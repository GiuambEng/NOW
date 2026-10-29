timnow
    .controller('newOrderStep2', ['$scope', '$state', '$rootScope', '$log', '$q', 'modalService', 'Offers', 'IDsrolo', 'VerificaNumeriNoteOperatore',
    	function ($scope, $state, $rootScope, $log, $q, modalService, Offers, IDsrolo, VerificaNumeriNoteOperatore) {
    	
    	$scope.isSelectedFwa = false; //SM_8079
    	$scope.isSelectedFwaAndMigrazione = false;
    	
    	$scope.isSelectedCps = false; //RU_915
    	$scope.isSelectedCpsAndMigrazione = false; //RU_915
    	
    	//SM_9998
    	$scope.idRisorsaAlfaNumericoRegExp = /^[a-zA-Z0-9 \/]*$/i;
    	$scope.idRisorsaNumericoRegExp = /^[0-9]*$/i;
    	
    	//RU_1203
    	$scope._offerteNonValideCessazione = [$rootScope.MAP_OFFERTE.FWA.id, 
    										  $rootScope.MAP_OFFERTE.CPS.id, 
    										  $rootScope.MAP_OFFERTE.VLANNGAMULTICAST.id,
    										  $rootScope.MAP_OFFERTE.FEEDER.id,
    										  $rootScope.MAP_OFFERTE.SEDEOLT.id,
    										  $rootScope.MAP_OFFERTE.CANALE.id,
    										  $rootScope.MAP_OFFERTE.NPNG.id];
    	
    	$scope._offerteNonValideVariazione = [$rootScope.MAP_OFFERTE.VLANNGAMULTICAST.id,
    		  								  $rootScope.MAP_OFFERTE.FEEDER.id,
    		  								  $rootScope.MAP_OFFERTE.SEDEOLT.id,
    		  								  $rootScope.MAP_OFFERTE.CANALE.id,
    		  								  $rootScope.MAP_OFFERTE.NPNG.id];
    	
    	$scope.errorMessageFwaAndCps = "Per la tipologia di contratto selezionata non è possibile procedere a una lavorazione di tipo Migrazione. Selezionare un contratto differente.";
    	
    	if($rootScope.formData && $rootScope.formData.offers && $rootScope.formData.offers.length > 0 && [$rootScope.MAP_OFFERTE.FWA.id].indexOf($rootScope.formData.offers[0].idOfferta) >= 0 && 
    		 (!!$scope.data.step2 && !!$scope.data.step2.contratto.nome)) { //SM_8079
    		$scope.isSelectedFwa = true;
    	}

    	
        if (!$rootScope.data.step2) {
            $rootScope.data.step2 = $scope.data.step2 = {};
        }

        if ($rootScope.formData.stepReached < 2) {
            $rootScope.formData.stepReached = 2;
            $scope.offertaCaricata = true;
        }
        else {
            $scope.offertaCaricata = false;
        }
        if($rootScope.data.step1 && ($rootScope.data.step1.causale_ordine === 'variazione')) {
        	$scope.loadStep2=false;
        	$scope.offertaCaricata=false;
    		$scope.max_idRisorsa = 16;
    	}else {
    		$scope.max_idRisorsa = 12;
    	}
        
        IDsrolo.get({list: 'all'}).$promise.then(
                function (response) {
                    $scope.loadOLO = false;
                    $rootScope.formData.elencoOloMigrazione = response.data;
                },
                function () {
                    $scope.loadOLO = false;
                    $scope.erroreService("Errore durante il caricamento degli OAO. Riprovare più tardi");
                }
            );

        $scope.getOffers = function () {
        	$scope.loadStep2=true;
            if (!$rootScope.bozza) {
                $rootScope.data.step3 = $rootScope.data.step4 = $rootScope.data.step4 = $rootScope.data.step5 = $rootScope.data.step6 = $rootScope.data.step7 = $rootScope.data.step8 = null;
                $scope.data.step3 = $scope.data.step4 = $scope.data.step4 = $scope.data.step5 = $scope.data.step6 = $scope.data.step7 = $scope.data.step8 = null;
            }
            if ($rootScope.data.step2.contratto) {
            	$rootScope.formData.offers = {};
            	
            	//RU_1180
            	var _request = {
                    contratto: $rootScope.data.step2.contratto.idContratto, 
                    azione: $rootScope.data.step1.causale_ordine
            	};
            	
            	if($rootScope.isFeederOrder){
            		_request.flagMulticast = 'Y';
            	}
            	
            	Offers.get(_request).$promise.then(function (response) {
                        $rootScope.formData.offers = filtraOfferteByRU(response.data);
                        $scope.offertaCaricata = false;
                        $scope.loadStep2=false;
                        
                        if($rootScope.formData.offers && $rootScope.formData.offers .length > 0) {                        	
                        	//RU_915
                        	if($rootScope.formData.offers[0].idOfferta == $rootScope.MAP_OFFERTE.CPS) {
                        		$scope.clearCpsInputs();
            	        	}
                        }
                        
                    }, function () {
                        $scope.erroreService("Impossibile caricare le offerte per il contratto selezionato. Riprovare più tardi");
                        $scope.offertaCaricata = true;
                        $scope.loadStep2=false;
                    });
            }
        };
        
        // utility per filtrare le offerte in base alle RU (utile per quando una RU introduce nuove offerte)
        filtraOfferteByRU = function(offers) {
			if($rootScope.OSCURAMENTI.RU_1581.oscurato) {
				offers = contracts.filter(p => $rootScope.OSCURAMENTI.RU_1581.idOfferteValide.indexOf(p.idOfferta) == -1);
			}
			return offers;
		}

//Valorizzazione ID Risorsa se viene da asset
        if($scope.data.step1 && $scope.data.step1.variazioneAsset){
        	if(!$scope.data.step2){
        		$scope.data.step2={};
        	}
        	$scope.data.step2.id_risorsa=$scope.data.step1.variazioneAsset.idRisorsa;
        }
//       MODALE CONTRATTO
        $scope.headerDatiOrdineContracts = [
             {"key": "nome", "value": "Nome", "type": "text"},
             {"key": "identificativoContrattoCRMW", "value": "Identificativo", "type": "text"},
             {"key": "dataInizio", "value": "Data inizio Validita", "type": "text"},
             {"key": "dataFine", "value": "Data fine validita", "type": "text"},
             {"key": "operatoreRete", "value": "Operatore di Rete", "type": "text"},
             {"key": "flagDiffidato", "value": "flagDiffidato", "type": "checkbox"}
        ];                                

        $scope.modalOptionsTabellaDatiOrdineContracts = {
            headerText: 'Seleziona un Contratto',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'datiOrdineCallbackContract',
            dataHeader: $scope.headerDatiOrdineContracts,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.contracts 
        };
        
        //RU_915
        $scope.isTipoLavorazioneCpsAdmitted = function(){
        	return (["attivazione", "cessazione"].indexOf($rootScope.data.step1.causale_ordine) >= 0);
        }

        $scope.datiOrdineCallbackContract = function (item) {
        	
        	if($rootScope.data.step1.causale_ordine === 'migrazione' && item.flagDiffidato){
        		 $scope.erroreService("Non è possibile selezionare contratti diffidati");
        	}else{
        		// AZZERO I PASSAGGI 3 e 4 in caso di bozza o di cambio contratto
                $scope.data.step3 ={};
                $scope.data.step4 ={}; 
                $scope.data.step7 ={};
                $rootScope.data.step3 = {};
                $rootScope.data.step4 ={}; 
                $rootScope.data.step7 = {};
                if ($rootScope.bozza) {
                    $rootScope.bozza.step4 ={}; 
                    $rootScope.bozza.step7 = {};
                    if ($rootScope.bozza) {
                        $rootScope.bozza.customizedOffer = {};
                    }
                }

                $rootScope.customizedOffer = {};
                $rootScope.formData.stepReached = 2;

                $rootScope.data.step2.contratto = item;
                $scope.data.step2.contratto = item;
                //$log.info($rootScope.data.step2.contratto.nome);
                $scope.getOffers();
        	}
        };

        $scope.datiOrdineGetContract = function ($event) {
            $event.preventDefault();

            if ($rootScope.formData.contracts.length <= 0) {
                $scope.erroreService("Non sono stati trovati contratti");
            }
            else {
                modalService.showModal({}, $scope.modalOptionsTabellaDatiOrdineContracts);
            }
        };

//		 MODALE PROGETTO
        $scope.datiOrdineGetProject = function ($event) {
            $event.preventDefault();
            if ($rootScope.formData.projects <= 0) {
                $scope.erroreService("Non sono stati trovati progetti");
            }
            else {
                modalService.showModal({}, $scope.modalOptionsTabellaDatiOrdineProjects);
            }
        };
        $scope.headerDatiOrdineProjects = [
                {"key": "cod_prgt", "value": "Codice progetto", "type": "text"},
                {"key": "codfc_olo_agcom", "value": "OLO", "type": "text"},
                {"key": "datainz_valid", "value": "Data inizio Validita", "type": "text"},
                {"key": "datafi_valid", "value": "Data fine validita", "type": "text"}
        ];
        
        $scope.datiOrdineCallbackProject = function (item) {
            $rootScope.data.step2.codice_progetto = item;
        };
        $scope.modalOptionsTabellaDatiOrdineProjects = {
            headerText: 'Seleziona un Progetto',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'datiOrdineCallbackProject',
            dataHeader: $scope.headerDatiOrdineProjects,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.projects
        };

//		CANCELLA CAMPI MODALI
        $scope.cancellaSelezioneProject = function () {
            $scope.data.step2.codice_progetto = null;
        };

        $scope.cancellaSelezioneContract = function () {
            $scope.data.step2.contratto = {};
            $scope.isSelectedFwa = false;
        };
        
        $scope.checkPermissionOffertaCessazione = function(idOfferta){
        	return !($scope._offerteNonValideCessazione.indexOf(idOfferta) > -1);
        }
        
        $scope.checkPermissionOffertaVariazione = function(idOfferta){
        	return !($scope._offerteNonValideVariazione.indexOf(idOfferta) > -1);
        }

// 		PASSAGGIO AL TERZO STEP
        $scope.submit_2 = function () {
        	
        	//R1F-20-0236.D
        	if($scope.data.step2.note_da_operatore && $scope.data.step2.note_da_operatore != '' && $scope.R1F_20_0236D){
        		$scope.verificaNoteOperatore()
        		.then(function(response){
        			if(response.VerificaNumeriNoteOutput){
            			if(response.VerificaNumeriNoteOutput.esito == 'OK'){
            				$scope._submit2();
            			}else{
            				$scope.erroreService(response.VerificaNumeriNoteOutput.message);
            			}  
        			}else{
        				$scope._submit2(); 
        			}
        		}, function(error){
        			$scope.erroreService("Impossibile verificare numeri note operatore");
        		});
        	}else{
        		$scope._submit2();        		
        	}
        };
               
        $scope._submit2 = function(){
        	if(!$scope.checkPermissionOffertaCessazione() || !$scope.checkPermissionOffertaVariazione()){
        		$scope.erroreService("Lavorazione non consentita per la tipologia di contratto selezionato.");
        		return;
        	}
        	
        	if(($rootScope.data.step2.codice_progetto && $rootScope.data.step2.codice_progetto.flagVull) && ($scope.data.step2.contratto.idSottofamigliaOfferta !== '11')){
        		$scope.erroreService("Il Codice Progetto inserito non è coerente con il Contratto selezionato");
        	} else {       	
        		$scope.controlloAsset();
        	}
        }
        
        
        $scope.svuotaOfferta = function () {
            //if(!$rootScope.bozza){
            if($rootScope.bozza){
                if($scope.bozza.data.step3)$scope.data.step3={};
                if($scope.bozza.data.step3 && $scope.bozza.data.step3.offertaLabel) delete $scope.bozza.data.step3.offertaLabel;
                if($scope.bozza.data.step3 && $scope.bozza.data.step3.opzioneVariazione) delete $scope.bozza.data.step3.opzioneVariazione;
                if($scope.bozza.data.step3 && $scope.bozza.data.step3.tipoMigrazione) delete $scope.bozza.data.step3.tipoMigrazione;
                if($scope.bozza.data.step4)delete $scope.bozza.data.step4;
                if($scope.bozza.data.step5)delete $scope.bozza.data.step5;
                if($scope.bozza.data.step6)delete $scope.bozza.data.step6;
                if($scope.bozza.data.step7)delete $scope.bozza.data.step7;
            };

            if($rootScope.data.step1 && (($rootScope.data.step1.causale_ordine === 'variazione') || ($rootScope.data.step1.causale_ordine === 'attivazione')) ) {
                if($scope.data.step2.idAssetScelto){delete $scope.data.step2.idAssetScelto;}

            }

            if($rootScope.formData)$rootScope.formData.stepReached=2;
            if($scope.data.step3 && $scope.data.step3.offertaLabel) delete $scope.data.step3.offertaLabel;
            if($scope.data.step3 && $scope.data.step3.opzioneVariazione) delete $scope.data.step3.opzioneVariazione;
            if($scope.data.step3 && $scope.data.step3.tipoMigrazione) delete $scope.data.step3.tipoMigrazione;
            if($scope.data.step4) delete $scope.data.step4;
            if($scope.data.step5) delete $scope.data.step5;
            if($scope.data.step6) delete $scope.data.step6;
            if($scope.data.step7) delete $scope.data.step7;
            //}

        };
        
        $scope.clearFwaInputs = function() {
        	
        	if($scope.RU_985){
        		$scope.data.step2.codice_progetto={};
        	}
        	
    		$scope.data.step2.codiceDelivery="";
    		$scope.data.step2.codiceQualita="";
    		$scope.isSelectedFwa = true;
        };
        
        //RU_915
        $scope.clearCpsInputs = function() {
        	$scope.data.step2.codice_progetto={};
    		$scope.data.step2.codiceDelivery="";
    		$scope.data.step2.codiceQualita="";
    		$scope.isSelectedCps = true;
        };
        
        $scope.$watch("formData.offers[0].idOfferta", function(newValue, oldValue) { //SM_8079
        	
        	//SM_8990
        	if(newValue){
            	if(newValue != oldValue){
    	        	if (newValue==$rootScope.MAP_OFFERTE.FWA.id){     	        		
    	        		$scope.isSelectedCps = false;
    	        	}
    	        	//RU_915
    	        	else if(newValue == $rootScope.MAP_OFFERTE.CPS.id){
    	        		$scope.clearCpsInputs();
    	        		$scope.isSelectedFwa = false;
    	        	}	        	
    	        	else {
    	        		$scope.isSelectedFwa = false;
    	        		$scope.isSelectedCps = false;
    	        	}
            	}else{
            		if(newValue == $rootScope.MAP_OFFERTE.FWA.id){
            			$scope.isSelectedFwa = true;
            			$scope.isSelectedCps = false;
            		}else if(newValue == $rootScope.MAP_OFFERTE.CPS.id){
            			$scope.isSelectedFwa = false;
            			$scope.isSelectedCps = true;
            		}
            	}
            	
        		//RU_985
        		$scope.oscuramento_RU_985();
        	}

        }, true);
        
        $scope.$watch("isSelectedFwa", function(newValue, oldValue) { //disabilitazione migrazione per contratto con offerta di tipo FWA
        	
        	//SM_9011
        	if (newValue){
        		if($rootScope.data.step1.causale_ordine === 'migrazione') {
        			$scope.isSelectedFwaAndMigrazione = true;
        			$scope.erroreService($scope.errorMessageFwaAndCps);
        		} else {
        			$scope.isSelectedFwaAndMigrazione = false;
        		}
        	} else {
        		$scope.isSelectedFwaAndMigrazione = false;
        	}
        }, true);
        
        //RU_915
        $scope.$watch("isSelectedCps", function(newValue, oldValue) { //disabilitazione migrazione per contratto con offerta di tipo CPS

        	//SM_9011
        	if (newValue){
        		if($rootScope.data.step1.causale_ordine === 'migrazione') {
        			$scope.isSelectedCpsAndMigrazione = true;
        			$scope.erroreService($scope.errorMessageFwaAndCps);
        		} else {
        			$scope.isSelectedCpsAndMigrazione = false;
        		}
        	} else {
        		$scope.isSelectedCpsAndMigrazione = false;
        	}
        }, true);
        
        // CONTROLLO BOZZA
        if ($rootScope.bozza) {
            $scope.lettura2 = true;
            $scope.data.step2 = $rootScope.data.step2 = $rootScope.bozza.data.step2;
            $scope.getOffers();
        }
        
        //RU_985
        $scope.oscuramento_RU_985 = function(){
    		
        	try{
        		if($scope.formData.offers[0] && $scope.formData.offers[0].idOfferta){            			
        			if(!$rootScope.OSCURAMENTI.RU_985.oscurato){
        				$scope.RU_985 = ($rootScope.OSCURAMENTI.RU_985.idOfferteValide.indexOf($scope.formData.offers[0].idOfferta) > -1);
        			}else{
        				$scope.RU_985 = false;
        			}           			
        		}
        	}catch(e){
        		$scope.RU_985 = false;
        	}          	
        }  
        
        $scope.oscuramento_RU_985();
        
        //RU_1058
        $scope.oscuramento_RU_1058 = function(){
    		
        	try{
        		if($scope.formData.offers[0] && $scope.formData.offers[0].idOfferta){            			
        			if(!$rootScope.OSCURAMENTI.RU_1058.oscurato){
        				$scope.RU_1058 = ($rootScope.OSCURAMENTI.RU_1058.idOfferteValide.indexOf($scope.formData.offers[0].idOfferta) > -1);
        			}else{
        				$scope.RU_1058 = false;
        			}           			
        		}
        	}catch(e){
        		$scope.RU_1058 = false;
        	}          	
        }
        
        //SM_9744
        $scope.checkVariazioneVLAN = function(){
        	
        	var _offerteVLAN = [$rootScope.MAP_OFFERTE.VLAN_GBE.name, 
        						$rootScope.MAP_OFFERTE.VLAN_NGA.name, 
        						$rootScope.MAP_OFFERTE.VLAN_VULA.name,
        						$rootScope.MAP_OFFERTE.VP.name];
        	
        	if($rootScope.data.step1.causale_ordine === 'variazione'){
        		if($scope.data.step1.variazioneAsset && 
            			$scope.data.step1.variazioneAsset.offerta &&
            			(_offerteVLAN.indexOf($scope.data.step1.variazioneAsset.offerta) > -1)){
            			//SM_10600
        			$scope.data.step2.codiceOrdineTIVlan = $scope.data.step1.variazioneAsset.codiceOrdineTi;
    				$scope.data.step2.codiceOrdineOloVlan = $scope.data.step1.variazioneAsset.codiceOrdineOlo;
            	}else if($scope.assetDetail && 
            			 $scope.assetDetail.nomeOffertaCatalogo &&
            			 (_offerteVLAN.indexOf($scope.assetDetail.nomeOffertaCatalogo) > -1)){
        			$scope.data.step2.codiceOrdineTIVlan = $scope.assetDetail.ordineTI;
    				$scope.data.step2.codiceOrdineOloVlan = $scope.assetDetail.ordineOao;        		
            	}else{
            		$scope.data.step2.codiceOrdineTIVlan = null;
    				$scope.data.step2.codiceOrdineOloVlan = null;
            	}
        	}else{
        		$scope.data.step2.codiceOrdineTIVlan = null;
				$scope.data.step2.codiceOrdineOloVlan = null;
        	}
        } 
        
        $scope.$watch("assetDetail", function(newValue, oldValue){
        	if(newValue){
        		$scope.checkVariazioneVLAN();
        	}
        }, true);
        
        $scope.oscuramento_RU_1058();
        $scope.checkVariazioneVLAN();
        
        //R1F-20-0236.D
        $scope.oscuramento_R1F_20_0236D = function(){    		
        	try{            			
        		$scope.R1F_20_0236D = !$rootScope.OSCURAMENTI.R1F_20_0236D.oscurato;
        	}catch(e){
        		$scope.RU_1058 = false;
        	}          	
        }
        
        $scope.oscuramento_R1F_20_0236D();
        
        $scope.verificaNoteOperatore = function(){
    		var _request = {
        			codOloAgcom: $scope.data.step1.operatore.codiceOLO,
        			note: $scope.data.step2.note_da_operatore
        		};
        		
        	return VerificaNumeriNoteOperatore.save(_request).$promise;
        }
        
        //SM_10514
        $scope.$watch('data.step2.codice_progetto', function(newValue, oldValue){
        	if(newValue && newValue.cod_prgt){
        		if($scope.data.step5 && $scope.data.step5.refOaoProgettiSpeciali){
        			$scope.data.step5.refOaoProgettiSpeciali = null;
        		}
        		if($scope.data.step7 && $scope.data.step7.refOaoProgettiSpeciali){
        			$scope.data.step7.refOaoProgettiSpeciali = null;
        		}
        	}
        });
        
    }]);

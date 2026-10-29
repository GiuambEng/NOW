timnow.controller('newOrderStep7', ['$scope', '$rootScope', '$log', 'modalService', 'IDULLCo', 'IDSLUCo', 'VerificaIDRisorsa', 'VerificaPresenzaIDRisorsa', '$timeout', '$q', 'RecuperaCodServizioSysUnico', 'Tokenizzazione', '_', 'RecuperaServiziOpzionaliAlternativi', 'NewOrderControlliService', 'Locator', 'RecuperaClusterAccesso', 
function ($scope, $rootScope, $log, modalService, IDULLCo, IDSLUCo, VerificaIDRisorsa, VerificaPresenzaIDRisorsa, $timeout, $q, RecuperaCodServizioSysUnico, Tokenizzazione, _, RecuperaServiziOpzionaliAlternativi, NewOrderControlliService, Locator, RecuperaClusterAccesso) {

	if (!$rootScope.data.step7) {
		$rootScope.data.step7 = $scope.data.step7 = {};
    }
	
	initShowServiziOpzionali = function(attivazione, _codiceProgetto, idOfferta){
		var prodottiACatalogoNO = _codiceProgetto && (_.isUndefined(_codiceProgetto.prodottiACatalogo) || _codiceProgetto.prodottiACatalogo == 'NO')
		if(!$scope.RU_1560) {
			return (prodottiACatalogoNO && attivazione.offerteServiziOpzionali.indexOf(idOfferta) > -1);
		} else {
			return (([$rootScope.MAP_OFFERTE.NGA_H.id, $rootScope.MAP_OFFERTE.VULA_H.id, $rootScope.MAP_OFFERTE.SEMI_VULA_H.id, $rootScope.MAP_OFFERTE.EASY_H.id].indexOf(idOfferta) > -1)
		        || (prodottiACatalogoNO && [$rootScope.MAP_OFFERTE.FULLGPONPLUS.id, $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id, $rootScope.MAP_OFFERTE.GPON_SEMI_PNRR.id, $rootScope.MAP_OFFERTE.GPON_FULL_PNRR.id].indexOf(idOfferta) > -1)); // RU_1581
		}
	};
	
    // RU_1560
    $scope.oscuramento_RU_1560 = function(){
    	try{
			$scope.RU_1560 = !$rootScope.OSCURAMENTI.RU_1560.oscurato;
			$scope.offertaValida_RU_1560 = $rootScope.OSCURAMENTI.RU_1560.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1;
    	}catch(e){
    		$scope.RU_1560 = false;
    	}          	
    }
    
   	$scope.oscuramento_RU_1560();  
   	
   	// RU_1598
    $scope.oscuramento_RU_1598 = function(){
    	try{
			$scope.RU_1598 = !$rootScope.OSCURAMENTI.RU_1598.oscurato;
    	}catch(e){
    		$scope.RU_1598 = false;
    	}          	
    }
    
   	$scope.oscuramento_RU_1598();  
   	
   		// RU_1598
    $scope.triggerCluster = function(){
    	//Se viene visualizzata la sezione Cluster, viene richiamato il servizio 
    	if($scope.showCluster){
        	RecuperaClusterAccesso.get().$promise.then(function(data){
        		if(data.result.message == 'KO'){
        			$scope.erroreService(data.result.message);
        			$scope.listCluster = [];
        		}
        		else{
        			if(!data.ClusterAccesso || data.ClusterAccesso.length == 0){
        				$scope.listCluster = [];
        			}
        			else{
        		    	$scope.erroreSystemUnico = null;
        				$scope.listCluster = data.ClusterAccesso;
        			}	    		
        		}
        	}, function(error){
        		// Error callback
                $scope.erroreService("Impossibile caricare lista valori cluster accesso");
    			$scope.listCluster = [];
        	});
    	}
    }
    
    calcolaShowCluster = function() {
		showCluster = false;
		causaleOrdine = $scope.data.step1.causale_ordine.toLowerCase();
		if(causaleOrdine == 'attivazione') {
			showCluster = $scope.RU_1598 && $rootScope.OSCURAMENTI.RU_1598.idOfferteValideAttivazione.indexOf($scope.data.step3.offerta.idOfferta) > -1;
		} else if(causaleOrdine == 'migrazione') {
			showCluster = $scope.RU_1598 && $rootScope.OSCURAMENTI.RU_1598.idOfferteValideMigrazione.indexOf($scope.data.step3.offerta.idOfferta) > -1;
		}
		return showCluster;
	}
   	
    
    //RU_1393
    //RU_1430
    //RU_1432
    $scope.isOffertaSemiGPON = ($scope.data.step3?.offerta?.idOfferta == $rootScope.MAP_OFFERTE.GPON_SEMI.id) || false;
    //SM_11217
    $scope.showOwnerPresaAppuntamentoTI = true;
    
	
    //SM_9425
	$scope.build_timeSlotPresaAppuntamento();
	
	//RU_915
	if($scope.data.step3 && $scope.data.step3.offerta){
		$scope.isCPS = ([$rootScope.MAP_OFFERTE.CPS.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0) ? true: false;
	}else{
		$scope.isCPS = false;
	}
	
	
	//SM_9035
	$rootScope.dateEmissione = null;
	$scope.regDate = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
	
	try{
    	if($scope.data.step6 && $scope.data.step6.datiClienteFinale && $scope.data.step6.datiClienteFinale.data_emissione){
    		$rootScope.dateEmissione = new Date($scope.data.step6.datiClienteFinale.data_emissione);
    	}else{
    		$rootScope.dateEmissione = null;
    	}
	}catch(e){
		$rootScope.dateEmissione = null;
	}
    
    $scope.convertDataEmissioneDate = function(){
        try{
        	if($scope.data.step6 && $scope.data.step6.datiClienteFinale && $scope.data.step6.datiClienteFinale){
        		$scope.data.step6.datiClienteFinale.data_emissione = new Date($rootScope.dateEmissione.getTime() - ($rootScope.dateEmissione.getTimezoneOffset() * 60000)).toISOString().split('T')[0];
        	}
        }catch(e){
        	$scope.data.step6.datiClienteFinale.data_emissione = null;
        }
    };
    
    //SM_9035
    $scope.onchangeDataEmissione = function(){
    	$timeout(function(){
        	if($rootScope.dateEmissione){ 		
        		$scope.convertDataEmissioneDate();
        	}
    	}, 90);
    };
	
	//RU_886
    //SM_9500
	$scope.initQualifica = function () {
		if(!$scope.data.step7){
			$scope.data.step7={};
			if(!$scope.data.step7.qualifica)
				$scope.data.step7.qualifica = 'Y';
		}
		else {
			if(!$scope.data.step7.qualifica)
				$scope.data.step7.qualifica = 'Y';
		}
    };
	$scope.initTest2 = function () {
		if(!$scope.data.step7 ){
			$scope.data.step7={};
			if(!$scope.data.step7.test2)
				$scope.data.step7.test2 = 'N';
		}
		else {
			if(!$scope.data.step7.test2)
				$scope.data.step7.test2 = 'N';
		}
    };
    if ($rootScope.formData.stepReached < 7){
    	$rootScope.formData.stepReached = 7;
    }
    if ($rootScope.bozza && $rootScope.bozza.data && $rootScope.bozza.data.step7 && (!$scope.data.step7 
    		|| typeof $scope.data.step7.dad === 'string' || typeof $scope.data.step7.dac === 'string' || typeof $scope.data.step7.dataDisponibilitaSede === 'string' || typeof $scope.data.step7.dataSottoscrizioneContratto === 'string')) {
        $scope.data.step7 = angular.copy($rootScope.bozza.data.step7);
        $scope.bozzaStep7 = true;
        var dateParts;
        var regDate = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
       
        //RU_915
        var regDate2 = /^\d{4}\-\d{1,2}\-\d{1,2}$/;

        
        if($scope.data.step7.dataSottoscrizioneContratto){
        	if((typeof $scope.data.step7.dataSottoscrizioneContratto === 'string') && $scope.data.step7.dataSottoscrizioneContratto.match(regDate)){
				dateParts = $scope.data.step7.dataSottoscrizioneContratto.split("/");
				$scope.data.step7.dataSottoscrizioneContratto=new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
        	}
        }
        if($scope.data.step7.dataDisponibilitaSede){
        	if((typeof $scope.data.step7.dataDisponibilitaSede === 'string') && $scope.data.step7.dataDisponibilitaSede.match(regDate)){
				dateParts = $scope.data.step7.dataDisponibilitaSede.split("/");
				$scope.data.step7.dataDisponibilitaSede=new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
        	}
        }
        if($scope.data.step7.dad){
        	if((typeof $scope.data.step7.dad === 'string') && $scope.data.step7.dad.match(regDate)){
        		dateParts = $scope.data.step7.dad.split("/");
        		$scope.data.step7.dad=new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
        	}
        }
        
        if($scope.data.step7.dac){
        	if((typeof $scope.data.step7.dac === 'string') && $scope.data.step7.dac.match(regDate)){
        		dateParts = $scope.data.step7.dac.split("/");
				$scope.data.step7.dac=new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
        	}
        }        
    }
    
    if ($scope.data.step7 && $scope.formData && $scope.formData.offerDetails && ([$rootScope.MAP_OFFERTE.ULL_LNA.id,
                                                                          		$rootScope.MAP_OFFERTE.ULL_LA.id,
                                                                        		$rootScope.MAP_OFFERTE.ULL_LANP.id,
                                                                        		$rootScope.MAP_OFFERTE.ULLD_LNA.id,
                                                                        		$rootScope.MAP_OFFERTE.ULLD_LA.id,
                                                                        		$rootScope.MAP_OFFERTE.ULLD_LANP.id].indexOf($rootScope.data.step3.offerta.idOfferta)>=0)) {
        $scope.data.step7.idsluco = {};
        if(!$scope.data.step7.dnAggiuntiveTemp)
        	{$scope.data.step7.dnAggiuntiveTemp=[];}
    }

    if ($scope.data.step7  && $scope.formData && $scope.formData.offerDetails && [$rootScope.MAP_OFFERTE.SLU_LNA.id,
                                                                          		$rootScope.MAP_OFFERTE.SLU_LA.id,
                                                                        		$rootScope.MAP_OFFERTE.SLU_LANP.id].indexOf($rootScope.data.step3.offerta.idOfferta)>=0) {
        delete $scope.data.step7.idullco;
        $scope.data.step7.searchIdullco = "";
        $scope.data.step7.dnAggiuntiveTemp=[];
    }

    if($rootScope.data && $rootScope.data.step1 &&  $rootScope.data.step1.causale_ordine==='migrazione'){
		$scope.datiView =[true,false];
		$scope.closeOthers=true;
	}

    $scope.calcolaTabVisualizzato = function () {
    	if(!$scope.dettaglioOrdineForm.$valid && $rootScope.data.step1.causale_ordine==='migrazione'){
    		$scope.datiView =[true,true];
    		$scope.closeOthers=false;
    		//RU_980
    		$scope.subFormView = [true, true, true, true, true];
    	}
    	//RU_980
    	else if($rootScope.OSCURAMENTI.RU_980.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1){
    		if($scope.dettaglioOrdineForm.$invalid){
    			$scope.subFormView = [true, true, true, true, true];
    		}    		
    	}
    };
    
    $scope.caricaDac = true;
    
    $scope.headerDettaglioOrdineIdullco = [
        {"key": "idullco", "value": "Id", "type": "text"},
        {"key": "clli", "value": "Clli", "type": "text"},
        {"key": "nomeCentrale", "value": "Centrale", "type": "text"},
        {"key": "codiceGat", "value": "Codice GAT", "type": "text"}
    ];

    $scope.headerDettaglioOrdineIdsluco = [
            {"key": "idsluco", "value": "Id", "type": "text"},
            {"key": "codificaOloAgcom", "value": "Codifica Olo", "type": "text"}
    ];
    $scope.cancellaSelezioneIdullco = function () {
        $scope.data.step7.idullco = {};
        $scope.data.step7.searchIdullco = "";
    };

    $scope.cancellaSelezioneIdsluco = function () {
        $scope.data.step7.idsluco = {};
    };
    $scope.deleteIdsluco = function(){
    	$scope.data.step7.idsluco = {};
    };
    $scope.dettaglioOrdineCallbackIdullco = function (item) {
        $scope.data.step7.idullco = item;
        $scope.data.step7.searchIdullco = item.idullco;
    };

    $scope.dettaglioOrdineCallbackIdsluco = function (item) {
        $scope.data.step7.idsluco = item;
    };


    $scope.dettaglioOrdineGetIdullco = function ($event) {
        $event.preventDefault();

        $scope.modalOptionsTabellaDettaglioOrdineIdullco = {
            headerText: 'Seleziona un IDULLCo',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'dettaglioOrdineCallbackIdullco',
            dataHeader: $scope.headerDettaglioOrdineIdullco,
			data : $rootScope.formData.idullcos
        };

        var idullcos = IDULLCo.get({
                codOLO: $scope.data.step1.operatore.codiceOLO,
                valoreRicerca: $scope.data.step7.searchIdullco
            }
        );

        $scope.p4 = idullcos.$promise.then(
            function (response) {
                $rootScope.formData.idullcos = response.data;
                $scope.modalOptionsTabellaDettaglioOrdineIdullco.data = $rootScope.formData.idullcos;
                modalService.showModal({}, $scope.modalOptionsTabellaDettaglioOrdineIdullco);
            }, function (error) {
                $log.info("Impossibile caricare i codici IDULLCo.");
                $log.debug(error);
            });
    };

    $scope.dettaglioOrdineGetIdsluco = function ($event) {
        $event.preventDefault();

        $scope.modalOptionsTabellaDettaglioOrdineIdsluco = {
            headerText: 'Seleziona un IDSLUCo',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'dettaglioOrdineCallbackIdsluco',
            dataHeader: $scope.headerDettaglioOrdineIdsluco,
			data : $rootScope.formData.idslucos
        };

        var idslucos = IDSLUCo.get({
                codOLO: $scope.data.step1.operatore.codiceOLO,
                valoreRicerca: $scope.data.step7.idsluco.idsluco
            });

        $scope.p3 = idslucos.$promise
            .then(
            function (response) {
                $rootScope.formData.idslucos = response.data;
                $scope.modalOptionsTabellaDettaglioOrdineIdsluco.data = $rootScope.formData.idslucos;
                modalService.showModal({}, $scope.modalOptionsTabellaDettaglioOrdineIdsluco);
            }, function (error) {
                $log.info("Impossibile caricare i codici IDSLUCO");
                $log.debug(error);
                $scope.data.step7.idsluco.idsluco="";

            });
    };

    // datepicker

    $scope.setDate = function (year, month, day) {
        $scope.dt = new Date(year, month, day);
    };

    $scope.formats = ['dd/MM/yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];

    function getDayClass(data) {
        var date = data.date, mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0,
                0, 0, 0);

            for (var i = 0; i < $scope.events.length; i++) {
                var currentDay = new Date(
                    $scope.events[i].date)
                    .setHours(0, 0, 0, 0);

                if (dayToCheck === currentDay) {
                    return $scope.events[i].status;
                }
            }
        }
        return '';
    }

    $scope.today = function () {
        $scope.dt = new Date();
    };

    $scope.clear = function () {
        $scope.dt = null;
    };

    $scope.inlineOptions = {
        customClass: getDayClass,
        minDate: new Date(),
        showWeeks: false
    };

    $scope.dateOptions = {
        dateDisabled: disabled,
        formatYear: 'yy',
        maxDate: new Date(2500, 5, 22),
        minDate: new Date(),
        startingDay: 1
    };
    
    //RU_915
    $scope.dateOptions2 = {
            dateDisabled: disabled,
            formatYear: 'yy',
            maxDate: new Date(new Date().setDate(new Date().getDate()-1)), //intervallo date (-infinito, ieri]
            minDate: new Date(1900, 1, 1),
            startingDay: 1
    };

    // Disable weekend selection
    function disabled(data) {
        var date = data.date, mode = data.mode;
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    }

    $scope.toggleMin = function () {
        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
    };

    $scope.toggleMin();

    $scope.openDP1 = function () {
        $scope.popup_dp1.opened = true;
    };

    $scope.openDP2 = function () {
        $scope.popup_dp2.opened = true;
    };
    $scope.openDP3 = function () {
    	$scope.popup_dp3.opened = true;
    };
    $scope.openDP4 = function () {
    	$scope.popup_dp4.opened = true;
    };
    
    //SM_9035
    $scope.openDataEmissione = function () {
    	$scope.popup_dataEmissione.opened = true;
    };
    
    //SM_9035
	$scope.popup_dataEmissione = {
			opened : false
		};

    $scope.popup_dp1 = {
        opened: false
    };

    $scope.popup_dp2 = {
        opened: false
    };
    $scope.popup_dp3 = {
    		opened: false
    };
    $scope.popup_dp4 = {
    		opened: false
    };

    $scope.utentiVlan = [{
        id: '1'
    }];
    
    if($scope.data.step7 && $scope.data.step7.dac && !$rootScope.dacValidato){
        if ($rootScope.data.step1.causale_ordine === 'migrazione') {
            $scope.verificaDacLavorativo($scope.data.step7.dac);
        } else {
            $scope.validationDac($scope.data.step7.dac);
        }
    }
    
    function testIDRisorsa(){
    	VerificaPresenzaIDRisorsa.verifica({
    		idRisorsa: $scope.data.step7.idRisorsaBTSNaked
        }).$promise.then(
        function (response) {
        	if(response.esito === 'OK'){
        		return testIDRisorsaNaked();
        	} else {
        		$scope.erroreService("L’IDRisorsa inserita non può essere utilizzata per l’operazione richiesta");
        	}
        	//$log.debug(response);
            
        }, function (error) {
            $log.info("Impossibile Verificare ");
            $log.debug(error);
            $scope.erroreService("L’IDRisorsa inserita non può essere utilizzata per l’operazione richiesta");
            return false;
			});
    }
    
    function testIDRisorsaNaked(){
    	VerificaIDRisorsa.verifica({type:"naked"},{
    		idRisorsaNaked: $scope.data.step7.idRisorsaBTSNaked,
    		tipoLineaWLR: $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft
        }).$promise.then(
        function (response) {
        	//$log.debug(response);
        	VaiAlPassaggioOtto();
        }, function (error) {
            $log.info("Impossibile Verificare ");
            $log.debug(error);
            $scope.erroreService("L’IDRisorsa Naked, inserita non può essere utilizzata per l’operazione richiesta");
            return false;
			});
    }
    
    function VaiAlPassaggioOtto(){
    	
    	//SM_10373
    	if($rootScope.customizedOffer && $rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.TIPOLINEA && $rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft){
			var tipolinea = $rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft;
			var numerolinea = $scope.data.step7.numeroLinea;
		}
    	var locatorQuery={
				"codiceOlo" : $rootScope.data.step1.operatore.codiceOLO || $rootScope.data.step1.operatore,
				"servizio" : $rootScope.data.step3.offerta.nomeOfferta,
				"lavorazione" : $rootScope.data.step1.causale_ordine,
				"tipoLinea" : tipolinea,
                "numeroLinea" : numerolinea 
			};
    	if($rootScope.data.step4 && $rootScope.data.step4.dn){
    		$scope.dnAttivo = $rootScope.data.step4.dn;
    	}else if($scope.data.step7 && $scope.data.step7.dn){
    		$scope.dnAttivo = $scope.data.step7.dn;
    	} else {
    		$scope.dnAttivo = null;
    	}
    	if($rootScope.data.step1.causale_ordine === 'attivazione'){
    		var codiceComune= ($scope.data.step6 && $scope.data.step6.indirizzoDatiClienteFinale && $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune )?$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune:null;
    		if(codiceComune){
    			locatorQuery.codiceComune = codiceComune;
    		}
    		
    		//SM_8415
    		var provincia= ($scope.data.step6 && $scope.data.step6.indirizzoDatiClienteFinale && $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia )?$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia : null;
    		if(provincia){
    			locatorQuery.provincia = provincia;
    		}
    		
			//RU_915
			if($scope.data.step3.offerta.idOfferta == $rootScope.MAP_OFFERTE.CPS.id){
				locatorQuery.dn = $rootScope.customizedOffer.offerTopDetails.DN.dft || undefined;
			}else{
				locatorQuery.dn = $scope.dnAttivo;
			}    		
    		
    	} else {
    		//SM_8415
    		if($scope.data && $scope.data.step3 && $scope.data.step3.opzioneVariazione==="Trasloco"){
    			locatorQuery.provincia = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia;
    			locatorQuery.codiceComune = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune;
    		}
    		else {
	    		if($rootScope.formData.assetDetail && $rootScope.formData.assetDetail.comune){
	    			locatorQuery.codiceComune = $rootScope.formData.assetDetail.comune;
	    		}
	    		
	    		//SM_8415
	    		if($rootScope.formData.assetDetail && $rootScope.formData.assetDetail.provincia){
	    			locatorQuery.provincia = $rootScope.formData.assetDetail.provincia;
	    		}
	    		
    		}

    		locatorQuery.idRisorsa=$rootScope.data.step2.id_risorsa;

    		if(!$rootScope.data.step2.id_risorsa || ($scope.dnAttivo && $rootScope.data.step1.causale_ordine === 'migrazione')){
    			locatorQuery.dn = $scope.dnAttivo;
    		}
    		if($rootScope.data.step4){
    			locatorQuery.DNAggiuntivi=$rootScope.data.step4.dnAggiuntive;
    		}
			locatorQuery.idRisorsa2=$rootScope.data.step2.id_risorsa2;
			
			//SM_8153
			if($rootScope.data.step1.causale_ordine === 'variazione' && $rootScope.data.step3.opzioneVariazione === 'Cambio Tipologia Accesso') {
				if(!!$rootScope.data.step4.tipologiaAccesso) {
					locatorQuery.tipologiaAccesso = $rootScope.data.step4.tipologiaAccesso; 
				}
			}
    	}
    	
        //SM_9677    	
    	//R1F-20-0236
    	if($scope.data.step5 && $scope.data.step5.datiReferenti){
    		if($scope.R1F_20_0236){
    			$scope.loadStep8=true;
    			$q.all([$scope.tokenizzazioneReferenti(), $scope.tokenizzazioneClienteFinale()])
    			.then(function(responses){
    				if(responses[0].referentiTokenizzati.esito=='OK' && responses[0].referentiTokenizzati.numeriReferenti){        			        			
    					$rootScope.data.numeriReferentiTokenizzati = responses[0].referentiTokenizzati.numeriReferenti; 
    					$scope.setFlagToken('Y');
    				}else{
    					$scope.setFlagToken('N');        			
    				}
    				//Task #36242
    				if(responses[1].referentiTokenizzati.esito == 'OK' && responses[1].referentiTokenizzati.numeriReferenti){        			        			
    					$rootScope.data.clienteFinaleTokenizzato = responses[1].referentiTokenizzati.numeriReferenti[0];
    				}    				
    				$scope.loadStep8=false;
    				$scope.VerificaAmbito(locatorQuery);
    			}, function(error){
    				//SM_10454
    				$rootScope.data.numeriReferentiTokenizzati = error.config.data.numeriReferenti;
    				$scope.setFlagToken('N');
    				$scope.loadStep8=false;
    				$scope.VerificaAmbito(locatorQuery);
    			});
    		}else if($scope.RU_1084){
    			$scope.loadStep8=true;
    			$scope.tokenizzazioneReferenti()        	 
    			.then(function(response){
    				//Bug 32193 -> Fix su corretta verifica del campo 'esito'
    				if(response.referentiTokenizzati.esito=='OK'){        			
    					$rootScope.data.numeriReferentiTokenizzati = response.referentiTokenizzati.numeriReferenti; 
    					$scope.setFlagToken('Y');
    				}else{
    					$scope.setFlagToken('N');        			
    				}
    				$scope.loadStep8=false;
    				$scope.VerificaAmbito(locatorQuery);
    			}, function(error){
    				$rootScope.data.numeriReferentiTokenizzati = error.referentiTokenizzati.numeriReferenti;
    				$scope.setFlagToken('N');
    				$scope.loadStep8=false;
    				$scope.VerificaAmbito(locatorQuery);
    			});
    		}else{
    			$scope.VerificaAmbito(locatorQuery);
    		}
    	}else{
			//Task #36243
    		$scope.VerificaAmbito(locatorQuery);
    	}
    	
	}
	
	function goToStep8() {
		if([$rootScope.MAP_OFFERTE.WLR_LNA.id].indexOf($rootScope.data.step3.offerta.idOfferta)>=0 && $scope.data.step7.idRisorsaBTSNaked){ 
		    testIDRisorsa();
    	}else if($rootScope.getMap_Offerta($rootScope.data.step3.offerta.idOfferta).regolatorio && $scope.data.step7.visibilitaNP && [$rootScope.MAP_OFFERTE.VULL_LNA.id, $rootScope.MAP_OFFERTE.WLR_LA.id, $rootScope.MAP_OFFERTE.VULL_LA.id].indexOf($rootScope.data.step3.offerta.idOfferta)<0){
    		$scope.checkDnAggiuntivi=false;
    		if($scope.data.step7.visibilitaAggiuntivi){
    			$scope.checkDnAggiuntivi=true;
    			$scope.data.step7.dnAggiuntive=[];
    			angular.forEach($scope.data.step7.dnAggiuntiveTemp, function(value) {
    				if(value && value.length>0 && $scope.checkDnAggiuntivi){
	    				$scope.checkDnAggiuntivi=false;
	    			}
    				$scope.data.step7.dnAggiuntive.push(value);
    			});
    		} 
    		
    		if(!$scope.checkDnAggiuntivi){
    			VaiAlPassaggioOtto(); 
    		}else{
    			$scope.erroreService("Valorizzare almeno un DN Aggiuntivo o deselezionare il Flag Aggiuntivi");
    		}
    	}else{
    		if($scope.data.step7 && $scope.data.step7.dnAggiuntiveTemp){
    			$scope.data.step7.dnAggiuntive=[];
    			angular.forEach($scope.data.step7.dnAggiuntiveTemp, function(value) {
    				$scope.data.step7.dnAggiuntive.push(value);
    			});
    		}
    		
    		if($scope.data.step7 && (($scope.data.step7.dac && $rootScope.dacValidato) || !$scope.data.step7.dac)){
    			VaiAlPassaggioOtto();
    		}
    	}
	}
	
	$scope.svuotaNP = function () {
		$scope.data.step7.routingNumber="";
		$scope.data.step7.visibilitaAggiuntivi=false;
	};
	
	$scope.svuotaAggiuntivi = function () {
		$scope.data.step7.dnAggiuntiveTemp=[];
		$scope.data.step7.dnAggiuntive=[];
		if($scope.data.step7.dn){
			$scope.data.step7.dn=null;
		}
		if($scope.data.step7.routingNumber){
			$scope.data.step7.routingNumber=null;
		}
	};
	
	$scope.svuotaFob = function () {
		$scope.data.step7.codiceIdentificativoLotto="";
		$scope.data.step7.indicatoreFob="";
	};
	
    $scope.submit_7 = function () {
    	
    	$rootScope.formData.data.step7 = $rootScope.data.step7 = $scope.data.step7;
    	
    	//RU_915    	
    	if($scope.isCPS){
    		if($scope.data.step6 && $scope.data.step6.datiClienteFinale){  			    			
    			angular.extend($rootScope.formData.step6.datiClienteFinale, $scope.data.step6.datiClienteFinale);
    		}
    	}
		
		if(($rootScope.data.step3.opzioneVariazione === 'Incremento/decremento VC' && [$rootScope.MAP_OFFERTE.ATM_SF.name, $rootScope.MAP_OFFERTE.ATM_SH.name ].indexOf($rootScope.data.step3.offerta.nomeOffertaCatalogo) >= 0)){
			if($scope.data.step7.datiReferenti && $scope.data.step7.datiReferenti[1] && ($scope.data.step7.datiReferenti[1].nome === "")){
				delete $scope.data.step7.datiReferenti[1];
			}
			if($scope.data.step7.datiReferenti && $scope.data.step7.datiReferenti[2] && ($scope.data.step7.datiReferenti[2].nome === "")){
				delete $scope.data.step7.datiReferenti[2];
			}
			if($scope.data.step7.datiReferenti && $scope.data.step7.datiReferenti[3] && ($scope.data.step7.datiReferenti[3].nome === "")){
				delete $scope.data.step7.datiReferenti[3];
			}
		}

		if(($scope.data.step7===null) || ($scope.data.step7===undefined)){
			$scope.data.step7={};
		}

		if($scope.data.step7 &&  $scope.data.step7.searchIdsullco && !$scope.data.step7.idsluco) {
			$scope.data.step7.idsluco = {};
			$scope.data.step7.idsluco.idsluco = $scope.data.step7.searchIdsullco;
		}
    	
    	//RU_980
    	//R1I_20_0131
    	if($scope.RU_980 || $scope.R1I_20_0131){
    		$scope.subFormView = [false, false, false, false, false];
    		$scope.deleteServizioOpzionaleEmpty();
    		
	    	//RU_1485
			var _checkDuplicatiServiziOpzionali = $scope.checkDuplicateServiziOpzionali();	
			var _checkDuplicatiServiziOpzionaliAlternativi = $scope.checkDuplicateServiziOpzionaliAlternativi();
			var _checkDuplicatiPadreServiziOpzionaliAlternativi = $scope.checkDuplicatePadreServiziOpzionaliAlternativi();
			if(_checkDuplicatiServiziOpzionali && _checkDuplicatiServiziOpzionali.flag){
		    	$scope.erroreService("Attenzione: hai inserito piu' volte il servizio opzionale con codice servizio " + _checkDuplicatiServiziOpzionali.codice); 
		    	return;
			}
			if(_checkDuplicatiServiziOpzionaliAlternativi && _checkDuplicatiServiziOpzionaliAlternativi.flag){
		    	$scope.erroreService("Attenzione: hai inserito piu' volte il servizio opzionale alternativo " + _checkDuplicatiServiziOpzionaliAlternativi.codice); 
		    	return;
			}
			if(_checkDuplicatiPadreServiziOpzionaliAlternativi && _checkDuplicatiPadreServiziOpzionaliAlternativi.flag){
		    	$scope.erroreService("Attenzione: e' possibile inserire un solo servizio opzionale alternativo in sostituzione del servizio Opzionale di Default " + _checkDuplicatiPadreServiziOpzionaliAlternativi.codice); 
		    	return;
			}
			//RU_1543
			if($scope.RU_1543){
				var _checkCodiceServizioTLC8 = $scope.C11M08F109();
				if(_checkCodiceServizioTLC8 && _checkCodiceServizioTLC8.flag){
					$scope.erroreService(_checkCodiceServizioTLC8.message);
					return;
				}
			}
    	}
    	
		var _gotoNextStep = true;
    	// RU_1560
    	if($scope.RU_1560) {
			var _promises = [];
			if($scope.data.step1.causale_ordine.toLowerCase() == 'attivazione') {
				
				_promises.push($scope.C11M08F16());
				
				if($scope.data.step7.datiServiziOpzionali && $scope.data.step7.datiServiziOpzionali.filter(x => x.codiceServizio === 'TLC8').length > 0
					&& $rootScope.OSCURAMENTI.RU_1560.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1) {
						
					var _idRisorsa = $rootScope.data.step2.id_risorsa ? $rootScope.data.step2.id_risorsa : "";
					var _slaAssurance = $rootScope.customizedOffer.offerTopDetails.SLAASSURANCE.dft;
					_promises.push(NewOrderControlliService.C11M08F112(_idRisorsa, _slaAssurance));
					
					// check C11M08F111
					if($scope.data.step2.codice_progetto) {
						var _codiceProgetto = $scope.data.step2.codice_progetto.cod_prgt;
						_promises.push(NewOrderControlliService.C11M08F111('TLC8', _codiceProgetto));
					}
				}
				$q.all(_promises)
        			.then(function(responses){
        				if(responses && responses.length > 0){
							var _messages = [];
							// C11M08F16
							if(responses[0].result.message == 'KO'){
				    			_messages.push("Verifica ambito KO");
				    			_gotoNextStep = false;
			    			}
							// C11M08F112
			    			if(responses.length > 1 && responses[1].esito == 'KO'){
								_gotoNextStep = false;
								_messages.push("Per accessi con ONT Operatore, è disponibile solo lo SLA base di assurance");
							}
							// C11M08F111
							if(responses.length > 2 && responses[2].esito == 'KO'){
				    			_gotoNextStep = false;
								_messages.push("Installazione ONT Operatore certificata da FiberCop non prevista con servizio ONE STEP");
				    		}
							if(!_gotoNextStep){
    							_messages.forEach(function(message){
    	            				modalService.showModal({}, {
    	            	                headerText: "Avviso",
    	            	                bodyText: message,
    	            	                actionButtonText: 'Chiudi',
    	            	                type: 'warning'
    	            	            });
    							});
    							return;
    						} else {
								goToStep8();
							}
						}
					}, function(error){
						_gotoNextStep = false;
        				modalService.showModal({}, {
        	                headerText: "Avviso",
        	                bodyText: "Impossibile effettuare le verifiche",
        	                actionButtonText: 'Chiudi',
        	                type: 'warning'
        	            });
        	            return;
        			});
			} else {
				goToStep8();
			}
		} else {
			goToStep8();
		}
    	
    };
    
    /* sezione referenti aggiunta START */
    
    $scope.telefonoFissoMaxLength=15;
    
    $scope.verificaInserimentoReferentiCorrettamente= function (item){
    		return (item &&(item.nome || item.telefonoFisso || item.cellulare || item.qualifica || item.cognome || item.email)) ;
    };
    
    $scope.validaDatiRiferimento = function (form) {

        if (form.ref1_tel_fisso.$invalid
            || form.ref1_qualifica.$invalid
            || form.ref1_cognome.$invalid
            || form.ref1_tel_cellulare.$invalid) {
            $scope.referentView = [true, false, false, false];
        } else {
            if (form.ref2_tel_fisso.$invalid
                || form.ref2_qualifica.$invalid
                || form.ref2_cognome.$invalid
                || form.ref2_tel_cellulare.$invalid) {
                $scope.referentView = [false, true, false, false];
            } else {
                if (form.ref3_tel_fisso.$invalid
                    || form.ref3_qualifica.$invalid
                    || form.ref3_cognome.$invalid
                    || form.ref3_tel_cellulare.$invalid) {
                    $scope.referentView = [false, false, true, false];
                } else {
                    if ($rootScope.data.step1.causale_ordine === 'variazione') {
                        if (form.ref4_tel_fisso &&( form.ref4_tel_fisso.$invalid
                                || form.ref4_cognome.$invalid
                                || form.ref4_tel_cellulare.$invalid )) {
                            $scope.referentView = [false, false, false, true];
                        }
                    }
                }
            }
        }
        
        angular.forEach(form.$error.required,
            function (field) {
                field.$setDirty();
            }
        );
    };
    
    
	//RU_915
	$scope.isATM_SF_ATM_SH = false;
	$scope.isIncrementoDecrementoVC = false;

    $scope.verifyATM_SFOrATM_SH = function(){
    	if($scope.data.step3 && $scope.data.step3.offerta && $scope.data.step3.offerta.nomeOffertaCatalogo){
        	if([$rootScope.MAP_OFFERTE.ATM_SF.name, $rootScope.MAP_OFFERTE.ATM_SH.name ].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0){
        		$scope.isATM_SF_ATM_SH = true;
        	}
    	}else{
    		$scope.isATM_SF_ATM_SH = false;
    	}
    }

    $scope.verifyTypeOfOpzioneVariazione = function(){
    	if($scope.data.step3 && $scope.data.step3.opzioneVariazione){
        	if($scope.data.step3.opzioneVariazione === 'Incremento/decremento VC'){
        		$scope.isIncrementoDecrementoVC = true;
        	}    
    	}else{
    		$scope.isIncrementoDecrementoVC = false;
    	}	
    }
    
    $scope.initShowNextButtonConditions = function(){
    	$scope.verifyATM_SFOrATM_SH();
    	$scope.verifyTypeOfOpzioneVariazione();
    }
    
    $scope.initShowNextButtonConditions();
    
    /* sezione referenti aggiunta END */
    
    //R1C-19-1212
    $scope.oscuramento_R1C_19_1212 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.R1C_19_1212.oscurato){
    				$scope.R1C_19_1212 = ($rootScope.OSCURAMENTI.R1C_19_1212.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.R1C_19_1212 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.R1C_19_1212 = false;
    	}          	
    }
    
    $scope.oscuramento_R1C_19_1212();
    
    
    //RU_980
        
    //Variabili per visualizzazione delle diverse sezioni
    $scope.showServiziOpzionali = false;
    $scope.showDisaggregazione = false;
    $scope.showPresaAppuntamento = false;
    $scope.showPrestazioniAggiuntive = false;
    $scope.showSlaPlusSu = false;
    $scope.showSezionePerLNA = true
	//RU_1485
    $scope.showServiziOpzionaliAlternativi = false;
    
    // RU_1598
    $scope.showCluster = calcolaShowCluster();
    if($scope.showCluster) {
		$scope.triggerCluster();
	}
    
    //Array per stati apertura dei collapsible (false = chiuso)
    $scope.subFormView = [false, false, false, false, false, false, false];
    
    $scope.maxLengthServiziOpzionali = 10;
    //RU_1485
    $scope.maxLengthServiziOpzionaliAlternativi = 10;
    
    if(!$scope.data.step7){
    	$scope.data.step7 = {};
    }
    
    //SM_9216
    if(!$scope.data.step7.datiDisaggregazione ){
    	$scope.data.step7.datiDisaggregazione = {};
    }
       
    //Inizializza le variabili per mostrare/nascondere le sezioni in base al tipo di offerta
    $scope.checkShowSezioni_RU_980 = function(){
    	if(!$rootScope.OSCURAMENTI.RU_980.oscurato){
    		var idOfferta = $scope.data.step3.offerta.idOfferta;
        	
        	var attivazione = $rootScope.OSCURAMENTI.RU_980.visualizzaSezioni.attivazione;
        	var migrazione = $rootScope.OSCURAMENTI.RU_980.visualizzaSezioni.migrazione;
        	
        	if($scope.data.step1.causale_ordine.toLowerCase() == 'attivazione'){
        		//RU_1485
    			var _codiceProgetto = $scope.data.step2.codice_progetto;
    			$scope.showServiziOpzionaliAlternativi = (_codiceProgetto && _codiceProgetto.prodottiACatalogo == 'SI' && _codiceProgetto.oneStep && attivazione.offerteServiziOpzionaliAlternativi.indexOf(idOfferta) > -1);
    			
				// RU_1560
				$scope.showServiziOpzionali = initShowServiziOpzionali(attivazione, _codiceProgetto, idOfferta);
													
        		$scope.showDisaggregazione = (attivazione.offerteDisaggregazione.indexOf(idOfferta) > -1);
        		$scope.showPresaAppuntamento = (attivazione.offertePresaAppuntamento.indexOf(idOfferta) > -1);
        		$scope.showPrestazioniAggiuntive = (attivazione.offertePrestazioniAggiuntive.indexOf(idOfferta) > -1);
        		$scope.showSlaPlusSu = (attivazione.offerteSlaPlusSu.indexOf(idOfferta) > -1);
        		
        		//In caso di Offerte Linea Attiva ULL/ULL Dati/SLU mostrare la sezione  Disaggregazione
        		var idOfferteLA =[$rootScope.MAP_OFFERTE.ULL_LA.id, $rootScope.MAP_OFFERTE.ULLD_LA.id, $rootScope.MAP_OFFERTE.SLU_LA.id];
        		if(idOfferteLA.indexOf(idOfferta) > -1){
        			$scope.showDisaggregazione = true;    			
        			//Mostrare solo System unico nella sezione Disaggregazione
        			$scope.showSezionePerLNA = (idOfferteLA.indexOf(idOfferta) == -1);
        		}
        	    
        	    //In caso di offerta BTS/VULA FTTCab, visualizzare la sezione Servizi Opzionali solo in caso di Linea Non Fonia    	    
        	    if(['15','17'].indexOf(idOfferta) > -1){
        	    	if(!$scope.RU_1560 && $scope.customizedOffer &&
        	       		 $scope.customizedOffer.offerTopDetails &&
        	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA && 
        	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'LineaNonFonia'){
        	    		$scope.showServiziOpzionali = true;
        	    	}else{
        	    		$scope.showServiziOpzionali = false;
        	    		//SM_9502
        	    		$scope.showPresaAppuntamento = false;
        	    		$scope.showPrestazioniAggiuntive = false;
        	    		$scope.showSlaPlusSu = false;
        	    	}
        	    	
        	    }
        		
        	}else if($scope.data.step1.causale_ordine.toLowerCase() == 'migrazione'){
        		$scope.showServiziOpzionali = (migrazione.offerteServiziOpzionali.indexOf(idOfferta) > -1);
        		$scope.showDisaggregazione = (migrazione.offerteDisaggregazione.indexOf(idOfferta) > -1);
        		
        		//RU_1033
        		$scope.showSezionePerLNA = false;
        		
        		//Disaggregazione visibile solo per VULA FTTCAB LineaNonFonia
        		if(['17'].indexOf(idOfferta) > -1){
        	    	if($scope.customizedOffer &&
           	       		 $scope.customizedOffer.offerTopDetails &&
           	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA && 
           	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'LineaNonFonia'){
           	    		$scope.showDisaggregazione = true;
           	    	}else{
           	    		$scope.showDisaggregazione = false;
           	    	}
        		}
        	}
    	}    	
    }
    
    /***** INIZIO CONFIGURAZIONE SERVIZI OPZIONALI *****/
    
    //Inizializzazione dati aggregato Servizi Opzionali
    if(!$scope.data.step7.datiServiziOpzionali || $scope.data.step7.datiServiziOpzionali.length == 0){
    	$scope.data.step7.datiServiziOpzionali = [{
    		id: 1,
    		codiceServizio: null,
    		descrizioneServizio: null,
    		datiTecnici: null,
    		vincolantePerEspletamento: null
    	}];
    }
    
    $scope.deleteServizioOpzionale = function(index){
    	if($scope.data.step7.datiServiziOpzionali && $scope.data.step7.datiServiziOpzionali.length > 1){
    		$scope.data.step7.datiServiziOpzionali.splice(index, 1);
    	}
    	
    	//Riallineamento id servizi
    	if($scope.data.step7.datiServiziOpzionali.length == 1){
    		$scope.data.step7.datiServiziOpzionali.id = 1;
    	}else{
    		$scope.data.step7.datiServiziOpzionali.forEach(function(item, index){
    			item.id = index + 1;
    		});
    	}
    }
    
    $scope.addServizioOpzionale = function(event){
		event.preventDefault();
    	if($scope.data.step7.datiServiziOpzionali && $scope.data.step7.datiServiziOpzionali.length < $scope.maxLengthServiziOpzionali){
    		$scope.data.step7.datiServiziOpzionali.push({
        		id: $scope.data.step7.datiServiziOpzionali.length + 1,
        		codiceServizio: null,
        		descrizioneServizio: null,
        		datiTecnici: null,
        		vincolantePerEspletamento: null
        	});
    	}
    }
    
    //La sezione Servizi Opzionali, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isServiziOpzionaliRequired = function(form){
    	$timeout(function(){
        	if(form){
        		if((form.descrizioneServizio.$modelValue && form.descrizioneServizio.$modelValue !== "") 
        				|| (form.datiTecnici.$modelValue && form.datiTecnici.$modelValue !== "")
        				|| (form.vincolantePerEspletamento.$modelValue && form.vincolantePerEspletamento.$modelValue !== "")){
        			$scope.isServiziOpzionaliRequiredFlag = true;
        		}else{
        			$scope.isServiziOpzionaliRequiredFlag = false;
        		}
        	} else{
    			$scope.isServiziOpzionaliRequiredFlag = false;
    		}
    	}, 100);
    }
    
    //Per evitare di creare aggregati vuoti, elimino tutti i servizi opzonali vuoti
    $scope.deleteServizioOpzionaleEmpty = function(){
    	
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionali);
    	
    	if(appArray && appArray.length > 0){
    		for(var i=0; i<appArray.length; i++){
    			if(!appArray[i]['codiceServizio'] || appArray[i]['codiceServizio'] == ""){
    				$scope.data.step7.datiServiziOpzionali.splice(i, 1);
    			}
    		}
    	}
    }
    
    //RU_1128
	//Ricerca codici servizi duplicati e nel caso, inibisce il passaggio allo step successivo
	$scope.checkDuplicateServiziOpzionali = function(){
		$scope.erroreCodiceServizio = "";		
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionali);    	
    	var _result = {
    		flag: false,
    		codice: ""	
    	};
    	
    	var _arrayDuplicati = [];
    	
    	if(appArray && appArray.length > 0){
	
			//Cerca i duplicati nella lista di object	
    		_arrayDuplicati = _.chain(appArray).groupBy('codiceServizio').filter(function(v){return v.length > 1}).flatten().uniq().value();
    		if(_arrayDuplicati && _arrayDuplicati.length > 0){
				_result.flag = true;
    			_result.codice = _arrayDuplicati[0].codiceServizio;
			}
    	}
    	return _result;
	}
    
    /***** FINE CONFIGURAZIONE SERVIZI OPZIONALI *****/
    
    //RU_1485
    /***** INIZIO CONFIGURAZIONE SERVIZI OPZIONALI ALTERNATIVI *****/
    //Inizializzazione dati aggregato Servizi Opzionali Alternativi
    if(!$scope.data.step7.datiServiziOpzionaliAlternativi || $scope.data.step7.datiServiziOpzionaliAlternativi.length == 0){
    	$scope.data.step7.datiServiziOpzionaliAlternativi = [{
    		id: 1,
    		codiceServizio: null,
    		codiceServizioPadre: null,
    		descrizioneServizio: null
    	}];
    }
    
    $scope.deleteServizioOpzionaleAlternativo = function(index){
    	if($scope.data.step7.datiServiziOpzionaliAlternativi && $scope.data.step7.datiServiziOpzionaliAlternativi.length > 1){
    		$scope.data.step7.datiServiziOpzionaliAlternativi.splice(index, 1);
    	}
    	
    	//Riallineamento id servizi
    	if($scope.data.step7.datiServiziOpzionaliAlternativi.length == 1){
    		$scope.data.step7.datiServiziOpzionaliAlternativi.id = 1;
    	}else{
    		$scope.data.step7.datiServiziOpzionaliAlternativi.forEach(function(item, index){
    			item.id = index + 1;
    		});
    	}
    }
    
    $scope.addServizioOpzionaleAlternativo = function(event){
		event.preventDefault();
    	if($scope.data.step7.datiServiziOpzionaliAlternativi && $scope.data.step7.datiServiziOpzionaliAlternativi.length < $scope.maxLengthServiziOpzionaliAlternativi){
    		$scope.data.step7.datiServiziOpzionaliAlternativi.push({
        		id: $scope.data.step7.datiServiziOpzionaliAlternativi.length + 1,
        		codiceServizio: null,
        		descrizioneServizio: null
        	});
    	}
    }
    
    //Per evitare di creare aggregati vuoti, elimino tutti i servizi opzonali vuoti
    $scope.deleteServizioOpzionaleAlternativoEmpty = function(){
    	
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionaliAlternativi);
    	
    	if(appArray && appArray.length > 0){
    		for(var i=0; i<appArray.length; i++){
    			if(!appArray[i]['codiceServizio'] || appArray[i]['codiceServizio'] == ""){
    				$scope.data.step7.datiServiziOpzionaliAlternativi.splice(i, 1);
    			}
    		}
    	}
    }
    
    //C11M08F102 - Visualizzazione Codici Servizio Alternativo
    $scope.C11M08F102 = function(){
    	var _baseRequest = {
    			codiceProgetto: $scope.data.step2.codice_progetto.cod_prgt
    	};
    	
		return RecuperaServiziOpzionaliAlternativi.get(_baseRequest).$promise;
    }
    
    $scope.configureServiziOpzionaliAlternativi = function(){
    	$scope.listCodiceServizioAlternativo = [];
    	
    	$scope.C11M08F102().then(function(data){
    		if(data.result.message == 'KO'){
    			$scope.erroreService(data.result.message);
    			$scope.listCodiceServizioAlternativo = [];
    		}
    		else{
    			if(!data.listaServiziOpzionaliAlternativi || data.listaServiziOpzionaliAlternativi.length == 0){
    	            $scope.erroreCodiceServizio = "Attenzione, nessun servizio opzionale alternativo presente in base dati per il Codice Progetto selezionato";
    				$scope.listCodiceServizioAlternativo = [];
    			}
    			else{
    				$scope.erroreCodiceServizio = null;
    				$scope.listCodiceServizioAlternativo = data.listaServiziOpzionaliAlternativi;	
    			}    			    		
    		}
    	}, function(error){
    		// Error callback
            $scope.erroreService("Impossibile caricare lista valori Codice Servizio");
			$scope.listCodiceServizioAlternativo = [];
    	});
    }
    
	//Ricerca codici servizi duplicati e nel caso, inibisce il passaggio allo step successivo
	$scope.checkDuplicateServiziOpzionaliAlternativi = function(){
		$scope.erroreCodiceServizio = "";
		
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionaliAlternativi);    	
    	var _result = {
    		flag: false,
    		codice: ""	
    	};
    	
    	var _arrayDuplicati = [];
    	
    	if(appArray && appArray.length > 0){
			//Cerca i duplicati nella lista di object
			//TODO: da modificare la proprietà 'codiceServizio' nel caso  		
    		_arrayDuplicati = _.chain(appArray).groupBy('codiceServizio').filter(function(v){return v.length > 1}).flatten().uniq().value();
    		if(_arrayDuplicati && _arrayDuplicati.length > 0){
				_result.flag = true;
    			_result.codice = _arrayDuplicati[0].codiceServizio;
			}
    	}
    	return _result;
	}
	
	//Ricerca codici servizi padre duplicati e nel caso, inibisce il passaggio allo step successivo
	$scope.checkDuplicatePadreServiziOpzionaliAlternativi = function(){
		$scope.erroreCodiceServizio = "";
		
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionaliAlternativi);    	
    	var _result = {
    		flag: false,
    		codice: ""	
    	};
    	
    	var _arrayDuplicati = [];   	
    	
    	if(appArray && appArray.length > 0){    		
    		//Cerca i duplicati nella lista di object
    		_arrayDuplicati = _.chain(appArray).groupBy('codiceServizioPadre').filter(function(v){return v.length > 1}).flatten().uniq().value();
    		if(_arrayDuplicati && _arrayDuplicati.length > 0){
				_result.flag = true;
    			_result.codice = _arrayDuplicati[0].codiceServizioPadre;
			}
    	}
    	
    	return _result;
	}
	
	$scope.setDescrizioneServizioOpzionaleAlternativo = function(codiceServizio, index) {
		let _servizioOpzionaleAlternativo = null;
		$scope.data.step7.datiServiziOpzionaliAlternativi[index].descrizioneServizio = "";
		if($scope.listCodiceServizioAlternativo && $scope.listCodiceServizioAlternativo.length > 0){
			_servizioOpzionaleAlternativo = _.findWhere($scope.listCodiceServizioAlternativo, {'servizioOpzionaleAlternativo': codiceServizio});
			if(_servizioOpzionaleAlternativo){
				$scope.data.step7.datiServiziOpzionaliAlternativi[index].descrizioneServizio = _servizioOpzionaleAlternativo.descrizioneAnagraficaServizioOpzionale;
				$scope.data.step7.datiServiziOpzionaliAlternativi[index].codiceServizioPadre = _servizioOpzionaleAlternativo.servizioOpzionalePadre;		
			}
		}
	}
	
	$scope.$watch("showServiziOpzionaliAlternativi", function(newValue, oldValue){
		if(newValue){
			$scope.configureServiziOpzionaliAlternativi();
		}else{
			$scope.listCodiceServizioAlternativo = [];
		}
	});
    
    /***** FINE CONFIGURAZIONE SERVIZI OPZIONALI ALTERNATIVI *****/
    
    //La sezione Disaggregazione, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isDisaggregazioneRequired = function(form){
    	if(form){
    		if(form.noteSu.$modelValue && form.noteSu.$modelValue !== ""){
    			$scope.isDisaggregazioneRequiredFlag = true;
    		}else {
    			$scope.isDisaggregazioneRequiredFlag = false;
    		}
    	}else {
			$scope.isDisaggregazioneRequiredFlag = false;
		}
    }
    
    //La sezione Presa Appuntamento, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isPresaAppuntamentoRequired = function(form){
    	$timeout(function(){
        	if(form){
        		//SM_9212
        		if((form.dataAppuntamento.$modelValue) 
        				|| (form.fasciaOraria.$modelValue && form.fasciaOraria.$modelValue !== "")){
        			$scope.isPresaAppuntamentoRequiredFlag = true;
        		}else{
        			$scope.isPresaAppuntamentoRequiredFlag = false;
        		} 
        	}else{
    			$scope.isPresaAppuntamentoRequiredFlag = false;
    		}
    	}, 100);
    }
    
    //La sezione Prestazioni Aggiuntive, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isPrestazioniAggiuntiveRequired = function(form){
    	$timeout(function(){
        	if(form){
        		if(form.flagPrestazioneAggiuntiva.$modelValue	 
        				|| (form.prestazioneAggiuntiva.$modelValue && form.prestazioneAggiuntiva.$modelValue !== "")){
        			$scope.isPrestazioniAggiuntiveRequiredFlag = true;
        		}else{
        			$scope.isPrestazioniAggiuntiveRequiredFlag = false;
        		} 
        	}else{
    			$scope.isPrestazioniAggiuntiveRequiredFlag = false;
    		}
    	}, 100);
    }
    
    //La sezione SlaPlusSu, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isSlaPlusSuRequired = function(form){
    	$timeout(function(){
        	if(form){
        		if(form.flagSlaPlusSu.$modelValue	 
        				|| (form.valoreSla.$modelValue && form.valoreSla.$modelValue !== "")){
        			$scope.isSlaPlusSuRequiredFlag = true;
        		}else{
        			$scope.isSlaPlusSuRequiredFlag = false;
        		} 
        	}else{
    			$scope.isSlaPlusSuRequiredFlag = false;
    		}
    	}, 100);
    }    
    
    //Da specifiche, se IDULLCO o IDSLUCO non sono valorizzati, 
    //disabilitare la sezione Disaggregazione per attivazione o migrazione
    $scope.$watchGroup(['data.step7.idullco', 'data.step7.idsluco','data.step4.idullco', 'data.step4.idsluco'], function(newValue, oldValue){        	
    	if($scope.RU_980 || $scope.R1I_20_0131){
        	if($scope.data.step1.causale_ordine.toLowerCase() == 'attivazione'){
        		//In caso di offerte BTS NGA FTTCab/VULA FTTCab, 
        		//viene richiamato solo il servizio di popolamento System Unico 
        		if(['15','16','17','18','44','45'].indexOf($scope.data.step3.offerta.idOfferta) > -1){
        			$scope.triggerC01M02F28_CodiceServizio();
        			//SM_9416
        			$scope.triggerC01M02F28_SystemUnico();
        		}else{
            		if(newValue && (newValue[0] || newValue[1]) && (!angular.equals({}, newValue[0]) || !angular.equals({}, newValue[1]))){
            			$scope.disaggregazioneDisabled = false;
            			$scope.serviziOpzionaliDisabled = false;
            			$scope.triggerC01M02F28_CodiceServizio(); 
            			$scope.triggerC01M02F28_SystemUnico();
            		}else{
						// attivo sempre il trigger, al suo interno la chiamata avviene solo se la sezione servizi opzionali è visibile
						$scope.triggerC01M02F28_CodiceServizio();
            			$scope.disaggregazioneDisabled = true;
            			$scope.serviziOpzionaliDisabled = true;
            		} 
        		}   		  		
        	}
        	
        	if($scope.data.step1.causale_ordine.toLowerCase() == 'migrazione'){
        		//SM_9505
        		//In caso di offerta VULA FTTCab, 
        		//viene richiamato solo il servizio di popolamento System Unico 
        		if($scope.data.step3.offerta.idOfferta == $rootScope.MAP_OFFERTE.VULA_CAB.id){
        			$scope.triggerC01M02F28_SystemUnico();
        		}else{
            		if(newValue && (newValue[2] || newValue[3]) && (!angular.equals({}, newValue[2]) || !angular.equals({}, newValue[3]))){
            			$scope.disaggregazioneDisabled = false;
            			$scope.serviziOpzionaliDisabled = false;
            			$scope.triggerC01M02F28_CodiceServizio(); 
            			$scope.triggerC01M02F28_SystemUnico();  			
            		}else{
            			$scope.disaggregazioneDisabled = true;
            			$scope.serviziOpzionaliDisabled = true;
            		}    
        		}		  		
        	}
    	}
    }); 
    
    
    $scope.triggerC01M02F28_CodiceServizio = function(){	
    	
    	//Se viene visualizzata la sezione Servizi Opzionali, viene richiamato il servizio 
    	if($scope.showServiziOpzionali){
        	$scope.C01M02F28(true).then(function(data){
        		$scope.listCodiceServizio = [];
        		if(data.result.message == 'KO'){
        			$scope.erroreService(data.result.message);
        		}
        		else{
        			if(!data.codiceServizio || data.codiceServizio.length == 0){
						// RU_1560
						if($scope.RU_1560 && !data.result.description.toLowerCase().contains("trovato record")) {
        	            	$scope.erroreCodiceServizio = "Nessun valore trovato per Codice Servizio";
        	            }
        			}
        			else{
        				$scope.erroreCodiceServizio = null;
        				$scope.listCodiceServizio = data.codiceServizio;
        			}
        			    		
        		}
        	}, function(error){
        		// Error callback
                $scope.erroreService("Impossibile caricare lista valori Codice Servizio");
    			$scope.listCodiceServizio = [];
        	});	
    	}
    }
    
    $scope.triggerC01M02F28_SystemUnico = function(){
    	
    	//Se viene visualizzata la sezione Disaggregazione, viene richiamato il servizio 
    	if($scope.showDisaggregazione){
        	$scope.C01M02F28(false).then(function(data){
        		if(data.result.message == 'KO'){
        			$scope.erroreService(data.result.message);
        			$scope.listSystemUnico = [];
        		}
        		else{
        			if(!data.systemUnico || data.systemUnico.length == 0){
        	            $scope.erroreSystemUnico = "Nessun valore trovato per System Unico";
        				$scope.listSystemUnico = [];
        			}
        			else{
        		    	$scope.erroreSystemUnico = null;
        				$scope.listSystemUnico = data.systemUnico;	
        			}	    		
        		}
        	}, function(error){
        		// Error callback
                $scope.erroreService("Impossibile caricare lista valori System Unico");
    			$scope.listSystemUnico = [];
        	});
    	}
    }
    
    
    //C01M02F28 - Determina Area Di Cantiere
    $scope.C01M02F28 = function(flagCodiceServizio){
    	var _baseRequest = {
    			idOfferta: $scope.data.step3.offerta.idOfferta,
    			codificaOloAgcom: $scope.data.step1.operatore.codiceOLO,
    			idOfferta: $scope.data.step3.offerta.idOfferta,
    			datiClienteFinale: $scope.data.step6.indirizzoDatiClienteFinale || {},
    			RU1560: ($scope.RU_1560 && $scope.offertaValida_RU_1560) ? "SI" : "NO"
    	};
    	
    	try{
    		if(_baseRequest.datiClienteFinale && Object.keys(_baseRequest.datiClienteFinale).length > 0){
	    		delete _baseRequest.datiClienteFinale['indirizzo_cliente_interno'];
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_piano'];
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_scala'];
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_complesso'];
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_cap'];
    		}
    	}catch(e){
    		console.error(e)
    	}
    	
    	if($scope.data.step7.idullco && $scope.data.step7.idullco.idullco){
    		_baseRequest.idullco = $scope.data.step7.idullco.idullco;
    	}else if($scope.data.step4.idullco && $scope.data.step4.idullco.idullco){
    		_baseRequest.idullco = $scope.data.step4.idullco.idullco;
    	}
    	if($scope.data.step7.idsluco && $scope.data.step7.idsluco.idsluco){
    		_baseRequest.idsluco = $scope.data.step7.idsluco.idsluco;
    	}else if($scope.data.step4.idsluco && $scope.data.step4.idsluco.idsluco){
    		_baseRequest.idsluco = $scope.data.step4.idsluco.idsluco;
    	}
    	
    	_baseRequest.flagCodiceServizio = flagCodiceServizio || false;
    	
		return RecuperaCodServizioSysUnico.save({}, _baseRequest).$promise;
    }
    
    $scope.oscuramento_RU_980 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_980.oscurato){
    				$scope.RU_980 = ($rootScope.OSCURAMENTI.RU_980.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_980 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_980 = false;
    	}          	
    }
    
    //SM_9216
    $scope.resetOtherSectionsOnDisaggragazioneRequired = function(){
	
		//RU_1393
		if(!$scope.isOffertaSemiGPON){
			$scope.data.step7.datiAppuntamentoDisaggregazione = {};
    		$scope.data.step7.datiPrestazioniAggiuntive = {};
    		$scope.data.step7.datiSlaPlusSu = {};    	
    		//RU_1393
    		$scope.data.step7.datiGestioneAutonoma = {};
    	
			$scope.presaAppuntamentoDisabled = true;
			$scope.prestazioniAggiuntiveDisabled = true;
			$scope.slaPlusSuDisabled = true;
		}

    }
    
    //SM_9216
    $scope.isDisaggregazioneFilledProperly = function(){    	
    	if($scope.data.step7 && $scope.data.step7.datiDisaggregazione){
    		var _sysUnico = $scope.data.step7.datiDisaggregazione.systemUnico;
    		if(!_sysUnico || _sysUnico == null || _sysUnico == '' || isNaN(_sysUnico)){
    			$scope.resetOtherSectionsOnDisaggragazioneRequired();
    		}else{
        		$scope.presaAppuntamentoDisabled = false;
        		$scope.prestazioniAggiuntiveDisabled = false;
        		$scope.slaPlusSuDisabled = false;
    		}
    	}else{    		
    		$scope.resetOtherSectionsOnDisaggragazioneRequired();
    	}
    }
    
    //Da specifiche, se la sezione Disaggregazione non è compilata correttamente
    //disabilitare le altre sezioni (Presa Apppuntamento, Prestazioni Aggiuntive, Sla Plus SU)
    
    $scope.$watch('data.step7.datiDisaggregazione.systemUnico', function(newValue, oldValue){
    	if(newValue){
    		$scope.isDisaggregazioneFilledProperly(newValue);
    	}else{
    		$scope.resetOtherSectionsOnDisaggragazioneRequired();
    	}
    });   
    
    $scope.oscuramento_RU_980();
    
    
    //R1I_20_0131
    
    $scope.oscuramento_R1I_20_0131 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.R1I_20_0131.oscurato){
    				$scope.R1I_20_0131 = ($rootScope.OSCURAMENTI.R1I_20_0131.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.R1I_20_0131 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.R1I_20_0131 = false;
    	}          	
    }
    
    //Inizializza le variabili per mostrare/nascondere le sezioni in base al tipo di offerta
    $scope.checkShowSezioni_R1I_20_0131 = function(){
    	
    	if($scope.R1I_20_0131){
    		var idOfferta = $scope.data.step3.offerta.idOfferta;
        	
        	var attivazione = $rootScope.OSCURAMENTI.R1I_20_0131.visualizzaSezioni.attivazione;
        	
        	if($scope.data.step1.causale_ordine.toLowerCase() == 'attivazione'){
        		$scope.showDisaggregazione = (attivazione.offerteDisaggregazione.indexOf(idOfferta) > -1);
        		$scope.showPresaAppuntamento = (attivazione.offertePresaAppuntamento.indexOf(idOfferta) > -1);
        		$scope.showPrestazioniAggiuntive = (attivazione.offertePrestazioniAggiuntive.indexOf(idOfferta) > -1);
        		$scope.showSlaPlusSu = (attivazione.offerteSlaPlusSu.indexOf(idOfferta) > -1);
        		
        	    //In caso di offerta VULA FTTCab, visualizzare la sezione Servizi Opzionali solo in caso di Linea Non Fonia    	    
    	    	if(!$scope.RU_1560 && $scope.customizedOffer &&
    	       		 $scope.customizedOffer.offerTopDetails &&
    	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA && 
    	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'LineaNonFonia'){
    	    		$scope.showServiziOpzionali = true;
    	    	}else{
    	    		$scope.showServiziOpzionali = false;
    	    		//SM_9502
    	    		$scope.showPresaAppuntamento = false;
    	    		$scope.showPrestazioniAggiuntive = false;
    	    		$scope.showSlaPlusSu = false;
    	    	}
        	}        		       	    
    	}    	
    }
    
    //RU_1036
    $scope.oscuramento_RU_1036 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1036.oscurato){
    				$scope.RU_1036 = ($rootScope.OSCURAMENTI.RU_1036.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_1036 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_1036 = false;
    	}          	
    }
    
    //RU_1084
    $scope.oscuramento_RU_1084 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1084.oscurato){   				
   					$scope.RU_1084 = ($rootScope.OSCURAMENTI.RU_1084.idOfferteNonValide.indexOf($scope.data.step3.offerta.idOfferta) == -1);  				
    			}else{
    				$scope.RU_1084 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.RU_1084 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1084();
    
    //R1F-20-0236
    $scope.oscuramento_R1F_20_0236 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.R1F_20_0236.oscurato){   				
   					$scope.R1F_20_0236 = ($rootScope.OSCURAMENTI.R1F_20_0236.idOfferteNonValide.indexOf($scope.data.step3.offerta.idOfferta) == -1);  				
    			}else{
    				$scope.R1F_20_0236 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.R1F_20_0236 = false;
    	}          	
    }
    
    $scope.oscuramento_R1F_20_0236();
    
    $scope.setFlagToken = function(flagToken){
    	if($scope.data.step5.datiReferenti){    	
    		
    		//SM_9625
    		Object.keys($scope.data.step5.datiReferenti)
    			.forEach(function(key, index){
    				if($scope.data.step5.datiReferenti[key].qualifica == 'O'){
    					$scope.data.step5.datiReferenti[key].flagToken = 'N';
    				}else{
    					$scope.data.step5.datiReferenti[key].flagToken = flagToken;
    				}
    			});
    	}
    }
    
	//R1F-20-0236
	//Nel caso di C2PLUS nuovo disoscurato, estraggo tutti i campi per cliente finale
	//altrimenti solo quelli richiesti da C2PLUS classico (numeri telefonici) 
    $scope.estraiDatiReferenti = function(){
    	
    	//Dalla lista dei referenti estrae solo i Clienti Finali
    	var _appArray = Object.keys($scope.data.step5.datiReferenti).map(function(i){ return $scope.data.step5.datiReferenti[i]});
    	var _clientiFinali = [];
    	
    	//SM_10450
    	_appArray.forEach(function(item, i){
    		if(item && item.qualifica == 'CF'){
    			_clientiFinali.push({
    				id: i,
    				numeroMobile: (item.cellulare || null),
    				numeroFisso: (item.telefonoFisso || null),
    				nome: (item.nome || null),
    				cognome: (item.cognome || null)
    			});
    		}    			
    	});
		
		return _clientiFinali;
    }
    
    //Comprende le funzioni C01M01F29 e C11M08F73
    $scope.tokenizzazioneReferenti = function(){

    	var _clientiFinali = [];
    	var _lavorazione = $scope.data.step1.causale_ordine;
    	var _request = {
    			codOloAgcom: $scope.data.step1.operatore.codiceOLO,
    			codOrdineOlo: $scope.data.step1.codice_ordine,
    			lavorazione: $scope.data.step1.causale_ordine,
    			operatore: $scope.data.step1.operatore.id
    	};
    	
    	//Bug #32193
    	//Dai referenti ricava solo i numeri telefonici
    	//SM_10354
    	if($scope.data.step5.datiReferenti && !_.isEmpty($scope.data.step5.datiReferenti)){
    		
    		//R1F-20-0236   		
    		_clientiFinali = $scope.estraiDatiReferenti();
    	}
    	
    	//SM_9606
		_request.idOfferta = $scope.data.step3.offerta.idOfferta;
    	_request.numeriReferenti = _clientiFinali;
    	
		_request.indirizzoClienteFinale = {
    			indirizzo_cliente_provincia: null,
    			indirizzo_cliente_comune: null,
    			indirizzo_cliente_indirizzo: null,
    			indirizzo_cliente_civico: null,
    			indirizzo_cliente_particella_toponomastica: null
		};
    	  
		//SM_9657
        if($scope.data.assetDetail){
        	_request.codIstatComune = ($scope.data.assetDetail.codIstatComune || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_provincia = ($scope.data.assetDetail.provincia || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_comune = ($scope.data.assetDetail.comune || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_indirizzo = ($scope.data.assetDetail.via || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_civico = ($scope.data.assetDetail.numero || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_particella_toponomastica = ($scope.data.assetDetail.descParticellaToponomastica || null);
        }else if($scope.data.step6 && $scope.data.step6.indirizzoDatiClienteFinale){
        	_request.codIstatComune = null;
			_request.indirizzoClienteFinale.indirizzo_cliente_provincia = ($scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_comune = ($scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_indirizzo = ($scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_civico = ($scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_particella_toponomastica = ($scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica || null);
        }
		
		//SM_9637
		if($scope.data.step7){
			if($scope.data.step7.numeroLinea){
				_request.dn = $scope.data.step7.numeroLinea;
			}	
			if($scope.data.step7.dn){
				_request.dn = $scope.data.step7.dn;
			}	
		}
		
    	$rootScope.data.numeriReferentiTokenizzati = [];
    	
    	return Tokenizzazione.save(_request).$promise;   	
    };    
    
    //R1F-20-0236
    $scope.tokenizzazioneClienteFinale = function(){
    	var _request = {};
    	
    	var _appClienteFinale = $scope.data.step6.datiClienteFinale;
    	var _appIndirizzo = $scope.data.step6.indirizzoDatiClienteFinale;
    	
		_request = {
				codOloAgcom: $scope.data.step1.operatore.codiceOLO,
				codOrdineOlo: $scope.data.step1.codice_ordine,
				lavorazione: $scope.data.step1.causale_ordine,
				operatore: $scope.data.step1.operatore.id
		};
    	
    	//SM_10354
		_request.idOfferta = $scope.data.step3.offerta.idOfferta;
		
		_request.indirizzoClienteFinale = {
    			indirizzo_cliente_provincia: null,
    			indirizzo_cliente_comune: null,
    			indirizzo_cliente_indirizzo: null,
    			indirizzo_cliente_civico: null,
    			indirizzo_cliente_particella_toponomastica: null
		};

    	if(_appClienteFinale){
    		_request.numeriReferenti = [];
    		_request.numeriReferenti.push({
    			id: "-1",
    			nome: (_appClienteFinale.nome_cliente || null),
    			cognome: (_appClienteFinale.cognome_cliente || null),
    			codFiscale: (_appClienteFinale.codice_fiscale_cliente || null),
    			pIva: (_appClienteFinale.partita_iva_cliente || null)    			
    		});
    		
    	}
    	
        if($scope.data.assetDetail){
        	_request.codIstatComune = ($scope.data.assetDetail.codIstatComune || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_provincia = ($scope.data.assetDetail.provincia || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_comune = ($scope.data.assetDetail.comune || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_indirizzo = ($scope.data.assetDetail.via || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_civico = ($scope.data.assetDetail.numero || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_particella_toponomastica = ($scope.data.assetDetail.descParticellaToponomastica || null);
        }else if(_appIndirizzo){
        	_request.codIstatComune = null;
        	
			_request.indirizzoClienteFinale.indirizzo_cliente_provincia = (_appIndirizzo.indirizzo_cliente_provincia || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_comune = (_appIndirizzo.indirizzo_cliente_comune || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_indirizzo = (_appIndirizzo.indirizzo_cliente_indirizzo || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_civico = (_appIndirizzo.indirizzo_cliente_civico || null);
			_request.indirizzoClienteFinale.indirizzo_cliente_particella_toponomastica = (_appIndirizzo.indirizzo_cliente_particella_toponomastica || null);
        }
    	
        //SM_10509
		if($scope.data.step7){
			if($scope.data.step7.numeroLinea){
				_request.dn = $scope.data.step7.numeroLinea;
			}	
			if($scope.data.step7.dn){
				_request.dn = $scope.data.step7.dn;
			}	
		}

    	$rootScope.data.clienteFinaleTokenizzato = {};
    	
    	return Tokenizzazione.save(_request).$promise;   
    }
    
    $scope.$watch("customizedOffer.offerTopDetails.TIPOLINEA.dft", function(newValue, oldValue){
    	if(newValue){
    		if($scope.customizedOffer.offerTopDetails.TIPOLINEA.dft == "LineaNonFonia" && $scope.RU_1036){
    			$scope.showQualifica = true;
    			if(!$scope.data.step7.qualifica){
    				$scope.data.step7.qualifica = 'Y';
    			}    			
    		}else{
    			$scope.showQualifica = false;
    			$scope.data.step7.qualifica = null;
    		}
    	}
    });
    
    $scope.oscuramento_R1I_20_0131();    
    
    $scope.checkShowSezioni_RU_980();
    
    $scope.oscuramento_RU_1036();
    
    $scope.checkShowSezioni_R1I_20_0131();
    
    //RU_1058
    $scope.oscuramento_RU_1058 = function(){
		
    	try{
    		if($scope.data.step3.offerta.idOfferta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1058.oscurato){
    				$scope.RU_1058 = ($rootScope.OSCURAMENTI.RU_1058.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_1058 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_1058 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1058();
    
    //RU_1164
    $scope.oscuramento_RU_1164 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1164.oscurato){
    				$scope.RU_1164 = ($rootScope.OSCURAMENTI.RU_1164.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_1164 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_1164 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1164();
    
    
    $scope.setShowReferenteOaoProgettiSpeciali = function(){
    	
   	 $scope.showReferenteOaoProgettiSpeciali = false;    	 
   	 var _causaleOrdine = $scope.data.step1.causale_ordine;
   	 var _idOfferta = $scope.data.step3.offerta.idOfferta;
   	 var _arrayOfferteNonValide = [$rootScope.MAP_OFFERTE.FWA.id,
   		 						   $rootScope.MAP_OFFERTE.GPON_SEMI.id,
   		 						   $rootScope.MAP_OFFERTE.GPON_FULL.id,
   		 						   $rootScope.MAP_OFFERTE.VLAN_VULA.id,
   		 						   $rootScope.MAP_OFFERTE.VLAN_NGA.id,
   		 						   $rootScope.MAP_OFFERTE.FEEDER.id,
   		 						   $rootScope.MAP_OFFERTE.VLANNGAMULTICAST.id,
   		 						   $rootScope.MAP_OFFERTE.SEDEOLT.id,
   		 						   $rootScope.MAP_OFFERTE.CANALE.id,
   		 						   $rootScope.MAP_OFFERTE.NPNG.id,
					        	   $rootScope.MAP_OFFERTE.GPON_SEMI_PNRR.id,
					        	   $rootScope.MAP_OFFERTE.GPON_FULL_PNRR.id];
   	 
   	if($scope.R1F_20_0236){
   		if(_causaleOrdine != 'cessazione' && _arrayOfferteNonValide.indexOf(_idOfferta) == -1){
   			$scope.showReferenteOaoProgettiSpeciali = true;  
   		}
   	}
   }
   
   $scope.setShowReferenteOaoProgettiSpeciali();
   
   //RU_1543
   $scope.oscuramento_RU_1543 = function() {
   		$scope.RU_1543 = !$rootScope.OSCURAMENTI.RU_1543.oscurato;
   }
   
   //C11M08F109 - Verifica servizio opzionale FULLGPONPLUS
   $scope.C11M08F109 = function(){
	 var _causaleOrdine = $scope.data.step1.causale_ordine;
   	 var _idOfferta = $scope.data.step3.offerta.idOfferta;
   	 var _offerteValide = [$rootScope.MAP_OFFERTE.FULLGPONPLUS.id,
   		 				   $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id];
   	 var _isOffertaFullGponPlus = (_offerteValide.indexOf(_idOfferta) > -1);
     var _response = {
		flag: false,
		message: null	
	 };
	 
	 if(_causaleOrdine == 'attivazione' && _isOffertaFullGponPlus){
		 $scope.data.step7.datiServiziOpzionali.forEach(function(item, index){
    	 	if(item.codiceServizio == "TLC8"){
				_response.flag = true;
				_response.message = "Servizio non congruente con la richiesta di attivazione corrispondente";
			}
    	});
	 }		 				 
   		 				   
   	 return _response;
   }
   
    // C11M08F16 – Verifica Ordine in Ambito 
    $scope.C11M08F16 = function(){
    	
    	var _request = {
    		codiceOlo : $scope.data.step1.operatore.codiceOLO || $scope.data.step1.operatore,
    		servizio : $scope.data.step3.offerta.nomeOfferta,
    		lavorazione : 'attivazione'
    	};
    	
    	return Locator.save(_request).$promise;
    	
    };	
    
	$scope.$watch("showServiziOpzionali", function(newValue, oldValue){
		if(newValue){
			$scope.triggerC01M02F28_CodiceServizio();
		}
	});
	
}]);
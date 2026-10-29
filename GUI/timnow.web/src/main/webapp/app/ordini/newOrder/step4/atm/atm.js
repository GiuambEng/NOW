timnow.controller('atm', ['$scope', '$state', '$rootScope', '$log', '$q', 'modalService', 'VPCode', 'VCProfiles','VerificaVpFlat','MAP_OFFERTE', 'VerificaCompatibilitaProfiloVc', function ($scope, $state, $rootScope, $log, $q, modalService, VPCode, VCProfiles,VerificaVpFlat, MAP_OFFERTE, VerificaCompatibilitaProfiloVc) {

    $scope.loadProfiloTecnicoLinea = false;
    $scope.attivaPassaggioCinque = true;
    $scope.erroriConfigurazioneOfferta = [];
    
    if($rootScope.topDetails && $rootScope.topDetails.TIPOLINEA && $rootScope.topDetails.TIPOLINEA['dft']){
    	$scope.tipoLineaOption=$rootScope.topDetails.TIPOLINEA['dft'].split(';');
    }
    
    if(($rootScope.MAP_OFFERTE && $scope.data && $scope.data.step3 && $rootScope.MAP_OFFERTE.ATM_SF.id === $scope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.ATM_SH.id === $scope.data.step3.offerta.idOfferta) && (($rootScope.data.step1.causale_ordine!=='variazione') || ($rootScope.data.step3.opzioneVariazione !== 'Downgrade Fast'))){
    	$scope.getLineProfiles();
    }
    $scope.getVPCode = function () {
        var vpcode = VPCode.get({
        	  idOfferta: $rootScope.data.step3.offerta.idOfferta,
        	  codOlo: $scope.data.step1.operatore.id
        	  });
        vpcode.$promise.then(
            function (response) {
                $rootScope.formData.VPCodes = response.data;
                $scope.errorVP = false;
            }, function (error) {
                $log.debug(error);
                $scope.errorVP = "Impossibile caricare i codici VP. Riprovare piu' tardi";
                $log.debug("Impossibile caricare i codici VP. Riprovare piu' tardi");
            });
    };
  
    
    $scope.eraseVciVpiDlciLmi = function(){
    	angular.forEach($scope.data.step4.vcItems, function(value) {
    		 if(value.VPI && value.VPI.dft){
    			 value.VPI.dft = "";
    		 }
    		 if(value.VCI && value.VCI.dft){
    			 value.VCI.dft = "";
    		 }
    		 if(value.DLCI && value.DLCI.dft){
    			 value.DLCI.dft = "";
    		 }
    		});
    };
   if(($rootScope.data.step1.causale_ordine==='attivazione') && ($rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING && !$rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING.dft)){
	   $rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING.dft = "N";
   }
    if($rootScope.data.step1.causale_ordine==='variazione'){
    	if($rootScope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    	if($rootScope.data.step3.opzioneVariazione === "Incremento/decremento VC"){
    		$scope.attivaPassaggioCinque = false;
    		
    		if($rootScope.data.step4.vcItems.length !== $rootScope.DettaglioAssetVC.vcItems.length){
    			$scope.avantiAttivo = true;
    		}
    	}
    	if($rootScope.data.step3.opzioneVariazione === "Cambio SLA"){
    		$rootScope.DettaglioChangeKO = true;
    	}
    	
    		if($rootScope.MAP_OFFERTE.ATM_SF.id === $scope.data.step3.offerta.idOfferta) {
        		$scope.tipoCaratteristica = ["FLAT", "HIGH LEVEL"];
        		if($rootScope.customizedOffer.offerTopDetails.CARATTERISTICA && !$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft){
       			$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft = "FLAT";
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA = {};
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft = "FLAT";
        		}
        	}
        	if($rootScope.MAP_OFFERTE.ATM_SH.id === $scope.data.step3.offerta.idOfferta){
        		$scope.tipoCaratteristica = ["FLAT", "HIGH LEVEL"];
        		if($rootScope.customizedOffer.offerTopDetails.CARATTERISTICA && !$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft){
       			$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft = "HIGH LEVEL";
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA = {};
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft = "HIGH LEVEL";
        		}
        	}
        	if($rootScope.MAP_OFFERTE.ATM_AL.id === $scope.data.step3.offerta.idOfferta){
        		$scope.tipoCaratteristica = ["LITE", "FLAT", "HIGH LEVEL"];
        		if($rootScope.customizedOffer.offerTopDetails.CARATTERISTICA && !$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft){
       			$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft = "LITE";
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA = {};
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft = "LITE";
        		}
        	}
        	if($rootScope.MAP_OFFERTE.ATM_AF.id === $scope.data.step3.offerta.idOfferta){
        		$scope.tipoCaratteristica = ["LITE", "FLAT", "HIGH LEVEL"];
        		if($rootScope.customizedOffer.offerTopDetails.CARATTERISTICA && !$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft){
       			$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft = "FLAT";
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA = {};
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft = "FLAT";
        		}
        	}
        	
			/* SM_8830 */
			if($rootScope.MAP_OFFERTE.ATM_AH.id === $scope.data.step3.offerta.idOfferta){
        		$scope.tipoCaratteristica = ["LITE", "FLAT", "HIGH LEVEL"];
        		if($rootScope.customizedOffer.offerTopDetails.CARATTERISTICA && !$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft){
       			$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft = "HIGH LEVEL";
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA = {};
       			$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft = "HIGH LEVEL";
        		}
			}
        	if($rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA){
        		$scope.getLineProfiles($rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft);
        	}
    	
    	
    }
//    C04M01F57 – Verifica univocità VCI – VPI (nel caso di protocollo ATM)
    $scope.checkUniqueVciVpi = function () {
        var ar = [];
        angular.forEach($scope.data.step4.vcItems,
            function (value, key) {
                ar.push(value.VPI.dft + "-" + value.VCI.dft);
            });
        ar.sort();
        for (var i = 1; i < ar.length; i++) {
            if (ar[i - 1] === ar[i]) {
                return false;
            }
        }
        return true;
    };
//    C04M01F151 – Verifica Univocità DLCI  (nel caso di protocollo FR)
    $scope.checkUniqueDLCI = function () {
        var ar = [];
        angular.forEach($scope.data.step4.vcItems,
            function (value, key) {
                ar.push(value.DLCI.dft + "-" + value.DLCI.dft);
            });
        ar.sort();
        for (var i = 1; i < ar.length; i++) {
            if (ar[i - 1] === ar[i]) {
                return false;
            }
        }
        return true;
    };
    
    $scope.configurazioneOffertaGetProfiloVC = function (itemNum) {
        $rootScope.numItemForModalCallback = itemNum;

        $scope.modalOptionsTabellaConfigurazioneOffertaProfiloVC = {
            headerText: 'Seleziona un Profilo VC',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackProfiloVC',
            dataHeader: $scope.headerConfigurazioneOffertaProfiloVC,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.ProfiliVC
        };
        $scope.showSpinner = false;
        modalService.showModal({}, $scope.modalOptionsTabellaConfigurazioneOffertaProfiloVC);
    };

    $scope.getVCProfiles = function (tipologia, itemNum) {
    	var protocollo = ""
    	if(($rootScope.MAP_OFFERTE && (($rootScope.MAP_OFFERTE.ATM_SF.id === $scope.data.step3.offerta.idOfferta) || ($rootScope.MAP_OFFERTE.ATM_SH.id === $scope.data.step3.offerta.idOfferta))) && $rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO){
    		protocollo = $rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft
    	}
        $scope.showSpinner = true;
        VCProfiles.get({
            idOfferta: $rootScope.data.step3.offerta.idOfferta,
            tipoprofilovc: tipologia,
            protocollo: protocollo,
            profilotecnicolinea:$scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft,
            caratteristica : ($scope.customizedOffer.offerTopDetails && $scope.customizedOffer.offerTopDetails.CARATTERISTICA.dft)?$scope.customizedOffer.offerTopDetails.CARATTERISTICA.dft:""
        }).$promise.then(
            function (response) {
                $rootScope.formData.ProfiliVC = response.data;
                $scope.errorVC = false;
                $scope.configurazioneOffertaGetProfiloVC(itemNum);
            }, function (error) {
                $log.debug(error);
                $scope.errorVC = "Impossibile caricare i Profili VC. Riprovare piu' tardi";
                $log.debug("Impossibile caricare i Profili VC. Riprovare piu' tardi");
                $scope.errorVC = true;
            });
    };

    $scope.headerConfigurazioneOffertaProfiloVC = [
        {"key": "identificativoProfiloVc", "value": "Profilo", "type": "text"},
        {"key": "tipoProfilo", "value": "Tipo Profilo", "type": "text"},
        {"key": "mcr_Down", "value": "MCR Down", "type": "text", "sort": "number"},
        {"key": "mcr_Up", "value": "MCR Up", "type": "text", "sort": "number"},
        {"key": "pcr_Down", "value": "PCR Down", "type": "text", "sort": "number"},
        {"key": "pcr_Up", "value": "PCR Up", "type": "text", "sort": "number"},
        {"key": "offerta", "value": "Offerta", "type": "text"}
    ];

    $scope.configurazioneOffertaCallbackProfiloVC = function (item) {
        angular.forEach($scope.data.step4.vcItems, function (vcItem) {
        	if(!vcItem.IDPROFILOVC){
        		vcItem.IDPROFILOVC = {};
        	}
            if (vcItem.id === $rootScope.numItemForModalCallback) {
                vcItem.IDPROFILOVC.dft = item.identificativoProfiloVc;
                vcItem.IDPROFILOVC.pcr_Up = item.pcr_Up;
                vcItem.IDPROFILOVC.pcr_Down = item.pcr_Down;
            }
        });
    };


    $scope.headerConfigurazioneOffertaCodiceVP = [
        {"key": "codiceVP", "value": "Codice VP", "type": "text"},
        {"key": "clli", "value": "CLLI", "type": "text"},
        {"key": "nomeCentrale", "value": "Nome Centrale", "type": "text"}
    ];

    $scope.configurazioneOffertaCallbackCodiceVP = function (item) {
        angular.forEach($scope.data.step4.vcItems, function (vcItem) {
            if (vcItem.id === $rootScope.numItemForModalCallback) {
                vcItem.CODICEVP = {};
                vcItem.CODICEVP.dft = item.codiceVP;
            }
        });
    };
    $scope.configurazioneOffertaGetCodiceVP = function ($event, itemNum) {
        $event.preventDefault();
        $rootScope.numItemForModalCallback = itemNum;

        $scope.modalOptionsTabellaConfigurazioneOffertaCodiceVP = {
            headerText: 'Seleziona un Codice VP',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackCodiceVP',
            dataHeader: $scope.headerConfigurazioneOffertaCodiceVP,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.VPCodes
        };

        modalService.showModal({}, $scope.modalOptionsTabellaConfigurazioneOffertaCodiceVP);
    };
    $scope.configurazioneOffertaCallbackGetCodiceTDAtm = function (item) {

        angular.forEach($scope.data.step4.vcItems, function (vcUsersItem) {
            if (vcUsersItem.id === $rootScope.numItemForModalCallback) {

                if (vcUsersItem.CODICETD) {
                    vcUsersItem.CODICETD.dft = item.codKit;
                } else {
                    vcUsersItem.CODICETD = {};
                    vcUsersItem.CODICETD.dft = item.codKit;
                }
            }
        });
    };
    $scope.headerGetCodiceTD = [
        {"key": "codKit", "value": "Codice Kit", "type": "text"},
        {"key": "clli", "value": "CLLI", "type": "text", "sort": "number"}
    ];

    $scope.configurazioneOffertaGetCodiceTDAtm = function ($event, itemNum) {
        $rootScope.numItemForModalCallback = itemNum;
        $scope.modalOptionsTabellaConfigurazioneOffertaCodiceTD = {
            headerText: 'Seleziona un codice TD',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackGetCodiceTDAtm',
            dataHeader: $scope.headerGetCodiceTD,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.codiceTD
        };
        $event.preventDefault();
        modalService.showModal({}, $scope.modalOptionsTabellaConfigurazioneOffertaCodiceTD);
    };
    
    function testVpFlat(){
    	var vcItemTemp=[];
    	var tipoBandaCondivisaCheck=false;
    	var tipoBandaDedicataCheck=false;
    	
    	angular.forEach($scope.data.step4.vcItems, function (item) {
    		
    		if((item.TIPOBANDACONSEGNA) && (item.TIPOBANDACONSEGNA.dft==="CONDIVISA")){
    			tipoBandaCondivisaCheck=true;
    			vcItemTemp.push({
    				vpCode: item.CODICEVP.dft,
    				tipoBanda: item.TIPOBANDACONSEGNA.dft,
    				tipoProfiloVC: item.TIPOPROFILOVC.dft,
    				idVc:item.IDPROFILOVC.dft
    			});
    		}else if((item.TIPOBANDACONSEGNA) && (item.TIPOBANDACONSEGNA.dft==="DEDICATA")){
    			tipoBandaDedicataCheck=true;
    		}
        });
    	
    	if(tipoBandaCondivisaCheck && !tipoBandaDedicataCheck){
    		VerificaVpFlat.verifica({
	    		vc: vcItemTemp,
	    		codOLOAgcom:$scope.data.step1.operatore.codiceOLO
	        }).$promise.then(
	        function (response) {
	        	if(response.esito==='OK'){
	        		$scope.salvaConfigurazioneOfferta();
		        	$scope.controlloBozza(5);
	        	}else{
	        		$scope.erroreService("Verifica VP Flat fallita");
	        	}
	        }, function (error) {
	            $log.info("Impossibile Verificare ");
	            $log.debug(error);
	            $scope.erroreService("Verifica VP Flat non riuscita");
	            return false;
				});
    	}else if(tipoBandaCondivisaCheck && tipoBandaDedicataCheck){
    		$scope.erroreService("La configurazione dei VC non è corretta.");
    	}else{
    		$scope.salvaConfigurazioneOfferta();
        	$scope.controlloBozza(5);
    	}
    };

    $scope.aggiungiVCIncDec = function (vc) {
    	$scope.avantiAttivo = true;
        $scope.data.step4.vcItems = vc;
        $scope.vcUser=vc.length;
        
        $scope.vcUserID = vc[vc.length - 1].id;
        
        $scope.vcUserID++;
        $scope.vcUser++;
        $scope.data.step4.vcItems.push({
            'id': $scope.vcUserID
        });
        if($rootScope.data.step1.causale_ordine === 'variazione'){
        	if(!vc[vc.length - 1].AZIONE){
        		vc[vc.length - 1].AZIONE={};
        	}
        	vc[vc.length - 1].AZIONE.dft='A';
    	}  
        
        
    };

    $scope.abilitaAddVC = function () {
    		var totali=$scope.data.step4.vcItems.length;
    		if ((MAP_OFFERTE.ATM_SF.id===$scope.data.step3.offerta.idOfferta ||MAP_OFFERTE.ATM_SH.id===$scope.data.step3.offerta.idOfferta)&&
    			(($scope.data.step3.opzioneVariazione==='Incremento/decremento VC')||$scope.data.step1.causale_ordine==='attivazione')){
    			return (totali < 2000 );
    		}else{
            	return (totali < 10 );
    		}
    };
    
    $scope.abilitaEliminaVC = function () {
    	var eliminati=1;
    	angular.forEach($scope.data.step4.vcItems, function (vc) {
			if (vc.ELIMINA && vc.ELIMINA.dft){
				eliminati++;
			}
		});
    	return ($scope.data.step4.vcItems.length > eliminati );
    };
    
    $scope.eliminaVCAzione = function (vc) {
    	$scope.attivaPassaggioCinque = true;
    	$scope.avantiAttivo = true;
    	if(vc.ELIMINA && vc.ELIMINA.dft){
    		vc.AZIONE = {};
    		vc.AZIONE.dft='C';
    	}else if(vc.AZIONE && vc.AZIONE.dft==='C'){
    		delete vc.AZIONE.dft;
    	}
    };
   
// CONTROLLO PER PASSAGGIO ALLO STEP 5
    $scope.submit_4 = function () {
    	$scope.controlloCasuale = function(){
    		if(($rootScope.data.step1.causale_ordine === 'variazione') && ($rootScope.data.step3.opzioneVariazione === 'Cambio SLA'))
    		{
    				$scope.salvaConfigurazioneOfferta();
    			} else {
        	//C04M01F64 – Verifica VP FLAT attestazione
        	if($scope.data.step3.offerta.nomeOffertaCatalogo === 'BitstreamATMAsimmetricoFlat'){
        		testVpFlat();
        	}else{
        		$scope.salvaConfigurazioneOfferta();
            	$scope.controlloBozza(5);
        	}
    		}
    	};
    	if(($rootScope.data.step1.causale_ordine !== 'variazione') || (($rootScope.data.step1.causale_ordine === 'variazione') && ($rootScope.data.step3.opzioneVariazione !== 'Cambio SLA'))){
    		if($rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO && ($rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft === "ATM")){
        		if($scope.checkUniqueVciVpi()){
        			$scope.controlloCasuale();
        		} else {
        			$scope.erroreService("La coppia VCI, VPI deve essere differente per ogni VC.");
        		}
        	} else if($rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO && ($rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft === "FR")){
        		if($scope.checkUniqueDLCI()){
        			$scope.controlloCasuale();
        		} else {
        			$scope.erroreService("Il DLCI deve essere differente per ogni VC.");
        		}
        	} else {
        		$scope.controlloCasuale();
        	}
    	} else {
    		$scope.controlloCasuale();
    	}
    	
    	
    };

    if (($rootScope.data.step1.causale_ordine !== 'variazione') && (!$rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft)){
    	$rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft = 'LineaNonFonia';
    }
    
    $scope.salvaConfigurazioneOfferta = function () {
        $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
        if(($rootScope.data.step1.causale_ordine === 'variazione') && !$scope.data.step4.idTicketTTM){
        	
        	//RU_713
        	if($scope.data.step1.causale_ordine==='variazione' && $rootScope.data.step3.opzioneVariazione === "Riconfigurazione Accesso" && [MAP_OFFERTE.ATM_AF.name, MAP_OFFERTE.ATM_AH.name, MAP_OFFERTE.ATM_AL.name, MAP_OFFERTE.ATM_SF.name, MAP_OFFERTE.ATM_SH.name].indexOf($rootScope.data.step3.offerta.nomeOffertaCatalogo) >= 0) {
        		$scope.verificacompatibproftecnlineaprofilovc(); 
        	} else {
        		$state.go($scope.checkNextStateVariazione());
        	}
        	
        }else if(($rootScope.data.step1.causale_ordine === 'variazione') && $scope.data.step4.idTicketTTM){
        	if($rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft === $rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA.dft){
        		$scope.erroreService("Per la variazione selezionata è necessario modificare il Profilo Tecnico Linea");
        	}else {
        		//RU_713
        		if($scope.data.step1.causale_ordine==='variazione' && $rootScope.data.step3.opzioneVariazione === "Riconfigurazione Accesso" && [MAP_OFFERTE.ATM_AF.name, MAP_OFFERTE.ATM_AH.name, MAP_OFFERTE.ATM_AL.name, MAP_OFFERTE.ATM_SF.name, MAP_OFFERTE.ATM_SH.name].indexOf($rootScope.data.step3.offerta.nomeOffertaCatalogo) >= 0) {        			
        			$scope.verificacompatibproftecnlineaprofilovc();
        		} else {
					//SM_10693
        			$state.go($scope.checkNextStateVariazione());
        		}
        	}
        	
        } else {
        	 $state.go($scope.checkNextState());
        }
    };
    
    $scope.verificacompatibproftecnlineaprofilovc = function() { //RU_713
    	
    		var vcList = $rootScope.formData.data.step4.vcItems;
    		var list = [];
    		var idOffertaSelezionata = "";
    		
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta) {
    			idOffertaSelezionata = $scope.data.step3.offerta.idOfferta;
    		} else {
    			idOffertaSelezionata = $scope.data.idOffertaCatalogo;
    		}
    		
    		for(var i = 0; i < vcList.length; i++) {
    			
    			var vcObj = {
    				"VPI": null,
    				"VCI": null,
    				"tipoProfilo" : null
    			}
				vcObj.tipoProfilo = vcList[i].TIPOPROFILOVC.dft;
    			
    			//SM_8252
    			if( vcObj.VPI!= null && vcObj.VCI!=null){
    				vcObj.VPI = vcList[i].VPI.dft;
    				vcObj.VCI = vcList[i].VCI.dft;
    			}
    			
				list.push(vcObj);
    		}
    		
    		var obj = {
				"lavorazione": $scope.data.step1.causale_ordine,
			    "caratteristica": $scope.customizedOffer.offerTopDetails.CARATTERISTICA.dft,
				"profiloTecnicoLinea": $scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft,
				"VC": list,
				"idAsset": $rootScope.formData.assetDetail.idAsset,	
				"idOfferta": idOffertaSelezionata
		    };
		    	
		    	VerificaCompatibilitaProfiloVc.save(obj, function (response) {
		   		 
			        if (response.esito == "OK") {
			        	$state.go($scope.checkNextStateVariazione());			        	
			        } else {

			        	$log.debug("Errore Verifica Compatibilita Profilo Tecnico Linea Profilo Vc");
			    	 	$scope.noSelectedOffers = false;
			    	 	
			        	modalService.showModal({}, {
			    			headerText: "Verifica Compatibilita' profilo VC",
			    			closeButtonText: '',
			    			bodyText: "La Verifica Compatibilità Profilo Tecnico Linea Profilo VC non è andata a buon fine. Si prega di riprovare",
			    			actionButtonText: 'Chiudi',
			    			scope: $scope,
			    			type: 'error'
			    		});
			        }
			        
			     }, function () {
			    	 	
		    	 	$log.debug("Errore Verifica Compatibilita Profilo Tecnico Linea Profilo Vc");
		    	 	$scope.noSelectedOffers = false;
		    	 	
		        	modalService.showModal({}, {
		    			headerText: "Verifica Compatibilita' profilo VC",
		    			closeButtonText: '',
		    			bodyText: "Errore Verifica Compatibilita Profilo Tecnico Linea Profilo VC",
		    			actionButtonText: 'Chiudi',
		    			scope: $scope,
		    			type: 'error'
		    		});
		     });
    }
    
    //SM_8437
    $scope.checkAttivaAvantiProfiloVc = function(nuovo) {
    	if($rootScope.DettaglioAssetVC){
    		vcItems=$rootScope.DettaglioAssetVC.vcItems
	    	if( vcItems ){
	    		i=0;
	    		for(i=0;i<vcItems.length;i++){
	    			if( vcItems[i].IDPROFILOVC.dft != nuovo[i].IDPROFILOVC.dft){
	    				$scope.avantiAttivoProfiloVC = true;
	    				return
	    			}
	//    			else if( !!vcItems[i].CODICETD.dft) {
	//    				if(vcItems[i].CODICETD.dft != nuovo[i].CODICETD.dft){
	//    					$scope.avantiAttivoProfiloVC = true;
	//        				return
	//    				}
	//    				else{
	//        				$scope.avantiAttivoProfiloVC = false;
	//        			}
	//    			}
	//    			else if(!!vcItems[i].CODICEVP.dft){
	//    				if(vcItems[i].CODICEVP.dft != nuovo[i].CODICEVP.dft){
	//    					$scope.avantiAttivoProfiloVC = true;
	//        				return
	//    				}
	//    				else{
	//        				$scope.avantiAttivoProfiloVC = false;
	//        			}
	//    			}
	    			else{
	    				$scope.avantiAttivoProfiloVC = false;
	    			}
	    		}
	    	}
    	}
    		
    }
    //SM_8437
//    $scope.checkAttivaAvantiCodiceVP = function(nuovo) { 	
//    	if( $rootScope.DettaglioAssetVC.vcItems[0].CODICEVP.dft === nuovo ){
//    		$scope.avantiAttivoCodiceVP = false;
//    	}
//    	else{
//    		$scope.avantiAttivoCodiceVP = true;
//    	}
//    		
//    }
	//SM_8437
    $scope.$watch("data.step4.vcItems", function(newValue, oldValue) { //SM_8437
    	 $scope.checkAttivaAvantiProfiloVc(newValue);
    }, true);
    
//    $scope.$watch("data.step4.vcItems", function(newValue, oldValue) { //SM_8437
//   	 	$scope.checkAttivaAvantiCodiceVP(newValue);
//    }, true);
    
}]);
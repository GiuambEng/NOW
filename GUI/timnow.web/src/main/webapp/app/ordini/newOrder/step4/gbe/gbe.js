timnow.controller('gbe', ['$scope','alertService', '$state', '$rootScope', '$log', '$q', 'modalService', 'VCProfiles', 'VlanSvlanCvlan', 'VerificaCompatibilitaIntermediateAgent', function ($scope, alertService, $state, $rootScope, $log, $q, modalService, VCProfiles, VlanSvlanCvlan, VerificaCompatibilitaIntermediateAgent) {

    $scope.loadProfiloTecnicoLinea = false; 
    $scope.visualizzaSpinner = false;
    $scope.attivaSubmit = false;
    
    $scope.fnPopolaCVLANIDCallback = function(object, index) { //GN

		if($scope.data.step4 && $scope.data.step4.vcItems){
			  if(object && ($scope.data.step4.vcItems[index].SVLANCODE && $scope.data.step4.vcItems[index].SVLANCODE.dft) && !$scope.data.step4.vcItems[index].CVLANIDVLAN) {
				  $scope.data.step4.vcItems[index].codice_vlan = $scope.data.step4.vcItems[index].SVLANCODE.dft;
				  delete $scope.data.step4.vcItems[index].SVLANCODE;
				  $scope.data.step4.vcItems[index].CVLANID = object;
			  } 
			  else if(object && ($scope.data.step4.vcItems[index].SVLANCODE && $scope.data.step4.vcItems[index].SVLANCODE.dft) && $scope.data.step4.vcItems[index].CVLANIDVLAN) {
				  $scope.data.step4.vcItems[index].SVLANCODE.tipobanda = object.tipobanda;
				  $scope.data.step4.vcItems[index].SVLANCODE.tipocos = object.tipocos;
			  }
		}
    	
    }

    if($rootScope.data.step1.causale_ordine==='variazione'){
    	
    	if($rootScope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    	
    	if($rootScope.data.step3.opzioneVariazione === "Downgrade Fast"){
    		$scope.getCvlanBandProfile();
    	}
    		if($rootScope.data.step3.opzioneVariazione === "Cambio SLA"){
    		$rootScope.DettaglioChangeKO = true;
    	}
    	if($rootScope.DettaglioAssetVC && $rootScope.DettaglioAssetVC.vcItems){
    		$scope.IPoA = 0;
    		angular.forEach($rootScope.DettaglioAssetVC.vcItems, function(value) {
    			if(value.PROTOCOLLOPILA && value.PROTOCOLLOPILA.dft && value.PROTOCOLLOPILA.dft === 'IPoA'){
    				$scope.IPoA++;
    			}
    			
    			if((value.SVLANCODE && value.SVLANCODE.dft) && !value.CVLANIDVLAN){
    				value.codice_vlan = value.SVLANCODE.dft;
    				value.SVLANCODE.dft = "";
    			}
    		});
    		if($rootScope.DettaglioAssetVC.vcItems.length === $scope.IPoA){
    			$scope.IPoActive = "IPoA";
    		} else {
    			if($scope.IPoActive){
    				delete $scope.IPoActive;
    			}
    		}
    		
    	}
    	if($scope.data.step4 && $scope.data.step4.vcItems){
		   angular.forEach($scope.data.step4.vcItems, function(value, index) {
	           if(value.SVLANCODE) {
		           $scope.popolaCVLANID(value.SVLANCODE.dft, $scope.fnPopolaCVLANIDCallback, index); //GN
	           }
			   
		   });
		}
    	$scope.getLineProfiles();
    }
    if(($rootScope.data.step1.causale_ordine==='attivazione') && ($rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING && !$rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING.dft)){
 	   $rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING.dft = "false";
    }
    if (!$rootScope.data.step4){
    	$rootScope.data.step4 = $scope.data.step4 = {};
    }
    																																																	//SM_8299
    if (($rootScope.bozza && $rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.MODULAZIONE && $rootScope.customizedOffer.offerTopDetails.MODULAZIONE.dft) || ($rootScope.MAP_OFFERTE.GBE_SF.id === $rootScope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.GBE_AF.id === $rootScope.data.step3.offerta.idOfferta) ) {
        $scope.getLineProfiles();
    }
    
//GET PROFILO VC
    $scope.getVCProfiles = function (tipologia) {
    	var protocollo = "";
        	if(($rootScope.MAP_OFFERTE && (($rootScope.MAP_OFFERTE.ATM_SF.id === $scope.data.step3.offerta.idOfferta) || ($rootScope.MAP_OFFERTE.ATM_SH.id === $scope.data.step3.offerta.idOfferta))) && $rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO){
        		protocollo = $rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft
        	}
        VCProfiles.get({
            idOfferta: $scope.data.step3.offerta.idOfferta,
            tipoprofilovc: tipologia,
            protocollo: protocollo,
            profilotecnicolinea:$scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft
        }).$promise.then(
            function (response) {
                $rootScope.formData.ProfiliVC = response.data;
                $scope.errorVC = false;
            }, function (error) {
                $log.debug(error);
                $scope.errorVC = "Impossibile caricare i Profili VC. Riprovare più tardi";
                $log.debug("Impossibile caricare i Profili VC. Riprovare più tardi");
                $scope.errorVC = true;
            });
    };

//	PROFILOTECNICOLINEA
    $scope.configurazioneOffertaCallbackProfilotecnicoLineaGBE = function (item) {

        if (!$scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA) {
            $scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA = {};
            $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA = {};
        }

        $scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft = item.profiloTecnicaLinea;
        $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft = item.profiloTecnicaLinea;
        $rootScope.profiloCommercialeDown = item.profiloCommercialeDown;
        $rootScope.profiloCommercialeUp = item.profiloCommercialeUp;
        $scope.getVCProfiles($scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft);
        $scope.getCvlanBandProfile();
    };
    $scope.configurazioneOffertaGetProfiloTecnicoLineaGBE = function ($event) {
        $event.preventDefault();
        $scope.modalOptionsProfiloTecnicoLinea = {
            headerText: 'Seleziona il Profilo Tecnico Linea',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackProfilotecnicoLineaGBE',
            dataHeader: $scope.headerConfigurazioneProfiloTecnicaLinea,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.lineProfiles
        };

        modalService.showModal({}, $scope.modalOptionsProfiloTecnicoLinea);
    };
    // SERVIZI VC
    
    
//    MODALE VLAN
    $scope.searchAdvance = function(formModale) {
        if (!formModale) {
            $scope.erroreService("Inserire almeno un valore di ricerca");
            $log.debug("Inserire almeno un valore di ricerca");
        } else {
            $scope.conditions = [];
            var countInputValidi = 0;
            angular.forEach(formModale, function(value, key) {
                var condizione = {};

                if (value) {
                    countInputValidi++;
                }
                condizione['nome'] = key;
                condizione['operazione'] = "=";
                condizione['valore'] = value;
                condizione['tipo'] = "string";

                $scope.conditions.push(condizione);
            });
            if($scope.data.encapsulation === "Y"){
            	$scope.tipologiaRicerca = "doubletag";
            } else{
            	$scope.tipologiaRicerca = "singletag";
            }
            
            $scope.visualizzaSpinner = true;
            VlanSvlanCvlan.verifica({type:"searchVlanSvlan",
            	codOloAgcom: $rootScope.data.step1.operatore.codiceOLO,
                encapsulation:  $scope.tipologiaRicerca,
                service : $rootScope.data.step3.offerta.nomeOffertaCatalogo},{conditions : $scope.conditions}).$promise.then(function(response) {
                $rootScope.formData.vlans = "";
                if (response.result && response.result.code === "2") {
                    $scope.erroreService("Nessuna VLAN/SVLAN trovata in base ai criteri utilizzati.");
                } else {
                    if (response) {
                        //$log.info(response);
                        $rootScope.formData.vlans = response.data;
                        $scope.modalVlan($scope.returnSearch);
                    } else {
                        $rootScope.formData.vlans = "";
                        $scope.erroreService("Nessuna VLAN/SVLAN trovata in base ai criteri utilizzati.");
                    }
                }
                $scope.visualizzaSpinner = false;
            }, function(error) {
            	$rootScope.formData.vlans = "";
                    $scope.erroreService("Impossibile caricare VLAN/SVLAN. Riprovare più tardi");
                    $log.debug("Impossibile caricare VLAN/SVLAN. Riprovare più tardi");
                $scope.visualizzaSpinner = false;
            });
        }
    };
	
    $scope.modalVlan = function(callback){
    	$scope.returnSearch = callback;
        $scope.headerGetAnagraficaVLAN = [
            {"key": "codicevlan", "value": "Codice VLAN", "type": "text"},
            {"key": "nomecentrale", "value": "Nome Centrale", "type": "text"},
            {"key": "nome", "value": "Nome", "type": "text"},
            {"key": "clli", "value": "CLLI", "type": "text", "sort": "number"},
            {"key": "idvlanolo", "value": "ID Vlan OAO", "type": "text", "sort": "number"}
        ];
        $scope.inputSearch = [
            {"key": "cod_vlan", "label": "Codice VLAN"},
            {"key": "nome", "label": "Nome"},
            {"key": "clli", "label": "CLLI"},
            {"key": "id_vlan_olo", "label": "ID Vlan OLO"}
            ];

            $scope.modalOptionsTabellaConfigurazioneOffertaAnagraficaVLAN = {
                headerText: 'Seleziona un elemento',
                actionButtonText: null,
                closeButtonText: 'Ok',
                contentType: 'modale_nowtable_search',
                scope: $scope,
                callbackFunction: callback,
                search: 'searchAdvance',
                dataSearch: $scope.inputSearch,
                dataHeader: $scope.headerGetAnagraficaVLAN,
                data: $rootScope.formData.vlans
            };
            modalService.showModal({}, $scope.modalOptionsTabellaConfigurazioneOffertaAnagraficaVLAN);
    };

    $scope.configurazioneOffertaGetAnagraficaVLANGBE = function ($event, itemNum) {
    	$rootScope.formData.vlans = "";
        $rootScope.numItemForModalCallback = itemNum;
        $event.preventDefault();
        $scope.data.encapsulation = 'N';
        $scope.modalVlan("configurazioneOffertaCallbackAnagraficaVLANGBE");
    };

    $scope.configurazioneOffertaGetAnagraficaSVLANGBE = function ($event, itemNum) {
    	$rootScope.formData.vlans = "";
        $rootScope.numItemForModalCallback = itemNum;
        $event.preventDefault();
        $scope.data.encapsulation = 'Y';
        $scope.modalVlan("configurazioneOffertaCallbackAnagraficaSVLANGBE");
    };

    $scope.configurazioneOffertaGetAnagraficaSVLANGBESIMMETRICO = function ($event, itemNum) {
    	$rootScope.formData.vlans = "";
        $rootScope.numItemForModalCallback = itemNum;
        $event.preventDefault();
        $scope.data.encapsulation = 'Y';
        $scope.modalVlan("configurazioneOffertaCallbackAnagraficaSVLANGBESIMMETRICO");
    };
    
    $scope.configurazioneOffertaCallbackAnagraficaVLANGBE = function (item) {
        angular.forEach($scope.data.step4.vcItems, function (vcItem) {
            if (vcItem.id === $rootScope.numItemForModalCallback) {
            	$scope.svuotaVLAN(vcItem);
                vcItem.CVLANID = {};
                vcItem.codice_vlan = item.codicevlan;
                vcItem.CVLANID.tipobanda = item.tipobanda;
                vcItem.CVLANID.tipocos = item.tipocos;
            }
        });
    };
    $scope.configurazioneOffertaCallbackAnagraficaSVLANGBE = function (item) {
        angular.forEach($scope.data.step4.vcItems, function (vcItem) {
            if (vcItem.id === $rootScope.numItemForModalCallback) {
            	$scope.svuotaVLAN(vcItem);
                vcItem.SVLANCODE = {};
                vcItem.SVLANCODE.dft = item.codicevlan;
                vcItem.SVLANCODE.tipobanda = item.tipobanda;
                vcItem.SVLANCODE.tipocos = item.tipocos;
            }
        });
    };

    $scope.headerConfigurazioneOffertaBMD = [
            {"key": "bp2", "value": "BP2", "type": "text"},
            {"key": "bp3", "value": "BP3", "type": "text"},
            {"key": "bp5", "value": "BP5", "type": "text"},
            {"key": "bp6", "value": "BP6", "type": "text"},
            {"key": "profilo", "value": "Profilo", "type": "text"},
            {"key": "bp2Max", "value": "BP2MAX", "type": "text"},
            {"key": "bp3Max", "value": "BP3MAX", "type": "text"},
            {"key": "bp5Max", "value": "BP5MAX", "type": "text"},
            {"key": "bp6Max", "value": "BP6MAX", "type": "text"}

    ];
    $scope.configurazioneOffertaGetBMD = function ($event, itemNum) {
        $event.preventDefault();
        $rootScope.numItemForModalCallback = itemNum;
        $scope.modalOptionsTabellaConfigurazioneOffertaBMD = {
            headerText: 'Seleziona un Codice BMD',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackBMD',
            dataHeader: $scope.headerConfigurazioneOffertaBMD,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.profiliBandaCvlan
        };
        modalService.showModal({}, $scope.modalOptionsTabellaConfigurazioneOffertaBMD);
    };


    $scope.configurazioneOffertaCallbackBMD = function (item) {
        angular.forEach($scope.data.step4.vcItems, function (vcItem) {
            if (vcItem.id === $rootScope.numItemForModalCallback) {
                vcItem.PROFILOBMD.dft = item.profilo;
            }
        });
    };
    $scope.ControlloVcInConsistenzaMod = function(){
    	var eliminati = 0;
    	if(($rootScope.data.step3.opzioneVariazione === 'Incremento/decremento VC')
            && ($scope.data.step4.vcItems
                && $rootScope.DettaglioAssetVC
                && $rootScope.DettaglioAssetVC.vcItems
                && ($scope.data.step4.vcItems.length === $rootScope.DettaglioAssetVC.vcItems.length))){
    		angular.forEach($scope.data.step4.vcItems, function (vcItem) {
                if (vcItem.ELIMINA && vcItem.ELIMINA.dft) {
                	eliminati = eliminati + 1;
                } 
            });
    	} else if(($rootScope.data.step3.opzioneVariazione === 'Incremento/decremento UserVLan')
            && ($scope.data.step4.vlanusers
                && $rootScope.DettaglioAssetUSER
                && $rootScope.DettaglioAssetUSER.vlanusers
                &&  ($scope.data.step4.vlanusers.length === $rootScope.DettaglioAssetUSER.vlanusers.length))){
    		angular.forEach($scope.data.step4.vlanusers, function (vlanusers) {
                if (vlanusers.ELIMINA && vlanusers.ELIMINA.dft) {
                	eliminati = eliminati + 1;
                }
            });
    	} else {
    		eliminati = eliminati + 1;
    	}
    	if(eliminati > 0) {
    		$scope.attivaSubmit = true;
    	}
    };
    if(($rootScope.data.step1.causale_ordine==='variazione')
        && ($rootScope.data.step3.opzioneVariazione === 'Incremento/decremento VC')){
    	$scope.attivaSubmit = false;
    	$scope.ControlloVcInConsistenzaMod();
    }
//	------->		PASSAGGIO A STEP 5
    $scope.submit_4 = function () {
    	$scope.controlloBozza(5);
    	if($rootScope.data.step3.opzioneVariazione === 'Cambio SLA'){
    		$state.go($scope.checkNextStateVariazione());
    	} else {
    		$scope.verificaConfigurazioneOfferta($scope.data.step3.tipologia_ordine);}
     };

    $scope.salvaConfigurazioneOfferta = function () {
        $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
        
        if(($rootScope.data.step1.causale_ordine === 'variazione') && !$scope.data.step4.idTicketTTM){
        	$state.go($scope.checkNextStateVariazione());
        } else if(($rootScope.data.step1.causale_ordine === 'variazione') && $scope.data.step4.idTicketTTM){
        	if($rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft === $rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA.dft){
        		$scope.erroreService("Per la variazione selezionata è necessario modificare il Profilo Tecnico Linea");
        	} else {
        		//SM_10693
        		$state.go($scope.checkNextStateVariazione());
        	}
        } else {
        	 $state.go($scope.checkNextState());
        }
    };
      
    $scope.verificaProtocolloPila = function () {
	    if ($scope.data.step4.vcItems
            && ($scope.data.step4.vcItems[0].PROTOCOLLOPILA
                && ($scope.data.step4.vcItems[0].PROTOCOLLOPILA.dft === "IPoA"))) {
	    	for (var i = 1; i < $scope.data.step4.vcItems.length; i++) {
	    		if($scope.data.step4 && $scope.data.step4.vcItems[i]
                    && $scope.data.step4.vcItems[i].PROTOCOLLOPILA
                    && $scope.data.step4.vcItems[i].PROTOCOLLOPILA.dft!=="IPoA"){
	        		return false;
	        	}
	        }
	    } else if ($scope.data.step4.vlanusers
                    && ($scope.data.step4.vlanusers[0].PROTOCOLLOPILA
                        && ($scope.data.step4.vlanusers[0].PROTOCOLLOPILA.dft === "IPoA"))) {
	    	for (var j = 1; j < $scope.data.step4.vlanusers.length; j++) {
	    		if($scope.data.step4
                    && $scope.data.step4.vlanusers[j]
                    && $scope.data.step4.vlanusers[j].PROTOCOLLOPILA
                    && $scope.data.step4.vlanusers[j].PROTOCOLLOPILA.dft!=="IPoA"){
	        		return false;
	        	}
	        }
	    }
	    
	    return true;

    };
    
    $scope.checkUniqueVpiVci = function () {
        var ar = [];

        angular.forEach($scope.data.step4.vcItems,
            function (value) {
                ar.push(value.VPI.dft + '-'
                + value.VCI.dft);
            }
        );

        ar.sort();
        for (var i = 1; i < ar.length; i++) {
            if (ar[i - 1] === ar[i]) {
                return false;
            }
        }
        return true;
    };
    $scope.checkUniqueSvlanCvlan = function () {
        var lista = [];
        var found=false;
        
        angular.forEach(
            $scope.data.step4.vcItems,
            function (value, key) {
                if (value.SVLANCODE && value.CVLANIDVLAN && value.CVLANIDVLAN.dft) {
                	if(value.AZIONE && value.AZIONE.dft){
                		var azioneMod = value.AZIONE.dft;
                	}
                    lista.push({SVLanCode:value.SVLANCODE.dft,CVLanId:value.CVLANIDVLAN.dft, azione: azioneMod});
                }
            }
        );
        // controllo duplicati nella pagina
        for (var i = 0; i < lista.length; i++){
	        for (var j=0; j<i; j++){
		        if (lista[i].SVLanCode === lista[j].SVLanCode && lista[i].CVLanId === lista[j].CVLanId){
		        	alertService.add("Le coppie Codice SVLAN / CVLan Code del VC "+(i+1)+" devono essere differenti a quelle del VC "+(j+1),"danger",20000);
		        	found=true;
		        } 
	        }
        }
        if(!found){
        	// controllo duplicati sul DB
        	VlanSvlanCvlan.verifica({type:"verify"},{
            	svlancvlan : lista,
            	lavorazione: $rootScope.data.step1.causale_ordine
            }).$promise.then(function(response) {
            	for (i = 0; i < response.data.length; i++){
    		        if (response.data[i].esito === 'KO'){
    		        	alertService.add("I valori Codice SVLAN / CVLan Code del VC "+(i+1)+" sono già stati utilizzati in precedenza","danger",20000);
    		        	found=true;
    		        }
            	}
            	if(!found){
            		$scope.salvaConfigurazioneOfferta();
            	}else{
            		return false;
            	}
            }, function(error) {
                    $log.debug(error);
                    return false;
            });
        }else{
        	return false;
        }
    };
    
    $scope.verificaCos = function () {
        var tipoBandaPrecedente = false;
        for (var i = 0; i < $scope.data.step4.vcItems.length; i++) {
    		if((tipoBandaPrecedente && $scope.data.step4.vcItems[i].CVLANID && !!$scope.data.step4.vcItems[i].CVLANID.tipobanda && $scope.data.step4.vcItems[i].CVLANID.tipobanda!==tipoBandaPrecedente)|| //GN aggiunta condizione tipobanda !undefined
    		        (tipoBandaPrecedente && $scope.data.step4.vcItems[i].SVLANCODE && !!$scope.data.step4.vcItems[i].SVLANCODE.tipobanda && $scope.data.step4.vcItems[i].SVLANCODE.tipobanda!==tipoBandaPrecedente))    { //GN
        		return false;
        	}
    		if($scope.data.step4.vcItems[i].CVLANID && $scope.data.step4.vcItems[i].CVLANID.tipobanda){
    			tipoBandaPrecedente= $scope.data.step4.vcItems[i].CVLANID.tipobanda;
    		}else if($scope.data.step4.vcItems[i].SVLANCODE && $scope.data.step4.vcItems[i].SVLANCODE.tipobanda){
    			tipoBandaPrecedente= $scope.data.step4.vcItems[i].SVLANCODE.tipobanda;
        	}
        }
        return true;
    };
    
    $scope.svuotaDslamKit = function (vcItem) {
    	if(vcItem){
    		vcItem.dslam_ip_1= null;
    		vcItem.dslam_ip_2= null;
    		vcItem.dslam_ip_3= null;
    		vcItem.dslam_ip_4= null;
    		vcItem.kit_ip_1= null;
    		vcItem.kit_ip_2= null;
    		vcItem.kit_ip_3= null;
    		vcItem.kit_ip_4= null;
    	}
    };
    
    $scope.svuotaVLAN = function (vcItem) {
    	if(vcItem){
    		$scope.svuotaDslamKit(vcItem);
    		vcItem.codice_vlan = null;
		if (vcItem.CVLANID) {
            vcItem.CVLANID = {};
        }
        if((vcItem.PROTOCOLLOPILA)
              && (($rootScope.MAP_OFFERTE.GBE_AF.id === $rootScope.data.step3.offerta.idOfferta)
              && ($rootScope.data.step3.opzioneVariazione !== 'Riconfigurazione Accesso')) ||
          (($rootScope.MAP_OFFERTE.GBE_AF.id !== $rootScope.data.step3.offerta.idOfferta)
              && ($rootScope.data.step3.opzioneVariazione !== 'Riconfigurazione Accesso')) ||
          (($rootScope.MAP_OFFERTE.GBE_AF.id !== $rootScope.data.step3.offerta.idOfferta)
              && ($rootScope.data.step3.opzioneVariazione === 'Riconfigurazione Accesso'))) {
            vcItem.PROTOCOLLOPILA.dft = "";
        }
		 if (vcItem.SVLANCODE) {
             vcItem.SVLANCODE.dft = "";
             vcItem.SVLANCODE.tipobanda = "";
         }
         if (vcItem.PROFILOBMD) {
             vcItem.PROFILOBMD.dft = "";
         } else {
             vcItem.PROFILOBMD = {};
             vcItem.PROFILOBMD.dft = "";
         }
         if (vcItem.CVLANIDVLAN) {
             vcItem.CVLANIDVLAN.dft = "";
         } else {
             vcItem.CVLANIDVLAN = {};
             vcItem.CVLANIDVLAN.dft = "";
         }
      }
   };
   
   $scope.checkNextStep = function(){
       $scope.caricaPassFive=false;
       if ($scope.erroriConfigurazioneOfferta.length) {
           return;
       }
       else {
       	// C11M02F37 Verifica Univocità Codice SVLAN e CVLan Code - parte client (verifica univocità in uscita tra i vc)
           if ($rootScope.data.step3.opzioneVariazione !== 'Downgrade Fast' && $rootScope.data.step3.opzioneVariazione !== 'Cambio SLA') {
           	$scope.checkUniqueSvlanCvlan();
           }else{
           	$scope.salvaConfigurazioneOfferta();
           }
       }
   } 
    
    $scope.verificaConfigurazioneOfferta = function () {
        $scope.erroriConfigurazioneOfferta = [];

        // C11M02F38 Verifica Univocità VPI e VCI
        if ($rootScope.MAP_OFFERTE.GBE_SF.id !== $rootScope.data.step3.offerta.idOfferta
            && !$scope.checkUniqueVpiVci()
            && ($rootScope.data.step3.opzioneVariazione !== 'Downgrade Fast')
            &&  ($rootScope.data.step3.opzioneVariazione !== 'Cambio SLA')) {
            $scope.erroriConfigurazioneOfferta.push({
                error: '1',
                msg: "Le coppie di valori VPI/VCI devono essere differenti per ogni VC."
            });
        }
        
        // C11M08F29 - Verifica Protocollo Pila
        if ($rootScope.MAP_OFFERTE.GBE_SF.id !== $rootScope.data.step3.offerta.idOfferta
            && !$scope.verificaProtocolloPila()
            && ($rootScope.data.step3.opzioneVariazione !== 'Downgrade Fast')
            &&  ($rootScope.data.step3.opzioneVariazione !== 'Cambio SLA')) {
            $scope.erroriConfigurazioneOfferta.push({
                error: '2',
                msg: "Il Protocollo Pila del primo VC è IPoA: tutti gli altri VC devono avere lo stesso valore per tale campo"
            });
        }

        //C04M01F63 – Verifica COS
        if ($rootScope.MAP_OFFERTE.GBE_SF.id !== $rootScope.data.step3.offerta.idOfferta && !$scope.verificaCos()) {
            $scope.erroriConfigurazioneOfferta.push({
                error: '3',
                msg: "La verifica Cos ha dato esito Negativo"
            });
        }
        
        //RU_982
        //C11M08F69 - Verifica Compatibilità intermediate agent full    
        
        if($scope.RU_982){
            $scope.C11M08F69().then(function(data){
	        	if(data.VerificaCompatibilitaIntermediateAgentOutput.esito === 'KO'){        		
	                $scope.erroriConfigurazioneOfferta.push({
	                    error: '4',
	                    msg: data.VerificaCompatibilitaIntermediateAgentOutput.message
	                });
	        	}
        	},
	        function (error) {
	            // Error callback
	            $scope.erroriConfigurazioneOfferta.push({
	                error: '4',
	                msg: "Impossibile verificare compatibilità Intermediate Agent Full"
	            });
	        })
	        .finally(function(){
	        	$scope.checkNextStep();
	     });
        }else{
        	$scope.checkNextStep();
        }  

    };

    if(!$scope.customizedOffer.offerTopDetails.TIPOLINEA.dft && ($rootScope.data.step1.causale_ordine !== 'variazione')){
    	$scope.customizedOffer.offerTopDetails.TIPOLINEA.dft = 'LineaNonFonia';
    }
    
    $scope.utentiVlan = [{
        id: '1'
    }];
    
    $scope.eliminaVlanUser = function (vc, vcIndex) {
        vc.splice(vcIndex, 1);
        $scope.data.step4.vcItems = vc;
        $scope.ControlloVcInConsistenzaMod();
    };

    $scope.aggiungiVCIncDec = function (vc) {
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
        
        $scope.ControlloVcInConsistenzaMod();
    };

    $scope.abilitaAddVC = function () {
    		var totali=$scope.data.step4.vcItems.length;
        	return (totali < 3 );
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
    	if(vc.ELIMINA && vc.ELIMINA.dft){
    		vc.AZIONE = {};
    		vc.AZIONE.dft='C';
    	}else if(vc.AZIONE && vc.AZIONE.dft==='C'){
    		delete vc.AZIONE.dft;
    	}
    	$scope.ControlloVcInConsistenzaMod();
    };
    
    $scope.configurazioneOffertaGetBMDSIMMETRICO = function ($event, itemNum) {
        $event.preventDefault();
        $rootScope.numItemForModalCallback = itemNum;
        $scope.modalOptionsTabellaConfigurazioneOffertaBMD = {
            headerText: 'Seleziona un Codice BMD',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackBMDSIMMETRICO',
            dataHeader: $scope.headerConfigurazioneOffertaBMD,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.profiliBandaCvlan
        };
        modalService.showModal({}, $scope.modalOptionsTabellaConfigurazioneOffertaBMD);
    };


    $scope.configurazioneOffertaCallbackBMDSIMMETRICO = function (item) {
        angular.forEach($scope.data.step4.vlanusers, function (vlanusersItem) {
            if (vlanusersItem.id === $rootScope.numItemForModalCallback) {
            	vlanusersItem.PROFILOBMD.dft = item.profilo;
            }
        });
    };
    
    $scope.configurazioneOffertaCallbackAnagraficaSVLANGBESIMMETRICO = function (item) {
        angular.forEach($scope.data.step4.vlanusers, function (vlanusersItem) {
            if (vlanusersItem.id === $rootScope.numItemForModalCallback) {

            	//HD0000015093380 - Bug #31396 - start
            	vlanusersItem.codicevlan = item.codicevlan;
            	//HD0000015093380 - Bug #31396 - end
                if (vlanusersItem.SVLANCODE) {
                    vlanusersItem.SVLANCODE.dft = item.codicevlan;
                    vlanusersItem.SVLANCODE.tipobanda = item.tipobanda;
                    vlanusersItem.SVLANCODE.tipocos = item.tipocos;
                } else {
                    vlanusersItem.SVLANCODE = {};
                    vlanusersItem.SVLANCODE.dft = item.codicevlan;
                    vlanusersItem.SVLANCODE.tipobanda = item.tipobanda;
                    vlanusersItem.SVLANCODE.tipocos = item.tipocos;
                }
                if (vlanusersItem.PROFILOBMD) {
                    vlanusersItem.PROFILOBMD.dft = '';
                } else {
                    vlanusersItem.PROFILOBMD = {};
                    vlanusersItem.PROFILOBMD.dft = '';
                }
            }
        });
    };
    // USER
    $scope.aggiungiVlanUser = function (vlanusers) {
        $scope.data.step4.vlanusers = vlanusers;
        $scope.vcUser=vlanusers.length;
        $scope.vcUserID = vlanusers[vlanusers.length - 1].id;
        $scope.attivaSubmit = true;
     
        $scope.vcUserID++;
        $scope.vcUser++;
        
        $scope.data.step4.vlanusers.push({
            'id': $scope.vcUserID
        });
        
        if($rootScope.data.step1.causale_ordine === 'variazione'){
        	if(!$scope.data.step4.vlanusers[vlanusers.length - 1].AZIONE){
        		$scope.data.step4.vlanusers[vlanusers.length - 1].AZIONE={};
        	}
        	$scope.data.step4.vlanusers[vlanusers.length - 1].AZIONE.dft='A';
    	} 
    };

    $scope.abilitaAddUserVlan = function () {
    		var totaliModificate=0; 
    		var totali=$scope.data.step4.vlanusers.length;
    		if($scope.data.step4.variazione==='Variazione Tagging'){
	        	angular.forEach($scope.data.step4.vlanusers, function (user) {
	    			if ((user.ELIMINA && user.ELIMINA.dft) || (user.AZIONE && user.AZIONE.dft)){
	    				totaliModificate++;
	    			}
	    		});
	        	return (totali < 4 ) && (totaliModificate <= 4 );
    		}
        	return (totali < 4 );
    };
    
    $scope.abilitaEliminaUserVlan = function () {
    	var eliminati=1;
    	angular.forEach($scope.data.step4.vlanusers, function (user) {
			if (user.ELIMINA && user.ELIMINA.dft){
				eliminati++;
			}
		});
    	return ($scope.data.step4.vlanusers.length > eliminati );
    };
    
    $scope.eliminaUserVlanAzione = function (vlanuser) {
    	if(vlanuser.ELIMINA && vlanuser.ELIMINA.dft){
    		if(!vlanuser.AZIONE){
    			vlanuser.AZIONE={};
    		}
    		vlanuser.AZIONE.dft='C';
    	} else if(vlanuser.AZIONE && vlanuser.AZIONE.dft==='C'){
    		delete vlanuser.AZIONE.dft;
    	}
    	$scope.ControlloVcInConsistenzaMod();
    };
    $scope.eliminaVlanUser = function (vlanusers, vlanIndex) {
        vlanusers.splice(vlanIndex, 1);
        $scope.data.step4.vlanusers = vlanusers;
        if($scope.data.step4.vlanusers.length !== $rootScope.DettaglioAssetUSER.vlanusers.length){
        	$scope.attivaSubmit = true;
        } else {
        	$scope.attivaSubmit = false;
        }
        $scope.ControlloVcInConsistenzaMod();
    };

    $scope.eraseVlanUser = function (vlanusers, vlanlength) {
    	if($rootScope.data.step1.causale_ordine !== 'variazione'){
    		vlanusers.splice(1, vlanlength - 1);
    		vlanusers[0].id = "1";
    		vlanusers[0].uservlan = "";
    		$scope.data.step4.vlanusers = vlanusers;
    		
    		angular.forEach($scope.data.step4.vlanusers, function (user) {
    			if (user.USERVLANID){
    				user.USERVLANID.dft = "";
    			}
    		});
    	}else{
    		if($scope.data && $scope.data.step4 && $rootScope.DettaglioAssetUSER){
    			$scope.data.step4.vlanusers=angular.copy($rootScope.DettaglioAssetUSER);
    		}
    	}
    };
    
    //RU_982
    
    $scope.oscuramento_RU_982 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_982.oscurato){
    				$scope.RU_982 = ($rootScope.OSCURAMENTI.RU_982.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_982 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_982 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_982();
    
    $scope.C11M08F69 = function(){
    	
    	var _request = {
    			idOfferta: $scope.data.step3.offerta.idOfferta,
    			lavorazione: $scope.data.step1.causale_ordine,
    			encapsulation: null,
    			intermediateAgentFull: null,
    			svlanCodes: [],
    			cvlanCodes: [],			
    			idAsset: ($scope.data.step2.idAssetScelto ? $scope.data.step2.idAssetScelto.idAsset : undefined)
    	};
    	
    	//Estrazione codici CVLAN o SVLAN
    	if($scope.data.step4.vcItems && $scope.data.step4.vcItems.length > 0){
    		var _app = angular.copy($scope.data.step4.vcItems);
			_app.forEach(function(lan){	
				
				//Se è popolato SVLANCODE, devo controllare che CVLANIDVLAN sia valido 
				//e creare un oggetto con lo stesso id sia per svlan che cvlan 
				if(lan.CVLANIDVLAN && lan.CVLANIDVLAN.dft){
					 _request['cvlanCodes'].push({
						 id: lan.id,
						 value: lan.CVLANIDVLAN.dft
					 }); 
	   				 _request['svlanCodes'].push({
						 id: lan.id,
						 value: lan.SVLANCODE.dft
					 });
				}
				//altrimenti solo per cvlan				
				else if(lan && lan.codice_vlan && lan.codice_vlan !== ""){
					 _request['cvlanCodes'].push({
						 id: lan.id,
						 value: lan.codice_vlan
					 });
				}
			});
    	}  	    
    	
    	if(!$scope.disableIntermediateAgentFull){
    		_request.intermediateAgentFull = ($scope.customizedOffer.offerTopDetails.INTERMEDIATEAGENTFULL ? $scope.customizedOffer.offerTopDetails.INTERMEDIATEAGENTFULL.dft : undefined);
    	}
    	
    	return VerificaCompatibilitaIntermediateAgent.save({}, _request).$promise; 
    };
    
    
    
    //SM_9329
    $scope.enableDisableAvanti = function(){    	
    	if($scope.data.step1.causale_ordine==='variazione'){
    		$scope.avantiAttivo = false;
        	
        	//Verifica parametri principali
        	if($scope.DettaglioAsset.offerTopDetails && $scope.customizedOffer.offerTopDetails){
        		var _keys = Object.keys($scope.DettaglioAsset.offerTopDetails);
        		if(_keys){
        			_keys.forEach(function(key, index){
        				if($scope.DettaglioAsset.offerTopDetails[key].dft != $scope.customizedOffer.offerTopDetails[key].dft){
        					$scope.avantiAttivo = true;
        					return;
        				}   				
        			});
        		}    		
        	}    
        	
        	//HD0000015093380 - Bug #31396 - start
        	if(!$scope.DettaglioAssetVC) {
        		$scope.DettaglioAssetVC = {};
        		$scope.DettaglioAssetVC.vcItems = $rootScope.data.step4.vlanusers;
        	}
        	//HD0000015093380 - Bug #31396 - end
        	
        	//Verifica parametri VLAN
        	if($scope.DettaglioAssetVC.vcItems && $scope.data.step4.vcItems){
        		var _dettaglioAssetVC = $scope.DettaglioAssetVC.vcItems;
        		var _VC = $scope.data.step4.vcItems;
        		
        		_dettaglioAssetVC.forEach(function(vc, index){    			
        			var _keys = Object.keys(vc);
        			if(_keys){
        				_keys.forEach(function(key){
        					if(key === 'codice_vlan' && (vc[key] && _VC[index][key]) && vc[key] != _VC[index][key]){
            					$scope.avantiAttivo = true;
            					return;
        					}
        					if(vc[key].dft && _VC[index][key].dft && vc[key].dft != _VC[index][key].dft){
            					$scope.avantiAttivo = true;
            					return;
        					}    					
        				});
        			}    			
        		});    		
        	}
    	}
    }
    
    $scope.$watch("customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft", function(newValue, oldValue){
    	if(newValue != oldValue){
    		$scope.enableDisableAvanti();
    	}    	
    });
    
    $scope.$watch("data.step4.vcItems", function(newValue){
    	if(newValue){
    		$scope.enableDisableAvanti();
    	}
    }, true);
    
    //HD0000015093380 - Bug #31396 - start
    $scope.$watch("data.step4.vlanusers", function(newValue, oldValue){
    	if(newValue != oldValue){
    		$scope.avantiAttivo = true;
    	}
    }, true);
    //HD0000015093380 - Bug #31396 - end
    
    $scope.enableDisableAvanti();

}]);
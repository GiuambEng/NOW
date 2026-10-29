timnow.controller('nga-vula', ['$scope', '$state', '$rootScope', '$log', '$q', 'modalService', 'LineProfiles', 'VlanSvlanCvlan', 'BandsProfileNewOrder', 'Bands', 'VerificaCodiceProgettoOneStep', 'VerificaCompatibilitaIntermediateAgent', 'verificaTicketTTM', 'VerificaOrdineVariazioneDowngradeFast', '_', 'ControlliServiceStep4', 'VerificaCongruenzaDRGOfferta','VerificaAttivazioneFullGponPlus', 'Orders', 'NewOrderControlliService', 'GetCodiceOperatoreSecondario', 'NewOrderControlliService', 'PARENTAL_CONTROL_MAP',   
    function ($scope, $state, $rootScope, $log, $q, modalService, LineProfiles, VlanSvlanCvlan, BandsProfileNewOrder, Bands, VerificaCodiceProgettoOneStep, VerificaCompatibilitaIntermediateAgent, verificaTicketTTM, VerificaOrdineVariazioneDowngradeFast, _, ControlliServiceStep4, VerificaCongruenzaDRGOfferta, VerificaAttivazioneFullGponPlus, Orders, NewOrderControlliService, GetCodiceOperatoreSecondario, NewOrderControlliService, PARENTAL_CONTROL_MAP) {
    $scope.vcUser = 1;
    $scope.visualizzaSpinner = false;
    $scope.LoadBandaPicco = false;
    $scope.changeInputOK = false;
    $scope.tipoBandaConsistenza= false;
    
    $scope.causaleOrdine = ($rootScope.data.step1.causale_ordine || $scope.data.step1.causale_ordine);
    $scope.opzioneVariazione = ($scope.data.step3.opzioneVariazione || null);
    
    $scope.parentalControlMap = PARENTAL_CONTROL_MAP;
    
    

    $scope.ripristinaProfiloTecnicoLinea= function () {
        if($rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft && ($rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA.dft !== $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft)){
              $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft = $rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA.dft;
        }
    };

    if($rootScope.bozza && $rootScope.bozza.data && $rootScope.bozza.data.step4 && $rootScope.bozza.data.step4.vlanusers) {
        angular.forEach($rootScope.bozza.data.step4.vlanusers, function(value, key){

            if(value.banda_picco && value.banda_picco.up){
               value.BANDAPICCOUP['dft'] = value.banda_picco.up;
           }
           if(value.banda_picco && value.banda_picco.down){
               value.BANDAPICCODOWN['dft'] = value.banda_picco.down;
           }
        });

    }
    if (($scope.causaleOrdine !== 'variazione') && (!$rootScope.customizedOffer.offerTopDetails.TIPOLINEA && !$rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft)){
		$rootScope.customizedOffer.offerTopDetails.TIPOLINEA = {};
    	$rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft = 'LineaNonFonia';
    }
    /**
     * SLA CHANGE
     * @returns {boolean}
     * @constructor
     */
    $scope.ControlSLAChange = function(){
    	$scope.changeInputOK = ($rootScope.customizedOffer.offerTopDetails.SLAASSURANCE.dft !== $rootScope.DettaglioAsset.offerTopDetails.SLAASSURANCE.dft);
    };

	/**
     * PARENTAL_CONTROL CHANGE (RU_1614)
     * @returns {boolean}
     * @constructor
     */
    $scope.ControlParentalControlChange = function(){
    	var customizedValue = $rootScope.customizedOffer && $rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.PROFILO ? $rootScope.customizedOffer.offerTopDetails.PROFILO.dft : null;
    	var dettaglioValue = $rootScope.DettaglioAsset && $rootScope.DettaglioAsset.offerTopDetails && $rootScope.DettaglioAsset.offerTopDetails.PROFILO ? $rootScope.DettaglioAsset.offerTopDetails.PROFILO.dft : null;
    	$scope.changeInputOK = (customizedValue !== dettaglioValue);
    	$scope.ControlloAvantiAttivo(dettaglioValue, customizedValue);
    };

    if(($scope.causaleOrdine==='attivazione') && ($rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING && !$rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING.dft)){
	 	   $rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING.dft = "false";
	    }
    if($scope.causaleOrdine==='variazione' && $scope.opzioneVariazione !== 'Riconfigurazione UserVLAN'){
    	$scope.getCvlanBandProfile();
    	if($rootScope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    	if($scope.opzioneVariazione === 'Cambio SLA'){
            $scope.ControlSLAChange();
    	}
    	if(!$rootScope.data.step4.variazione){
    		$rootScope.data.step4.variazione = "Profilo Tecnico Linea";
    	}
    	
    	if($scope.opzioneVariazione === 'Riconfigurazione Accesso' && $rootScope.DettaglioAssetUSER!==undefined && ([$rootScope.MAP_OFFERTE.NGA_H.name,$rootScope.MAP_OFFERTE.NGA_CAB.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0)){
    		angular.forEach($rootScope.DettaglioAssetUSER.vlanusers,
                    function (ITEM) {
    			//controllo dato da Ilario 
                        if (ITEM.PROFILOBMD && ITEM.PROFILOBMD.dft) {
                        	$scope.tipoBandaConsistenza = true;
                        }
                    }
                );
    	}
    }
    if($scope.causaleOrdine==='variazione' && $scope.opzioneVariazione === 'Riconfigurazione UserVLAN'){
    	$scope.getCvlanBandProfile();
    	if($rootScope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    }
    // funzione per variazione 'Riconfigurazione UserVLAN' svuoto o inizializzo USERVLAN1
    $scope.variazioneUserVlan = function(init){
    		$scope.changeInputOK=false;
    		if($rootScope.data.step4 && !$rootScope.data.step4.variazione){
    			$rootScope.data.step4.variazione='Variazione Tagging'; 
        	}else{
        		if($scope.data.step4.variazione === "Variazione Numero User VLAN" && (!($rootScope.DettaglioAsset && $rootScope.DettaglioAsset.offerTopDetails && $rootScope.DettaglioAsset.offerTopDetails.USERVLAN1TAGGING) || $rootScope.DettaglioAsset.offerTopDetails.USERVLAN1TAGGING.dft==="Untagged")){
            		$scope.erroreService("Incremento/Decremento Numero UserVlan non compatibile con il Servizio.");
            		$scope.changeInputOK=true;
            	}
        		
        		if($scope.data.step4.variazione === "Variazione Numero User VLAN" && ($rootScope.DettaglioAsset && $rootScope.DettaglioAsset.offerTopDetails && $rootScope.DettaglioAsset.offerTopDetails.USERVLAN1TAGGING && $rootScope.DettaglioAsset.offerTopDetails.USERVLAN1TAGGING.dft==="Tagged")){
        			$rootScope.customizedOffer.offerTopDetails.USERVLAN1TAGGING.dft="Tagged";
        			
        			 $scope.changeInputOK = $scope.verificaEliminaUserVlan();
        			 
        			 //SM_10740
        			 angular.forEach($rootScope.DettaglioAssetUSER.vlanusers,
            			function (vlan) {
   							$scope.setUserVlanMulticast(vlan);
             			}
        			);
        			if(!$rootScope.formData.profiliBandaCvlan || $rootScope.formData.profiliBandaCvlan.length === 0){
        				$scope.getCvlanBandProfile();
        			}
        			if($scope.data && $scope.data.step4 && $scope.data.step4.vlanusers){
        				angular.forEach($scope.data.step4.vlanusers, function(vlan) {
        					if(vlan.PROFILOBMD && vlan.PROFILOBMD.dft !== undefined && vlan.PROFILOBMD.dft !== null){
        						vlan.PROFILOBMD.dft = '' + vlan.PROFILOBMD.dft;
        					}
        				});
        			}
            	}
        	}
        	//SM_11048
    		/*if($scope.data && $scope.data.step4 && $rootScope.DettaglioAssetUSER && init){
    			$scope.data.step4.vlanusers=angular.copy($rootScope.DettaglioAssetUSER.vlanusers);
    		}*/
    		
    };   
    /* Apertura Accordion VLAN */
    $scope.apriVlan = function (form) {
    	if(form){
    		var forms = [form];
        angular.forEach(forms, function (formItem) {
            var open = true;
            angular.forEach(formItem.$error.required,
                function (field) {
                    if (field.$invalid) {
                        open = false;
                    }
                }
            );
            if (open) {
                $scope.datiVlanView = [false, true];
            } else {
                $scope.datiVlanView = [true, false];
            }
        }
    );}
        
    };
    
    
    $scope.utentiVlan = [{
        id: '1'
    }];
    
    $scope.resetUtentiVlan = function (vu) {
        if ($scope.firstProvaReset) {
            $scope.firstProvaReset = false;
        } else {
            angular.forEach(vu,
                function (v, key) {
                    if (v.id === 1) {
                        v.banda_picco = '';
                        v.codice_svlan = '';
                        $scope['user' + v.id + '_banda_picco_upstream'] = "";
                    } else {
                        vu.splice(1, vu.length - 1);
                    }
                }
            );
        }
    };

    //SM_8445
    $scope.resetUtentiVlanVariazioneSubFunc = function () {
    	var _vlans = $scope.data.step4.vlanusers;
    	
    	var _appVlans = [];
    	
    	//SM_10322
    	/*
    	 * Incaso di variazione Accesso, se esistono delle UserVLAN con FLAG MULTICAST, 
    	 * non devono essere azzerate ne rese editabili
    	 * */
    	if(_vlans && _vlans.length > 0){
    		_vlans.forEach(function(item, index){
    			if(!item.FLAGMULTICAST){
    				_appVlans.push({id: item.id});
    			}else{
    				_appVlans.push(item);
    			}
    		});
    		
    		$scope.data.step4.vlanusers = _appVlans;
    	}
    	
    }
  
    
    $scope.setUpstream = function (banda_picco, uid) {
        var bp = JSON.parse(banda_picco);
        $scope['user' + uid + '_banda_picco_upstream'] = bp.up;
    };

    $scope.aggiungiVlanUser = function (vlanusers) {
        $scope.data.step4.vlanusers = vlanusers;
        $scope.vcUser=vlanusers.length;
        $scope.vcUserID = vlanusers[vlanusers.length - 1].id;
     
        $scope.vcUserID++;
        $scope.vcUser++;
        
        $scope.data.step4.vlanusers.push({
            'id': $scope.vcUserID
        });
        
        if($scope.causaleOrdine === 'variazione'){
        	if(!$scope.data.step4.vlanusers[vlanusers.length - 1].AZIONE){
        		$scope.data.step4.vlanusers[vlanusers.length - 1].AZIONE={};
        	}
        	$scope.data.step4.vlanusers[vlanusers.length - 1].AZIONE.dft='A';
    	} 
        
        $scope.changeInputOK = true;
    };

    $scope.abilitaAddUserVlan = function () {
    		var totaliModificate=0; 
    		var totali=$rootScope.data.step4.vlanusers.length;
    		if($rootScope.data.step4.variazione==='Variazione Tagging'){
	        	angular.forEach($rootScope.data.step4.vlanusers, function (user) {
	    			if ((user.ELIMINA && user.ELIMINA.dft) || (user.AZIONE && user.AZIONE.dft)){
	    				totaliModificate++;
	    			}
	    		});
	        	return (totali < 4 ) && (totaliModificate <= 4 );
    		}
        	return (totali < 4 );
    };
    
    $scope.abilitaEliminaUserVlan = function () {
    	var eliminati=0;
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
    		 $scope.changeInputOK = true;
    	}else if(vlanuser.AZIONE && vlanuser.AZIONE.dft==='C'){
    		delete vlanuser.AZIONE;
    		 $scope.changeInputOK = false;
    	}    	
    };
    
    $scope.eliminaVlanUser = function (vlanusers, vlanIndex) {
        vlanusers.splice(vlanIndex, 1);
        $scope.data.step4.vlanusers = vlanusers;
        
        
        $scope.changeInputOK = $scope.verificaEliminaUserVlan();
    };
    
    $scope.verificaEliminaUserVlan = function(){
    	
    	var _app = $scope.data.step4.vlanusers;
    	var _deleteUserChecked = false;
    	    	
    	if(_app && _app.length > 0){    
    		_app.forEach(function(item){
    			if (item.AZIONE && item.AZIONE.dft === 'C'){
    				_deleteUserChecked = true;    				
    			}
    		});
    	}
    	
    	return _deleteUserChecked;
    }
    

    $scope.eraseVlanUser = function (vlanusers, vlanlength) {
    	if($scope.causaleOrdine !== 'variazione'){
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
    $scope.getLineProfilesNgaVula = function () {
        LineProfiles.get({
            idOfferta: $rootScope.data.step3.offerta.idOfferta,
        }).$promise.then(
            function (response) {
                $rootScope.formData.lineProfiles = response.data;
                $scope.errorPTL = false;
            }, function (error) {
                // scommentare se serve mostrare a video erroreService("Impossibile caricare i profili linea. Riprovare più tardi");
                $scope.errorPTL = "Impossibile caricare i profili linea. Riprovare più tardi";
                $log.debug(error);
                $log.debug("Impossibile caricare i profili linea. Riprovare più tardi");
            });
    };

    $scope.caricaBandePicco = function(){
        if([$rootScope.MAP_OFFERTE.EASY_CAB.name,$rootScope.MAP_OFFERTE.EASY_H.name, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0){
            $scope.getBands();
        }

    };

    $scope.getBands = function (tipocos, codiceLan) {
    	$scope.LoadBandaPicco = true;
        var parameters = {};

        if([$rootScope.MAP_OFFERTE.EASY_CAB.name,$rootScope.MAP_OFFERTE.EASY_H.name, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0) {

            if($rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft) {
                parameters.profTecnicoLinea = $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft;
            }

            if($rootScope.data.step3.offerta.idOfferta) {
                parameters.idOfferta = $rootScope.data.step3.offerta.idOfferta;
            }

        } else {
            if(tipocos){
                parameters.tipoCos = tipocos;
            }
            if(codiceLan){
                parameters.codiceLan = codiceLan;
            }
        }


        BandsProfileNewOrder.get(parameters).$promise.then(function (response) {
            $rootScope.formData.bands = response.data;
            $scope.errorBandePicco = false;
            $scope.LoadBandaPicco = false;
        }, function (error) {
            $scope.errorBandePicco = "Impossibile caricare le bande picco";
            $log.debug("Impossibile caricare le bande per tipo COS o codice Lan");
            $log.debug(error);
            $rootScope.formData.bands = '';
            $scope.LoadBandaPicco = false;
        });
    };
    $scope.ricaricaBandeVariazione = function(vlan, svlan){
    	if($scope.causaleOrdine === 'variazione'){
        	$scope.getBands(null, vlan || svlan);
        }
    };
    /**
     *
     * @param item
     */
    $scope.configurazioneOffertaCallbackAnagraficaSVLAN = function (item) {
        angular.forEach($scope.data.step4.vlanusers, function (vlanusersItem) {
        	if(!vlanusersItem.AZIONE || vlanusersItem.AZIONE.dft!=='C'){
	            if (vlanusersItem.id === $rootScope.numItemForModalCallback) {
	
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
	                $scope.getBands(vlanusersItem.SVLANCODE.tipocos);
	                $scope.getCvlanBandProfile();
	
	                vlanusersItem.clli = item.clli;
	                vlanusersItem.codice_vlan = '';
	                vlanusersItem.codvlanTipocos = '';
	                vlanusersItem.codvlanTipobanda = '';
	
	
	                if (vlanusersItem.BANDAPICCOUP) {
	                    vlanusersItem.BANDAPICCOUP.dft = '';
	                } else {
	                    vlanusersItem.BANDAPICCOUP = {};
	                    vlanusersItem.BANDAPICCOUP.dft = '';
	                }
	                if (vlanusersItem.BANDAPICCODOWN) {
	                    vlanusersItem.BANDAPICCODOWN.dft = '';
	                } else {
	                    vlanusersItem.BANDAPICCODOWN = {};
	                    vlanusersItem.BANDAPICCODOWN.dft = '';
	                }
	                vlanusersItem.banda_picco = '';
	            }
        	}
        });
    };

    $scope.configurazioneOffertaCallbackAnagraficaVLAN = function (item) {
        angular.forEach($scope.data.step4.vlanusers, function (vlanusersItem) {
        	if(!vlanusersItem.AZIONE || vlanusersItem.AZIONE.dft!=='C'){
	            if (vlanusersItem.id === $rootScope.numItemForModalCallback) {
	                vlanusersItem.codice_vlan = item.codicevlan;
	                vlanusersItem.codvlanTipocos = item.tipocos;
	                vlanusersItem.codvlanTipobanda = item.tipobanda;
	                vlanusersItem.codiceKit = item.codicekit;
	
	                $scope.getBands(vlanusersItem.codvlanTipocos);
	                $scope.getCvlanBandProfile();
	                vlanusersItem.clli = item.clli;
	                vlanusersItem.SVLANCODE = {};
	
	                if (vlanusersItem.CVLANID) {
	                    vlanusersItem.CVLANID.dft = '';
	                } else {
	                    vlanusersItem.CVLANID = {};
	                    vlanusersItem.CVLANID.dft = '';
	                }
	
	                if (vlanusersItem.PROFILOBMD) {
	                    vlanusersItem.PROFILOBMD.dft = '';
	                } else {
	                    vlanusersItem.PROFILOBMD = {};
	                    vlanusersItem.PROFILOBMD.dft = '';
	                }
	
	                if (vlanusersItem.SVLANCODE) {
	                    vlanusersItem.SVLANCODE.dft = '';
	                } else {
	                    vlanusersItem.SVLANCODE = {};
	                    vlanusersItem.SVLANCODE.dft = '';
	                }
	
	                if (vlanusersItem.BANDAPICCOUP) {
	                    vlanusersItem.BANDAPICCOUP.dft = '';
	                } else {
	                    vlanusersItem.BANDAPICCOUP = {};
	                    vlanusersItem.BANDAPICCOUP.dft = '';
	                }
	
	                if (vlanusersItem.BANDAPICCODOWN) {
	                    vlanusersItem.BANDAPICCODOWN.dft = '';
	                } else {
	                    vlanusersItem.BANDAPICCODOWN = {};
	                    vlanusersItem.BANDAPICCODOWN.dft = '';
	                }
	                vlanusersItem.banda_picco = '';
	            }
        	}
        });
    };
//  MODALE VLAN
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
            $scope.visualizzaSpinner = true;
            VlanSvlanCvlan.verifica({type:"searchVlanSvlan",
            	idContratto: $rootScope.data.step2.contratto.idContratto,
            	codOloAgcom: $rootScope.data.step1.operatore.codiceOLO,
                encapsulation: $rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft,
                service : $rootScope.data.step3.offerta.nomeOffertaCatalogo},{conditions : $scope.conditions}).$promise.then(function(response) {
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
            	$log.debug(error);
            	$rootScope.formData.vlans = "";
                    $scope.erroreService("Impossibile caricare VLAN/SVLAN. Riprovare più tardi");
                    $log.debug("Impossibile caricare VLAN/SVLAN. Riprovare più tardi");
                $scope.visualizzaSpinner = false;
            });
        }
    };    
    // Chiamo funzione per Codice VLAN
    
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

    

    $scope.configurazioneOffertaGetAnagraficaVLAN = function ($event, itemNum) {
    	$rootScope.formData.vlans = "";
        $rootScope.numItemForModalCallback = itemNum;
        $event.preventDefault();
        $scope.modalVlan("configurazioneOffertaCallbackAnagraficaVLAN");
    };

    $scope.configurazioneOffertaGetAnagraficaSVLAN = function ($event, itemNum) {
    	$rootScope.formData.vlans = "";
        $rootScope.numItemForModalCallback = itemNum;
        $event.preventDefault();
        $scope.modalVlan("configurazioneOffertaCallbackAnagraficaSVLAN");
    };
 
    $scope.configurazioneOffertaCallbackGetBandePiccoDownstream = function (item) {

        angular.forEach($scope.data.step4.vlanusers, function (vlanusersItem) {
        	if(!vlanusersItem.AZIONE || vlanusersItem.AZIONE.dft!=='C'){
	            if (vlanusersItem.id === $rootScope.numItemForModalCallback) {
	                vlanusersItem.banda_picco = item;
	
	                if (vlanusersItem.BANDAPICCODOWN) {
	                    vlanusersItem.BANDAPICCODOWN.dft = $scope.getBandaPicco(vlanusersItem.banda_picco, 'down')
	                } else {
	                    vlanusersItem.BANDAPICCODOWN = [];
	                    vlanusersItem.BANDAPICCODOWN.dft = $scope.getBandaPicco(vlanusersItem.banda_picco, 'down')
	                }
	
	                if (vlanusersItem.BANDAPICCOUP) {
	                    vlanusersItem.BANDAPICCOUP.dft = $scope.getBandaPicco(vlanusersItem.banda_picco, 'up');
	                } else {
	                    vlanusersItem.BANDAPICCOUP = [];
	                    vlanusersItem.BANDAPICCOUP.dft = $scope.getBandaPicco(vlanusersItem.banda_picco, 'up');
	                }
	            }
	            
        	}
        });
    };
    //SM_8451
    $scope.headerGetProfiloBandaCVLan = [
        {"key": "profilo", "value": "nome", "type": "text", "sort": "number"}
    ];
    $scope.headerGetBandePiccoDownstream = [
           {"key": "down", "value": "BandePicco Downstream", "type": "text", "sort": "number"},
           {"key": "up", "value": "BandePicco Upstream", "type": "text", "sort": "number"}
    ];
    //SM_8451
    $scope.configurazioneOffertaCallbackGetProfiloBandaCVLan = function (item) {
    	$scope.data.step4.vlanusers[$rootScope.vlanIndexForProfiloBanda].PROFILOBMD.dft= item.profilo
    }
    //SM_8451
    $scope.configurazioneOffertaGetProfiloBandaCVLan = function ($event, index) {
    	$rootScope.vlanIndexForProfiloBanda=index
        $event.preventDefault();
        $scope.modalOptionsProfiloBandaCVLan = {
            headerText: 'Seleziona un profilo banda cvlan',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackGetProfiloBandaCVLan',
            dataHeader: $scope.headerGetProfiloBandaCVLan,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.profiliBandaCvlan
        };

        modalService.showModal({},
            $scope.modalOptionsProfiloBandaCVLan);
    };
    
    $scope.configurazioneOffertaGetBandePiccoDownstream = function ($event, itemNum) {
        $rootScope.numItemForModalCallback = itemNum;
        $scope.modalOptionsTabellaConfigurazioneOffertaBandePiccoDownstream = {
            headerText: 'Seleziona una Banda Picco',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackGetBandePiccoDownstream',
            dataHeader: $scope.headerGetBandePiccoDownstream,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.bands
        };

        $event.preventDefault();
        modalService.showModal({}, $scope.modalOptionsTabellaConfigurazioneOffertaBandePiccoDownstream);
    };
    $scope.getBandaPicco = function (vv, w) {
        if (vv) {
        	var dd;
            try {
                dd = JSON.parse(vv);
            } catch (exception) {
                dd = vv;
            }
            var dx = (w === 'up') ? dd.up : dd.down;
            return dx;
        }
    };
    
    $scope.isValidCLLI = function () {
        var ar = [];
        angular.forEach($scope.data.step4.vlanusers,
            function (value, key) {
        		//RU_1180
	        	if((!value.AZIONE || value.AZIONE.dft!=='C') && !value.flagMulticastSelected){
	        		if(value.clli){
	        			ar.push(value.clli);
	        		} else {
	        			ar.push($rootScope.formData.data.step2.fromVariazione.centrale);
	        		}
	        	}
            });
        ar.sort();
        for (var i = 1; i < ar.length; i++) {
            if (ar[i - 1] !== ar[i]) {
                return false;
            }
        }
        return true;
    };
    $scope.checkUniqueCVlanId = function () {
        var ar = [];
        angular.forEach($scope.data.step4.vlanusers,
            function (value, key) {
        	//RU_1180
        	if((!value.AZIONE || value.AZIONE.dft!=='C') && !value.flagMulticastSelected){
        		if(value.CVLANID){
            		ar.push(value.CVLANID.dft);
            	}
        	}
        	
            });
        ar.sort();
        for (var i = 1; i < ar.length; i++) {
            if (ar[i - 1] === ar[i]) {
                return false;
            }
        }
        return true;
    };
    /* ** C11M08F19 **  - Verifica univocità UserVlanID */
    $scope.checkUniqueVlanId = function () {
        var ar = [];
        angular.forEach($scope.data.step4.vlanusers,
            function (value, key) {
        		if((!value.AZIONE || value.AZIONE.dft!=='C') && !value.flagMulticastSelected){
	                if (value.USERVLANID) {
	                    ar.push(value.USERVLANID.dft);
	                }
        		}
            });
        ar.sort();
        for (var i = 1; i < ar.length; i++) {
            if (ar[i - 1] === ar[i]) {
                return false;
            }
        }
        return true;
    };
    $scope.checkUniqueSvlanCvlan = function () {
    	if ($scope.data.step3.offerta.nomeOffertaCatalogo !== 'VULAFTTH' && $scope.data.step3.offerta.nomeOffertaCatalogo !== 'VULAFTTCAB' && $scope.data.step3.offerta.nomeOffertaCatalogo !== 'BitstreamNGAFTTH') {
        var ar = [];
        var cvlanList = [];
        angular.forEach($scope.data.step4.vlanusers,
            function (value, key) {
        		//RU_1180
                if (value.SVLANCODE && value.SVLANCODE.dft && (!value.AZIONE || value.AZIONE.dft!=='C') && !value.flagMulticastSelected) {
                	ar.push(value.SVLANCODE.dft + '-' + value.codice_vlan);
                }
                if(value.CVLANID && value.CVLANID.dft) {
                	cvlanList.push(value.CVLANID.dft);
                }
            }
        );

        ar.sort();
        cvlanList.sort();
        for (var i = 1; i < ar.length; i++) {
            if ((ar[i - 1] === ar[i]) && (cvlanList[i - 1] === cvlanList[i])) {
                return false;
            }
        }
        return true;
    	} else {
    		return true;
    	}
    };

    //RU_875
    $scope.verificaCodiceProgettoOneStep = function () {
    	if( $scope.causaleOrdine.toUpperCase() === 'ATTIVAZIONE' && 
    			$scope.data.step2.codice_progetto && $scope.data.step2.codice_progetto.cod_prgt &&
    			[$rootScope.MAP_OFFERTE.NGA_H.name, $rootScope.MAP_OFFERTE.NGA_CAB.name, $rootScope.MAP_OFFERTE.VULA_CAB.name, $rootScope.MAP_OFFERTE.VULA_H.name, $rootScope.MAP_OFFERTE.EASY_CAB.name, $rootScope.MAP_OFFERTE.EASY_H.name, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name, $rootScope.MAP_OFFERTE.SEMI_VULA_H.name, $rootScope.MAP_OFFERTE.SEMI_BTS_H.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0){
    		
    			//SM_10241
    			var _request = {
    					codiceProgetto: $scope.data.step2.codice_progetto.cod_prgt,
    					tipoLinea: $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft,
    					idAsset: ($scope.data.step2.idAssetScelto ? $scope.data.step2.idAssetScelto.idAsset : null),
    					codOloAgcom: $rootScope.data.step1.operatore.codiceOLO,
    					lavorazione: $scope.causaleOrdine
    			};
    		
    		VerificaCodiceProgettoOneStep.save(_request).$promise.then(
                    function (response) {
                    	//RU_871
                    	if(response.esito !=='KO'){
                            $scope.caricaPassFive = false;
                            //RU_875
                            $scope.submit_4();
                    		return true;
                    	}else{
                    		 // MODALE PER MESSAGGIO DI ERRORE
                                modalService.showModal({}, {
                                    headerText: "Avviso",
                                    closeButtonText: 'Chiudi',
                                    bodyText: "Codice Progetto non valido",
                                    scope: $scope,
                                    type: 'error'
                                });
                                $scope.caricaPassFive = false;
                                return false;
                    	}
                    	
                    },
                    function (error) {
                    	$log.debug(error);
			              modalService.showModal({},
			              {
			                  headerText: "Avviso",
			                  bodyText: "VerificaCodiceProgettoOneStep error",
			                  actionButtonText: 'Chiudi',
			                  type: 'warning'
			              });
			              $scope.caricaPassFive = false;
                          return false;
                    });
    	}
    	else if ( $scope.causaleOrdine.toUpperCase() === 'MIGRAZIONE' && $scope.data.step2.codice_progetto && $scope.data.step2.codice_progetto.cod_prgt && [$rootScope.MAP_OFFERTE.NGA_CAB.name, $rootScope.MAP_OFFERTE.VULA_CAB.name, $rootScope.MAP_OFFERTE.EASY_CAB.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0){
    		   			
    			//SM_10241
    			var _request = {
    					codiceProgetto: $scope.data.step2.codice_progetto.cod_prgt,
    					tipoLinea: $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft,
    					idAsset: ($scope.data.step2.idAssetScelto ? $scope.data.step2.idAssetScelto.idAsset : null),
    					codOloAgcom: $rootScope.data.step1.operatore.codiceOLO,
    					lavorazione: $scope.causaleOrdine
    			};
    			
    			VerificaCodiceProgettoOneStep.save(_request).$promise.then(
                    function (response) {
                    	//RU_871
                    	if(response.esito !=='KO'){ 
                            $scope.submit_4();
                            $scope.caricaPassFive = false; 
                    		return true;
                    	}else{
                    		 // MODALE PER MESSAGGIO DI ERRORE
                                modalService.showModal({}, {
                                    headerText: "Avviso",
                                    closeButtonText: 'Chiudi',
                                    bodyText: "Codice Progetto non valido",
                                    scope: $scope,
                                    type: 'error'
                                });
                                $scope.caricaPassFive = false;
                                return false;
                    	}
                    	
                    },
                    function (error) {
                    	$log.debug(error);
			              modalService.showModal({},
			              {
			                  headerText: "Avviso",
			                  bodyText: "VerificaCodiceProgettoOneStep error",
			                  actionButtonText: 'Chiudi',
			                  type: 'warning'
			              });
			              $scope.caricaPassFive = false;
                          return false;
                    });
    	}
    	else{
    		//RU_875
            $scope.submit_4(); 
    		return true;
    	}
    }
    
    
    //SM_9385
    /*
     * Verifica le condizioni per la chiamata ai servizi di controllo bande picco
     * Condizioni:
     * 
     * 1 - bandeFormattate > 0
     * 2 - causale = 'variazione' && (opzioneVariazione != 'Cambio SLA') && offerte = [Bitstream NGA FTTCAB,Bitstream NGA FTTH,	VULA FTTC (VULAC),	VULA FTTH (VULAH)]
     * 3 - causale = 'variazione' && (opzioneVariazione == 'Riconfigurazione Accesso' || opzioneVariazione == 'Riconfigurazione UserVLAN') && offerte = [EasyIPNGAFTTCAB, EasyIPNGAFTTH]
     * 4 - causale = 'atttivazione' 
     * 
     * */    
    $scope.verifica_SM_9385 = function(bande){
    	
    	var _causale = $scope.causaleOrdine || null; 
    	var _opzioneVariazione =  $scope.opzioneVariazione || null;
    	var _offerta = $scope.data.step3.offerta || null;
    	    	
    	if(bande && bande.length > 0){
    		if(_causale == 'variazione'){
    			
    			if(_offerta && [$rootScope.MAP_OFFERTE.NGA_CAB.id, $rootScope.MAP_OFFERTE.NGA_H.id, $rootScope.MAP_OFFERTE.VULA_CAB.id, $rootScope.MAP_OFFERTE.VULA_H.id].indexOf(_offerta.idOfferta) > -1){
    				return (_opzioneVariazione && _opzioneVariazione != 'Cambio SLA');
    			}    			
    			if(_offerta && [$rootScope.MAP_OFFERTE.EASY_CAB.id, $rootScope.MAP_OFFERTE.EASY_H.id, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id].indexOf(_offerta.idOfferta) > -1){
    				return (_opzioneVariazione && (_opzioneVariazione == 'Riconfigurazione Accesso' || _opzioneVariazione == 'Riconfigurazione UserVLAN'));
    			}  			
    		}else if(_causale == 'attivazione' || _causale == 'migrazione'){ //SM_10068
    			return (_offerta && [$rootScope.MAP_OFFERTE.NGA_CAB.id, $rootScope.MAP_OFFERTE.NGA_H.id, $rootScope.MAP_OFFERTE.VULA_CAB.id, $rootScope.MAP_OFFERTE.VULA_H.id, $rootScope.MAP_OFFERTE.SEMI_VULA_H.id, $rootScope.MAP_OFFERTE.SEMI_BTS_H.id].indexOf(_offerta.idOfferta) > -1);
    		}
    	}    	    	
    	return false;
    }
    
    
    
    $scope._idOfferta = ($scope.data.step3.offerta.idOfferta || $rootScope.data.step3.offerta.idOfferta || null);
    $scope._idContratto = ($scope.data.step2.contratto ? $scope.data.step2.contratto.idContratto : null);
    $scope._idAsset = ($scope.data.step2.idAssetScelto ? $scope.data.step2.idAssetScelto.idAsset : null);   

    $scope.submit_4 = function(){		
    	if($scope.causaleOrdine == 'variazione' ) {
			if($scope.RU_1560 && $scope.opzioneVariazione === 'Cambio SLA') {
				var _idRisorsa = $rootScope.data.step2.id_risorsa;
				var _slaAssurance = $rootScope.customizedOffer.offerTopDetails.SLAASSURANCE.dft;
				NewOrderControlliService.C11M08F112(_idRisorsa, _slaAssurance)
					.then(
						function(_result) {
							if(_result.esito == "KO"){
								$scope.caricaPassFive = false;
								$scope.erroreService("Per accessi con ONT Operatore certificato da FiberCop, è disponibile solo lo SLA base di assurance");
								return;
							} else {
								proseguiControlliVariazione();
							}
						}, function(error){
							$scope.erroreService("Impossibile richiamare il servizio di Verifica SLA Base per ONT Operatore");
							$scope.caricaPassFive = false;
							return;
						}
					);
			} else {
    			proseguiControlliVariazione();
    		}
    	}
    	//RU_1270
    	else if($scope.causaleOrdine == 'attivazione' && ($rootScope.customizedOffer.offerTopDetails.IDRISORSAOLD && $rootScope.customizedOffer.offerTopDetails.IDRISORSAOLD.dft)){
    		// RU_1560
			var _offerteValideC11M08F113 = [$rootScope.MAP_OFFERTE.NGA_H.id, 
							  $rootScope.MAP_OFFERTE.VULA_H.id, 
							  $rootScope.MAP_OFFERTE.EASY_H.id, 
							  $rootScope.MAP_OFFERTE.SEMI_BTS_H.id,
							  $rootScope.MAP_OFFERTE.SEMI_VULA_H.id,
							  $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id,
							  $rootScope.MAP_OFFERTE.FULLGPONPLUS.id,
							  $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id];
			if(!$rootScope.OSCURAMENTI.RU_1560.oscurato && _offerteValideC11M08F113.indexOf($scope._idOfferta) > -1){
				var _idRisorsaOld = $rootScope.customizedOffer.offerTopDetails.IDRISORSAOLD.dft;
				var _codOloAgcom = $rootScope.data.step1.operatore.codiceOLO;
				NewOrderControlliService.C11M08F113(_codOloAgcom, _idRisorsaOld)
				.then(function(_result){
					if(_result.esito == "KO"){
						$scope.erroreService("Per le attivazioni con \"riutilizzo\", utilizzare gli ordini di \"Migrazione Del. 82\"");
						$scope.caricaPassFive = false;
						return false;
					} else {
						proseguiControlliAttivazione();
					}
				}, function(error){
					$scope.erroreService("Impossibile richiamare il servizio di Verifica attivazione FTTH");
					$scope.caricaPassFive = false;
					return false;
				});	
			} else {
				proseguiControlliAttivazione();
			}
    	} else{
    		$scope._submit_4();
    	}
    }
	
	proseguiControlliVariazione = function () {
		  if($scope.opzioneVariazione == "Disabilitazione / Riabilitazione"){
			var _offerteValide = [$rootScope.MAP_OFFERTE.EASY_CAB.id, $rootScope.MAP_OFFERTE.EASY_H.id, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id];    		 			
			var _disabilitazione = $scope.customizedOffer.offerTopDetails.DISABILITAZIONE.dft;
	
			if(_offerteValide.indexOf($scope._idOfferta) > -1){
				ControlliServiceStep4.verificheOpzioneAbilitazioneDisabilitazione($scope._idAsset, $scope._idContratto, _disabilitazione)
				.then(function(_result){
					if(_result){
						if(_result.isResponsesOk){
							$state.go($scope.checkNextStateVariazione());
						}else{
							$scope.erroreService(_result.message);
							$scope.caricaPassFive = false;
							return;
						}
					}else{
						$scope.erroreService("Impossibile effettuare i controlli per Opzione variazione 'Disabilitazione / Riabilitazione'");
						$scope.caricaPassFive = false;
						return;
					}
				});
			}
		} else {
			$scope._submit_4();
		}
	};
	
	proseguiControlliAttivazione = function() {
		var _offerteValide = [$rootScope.MAP_OFFERTE.NGA_H.id, 
				  $rootScope.MAP_OFFERTE.VULA_H.id, 
				  $rootScope.MAP_OFFERTE.EASY_H.id, 
				  $rootScope.MAP_OFFERTE.SEMI_BTS_H.id,
				  $rootScope.MAP_OFFERTE.SEMI_VULA_H.id,
				  $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id];
		//RU_1543
		var _offerteFullGponPlus = [$rootScope.MAP_OFFERTE.FULLGPONPLUS.id, $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id];
		var _profiloTecnicoLinea = ($rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft || null);
		if(_offerteValide.indexOf($scope._idOfferta) > -1){
			ControlliServiceStep4.C11M08F91($scope._idOfferta, _profiloTecnicoLinea)
			.then(function(_result){
				if(_result.controlloProfiloTecnicoLineaX1X2Output){
					if(_result.controlloProfiloTecnicoLineaX1X2Output.esito == 'OK'){
						$scope._submit_4();
					}else{
						$scope.erroreService(_result.controlloProfiloTecnicoLineaX1X2Output.message);
					}
				}else{
					$scope.erroreService("Impossibile effettuare i controlli per Verifica Profilo Tecnico Linea X1 / X2'");
					$scope.caricaPassFive = false;
					return;
				} 
			});
		}
		//RU_1543
		else if(_offerteFullGponPlus.indexOf($scope._idOfferta) > -1){
			if($scope.RU_1543){
				$scope.C11M08F108()
				.then(function(_result){
					if(_result.esito == "KO"){
						$scope.caricaPassFive = false;
						$scope.erroreService("Servizio non congruente con la richiesta di attivazione corrispondente");
						return;
					}else{
						$scope._submit_4();
					}
				}, function(error){
					$scope.erroreService("Impossibile richiamare il servizio di Verifica attivazione Full Gpon Plus");
					$scope.caricaPassFive = false;
					return;
				});	
			}else{
				$scope._submit_4();
			}
		}
		else{
			$scope._submit_4();
		}
	};
    
    $scope.__submit4 = function(){
		//RU_1180
    	var _resultC11M08F87 = $scope.C11M08F87();
    	if(!_resultC11M08F87.flag){
    		$scope.erroreService(_resultC11M08F87.message);
    		$scope.caricaPassFive = false;
    		return;
    	}   	

    	//R1I-20-0313
    	var _resultC11M08F81 = $scope.C11M08F81();
    	if(!_resultC11M08F81.flag){
    		$scope.erroreService(_resultC11M08F81.message);
    		return;
    	}
    	
    	//RU_1270
    	if($scope.causaleOrdine == 'attivazione')


    	$scope.controlloBozza(5);
    	$scope.erroriConfigurazioneOfferta = [];
    	// VERIFICHE NGA-VULA
    	var svlanANDcvlan = false;
    	var ctrlSvlan = [];
    	var vecchiomodello = false;


    	angular.forEach($scope.data.step4.vlanusers, function (user) {
    		if (user.SVLANCODE && (!user.AZIONE || user.AZIONE.dft!=='C')) {
    			ctrlSvlan.push(user.SVLANCODE.dft);
    		}
    		if(user.SVLANCODE && user.SVLANCODE.dft && (user.CVLANID && user.CVLANID.dft))
    			svlanANDcvlan = true;
    	});

    	var sameSvlanCode = true;
    	for (var i = 1; i < ctrlSvlan.length; i++) {
    		if (ctrlSvlan[i - 1] !== ctrlSvlan[i]) {
    			sameSvlanCode = false;
    		}
    	}

    	//SM_9408
    	var _offerteEasyIPNGA = [$rootScope.MAP_OFFERTE.EASY_CAB.id, $rootScope.MAP_OFFERTE.EASY_H.id, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id]
    	if(_offerteEasyIPNGA.indexOf($scope.data.step3.offerta.idOfferta) > -1){
    		if($scope.causaleOrdine === 'variazione' && 
    				$scope.opzioneVariazione == 'Riconfigurazione Accesso' && 
    				($scope.data.step4.variazione == 'Riconfigurazione IP' || $scope.data.step4.variazione == 'Profilo Tecnico Linea')){
    			$state.go($scope.checkNextStateVariazione());
    			return;
    		}
    	}

    	// C04M01F93 - Determinazione modello VULA 
    	if (((($scope.data.step3.offerta.nomeOffertaCatalogo === 'VULAFTTH' || $scope.data.step3.offerta.nomeOffertaCatalogo === 'VULAFTTCAB') || $scope.data.step3.	offerta.nomeOffertaCatalogo === 'BitstreamNGAFTTH') && ($scope.causaleOrdine !== 'variazione')) ||
    			(($scope.causaleOrdine === 'variazione') && ($scope.opzioneVariazione !== 'Cambio SLA'))){
    		if (($scope.data.step4.vlanusers.length < 2) || (sameSvlanCode)) {
    			$scope.customizedOffer.offerTopDetails.FLAGNUOVOMODELLO.dft = 'Y';
    			$log.info("nuovo modello");
    		}
    		else {
    			vecchiomodello = true;
    			$scope.customizedOffer.offerTopDetails.FLAGNUOVOMODELLO.dft = 'N';
    			$log.info("vecchio modello");
    		}
    	}

    	// C11M02F26 Verifica CVLAN o UserVLan
    	if (!$scope.checkUniqueVlanId() && ($scope.opzioneVariazione !== 'Cambio SLA')) {
    		$scope.erroriConfigurazioneOfferta.push({
    			error: '1',
    			msg: "I campi UserVLAN devono essere differenti per ogni utente."
    		});
    		$scope.caricaPassFive = false;
    	}

    	if (!$scope.checkUniqueSvlanCvlan() && ($scope.opzioneVariazione !== 'Cambio SLA')) {
    		$scope.erroriConfigurazioneOfferta.push({
    			error: '2',
    			msg: "Le coppie di valori Codice SVLAN / CVLan Code devono essere differenti per ogni User."
    		});
    		$scope.caricaPassFive = false;
    	}

    	// C04M01F47 – Verifica CLLI (variazione solo se Riconfigurazione UserVLAN)
    	if ((($scope.causaleOrdine !== 'variazione') ||
    			(($scope.causaleOrdine === 'variazione') && ($scope.opzioneVariazione === 'Riconfigurazione UserVLAN')
    			)) && !([$rootScope.MAP_OFFERTE.EASY_H.name,$rootScope.MAP_OFFERTE.EASY_CAB.name, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0)) {
    		if (!$scope.isValidCLLI() ) {
    			$scope.erroriConfigurazioneOfferta.push({
    				error: '4',
    				msg: "Il CLLI di attestazione della prima user vlan deve essere uguale per tutte le altre UserVLAN"
    			});
    			$scope.caricaPassFive = false;
    		}
    	}
    	if ($scope.erroriConfigurazioneOfferta.length) {
    		return;
    	}

    	//Formatto le bande per utilizzarle nei controlli
    	var bandeFormattate = [];
    	var userVlan = [];

    	angular.forEach($scope.data.step4.vlanusers, function (user) {
    		//RU_1180
    		if((!user.AZIONE || user.AZIONE.dft!=='C') && (!user.FLAGMULTICAST || !user.flagMulticastSelected)){
    			var presenzaTipocos = false;
    			if(user.banda_picco) {
    				var bandaPicco = angular.fromJson(user.banda_picco);
    				var item = {
    						up: bandaPicco.up || user.BANDAPICCOUP.dft,
    						down: bandaPicco.down || user.BANDAPICCODOWN.dft
    				};
    				var tipocosScelto;
    				if(user.SVLANCODE && user.SVLANCODE.dft){
    					if(user.SVLANCODE.tipocos){
    						tipocosScelto = user.SVLANCODE.tipocos;
    						presenzaTipocos = true;
    					} else {

    						tipocosScelto = user.SVLANCODE.dft;
    						presenzaTipocos = false;
    					}

    				} else if(user.codice_vlan){
    					if(user.codvlanTipocos){
    						tipocosScelto = user.codvlanTipocos;
    						presenzaTipocos = true;
    					} else {
    						tipocosScelto = user.codice_vlan;
    						presenzaTipocos = false;
    					}

    				} else {
    					$log.info("Non è possibile inviare la chiamata a controllo banda, non c'è Tipocos");
    				}
    				var controlBand;
    				if($scope.causaleOrdine==='variazione' && !presenzaTipocos){
    					controlBand = { bandaPiccoDown : user.BANDAPICCODOWN.dft,
    							bandaPiccoUp : user.BANDAPICCOUP.dft,
    							codVlan : tipocosScelto};
    				}else{
    					controlBand = { bandaPiccoDown : user.BANDAPICCODOWN.dft,
    							bandaPiccoUp : user.BANDAPICCOUP.dft,
    							tipoCos : tipocosScelto};
    				}


    				userVlan.push(controlBand);
    				bandeFormattate.push(item);
    			}
    		}
    	}
    	);
    	if($scope.opzioneVariazione === 'Cambio SLA') {
    		$scope.salvaConfigurazioneOfferta();
    	} else {

    		//    	vecchiomodello è pari a FLAG NUOVO MODELLO = 'N'
    		//SM_9385	
    		if (vecchiomodello && bandeFormattate.length > 0) {
    			// C04M01F43 - Verifica Somma Bande di Picco (Attiva solo se FLAG NUOVO MODELLO = 'N')
    			Bands.save({type:"check"},{
    				profiloTecnicoLinea: $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft,
    				offerta: $rootScope.data.step3.offerta.nomeOffertaCatalogo,
    				bande: bandeFormattate
    			}).$promise.then(
    					function (bandsValues) {
    						if (!$scope.erroriConfigurazioneOfferta.length && bandsValues.result.description === 'OK') {
    							if (bandsValues.outcome.esito === 'OK') {          	

    								//SM_9283
    								//C11M08F69 - Verifica Compatibilità intermediate agent full  
    								$scope.verificaCompatibilitaIntermediateAgentFull(); 

    							} else {
    								$scope.erroreService("La somma delle Bande di Picco supera la soglia consentita per il profilo linea");
    								$scope.caricaPassFive = false;
    							}
    						} else {
    							$scope.erroreService("La somma delle Bande di Picco supera la soglia consentita per il profilo linea");
    							$scope.caricaPassFive = false;
    						}
    					},
    					function (error) {
    						// Error callback
    						$log.debug("Impossibile verificare la somma delle Bande di Picco");
    						$log.debug(error);
    						$scope.erroreService("Impossibile verificare la somma delle Bande di Picco");
    						$scope.caricaPassFive = false;
    					});
    		} else {
    			//SM_9385
    			if($scope.verifica_SM_9385(bandeFormattate)){
    				//C04M01F148 controlloValori Banda Picco
    				if($rootScope.data && $rootScope.data.step1 && $scope.causaleOrdine){
    					Bands.save({type:"checkvalues"},{userVlan: userVlan,lavorazione:$scope.causaleOrdine.toUpperCase()}).$promise.then(
    							function (response) {
    								$scope.caricaPassFive = false;
    								if(response){
    									if(response.codice === "OK") {

    										//RU_966
    										//C11M08F69 - Verifica Compatibilità intermediate agent full
    										//SM_9283
    										$scope.verificaCompatibilitaIntermediateAgentFull();               							

    									} else {
    										$scope.erroreService("Controllo valori Banda Picco superano le soglie consentite per il profilo linea");
    										$scope.caricaPassFive = false;
    									}
    								} else {
    									$scope.erroreService("Impossibile verificare Controllo valori Banda Picco");
    									$scope.caricaPassFive = false;
    								}
    							},
    							function (error) {
    								// Error callback
    								$log.debug("Impossibile verificare Controllo valori Banda Picco");
    								$log.debug(error);
    								$scope.erroreService("Impossibile verificare Controllo valori Banda Picco");
    								$scope.caricaPassFive = false;
    							} );	
    				}else{
    					$scope.erroreService("Impossibile verificare Controllo valori Banda Picco");
    				}

    			} else {
    				$scope.salvaConfigurazioneOfferta();
    			}
    		}
    	} 
	}

    $scope._submit_4 = function(){
	    //SM_11483	    
		if($scope.RU_1502){
				$scope.C11M08F107()
				.then(function(data){
					if(data.esito == "KO"){
						$scope.caricaPassFive = false;
						$scope.erroreService("I07 Servizio non congruente con il VP/VLAN/KIT/CAR");
						return;
					}else{
						$scope.__submit4();
					}
				}, function(error){
					$scope.erroreService("Impossibile richiamare il servizio di Verifica congruenza DRG offerta");
					$scope.caricaPassFive = false;
					return;
				});
		}else{
			$scope.__submit4();
		}	
    }


    if($rootScope.data && $rootScope.data.step1 && $scope.causaleOrdine==='variazione' && $scope.data && $scope.data.step4 && $scope.data.step4.vlanusers){
    	var vlan, svlan;
    	vlan=($scope.data.step4.vlanusers[0] && $scope.data.step4.vlanusers[0].codice_vlan)?$scope.data.step4.vlanusers.codice_vlan:null;
    	svlan=($scope.data.step4.vlanusers[0] && $scope.data.step4.vlanusers[0].SVLANCODE)?$scope.data.step4.vlanusers[0].SVLANCODE.dft:null;
    	$scope.ricaricaBandeVariazione(vlan, svlan);
    }
    
    $scope.calcolaUSERVLANID = function (id) {

    	//SM_10100
    	$scope.changeInputOK = true;
    	
    	angular.forEach($rootScope.DettaglioAssetUSER.vlanusers,
                function (ITEM) {
		    		if(ITEM.USERVLANID && ITEM.USERVLANID.dft == id){
						$scope.data.step4.vlanusers=[];
						$scope.data.step4.vlanusers.push(ITEM);
						$scope.data.step4.vlanusers[0].id=1;
					}
                }
            );
    };
         
    $scope.impostaUSERVLANID = function (id) {
			if(id && $scope.data.step4 && $scope.data.step4.vlanusers && $scope.data.step4.vlanusers[0]){
				if($scope.data.step4.vlanusers[0].USERVLANID){
					$scope.data.step4.vlanusers[0].USERVLANID.dft=id;
				}else{
					$scope.data.step4.vlanusers[0].USERVLANID={};
					$scope.data.step4.vlanusers[0].USERVLANID.dft=id;
				}
			}
		};

		$scope.variazioneGestioneProfiloEncapsulation = function () {
			
			if($rootScope.DettaglioAsset && $rootScope.DettaglioAsset.offerTopDetails && $rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA 
			    	&& $rootScope.customizedOffer && $rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA){
			    		$rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft=$rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA.dft;
			    	}

			if($rootScope.DettaglioAsset && $rootScope.DettaglioAsset.offerTopDetails && $rootScope.DettaglioAsset.offerTopDetails.MODALITACONSEGNA
			    	&& $rootScope.customizedOffer && $rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.MODALITACONSEGNA){
			    		$rootScope.customizedOffer.offerTopDetails.MODALITACONSEGNA.dft=$rootScope.DettaglioAsset.offerTopDetails.MODALITACONSEGNA.dft;
			    	}

	    	if($rootScope.DettaglioAsset && $rootScope.DettaglioAsset.offerTopDetails && $rootScope.DettaglioAsset.offerTopDetails.ENCAPSULATION 
	    	    	&& $rootScope.customizedOffer && $rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.ENCAPSULATION){
	    	    		$rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft=$rootScope.DettaglioAsset.offerTopDetails.ENCAPSULATION.dft;
	    	    	}

                if($scope.data.step4.vlanusers){
                    for(var i=0; i <= $scope.data.step4.vlanusers.length; i++) {

                        if(($scope.data.step4.vlanusers[i] && $scope.data.step4.vlanusers[i].CVLANID && $scope.data.step4.vlanusers[i].CVLANID.dft)
                            && ($rootScope.DettaglioAssetUSER && $rootScope.DettaglioAssetUSER.vlanusers[i] && $rootScope.DettaglioAssetUSER.vlanusers[i].CVLANID && $rootScope.DettaglioAssetUSER.vlanusers[i].CVLANID.dft)){

                              $scope.data.step4.vlanusers[i].CVLANID.dft = $rootScope.DettaglioAssetUSER.vlanusers[i].CVLANID.dft;

                        }
                    }
                }
		};

    $scope.salvaConfigurazioneOfferta = function () {
    	// SE Vula C04M01F94 Verifica coppia Banda Picco  altrimenti va agli step successivi
		if([$rootScope.MAP_OFFERTE.VULA_CAB.id,$rootScope.MAP_OFFERTE.VULA_H.id].indexOf($rootScope.data.step3.offerta.idOfferta) >= 0 && ($scope.opzioneVariazione !== 'Cambio SLA')){
			$scope.verificaCoppiaBandaPiccoBool=true;
			$scope.userVlan = [];
			for(i=0;i<$scope.data.step4.vlanusers.length;i++) {
				$scope.addVlan = {};
				$scope.addVlan.up = $scope.data.step4.vlanusers[i].BANDAPICCOUP.dft;
				$scope.addVlan.down = $scope.data.step4.vlanusers[i].BANDAPICCODOWN.dft;
                if($scope.data.step4.vlanusers[i].USERVLANID && $scope.data.step4.vlanusers[i].USERVLANID.dft){
                    var idVlan = $scope.data.step4.vlanusers[i].USERVLANID.dft;
                    $scope.addVlan.userVlanId = idVlan.toString();
                }
				$scope.userVlan.push($scope.addVlan);
			}
			
			var inputVerificaCoppiaBandaPicco = {
					profiloTecnicoLinea: $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft,
					userVlan : $scope.userVlan,
					lavorazione : $scope.causaleOrdine
	            };
			
			if($scope.causaleOrdine === 'variazione'){
					inputVerificaCoppiaBandaPicco.idRisorsa1 = $rootScope.data.step2.id_risorsa;
					inputVerificaCoppiaBandaPicco.tipoVariazione = $scope.opzioneVariazione;
			} 
			
			Bands.save({type:"checkCouple"},inputVerificaCoppiaBandaPicco).$promise.then(function (bandsValues) {
                if (!$scope.erroriConfigurazioneOfferta.length && bandsValues.result.description === 'OK') {
                    if (bandsValues.data[0].esito === 'OK') {
                    	$rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
                    	
                    	if(($scope.causaleOrdine === 'variazione') && !$scope.data.step4.idTicketTTM){
                        	$state.go($scope.checkNextStateVariazione());
                        }else if(($scope.causaleOrdine === 'variazione') && $scope.data.step4.idTicketTTM){
                        		if($rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft === $rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA.dft){
                            		$scope.erroreService("Per la variazione selezionata è necessario modificare il Profilo Tecnico Linea");
                            	}else { 
                            		
                            		//RU_994                            			           			
                            			if($scope.opzioneVariazione == 'Downgrade Fast'){
                                    		$scope.C11M08F49()
                                    		.then(function(data){
                                    			if(data.esito == 'OK'){    	
                                    				if($scope.RU_994){
                                    					return $scope.C11M08F71();  
                                    				}else{
                                    					$state.go($scope.checkNextStateVariazione());
                                    				}                                    				  				
                                    			}else{
                                    				$scope.erroreService("ID Ticket TTM inesistente oppure non compatibile con la richiesta o relativo ad altro accesso o relativo ad altra richiesta di Variazione Fast su medesima linea");
                                    			}   			    			
                                    		}, function(error){
                                    			$scope.erroreService("Errore servizio Verifica Ticket TTM");
                                    		})
                                    		.then(function(data){
                                    			if(data.esito == 'OK'){    				
                                    				$state.go($scope.checkNextStateVariazione());				
                                    			}else{
                                    				$scope.erroreService("ID Ticket TTM inesistente oppure non compatibile con la richiesta o relativo ad altro accesso o relativo ad altra richiesta di Variazione Fast su medesima linea");
                                    			}  
                                    		}, function(error){
                                    			$scope.erroreService("Errore servizio Verifica Downgrade Fast")
                                    		});
                            			}else{
                            				$state.go($scope.checkNextStateVariazione());
                            			}
                            	}
                        	
                        } else {
                        	 $state.go($scope.checkNextState());
                        }
                    } else {
                        $scope.erroreService("Controllo valori Banda Picco superano le soglie consentite per il profilo linea");
                        $scope.caricaPassFive = false;
                        $scope.verificaCoppiaBandaPiccoBool=false;
                    }
                } else {
                    $scope.erroreService("Controllo valori Banda Picco superano le soglie consentite per il profilo linea");
                    $scope.caricaPassFive = false;
                    $scope.verificaCoppiaBandaPiccoBool=false;
                }
            }, function(error) {
            	$scope.erroreService("Impossibile controllare valori Banda Picco");
            	$scope.caricaPassFive = false;
				$scope.verificaCoppiaBandaPiccoBool=false;
            });
			
			
		}else{
			var modBande = 0;
        	if(($scope.data.step4.vlanusers.length > 0) && ($scope.opzioneVariazione === 'Downgrade Fast')){
        		for(var i=0; i<$scope.data.step4.vlanusers.length; i++){
            		if($rootScope.DettaglioAssetUSER.vlanusers[i]){
            			if(parseInt($scope.data.step4.vlanusers[i].banda_picco.down) !== parseInt($rootScope.DettaglioAssetUSER.vlanusers[i].banda_picco.down) || parseInt($scope.data.step4.vlanusers[i].BANDAPICCOUP.dft) !== parseInt($rootScope.DettaglioAssetUSER.vlanusers[i].BANDAPICCOUP.dft)){
            				modBande++;	
            			}
            		}
            	}
        	}
        	
        	if(($scope.opzioneVariazione === 'Downgrade Fast') && ($rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft === $rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA.dft)){
        		$scope.erroreService("Per la variazione selezionata è necessario modificare il Profilo Tecnico Linea");
        	} else {
				$rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
				if($scope.causaleOrdine === 'variazione'){		        
					
					//RU_995
					if($scope.opzioneVariazione == 'Downgrade Fast'){
						
						var _offerteRU_995 = [$rootScope.MAP_OFFERTE.EASY_CAB.id];
						var _offerteRU_994 = [$rootScope.MAP_OFFERTE.NGA_CAB.id,$rootScope.MAP_OFFERTE.VULA_CAB.id];

						//In caso di offerte EasyIPNGAFTTCAB, BTS NGA FTTCAB o VULA FTTCAB
						//SM_9387
						if((_offerteRU_995.indexOf($scope.data.step3.offerta.idOfferta) > -1 && $scope.RU_995) || 
							(_offerteRU_994.indexOf($scope.data.step3.offerta.idOfferta) > -1 && $scope.RU_994)){
                    		$scope.C11M08F49()
                    		.then(function(data){
                    			if(data.esito == 'OK'){                     				
                    				return $scope.C11M08F71();   				
                    			}else{
                    				$scope.erroreService("ID Ticket TTM inesistente oppure non compatibile con la richiesta o relativo ad altro accesso o relativo ad altra richiesta di Variazione Fast su medesima linea");
                    			}   			    			
                    		}, function(error){
                    			$scope.erroreService("Errore servizio Verifica Ticket TTM");
                    		})
                     		.then(function(data){
                    			if(data.esito == 'OK'){    				
                    				$state.go($scope.checkNextStateVariazione());				
                    			}else{
                    				$scope.erroreService("ID Ticket TTM inesistente oppure non compatibile con la richiesta o relativo ad altro accesso o relativo ad altra richiesta di Variazione Fast su medesima linea");
                    			}  
                    		}, function(error){
                    			$scope.erroreService("Errore servizio Verifica Downgrade Fast")
                    		});
							
						}
						//SM_9401
						else{
	        				$state.go($scope.checkNextStateVariazione());
	        			}						
					}else{
        				$state.go($scope.checkNextStateVariazione());
        			}	        	
		        } else {
		        	 $state.go($scope.checkNextState());
		        } 
        	} 
		}
    };
    
    //RU_918
    $scope.onSelectTipoLinea = function(){
    	try{
    		if($scope.customizedOffer.offerTopDetails.TIPOLINEA.dft && $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft != 'LineaNonAttiva'){
    			$scope.customizedOffer.offerTopDetails.IDRISORSAOLD.dft = "";
    		}    		
    	}
    	catch(e){}
    };
    
    //RU_966          
    $scope.oscuramento_RU_966 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_966.oscurato){
    				//SM_9282
    				//In caso di Attivazione per BTS NGA FTTCAB/FTTH e VULA FTTCAB/FTTH, 
    				//Intermediate Agent Full può essere visualizzato/valorizzato
    				//mentre per Variazione solo per VULA FTTCAB/FTTH
    				
    				$scope.RU_966 = ($rootScope.OSCURAMENTI.RU_966.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);

//Change Request #31039 - Fix In caso di Variazione riconfigurazione accesso per offerta BITSTREAMNGAFTTCAB il Flag INTERMEDIATE_AGENT_FULL non e' presente.    				
//    				if($scope.causaleOrdine === 'variazione' && (['15', '16'].indexOf($scope.data.step3.offerta.idOfferta) > -1))
//    				{
//    					$scope.RU_966 = false;
//    				}else{
//    					$scope.RU_966 = ($rootScope.OSCURAMENTI.RU_966.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
//    				}	
    				
    			}else{
    				$scope.RU_966 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_966 = false;
    	}          	
    }
        
    $scope.C11M08F69 = function(){
    	
    	var _request = {
    			idOfferta: $scope.data.step3.offerta.idOfferta,
    			lavorazione: $scope.causaleOrdine,
    			encapsulation: null,
    			intermediateAgentFull: null,
    			svlanCodes: [],
    			cvlanCodes: [],			
    			idAsset: ($scope.data.step2.idAssetScelto ? $scope.data.step2.idAssetScelto.idAsset : undefined)
    	};
    	
    	//Estrazione codici VLAN o SVLAN
    	if($scope.customizedOffer.offerTopDetails.ENCAPSULATION.dft && $scope.data.step4.vlanusers && $scope.data.step4.vlanusers.length > 0){
    		var _app = angular.copy($scope.data.step4.vlanusers);
    		//RU_982
    		if($scope.customizedOffer.offerTopDetails.ENCAPSULATION.dft.toUpperCase() === 'SINGLETAG'){
    			//SM_10255
    			_app.forEach(function(lan){
    				if(!lan["FLAGMULTICAST"] || !lan["FLAGMULTICAST"].dft || lan["FLAGMULTICAST"].dft == ""){
	    				 _request['svlanCodes'].push({
	    					 id: lan.id,
	    					 value: lan.codice_vlan
	    				 });
    				}
    			});
    		}else{
    			_app.forEach(function(lan){
    				if(!lan["FLAGMULTICAST"] || !lan["FLAGMULTICAST"].dft || lan["FLAGMULTICAST"].dft == ""){
	    				 _request['svlanCodes'].push({
	    					 id: lan.id,
	    					 value: lan.SVLANCODE.dft
	    				 });				
    				}
    			});
    		}
    	}  	    
    	

    	_request.intermediateAgentFull = ($scope.customizedOffer.offerTopDetails.INTERMEDIATEAGENTFULL ? $scope.customizedOffer.offerTopDetails.INTERMEDIATEAGENTFULL.dft : null);

    	_request.encapsulation = ($scope.customizedOffer.offerTopDetails.ENCAPSULATION ? $scope.customizedOffer.offerTopDetails.ENCAPSULATION.dft : null);
    	
    	return VerificaCompatibilitaIntermediateAgent.save({}, _request).$promise;    	
    };
    
    $scope.resetOnChangeVariazione = function(){
    	$scope.customizedOffer.offerTopDetails.INTERMEDIATEAGENTFULL.dft = null;
    };
    
    //SM_9283
    $scope.verificaCompatibilitaIntermediateAgentFull = function(){
    	
        //C11M08F69 - Verifica Compatibilità intermediate agent full             
        $scope.C11M08F69().then(function(data){
        	if(data.VerificaCompatibilitaIntermediateAgentOutput.esito === 'KO'){
        		$scope.caricaPassFive = false;  
                $scope.erroreService(data.VerificaCompatibilitaIntermediateAgentOutput.message);
        	}else{

				$scope.salvaConfigurazioneOfferta();
        	}
        },
        function (error) {
            // Error callback
            $log.debug("Impossibile verificare compatibilità Intermediate Agent Full");
            $log.debug(error);
            $scope.erroreService("Impossibile verificare compatibilità Intermediate Agent Full");
            $scope.caricaPassFive = false;
        });  
    }
    
    $scope.disableIntermediateAgentFull = false;
	$scope.disableEncapsulation = false;
	$scope.disableProfiloTecnicoLinea = false;
       
    $scope.oscuramento_RU_966();
    
    //RU_994
    $scope.oscuramento_RU_994 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_994.oscurato){   				
   					$scope.RU_994 = ($rootScope.OSCURAMENTI.RU_994.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);  				
    			}else{
    				$scope.RU_994 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.RU_994 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_994();
    
    //RU_995    
        
    //C11M08F49 - Verifica ticket TTM
    $scope.C11M08F49 = function(){
    	
    	var _idRisorsa = null;  
    	
    	if($scope.RU_995 || $scope.RU_994){
    		_idRisorsa = $scope.getIdRisorsaIfOfferteCAB();  
    	}
    	
    	//SM_9374
    	return verificaTicketTTM
    			.get({
    				idTicketTTM: $scope.data.step4.idTicketTTM, 
    				idRisorsa: _idRisorsa,
    				tipoLinea: ($rootScope.customizedOffer.offerTopDetails['TIPOLINEA'].dft || null)
    			})
    			.$promise;   	
    }
    
    //C11M08F71 - Verifica esistenza ordine di variazione Downgrade Fast
    $scope.C11M08F71 = function(){
    	
    	var _idRisorsa = $scope.getIdRisorsaIfOfferteCAB();    	
    	var _request = {
    		idTicketTTM: $scope.data.step4.idTicketTTM, 
    		idRisorsa: _idRisorsa  	
    	};
    	
    	return VerificaOrdineVariazioneDowngradeFast
    			.save(_request)
    			.$promise;   	
    }
    
    //SM_9388
    $scope.getIdRisorsaIfOfferteCAB = function(){
    	if([$rootScope.MAP_OFFERTE.EASY_CAB.id, $rootScope.MAP_OFFERTE.NGA_CAB.id, $rootScope.MAP_OFFERTE.VULA_CAB.id].indexOf($scope.data.step3.offerta.idOfferta) > -1){
    		return $scope.data.step2.id_risorsa;
    	}    	
    	return null;
    }
    
    $scope.oscuramento_RU_995 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_995.oscurato){   				
   					$scope.RU_995 = ($rootScope.OSCURAMENTI.RU_995.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);  				
    			}else{
    				$scope.RU_995 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.RU_995 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_995();
    
    //SM_11483
    $scope.oscuramento_RU_1502 = function() {
		$scope.RU_1502 = !$rootScope.OSCURAMENTI.RU_1502.oscurato;
    }
    
    $scope.oscuramento_RU_1502();
    
    $scope.C11M08F107 = function(){
		var _lavorazione = $scope.causaleOrdine;
		var _opzioneVariazione = ($scope.opzioneVariazione || null);
		var _tipoVariazione = ($scope.data.step4.variazione || null);
    	var _offerta = $scope.data.step3.offerta.idOfferta;    	
    	//var _arrayOfferte = [$rootScope.MAP_OFFERTE.NGA_CAB.id];
    	var _encapsulation = $rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft
    	
    	var _request = {
			offerta: _offerta,
			codVlan: [],
			codSvlan: []
		};
    	
		if(_lavorazione == 'attivazione'){
			var _arrayFiltrato = [];
			if(_encapsulation == 'DOUBLETAG'){
    			_arrayFiltrato = _.chain($scope.data.step4.vlanusers).pluck('SVLANCODE').uniq('dft').value();
    			_request.codSvlan = _.chain(_arrayFiltrato).pluck('dft').map(function(item){ return item.toString()}).value(); 			
    		}else{
    			_arrayFiltrato = _.chain($scope.data.step4.vlanusers).pluck('codice_vlan').uniq().value();	    			
    			_request.codVlan = _arrayFiltrato;  	
    		}    		
		}else if(_lavorazione == 'variazione' && _opzioneVariazione == 'Riconfigurazione UserVLAN' && (_tipoVariazione == "Variazione Numero User VLAN" || _tipoVariazione == "IncrementoDecrementoUserVlan")){
			var _array = _.filter($scope.data.step4.vlanusers, function(item){
	        	return (_.isUndefined(item.AZIONE) || _.isEmpty(item.AZIONE) ||item.AZIONE.dft == 'A');
	        });
	        
        	if(_encapsulation == 'DOUBLETAG'){
    			_arrayFiltrato = _.chain(_array).pluck('SVLANCODE').uniq('dft').value();
    			_request.codSvlan = _.chain(_arrayFiltrato).pluck('dft').map(function(item){ return item.toString()}).value();
    		}else{
				_arrayFiltrato = _.chain(_array).pluck('codice_vlan').uniq().value();
				_request.codVlan = _arrayFiltrato;
        	}	
		}
		
		return VerificaCongruenzaDRGOfferta.save(_request).$promise;
	}
	
	//RU_1543
    $scope.oscuramento_RU_1543 = function() {
		$scope.RU_1543 = !$rootScope.OSCURAMENTI.RU_1543.oscurato;
    }
	
	$scope.C11M08F108 = function(){
		var _idRisorsaOld = $rootScope.customizedOffer.offerTopDetails.IDRISORSAOLD.dft;
    	var _codOloAgcom = $rootScope.data.step1.operatore.codiceOLO;
    	
    	var _request = {
			codOloAgcom: _codOloAgcom,
			idRisorsaOld: _idRisorsaOld
		};
		
		return VerificaAttivazioneFullGponPlus.get(_request).$promise;
	}
    
    //R1I-20-0313
    $scope.C11M08F81 = function(){
    	
    	var _lavorazione = $scope.causaleOrdine;
    	var _offerta = $scope.data.step3.offerta.idOfferta;
    	var _encapsulation = $rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft
    	//RU_1543
    	var _arrayOfferte = [$rootScope.MAP_OFFERTE.VULA_H.id, 
    						 $rootScope.MAP_OFFERTE.NGA_H.id, 
    						 $rootScope.MAP_OFFERTE.FULLGPONPLUS.id,
    						 $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id];
    	var _arrayEncapsulation = ['SINGLETAG', 'DOUBLETAG'];
    	
    	var _result = {
    		flag: true,
    		message: ''
    	};
    	
    	if(_arrayOfferte.indexOf(_offerta) > -1 ){
    	
	    	if(_lavorazione == 'attivazione' || _lavorazione == 'migrazione'){
	    		
	    		var _arrayFiltrato = [];
	    		
	    		if(_encapsulation == 'DOUBLETAG'){
	    			_arrayFiltrato = _.chain($scope.data.step4.vlanusers).pluck('CVLANID').uniq('dft').value();
	    			//Ci sono CVLANID duplicati
	    			if(_arrayFiltrato && _arrayFiltrato.length > 0 && _arrayFiltrato.length < $scope.data.step4.vlanusers.length){
	    				_result.flag = false;
	    				_result.message = "Per accessi FTTH con Encapsulation DOUBLE TAG non e' possibile associare lo stesso id a piu' di una CVLAN";
	    				$scope.caricaPassFive = false;
	    			}			
	    		}else{
					//RU_1543
	    			if([$rootScope.MAP_OFFERTE.NGA_H.id, $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id].indexOf(_offerta) > -1){
	    				_arrayFiltrato = _.chain($scope.data.step4.vlanusers).pluck('codice_vlan').uniq().value();
	        			//Ci sono codci VLAN duplicati
	        			if(_arrayFiltrato && _arrayFiltrato.length > 0 && _arrayFiltrato.length < $scope.data.step4.vlanusers.length){
		    				_result.flag = false;
		    				_result.message = "Per accessi FTTH con Encapsulation SINGLE TAG non e' possibile attestare piu' di una User VLAN sulla stessa VLAN di raccolta";
		    				$scope.caricaPassFive = false;
	        			}	
	    			}    			
	    		}
	    	}else if(_lavorazione == 'variazione'){
	        	var _opzioneVariazione = ($scope.opzioneVariazione || null);
	        	var _tipoVariazione = ($scope.data.step4.variazione || null);
	        	//SM_9954
	        	if((_opzioneVariazione == "Riconfigurazione Accesso") || (_opzioneVariazione == "Riconfigurazione UserVLAN" && (_tipoVariazione == "Variazione Numero User VLAN" || _tipoVariazione == "IncrementoDecrementoUserVlan"))){
	        		//Estrae VLAN senza AZIONE o con AZIONE = 'A'
	        		var _array = _.filter($scope.data.step4.vlanusers, function(item){
	        			return (_.isUndefined(item.AZIONE) || _.isEmpty(item.AZIONE) ||item.AZIONE.dft == 'A');
	        		});
	        		
	        		if(_encapsulation == 'DOUBLETAG'){
		    			_arrayFiltrato = _.chain(_array).pluck('CVLANID').uniq('dft').value();
		    			//Ci sono CVLANID duplicati
		    			if(_arrayFiltrato && _arrayFiltrato.length > 0 && _arrayFiltrato.length < _array.length){
		    				_result.flag = false;
		    				_result.message = "Per accessi FTTH con Encapsulation DOUBLE TAG non e' possibile associare lo stesso id a piu' di una CVLAN";
		    				$scope.caricaPassFive = false;
		    			}
	        		}else{
	    				_arrayFiltrato = _.chain(_array).pluck('codice_vlan').uniq().value();
	        			//Ci sono codci VLAN duplicati
	        			if(_arrayFiltrato && _arrayFiltrato.length > 0 && _arrayFiltrato.length < _array.length){
		    				_result.flag = false;
		    				_result.message = "Per accessi FTTH con Encapsulation SINGLE TAG non e' possibile attestare piu' di una User VLAN sulla stessa VLAN di raccolta";
		    				$scope.caricaPassFive = false;
	        			}	
	        		}	        		
	        	}
	    	}
    	}
    	
    	return _result;
    }
    
    //SM_10013
    $scope.$watch("customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){
    		if($rootScope.DettaglioAsset && ["variazione", "migrazione"].indexOf($scope.causaleOrdine) > -1){
    			$scope.data.step4.profiloTecnicoLineaAsset = $rootScope.DettaglioAsset.offerTopDetails.PROFILOTECNICOLINEA.dft;
    		}
    	}
    });
    
    //RU_1180
    /*
     * Per attivazione offerte BTSNGAFTTCAB, BBTSNGAFTTH e SEMIBTSNGAFTTH, allo step 4, se si seleziona FLAG MULTICAST (sta nella sezione inferiore):
     	* per Encapsulation == DoubleTag
			devono essere inibiti i campi CVLAN e Codice SVLAN
     	* per Encapsulation == SingleTag
			deve essere inibito il campo CodiceVlan
     */
    $scope.setUserVlanMulticast = function(vlan){
    	if(vlan && vlan.FLAGMULTICAST && vlan.FLAGMULTICAST.dft && vlan.FLAGMULTICAST.dft == 'Y'){
    		vlan.flagMulticastSelected = true;
    		if($rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft && $rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft == "DOUBLETAG"){
    			if(vlan.CVLANID){
    				vlan.CVLANID.dft = "";
    			}
    			if(vlan.SVLANCODE){
    				vlan.SVLANCODE.dft = "";
    			}    			
    		}
    		if($rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft && $rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft == "SINGLETAG"){
    			if(vlan.codice_vlan){
    				vlan.codice_vlan = "";
    			}    			
    		}
    		
    		//SM_10342
    		if(vlan.PROFILOBMD){
    			vlan.PROFILOBMD.dft = "";
    		}
    		
    		//Ricarica le bande
    		$scope.getBands();
    	}
    	else{
    		vlan.flagMulticastSelected = false;
    	}
    }
    
    
    // C11M08F87 - Verifica compatibilità Multicast
    $scope.C11M08F87 = function(){
    	var _isContrattoMulticast = ($scope.data.step2.contratto.flagMulticast || false);   
    	//RU_1210
    	var _arrayOfferteValide = [$rootScope.MAP_OFFERTE.NGA_CAB.id, $rootScope.MAP_OFFERTE.NGA_H.id, $rootScope.MAP_OFFERTE.SEMI_BTS_H.id, $rootScope.MAP_OFFERTE.VULA_CAB.id, $rootScope.MAP_OFFERTE.VULA_H.id, $rootScope.MAP_OFFERTE.SEMI_VULA_H.id, $rootScope.MAP_OFFERTE.FULLGPONPLUS.id, $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id];
    	var _idOfferta = ($scope.data.step3.offerta.idOfferta || null);
    	var _opzioneVariazione = ($scope.opzioneVariazione || null);
    	var _variazione = ($scope.data.step4.variazione || null);
    	var _lavorazione = $scope.causaleOrdine;
    	var _vlans = [];
    	angular.copy($scope.data.step4.vlanusers, _vlans);
    	
    	var _message_1 = "Contratto non abilitato al Multicast";
    	var _message_2 = "Non e' possibile avere piu' di una User VLAN dedicata al servizio multicast.";
    	var _message_3 = "Non e' possibile avere esclusivamente User VLAN dedicate al servizio multicast. Aggiungere almeno un'altra User VLAN per traffico dati. Eventualmente modificare il tagging";
    	
    	var _result = {
        		flag: true,
        		message: ''
        	};
    	
    	//SM_10255
    	if(_arrayOfferteValide.indexOf(_idOfferta) > -1){    		
    		var _resArray = [];    		
    		if(["attivazione", "migrazione"].indexOf(_lavorazione) > -1){
    			_resArray = $scope.userVlanFilterMulticastAttivazione(_vlans);  
    		}    		
    		if(_lavorazione == "variazione"){    			
    			if(_opzioneVariazione == "Riconfigurazione Accesso"){
    				_resArray = $scope.userVlanFilterMulticastAttivazione(_vlans);
    			}    			
    			if(_opzioneVariazione == "Riconfigurazione UserVLAN"){
    				_resArray = $scope.userVlanFilterMulticastVariazione(_vlans);    				
    			}
    			
    			_vlans = $scope.userVlanFilterVariazione(_vlans);
    		}    		
    		if(_resArray){    		
    			
    			var _numeroVlanValide = ($scope.data.step4.vlanusers.length - (_resArray.length + _vlans.length)); 
    			
    			//Se è stata selezionata una UserVLAN multicast ed il contratto non ha flag multicast
    			if(!_isContrattoMulticast && _resArray.length > 0){    				
    				_result.flag = false;
    				_result.message = _message_1;    				
    				return _result;
    			}
    			//Se sono state selezionate più UserVLAN multicast
    			if(_resArray.length > 1){
    				_result.flag = false;
    				_result.message = _message_2;    				
    				return _result;
    			}    			
    			//Se è stata selezionata solo una UserVLAN ed è anche multicast
    			if(_lavorazione == "variazione"){
    				if(_opzioneVariazione == "Riconfigurazione Accesso" && _resArray.length == 1 && _resArray.length == _vlans.length){
        				_result.flag = false;
        				_result.message = _message_3;    				
        				return _result;
    				}
    				
    				//SM_10259
    				if(_opzioneVariazione == "Riconfigurazione UserVLAN"){
    					
    					if(_variazione == "Variazione Tagging" && _resArray.length == 1){
            				_result.flag = false;
            				_result.message = _message_3;    				
            				return _result;
    					}
    					
    					if(_variazione == "Variazione Numero User VLAN"){
    						    						
    						if(_resArray.length == 1 && _numeroVlanValide == 0){
    	        				_result.flag = false;
    	        				_result.message = _message_3;    				
    	        				return _result;
    						}
    						if(_resArray.length > 1){
    	        				_result.flag = false;
    	        				_result.message = _message_2;    				
    	        				return _result;
    						}
    					}
    					
    				}    				
    			}
    			//SM_10267
    			if(["attivazione", "migrazione"].indexOf(_lavorazione) > -1){
    				if(_resArray.length == 1 && _resArray.length == _vlans.length){
        				_result.flag = false;
        				_result.message = _message_3;    				
        				return _result;
    				}
    			}
    		}
    	}     	
    	return _result;
    }
    
    $scope.userVlanFilterMulticastAttivazione = function(vlans){    	
    	var _res = [];    	
    	if(vlans && vlans.length > 0){
    		_res = _.filter(vlans, function(item){
			    return (item["FLAGMULTICAST"] && item["FLAGMULTICAST"].dft && item["FLAGMULTICAST"].dft == "Y");    			
			});
    	}    	
    	return _res;
    }
    
    $scope.userVlanFilterMulticastVariazione = function(vlans){    	
    	var _res = [];    	
    	if(vlans && vlans.length > 0){
    		_res = _.filter(vlans, function(item){
    			//Se non si tratta di una VLAN da eliminare
    			if(!(item["AZIONE"]) || (item["AZIONE"] && item["AZIONE"].dft && item["AZIONE"].dft != 'C')){
    				return (item["FLAGMULTICAST"] && item["FLAGMULTICAST"].dft && item["FLAGMULTICAST"].dft == "Y");
    			}
			});
    	}    	
    	return _res;
    }
    
    $scope.userVlanFilterVariazione = function(vlans){    	
    	var _res = [];    	
    	if(vlans && vlans.length > 0){
    		_res = _.filter(vlans, function(item){
    			//Se si tratta di una VLAN da eliminare
    			return(item["ELIMINA"] && item["ELIMINA"].dft && item["ELIMINA"].dft == true && !item.flagMulticastSelected);
			});
    	}    	
    	return _res;
    }
    
    // RU_1560
    $scope.oscuramento_RU_1560 = function(){
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1560.oscurato){
    				$scope.RU_1560 = ($rootScope.OSCURAMENTI.RU_1560.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_1560 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_1560 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1560();  
      
    $scope.getCodiceOperatoreSecondario = function() {
		GetCodiceOperatoreSecondario.get({codOloAgcom: $rootScope.data.step1.operatore.codiceOLO})
			.$promise
			.then(function(response) {
				if(response.CodiceOperatoreSecondario) {
					$scope.codiceOperatoreSecondarioList = response.CodiceOperatoreSecondario;
				} else {
					$scope.codiceOperatoreSecondarioList = []
				}
			}, function(error) {
				modalService.showModal({}, {
                    headerText: "Nuovo ordine",
                    bodyText: "Impossibile caricare la lista di codici operatore secondario.",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
			});
	}
	
	if($scope.RU_1560 && $scope.causaleOrdine==='attivazione') {
		$scope.getCodiceOperatoreSecondario();
	}
	
}]);
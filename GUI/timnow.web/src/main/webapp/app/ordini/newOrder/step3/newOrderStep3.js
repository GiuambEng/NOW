timnow
    .controller('newOrderStep3', ['alertService','$scope', '$state', '$rootScope', '$log', 'Offers', 'checkOao', 'VerificaCongruenzaOffertaCodOrdine','Verificacodiceordineolo', 'VLANUtils', 'VLAN_RACCOLTA_SERVIZI', 'VLAN_VARIAZIONI', 'VerificaContratto', 'NewOrderControlliService', '$q', 
    		function (alertService, $scope, $state, $rootScope, $log, Offers, checkOao, VerificaCongruenzaOffertaCodOrdine, Verificacodiceordineolo, VLANUtils, VLAN_RACCOLTA_SERVIZI, VLAN_VARIAZIONI, VerificaContratto, NewOrderControlliService, $q) {
        $scope.spinOptionVariazione = false;
        $scope.calcolatoDatiDaAsset=false;

        $scope.svuotaNP = function () {
        	if($scope.data.step7 && $scope.data.step7.routingNumber){$scope.data.step7.routingNumber="";}
        	if($scope.data.step7 && $scope.data.step7.visibilitaAggiuntivi){$scope.data.step7.visibilitaAggiuntivi=false;}
    	};
    	
    	//RU_716
    	$scope.verificaTipologiaLavorazioneFwa = function(lavorazione, contratto) { //In caso di Tipologia Lavorazione diverso da Attivazione e Contratto corrispondente all’Offerta = Fixed Wireless Access, restituire un KO, altrimenti OK
    		if($rootScope.data.step3.offerta.nomeOffertaCatalogo === 'FixedWirelessAccess' && (lavorazione.toLowerCase() != "attivazione" && lavorazione.toLowerCase() != "cessazione") && contratto.idSottofamigliaOfferta == $rootScope.data.step3.offerta.idOfferta == "46") {
    			return false;
    		} else {
    			return true;
    		}
    	};
    	
      // CLEAN STEP 4 DOPO CAMBIO OPZIONE VARIAZIONE
        $scope.cambiaOpzioneVariazione = function(){
            	if($rootScope.customizedOffer){
            		$rootScope.customizedOffer = {};
            	}
        	
        	$scope.getOfferDetails('reload');
        };
   	
        if (!$rootScope.data.step3) $rootScope.data.step3 = $scope.data.step3 = {};
        if ($rootScope.formData.stepReached < 3){
        	$rootScope.formData.stepReached = 3;
        }else{
        	$scope.loadStep3 = false;
            $scope.errColl = false;
        }
        
        $scope.getOfferDetails = function (actionSelect) {
        	if(($rootScope.data.step1 && $rootScope.data.step1.causale_ordine === 'variazione') && ($rootScope.formData.data.step2 && $rootScope.formData.data.step2.fromVariazione)){
//        		C11M08F39 – Recupera Lista Opzioni Variazioni per Servizio (S6)
        		//RU_716
        		var valoriConf = [{"funzione" : "C11M08F39", "idOfferta" : $rootScope.formData.data.step2.fromVariazione.idOfferta}];
        		$scope.spinOptionVariazione = true;
        		$scope.configurazioneFE(valoriConf).then(function (response) {
        			if(response.data.length === 0){
        				alertService.add("Non ci sono Opzioni Variazione per questo Tipo di Variazione","danger",15000);
        			}
        			$scope.data.option = response.data;
					if($rootScope.OSCURAMENTI.RU_1614.oscurato) {
						$scope.data.option = $scope.data.option.filter(function(item) {
							return item.codice !== 'VariazioneParentalControl';
						});
					}
        			$scope.spinOptionVariazione = false;
    	        },
    	        function (error) {
    	        	$scope.spinOptionVariazione = false;
    	        	$log.info('Impossibile caricare gli  STS');
    	        	$log.info(error);
    	        });
        	}
        	
            if ($rootScope.formData.data && ($rootScope.data.step3.offertaLabel || ($rootScope.formData.data.step2 && $rootScope.formData.data.step2.fromVariazione))) {
                if (!$rootScope.formData.offerDetails || (actionSelect === "reload")) {
                	$scope.calcolatoDatiDaAsset=false;
                    $scope.loadStep3 = true;
                    if (actionSelect === "reload") {
                    	
                    	$rootScope.formData.stepReached = 3;
						$rootScope.formData.data.step4 =null;
						$rootScope.formData.step4 =null;
						$rootScope.data.step4 = null;
                        $rootScope.formData.data.step7 = null;
                        $rootScope.formData.step7 =null; 
                        $rootScope.data.step7 = null;
                        if ($rootScope.formData.offerDetails && $rootScope.formData.offerDetails.offerBotDetails) {
                            $rootScope.formData.offerDetails.offerBotDetails = {};
                        }
                        delete $rootScope.customizedOffer;
                        
                    }
                   
                    
                    if($rootScope.data.step3 && $rootScope.data.step3.offertaLabel){
                    	$rootScope.data.step3.offerta = angular.fromJson($rootScope.data.step3.offertaLabel);
                    	$rootScope.data.step3.tipologia_ordine = $rootScope.data.step3.offerta.tipoOrdine;
                    	$rootScope.data.idOffertaCatalogo = $rootScope.data.step3.offerta.idOfferta;
                    }
                    if($rootScope.bozza
						&& $rootScope.bozza.data
						&& $rootScope.bozza.data.step3
						&& $rootScope.bozza.data.step3.visibilitaNP
						&& [$rootScope.MAP_OFFERTE.ULL_LA.id,$rootScope.MAP_OFFERTE.ULLD_LA.id,$rootScope.MAP_OFFERTE.SLU_LA.id].indexOf($rootScope.data.step3.offerta.idOfferta) >= 0) {
                        $rootScope.data.step3.visibilitaNP = $rootScope.bozza.data.step3.visibilitaNP;
					} else if ($rootScope.data && $rootScope.data.step1
						&& $rootScope.data.step1.causale_ordine === 'attivazione'
						&& $rootScope.data.step3 && $rootScope.data.step3.offerta
						&& [$rootScope.MAP_OFFERTE.ULL_LA.id,$rootScope.MAP_OFFERTE.ULLD_LA.id,$rootScope.MAP_OFFERTE.SLU_LA.id].indexOf($rootScope.data.step3.offerta.idOfferta) >= 0
						){
                    	$rootScope.data.step3.visibilitaNP = false;
                    }else{
                    	delete $rootScope.data.step3.visibilitaNP;
                    }
                    

                    if($rootScope.data.step1.causale_ordine === 'variazione'){

                        $rootScope.data.idOffertaCatalogo = null;

						if($rootScope.data.step2.fromVariazione){
							$rootScope.data.idOffertaCatalogo = $rootScope.data.step2.fromVariazione.idOfferta;
						} else {
                            $scope.erroreService("Impossibile caricare le offerte per il contratto selezionato. Riprovare più tardi");
						}

                    }
                                
                    Offers.get({offerId: $rootScope.data.idOffertaCatalogo}).$promise.then(
                        function (response) {
							if(response.offerDetail){
	                        	$scope.loadStep3 = false;
	                            $scope.errColl = false;
	                            
	                            if($rootScope.data.step1.causale_ordine === 'variazione'){
	                            	$scope.data.identificativoContratto = $rootScope.formData.data.step2.fromVariazione.identificativoContratto;
		                            $rootScope.foundContratto= false;
		                            
		                            if(!$rootScope.formData.offers){
		                            	Offers.get({
		                                    contratto: $rootScope.formData.data.step2.fromVariazione.identificativoContratto, 
		                                    azione: $rootScope.data.step1.causale_ordine
		                                }).$promise.then(function (response2) {
		                                        $rootScope.formData.offers = filtraOfferteByRU(response2.data);
		                                        for(var i=0; i<$rootScope.formData.offers.length; i++){
		    		                         		if($rootScope.formData.offers[i].idOfferta===$rootScope.formData.data.step2.fromVariazione.idOfferta){
		    		                         			$scope.data.step3.offerta = angular.fromJson($rootScope.formData.offers[i]);
		    		                         			$scope.data.step3.tipologia_ordine = $scope.data.step3.offerta.tipoOrdine;
		    		                         			$scope.data.idOffertaCatalogo = $scope.data.step3.offerta.idOfferta;
		    		                                 	$rootScope.foundContratto=true;
		    		                         		}
		    		                         	}
		    		                            if(!$rootScope.foundContratto){
		    		                            	alertService.add("L'ID Offerta dell'asset non corrisponde al contratto specifico","danger",40000);
		    		                            }  
		                                    }, function () {
		                                        $scope.erroreService("Impossibile caricare le offerte per il contratto selezionato. Riprovare più tardi");
		                                    });
		                            }else{
		                            	 for(var i=0; i<$rootScope.formData.offers.length; i++){
	    		                         		if($rootScope.formData.offers[i].idOfferta===$rootScope.formData.data.step2.fromVariazione.idOfferta){
	    		                         			$scope.data.step3.offerta = angular.fromJson($rootScope.formData.offers[i]);
	    		                         			$scope.data.step3.tipologia_ordine = $scope.data.step3.offerta.tipoOrdine;
	    		                                 	$rootScope.data.idOffertaCatalogo = $scope.data.step3.offerta.idOfferta;
	    		                                 	$rootScope.foundContratto=true;
	    		                         		}
	    		                         	}
	    		                            if(!$rootScope.foundContratto){
	    		                            	alertService.add("L'ID Offerta dell'asset non corrisponde al contratto specifico","danger",40000);
	    		                            }  
		                            }
	                            }else{
	                            	$scope.data.identificativoContratto = $rootScope.data.step2.contratto.idContratto;
	                            }
	                            $scope.customizedOffertCreation(response.offerDetail);
                            } else {
                            	alertService.add("Impossibile caricare il dettaglio della offerta selezionata.","danger",15000);
                            	$scope.loadStep3 = false;
                                $scope.errColl = true;
                            }
                        },
                        function (error) {
                            $log.debug(error);
                            alertService.add("Impossibile caricare il dettaglio della offerta selezionata.","danger",15000);
                            $scope.loadStep3 = false;
                            $scope.errColl = true;
                        });
                    
                    
//                  SVUOTO ONFIELD SE PASSO DA LINEA NON ATTIVA AD ATTIVA
                    if((actionSelect === "reload") && ($rootScope.data.step1.causale_ordine === 'attivazione') && ($scope.data.step5 && $scope.data.step5.datiReferentiOnField) && [$rootScope.MAP_OFFERTE.ULL_LA.id,$rootScope.MAP_OFFERTE.ULLD_LA.id,
                                                                                                                                                                            		$rootScope.MAP_OFFERTE.SLU_LA.id,$rootScope.MAP_OFFERTE.SHA_SM.id,
                                                                                                                                                                            		$rootScope.MAP_OFFERTE.WLR_LA.id,$rootScope.MAP_OFFERTE.VULL_LA.id].indexOf($rootScope.data.step3.offerta.idOfferta) >= 0){
                    	delete $scope.data.step5.datiReferentiOnField;
                    }
                } else {
                    $scope.loadStep3 = false;
                    $scope.errColl = false;
                }
            }
        };
        
        // utility per filtrare le offerte in base alle RU (utile per quando una RU introduce nuove offerte)
        filtraOfferteByRU = function(offers) {
			if($rootScope.OSCURAMENTI.RU_1581.oscurato) {
				offers = contracts.filter(p => $rootScope.OSCURAMENTI.RU_1581.idOfferteValide.indexOf(p.idOfferta) == -1);
			}
			return offers;
		}

        if($rootScope.data && $rootScope.data.step1 && $rootScope.data.step1.causale_ordine === 'variazione' || ($rootScope.data.step1 && $rootScope.data.step1.causale_ordine === 'migrazione' && $rootScope.bozza)){
        	$scope.getOfferDetails();
        }
        $scope.isForm3Disabled = function () {
            return (!$scope.data.step3.offerta);
        };
        
        if ($rootScope.bozza) {
            $scope.data.step3 = $rootScope.data.step3 = $rootScope.bozza.data.step3;
            $scope.getOfferDetails();
        } 
        
        //creazione Customized Offer e Gestione Della Consistenza della Variazione
        $scope.customizedOffertCreation = function (response) {
        	$rootScope.formData.offerDetails = response;
        	if(!$rootScope.customizedOffer){
        		$rootScope.customizedOffer = angular.copy($rootScope.formData.offerDetails);
        	
	            angular.forEach($rootScope.customizedOffer, function (item) {
	            	angular.forEach(item, function (value) {
	                	if(value.dft){
	                		value.dft="";
	                	}
	                });
	            });
        	}
        	// $log.info($rootScope.customizedOffer);
            $rootScope.topDetails = $rootScope.formData.offerDetails.offerTopDetails;
            if ($rootScope.topDetails.CODICEPRODOTTOMODEM) {
                if ($rootScope.topDetails.CODICEPRODOTTOMODEM.dft)
                    $rootScope.modemCodiceProdotto = $rootScope.topDetails.CODICEPRODOTTOMODEM.dft.split(';');
            }
            if ($rootScope.topDetails.DESCRIZIONE) {
                if ($rootScope.topDetails.DESCRIZIONE.dft)
                    $rootScope.modemDescrizioneProdotto = $rootScope.topDetails.DESCRIZIONE.dft.split(';');
            }
            if ($rootScope.topDetails.INTERFACCIA) {
                if ($rootScope.topDetails.INTERFACCIA.dft)
                    $rootScope.modemInterfaccia = $rootScope.topDetails.INTERFACCIA.dft.split(';');
            }
            $rootScope.botDetails = $rootScope.formData.offerDetails.offerBotDetails;
            
            if($rootScope.data.step1.causale_ordine === 'variazione'){
            	//SM_9723
            	if($rootScope.bozza && $rootScope.bozza.customizedOffer){
            		angular.copy($rootScope.bozza.customizedOffer, $rootScope.customizedOffer);
            	}
            	
            	$scope.datiVariazioneDaAsset();
            }
        };
                
        //TASK#33416
        $scope.verificaVariazioniVLAN = function(){
        	
        	var _raccoltaServizi = [];
        	var _famigliaVlan = null;
        	var _COS = [];
        	var _cos = [];
        	
        	var _variazione = $scope.data.step3.opzioneVariazione;
        	
    		switch($scope.data.assetDetail.idOfferta){
			case $rootScope.MAP_OFFERTE.VLAN_NGA.id:
					_raccoltaServizi = VLAN_RACCOLTA_SERVIZI.VLAN_NGA;
				break;
			case $rootScope.MAP_OFFERTE.VLAN_GBE.id:
					_raccoltaServizi = VLAN_RACCOLTA_SERVIZI.VLAN_GBE;
				break;
			case $rootScope.MAP_OFFERTE.VLAN_VULA.id:
					_raccoltaServizi = VLAN_RACCOLTA_SERVIZI.VLAN_VULA;
				break;
    		}
    		
    		VLANUtils.estraiDettagliAsset($scope.data.assetDetail);
    		VLANUtils.estraiTipoCosDaAsset($scope.data.assetDetail);
        	_famigliaVlan = VLANUtils.estraiCampoDettagliAsset(_raccoltaServizi, 'FAMIGLIAVLAN');
        	_COS = VLANUtils.estraiCampoSezioneInferiore('IDENTIFICATIVOCOS');    
        	
        	//SM_9791
        	if(_COS && _COS.length > 0){
            	_COS.forEach(function(item){
            		_cos.push(item.dft);
            	});
        	}
      	     
        	//Task #33790
        	if([VLAN_VARIAZIONI.VARIAZIONE_TDKIT].indexOf(_variazione) > -1){
        		if(_famigliaVlan == '3'){
        			return {esito: 'KO', messaggio: 'Per questa consistenza non è possibile effettuare questo tipo di variazione'};
        		}
        	}
        	
        	if([VLAN_VARIAZIONI.VARIAZIONE_CAR].indexOf(_variazione) > -1){
        		if(_famigliaVlan == '3' || (_famigliaVlan == '1' && (_cos.indexOf('3') > -1 || _cos.indexOf('5') > -1))){
        			return {esito: 'KO', messaggio: 'Per questa consistenza non è possibile effettuare questo tipo di variazione'};
        		}
        	}   
        	
        	if([VLAN_VARIAZIONI.VARIAZIONE_BANDA].indexOf(_variazione) > -1){
        		if(_famigliaVlan == '3' || (_famigliaVlan == '1' && (_cos.indexOf('0') > -1 || _cos.indexOf('1') > -1))){
        			return {esito: 'KO', messaggio: 'Per questa consistenza non è possibile effettuare questo tipo di variazione'};
        		}
        	}
        	
        	return {esito: 'OK', messaggio: ''};        	
        }
        
        //RU_1306
        $scope.verificaContratto = function(){
    		var _request = {
    			codiceOloAgcom: $scope.data.step1.operatore.codiceOLO,
    			lavorazione: $scope.data.step1.causale_ordine,
    			offerta: $scope.data.step3.offerta.idOfferta,
    			idContratto: $scope.data.step2.contratto.idContratto
    		};
    	
    		return VerificaContratto
    			.save(_request)
    			.$promise;
    	}
    	
		$scope.ctrlOkOlo = function (service3_OK) {
		    if (service3_OK === 2) {
		        //$log.info($rootScope.data.step3.tipologia_ordine);		
		        //C11M08F41 – Verifica Congruenza Intestatario Ordine-IDRisorsa (S6)
		        VerificaCongruenzaOffertaCodOrdine.get({
		            idOfferta: $rootScope.data.step3.offerta.idOfferta,
		            codOrdine: $rootScope.data.step1.codice_ordine,
		            codOrdinePadre: $rootScope.data.step1.codice_ordine_padre
		        }).$promise.then(
		            function (response) {
		            if (response.esito === "OK") {
		                $scope.loadStep3 = false;
		                if ($rootScope.formData.stepReached < 4)
		                    $rootScope.formData.stepReached = 4;
		
		                if ($rootScope.data.step1.causale_ordine !== 'variazione' || (
		                        $rootScope.data.step1.causale_ordine === 'variazione' && $rootScope.foundContratto)) {
		
		                    //	C04M03F19
		                    if ($rootScope.data.step1.causale_ordine === 'migrazione' && ([$rootScope.MAP_OFFERTE.GBE_SF.id,
		                                $rootScope.MAP_OFFERTE.ATM_SF.id,
		                                $rootScope.MAP_OFFERTE.ATM_SH.id
		                            ].indexOf($scope.data.step3.offerta.idOfferta) >= 0)) {
		                        $scope.erroreService("Non è possibile effettuare una migrazione verso Servizi Simmetrici");
		                    } else {
		
		                        //C11M08F65 - Verifica Tipologia Lavorazione per FWA (C11)
		                        if (!$scope.verificaTipologiaLavorazioneFwa($rootScope.data.step1.causale_ordine, $rootScope.data.step2.contratto)) {
		                            $scope.erroreService("I criteri impostati non sono corretti");
		                            $scope.loadStep3 = false;
		                        } else {
		                            if ($rootScope.formData.stepReached < 4)
		                                $rootScope.formData.stepReached = 4;
		                            //RU_833 FIX FWA CESSAZIONE
		                            if ($rootScope.formData.step1.causale_ordine === 'attivazione' && $rootScope.formData.step3.offerta.idOfferta === '46') {
		                                Verificacodiceordineolo.get({
		                                    codiceOrdineOlo: $rootScope.formData.step1.codice_ordine,
		                                    codOloAgcom: $rootScope.formData.step1.operatore.codiceOLO
		                                }).$promise.then(
		                                    function (response) {
		                                    if (response.esito === "OK") {
		                                        $state.go($scope.checkNextState());
		                                    } else {
		                                        $scope.erroreService(response.message);
		                                        return
		                                    }
		                                },
		                                    function () {
		                                    $scope.erroreService("Errore VerificaCodiceOrdineOlo");
		                                    return
		                                });
		                            } else {
		                                $state.go($scope.checkNextState());
		                            }
		                        }
		
		                    }
		
		                } else {
		                    $scope.erroreService("L'ID Offerta dell'asset non corrisponde al contratto specifico");
		                }
		            } else {
		                $scope.erroreService("Per l’Offerta selezionata il Codice Ordine e il Codice Ordine Padre non deve superare 11 caratteri. Torna a Pagina 1 per effettuare la modifica");
		                $scope.loadStep3 = false;
		            }
		        }, function () {
		            $scope.erroreService("Impossibile verificare la Congruenza Intestatario Ordine ID Risorsa");
		            $scope.loadStep3 = false;
		        });
		    } else {
		        $log.info("I servizi controllo OLO non sono andati a buon fine (" + service3_OK + " di 2)");
		        $scope.loadStep3 = false;
		    }
		
		};
        
        
//		PASSAGGIO ALLO STEP 4
        $scope.submit_3 = function () {
        	$scope.loadStep3 = true;
            $rootScope.data.step3 = $scope.data.step3;
            //$log.info($rootScope.data);
            $rootScope.formData.data.step3 = $rootScope.data.step3;
            
            //RU_1452
            //C11M08F96 - Verifica Offerta CPS
            if($rootScope.data.step1.causale_ordine == 'attivazione' && 
            	!$rootScope.OSCURAMENTI.RU_1452.oscurato &&
            	$scope.data.step3.offerta.idOfferta == $rootScope.MAP_OFFERTE.CPS.id){
				$scope.loadStep3 = false;
				$scope.erroreService("Non e' possibile selezionare l'offerta ");
				return;
			} 
            
            //RU_1400
            if(['attivazione', 'migrazione'].indexOf($rootScope.data.step1.causale_ordine) > -1 && 
            	!$rootScope.OSCURAMENTI.RU_1400.oscurato &&
            	$rootScope.OSCURAMENTI.RU_1400.idOfferteNonValide.indexOf($scope.data.step3.offerta.idOfferta) > -1){
				$scope.loadStep3 = false;
				$scope.erroreService("Non e' possibile selezionare l'offerta ");
				return;
			}  
			
			// eseguo controlli rest a cascata
			$scope.loadStep3 = true;
			$scope.caricaPassFive = true;
			
			$q.all([
			    verificaContrattoWrapped(),
			    verificaMigrazioneFTTH()
			]).then(function(){
			    // tutti i controlli OK
			    $scope._submit3();
			}).catch(function(errorMsg) {
			    $scope.loadStep3 = false;
			    $scope.caricaPassFive = false;
			    $scope.erroreService(errorMsg);
			});
			
        }
        
        function verificaContrattoWrapped() {
			var deferred = $q.defer();
			
			//RU_1306
            var _offerteSEMIFTTH = [$rootScope.MAP_OFFERTE.SEMI_VULA_H.id, $rootScope.MAP_OFFERTE.SEMI_BTS_H.id, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id];
            if($rootScope.data.step1.causale_ordine != 'cessazione' && (_offerteSEMIFTTH.indexOf($scope.data.step3.offerta.idOfferta) > -1)){
					$scope.verificaContratto()
		    		.then(function(response){
		    			if(response.verificaContrattoOutput && response.verificaContrattoOutput.esito.toUpperCase() === 'KO'){
		    				deferred.reject(response.verificaContrattoOutput.message);
		    			}else{
		    				 deferred.resolve();
		    			}		    			
		    		}, function(error) {
		    			deferred.reject("Errore verifica contratto OLO");
					});	
			}else{
				 deferred.resolve();
			}
			return deferred.promise;
			
		}
		
		function verificaMigrazioneFTTH() {
			var deferred = $q.defer();
			
			// RU_1560 --> C11M08F114 verifica migrazione FTTH
			if($rootScope.data.step1.causale_ordine === 'migrazione' && $scope.RU_1560) {
				var _offerta = $rootScope.data.step3.offerta.nomeOffertaCatalogo.toUpperCase();
				var _idAsset = ($scope.data.step2.idAssetScelto ? $scope.data.step2.idAssetScelto.idAsset : null);
				NewOrderControlliService.C11M08F114(_idAsset, _offerta)
					.then(function(_result){
						if(_result.esito == "KO"){
							deferred.reject("Per le migrazioni di accessi FTTH, utilizzare ordini di migrazione Del. 82");
						} else {
							deferred.resolve();
						}
					}, function(error){
						deferred.reject("Impossibile richiamare il servizio di Verifica migrazione FTTH");
					});	
			} else {
				 deferred.resolve();	
			}
			return deferred.promise;
		}
        
        $scope._submit3 = function(){
			//SM_9723
            var _offerteVLAN_VP = [$rootScope.MAP_OFFERTE.VLAN_NGA.id, $rootScope.MAP_OFFERTE.VLAN_GBE.id, $rootScope.MAP_OFFERTE.VLAN_VULA.id, $rootScope.MAP_OFFERTE.VP.id];
            if(_offerteVLAN_VP.indexOf($rootScope.data.step3.offerta.idOfferta) > -1 && $rootScope.data.step1.causale_ordine === 'variazione'){
            	//TASK#33416
            	var _check = $scope.verificaVariazioniVLAN();
            	
            	if(_check.esito == 'KO'){
            		$scope.erroreService(_check.messaggio);
            		$scope.loadStep3 = false;
            	}else{
            		$state.go($scope.checkNextState());
            	}
            }else{
            	
                var service3_OK = 0;

                $scope.actOAO = function (service3_OK) {
                    $scope.loadStep3 = false;
                	
                	if($rootScope.data.step3.offerta  && $rootScope.data.step3.offerta.idOfferta){
                		var activeOAO = checkOao.get({type:'checkActivationOao',
    						            			codOlo: $rootScope.data.step1.operatore.codiceOLO,
    						                        idOfferta: $rootScope.data.step3.offerta.idOfferta},{
                            idContratto: $scope.data.identificativoContratto
                        });
                        activeOAO.$promise.then(
                            function (response) {
                                $scope.esitoOloVal = response.esito;
                                if ($scope.esitoOloVal === "OK") {
                                    service3_OK++;
                                }
                                else {
                                    $log.info("La verifica OLO Attivo non è andata a buon fine (" + response.esito + ")");
                                    $scope.erroreService("L'OAO scelto non può effettuare ordini sull'offerta selezionata");
                                }
                                $scope.ctrlOkOlo(service3_OK);
                            },
                            function (error) {
                                    $log.debug(error);
                            		$scope.erroreService("La verifica OLO non è andata a buon fine");
                            }
                        );
                	}else{
                		$scope.erroreService("La verifica OLO non è andata a buon fine");
                	}
                };
                $scope.actOAO(++service3_OK);
                $scope.controlloBozza(4);             	
            }
		}
		
		        // RU_1560
	    $scope.oscuramento_RU_1560 = function(){
	    	try{
	    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){  
	    			if(!$rootScope.OSCURAMENTI.RU_1560.oscurato){
						var offerteValide = [$rootScope.MAP_OFFERTE.NGA_H.id, 
											$rootScope.MAP_OFFERTE.SEMI_BTS_H.id, 
											$rootScope.MAP_OFFERTE.VULA_H.id, 
											$rootScope.MAP_OFFERTE.SEMI_VULA_H.id,
											$rootScope.MAP_OFFERTE.EASY_H.id,
											$rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id,
											$rootScope.MAP_OFFERTE.FULLGPONPLUS.id,
											$rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id]				
	    				$scope.RU_1560 = (offerteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
	    			}else{
	    				$scope.RU_1560 = false;
	    			}           			
	    		}
	    	}catch(e){
	    		$scope.RU_1560 = false;
	    	}          	
	    }
	    
	   	$scope.$watch('data.step3.offerta', function(newValue){
	    	if(newValue && newValue.idOfferta){
	    		$scope.oscuramento_RU_1560();
	    	}
        });
   	
    }]);

timnow.controller('cessazioneNewOrder', [
    '$scope',
    '$state',
    '$rootScope',
    '$log',
    'Assets',
    'modalService',
    'Orders',
    'ConvertDateService',
    'SlaValidationService',
    '$filter',
    'ordersAction',
    'Locator',
    'RecuperaIdAsset',
    'VerificaCongruenzaOffertaCodOrdine',
    'Verificacodiceordineolo',
    'VerificaInConsistenzaPresenzaModem',
    'VerificaCarrierOloCps', //RU_15
    'VerificaContratto', //RU_915
    'Offers',	//RU_915
    'uibDateParser', //SM_9010
    'TRACKING_GUI', //RU_1010
    'TrackingGUI', //RU_1010
    'Tokenizzazione', //SM_9654
    'Projects', //SM_10033,
    'VerificaRecuperoModem', //RU_1181
    '_',
    function ($scope, $state, $rootScope, $log, Assets, modalService, Orders, ConvertDateService, SlaValidationService, $filter,ordersAction, Locator, RecuperaIdAsset, VerificaCongruenzaOffertaCodOrdine, Verificacodiceordineolo, VerificaInConsistenzaPresenzaModem, VerificaCarrierOloCps, VerificaContratto, Offers, uibDateParser, TRACKING_GUI, TrackingGUI, Tokenizzazione, Projects, VerificaRecuperoModem, _) {
        $rootScope.pageClass = $state.params.pageClass;
        
        //RU_871
        $scope.caricaPassFour = false;
        $scope.referentView = [true, false, false, false];
        $scope.bitstreamSimm = false;
        //RU_871
        $scope.flagRefModem = false;
        $scope.formDaValidare = false;
        
        //RU_915
        $scope.alphanumeric = /^[a-zA-Z0-9 ]*$/i;
        $scope.regDate = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
        $scope.onlyChar = /^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$/;
        $scope.integerval = /^\d*$/;
        $scope.isOffertaCps = false;
        $scope.accordionOpen = [true, false, false];
        $scope.showRadicale = false;
        $scope.showQuantitaLinee = false;
        $scope.isRadicaleRequired = false;
        $scope.isQuantitaLineeRequired = false;
        
        //SM_9049
        $scope.showDnPrimario = false;
        
        $scope.disableButtonAvanti = false
        
        //RU_915
        $scope.popup_dataSottoscrizioneContratto = {
        	opened: false 
        };
        $scope.popup_dataEmissione = {
          	opened: false 
        };
        $scope.popup_dataSottoscrizioneNuovoContratto = {
           	opened: false 
        };
        $scope.popup_dataRichiestaCessazione = {
           	opened: false 
        };
        //RU_915
        $scope.inlineOptions = {
                customClass: getDayClass,
                minDate: new Date(),
                showWeeks: false
            };
        
        $scope.dateOptions = {
                dateDisabled: disabled,
                formatYear: 'yy',
                maxDate: new Date(new Date().setDate(new Date().getDate()-1)), //intervallo date (-infinito, ieri]
                startingDay: 1
        };
        
        //SM_8990
        $scope.dataCessazioneOptions = {
                dateDisabled: disabled,
                formatYear: 'yy',
                startingDay: 1
        };
        
        $scope.formats = ['dd/MM/yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];
        
        // Disable weekend selection
        function disabled(data) {
            var date = data.date, mode = data.mode;
            return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
        }
        
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
        
        //SM_9010
        $scope.$watch("customizedOffer.offerTopDetails.DSC.dft", function(newValue, oldValue){
        	if(newValue && newValue != oldValue){
        		$rootScope.customizedOffer.offerTopDetails.DSC.dft = uibDateParser.parse(newValue, 'yyyy-MM-dd');
        	}
        });
        
        //SM_9010
        $scope.initArrayStrutturaLinea = function(){
  	    	if($rootScope.topDetails && $rootScope.topDetails.STRUTTURALINEA){
   				try{
					$scope.arrayStrutturaLinea = $rootScope.topDetails.STRUTTURALINEA['dft'].split(';');
				}catch(e){
					$scope.arrayStrutturaLinea = [];
				}
  	    	}
        }
        
        	//RU_1543
    	$scope.oscuramento_RU_1543 = function() {
			$scope.RU_1543 = !$rootScope.OSCURAMENTI.RU_1543.oscurato;
    	}
    	
    	$scope.oscuramento_RU_1543();
        
        $scope.init = function () {
            $scope.assetDetails = {};
            $scope.assetDetail = $rootScope.assetDetail || null;
            $scope.data = $rootScope.formData || {};
            $rootScope.dacValidato = false;
            $rootScope.dacMessaggioErrore = null;
            $scope.attesaRispostaChiamata=false;
            $rootScope.codordpadlngt = 30;
            
            if (angular.isUndefined($scope.data.step1)) {
                $state.go('root.ordini.new', {"init": true});
            }
            
            $scope.controlloVisibilitaInput();
            
            if (!$scope.data.step2) {
                $scope.data.step2 = [];
            }
            if (!$scope.data.step3) {
                $scope.data.step3 = [];
            }
            if (!$rootScope.formData) {
                $rootScope.formData = {
                    data: {}
                };
            }
            $scope.popup_dp2 = {
                    opened: false
                };
            $scope.popup_dp1 = {
                    opened: false
                };
            
            //RU_871
            if($rootScope.assetDetail) {
            	angular.forEach($rootScope.assetDetail.servizi,
                        function (field) {
                            if(field.prodotto.toUpperCase() === "MODEM"){
                            	$scope.flagRefModem = true;
                            }
                        }
                );
            }
            
            
            if($scope.data.step3 && $scope.data.step3.dac && !$rootScope.dacValidato){
            	$scope.validationDac($scope.data.step3.dac);
            }
            
      	    //RU_915
            if($scope.assetDetail){
            	$scope.isOffertaCps = ([$rootScope.MAP_OFFERTE.CPS.id].indexOf($scope.assetDetail.idOfferta) >= 0);
            }else{
            	$scope.isOffertaCps = false;
            }
            
            //RU_1543
            if($scope.assetDetail){
				// RU_1581
            	$scope.isOffertaFullGponPlus = ([$rootScope.MAP_OFFERTE.FULLGPONPLUS.id, $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id].indexOf($scope.assetDetail.idOfferta) >= 0);
            	// RU_1581
            	$scope.isOffertaGponPNRR = ([$rootScope.MAP_OFFERTE.GPON_SEMI_PNRR.id, $rootScope.MAP_OFFERTE.GPON_FULL_PNRR.id].indexOf($scope.assetDetail.idOfferta) >= 0);
            }else{
            	$scope.isOffertaFullGponPlus = false;
            	$scope.isOffertaGponPNRR = false;
            }
      	    
            //RU_915   	    
      	    if($scope.isOffertaCps){
      	    	      	    	      	    	
      	    	if(!$rootScope.customizedOffer){
      	    		$rootScope.customizedOffer = {};
            		Offers.get({offerId: $scope.assetDetail.idOfferta}).$promise
            		.then(function(response){
            			if(response.offerDetail){
            				$rootScope.customizedOffer = angular.copy(response.offerDetail);                   				
            				
            				$rootScope.topDetails = angular.copy(response.offerDetail.offerTopDetails);
            				
            	            angular.forEach($rootScope.customizedOffer, function (item) {
            	            	angular.forEach(item, function (value) {
            	                	if(value.dft){
            	                		value.dft="";
            	                	}
            	                });
            	            });
            				
            			}else{
    		                modalService.showModal({}, {
    		                    headerText: "Cessazione ordine",
    		                    bodyText: "Impossibile caricare il dettaglio della offerta associata.",
    		                    actionButtonText: 'Chiudi',
    		                    type: 'warning'
    		                });
            			}
            		}, function(error){
    	                modalService.showModal({}, {
    	                    headerText: "Cessazione ordine",
    	                    bodyText: "Impossibile caricare il dettaglio della offerta associata.",
    	                    actionButtonText: 'Chiudi',
    	                    type: 'warning'
    	                });
            		});
      	    	}
      	    }           
        };
        
        //RU_915
        $scope.openDataSottoscrizioneContratto = function(){
        	$scope.popup_dataSottoscrizioneContratto.opened = true;
        };
        $scope.openDataSottoscrizioneNuovoContratto = function(){
        	$scope.popup_dataSottoscrizioneNuovoContratto.opened = true;
        };
        $scope.openDataEmissione = function(){
        	$scope.popup_dataEmissione.opened = true;
        };
        $scope.openDataRichiestaCessazione = function(){
        	$scope.popup_dataRichiestaCessazione.opened = true;
        }
        
        
        //RU_915
        $scope.matrixRadicale = {
            	"POTS" : ["PBX","GNR"],
            	"ISDN" : ["PBX","GNR"]
            };    	
            
        //RU_915
        $scope.matrixQuantitaLinee = {
               	"POTS" : ["PBX","GNR"],
               	"ISDN" : ["PBX","GNR"]
            }; 
        
        
       //RU_915
        $scope.checkCPS = function () {
        	 return ($rootScope.assetDetail && $rootScope.assetDetail.idOfferta == $rootScope.MAP_OFFERTE.CPS.id);
        }
        
        
        //RU_915
        //C04M01F227
        $scope.verificaCarrierOloCps = function(){
        	var _request = {
            		codificaOloAgcom: $scope.data.step1.operatore.codiceOLO,
            		lavorazione: $scope.data.step1.causale_ordine,
            		offerta: $scope.assetDetail.idOfferta,
            		codiceCarrierOlo: $rootScope.customizedOffer.offerTopDetails.CODICECARRIEROLO.dft         		
            	};
        	
        	return VerificaCarrierOloCps
        		.save(_request)
        		.$promise;
        }
        
        //RU_915
        //C04M01F02
        $scope.verificaContratto = function(){
        	var _request = {
        		codiceOloAgcom: $scope.data.step1.operatore.codiceOLO,
        		lavorazione: $scope.data.step1.causale_ordine,
        		offerta: $scope.assetDetail.idOfferta,
        		//SM_8996
        		dn: $scope.data.step2.id_risorsa 
        	};
        	
        	return VerificaContratto
        		.save(_request)
        		.$promise;
        }
        
        //RU_915
        //SM_9010
        $scope.buildArrayStrutturaLinea = function(){
        	if($rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft){
        		switch($rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft){
    	    		case 'POTS':
    	    			$scope.arrayStrutturaLinea = ['Simplex','PBX','GNR'];
    	    			break;
    	    		case 'ISDN':
    	    			//SM_8985
    	    			$scope.arrayStrutturaLinea = ['BRA','PBX','GNR'];
    	    			break;
    	    		default:
    	    			$scope.arrayStrutturaLinea = [];
    	    			break;
        		}    		
        	}else{
        		$scope.arrayStrutturaLinea = [];
        	}
        }
        
        //RU_915
        $scope.resetData = function(){
			if($rootScope.customizedOffer){
				delete $rootScope['customizedOffer'];
			}
			
			if($rootScope.topDetails){
				delete $rootScope['topDetails'];
			}
			
			$rootScope.formData = {};
			$scope.data = {};
        }

      //RU_871
        $scope.checkBitstream = function () {
        	if($rootScope.assetDetail){
        		if($rootScope.assetDetail.idOfferta == "39" || $rootScope.assetDetail.idOfferta == "40" || $rootScope.assetDetail.idOfferta == "41"){
        			$scope.bitstreamSimm = true;
        			return true;
        		}
        	}
        	return false;
        }
      //RU_871
        $scope.validaForm = function (form) {
        	if($scope.flagRefModem || $scope.formDaValidare){
        		if( form.$valid )
        			return true;
        		return false;
        	}
        	return true
        }
        //RU_871
        $scope.validaDatiRiferimento = function (form) {

        	$scope.formDaValidare = false;
        	
            if (form.ref1_nome.$invalid //SM_8809
                || form.ref1_tel_fisso.$invalid
                || form.ref1_qualifica.$invalid
                || form.ref1_cognome.$invalid
                || form.ref1_tel_cellulare.$invalid) {
                $scope.referentView = [true, false, false, false];
            } else {
                if (form.ref2_nome.$invalid //SM_8809
                    || form.ref2_tel_fisso.$invalid
                    || form.ref2_qualifica.$invalid
                    || form.ref2_cognome.$invalid
                    || form.ref2_tel_cellulare.$invalid) {
                    $scope.referentView = [false, true, false, false];
                } else {
                    if (form.ref3_nome.$invalid //SM_8809
                        || form.ref3_tel_fisso.$invalid
                        || form.ref3_qualifica.$invalid
                        || form.ref3_cognome.$invalid
                        || form.ref3_tel_cellulare.$invalid) {
                        $scope.referentView = [false, false, true, false];
                    }
                }
            }
            
            if (form.ref1_nome.$modelValue //SM_8809
                    || form.ref1_tel_fisso.$modelValue
                    || form.ref1_qualifica.$modelValue
                    || form.ref1_cognome.$modelValue
                    || form.ref1_tel_cellulare.$modelValue) {
            		$scope.formDaValidare = true;
                } else {
                    if (form.ref2_nome.$modelValue //SM_8809
                        || form.ref2_tel_fisso.$modelValue
                        || form.ref2_qualifica.$modelValue
                        || form.ref2_cognome.$modelValue
                        || form.ref2_tel_cellulare.$modelValue) {
                    	$scope.formDaValidare = true;
                    } else {
                        if (form.ref3_nome.$modelValue //SM_8809
                            || form.ref3_tel_fisso.$modelValue
                            || form.ref3_qualifica.$modelValue
                            || form.ref3_cognome.$modelValue
                            || form.ref3_tel_cellulare.$modelValue) {
                        	$scope.formDaValidare = true;
                        }
                        else {
                        	$scope.formDaValidare = false;
                        }
                    }
            }
        	
            if($scope.formDaValidare || $scope.flagRefModem){
            	angular.forEach(form.$error.required,
                        function (field) {
                            field.$setDirty();
                            $scope.caricaPassFour = false;
                        }
                    );
            }
       
        };
        
        // MODALE PER MESSAGGIO DI ERRORE
        // Il secondo parametro (default true) permette di NON ripristinare il flag attesaRispostaChiamata
        // quando l'errore proviene da una chiamata parallela (es. Locator) che non deve
        // riabilitare il tasto "conferma" mentre la Orders.save() e' ancora in corso.
        $scope.erroreService = function (messageBody, resetAttesaRispostaChiamata) {
            modalService.showModal({}, {
                headerText: "Avviso",
                closeButtonText: 'Chiudi',
                bodyText: messageBody,
                scope: $scope,
                type: 'success'
            });
            if (resetAttesaRispostaChiamata !== false) {
            	$scope.attesaRispostaChiamata=false;
            }
        };
        
        $scope.openDP1 = function () {
            $scope.popup_dp1.opened = true;
        };
       
        $scope.openDP2 = function () {
            $scope.popup_dp2.opened = true;
        };
        
        $scope.goTo = function (state) {
            $state.go(state, {
                id: $scope.assetId
            });
        };
        
        $scope.confermaAnnulla = function () {
            modalService.showModal({}, {
                headerText: "Vuoi annullare la cessazione?",
                closeButtonText: 'Chiudi',
                bodyText: "I dati inseriti nel modulo saranno cancellati.",
                actionButtonText: 'Continua',
                scope: $scope,
                callbackFunction: 'annulla',
                type: 'success'
            });
        };
        $scope.annulla = function () {
            $rootScope.formData = null;
            //Task #36575
            $state.go('root.consistenze.asset.listaAccesso');
        };
        $scope.valida = function (form) {
            angular.forEach(form.$error.required, function (field) {
                field.$setDirty();
            });
            
            //RU_915
            if(form.$invalid){
            	$scope.accordionOpen = [true, true, true];
            }
        };

        $scope.submit_2 = function () {
        	
        	//RU_1213
        	if($scope.assetDetail.idOfferta == $rootScope.MAP_OFFERTE.FEEDER.id){
        		$scope.erroreService("Lavorazione al momento non disponibile");
        		return;
        	}
        	
            //C11M08F41 – Verifica Congruenza Intestatario Ordine-IDRisorsa (S6)
        	VerificaCongruenzaOffertaCodOrdine.get({
        		idOfferta: $rootScope.assetDetail.idOfferta,
        		codOrdine: $rootScope.data.step1.codice_ordine, 
        		codOrdinePadre: $rootScope.data.step1.codice_ordine_padre}).$promise.then(
        				function (response) {
        					if (response.esito === "OK") {
        						//RU_833 FIX FWA CESSAZIONE
        						if($rootScope.assetDetail.idOfferta == $rootScope.MAP_OFFERTE.FWA.id) { //SM_8110
        							Verificacodiceordineolo.get({
        								codiceOrdineOlo: $rootScope.data.step1.codice_ordine,
        								codOloAgcom: $rootScope.data.step1.operatore.codiceOLO
        							}).$promise.then(
        									function (response) {
        										if(response.esito==="OK"){        											
        											//RU_1181
        							        		$scope.C11M08F88()
        							        		.then(function(result){
        							        			if(result.outputVerificaRecuperoModem && result.outputVerificaRecuperoModem.esito == 'OK'){
        							        				
        							        				$scope.data.step2.statoRestituzioneProdotti = result.outputVerificaRecuperoModem.statoRestituzioneProdotti;
        							        				
        							                        $rootScope.formData = $scope.data;
        							                        $state.go('root.ordini.new.cessazione.step3');
        							        			}else{
        							        				$scope.erroreService(result.outputVerificaRecuperoModem.message);
        							        			}
        							        		}, function(error){
        							        			$scope.erroreService("Errore VerificaRecuperoModem");
        							        		});
        										}
        										else{
        											$scope.erroreService(response.message);
        											return
        										}
        									},
        									function () {
        										$scope.erroreService("Errore VerificaCodiceOrdineOlo");
        										return
        									}
        							);
        						}else{
        							$state.go('root.ordini.new.cessazione.step3');
        						}
        					} else {
        						$scope.erroreService("Per l’Offerta selezionata il Codice Ordine e il Codice Ordine Padre non deve superare 11 caratteri. Torna a Pagina 1 per effettuare la modifica");
        					}
        				}, function (error){
        					$scope.erroreService("Impossibile verificare la Congruenza Intestatario Ordine ID Risorsa");
        				});
        };
        
        $scope._submit_3 = function(form){
        	
        	$scope.disableButtonAvanti = true;
    		
    		if($scope.nonRegolatorio && !$scope.bitstreamSimm && !$scope.visibilitaCPS){
        		$state.go('root.ordini.new.cessazione.riepilogo');
        	}
      	
    		//RU_915
    		if($scope.visibilitaCPS){
    	        
    	        //Chiamata a C04M01F227			
    			$scope.verificaCarrierOloCps()
    	 		.then(function(response){  
    	 				$scope.disableButtonAvanti = false;
    					if(response.verificaCarrierOloCPSOutput && response.verificaCarrierOloCPSOutput.esito.toUpperCase() === 'KO'){
        					modalService.showModal({},
                                    {
                                        headerText: "Avviso",
                                        bodyText: response.verificaCarrierOloCPSOutput.message,
                                        actionButtonText: 'Chiudi',
                                        type: 'warning'
                                    });
        					//$scope.resetData();
        					//$scope.goTo('root.ordini.new.cessazione');
    					}else{
    					
    						//Chiamata a C04M01F02
    						$scope.verificaContratto()
    			    		.then(function(response){
    			    			$scope.disableButtonAvanti = false;
    			    			if(response.verificaContrattoOutput && response.verificaContrattoOutput.esito.toUpperCase() === 'KO'){
                					modalService.showModal({},
                                            {
                                                headerText: "Avviso",
                                                bodyText: response.verificaContrattoOutput.message,
                                                actionButtonText: 'Chiudi',
                                                type: 'warning'
                                            });
                					//$scope.resetData();
                					//$scope.goTo('root.ordini.new.cessazione');
    			    			}else{
    			            		$rootScope.formData.step3 = $scope.data.step3;
    			         			 $state.go('root.ordini.new.cessazione.riepilogo', {
    			                        id: $scope.assetId,
    			                        object: $scope.data.assetDetail
    			                    });
    			    			}
    			    			
    			    		}, function(error) {
    			    			$scope.disableButtonAvanti = false;
            					modalService.showModal({},
                                        {
                                            headerText: "Avviso",
                                            bodyText: "Errore verifica contratto OLO",
                                            actionButtonText: 'Chiudi',
                                            type: 'warning'
                                        });
            					//$scope.resetData();
            					//$scope.goTo('root.ordini.new.cessazione');
    						});		
    					}			
    			}, function(error) {
    				$scope.disableButtonAvanti = false;
					modalService.showModal({},
                            {
                                headerText: "Avviso",
                                bodyText: "Errore verifica carrier OLO",
                                actionButtonText: 'Chiudi',
                                type: 'warning'
                            });
					//$scope.resetData();
					//$scope.goTo('root.ordini.new.cessazione');
    			});
    		}else if($scope.visibilitaNP){
        		var tipolinea = "";
        		angular.forEach($scope.assetDetail.servizi[0].customizzazione, function(value) {
          		  //$log.info(value.attribute);
          		  if(value.attribute === "TIPOLINEA"){
          			tipolinea = value.value;
          		  }
          		});
        		 var verificaOloWholesaler = ordersAction.save({type:"verificaolowholesaler"},{
                     codificaAgcomRecipient: $scope.data.step1.operatore.codiceOLO,
                     offerta: $scope.data.step1.tiposervizioCompleto,
                     routingNumberRecipient: $scope.data.step3.routingNumber,
                     tipoLinea: tipolinea
                 });
        		 verificaOloWholesaler.$promise.then(
                     function (response) {
                    	 $scope.disableButtonAvanti = false;
                         if (response.esito === "OK") {
                             if($scope.visibilitaDac){
					        		if($rootScope.dacValidato){
					        			$state.go('root.ordini.new.cessazione.riepilogo');
					        		}
					        	}else{
					        		$state.go('root.ordini.new.cessazione.riepilogo');
					        	}
                         }
                         else {
                             modalService.showModal({},
                                 {
                                     headerText: "Avviso",
                                     bodyText: "La verifica OAO Wholesaler non è andata a buon fine",
                                     actionButtonText: 'Chiudi',
                                     type: 'warning'
                                 });
                         }
                     }, function (error) {
                    	 $scope.disableButtonAvanti = false;
                    	 $log.debug(error);
			              modalService.showModal({},
			              {
			                  headerText: "Avviso",
			                  bodyText: "La verifica OAO Wholesaler non è andata a buon fine",
			                  actionButtonText: 'Chiudi',
			                  type: 'warning'
			              });
                     }
                 );
        	}else if($scope.visibilitaDac){
        		$scope.disableButtonAvanti = false;
        		if($rootScope.dacValidato){
        			$state.go('root.ordini.new.cessazione.riepilogo');
        		}
        	}else{
        		//RU_871
            	if($scope.bitstreamSimm === true){
            		var flag = false; //SM_8769
            		angular.forEach($scope.data.step3.datiReferenti, function(value) {
                		  if(value && value != ""){
                			  flag = true;
                			  
                			  //SM_8809 --> 22/10/2019
                			  //Verifica e pulizia campi form referente vuoti
                			  var props = Object.keys(value);
                			  angular.forEach(props, function(prop){
                				 if(!value[prop] || value[prop] == null || value[prop] == ""){
                					 delete value[prop];
                				 } 
                			  });
                		  }
                	});

            		referente = flag ? 'Y' : 'N';
            		
            		VerificaInConsistenzaPresenzaModem.get({idRisorsa: $scope.data.step2.id_risorsa, idOfferta: $rootScope.assetDetail.idOfferta, flagReferente: referente}).$promise.then(
                            function (response) {
                            	$scope.disableButtonAvanti = false;
                            	//RU_871
                            	if(response.esito !=='KO'){
                            		$state.go('root.ordini.new.cessazione.riepilogo');
                            	}else{
                            		 // MODALE PER MESSAGGIO DI ERRORE
                                        modalService.showModal({}, {
                                            headerText: "Avviso",
                                            closeButtonText: 'Chiudi',
                                            bodyText: response.message,
                                            scope: $scope,
                                            type: 'error'
                                        });
                            	}
                            	
                            },
                            function (error) {
                            	$scope.disableButtonAvanti = false;
                            	$log.debug(error);
      			              modalService.showModal({},
      			              {
      			                  headerText: "Avviso",
      			                  bodyText: "VerificaInConsistenzaPresenzaModem error",
      			                  actionButtonText: 'Chiudi',
      			                  type: 'warning'
      			              });
                            });
            		
            	}
            	else{
            		$scope.disableButtonAvanti = false;
            		$state.go('root.ordini.new.cessazione.riepilogo');
            	}
        	}
        }
        
        //SM_10499
        $scope.verificaInserimentoReferentiCorrettamente= function (item){
          	if($scope.data && $scope.data.step3 && $rootScope.getMap_Offerta($scope.assetDetail.idOfferta).regolatorio){
          		return (item &&(item.telefonoFisso || item.cellulare || item.qualifica || item.cognome || item.email)) ;
          	}else{
          		return (item &&(item.nome || item.telefonoFisso || item.cellulare || item.qualifica || item.cognome || item.email)) ;
          	}
          };
    
        $scope.submit_3 = function (form) {
        	$scope.disableButtonAvanti = true;
    	    //SM_9654
    	    //SM_10454
        	//Task #36575
        	//SM_10499
    		if(($rootScope.R1F_20_0236 || $rootScope.RU_1084) && $scope.data.step3.datiReferenti){
    			$scope.tokenizzazioneReferenti()
        		.then(function(response){
        			$scope.disableButtonAvanti = false;
        			if(response.referentiTokenizzati.esito=='OK'){
            			$scope.setFlagToken('Y');
            		}else{
            			$scope.setFlagToken('N');
            		}
        			$rootScope.data.numeriReferentiTokenizzati = response.referentiTokenizzati.numeriReferenti; 
        			$scope._submit_3();
            	}, function(error){
            		$scope.disableButtonAvanti = false;
            		if(error.referentiTokenizzati && error.referentiTokenizzati.numeriReferenti){
            			$rootScope.data.numeriReferentiTokenizzati = error.referentiTokenizzati.numeriReferenti;
            		}else{
            			$rootScope.data.numeriReferentiTokenizzati = [];
            		}            		
            		$scope.setFlagToken('N');
            	});
    		}else{
    			$scope._submit_3();
    		}
        };
        
        
        $scope._submit_4 = function(){
			var orderData = {};
            if ($scope.data.step3.dac) {
                $scope.data.step3.dac = $scope.convertDate($scope.data.step3.dac);
            }
            
            //SM_9108
            if ($scope.data.step3.dad) {
            	$scope.data.step3.dad = $scope.convertDate($scope.data.step3.dad);
                $scope.dataRicezioneRichiesta = {"dataRicezioneRichiesta" : $scope.data.step3.dad};
            }
            
            $scope.data.step2.id_risorsa = $scope.data.idRisorsa;
            
            //SM_10033
            if ($scope.data.step2.codice_progetto){
                $scope.data.step2.codice_progetto = $scope.data.step2.codice_progetto.cod_prgt;
            }
            
            angular.extend(orderData, $scope.data.step1);
            angular.extend(orderData, $scope.data.step2);
            
            //RU_915
            orderData.offertaCatalogo = $scope.assetDetail.nomeOffertaCatalogo;
            
            //RU_915
            if($scope.checkCPS()){
            	$scope.buildRequestForCPS();
            	orderData.offerDetails = {};
            	orderData.offerDetails = $rootScope.customizedOffer;
            }
            
            //SM_9654
            //R1F-20-0236
            if($rootScope.RU_1084 || $rootScope.R1F_20_0236){
            	if($rootScope.data.numeriReferentiTokenizzati && $rootScope.data.numeriReferentiTokenizzati.length > 0){      
            		
            		var _referentiTokenizzati = $rootScope.data.numeriReferentiTokenizzati;
            		var _keys = Object.keys($scope.data.step3.datiReferenti);

            		//Bug #32193
            		_referentiTokenizzati.forEach(function(value, i){
            			//SM_9625
            			var _index = parseInt(value.id) + 1;
            			$scope.data.step3.datiReferenti[_index].cellulare = (value.numeroMobile || null);
            			$scope.data.step3.datiReferenti[_index].telefonoFisso = (value.numeroFisso || null);
            			//SM_10413
            			//SM_10539
            			if($rootScope.R1F_20_0236){
            				$scope.data.step3.datiReferenti[_index].nome = (value.nome || null);
            				$scope.data.step3.datiReferenti[_index].cognome = (value.cognome || null);
            			}
            		});
            	}
            }
            
            //SM_9108
            angular.extend(orderData, $scope.data.step3);
            
            if(!!$scope.dataRicezioneRichiesta) { //SM_7893
            	angular.extend(orderData, $scope.dataRicezioneRichiesta); 
            }

            orderData.operatore = $scope.data.step1.operatore.codiceOLO;
            
            //RU_1010
            //Tracking da GUI per operazione INSERIMENTO     
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Asset|Lista Asset|Cessazione Asset',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.INSERIMENTO.descrizione,
	    			parametriOperazione: null 			
            };
            
            Orders.save(orderData, function () {
                $rootScope.formData = null;
                $scope.attesaRispostaChiamata=false;
                
                _trackBean.esito = 'Ok'
	            _trackBean.timestampFine = new Date().toISOString();  
                TrackingGUI.tracking(_trackBean);
                
                $state.go('root.ordini.new.cessazione.conferma');
            }, function (data) {
                $log.debug(data);
            	$scope.attesaRispostaChiamata=false;
                
                modalService.showModal({}, {
                    headerText: "Cessazione ordine",
                    bodyText: "Non e' stato possibile completare l'operazione. Riprova piu' tardi.",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
                
                _trackBean.esito = 'Ko'
		        _trackBean.timestampFine = new Date().toISOString();    
	            TrackingGUI.tracking(_trackBean);
            });
		}        
        
        $scope.submit_4 = function () {
			// Evita doppi submit finche' la chiamata e' in corso
			if ($scope.attesaRispostaChiamata) {
				return;
			}
        	
            if ($scope.data.step2.drc){
            	var drc = new Date($scope.data.step2.drc);
            	$scope.data.step2.drc = $filter('date')(drc, 'dd/MM/yyyy');
            }
            
            $scope.attesaRispostaChiamata=true;
            
            $scope._submit_4();
            
            //CHIAMATA AL SYSTEM LOCATOR DISABILITATA
            
        	// C11M08F16 - Verifica ordine in ambito
			if(!$rootScope.OSCURAMENTI.RU_1612.oscurato) {
				var locatorQuery = {
						"codiceOlo" : $scope.data.step1.operatore.codiceOLO,
						"servizio" : $scope.assetDetail.tipoServizio,
						"lavorazione" : 'cessazione',
						"idRisorsa" : $scope.assetDetail.idRisorsa,
						"codiceComune" : $scope.assetDetail.comune,
						"provincia" : $scope.assetDetail.provincia //SM_8415 
				};
				
				Locator.save(locatorQuery,
						function(data) {
							if (data.esito === "OK") {

							} else {
								// Non ripristinare attesaRispostaChiamata: la Orders.save() potrebbe essere ancora in corso
								$scope.erroreService(data.descrizione, false);
							}
						},
						function(error) {
							$log.debug(error);
							// Non ripristinare attesaRispostaChiamata: la Orders.save() potrebbe essere ancora in corso
							$scope.erroreService("La Verifica Ordine in Ambito non è andata a buon fine", false);
						});
			}
           
        };
        
        $scope.goToStep1 = function () {
        	$state.go('root.ordini.new', {"init": true});
        };
        
        $scope.controlloVisibilitaInput = function () {
        	if($scope.assetDetail){
            	
            	//RU_1543
                $scope.nonRegolatorio=!$rootScope.getMap_Offerta($scope.assetDetail.idOfferta).regolatorio || $scope.isOffertaFullGponPlus;
                
            	$scope.visibilitaDac=[$rootScope.MAP_OFFERTE.ULL_LNA.id,
            	                      $rootScope.MAP_OFFERTE.ULL_LA.id,
            	                      $rootScope.MAP_OFFERTE.ULLD_LNA.id,
            	                      $rootScope.MAP_OFFERTE.ULLD_LA.id,
            	                      $rootScope.MAP_OFFERTE.SLU_LNA.id,
            	                      $rootScope.MAP_OFFERTE.SLU_LA.id,
            	                      $rootScope.MAP_OFFERTE.VULL_LNA.id,
            	                      $rootScope.MAP_OFFERTE.WLR_LNA.id,
            	                      $rootScope.MAP_OFFERTE.SHA_CM.id,
            	                      $rootScope.MAP_OFFERTE.SHA_SM.id,
            	                      $rootScope.MAP_OFFERTE.WLR_LA.id,
            	                      $rootScope.MAP_OFFERTE.VULL_LA.id,
            	                      $rootScope.MAP_OFFERTE.ULL_LANP.id,
            	                      $rootScope.MAP_OFFERTE.ULLD_LANP.id,
            	                      $rootScope.MAP_OFFERTE.SLU_LANP.id
            	                      ].indexOf($scope.assetDetail.idOfferta) >= 0;
            	
            	$scope.visibilitaFlagMonitoraggio=[$rootScope.MAP_OFFERTE.ULL_LNA.id,
            	                                   $rootScope.MAP_OFFERTE.ULL_LA.id,
            	                                   $rootScope.MAP_OFFERTE.ULLD_LNA.id,
            	                                   $rootScope.MAP_OFFERTE.ULLD_LA.id,
            	                                   $rootScope.MAP_OFFERTE.ULL_LANP.id,
            	                                   $rootScope.MAP_OFFERTE.ULLD_LANP.id
            	                                   ].indexOf($scope.assetDetail.idOfferta) >= 0;
            	
        		$scope.sezioneRientro=[$rootScope.MAP_OFFERTE.WLR_LA.id,
        		                       $rootScope.MAP_OFFERTE.ULL_LANP.id,
        		                       $rootScope.MAP_OFFERTE.ULLD_LANP.id,
        		                       $rootScope.MAP_OFFERTE.SLU_LANP.id
        		                       ].indexOf($scope.assetDetail.idOfferta) >= 0;
        		
        		$scope.visibilitaNP=[$rootScope.MAP_OFFERTE.ULL_LANP.id,
        		                     $rootScope.MAP_OFFERTE.ULLD_LANP.id,
        		                     $rootScope.MAP_OFFERTE.SLU_LANP.id
        		                     ].indexOf($scope.assetDetail.idOfferta) >= 0;
        		
        		//RU_915
        		$scope.visibilitaCPS=[$rootScope.MAP_OFFERTE.CPS.id].indexOf($scope.assetDetail.idOfferta) >= 0;
        		                     
        	}       	
        };

        $scope.convertDate = function (d) {
            var dd = new Date(d);
            if (d)
                formattedDate = $filter('date')(dd, 'dd/MM/yyyy');
            return formattedDate;
        };
        
        $scope.validationDac = function (data) {
        	if(data){
        		$scope.loadDac=true;
        		var item = SlaValidationService.get($scope.convertDate(data), 'Cessazione' , $scope.assetDetail.idOfferta, 'offer');
                item.then(function (response) {
                	$scope.loadDac=false;
                    $rootScope.dacMessaggioErrore = null;
                    if (response[0].outcome.codice !== "KO") {
                        if (response[1].outcome.codice !== "KO") {
                            $rootScope.dacValidato = true;
                        } else {
                            $rootScope.dacValidato = false;
                            $rootScope.dacMessaggioErrore = response[1].outcome.descrizione;
                        }
                    } else {
                        $rootScope.dacValidato = false;
                        $rootScope.dacMessaggioErrore = response[0].outcome.descrizione;
                    }
                }, function (error) {
                	$log.debug(error);
                	$scope.loadDac=false;
                    $rootScope.dacValidato = false;
                    $rootScope.dacMessaggioErrore = "Impossibile validare la Data";
                });
        	}
        };
        
        $scope.openAllRiepilogo = function () {
            $scope.openPanelRiepilogo = {
                step1: true,
                step2: true,
                step3: true,
                closeOthers: false
            };
        };

        $scope.closeAllRiepilogo = function () {
            $scope.openPanelRiepilogo = {
                step1: false,
                step2: false,
                step3: false,
                closeOthers: true
            };
        };
        
        $scope.allPanelsOpened = function () {
            var opr = $scope.openPanelRiepilogo;
            var allOpen = (opr.step1 && opr.step2
            && opr.step3 );
            return allOpen;
        };

        $scope.allPanelsClosed = function () {
            var opr = $scope.openPanelRiepilogo;
            var allClosed = (!opr.step1 && !opr.step2
            && !opr.step3);
            return allClosed;
        };
        
        $scope.openPanelRiepilogo = {
                step1: true,
                step2: true,
                step3: true
            };
        
        $scope.headerDatiOrdineContracts = [
		                                    {"key": "idAsset", "value": "Id Asset", "type": "text"},
		                                    {"key": "idRisorsa", "value": "Id Risorsa", "type": "text"},
		                                    {"key": "numeroTelefonico", "value": "Numero Telefonico", "type": "text", "sort":"number"},
		                                    {"key": "numeroFittizio", "value": "Numero Fittizio", "type": "text", "sort": "number"},
		                                    {"key": "offerta", "value": "offerta", "type": "text"}
		                               ];   
		
        
        //RU_915
    	$scope.buildModalOptionsTabellaDatiOrdineCessazione = function(){
    		return {    		
	            headerText: 'Seleziona un Asset',
	            actionButtonText: null,
	            closeButtonText: 'Ok',
	            contentType: 'modale_nowtable',
	            scope: $scope,
	            callbackFunction: 'ricercaIDAssetCallback',
	            dataHeader: $scope.headerDatiOrdineContracts
	         	}
	        };
		
		
        $scope.controlloAsset = function(event) {
        	
        	//SM_9712
        	event.preventDefault();
        	
        	$scope.messaggioErroreIdRisorsa = null;
        	
        	var modalOptions = $scope.buildModalOptionsTabellaDatiOrdineCessazione();
       	
        	RecuperaIdAsset.get({
        		codAgcom: $scope.data.step1.operatore.codiceOLO, 
        		idRisorsa:$scope.data.step2.id_risorsa,
        		azione: 'cessazione'}).$promise.then(
                        function (response) {
                        	//RU_833 FIX CESSAZIONE FWA RECUPERO ASSET
                        	if(response.esito !=='KO'){
                        		
                        		//RU_915
                        		var modalOptions = $scope.buildModalOptionsTabellaDatiOrdineCessazione();
                        		
                        		modalOptions.data=response.data;
	                        	modalService.showModal({}, modalOptions);
                        	}else{
                        		 // MODALE PER MESSAGGIO DI ERRORE
                                    modalService.showModal({}, {
                                        headerText: "Avviso",
                                        closeButtonText: 'Chiudi',
                                        bodyText: response.result.details,
                                        scope: $scope,
                                        type: 'error'
                                    });
                        		$scope.messaggioErroreIdRisorsa = "Impossibile caricare i relativi Asset";
                        	}
                        	
                        },
                        function (error) {
                        	$scope.loadStep2=false;
                            $log.debug(error);
                            $scope.messaggioErroreIdRisorsa = "Impossibile caricare i relativi Asset";
                        });
        		
        };
        
        
        $scope.recuperoIdAssetNew = function($event){
        	$event.preventDefault();
        	
        	//RU_915
        	var modalOptions = $scope.buildMmodalOptionsTabellaDatiOrdineCessazione();
        	
        	modalService.showModal({}, modalOptions);
        };
        
        $scope.ricercaIDAssetCallback = function (item) {
        	Assets.get({id: item.idAsset, paramName:'idAsset', consistenza:'N'}).$promise.then(
        			function (response) {
                        if (response.result && response.result.code === '2') {
                            $scope.messaggioErroreIdRisorsa = response.result.message;
                        }else{
                            $scope.assetDetail = response;
                            $scope.data.idRisorsa = response.idRisorsa;
                            $scope.data.step2.idAsset = response.idAsset;
                            
                            //RU_1058
                            if($scope.RU_1058){
                            	$scope.verificaCampi_RU_1058();
                            	//SM_9712
                            	$scope.setShowDRC();
                            }
                            
                            //SM_10033
                            $scope.setShowCodiceProgetto();
                            
                       	 	$scope.oscuramento_R1F_20_0236();
                       	 	$scope.oscuramento_RU_1084();
                       	 	
                       	 	$scope.setShowReferenteOaoProgettiSpeciali(); 
                            
                      if(response.tipoServizio) {
                    	  $scope.data.step1.tiposervizio = response.tipoServizio.substring(0, 3);
                          $scope.data.step1.tiposervizioCompleto = response.tipoServizio;
                          
	                      if (response.tipoServizio === "NP") {
	                          $scope.messaggioErroreIdRisorsa = 'l’IDRisorsa inserita corrisponde ad un ASSET di NUMBER PORTABILITY e non può essere utilizzata per l’operazione richiesta';
	                      }
	                     /* else if (response.statoAsset !== "ATTIVO") {
	                          $scope.messaggioErroreIdRisorsa = "l’ID Risorsa inserita non può essere utilizzata per l’operazione richiesta";
	                      }*/
	                      else {
	                          	$rootScope.assetDetail = response;
	                              $rootScope.formData = $scope.data;
	                      }
                      } else {
                    	  $scope.messaggioErroreIdRisorsa = "l’ID Risorsa inserita non può essere utilizzata per l’operazione richiesta";
                	  }
                        }
                    },
                    function (error) {
                    	$log.debug(error);
                        $scope.messaggioErroreIdRisorsa = "Impossibile verificare l'ID Risorsa inserita";
                    });
        };
        
        $scope.svuotaDaIdRisorsa = function () {
        	$scope.data.step3={};
        	$scope.assetDetail = null;
        };
        
        //SM_9712
        $scope.setShowDRC = function(){
        	if($scope.assetDetail && $scope.assetDetail.idOfferta && ($scope.assetDetail.idOfferta == $rootScope.MAP_OFFERTE.VP.id)){
        		$scope.showDRC = true;
        		$scope.isDataRichiestaCessazioneRequired = true;
        	}else{
        		$scope.showDRC = false;
        		$scope.isDataRichiestaCessazioneRequired = false;
        	}
        }
        
        //SM_9010
        $scope.$watch("customizedOffer.offerTopDetails.OPZIONETRAFFICO.dft", function(newValue, oldValue){	
        	if(newValue){
            	switch(newValue){
            	case '0':
            		$scope.opzioneTraffico = 'Long Distance';
            		break;
            	case '2':
            		$scope.opzioneTraffico = 'Tutte';
            		break;
            	default:
            		$scope.opzioneTraffico = '';
            	}
        	}else{
        		$scope.opzioneTraffico = "";
        	}
        	
        });
        
        //RU_915
        $scope.buildRequestForCPS = function(){
        	
        	if($scope.data.step3){
        		
            	if($scope.data.step3.datiClienteFinale){
            		
            		var dataEmissione = $scope.data.step3.datiClienteFinale.data_emissione;
            		var dataSotoscrizioneNuovoContratto = $scope.data.step3.datiClienteFinale.data_sottoscrizione_nuovo_contratto;
            		var dataRichiestaCessazione = $scope.data.step3.datiClienteFinale.data_richiesta_cessazione;
            		
            		if(dataEmissione){
            			$scope.data.step3.datiClienteFinale.data_emissione = $filter('date')(dataEmissione, 'yyyy-MM-dd');
            		}
            		if(dataSotoscrizioneNuovoContratto){
            			$scope.data.step3.datiClienteFinale.data_sottoscrizione_nuovo_contratto = $filter('date')(dataSotoscrizioneNuovoContratto, 'yyyy-MM-dd');
            		}
            		if(dataRichiestaCessazione){
            			$scope.data.step3.datiClienteFinale.data_richiesta_cessazione = $filter('date')(dataRichiestaCessazione, 'yyyy-MM-dd');
            		}        		
            		
            	}
        	}
        	        	
        	if($rootScope.customizedOffer.offerTopDetails){
        		var dsc = $rootScope.customizedOffer.offerTopDetails.DSC.dft;
        		if(dsc){
        			$rootScope.customizedOffer.offerTopDetails.DSC.dft = $filter('date')(dsc, 'yyyy-MM-dd');
        		}
        	}
        	
        	$rootScope.customizedOffer.offerBotDetails = [];
        	        	
        }
        
        
        //RU_915
        $scope.$watch("customizedOffer.offerTopDetails.TIPOLINEA.dft", function(newValue, oldValue){
        	if(newValue){
        		//SM_9010
        		$scope.initArrayStrutturaLinea();
        		$scope.buildArrayStrutturaLinea();
        	}        		  	
        });
        
        //RU_915
        $scope.$watch("customizedOffer.offerTopDetails.STRUTTURALINEA.dft", function(newValue, oldValue){
        	if(newValue){
        		var _strutturaLinea = $rootScope.customizedOffer.offerTopDetails.STRUTTURALINEA.dft;
        		var _tipoLinea = $rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft; 
        		//SM_8985
        		var _show = (_strutturaLinea && _strutturaLinea != "" && _strutturaLinea != "BRA" && _strutturaLinea != "Simplex");
        		$scope.showRadicale = angular.copy(_show);
        		$scope.showQuantitaLinee = angular.copy(_show);
        		
        		if($scope.showRadicale){                 	   	
                 	$scope.isRadicaleRequired = ($scope.matrixRadicale[_tipoLinea].indexOf(_strutturaLinea) > -1);
        		}else{
        			//SM_9238
                	$rootScope.customizedOffer.offerTopDetails.RADICALE.dft = "";   
        		}
        		
        		if($scope.showQuantitaLinee){  	
                 	$scope.isQuantitaLineeRequired = ($scope.matrixQuantitaLinee[_tipoLinea].indexOf(_strutturaLinea) > -1);
        		}else{
        			//SM_9238
                 	$rootScope.customizedOffer.offerTopDetails.QUANTITALINEE.dft = "";
        		}
        		
        		//SM_9049
        		$scope.showDnPrimario = (_tipoLinea === "ISDN" && _strutturaLinea === "BRA");
        		if(!$scope.showDnPrimario){
        			$rootScope.customizedOffer.offerTopDetails.DNPRIMARIO.dft = "";
        		}
        		
        	} else{
        		$scope.showRadicale = false;
        		$scope.showQuantitaLinee = false;
        		$scope.isRadicaleRequired = false;
        		$scope.isQuantitaLineeRequired = false;
        		//SM_9049
        		$scope.showDnPrimario = false;
        	}    
        	
            //SM_9654
            $scope.oscuramento_RU_1084 = function(){        		
            	try{
            		$rootScope.RU_1084 = !$rootScope.OSCURAMENTI.RU_1084.oscurato;
            	}catch(e){
            		$rootScope.RU_1084 = false;
            	}          	
            }
            
           
            
            //R1F-20-0236
            $scope.oscuramento_R1F_20_0236 = function(){
        		
            	try{
            		if($scope.assetDetail && $scope.assetDetail.idOfferta){            			
            			if(!$rootScope.OSCURAMENTI.R1F_20_0236.oscurato){   				
           					$rootScope.R1F_20_0236 = ($rootScope.OSCURAMENTI.R1F_20_0236.idOfferteNonValide.indexOf($scope.assetDetail.idOfferta) == -1);  				
            			}else{
            				$rootScope.R1F_20_0236 = false;     			
            			}
            		}
            	}catch(e){
            		$rootScope.R1F_20_0236 = false;
            	}          	
            }
            
           
            
            $scope.setFlagToken = function(flagToken){
            	if($scope.data.step3.datiReferenti){    	
            		Object.keys($scope.data.step3.datiReferenti)
            			.forEach(function(key, index){
            				if($scope.data.step3.datiReferenti[key].qualifica == 'O'){
            					$scope.data.step3.datiReferenti[key].flagToken = 'N';
            				}else{
            					$scope.data.step3.datiReferenti[key].flagToken = flagToken;
            				}
            			});
            	}
            }
            
            //SM_10539
            $scope.eliminaReferentiVuoti = function(){
            	var _appArray = Object.keys($scope.data.step3.datiReferenti).map(function(i){ return $scope.data.step3.datiReferenti[i]});
            	var _keysToDelete = [];
            	if(_appArray && _appArray.length > 0){
            		
            		$scope.data.step3.datiReferenti = _.omit($scope.data.step3.datiReferenti, function(value, key, obj){
            			return (!value.nome || !value.cognome);
            		});
            	}
            }
            
        	//R1F-20-0236
        	//Nel caso di C2PLUS nuovo disoscurato, estraggo tutti i campi per cliente finale
        	//altrimenti solo quelli richiesti da C2PLUS classico (numeri telefonici) 
            $scope.estraiDatiReferenti = function(){
            	
                //SM_10539
                $scope.eliminaReferentiVuoti(); 
                
            	//Dalla lista dei referenti estrae solo i Clienti Finali
            	var _appArray = Object.keys($scope.data.step3.datiReferenti).map(function(i){ return $scope.data.step3.datiReferenti[i]});
            	var _clientiFinali = [];
            	
        		if($rootScope.R1F_20_0236){
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
        		}else{
            		_appArray.forEach(function(item, i){
            			if(item && item.qualifica == 'CF'){
            				_clientiFinali.push({
                				id: i,
                				numeroMobile: (item.cellulare || null),
                				numeroFisso: (item.telefonoFisso || null)
                			});
            			}    			
            		});
        		}
        		
        		return _clientiFinali;
            }
            
            //Comprende le funzioni C01M01F29 e C11M08F73
            $scope.tokenizzazioneReferenti = function(){
            	
            	var _appArray = Object.keys($scope.data.step3.datiReferenti).map(function(i){ return $scope.data.step3.datiReferenti[i]});
            	var _clientiFinali = [];
            	var _lavorazione = $scope.data.step1.causale_ordine;
            	var _request = {
            			codOloAgcom: $scope.data.step1.operatore.codiceOLO,
            			codOrdineOlo: $scope.data.step1.codice_ordine,
            			lavorazione: $scope.data.step1.causale_ordine,
            			idOfferta: $scope.assetDetail.idOfferta
            	};
            	
            	//Dai clienti finali ricava solo i numeri telefonici
            	if(_appArray && _appArray.length > 0){
            		
            		//R1F-20-0236   		
            		_clientiFinali = $scope.estraiDatiReferenti();
            	}
            	
            	if(_clientiFinali && _clientiFinali.length > 0){
                	_request.numeriReferenti = _clientiFinali;
            		_request.indirizzoClienteFinale = {
                			indirizzo_cliente_provincia: null,
                			indirizzo_cliente_comune: null,
                			indirizzo_cliente_indirizzo: null,
                			indirizzo_cliente_civico: null,
                			indirizzo_cliente_particella_toponomastica: null
            		};
                	   
                    if($scope.assetDetail){
                    	_request.codIstatComune = ($scope.assetDetail.codIstatComune || null);
                    	_request.indirizzoClienteFinale.indirizzo_cliente_provincia = ($scope.assetDetail.provincia || null);
            			_request.indirizzoClienteFinale.indirizzo_cliente_comune = ($scope.assetDetail.comune || null);
            			_request.indirizzoClienteFinale.indirizzo_cliente_indirizzo = ($scope.assetDetail.via || null);
            			_request.indirizzoClienteFinale.indirizzo_cliente_civico = ($scope.assetDetail.numero || null);
            			_request.indirizzoClienteFinale.indirizzo_cliente_particella_toponomastica = ($scope.assetDetail.descParticellaToponomastica || null);
                    }
            		
            		if($scope.data.step3){
            			if($scope.data.step3.numeroLinea){
            				_request.dn = $scope.data.step3.numeroLinea;
            			}	
            			if($scope.data.step3.dn){
            				_request.dn = $scope.data.step3.dn;
            			}	
            		}
            		
            		if(!$rootScope.data){
            			$rootScope.data = {};
            		}
            		
                	$rootScope.data.numeriReferentiTokenizzati = [];
            	} 
            	
            	return Tokenizzazione.save(_request).$promise;
            };
            
            //RU_1058
            
            $scope.dataRichiestaCessazioneOptions = {
                    dateDisabled: disabled,
                    formatYear: 'yy',
                    minDate: new Date(),
                    startingDay: 1
            };
            
            $scope.popup_dataRichiestaCessazione = {
                	opened: false 
            };
            
            $scope.openDataRichiestaCessazione = function(){
            	$scope.popup_dataRichiestaCessazione.opened = true;
            };
                        
            
            $scope.oscuramento_RU_1058 = function(){        		
            	try{            		
            		$scope.RU_1058 = !$rootScope.OSCURAMENTI.RU_1058.oscurato;
            	}catch(e){
            		$scope.RU_1058 = false;
            	}          	
            }
            
            $scope.oscuramento_RU_1058();
            
        	$scope.verificaCampi_RU_1058 = function(){
        		var _offerte = [$rootScope.MAP_OFFERTE.VLAN_NGA.id, 
        						$rootScope.MAP_OFFERTE.VLAN_GBE.id, 
        						$rootScope.MAP_OFFERTE.VLAN_VULA.id, 
        						$rootScope.MAP_OFFERTE.VP.id];
        		if($scope.assetDetail && $scope.assetDetail.idOfferta){
        			if(_offerte.indexOf($scope.assetDetail.idOfferta > -1)){
        				$scope.data.step2.codiceOrdineTIVlan = $scope.assetDetail.ordineTI;
        				$scope.data.step2.codiceOrdineOloVlan = $scope.assetDetail.ordineOao;
        			}
        		}
        	}
        	
        	//SM_9712
        	if($scope.RU_1058){            	
            	$scope.setShowDRC();
                $scope.verificaCampi_RU_1058();
        	}
        	
        	//SM_10033
            $scope.headerDatiOrdineProjects = [
                {"key": "cod_prgt", "value": "Codice progetto", "type": "text"},
                {"key": "codfc_olo_agcom", "value": "OLO", "type": "text"},
                {"key": "datainz_valid", "value": "Data inizio Validita", "type": "text"},
                {"key": "datafi_valid", "value": "Data fine validita", "type": "text"}
            ];
            
            $scope.getProjectsForOlo = function ($event) {
            	
            	$event.preventDefault();
            	
            	if($rootScope.formData && $rootScope.formData.projects){
            		$scope.projects = $rootScope.formData.projects;
            		$scope.selectProject();
            	}else{
                    Projects.get({
                        codOlo: $scope.data.step1.operatore.codiceOLO
                    }).$promise.then(
                        function (response) {
                            $scope.projects = response.data;
                            $scope.selectProject();
                        },
                        function () {
                            $log.debug("Impossibile caricare i progetti per l'OAO selezionato.");
                        }
                    );
            	} 
            };
            
            $scope.datiOrdineCallbackProject = function (item) {
                $scope.data.step2.codice_progetto = item;
            };
            
            $scope.selectProject = function(){
            	var _modalConfig = {
    	            headerText: 'Seleziona un Progetto',
    	            actionButtonText: null,
    	            closeButtonText: 'Ok',
    	            contentType: 'modale_nowtable',
    	            scope: $scope,
    	            callbackFunction: 'datiOrdineCallbackProject',
    	            dataHeader: $scope.headerDatiOrdineProjects,
    	            templateUrl: 'app/common/templates.html',
    	            data: $scope.projects
            	};
            	
            	modalService.showModal({}, _modalConfig); 
            };

            $scope.cancellaSelezioneProject = function () {
                $scope.data.step2.codice_progetto = null;
            };
        	
            $scope.setShowCodiceProgetto = function(){
          	    if($scope.assetDetail){
          	    	$scope.showCodiceProgetto = ([$rootScope.MAP_OFFERTE.VP.id, $rootScope.MAP_OFFERTE.VLAN_GBE.id, $rootScope.MAP_OFFERTE.VLAN_VULA.id, $rootScope.MAP_OFFERTE.VLAN_NGA.id,].indexOf($scope.assetDetail.idOfferta) >= 0);
          	    }else{
          	    	$scope.showCodiceProgetto = false
          	    }
            }
            
            $scope.setShowCodiceProgetto();
            
            $scope.$watchGroup(['data.step2.id_risorsa', 'data.step2.codiceOrdineTIVlan', 'data.step2.codiceOrdineOloVlan'], function(newValues, oldValues){
            	if(newValue && newValue !== ''){
            		$scope.isCodiceOrdineTiRequired = false;
            		$scope.isCodiceOrdineOloRequired = false;
            	}else{
            		$scope.isIdRisorsaRequired = true;
            		$scope.isCodiceOrdineTiRequired = true;
            		$scope.isCodiceOrdineOloRequired = true;
            	}
            });
            
            $scope.$watch('data.step2.codiceOrdineTIVlan', function(newValue, oldValue){
            	if(newValue && newValue !== ''){
            		$scope.isIdRisorsaRequired = false;
            		$scope.isCodiceOrdineOloRequired = false;
            	}else{
            		$scope.isIdRisorsaRequired = true;
            		$scope.isCodiceOrdineTiRequired = true;
            		$scope.isCodiceOrdineOloRequired = true;
            	}
            });
            
            $scope.$watch('data.step2.codiceOrdineOloVlan', function(newValue, oldValue){
            	if(newValue && newValue !== ''){
            		$scope.isIdRisorsaRequired = false;
            		$scope.isCodiceOrdineTiRequired = false;            		
            	}else{
            		$scope.isIdRisorsaRequired = true;
            		$scope.isCodiceOrdineTiRequired = true;
            		$scope.isCodiceOrdineOloRequired = true;
            	}
            });
        });
        
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
        
        $scope.C11M08F41 = function(){
        	return VerificaCongruenzaOffertaCodOrdine.get({
        		idOfferta: $rootScope.assetDetail.idOfferta,
        		codOrdine: $rootScope.data.step1.codice_ordine, 
        		codOrdinePadre: $rootScope.data.step1.codice_ordine_padre}).$promise;
        }
        
        //RU_1181 - Verifica recupero modem
        $scope.C11M08F88 = function(){
        	return VerificaRecuperoModem.get({idAsset: $scope.data.step2.idAsset}).$promise;        	
        }
        
        $scope.init();
        
        //R1F-20-0236.B
        $scope.setShowReferenteOaoProgettiSpeciali = function(){

        	$scope.showReferenteOaoProgettiSpeciali = false;    	 
        	var _idOfferta = $scope.assetDetail.idOfferta;
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
        		$rootScope.MAP_OFFERTE.FIBERSTREAM.id,
        		$rootScope.MAP_OFFERTE.GPON_SEMI_PNRR.id,
        		$rootScope.MAP_OFFERTE.GPON_FULL_PNRR.id];

        	if($rootScope.R1F_20_0236){
        		if(_arrayOfferteNonValide.indexOf(_idOfferta) == -1){
        			$scope.showReferenteOaoProgettiSpeciali = true;  
        		}
        	}
        }
        
        //SM_10514
        $scope.$watch('data.step2.codice_progetto', function(newValue, oldValue){
        	if(newValue && newValue.cod_prgt){
        		if($scope.data.step2 && $scope.data.step2.refOaoProgettiSpeciali){
        			$scope.data.step2.refOaoProgettiSpeciali = null;
        		}
        	}
        });
        
        RU_1581_attiva = function() {
			return !$rootScope.OSCURAMENTI.RU_1581.oscurato;
		}
        
    }]);
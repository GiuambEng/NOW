timnow
    .controller('richiestaOrdine', ['$scope', '$state', '$rootScope', '$log', 'modalService', '$filter', 'nuovaRichiestaOrdine', 'ordersAction','SlaValidationService', 'ConvertDateService', 'CodiceRichiesta','RecuperaRichieste', 'VisualizzaCodiciRifiuto', 'TRACKING_GUI', 'TrackingGUI', '$q', 'Tokenizzazione', '_', 'VerificaNumeriNoteOperatore',
                                   function ($scope, $state, $rootScope, $log, modalService, $filter, nuovaRichiestaOrdine, ordersAction,SlaValidationService,ConvertDateService, CodiceRichiesta,RecuperaRichieste, VisualizzaCodiciRifiuto, TRACKING_GUI, TrackingGUI, $q, Tokenizzazione, _, VerificaNumeriNoteOperatore) {

        $rootScope.pageClass = 'dettaglio-ordine';
        //$log.debug('$state.params: ', $state.params);
        $scope.attesaRispostaChiamata=false;
        $scope.caricaDac = true;
        $scope.rimodulazioneVisualizzazione=false;
    	$scope.interruzioneAnnullamentoVisualizzazione=false;
    	$scope.integerval = /^\d*$/;
    	

        if ($state.params.order) {
            $scope.order = $state.params.order;
            $scope.orderNumber = $scope.order.ordineTi || $scope.order.idrichiestaolo;
            $scope.reqType = ($state.params.order.ordineTi) ? 'codiceordineti' : 'idrichiestaolo';
            $scope.data = {};
            $scope.dataTemp = {};
            
            //RU_1479
            $scope.idOfferta = ($scope.order.orderDetails && $scope.order.orderDetails.IdOfferta) ? $scope.order.orderDetails.IdOfferta : $scope.order.idOfferta;
            $scope.isOrdineFWaEolo = ($scope.idOfferta == $rootScope.MAP_OFFERTE.FWAITALIA1GIGASARDEGNA.id);
            $scope.isOrdineOpenFiber = ($scope.idOfferta == $rootScope.MAP_OFFERTE.FIBERSTREAM.id);

            if($scope.order.richiestaCrashed){
                $scope.order.codificaOao = $scope.order.oaoDonating;
                $scope.data.ordineOlo = $scope.order.codiceOrdineOao
            } else {
                $scope.data.ordineOlo = $scope.order.ordineOlo?$scope.order.ordineOlo:$scope.order.richiesta.codiceOrdineOLO;
            }

            $scope.data.oao = $scope.order.codificaOao?$scope.order.codificaOao:$scope.order.richiesta.codificaOAO;

            $scope.data.codice_ordine_ti = $scope.order.ordineTi;
            $scope.data.idRichiestaOlo = $scope.order.idrichiestaolo?$scope.order.idrichiestaolo:$scope.order.idRichiestaOLO;
            $scope.lunghezzaCodiceOrdine=30;

            CodiceRichiesta.get().$promise.then(
        			function(data) {
        				$scope.data.codice_richiesta = data.codiceUnivoco;
        			},
   					function(error) {
      				  $log.info(error);
    				  $log.info("Non e' stato possibile recuperare il codice richiesta");
	                  modalService.showModal({},{
                            headerText: "Recupero Codice Richiesta",
                            bodyText: "Non e' stato possibile recuperare il codice richiesta. Riprovare piu' tardi.",
                            actionButtonText: 'Chiudi',
                            type: 'success'
                        });
					}
      			);

            $scope.CallbackCodiciErrori = function (item) {
                $scope.data.codiceMotivoRifiuto = item.codiceMotivoRifiuto;
                $scope.data.motivoRifiuto = item.motivoRifiuto;
            };

            $scope.modaleCodiciErrori = function (lista) {
                $scope.headerCodiciErrori = [
                    {"key": "codiceMotivoRifiuto", "value": "Codice Motivo Rifiuto", "type": "text"},
                    {"key": "motivoRifiuto", "value": "Motivo Rifiuto", "type": "text"}
                ];

                $scope.modalOptionsTabellaCodiciErrori = {
                    headerText: 'Seleziona Codici Errori',
                    actionButtonText: null,
                    closeButtonText: 'Ok',
                    contentType: 'modale_nowtable',
                    scope: $scope,
                    callbackFunction: 'CallbackCodiciErrori',
                    dataHeader: $scope.headerCodiciErrori,
                    templateUrl: 'app/common/templates.html',
                    data: lista
                };

                //$event.preventDefault();
                modalService.showModal({}, $scope.modalOptionsTabellaCodiciErrori);
            };

            $scope.cambiaRiscontro = function () {
                if($scope.data.riscontroCodiceSessione === 'KO') {

                    var inputDataForCodiciErrore = {
                        ambitoServizioRecipient: $scope.order.ambitoServizioRecipient,
                        ambitoServizioDonating: $scope.order.ambitoServizioDonating
                    };

                    VisualizzaCodiciRifiuto.get(inputDataForCodiciErrore).$promise.then(
                        function(response) {
                            if(response.lista){
                                $scope.modaleCodiciErrori(response.lista);

                            }
                        },
                        function(error) {
                            $log.info("Non e' stato possibile recuperare i codici di rifiuto");
                            $log.info(error);
                            modalService.showModal({},{
                                headerText: "Recupera codici di rifiuto",
                                bodyText: "Non e' stato possibile recuperare i codici di rifiuto. Riprovare piu' tardi.",
                                actionButtonText: 'Chiudi',
                                type: 'success'
                            });

                        }
                    );
                } else {

                    delete $scope.data.codiceMotivoRifiuto;
                    delete $scope.data.motivoRifiuto;
                }

            };

            if($scope.order.richiestaCrashed){
                $scope.richiestaCrashed = true;
                $scope.data.causale_richiesta = $scope.order.richiestaCrashed;
            } else {
                var inputDataForRecuperaRichieste = {
                    lavorazione: $scope.order.tipoLavorazione?$scope.order.tipoLavorazione:'assente',
                    idOfferta: ($scope.order.orderDetails && $scope.order.orderDetails.IdOfferta)?$scope.order.orderDetails.IdOfferta:$scope.order.idOfferta,
                    statoNow: $scope.order.statoNow?$scope.order.statoNow:$scope.order.richiesta.statoNow,
                    flagNaked: $scope.order.Naked?'Y':'N'
                };
                RecuperaRichieste.get(inputDataForRecuperaRichieste).$promise.then(
                    function(response) {
                        $log.info("RecuperaRichieste= "+response.data);
                        $scope.recuperarichieste = response.data;
                        if (response.data.length===0){
                            modalService.showModal({},{
                                headerText: "Recupera Richieste",
                                bodyText: "Nessuna richiesta possibile.",
                                actionButtonText: 'Chiudi',
                                type: 'success'
                            });
                        }

                    },
                    function(error) {
                        $log.info("Non e' stato possibile recuperare le richieste");
                        $log.info(error);
                        modalService.showModal({},{
                            headerText: "Recupera Richieste",
                            bodyText: "Non e' stato possibile recuperare le richieste. Riprovare piu' tardi.",
                            actionButtonText: 'Chiudi',
                            type: 'success'
                        });

                    }
                );
            }


            if($scope.idOfferta){
            	$scope.lunghezzaCodiceOrdine=( $rootScope.getMap_Offerta($scope.idOfferta).regolatorio)?11:30;
            }
            //statorichiestolo e' una stringa
            if ($scope.order.tipoLavorazione === "MIGRAZIONE") {
        		$scope.rimodulazioneVisualizzazione= [$rootScope.MAP_OFFERTE.ULL_LA.id,
        		                                      $rootScope.MAP_OFFERTE.ULLD_LA.id,
        		                                      $rootScope.MAP_OFFERTE.SLU_LA.id,
        		                                      $rootScope.MAP_OFFERTE.SHA_SM.id,
        		                                      $rootScope.MAP_OFFERTE.VULL_LA.id,
        		                                      $rootScope.MAP_OFFERTE.ULL_LANP.id,
        		                                      $rootScope.MAP_OFFERTE.SLU_LANP.id,
        		                                      $rootScope.MAP_OFFERTE.GBE_SF.id,
        		                                      $rootScope.MAP_OFFERTE.ATM_SF.id,
        		                                      $rootScope.MAP_OFFERTE.ATM_SH.id
        		                                      ].indexOf($scope.idOfferta) >= 0;
            }

            //statoRichiesta ATTIVAZIONE Attivazione 274 o Attivazione LA
            if ($scope.order.tipoLavorazione === "MIGRAZIONE" || $scope.order.tipoLavorazione === "ATTIVAZIONE" && [$rootScope.MAP_OFFERTE.ULL_LA.id,
                                                                                                                    $rootScope.MAP_OFFERTE.ULLD_LA.id,
                                                                                                                    $rootScope.MAP_OFFERTE.SLU_LA.id,
                                                                                                                    $rootScope.MAP_OFFERTE.WLR_LA.id,
                                                                                                                    $rootScope.MAP_OFFERTE.VULL_LA.id,
                                                                                                                    $rootScope.MAP_OFFERTE.ULL_LANP.id,
                                                                                                                    $rootScope.MAP_OFFERTE.ULLD_LANP.id,
                                                                                                                    $rootScope.MAP_OFFERTE.SLU_LANP.id].indexOf($scope.idOfferta) >= 0){
	            	$scope.interruzioneAnnullamentoVisualizzazione=true;
        	}
        } else {
            $state.go('root.ordini.lista');
        }
       

        $scope.openDAC = function () {
            $scope.popup_dac.opened = true;
        };

        $scope.popup_dac = {
            opened: false
        };
        
        $scope.openDAD = function () {
            $scope.popup_dad.opened = true;
        };

        $scope.popup_dad = {
            opened: false
        };

        $scope.valida = function (form) {
            angular.forEach(form.$error.required, function (field) {
                field.$setDirty();
            });
        };
        $scope.submitRichiesta = function () {
                    $scope.checkRequest();
        };

        $scope.checkRequest = function () {
        	
        	 $scope.attesaRispostaChiamata=true;
        	
        	//SM_11418
            if($scope.order.richiestaCrashed || $scope.isOrdineFWaEolo){
                $scope.inviaRichiesta();
            } else {               
                var inputDataForRequestCheck = {
                    type:"checkRequest",
                    causaleRichiesta: $scope.data.causale_richiesta,
                    codiceRichiesta: $scope.data.codice_richiesta,
                    ordineTIRichiestaOlo: $scope.data.codice_ordine_ti?$scope.data.codice_ordine_ti:$scope.orderNumber
                };
                if ($scope.dataTemp.dad) {
                    inputDataForRequestCheck.dad = $filter('date')(new Date($scope.dataTemp.dad), 'dd/MM/yyyy');
                    inputDataForRequestCheck.fasciaOraria = $scope.data.fascia_oraria;
                }
                if ($scope.dataTemp.dac) {
                    inputDataForRequestCheck.dac = $filter('date')(new Date($scope.dataTemp.dac), 'dd/MM/yyyy');
                }

                ordersAction.get(inputDataForRequestCheck).$promise.then(function (response) {
                    if (response.result && response.result.code === '0' && response.esito === 'OK') {
                    	$rootScope.dacValidato = true;
                        $scope.inviaRichiesta();
                    } else if (response.esito === 'KO') {
                        $scope.attesaRispostaChiamata=false;
                        $rootScope.dacValidato = false;
                        modalService.showModal({}, {
                            headerText: "Nuova Richiesta",
                            closeButtonText: '',
                            bodyText: response.descrizione,
                            actionButtonText: 'Chiudi',
                            scope: $scope,
                            type: 'error'
                        });
                    } else {
                        $scope.attesaRispostaChiamata=false;
                        modalService.showModal({}, {
                            headerText: "Nuova Richiesta",
                            closeButtonText: '',
                            bodyText: "Impossibile completare l'operazione. Riprovare piu tardi",
                            actionButtonText: 'Chiudi',
                            scope: $scope,
                            type: 'error'
                        });
                    }
                }, function () {
                    $scope.attesaRispostaChiamata=false;
                    $log.debug('Impossibile salvare la richiesta');
                    modalService.showModal({}, {
                        headerText: "Nuova Richiesta",
                        closeButtonText: '',
                        bodyText: "Impossibile completare l'operazione. Riprovare piu tardi",
                        actionButtonText: 'Chiudi',
                        scope: $scope,
                        type: 'error'
                    });
                });
            }
        };
        
        
        //SM_9663
        $scope.sendReq = function(){
	       	 $scope.attesaRispostaChiamata=true;
	         if ($scope.dataTemp.dad){
				$scope.richiesta.dad = $filter('date')(new Date($scope.dataTemp.dad), 'dd/MM/yyyy');
	         } 
			if ($scope.dataTemp.dac){
				$scope.richiesta.dac = $filter('date')(new Date($scope.dataTemp.dac), 'dd/MM/yyyy');
			}
			
			if(_.isEmpty($scope.richiesta.ref_nome)){
				$scope.richiesta.ref_nome = null;
			}
			
			if(_.isEmpty($scope.richiesta.ref_tel_fisso)){
				$scope.richiesta.ref_tel_fisso = null;
			}
			
			if(_.isEmpty($scope.richiesta.ref_tel_cellulare)){
				$scope.richiesta.ref_tel_cellulare = null;
			}
        	
        	nuovaRichiestaOrdine.save({orderNumber: $scope.orderNumber}, $scope.richiesta).$promise
        	.then(function(response){
            	//RU_1010
                //Tracking da GUI per operazione INSERIMENTO                  
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			descrizioneFunzione: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.INSERIMENTO.descrizione,
    	    			parametriOperazione: null 			
                };
                
                
                if($scope.order.richiestaCrashed && $scope.order.richiestaCrashed == "RISCONTROCODICESESSIONE"){
                	_trackBean.descrizioneFunzione = 'Ordini|Ordini Donating|Riscontro Codice Sessione';
                }else{
                	_trackBean.descrizioneFunzione = 'Ordini|Nuova Richiesta';
                }
                
            	$scope.attesaRispostaChiamata=false;
                if (response.result && response.result.code === 'OK') {
                    modalService.showModal({}, {
                        headerText: "Nuova Richiesta",
                        closeButtonText: '',
                        bodyText: "La richiesta è stata inviata con successo.",
                        actionButtonText: 'Chiudi',
                        scope: $scope,
                        type: 'success'
                    });
                    
                    _trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ok';
                    TrackingGUI.tracking(_trackBean);
                    
                    $scope.changeState();
                    $log.debug('Richiesta salvata');
                }
                else if (response.result && response.result.code === 'KO'){                	
                	modalService.showModal({}, {
                        headerText: "Nuova Richiesta",
                        closeButtonText: '',
                        bodyText: response.result.details,
                        actionButtonText: 'Chiudi',
                        scope: $scope,
                        type: 'error'
                    });
                	
                    _trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ko';
                    TrackingGUI.tracking(_trackBean);
                }        		
        	}, function(error){	            	
                $log.debug('Impossibile salvare la richiesta');
                $scope.attesaRispostaChiamata=false;
                modalService.showModal({}, {
                    headerText: "Nuova Richiesta",
                    closeButtonText: '',
                    bodyText: "Impossibile completare l'operazione. Riprovare piu tardi",
                    actionButtonText: 'Chiudi',
                    scope: $scope,
                    type: 'error'
                });
		 });
        }
        
        $scope.inviaRichiesta = function () {

			//SM_9663			
			$scope.richiesta = {};
			angular.copy($scope.data, $scope.richiesta);
			
			//SM_10519			
			$scope.verificaNote()
				.then(function(response){
					if(response.VerificaNumeriNoteOutput && response.VerificaNumeriNoteOutput.esito == 'KO'){
						$scope.attesaRispostaChiamata = false;
		                modalService.showModal({}, {
		                    headerText: "Nuova Richiesta",
		                    closeButtonText: '',
		                    bodyText: response.VerificaNumeriNoteOutput.message,
		                    actionButtonText: 'Chiudi',
		                    scope: $scope,
		                    type: 'error'
		                });
					}else{
						//SM_11418
						if(($scope.R1F_20_0236 || $scope.RU_1084) && $scope._isFormReferenteRequired && $scope.data.ref_qualifica == 'CF' && !$scope.isOrdineFWaEolo && !$scope.isOrdineOpenFiber){
							$scope.tokenizzazioneReferenti()
							.then(function(response){
								if(response.referentiTokenizzati && response.referentiTokenizzati.numeriReferenti){
									$scope.setReferentiTokenizzati(response.referentiTokenizzati.numeriReferenti);
									$scope.sendReq();
								}else{
									$scope.attesaRispostaChiamata = false;
					                modalService.showModal({}, {
					                    headerText: "Nuova Richiesta",
					                    closeButtonText: '',
					                    bodyText: response.result.details,
					                    actionButtonText: 'Chiudi',
					                    scope: $scope,
					                    type: 'error'
					                });
								}
							}, function(error){
								$scope.attesaRispostaChiamata = false;
				                modalService.showModal({}, {
				                    headerText: "Nuova Richiesta",
				                    closeButtonText: '',
				                    bodyText: "Errore nel servizio Tokenizzazione",
				                    actionButtonText: 'Chiudi',
				                    scope: $scope,
				                    type: 'error'
				                });
							})
						}else{
							$scope.sendReq();
						}
					}
				}, function(error){
					$scope.attesaRispostaChiamata = false;
	                modalService.showModal({}, {
	                    headerText: "Nuova Richiesta",
	                    closeButtonText: '',
	                    bodyText: "Errore nel servizio Verifica Note",
	                    actionButtonText: 'Chiudi',
	                    scope: $scope,
	                    type: 'error'
	                });
				});
        };

        $scope.confermaAnnulla = function () {
            modalService.showModal({}, {
                headerText: "Vuoi annullare la richiesta?",
                closeButtonText: 'Chiudi',
                bodyText: "I dati inseriti nella richiesta saranno cancellati.",
                actionButtonText: 'Continua',
                scope: $scope,
                callbackFunction: 'annulla',
                type: 'success'
            });
        };
        $scope.annulla = function () {
            $rootScope.formData = null;
            $scope.changeState();
        };
        
        $scope.changeState = function () {
            if($scope.order.richiestaCrashed){
                $state.go('root.ordini.donating.dettaglio', {
                    order: $state.params.order });
            } else {	
				//SM_10731
				var _state = "";
				if($state.includes('**.listareport.**')){
					_state = "root.ordini.listareport.dettaglio.ordine"
				}else{
					_state = "root.ordini.lista.dettaglio"
				}
				$state.go(_state, {
					reqType: $scope.reqType,
                    orderNumber: $scope.orderNumber,
                    codiceOrdineOlo: $scope.data.ordineOlo
				});	
            }

        };
        
        $scope.svuotaRichiesta = function(){
        	$scope.data.dad=null;
        	$scope.data.dac=null;
        	$scope.data.fascia_oraria=null;
        	$scope.data.ref_nome=null;
        	$scope.data.ref_tel_fisso=null;
        	$scope.data.ref_qualifica=null;
        	$scope.data.ref_cognome=null;
        	$scope.data.ref_tel_cellulare=null;
        	$scope.dataTemp.dac=null;
        	$scope.dataTemp.dad=null;
        	$scope.data.note_altre_lavorazioni=null;
        	
        	//SM_10519
        	if($scope.data.causale_richiesta == 'DESOSPENSIONE'){
        		$scope._isFormReferenteRequired = true;
        	}
        };
        
        $scope.validationDac = function (data) {
        	if(data){
        		$scope.caricaDac = false;
                var item = SlaValidationService.get(
                    ConvertDateService.get(data),
                    $scope.data.causale_richiesta,
                    $scope.order.orderDetails.IdOfferta, 'offer');

              //outcome.codice e' una stringa
                item.then(function (response) {
                        $scope.caricaDac = true;
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
                    },
                    function (error) {
                        $scope.caricaDac = true;
                        $rootScope.dacValidato = false;
                        $rootScope.dacMessaggioErrore = "Impossibile validare la Data";
                    });
        	}
        };
        
        
        //SM_9351
        //SM_9275
        //Fasce orarie
        $scope.time_slot = {
        	"01" : "08:30 - 10:30",
        	"02" : "10:30 - 13:00",
        	"03" : "13:00 - 15:00",
        	"04" : "15:00 - 17:00"
        };
               

        //SM_9611
        var _hasOwnerPresaAppuntamento = false;
        var _objAppuntamento = null;
        var _app = [];
        
        if($scope.order && $scope.order.servizi && $scope.order.servizi.length > 0){
        	_objAppuntamento = $scope.order.servizi.find(function(x) { return (x.product === "APPUNTAMENTODISAGGREGAZIONE");});
        	
            if(_objAppuntamento){
            	_app = _objAppuntamento.customizations;
            }

            if(_app.length > 0){
    	        //SM_9625
            	var _objOwner = _app.find(function(x) {return (x.attribute === "OWNERPRESAAPPUNTAMENTO"); }).value;        	
            	if(_objOwner && (_objOwner == 'OP' || _objOwner == 'SU')){
            		_hasOwnerPresaAppuntamento = true;
            	}
            }
            
            //SM_9398
            //SM_9611
            //RU_1150
            //RU_1462
            if((_hasOwnerPresaAppuntamento && $scope.order.disaggregato && $scope.order.disaggregato == 'S') || 
            	([$rootScope.MAP_OFFERTE.GPON_SEMI.id, $rootScope.MAP_OFFERTE.GPON_FULL.id, $rootScope.MAP_OFFERTE.FIBERSTREAM.id].indexOf($scope.order.idOfferta) > -1)){
            	$scope.time_slot["05"] = "17:00 - 19:00";
            }        	
        	
        }   
        
        //SM_9663
        $scope.oscuramento_RU_1084 = function(){    		
        	try{
        			$scope.RU_1084 = !$rootScope.OSCURAMENTI.RU_1084.oscurato;
        	}catch(e){
        		$scope.RU_1084 = false;
        	}          	
        }
        
        $scope.oscuramento_RU_1084();
        
        //R1F-20-0236
        $scope.oscuramento_R1F_20_0236 = function(){
        	
        	var _idOfferta = ($scope.order.orderDetails && $scope.order.orderDetails.IdOfferta) ? $scope.order.orderDetails.IdOfferta : $scope.order.idOfferta;
    		
        	try{
        		if(_idOfferta){            			
        			if(!$rootScope.OSCURAMENTI.R1F_20_0236.oscurato){   				
       					$scope.R1F_20_0236 = ($rootScope.OSCURAMENTI.R1F_20_0236.idOfferteNonValide.indexOf(_idOfferta) == -1);  				
        			}else{
        				$scope.R1F_20_0236 = false;     			
        			}
        		}
        	}catch(e){
        		$scope.R1F_20_0236 = false;
        	}          	
        }
        
        $scope.oscuramento_R1F_20_0236();
        
        
        $scope.oscuramento_R1F_20_0236D = function(){
    		
        	try{        			
    			if(!$rootScope.OSCURAMENTI.R1F_20_0236D.oscurato){   				
   					$scope.R1F_20_0236D = !($rootScope.OSCURAMENTI.R1F_20_0236D.oscurato);  				
    			}else{
    				$scope.R1F_20_0236D = false;     			
    			}
        	}catch(e){
        		$scope.R1F_20_0236D = false;
        	}          	
        }
        
        $scope.oscuramento_R1F_20_0236D();
        
        $scope.setReferentiTokenizzati = function(referenti){ 
        	if(referenti && referenti.length > 0){
        		$scope.richiesta.ref_tel_cellulare = referenti[0].numeroMobile;
        		$scope.richiesta.ref_tel_fisso = referenti[0].numeroFisso;
        		//SM_10519
        		$scope.richiesta.ref_nome = referenti[0].nome;
        		$scope.richiesta.ref_cognome = referenti[0].cognome;        		
        	}
        }
        
        
    	//R1F-20-0236
    	//Nel caso di C2PLUS nuovo disoscurato, estraggo tutti i campi per cliente finale
    	//altrimenti solo quelli richiesti da C2PLUS classico (numeri telefonici) 
        $scope.estraiDatiReferenti = function(){
        	
        	//Dalla lista dei referenti estrae solo i Clienti Finali
        	var _clientiFinali = [];
        	
        	if($scope.data.ref_qualifica == 'CF'){
    			//SM_10450
    			//SM_10519
				_clientiFinali.push({
    				id: 0,
    				numeroMobile: ($scope.data.ref_tel_cellulare || null),
    				numeroFisso: ($scope.data.ref_tel_fisso || null),
    				nome: ($scope.data.ref_nome || null),
    				cognome: ($scope.data.ref_cognome || null)
    			});
        	}
    		
    		return _clientiFinali;
        }        
        
        //Comprende le funzioni C01M01F29 e C11M08F73
        $scope.tokenizzazioneReferenti = function(){

        	var _request = {
        			codOloAgcom: $scope.data.oao,
        			codOrdineOlo: $scope.data.ordineOlo,
        			lavorazione: $scope.data.causale_richiesta,
        			codiceOrdineTi: $scope.data.codice_ordine_ti
        	};
        	
        	//R1F-20-0236        	
        	_request.numeriReferenti = $scope.estraiDatiReferenti();
        	
    		_request.indirizzoClienteFinale = {
        			indirizzo_cliente_provincia: null,
        			indirizzo_cliente_comune: null,
        			indirizzo_cliente_indirizzo: null,
        			indirizzo_cliente_civico: null,
        			indirizzo_cliente_particella_toponomastica: null
    		};
    		        	
        	return Tokenizzazione.save(_request).$promise;        	
        };  
        
        
        //SM_10519
        
        $scope.verificaFormReferentiRequired = function(){     
    		if(($scope.data.ref_nome && $scope.data.ref_nome != '' )|| 
    				($scope.data.ref_cognome && $scope.data.ref_cognome != '') ||
    				($scope.data.ref_tel_fisso && $scope.data.ref_tel_fisso != '') || 
    				($scope.data.ref_tel_cellulare && $scope.data.ref_tel_cellulare != '') ||
    				($scope.data.ref_qualifica && $scope.data.ref_qualifica != '') || 
    				($scope.data.ref_email && $scope.data.ref_email != '')){
    			$scope._isFormReferenteRequired = true;
    		}else{
    			$scope._isFormReferenteRequired = false;
    		}
        }
        
        $scope.setNomeReferenteRequired = function(){
        	$scope._isNomeReferenteRequired = true;
        	var _arrayOfferteRegolatorio = [$rootScope.MAP_OFFERTE.WLR_LA.id,
        									$rootScope.MAP_OFFERTE.WLR_LNA.id,
        									$rootScope.MAP_OFFERTE.ULL_LA.id,
        									$rootScope.MAP_OFFERTE.ULL_LNA.id,
        									$rootScope.MAP_OFFERTE.ULL_LANP.id,
        									$rootScope.MAP_OFFERTE.ULLD_LA.id,
        									$rootScope.MAP_OFFERTE.ULLD_LANP.id,
        									$rootScope.MAP_OFFERTE.ULLD_LNA.id,
        									$rootScope.MAP_OFFERTE.VULL_LA.id,
        									$rootScope.MAP_OFFERTE.VULL_LNA.id,
        									$rootScope.MAP_OFFERTE.SHA_CM.id,
        									$rootScope.MAP_OFFERTE.SHA_SM.id,
        									$rootScope.MAP_OFFERTE.CPS.id,
        									$rootScope.MAP_OFFERTE.SLU_LA.id,
        									$rootScope.MAP_OFFERTE.SLU_LNA.id,
        									$rootScope.MAP_OFFERTE.SLU_LANP.id];
        	
        	if(_arrayOfferteRegolatorio.indexOf($scope.idOfferta) > -1){
        		$scope._isNomeReferenteRequired = false;
        	}        	
        }
        
        $scope.verificaNote = function(){
    		var _request = {
        			codOloAgcom: $scope.order.codificaOao
        		};
    		
    		_request.note = '';
    		
    		if($scope.data.note_da_operatore && $scope.data.note_da_operatore != ''){
    			_request.note = angular.copy($scope.data.note_da_operatore);
    		}
    		
    		if($scope.data.note_altre_lavorazioni && $scope.data.note_altre_lavorazioni != ''){
    			_request.note = (_request.note + ' ' + $scope.data.note_altre_lavorazioni);
    		}
        		
        	return VerificaNumeriNoteOperatore.save(_request).$promise;
        }
    }
    ]);
timnow
    .controller('listaRicariche', ['alertService', '$scope', '$state', '$rootScope',  '$log', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'CRM_RICARICHE_PROFILE', 'TRACKING_GUI', 'TrackingGUI',
        function (alertService, $scope, $state, $rootScope, $log, AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, CRM_RICARICHE_PROFILE, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = $state.current.params.pageClass;
            var userProfile = $rootScope.timnowConfigData.user.codiceProfilo;

            $scope.tastiAbilitati = CRM_RICARICHE_PROFILE.hasOwnProperty(userProfile);
           
        $scope.enableRicercaRicariche=true;
        // MODALE PER MESSAGGIO DI ERRORE
        $scope.errorMessage = function (messageBody) {
            modalService.showModal({}, {
                headerText: "Avviso",
                closeButtonText: 'Chiudi',
                bodyText: messageBody,
                scope: $scope,
                type: 'success'
            });
            $scope.caricaPassFive = false;
        };
        if ($rootScope.formData) {
            delete $rootScope.formData;
        }

        if ($rootScope.dacValidatoAsset) {
            delete $rootScope.dacValidatoAsset;
        }

        //solo singola lista
        $scope.RicaricaLoaded = true;


        $scope.headerList = [
            {"key": "codificaOAO", "value": "Codifica OAO", "type": "text"},
            {"key": "idRisorsa", "value": "ID Risorsa", "type": "text"},
            {"key": "dataInizioRicarica", "value": "Data Inizio Ricarica", "type": "text"},
            {"key": "dataFineRicarica", "value": "Data Fine Ricarica", "type": "text"},
            {"key": "stato", "value": "Stato", "type": "text"},
            {"key": "tipologiaAccensioneRicarica", "value": "Tipologia Accensione Ricarica", "type": "text"},
            {"key": "ultimoAggiornamento", "value": "Ultimo Aggiornamento", "type": "text"},
            {"key": "userId", "value": "User Id", "type": "text"}
        ];

        $scope.detailList = [];
        $scope.detailList.push({"key": "taglioRicaricaInGiorni", "value": "Taglio Ricarica in Giorni", "type": "text"});
        $scope.detailList.push({"key": "dataInserimentoRichiesta", "value": "Data Inserimento Richiesta", "type": "text"});
        $scope.detailList.push({"key": "dataAnnullamento", "value": "Data Annullamento", "type": "text"});
        if(!$scope.tastiAbilitati){
            $scope.detailList.push({"to":"root.consistenze.listaricariche.richiestaRicarica",
                                    "mode": "PROLUNGAMENTO",
                                    "key" : "Prolungamento",
                                    "ButtonValue": "Prolungamento ricarica",
                                    "type": "buttonConditionDisabledDoubleDifferentCondition",
                                    "disabledA" : "stato",
                                    "disabledValueA" : "ACCESA",
                                    "disabledB" : "statoAssetDinamico",
                                    "disabledValueB" : "CESSATO"
            });
            $scope.detailList.push({"to":"root.consistenze.listaricariche.richiestaRicarica",
                                    "mode": "ANNULLAMENTO",
                                    "key" : "Annullamento",
                                    "ButtonValue": "Annullamento ricarica",
                                    "type": "buttonConditionDisabledTripleDifferentCondition",
                                    "disabledA" : "tipologiaAccensioneRicarica",
                                    "disabledValueA" : ["SCHEDULATA", "PROLUNGATA"], //RU_692 
                                    "disabledB" : "stato",
                                    "disabledValueB" : "CESSATO",
                                    "disabledC" : "statoAssetDinamico",
                                    "disabledValueC" : "CESSATO"
            });

        }
        $scope.detailList.push({"to":"root.consistenze.listarichiestericarica", "mode": "Dettaglio", "key" : "Dettaglio", "ButtonValue": "Dettaglio Richieste", "type": "buttonClick"});

        $scope.tipologia = $state.params.tipologia;

        function init() {
            alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare le lista Ricariche di interesse.","danger",10000);
            $scope.RicaricaLoaded = true;
            $scope.errorDate = true;

        }

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }


        $scope.search = function () {
            $scope.RicaricaLoaded = false;
            $scope.enableRicercaRicariche=false;
            if ($scope.idRisorsa) {

                $scope.paramToSearch[0] = {"nome": "A.IDRISORSA", "operazione": "=", "valore": $scope.idRisorsa, "tipo": "STRING"};
                
            	//RU_1010
                //Tracking da GUI per operazione INSERIMENTO
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Asset|Lista Ricariche',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };


                //$rootScope.RicercaAdvListaIdsluco = $scope.paramToSearch;
                var ricariche = AdvancedSearchGetDati.save({type: 'listaRicaricheAssets'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                ricariche.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }

                        if (data.lista && data.dettaglioAsset) {
                            $scope.ricariche = data.lista;
                            $scope.dettaglioAsset = data.dettaglioAsset;
                            
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);

                        } else {
                            $scope.errorMessage("Non è stata trovata alcuna corrispondenza");
                            $scope.ricariche = null;
                            $scope.dettaglioAsset = null;
                            
                            _trackBean.timestampFine = new Date().toISOString();
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.RicaricaLoaded = true;
                    }, function () {
                        modalService.alertSearchError();
                        $scope.RicaricaLoaded = true;
                        
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
                init();
            }
        };


        $scope.iniziaExport = function () {
            $scope.exporting = true;

            var bodyData = {
                "idRichiesta": [],
                "tipoprofilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "numerorighe": "",
                "indiceriga": "",
                "exportRequest": true,
                "conditions": $scope.paramToSearch
            };
            
          //RU_902
            $rootScope.numeroDatiEsportati = $scope.ricariche.length;

            return ExportId.save({entita: 'listaRicaricheAssets'}, bodyData).$promise;

        };

        $scope.ricarica = function (tipologia) {

            if($scope.dettaglioAsset){

                var ricaricaType = [];
                ricaricaType.dettaglioAsset = $scope.dettaglioAsset;
                ricaricaType.dettaglioAsset['tipologiaAccensioneRicarica'] = "ACCENSIONE";
                ricaricaType.tipologia = tipologia;

                $state.go('root.consistenze.listaricariche.richiestaRicarica', {"ricaricaType": ricaricaType});
            }

        }


        if($state.params.ricaricaType){
            $scope.idRisorsa = $state.params.ricaricaType.idRisorsa;
            $scope.search();
        }
    }]);
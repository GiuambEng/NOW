timnow
    .controller('notificheOloController', ['$scope', '$state', '$rootScope', 'NotificheOloRichiesta', 'AdvancedSearchGetDati', '$log', 'modalService', 'ExportId', 'TRACKING_GUI', 'TrackingGUI',
        function ($scope, $state, $rootScope, NotificheOloRichiesta, AdvancedSearchGetDati, $log, modalService, ExportId, TRACKING_GUI, TrackingGUI) {
            $rootScope.pageClass = 'notificheOlo';
            $scope.init = function () {
                //solo singola lista
                $scope.listNotificheOlo = [];
                $scope.listLoaded = true;
                $scope.showTable = false;
                $scope.tipologiaRicerca = 'Monitoraggio Notifiche';
                $scope.tipologia = 'Notifiche OLO';
                $scope.detailArg = [];
                $scope.dataContainer = [];
                $scope.paramToSearch = [];
                $scope.headerList = [{"key": "ordineOlo","value": "Ordine OLO","type": "text"}, 
                                     {"key": "ordineTi","value": "Ordine TI","type": "text"}, 
                                     {"key": "codificaOao","value": "Codifica OAO","type": "text"}, 
                                     {"key": "idRichiesta","value": "ID richiesta","type": "text"}, 
                                     {"key": "lavorazione","value": "Lavorazione","type": "text"}, 
                                     {"key": "statoA","value": "Stato A","type": "text"}, 
                                     {"key": "statoDa","value": "Stato Da","type": "text"}, 
                                     {"key": "rowIdTracciamento","value": "RowID Tracciamento","type": "text"}, 
                                     {"key": "dataNotifica","value": "Data notifica","type": "text"}, 
                                     {"key": "idNotifica","value": "ID notifica","type": "text"}, 
                                     {"key": "descrizione","value": "Descrizione","type": "text"}, 
                                     {"key": "tipologiaOlo","value": "Tipologia OLO","type": "text"}, 
                                     {"key": "rowIdNotifica","value": "RowID Notifica","type": "text"}, 
                                     {"key": "canale","value": "Canale","type": "text"}, 
                                     {"key": "tracciatoErrore","value": "Tracciato Errore","type": "text"}, 
                                     {"key": "famigliaOfferta","value": "Famiglia Offerta","type": "text"}, 
                                     {"key": "offerta","value": "Offerta","type": "text"}, 
                                     {"key": "nomeFileNotificaOraria", "value": "Nome File Notifica Oraria", "type": "text"}, 
									 {"key": "nomeFileNotificaGiornaliera", "value": "Nome File Notifica Giornaliera", "type": "text"}, 
									 {"key": "dataInserimentoFile", "value": "Data Inserimento File", "type": "text"}, 
									 {"key": "dataInvioFile", "value": "Data invio file", "type": "text"}, 
									 {"key": "esitoInvio", "value": "Esito invio", "type": "text"}, 
									 {"key": "attesa", "value": "Attesa", "type": "text"}, 
									 {"key": "stato", "value": "Stato", "type": "text"}, 
									 {"key": "dataPassaggioStato", "value": "Data Passaggio Stato", "type": "text"}, 
									 {"key": "dataAcquisizioneOrdine", "value": "Data Acquisizione Ordine", "type": "text"}, 
									 {"key": "numeroTelefonoCliente", "value": "Numero Telefono Cliente", "type": "text"}, 
									 {"key": "soglia", "value": "Soglia", "type": "text"}];

                $scope.modalDefs = {
                    templateUrl: 'app/monitoraggio/olonotifiche/requestDetailmodal.html'
                };

                $scope.modalRequestDetail = {
                    scope: $scope
                };
            };

            $scope.getSearchAdvanced = function () {
                if ($scope.paramToSearch.length > 0) {
                	
                	//RU_1010
                    //Tracking da GUI per operazione RICERCA AVANZATA
                    var _trackBean = {
        	    			timestampInizio: new Date().toISOString(),
        	    			timestampFine: null,
        	    			numeroDatiEsportati: 0,
        	    			contenutoFile: null,
        	    			descrizioneFunzione: 'Monitoraggio|Monitoraggio Notifiche OLO',
        	    			nomeFile: null,
        	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
        	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                    };
                	
                    $scope.listLoaded = false;
                    var successCallback = function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError(); 
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }else{
                        	$scope.listNotificheOlo = data.detail;
                        	
                        	_trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        
                        $scope.listLoaded = true;
                        $scope.showTable = true;
                    };
                    var errorCallback = function (error) {
                        modalService.alertSearchError();
                        $scope.listLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    };
                    AdvancedSearchGetDati.save({
                        type: 'monitoraggio-notifiche-olo'
                    }, {
                        conditions: $scope.paramToSearch,
                        indiceriga: '',
                        numerorighe: ''
                    }).$promise.then(successCallback, errorCallback);
                } else {
                    modalService.showModal({}, {
                        headerText: "Notifiche Olo",
                        bodyText: "E' necessario aggiungere almeno un filtro nella ricerca per visualizzare le notifiche.",
                        actionButtonText: 'Chiudi'
                    });
                }
            };

            $scope.showRequestDetail = function (selectedNotifica) {
                $log.debug(selectedNotifica);
                if (selectedNotifica.ordineTi) {
                    NotificheOloRichiesta.get({
                        cordiceOrdineTi: selectedNotifica.ordineTi
                    }).$promise.then(function (response) {
                            $scope.modalRequestDetail.data = response;
                            $scope.modalRequestDetail.selFamily = selectedNotifica.ordineTi;

                            modalService.showModal($scope.modalDefs, $scope.modalRequestDetail);
                        }, function (error) {
                            $log.error(error);
                            $log.info("Impossibile visualizzare il dettaglio");

                        });
                } else {
                    $log.info("Impossibile visualizzare il dettaglio");
                }
            };

            $scope.init();

            /* EXPORT DATI */
            $scope.iniziaExport = function () {
                var bodyData = {
                    "exportRequest": true,
                    "conditions": $scope.paramToSearch
                };
                
              //RU_902
                $rootScope.numeroDatiEsportati = $scope.listNotificheOlo.length;
                
                return ExportId.save({entita: 'monitoraggio-notifiche-olo'}, bodyData).$promise;
            };
        }]);
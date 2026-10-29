timnow
    .controller('rinvioNotificheController', ['$scope', '$rootScope', '$log', 'modalService', '$anchorScroll', '$location', 'OLOforRinvioNotifiche', 'RichiesteForOLO', 'RinvioNotifiche', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $rootScope, $log, modalService, $anchorScroll, $location, OLOforRinvioNotifiche, RichiesteForOLO, RinvioNotifiche, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'rinvioFile';

        $scope.init = function () {
            //solo singola lista
            $scope.listaOlo = [];
            $scope.olosLoaded = false;
            $scope.tipologia = 'OLO';

            $scope.listaRichiestePerOlo = [];
            $scope.tipologiaRichieste = 'Richieste';
            $scope.detailArgRichieste = [];
            $scope.richiesteLoaded = false;

            $scope.listaNotifiche = [];
            $scope.tipologiaListaNotifiche = 'Notifiche';
            $scope.detailArgNotifiche = [];
            $scope.notificheLoaded = false;


            $scope.headersModale = {
                "idRichiesta": "Id Richiesta",
                "idNotifica": "Id Notifica",
                "est": "Esito"
            };

            $scope.headersListaOlo = [
                {"key": "olo", "value": "OLO", "type": "text"},
                {"key": "ragioneSociale", "value": "Ragione Sociale", "type": "text"},
                {"key": "codiceOlo", "value": "Codice OLO", "type": "text"},
                {"key": "codificaOlo", "value": "Codifica OLO", "type": "text"}
            ];

            $scope.headersListaRichieste = [
                {"key": "delete", "value": "Seleziona", "type": "selectable"},
                {
                    "key": "dataCreazioneRichiesta",
                    "value": "Data Creazione Richiesta",
                    "type": "data",
                    "pattern": "dd/MM/yyyy"
                },
                {"key": "codiceOrdineTI", "value": "Ordine TI", "type": "text"},
                {"key": "statoNOW", "value": "Stato NOW", "type": "text"},
                {"key": "statoOLO", "value": "Stato OLO", "type": "text"},
                {"key": "dro", "value": "DRO", "type": "data", "pattern": "dd/MM/yyyy"},
                {"key": "idRisorsa", "value": "ID Risorsa", "type": "text"},
                {"key": "ambito", "value": "Ambito", "type": "text"},
                {"key": "offerta", "value": "Offerta", "type": "text"},
                {"key": "codiceOrdineOLO", "value": "Codice Ordine OLO", "type": "text"}
            ];

            $scope.headersListaNotifiche = [
                {"key": "delete", "value": "Seleziona", "type": "selectable"},
                {"key": "dataCreazione", "value": "Data Creazione", "type": "data", "pattern": "dd/MM/yyyy"},
                {"key": "tipologiaNotifica", "value": "Tipologia Notifica", "type": "text"},
                {"key": "idNotifica", "value": "Identificativo Notifica", "type": "text"},
                {"key": "descrizioneCausaleOlo", "value": "Causale", "type": "text"},
                {
                    "key": "tipologiaNtfGiornaliero",
                    "value": "Identificativo Tipologia Stato Notifica File Giornaliero",
                    "type": "text"
                },
                {
                    "key": "tipologiaNtfMensile",
                    "value": "Identificativo Tipologia Stato Notifica File Mensile",
                    "type": "text"
                },
                {
                    "key": "tipologiaNtfOrario",
                    "value": "Identificativo Tipologia Stato Notifica File Orario",
                    "type": "text"
                },
                {"key": "origineNotifica", "value": "Origine Notifica", "type": "text"},
                {"key": "strutturaRichiesta", "value": "Struttura Richiesta", "type": "text"},
                {"key": "tracciatoFile", "value": "Tracciato File", "type": "popupXML"},
                {"key": "tracciatoMail", "value": "Tracciato Mail", "type": "text"},
                {"key": "flagNotificaStandard", "value": "Flag Notifica Standard", "type": "text"},
                {"key": "flagNotificaStraordinaria", "value": "Flag Notifica Straordinaria", "type": "text"},
                {"key": "flagNotificaMail", "value": "Flag Notifica Mail", "type": "text"}
            ];

            $scope.getOLOs();
        };

        $scope.getOLOs = function () {

            var successCallback = function (data) {
                if (data.result.code < 0) {
                    modalService.alertSearchError();
                    return false;
                }
                if (data.data) {
                    $scope.listaOlo = data.data;
                }
                $scope.olosLoaded = true;
            };

            var errorCallback = function () {
                modalService.alertSearchError();
                $scope.olosLoaded = true;
            };

            OLOforRinvioNotifiche.get().$promise.then(successCallback, errorCallback);

        };

        $scope.selectOlo = function (item) {

        	$scope.showResourcesTable = true;
            $scope.showNotificheTable = false;
            $scope.invioResourcesSending = true;

            if ($scope.listaRichiestePerOlo) {
                $scope.listaRichiestePerOlo = null;
            }
            
            //RU_1010
            //Tracking da GUI per operazione RICERCA AVANZATA
            
            var _params = { codOloAgcom: item.codificaOlo, codOloNow: item.codiceOlo };
            
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Monitoraggio|Rinvio Notifica',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: JSON.stringify(_params) 			
            };

            var successCallback = function (data) {
                $scope.invioResourcesSending = false;
                $scope.showResourcesTable = true;
                
                _trackBean.timestampFine = new Date().toISOString();
                
                if (data.result.code < 0) {
                    modalService.alertSearchError();
                    
                    _trackBean.esito = 'Ko';                        
                    TrackingGUI.tracking(_trackBean);
                    
                    return false;
                }
                if (data.data) {
                    $scope.listaRichiestePerOlo = data.data;
                    
                    _trackBean.esito = 'Ok';                        
                    TrackingGUI.tracking(_trackBean);
                }
                
                $scope.richiesteLoaded = true;
                $location.hash('richiesteOLO');
                $anchorScroll();
            };

            var errorCallback = function () {
                $scope.richiesteLoaded= false;
                modalService.alertSearchError();
                $scope.richiesteLoaded = true;
                $scope.invioResourcesSending = false;
                
                _trackBean.timestampFine = new Date().toISOString();
                _trackBean.esito = 'Ko';                        
                TrackingGUI.tracking(_trackBean);
            };
            
            $scope.codoloFinale = {};
            $scope.codoloFinale.codiceOloAgcom = item.codificaOlo;
            $scope.codoloFinale.codiceOloNow = item.codiceOlo;
            RichiesteForOLO.get({
                codOloAgcom: item.codificaOlo,
                codOloNow: item.codiceOlo
            }).$promise.then(successCallback, errorCallback);

        };

        $scope.rinviaNotificheSelezionate = function () {
            var notificheDaReinviare = [];
            $scope.invioNotificheSending = true;
            
            //RU_1010
            //Tracking da GUI per operazione INSERIMENTO
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Monitoraggio|Rinvio Notifica',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
            };
            
            if ($scope.detailArgNotifiche && $scope.detailArgNotifiche.length > 0) {

                for (var index = 0; index < $scope.detailArgNotifiche.length; index++) {
                    var item = $scope.detailArgNotifiche[index];

                    notificheDaReinviare[index] = {
                        idNotifica: item.idNotifica,
                        idRichiestaOlo: item.idRichiesta,
                        tipologiaNotificaRecipent: item.tipologiaNotifica
                    };
                }

                if (notificheDaReinviare.length) {
                    var successCallback = function (response) {
                        $scope.invioNotificheSending = false;
                        for (var index = 0; index < response.data.length; index++) {
                            response.data[index].est = response.data[index].esito.descrizione;
                            delete response.data[index].esito;
                        }

                        modalService.showModal({}, {
                            headerText: "Re-invio Notifiche",
                            templateUrl: 'app/common/templates.html',
                            actionButtonText: null,
                            closeButtonText: 'Ok',
                            contentType: 'table_Dett_inline',
                            dataHeader: $scope.headersModale,
                            data: response.data
                        });
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ok';
                        TrackingGUI.tracking(_trackBean);
                        
                        $scope.getSearchAdvanced();
                    };

                    var errorCallback = function () {
                        $scope.invioNotificheSending = false;
                        
                        modalService.showModal({}, {
                            headerText: "Re-invio Notifiche",
                            bodyText: "Non e' stato possibile effettuare l'invio dei file. Prova piu' tardi.",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                        $scope.listLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';
                        TrackingGUI.tracking(_trackBean);

                    };

                    RinvioNotifiche.rinvia({level:'level2'},{
                        listaRichieste: notificheDaReinviare,
                        codOlo: $scope.codoloFinale
                    }, successCallback, errorCallback);
                }
            } else {
                $scope.invioNotificheSending = false;
                modalService.showModal({}, {
                    headerText: "Re-invio Notifiche",
                    bodyText: "E' necessario selezionare almeno una notifica.",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
                $scope.listLoaded = true;

            }
        };


        $scope.getNotifiche = function () {
            var idRichiesteSelezionate = [];
            $scope.showNotificheTable = true;
            for (var index = 0; index < $scope.detailArgRichieste.length; index++) {
                idRichiesteSelezionate.push($scope.detailArgRichieste[index].idRichiestaOlo);
            }

            if (idRichiesteSelezionate.length) {
                var successCallback = function (response) {
                    $scope.listaNotifiche = response.data;
                    $scope.showSpinner = false;
                    $scope.notificheLoaded = true;
                    $location.hash('notificheOLO');
                    $anchorScroll();
                };

                var errorCallback = function () {
                	 $scope.showNotificheTable = false;
                    modalService.showModal({}, {
                        headerText: "Re-invio Notifiche",
                        bodyText: "Non e' stato possibile effettuare l'invio delle notifiche. Prova piu' tardi.",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                };
                RinvioNotifiche.rinvia({level:'level1'},idRichiesteSelezionate).$promise.then(successCallback, errorCallback);
            } else {
                $scope.showSpinner = false;
                $scope.showNotificheTable = false;
                modalService.showModal({}, {
                    headerText: "Re-invio Notifiche",
                    bodyText: "E' necessario selezionare almeno una richiesta.",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
            }
        };

        $scope.init();
    }]);
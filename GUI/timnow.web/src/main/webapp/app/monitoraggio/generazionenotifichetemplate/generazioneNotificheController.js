timnow
    .controller('generazioneNotificheController', ['$scope', '$rootScope', '$log', 'modalService', '$anchorScroll', '$location', 'RichiesteForOLONotificheTemplate', 'GeneraNotificheTemplate', 'ListaTipologieNotificheAttese','$filter', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $rootScope, $log, modalService, $anchorScroll, $location, RichiesteForOLONotificheTemplate, GeneraNotificheTemplate, ListaTipologieNotificheAttese,$filter, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'generazioneNotifiche';

        $scope.init = function () {
            //solo singola lista
            $scope.tipologia = 'OLO';

            $scope.listaRichiestePerOlo = [];
            $scope.tipologiaRichieste = 'Richieste';
            $scope.detailArgRichieste = [];
            $scope.richiesteLoading = false;

            $scope.listaNotifiche = [];
            $scope.tipologiaListaNotifiche = 'Notifiche';
            $scope.tipologiaListaNotificheAttese = 'Notifiche Attese';
            $scope.detailArgNotifiche = [];
            $scope.notificheLoaded = false;


            $scope.headersListaOlo = [
                {"key": "olo", "value": "OLO", "type": "text"},
                {"key": "ragioneSociale", "value": "Ragione Sociale", "type": "text"},
                {"key": "codiceOlo", "value": "Codice OLO", "type": "text"},
                {"key": "codificaOlo", "value": "Codifica OLO", "type": "text"}
            ];
            
            $scope.headersListaRichieste = [
                {"key": "delete", "value": "Seleziona", "type": "selectable"},
                {"key": "dataCreazioneRichiesta", "value": "Data Creazione Richiesta", "type": "text"},
                {"key": "ordineTI", "value": "Ordine TI", "type": "text"},
                {"key": "statoNOW", "value": "Stato NOW", "type": "text"},
                {"key": "statoOLO", "value": "Stato OLO", "type": "text"},
                {"key": "dro", "value": "DRO", "type": "text"},
                {"key": "idRisorsa", "value": "ID Risorsa", "type": "text"},
                {"key": "ambito", "value": "Ambito", "type": "text"},
                {"key": "offerta", "value": "Offerta", "type": "text"}
            ];

            $scope.headersListaNotificheAttese = [
                {"key": "delete", "value": "Seleziona", "type": "selectable"},
                {"key": "descrCodTipoDonating", "value": "Codice Notifica Donating", "type": "text"},
                {"key": "descrCodTipoDonor", "value": "Codice Notifica Donor", "type": "text"},
                {"key": "descrCodTipoRecipient", "value": "Codice Notifica Recipient", "type": "text"},
                {"key": "statoNowA", "value": "Stato NOW A", "type": "text"},
                {"key": "statoNowDa", "value": "Stato NOW Da", "type": "text"},
                {"key": "tipologiaLavorazione", "value": "Tipologia Lavorazione", "type": "text"},
                {
                    "key": "flagDestinazioneDonating",
                    "value": "Checkbox Destinatario Donating",
                    "type": "checkboxEditabile"
                },
                {"key": "flagDestinazioneDonor", "value": "Checkbox Destinatario Donor", "type": "checkboxEditabile"},
                {
                    "key": "flagDestinazioneRecipient",
                    "value": "Checkbox Destinatario Recipient",
                    "type": "checkboxEditabile"
                }
            ];

            $scope.headersModale = [
                {"key": "idRichiesta", "value": "Id Richiesta", "type": "text"},
                {"key": "idNotifica", "value": "Id Notifica", "type": "text"},
                {"key": "esito.descrizione", "value": "Esito", "type": "text"}
            ];
            
            $scope.modalOptionsTabellaSelectOlo = {
                    headerText: 'Seleziona un Olo',
                    actionButtonText: null,
                    closeButtonText: 'Ok',
                    contentType: 'modale_nowtable',
                    scope: $scope,
                    callbackFunction: 'selezionaOloCallback',
                    dataHeader: $scope.headersListaOlo,
                    templateUrl: 'app/common/templates.html'
                };
            
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
                    $scope.modalOptionsTabellaSelectOlo.data=$scope.listaOlo;
                }
            };

            var errorCallback = function () {
                modalService.alertSearchError();
            };

            GeneraNotificheTemplate.get().$promise.then(successCallback, errorCallback);

        };

        
        $scope.selezionaOloCallback = function (item) {
        	$scope.oloSelezionato=item;
        	if($scope.dataRichiestaOlo){
        		 $scope.selectOlo($scope.oloSelezionato,$scope.dataRichiestaOlo);
        	}
        };
        
        $scope.selezionataOlo = function ($event) {
            $event.preventDefault();
            modalService.showModal({}, $scope.modalOptionsTabellaSelectOlo);
        };
        
        $scope.openDP = function () {
            $scope.popup_dp.opened = true;
        };
        
        $scope.selectDateOlo = function (date) {
        	$scope.dataRichiestaOlo=date;
            if($scope.oloSelezionato){
       		 $scope.selectOlo($scope.oloSelezionato,$scope.dataRichiestaOlo);
            }
        };
        $scope.popup_dp = {
                opened: false
            };
        
        $scope.selectOlo = function (item,date) {
            $location.hash('');
                    	
        	//RU_1010
            //Tracking da GUI per operazione RICERCA AVANZATA
            
            var _params = {
                    codOloAgcom: item.codificaOlo,
                    codOloNow: item.codiceOlo,
                    dataCreazione:$filter('date')(date, 'dd/MM/yyyy')
                };
            
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			descrizioneFunzione: 'Monitoraggio|Generazione Notifiche da Template',
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
	    			parametriOperazione: JSON.stringify(_params) 			
            };
            
            
            var successCallback = function (data) {
            	
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
                $scope.showResourcesTable = true;
                $scope.richiesteLoading = true;
                $location.hash('richiesteOLO');
                $anchorScroll();
            };

            var errorCallback = function () {
                modalService.alertSearchError();
                $scope.richiesteLoading = true;
                
                _trackBean.timestampFine = new Date().toISOString();
                _trackBean.esito = 'Ko';                        
                TrackingGUI.tracking(_trackBean);
            };
            $scope.richiesteLoading = false;
            $scope.showResourcesTable = false;
            $scope.codoloFinale = {};
            $scope.codoloFinale.codiceOloAgcom = item.codificaOlo;
            $scope.codoloFinale.codiceOloNow = item.codiceOlo;
            RichiesteForOLONotificheTemplate.get({
                codOloAgcom: item.codificaOlo,
                codOloNow: item.codiceOlo,
                dataCreazione:$filter('date')(date, 'dd/MM/yyyy')
            }).$promise.then(successCallback, errorCallback);

        };


        $scope.rigeneraNotificheSelezionate = function () {
            $scope.invioNotificheSending = true;
            
            //Tracking da GUI per operazione INSERIMENTO
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Monitoraggio|Generazione Notifiche da Template',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
            };
            
            if ($scope.detailArgNotificheAttese.length) {
                var successCallback = function (response) {

                    $log.info(response);

                    $scope.arrayflagdetailArgNotificheAttese = [];

                    for (var index = 0; index < $scope.detailArgNotificheAttese.length; index++) {
                        var item = [];
                        item.push({
                            flagDestinazioneDonating: $scope.detailArgNotificheAttese[index].flagDestinazioneDonating,
                            flagDestinazioneDonor: $scope.detailArgNotificheAttese[index].flagDestinazioneDonor,
                            flagDestinazioneRecipient: $scope.detailArgNotificheAttese[index].flagDestinazioneRecipient
                        });
                        $scope.arrayflagdetailArgNotificheAttese[index] = item;
                    }

                    $scope.flagdetailArgNotificheAttese = false;
                    for (var indice = 0; indice < $scope.arrayflagdetailArgNotificheAttese.length; indice++) {
                        if (!$scope.arrayflagdetailArgNotificheAttese[indice][0].flagDestinazioneDonating && !$scope.arrayflagdetailArgNotificheAttese[indice][0].flagDestinazioneDonor && !$scope.arrayflagdetailArgNotificheAttese[indice][0].flagDestinazioneRecipient)
                            $scope.flagdetailArgNotificheAttese = true;
                    }

                    if ($scope.flagdetailArgNotificheAttese) {
                        modalService.showModal({}, {
                            headerText: "Seleziona destinatario notifiche",
                            bodyText: "Devi selezionare almeno un destinatario per ciascuna notifica.",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                        $scope.invioNotificheSending = false;
                    }
                    else {

                        $scope.invioNotificheSending = false;

                        for (var ind = 0; ind < response.data.length; ind++) {
                            response.data[ind].est = response.data[ind].esito.descrizione;
                            delete response.data[ind].esito;
                        }

                        $scope.headersModale = {
                            "idRichiesta": "Id Richiesta",
                            "est": "Esito",
                            "idNotifica": "Id Notifica"
                        };

                        modalService.showModal({}, {
                            headerText: "Rinvio File",
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
                    }
                };

                var errorCallback = function () {
                    $scope.invioNotificheSending = false;
                    
                    modalService.showModal({}, {
                        headerText: "Rigenerazione notifiche",
                        bodyText: "Non e' stato possibile rigenerare le notifiche selezionate. Prova piu' tardi.",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                    $scope.NotificheAtteseLoaded = true;
                    
                    _trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ko';
                    TrackingGUI.tracking(_trackBean);
                };

                GeneraNotificheTemplate.rinvia({
                    listaRichieste: $scope.detailArgNotificheAttese,
                    codOlo: $scope.codoloFinale
                }, successCallback, errorCallback);
            } else {
                modalService.showModal({}, {
                    headerText: "Rigenerazione notifiche",
                    bodyText: "Selezionare almeno una notifica.",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
                $scope.NotificheAtteseLoaded = true;
            }
        };

        $scope.getNotificheAttese = function () {
            var richiesteSelezionate = [];
            $scope.showNotificheAtteseTable = true;
            $scope.NotificheAtteseLoaded = false;
            for (var index = 0; index < $scope.detailArgRichieste.length; index++) {
                if ($scope.detailArgRichieste[index].idRichiestaOlo) {
                    var item = $scope.detailArgRichieste[index];
                    richiesteSelezionate.push({
                        idRichiestaOlo: item.idRichiestaOlo,
                        idOfferta: item.idOfferta,
                        idStatoNowDa: item.idStatoNow
                    });
                }
            }
            if (richiesteSelezionate.length) {
                $location.hash('');
                var successCallback = function (response) {
                    $scope.NotificheAtteseLoaded = true;
                    $scope.listaNotificheAttese = response.data;
                    $location.hash('notificheOLO');
                    $anchorScroll();
                };

                var errorCallback = function () {
                    $scope.showNotificheAtteseTable = false;
                    $scope.NotificheAtteseLoaded = true;
                    modalService.showModal({}, {
                        headerText: "Tipologie notifiche attese",
                        bodyText: "Non e' stato possibile caricare l'elenco delle tipologie notifiche attese. Prova piu' tardi.",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                };

                ListaTipologieNotificheAttese.rigenera(richiesteSelezionate).$promise.then(successCallback, errorCallback);

            } else {
                modalService.showModal({}, {
                    headerText: "Tipologie notifiche attese",
                    bodyText: "E' necessario selezionare almeno una richiesta.",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
            }
        };

        $scope.init();
    }]);
timnow
    .controller('rinvioEmailController', ['$scope', '$rootScope', '$log', 'modalService', 'RinvioEmail', 'AdvancedSearchGetDati', 'TRACKING_GUI', 'TrackingGUI',
    	function ($scope, $rootScope, $log, modalService, RinvioEmail, AdvancedSearchGetDati, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'rinvioEmail';

        $scope.init = function () {
            //solo singola lista
            $scope.listEmail = [];
            $scope.listLoaded = true;
            $scope.showTable = false;
            $scope.tipologia = 'Email';
            $scope.tipologiaRicerca = 'Rinvio Email';

            $scope.detailArg = [];
            $scope.dataContainer = [];
            $scope.paramToSearch = [];
            $scope.headerList = [
                {"key": "contenutoMail", "value": "Contenuto Mail", "type": "text"},
                {"key": "destinatarioEmailA", "value": "Destinatario Email A", "type": "text"},
                {"key": "destinatarioEmailCC", "value": "Destinatario Email CC", "type": "text"},
                {"key": "tipologiaNotifica", "value": "Tipologia Notifica", "type": "text"},
                {"key": "oggetto", "value": "Oggetto della Mail", "type": "text"},
                {"key": "dataInvio", "value": "Data Invio", "type": "text"},
                {"key": "idNotifica", "value": "Seleziona", "type": "selectable"}
            ];
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
    	    			descrizioneFunzione: 'Monitoraggio|Rinvio Mail',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };
            	
                $scope.listLoaded = false;
                var mails = AdvancedSearchGetDati.save({type: 'monitoraggio-rinvio-email'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });

                var successCallback = function (data) {
                	
                	_trackBean.timestampFine = new Date().toISOString();
                	
                    if (data.result.code < 0) {
                        modalService.alertSearchError();
                        
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                        
                        return false;
                    }
                    if (data.data) {
                        $scope.listEmail = data.data;
                        
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

                mails.$promise.then(successCallback, errorCallback);
            } else {
                modalService.showModal({}, {
                    headerText: "Rinvio Email",
                    bodyText: "E' necessario aggiungere almeno un filtro nella ricerca per visualizzare le Email.",
                    actionButtonText: 'Chiudi'
                });
            }
        };

        $scope.rinviaEmail = function () {
            var mails = [];
            $scope.showSpinner = true;
            for (var index = 0; index < $scope.detailArg.length; index++) {
                var element = $scope.detailArg[index];

                if (element.idNotifica) {
                    mails[index] = {
                        idNotifica: element.idNotifica,
                        timestampInvio: element.dataInvio
                    };
                }
            }

            if (mails.length) {
                var successCallback = function (response) {
                    if (response.result.code < 0 || !response.data || !response.data.length) {
                        $rootScope.alertGenericError();
                        $scope.showSpinner = false;
                        return false;
                    }

                    // Senza parole...
                    var esito = response.data[0];

                    if (esito.codice === 'KO') {
                        modalService.showModal({}, {
                            headerText: "Rinvio Email",
                            bodyText: esito.descrizione,
                            actionButtonText: 'Chiudi'
                        });
                        $scope.showSpinner = false;
                        return false;
                    }

                    modalService.showModal({}, {
                        headerText: "Rinvio Email",
                        bodyText: "Le email selezionate sono state rinviate con successo.",
                        actionButtonText: 'Chiudi'
                    });
                    $scope.getSearchAdvanced();
                    $scope.showSpinner = false;
                    $scope.listLoaded = true;
                };

                var errorCallback = function (error) {
                    modalService.showModal({}, {
                        headerText: "Rinvio Email",
                        bodyText: "Non e' stato possibile effettuare l'invio email. Prova piu' tardi.",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                    $scope.showSpinner = false;
                    $scope.listLoaded = true;
                };
                RinvioEmail.rinvia({listaEmail: mails}, successCallback, errorCallback);
            }
        };

        $scope.init();
    }]);
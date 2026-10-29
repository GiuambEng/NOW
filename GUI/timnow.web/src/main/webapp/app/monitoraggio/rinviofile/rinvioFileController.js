timnow
    .controller('rinvioFileController', ['$scope', '$rootScope', '$log', 'modalService', 'RinvioFile', 'AdvancedSearchGetDati', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $rootScope, $log, modalService, RinvioFile, AdvancedSearchGetDati, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'rinvioFile';

        $scope.init = function () {
            //solo singola lista
            $scope.listFile = [];
            $scope.listLoaded = true;
            $scope.showTable = false;
            $scope.tipologia = 'File';
            $scope.tipologiaRicerca = 'Rinvio File';

            $scope.detailArg = [];
            $scope.dataContainer = [];
            $scope.paramToSearch = [];
            $scope.headerList = [
                {"key": "delete", "value": "Seleziona", "type": "selectable"},
                {"key": "codiceOloNumerico", "value": "Codice OLO Numerico", "type": "text"},
                {"key": "codificaOloAgcom", "value": "Codifica OLO AGCOM", "type": "text"},
                {"key": "dataFile", "value": "Data File", "type": "text"},
                {"key": "descrizioneStatoFile", "value": "Descrizione Stato File", "type": "text"},
                {"key": "esito", "value": "Esito", "type": "text"},
                {"key": "idFile", "value": "Identificativo File", "type": "text"},
                {"key": "tipologiaFile", "value": "Tipologia File", "type": "text"},
                {"key": "versoFile", "value": "Verso del File", "type": "text"},
                {"key": "nomeFile", "value": "Nome File", "type": "text"},
                {"key": "esitoInvio", "value": "Esito Invio", "type": "text"},
                {"key": "timestampCreazioneFile", "value": "Timestamp Creazione File", "type": "text"},
                {"key": "timestampInvio", "value": "Timestamp Invio", "type": "text"}
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
    	    			descrizioneFunzione: 'Monitoraggio|Rinvio File',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };
            	
                $scope.listLoaded = false;
                var files = AdvancedSearchGetDati.save({type: 'monitoraggio-rinvio-file'}, {
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
                        $scope.listFile = data.data;
                        
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

                files.$promise.then(successCallback, errorCallback);
            } else {
                modalService.showModal({}, {
                    headerText: "Rinvio File",
                    bodyText: "E' necessario aggiungere almeno un filtro nella ricerca per visualizzare i file.",
                    actionButtonText: 'Chiudi'
                });
            }
        };

        $scope.rinviaFile = function () {
            var files = [];
            for (var index = 0; index < $scope.detailArg.length; index++) {
                files[index] = $scope.detailArg[index].idFile;
            }

            if (files.length) {
                $scope.showSpinner = true;
                var successCallback = function (response) {
                    modalService.showModal({}, {
                        headerText: "Rinvio File",
                        bodyText: "I file selezionati sono stati rinviati con successo.",
                        actionButtonText: 'Chiudi'
                    });
                    $scope.getSearchAdvanced();
                    $scope.showSpinner = false;
                    $scope.listLoaded = true;
                };

                var errorCallback = function (error) {
                    modalService.showModal({}, {
                        headerText: "Rinvio File",
                        bodyText: "Non e' stato possibile effettuare l'invio dei file. Prova piu' tardi.",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                    $scope.showSpinner = false;
                    $scope.listLoaded = true;

                };
                RinvioFile.rinvia({ids: files}, successCallback, errorCallback);
            }
        };

        $scope.init();
    }]);
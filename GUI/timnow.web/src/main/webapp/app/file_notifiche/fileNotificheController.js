timnow
    .controller('fileNotifiche', ['$scope', '$state', '$rootScope', '$log', 'Notifications','AdvancedSearchGetDati','modalService', 'ExportId', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $state, $rootScope, $log, Notifications,AdvancedSearchGetDati,modalService,ExportId,TRACKING_GUI,TrackingGUI) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        $log.info('file Notifiche page');

        //solo singola lista
        $scope.files = [];
        $scope.filesLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "nomeFile", "value": "Nome File", "type": "text"});
        $scope.headerList.push({
            "key": "dimensioneFile",
            "value": "Dimensione (Byte)",
            "type": "text",
            "sort": "number"
        });
        $scope.headerList.push({"key": "tipoNotifica", "value": "Tipo Notifica", "type": "text"});
        $scope.headerList.push({"key": "codOloAgcom", "value": "Codifica OAO", "type": "text"});
        $scope.headerList.push({"key": "esitoInvio", "value": "Esito Invio", "type": "text"});
        $scope.headerList.push({
            "key": "timestampInvio",
            "value": "Data Invio",
            "type": "data",
            "pattern": "dd/MM/yyyy HH:mm:ss"
        });
        $scope.headerList.push({"key": "idFile", "value": "", "type": "file"});
        $scope.errorMessage = "File e Notifiche";

        $scope.detailList = [];
        $scope.detailList.push({"key": "quantitaRecordTotali", "value": "Record TOT", "type": "text"});
        $scope.detailList.push({"key": "timestampCreazioneFile", "value": "Data Creazione", "type": "text"});
        
        function init() {
            var file = Notifications.get();
            return file.$promise.then(
                function (data) {
                    if (data.data) $scope.files = data.data;
                    $scope.filesLoaded = true;
//     		 $log.debug(data.data)
                }, function (error) {
                    $scope.filesLoaded = true;
                });
        }
        
        
        /* RICERCA AVANZATA START */
        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }

        $scope.tipologiaRicerca = 'FILE DI NOTIFICHE';

        $scope.getSearchAdvanced = function () {
            $scope.filesLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione INSERIMENTO
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'File e Notifiche|File di Notifiche',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                var files = AdvancedSearchGetDati.save({type: 'notifications'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                files.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data){
                        	$scope.files = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.filesLoaded = true;
                    }, function (error) {
                        modalService.alertSearchError();
                        $scope.filesLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
                init();
            }
        };
        /* RICERCA AVANZATA END */
        

        $scope.iniziaExport = function () {
            var bodyData = {
                "idRichiesta": [],
                "tipoprofilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "numerorighe": "",
                "indiceriga": "",
                "exportRequest": true,
                "conditions": $scope.paramToSearch
            };
            
          //RU_902
            $rootScope.numeroDatiEsportati = $scope.files.length;
            
            return ExportId.save({entita: 'notifications', selectedOLO: $scope.selectedOLO}, bodyData).$promise;
        };

        
        init();
    }]);
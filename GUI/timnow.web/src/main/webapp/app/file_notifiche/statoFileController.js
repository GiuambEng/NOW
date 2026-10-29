timnow
    .controller('statoFile', ['$scope', '$rootScope', '$state', 'FileState', 'IDsrolo', '$log', 'modalService', 'ExportId','AdvancedSearchGetDati','CRM_RISOTTOMISSIONE_PROFILE','TRACKING_GUI','TrackingGUI', 
    		function ($scope, $rootScope, $state, FileState, IDsrolo, $log, modalService, ExportId, AdvancedSearchGetDati, CRM_RISOTTOMISSIONE_PROFILE, TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        var userProfile = $rootScope.timnowConfigData.user.codiceProfilo;

        $scope.tastiAbilitati = CRM_RISOTTOMISSIONE_PROFILE.hasOwnProperty(userProfile);

        $scope.loadOLOsForNonOLOUsers = function () {
            $scope.isOLOUser = $rootScope.timnowConfigData.user.codiceProfilo.indexOf('OLO') >= 0;
            $scope.selectedOLO = null;

            if (!$scope.isOLOUser) {
                $log.debug('User has not OLO profile...');
                $scope.statoLoaded = true;
                $scope.olosLoading = true;
                IDsrolo.get({noDiffida: false}).$promise.then(
                    function (response) {
                        $scope.olosLoading = false;
                        $scope.olos = response.data;
                    },
                    function () {
                        $scope.olosLoading = false;
                        modalService.showModal({}, {
                            headerText: "Avviso",
                            closeButtonText: 'Chiudi',
                            bodyText: "Errore durante il caricamento degli OAO. Riprovare più tardi",
                            scope: $scope,
                            type: 'error'
                        });
                    }
                );
            } else {
                $log.debug('User has OLO profile...');
                $scope.loadStatoFile();
            }
        };

        $scope.loadStatoFile = function () {
            $scope.stato = [];
            $scope.statoLoaded = false;
            var params = {};
            if ($scope.selectedOLO) {
                params.selectedOLO = $scope.selectedOLO;
            }
            FileState.get(params).$promise.then(
                function (data) {
                    if (data) {
                        $scope.stato = data.data;
                    }
                    $scope.statoLoaded = true;
                },
                function (error) {
	                $log.error(error);
	                $scope.statoLoaded = true;
	                modalService.showModal({}, {
	                        headerText: "Avviso",
	                        closeButtonText: 'Chiudi',
	                        bodyText: "Errore durante il caricamento Stato File. Riprovare più tardi",
	                        scope: $scope,
	                        type: 'error'
	                    });	
	           });
        };

        $scope.iniziaExport = function () {
            var bodyData = {
                "idRichiesta": [],
                "tipoprofilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "numerorighe": "",
                "indiceriga": "",
                "exportRequest": true,
                "conditions" : $scope.paramToSearch
            };
            
            //RU_902
            $rootScope.numeroDatiEsportati = $scope.stato.length;
            
            return ExportId.save({entita: 'filestate', selectedOLO: $scope.selectedOLO}, bodyData).$promise;
        };

        $scope.init = function () {
            $rootScope.pageClass = 'file_notifiche';
            $log.info('stato file controller');

            $scope.stato = [];
            $scope.statoLoaded = false;
            $scope.headerList = [];
            $scope.detailList = [];

            $scope.headerList.push({"key": "color", "value": "Semaforo", "type": "semaforo"},
                    {"key": "filename", "value": "Nome File", "type": "text"},
                    {"key": "arrivalDate", "value": "Data Arrivo", "type": "data", "pattern": "dd/MM/yyyy"},
                    {"key": "acquisitionStateDescription", "value": "Stato acquisizione", "type": "text"},
                    {"key": "totalRecordNumber", "value": "Tot Ric Ricevute", "type": "text"},
                    {"key": "nowRecordNumber", "value": "Tot Ric NOW", "type": "text"},
                    {"key": "okRecordNumber", "value": "Tot Ord Acquisiti NOW", "type": "text"},
                    {"key": "koRecordNumber", "value": "Tot Ord non Acquisiti NOW", "type": "text"},
                    {"key": "idRejectReason", "value": "Causale Scarto", "type": "text"},
                    {"key": "idFile", "value": "", "type": "file"});

                $scope.detailList.push({"key": "interfaceId", "value": "Interfaccia", "type": "text"},
                    {"key": "filesize", "value": "Dimensione (Byte)", "type": "text"},
                    {"key": "type", "value": "Tipologia file", "type": "text"},
                    {"key": "agcomOloCode", "value": "OAO", "type": "text"},
                    {"key": "fileOpening", "value": "Data Inizio Elaborazione", "type": "text"},
                    {"key": "fileClosing", "value": "Data Fine Elaborazione", "type": "text"},
                    {"key": "datafile", "value": "Data File", "type": "text"},
                    {"key": "arrivalDate", "value": "Data Arrivo", "type": "text"},
                    {"key": "totRichiesteFuoriAmbito","value":"Tot Richieste Fuori Ambito","type":"text"},
                    {"key": "outcome", "value": "Esito", "type": "text"});

                if($scope.tastiAbilitati){
                    $scope.detailList.push({"key": "flagRisottomissione", "value": "", "type": "customButton"});
                }
            $scope.loadOLOsForNonOLOUsers();
        };

        $scope.getSubmit = function (item) {
        	$scope.statoLoaded = false;
        	item.flagRisottomissione=false;
        	FileState.get({idFile:item.idFile}).$promise.then(
                    function (response) {
                    	 $scope.statoLoaded = true;
                    	 modalService.showModal({}, {
                    		 headerText: "Risottomissione File",
                             bodyText: response.descrizione,//"Il file è stato risottomesso con successo.",
                             actionButtonText: 'Chiudi'
 	                    });	
                    },
                    function (error) {
    	                $log.error(error);
    	                item.flagRisottomissione=true;
    	                $scope.statoLoaded = true;
    	                modalService.showModal({}, {
    	                        headerText: "Avviso",
    	                        closeButtonText: 'Chiudi',
    	                        bodyText: "Errore durante La Risottomissione del File. Riprovare più tardi",
    	                        scope: $scope,
    	                        type: 'error'
    	                    });	
    	           });
        };
        
        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }
        
        $scope.tipologiaRicerca = 'semaforo';
        
        $scope.getSearchAdvanced = function () {
            $scope.statoLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'File e Notifiche|Stato File Ordini e Richieste',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };
            	
                $rootScope.RicercaAdvListaStato = $scope.paramToSearch;
                var stato = AdvancedSearchGetDati.save({type: 'filestate',selectedOLO:$scope.selectedOLO}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                stato.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data) {
                        	$scope.stato = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.statoLoaded = true;
                    }, function (error) {
                        modalService.alertSearchError();
                        $scope.statoLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
            	delete $rootScope.RicercaAdvListaStato;
            	 $scope.init();
            }
        };

        if ($rootScope.RicercaAdvListaStato) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaStato;
            $scope.getSearchAdvanced();
        } else {
        	 $scope.init();
        }
    }]);
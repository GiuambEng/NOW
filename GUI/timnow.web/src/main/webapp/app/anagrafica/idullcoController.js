timnow
    .controller('listaIdullco', ['alertService', '$scope', '$state', '$rootScope', '$log', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'CRM_PROFILE', 'TRACKING_GUI', 'TrackingGUI', 
    	function (alertService, $scope, $state, $rootScope, $log, AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, CRM_PROFILE, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = $state.current.params.pageClass;
        //$scope.exporting = false;
        $scope.enableRicercaIdullco=true;

        if ($rootScope.formData) {
            delete $rootScope.formData;
        }

        if ($rootScope.dacValidatoAsset) {
            delete $rootScope.dacValidatoAsset;
        }

        
        //solo singola lista
        $scope.idullco = [];
        $scope.idullcoLoaded = false;
        $scope.headerList = [
            {"key": "idullco", "value": "IDULLCO", "type": "text"},
            {"key": "clli", "value": "CLLI", "type": "text"},
            {"key": "codiceGAT", "value": "Codice GAT", "type": "text"},
            {"key": "codificaOAO", "value": "Codifica OAO", "type": "text"},
            {"key": "drcp", "value": "DRCP", "type": "text"},
            {"key": "centrale", "value": "Centrale", "type": "text"}];
        $scope.tipologia = $state.params.tipologia;

        function init() {
            alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare gli Idullco di interesse.","danger",10000);
            $scope.idullcoLoaded = true;
            $scope.errorDate = true;

        }

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }

        $scope.tipologiaRicerca = 'IDULLCO';

        $scope.getSearchAdvanced = function () {
            $scope.idullcoLoaded = false;
            $scope.enableRicercaIdullco=false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Anagrafiche|IDULLCO',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                $rootScope.RicercaAdvListaIdullco = $scope.paramToSearch;
                var idullco = AdvancedSearchGetDati.save({type: 'anagraficaIdullco'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                idullco.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data) {
                        	$scope.idullco = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.idullcoLoaded = true;
                    }, function (error) {
                        modalService.alertSearchError();
                        $scope.idullcoLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
                delete $rootScope.RicercaAdvListaIdullco;
                init();
            }
        };

        if ($rootScope.RicercaAdvListaIdullco) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaIdullco;
            $scope.getSearchAdvanced();
        } else {
            init();
        }

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

            return ExportId.save({entita: 'assets'}, bodyData).$promise;

        };
    }]);
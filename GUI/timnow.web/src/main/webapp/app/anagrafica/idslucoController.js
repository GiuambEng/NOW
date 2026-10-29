timnow
    .controller('listaIdsluco', ['alertService', '$scope', '$state', '$rootScope',  '$log', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'CRM_PROFILE', 'TRACKING_GUI', 'TrackingGUI', 
    	function (alertService, $scope, $state, $rootScope, $log, AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, CRM_PROFILE, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = $state.current.params.pageClass;
        //$scope.exporting = false;
        $scope.enableRicercaIdsluco=true;

        if ($rootScope.formData) {
            delete $rootScope.formData;
        }

        if ($rootScope.dacValidatoAsset) {
            delete $rootScope.dacValidatoAsset;
        }

        //solo singola lista
        $scope.idsluco = [];
        $scope.IdslucoLoaded = false;
        $scope.headerList = [
            {"key": "idsluco", "value": "IDSLUCO", "type": "text"},
            {"key": "clli", "value": "CLLI", "type": "text"},
            {"key": "da", "value": "Da", "type": "text"},
            {"key": "a", "value": "A", "type": "text"},
            {"key": "codificaOAO", "value": "Codifica OAO", "type": "text"}];
        $scope.tipologia = $state.params.tipologia;

        function init() {
            alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare gli Idsluco di interesse.","danger",10000);
            $scope.IdslucoLoaded = true;
            $scope.errorDate = true;

        }

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }

        $scope.tipologiaRicerca = 'IDSLUCO';

        $scope.getSearchAdvanced = function () {
            $scope.IdslucoLoaded = false;
            $scope.enableRicercaIdsluco=false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Anagrafiche|IDSLUCO',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                $rootScope.RicercaAdvListaIdsluco = $scope.paramToSearch;
                var idsluco = AdvancedSearchGetDati.save({type: 'anagraficaIdsluco'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                idsluco.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data) {
                        	$scope.idsluco = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.IdslucoLoaded = true;
                    }, function () {
                        modalService.alertSearchError();
                        $scope.IdslucoLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
                delete $rootScope.RicercaAdvListaIdsluco;
                init();
            }
        };

        if ($rootScope.RicercaAdvListaIdsluco) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaIdsluco;
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
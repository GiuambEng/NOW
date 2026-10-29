timnow
    .controller('cliente', ['$scope', '$state', '$rootScope', 'Customers', '$log', '$filter', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $state, $rootScope, Customers, $log, $filter, AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, TRACKING_GUI, TrackingGUI) {
        $log.debug("cliente page");
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        $scope.clienti = [];
        $scope.clientiLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "nome", "value": "OAO", "type": "text"});
        $scope.headerList.push({"key": "ragioneSociale", "value": "Ragione Sociale", "type": "text"});
        $scope.headerList.push({"key": "codiceOlo", "value": "Codice OAO", "type": "text"});
        $scope.headerList.push({"key": "codificaAgcom", "value": "Codifica OAO", "type": "text"});
        $scope.headerList.push({"key": "codificaOloRete", "value": "Codifica OAO Rete", "type": "text"});
        $scope.headerList.push({"key": "flagOloAccorpante", "value": "Accorpante", "type": "checkbox"});

        if (($state.params.init === true) && $rootScope.RicercaAdvListaClienti) {
            delete $rootScope.RicercaAdvListaClienti;
        }

        function init() {
            var cliente = Customers.get();
            cliente.$promise.then(
                function (data) {
                    if (data.data) $scope.clienti = data.data;
                    $scope.clientiLoaded = true;
                    //$log.info($scope.clienti.length);
                }, function (error) {
                    $scope.clientiLoaded = true;
                });
        }

        $scope.getDettaglioCliente = function (item) {
            if (item.flagOloAccorpante) {
                $scope.filterClienti = $filter('filter')($scope.clienti, {nomeAccorpante: item.codificaAgcom});
            } else {
                $scope.filterClienti = [];
            }
            $state.go('root.anagrafica.cliente.dettaglio', {
                cliente: item,
                clientiFiltered: $scope.filterClienti,
                parametriRicerca: $scope.paramToSearch
            });
        };

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }

        $scope.tipologiaRicerca = 'Cliente';

        $scope.getSearchAdvanced = function () {
            $scope.clientiLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Anagrafiche|Cliente',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };
            	
                $rootScope.RicercaAdvListaClienti = $scope.paramToSearch;
                var cliente = AdvancedSearchGetDati.save({type: 'customers'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                cliente.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data) {
                        	$scope.clienti = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.clientiLoaded = true;
                    }, function (error) {
                        modalService.alertSearchError();
                        $scope.clientiLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
            	delete $rootScope.RicercaAdvListaClienti;
                init();
            }
        };

        if ($rootScope.RicercaAdvListaClienti) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaClienti;
            $scope.getSearchAdvanced();
        } else {
            init();
        }

        $scope.iniziaExport = function () {
            var bodyData = {
                "idRichiesta": [],
                "tipoprofilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "numerorighe": $scope.clienti.length,
                "indiceriga": "",
                "exportRequest": true,
                "conditions": $scope.paramToSearch
            };
            
            //RU_902
            $rootScope.numeroDatiEsportati = $scope.clienti.length;
            
            return ExportId.save({entita: 'customers'}, bodyData).$promise;
        };
    }]);
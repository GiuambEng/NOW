timnow
    .controller('radius', ['$scope', '$state', '$rootScope', 'Radius', '$log', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $state, $rootScope, Radius, $log,  AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        //solo singola lista
        $scope.radiusList = [];
        $scope.radiusLoaded = false;
        $scope.headerList = [];
        // --------------------------------------------------------------------------------------------------
		$scope.headerList.push({"key": "codiceISP", "value": "Codice ISP", "type": "text"});
        $scope.headerList.push({"key": "ordineOneStep", "value": "Ordine One Step", "type": "text"});
        $scope.headerList.push({"key": "lavorazione", "value": "Lavorazione", "type": "text"});
        $scope.headerList.push({"key": "tecnologia", "value": "Tecnologia", "type": "text"});
        $scope.headerList.push({"key": "gestioneRadius", "value": "Gestione Radius", "type": "text"});
        $scope.headerList.push({"key": "fornitoreRadius", "value": "Fornitore Radius", "type": "text"});
        $scope.headerList.push({"key": "ownership", "value": "Ownership", "type": "text"});
        $scope.headerList.push({"key": "sopensioneOrdine", "value": "Prevista sosp. per RADIUS", "type": "text"});
        if(!$rootScope.OSCURAMENTI.RU_1614.oscurato) {
			$scope.headerList.push({"key": "dnsParentalControl", "value": "DNS Parental Control", "type": "text"});
			$scope.headerList.push({"key": "realm", "value": "Realm", "type": "text"});
			$scope.headerList.push({"key": "piattaformaO2O", "value": "Piattaforma O2O", "type": "text"});
		}
        $scope.headerList.push({"key": "cluster", "value": "Cluster", "type": "text"});
        $scope.headerList.push({"key": "descrizioneCluster", "value": "Descrizione Cluster", "type": "text"});
        
        
        var bodyData = {
                "idRichiesta": [],
                "tipoprofilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "numerorighe": "",
                "indiceriga": "",
                "exportRequest": true,
                "conditions": $scope.paramToSearch
            };

        if (($state.params.init === true) && $rootScope.RicercaAdvListaRadius) {
            delete $rootScope.RicercaAdvListaRadius;
        }
        
        function init() {
			bodyData.exportRequest = false;
			
            ExportId.save({entita: 'radius'}, bodyData)
        		.$promise
        		.then(
	                function (data) {
	                    if (data.listaAnagraficaRadius) {
							$scope.radiusList = data.listaAnagraficaRadius;
						}
	                    if (!$scope.radiusList) {
	                        $scope.errorDate = true;
	                    }
	                    $scope.radiusLoaded = true;
	                }, function (error) {
	                    $scope.radiusLoaded = true;
                	}
                );
        }

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }
        $scope.tipologiaRicerca = 'Radius';

        $scope.getSearchAdvanced = function () {
            $scope.radiusLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Anagrafiche|Radius',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                $rootScope.RicercaAdvListaRadius = $scope.paramToSearch;

                var radius = AdvancedSearchGetDati.save({type: 'radius'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                radius.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data) {
                        	$scope.radiusList = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.radiusLoaded = true;
                    }, function (error) {
                        modalService.alertSearchError();
                        $scope.radiusLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
            	delete $rootScope.RicercaAdvListaRadius;
                init();
            }
        };

        if ($rootScope.RicercaAdvListaRadius) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaRadius;
            $scope.getSearchAdvanced();
        } else {
            init();
        }
        
        $scope.iniziaExport = function () {
             bodyData.exportRequest = true;
            
          	//RU_902
            $rootScope.numeroDatiEsportati = $scope.radiusList.length;
            
            return ExportId.save({entita: 'radius'}, bodyData).$promise;
        };

    }]);
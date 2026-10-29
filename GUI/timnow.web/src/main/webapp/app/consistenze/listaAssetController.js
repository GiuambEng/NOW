timnow
    .controller('listaAsset', ['alertService', '$scope', '$state', '$rootScope', 'Assets', '$log', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'CRM_PROFILE', 'TRACKING_GUI', 'TrackingGUI', 
    	function (alertService, $scope, $state, $rootScope, Assets, $log, AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, CRM_PROFILE, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = $state.current.params.pageClass;
        //$scope.exporting = false;
        $scope.enableRicercaAsset=true;

        if ($rootScope.formData) {
            delete $rootScope.formData;
        }

        if ($rootScope.dacValidatoAsset) {
            delete $rootScope.dacValidatoAsset;
        }

        //solo singola lista
        $scope.assets = [];
        $scope.assetsLoaded = false;
        $scope.headerList = [
            {"key": "codiceOlo", "value": "Ordine OAO", "type": "text"},
            {"key": "codiceOrdineTI", "value": "Ordine TI", "type": "text"},
            {"key": "oao", "value": "Codifica OAO", "type": "text"},
            {"key": "idRisorsa", "value": "ID Risorsa", "type": "text", "classe": "pre"},
            {"key": "idRisorsaOperatoreRete", "value": "Identificativo Risorsa Operatore Rete", "type": "text", "classe": "pre"}, //RU_737
            {"key": "identificativoStatoAsset", "value": "Stato Asset", "type": "text"},
            {"key": "offerta", "value": "Offerta", "type": "text"}];
        $scope.tipologia = $state.params.tipologia;

		//SM_10344
        $scope.init = function() {
        	if($state.params.init){
        		$scope.paramToSearch = [];
        		$rootScope.RicercaAdvListaAsset = [];
        	}else{
        		if ($rootScope.RicercaAdvListaAsset) {
        			$scope.paramToSearch = $rootScope.RicercaAdvListaAsset;
        			$scope.getSearchAdvanced();
        		}
        	}

        	alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare gli Asset di interesse.","danger",10000);
        	$scope.assetsLoaded = true;
        	$scope.errorDate = true;
        }

        $scope.getDettaglioAsset = function (item) {
            $state.go('root.consistenze.asset.listaAccesso.dettaglio', {id: item.identificativoAsset, asset: item});
        };

        $scope.tipologiaRicerca = 'Lista Asset';

        $scope.getSearchAdvanced = function () {
            $scope.assetsLoaded = false;
            $scope.enableRicercaAsset=false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Asset|Lista Asset Accesso',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                $rootScope.RicercaAdvListaAsset = $scope.paramToSearch;
                var assets = AdvancedSearchGetDati.save({type: 'assets'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                assets.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data){
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                            $scope.assets = data.data;
                        }                         	
                        $scope.assetsLoaded = true;
                    }, function (error) {
                        modalService.alertSearchError();
                        $scope.assetsLoaded = true;
                        
                    	_trackBean.timestampFine = new Date().toISOString();
                    	_trackBean.esito = 'Ko';
                    	TrackingGUI.tracking(_trackBean);
                    });
            } else {
            	delete $rootScope.RicercaAdvListaAsset;
                init();
            }
        };

        $scope.iniziaExport = function () {
            $scope.exporting = true;
            
            //RU_902
            $rootScope.numeroDatiEsportati = $scope.assets.length;

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
        
        $scope.init();
        
    }]);
timnow
    .controller('listaAssetRaccolta', ['alertService', '$scope', '$state', '$rootScope', 'AssetsRaccolta', '$log', 'modalService', 'TRACKING_GUI', 'TrackingGUI', 'VLANUtils', '_', 
    	function (alertService, $scope, $state, $rootScope, AssetsRaccolta, $log, modalService, TRACKING_GUI, TrackingGUI, VLANUtils, _) {

        $rootScope.pageClass = $state.current.params.pageClass;
        $scope.enableRicercaAsset = true;

        $scope.assets = [];
        $scope.assetsLoaded = false;
        $scope.tipologia = $state.params.tipologia;
        $scope.tipologiaRicerca = 'Lista Asset Raccolta';
        
        $scope.headerList = [
            {"key": "codiceOrdineOao", "value": "Ordine OAO", "type": "text"},
            {"key": "codificaOAO", "value": "Codifica OAO", "type": "text"},
            {"key": "codiceTdKit", "value": "Codifica TDKit", "type": "text"},
            {"key": "offerta", "value": "Offerta", "type": "text"},
            {"key": "codiceOrdineTI", "value": "Ordine TI", "type": "text"},            
            {"key": "idRisorsa", "value": "ID Risorsa", "type": "text", "classe": "pre"},           
            {"key": "statoAsset", "value": "Stato Asset", "type": "text"}];

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
        	
         	 alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare gli Asset di interesse.","danger", 10000);
         	 $scope.assetsLoaded = true;
        }

        $scope.getDettaglioAsset = function (item) {
            $state.go('root.consistenze.asset.listaRaccolta.dettaglio', {idAsset: item.idAsset});
        };

        $scope.getSearchAdvanced = function () {
            $scope.assetsLoaded = false;
            $scope.enableRicercaAsset = false;
            
            if ($scope.paramToSearch.length > 0) {            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Asset|Lista Asset Raccolta',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                $rootScope.RicercaAdvListaAsset = $scope.paramToSearch;
                
                var _request = {
            		conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''	
                };
  
                AssetsRaccolta.search.save(_request).$promise	
                .then(function(response){
                	
                	 $scope.assetsLoaded = true;
                	 
                	_trackBean.timestampFine = new Date().toISOString();
                	
                    if (response.result.code.toUpperCase() == "KO") {
                        modalService.alertSearchError();
                        
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                        
                        return false;
                    }else{
                    	 $scope.assets = (response.ListaAssetRaccoltaOutput || []);
                    	 
                        _trackBean.esito = 'Ok';                        
                        TrackingGUI.tracking(_trackBean);
                    }                        	
                   
                }, function(error){
                	 $scope.assetsLoaded = true;
                    modalService.alertSearchError();                   
                    
                	_trackBean.timestampFine = new Date().toISOString();
                	_trackBean.esito = 'Ko';
                	TrackingGUI.tracking(_trackBean);
                });
            } else {
            	delete $rootScope.RicercaAdvListaAsset;
                $scope.init();
            }
        };

        $scope.iniziaExport = function () {
            $scope.exporting = true;
            
            $rootScope.numeroDatiEsportati = $scope.assets.length;

            var bodyData = {
                "idRichiesta": [],
                "tipoprofilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "numerorighe": "",
                "indiceriga": "",
                "exportRequest": true,
                "conditions": $scope.paramToSearch
            };
            return AssetsRaccolta.exportList.save(null, bodyData).$promise;
        };
        
        $scope.init();

    }]);
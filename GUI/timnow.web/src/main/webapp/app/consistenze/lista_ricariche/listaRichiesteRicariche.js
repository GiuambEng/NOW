timnow
    .controller('listaRichiesteRicariche', ['alertService', '$scope', '$state', '$rootScope',  '$log', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'CRM_PROFILE', 'TRACKING_GUI', 'TrackingGUI', 
    	function (alertService, $scope, $state, $rootScope, $log, AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, CRM_PROFILE, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = $state.current.params.pageClass;
        //$scope.exporting = false;
        $scope.enableRicercaRicariche=true;



        if ($rootScope.formData) {
            delete $rootScope.formData;
        }

        if ($rootScope.dacValidatoAsset) {
            delete $rootScope.dacValidatoAsset;
        }

        //solo singola lista
        $scope.listarichieste = [];
        $scope.RicaricaLoaded = false;
        $scope.headerList = [
            {"key": "codificaOAO", "value": "Codifica OAO", "type": "text"},
            {"key": "dataInvio", "value": "Data Invio", "type": "text"},
            {"key": "idRisorsa", "value": "ID Risorsa", "type": "text"},
            {"key": "tipologiaRichiesta", "value": "Tipologia Richiesta", "type": "text"},
            {"key": "tipologiaLavorazione", "value": "Tipologia Lavorazione", "type": "text"},
            {"key": "offerta", "value": "Offerta", "type": "text"},
            {"key": "statoOao", "value": "Stato", "type": "text"},
            {"key": "descrizioneCausale", "value": "Descrizione Causale", "type": "text"}
        ];


        $scope.tipologia = $state.params.tipologia;

        function init() {
            if(!$scope.typeRecharged){
                alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare le Richieste Ricariche di interesse.","danger",10000);
            }

            $scope.RicaricaLoaded = true;
            $scope.errorDate = true;

        }

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }

        //$scope.tipologiaRicerca = 'IDSLUCO';
        $scope.tipologiaRicerca = 'LISTA RICHIESTE RICARICA';

        $scope.getSearchAdvanced = function () {
            $scope.RicaricaLoaded = false;
            $scope.enableRicercaRicariche=false;

          if ($scope.ricaricaType && $scope.ricaricaType.idRisorsa) {

                $scope.paramToSearch[0] = {
                    "nome": "R.IDRISORSA",
                    "operazione": "=",
                    "valore": $scope.ricaricaType.idRisorsa,
                    "tipo": "STRING"
                };
            }

                if ($scope.paramToSearch.length > 0) {
                	
                	//RU_1010
                    //Tracking da GUI per operazione INSERIMENTO
                    var _trackBean = {
        	    			timestampInizio: new Date().toISOString(),
        	    			timestampFine: null,
        	    			numeroDatiEsportati: 0,
        	    			contenutoFile: null,
        	    			descrizioneFunzione: 'Asset|Lista Richieste Ricariche',
        	    			nomeFile: null,
        	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
        	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                    };

                $rootScope.RicercaAdvListaRicarica = $scope.paramToSearch;
                var listarichieste = AdvancedSearchGetDati.save({type: 'listaRichiesteAssets'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                listarichieste.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data) {
                        	$scope.listarichieste = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.RicaricaLoaded = true;
                    }, function () {
                        modalService.alertSearchError();
                        $scope.RicaricaLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
                delete $rootScope.RicercaAdvListaRicarica;
                init();
            }
        };

        if($state.params.getValue && $state.params.getOption){
            $scope.ricaricaType = $state.params.getValue;
            $scope.typeRecharged = $state.params.getValue.type;
            $scope.getSearchAdvanced();
        }


        if ($rootScope.RicercaAdvListaRicarica) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaRicarica;
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
            
          //RU_902
            $rootScope.numeroDatiEsportati = $scope.listarichieste.length;

            return ExportId.save({entita: 'listaRichiesteAssets'}, bodyData).$promise;

        };
        $scope.azzeraParams = function(){
            delete $rootScope.RicercaAdvListaRicarica;
            if($state.params.getValue){
                $state.params.getValue = null;
            }
        }
        $scope.changeState = function () {
            $scope.azzeraParams();
            $state.go('root.consistenze.listaricariche', {"ricaricaType": $scope.ricaricaType});
        }
    }]);
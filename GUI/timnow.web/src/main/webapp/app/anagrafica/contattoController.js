timnow
    .controller('contatto', ['$scope', '$state', '$rootScope', 'Contacts', '$log', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $state, $rootScope, Contacts, $log,  AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        //solo singola lista
        $scope.contacts = [];
        $scope.contactsLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "nome", "value": "Nome", "type": "text"});
        $scope.headerList.push({"key": "cognome", "value": "Cognome", "type": "text"});
        $scope.headerList.push({"key": "tipoReferente", "value": "Tipo referente", "type": "text"});
        $scope.headerList.push({"key": "metodoContatto", "value": "Metodo contatto", "type": "text"});

        if (($state.params.init === true) && $rootScope.RicercaAdvListaContatti) {
            delete $rootScope.RicercaAdvListaContatti;
        }

        function init() {
            var contatti = Contacts.get();
            contatti.$promise.then(
                function (data) {
                    if (data.data) $scope.contacts = data.data;
                    if (!$scope.contacts) {
                        $scope.errorDate = true;
                    }
                    $scope.contactsLoaded = true;
                }, function (error) {
                    $scope.contactsLoaded = true;
                });
        }

        $scope.getDettaglioContatti = function (item) {
            $state.go('root.anagrafica.contatto.dettaglio', {contatto: item, parametriRicerca: $scope.paramToSearch});
        };

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }
        $scope.tipologiaRicerca = 'Contatto';

        $scope.getSearchAdvanced = function () {
            $scope.contactsLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Anagrafiche|Contatto',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                $rootScope.RicercaAdvListaContatti = $scope.paramToSearch;

                var contatti = AdvancedSearchGetDati.save({type: 'contacts'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                contatti.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data) {
                        	$scope.contacts = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.contactsLoaded = true;
                    }, function (error) {
                        modalService.alertSearchError();
                        $scope.contactsLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
            	delete $rootScope.RicercaAdvListaContatti;
                init();
            }
        };

        if ($rootScope.RicercaAdvListaContatti) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaContatti;
            $scope.getSearchAdvanced();
        } else {
            init();
        }

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
            $rootScope.numeroDatiEsportati = $scope.contacts.length;
            
            return ExportId.save({entita: 'contacts'}, bodyData).$promise;
        };
    }]);
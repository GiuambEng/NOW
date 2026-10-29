timnow
    .controller('contratto', ['$scope', '$state', '$rootScope', 'ContractsAnagrafica', '$log', 'AdvancedSearch', 'AdvancedSearchGetDati', 'modalService', 'ExportId', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $state, $rootScope, ContractsAnagrafica, $log, AdvancedSearch, AdvancedSearchGetDati, modalService, ExportId, TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        $log.info('Pagina Contratti');

        $scope.contracts = [];
        $scope.contractsLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "nome", "value": "Nome Contratto", "type": "text"});
        $scope.headerList.push({"key": "codiceContratto", "value": "Codice Contratto", "type": "text"});
        $scope.headerList.push({"key": "tipoServizio", "value": "Tipo Servizio", "type": "text"});
        $scope.headerList.push({"key": "tipoContratto", "value": "Tipo Contratto", "type": "text"});
        $scope.headerList.push({"key": "stato", "value": "Stato", "type": "text"});
        $scope.headerList.push({"key": "codificaOAO", "value": "Codifica OAO", "type": "text"});
        $scope.headerList.push({"key": "flagValido", "value": "Attivo", "type": "checkbox"});
        
        //SM_8095
        $scope.allowedProfiles=["CRM_DG", "CRM_DG_CON", "CRM_DG_REG_UO"];
        $scope.flagForProfiles = false
        function checkContrattoButtonProfile(){	
        	angular.forEach($scope.allowedProfiles, function(value){
        		if($rootScope.timnowConfigData.user.codiceProfilo===value)
        			$scope.flagForProfiles = true
        	})
        }
        checkContrattoButtonProfile();
        
        //RU_716 NUOVO CONTRATTO
        //SM_8095
        if($scope.flagForProfiles){
        	// prima key = editable
        	$scope.headerList.push({"key": "idSistemaCompetente", "value": "Azione", "type": "button"});
        }
        
        if (($state.params.init === true) && $rootScope.RicercaAdvListaContratti) {
            delete $rootScope.RicercaAdvListaContratti;
        }

        function init() {
            var contratti = ContractsAnagrafica.get();
            contratti.$promise.then(
                function (data) {
                    if (data.result.code < 0) {
                        modalService.alertSearchError();
                        return false;
                    }
                    if (data.data) $scope.contracts = data.data;
                    if (!$scope.contracts) {
                        $scope.errorDate = true;
                    }
                    $scope.contractsLoaded = true;
                },
                function () {
                    modalService.alertSearchError();
                    $scope.contractsLoaded = true;
                    $scope.errorDate = true;
                });
        }

        $scope.getDettaglioContratti = function (item) {
        	//if item non è modificabile (leggere campo nuovo inviato da ilario):
            $state.go('root.anagrafica.contratto.dettaglio', {contratto: item, parametriRicerca: $scope.paramToSearch});
            //altrimenti state.go alla pagina nuova di creazione, passandogli un param che ti dice se sei in modifica con cui 
            //disabilitare le cose che non devi modificare (cfr. come gli passa il contratto attualmente)
        };

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }
        $scope.tipologiaRicerca = 'Contratto';

        $scope.getSearchAdvanced = function () {
            $scope.contractsLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Anagrafiche|Contratto',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                $rootScope.RicercaAdvListaContratti = $scope.paramToSearch;

                var contratti = AdvancedSearchGetDati.save({type: 'contracts'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                contratti.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.data) {
                        	$scope.contracts = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.contractsLoaded = true;
                    }, function (error) {
                        $scope.contractsLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                        
                    });
            } else {
            	 delete $rootScope.RicercaAdvListaContratti;
                init();
            }
        };

        if ($rootScope.RicercaAdvListaContratti) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaContratti;
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
          $rootScope.numeroDatiEsportati = $scope.contracts.length;
            
            return ExportId.save({entita: 'contracts'}, bodyData).$promise;
        };
        
    }]);
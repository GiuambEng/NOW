timnow
    .controller('pps', ['$scope', '$state', '$rootScope', 'PPSScopes', 'PPSMonitorings', '$log', 'modalService','TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $state, $rootScope, PPSScopes, PPSMonitorings, $log, modalService,TRACKING_GUI, TrackingGUI) {

        $scope.init = function () {
            $scope.scopes = [];
            $scope.reportTypes = [];
            $scope.selectedScope = null;
            $scope.selectedReportType = null;
            PPSScopes.get().$promise.then(function (response) {
                    $log.debug('Ambiti caricati correttamente.');
                    $scope.scopes = response.data;
                    $scope.scopesLoaded = true;
                },
                function (error) {
                    $log.error(error);
                    $scope.scopesLoaded = true;
                });

            $scope.parametriPPS = [];
            $scope.parametriLoaded = false;
            $scope.headerList = [
                {"key": "valoreSoglia", "value": "Valore", "type": "text"},
                {"key": "nomeSoglia", "value": "Soglia", "type": "text"},
                {"key": "idTipologiaSottoLavorazione", "value": "Sotto Lavorazione", "type": "text"},
                {"key": "idTipologiaSoglia", "value": "Tipo Soglia", "type": "text"},
                {"key": "idTipologiaLavorazione", "value": "Lavorazione", "type": "text"},
                {"key": "idStatoFile", "value": "Stato File", "type": "text"},
                {"key": "idRichiesta", "value": "Richiesta / Comunicazione Stato", "type": "text"},
                {"key": "idOfferta", "value": "Offerta", "type": "text"},
                {"key": "idFamigliaOfferta", "value": "Famiglia Offerta", "type": "text"},
                {"key": "idCausale", "value": "Causale", "type": "text"},
                {"key": "descrizioneSoglia", "value": "Descrizione", "type": "text"},
                {"key": "dataInizioValidita", "value": "Inizio Validità", "type": "text"},
                {"key": "dataFineValidita", "value": "Fine Validità", "type": "text"}
            ];

            $scope.tipologia = $state.params.tipologia;
        };

        $scope.init();

        $scope.getReportTypes = function () {
            if ($scope.selectedScope) {
                $scope.reportTypes = [];
                $scope.selectedReportType = null;
                $scope.reportTypesLoaded = false;
                PPSMonitorings.get({scopeId: $scope.selectedScope.id}).$promise.then(function (response) {
                        $scope.reportTypes = response.data;
                        $scope.reportTypesLoaded = true;
                    },
                    function (error) {
                        $scope.reportTypesLoaded = true;
                    });
            }
        };

        $scope.getPPSParameters = function () {
            if ($scope.selectedScope && $scope.selectedReportType) {
                PPSMonitorings.get({
                    scopeId: $scope.selectedScope.id,
                    reportType: $scope.selectedReportType.id
                }).$promise.then(function (response) {
                        $scope.parametriPPS = response.data;
                        $scope.parametriLoaded = true;
                    },
                    function (error) {
                        $scope.parametriLoaded = true;
                    });
            }
        };

        $scope.updateThreshold = function (selectedThreshold) {
            $log.debug(selectedThreshold);
            var selectedItem = angular.copy(selectedThreshold);
            $scope.modalForUpdateThreshold = {
                data: selectedItem,
                callbackFunction: 'saveNewThreshold',
                scope: $scope
            };

            $scope.modalDefs = {
                templateUrl: 'app/amministrazione/pps/edit.modal.html'
            };
            modalService.showModal($scope.modalDefs, $scope.modalForUpdateThreshold);
        };

        $scope.saveNewThreshold = function (item) {
            var updateMessage = {
                valoreSoglia: item.valoreSoglia,
                idSoglia: item.idSoglia
            };
            
            //RU_1010
            //Tracking da GUI per operazione INSERIMENTO
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Amministrazione|Parametri Monitoraggio PPS|Editing',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
            };

            PPSMonitorings.updateThreshold(updateMessage).$promise.then(function () {
                    $log.debug("Soglia aggiornata correttamente.");
                    $scope.getPPSParameters();
                    modalService.showModal({},
                        {
                            headerText: "Aggiornamento soglia",
                            bodyText: "Soglia aggiornata correttamente",
                            actionButtonText: 'Chiudi',
                            type: 'success'
                        });
                    
                    _trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ok';
                    TrackingGUI.tracking(_trackBean);
                },
                function (error) {
                    $log.debug("Errore durante salvataggio nuova soglia");
                    modalService.showModal({},
                        {
                            headerText: "Aggiornamento soglia",
                            bodyText: "Impossibile aggiornare la soglia",
                            actionButtonText: 'Chiudi',
                            type: 'error'
                        });
                    
                    _trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ko';
                    TrackingGUI.tracking(_trackBean);
                });
        }
    }]);
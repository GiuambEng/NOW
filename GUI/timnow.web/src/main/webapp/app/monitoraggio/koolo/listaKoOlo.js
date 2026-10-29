timnow
    .controller('listakoOlo', ['$scope', '$state', '$rootScope', 'MonitoraggioKOOLO', '$log', 'modalService',
        function ($scope, $state, $rootScope, MonitoraggioKOOLO, $log, modalService) {


            $scope.loading = true;
            $scope.tot1 = 0;
            $scope.tot2 = 0;
            $scope.tot3 = 0;
            $scope.tot4 = 0;
            $scope.tot5 = 0;
            $scope.tot6 = 0;
            $scope.tot7 = 0;
            $scope.conn = $rootScope.timnowConfigData.config;
            $scope.pageSize = $scope.conn.tablesPagesize;
            $scope.pageInit = $scope.pageSize.split(',');
            $scope.visLim = $scope.pageInit[0];
            $scope.numList = $scope.pageInit[0];

            var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
            $scope.today = new Date($scope.conn.today.replace(pattern, '$3-$2-$1'));
            /* EXPORT DATI VARIABILI */
            $scope.exportPollInterval = 5; // ogni quanti secondi fa il poll per l'export dati
            $scope.maxExportPoll = 24; // massimo di richieste di poll per l'export dati
            $scope.currentExportPoll = 1; // massimo di richieste di poll per l'export dati
            $scope.exportPercentage = 0;
            $scope.newExport = true;
            /* fine EXPORT DATI VARIABILI */

            init();

            function init() {
                var ord = MonitoraggioKOOLO.get({flagExport: false, level:'level0'});
                return ord.$promise.then(function (response) {
                        if (response.data) {
                            $scope.koOlo = response.data;
                        }
                        if ($scope.koOlo.length === 0) {
                            $scope.errorDate = true;
                            $scope.msg_err = "Nessun dato da visualizzare";
                        }
                        $scope.loading = false;
                    },
                    function (error) {
                        $log.error(error);
                        $scope.errorDate = true;
                        $scope.loading = false;
                        $scope.msg_err = "Impossibile visualizzare i KO su OLO";
                    });

            }
            $scope.changeList = function (item) {
                $scope.numList = item;
            };
            $scope.dettaglio = function (famiglia, causale, dataTotale, estrazione) {
                if (famiglia && causale && (estrazione > 0)) {
                    MonitoraggioKOOLO.get({
                        famiglia: famiglia,
                        causale: causale,
                        dataTotale: dataTotale,
                        level: 'level1'
                    }).$promise.then(function (response) {
                            $scope.modalDettaglioKoOlo.data = response.data;
                            $scope.richiesteLoaded = true;
                            modalService.showModal($scope.modalDefs, $scope.modalDettaglioKoOlo);
                        },
                        function (error) {
                            $log.error(error)
                        });
                } else {
                    $log.info("Impossibile visualizzare il dettaglio");
                }
            };

            $scope.modalDefs = {
                templateUrl: 'app/monitoraggio/koolo/requestDetailmodal.html'
            };

            $scope.modalDettaglioKoOlo = {
                scope: $scope
            };


            $scope.totale1 = function (estr1) {
                $scope.tot1 = $scope.tot1 + parseInt(estr1);
            };
            $scope.totale2 = function (estr2) {
                $scope.tot2 = $scope.tot2 + parseInt(estr2);
            };
            $scope.totale3 = function (estr3) {
                $scope.tot3 = $scope.tot3 + parseInt(estr3);
            };
            $scope.totale4 = function (estr4) {
                $scope.tot4 = $scope.tot4 + parseInt(estr4);
            };
            $scope.totale5 = function (estr5) {
                $scope.tot5 = $scope.tot5 + parseInt(estr5);
            };
            $scope.totale6 = function (estr6) {
                $scope.tot6 = $scope.tot6 + parseInt(estr6);
            };
            $scope.totale7 = function (estr7) {
                $scope.tot7 = $scope.tot7 + parseInt(estr7);
            };


            /* EXPORT DATI */
            $scope.iniziaExport = function () {
            	
            	//RU_902	//SM_8906
            	$rootScope.numeroDatiEsportati = $scope.koOlo.length;
            	
                return MonitoraggioKOOLO.get({flagExport: true, level:'level0'}).$promise;
            };

        }]);
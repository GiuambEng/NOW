timnow
    .controller('listakoWarn', ['$scope', '$state', '$rootScope', 'MonitoraggioKOWarning', '$log', 'modalService',
        function ($scope, $state, $rootScope, MonitoraggioKOWarning, $log, modalService) {

            $scope.loading = true;
            $scope.tot = 0;

            $scope.conn = $rootScope.timnowConfigData.config;
            $scope.pageSize = $scope.conn.tablesPagesize;
            $scope.pageInit = $scope.pageSize.split(',');
            $scope.visLim = $scope.pageInit[0];
            $scope.numList = $scope.pageInit[0];

            init();

            function init() {
            	MonitoraggioKOWarning.get({flagExport: false, level:'level0'}).$promise.then(function (response) {
                        if (response.data) {
                            $scope.koWarn = response.data;
                        }
                        if ($scope.koWarn.length === 0) {
                            $scope.errorDate = true;
                            $scope.msg_err = "Nessun dato da visualizzare";
                        }
                        $scope.loading = false;
                    },
                    function (error) {
                        $log.debug(error);
                        $scope.errorDate = true;
                        $scope.loading = false;
                        $scope.msg_err = "Impossibile visualizzare i KO di tipo Warning";
                    });

            }

            $scope.changeList = function (item) {
                $scope.numList = item;
            };

            $scope.dettaglio = function (dataOperazione, causale) {
                if (dataOperazione && causale) {
                    MonitoraggioKOWarning.get({
                        dataOperazione: dataOperazione,
                        causale: causale,
                        flagExport: false,
                        level:'level1'
                    }).$promise.then(
                        function (response) {
                            if (response.data.length > 0) {
                                var parentData = {
                                    dataOperazione: dataOperazione,
                                    causale: causale,
                                    level: 'level1'
                                };
                                $state.go('root.monitoraggio.koWarn.dettaglio', {
                                    dettaglio: response.data,
                                    parentData: parentData
                                });
                            } else {
                                modalService.showModal({}, {
                                    headerText: "Dettaglio KO di tipo Warning",
                                    bodyText: "Nessun dettaglio disponibile",
                                    actionButtonText: 'Chiudi',
                                    type: 'warning'
                                });
                            }
                        },

                        function (error) {
                            $log.debug(error);
                            $scope.errorDetail = true;
                            modalService.showModal({}, {
                                headerText: "Errore Dettaglio KO di tipo Warning",
                                bodyText: "Impossibile visualizzare il dettaglio",
                                actionButtonText: 'Chiudi',
                                type: 'warning'
                            });
                        }
                    );
                } else {
                    $log.info("Impossibile visualizzare il dettaglio");
                }
            };

            $scope.totale = function (estr) {
                $scope.tot = $scope.tot + parseInt(estr);
            };

            /* EXPORT DATI */

            $scope.iniziaExport = function () {

                var bodyData = {
                    "userId": $rootScope.timnowConfigData.user.userId,
                    "idRichiesta": [],
                    "codOloAgcom": $rootScope.timnowConfigData.user.codificaOloAgcom,
                    "tipoProfilo": $rootScope.timnowConfigData.user.codiceProfilo,
                    "tipoLista": "TUTTI"
                };
                
                //RU_902  //SM_8906
                $rootScope.numeroDatiEsportati = $scope.koWarn.length;

                return MonitoraggioKOWarning.get({flagExport: true, level:'level0'}, bodyData).$promise;

            };

            $scope.dataSort = function (dato) {
                var date = new Date(dato.dataEstrazione);
                return date;
            };

        }]);
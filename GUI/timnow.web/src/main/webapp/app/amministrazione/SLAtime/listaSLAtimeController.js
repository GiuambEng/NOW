timnow
    .controller('listaSLAtime', ['$scope', '$state', '$rootScope', 'SLAtime', '$log', function ($scope, $state, $rootScope, SLAtime, $log) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        $log.info('SLA Time');

        //solo singola lista
        $scope.SLAtime = [];
        $scope.SLAtimeLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "giorniSla", "value": "Giorni SLA", "type": "text"});
        $scope.headerList.push({"key": "tipoLinea", "value": "Tipo Linea", "type": "text"});
        $scope.headerList.push({"key": "causaleOrdine", "value": "Causale Ordine", "type": "text"});
        $scope.headerList.push({"key": "prodotto", "value": "Prodotto", "type": "text"});
        $scope.headerList.push({"key": "tipoLavorazione", "value": "Tipo Lavorazione", "type": "text"});

        $scope.detailList = [];
        $scope.detailList.push({"key": "dataInizio", "value": "Data Inizio", "type": "text"});
        $scope.detailList.push({"key": "dataFine", "value": "Data Fine", "type": "text"});
        $scope.detailList.push({"key": "flagMonitoraggio", "value": "Monitoraggio", "type": "checkbox"});
        $scope.detailList.push({"key": "flagReclamo", "value": "Reclamo", "type": "checkbox"});


        init();

        function init() {
            var ord = SLAtime.get();
            return ord.$promise.then(function (response) {
                    if (response.data) $scope.SLAtime = response.data;
                    if (!$scope.SLAtime) {
                        $scope.errorDate = true;
                    }
                    $scope.SLAtimeLoaded = true;
                },
                function (error) {
                    $scope.errorDate = true;
                    $scope.SLAtimeLoaded = true;
                });

        }

        $scope.getDettaglioSLA = function () {

            $log.debug($scope.detailArg);
            if (!$scope.dataContainer[$scope.detailArg.idAssetCrm]) {
                var dettaglio = SLAtime.get();
                dettaglio.$promise.then(function (data) {
                    $scope.dataContainer[$scope.detailArg.idAssetCrm] = [data];
                });
            }
        };
    }]);
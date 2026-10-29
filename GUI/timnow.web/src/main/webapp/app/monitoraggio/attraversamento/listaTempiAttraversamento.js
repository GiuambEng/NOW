timnow
    .controller('listaTempiAttrav', ['$scope', '$state', '$rootScope', 'TempiAttraversamento', '$log', 'modalService',
        function ($scope, $state, $rootScope, TempiAttraversamento, $log, modalService) {

            $scope.loading = true;
            $scope.tot1 = 0;
            $scope.tot2 = 0;
            $scope.tot3 = 0;
            $scope.tot4 = 0;
            $scope.tot5 = 0;
            $scope.tot6 = 0;
            $scope.tot7 = 0;
            $scope.tot8 = 0;
            $scope.totale1 = function (estr) {
                $scope.tot1 = $scope.tot1 + parseInt(estr);
            };
            $scope.totale2 = function (estr) {
                $scope.tot2 = $scope.tot2 + parseInt(estr);
            };
            $scope.totale3 = function (estr) {
                $scope.tot3 = $scope.tot3 + parseInt(estr);
            };
            $scope.totale4 = function (estr) {
                $scope.tot4 = $scope.tot4 + parseInt(estr);
            };
            $scope.totale5 = function (estr) {
                $scope.tot5 = $scope.tot5 + parseInt(estr);
            };
            $scope.totale6 = function (estr) {
                $scope.tot6 = $scope.tot6 + parseInt(estr);
            };
            $scope.totale7 = function (estr) {
                $scope.tot7 = $scope.tot7 + parseInt(estr);
            };
            $scope.totale8 = function (estr) {
                $scope.tot8 = $scope.tot8 + parseInt(estr);
            };

            $scope.conn = $rootScope.timnowConfigData.config;
            $scope.pageSize = $scope.conn.tablesPagesize;
            $scope.pageInit = $scope.pageSize.split(',');
            $scope.visLim = $scope.pageInit[0];
            $scope.numList = $scope.pageInit[0];

            init();

            function init() {
                $scope.showSpinner = true;
                TempiAttraversamento.get({flagExport: false, level:'level0'}).$promise.then(function (response) {
                        $scope.showSpinner = false;
                        if (response) {
                            $scope.tmpAttrav = response;
                        }
                        if ($scope.tmpAttrav.aggregates.length === 0) {
                            $scope.errorDate = true;
                        }
                        $scope.loading = false;
                    },
                    function (error) {
                        $log.debug(error);
                        $scope.showSpinner = false;
                        $scope.errorDate = true;
                        $scope.loading = false;
                    });

            }

            $scope.dettaglio = function (item) {
                $state.go('root.monitoraggio.tempiAttraversamento.dettaglio', {dettaglio: item});
            };

            /* EXPORT DATI */

            $scope.iniziaExportA = function () {
            	
            	//RU_902	//SM_8906
            	$rootScope.numeroDatiEsportati = $scope.tmpAttrav.aggregates.length;
            	
                return TempiAttraversamento.get({flagExport: true, tipoLista: 'A', level:'level0'}).$promise;

            };

            $scope.iniziaExportG = function () {
                return TempiAttraversamento.get({flagExport: true, tipoLista: 'G', level:'level0'}).$promise;
            };

            $scope.dataSort = function (dato) {
                var date = new Date(dato.dataEstrazione);
                return date;
            };

        }]);
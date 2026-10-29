timnow.controller('listaBande', ['$scope', '$state', '$rootScope', 'Bands', '$log',
    function ($scope, $state, $rootScope, Bands, $log) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        // solo singola lista
        $scope.BandePicco = [];
        $scope.BandePiccoLoaded = false;
        $scope.headerList = [{"key": "identificativoBandaPicco", "value": "ID Banda", "type": "text", "sort": "number"},
            {"key": "down", "value": "Banda Downstream", "type": "text", "sort": "number"}, {
                "key": "up",
                "value": "Banda Upstream",
                "type": "text",
                "sort": "number"
            },
            {"key": "modello", "value": "Modello", "type": "text"}, {
                "key": "tipoCos",
                "value": "Tipo Cos",
                "type": "text"
            }];

        init();

        function init() {
            var bandePico = Bands.get();
            bandePico.$promise.then(function (response) {
                if (response.data)
                    $scope.BandePicco = response.data;
                if (!$scope.BandePicco) {
                    $scope.errorDate = true;
                }
                $scope.BandePiccoLoaded = true;
            }, function (error) {
                $log.debug(error);
                $scope.errorDate = true;
                $scope.BandePiccoLoaded = true;
            });
        }
    }]);
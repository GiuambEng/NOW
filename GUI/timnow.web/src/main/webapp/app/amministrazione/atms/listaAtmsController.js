timnow.controller('Atms', ['$scope', '$state', '$rootScope', 'Atms', '$log',
    function ($scope, $state, $rootScope, Atms, $log) {

        $scope.init = function () {
            $rootScope.pageClass = $state.params.pageClass;
            $scope.tipologia = $state.params.tipologia;

            /* LISTA ATM */
            $scope.atm = [];
            $scope.atmsLoaded = false;
            $scope.headerList = [{"key": "codiceKit", "value": "Codice KIT", "type": "text"},
                {"key": "stato", "value": "Stato", "type": "text"},
                {"key": "decAttivazione", "value": "DEC Attivazione", "type": "data", "pattern": "dd/MM/yyyy"},
                {"key": "clli", "value": "CLLI", "type": "text"},
                {"key": "codificaOloAgcom", "value": "Codifica OAO", "type": "text"}];

            /* DETTAGLIO ATM */
            $scope.detailList = [{"key": "codiceAreaRaccolta", "value": "Codice Area di Raccolta", "type": "text"},
                {"key": "descAreaRaccolta", "value": "Desc Area Raccolta", "type": "text"},
                {"key": "codiceOlo", "value": "Codice OLO", "type": "text"},
                {"key": "identificativoPrimeContractor", "value": "ID Prime Contractor", "type": "text"},
                {"key": "dec", "value": "DEC", "type": "text"}];

            Atms.get().$promise.then(
                function (response) {
                    if (response.data) {
                        $scope.atm = response.data;
                    }
                    if (!$scope.atm) {
                        $scope.errorDate = true;
                    }
                    $scope.atmsLoaded = true;
                }, function (error) {
                    $scope.errorDate = true;
                    $scope.atmsLoaded = true;
                }
            );
        };

        $scope.init();
    }]);
timnow.controller('ihelp', ['$rootScope', '$scope', '$log', '$state', 'iHelpsVisible', '$location',
    function ($rootScope, $scope, $log, $state, iHelpsVisible, $location) {
        $rootScope.pageClass = $state.params.pageClass;
        // $scope.conn = $rootScope.timnowConfigData.authorizations;
        var info = $location.search();
        $scope.search = [];
        $scope.loadComplete = true;

        if ($state.params.ihelps.length > 0) {
            $scope.ihelps = $state.params.ihelps;
            $scope.loadComplete = false;
        } else {
            init();
        }

        function init() {
            var ord = iHelpsVisible.get({idAmbito: $state.params.idAmbito});
            return ord.$promise.then(function (response) {
                $scope.ihelps = response.data;
                $scope.loadComplete = false;
            }, function (error) {
                $scope.loadComplete = false;
            });
        }

        if (info) {
            $scope.ihelpVisible = parseInt(info.idIHelp);
        }

    }]);
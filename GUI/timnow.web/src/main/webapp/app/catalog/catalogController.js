timnow.
    controller('catalog', ['$scope', '$rootScope', '$sce', '$log', function ($scope, $rootScope, $sce, $log) {
        $log.debug('Catalog controller');
        if ($rootScope.timnowConfigData.config.catalogGuiURL) {
            $scope.catalogGUIURL = $sce.trustAsResourceUrl($rootScope.timnowConfigData.config.catalogGuiURL);
        } else {
            $log.debug('Catalog URL non configurato!');
        }
    }]);
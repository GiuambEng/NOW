timnow.controller('trackingApp', ['$scope', '$rootScope', '$sce', '$log', function ($scope, $rootScope, $sce, $log) {
    $log.debug('trackingApp controller');
    if ($rootScope.timnowConfigData.config.trackingAppURL) {
        $scope.trackingAppURL = $sce.trustAsResourceUrl($rootScope.timnowConfigData.config.trackingAppURL);
    } else {
        $log.debug('Tracking Applicativo URL non configurato!');
    }
}]);
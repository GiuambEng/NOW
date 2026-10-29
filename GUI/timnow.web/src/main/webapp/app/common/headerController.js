timnow.controller('header', ['$scope', '$state', 'Logout', '$log', '$rootScope', function ($scope, $state, Logout, $log, $rootScope) {

    $log.info('header');

    //Qui per gestire l'autorizzazioen dei menu...  console.log($rootScope.timnowConfigData);
    $scope.authorizations = $rootScope.timnowConfigData.authorizations; //test authorization
    $scope.user = $rootScope.timnowConfigData.user; //test authorization

    $scope.activeMenu = function ($event) {
        $log.debug($event);
    };

    $scope.invalidateSession = function ($event) {
        $log.debug('invalidateSession...');

        Logout.cleanSession().$promise.then(function (response) {
            $log.debug('Logout.clean..... ' + response);
        });
    };
}]);
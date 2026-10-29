timnow.controller('exit', ['$rootScope', '$scope', '$state', 'Logout', '$log', function ($rootScope, $scope, $state, Logout, $log) {
    $rootScope.pageClass = $state.params.pageClass;
    function init() {
        $log.debug('invalidateSession...');
        $rootScope = {};
        Logout.cleanSession().$promise.then(function (response) {
            $log.debug('Logout.clean..... ' + response);
        });
    }

    init();
}]);
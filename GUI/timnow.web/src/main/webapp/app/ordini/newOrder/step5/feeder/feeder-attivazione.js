//RU_1058
timnow.controller('feederAttivazioneStep5', ['$scope', '$state', '$rootScope',
	function ($scope, $state, $rootScope) {
	
	if (!$rootScope.data.step5) {
		$rootScope.formData.data.step5 = $rootScope.data.step5 = $scope.data.step5 = {};
    }
	
    $scope.goTo = function (state) {
        $state.go(state, {
            'returning': true
        });
    };
}]);  
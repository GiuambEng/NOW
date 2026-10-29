//RU_1058
timnow.controller('feederAttivazioneStep6', ['$scope', '$state', '$rootScope',
	function ($scope, $state, $rootScope) {
	
	if (!$rootScope.data.step6) {
		$rootScope.formData.data.step6 = $rootScope.data.step6 = $scope.data.step6 = {};
    }
	
    $scope.goTo = function (state) {
        $state.go(state, {
            'returning': true
        });
    };
}]);  
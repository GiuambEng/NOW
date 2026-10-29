//RU_1058
timnow.controller('vpAttivazioneStep6', ['$scope', '$state', '$rootScope',
	function ($scope, $state, $rootScope) {
	
	if (!$rootScope.data.step6) {
		$rootScope.formData.data.step6 = $rootScope.data.step6 = $scope.data.step6 = {};
    }
	
    $scope.nextState = function () {
        $state.go($scope.checkNextState(), {
            'returning': true
        });
    };
        
}]);  
//RU_1150
timnow.controller('ubbAttivazioneStep4', ['$scope', '$state', '$rootScope',
	function ($scope, $state, $rootScope) {
	
	if (!$rootScope.data.step4) {
		$rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4 = {};
    }
	
    $scope.goToNext = function (state) {
        $state.go($scope.checkNextState());
    };        
}]);  
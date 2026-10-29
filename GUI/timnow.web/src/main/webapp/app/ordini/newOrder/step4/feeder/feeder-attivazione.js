//RU_1058
timnow.controller('feederAttivazioneStep4', ['$scope', '$state', '$rootScope',
	function ($scope, $state, $rootScope) {
	
	if (!$rootScope.data.step4) {
		$rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4 = {};
    }
	
    $scope.submit_4 = function () {
    	 $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4; 
    	 $state.go('root.ordini.new.step5');              
    };
}]);  
timnow.controller('sha', ['$scope', '$state', '$rootScope', '$log','IDSLUCo','IDULLCo', 'modalService','$filter', function ($scope, $state, $rootScope, $log,IDSLUCo,IDULLCo, modalService, $filter  ) {
	if($rootScope.data.step1.causale_ordine==='variazione'){
    	if($rootScope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    }
	
	if (!$rootScope.data.step4) {
        $rootScope.data.step4 = $scope.data.step4 = {};
    }
    
    if($rootScope.data.step1.causale_ordine==='migrazione'){
		$scope.datiView =[true,false,false];
		$scope.closeOthers=true;
	}
    
    $scope.calcolaTabVisualizzato = function () {
    	if(!$scope.configurazioneOffertaForm.$valid){
    		$scope.datiView =[true,true,true];
    		$scope.closeOthers=false;
    	}
    };
    
    $scope.salvaConfigurazioneOfferta = function () {
    	$rootScope.formData.data.step4 = $scope.data.step4;
    	 if($rootScope.data.step1.causale_ordine === 'variazione'){
         	$state.go($scope.checkNextStateVariazione());
         }else {
         	 $state.go($scope.checkNextState());
         }
    };

    $scope.submit_4 = function () {
        $rootScope.data.step4 = $scope.data.step4;
        $scope.salvaConfigurazioneOfferta();
        $scope.controlloBozza(5);
    };

}]);
//RU_1475
timnow.controller('eoloAttivazioneStep7', ['$scope', '$state', '$rootScope',
	function ($scope, $state, $rootScope) {
	
	if (!$rootScope.data.step7) {
        $rootScope.data.step7 = $scope.data.step7 = {};
    }
	  
	
    $scope.submit_7 = function () {
    	
    	//Elimina le strutture dati provenienti dal controller padre 
    	if($scope.data.step7.datiAppuntamentoDisaggregazione){
    		delete $scope.data.step7.datiAppuntamentoDisaggregazione;
    	}
    	if($scope.data.step7.datiDisaggregazione){
    		delete $scope.data.step7.datiDisaggregazione;
    	}
    	if($scope.data.step7.datiPrestazioniAggiuntive){
    		delete $scope.data.step7.datiPrestazioniAggiuntive;
    	}
    	if($scope.data.step7.datiServiziOpzionali){
    		delete $scope.data.step7.datiServiziOpzionali;
    	}
    	if($scope.data.step7.datiSlaPlusSu){
    		delete $scope.data.step7.datiSlaPlusSu;
    	}
    	
    	$rootScope.formData.data.step7 = $scope.data.step7;
    }
    	
    
    $scope.nextState = function () {
        $state.go($scope.checkNextState(), {
            'returning': true
        });
    };
    
}]);  
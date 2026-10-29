//RU_1058
timnow.controller('vlanVariazioneStep7', ['$scope', '$state', '$rootScope',
	function ($scope, $state, $rootScope) {
	
	if (!$rootScope.data.step7) {
        $rootScope.data.step7 = $scope.data.step7 = {};
    }
	
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
	
    $scope.nextState = function () {
        $state.go($scope.checkNextState(), {
            'returning': true
        });
    };
    
}]);  
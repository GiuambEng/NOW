//RU_1335
timnow.controller('dettaglioFwaWillDeco', ['$scope', '$state', '$rootScope', 'RisorseFwaWillDeco',
	function ($scope, $state, $rootScope, RisorseFwaWillDeco) {

	$rootScope.pageClass = $state.current.params.pageClass;
	
	$scope.idRisorsa = $state.params.idRisorsa;
	$scope.loadDettaglio = true;
	$scope.risorsa = {};

	$scope.back = function () {
		$state.go("root.anagrafica.fwaWillDeco");
	};

	$scope.init = function(){
		RisorseFwaWillDeco.details.get({idRisorsa: $scope.idRisorsa}).$promise    	
		.then(function(response){
			
			$scope.loadDettaglio = false;
			if (response && response.result.code === 'OK') {
				$scope.risorsa = response.dettaglioRisorsa;
			}else{
				if(response && response.result.code === 'KO' && response.result.details) {
					$scope.erroreService(response.result.details);
				}else{
					$scope.erroreService("Errore nel recupero dettaglio Risorsa FWA");
				}
			}	
			
		}, function(error){			
			$scope.loadDettaglio = false;
			$scope.erroreService("Errore nel recupero dettaglio Risorsa FWA");
		});    	
	}
	
	$scope.erroreService = function (messageBody) {
		modalService.showModal({}, {
			headerText: "Avviso",
			bodyText: messageBody,
			scope: $scope,
			type: 'success'
		});
		$scope.caricaPassFive = false;
	}
	
	$scope.init();
}]);
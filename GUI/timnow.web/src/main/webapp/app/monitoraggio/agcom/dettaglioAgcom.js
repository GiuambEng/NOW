timnow.controller('dettaglioAgcom', [ '$scope', '$state', 'agcomMonitorings', function($scope, $state, agcomMonitorings) {
		
		$scope.init = function() {
						      
			$scope.showSpinner = true;

			 if ($state.params.livello) {
			 	$scope.sezione = $state.params.livello;
			 	$scope.dettaglio = $state.params.dettaglio;
			 	$scope.giorno = $state.params.giorno;
			 }
		};

		$scope.init();

		$scope.iniziaExport = function () {		
			return agcomMonitorings.get({
					livello : 'livello' + $scope.sezione,
					flagDettaglio : 'Y',
					dataEstrazione : $scope.giorno,
					flagExport : true
				}).$promise;		
		 };
		 
        $scope.backState = function (livello) {
			$state.go('root.monitoraggio.agcom', {
				livello : $scope.sezione
			});
        };
        
        $scope.showSpinner = false;
} ]);
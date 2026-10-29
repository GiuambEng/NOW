//RU_1203
timnow.controller('lavorazioneManualeNpng', ['$scope', '$state', '$rootScope', '$stateParams', 'modalService', 
	function ($scope, $state, $rootScope, $stateParams, modalService) {
	
    if ($state.params.init) {
        $rootScope.data = {};
        $rootScope.data.step1 = {};
        $rootScope.data.step2 = {};
        $scope.data = {};
        $scope.data.step1 = {};
        $scope.data.step2 = {};
        
        $scope.loadStep1 = false;
        $scope.loadStep2 = false;
        
        $state.go('root.ordini.npng.lavorazioneManuale.step1');          
    }
	
}]);
        
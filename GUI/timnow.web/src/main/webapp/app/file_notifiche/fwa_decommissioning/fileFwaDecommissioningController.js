//RU_1335
timnow
	.controller('fileFwaDecommissioning', ['$scope', '$rootScope', '$state', 'FwaDecommissioning', 'modalService',
    		function ($scope, $rootScope, $state, FwaDecommissioning, modalService) {
        
		$rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        $scope.files = [];
        $scope.headerList = [];
        $scope.detailList = [];
        
        $scope.headerList.push(
        		{"key": "nomeFile", "value": "Nome File", "type": "text"},
        		{"key": "dataInserimento", "value": "Data Inserimento", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
        		{"key": "dataUltimaModifica", "value": "Data Ultima Modifica", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
                {"key": "descrizioneEsito", "value": "Descrizione Esito", "type": "text"},
                {"key": "idFile", "value": "", "type": "file"});        
                
        $scope.detailList.push(
        		{"key": "numeroRecord", "value": "Numero Record", "type": "text"},
        		{"key": "operatoreInserimento", "value": "Operatore Inserimento", "type": "text"},
        		{"key": "operatoreUltimaModifica", "value": "Operatore Ultima Modifica", "type": "text"});     
        
        
        /* Visualizza lista */
        
        $scope.loadFileList = function(){
        	$scope.filesLoaded = false;
        	$scope.files = [];
        	FwaDecommissioning.all.get().$promise
        	.then(function(response){
                if (response.data) {
                	$scope.files = response.data;
                	$scope.$broadcast('nowTable.refreshData', $scope.files);
                }
                $scope.filesLoaded = true;        		
        	}, function(err){
        		$scope.filesLoaded = true;
        		$scope.erroreService("Impossibile recuperare i dati. Riprovare piu' tardi.")
        	});
        }      
        
        $scope.erroreService = function (messageBody) {
			modalService.showModal({}, {
				headerText: "Avviso",
				bodyText: messageBody,
				scope: $scope,
				type: 'success'
			});
		}
        
        $scope.loadFileList();     
                
     
}]);
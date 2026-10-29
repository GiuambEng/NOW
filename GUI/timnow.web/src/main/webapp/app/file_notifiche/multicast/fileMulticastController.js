//RU_1180
timnow
	.controller('fileMulticast', ['$scope', '$rootScope', '$state', 'FileState', 'modalService', 'AdvancedSearchGetDati', 'TRACKING_GUI', 'TrackingGUI', 'Multicast',
    		function ($scope, $rootScope, $state, FileState, modalService, AdvancedSearchGetDati, TRACKING_GUI, TrackingGUI, Multicast) {
        
		$rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        $scope.files = [];
        $scope.headerList = [];
        
        $scope.headerList.push(
        		{"key": "nomeFile", "value": "Nome File", "type": "text"},
                {"key": "tipologiaTracciato", "value": "Tipologia Tracciato", "type": "text"},               
                {"key": "dataInserimentoFile", "value": "Data Inserimento File", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
                {"key": "dataUltimoAggiornamento", "value": "Data Ultimo Aggiornamento", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
                {"key": "numeroOrdini", "value": "Numero Ordini", "type": "text"},
                {"key": "statoElaborazioneFile", "value": "Stato Elaborazione", "type": "text"},
                {"key": "idFile", "value": "", "type": "multicastFile"},
        		{"key": "idInterfaccia", "value": "", "type": "esitoMulticastFile"});
        
        
        /* Visualizza lista */
        
        $scope.loadFileList = function(){
        	$scope.filesLoaded = false;
        	$scope.files = [];
        	Multicast.all.get().$promise
        	.then(function(response){
                if (response.data) {
                	$scope.files = response.data;
                	$scope.$broadcast('nowTable.refreshData', $scope.files);
                }
                $scope.filesLoaded = true;        		
        	}, function(err){
        		$scope.filesLoaded = true;
        	});
        }      
        
        $scope.loadFileList();     
                
     
}]);
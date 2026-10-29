//RU_1301
timnow
	.controller('listaFileComuniCoinvestimento', ['$scope', '$rootScope', '$state', 'modalService', 'AdvancedSearchGetDati', 'alertService',
    		function ($scope, $rootScope, $state, modalService, AdvancedSearchGetDati, alertService) {
        
		$rootScope.pageClass = $state.params.pageClass;
        
        $scope.files = [];
        $scope.headerList = [];
        $scope.tipologia = $state.params.tipologia;
        $scope.tipologiaRicerca = $state.params.tipologia;
        $scope.enableRicercaComuniCoinvestimento = true;
        
        $scope.headerList.push(
        		{"key": "nomeFile", "value": "Nome File", "type": "text"},
        		{"key": "dataInserimento", "value": "Data Caricamento File", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
        		{"key": "dataAggiornamento", "value": "Ultimo Aggiornamento", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
                {"key": "statoElaborazione", "value": "Stato Elaborazione", "type": "text"},
                {"key": "nomeContratto", "value": "Nome Contratto", "type": "text"},                
                {"key": "oao", "value": "OAO", "type": "text"},
        		{"key": "offerta", "value": "Offerta", "type": "text"},
                {"key": "idFile", "value": "", "type": "comuniCoinvestimentoFile"},
	            {"key": "idFile", "value": "", "type": "esitoComuniCoinvestimentoFile"});
        
        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }

        $scope.init = function() {
        	alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare gli ordini di interesse.","danger",10000);
        }
                
        $scope.getSearchAdvanced = function () {
        	$scope.enableRicercaComuniCoinvestimento = false;
        	$scope.filesLoaded = false;

            if ($scope.paramToSearch.length > 0) {

                AdvancedSearchGetDati.save({
                    type: 'comuniCoinvestiti'
                }, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                }).$promise.then(function (data) {
                    if (data.result.code < 0) {
                        modalService.alertSearchError();
                        return false;
                    }
                    if (data.data)
                    	$scope.files = data.data;
                    $scope.filesLoaded = true;
                }, function (error) {
                    modalService.alertSearchError();
                    $scope.filesLoaded = true;
                });
            } else {
            	$scope.init();
            }
        };
        
        $scope.init();                     
     
}]);
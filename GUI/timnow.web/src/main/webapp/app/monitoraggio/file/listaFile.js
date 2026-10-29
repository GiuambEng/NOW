timnow.controller('listaFile', ['$scope', '$state', '$log', '$rootScope', 'MonitoraggioFile', function ($scope, $state, $log, $rootScope, MonitoraggioFile) {
    $scope.loading = true;
    init();
    function init() {
        $scope.showSpinner = true;
        MonitoraggioFile.get({flagExport: false}).$promise.then(function (response) {
                $scope.showSpinner = false;
                $scope.exportFileVisibility = false;
                if (response) {
                    $scope.fileMonitorings = response;
                }
                if ($scope.fileMonitorings.length === 0) {
                    $scope.errorDate = true;
                    $scope.msg_err = "Nessun dato da visualizzare";
                }
                else if ($scope.fileMonitorings.famigliaOfferta.length > 0) {
                	$scope.soglia = $scope.fileMonitorings.soglia;
                    angular.forEach($scope.fileMonitorings.famigliaOfferta, function (value) {
                        if (value.datiFile && value.datiFile.length > 0) {
                            $scope.exportFileVisibility = true;
                        }
                    });
                }
                $scope.loading = false;
            },
            function (error) {
                $log.debug(error);
                $scope.showSpinner = false;
                $scope.errorDate = true;
                $scope.loading = false;
                $scope.msg_errTotale = "Impossibile visualizzare il monitoraggio file";
            });

    }

    $scope.dettaglio = function (famiglia, data, statoFile, owner, canale, contatore) {
        if (canale && parseInt(contatore) >= 1) {
            var dettaglio = {
                'famiglia': famiglia,
                'data': data,
                'statoFileNow': statoFile,
                'owner': owner,
                'canale': canale,
                'contatore': contatore
            };
            $state.go('root.monitoraggio.file.dettaglio', {'dettaglio': dettaglio});
        }
    };

    /* EXPORT DATI */
    $scope.controlloSoglie = function (valore,soglia) {
        return (parseInt(valore) >= parseInt(soglia));
    };

    $scope.iniziaExport = function () {
    	
    	//RU_902	//SM_8906
    	$rootScope.numeroDatiEsportati = 0;
    	try{
    		$scope.fileMonitorings.famigliaOfferta.forEach(function(item){
    			$rootScope.numeroDatiEsportati += item.datiFile.length; 
    		});
    		
    	}catch(e){
    		$rootScope.numeroDatiEsportati = null;
    	}
    	
        return MonitoraggioFile.get({flagExport: true}).$promise;
    };

}]);
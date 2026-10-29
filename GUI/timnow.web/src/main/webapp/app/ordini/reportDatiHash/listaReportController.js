//R1F-21-0411
timnow.controller('listaReportController', ['$scope', '$state', 'modalService', 'ListaReport',
     function ($scope, $state, modalService, ListaReport) {
	
	$scope.headerListaReport = [];
	$scope.headerListaReport.push({"key": "idReport","value": "", "type": "idReport"});
	$scope.headerListaReport.push({"key": "nomeReport","value": "Nome Report","type": "text"});
	$scope.headerListaReport.push({"key": "tipoLista","value": "Tipo Lista","type": "text"});
	$scope.headerListaReport.push({"key": "statoElabReport","value": "Stato","type": "text"});
    $scope.headerListaReport.push({"key": "dataInserimento","value": "Data Inserimento","type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
    $scope.headerListaReport.push({"key": "dataAggiornamento","value": "Data Aggiornamento","type": "data","pattern": "dd/MM/yyyy HH:mm:ss"});    
    $scope.headerListaReport.push({"key": "dettaglioElabReport","value": "Dettaglio Elaborazione","type": "text"});    
	
    $scope.listaReport = [];
    $scope.tipologia = "Report"
    
	$scope.loadListaReport = function(){
		$scope.listaReport = [];
		$scope.datiLoaded = true;
		ListaReport.get($scope.report).$promise
		.then(function(response){
			$scope.datiLoaded = false;
			if(response && response.result.description == 'OK'){				
				if(response.outputListaReport){					
					$scope.listaReport = response.outputListaReport;
					$scope.$broadcast('nowTable.refreshData', $scope.listaReport);
				}
			}else{
				modalService.showModal({}, {
					headerText : "Lista Report",
					templateUrl : 'app/common/templates.html',
					bodyText : response.result.message
				});
			}
		}, function(error){
			$scope.datiLoaded = false;
			modalService.showModal({}, {
				headerText : "Lista Report",
				templateUrl : 'app/common/templates.html',
				bodyText : "Errore nel recupero della lista report."
			});
		});
	}	
	
	$scope.getDettaglioReport = function(item){
		$state.go('root.ordini.listareport.dettaglio', {idReport: item.idReport, tipoLista: item.tipoLista});
	}
	
	$scope.loadListaReport();
}]);
   

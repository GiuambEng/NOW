//R1F-21-0411
timnow.controller('creazioneReportController', ['$scope', '$state', 'CreazioneReport', 'modalService', '_',
     function ($scope, $state, CreazioneReport, modalService, _) {
	
	$scope.report = {};	
	$scope.tipoLista = "";
	$scope._filtriHashing = ["HASH.NOME_HASH", "HASH.CODICE_FISCALE_HASH", "HASH.COGNOME_RAGIONE_SOCIALE_HASH", "HASH.PARTITA_IVA_HASH"];
	
	$scope.creaReport= function(){
		
		//#Task 38472
		if($scope.report.tipoLista != 'DONATING' && !$scope.verifyFiltriHashing()){
			modalService.showModal({}, {
				headerText : "Creazione Report",
				templateUrl : 'app/common/templates.html',
				bodyText : "Non e' stato selezionato nessun dato sensibile per la creazione del report"
			});
			return;			
		}
		
		//SM_10700
		CreazioneReport.save($scope.report).$promise
		.then(function(response){
			if(response && response.result.code == 'OK'){
				modalService.showModal({}, {
					headerText : "Creazione Report",
					templateUrl : 'app/common/templates.html',
					bodyText : "Richiesta creazione report effettuata."
				});				
				$state.go('root.ordini.listareport');
			}else{
				modalService.showModal({}, {
					headerText : "Creazione Report",
					templateUrl : 'app/common/templates.html',
					bodyText : response.result.details
				});
			}
		}, function(error){
			modalService.showModal({}, {
				headerText : "Creazione Report",
				templateUrl : 'app/common/templates.html',
				bodyText : "Errore nella creazione richiesta report."
			});
		});
	}
	
	$scope.clearFiltriOrdiniDonating = function(){
		$scope.report.codOrdineTi = "";
		$scope.report.nomeFileNotifica = "";
		$scope.report.idRisorsa = "";
		$scope.report.codiceSessione = "";
	}
	
	$scope.verifyFiltriHashing = function(){
		if($scope.report.strutturaCondition && $scope.report.strutturaCondition.length > 0){
			var _selectedHashFilters = _.pluck($scope.report.strutturaCondition, 'nome');
			if(_selectedHashFilters && _selectedHashFilters.length > 0){
				return (_.intersection($scope._filtriHashing, _selectedHashFilters).length > 0);
			}
			return false; 
		}
		return false;
	}
	
	$scope.$watch("report.nomeReport", function(newValue, oldValue){
		if(!newValue || newValue == ''){
			$scope.report.tipoLista = "";
			$scope.tipoLista = "";
			$scope.filtriRicerca = [];
		}
	});
	
	$scope.$watch("report.tipoLista", function(newValue, oldValue){
		if(newValue){
			switch(newValue){
			case "TUTTI":
			case "SOSPESO":
			case "ACCODATO":			
			case "OPERASPECIALE":
				$scope.tipoLista = "Lista Ordini";
				break;
			case "DONATING":
				$scope.clearFiltriOrdiniDonating();
				break;
			case "ASSET":
				$scope.tipoLista = "Lista Asset";
				break;	
			}
		}else{
			$scope.tipoLista = "";
		}
		
		$scope.$broadcast("direttivaSearch.refreshCodFunzione", $scope.tipoLista);
	});
}]);
   

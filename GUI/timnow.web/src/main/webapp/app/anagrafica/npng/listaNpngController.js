
//RU_1203
timnow
    .controller('listaNpng', ['$scope', '$state', '$rootScope', 'modalService', 'ListaOpzioniTrafficoNpng',
    	function ($scope, $state, $rootScope, modalService, ListaOpzioniTrafficoNpng) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        $scope.numbers = [];
        $scope.numbersLoaded = false;
        
        $scope.headerList = [];        
        $scope.headerList.push({"key": "descrOpzTraffico", "value": "Descrizione Opzione Traffico", "type": "text"});
        $scope.headerList.push({"key": "opzTraffico", "value": "Opzione Traffico", "type": "text"});
        $scope.headerList.push({"key": "prefissoNPNG", "value": "Prefisso Non Geografico", "type": "text"});
        $scope.headerList.push({"key": "dataInizioValidita", "value": "Data Inizio Vaidita'", "type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "dataFineValidita", "value": "Data Fine Validita'", "type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "rowId", "value": "", "type": "npng"});
        
        $scope.init = function(){
        	
        	ListaOpzioniTrafficoNpng.get().$promise
        	.then(function(result){
        		if(result && result.listaOpzTrafficoNPNG){
        			$scope.numbers = result.listaOpzTrafficoNPNG;
        			$scope.numbersLoaded = true;
        		}
        	}, function(error){
        		$scope.numbersLoaded = true;
        		modalService
                .showModal({}, {
                    headerText: "Errore",
                    bodyText: "Errore recupera lista Opzioni traffico prefisso NPNG",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
        	});
        	
        }

        $scope.getDettaglioNumber = function(item){
            $state.go('root.anagrafica.npng.modifica', {number: item});
        }
        
        $scope.newNumber = function(){
            $state.go('root.anagrafica.npng.nuovo');
        }
        
        $scope.init();
        
    }]);
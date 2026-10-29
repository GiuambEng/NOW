//RU_1335
timnow
    .controller('listaFwaWillDeco', ['$scope', '$state', '$rootScope', 'modalService', 'RisorseFwaWillDeco',
    	function ($scope, $state, $rootScope, modalService, RisorseFwaWillDeco) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Campi tabella
        $scope.dati = [];
        $scope.datiLoaded = false;
        
        $scope.headerList = [];
        $scope.headerList.push({"key": "idRisorsaSwitchOff", "value": "Id Risorsa SwitchOff", "type": "text"});
        $scope.headerList.push({"key": "dataScadenzaSwitchOff", "value": "Data Scadenza Switch-Off", "type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "statoMigrato", "value": "Stato Migrato", "type": "text"});
        $scope.headerList.push({"key": "idRisorsaSwitchOff", "value": "Azione", "type": "idRisorsaSwitchOff"});
                      
        $scope.init = function(){
        	RisorseFwaWillDeco.list.get().$promise
        	.then(function(response){
        		$scope.datiLoaded = true;          		
        		if(response.listaRisorseFwa){        			      			
        			$scope.dati = response.listaRisorseFwa;
        		}         		
        	}, function(error){
        		$scope.datiLoaded = true;
        		$scope.erroreService("Impossibile ricavare i dati. Riprovare piu' tardi.");
        	});
        }
        
        $scope.getDettaglioFwaWillDeco = function(item){
			$state.go('root.anagrafica.fwaWillDeco.dettaglio', {idRisorsa: item.idRisorsaSwitchOff});
		}
		
		$scope.newRisorsaFwaWillDeco = function(){
			$state.go('root.anagrafica.fwaWillDeco.new');
		}
		
		$scope.erroreService = function (messageBody) {
			modalService.showModal({}, {
				headerText: "Avviso",
				bodyText: messageBody,
				scope: $scope,
				type: 'success'
		});
	}
               
        $scope.init();
    }]);
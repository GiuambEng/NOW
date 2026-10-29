//RU_1058
timnow
    .controller('kitVlan', ['$scope', '$state', '$rootScope','KitVlan', 'modalService', 
    	function ($scope, $state, $rootScope, KitVlan, modalService) {
    	
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Campi tabella
        $scope.dati = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "codiceKit", "value": "Codice Kit", "type": "text"});
        $scope.headerList.push({"key": "stato", "value": "Stato", "type": "text"});
        $scope.headerList.push({
            "key": "decAttivazione",
            "value": "DEC Attivaizone",
            "type": "data",
            "pattern": "dd/MM/yyyy"
        });
        $scope.headerList.push({"key": "clli", "value": "CLLI", "type": "text"});
        $scope.headerList.push({"key": "codificaOloAgcom", "value": "Codifica Olo AGCOM", "type": "text"});
        $scope.headerList.push({"key": "famigliaKit", "value": "Famiglia Kit", "type": "text"});
      
        $scope.detailList = [];
        $scope.detailList.push({
            "key": "dec",
            "value": "DEC",
            "type": "data",
            "pattern": "dd/MM/yyyy"
        });
        $scope.detailList.push({"key": "modelloKit", "value": "Modello Kit", "type": "text"});
        $scope.detailList.push({"key": "abilitatoNga", "value": "Abilitato NGA", "type": "text"});
        $scope.detailList.push({"key": "codiceOlo", "value": "Codice Olo", "type": "text"});
        $scope.detailList.push({"key": "idPrimeContractor", "value": "Identificativo Prime Contractor", "type": "text"});

        
        $scope.init = function(){
        	KitVlan.get().$promise
        	.then(function(response){
        		$scope.datiLoaded = true;          		
        		if(response.result.code == '0'){        			      			
        			$scope.dati = response.data;
        		}else{
        			modalService.alertSearchError();
        		} 
        		
        	}, function(error){
        		$scope.datiLoaded = true;
        		modalService.alertSearchError();
        	});
        }
               
        $scope.init();
    }]);
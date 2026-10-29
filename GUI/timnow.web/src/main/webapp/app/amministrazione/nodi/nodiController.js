//RU_1058
timnow
    .controller('nodi', ['$scope', '$state', '$rootScope', 'modalService', 'Nodi', 
    	function ($scope, $state, $rootScope, modalService, Nodi) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Colonne tabella
        $scope.centrali = [];
        $scope.centraliLoaded = false;
        
        $scope.headerList = [];
        $scope.detailsList = [];
        $scope.headerList.push({"key": "codiceNodo", "value": "Codice Nodo", "type": "text"});
        $scope.headerList.push({"key": "codiceClli", "value": "Codice CLLI", "type": "text"});
        $scope.headerList.push({"key": "descrizioneCentrale", "value": "Descrizione Centrale", "type": "text"});
       
              
        $scope.init = function(){
        	Nodi.get().$promise
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
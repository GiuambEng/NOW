//RU_1058
timnow
    .controller('vlan', ['$scope', '$state', '$rootScope', 'modalService', 'Vlan',
    	function ($scope, $state, $rootScope, modalService, Vlan) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Campi tabella
        $scope.dati = [];
        $scope.datiLoaded = false;
        
        $scope.headerList = [];
        $scope.headerList.push({"key": "marcaggioVLAN", "value": "Marcaggio VLAN", "type": "text"});
        $scope.headerList.push({"key": "ftthOnly", "value": "FTTH Only", "type": "text"});
                      
        $scope.init = function(){
        	Vlan.get().$promise
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
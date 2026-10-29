//RU_1058
timnow
    .controller('centraliGbe', ['$scope', '$state', '$rootScope', 'modalService', 'CentraliGBE',
    	function ($scope, $state, $rootScope, modalService, CentraliGBE) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Campi tabella
        $scope.dati = [];
        $scope.datiLoaded = false;
        
        $scope.headerList = [];
        $scope.headerList.push({"key": "codiceClli", "value": "Codice CLLI", "type": "text"});
        $scope.headerList.push({"key": "nomeCentrale", "value": "Nome Centrale", "type": "text"});
        $scope.headerList.push({"key": "stato", "value": "Stato", "type": "text"});
        $scope.headerList.push({"key": "flagQNQ", "value": "Flag QNQ", "type": "text"});
        $scope.headerList.push({"key": "flagLongDistance", "value": "Flag Long Distance", "type": "text"});
        $scope.headerList.push({
            "key": "dataAttivazione",
            "value": "Data Attivazione",
            "type": "data",
            "pattern": "dd/MM/yyyy"
        });
        $scope.headerList.push({"key": "flagProntoVendita", "value": "Flag Pronto Vendita", "type": "text"});
        
        
        $scope.detailList = [];
        $scope.detailList.push({"key": "codiceIdbre", "value": "Codie IDBRE", "type": "text"});
        $scope.detailList.push({"key": "descrizioneClli", "value": "Codie IDBRE", "type": "text"});
        $scope.detailList.push({"key": "comune", "value": "Comune", "type": "text"});       
        $scope.detailList.push({"key": "distretto", "value": "Distretto", "type": "text"});
        $scope.detailList.push({"key": "tipologiaDslam", "value": "Tipologia DSLAM", "type": "text"});       
              
        $scope.init = function(){
        	CentraliGBE.get().$promise
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
//RU_1058
timnow
    .controller('centraliNga', ['$scope', '$state', '$rootScope','modalService', 'CentraliNGA',
    	function ($scope, $state, $rootScope, modalService, CentraliNGA) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Colonne tabella
        $scope.dati = [];
        $scope.datiLoaded = false;
        
        $scope.headerList = [];
        $scope.headerList.push({"key": "codiceClli", "value": "Codice CLLI", "type": "text"});
        $scope.headerList.push({"key": "codiceClliPdc", "value": "Codice CLLI PDC", "type": "text"});
        $scope.headerList.push({"key": "nomeMacroArea", "value": "Nome Macro Area", "type": "text"});
        $scope.headerList.push({"key": "nomePdc", "value": "Nome PDC", "type": "text"});
        $scope.headerList.push({"key": "stato", "value": "Stato", "type": "text"});
        $scope.headerList.push({
            "key": "dataAttivazione",
            "value": "Data Attivazione",
            "type": "data",
            "pattern": "dd/MM/yyyy"
        });
        $scope.headerList.push({"key": "flagProntoVendita", "value": "Flag Pronto Vendita", "type": "text"});
        $scope.headerList.push({"key": "tecnologia", "value": "Tecnologia", "type": "text"});
        $scope.headerList.push({"key": "flagPdc", "value": "Flag PDC", "type": "text"});
        
        $scope.detailList = [];
        $scope.detailList.push({"key": "comune", "value": "Comune", "type": "text"});
        $scope.detailList.push({"key": "distretto", "value": "Distretto", "type": "text"});
        $scope.detailList.push({"key": "codiceIdbre", "value": "Codie IDBRE", "type": "text"});
        $scope.detailList.push({"key": "nomeCentrale", "value": "Nome Centrale", "type": "text"});
        $scope.detailList.push({"key": "nomeCentralePdc", "value": "Nome Centrale PDC", "type": "text"});
        $scope.detailList.push({
            "key": "dataProntoVendita",
            "value": "Data Pronto Vendita",
            "type": "data",
            "pattern": "dd/MM/yyyy"
        });
       
              
        $scope.init = function(){
        	CentraliNGA.get().$promise
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
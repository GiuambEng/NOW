//RU_1058
timnow
    .controller('areaMacroArea', ['$scope', '$state', '$rootScope','AreaMacroarea', 'modalService', 
    	function ($scope, $state, $rootScope, AreaMacroarea, modalService) {
    	
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Campi tabella
        $scope.dati = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "codiceAdr", "value": "Codice ADR", "type": "text"});
        $scope.headerList.push({"key": "descrizioneArea", "value": "Descrizione Area", "type": "text"});
        $scope.headerList.push({"key": "tipologiaAdr", "value": "Tipologia ADR", "type": "text"});
        $scope.headerList.push({"key": "flagAtm", "value": "Flag ATM", "type": "text"});

        $scope.detailList = [];
        $scope.detailList.push({
            "key": "dataInizioValidita",
            "value": "Data Inizio Validita ADR",
            "type": "data",
            "pattern": "dd/MM/yyyy"
        });
        $scope.detailList.push({
            "key": "dataFineValidita",
            "value": "Data Fine Validita ADR",
            "type": "data",
            "pattern": "dd/MM/yyyy"
        });
        
        $scope.init = function(){
        	AreaMacroarea.get().$promise
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
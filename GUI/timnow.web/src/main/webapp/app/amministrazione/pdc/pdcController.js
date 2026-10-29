//RU_1058
timnow
    .controller('pdc', ['$scope', '$state', '$rootScope', 'modalService', 'PuntiConsegna', 
    	function ($scope, $state, $rootScope, modalService, PuntiConsegna) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Colonne tabella
        $scope.dati = [];
        $scope.datiLoaded = false;
        
        $scope.headerList = [];
        $scope.headerList.push({"key": "codicePDC", "value": "Codice PDC", "type": "text"});
        $scope.headerList.push({"key": "roPDC", "value": "RO PDC", "type": "text"});
        $scope.headerList.push({"key": "idoneitaPopPDC", "value": "Idoneita POP PDC", "type": "text"});
        $scope.headerList.push({"key": "idoneitaNgaPDC", "value": "Idoneita POP PDC", "type": "text"});
        
        $scope.detailList = [];
        $scope.detailList.push({"key": "nomeCentralePDC", "value": "Nome Centrale PDC", "type": "text"});
        $scope.detailList.push({"key": "viaPDC", "value": "Via PDC", "type": "text"});
        $scope.detailList.push({"key": "comune", "value": "Comune", "type": "text"});
        $scope.detailList.push({"key": "codiceClliPDC", "value": "Codice CLLI PDC", "type": "text"});        
        $scope.detailList.push({"key": "descrizioneClliPDC", "value": "Descrizione CLLI PDC", "type": "text"});
        $scope.detailList.push({"key": "codiceIdbre", "value": "Codie IDBRE", "type": "text"});
        $scope.detailList.push({"key": "regionePDC", "value": "Regione PDC", "type": "text"});
        $scope.detailList.push({"key": "provincia", "value": "Provincia", "type": "text"});
        $scope.detailList.push({"key": "stato", "value": "Stato", "type": "text"});
        $scope.detailList.push({"key": "raccoltaTerminatingPDC", "value": "Raccolta Terminating PDC", "type": "text"});
               
        $scope.init = function(){
        	PuntiConsegna.get().$promise
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
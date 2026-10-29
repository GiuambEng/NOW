//RU_1078
timnow.controller('listaComuniInfratel', ['$scope', '$state', '$rootScope', 'ComuniInfratel', 'modalService',
    function ($scope, $state, $rootScope, ComuniInfratel, modalService) {

        $rootScope.pageClass = 'OLO Comuni Infratel';
        $scope.comuniInfratel = [];
        $scope.headerList = [];
        $scope.detailList = [];
        $scope.tipologia = $state.params.tipologia;
        
        $scope.headerList.push({"key": "codificaOloAgcom","value": "Codifica OLO Agcom ","type": "text"});
        $scope.headerList.push({"key": "codiceIstatComune","value": "Codice ISTAT","type": "text"});
        $scope.headerList.push({"key": "dataInizioValidita", "value": "Data Inizio Validita", "type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "dataFineValidita", "value": "Data Fine Validita", "type": "data", "pattern": "dd/MM/yyyy"});
             
        
        //Dettagli collapsible
        $scope.detailList.push({"key": "timestampInserimento", "value": "Timestamp Inserimento", "type": "text"});
        $scope.detailList.push({"key": "timestampAggiornamento", "value": "Timestamp Aggiornamento", "type": "text"});
        $scope.detailList.push({"key": "nota", "value": "Nota", "type": "text"});
        
        $scope.init = function() {
        	ComuniInfratel.get().$promise.then(function(response){
        		
                if (response.result.code < 0) {
                    modalService.alertSearchError();
                    return false;
                }
                if (response.data){
                	$scope.comuniInfratel = response.data;
                }        		
        		$scope.comuniInfratelLoaded = true;
        		
        	}, function(error){
        		 modalService.alertOkMessage(error.data.result.description);
        		 $scope.comuniInfratelLoaded = true;
        	});
           
        }


        
        $scope.init();
    }]);
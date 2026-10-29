//RU_1393
timnow
    .controller('associazioneOao', ['$scope', '$state', '$rootScope', 'modalService', 'GestioneAutonoma',
    	function ($scope, $state, $rootScope, modalService, GestioneAutonoma) {
	
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        //Campi tabella
        $scope.dati = [];
        $scope.datiLoaded = false;
        
        //RU_1447
        $scope.headerList = [];
        $scope.headerList.push({"key": "codOloAgcom", "value": "OLO", "type": "text"});
        $scope.headerList.push({"key": "codAreaDiCentrale", "value": "Area di Centrale", "type": "text"});
        $scope.headerList.push({"key": "codImpresa", "value": "Codice Impresa", "type": "text"});
        $scope.headerList.push({"key": "ragioneSociale", "value": "Ragione Sociale", "type": "text"});
        $scope.headerList.push({"key": "descrizioneTipologiaImpresa", "value": "Descrizione Tipologia Impresa", "type": "text"});
        $scope.headerList.push({"key": "presaAppuntamento", "value": "Presa appuntamento", "type": "text"});
        $scope.headerList.push({"key": "dataInizioValiditaProvisioning", "value": "Data Inizio Validita' Provisioning", "type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "dataFineValiditaProvisioning", "value": "Data Fine Validita' Provisioning", "type": "data", "pattern": "dd/MM/yyyy"});
                      
        $scope.init = function(){
        	GestioneAutonoma.associazioneOao.list().$promise
        	.then(function(response){
        		$scope.datiLoaded = true;          		
        		if(response.data){        			      			
        			$scope.dati = response.data;
        		}         		
        	}, function(error){
        		$scope.datiLoaded = true;
        		$scope.erroreService("Impossibile ricavare i dati. Riprovare piu' tardi.");
        	});
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
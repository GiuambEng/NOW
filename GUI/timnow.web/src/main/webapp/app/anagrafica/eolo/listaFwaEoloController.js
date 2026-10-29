//RU_1479
timnow
    .controller('listaFwaEolo', ['$scope', '$state', '$rootScope', 'modalService', 'AnagraficaFwaEolo',
    	function ($scope, $state, $rootScope, modalService, AnagraficaFwaEolo) {
        $rootScope.pageClass = 'Anagrafica VLAN FWA ITALIA 1GIGA SARDEGNA';
        $scope.gpon = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];
        $scope.detailList = [];
        $scope.storicoHeaderList = [];
        $scope.tipologia = $state.params.tipologia;
        $scope.tipologiaRicerca = $state.params.tipologia;
        
        $scope.headerList.push({"key": "codOloAgcom", "value": "Codifica Olo Agcom", "type": "text"});
        $scope.headerList.push({"key": "idVlanOlo", "value": "ID VLAN Olo", "type": "text"});
        $scope.headerList.push({"key": "svlanCode", "value": "SVLAN Code", "type": "text"});
        $scope.headerList.push({"key": "idVlanEolo", "value": "ID VLAN Eolo", "type": "text"});
        $scope.headerList.push({"key": "dataInizioValidita", "value": "Data Inizio Validita'", "type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "dataFineValidita", "value": "Data Fine Validita'", "type": "data", "pattern": "dd/MM/yyyy"});
       
        
        $scope.init = function(){        	
        	AnagraficaFwaEolo.list.get().$promise
        	.then(function(response){	
				$scope.datiLoaded = true;
				if (response.result.code < 0) {
                    modalService.alertSearchError();
                    return false;
                }
        		if(response.data){
        			$scope.vlanFwaEolo = response.data
        			
        		}
        	}, function(error){
        		$scope.datiLoaded = true;        		
        		$scope.erroreService("Errore nel recupero lista VLAN Eolo");
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
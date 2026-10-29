//RU_1485
timnow
    .controller('listaCodiciProgettoCatalogo', ['$scope', '$state', '$rootScope', 'modalService', 'AnagraficaCodiciProgettoCatalogo',
    	function ($scope, $state, $rootScope, modalService, AnagraficaCodiciProgettoCatalogo) {
        $rootScope.pageClass = 'Anagrafica Codici Progetto a Catalogo';
        $scope.serviziOpzionaliDefault = [];
        $scope.serviziOpzionaliAlternativi = [];
        $scope.datiLoaded = false;
        $scope.serviziDefaultHeaderList = [];
        $scope.serviziAlternativiHeaderList = [];
        $scope.tipologia = $state.params.tipologia;
        $scope.tipologiaRicerca = $state.params.tipologia;
        
              
        $scope.serviziDefaultHeaderList.push({"key": "codiceProgetto", "value": "Codice Progetto", "type": "text"});
        $scope.serviziDefaultHeaderList.push({"key": "codOloAgcom", "value": "Codifica Olo Agcom", "type": "text"});
        $scope.serviziDefaultHeaderList.push({"key": "offerta", "value": "Offerta", "type": "text"});
        $scope.serviziDefaultHeaderList.push({"key": "codiceAnagraficaServizioOpzionale", "value": "Codice Servizio Opzionale", "type": "text"});
        $scope.serviziDefaultHeaderList.push({"key": "descrizioneAnagraficaServizioOpzionale", "value": "Descrizione Servizio Opzionale", "type": "text"});
        $scope.serviziDefaultHeaderList.push({"key": "dataInizioValidita", "value": "Data Inizio Validita'", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.serviziDefaultHeaderList.push({"key": "dataFineValidita", "value": "Data Fine Validita'", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.serviziDefaultHeaderList.push({"key": "datiTecnici", "value": "Dati Tecnici", "type": "text"});
        $scope.serviziDefaultHeaderList.push({"key": "vincolanteEspletamento", "value": "Vincolante Espletamento", "type": "text"});
                
        $scope.serviziAlternativiHeaderList.push({"key": "codiceProgetto", "value": "Codice Progetto", "type": "text"});
        $scope.serviziAlternativiHeaderList.push({"key": "servizioOpzionalePadre", "value": "Servizio Opzionale Padre", "type": "text"});
        $scope.serviziAlternativiHeaderList.push({"key": "servizioOpzionaleAlternativo", "value": "Alternativo", "type": "text"});
        $scope.serviziAlternativiHeaderList.push({"key": "descrizioneAnagraficaServizioOpzionale", "value": "Descrizione Alternativo", "type": "text"});
        $scope.serviziAlternativiHeaderList.push({"key": "dataInizioValidita", "value": "Data Inizio Validita'", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.serviziAlternativiHeaderList.push({"key": "dataFineValidita", "value": "Data Fine Validita'", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.serviziAlternativiHeaderList.push({"key": "datiTecnici", "value": "Dati Tecnici", "type": "text"});
        $scope.serviziAlternativiHeaderList.push({"key": "vincolanteEspletamento", "value": "Vincolante Espletamento", "type": "text"});
        
        
        $scope.init = function(){      	
        	AnagraficaCodiciProgettoCatalogo.lists.get().$promise
        	.then(function(response){	
				$scope.datiLoaded = true;
				if (response.result.code == 'KO') {
                    modalService.alertSearchError();
                    return false;
                } else {
        			$scope.listaServiziOpzionaliDefault = response.listaServiziOpzionaliDefault || [];
        			$scope.listaServiziOpzionaliAlternativi = response.listaServiziOpzionaliAlternativi || [];
        			
        		}
        	}, function(error){
        		$scope.datiLoaded = true;        		
        		$scope.erroreService("Errore nel recupero liste Codici Progetto Catalogo");
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
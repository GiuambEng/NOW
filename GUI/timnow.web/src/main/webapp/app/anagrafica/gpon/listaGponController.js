//RU_1308
timnow
    .controller('listaGpon', ['$scope', '$state', '$rootScope', 'modalService', 'AnagraficaGpon',
    	function ($scope, $state, $rootScope, modalService, AnagraficaGpon) {
        $rootScope.pageClass = 'Anagrafica IDGPON';
        $scope.gpon = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];
        $scope.detailList = [];
        $scope.storicoHeaderList = [];
        $scope.tipologia = $state.params.tipologia;
        $scope.tipologiaRicerca = $state.params.tipologia;
        
        //RU_1338
        $scope.isUserDG = $rootScope.isDGUser();
              
        $scope.headerList.push({"key": "idGpon", "value": "Identificativo GPON", "type": "text"});
        $scope.headerList.push({"key": "puntoInterconnessione", "value": "Punto Interconnessione", "type": "text"});
        $scope.headerList.push({"key": "codificaOloAgcom", "value": "Codifica Olo Agcom", "type": "text"});
        $scope.headerList.push({"key": "codiceAreaCentrale", "value": "Codice Area Centrale", "type": "text"});
        $scope.headerList.push({"key": "dataFineValidita", "value": "Data Fine Validita'", "type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "tipoAccesso", "value": "Tipo Accesso", "type": "text"});
        $scope.headerList.push({"key": "coinvestimento", "value": "Coinvestimento", "type": "text"});
        
        //Dettagli collapsible
        $scope.detailList.push({"key": "timestampInserimento", "value": "Timestamp Inserimento", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.detailList.push({"key": "timestampAggiornamento", "value": "Timestamp Aggiornamento", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.detailList.push({"key": "idFileProcstoInput", "value": "Identificativo File Processato Input", "type": "text"});
        $scope.detailList.push({"key": "numeroRecord", "value": "Numero Record", "type": "text"});
        
        //RU_1338
        $scope.storicoHeaderList.push({"key": "fattoreDiSplittingAttuale", "value": "Fattore di splitting attuale", "type": "text"});
        $scope.storicoHeaderList.push({"key": "fattoreDiSplittingOld", "value": "Fattore di splitting old", "type": "text"});
        $scope.storicoHeaderList.push({"key": "dataFineRegistrazioneFattoreSplitting", "value": "Data fine registrazione fattore di splitting", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.storicoHeaderList.push({"key": "dataRegistrazioneFattoreSplitting", "value": "Data registrazione fattore di splitting", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        
        
        $scope.init = function(){        	
        	AnagraficaGpon.list.get().$promise
        	.then(function(response){	
				$scope.datiLoaded = true;
				if (response.result.code < 0) {
                    modalService.alertSearchError();
                    return false;
                }
        		if(response.data){
        			$scope.gpon = response.data
        			
        		}
        	}, function(error){
        		$scope.datiLoaded = true;        		
        		$scope.erroreService("Errore nel recupero lista ID GPON");
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
        
       	//RU_1338
		$scope.oscuramento_RU_1338 = function(){
			$scope.RU_1338 = !$rootScope.OSCURAMENTI.RU_1338.oscurato;
		}	
		
		//Pulsante di 'Storico Splitting' visibile solo ad utenze di tipo CRM_DG*
		$scope.setShowCampiStoricoSplitting = function(){
			if($scope.RU_1338){
				$scope.headerList.push({"key": "fattoreDiSplitting", "value": "Fattore di Splitting", "type": "text"});
				$scope.headerList.push({"key": "idGponValido", "value": "ID GPON Valido", "type": "text"});
				$scope.detailList.push({"key": "dataRegistrazioneFattoreSplitting", "value": "Data Registrazione Fattore di Splitting", "type": "data", "pattern": "dd/MM/yyyy"});
				if($scope.isUserDG){
					$scope.headerList.push({"key": "idGpon", "value": "", "type": "storicoIdGpon"});
				}
			}
		}
	
		$scope.callbackShowStorico = function(item){
	        var _modalConfig = {
	             headerText: 'Storico Splitting per IDGPON ' + item.idGpon,
	             actionButtonText: null,
	             closeButtonText: 'Ok',
	             contentType: 'modale_nowtable',
	             scope: $scope,
	             dataHeader: $scope.storicoHeaderList,
	             data: $scope.arrayStoricoIdGpon
	         };
	         modalService.showModal({}, _modalConfig);
		}
		
		$scope.showStoricoIdGpon = function(item){
			$scope.arrayStoricoIdGpon = [];
						
			AnagraficaGpon.storicoSplitting.get({idGpon: item.idGpon}).$promise
				.then(function(response){
					if(response.data && response.data.length > 0){						
						angular.copy(response.data, $scope.arrayStoricoIdGpon);
					}
					$scope.callbackShowStorico(item);
				}, function(error){
					$scope.erroreService("Errore nel recupero Storico Splitting IDGPON");
				});
		}
		
		$scope.oscuramento_RU_1338();
		$scope.setShowCampiStoricoSplitting();
        
        $scope.init();
        
    }]);
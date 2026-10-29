//RU_1335
timnow.controller('modificaFwaWillDeco', ['$scope', '$state', '$rootScope', 'RisorseFwaWillDeco', 'modalService', 'TRACKING_GUI', 'TrackingGUI',
	function ($scope, $state, $rootScope, RisorseFwaWillDeco, modalService, TRACKING_GUI, TrackingGUI) {

	$rootScope.pageClass = $state.current.params.pageClass;
	
	$scope.idRisorsa = $state.params.idRisorsa;
	$scope.loadDettaglio = true;
	$scope.showLoader = false;
	
	$scope.dataSwitchOff = new Date();
	$scope.altInputFormats = "dd/MM/yyyy";

	$scope.back = function () {
		$state.go("root.anagrafica.fwaWillDeco");
	};

	$scope.init = function(){
		$scope.risorsa = {};
		
		RisorseFwaWillDeco.details.get({idRisorsa: $scope.idRisorsa}).$promise  	
		.then(function(response){
			
			$scope.loadDettaglio = false;
			if (response && response.result.code === 'OK') {
				$scope.risorsa = response.dettaglioRisorsa;
				$scope.risorsa.dataScadenzaSwitchOff = new Date(response.dettaglioRisorsa.dataScadenzaSwitchOff);
				$scope.configureDataScadenzaSwitchoffOptions();
			}else{
				$scope.erroreService("Errore nel recupero dettaglio Risorsa FWA");
			}	
			
		}, function(error){			
			$scope.loadDettaglio = false;
			$scope.erroreService("Errore nel recupero dettaglio Risorsa FWA");
		});    	
	}
	
	/**
	 * Configurazione opzioni Data Scadenza Switchoff
	 */
	$scope.configureDataScadenzaSwitchoffOptions = function(){	
		$scope.dataScadenzaSwitchoffConfig = {
				formats: ['dd/MM/yyyy'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				dateOptions: {
					formatYear: 'yy',
					minDate: new Date(),
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				}
		};
	}
	
		$scope.submit = function () {
        modalService.showModal({}, {
            headerText: "Conferma",
            closeButtonText: 'Annulla',
            bodyText: "Modificare la risorsa ?",
            actionButtonText: 'Ok',
            scope: $scope,
            callbackFunction: 'confirmSaveCallback',
            type: 'success'
        });
    }
    
    $scope.confirmSaveCallback = function(){
		$scope.showLoader = true;
		
		var _request = angular.copy($scope.risorsa);
		
		_request.dataScadenzaSwitchOff = moment($scope.risorsa.dataScadenzaSwitchOff).format();		
		
		var _trackBean = {
			timestampInizio: new Date().toISOString(),
			timestampFine: null,
			numeroDatiEsportati: 0,
			contenutoFile: null,
			nomeFile: null,
			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
			parametriOperazione: null,
			descrizioneFunzione: 'Anagrafiche|Risorse FWA WILL Deco|Modifica Risorsa'
		};
		
		RisorseFwaWillDeco.edit.save(_request).$promise
		.then(function(response){
			$scope.showLoader = false;
			
			if (response && response.result.code === 'OK') {
				$scope.erroreService("Risorsa aggiornata con successo.");
				_trackBean.timestampFine = new Date().toISOString();
				_trackBean.esito = 'Ok';
				TrackingGUI.tracking(_trackBean);
				$scope.back();
			}else{
				if(response && response.result && response.result.code === 'KO') {
					$scope.erroreService(response.result.details);
				}else{
					$scope.erroreService("Impossibile completare l'operazione. Riprovare piu' tardi");
				}
			}			
		}, function(error){
			$scope.showLoader = false;
			$scope.erroreService("Impossibile completare l'operazione. Riprovare piu' tardi");
			_trackBean.timestampFine = new Date().toISOString();
			_trackBean.esito = 'Ok';
			TrackingGUI.tracking(_trackBean);
		})	
	}
	
	$scope.erroreService = function (messageBody) {
		modalService.showModal({}, {
			headerText: "Avviso",
			bodyText: messageBody,
			scope: $scope,
			type: 'success'
		});
		$scope.caricaPassFive = false;
	}
	
	$scope.init();
}]);
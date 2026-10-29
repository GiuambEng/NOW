timnow
.controller('visualizzazioneConsistenzaNpng', ['$scope', '$state', '$rootScope','modalService', '$q', 'IDsrolo', 'DettaglioAssetNpng', 'CambioOloNpng', 'alertService',
	function ($scope, $state, $rootScope, modalService, $q, IDsrolo, DettaglioAssetNpng, CambioOloNpng, alertService) {


	$scope.init = function() {

		$scope.loadStep2 = true;
		$scope.loadRisorsaNpng = true;
		$scope.showLoader = false;
		$scope.dataCutOver = "";
		
        if(!$rootScope.data){
        	$rootScope.data = {};
        }
        
        if(!$rootScope.data.step2){
        	$rootScope.data.step2 = {};
        }

        if ($rootScope.data && $rootScope.data.step2) {
            $scope.data.step2 = $rootScope.data.step2;
        }
        
        if(!$scope.data && !$scope.data.step2){
        	$scope.data = {}
        	$scope.data.step2 = {};
        }
        
        $scope.configureDataCutOver();


		$q.all([IDsrolo.get({noDiffida: false}).$promise,
			DettaglioAssetNpng.get({idAsset: $state.params.idOrdine}).$promise])
			.then(function(responses){

				var _message = null;

				if(responses[0] && responses[0].result && responses[0].result.code.toUpperCase() == 'KO'){
					_messge = responses[0].result.message;
				}else{
					$scope.listaOlo = responses[0].data;
				}
				if(responses[1] && responses[1].result && responses[1].result.code.toUpperCase() == 'KO'){
					_messge = responses[1].result.message;
				}else{
					$scope.data.step2 = responses[1].dettaglioAssetNPNG;
				}

				if(_message){
					modalService
					.showModal({}, {
						headerText: "Errore",
						bodyText: _message,
						actionButtonText: 'Chiudi',
						type: 'warning'
					});

					$scope.loadRisorsaNpng = false;
					return;
				}

				$scope.data.step2.nuovoOlo = {};

				$scope.loadRisorsaNpng = false;		

			}, function(error){
				$scope.loadRisorsaNpng = false;	
				modalService
				.showModal({}, {
					headerText: "Errore",
					bodyText: "Errore nel caricamento lista OLO e dettaglio risorsa",
					actionButtonText: 'Chiudi',
					type: 'warning'
				});
			});          
	}       

	/*
	 * Configurazione Data Cut Over
	 */

	$scope.configureDataCutOver = function(){
		$scope.dataCutOverConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				disabled: function(data){ //disabilita i weekend
					var date = data.date, mode = data.mode;
					return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
				},
				dateOptions: {
					dateDisabled: this.disabled,
					formatYear: 'yyyy',
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				}
		};
	}

	$scope.validazioneForm = function(){
		var _app = $scope.data.step2;

		if(_app){
			if(_app.stato != "ATTIVO"){
				alertService.add("Risorsa non attiva","danger",10000);
				return false;
			}  
			if(_app.olo == _app.nuovoOlo.olo){
				alertService.add("Olo non modificato","danger",10000);
				return false;
			}
		}        	
		return true;
	}
	
	$scope.submit_2 = function(){
		if($scope.validazioneForm()){
    	modalService.showModal(
    			{},
    			{
    				headerText: "Avviso",
    				closeButtonText: 'Annulla',
    				actionButtonText: 'Conferma',
    				bodyText: "ATTENZIONE si sta procedendo alla modifica della consistenza di NPNG per la risorsa selezionata",
    				scope: $scope,
    				callbackFunction: '_submit_2',
    				type: 'success'
    			});
		}
	}

	$scope._submit_2 = function(){
		$scope.showLoader = true;
		
		//trasformazione data nel formato dd/MM/yyyy
		$scope.data.step2.nuovoOlo.dataCutOver = "";
		$scope.data.step2.nuovoOlo.dataCutOver = $scope.dataCutOver.toLocaleDateString();
		
		CambioOloNpng.save($scope.data.step2).$promise
		.then(function(response){
			if(response && response.result && response.result.code.toUpperCase() == 'OK'){	
				$scope.showLoader = false;
				$state.go('root.ordini.npng.cambioOlo.conferma', {init: false});
			}
			else{
				$scope.showLoader = false;
				modalService
				.showModal({}, {
					headerText: "Errore",
					bodyText: response.result.message,
					actionButtonText: 'Chiudi',
					type: 'warning'
				});
			}
		}, function(error){
			$scope.showLoader = false;
			modalService
			.showModal({}, {
				headerText: "Errore",
				bodyText: "Errore servizio Cambio OLO",
				actionButtonText: 'Chiudi',
				type: 'warning'
			});
		});
	}
	
	$scope.indietro = function(){
    	$state.go('root.ordini.npng.cambioOlo.step1', {init: false});
    }
    
    $scope.annulla = function () {
        modalService.showModal(
            {},
            {
                headerText: "Vuoi annullare la lavorazione ?",
                closeButtonText: 'Chiudi',
                bodyText: "I dati inseriti nell'ordine saranno cancellati.",
                actionButtonText: 'Continua',
                scope: $scope,
                callbackFunction: 'confermaAnnulla',
                type: 'success'
            });
        $scope.caricaPassFive = false;
    };

    $scope.confermaAnnulla = function () {
        $rootScope.formData = {};
        $rootScope.data = {};
        $state.params.order = null;
        $state.go('root.homepage');
    };

	$scope.init(); 
	
	$scope.$watch('olo', function(newValue, oldValue){
		if(newValue){
			$scope.data.step2.nuovoOlo.olo = newValue.codiceOLO;
		}
	});

}]);

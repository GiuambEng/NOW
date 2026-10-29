timnow
    .controller('ricercaRisorsaNpng', ['$scope', '$state', '$rootScope', 'modalService', 'RicercaAssetNpng',
    	function ($scope, $state, $rootScope, modalService, RicercaAssetNpng) {

        $scope.headersTabellaNumeriNpng = [
             {"key": "olo", "value": "OLO", "type": "text"},
             {"key": "codOrdineOlo", "value": "Codice Ordine OLO", "type": "text"},
             {"key": "codOrdineTi", "value": "Codice Ordine TI", "type": "text"},
             {"key": "dn", "value": "DN", "type": "text"},
             {"key": "stato", "value": "Stato", "type": "text"}
        ];  
        
        $scope.modalOptionsTabellaNumeriNpng = {
                headerText: 'Seleziona una risorsa',
                actionButtonText: null,
                closeButtonText: 'Ok',
                contentType: 'modale_nowtable',
                scope: $scope,
                callbackFunction: 'callbackRicercaNpng',
                dataHeader: $scope.headersTabellaNumeriNpng,
                templateUrl: 'app/common/templates.html'
            };
    	
    	
        $scope.init = function() {        	
            $scope.loadStep1 = true;  
            
            if(!$rootScope.data){
            	$rootScope.data = {};
            }
            
            if(!$rootScope.data.step1){
            	$rootScope.data.step1 = {};
            }
            
            if ($rootScope.data && $rootScope.data.step1) {
                $scope.data.step1 = $rootScope.data.step1;
            }
            
            if(!$scope.data || !$scope.data.step1){
            	$scope.data = {}
            	$scope.data.step1 = {};
            }
        }    
        
        $scope.callbackRicercaNpng = function(itemSelected){
        	$scope.data.step1.npngSelected = itemSelected;        	
            $rootScope.data.step1 = $scope.data.step1;
            $state.go('root.ordini.npng.cambioOlo.step2', {idOrdine: itemSelected.idOrdine}); 
        }
		
        $scope.submit_1 = function () {        	 
        	
        	var _request = {
        		dn: ($scope.data.step1.dn || null)
        	};
        	
        	RicercaAssetNpng.get(_request).$promise
        	.then(function(response){
        		if(response && response.result.code.toUpperCase() == "OK"){        			
        			$scope.modalOptionsTabellaNumeriNpng.data = (response.ricercaOrdiniOutput || []);        			
        			modalService.showModal({}, $scope.modalOptionsTabellaNumeriNpng);       			
        		}else{
        			modalService
                    .showModal({}, {
                        headerText: "Avviso",
                        bodyText: "Errore ricerca Asset NPNG",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
        		}
        	}, function(error){        		
                modalService
                .showModal({}, {
                    headerText: "Errore",
                    bodyText: "Errore ricerca Asset NPNG",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
        	})         
        };        
        
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

    }]);

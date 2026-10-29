//RU_1203
timnow
    .controller('editNpng', ['$scope', '$state', '$rootScope', 'modalService', 'RecuperoCampiNpng', 'UpsertOpzioneTrafficoNpng',
    	function ($scope, $state, $rootScope, modalService, RecuperoCampiNpng, UpsertOpzioneTrafficoNpng) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        $scope.number = ($state.params.number || null);
        
        $scope.init = function(){        	
        	$scope.number = ($state.params.number || null);   
        	$scope.initDateModels();
        	$scope.configureDataFineValidita();        	
        }
        
        $scope.initDateModels = function(){
        	if($scope.number){
        		if($scope.number.dataInizioValidita){
        			$scope.dataInizio = new Date($scope.number.dataInizioValidita);
        		}
        		
        		if($scope.number.dataFineValidita){
        			$scope.dataFine = new Date($scope.number.dataFineValidita);
        		}
        	}
        }
        
    	/*
    	 * Configurazione Data Fine Validità
    	 */

    	$scope.configureDataFineValidita = function(){
    		$scope.dataFineValiditaConfig = {
    				formats: ['dd/MM/yyyy', 'shortDate'],
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
    	
    	$scope.annulla = function(){
    		$state.go("root.anagrafica.npng");
    	}
    	
    	$scope.convertDateModelsForRequest = function(){
    		if($scope.dataInizio){
    			$scope.number.dataInizioValidita = $scope.dataInizio.toISOString().split('T')[0];
    		}
    		if($scope.dataFine){
    			$scope.number.dataFineValidita = $scope.dataFine.toISOString().split('T')[0];
    		}
    	}
    	
    	$scope.submit = function(){
    		
    		var _app = $scope.number;
    		
    		if($scope.dataInizio){
    			if($scope.dataInizio.getTime() > $scope.dataFine.getTime()){    				
                    modalService.showModal({}, {
                        headerText: "Errore",
                        bodyText: "Date incongruenti",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                    
                    return;
    			}
    			
    			$scope.convertDateModelsForRequest(); 
    			
    			_app = $scope.number;
    			
    			UpsertOpzioneTrafficoNpng.save(_app).$promise
    			.then(function(response){
    				if(response.esito.toUpperCase() == 'KO'){
                        modalService.showModal({}, {
                            headerText: "Errore",
                            bodyText: response.result.message,
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
    				}else{
                        modalService.showModal({}, {
                            headerText: "Avviso",
                            bodyText: "Modifica effettuata con successo",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                        $state.go("root.anagrafica.npng");
    				}
    			}, function(error){
                    modalService.showModal({}, {
                        headerText: "Errore",
                        bodyText: "Errore su modifica numerazione NPNG",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
    			});
    		}
    	}
        
        $scope.init();
        
    }]);
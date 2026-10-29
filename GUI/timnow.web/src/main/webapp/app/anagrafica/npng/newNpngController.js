//RU_1203
timnow
    .controller('newNpng', ['$scope', '$state', '$rootScope', 'modalService', 'RecuperoCampiNpng', 'UpsertOpzioneTrafficoNpng', '_',
    	function ($scope, $state, $rootScope, modalService, RecuperoCampiNpng, UpsertOpzioneTrafficoNpng, _) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        
        $scope.init = function(){
        	
        	RecuperoCampiNpng.get().$promise
        	.then(function(result){
        		if(result && result.campiAnagraficaNPNG){
        			$scope.campi = result.campiAnagraficaNPNG;
        			$scope.configurePrefissi();
        			$scope.configureOpzioneTraffico();
        		}
        	}, function(error){
        		$scope.numbersLoaded = true;
        		modalService
                .showModal({}, {
                    headerText: "Errore",
                    bodyText: "Errore recupero campi",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
        	});
        	
        	$scope.number = {};
        	$scope.opzTrafficoSelected = {};
        	$scope.configureDataInizioValidita();
        	$scope.configureDataFineValidita();
        	
        }
        
        /*
         * Configurazione Prefissi
         */
        
        $scope.configurePrefissi = function(){        	
        	$scope.listaPrefissi = [];
        	var _prefissi =  $scope.campi.listaPrefissi;
        	
        	if(_prefissi && _prefissi.length > 0){
        		$scope.listaPrefissi = _prefissi;
        	} 
        }
        
        /*
         * Configurazione Prefissi
         */
        
        $scope.configureOpzioneTraffico = function(){        	
        	$scope.listaOpzioneTraffico = [];
        	var _opzioneTraffico =  $scope.campi.listaOpzioneTraffico;
        	
        	if(_opzioneTraffico && _opzioneTraffico.length > 0){
        		$scope.listaOpzioneTraffico = _opzioneTraffico;
        	} 
        }
        
        
    	/*
    	 * Configurazione Data Inizio Validità
    	 */

    	$scope.configureDataInizioValidita = function(){
    		$scope.dataInizioValiditaConfig = {
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
    	
    	$scope.submit = function(){
    		
    		var _app = $scope.number;
    		
    		if(_app.dataInizioValidita){
    			if(_app.dataInizioValidita.getTime() > _app.dataFineValidita.getTime()){    				
                    modalService.showModal({}, {
                        headerText: "Errore",
                        bodyText: "Date incongruenti",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                    
                    return;
    			}
    			
    			UpsertOpzioneTrafficoNpng.save(_app).$promise
    			.then(function(response){
    				if(response.result.code.toUpperCase() == 'KO'){
                        modalService.showModal({}, {
                            headerText: "Errore",
                            bodyText: response.result.message,
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
    				}else{
                        modalService.showModal({}, {
                            headerText: "Avviso",
                            bodyText: "Inserimento effettuato con successo",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                        $state.go("root.anagrafica.npng");
    				}
    			}, function(error){
    				
    			});
    		}
    	}
        
    	$scope.$watch('opzTrafficoSelected', function(newValue, oldValue){
    		if(newValue && !_.isEmpty(newValue)){
    			$scope.number.idOpzTraffico = newValue.idOpzTraffico;
    		}
    	})
    	
        $scope.init();
        
    }]);
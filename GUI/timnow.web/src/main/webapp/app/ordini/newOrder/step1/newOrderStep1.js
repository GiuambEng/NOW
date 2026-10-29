timnow
    .controller('newOrderStep1', ['$scope', '$state', '$rootScope', '$log', '$q', 'Addresses', 'IDsrolo', 'Contracts', 'Projects', function ($scope, $state, $rootScope, $log, $q, Addresses, IDsrolo, Contracts, Projects) {
    	$scope.controlAssetOAO = function(){
   		 if ($state.params.asset && ($state.params.asset.oao || $state.params.asset.codificaOao)) {
            	$scope.loadOAO = true;
            	$scope.data.step1={};
            	$scope.data.step1.variazioneAsset=$state.params.asset;
            	$scope.data.step1.causale_ordine="variazione";
            	angular.forEach($rootScope.formData.idsrolo, function (value) {
                    if ((value.codiceOLO === $scope.data.step1.variazioneAsset.oao) ||
                   		 (value.codiceOLO === $state.params.asset.codificaOao)) {
                    	$scope.data.step1.operatore = value;
                    	$scope.loadDataForOlo()
                    }
                });
            	if(!$scope.data.step1.operatore){
          		 $scope.loadOAO = false;
                  $scope.erroreService("OAO non valido o non attivo.");
            	}
            }
    	};
        function init() {
            $scope.lettura1 = false;
            $scope.loadStep1 = true;
            $scope.loadOLO = true;            
            
            if ($rootScope.data.step1) {
                $scope.data.step1 = $rootScope.data.step1;
                $scope.loadStep1 = false;
                $scope.loadOLO = false;
            }
            
            //RU_1180
            if(!$scope.data.step1){
            	$scope.data.step1 = {};
            }
            
            $scope.data.step1.primoFeeder = ($rootScope.primoFeeder ? $rootScope.primoFeeder : false);
            $scope.data.step1.secondoFeeder = ($rootScope.secondoFeeder ? $rootScope.secondoFeeder : false);            
            $scope.data.step1.isFeederOrder = ($rootScope.isFeederOrder ? $rootScope.isFeederOrder : false);


            Addresses.get({type:"provinces"}).$promise.then(
                function (response) {
                    $rootScope.formData.provinces = response.items;
                }
            );

            IDsrolo.get({noDiffida: false}).$promise.then(
                function (response) {
                    $scope.loadOLO = false;
                    $rootScope.formData.idsrolo = response.data;
                    $scope.controlAssetOAO();
                },
                function () {
                    $scope.loadOLO = false;
                    $scope.erroreService("Errore durante il caricamento degli OAO. Riprovare più tardi");
                }
            );

            if ($rootScope.bozza) {
                $scope.data.step1 = $rootScope.bozza.data.step1;
                
                $scope.lettura1 = true;
                if(!$rootScope.formData.idsrolo){
                	$scope.loadDataForOlo();
                }
            }
            
           
        }
        
        $scope.cambiaCasualeOrdine= function () {
        	if($rootScope.formData && $rootScope.formData.step2){
        		$rootScope.formData.step2 ={}; 
        		$rootScope.formData.step3 ={}; 
        		$rootScope.formData.step4 ={}; 
        		$rootScope.formData.step5 ={}; 
        		$rootScope.formData.step6 ={}; 
        		$rootScope.formData.step7 ={}; 
        		$rootScope.formData.step8 ={};
        		$scope.data.step2 = null;
        		$scope.data.step3 = null;
        		$scope.data.step4 = null;
        		$scope.data.step5 = null;
        		$scope.data.step6 = null;
        		$scope.data.step7 = null;
        		$rootScope.data.step2 = null; 
        		$rootScope.data.step3 = null; 
        		$rootScope.data.step4 = null; 
        		$rootScope.data.step5 = null; 
        		$rootScope.data.step6 = null; 
        		$rootScope.data.step7 = null;
        		$rootScope.formData.stepReached = 1;
        	}
        	
        };
        
        $scope.getContractsForOlo = function () {
        	
        	//RU_1180        	
        	var _request = {
        		codOlo: $scope.codiceOLO        			
        	};       
            
            if($rootScope.isFeederOrder){
            	_request.flagMulticast = 'Y'
            }
            
            $scope.p1 = Contracts.get(_request).$promise.then(
                function (response) {
                    $rootScope.formData.contracts = filtraContrattiByRU(response.data);
                    $scope.loadStep1 = false;
                },
                function () {
                    $scope.erroreService("Impossibile caricare i contratti. Riprovare più tardi");
                    $scope.loadStep1 = true;
                }
            );
        };
        
        // utility per filtrare i contratti in base alle RU (utile per quando una RU introduce nuovi tipi di contratto)
        filtraContrattiByRU = function(contracts) {
			if($rootScope.OSCURAMENTI.RU_1581.oscurato) {
				contracts = contracts.filter(p => $rootScope.OSCURAMENTI.RU_1581.nomiStandardfferteValide.indexOf(p.nomeStandard) == -1);
			}
			return contracts;
		}

        $scope.getPropjectsForOlo = function () {
            var projects = Projects.get({
                codOlo: $scope.codiceOLO
            });
            $scope.p2 = projects.$promise.then(
                function (response) {
                    $rootScope.formData.projects = response.data;
                },
                function () {
                    $log.debug("Impossibile caricare i progetti per l'OAO selezionato.");
                }
            );
        };

        $scope.loadDataForOlo = function () {
        	$scope.cambiaCasualeOrdine();
            $scope.loadOAO = true;
            if ($rootScope.data.step1) {
                $scope.codiceOLO = $rootScope.data.step1.operatore.codiceOLO;
            } else if ($scope.data.step1.operatore) {
                $scope.codiceOLO = $scope.data.step1.operatore.codiceOLO;
            } else {
                $scope.codiceOLO = null;
            }

            if ($rootScope.data.step1 || $scope.data.step1.operatore) {
                $scope.getContractsForOlo();
                $scope.getPropjectsForOlo();

                $q.all(
                    [$scope.p1.then(), $scope.p2.then()]).then(
                    function () {
                        $scope.loadOAO = false;
                    }, function () {
                        $scope.loadOAO = false;
                    }
                );
                //$log.info($rootScope.formData);
            }
        }
        
        $scope.setBackFromDetails = function(){
			$scope.backFromDetails = ($state.includes('**.dettaglio.**'));
		}
		
		$scope.backState = function(){
			////////
            var _state = "";
            if($state.includes('**.listareport.**')){
				_state = "root.ordini.listareport.dettaglio.asset";
			}else{
				_state = "root.ordini.lista.dettaglio";
			}		
			$state.go(_state);
		}
        
       	$scope.setBackFromDetails();        
        init(); 

// 		PASSAGGIO AL SECONDO STEP		
        $scope.submit_1 = function () {
            $rootScope.data.step1 = $scope.data.step1;

            $scope.data.data_creazione = $rootScope.timnowConfigData.config.today;
            if (!$rootScope.formData.data) {
                $rootScope.formData.data = {};
            }
            $rootScope.formData.data.step1 = $rootScope.data.step1;

            if ($scope.data.step1.causale_ordine === 'attivazione' || $scope.data.step1.causale_ordine === 'variazione' || $scope.data.step1.causale_ordine === 'migrazione') {
                $state.go($scope.checkNextState());
                $scope.controlloBozza(2);
            } else if ($scope.data.step1.causale_ordine === 'cessazione') {
                $state.go('root.ordini.new.cessazione.step2');
            }
        };

    }]);

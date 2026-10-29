//RU_1058
timnow.controller('vpAttivazioneStep7', ['$scope', '$state', '$rootScope', 'RecuperaCampiOffertaVP', 'VerificaCodiceTDKit', '$q', 'modalService',
	function ($scope, $state, $rootScope, RecuperaCampiOffertaVP, VerificaCodiceTDKit, $q, modalService) {
	
	$scope.arrayCodiceTDKit = [];
	$scope.arrayMacroArea = [];
	$scope.arrayClliCentrale = [];
	
	//SM_9825
	$scope.headerTabellaTdKit = [];
	$scope.headerTabellaTdKit.push({"key": "codiceKit","value": "Codice TD kit","type": "text"});
	$scope.headerTabellaTdKit.push({"key": "clliCentrale","value": "CLLI","type": "text"});
    
	if (!$rootScope.data.step7) {
        $rootScope.data.step7 = $scope.data.step7 = {};
    }
	
	$scope._codOloAgcom = ($scope.data.step1.operatore.codiceOLO || null);
    
    $scope.init = function(){  
        	$scope.configureMacroArea();
    }
	
	/**
	 * 	Per CodiceTDKit
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
    
   
	$scope.configureCodiceTDKit = function(event){
		
		event.preventDefault();
		
		var _request = {
			nomeCampo: 'CODICETDKIT',
			valoreCampo:  $scope._codOloAgcom
		};
		
		$scope.arrayCodiceTDKit = [];
		$scope.loadingCodiceTDKit = true;
		
		RecuperaCampiOffertaVP.save({}, _request).$promise
		.then(function(data){
			$scope.loadingCodiceTDKit = false;
			if(data.outputCampiOffertaVP && data.outputCampiOffertaVP.length > 0){									
				angular.copy(data.outputCampiOffertaVP, $scope.arrayCodiceTDKit);
			}
			$scope.selectCodiceTdKit();
		}, function(error){
			$scope.loadingCodiceTDKit = false;
			$scope.erroreService("Errore nel recupero dati Codice TDKit");
		});
	}
	
	$scope.selectCodiceTdKit = function(){
        var _modalConfig = {
             headerText: 'Seleziona Codice TD Kit',
             actionButtonText: null,
             closeButtonText: 'Ok',
             contentType: 'modale_nowtable',
             scope: $scope,
             callbackFunction: 'callbackSelectCodiceTdKit',
             dataHeader: $scope.headerTabellaTdKit,
             data: $scope.arrayCodiceTDKit
         };
         modalService.showModal({}, _modalConfig);
	}
	
	$scope.callbackSelectCodiceTdKit = function(item){
		$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = item.codiceKit;
	}
	
	/**
	 * 	Per MacroArea
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureMacroArea= function(){
		
		var _request = {
			nomeCampo: 'MACROAREA'
		};
		
		RecuperaCampiOffertaVP.save({}, _request).$promise
			.then(function(data){
				if(data.outputCampiOffertaVP){
					angular.copy(data.outputCampiOffertaVP, $scope.arrayMacroArea);
				}
			}, function(error){
				$scope.erroreService("Errore su recupero valori MacroArea");
			});
	}	
	
	/**
	 * Per CLLICentrale
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureClliCentrale = function(){		
		
		var _request = {
				nomeCampo: 'CODICECLLI',
				valoreCampo: $scope.data.step7.macroArea
		};
		
		RecuperaCampiOffertaVP.save({}, _request).$promise
		.then(function(data){
			if(data.outputCampiOffertaVP){
				var _array = data.outputCampiOffertaVP.map(function(item) {return item.clliCentrale;});
				angular.copy(_array, $scope.arrayClliCentrale);
			}
		}, function(error){
			$scope.erroreService("Errore su recupero valori CLLICentrale");
		});
	}
	
	
	// C11M08F77 - Verifica Area Raccolta VP LITE
	$scope.C11M08F77 = function(){
		var _request = {
			codiceTdKit: $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft,
			codiceFunzione: 'C11M08F77'
		};		
		
		return VerificaCodiceTDKit.save({}, _request).$promise;
	}
    
	// C11M08F76 – Verifica Limite massimo VP nel kit.
	$scope.C11M08F76 = function(){
		var _request = {
			codiceTdKit: $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft,
			codiceFunzione: 'C11M08F76'
		};		
		
		return VerificaCodiceTDKit.save({}, _request).$promise;
	}

        
    $scope.submitFormVlan = function (event) {
    	
    	event.preventDefault();
    	
    	//Elimina le strutture dati provenienti dal controller padre 
    	if($scope.data.step7.datiAppuntamentoDisaggregazione){
    		delete $scope.data.step7.datiAppuntamentoDisaggregazione;
    	}
    	if($scope.data.step7.datiDisaggregazione){
    		delete $scope.data.step7.datiDisaggregazione;
    	}
    	if($scope.data.step7.datiPrestazioniAggiuntive){
    		delete $scope.data.step7.datiPrestazioniAggiuntive;
    	}
    	if($scope.data.step7.datiServiziOpzionali){
    		delete $scope.data.step7.datiServiziOpzionali;
    	}
    	if($scope.data.step7.datiSlaPlusSu){
    		delete $scope.data.step7.datiSlaPlusSu;
    	}
    	
    	$rootScope.formData.data.step7 = $rootScope.data.step7 = $scope.data.step7;
    	
    	$q.all([$scope.C11M08F76(), $scope.C11M08F77()])
    		.then(function(responses){
    			if(responses[0].ControlliCodiceTDKitOutput.esito == 'KO'){
    				$scope.erroreService(responses[0].messaggio);
    			}else if(responses[1].ControlliCodiceTDKitOutput.esito == 'KO'){
    				$scope.erroreService(responses[1].messaggio);
    			}else{
    				$state.go($scope.checkNextState());	
    			}
    		}, function(error){
    			$scope.erroreService(error.messaggio);
    		});              
    };
    
    $scope.cleanMacroArea = function(){
    	$scope.data.step7.macroAreaJson = "";
		$scope.data.step7.macroAreaObject = "";
		$scope.data.step7.macroArea = "";
    }
    
    $scope.cleanClliCentrale = function(){
    	if($rootScope.customizedOffer.offerTopDetails.CODICECLLI){
    		$rootScope.customizedOffer.offerTopDetails.CODICECLLI.dft = "";
    	}
    }
    
    $scope.init();
    
    $scope.$watch("data.step7.macroAreaJson", function(newValue, oldValue){
    	if(newValue){
    		$scope.data.step7.macroAreaObject = JSON.parse($scope.data.step7.macroAreaJson);
    		$scope.data.step7.macroArea = $scope.data.step7.macroAreaObject.idAdrCrmws;
    	}        
    });
    
    $scope.$watch("data.step7.macroArea", function(newValue, oldValue){
    	if(newValue){
    		if(newValue != oldValue){
    			$scope.cleanClliCentrale();
    		}
    		$scope.configureClliCentrale();
    	}        
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.CODICETDKIT.dft", function(newValue, oldValue){
    	if(newValue){
    		if(newValue != oldValue){
    			$scope.cleanMacroArea();
    			$scope.cleanClliCentrale();
    		}
    		
    		$scope.configureMacroArea();
    	}        
    });
      
}]);  
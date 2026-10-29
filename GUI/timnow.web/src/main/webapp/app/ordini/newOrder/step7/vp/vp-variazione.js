//RU_1058
timnow.controller('vpVariazioneStep7', ['$scope', '$state', '$rootScope', 'VerificaCodiceTDKit', 'Locator',
	function ($scope, $state, $rootScope, VerificaCodiceTDKit, Locator) {
	
	if (!$rootScope.data.step7) {
        $rootScope.data.step7 = $scope.data.step7 = {};
    }
	  
	// C11M08F77 - Verifica Area Raccolta VP LITE
	$scope.C11M08F77 = function(){
		var _request = {
			codiceTdKit: $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft,
			codiceFunzione: 'C11M08F77'
		};		
		
		return VerificaCodiceTDKit.save({}, _request).$promise;
	}
		
    // C11M08F16 – Verifica Ordine in Ambito 
    $scope.C11M08F16 = function(){
    	
    	var _request = {
    		codiceOlo : $scope.data.step1.operatore.codiceOLO || $scope.data.step1.operatore,
    		servizio : $scope.data.step3.offerta.nomeOfferta,
    		lavorazione : 'attivazione'
    	};
    	
    	
    	return Locator.save(_request).$promise;
    	
    };

        
    $scope.submit_7 = function () {
    	
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
    	
    	$rootScope.formData.data.step7 = $scope.data.step7;
    	
    	
    	//CHIAMATA AL SYSTEM LOCATOR DISABILITATA
    	
    	$scope.C11M08F77()
    		.then(function(response){
				if(response.ControlliCodiceTDKitOutput.esito == 'KO'){
    				$scope.erroreService(response.messaggio);
    			}else{
    				$state.go($scope.checkNextState());	
    			}				
		});   	
    	
		// RU_1612	
		if(!$rootScope.OSCURAMENTI.RU_1612.oscurato) {
	    	let promises = [$scope.C11M08F16() /*, $scope.C11M08F77()*/];
	    	$q.all(promises)
	    		.then(function(responses){
	    			if(responses[0].esito == 'KO'){
	    				$scope.erroreService(responses[0].messaggio);
	    			}else if(promises.length > 1 && responses[1].ControlliCodiceTDKitOutput.esito == 'KO'){
	    				$scope.erroreService(responses[1].messaggio);
	    			}else{
	    				$state.go($scope.checkNextState());	
	    			}
	    		}, function(error){
	    			$scope.erroreService(error.messaggio);
	    		});  
    	}             
    };
    
    $scope.nextState = function () {
        $state.go($scope.checkNextState(), {
            'returning': true
        });
    };
    
}]);  
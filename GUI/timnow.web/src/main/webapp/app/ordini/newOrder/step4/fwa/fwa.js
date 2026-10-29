//RU_716
timnow.controller('fwa', ['$scope', '$state', '$rootScope', 'RecuperaProfiliFwaPost', 'RecuperaTipologieCpe', 'VerificaTipologiaContrattoFwa', '_', 'VerificaIdRisorsaSwitchoffFwa', '$q', 'modalService',
	function ($scope, $state, $rootScope, RecuperaProfiliFwaPost, RecuperaTipologieCpe, VerificaTipologiaContrattoFwa, _, VerificaIdRisorsaSwitchoffFwa, $q, modalService) {
	
	//RU_863
	$scope.loadingProfiloFWA = false;
	$scope.profiliFWA = [];
	$scope.caricaPassFive = false;
	
	if($rootScope.data.step4 == null) {
		$rootScope.data.step4 = {};
	}
	
	if($scope.data.step4 == null) {
		$scope.data.step4 = {};
	}
	//RU_921
	else{
		$scope.tipologia_cpe = $scope.data.step4.tipologia_cpe;
		$scope.tipologiaCpeList = $scope.data.step4.tipologiaCpeList;		
	}

	
	$scope.loadingCPE = false;
	$scope.flagProfilo = false; //SM_8813
	$scope.flagTipologiaCpe = false; //RU_921
	$scope.isRisorsaSwitchoffRequired = false; //RU_1335
	
	//RU_863
	$scope.init = function() {
		
		//Non oscurato
		if($scope.RU_1129){
			//SM_10011
			$scope.C11M08F80(true)
			.then(function(result){
				if(result.outputTipologieFWA.esito.toUpperCase() == 'OK'){				
					$scope.recuperaProfiliFwaPost(result.outputTipologieFWA.profili);
				}else{			
					$scope.data.step4.profilo_fwa = null;
					$scope.erroreService(result.outputTipologieFWA.message);
				}
			}, function(error){
				$scope.erroreService("Impossibile caricare i profili FWA");
			});
		}else{
			$scope.recuperaProfiliFwaPost([]);
		}
	}	
	
	
	$scope.recuperaProfiliFwaPost = function(profiliFwa){
			var _requestRecuperaProfiliFwa = {
					profili: profiliFwa
			};
					
			RecuperaProfiliFwaPost.save({}, _requestRecuperaProfiliFwa).$promise
			.then(function (response) {
            	$scope.profiliFWA = response.recuperaProfiliFWAOutput;
            },
            function (error) {	                    
                //RU_921
                $scope.erroreService("Impossibile caricare i dettagli dei profili FWA");       
            });	
	}
	
	//RU_1129
	$scope.C11M08F80 = function(isInit){
		var _requestVerificaTipologiaContrattoFwa = {
				codOloAgcom: $scope.data.step1.operatore.codiceOLO,
				idContratto: $scope.data.step2.contratto.idContratto						
			};
		
		//SM_9996
		//SM_10011
		if($scope.data.step4.profilo_fwa && !isInit){
			_requestVerificaTipologiaContrattoFwa.profiloFwa = $scope.data.step4.profilo_fwa.profilo
		}		
		
		//RU_1129
		if($scope.data.step2.codice_progetto && $scope.data.step2.codice_progetto.cod_prgt){
			_requestVerificaTipologiaContrattoFwa.codiceProgetto = $scope.data.step2.codice_progetto.cod_prgt;
		}
		
		return VerificaTipologiaContrattoFwa.save({}, _requestVerificaTipologiaContrattoFwa).$promise;
	}
	
	//RU_1335
	$scope.C11M08F93 = function(){
		var deferred = $q.defer()
		if($rootScope.customizedOffer.offerTopDetails.RISORSASWITCHOFF && $rootScope.customizedOffer.offerTopDetails.RISORSASWITCHOFF.dft){
			return VerificaIdRisorsaSwitchoffFwa.get({idRisorsa: $rootScope.customizedOffer.offerTopDetails.RISORSASWITCHOFF.dft}).$promise;
		}else{
			return deferred.reject("Compilare il campo Risorsa Switchoff");
		}
	}
	
	// CONTROLLO PER PASSAGGIO ALLO STEP 5
    $scope.submit_4 = function () {

		$scope.data.step4.flag_intervento = "Y";
    	
		$rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
		$scope.controlloBozza(5); //SM_8070
		
		var _promises = [];
		
		//RU_1355
		if($scope.isRisorsaSwitchoffRequired){
			_promises.push($scope.C11M08F93());
			//SM_9996
			_promises.push($scope.C11M08F80(false));	
		}else{
			//SM_9996
			_promises.push($scope.C11M08F80(false));
		}
		
		$scope.caricaPassFive = true;
		
		//RU_1335
		$q.all(_promises)
		.then(function(results){
			
				var _isResponsesOk = true; 
				
				$scope.caricaPassFive = false;
				
				results.forEach(function(promise, index){
		    		if(promise["outputTipologieFWA"] && promise["outputTipologieFWA"].esito == 'KO'){
						_isResponsesOk = false;
		    			$scope.erroreService(promise["outputTipologieFWA"].message);		    		
		    			return;
		    		}
		    		if(promise["outputVerificaIdRisorsaFwa"] && promise["outputVerificaIdRisorsaFwa"].esito == 'KO'){
						_isResponsesOk = false;
		    			$scope.erroreService(promise["outputVerificaIdRisorsaFwa"].message);
		    			return;
		    		}
	    		});
	    	
	    		if(_isResponsesOk){
					$state.go($scope.checkNextState());	
				}
	    }, function(error){
				$scope.caricaPassFive = false;
	    		$scope.erroreMessage("Impossibile proseguire con la lavorazione");
	    });
    };
    
    //RU_985   
    $scope.oscuramento_RU_985 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_985.oscurato){
    				$scope.RU_985 = ($rootScope.OSCURAMENTI.RU_985.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_985 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_985 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_985();
    
	//RU_1129
	$scope.oscuramento_RU_1129 = function(){
		$scope.RU_1129 = !$rootScope.OSCURAMENTI.RU_1129.oscurato;
	}
	
	$scope.oscuramento_RU_1129();
	
	//RU_1335
	$scope.oscuramento_RU_1335 = function(){
		$scope.RU_1335 = !$rootScope.OSCURAMENTI.RU_1335.oscurato;
	}
	
	$scope.oscuramento_RU_1335();
	
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
	
	$scope.$watch('data.step4.profilo_fwa', function(newValue, oldValue){
		if(newValue){
			
			//RU_1335
			if(newValue.profilo === "C" && newValue.descrizioneProfilo === "40/4 Deco"){
				$scope.isRisorsaSwitchoffRequired = true;
			}else{
				$scope.isRisorsaSwitchoffRequired = false;
				$rootScope.customizedOffer.offerTopDetails.RISORSASWITCHOFF.dft = "";
			}
					
			RecuperaTipologieCpe.get({profiloFwa: $scope.data.step4.profilo_fwa.profilo}).$promise
			.then(function(response){
				console.log(response);
				
				$scope.data.step4.tipologiaCpeList = [];
				$scope.tipologiaCpeList = [];
				
				if(response.outputTipologiaCPE && response.outputTipologiaCPE.length > 0){
					response.outputTipologiaCPE.forEach(function(item){
						$scope.data.step4.tipologiaCpeList.push(item.tipologiaCPE);
						$scope.tipologiaCpeList.push(item.tipologiaCPE);
					});
				}
				
			}, function(error){
	            console.debug(error);	                        
	            $scope.tipologiaCpeList = null;
	            $scope.tipologia_cpe = null;  
	            $scope.erroreService("Impossibile caricare la lista di Tipologie CPE.");

			});		
		}
	});
	
}]);
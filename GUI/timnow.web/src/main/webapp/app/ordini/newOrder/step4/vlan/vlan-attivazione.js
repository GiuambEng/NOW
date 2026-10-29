//RU_1058
timnow.controller('vlanAttivazioneStep4', ['$scope', '$state', '$rootScope', 'VisualizzaCampiOfferteVLAN', 'VLANUtils', 'modalService',
	function ($scope, $state, $rootScope, VisualizzaCampiOfferteVLAN, VLANUtils, modalService) {
	
    $scope.showCoS = false;
    $scope.isCoSRequired = false;
    $scope.showBanda = false;
    $scope.isBandaRequired = false;
    $scope.showCAR = false;
    $scope.isCARRequired = false;
    $scope.showProfiloBMC = false;
    $scope.isProfiloBMCRequired = false;
    
    $scope.arrayFamigliaVlan = [];
    $scope.arrayTipoVlan = []; 
    $scope.arrayCoS = [];
    $scope.arrayCAR = [];
    $scope.arrayBanda = [];
    $scope.arrayProfiloBMC = [];
    $scope.arrayBMCLight = [];
    
    //RU_1155
	$scope.headerTabellaProfiloBMC = [];
	$scope.headerTabellaProfiloBMC.push({"key": "profiloBMC","value": "Profilo","type": "text"});
	$scope.headerTabellaProfiloBMC.push({"key": "bandaMulticos3","value": "BP3","type": "text"});
	$scope.headerTabellaProfiloBMC.push({"key": "bandaMulticos5","value": "BP5","type": "text"});
	    
    $scope._idOfferta = $scope.data.step3.offerta.idOfferta;
    $scope._idOffertaVLAN_NGA = $rootScope.MAP_OFFERTE.VLAN_NGA.id;
    $scope._idOffertaVLAN_GBE = $rootScope.MAP_OFFERTE.VLAN_GBE.id;
   
    
	if (!$rootScope.data.step4) {
		 $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4 = {};
    }
	
    try{
    	$scope.arrayFamigliaVlan = $rootScope.topDetails.FAMIGLIAVLAN['dft'].split(';');
    	$scope.arrayTipoVlan = $rootScope.topDetails.TIPOVLAN['dft'].split(';');
    	$scope.arrayCoS = $rootScope.botDetails.IDENTIFICATIVOCOS['dft'].split(';');
    	$scope.arrayCAR = $rootScope.topDetails.IDENTIFICATIVOCAR['dft'].split(';');
    	
    	VLANUtils.convertiSezioneInferioreInArray();
    	$scope._indexBanda = VLANUtils.estraiIndiceCampoSezioneInferiore('BANDA');
    	$scope._indexCos = VLANUtils.estraiIndiceCampoSezioneInferiore('IDENTIFICATIVOCOS');
    	
    }catch(e){
        $scope.arrayFamigliaVlan = [];
        $scope.arrayTipoVlan = []; 
        $scope.arrayCoS = [];
        $scope.arrayCAR = [];
    }
	
	
	/**
	 * Per VLAN GBE - VLAN NGA
	 * 		Se Famiglia VLAN = 'VLAN MultiCoS Banda Dedicata'
	 * 		allora dovrà necessariamente essere selezionato DOUBLETAG 
	 */
	$scope.configureTipoVlan = function(){		
		var _famigliaVlan = $rootScope.customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft.toLowerCase();		
		if(_famigliaVlan){
			if(_famigliaVlan == 'vlan multicos banda dedicata'){
				$scope.arrayTipoVlan = ['DOUBLETAG'];
				//SM_9717
				if($rootScope.customizedOffer.offerTopDetails.TIPOVLAN.dft == "SINGLETAG"){
					$rootScope.customizedOffer.offerTopDetails.TIPOVLAN.dft = "";
				}				
			}else{
				$scope.arrayTipoVlan = ['SINGLETAG', 'DOUBLETAG'];
			}
		}
	}
	
	/**
	 * Per VLAN GBE - VLAN NGA
	 * 		Se Famiglia VLAN = 'VLAN MonoCoS Banda Condivisa' 
	 * 		allora dovrà essere obbligatorio, altrimenti non valorizzato/visibile 
	 */
	$scope.configureCoS = function(){		
		var _famigliaVlan = $rootScope.customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft.toLowerCase();		
		if(_famigliaVlan){
			if(_famigliaVlan == 'vlan monocos banda condivisa'){
			    $scope.showCoS = true;
			    $scope.isCoSRequired = true;
			}else{
			    $scope.showCoS = false;
			    $scope.isCoSRequired = false;
			    $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft = "";
			}
		}else{
		    $scope.showCoS = false;
		    $scope.isCoSRequired = false;
		    $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft = "";
		}
	}
	
	/**
	 * Per VLAN GBE - VLAN NGA
	 * 		Se CoS = 'VLAN MonoCoS Banda Condivisa CoS 3' oppure CoS = 'VLAN MonoCoS Banda Condivisa CoS 5'  
	 * 		allora dovrà essere obbligatorio, altrimenti non valorizzato/visibile 
	 */
	$scope.configureBanda = function(){		
		var _cos = $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft.toLowerCase();
		var _array = ['vlan monocos banda condivisa cos 3', 'vlan monocos banda condivisa cos 5'];
		$scope.arrayBanda = [];
				
		if(_cos){
			if(_array.indexOf(_cos) > -1){
			    $scope.showBanda = true;
			    $scope.isBandaRequired = true;
			    			    
			    /**
			     * Per VLAN NGA dovrà essere prevista una lista calcolata
			     * dalla quale selezionare il valore del campo
			     */    
			    
			    if($scope._idOfferta == $scope._idOffertaVLAN_NGA){
					var _request = {
							nomeCampo: 'BANDA',
							valoreCampo: $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft
						};
						
					VisualizzaCampiOfferteVLAN.save({}, _request).$promise
						.then(function(data){
							if(data.outputCampiOfferteVLAN && data.outputCampiOfferteVLAN.length > 0){
								
								var _array = data.outputCampiOfferteVLAN.map(function(item) {return item.banda;});
								
								angular.copy(_array, $scope.arrayBanda);
							}
						}, function(error){
							$scope.erroreService(data.descrizione);
							$scope.arrayBanda = [];
						});
			    }
			    
			    /**
			     * Per VLAN GBE si dovra prevedere una lista con i seguenti possibili valori:
			     * da 1 a 1000 (passi di 1 Mbit/s)
			     */
			    if($scope._idOfferta == $scope._idOffertaVLAN_GBE){
			    	$scope.arrayBanda = [];
			    	for(var i=1; i<=1000; i++){
			    		$scope.arrayBanda.push(i);
			    	}
			    }			    
			    
			    
			}else{
			    $scope.showBanda = false;
			    $scope.isBandaRequired = false;
			    $rootScope.customizedOffer.offerBotDetails[$scope._indexBanda].dft = "";
			}
		}else{
		    $scope.showBanda = false;
		    $scope.isBandaRequired = false;
		    $rootScope.customizedOffer.offerBotDetails[$scope._indexBanda].dft = "";
		}
	}

	/**
	 * Per VLAN GBE - VLAN NGA
	 * 		Se Famiglia VLAN = 'VLAN MultiCoS Banda Condivisa' 
	 * 		allora dovrà essere obbligatorio, altrimenti non valorizzato/visibile 
	 */

	//RU_1155
	$scope.configureShowProfiloBMC = function(){		
		var _famigliaVlan = $rootScope.customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft.toLowerCase();	
		
		if(_famigliaVlan){
			if(_famigliaVlan == 'vlan multicos banda condivisa'){
			    $scope.showProfiloBMC = true;
			    $scope.isProfiloBMCRequired = true;
			}else{
				$scope.showProfiloBMC = false;
			    $scope.isProfiloBMCRequired = false;
			    $scope.arrayProfiloBMC = [];
			    $rootScope.customizedOffer.offerTopDetails.PROFILOBMC.dft = "";
			}
		}else{
		    $scope.showProfiloBMC = false;
		    $scope.isProfiloBMCRequired = false;
		    $scope.arrayProfiloBMC = [];
		}
	}
	
	$scope.configureProfiloBMC = function(event){
		
		event.preventDefault();
	
	    /**
	     * Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	     */
		var _request = {
				idOfferta: $scope._idOfferta,
				nomeCampo: 'PROFILOBMC'
			};
		
		VisualizzaCampiOfferteVLAN.save({}, _request).$promise
			.then(function(data){
				if(data.outputCampiOfferteVLAN && data.outputCampiOfferteVLAN.length > 0){
					//RU_1155
					var _array = [];
					data.outputCampiOfferteVLAN.forEach(function(item) {
						_array.push( 
							{'profiloBMC': item.profiloBMC,
							 'bandaMulticos3': item.bandaMulticos3,
							 'bandaMulticos5': item.bandaMulticos5
							});
						});							
					
					angular.copy(_array, $scope.arrayProfiloBMC);
				}
				$scope.selectProfiloBMC();
			}, function(error){
				$scope.erroreService(data.descrizione);
				$scope.arrayProfiloBMC = [];
			});
	}
	
	//RU_1155
	$scope.selectProfiloBMC = function(){
        var _modalConfig = {
             headerText: 'Seleziona Profilo BMC',
             actionButtonText: null,
             closeButtonText: 'Ok',
             contentType: 'modale_nowtable',
             scope: $scope,
             callbackFunction: 'callbackSelectProfiloBMC',
             dataHeader: $scope.headerTabellaProfiloBMC,
             data: $scope.arrayProfiloBMC
         };
         modalService.showModal({}, _modalConfig);
	}
	
	$scope.callbackSelectProfiloBMC = function(item){
		$rootScope.customizedOffer.offerTopDetails.PROFILOBMC.dft = item.profiloBMC;
	}
	
	/**
	 * Per VLAN NGA
	 * 		Se Famiglia VLAN = 'VLAN MultiCoS Banda Condivisa' allora dovrà essere visibile
	 * Per VLAN GBE
	 * 		non dovrà essere valorizzato/visibile
	 *  
	 */
	$scope.configureBMCLight = function(){		
		$scope.arrayBMCLight = [];
		var _famigliaVlan = $rootScope.customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft.toLowerCase();		
		if(($scope._idOfferta == $scope._idOffertaVLAN_NGA) && _famigliaVlan){
			if(_famigliaVlan == 'vlan multicos banda condivisa'){
			    $scope.showBMCLight = true;
			    $scope.arrayBMCLight = ['SI'];
			}else{
			    $scope.showBMCLight = false;
			    $rootScope.customizedOffer.offerTopDetails.BMCLIGHT.dft = "";
			    $scope.arrayBMCLight = [];
			}
		}else{
		    $scope.showBMCLight = false;
		    $scope.arrayBMCLight = [];
		}
	}
	
	
    $scope.$watch("customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft", function(newValue, oldValue){
    	if(newValue){
    		$scope.configureTipoVlan();
    		$scope.configureCoS();
    		$scope.configureBanda();
    		$scope.configureShowProfiloBMC();
    		$scope.configureBMCLight();
    	}    	
    });
    
    $scope.$watch(function(){
    	if($scope._indexCos && $scope._indexCos > -1 && $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft){
    		return $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft;
    	}
    }, function(newValue, oldValue){
    	if(newValue){
    		$scope.configureBanda();
    	} 
    });
	
    $scope.submit_4 = function () {
    	 $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4; 
    	 $state.go($scope.checkNextState());              
    };
}]);  
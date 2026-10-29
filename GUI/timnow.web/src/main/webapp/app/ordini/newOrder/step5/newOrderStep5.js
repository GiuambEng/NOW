timnow.controller('newOrderStep5', ['$scope', '$state', '$rootScope', '$log', 'modalService', function ($scope, $state, $rootScope, $log, modalService) {
	
	if (!$rootScope.data.step5) {
		$rootScope.data.step5 = $scope.data.step5 = {};
		$scope.data.step5.datiReferenti = {}
    }else{
    	$scope.data.step5 = $rootScope.data.step5;
    }
	
    if ($rootScope.formData.stepReached < 5) $rootScope.formData.stepReached = 5;
    
    //Calcolo maxlength cellulare referente easyip con tipologia
    if( $rootScope.data && $rootScope.data.step3 && [$rootScope.MAP_OFFERTE.EASY_BF.id,$rootScope.MAP_OFFERTE.EASY_BL.id,	
                                               		$rootScope.MAP_OFFERTE.EASY_SF.id,$rootScope.MAP_OFFERTE.EASY_SL.id].indexOf($rootScope.data.step3.offerta.idOfferta)>=0 && $rootScope.customizedOffer.offerTopDetails.TIPOLINEA && ($rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft==='POTS' || $rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft==='ISDN')){
                              	$scope.telefonoFissoMaxLength=12;
                              }else{
                              	$scope.telefonoFissoMaxLength=15;
                              }
                              if($rootScope.data && $rootScope.data.step3 && [$rootScope.MAP_OFFERTE.ULL_LNA.id,$rootScope.MAP_OFFERTE.ULLD_LNA.id,	
                                                   		$rootScope.MAP_OFFERTE.SLU_LNA.id].indexOf($rootScope.data.step3.offerta.idOfferta)>=0)
                              	$scope.isLNA = true;
                          	
 
    $scope._submit_5 = function () {

    	if($scope.data.step5===null){
    		$scope.data.step5={};
    	}
    	
    	//RU_915
    	if($scope.data.step3.offerta.idOfferta != $rootScope.MAP_OFFERTE.CPS.id){
        	if($scope.data.step5.datiReferenti && $scope.data.step5.datiReferenti["1"] && ($scope.data.step5.datiReferenti["1"].nome === "")){
        		delete $scope.data.step5.datiReferenti["1"];
        	}
        	if($scope.data.step5.datiReferenti && $scope.data.step5.datiReferenti["2"] && ($scope.data.step5.datiReferenti["2"].nome === "")){
        		delete $scope.data.step5.datiReferenti["2"];
        	}
        	if($scope.data.step5.datiReferenti && $scope.data.step5.datiReferenti["3"] && ($scope.data.step5.datiReferenti["3"].nome === "")){
        		delete $scope.data.step5.datiReferenti["3"];
        	}
        	if($scope.data.step5.datiReferenti && $scope.data.step5.datiReferentiOnField && ($scope.data.step5.datiReferentiOnField.nome === "")){
        		delete $scope.data.step5.datiReferentiOnField;
        	}
    	}
    	
    	//RU_1058
    	if($scope.data.step3.offerta.idOfferta == $rootScope.MAP_OFFERTE.VP.id){
    		if((!$scope.data.step5.datiReferenti["1"].distrettoFisso || $scope.data.step5.datiReferenti["1"].distrettoFisso === "") && 
    		   (!$scope.data.step5.datiReferenti["1"].distrettoMobile || $scope.data.step5.datiReferenti["1"].distrettoMobile === "") &&
    		   (!$scope.data.step5.datiReferenti["1"].numeroFisso || $scope.data.step5.datiReferenti["1"].numeroFisso === "") &&
    		   (!$scope.data.step5.datiReferenti["1"].numeroMobile || $scope.data.step5.datiReferenti["1"].numeroMobile === "")){
    			delete $scope.data.step5.datiReferenti["1"];
    		}
    		
    	}
    	
        $rootScope.formData.data.step5 = $scope.data.step5;
        $scope.controlloBozza(6);
        $state.go($scope.checkNextState());
    };
    
    //R1F-20-0236.B
    $scope.oscuramento_R1F_20_0236 = function(){
		try {									
			if(!$rootScope.OSCURAMENTI.R1F_20_0236.oscurato){
				$scope.R1F_20_0236 = ($rootScope.OSCURAMENTI.R1F_20_0236.idOfferteNonValide.indexOf($scope.data.step3.offerta.idOfferta) == -1);
			}else {
				$scope.R1F_20_0236 = false;
			}									
			
		} catch (e) {
			$scope.R1F_20_0236 = false;
		}       	
    }
    
    $scope.oscuramento_R1F_20_0236();
    
    $scope.setShowReferenteOaoProgettiSpeciali = function(){
    	
    	 $scope.showReferenteOaoProgettiSpeciali = false;    	 
    	 var _causaleOrdine = $scope.data.step1.causale_ordine;
    	 var _idOfferta = $scope.data.step3.offerta.idOfferta;
    	 var _arrayOfferteNonValide = [$rootScope.MAP_OFFERTE.FWA.id,
    		 						   $rootScope.MAP_OFFERTE.GPON_SEMI.id,
    		 						   $rootScope.MAP_OFFERTE.GPON_FULL.id,
    		 						   $rootScope.MAP_OFFERTE.VLAN_VULA.id,
    		 						   $rootScope.MAP_OFFERTE.VLAN_NGA.id,
    		 						   $rootScope.MAP_OFFERTE.FEEDER.id,
    		 						   $rootScope.MAP_OFFERTE.VLANNGAMULTICAST.id,
    		 						   $rootScope.MAP_OFFERTE.SEDEOLT.id,
    		 						   $rootScope.MAP_OFFERTE.CANALE.id,
    		 						   $rootScope.MAP_OFFERTE.NPNG.id,
						        	   $rootScope.MAP_OFFERTE.GPON_SEMI_PNRR.id,
						        	   $rootScope.MAP_OFFERTE.GPON_FULL_PNRR.id];
    	 
    	if($scope.R1F_20_0236){
    		if(_causaleOrdine != 'cessazione' && _arrayOfferteNonValide.indexOf(_idOfferta) == -1){
    			$scope.showReferenteOaoProgettiSpeciali = true;  
    		}
    	}
    }
    
    $scope.setShowReferenteOaoProgettiSpeciali();
    
    //RU_1357
    $scope.oscuramento_RU_1357 = function(){
		try {	
			$scope.RU_1357 = !$rootScope.OSCURAMENTI.RU_1357.oscurato;
		} catch (e) {
			$scope.RU_1357 = false;
		}       	
    }
    
    $scope.setShowReferenteOnField = function(){
		$scope.showReferenteOnField = false;
		var _causaleOrdine = $scope.data.step1.causale_ordine;
		var _idOfferta = $scope.data.step3.offerta.idOfferta;
		if($scope.RU_1357){
    		if(_causaleOrdine == 'migrazione' && $rootScope.OSCURAMENTI.RU_1357.idOfferteValide.indexOf(_idOfferta) > -1){
    			$scope.showReferenteOnField = true;  
    		}
    	}
	}
	
	$scope.oscuramento_RU_1357();
	$scope.setShowReferenteOnField();
	
	//SM_11027
	//Verifica Referente OnField ambito OneStep
	$scope.C11M08F94 = function(){
		var _isReferenteOnFieldPresent = ($scope.data.step5.datiReferentiOnField && $scope.data.step5.datiReferentiOnField.cognomeOnField);
		var _isContrattoOneStep = ($scope.data.step2.codice_progetto && $scope.data.step2.codice_progetto.oneStep);
		
		var _arrayOfferteValide = [$rootScope.MAP_OFFERTE.NGA_CAB.id, 
									$rootScope.MAP_OFFERTE.VULA_CAB.id, 
									$rootScope.MAP_OFFERTE.EASY_CAB.id,
									$rootScope.MAP_OFFERTE.NGA_H.id,
									$rootScope.MAP_OFFERTE.VULA_H.id,
									$rootScope.MAP_OFFERTE.EASY_H.id,
									$rootScope.MAP_OFFERTE.SEMI_BTS_H.id,
									$rootScope.MAP_OFFERTE.SEMI_VULA_H.id,
									$rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id];
		var _isOffertaValida = ($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta && _arrayOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
		
		if(_isOffertaValida){
			if(_isReferenteOnFieldPresent){
				if(_isContrattoOneStep){
					$scope._submit_5();
				}else{
					modalService.showModal({}, {
	                    headerText: "Avviso",
	                    closeButtonText: 'Chiudi',
	                    bodyText: "La prestazione di Quarto Referente nelle migrazioni e' possibile solo in progetti ONE STEP",
	                    scope: $scope,
	                    type: 'error'
	                });
				}				
			}else{
				$scope._submit_5();
			}		
		}else{
			$scope._submit_5();
		}
	}
	
	$scope.submit_5 = function(){
		if($scope.RU_1357 && $scope.data.step1.causale_ordine.toLowerCase() == 'migrazione'){
			$scope.C11M08F94();
		}else{
			$scope._submit_5();
		}
	}
	
}]);
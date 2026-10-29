//RU_915
timnow.controller('cps', ['$scope', '$state', '$rootScope', '$log','VerificaCarrierOloCps', 'VerificaContratto', 'alertService','$filter', 'uibDateParser', function ($scope, $state, $rootScope, $log, VerificaCarrierOloCps, VerificaContratto, alertService, $filter, uibDateParser) {
	
    $scope.showRadicale = false;
    $scope.showQuantitaLinee = false;
    $scope.isRadicaleRequired = false;
    $scope.isQuantitaLineeRequired = false;
    
    //SM_9049
    $scope.showDnPrimario = false;
    
    //SM_9021
    $scope.DSC = null;
	
	if (!$rootScope.data.step4) {
        $rootScope.data.step4 = $scope.data.step4 = {};
    }
	
	
	//Configurazione datepicker
	
	$scope.regDate = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
    $scope.formats = ['dd/MM/yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    $scope.popup_dataSottoscrizioneContratto = {
    	opened : false
    };
    
    try{
    	$scope.arrayStrutturaLinea = $rootScope.topDetails.STRUTTURALINEA['dft'].split(';');
    	
    	//SM_9021
    	if($rootScope.customizedOffer.offerTopDetails.DSC['dft']){
    		$scope.DSC = new Date($rootScope.customizedOffer.offerTopDetails.DSC['dft']);
    	}
    }catch(e){
    	$scope.arrayStrutturaLinea = [];
    	$scope.DSC = null;
    }
    
    //SM_9021
    $scope.convertDSCDate = function(){
        try{
        	if($rootScope.customizedOffer && $rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.DSC){
        		$rootScope.customizedOffer.offerTopDetails.DSC.dft = new Date($scope.DSC.getTime() - ($scope.DSC.getTimezoneOffset() * 60000)).toISOString().split('T')[0];
        	}
        }catch(e){
        	$rootScope.customizedOffer.offerTopDetails.DSC.dft = null;
        }
    };
    
    $scope.inlineOptions = {
            customClass: getDayClass,
            minDate: new Date(),
            showWeeks: false
        };
    
    $scope.dateOptions = {
            dateDisabled: disabled,
            formatYear: 'yy',
            //SM_9739
            maxDate: new Date(new Date().setDate(new Date().getDate())), //intervallo date (-infinito, ieri]
            startingDay: 1
    };
    
    // Disable weekend selection
    function disabled(data) {
        var date = data.date, mode = data.mode;
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    }
    
    $scope.matrixRadicale = {
    	"POTS" : ["PBX","GNR"],
    	"ISDN" : ["PBX","GNR"]
    };    	
    
    $scope.matrixQuantitaLinee = {
        	"POTS" : ["PBX","GNR"],
        	"ISDN" : ["PBX","GNR"]
        };  
    
    function getDayClass(data) {
        var date = data.date, mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0,
                0, 0, 0);

            for (var i = 0; i < $scope.events.length; i++) {
                var currentDay = new Date(
                    $scope.events[i].date)
                    .setHours(0, 0, 0, 0);

                if (dayToCheck === currentDay) {
                    return $scope.events[i].status;
                }
            }
        }
        return '';
    }
    
    //SM_9010
    $scope.$watch("DSC", function(newValue, oldValue){
    	if(newValue !== oldValue){
    		$scope.DSC = uibDateParser.parse(newValue, 'yyyy-MM-dd');
    		
    		//SM_9021
    		$scope.convertDSCDate();
    	}
    });
    
    //SM_9010
    $scope.buildArrayStrutturaLinea = function(){
    	if($rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft){
    		switch($rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft){
	    		case 'POTS':
	    			$scope.arrayStrutturaLinea = ['Simplex','PBX','GNR'];
	    			break;
	    		case 'ISDN':
	    			//SM_8981
	    			$scope.arrayStrutturaLinea = ['BRA','PBX','GNR'];
	    			break;
	    		default:
	    			$scope.arrayStrutturaLinea = [];
	    			break;
    		}    		
    	}else{
    		$scope.arrayStrutturaLinea = [];
    	}
    }
    
    $scope.openDataSottoscrizioneContratto = function () {
        $scope.popup_dataSottoscrizioneContratto.opened = true;
    };
            
    //C04M01F227
    $scope.verificaCarrierOloCps = function(){
    	var _request = {
        		codificaOloAgcom: $scope.data.step1.operatore.codiceOLO,
        		lavorazione: $scope.data.step1.causale_ordine,
        		offerta: $scope.data.step3.offerta.idOfferta,
        		codiceCarrierOlo: $rootScope.customizedOffer.offerTopDetails.CODICECARRIEROLO.dft        		
        	};
    	
    	return VerificaCarrierOloCps
    		.save(_request)
    		.$promise;
    }
    
    //C04M01F02
    $scope.verificaContratto = function(){
    	var _request = {
    		codiceOloAgcom: $scope.data.step1.operatore.codiceOLO,
    		lavorazione: $scope.data.step1.causale_ordine,
    		offerta: $scope.data.step3.offerta.idOfferta,
    		dn: $rootScope.customizedOffer.offerTopDetails.DN.dft
    	};
    	
    	return VerificaContratto
    		.save(_request)
    		.$promise;
    }
    
    $scope.salvaConfigurazioneOfferta = function () {
        $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
        $state.go($scope.checkNextState());
    };

    $scope.submit_4 = function () {
        $rootScope.data.step4 = $scope.data.step4; 
       
        //Chiamata a C04M01F227			
		$scope.verificaCarrierOloCps()
 		.then(function(response){
			if(response.verificaCarrierOloCPSOutput && response.verificaCarrierOloCPSOutput.esito.toUpperCase() === 'KO'){
					$scope.erroreService(response.verificaCarrierOloCPSOutput.message);
				}else{
				
					//Chiamata a C04M01F02
					$scope.verificaContratto()
		    		.then(function(response){
		    			if(response.verificaContrattoOutput && response.verificaContrattoOutput.esito.toUpperCase() === 'KO'){
		    				$scope.erroreService(response.verificaContrattoOutput.message);
		    			}else{
		    				
		    				$scope.salvaConfigurazioneOfferta();
		    				$scope.controlloBozza(5);
		    			}
		    			
		    		}, function(error) {
		    			$scope.erroreService("Errore verifica contratto OLO");
					});		
				}			
		}, function(error) {
			$scope.erroreService("Errore verifica carrier OLO");
		});        
    };
    
    $scope.$watch("customizedOffer.offerTopDetails.TIPOLINEA.dft", function(newValue, oldValue){
    	//SM_9238
    	if(newValue){ //SM_9280
    		$scope.buildArrayStrutturaLinea();
    	}
    	
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.STRUTTURALINEA.dft", function(newValue, oldValue){
    	if(newValue){
    		var _strutturaLinea = $rootScope.customizedOffer.offerTopDetails.STRUTTURALINEA.dft;
    		var _tipoLinea = $rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft; 
    		var _show = (_strutturaLinea && _strutturaLinea != "" && _strutturaLinea != "BRA" && _strutturaLinea != "Simplex");
    		$scope.showRadicale = angular.copy(_show);
    		$scope.showQuantitaLinee = angular.copy(_show);
    		
       		if($scope.showRadicale){             	   	
             	$scope.isRadicaleRequired = ($scope.matrixRadicale[_tipoLinea].indexOf(_strutturaLinea) > -1);         	
    		}else{
    			//SM_9238
            	$rootScope.customizedOffer.offerTopDetails.RADICALE.dft = "";   
    		}
    		
    		if($scope.showQuantitaLinee){	
             	$scope.isQuantitaLineeRequired = ($scope.matrixQuantitaLinee[_tipoLinea].indexOf(_strutturaLinea) > -1);
    		}else{
    			//SM_9238
             	$rootScope.customizedOffer.offerTopDetails.QUANTITALINEE.dft = "";
    		}
    		
    		
    		//SM_9049
    		$scope.showDnPrimario = (_tipoLinea === "ISDN" && _strutturaLinea === "BRA");
    		if(!$scope.showDnPrimario){
    			$rootScope.customizedOffer.offerTopDetails.DNPRIMARIO.dft = "";
    		}
    		
    	} else{
    		$scope.showRadicale = false;
    		$scope.showQuantitaLinee = false;
    		$scope.isRadicaleRequired = false;
    		$scope.isQuantitaLineeRequired = false;
    		//SM_9049
    		$scope.showDnPrimario = false;
    	}       		  	
    });
}]);  
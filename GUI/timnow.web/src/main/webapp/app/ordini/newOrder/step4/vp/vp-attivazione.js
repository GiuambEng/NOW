//RU_1058
timnow.controller('vpAttivazioneStep4', ['$scope', '$state', '$rootScope', 'RecuperaCampiOffertaVP', 'VerificaCodiceTDKit',
	function ($scope, $state, $rootScope, RecuperaCampiOffertaVP, VerificaCodiceTDKit) {
	
	$scope.arrayCaratteristicaVP = [];
	$scope.arrayTipoVLAN = {};
	$scope.arrayMCR = [];
	$scope.arrayPCR = [];
	
	//Solo valori numerici nell'intervallo [10-255]
	$scope.regexVPI = /^0*([1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/;
	
	if (!$rootScope.data.step4) {
        $rootScope.data.step4 = $scope.data.step4 = {};
    }
		
	$scope.init = function(){
		$scope.arrayCaratteristicaVP = $rootScope.topDetails.CARATTERISTICAVP['dft'].split(';');
		$scope.arrayTipoVLAN = $rootScope.topDetails.TIPOVLAN['dft'].split(';');
		
		$rootScope.customizedOffer.offerBotDetails = [];
	}
	
		
	/**
	 * 	Per MCR
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureMCR = function(){
		//#Task33535
		$rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft = "";
		
		var _request = {
				nomeCampo: 'MCR',
				valoreCampo: $rootScope.customizedOffer.offerTopDetails.CARATTERISTICAVP.dft
			};
			
		RecuperaCampiOffertaVP.save({}, _request).$promise
				.then(function(data){
					if(data.outputCampiOffertaVP){
						var _array = data.outputCampiOffertaVP.map(function(item) {return item.mcr;});
						angular.copy(_array, $scope.arrayMCR);
					}
				}, function(error){
					$scope.erroreService("Errore su recupero valori MCR");
				});
	}
	
	/**
	 * 	Per PCR
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configurePCR = function(){
		//#Task33535
		$rootScope.customizedOffer.offerTopDetails.BANDAPCR.dft = "";
		
		var _request = {
				nomeCampo: 'PCR',
				valoreCampo: $rootScope.customizedOffer.offerTopDetails.CARATTERISTICAVP.dft,
				mcr: $rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft
			};
			
		RecuperaCampiOffertaVP.save({}, _request).$promise
				.then(function(data){
					if(data.outputCampiOffertaVP){
						var _array = data.outputCampiOffertaVP.map(function(item) {return item.pcr;});
						angular.copy(_array, $scope.arrayPCR);
					}
				}, function(error){
					$scope.erroreService("Errore su recupero valori PCR");
				});
	}
	
	/**
	 * Funzione C11M08F76 - Verifica Limite massimo VP nel Kit
	 * Se il limite è superato, la richiesta di attivazione VP deve essere bloccata 
	 */
	$scope.C11M08F76 = function(){
		
		var _request = {
			codiceFunzione: 'C11M06F76',
			codiceTdKit: ''
		};
		
		return VerificaCodiceTDKit.save({}, _request).$promise;
	}
	
    
    $scope.submit_4 = function () {    
    	
    	$rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4; 
    	$state.go($scope.checkNextState());	          
    };
    
    $scope.init();
    
    $scope.$watch("customizedOffer.offerTopDetails.CARATTERISTICAVP.dft", function(newValue, oldValue){
    	if(newValue){
    		//#Task33535
    		$scope.configureMCR();    		
    	}    	
    });
    
    //#Task33535
    $scope.$watch("customizedOffer.offerTopDetails.BANDAMCR.dft", function(newValue, oldValue){
    	if(newValue){
    		$scope.configurePCR();
    	}    	
    });
}]);  
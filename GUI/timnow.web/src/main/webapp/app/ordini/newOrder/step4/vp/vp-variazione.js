//RU_1058
timnow.controller('vpVariazioneStep4', ['$scope', '$state', '$rootScope', 'VPUtils', 'VP_VARIAZIONI', 'VP_RACCOLTA_SERVIZI', 'VerificaKitAbilitatoNGA', 'RecuperaCampiOffertaVP', 'modalService', 
	function ($scope, $state, $rootScope, VPUtils, VP_VARIAZIONI, VP_RACCOLTA_SERVIZI, VerificaKitAbilitatoNGA, RecuperaCampiOffertaVP, modalService) {

	$scope.buttonAvantiAttivo = false;
	
	$scope.arrayCodiceTDKit = [];
	$scope.arrayCaratteristicaVP = [];	
	$scope.arrayMCR = [];
	$scope.arrayPCR = [];
	
	$scope._opzioniVariazioni = VP_VARIAZIONI;
    $scope._idOfferta = $scope.data.step3.offerta.idOfferta;
    $scope._opzioneVariazione = $scope.data.step3.opzioneVariazione;
    
    $scope.buttonAvantiAttivo = false;
    
    $scope.campiModificati = {};
    
	//Solo valori numerici nell'intervallo [10-255]
	$scope.regexVPI = /^0*([1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/;
	
	//Task #33635
	$scope.headerTabellaTdKit = [];
	$scope.headerTabellaTdKit.push({"key": "codiceKit","value": "Codice TD kit","type": "text"});
	$scope.headerTabellaTdKit.push({"key": "clliCentrale","value": "CLLI","type": "text"});
	
	//SM_10423
	if (!$scope.data.step4) {
        $scope.data.step4 = {};
    }	
	
	if (!$rootScope.data.step4) {
        $rootScope.data.step4 = $scope.data.step4 = {};
    }
	
	if($scope.data.assetDetail){
		VPUtils.estraiDettagliAsset($scope.data.assetDetail);
	}
		
	$scope.init = function(){
		$scope.configureTipoServiziAsset();
		$scope.configureCampiModificati();
		
		$scope.configureShowCodiceTDKit();
		$scope.configureCaratteristicaVP();
		$scope.configureMCR();
		$scope.configurePCR();
		$scope.configureVPI();
		
		$rootScope.customizedOffer.offerBotDetails = [];
	}
	
	$scope.configureTipoServiziAsset = function(){
		switch($scope._idOfferta){
			case $rootScope.MAP_OFFERTE.VP.id:
					$scope._raccoltaServizi = VP_RACCOLTA_SERVIZI.VP;
				break;
		}
	}
	
    $scope.configureCampiModificati = function(){
    	$scope.campiModificati['CODICETDKIT'] = false;
    	$scope.campiModificati['CARATTERISTICAVP'] = false;
    	$scope.campiModificati['BANDAMCR'] = false;
    	$scope.campiModificati['BANDAPCR'] = false;
    	$scope.campiModificati['VPI'] = false;
    }
	
	/**
	 * 	Per CodiceTDKIT
	 * 		Se opzioneVariazone == Variazione TDKit
	 * 			dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 * 		Se opzioneVariazone == Variazione Banda
	 * 			si dovrà visualizzare l’attributo CODICETDKIT della componente RACCOLTAVP dall’asset di riferimento	
	 */
    
    //Task #33635
    $scope.configureShowCodiceTDKit = function(){
    	$scope._codiceTDKIT = VPUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'CODICETDKIT');
    	if(!$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft || $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft == ""){
    		$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = $scope._codiceTDKIT;
    	}
    }
    
	$scope.configureCodiceTDKit = function(event){
		
		event.preventDefault();

		if($scope._opzioneVariazione == VP_VARIAZIONI.VARIAZIONE_TDKIT){
			var _request = {
					nomeCampo: 'CODICETDKIT',
					valoreCampo: $rootScope.data.step1.operatore.codiceOLO
				};
			
			$scope.arrayCodiceTDKit = [];
			$scope.loadingCodiceTDKit = true;
				
			RecuperaCampiOffertaVP.save({}, _request).$promise
					.then(function(data){
						if(data.outputCampiOffertaVP){
							$scope.loadingCodiceTDKit = false;
							angular.copy(data.outputCampiOffertaVP, $scope.arrayCodiceTDKit);						
						}
						$scope.selectCodiceTdKit();
					}, function(error){
						$scope.loadingCodiceTDKit = false;
						$scope.erroreService("Errore nel recupero dati Codice TDKit");
					});
		}else if($scope._opzioneVariazione == VP_VARIAZIONI.VARIAZIONE_CARATTERISTICA){
			$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = $scope._codiceTDKIT;
		}
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
	
	
	$scope.configureCaratteristicaVP = function(){
		$scope.arrayCaratteristicaVP = ['LITE', 'STANDARD', 'SPECIAL'];
		
    	$scope._caratteristicaVp = VPUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'CARATTERISTICAVP');
    	if(!$rootScope.customizedOffer.offerTopDetails.CARATTERISTICAVP.dft || $rootScope.customizedOffer.offerTopDetails.CARATTERISTICAVP.dft == ""){
    		$rootScope.customizedOffer.offerTopDetails.CARATTERISTICAVP.dft = $scope._caratteristicaVp;
    	}
	}
	
	$scope.configureVPI = function(){
    	$scope._vpi = VPUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'VPI');
    	if(!$rootScope.customizedOffer.offerTopDetails.VPI.dft || $rootScope.customizedOffer.offerTopDetails.VPI.dft == ""){
    		$rootScope.customizedOffer.offerTopDetails.VPI.dft = $scope._vpi;
    	}
	}
	
	/**
	 * 	Per MCR
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureMCR = function(){
	
		if($scope._opzioneVariazione == VP_VARIAZIONI.VARIAZIONE_CARATTERISTICA){
			
			var _request = {
					nomeCampo: 'MCR',
					valoreCampo: $rootScope.customizedOffer.offerTopDetails.CARATTERISTICAVP.dft
				};
			
	    	$scope._mcr = VPUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'BANDAMCR');
	    	if(!$rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft || $rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft == ""){
	    		$rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft = $scope._mcr;
	    	}
				
			RecuperaCampiOffertaVP.save({}, _request).$promise
					.then(function(data){
						if(data.outputCampiOffertaVP){
							var _array = data.outputCampiOffertaVP.map(function(item) {return item.mcr;});									
							angular.copy(_array, $scope.arrayMCR);
						}
					}, function(error){
						$scope.erroreService(data.descrizione);
					});
		}
	}
	
	/**
	 * 	Per PCR
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configurePCR = function(){

		if($scope._opzioneVariazione == VP_VARIAZIONI.VARIAZIONE_CARATTERISTICA){
			var _request = {
					nomeCampo: 'PCR',
					valoreCampo: $rootScope.customizedOffer.offerTopDetails.CARATTERISTICAVP.dft,
					mcr: $rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft
				};
			
	    	$scope._pcr = VPUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'BANDAPCR');
	    	if(!$rootScope.customizedOffer.offerTopDetails.BANDAPCR.dft || $rootScope.customizedOffer.offerTopDetails.BANDAPCR.dft == ""){
	    		$rootScope.customizedOffer.offerTopDetails.BANDAPCR.dft = $scope._pcr;
	    	}
				
			RecuperaCampiOffertaVP.save({}, _request).$promise
					.then(function(data){
						if(data.outputCampiOffertaVP){
							var _array = data.outputCampiOffertaVP.map(function(item) {return item.pcr;});
							angular.copy(_array, $scope.arrayPCR);
						}
					}, function(error){
						$scope.erroreService(data.descrizione);
					});
		}
	}
	
	//Task #33635
	$scope.cleanMCR = function(){
		if($rootScope.customizedOffer.offerTopDetails.BANDAMCR && $rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft){
			$rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft = ""
		}	
	}
	
	$scope.cleanPCR = function(){
		if($rootScope.customizedOffer.offerTopDetails.BANDAPCR && $rootScope.customizedOffer.offerTopDetails.BANDAPCR.dft){
			$rootScope.customizedOffer.offerTopDetails.BANDAPCR.dft = ""
		}	
	}
	
	$scope.cleanVPI = function(){
		if($rootScope.customizedOffer.offerTopDetails.VPI && $rootScope.customizedOffer.offerTopDetails.VPI.dft){
			$rootScope.customizedOffer.offerTopDetails.VPI.dft = ""
		}		
	}
    
    $scope.submit_4 = function () {    	
    	$rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
    	$state.go($scope.checkNextStateVariazione());	             
    };
    
    $scope.init();
    
    $scope.$watch("customizedOffer.offerTopDetails.CODICETDKIT.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){
    		$scope.campiModificati['CODICETDKIT'] = true;
    	}else{
    		$scope.campiModificati['CODICETDKIT'] = false;
    	}
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.CARATTERISTICAVP.dft", function(newValue, oldValue){
    	//#Task33535
    	if(newValue && newValue != oldValue){
    		$rootScope.customizedOffer.offerTopDetails.BANDAMCR.dft = "";
    		$rootScope.customizedOffer.offerTopDetails.BANDAPCR.dft = "";
    		//Task #33635
    		$scope.cleanMCR();
    		$scope.cleanPCR();
    		$scope.cleanVPI();
    		
    		$scope.configureMCR();
    	}
    	if(newValue && newValue != $scope._caratteristicaVp){
    		$scope.campiModificati['CARATTERISTICAVP'] = true;
    	}
    	else{
    		$scope.campiModificati['CARATTERISTICAVP'] = false;
    	}
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.BANDAMCR.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){    		
    		$rootScope.customizedOffer.offerTopDetails.BANDAPCR.dft = "";
    		//Task #33635
    		$scope.cleanPCR();
    		$scope.cleanVPI();
    		
    		$scope.configurePCR();
    	}
    	if(newValue && newValue != $scope._mcr){
    		$scope.campiModificati['BANDAMCR'] = true;
    	}
    	else{
    		$scope.campiModificati['BANDAMCR'] = false;
    	}
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.BANDAPCR.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){
    		//Task #33635
    		$scope.cleanVPI();
    	}
    	if(newValue && newValue != $scope._pcr){
    		$scope.campiModificati['BANDAPCR'] = true;
    	}
    	else{
    		$scope.campiModificati['BANDAPCR'] = false;
    	}
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.VPI.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){
    		$scope.campiModificati['VPI'] = true;
    	}else{
    		$scope.campiModificati['VPI'] = false;
    	}
    });
    
    $scope.$watch('campiModificati', 
		function(newValue, oldValue){
			if(newValue){
				
				var _flags = Object.keys($scope.campiModificati).map(function(e) {
					  return $scope.campiModificati[e];
				});
				
				$scope.buttonAvantiAttivo = _flags.some(function(item){
					return item == true;
				});
			}
		}, true);
    
    
}]);  
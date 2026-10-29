timnow.controller('easyip', ['$scope', '$state', '$rootScope', '$log', '$q', 'modalService', function ($scope, $state, $rootScope, $log, $q, modalService) {
    $log.info("EasyIp Controller");
    
    if (!$rootScope.data.step4) $rootScope.data.step4 = $scope.data.step4 = {};
    if ($rootScope.bozza && $rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.MODULAZIONE && $rootScope.customizedOffer.offerTopDetails.MODULAZIONE.dft) {
            $scope.getLineProfiles();
    }
    $scope.configurazioneOffertaCallbackGetCodiceTDEasyIP = function (item) {
        if ($rootScope.customizedOffer.offerBotDetails.CODICETD) {
            $rootScope.customizedOffer.offerBotDetails.CODICETD.dft = item.codKit;
        } else {
            $rootScope.customizedOffer.offerBotDetails.CODICETD = [];
            $rootScope.customizedOffer.offerBotDetails.CODICETD.dft = item.codKit;
        }
    };
    
    if($rootScope.data.step1.causale_ordine==='variazione'){
    	
    	if($scope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    	
    	if(!$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft && $rootScope.MAP_OFFERTE && $rootScope.MAP_OFFERTE.EASY_BL.id === $scope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.EASY_SL.id === $scope.data.step3.offerta.idOfferta){
    		$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft = "LITE";
    		
    	}
    	if(!$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft && ($rootScope.MAP_OFFERTE && $rootScope.MAP_OFFERTE.EASY_BL.id === $scope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.EASY_SL.id === $scope.data.step3.offerta.idOfferta)){
    		$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft = "LITE";
    	}
    	if(!$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft && $rootScope.MAP_OFFERTE && $rootScope.MAP_OFFERTE.EASY_BF.id === $scope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.EASY_SF.id === $scope.data.step3.offerta.idOfferta){
    		$rootScope.customizedOffer.offerTopDetails.CARATTERISTICA.dft = "FLAT";
    	}
    	if(!$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft && ($rootScope.MAP_OFFERTE && $rootScope.MAP_OFFERTE.EASY_BF.id === $scope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.EASY_SF.id === $scope.data.step3.offerta.idOfferta)){
    		$rootScope.DettaglioAsset.offerTopDetails.CARATTERISTICA.dft = "FLAT";
    	}
    }
    if(($rootScope.data.step1.causale_ordine==='attivazione') && ($rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING && !$rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING.dft)){
  	   $rootScope.customizedOffer.offerTopDetails.SLAPROVISIONING.dft = "N";
     }
    $scope.headerGetCodiceTD = [
        {"key": "codKit", "value": "Codice Kit", "type": "text"},
        {"key": "clli", "value": "CLLI", "type": "text", "sort": "number"}
    ];
    $scope.configurazioneOffertaGetCodiceTDEasyIP = function ($event, itemNum) {
        $rootScope.numItemForModalCallback = itemNum;
        $scope.modalOptionsTabellaConfigurazioneOffertaCodiceTD = {
            headerText: 'Seleziona un codice TD',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'configurazioneOffertaCallbackGetCodiceTDEasyIP',
            dataHeader: $scope.headerGetCodiceTD,
            templateUrl: 'app/common/templates.html',
            data: $rootScope.formData.codiceTD
        };

        $event.preventDefault();
        modalService.showModal({}, $scope.modalOptionsTabellaConfigurazioneOffertaCodiceTD);
    };

    $scope.salvaConfigurazioneOfferta = function () {
        $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
        if($rootScope.data.step1.causale_ordine === 'variazione'){
        	$state.go($scope.checkNextStateVariazione());
        }else {
        	 $state.go($scope.checkNextState());
        }
    };
    
    if (($rootScope.data.step1.causale_ordine !== 'variazione') && (!$rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft)){
    	$rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft = 'LineaNonFonia';
    }

    $scope.submit_4 = function () {
        $scope.salvaConfigurazioneOfferta();
        $scope.controlloBozza(5);
    };

}]);
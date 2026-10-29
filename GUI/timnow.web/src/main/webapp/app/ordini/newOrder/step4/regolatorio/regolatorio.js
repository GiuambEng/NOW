timnow.controller('regolatorio', ['$scope', '$state', '$rootScope', '$log','IDSLUCo','IDULLCo', 'modalService','$filter', function ($scope, $state, $rootScope, $log,IDSLUCo,IDULLCo, modalService, $filter  ) {
	if($rootScope.data.step1.causale_ordine==='variazione'){
    	if($rootScope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    }
	
	if (!$rootScope.data.step4) {
        $rootScope.data.step4 = $scope.data.step4 = {};
    }
    $scope.destinazioneduso = false;
    // Controllo Catalogo
    //$log.info($rootScope.customizedOffer);

	if($rootScope.data.step3.opzioneVariazione === "Destinazione d'uso"){
		$scope.destinazioneduso = true;
	}

	if($rootScope.data.step3.opzioneVariazione === "Cambio coppia" && $scope.data.assetDetail.servizi && $scope.data.assetDetail.servizi[0].customizzazione){
    	for(var i=0; i<$scope.data.assetDetail.servizi[0].customizzazione.length; i++){
    		if($scope.data.assetDetail.servizi[0].customizzazione[i].attribute==='IDULLCO'){
    			$scope.data.step4.idullco={};
    			$scope.data.step4.idullco.idullco=$scope.data.assetDetail.servizi[0].customizzazione[i].value;
    		}
    	}
	}
	
    if($rootScope.data.step1.causale_ordine==='migrazione'){
    		$scope.datiView =[true,false,false];
    		$scope.closeOthers=true;
    	 $scope.bitrate_length=6;
    }else{
    	 $scope.bitrate_length=4;
    }
    
    $scope.cancellaDestinazioneDUso = function(type){
    	if(($rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.DESTINAZIONEUSOFONIA) && (type === 'fonia')){
    		$rootScope.customizedOffer.offerTopDetails.DESTINAZIONEUSOFONIA.dft="";
    	}else if(($rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.DESTINAZIONEUSODATI) && (type === 'dati')){
    		$rootScope.customizedOffer.offerTopDetails.DESTINAZIONEUSODATI.dft="";
    		if($rootScope.customizedOffer.offerTopDetails.BITRATE)
    			{$rootScope.customizedOffer.offerTopDetails.BITRATE.dft = "";}
    	}
    };
    
    $scope.calcolaTabVisualizzato = function () {
    	if(!$scope.configurazioneOffertaForm.$valid){
    		$scope.datiView =[true,true,true];
    		$scope.closeOthers=false;
    	}
    };
    
    
    $scope.salvaConfigurazioneOfferta = function () {
    	//$log.info($rootScope.customizedOffer);
    	$rootScope.formData.data.step4 = $scope.data.step4;
        $state.go($scope.checkNextState());
    };

    $scope.svuotaAggiuntivi = function () {
		$scope.data.step4.dnAggiuntiveTemp=[];
		$scope.data.step4.dnAggiuntive=[];
		$scope.data.step4.dn=null;
		$scope.data.step4.routingNumber=null;
	};

    $scope.submit_4 = function () {
    	if($scope.data.step4.dnAggiuntiveTemp){
    		$scope.data.step4.dnAggiuntive=[];
    		angular.forEach($scope.data.step4.dnAggiuntiveTemp, function(value, key) {
    			$scope.data.step4.dnAggiuntive.push(value);
    		});
    	} 

        $rootScope.data.step4 = $scope.data.step4;
        $scope.controlloBozza(5);
        if($scope.data.step4.dac){
        	if($rootScope.dacValidato){
        		$scope.salvaConfigurazioneOfferta();
        	}
        }else{
        	$scope.salvaConfigurazioneOfferta();
        }
    };

    /* Sezione Migrazione Start */
    
    $scope.headerDettaglioOrdineIdullco = [
                                           {"key": "idullco", "value": "Id", "type": "text"},
                                           {"key": "clli", "value": "Clli", "type": "text"},
                                           {"key": "nomeCentrale", "value": "Centrale", "type": "text"},
                                           {"key": "codiceGat", "value": "Codice GAT", "type": "text"}
                                       ];

   $scope.headerDettaglioOrdineIdsluco = [
                                               {"key": "idsluco", "value": "Id", "type": "text"},
                                               {"key": "codificaOloAgcom", "value": "Codifica Olo", "type": "text"}
                                       ];
   $scope.cancellaSelezioneIdullco = function () {
                                           $scope.data.step4.idullco = {};
                                           $scope.data.step4.searchIdullco = "";
                                       };

  $scope.cancellaSelezioneIdsluco = function () {
                                           $scope.data.step4.idsluco = {};
                                       };
  $scope.deleteIdsluco = function(){
                                       	$scope.data.step4.idsluco = {};
                                       };
  $scope.dettaglioOrdineCallbackIdullco = function (item) {
                                           $scope.data.step4.idullco = item;
                                           $scope.data.step4.searchIdullco = item.idullco;
                                       };

  $scope.dettaglioOrdineCallbackIdsluco = function (item) {
                                           $scope.data.step4.idsluco = item;
                                       };


  $scope.dettaglioOrdineGetIdullco = function ($event) {
                                           $event.preventDefault();

                                           $scope.modalOptionsTabellaDettaglioOrdineIdullco = {
                                               headerText: 'Seleziona un IDULLCo',
                                               actionButtonText: null,
                                               closeButtonText: 'Ok',
                                               contentType: 'modale_nowtable',
                                               scope: $scope,
                                               callbackFunction: 'dettaglioOrdineCallbackIdullco',
                                               dataHeader: $scope.headerDettaglioOrdineIdullco,
                                   			  data : $rootScope.formData.idullcos
                                           };

                                           var idullcos = IDULLCo.get({
                                                   codOLO: $scope.data.step1.operatore.codiceOLO,
                                                   valoreRicerca: $scope.data.step4.searchIdullco
                                               }
                                           );

                                           $scope.p4 = idullcos.$promise.then(
                                               function (response) {
                                                   $rootScope.formData.idullcos = response.data;
                                                   $scope.modalOptionsTabellaDettaglioOrdineIdullco.data = $rootScope.formData.idullcos;
                                                   modalService.showModal({}, $scope.modalOptionsTabellaDettaglioOrdineIdullco);
                                               }, function (error) {
                                                   $log.info("Impossibile caricare i codici IDULLCo." + error);
                                               });
                                       };
                                       
    $scope.dettaglioOrdineGetIdsluco = function ($event) {
        $event.preventDefault();

        $scope.modalOptionsTabellaDettaglioOrdineIdsluco = {
            headerText: 'Seleziona un IDSLUCo',
            actionButtonText: null,
            closeButtonText: 'Ok',
            contentType: 'modale_nowtable',
            scope: $scope,
            callbackFunction: 'dettaglioOrdineCallbackIdsluco',
            dataHeader: $scope.headerDettaglioOrdineIdsluco,
			data : $rootScope.formData.idslucos
        };

        var idslucos = IDSLUCo
            .get({
                codOLO: $scope.data.step1.operatore.codiceOLO,
                valoreRicerca: $scope.data.step4.idsluco.idsluco
            }
        );

        $scope.p3 = idslucos.$promise
            .then(
            function (response) {
                $rootScope.formData.idslucos = response.data;
                $scope.modalOptionsTabellaDettaglioOrdineIdsluco.data = $rootScope.formData.idslucos;
                modalService.showModal({}, $scope.modalOptionsTabellaDettaglioOrdineIdsluco);
            }, function (error) {
                $log.info("Impossibile caricare i codici IDSLUCO " + error);
                $scope.data.step4.idsluco={};

            });
    };
    
 // datepicker

    $scope.setDate = function (year, month, day) {
        $scope.dt = new Date(year, month, day);
    };

    $scope.formats = ['dd/MM/yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];

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

    $scope.today = function () {
        $scope.dt = new Date();
    };

    $scope.clear = function () {
        $scope.dt = null;
    };

    $scope.inlineOptions = {
        customClass: getDayClass,
        minDate: new Date(),
        showWeeks: false
    };

    $scope.dateOptions = {
        dateDisabled: disabled,
        formatYear: 'yy',
        maxDate: new Date(2500, 5, 22),
        minDate: new Date(),
        startingDay: 1
    };

    // Disable weekend selection
    function disabled(data) {
        var date = data.date, mode = data.mode;
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    }

    $scope.toggleMin = function () {
        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
    };

    $scope.toggleMin();
    
    $scope.openDP1 = function () {
        $scope.popup_dp1.opened = true;
    };

    $scope.openDP2 = function () {
        $scope.popup_dp2.opened = true;
    };

    $scope.popup_dp1 = {
        opened: false
    };

    $scope.popup_dp2 = {
        opened: false
    };
    
    $scope.caricaDac = true;
        
    /* Sezione Migrazione End */
	if($scope.data.step4 && $scope.data.step4.dac){
    	$scope.verificaDacLavorativo($scope.data.step4.dac);
    }
}]);  
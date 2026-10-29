timnow.controller('wlr', ['$scope', '$state', '$rootScope', '$log', 'modalService','$filter', 'VerificaPerVariazioneWlr',  function ($scope, $state, $rootScope, $log, modalService, $filter, VerificaPerVariazioneWlr ) {
	$scope.caricaDac = true;
	if($rootScope.data.step1.causale_ordine==='variazione'){
    	if($rootScope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    }
	if (!$rootScope.data.step4) {
        $rootScope.data.step4 = $scope.data.step4 = {};
    }
    //$log.info($rootScope.topDetails);

    $scope.tipoOfferta = $rootScope.formData.offers[0].idOfferta;

    //$log.info($rootScope.topDetails);

    if($rootScope.data.step1.causale_ordine==='migrazione'){
		$scope.datiView =[true,false];
		$scope.closeOthers=true;
    }
    
    $scope.calcolaTabVisualizzato = function () {
    	if(!$scope.configurazioneOffertaForm.$valid){
    		$scope.datiView =[true,true];
    		$scope.closeOthers=false;
    	}
    };
//    SE L'OFFERTA è WLR LA AL PRIMO PASSAGGIO VALORIZZO TUTTI I FLAG A FALSE
    if($rootScope.MAP_OFFERTE.WLR_LA.id === $rootScope.data.step3.offerta.idOfferta && (!$rootScope.customizedOffer.offerTopDetails.FLAGMANTENIMENTOPRODOTTI.dft)){
    	$rootScope.customizedOffer.offerTopDetails.FLAGMANTENIMENTOPRODOTTI.dft = false;
    }
    if($rootScope.MAP_OFFERTE.WLR_LA.id === $rootScope.data.step3.offerta.idOfferta && (!$rootScope.customizedOffer.offerTopDetails.FLAGAGGIUNTIVI.dft)){
    	$rootScope.customizedOffer.offerTopDetails.FLAGAGGIUNTIVI.dft = false;
    }
    if($rootScope.MAP_OFFERTE.WLR_LA.id === $rootScope.data.step3.offerta.idOfferta && (!$rootScope.customizedOffer.offerTopDetails.FLAGMANTENIMENTOSTS.dft)){
    	$rootScope.customizedOffer.offerTopDetails.FLAGMANTENIMENTOSTS.dft = false;
    }
    
//    CAMBIO STRUTTURA LINEA E PULISCO I CAMPI CHE DIPENDONO DA LUI
    $scope.cambioStrutturaLinea = function(){
    	$rootScope.customizedOffer.offerTopDetails.QUANTITALINEE.dft = $rootScope.customizedOffer.offerTopDetails.QUANTITACANALI.dft =  $rootScope.customizedOffer.offerTopDetails.ACCESSONUMERICO.dft = $rootScope.customizedOffer.offerTopDetails.SELEZIONEPASSANTE.dft = "";
    	$rootScope.customizedOffer.offerTopDetails.NUMAGGIUNTIVI.dft = ""; //SM_8700
    };
//    C11M08F51 Recupera Lista Codici per Variazioni WLR (S6)
    $scope.recuperaCodiciVariazione = function(){
    	var valoriConf = [{"funzione" : "C11M08F51", "opzioneVariazione" : $rootScope.data.step3.opzioneVariazione}];
    	$scope.configurazioneFE(valoriConf).then(function (response) {
            $scope.data.codiciVariazione = response.data;
        },
        function (error) {
        	$log.info('Impossibile caricare gli  STS');
        	$log.info(error);
        });
	
	//$log.debug($scope.data.STS);
    };
     
    
    $scope.salvaConfigurazioneOfferta = function () {
    	 $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
         	 $state.go($scope.checkNextState());
    };

    $scope.svuotaAggiuntivi = function () {
		$scope.data.step4.dnAggiuntiveTemp=[];
		$scope.data.step4.dnAggiuntive=[];
		$scope.data.step4.dn=null;
	};
    
    $scope.submit_4 = function () {
    	if($scope.data.step4.dnAggiuntiveTemp){
    		$scope.data.step4.dnAggiuntive=[];
    		angular.forEach($scope.data.step4.dnAggiuntiveTemp, function(value, key) {
    			$scope.data.step4.dnAggiuntive.push(value);
    		});
    	} 
    	
    	if($rootScope.data.step1.causale_ordine === 'variazione' && $scope.data.numAggiuntiva) {
    		
    		var numAgg = [];
    		angular.forEach($scope.data.numAggiuntiva, function(value, key) {
    			numAgg.push(value);
    			});
    		$scope.data.step4.numerazioneAggiuntiva = numAgg;
    	}
    	//SM_8535
    	if($rootScope.data.step1.causale_ordine === 'variazione'){
    		
    		if( $rootScope.data.step3.opzioneVariazione === "Attivazione STS" || $rootScope.data.step3.opzioneVariazione === "Cessazione STS" ){
    			
    			if( $rootScope.data.step3.opzioneVariazione === "Attivazione STS")
    				$scope.OpVar = "ATTIVO"
    			else
    				$scope.OpVar = "CESSATO"
    					
	    		$scope.verificaVarWlr={
	    				"opzioneVariazione": $scope.OpVar,
	    				"codiceSTS":$scope.data.step4.stsDaAttivare ? $scope.data.step4.stsDaAttivare :$scope.data.step4.stsDaCessare, //SM_8731
	    				"idRisorsa":$scope.data.step2.id_risorsa,
	    				"aggiuntiviISDN":$scope.data.step4.aggiuntiviISDN,
	    				"numerazioneAggiuntiva":$scope.data.step4.numerazioneAggiuntiva,
	    				"idAsset": $scope.data.step2.idAssetScelto ? $scope.data.step2.idAssetScelto.idAsset: null //SM_9028
	    		}
	    		VerificaPerVariazioneWlr.save($scope.verificaVarWlr).$promise.then(function (response) {
	          		 
			        if (response && response.esito === 'OK') {
			        	$log.debug('VerificaPerVariazioneWlr chiamato');
			    		$rootScope.data.step4 = $scope.data.step4;
				        $scope.salvaConfigurazioneOfferta();
				        $scope.controlloBozza(5);
			        } 
			        else {
			        	$log.debug("Errore VerificaPerVariazioneWlr");
			        	$scope.erroreService(response.descrizione);
			        }
			        
			     }, function (error) {
			    	 	$log.debug("Impossibile Verifica Per Variazione Wlr", error);
			    	 	$scope.erroreService("Impossibile completare l'operazione. Riprovare piu tardi");
			     });
    		}
    		//SM_8501
    		else {
	    		$rootScope.data.step4 = $scope.data.step4;
		        $scope.salvaConfigurazioneOfferta();
		        $scope.controlloBozza(5);
    		}
    			
    	}
    	//SM_8535
    	else{
	    	if($rootScope.MAP_OFFERTE.WLR_LNA.id === $rootScope.data.step3.offerta.idOfferta && $rootScope.data.step1.causale_ordine !== 'variazione' && ($rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'POTS') && (($rootScope.customizedOffer.offerTopDetails.STRUTTURALINEA.dft === 'PBX') || ($rootScope.customizedOffer.offerTopDetails.STRUTTURALINEA.dft === 'GNR'))){
	    		if($rootScope.customizedOffer.offerTopDetails.DIREZIONALITA.dft <= $rootScope.customizedOffer.offerTopDetails.QUANTITALINEE.dft){ 
	    			$rootScope.data.step4 = $scope.data.step4;
	    	        $scope.salvaConfigurazioneOfferta();
	    	        $scope.controlloBozza(5);
	    	    }else{
	    			$scope.erroreService("Il controllo di Verifica Direzionalità non è andato a buon fine.");
	    		}
	    	}else{
	    		$rootScope.data.step4 = $scope.data.step4;
		        $scope.salvaConfigurazioneOfferta();
		        $scope.controlloBozza(5);
	    	}
    	}
    };

    /* Sezione Migrazione Start */
    

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

       
       $scope.svuotaSTS = function () {
    	   if($scope.data && $scope.data.step4 && $scope.data.step4.stsDaAttivare){
    		   $scope.data.step4.stsDaAttivare="";
    	   }
    	   if($scope.data && $scope.data.step4 && $scope.data.step4.stsDaCessare){
    		   $scope.data.step4.stsDaCessare="";
    	   }
    	   $scope.data.step4.aggiuntiviISDN="";
    	   $scope.data.step4.numerazioneAggiuntiva=[];
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
       
    /* Sezione Migrazione End */
}]);
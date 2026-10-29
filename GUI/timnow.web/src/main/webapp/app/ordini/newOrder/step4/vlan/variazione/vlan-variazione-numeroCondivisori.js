//RU_1058
timnow.controller('vlanVariazioneNumeroCondivisoriStep4', ['$scope', '$state', '$rootScope', 'VLANUtils', 'VLAN_VARIAZIONI', 'RecuperaSubContractor', 'RecuperaCodOloSubContractor', '$q', 'VLAN_RACCOLTA_SERVIZI',
	function ($scope, $state, $rootScope, VLANUtils, VLAN_VARIAZIONI, RecuperaSubContractor, RecuperaCodOloSubContractor, $q, VLAN_RACCOLTA_SERVIZI) {

	$scope.enableEliminaCondivisore = false;
	$scope.enableAggiungiCondivisore = false;

	$scope.buttonAvantiAttivo = false;

	$scope.maxNumeroCondivisori = 10;	

	$scope._opzioniVariazioni = VLAN_VARIAZIONI;
	$scope._idOfferta = $scope.data.step3.offerta.idOfferta;
	$scope._idOffertaVLAN_NGA = $rootScope.MAP_OFFERTE.VLAN_NGA.id;
	$scope._idOffertaVLAN_GBE = $rootScope.MAP_OFFERTE.VLAN_GBE.id;
	$scope._opzioneVariazione = $scope.data.step3.opzioneVariazione;
	$scope._idRisorsa = $scope.data.step2.id_risorsa;
	$scope.numeroCondivisori = 0;
	
	if (!$scope.data.step4) {
		$rootScope.data.step4 = $scope.data.step4 = {};
	}
	
	if(!$scope.data.step4.arrayCondivisori){
		$scope.data.step4.arrayCondivisori = [];
	}
	
	if(!$scope.data.step4.arrayCondivisoriNuovi){
		$scope.data.step4.arrayCondivisoriNuovi = [];
	}

	if(!$scope.data.step4.offerBotDetails){
		$scope.data.step4.offerBotDetails = {};
	}
	
	if($scope.data.assetDetail){
		VLANUtils.estraiDettagliAsset($scope.data.assetDetail);
	}

	$scope.init = function(){  
		$scope.configureLabelServiziEstrazioneAsset();
		$scope.configureFamigliaVlan();
		$scope.configureCondivisori();
		$scope.configureNuoviCondivisori();
	}
	
	$scope.configureLabelServiziEstrazioneAsset = function(){
		switch($scope._idOfferta){
			case $rootScope.MAP_OFFERTE.VLAN_NGA.id:
					$scope._raccoltaServizi = VLAN_RACCOLTA_SERVIZI.VLAN_NGA;
				break;
			case $rootScope.MAP_OFFERTE.VLAN_GBE.id:
					$scope._raccoltaServizi = VLAN_RACCOLTA_SERVIZI.VLAN_GBE;
				break;
			case $rootScope.MAP_OFFERTE.VLAN_VULA.id:
					$scope._raccoltaServizi = VLAN_RACCOLTA_SERVIZI.VLAN_VULA;
				break;
		}
	}
	
	$scope.configureFamigliaVlan = function(){	
		$scope._famigliaVlan = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'FAMIGLIAVLAN');
		$scope._famigliaVlan = VLANUtils.trascodeFamigliaVlan($scope._famigliaVlan);
		$rootScope.customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft = $scope._famigliaVlan;
	}
	
	$scope.configureCondivisori = function(){
		if(!$scope.data.step4.arrayCondivisori || $scope.data.step4.arrayCondivisori.length == 0){
			$scope.recuperaSubContractor()
			.then(function(result){
				if(result.result.code == '0'){
					$scope.data.step4.arrayCondivisori = result.listaSubcontractor;
					$scope.data.step4.arrayCondivisori = VLANUtils.addAzioneToCondivisori($scope.data.step4.arrayCondivisori);
					$scope.updateNumeroCondivisori();
				}else{
					$scope.erroreService("Errore recupero condivisori");
				}
			}, function(error){
				$scope.erroreService(error.data.result.message);
			});
		}
	}

	$scope.configureNuoviCondivisori = function(){
		$scope.recuperaCodOloSubContractor()
		.then(function(result){
			if(result.result.code == '0'){
				$scope.listaCodOlo = result.listaCodOloSubcontractor;
			}else{
				$scope.erroreService("Errore subcontractor OLO");
			}

		}, function(error){
			$scope.erroreService(error.data.result.message);
		});		
	}

	$scope.updateNumeroCondivisori = function(){
		
		if(!$scope.data.step4.arrayCondivisori || $scope.data.step4.arrayCondivisori.length == 0){
			$scope.numeroCondivisori = $scope.data.step4.arrayCondivisoriNuovi.length;
		}else if(!$scope.data.step4.arrayCondivisoriNuovi || $scope.data.step4.arrayCondivisoriNuovi.length == 0){
			$scope.numeroCondivisori = $scope.data.step4.arrayCondivisori.length;
			$scope.buttonAvantiAttivo = true;
		}else{
			$scope.numeroCondivisori = $scope.data.step4.arrayCondivisori.length + $scope.data.step4.arrayCondivisoriNuovi.length;
		}
	}

	$scope.deleteCondivisoreNuovo = function(index){
		$scope.data.step4.arrayCondivisoriNuovi.splice(index, 1);
		$scope.updateNumeroCondivisori();
	}

	$scope.addNuovoCondivisore = function(event){
		
		event.preventDefault();		
		$scope.data.step4.arrayCondivisoriNuovi.push({});		
	}	
	
	$scope.addAzione = function(index){		
		if($scope.data.step4.arrayCondivisoriNuovi[index]){
			$scope.data.step4.arrayCondivisoriNuovi[index].azione = 'A';
		}
	}

	$scope.recuperaSubContractor = function(){
		return RecuperaSubContractor.get({idRisorsa: $scope._idRisorsa}).$promise;
	}

	$scope.recuperaCodOloSubContractor = function(){
		return RecuperaCodOloSubContractor.get({idRisorsa: $scope._idRisorsa}).$promise;
	}

	//Preparo la struttura dell'array da inviare per lo step 8
	$scope.buildArrayCondivisoriToSend = function(){
		var _array = [];    	
		var counter = 0;

		//Estraggo solo i vecchi condivisori con AZIONE == 'C' 
		if($scope.data.step4.arrayCondivisori && $scope.data.step4.arrayCondivisori.length > 0){		
			$scope.data.step4.arrayCondivisori.forEach(function(item, index){
				if(item.azione && item.azione == 'C'){
					counter++;
					var _azione = {
							key: "AZIONE",
							componente: "OLOVLAN",
							tipologiaDato: "VARCHAR2",
							dft: item.azione,
							progressivo: counter,
							domain: "list",
							label: "Azione"
					};
					var _codOloNumerico = {
							key: "CODICEOLONUMERICO",
							componente: "OLOVLAN",
							tipologiaDato: "VARCHAR2",
							dft: item.codiceOloNumerico,
							progressivo: counter,
							domain: "list",
							label: "CodiceOlo"
					};
					var _codOloAgcom = {
							key: "CODIFICAOLOAGCOM",
							componente: "OLOVLAN",
							tipologiaDato: "VARCHAR2",
							dft: item.codOloAgcom,
							progressivo: counter,
							domain: "list",
							label: "Codice Olo Agcom"
							
					}						
					_array.push(_azione);
					_array.push(_codOloNumerico);
					_array.push(_codOloAgcom);
				}
			});    		
		}
		if($scope.data.step4.arrayCondivisoriNuovi && $scope.data.step4.arrayCondivisoriNuovi.length > 0){	
			$scope.data.step4.arrayCondivisoriNuovi.forEach(function(item, index){
					counter++;
					var _azione = {
							key: "AZIONE",
							componente: "OLOVLAN",
							tipologiaDato: "VARCHAR2",
							dft: 'A',
							progressivo: counter,
							domain: "list",
							label: "Azione"
					};
					var _codOloNumerico = {
							key: "CODICEOLONUMERICO",
							componente: "OLOVLAN",
							tipologiaDato: "VARCHAR2",
							dft: item.codOloNumerico,
							progressivo: counter,
							domain: "list",
							label: "CodiceOlo"
					};
					var _codOloAgcom = {
							key: "CODIFICAOLOAGCOM",
							componente: "OLOVLAN",
							tipologiaDato: "VARCHAR2",
							dft: item.codOloAgcom,
							progressivo: counter,
							domain: "list",
							label: "Codice Olo Agcom"
					}						
					_array.push(_azione);
					_array.push(_codOloNumerico);
					_array.push(_codOloAgcom);
			});
		}		
		return _array;
	}
	
	$scope.mergeCondivisori = function(){
		var _array = [];	
		
		if($scope.data.step4.arrayCondivisori && $scope.data.step4.arrayCondivisoriNuovi){
			_array = $scope.data.step4.arrayCondivisori.concat($scope.data.step4.arrayCondivisoriNuovi);
		}else if($scope.data.step4.arrayCondivisori && $scope.data.step4.arrayCondivisori.length > 0){
			_array = $scope.data.step4.arrayCondivisori;
		}else if($scope.data.step4.arrayCondivisoriNuovi && $scope.data.step4.arrayCondivisoriNuovi.length > 0){
			_array = $scope.data.step4.arrayCondivisoriNuovi;
		}		
			
		return _array;
	}
	
	//Ricerca condivisori duplicati e nel caso, inibisce il passaggio allo step successivo
	$scope.checkDuplicateCondivisori = function(){
		
    	var appArray = angular.copy($scope.data.step4.condivisori);    	
    	var _result = {
    		flag: false,
    		codice: ""	
    	};
    	var _codice = "";
    	var _arrayCodici = [];
    	
    	if(appArray && appArray.length > 0){
    		
    		appArray.forEach(function(item){
    			_arrayCodici.push(item.codOloAgcom);
    		});
    		
    		if(_arrayCodici && _arrayCodici.length > 0){
    			_arrayCodici.forEach(function(item, index, array){
    				var _index = array.indexOf(item);
    				var _lastIndex = array.lastIndexOf(item);
    				if(_index != _lastIndex){
    					//Duplicato
    					_result.flag = true;
    					_result.codice = item;    					
    				}
    			});
    		}

    	}
    	return _result;
	}

	$scope.submit_4 = function () {

		$scope.data.step4.condivisoriToSend = $scope.buildArrayCondivisoriToSend();
		$scope.data.step4.condivisori = $scope.mergeCondivisori();
		
		//SM_9791
		var _check = $scope.checkDuplicateCondivisori();
		if(_check && _check.flag){
	    	$scope.erroreService("Attenzione: hai inserito più volte il condivisore con codice olo Agcom " + _check.codice); 
	    	return;
		}

		$rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4; 

		$state.go($scope.checkNextStateVariazione());	

	};

	$scope.init();

	$scope.$watch(function(){
		return $scope.numeroCondivisori;
	}, function(newValue, oldValue){
		if(newValue == 0){
			$scope.enableAggiungiCondivisore = true;
			$scope.buttonAvantiAttivo = false;
		}
		if(newValue >= 1 && newValue < 10){
			$scope.enableAggiungiCondivisore = true;
		}    		
		if(newValue == 10){
			$scope.enableAggiungiCondivisore = false;
		}
	});
	
	$scope.$watchCollection("data.step4.arrayCondivisoriNuovi", function(newValue, oldValue){
		if(newValue && newValue.length > 0){	
			var _array = [];
			$scope.data.step4.arrayCondivisoriNuovi.forEach(function(item){
				if(JSON.stringify(item) == '{}'){
					_array.push(item);					
				}
			});
			
			$scope.buttonAvantiAttivo = !(_array.length > 0);
		}
		$scope.updateNumeroCondivisori();
	});

}]);  
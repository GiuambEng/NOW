timnow.controller('newOrderStep6', ['$scope', '$state', '$rootScope', '$log', '$http', 'BASEPATH', 'Addresses', 'Districts', 'modalService', 'VerificaComuneOffertaInfratel', 'VerificaCongruenzaClusterComuneVlan', '$q', 'VerificaContrattoCoinvestimentoComune',
	function ($scope, $state, $rootScope, $log, $http, BASEPATH, Addresses, Districts, modalService, VerificaComuneOffertaInfratel, VerificaCongruenzaClusterComuneVlan, $q, VerificaContrattoCoinvestimentoComune) {

    if ($rootScope.formData.stepReached < 6) $rootScope.formData.stepReached = 6;
    $scope.loadingAddresses = false;
    $scope.districtChecked = false;
    
	if (!$rootScope.data.step6) {
		$rootScope.formData.data.step6 = $rootScope.data.step6 = $scope.data.step6 = {};
    }
    
    //RU_XXXX
    $scope._isOffertaFullGponPlus = ([$rootScope.MAP_OFFERTE.FULLGPONPLUS.id, $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id].indexOf($rootScope.data.step3.offerta.idOfferta) >= 0);
    
    /**
     * Pulizia dei campi del cliente finale che avviene quando si clicca sulla x acconto al campo
     *
     * @param field
     */
    $scope.resetAllFieldsAfter = function (field, value) {
        //$log.debug('resetAllFieldsAfter ' + field);
    	if(field === 'reseProvincia') {
    		$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_cap =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_piano =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_complesso =
    		$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_scala =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_interno ='';
    		
    		$scope.data.address_parts= {};
    		}
    	if(field === 'resetComune') {
    		$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune =
    		$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_cap =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_piano =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_complesso =
    		$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_scala =
            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_interno ='';
    		
    		$scope.data.address_parts= {};
    	}
    	if(field === 'resetToponomastica') {
                $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo =
                        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico =
                            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_cap =
                                $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_piano =
                                    $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_complesso =
                                        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_scala =
                                            $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_interno ='';
    	}
        
    	 if (field !== 'comune' && field !== 'toponomastica' && field !== 'indirizzo' && field !== 'resetToponomastica') {
    		 $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune = '';
         }

         if (field !== 'comune' && field !== 'toponomastica' && field !== 'indirizzo' && field !== 'resetToponomastica') {
             $scope.indirizzo_cliente_localita = '';
         }

        /* if (field !== 'toponomastica' && field !== 'indirizzo') {
             $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica = '';
         }*/

         if (field !== 'indirizzo') {
             $scope.data.step6.indirizzo_cliente_indirizzo = '';
         }
         $scope.data.step6.indirizzo_cliente_civico = '';
         $scope.data.step6.indirizzo_cliente_cap = '';
         $scope.data.step6.indirizzo_cliente_piano = '';
         $scope.data.step6.indirizzo_cliente_complesso = '';
         $scope.data.step6.indirizzo_cliente_scala = '';
         $scope.data.step6.indirizzo_cliente_interno = '';
    };


    $scope.indirizzoSedeObbligatorio = true;


    $scope.controlloLA = function() {
        if($scope.data.step1.causale_ordine==='migrazione' || ($scope.data.step1.causale_ordine!=='migrazione' && [$rootScope.MAP_OFFERTE.ULL_LA.id,$rootScope.MAP_OFFERTE.ULLD_LA.id,
                $rootScope.MAP_OFFERTE.SLU_LA.id,$rootScope.MAP_OFFERTE.SHA_CM.id,
                $rootScope.MAP_OFFERTE.SHA_SM.id,$rootScope.MAP_OFFERTE.WLR_LA.id,
                $rootScope.MAP_OFFERTE.VULL_LA.id,$rootScope.MAP_OFFERTE.ULL_LANP.id,
                $rootScope.MAP_OFFERTE.ULLD_LANP.id,$rootScope.MAP_OFFERTE.SLU_LANP.id].indexOf($rootScope.data.step3.offerta.idOfferta)>=0)
            && !($scope.data.step6 && $scope.data.step6.indirizzoDatiClienteFinale && $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia)){
            $scope.indirizzoSedeObbligatorio = false;
        } else {
            $scope.indirizzoSedeObbligatorio = true;
        }
        //SM_8442
        if($scope.data.step1.causale_ordine==='variazione' && $rootScope.MAP_OFFERTE.WLR_LA.id===$rootScope.data.step3.offerta.idOfferta){
        	$scope.indirizzoSedeObbligatorio = true;
        }
    };



    $scope.indirizzoSedeObbligatorioNonRegolatorio = !($scope.data.step1.causale_ordine === 'migrazione' || ($scope.data.step1.causale_ordine !== 'migrazione' && ($rootScope.customizedOffer && $rootScope.customizedOffer.offerTopDetails &&
        $rootScope.customizedOffer.offerTopDetails.TIPOLINEA && $rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft
        && (($rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'POTS') ||
            ($rootScope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'ISDN')))));
    
    //aggiunta per verificare che non si inserisca sia cf e piva
    $scope.checkUniqueCFPiva = function () {
    	if (($scope.data.step6.datiClienteFinale.partita_iva_cliente && $scope.data.step6.datiClienteFinale.partita_iva_cliente.length>0) &&
    	    ($scope.data.step6.datiClienteFinale.codice_fiscale_cliente && $scope.data.step6.datiClienteFinale.codice_fiscale_cliente.length>0)){
            modalService.showModal({}, {
                headerText: "Avviso",
                bodyText: "Inserire esclusivamente codice fiscale o partita iva.",
                actionButtonText: 'Chiudi',
                type: 'warning'
            });
            
            $scope.data.step6.datiClienteFinale.codice_fiscale_cliente="";
            $scope.data.step6.datiClienteFinale.partita_iva_cliente="";
    	}
    		
    };
    
    $scope.validaDatiCliente = function (form) {
        if (form && ((form.nome_cliente && form.nome_cliente.$invalid)
                || (form.cognome_cliente && form.cognome_cliente.$invalid)
                || (form.codice_fiscale_cliente && form.codice_fiscale_cliente.$invalid)
                || (form.partita_iva_cliente && form.partita_iva_cliente.$invalid))) {
            $scope.datiFinalView = [true, false];
        } else {
            $scope.datiFinalView = [false, true];
        }
        angular.forEach(form.$error.required, function (field) {
            field.$setDirty();
            $scope.caricaPassFive = false;
        });
    };


    $scope.populateCities = function ($item) {
        if (!$rootScope.bozza) this.resetAllFieldsAfter('provincia');
        var cities = Addresses.get({
            selectedProvince: $item
        });
        cities.$promise.then(function (response) {
            $scope.cities = response.items;
        }, function () {
            $log.debug("Impossibile caricare i comuni.");
        });
        $scope.controlloLA();
    };

    $scope.populateLocalita = function (item) {
        if (!$rootScope.bozza) this.resetAllFieldsAfter('comune');
        $scope.populatePartToponomastica(item);
    };

    $scope.populatePartToponomastica = function (item) {
        var addressParts = Addresses.get({
            selectedProvince: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia,
            selectedCity: item
        });
        addressParts.$promise.then(function (response) {
            $scope.data.address_parts = response.items;
        }, function () {
            $log.debug("Impossibile caricare le particelle toponomastiche. Riprovare più tardi");
        });
    };

    $scope.populateAddresses = function (val) {
    	/*var charsLimit = $rootScope.timnowConfigData.config.charsLimitForAutocomplete || 2;
    	if(val && val.length > parseInt(charsLimit)){*/
    		var parameters= {
    				params: {
    					selectedProvince: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia,
    					selectedCity: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune,
    					selectedParticle: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica,
    					query: val
    				}
    			};

    		$scope.loadingAddresses = true;
    		return $http.get(BASEPATH + 'address', parameters).then(
    	            function (response) {
    	            	$scope.loadingAddresses = false;
   	                    return (response && response.data) ? response.data.items : [];
    	            });
    	/*} else {
    		$log.info("caratteri non sufficienti...");
    	}*/
    };

    $scope.populateHouseNumbers = function () {
//		$log.debug('populateHouseNumbers');

        var houseNumbers = Addresses.get({
            selectedProvince: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia,
            selectedCity: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune,
            selectedParticle: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica,
            selectedAddress: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo
        });
        houseNumbers.$promise.then(function (response) {
            $scope.data.house_numbers = response.items;
        }, function () {
            $log.debug("Impossibile caricare i numeri civici. Riprovare più tardi");
        });
    };

    //RU_716
    $scope.controlloRecuperaDistretto = function() {

    	$scope.districtChecked = false;
    	
    	var params = {
			'provincia': $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia,
			'comune': $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune,
			'toponomastica': $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica,
			'indirizzo': $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo,
			'civico': $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico,
			'lavorazione': $scope.data.step1.causale_ordine
    	};

    	Districts.get(params).$promise.then(
            function (data) {
                $scope.districtChecked = true;
                
                if(data.esito=="OK") {
                	$state.go($scope.checkNextState());
                } else {
                	modalService.showModal({}, {
                        headerText: "Avviso",
                        closeButtonText: 'Chiudi',
                        bodyText: data.message,
                        scope: $scope,
                        type: 'error'
                    });	
                }
            },
            function (error) {
                $log.error(error);
                $scope.districtChecked = true;
                modalService.showModal({}, {
                        headerText: "Avviso",
                        closeButtonText: 'Chiudi',
                        bodyText: "Errore durante il controllo distretto. Riprovare più tardi",
                        scope: $scope,
                        type: 'error'
                    });	
           });
    	
    };
    
    $scope.cancellaToponomastica = function () {
        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica = "";
    };
    $scope.cancellaIndirizzo = function () {
        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo = "";
    };
    $scope.cancellaCivico = function () {
        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico = "";
    };

    // INIZIALIZZAZIONE BOZZA
    function init() {
        if ($rootScope.bozza) {
            if ($rootScope.bozza.data) {
                if ($rootScope.bozza.data.step6 && $rootScope.bozza.data.step6.indirizzoDatiClienteFinale) {
                    if ($rootScope.bozza.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia) {
                        $scope.populateCities($rootScope.bozza.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia);
                    }
                    if ($rootScope.bozza.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune) {
                        $scope.populateLocalita($rootScope.bozza.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune);
                    }
                    if ($rootScope.bozza.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo) {
                        $scope.populateHouseNumbers($rootScope.bozza.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo);
                    }
                }
            }
        }
        
        $scope.controlloLA();
    }
    
    //RU_1060
    
    //C11M08F75 - Verifica Comune/Offerta Infratel
    $scope.C11M08F75 = function(){
    	
    	var _lavorazione = $scope.data.step1.causale_ordine;
    	var _request = {
        		lavorazione: $scope.data.step1.causale_ordine,
        		codificaOloAgcom: $scope.data.step1.operatore.codiceOLO       		
        	};
    	
    	if(_lavorazione == 'migrazione'){
    		_request.codificaOloAgcom = $scope.data.step1.operatore.codiceOLO;
    		//SM_9563
    		//SM_9602
    		_request.idAsset = ($scope.data.assetDetail != null ? $scope.data.assetDetail.idAsset : null);
    		_request.codiceIstatComuneAsset = ($scope.data.assetDetail != null ? $scope.data.assetDetail.codIstatComune : null);    		    		
    	}
    	
    	if($scope.data.step6.indirizzoDatiClienteFinale){
        	_request.indirizzoDatiClienteFinale = {}; 
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_provincia =	$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_comune = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_civico = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico;
    	}  	
    	
    	return VerificaComuneOffertaInfratel
    			.save({}, _request).$promise;   	
    }
    
    //C11M08F84 - Verifica Comuni Coinvestimento
    $scope.C11M08F84 = function(){
    	//SM_10064
    	var _lavorazione = $scope.data.step1.causale_ordine;
    	
    	var _request = {
    			idOfferta: $scope.data.step3.offerta.idOfferta,
    			idContratto: $scope.data.step2.contratto.idContratto,
    			lavorazione: _lavorazione
        	};
    	
    	//SM_10105
    	if($scope.data.step6.indirizzoDatiClienteFinale && $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia != ""){
        	_request.indirizzoDatiClienteFinale = {}; 
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_provincia =	$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_comune = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_civico = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico;
    	}else if(_lavorazione == 'migrazione' && $scope.data.assetDetail){
        	_request.indirizzoDatiClienteFinale = {}; 
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_provincia = $scope.data.assetDetail.provincia;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_comune = $scope.data.assetDetail.comune;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica = $scope.data.assetDetail.descParticellaToponomastica;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo = $scope.data.assetDetail.via;
        	_request.indirizzoDatiClienteFinale.indirizzo_cliente_civico = $scope.data.assetDetail.numero;
        	_request.codiceIstatComune = $scope.data.assetDetail.codIstatComune;
    	}  	
    	
    	return VerificaContrattoCoinvestimentoComune
    			.save({}, _request).$promise; 
    }
    
    $scope.oscuramento_RU_1060 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1060.oscurato){   				
   					$scope.RU_1060 = ($rootScope.OSCURAMENTI.RU_1060.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);  				
    			}else{
    				$scope.RU_1060 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.RU_1060 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1060();
    
    //RU_1089
    //C11M08F79 - Verifica Congruenza Cluster Comune VLAN
    $scope.C11M08F79 = function(){
    	
    	var _lavorazione = $scope.data.step1.causale_ordine;
    	var _request = {
        		lavorazione: $scope.data.step1.causale_ordine,
        		codificaOloAgcom: $scope.data.step1.operatore.codiceOLO,
        		idOfferta: $scope.data.step3.offerta.idOfferta,
        		codiciVlan: []
        	};
    	
    	if(_lavorazione == 'migrazione'){
    		_request.idAsset = ($scope.data.assetDetail != null ? $scope.data.assetDetail.idAsset : null);
    		_request.codiceIstatComune = ($scope.data.assetDetail != null ? $scope.data.assetDetail.codIstatComune : null);    		    		
    	}
    	
    	if($scope.data.step6.indirizzoDatiClienteFinale){
        	_request.indirizzoClienteFinale = {}; 
        	_request.indirizzoClienteFinale.indirizzo_cliente_provincia =	$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia;
        	_request.indirizzoClienteFinale.indirizzo_cliente_comune = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune;
        	_request.indirizzoClienteFinale.indirizzo_cliente_particella_toponomastica = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica;
        	_request.indirizzoClienteFinale.indirizzo_cliente_indirizzo = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo;
        	_request.indirizzoClienteFinale.indirizzo_cliente_civico = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico;
    	}  
    	    	
    	if($scope.data.step4.vlanusers && $scope.data.step4.vlanusers.length > 0){
    		if($rootScope.customizedOffer.offerTopDetails.ENCAPSULATION){
    			if($rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft == 'SINGLETAG'){
    				$scope.data.step4.vlanusers.forEach(function(item, index){
    					//SM_10247
    					if(item.codice_vlan && item.codice_vlan != ''){
    						_request.codiciVlan.push(item.codice_vlan);
    					}
    				});
    			}
    			if($rootScope.customizedOffer.offerTopDetails.ENCAPSULATION.dft == 'DOUBLETAG'){
    				$scope.data.step4.vlanusers.forEach(function(item, index){
    					//SM_10247
    					if(item.SVLANCODE && item.SVLANCODE.dft && item.SVLANCODE.dft != ''){
    						_request.codiciVlan.push(item.SVLANCODE.dft);
    					}
    				});
    			}
    		}
    	}
    	
    	return VerificaCongruenzaClusterComuneVlan
    			.save({}, _request).$promise;   	
    }
    
    $scope.oscuramento_RU_1089 = function(){
		
    	try{
    		if($scope.data.step3.offerta.idOfferta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1089.oscurato){
    				$scope.RU_1089 = ($rootScope.OSCURAMENTI.RU_1089.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_1089 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_1089 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1089();
    
    //RU_1164
    $scope.oscuramento_RU_1164 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1164.oscurato){   				
   					$scope.RU_1164 = ($rootScope.OSCURAMENTI.RU_1164.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);  				
    			}else{
    				$scope.RU_1164 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.RU_1164 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1164();   
    
    //RU_1299
    $scope.oscuramento_RU_1299 = function(){
		try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1299.oscurato){   				
   					$scope.RU_1299 = ($rootScope.OSCURAMENTI.RU_1299.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);			
    			}else{
    				$scope.RU_1299 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.RU_1299 = false;
    	}
	}
	
	$scope.oscuramento_RU_1299();
        
    init();

    $scope.submit_6 = function () {
    	if($scope.data.step6===null){
    		$scope.data.step6={};
    	}
    	
        $rootScope.formData.data.step6 = $rootScope.data.step6 = $scope.data.step6; 
        $scope.controlloBozza(7);
        
        //RU_716 if !FWA else controlloRecuperaDistretto e poi go 
        
        if($rootScope.data.step3.offerta.idOfferta != "46") {
        	
        	//RU_1089
        	var _lavorazione = $scope.data.step1.causale_ordine;
        	
        	var _promises = [];
        	if(_lavorazione == 'attivazione' || _lavorazione == 'migrazione'){
				//RU_1299
				//RU_XXXX
				var _offerteC11M08F75 = [
					$rootScope.MAP_OFFERTE.VULA_H.id,
					$rootScope.MAP_OFFERTE.NGA_H.id,
					$rootScope.MAP_OFFERTE.EASY_H.id,
					$rootScope.MAP_OFFERTE.SEMI_VULA_H.id,
					$rootScope.MAP_OFFERTE.SEMI_BTS_H.id,
					$rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id,
					$rootScope.MAP_OFFERTE.FULLGPONPLUS.id,
					$rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id
				];
        		if((($scope.RU_1060 && !$scope.RU_1299) || $scope._isOffertaFullGponPlus) && _offerteC11M08F75.indexOf($rootScope.data.step3.offerta.idOfferta) >= 0) {
        			_promises.push($scope.C11M08F75());
        		}
        		if($scope.RU_1089){
        			_promises.push($scope.C11M08F79());
        		}
        		
        		//RU_1164
        		if($scope.RU_1164){
        			_promises.push($scope.C11M08F84());
        		}
        		
        		if(_promises.length > 0){
            		$q.all(_promises)
        			.then(function(responses){
        				if(responses && responses.length > 0){
        					var _gotoNextStep = true;
        					var _messages = [];
        					responses.forEach(function(response, index){
        						if(response.VerificaComuneOffertaInfratelOutput && response.VerificaComuneOffertaInfratelOutput.esito == 'KO'){
        							_gotoNextStep = false;
        							_messages.push(response.VerificaComuneOffertaInfratelOutput.message);
        						}
        						if(response.VerificaCongruenzaClusterComuneVlanOutput && response.VerificaCongruenzaClusterComuneVlanOutput.esito == 'KO'){
        							_gotoNextStep = false;
        							_messages.push(response.VerificaCongruenzaClusterComuneVlanOutput.message);
        						}
        						//RU_1164
        						if(response.VerificaContrattoCoinvestimentoComuneOuput && response.VerificaContrattoCoinvestimentoComuneOuput.esito == 'KO'){
        							_gotoNextStep = false;
        							_messages.push(response.VerificaContrattoCoinvestimentoComuneOuput.message);
        						}        						
        					});
    						if(_gotoNextStep){
    							$state.go($scope.checkNextState());
    						}else{
    							_messages.forEach(function(message, index){
    	            				modalService.showModal({}, {
    	            	                headerText: "Avviso",
    	            	                bodyText: message,
    	            	                actionButtonText: 'Chiudi',
    	            	                type: 'warning'
    	            	            });
    							});
    						}
        				}
        			}, function(error){
        				modalService.showModal({}, {
        	                headerText: "Avviso",
        	                bodyText: "Impossibile effettuare le verifiche",
        	                actionButtonText: 'Chiudi',
        	                type: 'warning'
        	            });
        			});
        		}else{
        			$state.go($scope.checkNextState());
        		}       		
        	}else{
        		$state.go($scope.checkNextState());
        	}
        } else {
        	$scope.controlloRecuperaDistretto();
        }         
    	
    };
}]);
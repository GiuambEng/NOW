//RU_1475
timnow.controller('eoloAttivazioneStep6', ['$scope', '$state', '$rootScope', '$log', '$http', 'BASEPATH', 'AddressesEoloFwa', 'modalService',
	function ($scope, $state, $rootScope, $log, $http, BASEPATH, AddressesEoloFwa, modalService) {

    if ($rootScope.formData.stepReached < 6) $rootScope.formData.stepReached = 6;
    $scope.loadingAddresses = false;
    $scope.districtChecked = false;
    
	if (!$rootScope.data.step6) {
		$rootScope.formData.data.step6 = $rootScope.data.step6 = $scope.data.step6 = {};
    }    
    
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
        var cities = AddressesEoloFwa.get({
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
        var addressParts = AddressesEoloFwa.get({
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
    		var parameters= {
    				params: {
    					selectedProvince: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia,
    					selectedCity: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune,
    					selectedParticle: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica,
    					query: val
    				}
    			};

    		$scope.loadingAddresses = true;
    		return $http.get(BASEPATH + 'eoloFwa/address', parameters).then(
    	            function (response) {
    	            	$scope.loadingAddresses = false;
   	                    return (response && response.data) ? response.data.items : [];
    	            });
    };

    $scope.populateHouseNumbers = function () {

        var houseNumbers = AddressesEoloFwa.get({
            selectedProvince: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_provincia,
            selectedCity: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_comune,
            selectedParticle: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica,
            selectedAddress: $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo
        });
        houseNumbers.$promise.then(function (response) {
            $scope.data.house_numbers = response.civico;
            $scope.data.egon_numbers = response.codiceEgon;
        }, function () {
            $log.debug("Impossibile caricare i numeri civici. Riprovare più tardi");
        });
    };
    
    $scope.populateCodiceEgon = function () {
		var _civico = $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico;
		if(_civico && _civico != ''){
			var _index = _.indexOf($scope.data.house_numbers, _civico);
			if(_index > -1){
				$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_codice_egon = $scope.data.egon_numbers[_index];
			} 
		}else{
			$scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_codice_egon = '';
		}
    };

    
    $scope.cancellaToponomastica = function () {
        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_particella_toponomastica = "";
    };
    $scope.cancellaIndirizzo = function () {
        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_indirizzo = "";
    };
    $scope.cancellaCivico = function () {
        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_civico = "";
        $scope.data.step6.indirizzoDatiClienteFinale.indirizzo_cliente_codice_egon = "";
    };

    // INIZIALIZZAZIONE BOZZA
    $scope.init = function() {
		AddressesEoloFwa.get({type:"provinces"}).$promise.then(
           function (response) {
                $rootScope.formData.provinces = response.items;
            }
        );
	
	
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
        
    $scope.init();

    $scope.submit_6 = function () {
    	if($scope.data.step6===null){
    		$scope.data.step6={};
    	}
    	
        $rootScope.formData.data.step6 = $rootScope.data.step6 = $scope.data.step6; 
        $scope.controlloBozza(7);
        
        $state.go($scope.checkNextState());  
    	
    };
}]);
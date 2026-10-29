//RU_1180
timnow.controller('feederAttivazioneStep7', ['$scope', '$state', '$rootScope', 'Locator', 'modalService', 'VisualizzaCampiOfferteMulticast', '$uibModal',
	function ($scope, $state, $rootScope, Locator, modalService, VisualizzaCampiOfferteMulticast, $uibModal) {
		
	$scope.arrayCodiceTDKit = [];
	$scope.arrayMacroArea = [];
	$scope.arrayIdVlanOlo = [];
	$scope.arrayClliFeeder = [];
	$scope.arrayBandaFeeder = [];
	$scope.arrayAsNumber = [];
	$scope.arrayIpSessione = [];
	
	$scope.rangeIdentificativoVlan = /^([2-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-3][0-9]{3}|4000)$/;
	
	$scope._idContratto = $scope.data.step2.contratto.idContratto;
	$scope._codOloAgcom = $scope.data.step1.operatore.codiceOLO;
 
	$scope.headerTabellaTdKit = [];
	$scope.headerTabellaTdKit.push({"key": "valoreCampo","value": "Codice TD kit","type": "text"});
	$scope.headerTabellaTdKit.push({"key": "tipoApparato","value": "Tipo Apparato","type": "text"});
	
	//RU_1199
	$scope.headerTabellaCLLIFeeder = [];
	$scope.headerTabellaCLLIFeeder.push({"key": "valoreCampo","value": "CLLI Feeder","type": "text"});
	$scope.headerTabellaCLLIFeeder.push({"key": "nomeCentrale","value": "Nome Centrale","type": "text"});
	
	$scope._codiceTDKIT =  null;
	
	$scope._flagPrimoFeeder = ($rootScope.primoFeeder ? 'Y' : 'N');	
	
        
	if (!$rootScope.data.step7) {
        $rootScope.data.step7 = $scope.data.step7 = {};
        $rootScope.data.step7.datiOfferteMulticast = $scope.data.step7.datiOfferteMulticast = {};
    }
    
    $scope.init = function(){
		$scope.data.step7.datiOfferteMulticast = {
			idVlanOlo: "",
			clliFeeder: "",
			macroArea: "",
			codiceTdKit: "",
			bandaFeeder: "",
			asNumber: "",
			ipSessione: ""
		};
		$scope.cleanErrorMessages();
        $scope.configureMacroArea();
        $scope.configureBandaFeeder();
        $scope.configureIdVlanOlo();
        $scope.configureAsNumber();
        $scope.configureIpSessioneEbgp();
    }
    
	/**
	 * 	Per Macro Area
	 */
	$scope.configureMacroArea = function(){

		$scope.arrayMacroArea = [];
		$scope.loadingMacroArea = true;
		
		var _request = {
			codOloAgcom: $scope._codOloAgcom,
			idContratto: $scope._idContratto,
			nomeCampo: 'MACROAREA',
			flagPrimoFeeder: $scope._flagPrimoFeeder				
		};	
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
			.then(function(data){
				$scope.loadingMacroArea = false;
				if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){
					var _array = data.outputCampiOfferteMulticast.map(function(item) {return item.valoreCampo;});					
					angular.copy(_array, $scope.arrayMacroArea);
				}else{
					$scope.erroreService("Attenzione, non esiste nessuna MacroArea senza Primo Feeder associato, non e' possibile procedere con l''inserimento dell’ordine richiesto");
					$scope.cleanMacroArea();
				}
			}, function(error){
				$scope.loadingMacroArea = false;
				$scope.cleanMacroArea();
				$scope.erroreService("Errore nel recupero dati Macro Area");
			});
	}
	
	/**
	 * Per CLLIFeeder
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureClliFeeder = function(event){		

		event.preventDefault();
		
		$scope.loadingClliFeeder = true;
		$scope.arrayClliFeeder = [];			
		
		var _request = {
				codOloAgcom: $scope._codOloAgcom,
				idContratto: $scope._idContratto,
				nomeCampo: 'CLLIFEEDER',
				descrArea: $scope.data.step7.datiOfferteMulticast.macroArea, 
				flagPrimoFeeder: $scope._flagPrimoFeeder				
			};	
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
		.then(function(data){
			$scope.loadingClliFeeder = false;
			if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){
				angular.copy(data.outputCampiOfferteMulticast, $scope.arrayClliFeeder);
			}
			$scope.selectCLLIFeeder();
		}, function(error){
			$scope.loadingClliFeeder = false;
			$scope.cleanClliFeeder();
			$scope.erroreService("Errore nel recupero dati CLLI Feeder");				
		});
	}
	
	//RU_1199
	$scope.selectCLLIFeeder = function(){
        var _modalConfig = {
             headerText: 'Seleziona CLLI Feeder',
             actionButtonText: null,
             closeButtonText: 'Ok',
             contentType: 'modale_nowtable',
             scope: $scope,
             callbackFunction: 'callbackSelectCLLIFeeder',
             dataHeader: $scope.headerTabellaCLLIFeeder,
             data: $scope.arrayClliFeeder
         };
         modalService.showModal({}, _modalConfig);
	}
	
	$scope.callbackSelectCLLIFeeder = function(item){
		$scope.data.step7.datiOfferteMulticast.clliFeeder = item.valoreCampo;
	}	
	
	//RU_1205
	$scope.configureClliFeederSuccessivi = function(event){		

		event.preventDefault();
		
		$scope.loadingClliFeeder = true;
		$scope.arrayClliFeeder = [];				
		
		var _request = {
				codOloAgcom: $scope._codOloAgcom,
				idContratto: $scope._idContratto,
				nomeCampo: 'CLLIFEEDER',
				descrArea: $scope.data.step7.datiOfferteMulticast.macroArea, 
				flagPrimoFeeder: $scope._flagPrimoFeeder				
			};	
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
		.then(function(data){
			$scope.loadingClliFeeder = false;
			if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){
				angular.copy(data.outputCampiOfferteMulticast, $scope.arrayClliFeeder);
			}
			$scope.selectCLLIFeederSuccessivi();
		}, function(error){
			$scope.loadingClliFeeder = false;
			$scope.cleanClliFeeder();
			$scope.erroreService("Errore nel recupero dati CLLI Feeder");				
		});
	}
	
	$scope.selectCLLIFeederSuccessivi = function(){
		$uibModal.open({
			backdrop: 'static',
            templateUrl: 'app/ordini/newOrder/step7/feeder/feederSuccessivi/modal/clliFeederSelect.tpl.html',
            controller: 'ClliFeederSelectModalCtrl',
            resolve: {
                feeders: function () {
                    return $scope.arrayClliFeeder;
                },
                alreadySelected: function(){
                	return $scope.data.step7.datiOfferteMulticast.clliFeederSuccessivi;
                }
            }
        }).result.then(function (selectedItems) {
        	$scope.data.step7.datiOfferteMulticast.clliFeederSuccessivi = selectedItems;
        }, function (error) {
        	console.error(error);
        });
	}
	
	
	/**
	 * Per IDVLANOLO
	 * 		Dovrà essere previsto un campo modificabile dall'utente che abbia come default il più basso
	 * 		tra i valori di IDVLANOLO, nel range 2-4000, disponibile in consistenza (non già utilizzato)
	 */
	$scope.configureIdVlanOlo = function(){		
					
		$scope.loadingIdVlanOlo = true;	
		$scope.arrayIdVlanOlo = [];
		
		var _request = {
				codOloAgcom: $scope._codOloAgcom,
				idContratto: $scope._idContratto,
				nomeCampo: 'IDVLANOLO',
				flagPrimoFeeder: $scope._flagPrimoFeeder				
			};	
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
		.then(function(data){
			$scope.loadingIdVlanOlo = false;
			if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){					
				var _array = data.outputCampiOfferteMulticast.map(function(item) {return item.valoreCampo;});					
				angular.copy(_array, $scope.arrayIdVlanOlo);		
				$scope.data.step7.datiOfferteMulticast.idVlanOlo = _array[0];
			}
		}, function(error){
			$scope.loadingIdVlanOlo = false;
			$scope.cleanIdVlanOlo();
			$scope.erroreService("Errore nel recupero dati IdVlanOlo");				
		});
	}
	
	/**
	 * 	Per CodiceTDKit
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */	
	$scope.configureCodiceTDKit = function(event){

		event.preventDefault();
					
		$scope.loadingCodiceTDKit = true;			
		$scope.arrayCodiceTDKit = [];
		
		var _request = {
				codOloAgcom: $scope._codOloAgcom,
				idContratto: $scope._idContratto,
				nomeCampo: 'CODICETDKIT',
				descrArea: $scope.data.step7.datiOfferteMulticast.macroArea, 
				clliFeeder: $scope.data.step7.datiOfferteMulticast.clliFeeder, 
				flagPrimoFeeder: $scope._flagPrimoFeeder			
			};			
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
			.then(function(data){
				$scope.loadingCodiceTDKit = false;
				if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){
					angular.copy(data.outputCampiOfferteMulticast, $scope.arrayCodiceTDKit);
				}
				$scope.selectCodiceTdKit();
			}, function(error){
				$scope.loadingCodiceTDKit = false;
				$scope.cleanCodiceTdKit();
				$scope.erroreService("Errore nel recupero dati Codice TDKit");
			});
	}	
	
	$scope.selectCodiceTdKit = function(){
        var _modalConfig = {
             headerText: 'Seleziona TD Kit di consegna',
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
		$scope.data.step7.datiOfferteMulticast.codiceTdKit = item.valoreCampo;
	}		
	
	
	/**
	 * Per BandaFeeder
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureBandaFeeder = function(){		
					
		$scope.loadingBandaFeeder = true;
		$scope.arrayBandaFeeder = [];
		
		//RU_1414
		var _request = {};
		
		if($scope._flagPrimoFeeder == 'Y'){
			_request = {
				codOloAgcom: $scope._codOloAgcom,
				idContratto: $scope._idContratto,
				nomeCampo: 'BANDAFEEDER',
				flagPrimoFeeder: $scope._flagPrimoFeeder				
			};	
		}else{
			_request = {
				//Bug #46385
				codOloAgcom: $scope._codOloAgcom,
				descrArea: 	$scope.data.step7.datiOfferteMulticast.macroArea,
				nomeCampo: "BANDAFS"
			};	
		}
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
		.then(function(data){
			$scope.loadingBandaFeeder = false;
			if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){					
				var _array = data.outputCampiOfferteMulticast.map(function(item) {return item.valoreCampo;});					
				angular.copy(_array, $scope.arrayBandaFeeder);
				//RU_1414
				if($scope._flagPrimoFeeder == 'N' && _array){
					$scope.data.step7.datiOfferteMulticast.bandaFeeder = _array[0];
				}
			}else{
				$scope.erroreBandaFeeder = "Nessun valore Banda Feeder trovato";
				$scope.cleanBandaFeeder();
			}
		}, function(error){
			$scope.loadingBandaFeeder = false;
			$scope.cleanBandaFeeder();
			$scope.erroreService("Errore nel recupero dati Banda Feeder");				
		});
	}
	
	
	/**
	 * Per AS Number
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureAsNumber = function(){		
					
		$scope.loadingAsNumber = true;
		$scope.arrayAsNumber = [];
		
		var _request = {
				codOloAgcom: $scope._codOloAgcom,
				idContratto: $scope._idContratto,
				nomeCampo: 'ASNUMBER',
				flagPrimoFeeder: $scope._flagPrimoFeeder				
			};	
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
		.then(function(data){
			$scope.loadingAsNumber = false;
			if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){					
				var _array = data.outputCampiOfferteMulticast.map(function(item) {return item.valoreCampo;});					
				angular.copy(_array, $scope.arrayAsNumber);
			}else{
				$scope.erroreAsNumber = "Nessun valore AsNumber trovato";
			}
		}, function(error){
			$scope.loadingAsNumber = false;
			$scope.cleanAsNumber();
			$scope.erroreService("Errore nel recupero dati As Number");				
		});
	}
	
	/**
	 * Per IP SESSIONE eBGP
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureIpSessioneEbgp = function(){		
					
		$scope.loadingIpSessione = true;
		$scope.arrayIpSessione = [];
		
		var _request = {
				codOloAgcom: $scope._codOloAgcom,
				idContratto: $scope._idContratto,
				nomeCampo: 'IPSESSIONE',
				flagPrimoFeeder: $scope._flagPrimoFeeder				
			};	
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
		.then(function(data){
			$scope.loadingIpSessione = false;
			if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){					
				var _array = data.outputCampiOfferteMulticast.map(function(item) {return item.valoreCampo;});					
				angular.copy(_array, $scope.arrayIpSessione);
			}else{
				$scope.erroreIpSessione = "Nessun valore IP Sessione eBGP trovato";
			}
		}, function(error){
			$scope.loadingIpSessione = false;
			$scope.cleanIpSessione();
			$scope.erroreService("Errore nel recupero dati Ip Sessione eBGP");				
		});
	}
	
	/**
	 * Per Primo Feeder
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configurePrimoFeeder = function(){		
					
		$scope.loadingPrimoFeeder = true;
		
		var _request = {				
				codOloAgcom: $scope._codOloAgcom,
				idContratto: $scope._idContratto,
				nomeCampo: 'PRIMOFEEDER',
				descrArea: $scope.data.step7.datiOfferteMulticast.macroArea,
				flagPrimoFeeder: $scope._flagPrimoFeeder			
			};	
		
		VisualizzaCampiOfferteMulticast.save({}, _request).$promise
		.then(function(data){
			$scope.loadingPrimoFeeder = false;
			if(data.outputCampiOfferteMulticast && data.outputCampiOfferteMulticast.length > 0){					
				var _array = data.outputCampiOfferteMulticast.map(function(item) {return item.valoreCampo;});	
				$scope.data.step7.datiOfferteMulticast.primoFeeder = _array[0];
			}else{
				$scope.cleanPrimoFeeder();
			}
		}, function(error){
			$scope.loadingPrimoFeeder = false;
			$scope.cleanPrimoFeeder();
			$scope.erroreService("Errore nel recupero dati Codice CLLI");				
		});
	}
       
    $scope.submitFormFeeder = function(event) {
    	event.stopPropagation();
    	
    	//Elimina le strutture dati provenienti dal controller padre 
    	if($scope.data.step7.datiAppuntamentoDisaggregazione){
    		delete $scope.data.step7.datiAppuntamentoDisaggregazione;
    	}
    	if($scope.data.step7.datiDisaggregazione){
    		delete $scope.data.step7.datiDisaggregazione;
    	}
    	if($scope.data.step7.datiPrestazioniAggiuntive){
    		delete $scope.data.step7.datiPrestazioniAggiuntive;
    	}
    	if($scope.data.step7.datiServiziOpzionali){
    		delete $scope.data.step7.datiServiziOpzionali;
    	}
    	if($scope.data.step7.datiSlaPlusSu){
    		delete $scope.data.step7.datiSlaPlusSu;
    	}
    	
    	$rootScope.formData.data.step7 = $rootScope.data.step7 = $scope.data.step7;
    	
    	$state.go('root.ordini.new.step8');	          
    };
    
    
    $scope.cleanMacroArea = function(){
    	if($scope.data.step7.datiOfferteMulticast.macroArea){
    		$scope.data.step7.datiOfferteMulticast.macroArea = "";
    		$scope.arrayMacroArea = [];
    	}
    }
    
    
    $scope.cleanClliFeeder = function(){
    	if($scope.data.step7.datiOfferteMulticast.clliFeeder){
    		$scope.data.step7.datiOfferteMulticast.clliFeeder = "";
    		$scope.arrayClliFeeder = [];
    	}
    }
    
    $scope.cleanCodiceTdKit = function(){
    	if($scope.data.step7.datiOfferteMulticast.codiceTdKit){
    		$scope.data.step7.datiOfferteMulticast.codiceTdKit = "";
    		$scope.arrayCodiceTDKit = [];
    	}
    }
    
    $scope.cleanIdVlanOlo = function(){
    	if($scope.data.step7.datiOfferteMulticast.idVlanOlo){
    		$scope.data.step7.datiOfferteMulticast.idVlanOlo = "";
    		$scope.arrayIdVlanOlo = [];
    	}
    }
    
    $scope.cleanBandaFeeder = function(){
    	if($scope.data.step7.datiOfferteMulticast.bandaFeeder){
    		$scope.data.step7.datiOfferteMulticast.bandaFeeder = "";
    		$scope.arrayBandaFeeder = [];
    	}
    }
    
    $scope.cleanAsNumber = function(){
    	if($scope.data.step7.datiOfferteMulticast.asNumber){
    		$scope.data.step7.datiOfferteMulticast.asNumber = "";
    		$scope.arrayAsNumber = [];
    	}
    }
    
    $scope.cleanIpSessione = function(){
    	if($scope.data.step7.datiOfferteMulticast.ipSessione){
    		$scope.data.step7.datiOfferteMulticast.ipSessione = "";
    		$scope.arrayIpSessione = [];
    	}
    }
    
    $scope.cleanPrimoFeeder = function(){
    	if($scope.data.step7.datiOfferteMulticast.primoFeeder){
    		$scope.data.step7.datiOfferteMulticast.primoFeeder = "";
    	}
    }
    
    //RU_1414
    $scope.cleanBandaFeeder = function(){
    	if($scope.data.step7.datiOfferteMulticast.bandaFeeder){
    		$scope.data.step7.datiOfferteMulticast.bandaFeeder = "";
    		$scope.arrayBandaFeeder = [];
    	}
    }
    
    //SM_11151
    $scope.cleanErrorMessages = function(){	
		$scope.erroreBandaFeeder = '';
		$scope.erroreAsNumber = '';
		$scope.erroreIpSessione = '';
	}
   
    $scope.$watch("data.step7.datiOfferteMulticast.macroArea", function(newValue, oldValue){
    	if(newValue){
    		if(newValue != oldValue){
    			$scope.cleanClliFeeder();
    			$scope.cleanCodiceTdKit();
    			$scope.cleanErrorMessages();
    		}    		
    		if($scope._flagPrimoFeeder && $scope._flagPrimoFeeder == 'N'){
	    		$scope.cleanBandaFeeder();
    			$scope.cleanPrimoFeeder();
    			$scope.configurePrimoFeeder();
    			//RU_1414
    			$scope.configureBandaFeeder();
    		}    		
    	}
    });
    
    $scope.$watch("data.step7.datiOfferteMulticast.clliFeeder", function(newValue, oldValue){
    	if(newValue){
    		if(newValue != oldValue){
    			$scope.cleanCodiceTdKit();
    			$scope.cleanErrorMessages();
    		}
    	}
    });
    
    $scope.$watch("data.step7.datiOfferteMulticast.codiceTdKit", function(newValue, oldValue){
    	if(newValue){
    		if(newValue != oldValue){
    			$scope.cleanErrorMessages();
    		}
    		
    		$scope.configureIdVlanOlo();
    	}
    });
       
    $scope.init();

}]);  
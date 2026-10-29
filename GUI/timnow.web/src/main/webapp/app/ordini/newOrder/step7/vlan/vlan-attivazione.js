//RU_1058
timnow.controller('vlanAttivazioneStep7', ['$scope', '$state', '$rootScope', '$timeout', 'VLANUtils', 'modalService', 'VisualizzaCampiOfferteVLAN', 'VerificaKitAbilitatoNGA', 'RecuperaCAR', 'RecuperaCodiciTdKit', 'RecuperaMacroArea',
	function ($scope, $state, $rootScope, $timeout, VLANUtils, modalService, VisualizzaCampiOfferteVLAN, VerificaKitAbilitatoNGA, RecuperaCAR, RecuperaCodiciTdKit, RecuperaMacroArea) {
	
	$scope.showSuperMacroArea = false;
	$scope.showCcLib = false;
	$scope.showFtthOnly = false;
	$scope.showCAR = false;
	$scope.enableCAR = false;
	$scope.showIntermediateAgentDhcpOption82 = false;
	
	$scope.arrayCodiceTDKit = [];
	$scope.arrayMacroArea = [];
	$scope.arrayArea = [];
	$scope.arrayIdVlanOlo = [];
	$scope.arraySuperMacroArea = [];
	$scope.arrayClliCentrale = [];
	$scope.arrayCCLib = [];
	
	$scope.rangeIdentificativoVlan = /^([2-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-3][0-9]{3}|4000)$/;
	
	$scope.headerTabellaCAR = [];
	$scope.headerTabellaCAR.push({"key": "codiceCAR","value": "Codice CAR","type": "text"});
	$scope.headerTabellaCAR.push({"key": "aggregatoBMCLight","value": "Aggregato BMC Light","type": "text"});
	$scope.headerTabellaCAR.push({"key": "ftthOnly","value": "FTTH Only","type": "text"});
	$scope.headerTabellaCAR.push({"key": "tipologiaComune","value": "Tipologia Comune","type": "text"});
	$scope.headerTabellaCAR.push({"key": "macroArea","value": "Macro Area","type": "text"});
	//RU_1155
	$scope.headerTabellaCAR.push({"key": "bandaCar","value": "Banda CAR","type": "text"}); 
	//RU_1502
	$scope.headerTabellaCAR.push({"key": "DRG","value": "DRG","type": "text"});
	
	//SM_9825
	$scope.headerTabellaTdKit = [];
	$scope.headerTabellaTdKit.push({"key": "codiceTdKit","value": "Codice TD kit","type": "text"});
	$scope.headerTabellaTdKit.push({"key": "modelloKit","value": "Modello kit","type": "text"});
	$scope.headerTabellaTdKit.push({"key": "clli","value": "CLLI","type": "text"});
	
	$scope._codiceTDKIT =  null;
    $scope._famigliaVlan = null;
    $scope._COS = null;
	
    $scope._codOloAgcom = ($scope.data.step1.operatore.codiceOLO || null);
    $scope._idOfferta = $scope.data.step3.offerta.idOfferta;
    $scope._idOffertaVLAN_NGA = $rootScope.MAP_OFFERTE.VLAN_NGA.id;
    $scope._idOffertaVLAN_GBE = $rootScope.MAP_OFFERTE.VLAN_GBE.id;
    $scope._idOffertaVLAN_VULA = $rootScope.MAP_OFFERTE.VLAN_VULA.id;
    $scope._indexCos = VLANUtils.estraiIndiceCampoSezioneInferiore('IDENTIFICATIVOCOS');
    
    //RU_1502
    $scope.showFlagDRG = ($scope._idOfferta == $scope._idOffertaVLAN_NGA);
    $scope.RU_1502 = false;
    
	if (!$rootScope.data.step7) {
        $rootScope.data.step7 = $scope.data.step7 = {};
    }
    
    $scope.init = function(){     	        	
        	$scope.configureSuperMacroArea();
        	$scope.configureCCLIB();
        	$scope.configureIntermediateAgentDhcpOption82();
    }
	
	/**
	 * 	Per CodiceTDKit
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */	
    //SM_9825
	$scope.configureCodiceTDKit = function(event){

		event.preventDefault();
		
		if($rootScope.customizedOffer.offerTopDetails.CODICETDKIT){		
			
			$scope.loadingCodiceTDKit = true;			
			$scope.arrayCodiceTDKit = [];
			
			var _request = {
				lavorazione: 'attivazione',
				famigliaVlan: $scope._famigliaVlan,
				cos: $scope._COS,
				codOloAgcom: $scope._codOloAgcom,
				idOfferta: $scope._idOfferta
			};
			
			//RU_1166
			if($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA && $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft){
				_request.supermacroarea = $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft;
			}
			if($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN && $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft){
				_request.ccLib = $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft;
			}
			if($rootScope.customizedOffer.offerTopDetails.BMCLIGHT && $rootScope.customizedOffer.offerTopDetails.BMCLIGHT.dft){
				_request.bmcLight = $rootScope.customizedOffer.offerTopDetails.BMCLIGHT.dft;
			}			
			
			RecuperaCodiciTdKit.save({}, _request).$promise
				.then(function(data){
					$scope.loadingCodiceTDKit = false;
					if(data.outputCodiciTdKit && data.outputCodiciTdKit.length > 0){						
						angular.copy(data.outputCodiciTdKit, $scope.arrayCodiceTDKit);
					}
					$scope.selectCodiceTdKit();
				}, function(error){
					$scope.loadingCodiceTDKit = false;
					$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = "";
					$scope.erroreService("Errore nel recupero dati Codice TDKit");
				});
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
		$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = item.codiceTdKit;
	}
		
	/**
	 * 	Per Macro Area
	 */
	$scope.configureMacroArea = function(){

		$scope.arrayMacroArea = [];
		$scope.loadingMacroArea = true;
		
		var _request = {
			idOfferta: $scope._idOfferta,
			codiceTdKit: $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft,
			cos: $scope._COS
		};
		
		if($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN && $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft){
			_request.ccLib = $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft;
		}
		if($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA && $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft){
			_request.supermacroarea = $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft;
		}		
		
		RecuperaMacroArea.save({}, _request).$promise
			.then(function(data){
				$scope.loadingMacroArea = false;
				if(data.listaMacroaree && data.listaMacroaree.length > 0){
					angular.copy(data.listaMacroaree, $scope.arrayMacroArea);
				}
			}, function(error){
				$scope.loadingMacroArea = false;
				$scope.cleanMacroArea();
				$scope.erroreService("Errore nel recupero dati Macro Area");
			});
	}	
	
	/**
	 * 	Per Area
	 */
	$scope.configureArea = function(){
		
		$scope.loadingArea = true;
		$scope.arrayArea = [];
		
		var _request = {	
			valoreCampo: $scope.data.step7.macroArea,
			//SM_9717
			idOfferta: $scope._idOfferta,
			//SM_9787
			nomeCampo: $scope.data.step7.macroAreaObject.descrizioneArea
		};
		
		VisualizzaCampiOfferteVLAN.save({}, _request).$promise
			.then(function(data){
				$scope.loadingArea = false;
				if(data.outputCampiOfferteVLAN && data.outputCampiOfferteVLAN.length > 0){					
					angular.copy(data.outputCampiOfferteVLAN, $scope.arrayArea);
				}
			}, function(error){
				$scope.loadingArea = false;
				$scope.cleanArea();	
				$scope.erroreService("Errore nel recupero dati Area");							
			});
	}	
	
	/**
	 * Per CLLICentrale
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 */
	$scope.configureClliCentrale = function(){		
		
		if($rootScope.customizedOffer.offerTopDetails.CODICECLLI){
			
			$scope.loadingCodiceClli = true;
			$scope.arrayClliCentrale = [];				
			
			var _request = {
				nomeCampo: 'CLLICENTRALE',
				idOfferta: $scope._idOfferta,
				valoreCampo: $scope.data.step7.area 
			};
			
			VisualizzaCampiOfferteVLAN.save({}, _request).$promise
			.then(function(data){
				$scope.loadingCodiceClli = false;
				if(data.outputCampiOfferteVLAN && data.outputCampiOfferteVLAN.length > 0){					
					var _array = data.outputCampiOfferteVLAN.map(function(item) {return item.clliCentrale;});					
					angular.copy(_array, $scope.arrayClliCentrale);
				}
			}, function(error){
				$scope.loadingCodiceClli = false;
				$scope.cleanClliCentrale();
				$scope.erroreService("Errore nel recupero dati Codice CLLI");				
			});
		}
	}
	
	
	/**
	 * Per SuperMacroArea
	 * Visibile solo per VLAN NGA - VLAN GBE e valorizzabile se:
	 * 		Se Famiglia VLAN = 'VLAN MonoCoS Banda Condivisa' e CoS = 'VLAN MonoCoS Banda Condivisa CoS 3'
	 * 			oppure
	 * 		se Famiglia VLAN = 'VLAN MonoCoS Banda Condivisa' e CoS = 'VLAN MonoCoS Banda Condivisa CoS 5'  
	 * 		allora non dovrà essere valorizzato/visibile
	 */
	$scope.configureSuperMacroArea = function(){
		var _arrayCos = ["vlan monocos banda condivisa cos 3", "vlan monocos banda condivisa cos 5"];
		var famigliaVLAN = "vlan monocos banda condivisa";
		if([$scope._idOffertaVLAN_NGA, $scope._idOffertaVLAN_GBE].indexOf($scope._idOfferta) > -1 ){
			if($scope._COS){
				if($scope._famigliaVlan.toLowerCase() == famigliaVLAN && _arrayCos.indexOf($scope._COS.toLowerCase()) > -1){
					$scope.showSuperMacroArea = false;	
					$rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft = "";
				}else{
					$scope.showSuperMacroArea = true;
					$scope.arraySuperMacroArea =  VLANUtils.buildArraySuperMacroArea($scope._idOfferta, $scope.data.step7.descrizioneMacroArea);
				}
			}else{
				$scope.showSuperMacroArea = true;
				$scope.arraySuperMacroArea = VLANUtils.buildArraySuperMacroArea($scope._idOfferta, $scope.data.step7.descrizioneMacroArea);
			}
		}else{
			$scope.showSuperMacroArea = false;			
			$scope.arraySuperMacroArea = [];
		}
	}
	
	/**
	 * Per CC_LIB
	 * Visibile solo per VLAN NGA e valorizzabile se:
	 * 		SuperMacroarea = “Consegna su CAR di MAdR ‘SUPERMACROAREA” (codice 1)
	 *		SuperMacroarea = “Consegna su CAR di MAdR ‘SUPERMACROAREA CC’” (codice 2)
	 *		SuperMacroarea = “Consegna su CAR di MAdR ‘SUPERMACROAREA LIB’” (codice 3)
	 */
	$scope.configureCCLIB = function(){
		
		//SM_9781
		//RU_1502
		if($scope._idOfferta == $scope._idOffertaVLAN_NGA &&
			($scope.showFlagDRG && (!$scope.data.step7.flagDRG || $scope.data.step7.flagDRG == 'N'))){
			if($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA && $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft){
				var _array = ["consegna su car di madr 'supermacroarea'",
					  "consegna su car di madr 'supermacroarea cc'",
					  "consegna su car di madr 'supermacroarea lib'"];	
				var _superMacroArea = ($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft || null);
				if(_array.indexOf(_superMacroArea.toLowerCase()) > -1){
					$scope.showCcLib = false;
					if($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN){
						$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = "";
					}
				}else{
					$scope.showCcLib = true;
					$scope.arrayCCLib = ["CC", "LIB"]
				}	
			}else{
				$scope.showCcLib = true;
				$scope.arrayCCLib = ["CC", "LIB"]
			}			
		}else{
			$scope.showCcLib = false;
			if($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN){
				$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = "";
			}
		}
	}
	
	/**
	 * Per FTTH_Only
	 * Visibile solo per VLAN NGA e valorizzabile se:
	 * 		Famiglia VLAN = “VLAN NGA MonoCoS Banda Condivisa” (codice 1) 
	 *		e (AND) CoS = “VLAN MonoCoS Banda Condivisa CoS 0” (codice 0)
	 *		oppure
	 * 		Famiglia VLAN = “VLAN NGA MonoCoS Banda Condivisa” (codice 1) 
	 *			e (AND) CoS = “VLAN MonoCoS Banda Condivisa CoS 1” (codice 1)
	 *		oppure
	 *		Famiglia VLAN = “VLAN NGA MutiCoS Banda Condivisa” (codice 2)
	 *		oppure
	 *		Famiglia VLAN = “VLAN NGA MultiCoS Banda Dedicata” (codice 3)
	 */

	$scope.configureFTTHOnly = function(){		
		//SM_9839
		//Task #33705
		var _arrayCos = ["vlan monocos banda condivisa cos 0", "vlan monocos banda condivisa cos 1"];
		//RU_1502
		var _verificaMacroArea = $scope.verificaMacroAreaPerFTTHOnly();
		if($scope._idOfferta == $scope._idOffertaVLAN_NGA &&
			($scope.showFlagDRG && (!$scope.data.step7.flagDRG || $scope.data.step7.flagDRG == 'N'))){
				if(($scope._famigliaVlan.toLowerCase() == 'vlan monocos banda condivisa' && $scope._COS && _arrayCos.indexOf($scope._COS.toLowerCase()) > -1) ||
					$scope._famigliaVlan.toLowerCase() == 'vlan multicos banda condivisa' ||
					$scope._famigliaVlan.toLowerCase() == 'vlan multicos banda dedicata' || 
					($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft && $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft !== "") ||
						_verificaMacroArea
					){
							$scope.showFtthOnly = false;
							$rootScope.customizedOffer.offerTopDetails.FTTHONLY.dft = "";
				}else{
					$scope.showFtthOnly = true;
				}
		}else{
			$scope.showFtthOnly = false;
			if($rootScope.customizedOffer.offerTopDetails.FTTHONLY && $rootScope.customizedOffer.offerTopDetails.FTTHONLY.dft){
				$rootScope.customizedOffer.offerTopDetails.FTTHONLY.dft = "";
			}
		}	
	}
	
	//SM_11478
	$scope.verificaMacroAreaPerFTTHOnly = function(){
		if($scope.data.step7.macroAreaJson && $scope.data.step7.macroAreaJson !== ""){
			let _macroArea = JSON.parse($scope.data.step7.macroAreaJson);
			return (_macroArea.descrizioneArea.includes("_CC") || _macroArea.descrizioneArea.includes("_LIB"));			
		}
		return false;
	}
	
	/**
	 * Per INTERMEDIATE_AGENT_DHCP_OPTION_82
	 * Visibile solo per VLAN VULA
	 */
	$scope.configureIntermediateAgentDhcpOption82 = function(){		
		if($scope._idOfferta == $scope._idOffertaVLAN_VULA){
			$scope.showIntermediateAgentDhcpOption82 = true;
		}else{
			$scope.showIntermediateAgentDhcpOption82 = false;
		}
	}	
	
	
	/**** INIZIO SEZIONE CAR ****/
	
	/**
	 * Per CAR (C11M08F78)
	 * Visibile solo per VLAN NGA/VLAN GBE
	 * Il pulsante dovrà essere selezionabile se rispettate le seguenti condizioni:
		o	Famiglia VLAN = “VLAN NGA MonoCoS Banda Condivisa” (codice 1) 
			e (AND) CoS = “VLAN MonoCoS Banda Condivisa CoS 0” (codice 0)
		oppure
		o	Famiglia VLAN = “VLAN NGA MonoCoS Banda Condivisa” (codice 1) 
			e (AND) CoS = “VLAN MonoCoS Banda Condivisa CoS 1” (codice 1)
		oppure
		o	Famiglia VLAN = “VLAN NGA MutiCoS Banda Condivisa” (codice 2)
		oppure
		o	Famiglia VLAN = “VLAN NGA MultiCoS Banda Dedicata” (codice 3)
		altrimenti il pulsante non deve essere selezionabile.
	 */
	$scope.configureShowCAR = function(){		
		
		var _arrayCos = ["vlan monocos banda condivisa cos 0", "vlan monocos banda condivisa cos 1"];
		var _famigliaVLAN = $scope._famigliaVlan.toLowerCase();
		var _cos = ($scope._COS || null);
		
		$scope.showCAR = false;
		$scope.isCARRequired = false;
		$scope.enableCAR = false;
		
		if($scope._idOfferta != $scope._idOffertaVULA){
			if((_famigliaVLAN == "vlan monocos banda condivisa" && _cos && _arrayCos.indexOf(_cos.toLowerCase()) > -1) || 
			   (_famigliaVLAN != "vlan monocos banda condivisa" && _cos && _arrayCos.indexOf(_cos.toLowerCase()) == -1)){
				$scope.showCAR = true;
				$scope.enableCAR = true;
				$scope.isCARRequired = true;
			}else if(_famigliaVLAN != "vlan monocos banda condivisa"){
				$scope.showCAR = true;
				$scope.enableCAR = true;
				$scope.isCARRequired = true;				
			}else{
				$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = "";
			} 
			
		}else{
			$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = "";
		}
	}
	
	$scope.configureCAR = function(event){
		
		event.preventDefault();
		
		if($rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR){
		
			var _request = {
				idOfferta: $scope._idOfferta,
				lavorazione: "attivazione",
				famigliaVLAN: ($rootScope.customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft || null),
				codiceTDKIT: ($rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft || null)
			};
			if($rootScope.customizedOffer.offerTopDetails.FTTHONLY && $rootScope.customizedOffer.offerTopDetails.FTTHONLY.dft){
				_request.ftthOnly = ($rootScope.customizedOffer.offerTopDetails.FTTHONLY.dft || null);
			}
			if($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA && $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft){
				_request.supermacroarea = ($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft || null);
			}
			//SM_9917
			if($rootScope.customizedOffer.offerTopDetails.BMCLIGHT && $rootScope.customizedOffer.offerTopDetails.BMCLIGHT.dft){
				_request.bmcLight = ($rootScope.customizedOffer.offerTopDetails.BMCLIGHT.dft || null);
			}
			if($rootScope.customizedOffer.offerBotDetails[$scope._indexCos] && $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft){
				_request.cos = ($rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft || null);
			}
			if($scope.data.step7.macroArea){
				_request.macroarea = ($scope.data.step7.macroArea || null);
			}
			if($scope.data.step7.area){
				_request.area = ($scope.data.step7.area || null);
			}
			
			if($scope._idOffertaVLAN_NGA == $scope._idOfferta){
				if($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN && $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft){
					_request.ccLib = $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft;
				}
			}
			
			//RU_1502
			if($scope.RU_1502 && $scope.showFlagDRG){
				_request.flagDRG = $scope.data.step7.flagDRG; 
			}
			
			$scope.arrayCAR = [];
			$scope.loadingCAR = true;
			
			RecuperaCAR.save({}, _request).$promise
			.then(function(response){
				$scope.loadingCAR = false;
				
				if(response.outputCAR && response.outputCAR.length > 0){					
					$scope.arrayCAR = response.outputCAR;				
				}
				$scope.selectCAR();
			}, function(error){
				$scope.loadingCAR = false;
				$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = "";
				$scope.erroreService("Errore nel recupero dati CAR");	
			});
		}
	}
	
	$scope.selectCAR = function(){
           var _modalConfig = {
                headerText: 'Seleziona CAR',
                actionButtonText: null,
                closeButtonText: 'Ok',
                contentType: 'modale_nowtable',
                scope: $scope,
                callbackFunction: 'callbackSelectCAR',
                dataHeader: $scope.headerTabellaCAR,
                data: $scope.arrayCAR
            };
            modalService.showModal({}, _modalConfig);
	}
	
	$scope.callbackSelectCAR = function(item){
		$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = item.codiceCAR;
	}
	
	/**** FINE SEZIONE CAR ****/
	

	//C11M08F72 - Verifica Kit abilitato NGA
	$scope.C11M08F72 = function(){
		var _request = {
			codiceFunzione: 'C11M08F72',
			codiceTdKit: $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft
			
		};		
		return VerificaKitAbilitatoNGA.save({}, _request).$promise;
	}
	
       
    $scope.submitFormVlan = function(event) {
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
    	
    	//SM_10161
    	//Il controllo C11M08F72 va effettuato solo in caso di offerta VLAN NGA
    	if($scope._idOfferta == $scope._idOffertaVLAN_NGA){
        	$scope.C11M08F72()
    		.then(function(response){
    			if(response.ControlliCodiceTDKitOutput && response.ControlliCodiceTDKitOutput.esito == 'OK'){
    				$state.go($scope.checkNextState());	
    			}else{
    				$scope.erroreService("Errore su verifica KIT abilitato NGA");
    			}
    		}, function(error){
    			$scope.erroreService("Errore su verifica KIT abilitato NGA");
    		}); 
    	}else{
    		$state.go($scope.checkNextState());
    	}        
    };
    
    $scope.cleanMacroArea = function(){
    	$scope.data.step7.macroAreaJson = "";
		$scope.data.step7.macroAreaObject = "";
		$scope.data.step7.macroArea = "";
		$scope.data.step7.descrizioneMacroArea = "";
		$scope.arrayMacroArea = [];
    }
    
    $scope.cleanArea = function(){
    	$scope.data.step7.areaJson = "";
		$scope.data.step7.areaObject = "";
		$scope.data.step7.area = "";
		$scope.arrayArea = [];
    }
    
    $scope.cleanClliCentrale = function(){
    	if($rootScope.customizedOffer.offerTopDetails.CODICECLLI){
    		$rootScope.customizedOffer.offerTopDetails.CODICECLLI.dft = "";
    		$scope.arrayClliCentrale = [];
    	}
    }
    
    $scope.cleanCAR = function(){
    	if($rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR){
    		$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = "";
    	}
    }
    
    $scope.cleanCodiceTdKit = function(){
    	if($rootScope.customizedOffer.offerTopDetails.CODICETDKIT){
    		$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = "";
    	}
    }
    
    $timeout(function(){
    	$scope.init();   
    }, 500, true);
    
    //RU_1502
    $scope.oscuramento_RU_1502 = function() {
		$scope.RU_1502 = !$rootScope.OSCURAMENTI.RU_1502.oscurato;
    }
    
    $scope.oscuramento_RU_1502();
    
    
    $scope.$watch("customizedOffer.offerTopDetails.CODICETDKIT.dft", function(newValue, oldValue){
    	if(newValue){
    		$scope._codiceTDKIT = newValue;
    		
    		if(newValue != oldValue){
        		$scope.cleanMacroArea();
        		$scope.cleanArea();
        		$scope.cleanClliCentrale();
        		$scope.cleanCAR();	
    		}
    		
    		$scope.configureMacroArea(); 
    	}    	
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft", function(newValue, oldValue){
    	if(newValue){
    		$scope._famigliaVlan = newValue;
    	}        
    });
        
    $scope.$watch(function(){
    	if($scope._indexCos && $scope._indexCos > -1 && $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft){
    		return $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft;
    	}
    }, function(newValue, oldValue){
    	if(newValue){
    		$scope._COS = newValue;
    	} 
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft", function(newValue, oldValue){
    	if(newValue != oldValue){
    		$scope.cleanCodiceTdKit();
    		$scope.cleanMacroArea();
    		$scope.cleanArea();
    		$scope.cleanClliCentrale();
    		$scope.cleanCAR();
    	}
    	$scope.configureFTTHOnly();
    });
    
    
    $scope.$watch("customizedOffer.offerTopDetails.SUPERMACROAREA.dft", function(newValue, oldValue){
    	//SM_9804
    	if(newValue != oldValue){
    		$scope.configureCCLIB();
    		$scope.cleanCodiceTdKit();
    		$scope.cleanMacroArea();
    		$scope.cleanArea();
    		$scope.cleanClliCentrale();
    		$scope.cleanCAR();
    	}
    });    
    
    $scope.$watch("data.step7.macroAreaJson", function(newValue, oldValue){
    	if(newValue){
    		$scope.data.step7.macroAreaObject = JSON.parse($scope.data.step7.macroAreaJson);
    		$scope.data.step7.macroArea = $scope.data.step7.macroAreaObject.idAdrCrmws;
    		$scope.data.step7.descrizioneMacroArea = $scope.data.step7.macroAreaObject.descrizioneArea;
    		
    		if(newValue != oldValue){
        		$scope.cleanArea();
        		$scope.cleanClliCentrale();
        		$scope.cleanCAR();
    		}
    		
    		$scope.configureArea();
    		$scope.configureCCLIB();
    		//RU_1155
    		$scope.configureFTTHOnly();
    	}        
    });
        
    $scope.$watch("data.step7.areaJson", function(newValue, oldValue){
    	if(newValue){
    		$scope.data.step7.areaObject = JSON.parse($scope.data.step7.areaJson);
    		$scope.data.step7.area = $scope.data.step7.areaObject.idArea;
    		
    		if(newValue != oldValue){
        		$scope.cleanClliCentrale();
        		$scope.cleanCAR();
    		}
    		
    		$scope.configureClliCentrale();
    	}        
    });     
    
    $scope.$watch("customizedOffer.offerTopDetails.CODICECLLI.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){
    		$scope.cleanCAR();
    	}
    });   
    
    $scope.$watchGroup(['_famigliaVlan', '_COS'], function(newValues, oldValues){
    	if(newValues && (newValues[0] || newValues[1])){
    		$scope.configureShowCAR();
    		$scope.configureFTTHOnly();        	
    	}
    });
    
    //SM_11474
    $scope.$watch('data.step7.flagDRG', function(newValue, oldValue){
		if(newValue && newValue ==='Y'){
			$scope.showCcLib = false;
			$scope.showFtthOnly = false;
			$rootScope.customizedOffer.offerTopDetails.FTTHONLY.dft = "";
			$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = "";
			return;
		}
		$scope.configureCCLIB();
		$scope.configureFTTHOnly();		
	});
}]);  
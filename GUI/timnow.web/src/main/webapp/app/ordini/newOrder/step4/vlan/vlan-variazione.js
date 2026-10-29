//RU_1058
timnow.controller('vlanVariazioneStep4', ['$scope', '$state', '$rootScope', 'VLANUtils', 'VLAN_VARIAZIONI', 'VLAN_RACCOLTA_SERVIZI', 'VerificaCodiceTDKit', 'VerificaModelloKit', '$q', 'VisualizzaCampiOfferteVLAN', 'RecuperaCAR', 'modalService', 'RecuperaCodiciTdKit', 'VerificaModelloKitMadr', 'VerificaSpostamentoVlan',
	function ($scope, $state, $rootScope, VLANUtils, VLAN_VARIAZIONI, VLAN_RACCOLTA_SERVIZI, VerificaCodiceTDKit, VerificaModelloKit, $q, VisualizzaCampiOfferteVLAN, RecuperaCAR, modalService, RecuperaCodiciTdKit, VerificaModelloKitMadr, VerificaSpostamentoVlan) {
	
	$scope.showCoS = false;
	$scope.showCAR = false;
	$scope.showSuperMacroArea = false;
	$scope.showBanda = false;
	$scope.showVariazioneConcordata = false;
	$scope.enableEliminaCondivisore = false;
	//RU_1502
	$scope.showFlagDRG = false;
	$scope.RU_1502 = false;
	$scope._macroArea = "";
	
	$scope.buttonAvantiAttivo = false;
	
	$scope.arrayCodiceTDKit = [];
	$scope.arrayCAR = [];
	$scope.arraySuperMacroArea = [];
	$scope.arrayProfiloBMC = [];
	
	$scope.campiModificati = {};
	
	$scope.maxNumeroCondivisori = 10;	
	$scope._opzioniVariazioni = VLAN_VARIAZIONI;
    $scope._idOfferta = $scope.data.step3.offerta.idOfferta;
    $scope._idOffertaVLAN_NGA = $rootScope.MAP_OFFERTE.VLAN_NGA.id;
    $scope._idOffertaVLAN_GBE = $rootScope.MAP_OFFERTE.VLAN_GBE.id;
    $scope._idOffertaVLAN_VULA = $rootScope.MAP_OFFERTE.VLAN_VULA.id;
    $scope._opzioneVariazione = $scope.data.step3.opzioneVariazione;
    
    $scope._variazioniPerServizi = [VLAN_VARIAZIONI.VARIAZIONE_TDKIT, VLAN_VARIAZIONI.VARIAZIONE_CAR]
    
    $scope.rangeIdentificativoVlan = /^([2-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-3][0-9]{3}|4000)$/;
    
    //RU_1155
	$scope.headerTabellaProfiloBMC = [];
	$scope.headerTabellaProfiloBMC.push({"key": "profiloBMC","value": "Profilo","type": "text"});
	$scope.headerTabellaProfiloBMC.push({"key": "bandaMulticos3","value": "BP3","type": "text"});
	$scope.headerTabellaProfiloBMC.push({"key": "bandaMulticos5","value": "BP5","type": "text"});
    
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
	
	if (!$rootScope.data.step4) {
        $rootScope.data.step4 = {};
    }
	
	if(!$scope.data.step4){
		$scope.data.step4 = {};
	}
	
	if($scope.data.assetDetail){
		VLANUtils.estraiDettagliAsset($scope.data.assetDetail);
		VLANUtils.estraiTipoCosDaAsset($scope.data.assetDetail);
		
		$scope._idAsset = $scope.data.assetDetail.idAsset;
        $scope._indexBanda =  VLANUtils.estraiIndiceCampoSezioneInferiore('BANDA');
        $scope._indexTipoBanda = VLANUtils.estraiIndiceCampoSezioneInferiore('TIPOBANDA');
        $scope._indexCos = VLANUtils.estraiIndiceCampoSezioneInferiore('IDENTIFICATIVOCOS');
	}
    
    $scope.init = function(){  
    	$scope.configureLabelServiziEstrazioneAsset();
    	
    	$scope.configureCampiModificati();
    	    	
	 	$scope.configureFamigliaVlan();	    	
		$scope.configureCoS();
		$scope.configureShowCodiceTDKit();     	
		$scope.configureIdVlanOlo();
		//RU_1502		
       	$scope.configureFlagDRG();
		$scope.configureCCLIB();
	
    	$scope.configureShowCAR(); 
    	//SM_10474
    	$scope.configureRequiredCAR();
    	
    	$scope.configureSuperMacroArea();
    	$scope.configureBanda();
    	$scope.configureVariazioneConcordata();
    	$scope.configureShowProfiloBMC();
    	
    	//RU_1502
		$scope.initSpostamentoVlan();
    } 
    
    //RU_1502
    /**
		Per FlagDRG
		visibile solo per offerta VLAN NGA
	 */
	 $scope.configureFlagDRG = function(){
		$scope.showFlagDRG = ($scope._idOfferta == $scope._idOffertaVLAN_NGA);
	}
	
    /**
     * Configura la struttura dati per la chiamata al servizio C11M08F106 
       con i valori iniziali per variazione TDKIT o variazione CAR
     */
    $scope.initSpostamentoVlan = function(){
		$scope._C11M08F106 = {
			idRisorsa: $scope.data.step2.id_risorsa,
			lavorazione: "variazione",
			offerta: $rootScope.MAP_OFFERTE.VLAN_NGA.name,
			caratterizzazioneCarCons: "",
			caratterizzazioneCarRic: "",
			superMacroareaRic: "",
			superMacroareaCons: "",
			nomeMacroAreaRic: "",
			nomeMacroAreaCons: ""
		};
		//Campi attuali dell'asset, non modificati
		$scope._C11M08F106.caratterizzazioneCarCons = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'IDENTIFICATIVOCAR');
		$scope._C11M08F106.superMacroareaCons = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'SUPERMACROAREA');
		$scope._C11M08F106.nomeMacroAreaCons = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'NOMEMACROAREA');
		//Nuovi valori
		if($scope.customizedOffer.offerTopDetails.SUPERMACROAREA && $scope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft){
			$scope._C11M08F106.superMacroAreaRic = $scope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft;
		}
		if($scope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR && $scope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft){
			$scope._C11M08F106.caratterizzazioneCarRic = $scope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft;
		}
		if($scope._macroArea){
			$scope._C11M08F106.nomeMacroAreaRic = $scope._macroArea; 
		}
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
    
    $scope.configureCampiModificati = function(){
    	$scope.campiModificati['CODICETDKIT'] = false;
    	$scope.campiModificati['IDENTIFICATIVOVLANOLO'] = false;
    	$scope.campiModificati['SUPERMACROAREA'] = false;
    	$scope.campiModificati['VARIAZIONECONCORDATA'] = false;
    	$scope.campiModificati['BANDA'] = false;
    	$scope.campiModificati['IDENTIFICATIVOCAR'] = false;
    	$scope.campiModificati['PROFILOBMC'] = false;
    	$scope.campiModificati['TIPOLOGIACLUSTERVLAN'] = false;
    }
	
	/**
	 * 	Per Variazione TDKit
	 * 		Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
	 *  Per Variazione CAR e Variazione Banda
	 *  	Campo in sola lettura letto dalla consistenza
	 */
    //SM_9825
    $scope.configureShowCodiceTDKit = function(){
		if($rootScope.bozza && 
				$rootScope.bozza.customizedOffer && 
				$rootScope.bozza.customizedOffer.offerTopDetails && 
				$rootScope.bozza.customizedOffer.offerTopDetails["CODICETDKIT"]){
			$scope._codiceTDKIT = $rootScope.bozza.customizedOffer.offerTopDetails["CODICETDKIT"].dft;
			}else{
				$scope._codiceTDKIT= VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'CODICETDKIT');
				$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = $scope._codiceTDKIT;
			}
		
    	if(!$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft || $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft == ""){
    		$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = $scope._codiceTDKIT;
    	}
    }
    
	$scope.configureCodiceTDKit = function(event){	
		
		event.preventDefault();

		if($scope._opzioneVariazione == VLAN_VARIAZIONI.VARIAZIONE_TDKIT){
			
			$scope.loadingCodiceTDKit = true;	
			$scope.arrayCodiceTDKit = [];
			
			var _request = {
					lavorazione: 'variazione',
					famigliaVlan: $scope._famigliaVlan,
					cos: (($scope._COS && $scope._COS.length > 0) ? $scope._COS[0].dft : null),
					codiceTdKitAsset: $scope._codiceTDKIT,
					codOloAgcom: $rootScope.data.step1.operatore.codiceOLO,
					idOfferta: $scope._idOfferta
				};
			
			//RU_1166
			if($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA && $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft){
				_request.supermacroarea = $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft;
			}
			if($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN && $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft){
				_request.ccLib = $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft;
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
	
	$scope.configureFamigliaVlan = function(){		
		$scope._famigliaVlan = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'FAMIGLIAVLAN');
		$scope._famigliaVlan = VLANUtils.trascodeFamigliaVlan($scope._famigliaVlan);
		$rootScope.customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft = $scope._famigliaVlan;
	}
	
	$scope.configureIdVlanOlo = function(){
		
		if($rootScope.bozza && 
				$rootScope.bozza.customizedOffer && 
				$rootScope.bozza.customizedOffer.offerTopDetails && 
				$rootScope.bozza.customizedOffer.offerTopDetails["IDENTIFICATIVOVLANOLO"]){
			$scope._idVlanOlo = $rootScope.bozza.customizedOffer.offerTopDetails["IDENTIFICATIVOVLANOLO"].dft;
			}else{
				$scope._idVlanOlo= VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'IDENTIFICATIVOVLANOLO');
			}
		
    	if(!$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOVLANOLO.dft || $rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOVLANOLO.dft == ""){
    		$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOVLANOLO.dft = $scope._idVlanOlo;
    	}
	}
	
	/**
	 * 	Se Famiglia VLAN = 'VLAN MonoCoS Banda Condivisa' 
	 * 		allora dovrà essere valorizzato/visibile 
	 */
	$scope.configureCoS = function(){				
		if($scope._famigliaVlan){
			
			$scope._COS = VLANUtils.estraiCampoSezioneInferiore('IDENTIFICATIVOCOS');
			
	        if($scope._COS && $scope._COS.length > 0){
	        	$scope._COS.forEach(function(item){
	        		item.dft = VLANUtils.trascodeCoS(item.dft);
	        	});
	        }	
	        
			if($scope._famigliaVlan.toLowerCase() == 'vlan monocos banda condivisa'){
			    $scope.showCoS = true;  	    
			}else{
			    $scope.showCoS = false;
			}
		}else{
		    $scope.showCoS = false;
		}
	}
	
	/**
	 * SM_9825
	 * Per CC_LIB
	 * Visibile solo per VLAN NGA e valorizzabile se:
	 * 		SuperMacroarea = “Consegna su CAR di MAdR reale” (codice 0)
	 * 		oppure non valorizzata
	 */
	$scope.configureCCLIB = function(){
		
		//RU_1502
		if($scope._idOfferta == $scope._idOffertaVLAN_NGA &&
			($scope.showFlagDRG && (!$scope.data.step4.flagDRG || $scope.data.step4.flagDRG == 'N'))){
			
			if($rootScope.bozza && 
					$rootScope.bozza.customizedOffer && 
					$rootScope.bozza.customizedOffer.offerTopDetails && 
					$rootScope.bozza.customizedOffer.offerTopDetails["TIPOLOGIACLUSTERVLAN"]){
				$scope._ccLib = $rootScope.bozza.customizedOffer.offerTopDetails["TIPOLOGIACLUSTERVLAN"].dft;
				}else{
					$scope._ccLib= VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'TIPOLOGIACLUSTERVLAN');
				}
			
			$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = $scope._ccLib;
						
			if($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA){
				var _superMacroArea = ($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft || null);
				if(_superMacroArea == null || _superMacroArea.toLowerCase() == "consegna su car di madr reale"){
					$scope.showCcLib = true;
					$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = ($scope._ccLib || "");
				}else{
					$scope.showCcLib = false;
					$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = "";
				}	
			}else{
				$scope.showCcLib = false;
				$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = "";
			}			
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
		var _famigliaVLAN = $scope._famigliaVlan.toLowerCase();
		var _cos = false;
		
		if($scope._COS){
			$scope._COS.forEach(function(item){
				var _lower = item.dft.toLowerCase();
				if(_lower == "vlan monocos banda condivisa cos 0" || _lower == "vlan monocos banda condivisa cos 1"){
					_cos = true;
				}
			});
		}
		
		$scope.showCAR = false;
		$scope.enableCAR = false;
		
		if($rootScope.bozza && 
			$rootScope.bozza.customizedOffer && 
			$rootScope.bozza.customizedOffer.offerTopDetails && 
			$rootScope.bozza.customizedOffer.offerTopDetails["IDENTIFICATIVOCAR"]){
			$scope._CAR = $rootScope.bozza.customizedOffer.offerTopDetails["IDENTIFICATIVOCAR"].dft;
		}else{
			$scope._CAR = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'IDENTIFICATIVOCAR');
		}
		
		
    	if(!$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft || $rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft == ""){
    		$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = $scope._CAR;
    	}
		
		if($scope._idOfferta != $scope._idOffertaVULA){
			if((_famigliaVLAN == "vlan monocos banda condivisa" && _cos) || 
			   (_famigliaVLAN != "vlan monocos banda condivisa" && !_cos)){
				$scope.showCAR = true;
				$scope.enableCAR = true;
			}else if(_famigliaVLAN != "vlan monocos banda condivisa"){
				$scope.showCAR = true;
				$scope.enableCAR = true;			
			}else{
				$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = "";
			} 
			
		}else{
			$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = "";
		}
	}
	
	//SM_10474
	//Controllo utilizzato solo su Variazione TDKit
	$scope.configureRequiredCAR = function(){
		$scope.requiredCAR = false;
		
		var _famigliaVLAN = $scope._famigliaVlan.toLowerCase();
		var _cos = false;
		
		if($scope._COS){
			$scope._COS.forEach(function(item){
				var _lower = item.dft.toLowerCase();
				if(_lower == "vlan monocos banda condivisa cos 0" || _lower == "vlan monocos banda condivisa cos 1"){
					_cos = true;
				}
			});
		}
		
		if((_famigliaVLAN == 'vlan monocos banda condivisa' && _cos) || _famigliaVLAN == 'vlan multicos banda condivisa'){
			$scope.requiredCAR = true;
		}
	}
	
	$scope.configureCAR = function(event){
		
		event.preventDefault();
		
		if($rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR){
		
			var _request = {
				idOfferta: $scope._idOfferta,
				lavorazione: "variazione",
				famigliaVLAN: ($rootScope.customizedOffer.offerTopDetails.FAMIGLIAVLAN.dft || null),
				codiceTDKIT: ($rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft || null),
				//SM_9825
				idAsset: $scope._idAsset,
				sottolavorazione: $scope._opzioneVariazione
			};
			if($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA && $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft){
				_request.supermacroarea = ($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft || null);
			}
			if($rootScope.customizedOffer.offerBotDetails[$scope._indexCos] && $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft){
				_request.cos = ($rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft || null);
			}
			
			//SM_9825
			if($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN && $rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft){
				_request.ccLib = ($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft || null);
			}
			
			//SM_9971
			if($scope._codiceTDKIT && ($scope._codiceTDKIT == $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft)){
				_request.codiceTDKIT = $scope._codiceTDKIT;				
			}else if($rootScope.customizedOffer.offerTopDetails.CODICETDKIT && $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft != ""){
				_request.codiceTDKIT = $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft;	
			}else{
				//SM_10678
				_request.codiceTDKIT = $scope._codiceTDKIT;
			}
			
						//RU_1502
			if($scope.RU_1502 && $scope.showFlagDRG){
				_request.flagDRG = $scope.data.step4.flagDRG; 
			}
			
			$scope.loadingCAR = true ;
			$scope.arrayCAR = [];
			
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
		//RU_1502
		$scope._macroArea = item.macroArea;
	}
	
	/**** FINE SEZIONE CAR ****/
	
	
	
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
		var _cos = false;
		
		if($rootScope.bozza && 
				$rootScope.bozza.customizedOffer && 
				$rootScope.bozza.customizedOffer.offerTopDetails && 
				$rootScope.bozza.customizedOffer.offerTopDetails["SUPERMACROAREA"]){
				$scope._superMacroArea = $rootScope.bozza.customizedOffer.offerTopDetails["SUPERMACROAREA"].dft;
			}else{
				$scope._superMacroArea = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'SUPERMACROAREA');
				$scope._superMacroArea = VLANUtils.trascodeSuperMacroArea($scope._superMacroArea);
			}		
		
    	if(!$rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft || $rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft == ""){
    		$rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft = $scope._superMacroArea;
    	}
		
		if($scope._COS){
			$scope._COS.forEach(function(item){
				var _lower = item.dft.toLowerCase();
				if(_lower == "vlan monocos banda condivisa cos 3" || _lower == "vlan monocos banda condivisa cos 5"){
					_cos = true;
				}
			});
		}
		
		if([$scope._idOffertaVLAN_NGA, $scope._idOffertaVLAN_GBE].indexOf($scope._idOfferta) > -1 ){
			if($scope._COS){
				if($scope._famigliaVlan.toLowerCase() == famigliaVLAN && _cos){
					$scope.showSuperMacroArea = false;	
					$rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft = "";
				}else{					
					$scope.showSuperMacroArea = true;
					$scope.arraySuperMacroArea =  $rootScope.topDetails.SUPERMACROAREA['dft'].split(';');
				}
			}else{
				$scope.showSuperMacroArea = true;
				$scope.arraySuperMacroArea = $rootScope.topDetails.SUPERMACROAREA['dft'].split(';');
			}
		}else{
			$scope.showSuperMacroArea = false;			
			$scope.arraySuperMacroArea = [];
		}
	}
	
	
	/**
	 * Per VLAN GBE - VLAN NGA
	 * 		Se CoS = 'VLAN MonoCoS Banda Condivisa CoS 3' oppure CoS = 'VLAN MonoCoS Banda Condivisa CoS 5'  
	 * 		allora dovrà essere obbligatorio, altrimenti non valorizzato/visibile 
	 */
	$scope.configureBanda = function(){
		
		if($scope._opzioneVariazione == VLAN_VARIAZIONI.VARIAZIONE_BANDA){
			
			$scope._banda = $rootScope.customizedOffer.offerBotDetails[$scope._indexBanda].dft;
			
			var _cos = false;			
			$scope.arrayBanda = [];			
			if($scope._COS){
				$scope._COS.forEach(function(item){
					var _lower = item.dft.toLowerCase();
					if(_lower == "vlan monocos banda condivisa cos 3" || _lower == "vlan monocos banda condivisa cos 5"){
						_cos = true;
					}
				});
			}
								
			if($scope._famigliaVlan && $scope._COS){
				if($scope._famigliaVlan.toLowerCase() == 'vlan monocos banda condivisa' && _cos){
				    $scope.showBanda = true;
				    			    
				    /**
				     * Per VLAN NGA dovrà essere prevista una lista calcolata
				     * dalla quale selezionare il valore del campo
				     */    
				    
				    if($scope._idOfferta == $scope._idOffertaVLAN_NGA){
						var _request = {
								nomeCampo: 'BANDA',
								valoreCampo: $rootScope.customizedOffer.offerBotDetails[$scope._indexCos].dft
							};
							
						VisualizzaCampiOfferteVLAN.save({}, _request).$promise
							.then(function(data){
								if(data.outputCampiOfferteVLAN){								
									var _array = data.outputCampiOfferteVLAN.map(function(item) {return item.banda;});									
									angular.copy(_array, $scope.arrayBanda);
								}
							}, function(error){
								$scope.erroreService(data.descrizione);
							});
				    }
				    
				    /**
				     * Per VLAN GBE si dovra prevedere una lista con i seguenti possibili valori:
				     * da 1 a 1000 (passi di 1 Mbit/s)
				     */
				    if($scope._idOfferta == $scope._idOffertaVLAN_GBE){
				    	$scope.arrayBanda = [];
				    	for(var i=1; i<=1000; i++){
				    		$scope.arrayBanda.push(i);
				    	}
				    }			    
				    
				    
				}else{
				    $scope.showBanda = false;				    
				    $rootScope.customizedOffer.offerBotDetails[$scope._indexBanda].dft = "";
				}
			}else{
			    $scope.showBanda = false;
			    $rootScope.customizedOffer.offerBotDetails[$scope._indexBanda].dft = "";
			}
		}
	}
	
	/**
	 * Per VLAN GBE - VLAN NGA
	 * 		Se Famiglia VLAN = 'VLAN MultiCoS Banda Condivisa' 
	 * 		allora dovrà essere obbligatorio, altrimenti non valorizzato/visibile 
	 */
	
	//RU_1155
	$scope.configureShowProfiloBMC = function(){
		if($scope._famigliaVlan && $scope._famigliaVlan.toLowerCase() == 'vlan multicos banda condivisa'){
		    $scope.showProfiloBMC = true;
		}else{
			$scope.showProfiloBMC = false;
		    $rootScope.customizedOffer.offerTopDetails.PROFILOBMC.dft = "";
		}
	}
	
	$scope.configureProfiloBMC = function(event){	
		
		event.preventDefault();
		
		if($scope._opzioneVariazione == VLAN_VARIAZIONI.VARIAZIONE_BANDA){
			
			if($rootScope.bozza && 
					$rootScope.bozza.customizedOffer && 
					$rootScope.bozza.customizedOffer.offerTopDetails && 
					$rootScope.bozza.customizedOffer.offerTopDetails["PROFILOBMC"]){
					$scope._profiloBMC = $rootScope.bozza.customizedOffer.offerTopDetails["PROFILOBMC"].dft;
				}else{
					$scope._profiloBMC = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'PROFILOBMC');
				}
			
			if(!$rootScope.customizedOffer.offerTopDetails.PROFILOBMC.dft || $rootScope.customizedOffer.offerTopDetails.PROFILOBMC.dft == ""){
	    		$rootScope.customizedOffer.offerTopDetails.PROFILOBMC.dft = $scope._profiloBMC;
	    	}
		    
		    /**
		     * Dovrà essere prevista una lista calcolata dalla quale poter selezionare il valore del campo
		     */
			var _request = {
					nomeCampo: 'PROFILOBMC',
					idOfferta: $scope._idOfferta
				};
				
			VisualizzaCampiOfferteVLAN.save({}, _request).$promise
				.then(function(data){
					if(data.outputCampiOfferteVLAN){
						//RU_1155
						var _array = [];
						data.outputCampiOfferteVLAN.forEach(function(item) {
							_array.push( 
								{'profiloBMC': item.profiloBMC,
								 'bandaMulticos3': item.bandaMulticos3,
								 'bandaMulticos5': item.bandaMulticos5
								});
							});							
						
						angular.copy(_array, $scope.arrayProfiloBMC);
					}
					$scope.selectProfiloBMC();
				}, function(error){
					$scope.erroreService(data.descrizione);
				});				    
		}
	}
	
	
	//RU_1155
	$scope.selectProfiloBMC = function(){
        var _modalConfig = {
             headerText: 'Seleziona Profilo BMC',
             actionButtonText: null,
             closeButtonText: 'Ok',
             contentType: 'modale_nowtable',
             scope: $scope,
             callbackFunction: 'callbackSelectProfiloBMC',
             dataHeader: $scope.headerTabellaProfiloBMC,
             data: $scope.arrayProfiloBMC
         };
         modalService.showModal({}, _modalConfig);
	}
	
	$scope.callbackSelectProfiloBMC = function(item){
		$rootScope.customizedOffer.offerTopDetails.PROFILOBMC.dft = item.profiloBMC;
	}
	
	/**
	 * Solo per VLAN NGA e Opzione Variazione TDKit
	 */
	$scope.configureVariazioneConcordata = function(){	
		
		if($rootScope.bozza && 
				$rootScope.bozza.customizedOffer && 
				$rootScope.bozza.customizedOffer.offerTopDetails && 
				$rootScope.bozza.customizedOffer.offerTopDetails["VARIAZIONECONCORDATA"]){
				$scope._variazioneConcordata = $rootScope.bozza.customizedOffer.offerTopDetails["VARIAZIONECONCORDATA"].dft;
			}else{
				$scope._variazioneConcordata = VLANUtils.estraiCampoDettagliAsset($scope._raccoltaServizi, 'VARIAZIONECONCORDATA');
			}
		//SM_10027
		if($scope._opzioneVariazione == VLAN_VARIAZIONI.VARIAZIONE_TDKIT && [$scope._idOffertaVLAN_NGA, $scope._idOffertaVLAN_GBE].indexOf($scope._idOfferta) > -1){
			$scope.showVariazioneConcordata = true;
		}else{
			$scope.showVariazioneConcordata = false;
			$rootScope.customizedOffer.offerTopDetails.VARIAZIONECONCORDATA.dft = "";
		}
	}
		
    
	//C11M08F72 - Verifica Kit abilitato NGA
	$scope.C11M08F72 = function(){
		var _request = {
			codiceFunzione: "C11M08F72"
		};	
		
		//SM_9971
		if($scope._codiceTDKIT){
			_request.codiceTdKit = $scope._codiceTDKIT;				
		}else if($rootScope.customizedOffer.offerTopDetails.CODICETDKIT && $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft){
			request.codiceTdKit = $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft;	
		}
		
		return VerificaCodiceTDKit.save({}, _request).$promise;
	}
	
	//C04M01F454 - Verifica Modello Kit
	$scope.C04M01F454 = function(){
		var _request = {
			sottolavorazione: $scope._opzioneVariazione,
			offerta: $rootScope.data.step3.offerta.nomeOffertaCatalogo
		};	
		
		//SM_9971
		if($scope._opzioneVariazione == VLAN_VARIAZIONI.VARIAZIONE_TDKIT){
			_request.codiceTdKit = $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft;
			_request.codiceTdKitAsset = $scope._codiceTDKIT;
		}else{
			_request.codiceTdKit = $scope._codiceTDKIT;
			_request.codiceTdKitAsset = $scope._codiceTDKIT;
		}		
		
		return VerificaModelloKit.save({}, _request).$promise;
	}
	
	//SM_9825
	$scope.C11M08F82 = function(){
		
		var _codiceTdKit = "";
		
		//SM_9971
		if($scope._codiceTDKIT){
			_codiceTdKit = $scope._codiceTDKIT;				
		}else if($rootScope.customizedOffer.offerTopDetails.CODICETDKIT && $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft){
			_codiceTdKit = $rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft;	
		}		
		
		return VerificaModelloKitMadr.get({
			codiceTdKit: _codiceTdKit
		}).$promise;
	}
	
	//RU_1502
	//C11M08F106 Verifica Spostamento VLAN
	$scope.C11M08F106 = function(){
		$scope.initSpostamentoVlan ();
		return VerificaSpostamentoVlan.save($scope._C11M08F106).$promise;
	}
        
    $scope.submit_4 = function () {
    	 
        $scope.data.step4.indexBanda = $scope._indexBanda;
        $scope.data.step4.indexTipoBanda = $scope._indexTipoBanda;
        $scope.data.step4.indexCos = $scope._indexCos;
    	
    	 $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4; 
    	 
    	 if($scope._variazioniPerServizi.indexOf($scope._opzioneVariazione) > -1){
    		 
    		 var _promises = [];
    		 
    		//SM_10161
    		//Il controllo C11M08F72 va effettuato solo in caso di offerta VLAN NGA
    		 if($scope._idOfferta == $scope._idOffertaVLAN_NGA){
    			 _promises.push($scope.C11M08F72()); 
    		 }
    		 
    		 _promises.push($scope.C04M01F454());
    		 
    		 //SM_9815
    		 if($scope._opzioneVariazione == VLAN_VARIAZIONI.VARIAZIONE_CAR){
    			 _promises.push($scope.C11M08F82());
    		 }
    		 
    		 //RU_1502
    		 if([VLAN_VARIAZIONI.VARIAZIONE_CAR, VLAN_VARIAZIONI.VARIAZIONE_TDKIT].indexOf($scope._opzioneVariazione) > -1 && $scope.RU_1502){
    			 _promises.push($scope.C11M08F106());
    		 }
    		 
    		 $q.all(_promises)
    		   .then(function(promises){
    			
    			var _isResponsesOk = true;
    			var _message = "";
    			
    			promises.forEach(function(promise, index){
    				if(promise["outputModelloKit"] && promise["outputModelloKit"].esito == 'KO'){
    					_isResponsesOk = false;
    					_message = promise["outputModelloKit"].message;
    					return;
    				}
    				if(promise["ControlliCodiceTDKitOutput"] && promise["ControlliCodiceTDKitOutput"].esito == 'KO'){
    					_isResponsesOk = false;
    					_message = promise["ControlliCodiceTDKitOutput"].message;
    					return;
    				}
    				if([VLAN_VARIAZIONI.VARIAZIONE_CAR, VLAN_VARIAZIONI.VARIAZIONE_TDKIT].indexOf($scope._opzioneVariazione) > -1 && $scope.RU_1502){
						if(promise["esito"] && promise["esito"] == 'KO'){
							_isResponsesOk = false;
    						_message = "Verifica Spostamento VLAN KO";
    						return;							
						}
					}
    			});
    			
    			if(!_isResponsesOk){
    				$scope.erroreService(_message);
    			}else{
    				$state.go($scope.checkNextStateVariazione());	
    			}
    		}, function(error){
    			$scope.erroreService(error.data.result.message);
    		});      
    		 
    	 }else{
    		 $state.go($scope.checkNextStateVariazione());
    	 }              
    };
    
    $scope.cleanSuperMacroarea = function(){
    	if($rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA){
    		$rootScope.customizedOffer.offerTopDetails.SUPERMACROAREA.dft = "";
    	}
    }
    
    $scope.cleanCAR = function(){
    	if($rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR){
    		$rootScope.customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft = "";
    	}
    }
    
    $scope.cleanCCLIB = function(){
    	if($rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN){
    		$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = "";
    	}
    }
    
    $scope.cleanCodiceTdKit = function(){
    	if($rootScope.customizedOffer.offerTopDetails.CODICETDKIT){
    		$rootScope.customizedOffer.offerTopDetails.CODICETDKIT.dft = "";
    	}
    }
    
    //RU_1502
    $scope.oscuramento_RU_1502 = function() {
		$scope.RU_1502 = !$rootScope.OSCURAMENTI.RU_1502.oscurato;
    }
    
    $scope.oscuramento_RU_1502();    
    
    $scope.init();
    
    $scope.$watch("customizedOffer.offerTopDetails.CODICETDKIT.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){
    		$scope.cleanCAR();
    	}
    	if(newValue && newValue != "" && newValue != $scope._codiceTDKIT){
    		$scope.campiModificati['CODICETDKIT'] = true;
    	}else{
    		$scope.campiModificati['CODICETDKIT'] = false;
    	}
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.IDENTIFICATIVOVLANOLO.dft", function(newValue, oldValue){
    	if(newValue && newValue != "" && newValue != $scope._idVlanOlo){
    		$scope.campiModificati['IDENTIFICATIVOVLANOLO'] = true;
    	}else{
    		$scope.campiModificati['IDENTIFICATIVOVLANOLO'] = false;
    	}
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.SUPERMACROAREA.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){
    		$scope.cleanCCLIB();
    		$scope.cleanCodiceTdKit();    		
    		$scope.cleanCAR();
    	}    	
    	if(newValue && newValue != $scope._superMacroArea){
    		$scope.campiModificati['SUPERMACROAREA'] = true;
    	}else{
    		$scope.campiModificati['SUPERMACROAREA'] = false;
    	}
    	$scope.configureCCLIB();
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.VARIAZIONECONCORDATA.dft", function(newValue, oldValue){
		//SM_10027
    	if(newValue != $scope._variazioneConcordata){
    		$scope.campiModificati['VARIAZIONECONCORDATA'] = true;
    	}else{
    		$scope.campiModificati['VARIAZIONECONCORDATA'] = false;
    	}
    });
    
    $scope.$watch(function(){
    	if($scope._indexBanda && $scope._indexBanda > -1 && $rootScope.customizedOffer.offerBotDetails[$scope._indexBanda]){
    		return $rootScope.customizedOffer.offerBotDetails[$scope._indexBanda].dft;
    	}
    }, function(newValue, oldValue){
    	if(newValue && newValue != "" && newValue != $scope._banda){
    		$scope.campiModificati['BANDA'] = true;
    		$scope.configureShowProfiloBMC();
    	}else{
    		$scope.campiModificati['BANDA'] = false;
    	}    	
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.IDENTIFICATIVOCAR.dft", function(newValue, oldValue){
    	if(newValue && newValue != "" && newValue != $scope._CAR){
    		$scope.campiModificati['IDENTIFICATIVOCAR'] = true;
    	}else{
    		$scope.campiModificati['IDENTIFICATIVOCAR'] = false;
    	}
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.PROFILOBMC.dft", function(newValue, oldValue){
    	if(newValue && newValue != "" && newValue != $scope._profiloBMC){
    		$scope.campiModificati['PROFILOBMC'] = true;
    	}else{
    		$scope.campiModificati['PROFILOBMC'] = false;
    	}
    });
    
    $scope.$watch("customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft", function(newValue, oldValue){
    	if(newValue && newValue != oldValue){
    		$scope.cleanCodiceTdKit();
    		$scope.cleanCAR();
    	}
    	if(newValue && newValue != "" && newValue != $scope._profiloBMC){
    		$scope.campiModificati['TIPOLOGIACLUSTERVLAN'] = true;    		
    	}else{
    		$scope.campiModificati['TIPOLOGIACLUSTERVLAN'] = false;
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
		
	    //SM_11474
    $scope.$watch('data.step4.flagDRG', function(newValue, oldValue){
		if(newValue && newValue ==='Y'){
			$scope.showCcLib = false;
			$rootScope.customizedOffer.offerTopDetails.TIPOLOGIACLUSTERVLAN.dft = "";
			return;
		}
		$scope.showCcLib = true;
	});
    
}]);  
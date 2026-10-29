timnow.controller('dettaglioAsset', ['$scope', '$state', '$rootScope', '$log', '$resource', 'Assets', 'CRM_DG_PROFILES', '$uibModal', 'modalService', '$timeout', 'TrackingGUI', 'TRACKING_GUI', 'Detokenizzazione', 'ListaSediOlt', 'ListaFeeders', 'OscuramentoFEA32918', 'PARENTAL_CONTROL_MAP',
	function ($scope, $state, $rootScope, $log, $resource, Assets, CRM_DG_PROFILES, $uibModal, modalService, $timeout, TrackingGUI, TRACKING_GUI, Detokenizzazione, ListaSediOlt, ListaFeeders, OscuramentoFEA32918, PARENTAL_CONTROL_MAP) {

	//RU_1203
	$scope._offerteNonValideCessazione = [$rootScope.MAP_OFFERTE.FWA.id, 
		$rootScope.MAP_OFFERTE.CPS.id, 
		$rootScope.MAP_OFFERTE.VLANNGAMULTICAST.id,
		$rootScope.MAP_OFFERTE.FEEDER.id,
		$rootScope.MAP_OFFERTE.SEDEOLT.id,
		$rootScope.MAP_OFFERTE.CANALE.id,
		$rootScope.MAP_OFFERTE.NPNG.id];

	$scope._offerteNonValideVariazione = [$rootScope.MAP_OFFERTE.VLANNGAMULTICAST.id,
		$rootScope.MAP_OFFERTE.FEEDER.id,
		$rootScope.MAP_OFFERTE.SEDEOLT.id,
		$rootScope.MAP_OFFERTE.CANALE.id,
		$rootScope.MAP_OFFERTE.NPNG.id];
	
	//R1I-21-0203
	$scope.headerListFeeders = [];
    $scope.headerListFeeders.push({"key": "nomeMacroarea","value": "Macroarea","type": "text"});
    $scope.headerListFeeders.push({"key": "codiceMacroarea","value": "Codice Macroarea","type": "text"});
    $scope.headerListFeeders.push({"key": "des","value": "DES","type": "data","pattern": "dd/MM/yyyy"});
    $scope.headerListFeeders.push({"key": "clliFeederSuccessivo","value": "CLLI Feeder Succ.","type": "text"});
    $scope.headerListFeeders.push({"key": "clliPrimoFeeder","value": "CLLI Primo Feeder","type": "text"});
    $scope.headerListFeeders.push({"key": "idRisorsa","value": "ID Risorsa","type": "text"});
	
	$scope.headerListSediOlt = [];
    $scope.headerListSediOlt.push({"key": "nomeMacroarea","value": "Macroarea","type": "text"});
    $scope.headerListSediOlt.push({"key": "codiceMacroarea","value": "Codice Macroarea","type": "text"});
    $scope.headerListSediOlt.push({"key": "nomeCentralePDC","value": "Centrale PDC","type": "text"});
    $scope.headerListSediOlt.push({"key": "codiceClliPDC","value": "CLLI PDC","type": "text"});
    $scope.headerListSediOlt.push({"key": "des","value": "DES","type": "data","pattern": "dd/MM/yyyy"});
    $scope.headerListSediOlt.push({"key": "idRisorsa","value": "ID Risorsa","type": "text"});    
    $scope.headerListSediOlt.push({"key": "clliCentrale","value": "CLLI Centrale","type": "text"});

	//SM_10344
	$scope.changeState = function () {
		$rootScope.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
		$state.go($rootScope.fromState, {parametriRicerca: $state.params.parametriRicerca, init: false});
	};

	$scope.open = function (val, data) {

		//Task #34292
		if($scope.detailAsset.idOfferta == $rootScope.MAP_OFFERTE.CPS.id){
			//SM_9063
			$scope.items = $scope.transcodeOfferDetailsCPS(data, "attribute", "OPZIONETRAFFICO", "value");
		}                
		else if([$rootScope.MAP_OFFERTE.GPON_SEMI.id, $rootScope.MAP_OFFERTE.GPON_FULL.id].indexOf($scope.detailAsset.idOfferta) > -1){
			$scope.items = $scope.transcodeOfferDetailsGPON(data);
		}
		else{
			$scope.items = data;
		}

		$scope.title = val;
		$uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'app/ordini/dettaglio/dettaglioTplService.html',
			controller: 'ModalInstanceCtrl',
			resolve: {
				items: function () {
					return $scope.items;
				},
				title: function () {
					return $scope.title;
				}
			}
		});
	}

	$scope.init = function() {
		$rootScope.pageClass = $state.current.params.pageClass;
		var userProfile = $rootScope.timnowConfigData.user.codiceProfilo;
		$scope.profiloTotale = CRM_DG_PROFILES.hasOwnProperty(userProfile);

		$scope.loadDettagli = true;
		var dettaglio = Assets.get({id: $state.params.id, paramName:'idAsset', consistenza:'N'});
		dettaglio.$promise.then(function (response) {
			$scope.detailAsset = response;
			$scope.detailAsset.servizi = OscuramentoFEA32918.filtraServizi(
				$scope.detailAsset.servizi, response.idOfferta, 'customizzazione'
			);
			$scope.detailAsset.servizi = OscuramentoFEA32918.filtraServiziFEA36452(
				$scope.detailAsset.servizi, response.idOfferta, 'customizzazione'
			);
			$scope.detailAsset.servizi = OscuramentoFEA32918.filtraServiziRU1614(
				$scope.detailAsset.servizi, 'customizzazione'
			);
			$scope.decodificaProfiloParentalControl($scope.detailAsset.servizi);
			$scope.loadDettagli = false;

			//RU_1203
			if(response.idOfferta) {
				$scope.setShowButtonCessazione(response.idOfferta);
				$scope.setShowButtonVariazione(response.idOfferta);
			}
			
			$scope.oscuramento_R1F_20_0236();
			$scope.oscuramento_R1F_20_0236C();
			$scope.verificaTipologiaTokenizzazione();
			$scope.setShowButtonDetokenizzazione();

			//SM_10250
			if(response.idOfferta && response.idOfferta == $rootScope.MAP_OFFERTE.FEEDER.id){
				$scope.deleteNomeBouquetDaServizi();
				//RU_1213
				$scope.renameIpSessioneInServizi();
			}

			$scope.setTokenizzazioneClienteFinale();

		}, function (error) {
			$scope.loadDettagli = false;
			$log.info(error);
		});
	};

	$scope.decodificaProfiloParentalControl = function(servizi) {
		if(!servizi){
			return;
		}

		servizi.forEach(function(servizio) {
			if(!servizio.customizzazione){
				return;
			}

			servizio.customizzazione.forEach(function(customization) {
				if(customization.attribute == 'PROFILO' &&
					Object.prototype.hasOwnProperty.call(PARENTAL_CONTROL_MAP, customization.value)){
					customization.value = PARENTAL_CONTROL_MAP[customization.value];
				}
			});
		});
	};

	$scope.setShowButtonCessazione = function(idOfferta){
		if($scope._offerteNonValideCessazione.indexOf(idOfferta) > -1){
			$scope.showButtonCessazione = false;
		}else{
			$scope.showButtonCessazione = true;
		}
	}

	$scope.setShowButtonVariazione = function(idOfferta){
		if($scope._offerteNonValideVariazione.indexOf(idOfferta) > -1){
			$scope.showButtonVariazione = false;
		}else{
			$scope.showButtonVariazione = true;
		}
	}

	$scope.cessoAsset = function () {
		if ($scope.detailAsset.idOfferta === $rootScope.MAP_OFFERTE.NP.id) {
			modalService.showModal({}, {
				headerText: "Avviso",
				bodyText: "Per Asset di NUMBER PORTABILITY non è possibile procedere alla richiesta di cessazione da GUI",
				scope: $scope,
				type: 'success'
			});
		}
		else {			
			////////
            var _state = "";
            if($state.includes('**.listareport.**')){
				_state = "root.ordini.listareport.dettaglio.asset.cessazione";
			}else{
				_state = "root.consistenze.asset.cessazione";
			}
			$state.go(_state, {id: $scope.detailAsset.idAsset});
		}
	};

	$scope.varioAsset = function () {
		if ($scope.detailAsset.idOfferta === $rootScope.MAP_OFFERTE.NP.id) {
			modalService.showModal({}, {
				headerText: "Avviso",
				bodyText: "Per Asset di NUMBER PORTABILITY non è possibile procedere alla richiesta di Variazione da GUI",
				scope: $scope,
				type: 'success'
			});
		}
		else {
			////////
            var _state = "";
            if($state.includes('**.listareport.**')){
				_state = "root.ordini.listareport.dettaglio.asset.new.step1";
			}else{
				_state = "root.ordini.new.step1";
			}		
			
			//modificare Qui il redirect
			$rootScope.formData={};
			$state.go(_state, {asset: $state.params.asset, "init": true});
		}
	};

	//SM_9063
	$scope.transcodeOfferDetailsCPS = function(arrayOptions, objectKey, optionName, objectValue){

		var _indexKey = -1;

		if(!arrayOptions){
			return;
		}

		arrayOptions.forEach(function(option, index){
			if(option[objectKey] == optionName){
				_indexKey = index;
				return;
			}
		});

		if(_indexKey > -1){
			if(optionName === "OPZIONETRAFFICO"){
				switch(arrayOptions[_indexKey][objectValue]){
				case '0':
					arrayOptions[_indexKey][objectValue] = "Long Distance";
					break;
				case '2':
					arrayOptions[_indexKey][objectValue] = "Tutte";
					break;
				}
			}           		
		}

		return arrayOptions;
	}

	//Task #34292
	$scope.transcodeOfferDetailsGPON = function(arrayOptions){

		var _indexKeyCoinvestimento = -1;
		var _indexKeyTipologiaAccessoUbb = -1;
		var _optionNameCoinvestimento = "COINVESTIMENTO";
		var _optionNameTipologiaAccessoUbb = "TIPOLOGIAACCESSOUBB";

		if(!arrayOptions){
			return;
		}

		arrayOptions.forEach(function(option, index){
			if(option['attribute'] == _optionNameCoinvestimento){
				_indexKeyCoinvestimento = index;            			
			}
			if(option['attribute'] == _optionNameTipologiaAccessoUbb){
				_indexKeyTipologiaAccessoUbb = index;            			
			}
		});

		if(_indexKeyCoinvestimento > -1){
			switch(arrayOptions[_indexKeyCoinvestimento]['value']){
			case 'I':
				arrayOptions[_indexKeyCoinvestimento]['value'] = "IRU";
				break;
			case 'M':
				arrayOptions[_indexKeyCoinvestimento]['value'] = "Minimo Garantito";
				break;
			}     		
		}

		if(_indexKeyTipologiaAccessoUbb > -1){
			switch(arrayOptions[_indexKeyTipologiaAccessoUbb]['value']){
			case 'S':
				arrayOptions[_indexKeyTipologiaAccessoUbb]['value'] = "Semi-Gpon";
				break;
			case 'F':
				arrayOptions[_indexKeyTipologiaAccessoUbb]['value'] = "Full-Gpon";
				break;
			}     		
		}

		return arrayOptions;
	}

	//SM_10250
	//Il campo NomeBouquet presente nelle componenti, non deve essere visibile per i profili CRM_OLO*
	$scope.deleteNomeBouquetDaServizi = function(){

		if($rootScope.isOLOUser()){
			if($scope.detailAsset.servizi){
				$scope.detailAsset.servizi = _.map($scope.detailAsset.servizi, function(servizio, index){
					var _indice = -1;
					_.each(servizio.customizzazione, function(customization, indice){
						if(customization.attribute == "NOMEBOUQUET"){
							_indice = indice;
							return;
						}
					});

					if(_indice > -1){
						servizio.customizzazione.splice(_indice, 1);
					} 
					return servizio;
				});
			}
		}            	
	}

	//RU_1213            
	$scope.renameIpSessioneInServizi = function(){
		if($scope.detailAsset.servizi){
			$scope.detailAsset.servizi = _.map($scope.detailAsset.servizi, function(servizio, index){    			
				_.map(servizio.customizzazione, function(customization, indice){
					if(customization.attribute == "IPSESSIONE"){
						customization.attribute = "IPSESSIONEEBGP";
						return;
					}
				});
				return servizio;
			});
		}     	
	} 

	//RU_1180
	$scope.datiMulticastHeaderList = [];
	$scope.datiMulticastHeaderList.push({"key": "idRisorsa", "value": "Id Risorsa", "type": "text"});
	$scope.datiMulticastHeaderList.push({"key": "tipologia", "value": "Tipologia", "type": "text"});
	$scope.datiMulticastHeaderList.push({"key": "dataAbilitazione", "value": "Data Abilitazione", "type": "text", "pattern": "dd/MM/yyyy"});    

	//SM_10353
	$scope.setShowOperatoreRete = function(){
		$scope.showOperatoreRete = ($rootScope.isDGUser() || $rootScope.isMKTGUser() || $rootScope.isGAUser() || $rootScope.isPPSUser());
	}

	$scope.setShowOperatoreRete();

	/***** INIZIO DETOKENIZZAZIONE *****/

	$scope.detokenizza = function(){
		var _request = {
				codOloAgcom: $scope.detailAsset.codOAOAgcom,
				codOrdineOlo: $scope.detailAsset.ordineOao,
				flagAsset: 'Y',
				tokenReferenti: []
		}

		_request.tokenReferenti.push({
			id: -1,
			tokenCF: ($scope.detailAsset.cognome_ragSociale || null)
		});

		//R1F-20-0236
		var _trackBean = {
				timestampInizio: new Date().toISOString(),
				timestampFine: null,
				numeroDatiEsportati: 0,
				contenutoFile: null,
				nomeFile: null,
				tipoOperazione: TRACKING_GUI.EVENTI.DETOKENIZZAZIONE_REALE.descrizione,
				parametriOperazione: null,
				descrizioneFunzione: 'Ordini|Lista Asset Accesso|Dettaglio Asset'
		};

		Detokenizzazione.save({}, _request).$promise.then(function(response){                		
			if(response.result.code == 'OK'){
				var _referentiDetokenizzati = response.referentiDetokenizzati.numeriReferenti;   
				$scope._showButtonDetokenizzazione = false;
				$scope.sostituisciClienteFinaleDetokenizzato(_referentiDetokenizzati);
			}else{
				modalService.showModal({}, {
					headerText: "Detokenizzazione",
					closeButtonText: '',
					bodyText: "Dati non disponibili, riprovare più tardi",
					actionButtonText: 'Chiudi',
					scope: $scope,
					type: 'error'
				});
			}

			_trackBean.timestampFine = new Date().toISOString();
			_trackBean.esito = 'Ok';           				
			TrackingGUI.tracking(_trackBean);
		}, function(error){

			_trackBean.timestampFine = new Date().toISOString();
			_trackBean.esito = 'Ko';           				
			TrackingGUI.tracking(_trackBean);

			modalService.showModal({}, {
				headerText: "Detokenizzazione",
				closeButtonText: '',
				bodyText: "Dati non disponibili, riprovare più tardi",
				actionButtonText: 'Chiudi',
				scope: $scope,
				type: 'error'
			});
		});  	
	}    
	
	$scope.sostituisciClienteFinaleDetokenizzato = function(_referentiDetokenizzati){
		if(_referentiDetokenizzati && _referentiDetokenizzati.length > 0){
			$scope.detailAsset.nome = _referentiDetokenizzati[0].nome;
			$scope.detailAsset.cognome_ragSociale = _referentiDetokenizzati[0].cognome;
			$scope.detailAsset.cf = _referentiDetokenizzati[0].codFiscale;
			$scope.detailAsset.piva = _referentiDetokenizzati[0].pIva;						
			$scope._showButtonDetokenizzazione = false;			
		}
	}
	
	//Task #36766
	$scope.setShowButtonDetokenizzazione = function(){
		$scope._showButtonDetokenizzazione = false;
		if($scope._ordineTokenizzatoD420){
			$scope._showButtonDetokenizzazione = $rootScope.isSUPERUserInterno();
		}else if($scope._ordineTokenizzatoC2Plus){
			$scope._showButtonDetokenizzazione = $rootScope.isSUPERUser();
		}
	}

	$scope.setTokenizzazioneClienteFinale = function(){    	
		if($scope.detailAsset){			
			if($scope.R1F_20_0236C && $scope._ordineTokenizzatoC2Plus){		
				
				$scope.detailAsset.cognome_ragSocialeFittizio = angular.copy($scope.detailAsset.cognome_ragSociale);
				$scope.detailAsset.nomeFittizio = angular.copy($scope.detailAsset.nome);
				$scope.detailAsset.cfFittizio = angular.copy($scope.detailAsset.cf);
				$scope.detailAsset.pivaFittizio = angular.copy($scope.detailAsset.piva);

				$scope.detailAsset.cognome_ragSociale = $scope._patternDetokenizzazioneFittizia;
				$scope.detailAsset.nome = $scope._patternDetokenizzazioneFittizia;
				$scope.detailAsset.cf = $scope._patternDetokenizzazioneFittizia;
				$scope.detailAsset.piva = $scope._patternDetokenizzazioneFittizia;        
			}
		}
	}

	$scope.detokenizzaClienteFinale = function(){
		if($scope.detailAsset){
			if($scope.R1F_20_0236C && $scope._ordineTokenizzatoC2Plus){
				$scope.detailAsset.cognome_ragSociale = angular.copy($scope.detailAsset.cognome_ragSocialeFittizio);
				$scope.detailAsset.nome = angular.copy($scope.detailAsset.nomeFittizio);
				$scope.detailAsset.cf = angular.copy($scope.detailAsset.cfFittizio);
				$scope.detailAsset.piva = angular.copy($scope.detailAsset.pivaFittizio);

				delete $scope.detailAsset['cognome_ragSocialeFittizio'];
				delete $scope.detailAsset['nomeFittizio'];
				delete $scope.detailAsset['cfFittizio'];
				delete $scope.detailAsset['pivaFittizio'];
				
				$scope.detokenizzazioneFittiziaTracking();

			}
			
			if($scope._ordineTokenizzatoD420){
				$scope.detokenizza();
			}else{
				$scope._showButtonDetokenizzazione = false;
			}		
		}
	}

	//R1F-20-0236.C
	$scope.detokenizzazioneFittiziaTracking = function(){            	
		var _trackBean = {
				timestampInizio: new Date().toISOString(),
				timestampFine: null,
				numeroDatiEsportati: 0,
				contenutoFile: null,
				nomeFile: null,
				tipoOperazione: TRACKING_GUI.EVENTI.DETOKENIZZAZIONE_FITTIZZIA.descrizione,
				parametriOperazione: null,
				descrizioneFunzione: 'Ordini|Lista Asset Accesso|Dettaglio Asset'
		};

		//Ritardo fake
		$timeout(function(){
			_trackBean.timestampFine = new Date().toISOString();
			_trackBean.esito = 'Ok';

			TrackingGUI.tracking(_trackBean);
		}, 1000);
	}

	//R1F-20-0236
	$scope.oscuramento_R1F_20_0236 = function(){
		try {									
			if(!$rootScope.OSCURAMENTI.R1F_20_0236.oscurato){
				$scope.R1F_20_0236 = ($rootScope.OSCURAMENTI.R1F_20_0236.idOfferteNonValide.indexOf($scope.detailAsset.idOfferta) == -1);
			}else {
				$scope.R1F_20_0236 = false;
			}									
			
		} catch (e) {
			$scope.R1F_20_0236 = false;
		}       	
	}

	//R1F-20-0236.C
	$scope.oscuramento_R1F_20_0236C = function(){
		try{
			if($scope.R1F_20_0236 && !$rootScope.OSCURAMENTI.R1F_20_0236C.oscurato){           		
				$scope.R1F_20_0236C = true;
				$scope._patternDetokenizzazioneFittizia = $rootScope.OSCURAMENTI.R1F_20_0236C.pattern;
			}else{
				$scope.R1F_20_0236C = false;
			}            		
		}catch(e){
			$scope.R1F_20_0236C = false;
		}          	
	}
	
	// RU_1560
	$scope.oscuramento_RU_1560 = function(){
		try{
			$scope.RU_1560 = !$rootScope.OSCURAMENTI.RU_1560.oscurato;
		}catch(e){
			$scope.RU_1560 = false;
		}    
	}

	$scope.oscuramento_RU_1560();  
	
	//SM_10585
	$scope.verificaTipologiaTokenizzazione = function(){
		
		var _regexD420 = new RegExp("^dk");
		var _regexC2Plus = new RegExp("^kk");
		//SM_10603
		if($scope.detailAsset.cognome_ragSociale){
			$scope._ordineTokenizzatoD420 = (_regexD420.test($scope.detailAsset.cognome_ragSociale) || _regexD420.test($scope.detailAsset.cognome_ragSociale));
			$scope._ordineTokenizzatoC2Plus = !$scope._ordineTokenizzatoD420;
		}else{
			//SM_10618
			$scope._ordineTokenizzatoC2Plus = true;
		}
	}


	/***** FINE DETOKENIZZAZIONE *****/
	
	//R1I-21-0203
	$scope.visualizzaFeeder = function(){
		
		$scope.arrayFeeder = [];
		
		ListaFeeders.get({'idAsset': $scope.detailAsset.idAsset}).$promise
		.then(function(response){
			if(response.result.code == 'OK'){
				angular.copy(response.FeederDettaglioAssetOutput, $scope.arrayFeeder);
			}
			$scope.showListaFeeder();
		}, function(error){
			modalService.showModal({}, {
				headerText: "Avviso",
				bodyText: "Errore nel recupero dati Feeder",
				scope: $scope,
				type: 'success'
			});
		});
	}
	
	$scope.showListaFeeder = function(){
        var _modalConfig = {
             headerText: 'Feeders',
             actionButtonText: null,
             closeButtonText: 'Ok',
             contentType: 'modale_nowtable_no_selection',
             scope: $scope,
             dataHeader: $scope.headerListFeeders, 
             data: $scope.arrayFeeder
         };
         modalService.showModal({}, _modalConfig);
	}
	
	$scope.visualizzaSediOlt = function(){
		
		$scope.arraySediOlt = [];
		
		ListaSediOlt.get({'idAsset': $scope.detailAsset.idAsset}).$promise
		.then(function(response){
			if(response.result.code == 'OK'){
				angular.copy(response.SediOltDettaglioAssetOutput, $scope.arraySediOlt);
			}
			$scope.showListaSediOlt();
		}, function(error){
			modalService.showModal({}, {
				headerText: "Avviso",
				bodyText: "Errore nel recupero dati Sedi OLT",
				scope: $scope,
				type: 'success'
			});
		});
	}
	
	$scope.showListaSediOlt = function(){
        var _modalConfig = {
             headerText: 'Sedi OLT',
             actionButtonText: null,
             closeButtonText: 'Ok',
             contentType: 'modale_nowtable_no_selection',
             scope: $scope,
             dataHeader: $scope.headerListSediOlt, 
             data: $scope.arraySediOlt
         };
         modalService.showModal({}, _modalConfig);
	}
	
	$scope.init();

}]);
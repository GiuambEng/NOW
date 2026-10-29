//RU_1150
timnow.controller('ubbAttivazioneStep7', ['$scope', '$state', '$rootScope', '$timeout', 'modalService', 'RecuperaCodServizioSysUnico', 'RecuperaIdGpon', 'RecuperaCodiceSystemUnico', 'RecuperaCodiceSubAppalto', 'RecuperaTipologiaImpresa', 'RecuperaServiziOpzionaliAlternativi', '_',
	function ($scope, $state, $rootScope, $timeout, modalService, RecuperaCodServizioSysUnico, RecuperaIdGpon, RecuperaCodiceSystemUnico, RecuperaCodiceSubAppalto, RecuperaTipologiaImpresa, RecuperaServiziOpzionaliAlternativi, _) {
	
	// RU_1560
    $scope.oscuramento_RU_1560 = function(){
    	try{
			$scope.RU_1560 = !$rootScope.OSCURAMENTI.RU_1560.oscurato;
			$scope.offertaValida_RU_1560 = $rootScope.OSCURAMENTI.RU_1560.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1;
    	}catch(e){
    		$scope.RU_1560 = false;
    	}          	
    }
    
   	$scope.oscuramento_RU_1560();  
	
	$scope.arrayIdGpon = [];
	$scope.listCodiceServizio = [];
	$scope.listCodiceSubappalto = [];
    $scope.listCodiceSystemUnico = [];
    //RU_1428
    $scope._idAreaDiCentrale = "";

	$scope.headerTabellaIdGpon = [];
	//RU_1274
	$scope.headerTabellaIdGpon.push({"key": "idGpon","value": "IDGPON","type": "text"});
	$scope.headerTabellaIdGpon.push({"key": "codiceAreaCentrale","value": "Codice Area Centrale","type": "text"});
	$scope.headerTabellaIdGpon.push({"key": "puntoInterconnessione","value": "Punto Interconnessione","type": "text"});
	$scope.headerTabellaIdGpon.push({"key": "codificaOlo","value": "Codifica OLO","type": "text"});
	
	$scope._codOloAgcom = ($scope.data.step1.operatore.codiceOLO || null);
	
    $scope._idOfferta = $scope.data.step3.offerta.idOfferta;
    $scope._idOffertaGPON_SEMI = $rootScope.MAP_OFFERTE.GPON_SEMI.id;
    $scope._idOffertaGPON_FULL = $rootScope.MAP_OFFERTE.GPON_FULL.id;    
    
    $scope.maxLengthServiziOpzionali = 10;
    //RU_1485
    $scope.maxLengthServiziOpzionaliAlternativi = 10;
     
    //RU_1393
    //RU_1430
    //RU_1432
    $scope.isOffertaSemiGPON = ($scope._idOfferta == $rootScope.MAP_OFFERTE.GPON_SEMI.id) || false;

    $scope.subFormView = [false, false, false, false, false, false];
    $scope.showGestioneAutonoma = false;
    $scope.showPresaAppuntamento = false;
    $scope.showPrestazioniAggiuntive = false;
    $scope.showSlaPlusSu = false;
    
    //RU_1485
	var _codiceProgetto = $scope.data.step2.codice_progetto;
    $scope.showServiziOpzionaliAlternativi = (_codiceProgetto && _codiceProgetto.prodottiACatalogo == 'SI' && _codiceProgetto.oneStep) || false;
    $scope.showServiziOpzionali = (_codiceProgetto && (_.isUndefined(_codiceProgetto.prodottiACatalogo) || _codiceProgetto.prodottiACatalogo == 'NO')) || false;
	
	if (!$rootScope.data.step7) {
        $rootScope.data.step7 = $scope.data.step7 = {};
    }
	
    //Inizializzazione dati aggregato Servizi Opzionali
    if(!$scope.data.step7.datiServiziOpzionali || $scope.data.step7.datiServiziOpzionali.length == 0){
    	$scope.data.step7.datiServiziOpzionali = [{
    		id: 1,
    		codiceServizio: null,
    		descrizioneServizio: null,
    		datiTecnici: null,
    		vincolantePerEspletamento: null
    	}];
    }
    
    //RU_1485
    //Inizializzazione dati aggregato Servizi Opzionali Alternativi
    if(!$scope.data.step7.datiServiziOpzionaliAlternativi || $scope.data.step7.datiServiziOpzionaliAlternativi.length == 0){
    	$scope.data.step7.datiServiziOpzionaliAlternativi = [{
    		id: 1,
    		codiceServizio: null,
    		codiceServizioPadre: null,
    		descrizioneServizio: null
    	}];
    }
    
    //RU_1428
    if( $scope.isOffertaSemiGPON && (!$scope.data.step7.datiGestioneAutonoma)){
		$scope.data.step7.datiGestioneAutonoma = {
			impresaSystem: "",
			operatoreSystem: "",
			systemUnico: "",
			subAppalto: "",
			tipologiaImpresa: "",
			noteSu: ""
		} 
	}
    
    $scope.init = function(){     	        	
        $scope.configureServiziOpzionali();
        //RU_1393
        if($scope.isOffertaSemiGPON){
			$scope.setShowGestioneAutonoma();
			$scope.setShowPrestazioniAggiuntive();
			$scope.setShowSlaPlusSu();
			$scope.setShowPresaAppuntamento();
		}
    }
	
	/**
	 * 	Per IDGPON
	 * 		Dovrà essere prevista una lista dalla quale poter selezionare il valore del campo
	 */	
	$scope.configureIdGpon = function(event){

		event.preventDefault();			
			
		$scope.loadingIdGpon = true;			
		$scope.arrayIdGpon = [];
		
		var _request = {
			coinvestimento: $scope.data.step7.coinvestimento,
			codOloAgcom: $scope._codOloAgcom,
			idOfferta: $scope._idOfferta
		};
		
		//RU_1338
		if($scope.oscuramento_RU_1338){
			$scope.headerTabellaIdGpon.push({"key": "fattoreDiSplitting","value": "Fattore di Splitting","type": "text"});
			$scope.headerTabellaIdGpon.push({"key": "dataRegistrazioneFattoreDiSplitting","value": "Data registrazione fattore di Splitting","type": "data", "pattern": "dd/MM/yyyy"});
			$scope.headerTabellaIdGpon.push({"key": "idGponValido","value": "IDGPON Valido","type": "text"});
		}
		
		RecuperaIdGpon.save({}, _request).$promise
			.then(function(data){
				$scope.loadingIdGpon = false;
				if(data.outputIdGpon && data.outputIdGpon.length > 0){						
					angular.copy(data.outputIdGpon, $scope.arrayIdGpon);
				}
				$scope.selectIdGpon();
			}, function(error){
				$scope.loadingIdGpon = false;
				$scope.data.step7.idGpon = "";
				$scope.erroreService("Errore nel recupero dati IDGPON");
			});
	}	
	
	$scope.selectIdGpon = function(){
        var _modalConfig = {
             headerText: 'Seleziona IDGPON',
             actionButtonText: null,
             closeButtonText: 'Ok',
             contentType: 'modale_nowtable',
             scope: $scope,
             callbackFunction: 'callbackSelectIdGpon',
             dataHeader: $scope.headerTabellaIdGpon,
             data: $scope.arrayIdGpon
         };
         modalService.showModal({}, _modalConfig);
	}
	
	$scope.callbackSelectIdGpon = function(item){
		$scope.data.step7.idGpon = item.idGpon;
		if($scope.isOffertaSemiGPON){
			$scope.clearGestioneAutonoma();
		}
	}
		
	/***** FINE IDGPON *****/
	
	/***** INIZIO CONFIGURAZIONE DAI *****/
	
	$scope.popup_dai = {
		opened: false
	};

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
    
    $scope.openDaiPicker = function () {
    	$scope.popup_dai.opened = true;
    };
    
    // Disable weekend selection
    function disabled(data) {
        var date = data.date, mode = data.mode;
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    }
    
    /***** FINE CONFIGURAZIONE DAI *****/
    
    /***** INIZIO CONFIGURAZIONE SERVIZI OPZIONALI *****/
    
    $scope.deleteServizioOpzionale = function(index){
    	if($scope.data.step7.datiServiziOpzionali && $scope.data.step7.datiServiziOpzionali.length > 1){
    		$scope.data.step7.datiServiziOpzionali.splice(index, 1);
    	}
    	
    	//Riallineamento id servizi
    	if($scope.data.step7.datiServiziOpzionali.length == 1){
    		$scope.data.step7.datiServiziOpzionali.id = 1;
    	}else{
    		$scope.data.step7.datiServiziOpzionali.forEach(function(item, index){
    			item.id = index + 1;
    		});
    	}
    }
    
    $scope.addServizioOpzionale = function(event){
		event.preventDefault();
    	if($scope.data.step7.datiServiziOpzionali && $scope.data.step7.datiServiziOpzionali.length < $scope.maxLengthServiziOpzionali){
    		$scope.data.step7.datiServiziOpzionali.push({
        		id: $scope.data.step7.datiServiziOpzionali.length + 1,
        		codiceServizio: null,
        		descrizioneServizio: null,
        		datiTecnici: null,
        		vincolantePerEspletamento: null
        	});
    	}
    }
    
    //Per evitare di creare aggregati vuoti, elimino tutti i servizi opzonali vuoti
    $scope.deleteServizioOpzionaleEmpty = function(){
    	
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionali);
    	
    	if(appArray && appArray.length > 0){
    		for(var i=0; i<appArray.length; i++){
    			if(!appArray[i]['codiceServizio'] || appArray[i]['codiceServizio'] == ""){
    				$scope.data.step7.datiServiziOpzionali.splice(i, 1);
    			}
    		}
    	}
    }
    
    //SM_11214
    $scope.deleteSlaPlusSuEmpty = function(){
		if($scope.isOffertaSemiGPON && $scope.data.step7.datiSlaPlusSu && !$scope.data.step7.datiSlaPlusSu.flagSlaPlusSu){
	    	 $scope.data.step7.datiSlaPlusSu = {};
	    }
    }
    
    //La sezione Servizi Opzionali, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isServiziOpzionaliRequired = function(form){
    	$timeout(function(){
        	if(form){
        		if((form.descrizioneServizio.$modelValue && form.descrizioneServizio.$modelValue !== "") 
        				|| (form.datiTecnici.$modelValue && form.datiTecnici.$modelValue !== "")
        				|| (form.vincolantePerEspletamento.$modelValue && form.vincolantePerEspletamento.$modelValue !== "")){
        			$scope.isServiziOpzionaliRequiredFlag = true;
        		}else{
        			$scope.isServiziOpzionaliRequiredFlag = false;
        		}
        	} else{
    			$scope.isServiziOpzionaliRequiredFlag = false;
    		}
    	}, 100);
    }
    
    //C01M02F28 - Determina Area Di Cantiere
    $scope.C01M02F28 = function(){
    	var _baseRequest = {
    			idOfferta: $scope.data.step3.offerta.idOfferta,
    			codificaOloAgcom: $scope.data.step1.operatore.codiceOLO,
    			RU1560: ($scope.RU_1560 && $scope.offertaValida_RU_1560) ? "SI" : "NO"
    	};
    	
    	try{
    		if($scope.data.step6.indirizzoDatiClienteFinale && Object.keys($scope.data.step6.indirizzoDatiClienteFinale).length > 0){    			
    			_baseRequest.datiClienteFinale = {};
    			angular.copy($scope.data.step6.indirizzoDatiClienteFinale, _baseRequest.datiClienteFinale);
    			
	    		delete _baseRequest.datiClienteFinale['indirizzo_cliente_interno'];
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_piano'];
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_scala'];
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_complesso'];
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_cap'];
		    	//Task #34291
		    	delete _baseRequest.datiClienteFinale['indirizzo_cliente_codice_egon'];
    		}
    	}catch(e){
    		console.error(e)
    	}
    	   	
    	_baseRequest.flagCodiceServizio = true;
    	
		return RecuperaCodServizioSysUnico.save(_baseRequest).$promise;
    }
    
    $scope.configureServiziOpzionali = function(){
    	$scope.listCodiceServizio = [];
    	$scope.C01M02F28().then(function(data){
    		if(data.result.message == 'KO'){
    			$scope.erroreService(data.result.message);
    			$scope.listCodiceServizio = [];
    		}
    		else{
    			if(!data.codiceServizio || data.codiceServizio.length == 0){
    	            $scope.erroreCodiceServizio = "Nessun valore trovato per Codice Servizio";
    				$scope.listCodiceServizio = [];
    			}
    			else{
    				$scope.erroreCodiceServizio = null;
    				$scope.listCodiceServizio = data.codiceServizio;	
    			}    			    		
    		}
    	}, function(error){
    		// Error callback
            $scope.erroreService("Impossibile caricare lista valori Codice Servizio");
			$scope.listCodiceServizio = [];
    	});
    }
    
	//Ricerca codici servizi duplicati e nel caso, inibisce il passaggio allo step successivo
	$scope.checkDuplicateServiziOpzionali = function(){
		$scope.erroreCodiceServizio = "";
		
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionali);    	
    	var _result = {
    		flag: false,
    		codice: ""	
    	};
    	
    	var _arrayDuplicati = [];
    	
    	if(appArray && appArray.length > 0){
	
			//Cerca i duplicati nella lista di object	
    		_arrayDuplicati = _.chain(appArray).groupBy('codiceServizio').filter(function(v){return v.length > 1}).flatten().uniq().value();
    		if(_arrayDuplicati && _arrayDuplicati.length > 0){
				_result.flag = true;
    			_result.codice = _arrayDuplicati[0].codiceServizio;
			}
    	}
    	return _result;
	}
    
    /***** FINE CONFIGURAZIONE SERVIZI OPZIONALI *****/
    
    
    //RU_1485
    /***** INIZIO CONFIGURAZIONE SERVIZI OPZIONALI ALTERNATIVI *****/
    
    $scope.deleteServizioOpzionaleAlternativo = function(index){
    	if($scope.data.step7.datiServiziOpzionaliAlternativi && $scope.data.step7.datiServiziOpzionaliAlternativi.length > 1){
    		$scope.data.step7.datiServiziOpzionaliAlternativi.splice(index, 1);
    	}
    	
    	//Riallineamento id servizi
    	if($scope.data.step7.datiServiziOpzionaliAlternativi.length == 1){
    		$scope.data.step7.datiServiziOpzionaliAlternativi.id = 1;
    	}else{
    		$scope.data.step7.datiServiziOpzionaliAlternativi.forEach(function(item, index){
    			item.id = index + 1;
    		});
    	}
    }
    
    $scope.addServizioOpzionaleAlternativo = function(event){
		event.preventDefault();
    	if($scope.data.step7.datiServiziOpzionaliAlternativi && $scope.data.step7.datiServiziOpzionaliAlternativi.length < $scope.maxLengthServiziOpzionaliAlternativi){
    		$scope.data.step7.datiServiziOpzionaliAlternativi.push({
        		id: $scope.data.step7.datiServiziOpzionaliAlternativi.length + 1,
        		codiceServizio: null,
        		descrizioneServizio: null
        	});
    	}
    }
    
    //Per evitare di creare aggregati vuoti, elimino tutti i servizi opzonali vuoti
    $scope.deleteServizioOpzionaleAlternativoEmpty = function(){
    	
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionaliAlternativi);
    	
    	if(appArray && appArray.length > 0){
    		for(var i=0; i<appArray.length; i++){
    			if(!appArray[i]['codiceServizio'] || appArray[i]['codiceServizio'] == ""){
    				$scope.data.step7.datiServiziOpzionaliAlternativi.splice(i, 1);
    			}
    		}
    	}
    }
    
    //C11M08F102 - Visualizzazione Codici Servizio Alternativo
    $scope.C11M08F102 = function(){
    	var _baseRequest = {
    			codiceProgetto: $scope.data.step2.codice_progetto.cod_prgt
    	};
    	
		return RecuperaServiziOpzionaliAlternativi.get(_baseRequest).$promise;
    }
    
    $scope.configureServiziOpzionaliAlternativi = function(){
    	$scope.listCodiceServizioAlternativo = [];
    	
    	$scope.C11M08F102().then(function(data){
    		if(data.result.message == 'KO'){
    			$scope.erroreService(data.result.message);
    			$scope.listCodiceServizioAlternativo = [];
    		}
    		else{
    			if(!data.listaServiziOpzionaliAlternativi || data.listaServiziOpzionaliAlternativi.length == 0){
    	            $scope.erroreCodiceServizio = "Attenzione, nessun servizio opzionale alternativo presente in base dati per il Codice Progetto selezionato";
    				$scope.listCodiceServizioAlternativo = [];
    			}
    			else{
    				$scope.erroreCodiceServizio = null;
    				$scope.listCodiceServizioAlternativo = data.listaServiziOpzionaliAlternativi;	
    			}    			    		
    		}
    	}, function(error){
    		// Error callback
            $scope.erroreService("Impossibile caricare lista valori Codice Servizio");
			$scope.listCodiceServizioAlternativo = [];
    	});
    }
    
	//Ricerca codici servizi duplicati e nel caso, inibisce il passaggio allo step successivo
	$scope.checkDuplicateServiziOpzionaliAlternativi = function(){
		$scope.erroreCodiceServizio = "";
		
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionaliAlternativi);    	
    	var _result = {
    		flag: false,
    		codice: ""	
    	};
    	
    	var _arrayDuplicati = [];
    	
    	if(appArray && appArray.length > 0){
			//Cerca i duplicati nella lista di object
			//TODO: da modificare la proprietà 'codiceServizio' nel caso  		
    		_arrayDuplicati = _.chain(appArray).groupBy('codiceServizio').filter(function(v){return v.length > 1}).flatten().uniq().value();
    		if(_arrayDuplicati && _arrayDuplicati.length > 0){
				_result.flag = true;
    			_result.codice = _arrayDuplicati[0].codiceServizio;
			}
    	}
    	return _result;
	}
	
	//Ricerca codici servizi padre duplicati e nel caso, inibisce il passaggio allo step successivo
	$scope.checkDuplicatePadreServiziOpzionaliAlternativi = function(){
		$scope.erroreCodiceServizio = "";
		
    	var appArray = angular.copy($scope.data.step7.datiServiziOpzionaliAlternativi);    	
    	var _result = {
    		flag: false,
    		codice: ""	
    	};
    	
    	var _arrayDuplicati = [];   	
    	
    	if(appArray && appArray.length > 0){    		
    		//Cerca i duplicati nella lista di object
    		//TODO: da modificare la proprietà 'codiceServizioPadre' nel caso
    		_arrayDuplicati = _.chain(appArray).groupBy('codiceServizioPadre').filter(function(v){return v.length > 1}).flatten().uniq().value();
    		if(_arrayDuplicati && _arrayDuplicati.length > 0){
				_result.flag = true;
    			_result.codice = _arrayDuplicati[0].codiceServizioPadre;
			}
    	}
    	
    	return _result;
	}
	
	$scope.setDescrizioneServizioOpzionaleAlternativo = function(codiceServizio, index) {
		let _servizioOpzionaleAlternativo = null;
		$scope.data.step7.datiServiziOpzionaliAlternativi[index].descrizioneServizio = "";
		if($scope.listCodiceServizioAlternativo && $scope.listCodiceServizioAlternativo.length > 0){
			_servizioOpzionaleAlternativo = _.findWhere($scope.listCodiceServizioAlternativo, {'servizioOpzionaleAlternativo': codiceServizio});
			if(_servizioOpzionaleAlternativo){
				$scope.data.step7.datiServiziOpzionaliAlternativi[index].descrizioneServizio = _servizioOpzionaleAlternativo.descrizioneAnagraficaServizioOpzionale;
				$scope.data.step7.datiServiziOpzionaliAlternativi[index].codiceServizioPadre = _servizioOpzionaleAlternativo.servizioOpzionalePadre;		
			}
		}
	}
	
	$scope.$watch("showServiziOpzionaliAlternativi", function(newValue, oldValue){
		if(newValue){
			$scope.configureServiziOpzionaliAlternativi();
		}else{
			$scope.listCodiceServizioAlternativo = [];
		}
	});
    
    /***** FINE CONFIGURAZIONE SERVIZI OPZIONALI ALTERNATIVI *****/
    
    //RU_1393
    /***** INIZIO CONFIGURAZIONE GESTIONE AUTONOMA *****/

	$scope.triggerCodiceSystemUnico_GestioneAutonoma = function(type){
		$scope.listCodiceSystemUnico = [];		
						
		var _request = {
			codOloAgcom: $scope.data.step1.operatore.codiceOLO,
			idGpon: $scope.data.step7.idGpon,
			systemType: type
		};	
		
		//RU_1428
		RecuperaCodiceSystemUnico.save(_request).$promise
		.then(function(data){
        		if(data.result.message == 'KO'){
        			$scope.erroreService(data.result.message);
        		}
        		else{
        			if(!data.outputCodSystemUnico || data.outputCodSystemUnico.length == 0){
        	            $scope.erroreCodiceSystemUnico = "Nessun valore trovato per System Unico";
        			}
        			else{
        				$scope.erroreCodiceSystemUnico = "";
        				$scope.listCodiceSystemUnico = data.outputCodSystemUnico;	
        			}
        			    		
        		}
        	}, function(error){
        		// Error callback
        		$scope.erroreCodiceSystemUnico = "Nessun valore trovato per System Unico";
                $scope.erroreService("Impossibile caricare lista valori Codice System Unico");
        	});	
	}
	
	$scope.triggerCodiceSubAppalto_GestioneAutonoma = function(){
		$scope.listCodiceSubappalto = [];
		var _request = {
			codOloAgcom: $scope.data.step1.operatore.codiceOLO,
			idGpon: $scope.data.step7.idGpon,
			
		};		
		RecuperaCodiceSubAppalto.save(_request).$promise
		.then(function(data){
        		if(data.result.message == 'KO'){
        			$scope.erroreService(data.result.message);
        		}
        		else{
        			if(!data.codSubAppalto || data.codSubAppalto.length == 0){
        	            $scope.erroreCodiceSubAppalto = "Nessun valore trovato per Subappalto";
        			}
        			else{
        				$scope.erroreCodiceSubAppalto = "";
        				$scope.listCodiceSubappalto = data.codSubAppalto;	
        			}
        			    		
        		}
        	}, function(error){
        		// Error callback
        		$scope.erroreCodiceSubAppalto = "Nessun valore trovato per Subappalto";
                $scope.erroreService("Impossibile caricare lista valori Subappalto");
        	});	
	}
	
	//RU_1428
	$scope.trigger_tipologiaImpresa = function(){
    	
    	var _request = {
			codOloAgcom: $scope.data.step1.operatore.codiceOLO,
			idAreaDiCentrale: $scope.data.step7.datiGestioneAutonoma.idAreaDiCentrale,
			codImpresa: $scope.data.step7.datiGestioneAutonoma.systemUnico
		};
    	
    	RecuperaTipologiaImpresa.save(_request).$promise
    	.then(function(data){
    		if(data.result.message == 'KO'){
    			$scope.erroreService(data.result.message);
    		}
    		else{
    			if(!data.outputTipologiaImpresa || data.outputTipologiaImpresa.length == 0){
    	            $scope.erroreTipologiaImpresa = "Nessun valore trovato per Tipologia Impresa";
    			}
    			else{
    				$scope.erroreTipologiaImpresa = null;
    				$scope.data.step7.datiGestioneAutonoma.tipologiaImpresa = data.outputTipologiaImpresa[0] || null;
    			}    			    		
    		}
    	}, function(error){
    		// Error callback
            $scope.erroreService("Impossibile caricare lista valori Tipologia Impresa");
    	});
    }
    
    //SM_11170
	//La sezione Gestione Autonoma, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isGestioneAutonomaRequired = function(form){
	 	$timeout(function(){
			if(form){
    			if((form.impresaSystem.$modelValue && form.impresaSystem.$modelValue == "Y") || (form.operatoreSystem.$modelValue && form.operatoreSystem.$modelValue == "Y")){
    				$scope.isGestioneAutonomaRequiredFlag = true;
    			}else {
    				$scope.isGestioneAutonomaRequiredFlag = false;
    			}
    		}else {
				$scope.isGestioneAutonomaRequiredFlag = false;
			}
		}, 100);
    }
    
    $scope.deleteGestioneAutonomaEmpty = function(){
		var _gestioneAutonoma = $scope.data.step7.datiGestioneAutonoma;
    	if(_gestioneAutonoma){
			if(!_gestioneAutonoma.systemUnico){
				$scope.data.step7.datiGestioneAutonoma = {};
			}
		}
    }
    
    /***** FINE CONFIGURAZIONE GESTIONE AUTONOMA *****/
    
       
    $scope.submitFormVlan = function(event) {
    	event.stopPropagation();
    	
    	//SM_11134
    	if(!$scope.isOffertaSemiGPON){
	
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
	
	    	if($scope.data.step7.datiSlaPlusSu){
	    		delete $scope.data.step7.datiSlaPlusSu;
	    	}
	    	
	    	if($scope.data.step7.datiServiziOpzionali.length > 0 && $scope.data.step7.datiServiziOpzionali[0].codiceServizio == null){
	    		delete $scope.data.step7.datiServiziOpzionali;
	    	}
	    	
	    	if($scope.data.step7.datiGestioneAutonoma){
				delete $scope.data.step7.datiGestioneAutonoma;
			}
		}else{
			$scope.deleteGestioneAutonomaEmpty();
			$scope.deleteSlaPlusSuEmpty();
		}
    	
    	//Task #34291
    	$scope.deleteServizioOpzionaleEmpty();
    	$scope.deleteServizioOpzionaleAlternativoEmpty();
    	
    	$rootScope.formData.data.step7 = $rootScope.data.step7 = $scope.data.step7;
    	
    	//RU_1485
		var _checkDuplicatiServiziOpzionali = $scope.checkDuplicateServiziOpzionali();	
		var _checkDuplicatiServiziOpzionaliAlternativi = $scope.checkDuplicateServiziOpzionaliAlternativi();
		var _checkDuplicatiPadreServiziOpzionaliAlternativi = $scope.checkDuplicatePadreServiziOpzionaliAlternativi();	
		if(_checkDuplicatiServiziOpzionali && _checkDuplicatiServiziOpzionali.flag){
	    	$scope.erroreService("Attenzione: hai inserito piu' volte il servizio opzionale con codice servizio " + _checkDuplicatiServiziOpzionali.codice); 
	    	return;
		}
		if(_checkDuplicatiServiziOpzionaliAlternativi && _checkDuplicatiServiziOpzionaliAlternativi.flag){
	    	$scope.erroreService("Attenzione: hai inserito piu' volte il servizio opzionale alternativo " + _checkDuplicatiServiziOpzionaliAlternativi.codice); 
	    	return;
		}
		if(_checkDuplicatiPadreServiziOpzionaliAlternativi && _checkDuplicatiPadreServiziOpzionaliAlternativi.flag){
	    	$scope.erroreService("Attenzione: e' possibile inserire un solo servizio opzionale alternativo in sostituzione del servizio Opzionale di Default " + _checkDuplicatiPadreServiziOpzionaliAlternativi.codice); 
	    	return;
		}
		
		//CHIAMATA AL SYSTEM LOCATOR DISABILITATA
		
		$rootScope.formData.data.step7 = $scope.data.step7;
		$state.go($scope.checkNextState());	
        	         
    };
    
    $scope.clearIdGpon = function(){
    	if($scope.data.step7.idGpon){
    		$scope.data.step7.idGpon = "";
    	}
    }
    
    $scope.clearGestioneAutonoma = function(){
    	if($scope.data.step7.datiGestioneAutonoma){
			$scope.data.step7.systemUnico = ""; 
    		$scope.data.step7.datiGestioneAutonoma = {
				impresaSystem: "",
				operatoreSystem: "",
				systemUnico: "",
				subAppalto: "",
				tipologiaImpresa: "",
				noteSu: ""
			} 
    	}
    }
    
    //RU_1338
    $scope.oscuramento_RU_1338 = function(){
		$scope.RU_1338 = !$rootScope.OSCURAMENTI.RU_1338.oscurato;
	}
	
	$scope.oscuramento_RU_1338();   
    
    $scope.$watch("data.step7.coinvestimento", function(newValue, oldValue){
    	if(newValue != oldValue){
    		$scope.clearIdGpon();
    	}
    }); 
    
    //RU_1393
    $scope.setShowGestioneAutonoma = function(){
		$scope.showGestioneAutonoma = $scope.isOffertaSemiGPON;		
	}
	
	$scope.setShowPrestazioniAggiuntive = function(){
		$scope.showPrestazioniAggiuntive = $scope.isOffertaSemiGPON;
	}
	
	$scope.setShowSlaPlusSu = function(){
		$scope.showSlaPlusSu = $scope.showGestioneAutonoma; 
	}
	
	$scope.setShowPresaAppuntamento = function(){
		$scope.showPresaAppuntamento = $scope.showGestioneAutonoma; 
	}
    
    $scope.$watch('data.step7.datiGestioneAutonoma.impresaSystem', function(newValue, oldValue){
		if(newValue == 'Y'){			
			if($scope.data.step7.datiGestioneAutonoma.operatoreSystem == 'Y'){
				$scope.data.step7.datiGestioneAutonoma.operatoreSystem = 'N';
				$scope.data.step7.datiGestioneAutonoma.tipologiaImpresa = "";
			}
			$scope.listSubappalto = [];
			$scope.data.step7.datiGestioneAutonoma.subAppalto = "";
			$scope.data.step7.datiGestioneAutonoma.systemUnico = "";
			$scope.data.step7.systemUnico = "";
			$scope.triggerCodiceSystemUnico_GestioneAutonoma("IS");
		}
		$scope.setShowSlaPlusSu();			
	});
	
	$scope.$watch('data.step7.datiGestioneAutonoma.operatoreSystem',function(newValue, oldValue){
		if(newValue == 'Y'){
			
			if($scope.isOffertaSemiGPON && $scope.showGestioneAutonoma){
				//SM_11217
				$scope.showOwnerPresaAppuntamentoTI = false;
				if($scope.data.step7.datiGestioneAutonoma.impresaSystem == 'Y'){
					$scope.data.step7.datiGestioneAutonoma.impresaSystem = 'N';										
				}
				$scope.slaPlusSuDisabled = true;
				$scope.data.step7.datiSlaPlusSu = {};
			}			

			$scope.triggerCodiceSystemUnico_GestioneAutonoma("OS");
			$scope.triggerCodiceSubAppalto_GestioneAutonoma();
		}else{
	        //SM_11217
			$scope.showOwnerPresaAppuntamentoTI = true;
			$scope.listSubappalto = [];
			$scope.data.step7.datiGestioneAutonoma.subAppalto = "";
			
			if($scope.isOffertaSemiGPON && $scope.showGestioneAutonoma){
				$scope.slaPlusSuDisabled = false;				
				$scope.data.step7.datiSlaPlusSu = {};
				//$scope.data.step7.datiSlaPlusSu.flagSlaPlusSu = false;
				//$scope.data.step7.datiSlaPlusSu.valoreSla = "";
			}
		}
	});
	
	 //SM_9216
    $scope.resetOtherSectionsOnGestioneAutonomaRequired = function(){
    	$scope.data.step7.datiAppuntamentoDisaggregazione = {};
    	$scope.data.step7.datiPrestazioniAggiuntive = {};
    	$scope.data.step7.datiSlaPlusSu = {};
    	
		$scope.presaAppuntamentoDisabled = true;
		$scope.prestazioniAggiuntiveDisabled = true;
		$scope.slaPlusSuDisabled = true;
    }
    
    //SM_9216
    $scope.isGestioneAutonomaFilledProperly = function(){    	
    	if($scope.data.step7 && $scope.data.step7.datiGestioneAutonoma){
    		var _sysUnico = $scope.data.step7.datiGestioneAutonoma.systemUnico;
    		if(!_sysUnico || _sysUnico == null || _sysUnico == '' || isNaN(_sysUnico)){
    			$scope.resetOtherSectionsOnGestioneAutonomaRequired();
    		}else{
        		$scope.presaAppuntamentoDisabled = false;
        		$scope.prestazioniAggiuntiveDisabled = false;
        		$scope.slaPlusSuDisabled = false;
    		}
    	}else{    		
    		$scope.resetOtherSectionsOnGestioneAutonomaRequired();
    	}
    }
    
    //Da specifiche, se la sezione Disaggregazione non è compilata correttamente
    //disabilitare le altre sezioni (Presa Apppuntamento, Prestazioni Aggiuntive, Sla Plus SU)
    
    $scope.$watch('data.step7.systemUnico', function(newValue, oldValue){
    	if(newValue){	
			var _json = JSON.parse(newValue);
    		//RU_1428
    		$scope.data.step7.datiGestioneAutonoma.systemUnico = _json.codSystemUnico || null;
    		$scope.data.step7.datiGestioneAutonoma.idAreaDiCentrale = _json.idAreaDiCentrale || null;
    		$scope.isGestioneAutonomaFilledProperly();
    		$scope.trigger_tipologiaImpresa();
    	}else{
    		$scope.resetOtherSectionsOnGestioneAutonomaRequired();
    		$scope.data.step7.datiGestioneAutonoma.tipologiaImpresa = "";
    	}
    });   
	
	$scope.init(); 
	
}]);  
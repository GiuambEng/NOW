
/* Creazione modulo per import underscorejs*/
var underscore = angular.module('underscore', []);
        underscore.factory('_', function() {
            return window._;
});

var timnow = angular.module('timnowApp', [ 'ui.router', 'ngSanitize', 'common', 'ngAnimate', 'ui.bootstrap', 'init', 'ngFileUpload', 'underscore' ]);

/* Internal Modules */
var commonModule = angular.module('common', [ 'ui.router', 'ngResource', 'angularSpinner', 'ui.bootstrap', 'ui.filters','ngAnimate', 'ngSanitize', 'underscore' ]);

/* Second Phase */
angular.module('init', [ 'ui.router', 'ngResource', 'common', 'ui.select', 'underscore' ]);

/* Avvio Timnow */
//SM_8904
timnow.run([ '$rootScope', '$state', '$stateParams', '$log', 'filterFilter','$filter', 'modalService', 'alertService', 'Ambito', '$window', 'MAP_OFFERTE', 'VIEW', 'CRM_PROFILE_SUPER', 'OSCURAMENTI', 'TRACKING_GUI', 'TrackingGUI', 
	function($rootScope, $state, $stateParams, $log, filterFilter, $filter, modalService, alertService, Ambito, $window, MAP_OFFERTE, VIEW, CRM_PROFILE_SUPER, OSCURAMENTI, TRACKING_GUI, TrackingGUI) {
	$log.info('app bootstrap...');

	//CREO VARIABILE MAP OFFERTE PER HTML
	$rootScope.MAP_OFFERTE=MAP_OFFERTE;
	
	//SM_8904
	$rootScope.VIEW = VIEW;
	
	//RU_935
	$rootScope.CRM_PROFILE_SUPER = CRM_PROFILE_SUPER;
	
	//RU_956 
	$rootScope.OSCURAMENTI = OSCURAMENTI;
	
	$rootScope.getMap_Offerta = function(value) {
		var output;
		angular.forEach($rootScope.MAP_OFFERTE, function(item, key) {
				if(item.name===value || item.id===value){
					output=item;
					return;
				}
			});

		return output;
	}
	
	
	
	/* Inizializzazione Timnow */
	$rootScope.initTimnow = function() {
		$rootScope.$state = $state;
		$rootScope.$stateParams = $stateParams;
		$rootScope.pageClass = 'home';

		$rootScope.dismissableAlerts = alertService.alerts();
		$rootScope.previousStateStack = [];
		$rootScope.previousStateParamsStack = [];
		// init stato precedente alla dashboard.

		$rootScope.currentUser = {};
		$rootScope.appConfiguration = {};
		$rootScope.appLoaded = false;
		$rootScope.basePath = "";
	};

	$rootScope.initTimnow();

	/* Verifica OLO */
	$rootScope.isOLOUser = function() {		
		var _regex = /^(CRM_OLO|CRM_OLORO)$/
		return ($rootScope.timnowConfigData.user.codiceProfilo.match(_regex) != null);
	};
	
	//RU_896
	$rootScope.isOPCCUser = function() {
		return ($rootScope.timnowConfigData.user.codiceProfilo.indexOf('OPCC') >= 0);
	};
	
	$rootScope.isAllOLOUser = function() {
		return ($rootScope.timnowConfigData.user.codiceProfilo.indexOf('OLO') >= 0);
	};
	
	//RU_896
	$rootScope.isDGUser = function() {
		return ($rootScope.timnowConfigData.user.codiceProfilo.indexOf('DG') >= 0);
	};
	
	//SM_10353
	$rootScope.isMKTGUser = function() {
		return ($rootScope.timnowConfigData.user.codiceProfilo.indexOf('MKTG') >= 0);
	};
	
	$rootScope.isGAUser = function() {
		return ($rootScope.timnowConfigData.user.codiceProfilo.indexOf('GA') >= 0);
	};
	
	$rootScope.isPPSUser = function() {
		return ($rootScope.timnowConfigData.user.codiceProfilo.indexOf('PPS') >= 0);
	};
	
	$rootScope.isSUPERUser = function() {
		return ($rootScope.timnowConfigData.user.codiceProfilo.indexOf('SUPER') >= 0);
	};
	
	//SM_10585
	$rootScope.isSUPERUserInterno = function() {
		var _arrayUtenze = ['CRM_OLO_SUPER', 'CRM_OLORO_SUPER'];		
		return ($rootScope.timnowConfigData.user.codiceProfilo.indexOf('SUPER') >= 0 && 
				_arrayUtenze.indexOf($rootScope.timnowConfigData.user.codiceProfilo) == -1);
	};
	
	//RU_935
	$rootScope.canDownloadFiles = function() {		

		var _superProfiles = Object.keys(CRM_PROFILE_SUPER);
		var _downloadFlag = false;

		if(_superProfiles && _superProfiles.length > 0){
			if(_superProfiles.indexOf($rootScope.timnowConfigData.user.codiceProfilo) >= 0){
				if($state.$current.name == 'root.monitoraggio.rimodulazioniDAC'){

					switch($rootScope.timnowConfigData.user.codiceProfilo){
					case 'CRM_GA_SUPER':
					case 'CRM_PPS_SUPER':
						_downloadFlag = true;
						break;
					default:
						_downloadFlag = false;
					break;
					}
				}else{
					_downloadFlag = true;
				}				
			}	
		}
		//RU_1127
		if($state.$current.name == 'root.notifiche.decommissioningdownload'){
			//SM_10035
			switch($rootScope.timnowConfigData.user.codiceProfilo){
			case 'CRM_DG_SUPER':
			case 'CRM_OLO_SUPER':
			case 'CRM_DG':
			case 'CRM_OLO':
				_downloadFlag = true;
				break;
			default:
				_downloadFlag = false;
			break;
			}
		}		
		
		console.log("DOWNLOAD FLAG: " + _downloadFlag);
		return _downloadFlag;
	};
	
	
	/**
	 * Recupera l'ambito configurato per la pagina corrente dai parametri
	 * configurati per la route.
	 * 
	 * @see app.routes.js
	 */
	$rootScope.currentAmbito = function() {
		var idAmbito = "1";
		
		var currPageAmbito = $stateParams.ambito;
		var listaAmbiti = $rootScope.listaAmbiti;
		
		if(currPageAmbito && listaAmbiti && listaAmbiti.length){
			var found = listaAmbiti.filter(function(ambito){ return ambito.label === currPageAmbito });
		    if (found.length) {
		    	idAmbito = found[0].value;
		    }
		}
		
		return idAmbito;
	};
	
	/**
	 * Costruisce la lista delle label di navigazione usate per il
	 * tracking delle operazioni da GUI
	 * 
	 */
	//RU_1010
	$rootScope.buildParametriTrackingGUI = function(stateParams){
		var _tracking = "";
		
		if(stateParams){
			if(stateParams.componente && stateParams.componente != ''){
				
				_tracking = stateParams.componente;
				
				if(stateParams.macro && stateParams.macro != ''){
					_tracking += TRACKING_GUI.SEPARATORE + stateParams.macro;
					
					if(stateParams.dettaglioFunzione && stateParams.dettaglioFunzione != ''){
						_tracking += TRACKING_GUI.SEPARATORE + stateParams.dettaglioFunzione;
					}
				}
			}
		}
		
		return _tracking;
	}
	
	/* Cambio Stato */
	$rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams, options) {
		if (toParams.excludeAccorpato === true && $rootScope.timnowConfigData.user.flagAccorpato === true) {
			$log.info('user not authorized (accorpato) for ' + toParams.page);			
			$state.go('root.homepage');
		} 
		
		$rootScope.canDownloadFiles();
		
		$rootScope.fromState = fromState.name;
		
		//SM_9063
		$rootScope.toState = toState.name;
		/*if (!$rootScope.isAuthorized(toParams.settore, toParams.page)) {
			$log.info('user not authorized for ' + toParams.page);
			$state.go('root.homepage');
		}*/
		
		//RU_1010
		//Tracking da GUI per operazione NAVIGAZIONE
		if(TRACKING_GUI.EVENTI.NAVIGAZIONE.attivo){
	
			var _tracking = $rootScope.buildParametriTrackingGUI(toParams);
			
			if(_tracking && _tracking != ""){
		    	var _trackBean = {
		    			timestampInizio: new Date().toISOString(),
		    			timestampFine: new Date().toISOString(),
		    			descrizioneFunzione: _tracking,
		    			numeroDatiEsportati: 0,
		    			contenutoFile: null,
		    			nomeFile: null,
		    			esito: 'Ok',
		    			tipoOperazione: TRACKING_GUI.EVENTI.NAVIGAZIONE.descrizione,
		    			parametriOperazione: null	
		    	};	
		    	
		    	TrackingGUI.tracking(_trackBean);
			}
		}
	});

	/* Verifica Autorizzazione: Area - Funzionalita */
	$rootScope.isAuthorized = function(areaName, functionName) {
		if (!$rootScope.timnowConfigData) {
			return false;
		} else {
			if (!areaName) {
				return true;
			} else {
				if (areaName === "allUser") {
					return true;
				}
			}
		}
		var filteredArray = filterFilter($rootScope.timnowConfigData.authorizations[areaName], functionName);
		return (filteredArray && filteredArray.length > 0);
	};
	
	$rootScope.alertGenericError = function () {
    	var options = {
            headerText : "Errore",
            bodyText : "Si è verificato un errore. Si prega di riprovare più tardi",
            actionButtonText : 'Chiudi',
            type : 'warning'
        };
    	return modalService.showModal({}, options);
    };
    
    /**
     * Recupera la lista degli ambiti dal servizio di BE.
     */
    $rootScope.loadListaAmbiti = function() {
		Ambito.get().$promise.then(function(result) {
	    	$rootScope.listaAmbiti = result.data;
		});
	 };

	 /**
	  * Si memorizza la tipologia dei filtri di ricerca da utilizzare per la
	  * funzionalità "Tasto Indietro".
	  * Tale funzionalità viene abilitata dal parametro di configurazione che
	  * abilita e disabilita il tasto indietro.
	  */  
	 $rootScope.impostaTipologiaFiltriRicerca = function(tipologia){
		if($rootScope.timnowConfigData.config.abilitaTastoIndietro === "true" && $rootScope.salvataggioFiltriPaginazione){
		 	$rootScope.salvataggioFiltriPaginazione.tipologia = tipologia;
		}
	 };
	 
	 $rootScope.$on('restartSession', function(){
         $state.go('root.homepage', {},{reload:true});
     });

	 $rootScope.$on('sessionExpired', function(){
		 $window.location.href = '/now/sessionExpired.html';
	 });
} ]);

var vastness= function(){
	if (document.getElementById("boxMessaggiAScomparsa").classList.contains('vastness')){
		document.getElementById("boxMessaggiAScomparsa").classList.remove('vastness');
	}else{
		document.getElementById("boxMessaggiAScomparsa").classList.add('vastness');
	}
}

commonModule
    .factory('ConfigFE', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'config');
    }])
    .factory('ExportId', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + ':entita/export', {}, {
            'save': {
                method: 'POST',
                headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('Bands', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'bands/:type/:idOfferta', {}, {
            'save': {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('BandsProfile', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'bands', {}, {
            'save': {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('BandsProfileNewOrder', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'bands/newOrder', {}, {
    		'save': {method: 'POST', headers: {'Content-Type': 'application/json'}}
    	});
    }])
     .factory('FileState', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'filestate/order_request/:idFile', {selectedOLO: '@selectedOLO'});
    }])
    //le notifiche se non gli si passa l'ID ordine fa visualizzare tutte le notifiche
	.factory('Notifications', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'notifications/:idRichiestaOlo');
    }])
    //query parameters modulazione
    .factory('LineProfiles', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'lines/:idOfferta');
    }])
    .factory('ExportPoll', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'exportdata/file/check');
    }])
    .factory('Ambito', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'ambiti');
    }])
    .factory('Locator', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'locators', {}, {
            save: {
                method: 'POST',
                headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //RU_1127
    .factory('Decommissioning', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	all: $resource(BASEPATH + 'decommissioning', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	//RU_1312
        	fileDetails: $resource(BASEPATH + 'decommissioning/fileDetails', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }])
    //RU_1180
    .factory('Multicast', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	verificaContrattoMulticast: $resource(BASEPATH + 'multicast/verificaContrattoMulticast', {codOloAgcom: '@codOloAgcom'}, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	all: $resource(BASEPATH + 'multicast', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }])    
    .factory('MigrazioneUllSlu', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return {
            files: $resource(BASEPATH + 'migrazione-ull-slu/files', null, {
                get: {
                    method: 'GET',
                    headers: {'Content-Type': 'application/json'}
                }
            }),
            dettaglio: $resource(BASEPATH + 'dettagliofileullslu', null, {
                get: {
                    method: 'GET',
                    headers: {'Content-Type': 'application/json'}
                }
            }),
            check: $resource(BASEPATH + 'migrazione-ull-slu/files/:nomeFile/check', null, {
                save: {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'}
                }
            }),
            delete: $resource(BASEPATH + 'migrazione-ull-slu/files/:nomeFile', null, {
                remove: {
                    method: 'DELETE',
                    headers: {'Content-Type': 'application/json'}
                }
            }),
            avviaLavorazione: $resource(BASEPATH + 'avvialavorazioneullslu', null, {
                save: {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'}
                }
            })
        };
    }])
    //RU_1184
    .factory('VerificaStatoAssetAbilitatoDisabilitato', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'assets/verificaStatoAssetAbilitazioneDisabilitazione');
    }])
    
    //CR1-CR4
    .factory('VerificaFileEsitiMulticast', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'multicast/verificaFileEsiti');
    }])
    
    //R1I-21-0203
    .factory('ListaSediOlt', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'assets/listaSediOlt');
    }])
    .factory('ListaFeeders', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'assets/listaFeeders');
    }])
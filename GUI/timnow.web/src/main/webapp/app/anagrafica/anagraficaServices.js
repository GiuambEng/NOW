timnow.factory('Customers', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    'use strict';
    return $resource(BASEPATH + 'customers/');
}])
    .factory('Contacts', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contacts/:idcontatto/:references');
    }])
    .factory('ContractsAnagrafica', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/profiled');
    }])
    //RU_716 NUOVO CONTRATTO
    .factory('GetCodOloNumerico', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'srolos/getCodOloNumerico/:codOlo');
    }])
    //RU_716 NUOVO CONTRATTO
    .factory('NuovoContratto', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/nuovoContratto', null, {
            'save': {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    //RU_716 NUOVO CONTRATTO
    .factory('RecuperoDatiContratto', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/recuperoDatiContratto');
    }])
    //RU_716 NUOVO CONTRATTO
    .factory('RecuperoContratti', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/recuperoContratti');
    }])
    //RU_716 NUOVO CONTRATTO
    .factory('RecuperoDettaglioContratto', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/recuperoDettaglioContratto');
    }])
    //RU_716 NUOVO CONTRATTO
    .factory('ModificaContratto', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/modificaContratto', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
	//RU_1164
	.factory('RecuperaComuniCoinvestiti', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	    'use strict';
	    return $resource(BASEPATH + 'comuniCoinvestiti', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
	}])
	
	//RU_1184
    .factory('VerificaStatoContrattoAbilitatoDisabilitato', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/verificaStatoContrattoAbilitazioneDisabilitazione');
    }])
    //SM_10433
    .factory('RecuperoFlagMulticast', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/recuperaFlagMulticast');
    }])
    
    //SM_1276
    .factory('ListaFileComuniCoinvestiti', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'comuniCoinvestiti');
    }])
    //SM_11367
    .factory('VerificaContrattoFwaEolo', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/verificaContrattoFwaEolo');
    }])
    // RU_1583
    .factory('Radius', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'radius');
    }])
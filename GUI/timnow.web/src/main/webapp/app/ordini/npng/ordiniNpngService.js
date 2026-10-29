//RU_1203
timnow
    .factory('RicercaOrdiniNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'npng/ricercaOrdini', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('DettaglioOrdineNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'npng/dettaglioOrdine?idOrdine=:idOrdine');
    }])
    .factory('LavorazioneManualeOrdineNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'npng/lavorazioneManualeOrdine', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('RicercaAssetNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'npng/ricercaAsset');
    }])
    .factory('DettaglioAssetNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'npng/dettaglioAsset?idAsset=:idAsset', {
    		idAsset: '@idAsset'
    	});
    }])
    .factory('CambioOloNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'npng/cambioOlo', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
//RU_1203
timnow
	.factory('ListaOpzioniTrafficoNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
		'use strict';
		return $resource(BASEPATH + 'opzioneNpng/lista');
	}])
    .factory('RecuperoCampiNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'opzioneNpng/campiAnagrafica');
    }])

    .factory('UpsertOpzioneTrafficoNpng', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'opzioneNpng/modifica', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }]);
timnow
    .factory('CreazioneReport', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'report/crea', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('ListaReport', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'report/lista');
    }])
    .factory('DettaglioListaReport', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'report/dettaglio');
    }])
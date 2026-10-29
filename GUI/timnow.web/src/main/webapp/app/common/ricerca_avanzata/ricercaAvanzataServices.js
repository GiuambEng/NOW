timnow
    .factory('AdvancedSearch', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'advancedsearch/fields/:type');
    }])
    .factory('AdvancedSearchGetDati', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + ':type/search', {}, {
            'save': {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        });
    }])
    .factory('AdvancedSearchSave', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'advancedsearch/:codFunzione/:operationType', {}, {
            'save': {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                }
            },
            'remove': {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                },
                params: {nomeFiltro: '@nomeFiltro'}
            }
        });
    }])

;


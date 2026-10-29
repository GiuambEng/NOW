timnow
    .factory('OfferteDisambiguazione', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'offers/disambiguation/:tplg_lavrz', {tplg_lavrz: '@tplg_lavrz'});
    }])
	.factory('Lavorazioni', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    'use strict';
    return $resource(BASEPATH + 'ordine-lavorazione');
	}]);


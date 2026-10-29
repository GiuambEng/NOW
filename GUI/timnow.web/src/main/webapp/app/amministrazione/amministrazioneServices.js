timnow
    .factory('FaqsVisible', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'faqs/visible');
    }])
    .factory('Faq', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'faqs/:idFaq', {}, {
            delete_faqs: {method: 'GET', headers: {'Content-Type': 'application/json'}},
            add_faqs: {method: 'POST', headers: {'Content-Type': 'application/json'}},
            mod_faqs: {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('News', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'news/:idNews', {}, {
            delete_news: {method: 'GET'},
            save: {method: 'POST', headers: {'Content-Type': 'application/json'}},
            mod_news: {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('iHelpsVisible', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'helps/visible/:idAmbito');
    }])
    .factory('iHelps', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'helps/:idIHelp', {}, {
            helpAdd: {method: 'POST', headers: {'Content-Type': 'application/json'}},
            helpMod: {method: 'POST', headers: {'Content-Type': 'application/json'}},
            delete_ihelps: {method: 'GET', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('Atms', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'atms');
    }])
    .factory('vcs', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'vcs');
    }])
    .factory('vps', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'vps');
    }])
    .factory('lans', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'lans/:admin');
    }])
        .factory('CausaliRimodulazioni', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'configcausalirimdelivery/:operation/:flagEsplicita',{}, {
            mod_item: {method: 'POST', headers: {'Content-Type': 'application/json'}}, 
        	delete_item: {method: 'PUT', headers: {'Content-Type': 'application/json'}}
        });
	}]) 
    .factory('SLAtime', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'slas');
    }])
    .factory('PPSScopes', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'ppsmonitorings/scopes');
    }])
    .factory('PPSMonitorings', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'ppsmonitorings/:scopeId/:reportType/', {}, {
            updateThreshold: {method: 'POST', headers: {'Content-Type': 'application/json'}},
        });
    }])
    .factory('archiTD', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'gestionearchinumerazionitd/:idArchiTD', {}, {
            delete_archiTD: {method: 'DELETE', headers: {'Content-Type': 'application/json'}},
            add_archiTD: {method: 'POST', headers: {'Content-Type': 'application/json'}},
            mod_archiTD: {method: 'PUT', headers: {'Content-Type': 'application/json'}}
        });
    }])
    //RU_1078
    .factory('ComuniInfratel', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'comuniInfratel');
    }])
    //RU_1058
    .factory('AreaMacroarea', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'areaMacroarea')
    }])
	//RU_1058
	.factory('KitVlan', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	    'use strict';
	    return $resource(BASEPATH + 'kitVlan')
	}])
	//RU_1058
	.factory('CentraliNGA', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	    'use strict';
	    return $resource(BASEPATH + 'centraliNGA')
	}])
	//RU_1058
	.factory('CentraliGBE', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	    'use strict';
	    return $resource(BASEPATH + 'centraliGBE')
	}])
	//RU_1058
	.factory('Nodi', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	    'use strict';
	    return $resource(BASEPATH + 'nodi')
	}])
	//RU_1058
	.factory('PuntiConsegna', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	    'use strict';
	    return $resource(BASEPATH + 'pdc')
	}])
		//RU_1058
	.factory('Vlan', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	    'use strict';
	    return $resource(BASEPATH + 'vlan')
	}])
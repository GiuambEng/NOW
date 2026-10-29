//RU_1335
timnow
    .factory('RisorseFwaWillDeco', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	list: $resource(BASEPATH + 'risorseFwaWillDeco/list', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	details: $resource(BASEPATH + 'risorseFwaWillDeco/details/:idRisorsa', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	edit: $resource(BASEPATH + 'risorseFwaWillDeco/edit', {}, {
        		save:{
        			method: 'POST',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	create: $resource(BASEPATH + 'risorseFwaWillDeco/create', {}, {
        		save:{
        			method: 'POST',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }])   
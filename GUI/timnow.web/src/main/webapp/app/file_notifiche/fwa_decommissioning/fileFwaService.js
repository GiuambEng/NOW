//RU_1335
timnow
    .factory('FwaDecommissioning', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	all: $resource(BASEPATH + 'fwa', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }])  
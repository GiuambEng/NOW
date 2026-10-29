//RU_1485
timnow.factory('AnagraficaCodiciProgettoCatalogo', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	lists: $resource(BASEPATH + 'anagraficaCodiciProgettoCatalogo/liste', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }]) 
//RU_1479
timnow.factory('AnagraficaFwaEolo', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	list: $resource(BASEPATH + 'anagraficaFwaEolo/lista', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }]) 
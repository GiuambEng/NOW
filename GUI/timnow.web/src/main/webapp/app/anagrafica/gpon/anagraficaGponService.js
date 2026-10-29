//RU_1308
timnow	
	//RU_1338
	.factory('AnagraficaGpon', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	list: $resource(BASEPATH + 'anagraficaGpon/lista', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	storicoSplitting: $resource(BASEPATH + 'anagraficaGpon/storicoSplitting', {}, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }]) 
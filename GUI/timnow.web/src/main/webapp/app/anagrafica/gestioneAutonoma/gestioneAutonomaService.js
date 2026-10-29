//RU_1335
timnow
    .factory('GestioneAutonoma', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	associazioneOao: $resource(BASEPATH + 'gestioneAutonoma/associazioneOao/list', null, {
        		list:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }])   
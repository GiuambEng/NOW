//RU_1492
timnow
    .factory('LavorazioneManualeFiberstream', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';        
        return{
        	scarta: $resource(BASEPATH + 'lavorazioneManuale/scarta', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	risottometti: $resource(BASEPATH + 'lavorazioneManuale/risottometti', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	modifica: $resource(BASEPATH + 'lavorazioneManuale/modifica', null, {
        		save:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }])   
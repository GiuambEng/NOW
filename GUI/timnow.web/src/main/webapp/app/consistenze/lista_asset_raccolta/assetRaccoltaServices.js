timnow
    .factory('AssetsRaccolta', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return{
        	list: $resource(BASEPATH + 'assetsRaccolta', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	exportList: $resource(BASEPATH + 'assetsRaccolta/export', null, {
        		save:{
        			method: 'POST',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	search: $resource(BASEPATH + 'assetsRaccolta/search', null, {
        		save:{
        			method: 'POST',
        			headers: {'Content-Type': 'application/json'}
        		}
        	}),
        	detail: $resource(BASEPATH + 'assetsRaccolta/:idAsset', null, {
        		get:{
        			method: 'GET',
        			headers: {'Content-Type': 'application/json'}
        		}
        	})
        };
    }]);
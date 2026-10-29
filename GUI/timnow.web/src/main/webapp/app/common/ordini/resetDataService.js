//SM_9063
timnow.factory('ResetDataService', ['$rootScope',
    function ($rootScope) {

        return {
            reset: function (regex) {
    			
            	if(!regex || regex == ""){
            		return;
            	} 
            	
            	if(!$rootScope.fromState || $rootScope.fromState == ""){
            		return;
            	}
            	
            	if(!$rootScope.toState || $rootScope.toState == ""){
            		return;
            	}
            	
            	
    			var _matchFromStateRegex = $rootScope.fromState.match(regex);
    			var _matchtoStateRegex = $rootScope.toState.match(regex);
    			
    			if(!_matchFromStateRegex || !_matchtoStateRegex){
    				$rootScope.formData = {};
    				$rootScope.data = {};
    				$rootScope.customizedOffer = null;
    			}
            }
        };
    }
]);

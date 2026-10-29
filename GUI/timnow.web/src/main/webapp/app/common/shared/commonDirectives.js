angular.module('common')
    .directive('ngEnter', function () {
        'use strict';
        return function (scope, element, attrs) {
            element.bind('keydown keypress', function (event) {
                if (event.which === 13) {
                    scope.$apply(function () {
                        scope.$eval(attrs.ngEnter, {'event': event});
                    });

                    event.preventDefault();
                }
            });
        };
    })
    .directive('scrollTop', ['$uiViewScroll', function ($uiViewScroll) {
        'use strict';
        var linker = function (scope, element, attr) {
            $uiViewScroll(element);
        };

        return {
            restrict: 'A',
            link: linker
        };
    }])
    .directive('dateToStringInModel', ['dateFilter', '$parse', function (dateFilter, $parse) {
        'use strict';
        return {
            restrict: 'EAC',
            require: '?ngModel',
            link: function (scope, element, attrs, ngModel, ctrl) {
                ngModel.$parsers.push(function (viewValue) {
                    return dateFilter(viewValue, 'dd/MM/yyyy');
                });
            }
        };
    }])    
    //ESPLETAMENTO CESSAZIONE CPS
    .directive('checkFormItemsValidity', ['$timeout', function($timeout) {
    	return {
    		restrict: 'A',
    		require: '^form',
    		scope: {
    			validationCallback: '=',
    			fieldCustomValidator: '@'
    		},
    		link: function(scope, element, attrs, formCtrl) {
    			
    			scope.formFields = {};
    			scope.itemsValid = [];
    			
    			scope.verifyFormItem = function(item){
    				if(item){    					
    					scope.itemsValid[item.$name] = (item.$valid && !item.$isEmpty(item.$viewValue));
    					scope.validationCallback(scope.itemsValid);
    				}
    			};  
    			
    			scope.extractFormFields = function(){
    				
    				scope.formFields = {};
    				scope.formFieldsKeys = [];
    				
    				var _keys = Object.keys(formCtrl);    				
    				var _reg = /^ref1/;
    				
    				_keys.forEach(function(key){
    					if(key.match(_reg)){
    						scope.formFieldsKeys.push(key);
    						scope.formFields[key] = formCtrl[key];
    						scope.itemsValid[key] = false;
    						
    						//Aggiunta $viewChangeListener per ogni campo del form estratto    						
    						scope.formFields[key].$viewChangeListeners.push(function(){
    							scope.verifyFormItem(scope.formFields[key]);
    						});
    					}
    				});
    			}; 
    			
    			$timeout(function(){
    				scope.extractFormFields();  
    				if(scope.formFieldsKeys && scope.formFieldsKeys.length > 0){
        				scope.formFieldsKeys.forEach(function(key){
        					scope.formFields[key].$viewChangeListeners[0]();
        				});	
    				}    				
    			}, 50);

    		}
    	}
    }]);
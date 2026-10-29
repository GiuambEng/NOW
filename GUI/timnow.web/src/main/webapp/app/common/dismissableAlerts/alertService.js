/**modal service**/
angular.module('common').service('alertService', function () {
    'use strict';
   var defaultTimeout = 6000;
   var defaultType = "info"; //info, success, danger, warning
    var dismissableAlerts = [];
    this.add = function (text, tipo, contoAllaRovescia) {
    	var alertType = tipo || defaultType; 
    	var alertTimeout = contoAllaRovescia || defaultTimeout;
    	dismissableAlerts.push({msg: text, type:alertType, timeout:alertTimeout})
    };
    
    this.closeAlert = function(index) {
    	dismissableAlerts.splice(index, 1);
    };
    
    this.alerts = function(){
    	return dismissableAlerts;
    };
 });

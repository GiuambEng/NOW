//RU_1010
commonModule
.service('TrackingGUI', ['$resource', 'BASEPATH', 'TRACKING_GUI', function ($resource, BASEPATH, TRACKING_GUI) {

	var _logging = $resource(BASEPATH + 'tracking/file', {}, {
		save: {
			method: 'POST',
			headers: {'Content-Type': 'application/json'}
		}
	});
	
	/**
	 * Funzione che verifica se nella configurazione
	 * l'operazione di tracking selezionata è attiva
	 */
	function isTypeOperationActiveTracking(typeOperation){
		var _operation = Object.keys(TRACKING_GUI.EVENTI);

		var _result = false;
		
		if(_operation && _operation.length > 0){
			_operation.forEach(function(item){
				if(TRACKING_GUI.EVENTI[item].descrizione == typeOperation){
					if(TRACKING_GUI.EVENTI[item].attivo){
						_result = true;
						return;
					}
				}					
			});
		}

		return _result;
	}
	
	return {
		exportTracking: function(request){
			return _logging.save({}, request);
		},
		tracking: function(request){
			if(request){	

                var _app = isTypeOperationActiveTracking(request.tipoOperazione);
						
				if(_app){
					//console.log(JSON.stringify(request));					
					return _logging.save({}, request);
				}
			}
		}	
	}
}])
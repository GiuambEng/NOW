//RU_1184
timnow
	.service('ControlliServiceStep4', function( $q, 
												VerificaStatoContrattoAbilitatoDisabilitato, 
												VerificaStatoAssetAbilitatoDisabilitato, 
												VerificaCompatibilitaProfiloTecnicoLinea,
												VerificaProfiloTecnicoLineaX1X2,
												VerificaAttivazioneFTTH){
		
		var dettagliAsset = {};
		
		return{
			//C11M08F85 - Verifica Stato Asset Abilitazione/Disabilitazione
			C11M08F85: function(idAsset, disabilitazione){
				
				return VerificaStatoAssetAbilitatoDisabilitato.get({'idAsset': idAsset, 'disabilitazione': disabilitazione}).$promise;
			},
			
			//C11M08F86 - Verifica Stato Contratto Abilitazione/Disabilitazione
			C11M08F86: function(idContratto){

				return VerificaStatoContrattoAbilitatoDisabilitato.get({'idContratto': idContratto}).$promise;
			},
			
			/*
			 * Wrapper per le funzioni C11M08F85 e C11M08F86 per
			 * l'opziopne variazione Abilitazione/Disabilitazione nel passaggio allo step 5
			 * per variazione offerte EasyIPUBBFTTCAB/FTTH
			 */ 
			//SM_10407
			verificheOpzioneAbilitazioneDisabilitazione: function(idAsset, idContratto, disabilitazione){
				
				var _promises = [];
				_promises.push(this.C11M08F85(idAsset, disabilitazione));
				_promises.push(this.C11M08F86(idContratto));
				
				var _response = {
					isResponsesOk: true,
					message: ""
				};
				
				var _defer = $q.defer();
				
	    		 $q.all(_promises)
	    		   .then(function(promises){
		    			
	    			promises.forEach(function(promise, index){
	    				if(promise["VerificaStatoAssetAbilitazDisabilitazOutput"] && promise["VerificaStatoAssetAbilitazDisabilitazOutput"].esito == 'KO'){
	    					_response.isResponsesOk = false;
	    					_response.message = promise["VerificaStatoAssetAbilitazDisabilitazOutput"].message;
	    					return;
	    				}
	    				if(promise["VerificaStatoContrattoDisabilitazAbilitazOutput"] && promise["VerificaStatoContrattoDisabilitazAbilitazOutput"].esito == 'KO'){
	    					_response.isResponsesOk = false;
	    					_response.message = promise["VerificaStatoContrattoDisabilitazAbilitazOutput"].message;
	    					return;
	    				}
	    			});
	    			
	    			_defer.resolve(_response);

	    		}, function(error){
	    			_response.isResponsesOk = false;
	    			_response.messaggio = error.messaggio;
	    			
	    			_defer.reject(_response);
	    		});  
	    		 
	    		 return _defer.promise;
			},
			
			//R1I-21-0138
			//C11M08F89 - Verifica compatibilità Profilo Tecnico Linea
			C11M08F89: function(request){				
				return VerificaCompatibilitaProfiloTecnicoLinea.save(request).$promise;
			},
			
			//RU_1270
			//C11M08F91 -> Verifica Profilo Tecnico Linea X1/X2
			C11M08F91: function(idOfferta, profiloTecnicoLinea){				
				return VerificaProfiloTecnicoLineaX1X2.get({'idOfferta': idOfferta, 'profiloTecnicoLinea': profiloTecnicoLinea}).$promise;
			}
			
		};
});
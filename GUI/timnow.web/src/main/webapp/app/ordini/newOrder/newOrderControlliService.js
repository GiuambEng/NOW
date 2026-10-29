timnow
	.service('NewOrderControlliService', function(VerificaSLABasePerONTOperatore,
												VerificaCodiceProgettoOneStepTLC8,
												VerificaAttivazioneFTTH,
												VerificaMigrazioneFTTH){
	return {
		
			// RU_1560
			// C11M08F111 -> Verifica codice progetto ONESTEP
			C11M08F111: function(codiceServizio, codiceProgetto) {
				
				var _request = {
					codServizio: codiceServizio,
					codProgetto: codiceProgetto
				};
	
				return VerificaCodiceProgettoOneStepTLC8.get(_request).$promise;
			},
			
			// RU_1560
			// C11M08F112 -> Verifica SLA base per ONT operatore
			C11M08F112: function(idRisorsa, slaAssurance) {
				
				var _request = {
					idRisorsa: idRisorsa,
					slaAssurance: slaAssurance
				};
				
				return VerificaSLABasePerONTOperatore.get(_request).$promise;
			},
			
			// RU_1560
			// C11M08F113 -> Verifica richiesta attivazione FTTH
			C11M08F113: function(codOloAgcom, idRisorsaOld) {
				
				var _request = {
					codOloAgcom: codOloAgcom,
					idRisorsaOld: idRisorsaOld
				}
				
				return VerificaAttivazioneFTTH.get(_request).$promise;
			},
			
			// RU_1560
			// C11M08F114 -> Verifica migrazione FTTH
			C11M08F114: function(idAsset, offerta) {
				
				var _request = {
					idAsset: idAsset,
					offerta: offerta
				};
	
				return VerificaMigrazioneFTTH.get(_request).$promise;
			},
		
	};
});
timnow
    .factory('MonitoraggioKOOLO', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // queryparam: flagExport, famiglia, causale, dataTotale
        return $resource(BASEPATH + 'monitorings/oloKo/:level');
    }])
    .factory('MonitoraggioKOCautelare', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // queryparam: codiceErrore, offerta
        return $resource(BASEPATH + 'monitorings/precautionaryKo/:level');
    }])
    .factory('RinvioEmail', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'monitoraggio-rinvio-email/send', {}, {
            rinvia: {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('OLOforRinvioNotifiche', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'monitoraggio-rinvio-notifiche/olo');
    }])
    .factory('RichiesteForOLO', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'monitoraggio-rinvio-notifiche/:codOloAgcom/:codOloNow');
    }])
    .factory('RichiesteForOLONotificheTemplate', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'generazione-notifiche/:codOloAgcom/:codOloNow');
    }])
    .factory('GeneraNotificheTemplate', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'generazione-notifiche', {}, {
            rinvia: {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('ListaTipologieNotificheAttese', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'generazione-notifiche/notificheAttese', {}, {
            rigenera: {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('RinvioFile', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'monitoraggio-rinvio-file/send', {}, {
            rinvia: {method: 'PUT', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('RinvioNotifiche', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'monitoraggio-rinvio-notifiche/send/:level', {}, {
            rinvia: {method: 'PUT', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('NotificheOloRichiesta', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // queryparam: cordiceOrdineTi
        return $resource(BASEPATH + 'monitoraggio-notifiche-olo/request-detail');
    }])
    .factory('MonitoraggioKOWarning', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // queryparam: flagExport, dataOperazione, causale, dataAggiornamento,
		// codCausaleOLO, tipoErrore
        return $resource(BASEPATH + 'monitorings/warningKo/:level');
    }])
    .factory('TempiAttraversamento', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // queryparam: flagExport, tipoLista, dataAggiornamento, codCausaleOLO,
		// tipoErrore, idTempiAttraversamento
        return $resource(BASEPATH + 'monitorings/times/:level');
    }])
    .factory('MonitoraggioKOGiornalieri', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // queryparam: flagExport, ambito, codCausaleOlo
        return $resource(BASEPATH + 'alarms/:level');
    }])

    .factory('MonitoraggioFile', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // queryparam: flagExport, idFileProcessato, tipoContatore
        return $resource(BASEPATH + 'monitorings/file/:type', {}, {
        	'save': {method: 'POST', headers: {'Content-Type': 'application/json'}}});
    }])
    
    .factory('MonitoraggioFatturazione', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // queryparam: flagExport,dataEstrazione, statoRichiestaNow,
		// descrizioneFamigliaOfferta,
        return $resource(BASEPATH + 'monitorings/fatturazione/:type/:codiceOrdineTI');
    }])
    
    .factory('UserTask', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        // querystring tipoUserTask
        return $resource(BASEPATH + 'monitorings/userTask/:idWorkItem/:idRichiestaOlo', null, {
            rinvia: {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    
     .factory('agcomMonitorings', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
      // queryparam: dataEstrazione, flagExport
        return $resource(BASEPATH + 'monitorings/agcom/:livello/:flagDettaglio');
    }])
    .factory('MonitoraggioRimodulazioniDAC', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'monitorings/rimodulazionidac/:operation/:contatoreSingolo');
    }])
    .factory('RigenerazioneMailListaNotifiche', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'monitoraggio-rigenerazione-mail/listaNotifiche/:idRichiestaOlo');
    }])
    
   .factory('RigenerazioneMailInvioNotifiche', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
     'use strict';
       return $resource(BASEPATH + 'monitoraggio-rigenerazione-mail/invioNotifiche', {}, {
          rinvia: {method: 'POST', headers: {'Content-Type': 'application/json'}}
       });      
    }]);
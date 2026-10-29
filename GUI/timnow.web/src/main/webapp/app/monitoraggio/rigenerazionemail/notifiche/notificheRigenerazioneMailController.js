timnow
    .controller('notificheRigenerazioneMailController', ['$scope', '$state', '$rootScope', '$log', 'modalService', 'RigenerazioneMailListaNotifiche', 'RigenerazioneMailInvioNotifiche', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $state, $rootScope, $log, modalService, RigenerazioneMailListaNotifiche, RigenerazioneMailInvioNotifiche, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'notificheRigenerazioneMail';

        $scope.init = function () {
            //solo singola lista
            $scope.listEmail = [];
            $scope.listLoaded = true;
            $scope.showTable = false;
            $scope.tipologia = 'Monitoraggio Rigenerazione Mail';
            $scope.tipologiaRicerca = 'Monitoraggio Rigenerazione Mail';
//            $scope.tipologiaRicerca = 'Lista Richieste';
            
            $scope.idRichiestaOlo = $state.params.idRichiestaOlo;

            $scope.headerList = [
                {"key": "dataCreazione", "value": "Data Creazione", "type": "data"},
                {"key": "codiceNotifica", "value": "Codice Notifica", "type": "text"},
                {"key": "codiceCausaleNow", "value": "Codice Causale Now", "type": "text"},
                {"key": "codiceCausaleOao", "value": "Codice Causale OAO", "type": "text"},
                {"key": "destinatario", "value": "Destinatario", "type": "text"},
                {"key": "idNotifica", "value": "Seleziona", "type": "selectable"}
            ];

            RigenerazioneMailListaNotifiche.get({idRichiestaOlo: $scope.idRichiestaOlo}).$promise.then(function (response) {
                        $scope.listaNotifiche = response.data;
                        $scope.showTable = true;
                    }, function (error) {
                        $log.debug(error);
                    });
            	
            ///------------------------------------------------------------------------------------------------------------------------------
      };
        

      $scope.rinviaNotifiche = function () {
          var notifiche = [];
          $scope.showSpinner = true;
          
          //RU_1010
          //Tracking da GUI per operazione INSERIMENTO
          var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Monitoraggio|Rigenerazione Mail',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
          };
          
          for (var index = 0; index < $scope.detailArg.length; index++) {
              var element = $scope.detailArg[index];

              if (element.idNotifica) {
            	  notifiche[index] = {
                      idNotifica: element.idNotifica,
                      timestampInvio: element.dataCreazione
                  };
              }
          }

          if (notifiche.length) {
              var successCallback = function (response) {
                  if (response.result.code < 0 || !response.data || !response.data.length) {
                      $rootScope.alertGenericError();
                      $scope.showSpinner = false;
                      return false;
                  }

                  // Senza parole...
                  var esito = response.data[0];

                  if (esito.codice === 'KO') {
                      modalService.showModal({}, {
                          headerText: "Rinvio Notifiche",
                          bodyText: esito.descrizione,
                          actionButtonText: 'Chiudi'
                      });
                      $scope.showSpinner = false;
                      return false;
                  }                  

                  modalService.showModal({}, {
                      headerText: "Rinvio Notifiche",
                      bodyText: "Le notifiche selezionate sono state rinviate con successo.",
                      actionButtonText: 'Chiudi'
                  });
                  $scope.showSpinner = false;
                  $scope.listLoaded = true;
                  
                  _trackBean.timestampFine = new Date().toISOString();
                  _trackBean.esito = 'Ok';
                  TrackingGUI.tracking(_trackBean);
              };

              var errorCallback = function (error) {
            	  
                  modalService.showModal({}, {
                      headerText: "Rinvio Notifiche",
                      bodyText: "Non e' stato possibile effettuare l'invio delle notifiche selezionate. Prova piu' tardi.",
                      actionButtonText: 'Chiudi',
                      type: 'warning'
                  });
                  $scope.showSpinner = false;
                  $scope.listLoaded = true;
                  
                  _trackBean.timestampFine = new Date().toISOString();
                  _trackBean.esito = 'Ko';
                  TrackingGUI.tracking(_trackBean);
              };
              RigenerazioneMailInvioNotifiche.rinvia({listaNotifiche: notifiche}, successCallback, errorCallback);
          }
      };
      
      $scope.changeState = function () {
          //Variabile salvataggioFiltriPaginazione.tipologia deve essere aggiunta per
          //Gestire il back con i relativi salvataggi dei filtri light e della paginazione
          //la variabile va settata nel file app.routes
          //Per parametriRicerca invece viene gestita la ricerca avanzata
      	$log.debug($state.current.name);
  		if($state.params.parametriRicerca!==""){
      		$rootScope.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
              $state.go($rootScope.fromState, {
                  parametriRicerca: $state.params.parametriRicerca, "init": false
              });
      	}else{
      		$state.go('^');
      	}
      };

      
      
      
      $scope.init();
        
    }]);
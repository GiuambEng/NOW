timnow
    .controller('rigenerazioneMailController', ['alertService', '$scope', '$rootScope', '$state', '$log', 'modalService', 'AdvancedSearchGetDati', 'TRACKING_GUI', 'TrackingGUI',
    	function (alertService, $scope, $rootScope, $state, $log, modalService, AdvancedSearchGetDati, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'rigenerazioneMail';

//        $scope.init = function () {
            //solo singola lista
            $scope.listEmail = [];
            $scope.listLoaded = true;
            $scope.showTable = false;
            $scope.tipologia = 'Monitoraggio Rigenerazione Mail';
            $scope.tipologiaRicerca = 'Monitoraggio Rigenerazione Mail';
//            $scope.tipologiaRicerca = 'Lista Notifiche';
            
            
            $scope.detailArg = [];
            $scope.dataContainer = [];
            $scope.paramToSearch = [];
            $scope.headerList = [
                {"key": "dataInvio", "value": "Data Invio", "type": "data"},
                {"key": "codiceOrdineOao", "value": "Codice Ordine OAO", "type": "text"},
                {"key": "ordineTI", "value": "Ordine TI", "type": "text"},
                {"key": "tipoLavorazione", "value": "Tipo Lavorazione", "type": "text"},
                {"key": "offerta", "value": "Offerta", "type": "text"},
                {"key": "statoNow", "value": "Stato Now", "type": "text"},
                {"key": "statoOao", "value": "Stato OAO", "type": "text"},
                {"key": "codificaOao", "value": "Codifica OAO", "type": "text"}
            ];
//        };

        
        function init() {
       	   alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare le richieste di interesse.","danger",10000);
           $scope.datiLoaded = true;
       }
        
        

        if ($state.params.parametriRicerca) {
            $scope.paramToSearch = $state.params.parametriRicerca;
        }

   	    
        $scope.getSearchAdvanced = function () {
        	$scope.enableListaRichieste=false;
            $scope.listLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Monitoraggio|Rigenerazione Mail',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };
                
            	$rootScope.RicercaAdvMonitoraggioRigenerazioneMailListaRichieste = $scope.paramToSearch;
                var richieste = AdvancedSearchGetDati.save({type: 'monitoraggio-rigenerazione-mail' }, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                richieste.$promise.then(function (data) {
                	
                	_trackBean.timestampFine = new Date().toISOString();
                	
                    if (data.result.code < 0) {
                        modalService.alertSearchError();
                        
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                        
                        return false;
                    }
                    if (data.richieste){
                        $scope.listaRichieste = data.richieste;
                        
                        _trackBean.esito = 'Ok';                        
                        TrackingGUI.tracking(_trackBean);
                    }
                    $scope.listLoaded = true;
                    $scope.showTable = true;
                }, function (error) {
                    $log.debug(error);
                    modalService.alertSearchError();
                    $scope.listLoaded = true;
                    
                    _trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ko';                        
                    TrackingGUI.tracking(_trackBean);
                });

            } else {
            	delete $rootScope.RicercaAdvMonitoraggioRigenerazioneMailListaRichieste;
                modalService.showModal({}, {
                    headerText: "Rigenerazione Mail - Lista Richieste",
                    bodyText: "E' necessario aggiungere almeno un filtro nella ricerca per visualizzare la lista delle richieste.",
                    actionButtonText: 'Chiudi'
                });
            }
        };

        $scope.getListaNotifiche = function (item) {
            if (item.idRichiestaOlo){
                $state.go('root.monitoraggio.rigenerazioneMail.listaNotifiche', {
                	idRichiestaOlo: item.idRichiestaOlo,
                	parametriRicerca: $scope.paramToSearch
                });
            }else{
            	//alert nessun idRichiestaOlo associato alla richiesta
            }
            ///------------------------------------------------------------------------------------------------------------------------------
        };

        if ($rootScope.RicercaAdvMonitoraggioRigenerazioneMailListaRichieste) {
            $scope.paramToSearch = $rootScope.RicercaAdvMonitoraggioRigenerazioneMailListaRichieste;
            $scope.getSearchAdvanced();
        } else {
            init();
        }
    }]);
//Change Request #42013
timnow.controller('listaKoDel103', ['$scope', '$state', '$rootScope', 'modalService', '$log', 'alertService', 'AdvancedSearchGetDati', 'TrackingGUI', 'TRACKING_GUI',
	function ($scope, $state, $rootScope, modalService, $log, alertService, AdvancedSearchGetDati, TrackingGUI, TRACKING_GUI) {

        $scope.enableRicerca=true;
        $scope.monitoring = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];
        $scope.tipologia = 'Monitoraggi KO Delibera 103';
        $scope.tipologiaRicerca = 'MonitoraggioKODel103';

        $scope.isInitTrue = $state.params.init;
                
        $scope.init = function() {
            alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare i dati di interesse.","danger",10000);
            $scope.datiLoaded = true;
        }

        $scope.headerList.push({"key": "dataCreazioneRichiesta","value": "Data Creazione","type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.headerList.push({"key": "codificaOloAgcom","value": "OLO","type": "text","condition": ""});
        $scope.headerList.push({"key": "lavorazione","value": "Lavorazione","type": "text"});
        $scope.headerList.push({"key": "offerta","value": "Offerta","type": "text"});
        $scope.headerList.push({"key": "codiceOrdineOlo","value": "Codice Ordine Olo","type": "text"});
        $scope.headerList.push({"key": "codiceOrdineOloTarget","value": "Codice Ordine Olo Target","type": "text"});
        $scope.headerList.push({"key": "codiceOrdineTiTarget","value": "Codice Ordine TI Target","type": "text"});        
        $scope.headerList.push({"key": "idRisorsa","value": "ID Risorsa","type": "text"});
        $scope.headerList.push({"key": "idAnagraficaCausale","value": "ID Anagrafica Causale","type": "text"});
        $scope.headerList.push({"key": "descrizioneCausaleInterno","value": "Descrizione Causale Interno","type": "text"});
        $scope.headerList.push({"key": "statoRichiestaNow","value": "Stato Richiesta Now","type": "text"});        
        $scope.headerList.push({"key": "tmpacknpd103","value": "TMPACKNPD103", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.headerList.push({"key": "dac","value": "DAC","type": "data", "pattern": "dd/MM/yyyy"});       

        $scope.showDettaglio = function (item) {
			modalService.showModal({},
				{
					headerText : "File XML",
					templateUrl : 'app/common/templates.html',
					filexml : true,
					bodyText : item.contenutoXmlOlo
			});
        };
        
        $scope.getSearchAdvanced = function () {
        	$scope.enableRicerca=false;
            $scope.datiLoaded = false;

            if ($scope.paramToSearch.length > 0) {
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Monitoraggio|KO Delibera 103',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };
            	
                $rootScope.RicercaAdvMonitoraggioKoDel103 = $scope.paramToSearch;

                var ordini = AdvancedSearchGetDati.save({
                    type: 'monitorings_delibera103Ko'
                }, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                ordini.$promise.then(function (data) {
                	
                	_trackBean.timestampFine = new Date().toISOString();
                	                	
                    if (data.result.code < 0) {
                        modalService.alertSearchError();
                        
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                        
                        return false;
                    }
                    if (data.data){
                        $scope.monitoring = data.data;
                        
                        _trackBean.esito = 'Ok';
                        TrackingGUI.tracking(_trackBean);
                    }
                    $scope.datiLoaded = true;
                }, function (error) {                	
                    $log.debug(error);
                    modalService.alertSearchError();
                    $scope.datiLoaded = true;
                    
                	_trackBean.timestampFine = new Date().toISOString();
                	_trackBean.esito = 'Ko';
                	TrackingGUI.tracking(_trackBean);
                });
            } else {
            	delete $rootScope.RicercaAdvListaOrdini;
                init();
            }
        };
        
        if (($scope.isInitTrue) && $rootScope.RicercaAdvMonitoraggioKoDel103) {
            delete $rootScope.RicercaAdvMonitoraggioKoDel103;
        }
        
        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }
        
        if ($rootScope.RicercaAdvMonitoraggioKoDel103) {
            $scope.paramToSearch = $rootScope.RicercaAdvMonitoraggioKoDel103;
            $scope.getSearchAdvanced();
        } else {
            $scope.init();
        }
        
    }]);
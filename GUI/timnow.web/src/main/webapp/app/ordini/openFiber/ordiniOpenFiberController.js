timnow.controller('listaOrdiniOpenFiber', ['alertService', '$scope', '$state', '$rootScope', '$log', 'AdvancedSearchGetDati', 'ExportId', 'modalService', 'TRACKING_GUI', 'TrackingGUI',
    function (alertService, $scope, $state, $rootScope, $log, AdvancedSearchGetDati, ExportId, modalService, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'lista-ordini';
        $scope.enableRicercaOrdini=true;
        $scope.orders = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];
        $scope.tipologia = $state.params.tipologia;

        var isInitTrue = $state.params.init;
        if ((isInitTrue) && $rootScope.RicercaAdvListaOrdiniOpenFiber) {
            delete $rootScope.RicercaAdvListaOrdiniOpenFiber;
        }

        $scope.init = function() {
            alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare gli ordini di interesse.","danger",10000);
            $scope.datiLoaded = true;
        }

        $scope.conn = $rootScope.timnowConfigData.config;

        $scope.headerList.push({"key": "dataInvio","value": "Data Invio","type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "codiceordineolo","value": "Codice Ordine OAO","type": "text","condition": ""});
        $scope.headerList.push({"key": "idRisorsa","value": "ID Risorsa","type": "text"});
        $scope.headerList.push({"key": "tipoLavorazione","value": "Tipo Lavorazione","type": "text"});
        $scope.headerList.push({"key": "sottolavorazione","value": "Sottolavorazione","type": "text"});
        $scope.headerList.push({"key": "offerta","value": "Offerta","type": "text"});
        $scope.headerList.push({"key": "descriz_causal_olo","value": "Causale","type": "text"});
        $scope.headerList.push({"key": "statorichiesteolo","value": "Stato OAO","type": "text","condition": ""});
        $scope.headerList.push({"key": "inAttesaDesospensioneDaOao","value": "In Attesa Desospensione da OAO(SI/NO)","type": "text","condition": ""});
        
        $scope.getDettaglioOrdini = function (item) {
            //devo eseguire il controllo se codiceOrdineTI esiste ma si trova in stato scartato allora devo comunque passare idRIchiestaOlo
            if (item.codiceordineti && item.statorichiestanow!=='SCARTATO'){
            	$scope.orderNumber = item.codiceordineti;
            }else{
            	$scope.orderNumber = item.idRichiestaOlo;
            }
            $scope.reqType = ((item.codiceordineti)&& item.statorichiestanow!=='SCARTATO')? 'codiceordineti' : 'idrichiestaolo';
            $scope.codiceOrdineOlo = item.codiceordineolo || (item.codiceordineti && item.statorichiestanow!=='SCARTATO') || item.idRichiestaOlo;
 
            $state.go("root.ordini.openfiber.dettaglio", {
            	reqType: $scope.reqType,
            	orderNumber:$scope.orderNumber,
                parametriRicerca: $scope.paramToSearch,
                codiceOrdineOlo: $scope.codiceOrdineOlo
            });
        };

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }

        $scope.tipologiaRicerca = 'Lista Ordini OF';
        
        $scope.getSearchAdvanced = function () {
        	$scope.enableRicercaOrdini=false;
            $scope.datiLoaded = false;

            if ($scope.paramToSearch.length > 0) {
            	var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Ordini|Lista Ordini OpenFiber',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };
            	
                $rootScope.RicercaAdvListaOrdiniOpenFiber = $scope.paramToSearch;

                var ordini = AdvancedSearchGetDati.save({
                    type: 'orders',
                    listType: 'FIBERSTREAM',
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
                        $scope.orders = data.data;
                        
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
            	delete $rootScope.RicercaAdvListaOrdiniOpenFiber;
                $scope.init();
            }
        };

        $scope.iniziaExport = function () {
            var bodyData = {
                "userId": $rootScope.timnowConfigData.user.userId,
                "idRichiesta": [],
                "codOloAgcom": $rootScope.timnowConfigData.user.codificaOloAgcom,
                "tipoProfilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "tipoLista": "FIBERSTREAM"
            };

            if ($scope.paramToSearch.length > 0) {

                bodyData.advancedResearch = {
                    "numerorighe": "",
                    "indiceriga": "",
                    "exportRequest": true,
                    "conditions": $scope.paramToSearch
                };
            }
            
            $rootScope.numeroDatiEsportati = $scope.orders.length;

            return ExportId.save({
                entita: 'orders'
            }, bodyData).$promise;

        };


        if ($rootScope.RicercaAdvListaOrdiniOpenFiber) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaOrdiniOpenFiber;
            $scope.getSearchAdvanced();
        } else {
            $scope.init();
        }

    }]);
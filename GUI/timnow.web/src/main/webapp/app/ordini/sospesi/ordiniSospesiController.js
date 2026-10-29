timnow.controller('listaOrdiniSospesi', ['alertService', '$scope', '$state', '$rootScope', 'Orders', '$log', 'AdvancedSearchGetDati', 'modalService',
    'ExportId', 'CRM_PROFILE', 'TRACKING_GUI', 'TrackingGUI',
    function (alertService, $scope, $state, $rootScope, Orders, $log, AdvancedSearchGetDati, modalService, ExportId, CRM_PROFILE, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'lista-ordini-sospesi';

        $scope.orders = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];

        $scope.tipologia = $state.params.tipologia;

        if (($state.params.init === true) && $rootScope.RicercaAdvListaSospesi) {
            delete $rootScope.RicercaAdvListaSospesi;
        }

        function init() {
            var ord = Orders.get({state:"SOSPESO"});
            return ord.$promise.then(function (data) {
                $scope.orders = data.data;
                $scope.datiLoaded = true;
                if (!$scope.orders) {
                    $scope.errorDate = true;
                } else {
                    $scope.long = data.data.length;
                }
            }, function (error) {
                $log.error(error);
                $scope.errorDate = true;
                $scope.datiLoaded = true;
            });
        }

        $scope.conn = $rootScope.timnowConfigData.config;

        var ut_profile = $rootScope.timnowConfigData.user.codiceProfilo;

        $scope.headerList.push({"key": "dataInvio","value": "Data Invio","type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "codiceordineolo","value": "Codice Ordine OAO","type": "text","condition": ""});
//      $scope.headerList.push({"key": "codiceordineti","value": "Ordine TI","type": "text"});
        $scope.headerList.push({"key": "idRisorsa","value": "ID Risorsa","type": "text"});
        $scope.headerList.push({"key": "tipoLavorazione","value": "Tipo Lavorazione","type": "text"});
        $scope.headerList.push({"key": "offerta","value": "Offerta","type": "text"});
        $scope.headerList.push({"key": "descriz_causal_olo","value": "Causale","type": "text"});
        $scope.headerList.push({"key": "statorichiesteolo","value": "Stato OAO","type": "text","condition": ""});
        if (ut_profile !== CRM_PROFILE.CRM_OLO && ut_profile !== CRM_PROFILE.CRM_OLORO) {
            $scope.headerList.push({"key": "statorichiestanow","value": "Stato Now","type": "text","condition": ""});
            $scope.headerList.push({"key": "codfc_olo_agcom","value": "Codifica OAO","type": "text"});
        }
        $scope.headerList.push({"key": "inAttesaDesospensioneDaOao","value": "In Attesa Desospensione da OAO(SI/NO)","type": "text","condition": ""});

        $scope.getDettaglioOrdini = function (item) {
        	$scope.orderNumber = item.codiceordineti || item.idRichiestaOlo;
            //$log.info($scope.orderNumber);
            $scope.reqType = (item.codiceordineti) ? 'codiceordineti' : 'idrichiestaolo';
            $scope.codiceOrdineOlo = item.codiceordineolo || item.codiceordineti || item.idRichiestaOlo;
            $state.go('root.ordini.sospesi.dettaglio', {
            	reqType: $scope.reqType,
            	orderNumber:$scope.orderNumber,
                parametriRicerca: $scope.paramToSearch,
                codiceOrdineOlo: $scope.codiceOrdineOlo
            });
        };

        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }
        $scope.tipologiaRicerca = 'Lista Ordini';

        $scope.getSearchAdvanced = function () {
            $scope.datiLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione INSERIMENTO
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Ordini|Ordini Sospesi',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                $rootScope.RicercaAdvListaSospesi = $scope.paramToSearch;
                var ordini = AdvancedSearchGetDati.save({
                	state: 'SOSPESO',
                    type: 'orders'
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
                    if (data.data) {
                        $scope.orders = data.data;
                        
                        _trackBean.esito = 'Ok';
                        TrackingGUI.tracking(_trackBean);
                    }
                    $scope.datiLoaded = true;
                }, function (error) {
                    $log.error(error);
                    modalService.alertSearchError();
                    $scope.datiLoaded = true;
                    
                	_trackBean.timestampFine = new Date().toISOString();
                	_trackBean.esito = 'Ko';
                	TrackingGUI.tracking(_trackBean);
                });
            } else {
            	delete $rootScope.RicercaAdvListaSospesi;
                init();
            }
        };

        $scope.iniziaExport = function () {
            var bodyData = {
                "userId": $rootScope.timnowConfigData.user.userId,
                "idRichiesta": [],
                "codOloAgcom": $rootScope.timnowConfigData.user.codificaOloAgcom,
                "tipoProfilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "tipoLista": "SOSPESO"
            };

            if ($scope.paramToSearch.length > 0) {

                bodyData.advancedResearch = {
                    "numerorighe": "",
                    "indiceriga": "",
                    "exportRequest": true,
                    "conditions": $scope.paramToSearch
                };
            }

          //RU_902
            $rootScope.numeroDatiEsportati = $scope.orders.length;
            
            return ExportId.save({
                entita: 'orders'
            }, bodyData).$promise;

        };

        if ($rootScope.RicercaAdvListaSospesi) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaSospesi;
            $scope.getSearchAdvanced();
        } else {
            init();
        }

    }]);
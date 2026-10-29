timnow.controller('listaTempiAttravDettaglio', ['$scope', '$state', '$rootScope', 'TempiAttraversamento', '$log', 'modalService',
    function ($scope, $state, $rootScope, TempiAttraversamento, $log, modalService) {

        $rootScope.pageClass = 'listaTempiAttravDettaglio';
        $log.info('listaTempiAttraversamentoDettaglio');
        $scope.tipologia = 'Dettaglio tempi di attraversamento';
        // solo singola lista
        $scope.tempAttraversamento = [];
        $scope.tempAttraversamentoLoaded = false;
        $scope.headerList = [{
            "key": "dataCreazioneRichiesta",
            "value": "Data Creazione Richiesta",
            "type": "text"
        }, {
            "key": "offerta",
            "value": "Offerta",
            "type": "text"
        }, {
            "key": "ambito",
            "value": "Ambito",
            "type": "text"
        }, {
            "key": "codiceOrdineTI",
            "value": "Ordine TI",
            "type": "text"
        }, {
            "key": "statoNOW",
            "value": "Stato NOW",
            "type": "text"
        }, {
            "key": "statoOAO",
            "value": "Stato OAO",
            "type": "text"
        }, {
            "key": "dro",
            "value": "DRO",
            "type": "text"
        }, {
            "key": "idRisorsa",
            "value": "Id Risorsa",
            "type": "text"
        }, {
            "key": "codificaOloAgcom",
            "value": "Codifica OAO",
            "type": "text"
        }, {
            "key": "codOloNow",
            "value": "Codice OAO",
            "type": "text"
        }, {
            "key": "codiceOrdineOAO",
            "value": "Codice Ordine OAO",
            "type": "text"
        }, {
            "key": "idRichiesta",
            "value": "Id Richiesta",
            "type": "text"
        }];
        init();

        function init() {
            if ($state.params.dettaglio) {
                $scope.item = $state.params.dettaglio;
                $scope.tempAttraversamentoLoaded = false;
                if ($scope.item.IdTempiAttraversamentoGUI) {
                    var ordDetails = TempiAttraversamento.get({
                        idTempiAttraversamento: $scope.item.IdTempiAttraversamentoGUI,
                        flagExport: false, 
                        level:'level1'                    
                    });

                    return ordDetails.$promise.then(function (response) {
                        $scope.tempAttraversamentoLoaded = true;
                        if (response.crossingTimes) {
                            $scope.tempAttraversamento = response.crossingTimes;
                        } else {
                            modalService.showModal({}, {
                                headerText: "Dettaglio Monitoraggio Tempo di attraversamento",
                                bodyText: "Nessun dettaglio disponibile",
                                actionButtonText: 'Chiudi',
                                type: 'warning'
                            });
                        }
                    }, function (error) {
                        $log.debug(error);
                        $scope.tempAttraversamentoLoaded = true;
                        $scope.errorDetail = true;
                        modalService.showModal({}, {
                            headerText: "Errore Dettaglio Monitoraggio Tempo di attraversamento",
                            bodyText: "Impossibile visualizzare il dettaglio",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                    });
                } else {
                    $log.info("Impossibile visualizzare il dettaglio");
                }
            } else {
                $state.go('root.monitoraggio.tempiAttraversamento');
            }
        }

        $scope.changeState = function () {
            $state.go($rootScope.fromState);
        };

        /* EXPORT DATI */

        $scope.iniziaExport = function () {
        	
        	//RU_902
            $rootScope.numeroDatiEsportati = $scope.tempAttraversamento.length;
        	
            return TempiAttraversamento.get({
                idTempiAttraversamento: $scope.item.IdTempiAttraversamentoGUI,
                flagExport: true, 
                level:'level1'
            }).$promise;
        };

        $scope.dataSort = function (dato) {
            var date = new Date(dato.dataEstrazione);
            return date;
        };

    }]);

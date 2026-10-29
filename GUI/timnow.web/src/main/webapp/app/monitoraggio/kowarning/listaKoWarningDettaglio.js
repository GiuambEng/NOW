timnow
    .controller('listakoWarnDettaglio', ['$scope', '$state', '$rootScope', 'MonitoraggioKOWarning', '$log', 'modalService', function ($scope, $state, $rootScope, MonitoraggioKOWarning, $log, modalService) {

        $rootScope.pageClass = 'listakoWarnDettaglio';
        $log.info('listakoWarnDettaglio');


        //solo singola lista  
        $scope.koData = [];
        $scope.koDataLoaded = false;
        $scope.headerList = [
            {"key": "dataEstrazione", "value": "Data Estrazione", "type": "text"},
            {"key": "offerta", "value": "Offerta", "type": "text"},
            {"key": "causaleOrdineOlo", "value": "Causale Ordine OLO", "type": "text"},
            {"key": "descrizioneCausaleOrdineOlo", "value": "Descrizione Causale Ordine OLO", "type": "text"},
            {"key": "lavorazione", "value": "Lavorazione", "type": "text"},
            {"key": "totale", "value": "Totale", "type": "text"}
        ];


        $scope.keyDetail = "chiave";
        $scope.detailArg = "";
        $scope.dataContainer = [];
        $scope.detailList = [
            {"key": "dataCreazioneRichiesta", "value": "Data Creazione Richiesta", "type": "text"},
            {"key": "codificaOAO", "value": "Codifica OAO", "type": "text"},
            {"key": "codiceOAO", "value": "Codice OAO", "type": "text"},
            {"key": "ordineTI", "value": "Ordine TI", "type": "text"},
            {"key": "statoNOW", "value": "Stato NOW", "type": "text"},
            {"key": "statoOLO", "value": "Stato OLO", "type": "text"},
            {"key": "DRO", "value": "DRO", "type": "text"},
            {"key": "idRisorsa", "value": "Id Risorsa", "type": "text"},
            {"key": "ambito", "value": "Ambito", "type": "text"},
            {"key": "offerta", "value": "Offerta", "type": "text"},
            {"key": "idRichiesta", "value": "IdRichiesta", "type": "text"}
        ];


        init();

        function init() {
            if ($state.params.dettaglio) {
                $scope.koData = $state.params.dettaglio;
                for (var index = 0; index < $scope.koData.length; index++) {
                    $scope.koData[index].chiave = index;
                }

            } else {
                $state.go('root.monitoraggio.koWarn');
            }
            $scope.koDataLoaded = true;
        }

        $scope.getDettaglio = function (rowSelezionato) {
            $log.debug($scope.detailArg);

            if (!$scope.dataContainer[$scope.detailArg.chiave]) {
                if ($scope.koData[rowSelezionato.chiave].causaleOrdineOlo && $scope.koData[rowSelezionato.chiave].dataEstrazione) {
                    MonitoraggioKOWarning.get({
                        dataAggiornamento: $scope.koData[rowSelezionato.chiave].dataEstrazione,
                        codCausaleOLO: $scope.koData[rowSelezionato.chiave].causaleOrdineOlo,
                        tipoErrore: 'WARNING',
                        level:'level2'
                    }).$promise.then(function (response) {
//                        $scope.dataContainer[$scope.detailArg.chiave] = response.data[0];
                        $scope.modalDettaglioKoWarning.data = response.data;
                        modalService.showModal($scope.modalDefs, $scope.modalDettaglioKoWarning);
                    });


                } else {
                    modalService.showModal({}, {
                        headerText: "Lista KO Warning",
                        bodyText: "Nessun dettaglio da visualizzare",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                }
            }
        };

        $scope.modalDefs = {templateUrl: 'app/monitoraggio/kowarning/requestDetailmodal.html'};
        $scope.modalDettaglioKoWarning = {scope: $scope};

        /* EXPORT DATI */
        $scope.iniziaExport = function () {
            if (!$state.params.parentData) {
                $state.go('root.monitoraggio.koWarn');
            }
            
            //RU_902	//SM_8906
            $rootScope.numeroDatiEsportati = $scope.koData.length

            var bodyData = $state.params.parentData;
            bodyData.flagExport = true;

            return MonitoraggioKOWarning.get(bodyData).$promise;
        };


        $scope.changeState = function () {
            $state.go($rootScope.fromState);
        };

    }]);

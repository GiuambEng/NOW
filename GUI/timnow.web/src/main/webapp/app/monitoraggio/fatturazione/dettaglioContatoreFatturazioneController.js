timnow
    .controller('dettaglioContatoreFatturazioneController', ['$scope', '$rootScope', '$state', 'modalService', 'MonitoraggioFatturazione', function ($scope, $rootScope, $state, modalService, MonitoraggioFatturazione) {

        $rootScope.pageClass = 'monitoraggioFatturazioneContatore';

        /**
         * Callback per l'inizializzazione delle variabili dello scope.
         */
        $scope.init = function () {
            $scope.list = [];
            $scope.listLoaded = false;
            $scope.tipologia = "Dettagli";
            $scope.listHeaders = [
                {"key": "codiceOrdineOlo", "value": "Cod. ordine OLO", "type": "text"},
                {"key": "codiceOrdineTI", "value": "Cod. ordine TI", "type": "text"},
                {"key": "dataEstrazione", "value": "Data estrazione", "type": "text"},
                {"key": "dataRicezioneOrdine", "value": "Data ricezione ordine", "type": "text"},
                {"key": "famigliaOfferta", "value": "Desc. famiglia offerta", "type": "text"},
                {"key": "tipologiaLavorazione", "value": "Tipologia lavorazione", "type": "text"},
                {"key": "idRichiesta", "value": "Id. richiesta OLO", "type": "text"},
                {"key": "idEventoOrdineNOW", "value": "Id. evento ordine NOW Wholesale", "type": "text"},
                {"key": "servizio", "value": "Offerta", "type": "text"},
                {"key": "statoOrdineNOW", "value": "Stato richiesta NOW", "type": "text"},
                {"key": "statoRichiestaOLO", "value": "Stato richiesta OLO", "type": "text"},
                {"key": "dataEvento", "value": "Data evento", "type": "text"},
                {"key": "codificaOloAgcom", "value": "Codifica OLO AGCOM", "type": "text"},
                {"key": "codificaOloNOW", "value": "Codifica OLO NOW", "type": "text"},
                {"key": "causaleScarto", "value": "Causale scarto", "type": "text"},
                {"key": "descCausaleScarto", "value": "Desc. scarto", "type": "text"}
            ];

            $scope.getDettaglioContatore();
        };

        /**
         *  Carica e inietta nello scope i dati relativi al dettaglio del contatore.
         */
        $scope.getDettaglioContatore = function () {
            if (!$state.params.contatore) {
                $state.go('root.monitoraggio.fatturazione');
                return false;
            }

            var successCallback = function (response) {
                if (!response.hasOwnProperty('result') || response.result.code < 0) {
                    modalService.alertSearchError();
                    return false;
                }
                if (response.data) {
                    $scope.list = response.data;
                }

                $scope.listLoaded = true;
                $scope.loading = false;
            };

            var errorCallback = function () {
                modalService.alertSearchError();
                $scope.listLoaded = true;
                $scope.loading = false;
            };

            var contatore = $state.params.contatore;

            var parameters = {
                dataEstrazione: contatore.dataEstrazione,
                statoRichiestaNow: contatore.statoRichiestaNow,
                descrizioneFamigliaOfferta: contatore.descrizioneFamigliaOfferta,
                flagExport: false,
                type: 'contatore'
            };

            MonitoraggioFatturazione.get(parameters).$promise.then(successCallback, errorCallback);

        };

        /**
         *  Callback per la redirect verso a pagina di dettaglio del contatore.
         */
        $scope.getDettaglio = function (item) {
            $state.go('root.monitoraggio.fatturazione.contatore.dettaglio', {
                selectedOrder: item
            });
        };

        /**
         *  Callback per la redirect verso a pagina di listing.
         */
        $scope.backState = function () {
            $state.go($rootScope.fromState);
        };

        $scope.init();

    }]);
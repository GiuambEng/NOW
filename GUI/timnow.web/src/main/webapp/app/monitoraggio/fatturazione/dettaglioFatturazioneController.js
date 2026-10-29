timnow.controller('dettaglioFatturazioneController', ['$scope', '$rootScope', '$state', 'modalService', 'MonitoraggioFatturazione',
    function ($scope, $rootScope, $state, modalService, MonitoraggioFatturazione) {

        $rootScope.pageClass = 'monitoraggioFatturazioneDettaglio';

        /**
         * Callback per l'inizializzazione delle variabili dello scope.
         */
        $scope.init = function () {
            $scope.list = [];
            $scope.listLoaded = false;
            $scope.tipologia = "Richieste";
            $scope.listHeaders = [{
                "key": "dataCreazioneRichiesta",
                "value": "Data invio richiesta",
                "type": "text"
            }, {
                "key": "codificaOAO",
                "value": "Codifica OLO AGCOM",
                "type": "text"
            }, {
                "key": "codiceOAO",
                "value": "Codifica OLO NOW",
                "type": "text"
            }, {
                "key": "ordineTI",
                "value": "Cod. ordine TI",
                "type": "text"
            }, {
                "key": "statoNOW",
                "value": "Stato richiesta NOW",
                "type": "text"
            }, {
                "key": "statoOLO",
                "value": "Stato richiesta OLO",
                "type": "text"
            }, {
                "key": "idRisorsa",
                "value": "Id risorsa",
                "type": "text"
            }, {
                "key": "dro",
                "value": "DRO",
                "type": "text"
            }, {
                "key": "ambito",
                "value": "Ambito",
                "type": "text"
            }, {
                "key": "offerta",
                "value": "Offerta",
                "type": "text"
            }, {
                "key": "idRichiesta",
                "value": "Id Richiesta",
                "type": "text"
            }];
            $scope.getRichieste();
        };

        /**
         * Carica e inietta nello scope i dati relativi al dettaglio
         * richieste per ordine selezionato.
         */
        $scope.getRichieste = function () {
            if (!$state.params.selectedOrder) {
                $state.go('root.monitoraggio.fatturazione');
                return false;
            }

            var successCallback = function (response) {
                if (!response.hasOwnProperty('result') || response.result.code < 0) {
                    modalService.alertSearchError();
                    return false;
                }
                if (response) {
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

            MonitoraggioFatturazione.get({
                codiceOrdineTI: $state.params.selectedOrder.codiceOrdineTI,
                type:'dettaglio'
            }).$promise.then(successCallback, errorCallback);

        };

        $scope.backState = function () {
            $state.go($rootScope.fromState);
        };
        
        $scope.init();

    }]);
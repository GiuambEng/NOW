timnow
    .controller('listaFatturazioneController', ['$scope', '$rootScope', '$state', 'modalService', 'MonitoraggioFatturazione', function ($scope, $rootScope, $state, modalService, MonitoraggioFatturazione) {

        $rootScope.pageClass = 'monitoraggioFatturazione';

        /**
         * Callback per l'inizializzazione delle variabili dello scope.
         */
        $scope.init = function () {
            $scope.loading = false;
            $scope.list = [];
            $scope.listLoaded = false;
            $scope.getMonitoraggioFatturazione();
        };

        /**
         *  Callback per l'inizializzazione della lista.
         */
        $scope.getMonitoraggioFatturazione = function () {
            var successCallback = function (response) {
                if (!response.hasOwnProperty('result') || response.result.code < 0) {
                    modalService.alertSearchError();
                    return false;
                }
                if (response.monitoraggi) {
                    $scope.list = response;
                }

                $scope.listLoaded = true;
                $scope.loading = false;
            };

            var errorCallback = function () {
                modalService.alertSearchError();
                $scope.listLoaded = true;
                $scope.loading = false;
            };

            $scope.list = [];
            $scope.loading = true;

            MonitoraggioFatturazione.get().$promise.then(successCallback, errorCallback);
        };

        /**
         *  Callback per la redirect verso a pagina di dettaglio del contatore.
         */
        $scope.getDettaglioContatore = function (item, famiglia, stato) {
            var parameters = {
                statoRichiestaNow: stato,
                descrizioneFamigliaOfferta: famiglia,
                dataEstrazione: item.dataAcquisizione
            };

            $state.go('root.monitoraggio.fatturazione.contatore', {
                contatore: parameters
            });
        };

        $scope.init();

    }]);
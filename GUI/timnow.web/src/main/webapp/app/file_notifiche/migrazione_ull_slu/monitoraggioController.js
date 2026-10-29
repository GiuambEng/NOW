timnow.controller('monitoraggioMigrazioneUllSlu', ['$scope', '$rootScope', '$state', 'MigrazioneUllSlu',
    function ($scope, $rootScope, $state, MigrazioneUllSlu) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        $scope.uploadStatuses = [];
        $scope.headerList = [
            {key: 'numeroRecord', value: 'Numero record', type: 'text'},
            {key: 'clli', value: 'CLLI', type: 'text'},
            {key: 'distrettoTelefono', value: 'Distretto telefono', type: 'text'},
            {key: 'codiceOrdineOLO', value: 'Codice ordine OLO', type: 'text'},
            {key: 'stato', value: 'Stato', type: 'text'},
            {key: 'descrizioneErrore', value: 'Descrizione errore', type: 'text'},
            {key: 'dataInizioElab', value: 'Data inizio elaborazione', type: 'text'},
            {key: 'contenutoRecord', value: 'Contenuto record', type: 'text'}
        ];

        $scope.backToFileList = function () {
            $state.go('root.notifiche.migrazioneUllSlu.listaFile');
        };

        $scope.loadUploadStatus = function () {
            $scope.statusesLoaded = false;
            $scope.operationError = null;
            MigrazioneUllSlu.dettaglio.get({
                nomeFile: $state.params.nomeFile,
                idFile: $state.params.idFile
            }).$promise.then(function (response) {
                if (response.result && response.result.code != '0' && response.result.code != 'OK') {
                    $scope.uploadStatuses = [];
                    $scope.operationError = response.result.details || 'Impossibile recuperare il dettaglio del file.';
                } else {
                    $scope.uploadStatuses = response.listacampi || [];
                    $scope.$broadcast('nowTable.refreshData', $scope.uploadStatuses);
                }
                $scope.statusesLoaded = true;
            }, function () {
                $scope.uploadStatuses = [];
                $scope.statusesLoaded = true;
                $scope.operationError = 'Impossibile recuperare il dettaglio del file. Riprovare piu\' tardi.';
            });
        };

        $scope.loadUploadStatus();
    }]);
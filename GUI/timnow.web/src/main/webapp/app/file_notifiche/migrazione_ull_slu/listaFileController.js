timnow.controller('listaFileMigrazioneUllSlu', ['$scope', '$rootScope', '$state', 'MigrazioneUllSlu', 'MIGRAZIONE_ULL_SLU_STATI',
    function ($scope, $rootScope, $state, MigrazioneUllSlu, MIGRAZIONE_ULL_SLU_STATI) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        $scope.files = [];
        $scope.filesLoaded = false;
        $scope.operationInProgressId = null;
        $scope.operationError = null;
        
        $scope.headerList = [
            {key: 'nomeFile', value: 'Nome File', type: 'text'},
            {key: 'dataInserimento', value: 'Data Inserimento File', type: 'text'},
            {key: 'dataAggiornamento', value: 'Data Aggiornamento', type: 'text'},
            {key: 'numeroRecord', value: 'Numero Record', type: 'text'},
            {key: 'statoElaborazione', value: 'Stato Elaborazione', type: 'text'},
            {key: 'descrizioneErrore', value: 'Descrizione Errore', type: 'text'},
            {key: 'idOperatore', value: 'Operatore', type: 'text'},
            {key: 'azioni', value: '', type: 'migrazioneUllSluActions'}
        ];

        $scope.loadFileList = function () {
            $scope.filesLoaded = false;
            $scope.operationError = null;
            MigrazioneUllSlu.files.get().$promise.then(function (response) {
                $scope.files = response.data || [];
                angular.forEach($scope.files, function (file) {
                    var statoElaborazione = MIGRAZIONE_ULL_SLU_STATI[file.idStatoElabStag];
                    if (statoElaborazione) {
                        file.statoElaborazione = statoElaborazione;
                    }
                });
                $scope.$broadcast('nowTable.refreshData', $scope.files);
                $scope.filesLoaded = true;
            }, function () {
                $scope.files = [];
                $scope.filesLoaded = true;
                $scope.operationError = 'Impossibile recuperare la lista file. Riprovare piu\' tardi.';
            });
        };

        $scope.executeOperation = function (resource, file, urlParams, body) {
            $scope.operationInProgressId = file.id;
            $scope.operationError = null;
            resource.save(urlParams || {}, body || {}).$promise.then(function (response) {
                $scope.operationInProgressId = null;
                if (response.result && response.result.code != '0' && response.result.code != 'OK') {
                    $scope.operationError = response.result.details || 'Impossibile completare l\'operazione sul file ' + file.nomeFile + '.';
                } else {
                    $scope.loadFileList();
                }
            }, function () {
                $scope.operationInProgressId = null;
                $scope.operationError = 'Impossibile completare l\'operazione sul file ' + file.nomeFile + '.';
            });
        };

        $scope.performFileAction = function (action, file) {
            if (action === 'check') {
                $scope.executeOperation(MigrazioneUllSlu.check, file, {nomeFile: file.nomeFile}, {});
            } else if (action === 'delete') {
                $scope.operationInProgressId = file.id;
                $scope.operationError = null;
                MigrazioneUllSlu.delete.remove({nomeFile: file.nomeFile}).$promise.then(function () {
                    $scope.operationInProgressId = null;
                    $scope.loadFileList();
                }, function () {
                    $scope.operationInProgressId = null;
                    $scope.operationError = 'Impossibile completare l\'operazione sul file ' + file.nomeFile + '.';
                });
            } else if (action === 'startProcessing') {
                $scope.executeOperation(MigrazioneUllSlu.avviaLavorazione, file, {}, {nomeFile: file.nomeFile});
            } else if (action === 'viewDetails') {
                $state.go('root.notifiche.migrazioneUllSlu.monitoraggio', {
                    idFile: file.id,
                    nomeFile: file.nomeFile
                });
            }
        };

        $scope.loadFileList();
    }]);
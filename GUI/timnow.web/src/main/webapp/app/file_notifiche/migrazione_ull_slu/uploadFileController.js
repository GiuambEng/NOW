timnow.controller('uploadFileMigrazioneUllSlu', ['$scope', '$state', '$rootScope', 'BASEPATH', '$timeout', 'Upload',
    function ($scope, $state, $rootScope, BASEPATH, $timeout, Upload) {
        $rootScope.pageClass = $state.params.pageClass;

        $scope.onFileSelect = function (files) {
            $scope.csvFile = files && files[0];
            $scope.fileName = $scope.csvFile ? $scope.csvFile.name : null;
            $scope.errorMsg = null;
            $scope.successMsg = null;
        };

        $scope.uploadFile = function (file) {
            if (!file) {
                return;
            }
            $scope.uploadingFile = true;
            $scope.errorMsg = null;
            $scope.successMsg = null;
            Upload.upload({
                url: BASEPATH + 'migrazione-ull-slu/upload',
                data: {file: file}
            }).then(function (response) {
                $scope.uploadingFile = false;
                
                // Gestire il risultato ricevuto dal backend
                if (response.data && response.data.result) {
                    var resultObj = response.data.result;
                    
                    // Controllare il severity per determinare se è un errore o un successo
                    if (resultObj.severity === 'ERROR' || resultObj.code == "KO") {
                        // Mostrare messaggio di errore con icona alert
                        $scope.errorMsg = resultObj.details || 'Errore durante il caricamento del file';
                        $scope.isError = true;
                    } else {
                        // Mostrare messaggio di successo con icona success
                        $scope.successMsg = resultObj.details || 'File caricato correttamente';
                        $scope.isSuccess = true;
                        $timeout(function () {
                            $scope.csvFile = null;
                            $scope.fileName = null;
                            $scope.uploadForm.$setPristine();
                        }, 3000);
                    }
                } else {
                    // Fallback se la risposta non ha la struttura attesa
                    $scope.successMsg = 'File caricato correttamente';
                    $scope.isSuccess = true;
                    $timeout(function () {
                        $scope.csvFile = null;
                        $scope.fileName = null;
                        $scope.uploadForm.$setPristine();
                    }, 3000);
                }
            }, function (response) {
                $scope.uploadingFile = false;
                // In caso di errore della richiesta HTTP
                var errorMsg = 'Impossibile caricare il file, riprovare piu tardi';
                if (response.data && response.data.result) {
                    errorMsg = response.data.result.description || response.data.result.details || errorMsg;
                }
                $scope.errorMsg = errorMsg;
                $scope.isError = true;
            });
        };
    }]);
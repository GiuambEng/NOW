//RU_1335
timnow
    .controller('uploadFileFwaDecommissioning', ['$scope', '$state', '$rootScope', 'BASEPATH', '$log', '$timeout', 'Upload', 'TRACKING_GUI', 'TrackingGUI',
    	function ($scope, $state, $rootScope, BASEPATH, $log, $timeout, Upload, TRACKING_GUI, TrackingGUI)  {
        $rootScope.pageClass = $state.params.pageClass;

        $scope.invalidFiles = [];

        $scope.$watch('files', function (files) {
            if (typeof files === "undefined") {
                return;
            }

            $scope.formUpload = false;
            if (files !== null) {
                if (!angular.isArray(files)) {
                    $timeout(function () {
                        $scope.files = files = [files];
                    });
                    return;
                }

                for (var i = 0; i < files.length; i++) {
                    $scope.errorMsg = null;
                    (extractedFunction(f))(files[i]);
                }
            }
        });
        
        function extractedFunction (f) {
            $scope.upload(f, true);
        }

        $scope.uploadFile = function (file) {
            if (file) {
                $scope.formUpload = true;
                if (file != null && !file.progress) {
                    $scope.upload(file);
                }
            }

        };

        $scope.upload = function (file, resumable) {
            $scope.uploadingFile = true;
            uploadUsingUpload(file, resumable);
        };

        $scope.onFileSelect = function (file) {
            $log.info("onFileSelect");
            if (file && file[0]) {
                $scope.fileName = file[0].name;
                $scope.errorMsg = "";
            }
        };

        $scope.chunkSize = 100000;
        function uploadUsingUpload(file, resumable) {
            $log.debug(file); 
          			
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			descrizioneFunzione: 'File e Notifiche|Upload File Risorse FWA Decommissioning',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: file.name || null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.UPLOAD.descrizione,
	    			parametriOperazione: null	
            };

            $scope.fileName = file.name;
            file.upload = Upload.upload({
                url: BASEPATH + 'fwa/upload' + $scope.getReqParams(),
                resumeSizeUrl: resumable ? BASEPATH + 'fwa/upload?name=' + encodeURIComponent(file.name) : null,
                resumeChunkSize: resumable ? $scope.chunkSize : null,
                data: {
                    file: file	
                }
            });

            file.upload.then(function (response) {
                $scope.uploadingFile = false;
                $timeout(function () {
                    file.result = response.data;
                    $scope.fileName = "";
                    
                    _trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ok';
                    TrackingGUI.tracking(_trackBean);  
                });
            }, function (response) {
                $scope.uploadingFile = false;
                if (response.status !== -1) {
                    if (response.data && response.data.result.code < 0) {
                        $scope.errorMsg = response.data.result.description;
                    }
                } else {
                    $scope.errorMsg = "Impossibile caricare il file, riprovare più tardi";
                }
                
                _trackBean.timestampFine = new Date().toISOString();
                _trackBean.esito = 'Ko';
                TrackingGUI.tracking(_trackBean);
                
                $scope.csvFile = "";
                $scope.fileName = "";
            }, function (evt) {
                file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
            });

            file.upload.xhr(function (xhr) {
                $log.debug(xhr);
            });
        }

        $scope.getReqParams = function () {
            return $scope.generateErrorOnServer ? '?errorCode=' + $scope.serverErrorCode +
            '&errorMessage=' + $scope.serverErrorMsg : '';
        };

    }]);
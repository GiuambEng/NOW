timnow
    .controller('uploadFile', ['$scope', '$state', '$rootScope', 'BASEPATH', '$log', '$http', '$timeout', '$compile', 'Upload', 'modalService', 'IDsrolo', 'TRACKING_GUI', 'TrackingGUI',
    	function ($scope, $state, $rootScope, BASEPATH, $log, $http, $timeout, $compile, Upload, modalService, IDsrolo, TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.conn = $rootScope.timnowConfigData.config;
        $scope.checkOlo = false;
        $scope.usingFlash = FileAPI && FileAPI.upload !== null;
        $scope.changeAngularVersion = function () {
            window.location.hash = $scope.angularVersion;
            window.location.reload(true);
        };
        $scope.angularVersion = window.location.hash.length > 1 ? (window.location.hash.indexOf('/') === 1 ?
            window.location.hash.substring(2) : window.location.hash.substring(1)) : '1.2.24';

        $scope.invalidFiles = [];

        $scope.$watch('files', function (files) {
            $log.info("Inside watch");
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

        var checkOlo = IDsrolo.get({noDiffida: true});
        checkOlo.$promise.then(function (response) {
                $scope.elencoCodiciAgcom = response.data;
                $scope.checkOlo = true;
            },
            function (error) {
                $scope.errorDate = true;
                $log.debug(error);
            });

        $scope.uploadPic = function (file, codiceAgcomScelto) {
            if (file) {
                if (codiceAgcomScelto){
                	$scope.codiceAgcomScelto = codiceAgcomScelto;
                }
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
            
            //RU_1010
            //Tracking da GUI per operazione UPLOAD                  
          			
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			descrizioneFunzione: 'File e Notifiche|Upload File Ordini e Richieste',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: file.name || null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.UPLOAD.descrizione,
	    			parametriOperazione: null	
            };

            $scope.fileName = file.name;
            file.upload = Upload.upload({
                url: BASEPATH + 'files/order_request' + $scope.getReqParams(),
                resumeSizeUrl: resumable ? BASEPATH + 'files/order_request?name=' + encodeURIComponent(file.name) : null,
                resumeChunkSize: resumable ? $scope.chunkSize : null,
                data: {
                    file: file,
                    codAgcom: $scope.codiceAgcomScelto ? $scope.codiceAgcomScelto : null
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
                
                $scope.xmlFile = "";
                $scope.fileName = "";
            }, function (evt) {
                file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
            });

            file.upload.xhr(function (xhr) {
                $log.debug(xhr);
            });
        }

        $scope.success_action_redirect = $scope.success_action_redirect || window.location.protocol + '//' + window.location.host;
        $scope.jsonPolicy = $scope.jsonPolicy || '{\n  "expiration": "2020-01-01T00:00:00Z",\n  "conditions": [\n    {"bucket": "angular-file-upload"},\n    ["starts-with", "$key", ""],\n    {"acl": "private"},\n    ["starts-with", "$Content-Type", ""],\n    ["starts-with", "$filename", ""],\n    ["content-length-range", 0, 524288000]\n  ]\n}';
        $scope.acl = $scope.acl || 'private';

        $scope.confirm = function () {
            return confirm('Are you sure? Your local changes will be lost.');
        };

        $scope.getReqParams = function () {
            return $scope.generateErrorOnServer ? '?errorCode=' + $scope.serverErrorCode +
            '&errorMessage=' + $scope.serverErrorMsg : '';
        };
    }]);
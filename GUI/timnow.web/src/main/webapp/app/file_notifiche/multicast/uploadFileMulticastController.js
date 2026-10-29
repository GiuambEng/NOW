//RU_1180
timnow
    .controller('uploadFileMulticast', ['$scope', '$state', '$rootScope', 'BASEPATH', '$log', '$timeout', 'Upload', 'modalService', 'IDsrolo', 'TRACKING_GUI', 'TrackingGUI', 'Multicast', '_verificaContrattoMulticast', '_codOloAgcom',
    	function ($scope, $state, $rootScope, BASEPATH, $log, $timeout, Upload, modalService, IDsrolo, TRACKING_GUI, TrackingGUI, Multicast, _verificaContrattoMulticast, _codOloAgcom)  {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.checkOlo = false;

        $scope.invalidFiles = [];
        
        $scope.isDGUser = $rootScope.isDGUser();
        $scope.showSelectFile = false;
        $scope.idContratto = null;
                
        $scope.init = function(){
        	//SM_10214
        	//SM_11045        	
        	if($rootScope.isAllOLOUser()){
            	if(_verificaContrattoMulticast){
            		if(_verificaContrattoMulticast.outputVerificaContrattoMulticast && _verificaContrattoMulticast.outputVerificaContrattoMulticast.esito == 'OK'){
            			$scope.idContratto = _verificaContrattoMulticast.outputVerificaContrattoMulticast.idContratto;
            		}else{
            			modalService.alertOkMessage("L'OLO " + _codOloAgcom + " non ha un contratto attivo abilitato al Multicast");
            			$state.go('root.homepage');
            			return;
            		}
            	}else{
            		modalService.alertOkMessage("Impossibile verificare l'abilitazione Multicast per l'OLO");
            		$state.go('root.homepage');
            		return;
            	} 	
        	}
        	
        	IDsrolo.get({noDiffida: true}).$promise
    		.then(function (response) {
                $scope.elencoCodiciAgcom = response.data;
                $scope.checkOlo = true;
            },
            function (error) {
                $scope.errorDate = true;
                $log.debug(error);
                $scope.showSelectFile = false;
            });        	
        }
        
        $scope.init();
        

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



        $scope.uploadFile = function (file, codiceAgcomScelto) {
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

            var _codiceAgcom = JSON.parse($scope.agcomSelezionato);
          			
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			descrizioneFunzione: 'File e Notifiche|Upload File Multicast',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: file.name || null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.UPLOAD.descrizione,
	    			parametriOperazione: null	
            };

            $scope.fileName = file.name;
            file.upload = Upload.upload({
                url: BASEPATH + 'multicast/upload' + $scope.getReqParams(),
                resumeSizeUrl: resumable ? BASEPATH + 'multicast/upload?name=' + encodeURIComponent(file.name) : null,
                resumeChunkSize: resumable ? $scope.chunkSize : null,
                data: {
                    file: file,
                    codAgcom: _codiceAgcom.codiceOLO ? _codiceAgcom.codiceOLO : null,
                    codNumericoAgcom: _codiceAgcom.codiceOLONumerico,
                    idContratto: $scope.idContratto		
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
        
        $scope.$watch('agcomSelezionato', function(newValue, oldValue){
        	if(newValue){
        		if($scope.isDGUser){
        			
        			var _newValue = JSON.parse(newValue);
        			
            		$scope.showSelectFile = false;
            		$scope.idContratto = null;
            		$scope.csvFile = null;
        			
					Multicast.verificaContrattoMulticast.get({codOloAgcom: _newValue.codiceOLO}).$promise
					.then(function(response){
						if(response && response.outputVerificaContrattoMulticast && response.outputVerificaContrattoMulticast.esito == 'OK'){
			        		$scope.showSelectFile = true;
			        		$scope.idContratto = response.outputVerificaContrattoMulticast.idContratto;
						}else{
			                  modalService.alertOkMessage("L'OLO " + _newValue.codiceOLO + " non ha un contratto attivo abilitato al Multicast");
						}
					}, function(error){
						modalService.alertOkMessage("Impossibile verificare l'abilitazione Multicast per l'OLO");
					});		
        		}else{
        			$scope.showSelectFile = true;
        		}
        	}
        })
    }]);
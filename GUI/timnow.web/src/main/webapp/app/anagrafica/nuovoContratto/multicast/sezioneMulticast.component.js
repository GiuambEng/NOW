//RU_1180
timnow.component('sezioneMulticast', {
	templateUrl: 'app/anagrafica/nuovoContratto/multicast/sezioneMulticast.component.html',
	bindings:{
		data: '=',
		fileNamingConvention: '<'
	},
	replace: true,
	require: {
		form: '^form'
	},
	controller: ['$rootScope', '$timeout','Upload', 'BASEPATH', 'TRACKING_GUI', 'TrackingGUI', 
		function($rootScope, $timeout, Upload, BASEPATH, TRACKING_GUI, TrackingGUI){		
		
		var vm = this;
		
		vm.chunkSize = 100000;
		
		vm.regexBouquet = /^[0-9]{3}$/
		
		vm.$onInit = function(){
			//Se il nome bouquet esiste, disabilitare il relativo campo GUI
			vm.disableBouquet = (vm.data.bouquet && vm.data.bouquet != '');
			
			//Verifica se in input al componente c'è una espressione regolare per il nome del file
			try{
				if(vm.fileNamingConvention){				
					vm.fileNameRegex= new RegExp(vm.fileNamingConvention);
					vm.checkFileName = true;
				}else{
					vm.checkFileName = false;
					vm.fileNameRegex = null;
				}
			}catch(e){
				vm.checkFileName = false;
				vm.fileNameRegex = null;
			}
			
		}
		
		/*--- GESTIONE UPLOAD FILE CSV ---*/
		
		vm.files = [];
		
        vm.onChangeFile = function(files) {
        	vm.errorMsg = null;
            if (typeof files === "undefined") {
                return;
            }
            
            if(vm.checkFileName && !vm.fileNameRegex.test(vm.csvFile.name)){
            	vm.errorMsg = " Il nome " + vm.csvFile.name + " non rispetta la naming convention condivisa!";
            	return;
            }

            if (files !== null) {
                if (!angular.isArray(files)) {
                    $timeout(function () {
                        vm.files = files = [files];
                    });
                    return;
                }

                for (var i = 0; i < files.length; i++) {
                    vm.errorMsg = null;
                    (vm.extractedFunction(f))(files[i]);
                }
            }
        }
        
        vm.extractedFunction = function(f) {
            vm.upload(f, true);
        }

        vm.uploadFile = function (file) {
          	if (file != null && !file.progress) {
                vm.upload(file);
            }
        };

        vm.upload = function (file, resumable) {
            vm.uploadingFile = true;
            vm.uploadUsingUpload(file, resumable);
        };

        vm.onFileSelect = function (file) {
            if (file && file[0]) {
                vm.fileName = file[0].name;
            }
        };

        vm.chunkSize = 100000;
        vm.uploadUsingUpload = function(file, resumable) {   
        	 vm.uploadingFile = true;
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			descrizioneFunzione: 'Modifica Contratto|Upload File Multicast',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: file.name || null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.UPLOAD.descrizione,
	    			parametriOperazione: null	
            };

            vm.fileName = file.name;
            Upload.upload({
                url: BASEPATH + 'contracts/uploadFileMulticast' + vm.getReqParams(),
                resumeSizeUrl: resumable ? BASEPATH + 'contracts/uploadFileMulticast?name=' + encodeURIComponent(file.name) : null,
                resumeChunkSize: resumable ? vm.chunkSize : null,
                data: {
                    file: file,
                    idContratto: vm.data.idContratto ? vm.data.idContratto : null
                }
            }).then(function (response) {
                vm.uploadingFile = false;
                file.result = response.data;
                vm.fileName = "";
                
                _trackBean.timestampFine = new Date().toISOString();
                _trackBean.esito = 'Ok';
                TrackingGUI.tracking(_trackBean);  
            }, function (response) {
                vm.uploadingFile = false;
                if (response.data.result && parseInt(response.data.result.code) < 0) {
                    vm.errorMsg = response.data.result.description;
                } else {
                    vm.errorMsg = "Impossibile caricare il file, riprovare più tardi";
                }
                
                _trackBean.timestampFine = new Date().toISOString();
                _trackBean.esito = 'Ko';
                TrackingGUI.tracking(_trackBean);
                
                vm.csvFile = "";
                vm.fileName = "";
            }, function (evt) {
                file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
            });

            /*file.upload.xhr(function (xhr) {
                console.debug(xhr);
            });*/
        }

        vm.getReqParams = function () {
            return vm.generateErrorOnServer ? '?errorCode=' + vm.serverErrorCode +
            '&errorMessage=' + vm.serverErrorMsg : '';
        }
        
        vm.downloadFiliEsiti = function(){
            var url = "contracts/downloadEsiti?idFile=" + $scope.data.idFile + '&fileName=' + $scope.data.fileName;
            $window.open(url);
        }
						
	}]
})
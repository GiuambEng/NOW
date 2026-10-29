//RU_1180
timnow.directive('sezioneFileComuniCoinvestiti', function(){
	return {
		templateUrl: 'app/anagrafica/contratto/common/sezioneFileComuniCoinvestiti/sezioneFileComuniCoinvestiti.component.html',		
		scope:{
			isEdit: '=',
			data: '=',
			form:'=',
			showOnlyList: '=',
			useBroadcastForUpload: '=',
			fileToUpload: '='
		},
		restrict: 'E',
		require:{
			form: '^?form'
		},
        link: function ($scope, $elm, $attr) {
            $scope.$watch("listaFiles", function (newValue, oldValue) {
            	if(newValue && newValue.length > 0){
            		$scope.$broadcast('nowTable.refreshData', newValue);
            	}				
            });
        },
		controller: ['$scope', '$rootScope', '$timeout','Upload', 'BASEPATH', 'TRACKING_GUI', 'TrackingGUI', 'ListaFileComuniCoinvestiti', 'modalService', '_',
			function($scope, $rootScope, $timeout, Upload, BASEPATH, TRACKING_GUI, TrackingGUI, ListaFileComuniCoinvestiti, modalService, _){		
				
			$scope.chunkSize = 100000;
			
			$scope.fileNamingConvention = /[A-Z0-9]{3}_(SEMIVULA|SEMIBTSNGA|SEMIEIPNGA)_[0-9]{4}[0-9]{2}[0-9]{2}_[0-9]{2}.csv/gm;
			
			$scope.arrayNomiOfferte = ['SEMIVULA', 'SEMIBTSNGA', 'SEMIEIPNGA'];
			
			$scope.data.fileToUpload = {};
			
			$scope.headersListaFile = [];
			//SM_10739
			$scope.headersListaFile.push(
	        		{"key": "nomeFile", "value": "Nome File", "type": "text"},
	        		{"key": "dataInserimento", "value": "Inserimento File", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
	        		{"key": "dataAggiornamento", "value": "Ultimo Aggiornamento", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
	        		{"key": "statoElaborazione", "value": "Stato Elaborazione", "type": "text"},
	        		{"key": "offerta", "value": "Offerta", "type": "text"},
	        		{"key": "oao", "value": "OAO", "type": "text"},
	                {"key": "tipologiaTracciato", "value": "Tipologia Tracciato", "type": "text"},
	                {"key": "idFile", "type": "comuniCoinvestimentoFile"},
	                {"key": "idFile", "type": "esitoComuniCoinvestimentoFile"});
					
			
			$scope.listaFiles = [];
			
			$scope.init = function(){
				
				$scope.setNomeOfferta();
				
				//Se si tratta di  una modifica contratto, richiamare il servizio di lista file caricati
				if($scope.isEdit || $scope.showOnlyList){
					$scope.loadListaFileComuniCoinvestiti();
				}
				
				//Verifica se in input al componente c'è una espressione regolare per il nome del file
				try{
					if($scope.fileNamingConvention){				
						$scope.fileNameRegex= new RegExp($scope.fileNamingConvention);
						$scope.checkFileName = true;
					}else{
						$scope.checkFileName = false;
						$scope.fileNameRegex = null;
					}
				}catch(e){
					$scope.checkFileName = false;
					$scope.fileNameRegex = null;
				}			
			}
			
			/*--- INIZIO GESTIONE UPLOAD FILE CSV ---*/
			
			$scope.files = [];
			
	        $scope.onChangeFile = function(files) {
	        	$scope.errorMsg = null;
	            if (!files) {
					$scope.data.fileToUpload = {};
	                return;
	            }
	            
	            if($scope.checkFileName && !$scope.fileNameRegex.test(files.name)){
	            	$scope.errorMsg = " Il nome " + files.name + " non rispetta la naming convention condivisa!";
	            	$scope.form.file.$setValidity("required", false);	            	
	            	return;
	            }else{
	            	$scope.errorMsg = null;
	            	$scope.form.file.$setValidity("required", true);	 
	            }

	            if (files !== null) {
	            	$scope.data.fileToUpload = files;
	            	
	                if (!angular.isArray(files)) {
	                    $timeout(function () {
							$scope.data.fileToUpload = [files];
	                        $scope.files = files = [files];
	                        
	                    });
	                    return;
	                }

	                for (var i = 0; i < files.length; i++) {
	                    $scope.errorMsg = null;
	                    ($scope.extractedFunction(f))(files[i]);
	                }
	            }
	        }
	        
	        $scope.extractedFunction = function(f) {
	            $scope.upload(f, true);
	        }
	        
	        $scope.uploadFileFromBroadcast = function(){
	        	if($scope.data.fileToUpload){
					if(_.isArray($scope.data.fileToUpload)){
						$scope.upload($scope.data.fileToUpload[0]);
					}else{
						$scope.upload($scope.data.fileToUpload);	
					}        		
	        	}else{
	        		 $scope.$emit("endFileUploadSuccess", null);
	        	}
	        }

	        $scope.uploadFile = function (file) {	        		        	
	          	if (file != null && !file.progress) {
	                $scope.upload(file);
	            }
	        };

	        $scope.upload = function (file, resumable) {
	            $scope.uploadingFile = true;
	            $scope.uploadUsingUpload(file, resumable);
	        };

	        $scope.onFileSelect = function (file) {
	            if (file && file[0]) {
	                $scope.fileName = file[0].name;
	            }
	        };

	        $scope.chunkSize = 100000;
	        $scope.uploadUsingUpload = function(file, resumable) {   
	        	 $scope.uploadingFile = true;
	            var _trackBean = {
		    			timestampInizio: new Date().toISOString(),
		    			descrizioneFunzione: ($scope.isEdit ? 'Modifica Contratto' : 'Nuovo Contratto') +' | Upload File Comuni Coinvestimento',
		    			numeroDatiEsportati: 0,
		    			contenutoFile: null,
		    			nomeFile: file.name || null,
		    			tipoOperazione: TRACKING_GUI.EVENTI.UPLOAD.descrizione,
		    			parametriOperazione: null	
	            };

	            $scope.fileName = file.name;
	            
	            Upload.upload({
	                url: BASEPATH + 'comuniCoinvestiti/uploadFileComuniCoinvestiti' + $scope.getReqParams(),
	                resumeSizeUrl: resumable ? BASEPATH + 'comuniCoinvestiti/uploadFileComuniCoinvestiti?name=' + encodeURIComponent(file.name) : null,
	                resumeChunkSize: resumable ? $scope.chunkSize : null,
	                data: {
	                    file: file,
	                    codOloAgcom: $scope.data.codOloAgcom ? $scope.data.codOloAgcom : null,
	                    offerta: $scope.offerta ? $scope.offerta  : null,
	                    idContratto: $scope.data.idContratto ? $scope.data.idContratto : null,
	                }
	            }).then(function (response) {
	                $scope.uploadingFile = false;
	                file.result = response.data;
	                $scope.fileName = "";
	                
	                _trackBean.timestampFine = new Date().toISOString();
	                _trackBean.esito = 'Ok';
	                TrackingGUI.tracking(_trackBean);
	                
	                $scope.$emit("endFileUploadSuccess", null);
	                
	            }, function (response) {
	                $scope.uploadingFile = false;
	                if (response.data.result && parseInt(response.data.result.code) < 0) {
	                    $scope.errorMsg = response.data.result.description;
	                } else {
	                    $scope.errorMsg = "Impossibile caricare il file, riprovare più tardi";
	                }
	                
	                $scope.$emit("endFileUploadError", $scope.errorMsg);
	                
	                _trackBean.timestampFine = new Date().toISOString();
	                _trackBean.esito = 'Ko';
	                TrackingGUI.tracking(_trackBean);
	                
	                $scope.csvFile = "";
	                $scope.fileName = "";
	            }, function (evt) {
	                file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
	            });
	        }

	        $scope.getReqParams = function () {
	            return $scope.generateErrorOnServer ? '?errorCode=' + $scope.serverErrorCode + '&errorMessage=' + $scope.serverErrorMsg : '';
	        }
	        
	        /*--- FINE GESTIONE UPLOAD FILE CSV ---*/
						
	        $scope.setNomeOfferta = function(){
	        	$scope.offerta = '';
	        	if($scope.data.offerta){
	        		switch($scope.data.offerta){
	        		case $rootScope.MAP_OFFERTE.SEMI_VULA_H.id:
	        			$scope.offerta = $scope.arrayNomiOfferte[0];
	        			$scope.nomeOfferta = $rootScope.MAP_OFFERTE.SEMI_VULA_H.name;
	        			break;
	        		case $rootScope.MAP_OFFERTE.SEMI_BTS_H.id:
	        			$scope.offerta = $scope.arrayNomiOfferte[1];
	        			$scope.nomeOfferta = $rootScope.MAP_OFFERTE.SEMI_BTS_H.name;
	        			break;
	        		case $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id:
	        			$scope.offerta = $scope.arrayNomiOfferte[2];
	        			$scope.nomeOfferta = $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name;
	        			break;
	        		}
	        	}
	        }
	        
	        $scope.loadListaFileComuniCoinvestiti = function(){
	     	  	$scope.loaderListaFiles = true;
	          	$scope.listaFiles = [];
	          	
				ListaFileComuniCoinvestiti.get({codOloAgcom: $scope.data.codOloAgcom, idContratto: $scope.data.idContratto}).$promise
				.then(function(response){
					$scope.loaderListaFiles = false;
					if(response.result.code == 'OK'){
						if(response.listaFileComuniCoinvestiti && response.listaFileComuniCoinvestiti.length > 0){						
							$scope.listaFiles = _.map(response.listaFileComuniCoinvestiti, function(item){
								item.offerta = $scope.nomeOfferta;
								item.codOloAgcom = $scope.data.codOloAgcom;
								return item;
							});							
						}					
					}else{
						$scope.errorService(response.result.details);
					}
				}, function(error){
					$scope.loaderListaFiles = false;
					$scope.errorService("Impossibile recuperare la lista file");
				})
	        }
	        
	        $scope.aggiornaListaFileComuniCoinvestiti = function($event){
	        	$event.stopPropagation();
	        	$event.preventDefault();
	        	
	        	$scope.loadListaFileComuniCoinvestiti();
	        }
	        
	    	$scope.errorService = function (messageBody) {
	    		modalService.showModal({}, {
	    			headerText: "Avviso",
	    			bodyText: messageBody,
	    			scope: $scope,
	    			type: 'success'
	    		});
	    	}
	    	
		    $scope.$on('startUploadFile', function(event, data){
		        $scope.uploadFileFromBroadcast();
		     })
	    	
	    	$scope.init();
	        
		}]
	}
})
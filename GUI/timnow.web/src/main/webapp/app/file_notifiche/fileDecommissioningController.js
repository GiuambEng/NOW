//RU_1127
timnow
	.controller('fileDecommissioning', ['$scope', '$rootScope', '$state', 'FileState', 'modalService', 'AdvancedSearchGetDati', 'TRACKING_GUI', 'TrackingGUI', 'Decommissioning', '_', '$timeout',
    		function ($scope, $rootScope, $state, FileState, modalService, AdvancedSearchGetDati, TRACKING_GUI, TrackingGUI, Decommissioning, _, $timeout) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        $scope.tipologiaRicerca = 'LISTA FILE INCENTIVI';
        
        $scope.headerList = [];
        $scope.detailList = [];
        $scope.fileDetailsLoaded = false;
        
        $scope.headerList.push(
        		{"key": "nomeFile", "value": "Nome File", "type": "text"},
                {"key": "codificaOao", "value": "Codifica OAO", "type": "text"},               
                {"key": "dataCreazioneFile", "value": "Data Creazione File", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
                {"key": "tipologiaFile", "value": "Tipologia File", "type": "text"},
                {"key": "idFile", "value": "", "type": "file"});
		//RU_1312                
        $scope.detailList.push(
        		{"key": "idRisorsa", "value": "ID Risorsa", "type": "text"},
                {"key": "clli", "value": "CLLI", "type": "text"},               
                {"key": "dataIn", "value": "Data In", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
                {"key": "dataOut", "value": "Data Out", "type": "data", "pattern": "dd/MM/yyyy HH:mm:ss"},
                {"key": "offerta", "value": "Offerta", "type": "text"},
                {"key": "descrizioneErrore", "value": "Descrizione Errore", "type": "text"});
                        
        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }
        
        $scope.init = function() {
            Decommissioning.all.get().$promise
            .then(
                function (data) {
                    if (data.data) $scope.files = data.data;
                    $scope.filesLoaded = true;
                }, function (error) {
                    $scope.filesLoaded = true;
                });
        }
        
        
        /* RICERCA AVANZATA START */

        $scope.getSearchAdvanced = function () {
            $scope.filesLoaded = false;
            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione INSERIMENTO
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'File e Notifiche|Download File Decommissioning',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };

                var files = AdvancedSearchGetDati.save({type: 'decommissioning'}, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                files.$promise.then(
                    function (data) {
                    	
                    	_trackBean.timestampFine = new Date().toISOString();
                    	
                        if (data.result.code < 0) {
                            modalService.alertSearchError();
                            
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                            
                            return false;
                        }
                        if (data.data){
                        	$scope.files = data.data;
                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        }
                        $scope.filesLoaded = true;
                    }, function (error) {
                        modalService.alertSearchError();
                        $scope.filesLoaded = true;
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
                $scope.init();
            }
        };
        /* RICERCA AVANZATA END */
        
        //RU_1312
        $scope.fileDetails = function(item){	
	
			//SM_10808
			if(['File CLLI Incentivo Switch OFF', 'File Risorse OAO Incentivo'].indexOf(item.tipologiaFile) > -1){				
				$scope.fileDetailsLoaded = true;
				
				$timeout(function(){
					$scope.fileDetailsLoaded = false;
				}, 1000);
				
				//TODO: SM_10838 disabilitata momentaneamente la chiamata al servizio di dettaglio file				
				/*
				Decommissioning.fileDetails.get({idFile: item.idFile, tipologiaFile: item.tipologiaFile})
				.$promise
				.then(function(response){
					$scope.fileDetailsLoaded = false;
					var _index = _.findIndex($scope.files, {idFile: item.idFile});
					if(_index > -1){
						_.extend($scope.files[_index], response);
					}				
				}, function(error){
					$scope.fileDetailsLoaded = false;
					console.error(error);
				});*/
			}else{
				item.collapse = false;
			}		
		};
                
        $scope.init();
}]);
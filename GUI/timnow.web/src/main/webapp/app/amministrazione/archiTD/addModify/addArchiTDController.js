timnow
    .controller('amministrazioneAddArchiTD', ['$scope', '$state', '$rootScope', '$log', 'archiTD', '$uibModal','alertService','$filter','TRACKING_GUI', 'TrackingGUI',
    	function ($scope, $state, $rootScope, $log, archiTD, $uibModal, alertService,$filter, TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.current.params.pageClass;
        $scope.tipologia = $state.current.params.tipologia;
        $scope.insertArcoTD = false;
        
        //solo singola lista
        $scope.detailList = [
                 			{"key": "tdParziale", "value": "TD parziale", "type": "text_disabled", "required": true},
                 			{"key": "tdCurrent", "value": "TD Current", "type": "text_disabled", "required": false},
                 			{"key": "tdMin", "value": "TD min", "type": "text_disabled", "required": false},
                 			{"key": "tdMax", "value": "TD max", "type": "text_disabled", "required": false},
                 			{"key": "inizioValidita", "value": "Inizio validità", "type": "text_disabled", "required": false},
                 			{"key": "fineValidita", "value": "Fine validità", "type": "text_disabled", "required": false},
                 			{"key": "activeFlag", "value": "Active_Flag", "type": "checkbox_disabled", "required": false},
                 			{"key": "operatore", "value": "Operatore", "type": "text_disabled", "required": false}
                         ];
        
        if($state.params.archiTD){
        	$scope.action="UPDATE";
        	$scope.archiTD = $state.params.archiTD;
        	if($scope.archiTD.activeFlag){
        		$scope.detailList[5].type="date";
        		$scope.archiTD.fineValidita=new Date($scope.archiTD.fineValidita);
        	}
        	$scope.archiTD.operatore=$rootScope.timnowConfigData.user.userId;
        }else{
        	$scope.action="INSERT";
        	$scope.detailList[0].type="text";
        	var dataOggi=new Date();
        	var data=dataOggi.getDate() +"/"+(dataOggi.getMonth()+1 )+"/"+dataOggi.getFullYear();
        	$scope.archiTD={
					"tdCurrent":0,
					"tdMin":0,
					"tdMax":99,
					"inizioValidita":data,
					"fineValidita":"31/12/2099",
					"activeFlag":true,
					"operatore":$rootScope.timnowConfigData.user.userId
        	}
        }

        $scope.addItem = function () {
            $log.info("add - modifica");
            
            //RU_1010
            //Tracking da GUI per operazione INSERIMENTO
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Amministrazione|Gestione archi TD',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
            };
            
            if ($scope.action==="UPDATE") {
            	if($scope.detailList[6].valore){
            		$scope.insertArcoTD = true;
            		archiTD.mod_archiTD({},{
                		"action":$scope.action,
                        "tdParziale":  $scope.detailList[0].valore,
                        "tdCurrent":  $scope.detailList[1].valore,
                        "tdMin":  $scope.detailList[2].valore,
                        "tdMax":  $scope.detailList[3].valore,
                        "inizioValidita":  $filter('date')($scope.detailList[4].valore, 'dd/MM/yyyy'),
                        "fineValidita":  $filter('date')($scope.detailList[5].valore, 'dd/MM/yyyy'),
                        "activeFlag":  $scope.detailList[6].valore
                    },
                    function (response) {
                    	$scope.insertArcoTD = false;
                        $log.info("aggiunto:"+response);
                        openRes("Arco TD Modificato con successo");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ok';
                        
                        TrackingGUI.tracking(_trackBean);
                    },
                    function (error) {
                    	$scope.insertArcoTD = false;
                        $log.debug("errore:"+error);
                        alertService.add("Arco TD non modificato","danger",15000);
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';
                        TrackingGUI.tracking(_trackBean);
                    });
            	}else{
            		alertService.add("L'arco TD non può essere modificato","danger",15000);
            	}
            	
                
            } else {
            	if($scope.detailList[0].valore.length>6){
            		alertService.add("la lunghezza del campo TD Parziale non deve superare i 6 caratteri","danger",15000);
            	}else if(isNaN($scope.detailList[0].valore)){
            		alertService.add("Il campo TD Parziale deve contenere solo numeri","danger",15000);
            	}else{
            		$scope.insertArcoTD = true;
            		archiTD.add_archiTD({},{
                		"action":$scope.action,
                        "tdParziale":  $scope.detailList[0].valore,
                        "tdCurrent":  $scope.detailList[1].valore,
                        "tdMin":  $scope.detailList[2].valore,
                        "tdMax":  $scope.detailList[3].valore,
                        "inizioValidita":  $filter('date')($scope.detailList[4].valore, 'dd/MM/yyyy'),
                        "fineValidita":  $filter('date')($scope.detailList[5].valore, 'dd/MM/yyyy'),
                        "activeFlag":  $scope.detailList[6].valore
                    },
                        function (response) {
                    		$scope.insertArcoTD = false;
                            $log.info("aggiunto:"+response);
                            openRes("Arco TD aggiunto con successo");
                            
                            _trackBean.timestampFine = new Date().toISOString();
                            _trackBean.esito = 'Ok';
                        },
                        function (error) {
                        	$scope.insertArcoTD = false;
                            $log.debug("errore:"+error);
                            alertService.add("Arco TD non inserito","danger",15000);
                            
                            _trackBean.timestampFine = new Date().toISOString();
                            _trackBean.esito = 'Ko';
                        });
            	}
            }
        };

        function openRes(val) {
            $scope.items = val;
            $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: 'app/common/edit_delete_now_table/risultatoAddMod.html',
                controller: 'ModalArcoTD',
                resolve: {
                    items: function () {
                        return $scope.items;
                    },
                    title: function () {
                    }
                }
            });
        }
    }])
    .controller('ModalArcoTD', ['$scope', '$uibModalInstance', 'items', 'title', '$state', function ($scope, $uibModalInstance, items, title, $state) {
        $scope.items = items;
        $scope.title = title;

        $scope.cancel = function () {
        	$state.go('^');
            $uibModalInstance.dismiss('cancel');
        };
    }]);
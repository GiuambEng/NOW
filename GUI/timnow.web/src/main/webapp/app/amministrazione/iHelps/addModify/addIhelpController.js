timnow
    .controller('AddIhelp', ['$scope', '$state', '$rootScope', '$log', 'iHelps', '$uibModal', 'modalService','TRACKING_GUI', 'TrackingGUI',
    	function ($scope, $state, $rootScope, $log, iHelps, $uibModal, modalService,TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = $state.current.params.pageClass;
        $scope.tipologia = $state.current.params.tipologia;

        //solo singola lista
        $scope.ihelp = $state.params.ihelp;
        $scope.ambiti = [];
        $scope.detailList = [
            {
                "key": "ambito",
                "value": "Ambito",
                "type": "select",
                "required": true,
                "valuesList": $rootScope.listaAmbiti
            },
            {"key": "titolo", "value": "Titolo", "type": "text", "required": true},
            {"key": "visibile", "value": "Visibile", "type": "checkbox", "required": false, "default": true},
            {"key": "contenuto", "value": "Contenuto", "type": "textarea", "required": true},
            {"key": "note", "value": "Note", "type": "textarea", "required": false}
        ];

        if (!$rootScope.listaAmbiti || $rootScope.listaAmbiti.length === 0) {
            modalService.showModal({}, {
                headerText: "Errore",
                bodyText: "Impossibile caricare la lista ambiti.",
                actionButtonText: 'Chiudi',
                type: 'warning'
            });
        }

        $scope.addItem = function () {
            $log.info("add - modifica");
            $log.debug($scope.detailList);
            
            //RU_1010
            //Tracking da GUI per operazione INSERIMENTO
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Amministrazione|iHelp',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
            };
            
            if ($scope.ihelp !== "") {
                iHelps.helpMod({"idIHelp": $scope.ihelp.idIHelp},
                    {
                        "ambito": $scope.detailList[0].valore,
                        "titolo": $scope.detailList[1].valore,
                        "visibile": $scope.detailList[2].valore,
                        "idIHelp": $scope.ihelp.idIHelp,
                        "contenuto": $scope.detailList[3].valore,
                        "note": $scope.detailList[4].valore,
                    },
                    function (response) {
                        $log.info("modificato");
                        openRes("iHelp modificata con successo");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ok';
                        TrackingGUI.tracking(_trackBean);
                    },
                    function (error) {
                        $log.debug("errore");
                        openRes("iHelp non modificata");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
                iHelps.helpAdd({
                        "ambito": $scope.detailList[0].valore,
                        "titolo": $scope.detailList[1].valore,
                        "visibile": $scope.detailList[2].valore,
                        "contenuto": $scope.detailList[3].valore,
                        "note": $scope.detailList[4].valore,
                    },
                    function (response) {
                        $log.info("aggiunto");
                        openRes("iHelp aggiunta con successo");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ok';
                        TrackingGUI.tracking(_trackBean);
                    },
                    function (error) {
                        $log.debug("errore");
                        openRes("iHelp non inserita");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';
                        TrackingGUI.tracking(_trackBean);
                    });
            }

        };

        function openRes(val) {
            $scope.items = val;
            $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: 'app/common/edit_delete_now_table/risultatoAddMod.html',
                controller: 'Modalhelp',
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
    .controller('Modalhelp', ['$scope', '$uibModalInstance', 'items', 'title', '$state', function ($scope, $uibModalInstance, items, title, $state) {
        $scope.items = items;
        $scope.title = title;

        $scope.cancel = function () {
            $state.go('root.amministrazione.ihelp');
            $uibModalInstance.dismiss('cancel');
        };
    }]);
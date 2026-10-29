timnow
    .controller('amministrazioneAddFaq', ['$scope', '$state', '$rootScope', '$log', 'Faq', '$uibModal','TRACKING_GUI', 'TrackingGUI',
    	function ($scope, $state, $rootScope, $log, Faq, $uibModal, TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.current.params.pageClass;
        $scope.tipologia = $state.current.params.tipologia;
        //solo singola lista
        $scope.faq = $state.params.faq;

        $scope.detailList = [
            {"key": "question", "value": "Domanda", "type": "textarea", "required": true},
            {"key": "answer", "value": "Risposta", "type": "textarea", "required": true},
            {"key": "note", "value": "Note", "type": "textarea", "required": false},
            {"key": "visible", "value": "Visibile", "type": "checkbox", "required": false, "default": true}
        ];

        $scope.addItem = function () {
            $log.info("add - modifica");
            
            //RU_1010
            //Tracking da GUI per operazione INSERIMENTO
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Amministrazione|FAQ',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
            };
            
           	if ($scope.faq && $scope.faq !== "") {
                Faq.mod_faqs({
                        "idFaq": $scope.faq.idFaq,
                        "question": $scope.detailList[0].valore,
                        "answer": $scope.detailList[1].valore,
                        "note": $scope.detailList[2].valore,
                        "visible": $scope.detailList[3].valore,
                        "operationType": "UPDATE"
                    },
                    function (response) {
                        $log.info("aggiunto");
                        openRes("FAQ Modificata con successo");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ok';
                        TrackingGUI.tracking(_trackBean);
                    },
                    function (error) {
                        $log.debug("errore");
                        openRes("FAQ non modificata");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';
                        TrackingGUI.tracking(_trackBean);
                    });
            } else {
                Faq.add_faqs({
                        "question": $scope.detailList[0].valore,
                        "answer": $scope.detailList[1].valore,
                        "note": $scope.detailList[2].valore,
                        "visible": $scope.detailList[3].valore,
                        "operationType": "CREATE"
                    },
                    function (response) {
                        $log.info("aggiunto");
                        openRes("FAQ aggiunta con successo");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ok';
                    },
                    function (error) {
                        $log.debug("errore");
                        openRes("FAQ non inserita");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';
                    });

            }
        };

        function openRes(val) {
            $scope.items = val;
            $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: 'app/common/edit_delete_now_table/risultatoAddMod.html',
                controller: 'Modalfaq',
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
    .controller('Modalfaq', ['$scope', '$uibModalInstance', 'items', 'title', '$state', function ($scope, $uibModalInstance, items, title, $state) {
        $scope.items = items;
        $scope.title = title;

        $scope.cancel = function () {
            $state.go('root.amministrazione.faq');
            $uibModalInstance.dismiss('cancel');
        };
    }]);
timnow
    .controller('AddNews', ['$scope', '$state', '$rootScope', '$log', 'News', '$uibModal','TRACKING_GUI', 'TrackingGUI',
    	function ($scope, $state, $rootScope, $log, News, $uibModal,TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.current.params.pageClass;
        $scope.tipologia = $state.current.params.tipologia;

        //solo singola lista
        $scope.news = $state.params.news;

        $scope.detailList = [
            {"key": "title", "value": "Titolo", "type": "text", "required": true},
            {"key": "visible", "value": "Visibile", "type": "checkbox", "required": false, "default": true},
            {"key": "content", "value": "Contenuto", "type": "textarea", "required": true},
            {"key": "note", "value": "Note", "type": "textarea", "required": false}
        ];

        $scope.addItem = function () {
            $log.debug($scope.news);
            
            //RU_1010
            //Tracking da GUI per operazione INSERIMENTO
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Amministrazione|News e Informative Migrazione',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
            };
            
            /* SE MODIFICA */
            if ($scope.news !== "") {

                News.mod_news({
                        "title": $scope.detailList[0].valore,
                        "visible": $scope.detailList[1].valore,
                        "idNews": $scope.news.idNews,
                        "content": $scope.detailList[2].valore,
                        "note": $scope.detailList[3].valore,
                        "operationType" : "UPDATE"
                    },
                    function (response) {
                        $log.info("aggiunto");
                        openRes("News modificata successo");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ok';
                        TrackingGUI.tracking(_trackBean);
                    },
                    function (error) {
                        $log.debug("errore");
                        openRes("News non modificata");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';
                        TrackingGUI.tracking(_trackBean);
                    });
            } else { /* SE E' NUOVO */

                var newsData = {
                    "title": $scope.detailList[0].valore,
                    "visible": $scope.detailList[1].valore,
                    "content": $scope.detailList[2].valore,
                    "note": $scope.detailList[3].valore,
                    "operationType" : "CREATE"
                };

                $log.info(newsData);                
	            
                News.save(newsData, function (response) {
                        $log.info("aggiunto");
                        openRes("News aggiunta con successo");
                        
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ok';
                        TrackingGUI.tracking(_trackBean);
                    },
                    function (error) {
                        $log.debug("errore");                        
                        openRes("News non inserita");
                        
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
                controller: 'ModalNews',
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
    .controller('ModalNews', ['$scope', '$uibModalInstance', 'items', 'title', '$state', function ($scope, $uibModalInstance, items, title, $state) {

        $scope.items = items;
        $scope.title = title;

        $scope.cancel = function () {
            $state.go('root.amministrazione.News');
            $uibModalInstance.dismiss('cancel');
        };
    }]);
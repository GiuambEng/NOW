timnow.controller( 'listaCausaliRimod', ['$scope', '$state', '$rootScope', 'CausaliRimodulazioni', '$uibModal', '$log', 'modalService', 'TRACKING_GUI', 'TrackingGUI',
                                 function($scope, $state, $rootScope, CausaliRimodulazioni, $uibModal, $log, modalService, TRACKING_GUI, TrackingGUI) {
	

			function init() {
				$scope.totaleY = 0;
				$scope.totaleN = 0;
				$scope.causaliSelezionate = [];
				$scope.detailArg = [];
				$scope.inputModificaConfigCausaliRimDelivery = [];
				$scope.disabledAddFlag = true;
				
				$rootScope.pageClass = $state.params.pageClass;
				$scope.tipologia = $state.params.tipologia;

				$scope.causaliRimodulazioni = {};
				$scope.recordSelezionato = {};
				$scope.causaliRimodulazioniLoaded = false;

				$scope.headerListY = [ {
					"key" : "seleziona",
					"value" : "Seleziona",
					"type" : "selectable"
				}, {
					"key" : "codiceCausale",
					"value" : "Codice Causale",
					"type" : "text"
				}, {
					"key" : "descrizioneCausale",
					"value" : "Descrizione Causale",
					"type" : "text"
				} ];

				$scope.caricaTutteLeCausali();
			}
			
			$scope.caricaTutteLeCausali = function(){
				$scope.caricaCausali("selezionate");
				$scope.caricaCausali("DaSelezionare");
			};

			$scope.caricaCausali = function(tipo) {
				$scope.causaliRimodulazioniLoaded = false;
				var valoreFlagEsplicita = tipo === "selezionate" ? "Y" : "S"; // selezionate o daSelezionare
				
				function successCallback(response) {
					if (response.data)
						$scope.causaliRimodulazioni[tipo] = response.data;
					if (!$scope.causaliRimodulazioni[tipo]) {
						$scope.errorDate = true;
					}
					$scope.causaliRimodulazioniLoaded = true;

					if (valoreFlagEsplicita === "Y") {
						$scope.totaleY = $scope.causaliRimodulazioni["selezionate"].length;
						$scope.abilitaAdd();
					} else {
						$scope.totaleN = $scope.causaliRimodulazioni["DaSelezionare"].length;
					}
				}

				function errorCallback(error) {
					$scope.errorDate = true;
					$scope.causaliRimodulazioniLoaded = true;
				}

				CausaliRimodulazioni.get({flagEsplicita : valoreFlagEsplicita, operation : "lista"}).$promise.then(successCallback, errorCallback);
			};
			
			$scope.abilitaAdd = function() {
				$scope.disabledAddFlag = $scope.totaleY>=5;
			};

			$scope.addItem = function($event) {

				$scope.headerListN = [ {
					"key" : "codiceCausale",
					"value" : "Codice Causale",
					"type" : "text"
				}, {
					"key" : "descrizioneCausale",
					"value" : "Descrizione Causale",
					"type" : "text"
				} ];

				$scope.modalOptionsTabellaDati = {
					headerText : 'Seleziona una causale',
					actionButtonText : null,
					closeButtonText : 'Ok',
					contentType : 'modale_nowtable',
					scope : $scope,
					callbackFunction : 'listaCausaliCallback',
					dataHeader : $scope.headerListN,
					templateUrl : 'app/common/templates.html',
					data : $scope.causaliRimodulazioni["DaSelezionare"]
				};

				modalService.showModal( {}, $scope.modalOptionsTabellaDati);
			};

			$scope.listaCausaliCallback = function(item) {
				$scope.causaliRimodulazioniLoaded = false;
				$scope.inputModificaConfigCausaliRimDelivery = [];
				$scope.inputModificaConfigCausaliRimDelivery.push(item);
				
				//RU_1010
	            //Tracking da GUI per operazione INSERIMENTO
	            var _trackBean = {
		    			timestampInizio: new Date().toISOString(),
		    			timestampFine: null,
		    			descrizioneFunzione: 'Amministrazione|Configura Causali RDAC',
		    			numeroDatiEsportati: 0,
		    			contenutoFile: null,
		    			nomeFile: null,
		    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
		    			parametriOperazione: null 			
	            };
				
				
				CausaliRimodulazioni.mod_item({operation : "modifica"},
					{
						inputModificaConfigCausaliRimDelivery : $scope.inputModificaConfigCausaliRimDelivery
					},
					function(response) {
						if(response.data && response.data[0] && response.data[0].esito!=="KO"){
							openRes("Causale aggiunta con successo");
							$scope.caricaTutteLeCausali();
							
	                        _trackBean.timestampFine = new Date().toISOString();
	                        _trackBean.esito = 'Ok';
	                        
						}else{
							openRes("Causale non inserita");
							
	                        _trackBean.timestampFine = new Date().toISOString();
	                        _trackBean.esito = 'Ko';
	                        TrackingGUI.tracking(_trackBean);
						}
					},
					function(error) {
						$scope.causaliRimodulazioniLoaded = true;
						openRes("Errore Nell'inserimento della Causale");
						
                        _trackBean.timestampFine = new Date().toISOString();
                        _trackBean.esito = 'Ko';
                        TrackingGUI.tracking(_trackBean);
					});

			};

			function openRes(val) {
				$scope.items = val;
				$uibModal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'app/common/edit_delete_now_table/risultatoAddMod.html',
					controller : 'ModalCausali',
					resolve : {items : function() {return $scope.items;}, title : function() {}}
				});
			}

			$scope.deleteItem = function() {
				$scope.causaliRimodulazioniLoaded = false;

				var successCallbackElim = function(response) {
					openRes("Causali eliminate con successo");
					$scope.caricaTutteLeCausali();
					$scope.causaliRimodulazioniLoaded = true;
				};

				var errorCallbackElim = function(error) {
					openRes("Errore Nell'eliminazione della Causale");
					$scope.causaliRimodulazioniLoaded = true;
				};

				delete $scope.detailArg[0]["isSelected"];
				CausaliRimodulazioni.delete_item({operation : "delete"},
								{inputModificaConfigCausaliRimDelivery : $scope.detailArg}, 
								successCallbackElim,errorCallbackElim);
			};

			init();
		} ])
.controller(
		'ModalCausali',['$scope','$uibModalInstance','items','title','$state', function($scope, $uibModalInstance, items, title,$state) {
			$scope.items = items;
			$scope.title = title;

			$scope.cancel = function() {
				$state.go('root.amministrazione.causalirimodulazioni');
				$uibModalInstance.dismiss('cancel');
				};
			} ]);

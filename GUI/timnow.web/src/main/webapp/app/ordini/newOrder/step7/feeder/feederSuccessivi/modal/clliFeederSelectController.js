//RU_1205
timnow.controller('ClliFeederSelectModalCtrl',
		['$rootScope', '$scope', '$uibModalInstance', 'feeders', 'alreadySelected', '_', function ($rootScope, $scope, $uibModalInstance, feeders, alreadySelected, _) {

			$scope.feeders = feeders;	
			$scope.alreadySelected = (alreadySelected || []);
			
			$scope.dataComponent = {};
			$scope.dataComponent.selected = [];
			
			$scope.datiLoaded = true;			
			$rootScope.salvataggioFiltriPaginazione = {};

			$scope.headerTabellaCLLIFeederSuccessivi = [];
			$scope.headerTabellaCLLIFeederSuccessivi.push({"key" : "",	"value" : "Seleziona", "type" : "selectable"});
			$scope.headerTabellaCLLIFeederSuccessivi.push({"key": "valoreCampo","value": "CLLI Feeder","type": "text"});
			$scope.headerTabellaCLLIFeederSuccessivi.push({"key": "nomeCentrale","value": "Nome Centrale","type": "text"});
			
			
			$scope.trasformaSelezioneBegin = function(){
				if($scope.dataComponent.selected && $scope.alreadySelected && $scope.feeders){
					$scope.feeders = _.map($scope.feeders, function(feeder){						
						_.each($scope.alreadySelected, function(already){
							if(already.clliFeederSuccessivo === feeder.valoreCampo){
								feeder.isSelected = true;
								$scope.dataComponent.selected.push(feeder); 
							}
						});
						
						return feeder;
					});
				}
			}
			
			
			$scope.trasformaSelezioneReturn = function(){
				if($scope.dataComponent.selected && $scope.dataComponent.selected.length > 0){
					var _cont = 0;
					$scope.dataComponent.selected = _.map($scope.dataComponent.selected, function(item){						
						var _app = {};
						_app.id = ++_cont;
						_app.clliFeederSuccessivo = item.valoreCampo;
						item = _app;
						return item;
					});
				}
			}

			$scope.annulla = function () {
				$scope.clliFeedersSelected = [];
				$uibModalInstance.dismiss('cancel');
			};
			
			$scope.chiudi = function () {
				$uibModalInstance.dismiss('cancel');
			};
			
			$scope.conferma = function(){
				$scope.trasformaSelezioneReturn();
				$uibModalInstance.close($scope.dataComponent.selected);
			}
			
			$scope.trasformaSelezioneBegin();
			
		}]);
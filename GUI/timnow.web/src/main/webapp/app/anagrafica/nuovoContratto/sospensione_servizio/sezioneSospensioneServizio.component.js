//SM_10292
timnow.directive('sezioneSospensioneServizio', function(){
	return {
		templateUrl: 'app/anagrafica/nuovoContratto/sospensione_servizio/sezioneSospensioneServizio.component.html',
		scope:{
			data: '=',
			isEdit: '=',
			form: '='
		},
		restrict: 'E',
		require: {
			form: '^form'
		},
		controllerAs: '$ctrl',
		controller: ['$scope', '$timeout',
			function($scope, $timeout){		

			$scope.$watch("data.dataFineValiditaContratto", function(newValue, oldValue){
				if(!$scope.isEdit && $scope.data.flagDisabil != 'N'){
					$scope.data.dataFineDisabil = newValue;
				}
			});

			$scope.init = function(){		

				$scope.dataInizioDisabilConfig = {
						formats: ['dd/MM/yyyy', 'shortDate'],
						format: 'dd/MM/yyyy',
						popupOpened : false,
						dateOptions: {
							formatYear: 'yy',
							startingDay: 1
						},
						open: function(){
							this.popupOpened = !this.popupOpened;
						}
				};

				$scope.dataFineDisabilConfig = {
						formats: ['dd/MM/yyyy', 'shortDate'],
						format: 'dd/MM/yyyy',
						popupOpened : false,
						dateOptions: {
							formatYear: 'yy',
							startingDay: 1,
							minDate: new Date()
						},
						open: function(){
							this.popupOpened = !this.popupOpened;
						}
				};

				//Task #36345
				if(!$scope.isEdit){
					$scope.data.flagDisabil = 'Y';
					$scope.dataInizioDisabilConfig.minDate = new Date();
					$scope.data.dataInizioDisabil = new Date();
				}
			}

			$scope.onChangeFlagDisabilitazione = function(){
				if($scope.data.flagDisabil && $scope.data.flagDisabil != '' ){		
					if($scope.data.flagDisabil == 'Y'){		
						$scope.data.dataInizioDisabil = new Date();
						$scope.data.dataFineDisabil = null;
						$scope.dataInizioDisabilRequired = true;
						$scope.dataInizioDisabilitazioneDisabled = false
						$scope.dataFineDisabilRequired = true;
						$scope.dataFineDisabilitazioneDisabled = false
					}else{					
						//Task #36345
						//flagDisabil == 'N'
						if(!$scope.isEdit){
							$scope.data.dataInizioDisabil = null;
							$scope.data.dataFineDisabil = null;
							$scope.dataInizioDisabilRequired = false;
							$scope.dataFineDisabilRequired = false;
							$scope.dataInizioDisabilitazioneDisabled = true;
							$scope.dataFineDisabilitazioneDisabled = true;

						}else{
							$scope.dataInizioDisabilRequired = true;
							$scope.dataFineDisabilRequired = true;
							$scope.dataInizioDisabilitazioneDisabled = true;
							scope.dataFineDisabilitazioneDisabled = false;
						}				
					}
				}else{
					$scope.data.dataInizioDisabil = null;
					$scope.data.dataFineDisabil = null;
					$scope.dataInizioDisabilRequired = false;
					$scope.dataFineDisabilRequired = false;
					$scope.dataInizioDisabilitazioneDisabled = true;
					$scope.dataFineDisabilitazioneDisabled = true;
				}
			}

			$scope.onChangeDataInizioDisabilitazione = function(){
				if ($scope.data.dataInizioDisabil && $scope.data.dataFineDisabil){
					var _dataInizio = moment($scope.data.dataInizioDisabil);
					var _dataFine = moment($scope.data.dataFineDisabil);
					if(_dataInizio > _dataFine){
						$timeout(function(){
							$scope.form.dataInizioDisabilitazione.$setValidity('invalidDate', false);
							$scope.message = "La data di inizio deve essere minore o uguale a quella di fine"
						}, 20);					
					}else{
						$timeout(function(){
							$scope.form.dataInizioDisabilitazione.$setValidity('invalidDate', true);
							$scope.message = "";
						}, 20);	
					}
				}else{
					$timeout(function(){
						$scope.form.dataInizioDisabilitazione.$setValidity('invalidDate', true);
						$scope.message = "";
					}, 50);	
				}
			}

			$scope.init();
		}]
	}
})

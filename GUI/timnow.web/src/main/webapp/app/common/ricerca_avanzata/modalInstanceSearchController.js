angular.module("common")
    .controller('ModalInstanceSearchCtrl', ['$scope', '$uibModalInstance', 'dati', 'titolo', 'tipoDirettiva', 'codFunzione', 'AdvancedSearchSave', '$log', '$rootScope',
        function ($scope, $uibModalInstance, dati, titolo, tipoDirettiva, codFunzione, AdvancedSearchSave, $log, $rootScope) {

            $scope.integerval = /^\d*$/;
            $scope.filters = dati;
            $scope.titolo = titolo;
            $scope.tipoDirettiva = tipoDirettiva;
            $scope.codFunzione = codFunzione;
            $scope.loadElimina = false;

            if ($scope.tipoDirettiva === 'cerca') {
                recharge();
            }

            function recharge() {
                var ricerche = AdvancedSearchSave.get({codFunzione: $scope.codFunzione});

                ricerche.$promise.then(function (data) {
                    $scope.ricerche = data.data;
                    $scope.ricercheLoaded = true;
                }, function (error) {
                    $log.debug(error);
                    $scope.ricerche = [];
                    $scope.ricercheLoaded = true;
                });
            }

            $scope.salva = function (form, nomeFiltro, descrizione) {
                angular.forEach(form.$error.required, function (field) {
                    field.$setDirty();
                });

                if (form.$valid) {
                    var ricerche = AdvancedSearchSave.save({codFunzione: $scope.codFunzione, operationType: 'save'}, {
                        description: descrizione,
                        filters: $scope.filters,
                        nomeFiltro: nomeFiltro
                    });

                    ricerche.$promise.then(function (data) {
                        if (data.result.code === '0') {
                            $uibModalInstance.dismiss('cancel');
                        } else if (data.result.code === '2') {
                            $scope.ricercaEsistente = true;
                        } else {
                            $uibModalInstance.dismiss('cancel');
                            $rootScope.alertGenericError();
                        }
                    }, function () {
                        $uibModalInstance.dismiss('cancel');
                        $rootScope.alertGenericError();
                    });
                }
            };

            $scope.chooseRicerca = function (index) {
                $scope.datiToSearch = $scope.ricerche[index].filters;
                angular.forEach($scope.datiToSearch, function (item) {
                    if (item.tipo === "DATE") {
                        if (item.valore) {
                            var parts = item.valore.split("-");
                            item.valore = parts[2] + "/" + parts[1] + "/" + parts[0];
                        }
                    }
                });
                $uibModalInstance.dismiss($scope.datiToSearch);
            };

            $scope.deleteRicerca = function (index) {

                $scope.loadElimina = true;
                var elimina = AdvancedSearchSave.remove({codFunzione: $scope.codFunzione, operationType: 'delete'}, {nomeFiltro: index});
                elimina.$promise.then(function (data) {
                    $scope.ricercheLoaded = true;
                    $scope.datiToSearch = [];
                    recharge();
                    $scope.loadElimina = false;
                }, function (error) {
                    $log.debug(error);
                    $scope.ricerche = [];
                    recharge();
                    $scope.ricercheLoaded = true;
                    $scope.loadElimina = false;
                });

            };

            $scope.close = function () {
                $scope.datiToSearch = [];
                $uibModalInstance.dismiss('cancel');
            };

        }]);
(function () {
    "use strict";
    angular.module("common")
        .directive("addModifyPageTimNow", addModifyPageTimNowDirectives);

    function addModifyPageTimNowDirectives() {

        var directive = {
            restrict: 'E',
            templateUrl: 'app/common/edit_delete_now_table/templateAddModifyPage.html',
            scope: {
                dati: '=',
                isAuthorized: '=',
                addCallback: '&',
                detailList: '=',
                insertUpdate: '='
            },
            replace: true,
            controller: controller,
            controllerAs: 'ctrlDirettiva',
            bindToController: true
        };
        return directive;
    }

    controller.$inject = ['$log', '$scope', '$rootScope', '$state'];
    function controller($log, $scope, $rootScope, $state) {
        $scope.init = function () {
            if ($scope.ctrlDirettiva.detailList) {
                angular.forEach($scope.ctrlDirettiva.detailList, function (item) {
                    if ($scope.ctrlDirettiva.dati) {
                        if (item.type === 'date') {
                            item.valore = $scope.ctrlDirettiva.dati[item.key];
                            item.opened = false;
                        } else {
                            item.valore = $scope.ctrlDirettiva.dati[item.key];
                        }
                    }
                });
            }

        };

        $scope.addItem = function (form) {
            if (form && form.$error) {
                angular.forEach(form.$error.required, function (field) {
                    field.$setDirty();
                });
            }
            if (form && form.$valid) {
                $scope.ctrlDirettiva.addCallback();
            }
        };

        $scope.changeState = function () {
        	$rootScope.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
            $state.go($rootScope.fromState);
        };
    }
})();
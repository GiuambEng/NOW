angular.module("common").controller('ModalInstanceDeleteCtrl', ['$scope', '$uibModalInstance', function ($scope, $uibModalInstance) {
    $scope.ok = function () {
        $uibModalInstance.dismiss(true);
    };

    $scope.close = function () {
        $uibModalInstance.dismiss(false);
    };
}]);
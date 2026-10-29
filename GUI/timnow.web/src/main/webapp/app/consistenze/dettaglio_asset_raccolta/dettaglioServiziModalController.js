//RU_1188
timnow.controller('DettaglioServiziModalCtrl',
		['$scope', '$uibModalInstance', 'item', 'title', function ($scope, $uibModalInstance, item, title) {
    $scope.item = item;
    $scope.title = title;
    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
}]);
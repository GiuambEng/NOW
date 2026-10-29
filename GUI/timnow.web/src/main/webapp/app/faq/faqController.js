timnow.controller('faq', ['$rootScope', '$scope', '$log', '$state', 'FaqsVisible', '$location',
    function ($rootScope, $scope, $log, $state, FaqsVisible, $location) {
        $rootScope.pageClass = $state.params.pageClass;
        var info = $location.search();
        $scope.search = [];
        $scope.loadComplete = true;

        if ($state.params.faqs.length > 0) {
            $scope.faqs = $state.params.faqs;
            $scope.loadComplete = false;
        } else {
            init();
        }

        function init() {
            var ord = FaqsVisible.get();
            return ord.$promise.then(function (response) {
                $scope.faqs = response.data;
                $scope.loadComplete = false;
            }, function (error) {
                $scope.loadComplete = false;
            });
        }

        if (info) {
            $scope.faqVisible = parseInt(info.idfaq);
        }
    }]);
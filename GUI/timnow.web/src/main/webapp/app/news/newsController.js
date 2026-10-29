timnow.controller('allNews', ['$rootScope', '$scope', '$log', '$state',
    'News', '$location',
    function ($rootScope, $scope, $log, $state, News, $location) {
        $rootScope.pageClass = $state.params.pageClass;
        // $scope.conn = $rootScope.timnowConfigData.authorizations;
        var info = $location.search();
        $scope.search = [];
        $scope.loadComplete = true;

        if ($state.params.news.length > 0) {
            $scope.news = $state.params.news;
            $scope.loadComplete = false;
        } else {
            init();
        }

        function init() {
            var ord = News.get({idNews:'visible'});
            return ord.$promise.then(function (response) {
                $scope.news = response.data;
                $scope.loadComplete = false;
            }, function (error) {
                $scope.loadComplete = false;
            });
        }

        if (info) {
            $scope.newsVisible = parseInt(info.idnews);
        }
    }]);
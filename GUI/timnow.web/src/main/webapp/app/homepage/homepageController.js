timnow.
    controller('homepage', ['$rootScope', '$scope', '$state', '$log', 'News', function ($rootScope, $scope, $state, $log, News) {


        $scope.init = function () {
            $rootScope.pageClass = $state.params.pageClass;
            $scope.user = $rootScope.timnowConfigData.user;
            $scope.visTab = 0;
            $scope.lastNews = {};

            if ($rootScope.isAuthorized('Ordini', 'Nuovo Ordine')) {
                $scope.visTab = 1;
            }
            if ($rootScope.isAuthorized('Asset', 'Lista Asset')) {
                $scope.visTab = $scope.visTab + 1;
            }
            if ($rootScope.isAuthorized('File e Notifiche', 'Upload File Ordini e Richieste') && !$scope.user.flagAccorpato) {
                $scope.visTab = $scope.visTab + 1;
            }
            if ($rootScope.isAuthorized('File e Notifiche', 'Stato File Ordini e Richieste')) {
                $scope.visTab = $scope.visTab + 1;
            }

            $scope.visTab = 12 / $scope.visTab;
            $scope.classTab = "col-md-" + $scope.visTab;

            News.get({visible: "visible"}).$promise.then(function (response) {
                var news = response.data;
                if (news && news.length > 0) {
                    $scope.lastNews = news[0];
                }
            });
        };

        $scope.init();
    }]);
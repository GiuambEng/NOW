timnow
    .controller('amministrazioneNewsList', ['$scope', '$state', '$rootScope', 'News', '$log', '$timeout', function ($scope, $state, $rootScope, News, $log, $timeout) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        //solo singola lista
        $scope.news = [];
        $scope.newsLoaded = false;
        $scope.detailArg = [];

        $scope.headerList = [
            {"key": "delete", "value": "Seleziona", "type": "selectable"},
            {"key": "insertDate", "value": "Data inserimento", "type": "data", "pattern": "dd/MM/yyyy"},
            {"key": "updateDate", "value": "Data aggiornamento", "type": "data", "pattern": "dd/MM/yyyy"},
            {"key": "visible", "value": "Visibile", "type": "checkbox"},
            {"key": "operator", "value": "Operatore", "type": "text"},
            {"key": "title", "value": "Titolo", "type": "text"}
        ];

        $scope.detailList = [
            {"key": "note", "value": "Note", "type": "text"},
            {"key": "content", "value": "Contenuto", "type": "text-area"}
        ];


        init();

        function init() {
            News.get().$promise.then(function (response) {
                    if (response.data) {
                        $scope.news = response.data;
                    }
                    if (!$scope.news) {
                        $scope.errorDate = true;
                    }
                    $scope.newsLoaded = true;
                },
                function (error) {
                    $scope.errorDate = true;
                    $scope.newsLoaded = true;
                });
        }

        $scope.deleteItem = function () {
            $scope.newsLoaded = false;

            var successCallback = function (response) {
                $scope.messaggio = "News Cancellate";
                $timeout(function () {
                    $scope.messaggio = "";
                }, 3000);
                $log.info($scope.messaggio);
                init();
            };

            var errorCallback = function (error) {
                $scope.messaggio = "News Errore";
                $timeout(function () {
                    $scope.messaggio = "";
                }, 3000);
                $scope.newsLoaded = true;
            };

            var newsList = $scope.detailArg;

            for (var index = 0; index < newsList.length; index++) {
                var idDelete = newsList[index].idNews;
                $log.info(idDelete);
                News.delete_news({"idNews": idDelete}, successCallback, errorCallback);
            }
        };

        $scope.modifyItem = function () {
            $state.go('root.amministrazione.News.addModify', {"news": $scope.detailArg});
        };

        $scope.addItem = function () {
            $state.go('root.amministrazione.News.addModify');
        };

    }]);
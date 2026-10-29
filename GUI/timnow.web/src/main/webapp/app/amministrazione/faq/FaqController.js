timnow
    .controller('amministrazioneFaq', ['$scope', '$state', '$rootScope', 'Faq', '$log', '$timeout', function ($scope, $state, $rootScope, Faq, $log, $timeout) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        //solo singola lista
        $scope.faq = [];
        $scope.newsLoaded = false;
        $scope.keyDetail = "answer";
        $scope.detailArg = [];

        $scope.headerList = [
            {"key": "delete", "value": "Seleziona", "type": "selectable"},
            {"key": "question", "value": "Domanda", "type": "text"},
            {"key": "insertDate", "value": "Data Ins.", "type": "data", "pattern": "dd/MM/yyyy"},
            {"key": "updateDate", "value": "Data Agg.", "type": "data", "pattern": "dd/MM/yyyy"},
            {"key": "visible", "value": "Visibile", "type": "checkbox"},
            {"key": "operator", "value": "Operatore", "type": "text"}
        ];

        $scope.detailList = [
            {"key": "answer", "value": "Risposta", "type": "text-area"},
            {"key": "note", "value": "Note", "type": "text"}
        ];


        init();

        function init() {
            Faq.get().$promise.then(function (response) {
                    if (response.data) {
                        $scope.faq = response.data;
                    }
                    if (!$scope.faq) {
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

            var successCallback = function (response) {
                $scope.messaggio = "Faq Cancellata";
                $timeout(function () {
                    $scope.messaggio = "";
                }, 3000);
                init();
            };

            var errorCallback = function (error) {
                $scope.messaggio = "Faq Non Cancellata";
                $timeout(function () {
                    $scope.messaggio = "";
                }, 3000);
                init();
            };

            var faqsList = $scope.detailArg;

            for (var index = 0; index < faqsList.length; index++) {
                var idDelete = faqsList[index].idFaq;
                $log.info(idDelete);
                Faq.delete_faqs({"idFaq": idDelete}, successCallback, errorCallback);
            }
        };

        $scope.modifyItem = function () {
            $state.go('root.amministrazione.faq.addModify', {"faq": $scope.detailArg});
        };

        $scope.addItem = function () {
            $state.go('root.amministrazione.faq.addModify', {"faq": ""});
        };

    }]);
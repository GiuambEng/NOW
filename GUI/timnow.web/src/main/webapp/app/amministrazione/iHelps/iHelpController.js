timnow
    .controller('amministrazioneIhelp', ['$scope', '$state', '$rootScope', 'iHelps', '$log', '$timeout', function ($scope, $state, $rootScope, iHelps, $log, $timeout) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        //solo singola lista
        $scope.ihelp = [];
        $scope.ihelpLoaded = false;
        $scope.headerList = [
            {"key": "delete", "value": "Seleziona", "type": "selectable"},
            {"key": "descAmbito", "value": "Ambito", "type": "text"},
            {"key": "dataInserimento", "value": "Data inserimento", "type": "data", "pattern": "dd/MM/yyyy"},
            {"key": "dataAggiornamento", "value": "Data Aggiornamento", "type": "data", "pattern": "dd/MM/yyyy"},
            {"key": "visibile", "value": "Visibile", "type": "checkbox"},
            {"key": "operatore", "value": "Operatore", "type": "text"},
            {"key": "titolo", "value": "Titolo", "type": "text"}];


        $scope.keyDetail = "idIHelp";
        $scope.detailArg = [];
        $scope.dataContainer = [];
        $scope.detailList = [
            {"key": "note", "value": "Note", "type": "text"},
            {"key": "contenuto", "value": "Contenuto", "type": "text-area"}];

        init();

        function init() {
            iHelps.get().$promise.then(function (response) {
                    if (response.data) {
                        $scope.ihelp = response.data;
                    }
                    if (!$scope.ihelp) {
                        $scope.errorDate = true;
                    }
                    $scope.ihelpLoaded = true;
                },
                function (error) {
                    $scope.errorDate = true;
                    $scope.ihelpLoaded = true;
                });
        }

        $scope.deleteItem = function () {
            $scope.ihelpLoaded = false;

            var successCallback = function (response) {
                $scope.messaggio = "IHelp Cancellata";
                $timeout(function () {
                    $scope.messaggio = "";
                }, 3000);
                init();
            };

            var errorCallback = function (error) {
                $scope.messaggio = "iHelps NON cancellata";
                $timeout(function () {
                    $scope.messaggio = "";
                }, 3000);
                $scope.ihelpLoaded = true;
            };

            var ihelpList = $scope.detailArg;

            for (var index = 0; index < ihelpList.length; index++) {
                var idDelete = ihelpList[index].idIHelp;
                $log.info(idDelete);
                iHelps.delete_ihelps({"idIHelp": idDelete}, successCallback, errorCallback);
            }
        };

        $scope.modifyItem = function () {
            $state.go('root.amministrazione.ihelp.addModify', {"ihelp": $scope.detailArg});
        };

        $scope.addItem = function () {
            $state.go('root.amministrazione.ihelp.addModify', {"ihelp": ""});
        };

    }]);
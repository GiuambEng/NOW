timnow
    .controller('amministrazioneArchiTD', ['$scope', '$state', '$rootScope', '$log', 'archiTD',  function ($scope, $state, $rootScope, $log, archiTD) {

        $rootScope.pageClass = 'ArchiTD';

        //solo singola lista
        $scope.listaArchiTD = [];
        $scope.listaArchiTDLoaded = false;
        $scope.tipologia = "ArchiTD";

        $scope.headerList = [
            {"key": "tdParziale", "value": "TD parziale", "type": "text"},
            {"key": "tdCurrent", "value": "TD Current", "type": "text"},
            {"key": "tdMin", "value": "TD min", "type": "text"},
            {"key": "tdMax", "value": "TD max", "type": "text"},
            {"key": "inizioValidita", "value": "Inizio validità", "type": "data", "pattern": "dd/MM/yyyy"},
            {"key": "fineValidita", "value": "Fine validità", "type": "data", "pattern": "dd/MM/yyyy"},
            {"key": "activeFlag", "value": "Active_Flag", "type": "checkbox"},
            {"key": "operatore", "value": "Operatore", "type": "text"}
        ];

        init();

        function init() {
        	archiTD.get().$promise.then(function (data) {
                if (data.data) {
                    $scope.listaArchiTD = data.data;
                    $scope.archiParziali = data.tdResidui;
                }
                $scope.listaArchiTDLoaded = true;
            }, function (error) {
            	$log.debug(error);
                $scope.listaArchiTDLoaded = true;
            });
        }

        $scope.modifyItem = function () {
            $state.go('root.amministrazione.archiTD.addModify', {"archiTD": $scope.detailArg});
        };
        
        $scope.addItem = function () {
            $state.go('root.amministrazione.archiTD.addModify');
        };

    }]);
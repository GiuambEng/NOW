timnow
    .controller('vcs', ['$scope', '$state', '$rootScope', 'vcs', '$log', 'modalService', function ($scope, $state, $rootScope, vcs, $log, modalService) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        //solo singola lista
        $scope.vcs = [];
        $scope.vcsLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "profilo", "value": "Profilo", "type": "text"});
        $scope.headerList.push({"key": "tipoProfilo", "value": "Tipo Profilo", "type": "text"});
        $scope.headerList.push({"key": "mcr_Down", "value": "MCR Down", "type": "text", "sort": "number"});
        $scope.headerList.push({"key": "mcr_Up", "value": "MCR UP", "type": "text", "sort": "number"});
        $scope.headerList.push({"key": "pcr_Down", "value": "PCR Down", "type": "text", "sort": "number"});
        $scope.headerList.push({"key": "pcr_Up", "value": "PCR UP", "type": "text", "sort": "number"});
        $scope.headerList.push({"key": "scr_Down", "value": "SCR Down", "type": "text"});
        $scope.headerList.push({"key": "scr_Up", "value": "SCR Up", "type": "text"});
        $scope.headerList.push({"key": "offerta", "value": "Offerta", "type": "text"});


        $scope.detailList = [];
        $scope.detailList.push({"key": "identificativoProfiloVc", "value": "ID Profilo VC", "type": "text"});
        $scope.detailList.push({"key": "flagVendibilita", "value": "Vendibilita'", "type": "checkbox"});
        $scope.detailList.push({"key": "identificativoOfferta", "value": "ID Offerta", "type": "text"});

        init();

        function init() {
            var profiliVC = vcs.get({identificativoProfiloVc: ""});
            profiliVC.$promise.then(function (response) {
                    if (response.data) $scope.vcs = response.data;
                    if (!$scope.vcs) {
                        $scope.errorDate = true;
                    }
                    $scope.vcsLoaded = true;
                },
                function (error) {
                    $scope.errorDate = true;
                    $scope.vcsLoaded = true;
                });

        }
    }]);
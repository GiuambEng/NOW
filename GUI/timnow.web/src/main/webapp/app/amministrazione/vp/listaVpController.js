timnow
    .controller('vps', ['$scope', '$state', '$rootScope', 'vps', '$log', function ($scope, $state, $rootScope, vps, $log) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        //solo singola lista
        $scope.vps = [];
        $scope.vpsLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "codiceVP", "value": "Codice VP", "type": "text"});
        $scope.headerList.push({"key": "stato", "value": "Stato", "type": "text"});
        $scope.headerList.push({"key": "tipo", "value": "Tipo", "type": "text"});
        $scope.headerList.push({"key": "codiceKit", "value": "Codice Kit", "type": "text"});
        $scope.headerList.push({"key": "clli", "value": "CLLI", "type": "text"});
        $scope.headerList.push({"key": "nomeCentrale", "value": "Nome Centrale", "type": "text"});
        $scope.headerList.push({"key": "codificaOloAgcom", "value": "Codifica OLO Agcom", "type": "text"});
        $scope.headerList.push({"key": "dec", "value": "DEC", "type": "data", "pattern": "dd/MM/yyyy"});

        $scope.detailList = [];
        $scope.detailList.push({"key": "modalitaFatturazione", "value": "Modalità di fatturazione", "type": "text"});
        $scope.detailList.push({"key": "codiceOlo", "value": "Codice OLO", "type": "text"});
        $scope.detailList.push({"key": "bandaMCR", "value": "Banda MCR", "type": "text"});
        $scope.detailList.push({"key": "bandaPCR", "value": "Banda PCR", "type": "text"});
        $scope.detailList.push({"key": "codiceAreaRaccolta", "value": "Codice Area Raccolta", "type": "text"});
        $scope.detailList.push({"key": "descAreaRaccolta", "value": "Desc Area Raccolta", "type": "text"});
        $scope.detailList.push({"key": "vpiRete", "value": "VPI Rete", "type": "text"});
        $scope.detailList.push({"key": "vpi", "value": "VPI", "type": "text"});
        $scope.detailList.push({"key": "tipoTrasporto", "value": "Tipo Trasporto", "type": "text"});
        $scope.detailList.push({"key": "decAttivazione", "value": "DEC Attivazione", "type": "text"});
        $scope.detailList.push({"key": "numeroMaxVc", "value": "Numero Max VC", "type": "text"});

        init();

        function init() {
            var vp = vps.get({codiceVP: ""});
            vp.$promise.then(function (response) {
                    if (response.data) $scope.vps = response.data;
                    if (!$scope.vps) {
                        $scope.errorDate = true;
                    }
                    $scope.vpsLoaded = true;
                },
                function (error) {
                    $scope.errorDate = true;
                    $scope.vpsLoaded = true;
                });
        }
    }]);
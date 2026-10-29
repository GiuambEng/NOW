timnow
    .controller('linea', ['$scope', '$state', '$rootScope', 'LineProfiles', '$log', function ($scope, $state, $rootScope, LineProfiles, $log) {

        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;

        //$log.info('Lista News');

        //solo singola lista
        $scope.lines = [];
        $scope.linesLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "profiloTecnicaLinea", "value": "Profilo Linea", "type": "text"});
        $scope.headerList.push({"key": "idOfferta", "value": "ID Offerta", "type": "text", "sort": "number"});
        $scope.headerList.push({
            "key": "profiloCommercialeDown",
            "value": "Profilo Commerciale Down",
            "type": "text",
            "sort": "number"
        });
        $scope.headerList.push({
            "key": "profiloCommercialeUp",
            "value": "Profilo Commerciale Up",
            "type": "text",
            "sort": "number"
        });
        $scope.headerList.push({
            "key": "velocitaAggancioDownMin",
            "value": "Vel. Download Min",
            "type": "text",
            "sort": "number"
        });
        $scope.headerList.push({
            "key": "velocitaAggancioDownMax",
            "value": "Vel. Download Max",
            "type": "text",
            "sort": "number"
        });
        $scope.headerList.push({
            "key": "velocitaAggancioUpMin",
            "value": "Vel. Upload Min",
            "type": "text",
            "sort": "number"
        });
        $scope.headerList.push({
            "key": "velocitaAggancioUpMax",
            "value": "Vel. Upload Max",
            "type": "text",
            "sort": "number"
        });

        $scope.detailList = [];
        $scope.detailList.push({"key": "idProfiloTecnicoLinea", "value": "ID prof. Tecnico Linea", "type": "text"});
        $scope.detailList.push({"key": "offerta", "value": "Offerta", "type": "text"});
        $scope.detailList.push({"key": "maxVCxCF", "value": "MAX VC x CF", "type": "text"});
        $scope.detailList.push({"key": "flagVendibilita", "value": "Flag Vendibilità", "type": "checkbox"});
        $scope.detailList.push({"key": "flagOscurabile", "value": "Flag Oscurabile", "type": "checkbox"});
        $scope.detailList.push({"key": "codiceModem", "value": "Cod. Modem", "type": "text"});
        $scope.detailList.push({"key": "modem", "value": "Modem", "type": "text"});
        $scope.detailList.push({"key": "bandaNetta", "value": "Banda Netta", "type": "text"});
        $scope.detailList.push({"key": "modelloAccesso", "value": "Modello Accesso", "type": "text"});
        $scope.detailList.push({"key": "protocollo", "value": "Protocollo", "type": "text"});
        $scope.detailList.push({"key": "tecnologiaOlo", "value": "Tecnologia OLO", "type": "text"});
        $scope.detailList.push({"key": "tipoModulazione", "value": "Tipo Modulazione", "type": "text"});
        $scope.detailList.push({"key": "idProfiloBMD", "value": "ID profilo BDM", "type": "text"});

        init();

        function init() {
            var profiliLinea = LineProfiles.get();
            profiliLinea.$promise.then(function (response) {
                    if (response.data) $scope.lines = response.data;
                    if (!$scope.lines) {
                        $scope.errorDate = true;
                    }
                    $scope.linesLoaded = true;
                },
                function (error) {
                    $scope.errorDate = true;
                    $scope.linesLoaded = true;
                });
        }
    }]);
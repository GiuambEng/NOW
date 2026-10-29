timnow
    .controller('listaDisaggregazione', ['alertService', '$scope', '$state', '$rootScope', '$log', 'modalService', 'CRM_PROFILE', 'DISAGGREGAZIONE', 
    	function (alertService, $scope, $state, $rootScope, $log, modalService, CRM_PROFILE, DISAGGREGAZIONE) {

        $rootScope.pageClass = $state.current.params.pageClass;

        //solo singola lista
        $scope.listaDisaggregazione = [];
        $scope.datiLoaded = true;
        $scope.headerList = [];
        $scope.headerList.push({"key": "olo","value": "OLO","type": "text"});
        $scope.headerList.push({"key": "codiceImpresa","value": "Codice Impresa","type": "text"});
        $scope.headerList.push({"key": "areaDiCantiere","value": "AREA DI CANTIERE","type": "text"});
        $scope.headerList.push({"key": "dataInizioValiditaProvisioning","value": "DATA INIZIO VALIDITA PROVISIONING","type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "dataFineValiditaProvisioning","value": "DATA FINE VALIDITA PROVISIONING","type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "ragioneSociale","value": "Ragione Sociale","type": "text"});
        
        //R1I_20_0131
        $scope.sezione = $state.current.params.sezione;
        $scope.sezioneName = $state.current.params.sezioneName;
        $scope.headerList.push({"key": "disaggregazioneAppuntamento","value": "DISAGGREGAZIONE APPUNTAMENTO","type": "text"});
        

        $scope.tipologia = $state.params.tipologia;

    	//R1I_20_0131
    	DISAGGREGAZIONE.get({sezione: $scope.sezione}).$promise.then(function (data) {
            if (data.data) {
                $scope.listaDisaggregazione = data.data;
            }
            $scope.datiLoaded = true;
        }, function (error) {
        	$log.debug(error);
            $scope.datiLoaded = true;
        });

    }]);
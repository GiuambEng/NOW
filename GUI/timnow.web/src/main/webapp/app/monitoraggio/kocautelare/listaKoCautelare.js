timnow.controller('listakoCaut', ['$scope', '$interval', '$state', '$rootScope', 'MonitoraggioKOCautelare', 'BASEPATH', '$log', 'modalService',
    'ExportPoll', function ($scope, $interval, $state, $rootScope, MonitoraggioKOCautelare, BASEPATH, $log, modalService, ExportPoll) {

        /*
         * $scope.koCaut = [{servizio : "N02", causaleEsito : "TWS Bitstream
         * GBE Asimmetrico Flat", totale : "41"}, {servizio : "OLO",
         * causaleEsito : "TWS Bitstream GBE Asimmetrico Flat", totale :
         * "38"}];
         */

        $scope.loading = true;
        $scope.tot = 0;

        $scope.conn = $rootScope.timnowConfigData.config;
        $scope.pageSize = $scope.conn.tablesPagesize;
        $scope.pageInit = $scope.pageSize.split(',');
        $scope.visLim = $scope.pageInit[0];
        $scope.numList = $scope.pageInit[0];

        init();

        function init() {
            MonitoraggioKOCautelare.get({level:'level0'}).$promise.then(function (response) {
                if (response.data) {
                    $scope.koCaut = response.data;
                }
                if ($scope.koCaut.length === 0) {
                    $scope.errorDate = true;
                    $scope.msg_err = "Nessun dato da visualizzare";
                }
                $scope.loading = false;
            }, function (error) {
                $log.debug(error);
                $scope.errorDate = true;
                $scope.loading = false;
                $scope.msg_err = "Impossibile visualizzare i KO su Cautelare";
            });

        }

        $scope.changeList = function (item) {
            $scope.numList = item;
        };

        $scope.dettaglio = function (codiceErrore, offerta) {
            if (codiceErrore && offerta) {
                var ordDetails = MonitoraggioKOCautelare.get({
                    codiceErrore: offerta,
                    offerta: codiceErrore,
                    level:'level1'
                });

                return ordDetails.$promise.then(function (response) {

                        if (response.data.length > 0) {
                            $scope.datiModaleDettaglio = [];
                            $scope.datiModaleDettaglio.selFamily = codiceErrore;
                            $scope.datiModaleDettaglio.response = [];
                            angular.forEach(response.data, function (value) {

                                $scope.datiModaleDettaglio.response.push([
                                    {label: "Data Creazione Richiesta", valore: value.DataInvioRichiesta},
                                    {label: "Codifica OAO", valore: value.codificaOloAgcom},
                                    {label: "Codice OAO", valore: value.codificaOloNow},
                                    {label: "Ordine TI", valore: value.ordineTI},
                                    {label: "Stato NOW", valore: value.statoNOW},
                                    {label: "Stato OLO", valore: value.statoOLO},
                                    {label: "Id Risorsa", valore: value.idRisorsa},
                                    {label: "DRO", valore: value.dro},
                                    {label: "Ambito", valore: value.ambito},
                                    {label: "Offerta", valore: value.offerta},
                                    {label: "Id Richiesta", valore: value.idRichiesta}]);
                            });

                            $scope.modalDettaglioKoCautelare = {
                                headerText: 'Dettaglio KO Cautelare',
                                actionButtonText: null,
                                closeButtonText: 'Ok',
                                contentType: 'table_Dett',
                                scope: $scope,
                                data: $scope.datiModaleDettaglio,
                                valueFamily: $scope.selFamily
                            };

                            modalService.showModal({}, $scope.modalDettaglioKoCautelare);
                        } else {
                            modalService.showModal({}, {
                                headerText: "KO allarme Cautelare",
                                bodyText: "Non è presente nessun dettaglio",
                                actionButtonText: 'Chiudi',
                                type: 'warning'
                            });
                        }
                    },

                    function (error) {
                        $log.debug(error);
                        $scope.errorDetail = true;
                        modalService.showModal({}, {
                            headerText: "Errore Monitoraggio KO su cautelare",
                            bodyText: "Impossibile visualizzare il dettaglio",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                    });
            } else {
                $log.info("Impossibile visualizzare il dettaglio");
            }
        };

        $scope.totale = function (estr) {
            $scope.tot = $scope.tot + parseInt(estr);
        };

        /* EXPORT DATI */

        $scope.iniziaExport = function () {
        	
        	//SM_8906
        	$rootScope.numeroDatiEsportati = $scope.koCaut.length;
        	
            var bodyData = {
                "userId": $rootScope.timnowConfigData.user.userId,
                "idRichiesta": [],
                "codOloAgcom": $rootScope.timnowConfigData.user.codificaOloAgcom,
                "tipoProfilo": $rootScope.timnowConfigData.user.codiceProfilo,
                "tipoLista": "TUTTI"
            };

            return MonitoraggioKOCautelare.get({
                flagExport: true,
                level:'level0'
            }, bodyData).$promise;
        };
    }]);
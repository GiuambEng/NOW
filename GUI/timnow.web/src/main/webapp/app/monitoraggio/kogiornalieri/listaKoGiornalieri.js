timnow
    .controller('listakoGiornal', ['$scope', '$state', '$rootScope', 'MonitoraggioKOGiornalieri', '$log', 'modalService',
        function ($scope, $state, $rootScope, MonitoraggioKOGiornalieri, $log, modalService) {

            $scope.loading = true;
            $scope.tot = 0;

            $scope.conn = $rootScope.timnowConfigData.config;
            $scope.pageSize = $scope.conn.tablesPagesize;
            $scope.pageInit = $scope.pageSize.split(',');
            $scope.visLim = $scope.pageInit[0];
            $scope.numList = $scope.pageInit[0];

            init();

            function init() {
                MonitoraggioKOGiornalieri.get({flagExport: false, level:'level0'}).$promise.then(function (response) {
                        if (response.data) {
                            $scope.koGiornal = response.data;
                        }
                        if ($scope.koGiornal.length === 0) {
                            $scope.errorDate = true;
                            $scope.msg_err = "Nessun dato da visualizzare";
                        }
                        $scope.loading = false;
                    },
                    function (error) {
                        $log.debug(error);
                        $scope.errorDate = true;
                        $scope.loading = false;
                        $scope.msg_err = "Impossibile visualizzare i KO giornalieri";
                    });

            }

            $scope.changeList = function (item) {
                $scope.numList = item;
            };

            $scope.dettaglio = function (codCausaleOlo, ambito) {
                if (codCausaleOlo && ambito) {
                    var ordDetails = MonitoraggioKOGiornalieri.get({
                        codCausaleOlo: codCausaleOlo,
                        ambito: ambito,
                        flagExport: false,
                        level:'level1'
                    });

                    return ordDetails.$promise.then(
                        function (response) {

                            if (response.data.length > 0) {
                                $scope.datiModaleDettaglio = [];
                                $scope.datiModaleDettaglio.selFamily = codCausaleOlo;
                                $scope.datiModaleDettaglio.response = [];
                                angular.forEach(response.data, function (value) {

                                    $scope.datiModaleDettaglio.response.push([
                                        {label: "Data Creazione Richiesta", valore: value.dataCreazioneRichiesta},
                                        {label: "Codifica OAO", valore: value.codificaOAO},
                                        {label: "Codice OAO", valore: value.codiceOAO},
                                        {label: "Ordine TI", valore: value.ordineTI},
                                        {label: "Stato NOW", valore: value.statoNOW},
                                        {label: "Stato OLO", valore: value.statoOLO},
                                        {label: "Id Risorsa", valore: value.idRisorsa},
                                        {label: "DRO", valore: value.dro},
                                        {label: "Ambito", valore: value.ambito},
                                        {label: "Offerta", valore: value.offerta},
                                        {label: "Id Richiesta", valore: value.idRichiesta}]);
                                });

                                $scope.modalDettaglioKoGiornal = {
                                    headerText: 'Dettaglio KO allarme Giornaliero',
                                    actionButtonText: null,
                                    closeButtonText: 'Ok',
                                    contentType: 'table_Dett',
                                    scope: $scope,
                                    data: $scope.datiModaleDettaglio,
                                    valueFamily: $scope.selFamily
                                };

                                modalService.showModal({}, $scope.modalDettaglioKoGiornal);
                            } else {
                                modalService.showModal({}, {
                                    headerText: "KO allarme Giornaliero",
                                    bodyText: "Non è presente alcun dettaglio",
                                    actionButtonText: 'Chiudi',
                                    type: 'warning'
                                });
                            }

                        },

                        function (error) {
                            $log.debug(error);
                            $scope.errorDetail = true;
                            $scope.msg_err = "Impossibile visualizzare i KO su OLO";
                            modalService.showModal({}, {
                                headerText: "Errore Dettaglio KO allarme Giornaliero",
                                bodyText: "Impossibile visualizzare il dettaglio",
                                actionButtonText: 'Chiudi',
                                type: 'warning'
                            });
                        }
                    );
                } else {
                    modalService.showModal({}, {
                        headerText: "Errore Dettaglio KO allarme Giornaliero",
                        bodyText: "Impossibile visualizzare il dettaglio",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                    $log.info("Impossibile visualizzare il dettaglio");
                }
            };


            $scope.totale = function (estr) {
                $scope.tot = $scope.tot + parseInt(estr);
            };

            /* EXPORT DATI */
            $scope.iniziaExport = function () {
                var bodyData = {
                    "userId": $rootScope.timnowConfigData.user.userId,
                    "idRichiesta": [],
                    "codOloAgcom": $rootScope.timnowConfigData.user.codificaOloAgcom,
                    "tipoProfilo": $rootScope.timnowConfigData.user.codiceProfilo,
                    "tipoLista": "TUTTI"
                };
               
                //RU_902  //SM_8906
                $rootScope.numeroDatiEsportati = $scope.koGiornal.length
               
                return MonitoraggioKOGiornalieri.get({flagExport: true, level:'level0'}, bodyData).$promise;

            };
        }]);
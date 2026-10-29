timnow
    .controller('FileDettaglio', ['$scope', '$state', '$rootScope', 'MonitoraggioFile', '$log', 'modalService', function ($scope, $state, $rootScope, MonitoraggioFile, $log, modalService) {

        $rootScope.pageClass = 'listaFileDettaglio';

        //solo singola lista
        $scope.fileLoaded = false;
       
        $scope.modalDefs = {
                templateUrl: 'app/monitoraggio/file/requestDetailmodal.html'
            };

        $scope.modalRequestDetail = {
                scope: $scope
            };
        
        function init() {
            if ($state.params.dettaglio) {
                $scope.fileLoaded = false;
                if ($state.params.dettaglio.famiglia) {
                    MonitoraggioFile.save({type:'contatore'},{
                        descrizioneFamigliaOfferta: $state.params.dettaglio.famiglia,
                        dataAcquisizione: $state.params.dettaglio.data,
                        statoFileNow: $state.params.dettaglio.statoFileNow,
                        owner: $state.params.dettaglio.owner,
                        canaleAcquisizione: $state.params.dettaglio.canale,
                        flagExport: false
                    }).$promise.then(
                        function (response) {
                            $scope.fileLoaded = true;
                            if (response.data) {
                                $scope.file = response.data;
                                //aggiunto per nuovo json MonitoraggioFile
                                $scope.idFile = response.idFile;
                            } else {
                                modalService.showModal({}, {
                                    headerText: "Dettaglio Monitoraggio File",
                                    bodyText: "Nessun dettaglio disponibile",
                                    actionButtonText: 'Chiudi',
                                    type: 'warning'
                                });
                            }
                        },
                        function (error) {
                            $log.debug(error);
                            $scope.fileLoaded = true;
                            $scope.errorDetail = true;
                            $scope.msg_err = "Impossibile visualizzare il dettaglio dei File";
                            modalService.showModal({}, {
                                headerText: "Dettaglio Richiesta OLO",
                                bodyText: "Impossibile visualizzare il dettaglio",
                                actionButtonText: 'Chiudi',
                                type: 'warning'
                            });
                        }
                    );
                } else {
                    $log.info("Impossibile visualizzare il dettaglio");
                }
            } else {
                $state.go('root.monitoraggio.file');
            }
        }

        $scope.changeState = function () {
            $state.go($rootScope.fromState);
        };

        
        $scope.getDettaglioFile = function (idFileProcessato, contatore) {
            MonitoraggioFile.get({idFileProcessato: idFileProcessato, tipoContatore: contatore, type:'dettaglio'}).$promise.then(function (data) {
                $scope.modalRequestDetail.data = data;
                $scope.modalRequestDetail.selFamily = data.ordineTi;

                modalService.showModal($scope.modalDefs, $scope.modalRequestDetail);
                },
                function (error) {
                    $log.debug(error);
                    $scope.fileLoaded = true;
                    $scope.errorDetail = true;
                    $scope.msg_err = "Impossibile visualizzare il dettaglio dei File";
                    modalService.showModal({}, {
                        headerText: "Dettaglio Richiesta OLO",
                        bodyText: "Impossibile visualizzare il dettaglio",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });

                });
        };


        /* EXPORT DATI */

        $scope.iniziaExport = function () {

            return MonitoraggioFile.save({type:'contatore'},{
                descrizioneFamigliaOfferta: $state.params.dettaglio.famiglia,
                dataAcquisizione: $state.params.dettaglio.data,
                statoFileNow: $state.params.dettaglio.statoFileNow,
                owner: $state.params.dettaglio.owner,
                canaleAcquisizione: $state.params.dettaglio.canale,
                flagExport: true
            }).$promise;
        };

        init();
        
    }]);



(function () {
    "use strict";

    angular.module("common")
        .directive("nowExportFile", nowExportFileDirectives);

    function nowExportFileDirectives() {


        var directive = {
            restrict: 'E',
            templateUrl: 'app/common/export_file/template.html',
            scope: {
                exportCallback: '&',
                areaFunzione: '@',
                //SM_8904
                vista: '=',
                //RU_963
                fileType: '='
                	
            },
            controller: controller,
            controllerAs: 'nowExportFileController',
            bindToController: true
        };
        return directive;
    }

    controller.$inject = ['$log', '$scope', '$rootScope', '$state', '$window', 'filterFilter', 'modalService', 'ExportPoll', 'BASEPATH', '$interval', 'TrackingGUI'];
    function controller($log, $scope, $rootScope, $state, $window, filterFilter, modalService, ExportPoll, BASEPATH, $interval, TrackingGUI) {

        $scope.exportPollInterval = 5; // ogni quanti secondi fa il poll per l'export dati
        $scope.maxExportPoll = 24; // massimo di richieste di poll per l'export dati
        $scope.currentExportPoll = 1; // massimo di richieste di poll per l'export dati
        $scope.newExport = true;
        $scope.exportPercentage = 0;
        
        //RU_963
        $scope.fileType = $scope.nowExportFileController.fileType || null;

        //SM_8095
        $scope.allowedProfiles=["CRM_DG", "CRM_DG_CON", "CRM_DG_REG_UO", "CRM_DG_SUPER", "CRM_DG_CON_SUPER", "CRM_DG_REG_UO_SUPER"]; //RU_872 aggiunta profili super
        $scope.flagForProfiles = false
        function checkContrattoButtonProfile(){	
        	angular.forEach($scope.allowedProfiles, function(value){
        		if($rootScope.timnowConfigData.user.codiceProfilo===value)
        			$scope.flagForProfiles = true
        	})
        }
        checkContrattoButtonProfile();
        
        //RU_716 NUOVO CONTRATTO
        $scope.checkContrattoButton = function () {
        	if($rootScope.pageClass==="contratti" &&  $scope.flagForProfiles ) //SM_8095
        		return true;
        	else 
        		return false;
        };
        
        
        //RU_716 NUOVO CONTRATTO
        $scope.nuovoContratto = function () {
        	$state.go('root.anagrafica.contratto.nuovoContratto');
        }
        
        
        $scope.iniziaExport = function () {
            if ($scope.nowExportFileController.exportCallback && angular.isFunction($scope.nowExportFileController.exportCallback())) {
                $log.debug("directive callback ...");
                $scope.exporting = true;
                if (typeof $scope.nowExportFileController.areaFunzione === 'undefined'|| !$scope.nowExportFileController.areaFunzione){
                	$scope.nowExportFileController.areaFunzione="DEFAULT";
                }
                if (typeof $scope.nowExportFileController.areaFunzione !== 'undefined') $log.debug("export area = "+ $scope.nowExportFileController.areaFunzione);
                
                /////
                $scope.dataInizioExport = new Date();
                
                $scope.nowExportFileController.exportCallback()().then(
                    function (data) {
                        if (!data.idExportFile) {
                            modalService.showModal({}, {
                                headerText: "Errore",
                                bodyText: "Non e' stato possibile effettuare l'export. Prova piu' tardi.",
                                actionButtonText: 'Chiudi',
                                type: 'warning'
                            });
                            $scope.resetExport();
                            return;
                        }
                        $scope.export_id = decodeURIComponent(data.idExportFile);
                        $scope.ExportPromise = $interval($scope.pollExport, $scope.exportPollInterval * 1000);
                    }, function (error) {
                        $log.debug(error);
                        modalService.showModal({}, {
                            headerText: "Errore",
                            bodyText: "Non e' stato possibile effettuare l'export. Prova piu' tardi.",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                        $scope.resetExport();
                    });
            }
        };


        $scope.resetExport = function () {
            $interval.cancel($scope.ExportPromise);
            $scope.currentExportPoll = 1;
            $scope.exportPercentage = 0;
            $scope.export_id = null;
            $scope.exporting = false;
            
            //SM_8906
            $rootScope.numeroDatiEsportati = null;
            $rootScope.datiToSearch = [];

            $scope.dataInizioExport = null;
            $scope.dataFineExport = null;
            
        };

        $scope.pollExport = function () {
            if ($scope.currentExportPoll === $scope.maxExportPoll) {
            	
            	$scope.dataFineExport = new Date();
            	
                var filtriDati = $rootScope.datiToSearch ? $rootScope.datiToSearch : [];                        
                var filtriDatiToString = JSON.stringify(filtriDati);
            	
            	var _trackBean = {
            			timestampInizio: $scope.dataInizioExport.toISOString(),
            			timestampFine: $scope.dataFineExport.toISOString(),
            			descrizioneFunzione: $scope.nowExportFileController.vista,
            			numeroDatiEsportati: 0,
            			contenutoFile: null,
            			nomeFile: "Export fallito",
            			esito: 'Ko',
            			tipoOperazione: 'Export file',
            			parametriOperazione: filtriDatiToString
            	};
            	
            	//RU_1010
            	TrackingGUI.exportTracking(_trackBean).$promise
            		.then(function(data){
                        modalService.showModal({}, {
                            headerText: "Errore Export " + $scope.nowExportFileController.vista,
                            bodyText: "La generazione del file sta richiedendo piu' tempo del previsto. Riprova piu' tardi.",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        }); 
            		}, function(error){
            			
            		});               
                
                $scope.resetExport();
                return;
            }
            $scope.currentExportPoll++;
            $scope.exportPercentage = ($scope.currentExportPoll * 100) / $scope.maxExportPoll;
            $log.debug('$scope.currentExportPoll: ', $scope.currentExportPoll);
            $log.debug('$scope.exportPercentage: ', $scope.exportPercentage);
            if (typeof $scope.nowExportFileController.areaFunzione === 'undefined'|| !$scope.nowExportFileController.areaFunzione){
            	$scope.nowExportFileController.areaFunzione="DEFAULT";
            }
            ExportPoll.get({idExport: $scope.export_id, areaFunzione: $scope.nowExportFileController.areaFunzione}).$promise.then(
                function (data) {
                    if (data.codice === 'OK') {
                        $log.debug('finito');
                        if (typeof $scope.nowExportFileController.areaFunzione === 'undefined'|| !$scope.nowExportFileController.areaFunzione){
                        	$scope.nowExportFileController.areaFunzione="DEFAULT";
                        }
                        $interval.cancel($scope.ExportPromise);
                        
                        //RU_902
                        var numeroDatiEsportati = $rootScope.numeroDatiEsportati ? $rootScope.numeroDatiEsportati : "";
                        var filtriDati = $rootScope.datiToSearch ? $rootScope.datiToSearch : [];                        
                        var filtriDatiToString = JSON.stringify(filtriDati);
                        //SM_8904
                        var vista = $scope.nowExportFileController.vista;
                        location.href = BASEPATH + 'exportdata/file?idFile='+ $scope.export_id+'&areaFunzione='+$scope.nowExportFileController.areaFunzione+'&numeroDatiEsportati='+numeroDatiEsportati+'&filtriDatiEsportati='+filtriDatiToString+'&vista='+vista;
                        
                        $scope.resetExport();
                    } else if (data.codice === 'KO' && data.result.code === '1') {
                        $log.debug('continua polling');
                    } else {
                        modalService.showModal({}, {
                            headerText: "Errore",
                            bodyText: "Non e' stato possibile effettuare l'export. Prova piu' tardi.",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                        $scope.resetExport();
                        return;
                    }
                }, function (error) {
                    $log.debug(error);
                    modalService.showModal({}, {
                        headerText: "Errore",
                        bodyText: "Non e' stato possibile effettuare l'export. Prova piu' tardi.",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
                    $scope.resetExport();
                });
        };

        $scope.$on("$destroy", function () {
            if ($scope.exporting) {
                modalService.showModal({}, {
                    headerText: "Export dati in corso, vuoi continuare o terminare il processo?",
                    bodyText: "Se decidi di continuare, il file verrà scaricato automaticamente appena pronto.",
                    actionButtonText: 'Termina',
                    closeButtonText: 'Continua',
                    scope: $scope,
                    callbackFunction: 'resetExport',
                    type: 'warning'
                });
            }
        });
    }
})();
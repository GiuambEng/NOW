timnow.controller('userTaskController',['$scope','$rootScope','$log','$filter','modalService','UserTask','USER_TASK_ACTION', 'TRACKING_GUI', 'TrackingGUI',
                function($scope, $rootScope, $log, $filter, modalService, UserTask, USER_TASK_ACTION, TRACKING_GUI, TrackingGUI) {

                    $scope.init = function() {
                        $rootScope.pageClass = 'userTask';
                        $scope.listaUserTask = [];
                        $scope.showSpinner = true;
                        $scope.listLoaded = true;
                        $scope.showAction = false;
                        $scope.showNack = false;
                        $scope.showErrate = false;
                        $scope.causaleModificata = null;
                        $scope.causaleDaImpostare = null;
                        $scope.causaleImpropriaSelezionata = null;
                        $scope.causaleErrataSelezionata = null;
                        $scope.causaleSbagliataSelezionata = null;
                        $scope.causaleModificataErrata = null;
                        $scope.causaleDaImpostareErrata = null;
                        $scope.azioneSelezionata = null;
                        $scope.selectOffertaImproprie = [];
                        $scope.selectTipoLavorazioneImproprie = [];
                        $scope.selectOffertaErrate = [];
                        $scope.selectTipoLavorazioneErrate = [];
                        $scope.offertaImpropriaSelezionata = null;
                        $scope.tipoLavorazioneImpropriaSelezionata = null;
                        $scope.offertaErrataSelezionata = null;
                        $scope.tipoLavorazioneErrataSelezionata = null;

                        $scope.azioni = [ USER_TASK_ACTION.SKIP, USER_TASK_ACTION.SKIP_MOD, USER_TASK_ACTION.RETRY ];
                        $scope.tipologiaErrata = 'User Task Errate';
                        $scope.tipologiaSbagliata = 'User Task Sbagliate';
                        $scope.tipologiaImpropria = 'User Task Improprie';
                        $scope.tipologiaRicerca = 'User Task';

                        $scope.userTaskCausaliImproprieFiltrate = [];
                        $scope.userTaskOffertaImproprieFiltrate = [];
                        $scope.userTaskTipologiaLavorazioneImproprieFiltrate = [];
                        $scope.userTaskCausaliErrateFiltrate = [];
                        $scope.userTaskOffertaErrateFiltrate = [];
                        $scope.userTaskTipologiaLavorazioneErrateFiltrate = [];
                        $scope.detailArgErrata = [];
                        $scope.detailArgSbagliata = [];
                        $scope.detailArgImpropria = [];
                        $scope.detailArgImpropriaSkip = [];
                        $scope.detailArgImpropriaRetry = [];
                        $scope.dataContainer = [];
                        $scope.headerListErrate = [
                         {"key" : "delete","value" : "Seleziona","type" : "selectable"},
                         {"key" : "codiceOrdineOlo","value" : "Codice Ordine OAO","type" : "text"},
                         {"key" : "ordineTI","value" : "Ordine TI","type" : "text"},
                         {"key" : "causale","value" : "Causale","type" : "text"},
                         {"key" : "statoNOW","value" : "Stato NOW","type" : "text"},
                         {"key" : "statoOao","value" : "Stato OAO","type" : "text"},
                         {"key" : "codificaOAO","value" : "Codifica OAO","type" : "text"},
                         {"key" : "idRichiestaOlo","value" : "Id Richiesta","type" : "text"},
                         {"key" : "idAnagraficaCausale","value" : "Id Anagrafica Causale","type" : "text"},
                         {"key" : "codCausaleInterno","value" : "Codice Causale Interno","type" : "text"}, 
                         {"key" : "codCausaleNowDG","value" : "Codice Causale NOW DG","type" : "text"},
                         {"key" : "codCausaleOAO","value" : "Codice Causale OAO","type" : "text"},
                         {"key" : "causaleInterno","value" : "Causale Interno","type" : "text"},
                         {"key" : "causaleNowDG","value" : "Causale NOW DG","type" : "text"},
                         {"key" : "causaleOAO","value" : "Causale OAO","type" : "text"}
                         ];

                        $scope.headerListImproprie = [ 
                           {"key" : "delete","value" : "Seleziona","type" : "selectable"},
                           {"key" : "codiceOrdineOlo","value" : "Codice Ordine OAO","type" : "text"},
                           {"key" : "ordineTI","value" : "Ordine TI","type" : "text"},
                           {"key" : "causale","value" : "Causale","type" : "text"},
                           {"key" : "statoNOW","value" : "Stato NOW","type" : "text"},
                           {"key" : "statoOao","value" : "Stato OAO","type" : "text"},
                           {"key" : "codificaOAO","value" : "Codifica OAO","type" : "text"},
                           {"key" : "idRichiestaOlo","value" : "Id Richiesta","type" : "text"},
                           {"key" : "idAnagraficaCausale","value" : "Id Anagrafica Causale","type" : "text"},
                           {"key" : "codCausaleInterno","value" : "Codice Causale Interno","type" : "text"},
                           {"key" : "codCausaleNowDG","value" : "Codice Causale NOW DG","type" : "text"},
                           {"key" : "codCausaleOAO","value" : "Codice Causale OAO","type" : "text"},
                           {"key" : "causaleInterno","value" : "Causale Interno","type" : "text"},
                           {"key" : "causaleNowDG","value" : "Causale NOW DG","type" : "text"},
                           {"key" : "causaleOAO","value" : "Causale OAO","type" : "text"}
                           ];

                        $scope.headerListSbagliate = [
                          {"key" : "delete","value" : "Seleziona","type" : "selectable"},
                          {"key" : "codiceOrdineOlo","value" : "Codice Ordine OAO","type" : "text"},
                          {"key" : "ordineTI","value" : "Ordine TI","type" : "text"},
                          {"key" : "causale","value" : "Causale","type" : "text"},
                          {"key" : "statoNOW","value" : "Stato NOW","type" : "text"},
                          {"key" : "statoOao","value" : "Stato OAO","type" : "text"},
                          {"key" : "codificaOAO","value" : "Codifica OAO","type" : "text"} ];

                        $scope.modalDefsResponse = {
                            templateUrl : 'app/monitoraggio/usertask/conferma.modal.html'
                        };

                        $scope.headerSelezionaCausale = [ {"key" : "idCausaleDaImpostare","value" : "Id Causale Da Impostare","type" : "text"},
                                                          {"key" : "causaleDaImpostare","value" : "Causale Da Impostare","type" : "text"}
                        ];

                        $scope.modalOptionsProfiloTecnicoLinea = {
                            headerText : 'Seleziona la Causale',
                            actionButtonText : null,
                            closeButtonText : 'Ok',
                            contentType : 'modale_nowtable',
                            scope : $scope,
                            callbackFunction : 'callbackCausale',
                            dataHeader : $scope.headerSelezionaCausale,
                            templateUrl : 'app/common/templates.html',
                            data : []
                        };
                        
                    	//RU_1010
                        //Tracking da GUI per operazione RICERCA AVANZATA
                        var _trackBean = {
            	    			timestampInizio: new Date().toISOString(),
            	    			timestampFine: null,
            	    			numeroDatiEsportati: 0,
            	    			contenutoFile: null,
            	    			descrizioneFunzione: 'Monitoraggio|Gestione User Task',
            	    			nomeFile: null,
            	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
            	    			parametriOperazione: null			
                        };
                        
                        // caricamento di tutti gli usertask
                        UserTask.get().$promise.then(function(response) {
                        	
                        	_trackBean.timestampFine = new Date().toISOString();                        	
                            _trackBean.esito = 'Ok';                        
                            TrackingGUI.tracking(_trackBean);
                        	
                            if (response.userTaskCausaliImproprie && response.userTaskCausaliImproprie.length > 0) {
                                $scope.showAction = true;
                                var causaliImproprie = response.userTaskCausaliImproprie;
                                $scope.userTaskCausaliImproprie = angular.copy(causaliImproprie);
                                $scope.userTaskCausaliImproprieSkip = angular.copy(causaliImproprie);
                                $scope.userTaskCausaliImproprieRetry = angular.copy(causaliImproprie);
                                // precaricamento select offerta
                                $scope.selectOffertaImproprie = $scope.getUnique($scope.userTaskCausaliImproprie, 'offerta');
                                $scope.showSpinner = false;
                            } else {
                                $scope.showAction = false;
                                $scope.showSpinner = false;
                            }
                            if (response.userTaskCausaliSbagliate && response.userTaskCausaliSbagliate.length > 0) {
                                $scope.userTaskCausaliSbagliate = response.userTaskCausaliSbagliate;
                                $scope.showNack = true;
                            } else {
                                $scope.showNack = false;
                            }
                            if (response.userTaskCausaliErrate && response.userTaskCausaliErrate.length > 0) {
                                $scope.userTaskCausaliErrate = response.userTaskCausaliErrate;
                                $scope.userTaskCausaliErrateFiltrate= response.userTaskCausaliErrate;
                                $scope.showErrate = true;
                                // precaricamento select offerta Errate
                                $scope.selectOffertaErrate = $scope.getUnique($scope.userTaskCausaliErrate, 'offerta');
                            } else {
                                $scope.showErrate = false;
                            }
                            if ((!$scope.showAction) && (!$scope.showNack) && (!$scope.showErrate)) {
                                modalService.showModal({}, {
                                    headerText : "User Task",
                                    bodyText : "Non ci sono User Task disponibili.",
                                    actionButtonText : 'Chiudi',
                                    type : 'warning'
                                });
                                $scope.showSpinner = false;
                            }
                        }, function(error) {
                            $log.debug(error);
                            modalService.showModal({}, {
                                headerText : "User Task",
                                bodyText : "Non e' stato possibile ricevere gli User Task. Riprovare più tardi.",
                                actionButtonText : 'Chiudi',
                                type : 'warning'
                            });
                            $scope.showSpinner = false;
                            
                        	_trackBean.timestampFine = new Date().toISOString();                        	
                            _trackBean.esito = 'Ko';                        
                            TrackingGUI.tracking(_trackBean);
                        });
                    };

                    $scope.isCausaleImpropriaSelezionata = function(value) {
                        $log.info($scope.causaleImpropriaSelezionata);
                        if (value && $scope.causaleImpropriaSelezionata && $scope.causaleImpropriaSelezionata.causale === value.causale) {
                            return true;
                        } else {
                            return false;
                        }
                    };

                    $scope.isCausaleErrataSelezionata = function(value) {
                        $log.info($scope.causaleErrataSelezionata);
                        if (value && $scope.causaleErrataSelezionata && $scope.causaleErrataSelezionata.causale === value.causale) {
                            return true;
                        } else {
                            return false;
                        }
                    };

                    
                    // -----------------------------
                    $scope.isOffertaSelezionata = function(type) {
                        
                        if ('improprio'===type){
                            $log.info($scope.offertaImpropriaSelezionata);
                            if ($scope.offertaImpropriaSelezionata && $scope.offertaImpropriaSelezionata.offerta !== "") {
                                return true;
                            } else {
                                return false;
                            }
                        }else{
                            $log.info($scope.offertaErrataSelezionata);
                            if ($scope.offertaErrataSelezionata && $scope.offertaErrataSelezionata.offerta !== "") {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    };

                    // -------------------------------
                    $scope.isTipologiaLavorazioneSelezionata = function(type) {
                        if ('improprio'===type){
                            $log.info($scope.tipoLavorazioneImpropriaSelezionata);
                            if ($scope.tipoLavorazioneImpropriaSelezionata
                                    && $scope.tipoLavorazioneImpropriaSelezionata.tipoLavorazione !== "") {
                                return true;
                            } else {
                                return false;
                            }
                        }else{
                            $log.info($scope.tipoLavorazioneErrataSelezionata);
                            if ($scope.tipoLavorazioneErrataSelezionata
                                    && $scope.tipoLavorazioneErrataSelezionata.tipoLavorazione !== "") {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    };

                    
                    $scope.isCausaleSbagliataSelezionata = function(value) {
                        if (value && $scope.causaleSbagliataSelezionata && $scope.causaleSbagliataSelezionata.causale === value.causale) {
                            return true;
                        } else {
                            return false;
                        }
                    };

                    // set Azione per user task per scarto improprio
                    $scope.setAzione = function(azioneSelezionata) {
                    	$scope.azioneSelezionata = azioneSelezionata;
                        $scope.offertaImpropriaSelezionata = null;
                        $scope.tipoLavorazioneImpropriaSelezionata = null;
                        $scope.causaleImpropriaSelezionata = null;
                        $scope.userTaskCausaliImproprieFiltrate = $scope.userTaskCausaliImproprie;
                    };

                    // set Offerta per user task per scarto improprio e errate e resetto tipolavorazione
                    $scope.setOfferta = function(offSel,type) {
                        if ("improprio"===type){
                            $scope.offertaImpropriaSelezionata = offSel.offerta;
                            $scope.tipoLavorazioneImpropriaSelezionata=null;
                            $scope.causaleImpropriaSelezionata=null;
                            $scope.selectTipoLavorazioneImproprie = $scope.getUnique($filter('filter')($scope.userTaskCausaliImproprie, {
                                'offerta' : $scope.offertaImpropriaSelezionata}), 'tipoLavorazione');
                        }else{
                            $scope.offertaErrataSelezionata = offSel.offerta;
                            $scope.tipoLavorazioneErrataSelezionata=null;
                            $scope.causaleErrataSelezionata=null;
                            $scope.selectTipoLavorazioneErrate = $scope.getUnique($filter('filter')($scope.userTaskCausaliErrate, {
                                'offerta' : $scope.offertaErrataSelezionata}), 'tipoLavorazione');
                        }
                        
                    };

                    // set TipologiaLavorazione per user task per scarto
                    // improprio
                    $scope.setTipologiaLavorazione = function(tipoLavSel,type) {
                    	if ("improprio"===type && tipoLavSel){
                            $scope.tipoLavorazioneImpropriaSelezionata = tipoLavSel.tipoLavorazione;
                        }else if(tipoLavSel){
                            $scope.tipoLavorazioneErrataSelezionata = tipoLavSel.tipoLavorazione;
                        }
                    	$scope.causaleImpropriaSelezionata=null;
               		 	$scope.causaleErrataSelezionata=null;
                    };

                    // INVIO user task CAUSALI ERRATE
                    $scope.rinviaUserTaskErrate = function(detailArgErrata) {
                        if (detailArgErrata.length === 0) {
                            modalService.showModal({}, {
                                headerText : "User Task",
                                bodyText : "Devi selezionare almeno una user task da inviare.",
                                actionButtonText : 'Chiudi',
                                type : 'warning'
                            });
                        } else {
                            $scope.detailArgErrata = detailArgErrata;
                            $scope.changeCausale('errate');
                        }
                    };

                    // INVIO user task causali nack da dtu
                    $scope.rinviaUserTaskSbagliate = function(detailArgSbagliata) {
                        $scope.detailArgSbagliata = detailArgSbagliata;
                        var userTask = [];
                        for (var index = 0; index < $scope.detailArgSbagliata.length; index++) {
                            userTask.push({
                                "causale" : $scope.detailArgSbagliata[index].idAnagraficaCausale,
                                "idWorkItem" : $scope.detailArgSbagliata[index].idWorkItem,
                                "version" : $scope.detailArgSbagliata[index].version,
                                "azione" : USER_TASK_ACTION.SKIP_MOD.key
                            });
                        }

                        if (userTask.length) {
                            $scope.showSpinner = true;
                            var successCallback = function(response) {
                                if (response.listUserTaskResultSbagliateDTU && response.listUserTaskResultSbagliateDTU.length > 0) {
                                    response.listUserTaskResultSbagliateDTU.header = $scope.modaleHeader;
                                    $scope.modalForResponse = {
                                        data : response.listUserTaskResultSbagliateDTU,
                                        scope : $scope
                                    };

                                    modalService.showModal($scope.modalDefsResponse, $scope.modalForResponse);
                                } else {
                                    modalService.showModal({}, {
                                        headerText : "User Task",
                                        bodyText : "La lavorazione è stata presa in carico.",
                                        actionButtonText : 'Chiudi'
                                    });
                                }

                                $scope.showSpinner = false;
                                $scope.init();
                            };

                            var errorCallback = function(error) {
                                $log.debug(error);
                                modalService.showModal({}, {
                                    headerText : "User Task",
                                    bodyText : "Non e' stato possibile avviare la presa in carico. Riprovare piu' tardi.",
                                    actionButtonText : 'Chiudi',
                                    type : 'warning'
                                });
                                $scope.showSpinner = false;

                            };

                            UserTask.rinvia({
                                modUserTaskCausaliSbagliate : userTask
                            }, successCallback, errorCallback);
                        }
                    };

                    // caricamento della lista "Seleziona nuova causale"
                    $scope.changeCausale = function(item) {
                        $scope.showSpinner = true;
                        $log.debug("Inside Change Causale: " + item);
                        var inputLoadCausaliList;
                        if (item === "improprio") {
                            inputLoadCausaliList = $scope.userTaskCausaliImproprie[0];
                            $scope.modalOptionsProfiloTecnicoLinea.callbackFunction = 'callbackCausaleImproprie';
                            $scope.modalOptionsProfiloTecnicoLinea.actionButtonText = 'Continua';
                        } else {
                            inputLoadCausaliList = $scope.userTaskCausaliErrate[0];
                            $scope.modalOptionsProfiloTecnicoLinea.callbackFunction = 'callbackCausaleErrate';
                            $scope.modalOptionsProfiloTecnicoLinea.actionButtonText = 'Continua';
                        }
                        $scope.listaCausali = [];
                        UserTask.get({
                            idRichiestaOlo : inputLoadCausaliList.idRichiestaOlo,
                            idWorkItem : inputLoadCausaliList.idWorkItem
                        }).$promise.then(function(response) {
                            $scope.showSpinner = false;
                            $scope.modalOptionsProfiloTecnicoLinea.data = response.data;
                            modalService.showModal({}, $scope.modalOptionsProfiloTecnicoLinea);

                        }, function(error) {
                            $log.debug(error);
                            modalService.showModal({}, {
                                headerText : "User Task",
                                bodyText : "Non e' stato possibile caricare le causali",
                                actionButtonText : 'Chiudi',
                                type : 'error'
                            });
                            $scope.showSpinner = false;
                        });
                    };

                    $scope.callbackCausaleImproprie = function(item) {
                        $log.debug(item);
                        $scope.causaleModificata = item.idCausaleDaImpostare;
                        $scope.causaleDaImpostare = item.causaleDaImpostare;
                        var userTask = [];
                        var causaleMod = ($scope.causaleModificata != null);
                        if (!causaleMod) {
                            modalService.showModal({}, {
                                headerText : "User Task",
                                bodyText : "Per inviare devi essere selezionata una nuova causale.Riprova l'invio.",
                                actionButtonText : 'Chiudi'
                            });
                        } else {
                            for (var index = 0; index < $scope.detailArgImpropria.length; index++) {
                                userTask.push({
                                    "causale" : $scope.causaleModificata,
                                    "idWorkItem" : $scope.detailArgImpropria[index].idWorkItem,
                                    "version" : $scope.detailArgImpropria[index].version,
                                    "azione" : $scope.azioneSelezionata.key,
                                });
                            }

                            if (userTask.length) {
                                $scope.showSpinner = true;
                                var successCallback = function(response) {
                                    if (response.listUserTaskResultImproprie && response.listUserTaskResultImproprie.length > 0) {
                                        response.listUserTaskResultImproprie.header = $scope.modaleHeader;
                                        $scope.modalForResponse = {
                                            data : response.listUserTaskResultImproprie,
                                            scope : $scope
                                        };

                                        modalService.showModal($scope.modalDefsResponse, $scope.modalForResponse);
                                    } else {
                                        modalService.showModal({}, {
                                            headerText : "User Task",
                                            bodyText : "La lavorazione è stata presa in carico.",
                                            actionButtonText : 'Chiudi'
                                        });
                                    }

                                    $scope.showSpinner = false;
                                    $scope.init();
                                    $scope.cancellaSelezioneCausale();
                                };

                                var errorCallback = function(error) {
                                    $log.debug(error);
                                    modalService.showModal({}, {
                                        headerText : "User Task",
                                        bodyText : "Non e' stato possibile avviare la presa in carico. Riprovare piu' tardi.",
                                        actionButtonText : 'Chiudi',
                                        type : 'warning'
                                    });
                                    $scope.showSpinner = false;

                                };

                                UserTask.rinvia({
                                    modUserTaskCausaliImproprie : userTask
                                }, successCallback, errorCallback);
                            }

                        }
                    };

                    $scope.callbackCausaleErrate = function(item) {
                        var userTask = [];
                        $log.debug(item);
                        $scope.causaleModificataErrata = item.idCausaleDaImpostare;
                        $scope.causaleDaImpostareErrata = item.causaleDaImpostare;
                        var causaleMod = ($scope.causaleModificataErrata != null);
                        if (!causaleMod) {
                            modalService.showModal({}, {
                                headerText : "User Task",
                                bodyText : "Per inviare devi essere selezionata una nuova causale.Riprova l'invio.",
                                actionButtonText : 'Chiudi'
                            });
                        } else {
                            for (var index = 0; index < $scope.detailArgErrata.length; index++) {
                                userTask.push({
                                    "causale" : $scope.causaleModificataErrata,
                                    "idWorkItem" : $scope.detailArgErrata[index].idWorkItem,
                                    "version" : $scope.detailArgErrata[index].version,
                                    "azione" : USER_TASK_ACTION.SKIP.key
                                });
                            }

                            if (userTask.length) {
                                $scope.showSpinner = true;
                                var successCallback = function(response) {

                                    if (response.listUserTaskResultErrate && response.listUserTaskResultErrate.length > 0) {
                                        $scope.modalForResponse = {
                                            data : response.listUserTaskResultErrate,
                                            scope : $scope
                                        };

                                        modalService.showModal($scope.modalDefsResponse, $scope.modalForResponse);
                                    } else {
                                        modalService.showModal({}, {
                                            headerText : "User Task",
                                            bodyText : "La lavorazione è stata presa in carico.",
                                            actionButtonText : 'Chiudi'
                                        });
                                    }

                                    $scope.showSpinner = false;
                                    $scope.init();
                                };

                                var errorCallback = function(error) {
                                    $log.debug(error);
                                    modalService.showModal({}, {
                                        headerText : "User Task",
                                        bodyText : "Non e' stato possibile avviare la presa in carico. Riprovare piu' tardi.",
                                        actionButtonText : 'Chiudi',
                                        type : 'warning'
                                    });
                                    $scope.showSpinner = false;
                                };
                                UserTask.rinvia({
                                    modUserTaskCausaliErrate : userTask
                                }, successCallback, errorCallback);
                            }
                        }

                    };

                    // INVIO user task CAUSALI IMPROPRIE con modifica Causale
                    $scope.rinviaUserTaskImproprie = function(detailArgImpropria) {
                        if (detailArgImpropria.length === 0) {
                            modalService.showModal({}, {
                                headerText : "User Task",
                                bodyText : "Devi selezionare almeno una user task da inviare.",
                                actionButtonText : 'Chiudi',
                                type : 'warning'
                            });
                        } else {
                            $scope.detailArgImpropria = detailArgImpropria;
                            $scope.changeCausale('improprio');
                        }
                    };

                    // invio user task causali improprie senza nmodifica Causale
                    $scope.rinviaUserTaskImproprieSkip = function(detailArgImpropriaSkip) {
                        $scope.detailArgImpropriaSkip = detailArgImpropriaSkip;
                        var userTask = [];
                        for (var index = 0; index < $scope.detailArgImpropriaSkip.length; index++) {
                            userTask.push({
                                "causale" : $scope.detailArgImpropriaSkip[index].idAnagraficaCausale,
                                "idWorkItem" : $scope.detailArgImpropriaSkip[index].idWorkItem,
                                "version" : $scope.detailArgImpropriaSkip[index].version,
                                "azione" : $scope.azioneSelezionata.key,
                            });
                        }

                        if (userTask.length) {
                            $scope.showSpinner = true;
                            var successCallback = function(response) {
                                if (response.listUserTaskResultImproprie && response.listUserTaskResultImproprie.length > 0) {
                                    response.listUserTaskResultImproprie.header = $scope.modaleHeader;
                                    $scope.modalForResponse = {
                                        data : response.listUserTaskResultImproprie,
                                        scope : $scope
                                    };

                                    modalService.showModal($scope.modalDefsResponse, $scope.modalForResponse);
                                } else {
                                    modalService.showModal({}, {
                                        headerText : "User Task",
                                        bodyText : "La lavorazione è stata presa in carico.",
                                        actionButtonText : 'Chiudi'
                                    });
                                }

                                $scope.showSpinner = false;
                                $scope.init();
                                $scope.cancellaSelezioneCausale();

                            };

                            var errorCallback = function(error) {
                                $log.debug(error);
                                modalService.showModal({}, {
                                    headerText : "User Task",
                                    bodyText : "Non e' stato possibile avviare la presa in carico. Riprovare piu' tardi.",
                                    actionButtonText : 'Chiudi',
                                    type : 'warning'
                                });
                                $scope.showSpinner = false;

                            };

                            UserTask.rinvia({
                                modUserTaskCausaliImproprie : userTask
                            }, successCallback, errorCallback);
                        }
                    };

                    // invio user task causali improprie Risottomissione
                    $scope.rinviaUserTaskImproprieRetry = function(detailArgImpropriaRetry) {
                        $scope.detailArgImpropriaRetry = detailArgImpropriaRetry;
                        var userTask = [];
                        for (var index = 0; index < $scope.detailArgImpropriaRetry.length; index++) {
                            userTask.push({
                                "causale" : $scope.detailArgImpropriaRetry[index].idAnagraficaCausale,
                                "idWorkItem" : $scope.detailArgImpropriaRetry[index].idWorkItem,
                                "version" : $scope.detailArgImpropriaRetry[index].version,
                                "azione" : $scope.azioneSelezionata.key,
                            });
                        }

                        if (userTask.length) {
                            $scope.showSpinner = true;
                            var successCallback = function(response) {
                                if (response.listUserTaskResultImproprie && response.listUserTaskResultImproprie.length > 0) {
                                    response.listUserTaskResultImproprie.header = $scope.modaleHeader;
                                    $scope.modalForResponse = {
                                        data : response.listUserTaskResultImproprie,
                                        scope : $scope
                                    };

                                    modalService.showModal($scope.modalDefsResponse, $scope.modalForResponse);
                                } else {
                                    modalService.showModal({}, {
                                        headerText : "User Task",
                                        bodyText : "La lavorazione è stata presa in carico.",
                                        actionButtonText : 'Chiudi'
                                    });
                                }

                                $scope.showSpinner = false;
                                $scope.init();
                                $scope.cancellaSelezioneCausale();

                            };

                            var errorCallback = function(error) {
                                $log.debug(error);
                                modalService.showModal({}, {
                                    headerText : "User Task",
                                    bodyText : "Non e' stato possibile avviare la presa in carico. Riprovare piu' tardi.",
                                    actionButtonText : 'Chiudi',
                                    type : 'warning'
                                });
                                $scope.showSpinner = false;

                            };

                            UserTask.rinvia({
                                modUserTaskCausaliImproprie : userTask
                            }, successCallback, errorCallback);
                        }
                    };

                    $scope.getCausali = function($event,type) {
                        $event.preventDefault();
                        var headerSelezionaCausale = {
                                "idAnagraficaCausale" : "Id Anagrafica Causale",
                                "idRichiestaOlo" : "Id Richiesta Olo",
                                "codCausaleInterno" : "Codice Causale Interno",
                                "codCausaleNowDG" : "Codice Causale NOW DG",
                                "codCausaleOAO" : "Codice Causale OAO",
                                "causaleInterno" : "Codice Interno",
                                "causaleNowDG" : "Codice NOW DG",
                                "causaleOAO" : "Codice OAO"
                            };

                        var modalDefsResponse = {
                                templateUrl : 'app/monitoraggio/usertask/selezionaCausaleModal.html'
                            };

                        if ('improprio'===type){
                            // check dele select
                            if (($scope.isOffertaSelezionata('improprio')) && ($scope.isTipologiaLavorazioneSelezionata('improprio'))) {

                                // filter offerta e tipolavorazione
                                var causaliImproprie = $filter('filter')($scope.userTaskCausaliImproprie, {
                                    'offerta' : $scope.offertaImpropriaSelezionata, 'tipoLavorazione' : $scope.tipoLavorazioneImpropriaSelezionata
                                });
                                
                                if (causaliImproprie <= 0) {
                                    erroreService("Non sono stati trovate causali");
                                } else {
                                    var modalOptionsTabellaCausali = {
                                        headerText : 'Seleziona una Causale',
                                        actionButtonText : null,
                                        closeButtonText : 'Ok',
                                        contentType : 'table_sb',
                                        scope : $scope,
                                        callbackFunction : 'callbackCausali',
                                        dataHeader : headerSelezionaCausale,
                                        data : $scope.getUnique(causaliImproprie, 'causale')
                                    };

                                    modalService.showModal(modalDefsResponse, modalOptionsTabellaCausali);
                                }
                            }else{
                                modalService.showModal({}, {
                                    headerText : "Avviso",
                                    closeButtonText : 'Chiudi',
                                    bodyText : "Per selezionare la causale da modificare devi selezionare Offerta e Tipologia Lavorazione",
                                    type : 'success'
                                });
                            }
                            
                        }else{
                            // check ERRATE
                            if (($scope.isOffertaSelezionata('errata')) && ($scope.isTipologiaLavorazioneSelezionata('errata'))) {

                                // filter offerta e tipolavorazione
                                var causaliErrate = $filter('filter')($scope.userTaskCausaliErrate, {
                                    'offerta' : $scope.offertaErrataSelezionata, 'tipoLavorazione' : $scope.tipoLavorazioneErrataSelezionata
                                });
                                
                                if (causaliErrate <= 0) {
                                    erroreService("Non sono stati trovate causali");
                                } else {
                                    var modalOptionsTabellaCausaliErrate = {
                                        headerText : 'Seleziona una Causale',
                                        actionButtonText : null,
                                        closeButtonText : 'Ok',
                                        contentType : 'table_sb',
                                        scope : $scope,
                                        callbackFunction : 'callbackCausaliErrate',
                                        dataHeader : headerSelezionaCausale,
                                        data : $scope.getUnique(causaliErrate, 'causale')
                                    };

                                    modalService.showModal(modalDefsResponse, modalOptionsTabellaCausaliErrate);
                                }
                            }else{
                                modalService.showModal({}, {
                                    headerText : "Avviso",
                                    closeButtonText : 'Chiudi',
                                    bodyText : "Per selezionare la causale da modificare devi selezionare Offerta e Tipologia Lavorazione",
                                    type : 'success'
                                });
                            }
                            
                        }
                    };

                    // get unique
                    $scope.getUnique = function(array, type) {
                        var tmp = {}, result = [];
                        if ("causale" === type) {
                            for (var i = 0, li = array.length; i < li; ++i) {
                                if (tmp.hasOwnProperty(array[i].idAnagraficaCausale)) {
                                    continue;
                                }
                                result.push(array[i]);
                                tmp[array[i].idAnagraficaCausale] = 1;
                            }

                        }
                        if ("offerta" === type) {
                            for (var j = 0, lj = array.length; j < lj; ++j) {
                                if (tmp.hasOwnProperty(array[j].offerta)) {
                                    continue;
                                }
                                result.push(array[j]);
                                tmp[array[j].offerta] = 1;
                            }

                        }

                        if ("tipoLavorazione" === type) {
                            for (var k = 0, lk = array.length; k < lk; ++k) {
                                if (tmp.hasOwnProperty(array[k].tipoLavorazione)) {
                                    continue;
                                }
                                result.push(array[k]);
                                tmp[array[k].tipoLavorazione] = 1;
                            }

                        }
                        return result;
                    };

                    $scope.cancellaSelezioneCausale = function() {
                        $scope.causaleImpropriaSelezionata = undefined;
                        $scope.causaleErrataSelezionata = undefined;
                        $scope.causaleModificata = null;

                    };

                    $scope.callbackCausali = function(item) {
                            //improprio
                            $scope.causaleImpropriaSelezionata = item;
                            $scope.userTaskCausaliImproprieFiltrate = $filter('filter')($scope.userTaskCausaliImproprie, {
                                'offerta' : $scope.offertaImpropriaSelezionata, 'tipoLavorazione' : $scope.tipoLavorazioneImpropriaSelezionata,
                                'idAnagraficaCausale' : item.idAnagraficaCausale
                            });
                    };

                    $scope.callbackCausaliErrate = function(item) {
                             //errate
                            $scope.causaleErrataSelezionata = item;
                            $scope.userTaskCausaliErrateFiltrate = $filter('filter')($scope.userTaskCausaliErrate, {
                                'offerta' : $scope.offertaErrataSelezionata, 'tipoLavorazione' : $scope.tipoLavorazioneErrataSelezionata,
                                'idAnagraficaCausale' : item.idAnagraficaCausale
                            });
                    };

                    
                    function erroreService(messageBody) {
                        modalService.showModal({}, {
                            headerText : "Avviso",
                            closeButtonText : 'Chiudi',
                            bodyText : messageBody,
                            scope : $scope,
                            type : 'success'
                        });
                        $scope.caricaPassFive = false;
                    }

                    $scope.init();
                } ]);
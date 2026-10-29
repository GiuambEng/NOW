timnow
    .controller('listaBozze', ['$scope', '$interval', '$state', '$rootScope', 'Draft', '$log', 'modalService', '$timeout', 'CRM_PROFILE', 'TRACKING_GUI', 'TrackingGUI',
    	function ($scope, $interval, $state, $rootScope, Draft, $log, modalService, $timeout, CRM_PROFILE, TRACKING_GUI, TrackingGUI) {

        $rootScope.pageClass = 'ordini-bozza';

        $scope.orders = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];
        $scope.tipologia = "Ordini in Bozza";
        $scope.detailList = [];
        $scope.keyDetail = "codOrdineOlo";
        $scope.detailArg = [];
        $scope.dataContainer = [];
        $scope.abilitato = false;
        var ut_profile = $rootScope.timnowConfigData.user;

        function init() {
            var ordini = Draft.get();
            ordini.$promise.then(
                function (data) {
                    if (data.data)$scope.orders = data.data;
                    $scope.datiLoaded = true;

                }, function (error) {
                    $scope.datiLoaded = true;
                    $log.info(error);
                    $log.info("Impossibile caricare bozze");
                });
        }

        $scope.conn = $rootScope.timnowConfigData.config;

        //Task #34215
        if (
            ut_profile.codiceProfilo === CRM_PROFILE.CRM_DG ||
            ut_profile.codiceProfilo === CRM_PROFILE.CRM_DG_SUPER ||
            ut_profile.codiceProfilo === CRM_PROFILE.CRM_OLO  ||
            ut_profile.codiceProfilo === CRM_PROFILE.CRM_OLO_SUPER
        ) {
            $scope.abilitato = true;
            $scope.headerList.push({"key": "delete", "value": "Seleziona", "type": "selectable"});
        }
        $scope.headerList.push({"key": "codOrdineOlo", "value": "Codice Ordine OAO", "type": "text"});
        $scope.headerList.push({"key": "tipologiaLavorazione", "value": "Causale Ordine", "type": "text"});
        $scope.headerList.push({"key": "ultimoAggiornamento", "value": "Ultimo Aggiornamento", "type": "data", "pattern": "dd/MM/yyyy"});
        $scope.headerList.push({"key": "userId", "value": "Utente", "type": "text"});
        $scope.headerList.push({"key": "codOloNum", "value": "Codice OAO", "type": "text"});
        $scope.headerList.push({"key": "codOloAgcom", "value": "Codifica OAO", "type": "text"});
        $scope.headerList.push({"key": "note", "value": "Note", "type": "text"});


        $scope.deleteItem = function () {
            $scope.datiLoaded = false;
            
            //RU_1010
            //Tracking da GUI per operazione INSERIMENTO
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			descrizioneFunzione: 'Ordini|Ordini in bozza|Cancellazione',
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
	    			parametriOperazione: null 			
            };

            var successCallback = function (response) {
                $scope.messaggio = "Ordine Cancellato";
                $timeout(function () {
                    $scope.messaggio = "";
                }, 3000);
                
                _trackBean.timestampFine = new Date().toISOString();
                _trackBean.esito = 'Ok';
                TrackingGUI.tracking(_trackBean);
                
                init();
            };

            var errorCallback = function (error) {
                $scope.messaggio = "Ordine Non Cancellato";
                $log.debug(error);
                $timeout(function () {
                    $scope.messaggio = "";
                }, 3000);                
                
                $scope.datiLoaded = true;                

                _trackBean.timestampFine = new Date().toISOString();
                _trackBean.esito = 'Ko';
                TrackingGUI.tracking(_trackBean);
            };

            var bozzaList = $scope.detailArg;


            for (var index = 0; index < bozzaList.length; index++) {

                var codordolo = bozzaList[index].codOrdineOlo;
                var OAO = bozzaList[index].codOloAgcom;
                //$log.info(codordolo);
                Draft.delete_draft({"codOloAgcom": OAO, "codOrdOlo": codordolo, "operationType": "delete"}, successCallback, errorCallback);
            }
        };

        $scope.getBozza = function () {
            Draft.get({
                codOloAgcom: $scope.detailArg.codOloAgcom,
                codOrdOlo: $scope.detailArg.codOrdineOlo,
                operationType: "get",
                listaOrdiniBozzaOp: "listaordinibozza"
            }).$promise.then(
                function (response) {

                    if(response.result && (response.result.code === '0')) {
                        var bozza = [];
                        bozza.nome = $scope.detailArg.codOrdineOlo;
                        bozza.note = $scope.detailArg.note;
                        bozza.codOloAgcom = $scope.detailArg.codOloAgcom;
                        bozza.corpo = JSON.parse(response.ordineBozza);

                        if(bozza.corpo.data && bozza.corpo.data.step4 && bozza.corpo.data.step4.dac){
                            bozza.corpo.data.step4.dac=new Date(bozza.corpo.data.step4.dac);
                        }
                        if(bozza.corpo.data && bozza.corpo.data.step4 && bozza.corpo.data.step4.dad){
                            bozza.corpo.data.step4.dad=new Date(bozza.corpo.data.step4.dad);
                        }
                        if(bozza.corpo.data && bozza.corpo.data.step7 && bozza.corpo.data.step7.dac){
                            bozza.corpo.data.step7.dac=new Date(bozza.corpo.data.step7.dac);
                        }
                        if(bozza.corpo.data && bozza.corpo.data.step7 && bozza.corpo.data.step7.dad){
                            bozza.corpo.data.step7.dad=new Date(bozza.corpo.data.step7.dad);
                        }
                        if(bozza.corpo.data && bozza.corpo.data.step7 && bozza.corpo.data.step7.dataRichiestaColocazione){
                            bozza.corpo.data.step7.dataRichiestaColocazione=new Date(bozza.corpo.data.step7.dataRichiestaColocazione);
                        }
                        if(bozza.corpo.data && bozza.corpo.data.step7 && bozza.corpo.data.step7.dataSottoscrizioneContratto){
                            bozza.corpo.data.step7.dataSottoscrizioneContratto=new Date(bozza.corpo.data.step7.dataSottoscrizioneContratto);
                        }
                        if(bozza.corpo.data && bozza.corpo.data.step2 && bozza.corpo.data.step2.idAssetScelto){
                            bozza.corpo.data.step2.idAssetScelto=null;
                        }
                        if(bozza.corpo.data && bozza.corpo.data.step7 && bozza.corpo.data.step7.dataDisponibilitaSede){
                            bozza.corpo.data.step7.dataDisponibilitaSede=new Date(bozza.corpo.data.step7.dataDisponibilitaSede);
                        }
                        $state.go('root.ordini.new.step1', {order: bozza});
                    } else {
                        modalService.showModal({},{
                            headerText: "Recupero Ordine in bozza",
                            bodyText: "Non e' stato possibile recuperare il l'ordine in bozza selezionato. Riprovare piu' tardi.",
                            actionButtonText: 'Chiudi',
                            type: 'success'
                        });
                    }

                },
                function (reason) {
                    $log.info("Impossibile trovare la bozza: "+reason);
                    modalService.showModal({},{
                        headerText: "Recupero Ordine in bozza",
                        bodyText: "Non e' stato possibile recuperare il l'ordine in bozza selezionato. Riprovare piu' tardi.",
                        actionButtonText: 'Chiudi',
                        type: 'success'
                    });
                });
        };

        init();
    }]);
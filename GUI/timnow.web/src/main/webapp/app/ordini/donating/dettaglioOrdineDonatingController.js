timnow.controller('dettaglioOrdineDonating', ['$scope', '$state', '$rootScope', 'modalService', 'OrdineDonating', '$uibModal', function ($scope, $state, $rootScope, modalService, OrdineDonating, $uibModal) {

    $rootScope.pageClass = 'dettaglio-ordine-donating';

    /**
     * Callback per l'inizializzazione delle variabili dello scope.
     */
    $scope.init = function () {
        $scope.tipologia = 'Dettaglio Ordine';

        $scope.listLoaded = false;

        $scope.list = [];
        $scope.richiestaDisabilitata = true;
        // REQUEST NOTIFICATION TABELLA START
        $scope.tipologiaEsiti = "Esiti";
        $scope.headerListRequestNotification = [];
        $scope.headerListRequestNotification.push({"key": "tipologiaNotifica","value": "Tipologia Notifica","type": "text"});
        $scope.headerListRequestNotification.push({"key": "causale","value": "Causale","type": "text"});
        $scope.headerListRequestNotification.push({"key": "dataCreazione","value": "Data Creazione","type": "data","pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.headerListRequestNotification.push({"key": "notificaXML","value": "Notifica XML","type": "popupXML"});
        $scope.headerListRequestNotification.push({"key": "ultimoFileNotifica","value": "Ultimo File Notifica","type": "text"});
        $scope.headerListRequestNotification.push({"key": "dataInvioFile","value": "Data Invio File ","type": "text"});

        $scope.tipologiarichieste = "Richieste";
        $scope.headerListRequestRequest = [];
        $scope.headerListRequestRequest.push({"key": "codiceRichiestaOao","value": "Cod. Richiesta OAO","type": "text"});
        $scope.headerListRequestRequest.push({"key": "dataInvio","value": "Data Invio","type": "data","pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.headerListRequestRequest.push({"key": "statoNow","value": "Stato NOW","type": "text"});
        $scope.headerListRequestRequest.push({"key": "statoOao","value": "Stato OAO","type": "text"});
        $scope.headerListRequestRequest.push({"key": "xml","value": "XML","type": "popupXML"});
        $scope.headerListRequestRequest.push({"key": "lavorazioneRichiesta","value": "Lavorazione","type": "text"});
        $scope.headerListRequestRequest.push({"key": "userId","value": "User ID","type": "text"});

        if ($state.params.order) {
            $scope.getOrderDetail();
            $scope.orders = $state.params.order;
        }
    };
    
    $scope.controlloRichiesta = function(ordine){
        if((ordine.flagDiffidato === "Y") && (ordine.statoNow === 'INVERIFICADONATING') && (ordine.offerta !== 'NP')){
            $scope.richiestaDisabilitata = false;
        }
    };

    /**
     * Recupera il dettaglio dell'ordine donating in base al codiceOrdineInput
     * passato in inputt.
     */
    $scope.getOrderDetail = function () {
        var successCallback = function (response) {
            if (!response.hasOwnProperty('result') || response.result.code < 0) {
                modalService.alertSearchError();
                return false;
            }
            if (response.OutputOrdiniDonatingDettaglio) {
                $scope.notifiche = response.OutputOrdiniDonatingDettaglio;

                if(response.OutputOrdiniDonatingDettaglio.length > 0) {
					$scope.controlloRichiesta($scope.orders);
				}
            }
            if (response.OutputOrdiniDonatingRichieste) {
                $scope.richieste = response.OutputOrdiniDonatingRichieste;
            }
            $scope.listLoaded = true;
        };

        var errorCallback = function () {
            modalService.alertSearchError();
            $scope.listLoaded = true;
        };

        OrdineDonating.get({idRichiestaOLO: $state.params.order.idRichiestaOLO}).$promise.then(successCallback, errorCallback);
    };

    /**
     * Callback per ritornare alla lista degli ordini donating.
     */
    $scope.backToList = function () {
        $state.go('root.ordini.donating', {
            filters: $state.params.filters
        });
    };

    $scope.init();

    $scope.nuovaRichiesta = function () {
        $scope.orders.ordineTi = $scope.orders.ordineTI;
        $scope.orders.richiestaCrashed = "RISCONTROCODICESESSIONE";
 
		////////
		var _state = "";
		if($state.includes('**.listareport.**')){
			_state = "root.ordini.listareport.dettaglio.ordine.richiesta"
		}else{
			_state = "root.ordini.lista.dettaglio.richiesta"
		}
		$state.go(_state, {
			order : $scope.orders,
			orderNumber : $scope.orders.ordineTi
		});
        
    };
}]);
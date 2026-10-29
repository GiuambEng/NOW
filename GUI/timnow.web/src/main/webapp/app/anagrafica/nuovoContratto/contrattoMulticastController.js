//RU_1180
timnow.controller('contrattoMulticast', ['$scope', '$state', '$rootScope', 'modalService', 'RecuperoDettaglioContratto', 'ModificaContratto', 'TRACKING_GUI', 'TrackingGUI', '_', 
	function ($scope, $state, $rootScope, modalService, RecuperoDettaglioContratto, ModificaContratto, TRACKING_GUI, TrackingGUI, _) {

	$scope.eventSources = [];
	$scope.flag_abilitato = 'N';
	$scope.flag_notify = 'N';
	$scope.flag_valido = 'N';
	$scope.idContrattoOffertaCatalogo = "";

	$scope.altInputFormats = "dd/MM/yyyy";

	$scope.contratto_fwa_plus = 'N';
	$scope.contratto_fwa_decommissioning = 'N';
	$scope.contratto_fwa_infratel = 'N';

	$scope.contrattoFwaInfratelStart = 'N';
	$scope.contrattoFwaPlusStart = 'N';
	$scope.contrattoFwaDecommissioningStart = 'N';
	
	//RU_1210
	$scope.showSezioneDatiMulticast = false;
	$scope.offerteValide = ["BitstreamNGAFTTCAB"];

	//RU_1180
	$scope.multicastData = {};
	$scope.fileNamePattern = /MC_CONTRATTO_[0-9]{3}_[0-9]{2}[0-9]{2}[0-9]{4}_[0-9]{1,}.csv/gm;
	$scope.isDGUser = $rootScope.isDGUser();
	$scope.tipologia = $state.params.tipologia;
	
	$scope.multicastData.headersFileEsiti = [];
	$scope.multicastData.headersFileEsiti.push({"key": "nomeFile", "value": "Nome File", "type": "text"});
	$scope.multicastData.headersFileEsiti.push({"key": "idFile", "value": "", "type": "esitoMulticastContratto"});
	$scope.multicastData.headersFileEsiti.push({"key": "statoFile", "value": "", "type": "statoFile"});

	$scope.init = function() {
		$scope.dettaglioRetrieved = false;
		RecuperoDettaglioContratto.get({"idContratto":$state.params.idContratto}).$promise.then(
				function (response) {

					if(!!response.dettaglioContratto) {
						$scope.codiceContrattoNuovoContr = response.dettaglioContratto.codiceContratto;
						$scope.codOloSelectNuovoContr = response.dettaglioContratto.codificaOloAgcom;
						$scope.codiceOloNumericoNuovoContr = response.dettaglioContratto.codiceOloNumerico;
						$scope.flag_abilitato = response.dettaglioContratto.flagAbilitato;
						$scope.flag_notify = response.dettaglioContratto.flagFileNotify;
						$scope.flag_valido = response.dettaglioContratto.flagValido;
						$scope.nomeContrattoNuovoOrd = response.dettaglioContratto.nomeContratto;
						$scope.dataInizioValContr = response.dettaglioContratto.dataInizioValiditaContratto;
						$scope.dataFineValContr = response.dettaglioContratto.dataFineValiditaContratto;
						$scope.tipoServizioNuovoContratto = response.dettaglioContratto.tipoServizio;
						$scope.tipoProdottiNuovoContratto = response.dettaglioContratto.tipoProdotti;
						$scope.tipoContrattoNuovoContratto = response.dettaglioContratto.tipoContratto;						
						$scope.dataInizioAssOff = response.dettaglioContratto.dataInizioAssociazioneOffertaContratto
						$scope.dataFineAssOff = response.dettaglioContratto.dataFineAssociazioneOffertaContratto
						$scope.offerta = response.dettaglioContratto.offerta;

						$scope.idContrattoOffertaCatalogo = response.dettaglioContratto.idContrattoOffertaCatalogo;
						//RU_1180
						$scope.flag_multicast = (response.dettaglioContratto.flagMulticast ? true : false);
						$scope.multicastData.idContratto = $scope.contractToUpdate;
						$scope.multicastData.listaFileCsv = (response.dettaglioContratto.listaFileCsv ? response.dettaglioContratto.listaFileCsv : []);
						$scope.multicastData.idContratto = $state.params.idContratto;
						if(response.dettaglioContratto.bouquet && response.dettaglioContratto.bouquet != ''){
							var test = response.dettaglioContratto.bouquet.split("Bouquet");				
							if(test && test.length > 1){
								$scope.multicastData.bouquet = test[1];
							}else{
								$scope.multicastData.bouquet = "";
							}
							
						}

						$scope.dettaglioRetrieved = true;

						//SM_9996
						if(response.dettaglioContratto.offerta == "FixedWirelessAccess"){								
							$scope.contratto_fwa_infratel = response.dettaglioContratto.contrattoFwaInfratel;
							$scope.contratto_fwa_plus = response.dettaglioContratto.contrattoFwaPlus;
							$scope.contratto_fwa_decommissioning = response.dettaglioContratto.contrattoFwaDecommissioning;

							$scope.contrattoFwaInfratelStart = response.dettaglioContratto.contrattoFwaInfratel;
							$scope.contrattoFwaPlusStart = response.dettaglioContratto.contrattoFwaPlus;
							$scope.contrattoFwaDecommissioningStart = response.dettaglioContratto.contrattoFwaDecommissioning;
							$scope.showSezioneFwa = true;
						}

						//RU_1164
						var _tipoContratto = response.dettaglioContratto.tipoContratto;
						if(['NGA', 'VULA'].indexOf(_tipoContratto) > -1){
							$scope.showSezioneSemi = true;
							if(response.dettaglioContratto.dataInizioCoinvestimento){
								var tempDataInizioCoinvestimento = response.dettaglioContratto.dataInizioCoinvestimento.substring(0,10).split('-');
								$scope.dataInizioCoinvestimento = new Date(response.dettaglioContratto.dataInizioCoinvestimento);
							}
							if(response.dettaglioContratto.dataFineCoinvestimento){
								var tempDataFineCoinvestimento = response.dettaglioContratto.dataFineCoinvestimento.substring(0,10).split('-');
								$scope.dataFineCoinvestimento = new Date(response.dettaglioContratto.dataFineCoinvestimento);
							}
						}
						
						//RU_1210
						$scope.showSezioneMulticast = $scope.setShowSezioneMulticast();

					} else {
						$scope.erroreService("Errore durante il caricamento dei dati. Riprovare più tardi");
						$scope.dettaglioRetrieved = true;
					}

				},
				function () {
					$scope.erroreService("Errore durante il caricamento dei dati. Riprovare più tardi");
					$scope.dettaglioRetrieved = true;
				}
		);

	}
	
	//RU_1210
	$scope.setShowSezioneMulticast = function(){
		return ($scope.dettaglioRetrieved &&
		   $scope.isDGUser &&
		   $scope.offerteValide.indexOf($scope.offerta) > -1);
	}


	$scope.erroreService = function (messageBody) {
		modalService.showModal({}, {
			headerText: "Avviso",
			bodyText: messageBody,
			scope: $scope,
			type: 'success'
		});
		$scope.caricaPassFive = false;
	}
	
	$scope.formatDateToString = function(date) {
		if(!!date) {
			var d = date.getDate().toString();
			var m = (date.getMonth() + 1).toString();
			var y = date.getFullYear().toString();

			d.length == 1 ? d = "0" + d : d;
			m.length == 1 ? m = "0" + m : m;

			return y + "-" + m + "-" + d;
		}
		return "";
	};


	$scope.submit = function () {

		//RU_1010
		//Tracking da GUI per operazione INSERIMENTO
		var _trackBean = {
				timestampInizio: new Date().toISOString(),
				timestampFine: null,
				numeroDatiEsportati: 0,
				contenutoFile: null,
				nomeFile: null,
				tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
				parametriOperazione: null 			
		};


		_trackBean.descrizioneFunzione = 'Anagrafiche|Contratto|Modifica Contratto';

		$scope.contrattoUpdateObj = {
				"modificaContrattoInput": {
					"idContratto": $state.params.idContratto,
					"dataFineValiditaContratto": $scope.formatDateToString(new Date($scope.dataFineValContr)),
					"dataFineAssociazioneOffertaContratto": $scope.formatDateToString(new Date($scope.dataFineAssOff)),
					"flagAbilitato": $scope.flag_abilitato,
					"flagFileNotify": $scope.flag_notify,
					"flagValido": $scope.flag_valido,
					"bouquet": "Bouquet"+$scope.multicastData.bouquet					
				}
		};

		ModificaContratto.save({}, $scope.contrattoUpdateObj).$promise
		.then(function (response) {

			if (response.result && response.result.code === '0') {
				$scope.noSelectedOffers = false;

				modalService.showModal({}, {
					headerText: "Modifica Contratto",
					closeButtonText: '',
					bodyText: "Il contratto è stato modificato con successo.",
					actionButtonText: 'Chiudi',
					scope: $scope,
					type: 'success'
				});

				_trackBean.timestampFine = new Date().toISOString();
				_trackBean.esito = 'Ok';
				TrackingGUI.tracking(_trackBean);

				$state.go('root.anagrafica.contratto');

			} else {

				modalService.showModal({}, {
					headerText: "Modifica Contratto",
					closeButtonText: '',
					bodyText: "Impossibile completare l'operazione. Riprovare piu tardi",
					actionButtonText: 'Chiudi',
					scope: $scope,
					type: 'error'
				});

				_trackBean.timestampFine = new Date().toISOString();
				_trackBean.esito = 'Ko';
				TrackingGUI.tracking(_trackBean);
			}

		}, function () {
			
			modalService.showModal({}, {
				headerText: "Modifica Contratto",
				closeButtonText: '',
				bodyText: "Impossibile completare l'operazione. Riprovare piu tardi",
				actionButtonText: 'Chiudi',
				scope: $scope,
				type: 'error'
			});

			_trackBean.timestampFine = new Date().toISOString();
			_trackBean.esito = 'Ko';
			TrackingGUI.tracking(_trackBean);
		});


	};

	$scope.annulla = function() {
		$state.go('root.anagrafica.contratto');
	}

	$scope.init();
	
}]);
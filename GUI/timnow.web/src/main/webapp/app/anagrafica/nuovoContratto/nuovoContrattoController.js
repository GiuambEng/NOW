//RU_716 NUOVO CONTRATTO
timnow.controller('nuovoContratto', ['$scope', '$state', '$rootScope', 'modalService',  'IDsrolo', 'GetCodOloNumerico','NuovoContratto', 'RecuperoDatiContratto', 'RecuperoContratti' , 'RecuperoDettaglioContratto', 'ModificaContratto', '$log','TRACKING_GUI', 'TrackingGUI','OSCURAMENTI', '$filter', '$timeout', 'AnagraficaUtils','_', 
	function ($scope, $state, $rootScope, modalService, IDsrolo, GetCodOloNumerico, NuovoContratto, RecuperoDatiContratto, RecuperoContratti, RecuperoDettaglioContratto, ModificaContratto, $log, TRACKING_GUI, TrackingGUI, OSCURAMENTI, $filter, $timeout, AnagraficaUtils, _) {
	$log.debug("nuovoContratto");
	$scope.eventSources = [];
	$scope.noSelectedOffers = false;
	$scope.flag_abilitato = 'N';
	$scope.flag_notify = 'N';
	$scope.flag_valido = 'N';
	$scope.idContrattoOffertaCatalogo = "";
	$scope.offertaNuovoContr = null;
	$scope.altInputFormats = "dd/MM/yyyy";
	$scope.isUpdateContract = $state.params.flag;
	$scope.msgCampiMancanti="Impossibile creare il contratto. E' necessario valorizzare tutti i campi. Verificare ";
	$rootScope.updateContractForBanner=$state.params.flag;
	
	//SM_10036
	$scope.contratto_fwa_plus = 'N';
	$scope.contratto_fwa_decommissioning = 'N';
	$scope.contratto_fwa_infratel = 'N';
	
	$scope.contrattoFwaInfratelStart = 'N';
	$scope.contrattoFwaPlusStart = 'N';
	$scope.contrattoFwaDecommissioningStart = 'N';
	
	$scope.checkAlmostOneFwa = false;
	
	$scope.dataInizioCoinvestimento = new Date();
	$scope.dataFineCoinvestimento = new Date(2999, 11, 31);
	
	//SM_10292
	$scope.sospensioneServizio = {};
	
	$scope.start = function() {
		$scope.contractToUpdate = $state.params.contratto.idContratto;
		$scope.dettaglioRetrieved = false;

		$scope.dataFineValDPOptions = {
				dateDisabled: disabled,
				formatYear: 'yy',
				minDate: new Date(),
				startingDay: 1
		};

		$scope.dataFineAssDPOptions = {
				dateDisabled: disabled,
				formatYear: 'yy',
				minDate: new Date(),
				startingDay: 1
		};

		if(!$scope.isUpdateContract) {
			// CREAZIONE NUOVO CONTRATTO
			$scope.loadOLO = true;

			IDsrolo.get({noDiffida: false}).$promise.then(
					function (response) {
						$scope.loadOLO = false;
						$scope.nuovoContrattoOlos = response.data;
						//$scope.controlAssetOAO();
					},
					function () {
						$scope.loadOLO = false;
						$scope.erroreService("Errore durante il caricamento degli OAO. Riprovare più tardi");
					}
			);

			RecuperoDatiContratto.get({}).$promise.then(
					function (response) {
						if(response.result.description == "OK" && response.result.details != "Nessuna offerta trovata") {
							$scope.loadOLO = false;
							
							//RU_961
							if(response.tipoServizio && response.tipoServizio.length > 0){
								response.tipoServizio = response.tipoServizio.map(function(servizio, index){
									return {
										value: servizio,
										code: response.idFamigliaOfferta[index]
									};
								});
							}
							
							$scope.tipoServizioNuovoContr={
									"tipoServizio" : response.tipoServizio,
									"idFamigliaOfferta" : response.idFamigliaOfferta,
							};							

						} else {
							$scope.loadOLO = false;
							$scope.erroreService("Nessuna offerta trovata.");
						}

					},
					function () {
						$scope.loadOLO = false;
						$scope.erroreService("Errore durante il caricamento dei dati. Riprovare più tardi");
					}
			);

		} else {

			// MODIFICA CONTRATTO PREESISTENTE

			RecuperoDettaglioContratto.get({"idContratto":$scope.contractToUpdate}).$promise.then(
					function (response) {

						if(!!response.dettaglioContratto) {
							$scope.codiceContrattoNuovoContr = response.dettaglioContratto.codiceContratto;
							$scope.codOloSelectNuovoContr = response.dettaglioContratto.codificaOloAgcom;
							$scope.codiceOloNumericoNuovoContr = response.dettaglioContratto.codiceOloNumerico;
							$scope.flag_abilitato = response.dettaglioContratto.flagAbilitato;
							$scope.flag_notify = response.dettaglioContratto.flagFileNotify;
							$scope.flag_valido = response.dettaglioContratto.flagValido;
							$scope.nomeContrattoNuovoOrd = response.dettaglioContratto.nomeContratto;
							var tempDataInizioValContr = response.dettaglioContratto.dataInizioValiditaContratto.substring(0,10).split('-');
							$scope.dataInizioValContr = tempDataInizioValContr[2] + "/" + tempDataInizioValContr[1] + "/" + tempDataInizioValContr[0];
							$scope.reinitializeDpOnModify(response.dettaglioContratto.dataFineValiditaContratto, true, response.dettaglioContratto.dataInizioValiditaContratto); //SM_8059
							$scope.tipoServizioNuovoContratto = response.dettaglioContratto.tipoServizio;
							$scope.tipoProdottiNuovoContratto = response.dettaglioContratto.tipoProdotti;
							$scope.tipoContrattoNuovoContratto = response.dettaglioContratto.tipoContratto;
							$scope.selectedOfferteList[0] = response.dettaglioContratto.offerta //TODO il servizio deve restituire una lista di id
							var tempDataInizioAssOff = response.dettaglioContratto.dataInizioAssociazioneOffertaContratto.substring(0,10).split('-');
							$scope.dataInizioAssOff = tempDataInizioAssOff[2] + "/" + tempDataInizioAssOff[1] + "/" + tempDataInizioAssOff[0];
							$scope.reinitializeDpOnModify(response.dettaglioContratto.dataFineAssociazioneOffertaContratto, false, response.dettaglioContratto.dataInizioAssociazioneOffertaContratto); //SM_8059

							$scope.idContrattoOffertaCatalogo = response.dettaglioContratto.idContrattoOffertaCatalogo;

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
								var tempDataInizioCoinvestimento = response.dettaglioContratto.dataInizioCoinvestimento.substring(0,10).split('-');
								$scope.dataInizioCoinvestimento = new Date(response.dettaglioContratto.dataInizioCoinvestimento);
								var tempDataFineCoinvestimento = response.dettaglioContratto.dataFineCoinvestimento.substring(0,10).split('-');
								$scope.dataFineCoinvestimento = new Date(response.dettaglioContratto.dataFineCoinvestimento);
							}
							
							//SM_10292
							var _offerta = response.dettaglioContratto.offerta;
							if(_offerta == 'SEMIEasyIPUBBFTTH'){
								$scope.showSezioneSospensioneServizio = true;								
								var tempDataFineCoinvestimento = response.dettaglioContratto.dataFineCoinvestimento.substring(0,10).split('-');								
								$scope.datiSospensioneServizio = {
									dataFineValiditaContratto: new Date(response.dettaglioContratto.dataFineValiditaContratto)
								}
								
								if(response.dettaglioContratto.datiSospensioneServizio){
									angular.extend($scope.datiSospensioneServizio, response.dettaglioContratto.datiSospensioneServizio)
									if($scope.datiSospensioneServizio.dataInizioDisabil && $scope.datiSospensioneServizio.dataInizioDisabil != ''){
										$scope.datiSospensioneServizio.dataInizioDisabil = new Date($scope.datiSospensioneServizio.dataInizioDisabil);
									}
									if($scope.datiSospensioneServizio.dataFineDisabil && $scope.datiSospensioneServizio.dataFineDisabil != ''){
										$scope.datiSospensioneServizio.dataFineDisabil = new Date($scope.datiSospensioneServizio.dataFineDisabil);
									}
								}	
								
							}
							
							
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

	}

	$scope.selectedIdSottofamigliaOfferta = function(idSottofamigliaOfferta) {
		//RU_961
		$scope.idSottofamigliaOfferta = idSottofamigliaOfferta;
	}

	$scope.selectedTipoServizio = function (tipoServizio){

		$scope.idFamigliaOfferta = tipoServizio.code;
		
		//RU_1129
		$scope.selectedOfferteList = [];
		
		//RU_1197
		RecuperoContratti.get({"tipoServizio": tipoServizio.value}).$promise.then(
				function (response) {
					if(response.result.description == "OK" && response.result.details != "Nessun contratto disponibile") {
						$scope.loadOLO = false;
						$scope.tipoContrattoNuovoContr=response.recuperoContrattoOutput.tipologiaContrattoOutput;
					} else {
						$scope.loadOLO = false;
						$scope.erroreService("Nessun contratto disponibile.");
					}
				},
				function () {
					$scope.loadOLO = false;
					$scope.erroreService("Errore durante il caricamento del tipo contratto. Riprovare più tardi");
				}
		);
		
		
		
		

		RecuperoDatiContratto.get({idFamigliaOfferta: $scope.idFamigliaOfferta}).$promise.then(
				function (response) {
					$scope.loadOLO = false;
					
					//RU_961
					$scope.selected = [];
					
					$scope.offertaNuovoContr={
							"offerta" : response.offerta,
							"idOfferta" : response.idOfferta,
					};
					
					//RU_961					
					if(response.tipoProdotti && response.tipoProdotti.length > 0){
						response.tipoProdotti = response.tipoProdotti.map(function(prodotto, index){
							return {
								value: prodotto,
								code: response.idSottofamigliaOfferta[index]
							};
						});
					}
					$scope.tipoProdottiNuovoContr={
							"tipoProdotti":response.tipoProdotti,
							"idSottofamigliaOfferta":response.idSottofamigliaOfferta,
					};
					
					$scope.offertaNuovoContr.idOfferta.forEach(function(item){
						$scope.selected.push(false);
					});
				},
				function () {
					$scope.loadOLO = false;
					$scope.erroreService("Errore durante il caricamento dei dati. Riprovare più tardi");
				}
		);
	}

	$scope.tipoContrattoNuovoContratto={id:null};

	$scope.codOloSelectNuovoContr = {id:null};

	$scope.codiceOloNumerico= function (codiceOlo){
		$scope.loadOLO = true;
		GetCodOloNumerico.get({codOlo:codiceOlo}).$promise.then(
				function (response) {
					$scope.loadOLO = false;
					$scope.codiceOloNumericoNuovoContr = response.codOloNumerico;
					//$scope.controlAssetOAO();
				},
				function () {
					$scope.loadOLO = false;
					$scope.erroreService("Errore durante il recupero del codice olo numerico. Riprovare più tardi");
				}
		);
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


	$scope.setDate = function (year, month, day) {
		$scope.dt = new Date(year, month, day);
	};

	$scope.formats = ['dd/MM/yyyy', 'shortDate'];
	$scope.format = $scope.formats[0];

	function getDayClass(data) {
		var date = data.date, mode = data.mode;
		if (mode === 'day') {
			var dayToCheck = new Date(date).setHours(0,
					0, 0, 0);

			for (var i = 0; i < $scope.events.length; i++) {
				var currentDay = new Date(
						$scope.events[i].date)
				.setHours(0, 0, 0, 0);

				if (dayToCheck === currentDay) {
					return $scope.events[i].status;
				}
			}
		}
		return '';
	}

	$scope.today = function () {
		$scope.dt = new Date();
	};

	$scope.clear = function () {
		$scope.dt = null;
	};

	$scope.inlineOptions = {
			//customClass: getDayClass,
			minDate: new Date(),
			showWeeks: false
	};

	$scope.dateOptions = {
			dateDisabled: disabled,
			formatYear: 'yy',
			minDate: new Date(),
			startingDay: 1
	};

	$scope.inizioDPOptions = {
			dateDisabled: disabled,
			formatYear: 'yy',
			minDate: new Date(),
			startingDay: 1
	};

	$scope.initializeDpFineValContr = function(data) {
		if(!$state.params.flag && !!data) { //se non è modifica contratto
			$scope.dataFineValContr = "";
			$scope.dataInizioValContr = data;
			var myDate = new Date(data.getFullYear(), data.getMonth(), data.getDate()+1);

			$scope.dataFineValDPOptions = {
					dateDisabled: disabled,
					formatYear: 'yy',
					minDate: myDate,
					startingDay: 1
			};
		};
	};

	$scope.initializeFineValContr = function(data) {
		$scope.dataFineValContr = data;
	};

	$scope.initializeFineAssOff = function(data) {
		$scope.dataFineAssOff = data;
	};

	$scope.initializeDpFineAssOff = function(data) {
		if(!$state.params.flag && !!data) { //se non è modifica contratto
			$scope.dataFineAssOff = "";
			$scope.dataInizioAssOff = data;
			var myDate = new Date(data.getFullYear(), data.getMonth(), data.getDate()+1);

			$scope.dataFineAssDPOptions = {
					dateDisabled: disabled,
					formatYear: 'yy',
					minDate: myDate,
					startingDay: 1
			};
		}
	};

	$scope.reinitializeDpOnModify = function(stringDate, isDataFineValContr, dpMinDate) {

		var date = new Date(stringDate);
		var minimumDate = new Date(dpMinDate); //SM_8059
		var now = new Date();
		now.setHours(0);
		now.setMinutes(0);
		now.setSeconds(0);
		now.setMilliseconds(0);

		if(minimumDate.getTime() < now.getTime() ) {
			var tomorrow = now.setDate(now.getDate()+1);
			minimumDate = tomorrow;
		}

		var temp = stringDate.substring(0,10).split('-');

		if(isDataFineValContr) {
			$scope.dataFineValContr = date;
			$scope.dataFineValDPOptions = {
					dateDisabled: disabled,
					formatYear: 'yy',
					minDate: minimumDate,
					startingDay: 1
			};

		} else {
			$scope.dataFineAssOff = date;
			$scope.dataFineAssDPOptions = {
					dateDisabled: disabled,
					formatYear: 'yy',
					minDate: minimumDate,
					startingDay: 1
			};
		};

		return temp[2] + "/" + temp[1] + "/" + temp[0];
	}

	// Disable weekend selection
	function disabled(data) {
		var date = data.date, mode = data.mode;
		return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	}

	$scope.toggleMin = function () {
		if(!$state.params.flag) { //se non è modifica contratto
			$scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
			$scope.dateOptions.minDate = $scope.inlineOptions.minDate;
		}
	};

	$scope.toggleMin();

	$scope.openDP1 = function () {
		$scope.popup_dp1.opened = true;
	};

	$scope.openDP2 = function () {
		$scope.popup_dp2.opened = true;
	};
	$scope.openDP3 = function () {
		$scope.popup_dp3.opened = true;
	};
	$scope.openDP4 = function () {
		$scope.popup_dp4.opened = true;
	};

	$scope.popup_dp1 = {
			opened: false
	};

	$scope.popup_dp2 = {
			opened: false
	};
	$scope.popup_dp3 = {
			opened: false
	};
	$scope.popup_dp4 = {
			opened: false
	};
	
	//RU_1164
	$scope.popup_dataInizioCoinvestimento = {
			opened: false
	};
	
	$scope.popup_dataFineCoinvestimento = {
			opened: false
	};
	
	$scope.openDataInizioCoinvestimento = function () {
		$scope.popup_dataInizioCoinvestimento.opened = true;
	};
	
	$scope.openDataFineCoinvestimento = function () {
		$scope.popup_dataFineCoinvestimento.opened = true;
	};

	$scope.inizioCoinvestimentoDPOptions = {
			dateDisabled: disabled,
			formatYear: 'yy',
			startingDay: 1
	};
	
	$scope.fineCoinvestimentoDPOptions = {
			dateDisabled: disabled,
			formatYear: 'yy',
			startingDay: 1
	};
	
	$scope.initializeDataFineCoinvestimento = function(data) {
		$scope.dataFineContrattoCoinvestimento = "";
		var myDate = new Date($scope.dataInizioCoinvestimento.getFullYear(), $scope.dataInizioCoinvestimento.getMonth(), $scope.dataInizioCoinvestimento.getDate());

		$scope.fineCoinvestimentoDPOptions = {
				dateDisabled: disabled,
				formatYear: 'yy',
				minDate: myDate,
				startingDay: 1
		};
	};

	$scope.dataInizioValSelected = function(data) {
		console.log(prova);
	};

	$scope.checkDateInizioVal= function (){
//		if($scope.dataInizioValContr)
//	return false
//else
//	return true
	};
	$scope.checkDateInizioAss= function (){
//		if($scope.dataInizioAssOff)
//		return false
//		else
//		return true
	};


	$scope.modifyState=function (){
		var flag = $state.params.flag
		if(flag){
			return true;
		}
	}

	//fix per campi non inseriti in rosso
	$scope.valida = function (form) {
		checkOffertaSelect();
		angular.forEach(form.$error.required, function (field) {
			field.$setDirty();
		});
	};

	//con la select multipla riempire queste due variabili

	$scope.selectedOfferteList = [];
	$scope.failedOfferteList = [];
	$scope.failedOffers = "";

	$scope.submit = function () {
		
		
		//SM_10029
		if($scope.RU_1129 && $scope.showSezioneFwa){
			if((!$scope.contratto_fwa_infratel || $scope.contratto_fwa_infratel == 'N') && 
					(!$scope.contratto_fwa_plus || $scope.contratto_fwa_plus == 'N') && 
					(!$scope.contratto_fwa_decommissioning || $scope.contratto_fwa_decommissioning == 'N')){
				$scope.erroreService("Seleziona almeno un campo tra  CONTRATTO FWA INFRATEL, CONTRATTO FWA PLUS, CONTRATTO FWA DECOMMISSIONING");
				return;
			}
		}
		
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
		

		if(!$scope.isUpdateContract && !$scope.dettaglioRetrieved) {
			//SAVATAGGIO NUOVO CONTRATTO
			var msg="";
			if(!$scope.isUpdateContract ) {

				//fix per campi non inseriti in rosso
				//SM_8048
				if(!$scope.codiceContrattoNuovoContr)
					msg=$scope.msgCampiMancanti+"Codice Contratto"
					else if (!$scope.tipoContrattoNuovoContratto.id)
						msg=$scope.msgCampiMancanti+"TIPO CONTRATTO"
						else if(!$scope.codOloSelectNuovoContr.id)
							msg=$scope.msgCampiMancanti+"OAO"
							else if(!$scope.codiceOloNumericoNuovoContr)
								msg=$scope.msgCampiMancanti+"CODICE OLO NUMERICO"
								else if(!$scope.nomeContrattoNuovoOrd)
									msg=$scope.msgCampiMancanti+"NOME CONTRATTO"
									else if(!$scope.dataInizioValContr)
										msg=$scope.msgCampiMancanti+"DATA INIZIO VALIDITA CONTRATTO"
										else if(!$scope.dataFineValContr)
											msg=$scope.msgCampiMancanti+"DATA FINE VALIDITA CONTRATTO"
											else if(!$scope.idFamigliaOfferta) 
												msg=$scope.msgCampiMancanti+"TIPO SERVIZIO" 
												else if(!$scope.idSottofamigliaOfferta)
													msg=$scope.msgCampiMancanti+"TIPO PRODOTTI"
													else if(!$scope.dataInizioAssOff)
														msg=$scope.msgCampiMancanti+"DATA INIZIO ASSOCIAZIONE OFFERTA - CONTRATTO"
														else if(!$scope.dataFineAssOff)
															msg=$scope.msgCampiMancanti+"DATA FINE ASSOCIAZIONE OFFERTA - CONTRATTO"

															if(msg!=""){
																return;
															}
			}

			if(!!$scope.selectedOfferteList && $scope.selectedOfferteList.length > 0) {
				
				_trackBean.descrizioneFunzione = 'Anagrafiche|Contratto|Nuovo Contratto';

				$scope.attesaRispostaChiamata=true;
				$scope.nuovoContratto = [];

				for(var i = 0; i < $scope.selectedOfferteList.length; i++) {

					$scope.contrattoObj = 
					{
							"codiceContratto": $scope.codiceContrattoNuovoContr,
							"codificaOloAgcom": $scope.codOloSelectNuovoContr.id.id,
							"codiceOloNumerico": $scope.codiceOloNumericoNuovoContr,
							"flagAbilitato": $scope.flag_abilitato,
							"flagFileNotify": $scope.flag_notify,
							"flagValido": $scope.flag_valido,
							"nomeContratto": $scope.nomeContrattoNuovoOrd,
							"dataInizioValiditaContratto": $scope.setDateHours($scope.dataInizioValContr),
							"dataFineValiditaContratto": $scope.setDateHours($scope.dataFineValContr),
							"idFamigliaOfferta": $scope.idFamigliaOfferta,
							"idSottofamigliaOfferta": $scope.idSottofamigliaOfferta,
							"idOfferta": $scope.selectedOfferteList[i],
							"dataInizioAssociazioneOffertaContratto": $scope.setDateHours($scope.dataInizioAssOff),
							"dataFineAssociazioneOffertaContratto": $scope.setDateHours($scope.dataFineAssOff),
							"idTipologiaContratto":$scope.tipoContrattoNuovoContratto.id
					};
					
					//RU_1129
					if($scope.RU_1129 && $scope.showSezioneFwa){
							$scope.contrattoObj.contrattoFwaInfratel = $scope.contratto_fwa_infratel;
							$scope.contrattoObj.contrattoFwaPlus = $scope.contratto_fwa_plus;
							$scope.contrattoObj.contrattoFwaDecommissioning = $scope.contratto_fwa_decommissioning;
					}
					
					//RU_1164
					if($scope.showSezioneSemi){
						if($scope.dataInizioCoinvestimento && $scope.dataInizioCoinvestimento != ''){
							$scope.contrattoObj.dataInizioCoinvestimento = $scope.setDateHours($scope.dataInizioCoinvestimento);
						}						
						if($scope.dataFineCoinvestimento && $scope.dataFineCoinvestimento != ''){
							$scope.contrattoObj.dataFineCoinvestimento = $scope.setDateHours($scope.dataFineCoinvestimento);
						}						
					}
					
					$scope.nuovoContratto.push($scope.contrattoObj);
				}

				NuovoContratto.save({}, $scope.nuovoContratto, function (response) {

					if (response && response.esito === 'OK') {
						$scope.noSelectedOffers = false;
						$log.debug('Contratto salvato');					

						modalService.showModal({}, {
							headerText: "Nuovo Contratto",
							closeButtonText: '',
							bodyText: "Il contratto è stato creato con successo.",
							actionButtonText: 'Chiudi',
							scope: $scope,
							type: 'success'
						});
						
						_trackBean.timestampFine = new Date().toISOString();
						_trackBean.esito = 'Ok';
						TrackingGUI.tracking(_trackBean);
						
						$state.go('root.anagrafica.contratto');

					} else {
						$log.debug("Impossibile creare il contratto");
						$scope.noSelectedOffers = false;

						//SM_8049
						var messageBody = "Impossibile completare l'operazione. Riprovare piu tardi";

						if(response && response.esito === 'KO' && response.result && response.result.details) {
							messageBody = response.result.details;
						}

						modalService.showModal({}, {
							headerText: "Nuovo Contratto",
							closeButtonText: '',
							bodyText: messageBody, 
							actionButtonText: 'Chiudi',
							scope: $scope,
							type: 'error'
						});
						
						_trackBean.timestampFine = new Date().toISOString();
						_trackBean.esito = 'Ko';
						TrackingGUI.tracking(_trackBean);
					}

				}, function () {

					$log.debug("Impossibile creare il contratto");
					$scope.noSelectedOffers = false;

					modalService.showModal({}, {
						headerText: "Nuovo Contratto",
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

			} else {
				$scope.noSelectedOffers = true;
			}

		} else {
			// MODIFICA CONTRATTO

			_trackBean.descrizioneFunzione = 'Anagrafiche|Contratto|Modifica Contratto';

			$scope.contrattoUpdateObj = {
					"modificaContrattoInput": {
						"idContratto": $scope.contractToUpdate,
						"idContrattoOffertaCatalogo": $scope.idContrattoOffertaCatalogo,
						"flagAbilitato": $scope.flag_abilitato,
						"flagFileNotify": $scope.flag_notify,
						"flagValido": $scope.flag_valido,
						"dataFineAssociazioneOffertaContratto": $scope.formatDateToString($scope.dataFineAssOff)
					}
			};
			
			//SM_9996
			if(_.isDate($scope.dataFineValContr)){
				$scope.contrattoUpdateObj.modificaContrattoInput.dataFineValiditaContratto = $scope.formatDateToString($scope.dataFineValContr);
			}else{
				$scope.contrattoUpdateObj.modificaContrattoInput.dataFineValiditaContratto = $scope.dataFineValContr;
			}
			
			if(_.isDate($scope.dataInizioValContr)){
				$scope.contrattoUpdateObj.modificaContrattoInput.dataInizioValiditaContratto = $scope.formatDateToString($scope.dataInizioValContr);
			}else{
				var app = $scope.dataInizioValContr.split('/');
				$scope.contrattoUpdateObj.modificaContrattoInput.dataInizioValiditaContratto = "".concat(app[2], '-', app[1], '-', app[0]);
			}
			
			//RU_1129
			if($scope.RU_1129 && $scope.showSezioneFwa){
				//SM_9996			
				if($scope.contratto_fwa_infratel != $scope.contrattoFwaInfratelStart){
					$scope.contrattoUpdateObj.modificaContrattoInput.contrattoFwaInfratel = $scope.contratto_fwa_infratel;
				}
				if($scope.contratto_fwa_plus != $scope.contrattoFwaPlusStart){
					$scope.contrattoUpdateObj.modificaContrattoInput.contrattoFwaPlus = $scope.contratto_fwa_plus;
				}
				if($scope.contratto_fwa_decommissioning != $scope.contrattoFwaDecommissioningStart){
					$scope.contrattoUpdateObj.modificaContrattoInput.contrattoFwaDecommissioning = $scope.contratto_fwa_decommissioning;
				}
			}
			
			//RU_1164
			if($scope.RU_1164 && $scope.showSezioneSemi){
				if($scope.dataInizioCoinvestimento && $scope.dataInizioCoinvestimento != ''){
					$scope.contrattoUpdateObj.modificaContrattoInput.dataInizioCoinvestimento = $scope.formatDateToString($scope.dataInizioCoinvestimento);
				}
				if($scope.dataFineCoinvestimento && $scope.dataFineCoinvestimento != ''){
					$scope.contrattoUpdateObj.modificaContrattoInput.dataFineCoinvestimento = $scope.formatDateToString($scope.dataFineCoinvestimento);
				}						
			}
			
			//SM_10292
			if($scope.showSezioneSospensioneServizio){
				$scope.contrattoUpdateObj.modificaContrattoInput.datiSospensioneServizio = {};
				var _dataInizio =  $scope.datiSospensioneServizio.dataInizioDisabil;
				var _dataFine =  $scope.datiSospensioneServizio.dataFineDisabil;
				if(_dataInizio){
					$scope.contrattoUpdateObj.modificaContrattoInput.datiSospensioneServizio.dataInizioDisabil = $scope.formatDateToString($scope.datiSospensioneServizio.dataInizioDisabil);
				}
				if(_dataFine){
					$scope.contrattoUpdateObj.modificaContrattoInput.datiSospensioneServizio.dataFineDisabil = $scope.formatDateToString($scope.datiSospensioneServizio.dataFineDisabil);
				}		
				
				$scope.contrattoUpdateObj.modificaContrattoInput.datiSospensioneServizio.flagDisabil = ($scope.datiSospensioneServizio.flagDisabil || null);				
			}

			if( !$scope.dataFineValContr || !$scope.dataFineAssOff ) {

				msg =""

					if( !$scope.dataFineValContr)
						msg=$scope.msgCampiMancanti+"DATA FINE VALIDITA' CONTRATTO"
						else if(!$scope.dataFineAssOff)
							msg=$scope.msgCampiMancanti+"DATA FINE ASSOCIAZIONE OFFERTA - CONTRATTO"

							//fix per campi non inseriti in rosso
							if(msg!=""){ 
//								modalService.showModal({}, {
//								headerText: "Nuovo Contratto",
//								closeButtonText: '',
//								bodyText: msg,
//								actionButtonText: 'Chiudi',
//								scope: $scope,
//								type: 'error'
//								});
								return;
							}
			}

			ModificaContratto.save({}, $scope.contrattoUpdateObj).$promise
			.then(function (response) {

				if (response.result && response.result.code === '0') {
					$scope.noSelectedOffers = false;
					$log.debug('Contratto salvato');

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
					$log.debug("Impossibile modificare il contratto");
					$scope.noSelectedOffers = false;

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

				$log.debug("Impossibile modificare il contratto");
				$scope.noSelectedOffers = false;

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

		}

	};

	$scope.selectedCount=0;
	$scope.showOptions = false;
	$scope.selectedItems=[];
	$scope.selected = [];

	$scope.createSelectedArray = function(index, isAdding){

		for(var i = 0; i < $scope.offertaNuovoContr.idOfferta.length; i++) {
			if( i == index ) {
				if($scope.selectedOfferteList.indexOf($scope.offertaNuovoContr.idOfferta[i]) < 0 && isAdding) { // se offerta non è già presente
					$scope.selectedOfferteList.push($scope.offertaNuovoContr.idOfferta[i]);
				} else {
					if(!isAdding) {
						if($scope.selectedOfferteList.indexOf($scope.offertaNuovoContr.idOfferta[i]) > -1) {
							$scope.selectedOfferteList.splice($scope.selectedOfferteList.indexOf($scope.offertaNuovoContr.idOfferta[i]), 1);
						}
					}
				}
			}
		}

	};

	$scope.update = function(index){
		var isAdding = true;

		if(!$scope.selected[index]) {
			isAdding = false;
		}
		
		//SM_10055
		//Per tipo servizio == NGA, si puo scegliere solo un'offerta 
		//tra SEMI BTS NGA FTTH e SEMI EASYIP NGA FTTH 
		if($scope.idFamigliaOfferta == "5"){
			
			$scope.selectedOfferteList = [];
			
			if($scope.selected.length > 1){
				if(isAdding){
					
					$scope.selected.forEach(function(item, i){
						if(i != index){
							$scope.selected[i] = false;
						}
					});
				}
			}
		}

		$scope.createSelectedArray(index, isAdding);

		//fix per campi non inseriti in rosso
		checkOffertaSelect();

		$log.debug("Offerte Selezionate: " + $scope.selectedOfferteList);
	};

	//fix per campi non inseriti in rosso
	function checkOffertaSelect(){
		if( $scope.selectedOfferteList && $scope.selectedOfferteList.length > 0 )
			$scope.noSelectedOffers=false;
		else
			$scope.noSelectedOffers=true;
	}


	$scope.toggleOffers = function(){
		$scope.showOptions = !$scope.showOptions;
	};

	$scope.annulla = function() {
		$state.go('root.anagrafica.contratto');
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

	$scope.updateNomeContratto = function(nome) {
		$scope.nomeContrattoNuovoOrd = nome;
	} 


	$scope.updateCodiceContratto = function(codice) {
		$scope.codiceContrattoNuovoContr = codice;
	};

	$scope.setDateHours = function(date) {
		var d = date;

		d.setHours(12);
		d.setMinutes(0);
		d.setSeconds(0);
		d.setMilliseconds(0);

		return d;
	};
	
	//RU_1129
	$scope.oscuramento_RU_1129 = function(){
		$scope.RU_1129 = !OSCURAMENTI.RU_1129.oscurato;
	}
	
	$scope.oscuramento_RU_1129();
	
	//RU_1164
	$scope.oscuramento_RU_1164 = function(){
		$scope.RU_1164 = !OSCURAMENTI.RU_1164.oscurato;
	}
	
	$scope.oscuramento_RU_1164();
	
	
	$scope.$watchCollection('selectedOfferteList', function(newValue, oldValue){
		if(newValue && newValue.length > 0){
			//x creazione contratto
			var _arrayCreazioneFwa = $filter('filter')(newValue, '46');
			var _arrayCreazioneSemi = _.intersection(newValue, [$rootScope.MAP_OFFERTE.SEMI_VULA_H.id, $rootScope.MAP_OFFERTE.SEMI_BTS_H.id, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id]);
			//x modifica contratto
			var _arrayModificaFwa = $filter('filter')(newValue, 'FixedWirelessAccess');
			var _arrayModificaSemi = _.intersection(newValue, [$rootScope.MAP_OFFERTE.SEMI_VULA_H.name, $rootScope.MAP_OFFERTE.SEMI_BTS_H.name, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name]);
			if((_arrayCreazioneFwa && _arrayCreazioneFwa.length > 0) || (_arrayModificaFwa && _arrayModificaFwa.length > 0)){
				$scope.showSezioneFwa = true;				
			}
			//RU_1164
			if((_arrayCreazioneSemi && _arrayCreazioneSemi.length > 0) || (_arrayModificaSemi && _arrayModificaSemi.length > 0)){
				$scope.showSezioneSemi = true;				
			}
		}else{
			$scope.showSezioneFwa = false;
			$scope.contrattoFwaInfratel = 'N';
			$scope.contrattoFwaPlus = 'N';
			$scope.contrattoFwaDecommissioning = 'N';
			
			//RU_1164
			$scope.showSezioneSemi = false;
		}
	});
	

	//SM_10029
	$scope.$watch('dataFineValContr', function(newValue, oldValue){
		if(newValue && angular.isDate(newValue) && $scope.isUpdateContract){
			//Se la data di fine validità contratto è maggiore della data attuale, allora abilitare i flag fwa
			$scope.enableFlagsFwa = (new Date() < newValue);
			
			if(oldValue && newValue != oldValue && $scope.showSezioneFwa){
				$scope.dataFineAssOff = "";				
				
				var _date = new Date(newValue.getFullYear(), newValue.getMonth(), newValue.getDate());
				
				$scope.dataFineAssDPOptions = {
						dateDisabled: disabled,
						formatYear: 'yy',
						minDate: _date,
						startingDay: 1
				};				
			}
			
		}else{
			//SM_10036
			$scope.enableFlagsFwa = true;
		}
	});
	
	$scope.start();
	
	function fixDatepickerTriggerChange() {
	    $(document).ready(function () {
	        $('[datepicker-options]').datepicker().on('changeDate', function (e) {
	            angular.element($(this)).triggerHandler('input');
	        });
	    });
	}
}]);
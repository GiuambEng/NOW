///////NEW!!!!!

timnow.controller("nuovoContrattoNew", ['$scope', '$state', '$rootScope', 'modalService', 'IDsrolo', 'NuovoContratto', 'RecuperoDatiContratto', 'RecuperoContratti', 'TRACKING_GUI', 'TrackingGUI','OSCURAMENTI', '_', '$q', '$filter', '$timeout', 'RecuperoFlagMulticast', 'VerificaContrattoFwaEolo',
	function($scope, $state, $rootScope, modalService, IDsrolo, NuovoContratto, RecuperoDatiContratto, RecuperoContratti, TRACKING_GUI, TrackingGUI, OSCURAMENTI, _, $q, $filter, $timeout, RecuperoFlagMulticast, VerificaContrattoFwaEolo){

	$scope.noSelectedOffers = false;

	$scope.data = {};

	$scope.idContrattoOffertaCatalogo = "";
	$scope.checkAlmostOneFwa = false;

	$scope._regexCodiceContratto = /^[a-zA-Z0-9 -_]*$/;

	$scope.showOffertaOptions = false; 
	
	$scope.fileToUpload = {};

	$scope.init = function(){

		$scope.datiRetrieved = false;		
		$scope.listaOlo = [];

		$scope.data.flagFileNotify = 'N';
		$scope.data.flagAbilitato = 'N';
		$scope.data.flagValido = 'N';

		//SM_10036
		$scope.data.contrattoFwaPlus = 'N';
		$scope.data.contrattoFwaDecommissioning = 'N';
		$scope.data.contrattoFwaInfratel = 'N';

		$scope.offerteSelected = [];


		$q.all([$scope.configureListaOlo(), $scope.configureOfferte()])
		.then(function(responses){
			$scope.datiRetrieved = true;

			if(responses[0].data){
				$scope.listaOlo = responses[0].data;
			}else{
				$scope.erroreService("Errore durante il caricamento degli OAO. Riprovare più tardi");
			}

			if(responses[1].result.description == "OK" && responses[1].result.details != "Nessuna offerta trovata") {				
				//RU_961
				if(responses[1].tipoServizio && responses[1].tipoServizio.length > 0){
					responses[1].tipoServizio = responses[1].tipoServizio.map(function(servizio, index){
						return {
							value: servizio,
							code: responses[1].idFamigliaOfferta[index]
						};
					});
				}

				$scope.tipoServizioNuovoContr = {
						"tipoServizio" : responses[1].tipoServizio,
						"idFamigliaOfferta" : responses[1].idFamigliaOfferta,
				};							
			} else {
				$scope.loadOLO = false;
				$scope.erroreService("Nessuna offerta trovata.");
			}

			$scope.configureDataInizioValiditaContrattoOptions();
			$scope.configureDataFineValiditaContrattoOptions();
			$scope.configureDataInizioContrattoCoinvestimentoOptions();
			$scope.configureDataFineContrattoCoinvestimentoOptions();
			$scope.configureDataInizioAssociazioneOffertaOptions();
			$scope.configureDataFineAssociazioneOffertaOptions();

		}, function(error){
			$scope.datiRetrieved = true;
			$scope.erroreService("Errore durante il caricamento dei dati. Riprovare più tardi");
		});		
	}


	/**
	 * Recupera lista OLO
	 */
	$scope.configureListaOlo = function(){
		return IDsrolo.get({noDiffida: false}).$promise;
	}


	/**
	 * Recupera configurazioni offerte
	 */
	$scope.configureOfferte = function(){
		return RecuperoDatiContratto.get({}).$promise;
	}


	/**
	 * Configurazione opzioni Data Inizio Validità
	 */
	$scope.configureDataInizioValiditaContrattoOptions = function(){
		$scope.dataInizioValiditaContrattoConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				disabled: function(data){
					var date = data.date, mode = data.mode;
					return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6 ) &&
							(date.toISOString().split('T')[0] === new Date().toISOString().split('T')[0]));
				},
				dateOptions: {
					dateDisabled: this.disabled,
					formatYear: 'yy',
					minDate: new Date(),
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				},
				onChange: function(){
					if($scope.data.dataInizioValiditaContratto){
						var _date = angular.copy($scope.data.dataInizioValiditaContratto);
						_date.setDate(_date.getDate() + 1);
						$scope.data.dataFineValiditaContratto = null;
						$scope.dataFineValiditaContrattoConfig.dateOptions.minDate = _date;
					}
				}
		};
	}


	/**
	 * Configurazione opzioni Data Fine Validità
	 */
	$scope.configureDataFineValiditaContrattoOptions = function(){
		var date = new Date();
		date.setDate(date.getDate() + 1);

		$scope.dataFineValiditaContrattoConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				disabled: function(data){
					var date = data.date, mode = data.mode;
					return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
				},
				dateOptions: {
					dateDisabled: this.disabled,
					formatYear: 'yy',
					minDate: date,
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				},
				onChange: function(){
					if($scope.showSezioneSospensioneServizio && $scope.data.datiSospensioneServizio){
						$scope.data.datiSospensioneServizio.dataFineValiditaContratto = angular.copy($scope.data.dataFineValiditaContratto);
					}
				}
		};
	}

	/**
	 * Configurazione opzioni Data Inizio Coinvestimento
	 */
	$scope.configureDataInizioContrattoCoinvestimentoOptions = function(){
		$scope.dataInizioContrattoCoinvestimentoConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				disabled: function(data){
					var date = data.date, mode = data.mode;
					return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
				},
				dateOptions: {
					dateDisabled: this.disabled,
					formatYear: 'yy',
					initDate: new Date(),
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				},
				onChange: function(){
					if($scope.dataFineContrattoCoinvestimentoConfig && 
							$scope.dataFineContrattoCoinvestimentoConfig.dateOptions &&
							$scope.data.dataInizioCoinvestimento){
						$scope.dataFineContrattoCoinvestimentoConfig.dateOptions.minDate = new Date($scope.data.dataInizioCoinvestimento); 
					}
				}
		};
	}

	/**
	 * Configurazione opzioni Data Fine Coinvestimento
	 */
	$scope.configureDataFineContrattoCoinvestimentoOptions = function(){
		$scope.dataFineContrattoCoinvestimentoConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				disabled: function(data){
					var date = data.date, mode = data.mode;
					return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
				},
				dateOptions: {
					dateDisabled: this.disabled,
					formatYear: 'yy',
					initDate: new Date(2999, 11, 31),
					minDate: new Date(),
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				}
		};
	}	

	/**
	 * Configurazione opzioni Data Inizio Associazione offerta
	 */
	$scope.configureDataInizioAssociazioneOffertaOptions = function(){
		$scope.dataInizioAssociazioneOffertaConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				disabled: function(data){
					var date = data.date, mode = data.mode;
					return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
				},
				dateOptions: {
					dateDisabled: this.disabled,
					formatYear: 'yy',
					minDate: new Date(),
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				},
				onChange: function(){
					if($scope.data.dataInizioAssociazioneOfferta){
						var _data = angular.copy($scope.data.dataInizioAssociazioneOfferta);
						_data.setDate(_data.getDate() + 1);
						$scope.dataFineAssociazioneOffertaConfig.dateOptions.minDate = _data;
						$scope.data.dataFineAssociazioneOfferta = null;
					}
				}
		};
	}

	/**
	 * Configurazione opzioni Data Fine Associazione offerta
	 */
	$scope.configureDataFineAssociazioneOffertaOptions = function(){
		$scope.dataFineAssociazioneOffertaConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				disabled: function(data){
					var date = data.date, mode = data.mode;
					return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
				},
				dateOptions: {
					dateDisabled: this.disabled,
					formatYear: 'yy',
					minDate: new Date(),
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				}
		};
	}

	/**
	 * Configura tipo servizio e prodotti
	 */

	$scope.onChangeTipoServizio = function(){

		$scope.data.idFamigliaOfferta = "";

		//RU_1129
		$scope.selectedOfferteList = [];
		$scope.listaTipoContratto = [];
		$scope.offerta = {};
		$scope.offerteSelected = [];

		if($scope.data.tipoServizio && $scope.data.tipoServizio.code){
			$scope.data.idFamigliaOfferta = $scope.data.tipoServizio.code;			
			$scope.loadTipoContratto = true;
			$scope.loadTipoProdotti = true;

			//RU_1197
			RecuperoContratti.get({"tipoServizio": $scope.data.tipoServizio.value}).$promise
			.then(function (response) {
				if(response.result.description == "OK" && response.result.details != "Nessun contratto disponibile") {
					$scope.loadTipoContratto = false;
					$scope.listaTipoContratto = response.recuperoContrattoOutput.tipologiaContrattoOutput;
				} else {
					$scope.loadTipoContratto = false;
					$scope.erroreService("Nessun contratto disponibile.");
				}
			}, function () {
				$scope.loadTipoContratto = false;
				$scope.erroreService("Errore durante il caricamento del tipo contratto. Riprovare più tardi");
			}
			);

			RecuperoDatiContratto.get({idFamigliaOfferta: $scope.data.idFamigliaOfferta}).$promise.then(
					function (response) {
						$scope.loadTipoProdotti = false;

						$scope.offerta = {
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
						$scope.tipoProdotti = {
								"listaTipoProdotti":response.tipoProdotti,
								"idSottofamigliaOfferta":response.idSottofamigliaOfferta,
						};

						$scope.offerta.idOfferta.forEach(function(item){
							$scope.offerteSelected.push(false);
						});
					},
					function() {
						$scope.loadTipoProdotti = false;
						$scope.erroreService("Errore durante il caricamento dei dati. Riprovare più tardi");
					}
			);
		}
	}

	$scope.onChangeOfferteSelected = function(index){
		var isAdding = true;

		if(!$scope.offerteSelected[index]) {
			isAdding = false;
		}

		//SM_10055
		//Per tipo servizio == NGA, si puo scegliere solo un'offerta 
		//tra SEMI BTS NGA FTTH e SEMI EASYIP NGA FTTH 
		if($scope.data.idFamigliaOfferta == "5"){

			$scope.selectedOfferteList = [];

			if($scope.offerteSelected.length > 1){
				if(isAdding){					
					$scope.offerteSelected.forEach(function(item, i){
						if(i != index){
							$scope.offerteSelected[i] = false;
						}
					});
				}
			}
		}

		$scope.noSelectedOffers = !_.some($scope.offerteSelected);

		$scope.createSelectedArray(index, isAdding);

	};	

	$scope.createSelectedArray = function(index, isAdding){		
		$scope.offerta.idOfferta.forEach(function(offerta, i){
			if(i == index){
				if($scope.selectedOfferteList.indexOf($scope.offerta.idOfferta[i]) < 0 && isAdding) { // se offerta non è già presente
					$scope.selectedOfferteList.push($scope.offerta.idOfferta[i]);
				} else {
					if(!isAdding) {
						if($scope.selectedOfferteList.indexOf($scope.offerta.idOfferta[i]) > -1) {
							$scope.selectedOfferteList.splice($scope.selectedOfferteList.indexOf($scope.offerta.idOfferta[i]), 1);
						}
					}
				}
			}
		});
	};

	$scope.erroreService = function (messageBody) {
		modalService.showModal({}, {
			headerText: "Avviso",
			bodyText: messageBody,
			scope: $scope,
			type: 'success'
		});
		$scope.caricaPassFive = false;
	}


	$scope.submit = function(){
		var _request = {
				nuovoContratto: []
		};     

		if($scope.selectedOfferteList && $scope.selectedOfferteList.length > 0) {
			$scope.selectedOfferteList.forEach(function(item, index){
				var _contratto = {
						"codiceContratto": $scope.data.codiceContratto,
						"codificaOloAgcom": $scope.data.olo.id,
						"codiceOloNumerico": $scope.data.olo.codiceOLONumerico,
						"flagAbilitato": $scope.data.flagAbilitato,
						"flagFileNotify": $scope.data.flagFileNotify,
						"flagValido": $scope.data.flagValido,
						"nomeContratto": $scope.data.nomeContratto,
						"dataInizioValiditaContratto": $scope.convertDate($scope.data.dataInizioValiditaContratto),
						"dataFineValiditaContratto": $scope.convertDate($scope.data.dataFineValiditaContratto),
						"idFamigliaOfferta": $scope.data.idFamigliaOfferta,
						"idSottofamigliaOfferta": $scope.data.tipoProdotti.code,
						"idOfferta": $scope.selectedOfferteList[index],
						"dataInizioAssociazioneOffertaContratto": $scope.convertDate($scope.data.dataInizioAssociazioneOfferta),
						"dataFineAssociazioneOffertaContratto": $scope.convertDate($scope.data.dataFineAssociazioneOfferta),
						"idTipologiaContratto":$scope.data.tipoContratto						
				};

				//RU_1129
				if($scope.RU_1129 && $scope.showSezioneFwa){
					_contratto.contrattoFwaInfratel = $scope.data.contrattoFwaInfratel;
					_contratto.contrattoFwaPlus = $scope.data.contrattoFwaPlus;
					_contratto.contrattoFwaDecommissioning = $scope.data.contrattoFwaDecommissioning;
				}

				//RU_1164
				if($scope.showSezioneSemi){
					if($scope.data.dataInizioContrattoCoinvestimento && $scope.data.dataInizioContrattoCoinvestimento != ''){
						_contratto.dataInizioCoinvestimento = $scope.convertDate($scope.data.dataInizioContrattoCoinvestimento);
					}						
					if($scope.data.dataFineContrattoCoinvestimento && $scope.data.dataFineContrattoCoinvestimento != ''){
						_contratto.dataFineCoinvestimento = $scope.convertDate($scope.data.dataFineContrattoCoinvestimento);
					}						
				}

				//Task #36345
				if($scope.showSezioneSospensioneServizio && $scope.data.datiSospensioneServizio){
					_contratto.datiSospensioneServizio = {};
					_contratto.datiSospensioneServizio = angular.copy($scope.data.datiSospensioneServizio);
					
					//SM_10518
					if(!$scope.data.datiSospensioneServizio.dataInizioDisabil){
						_contratto.datiSospensioneServizio.dataInizioDisabil = null;
					}else{
						_contratto.datiSospensioneServizio.dataInizioDisabil = $scope.convertDate($scope.data.datiSospensioneServizio.dataInizioDisabil);
					}					
					if(!$scope.data.datiSospensioneServizio.dataFineDisabil){
						_contratto.datiSospensioneServizio.dataFineDisabil = null;
					}else{
						_contratto.datiSospensioneServizio.dataFineDisabil = $scope.convertDate($scope.data.datiSospensioneServizio.dataFineDisabil);
					}
				}
				
				//SM_10433
				if($scope.showFlagMulticast && $scope.data.flagMulticast){
					_contratto.flagMulticast = $scope.data.flagMulticast;
				}
				
				if($scope.showEmailFwaEolo){
					_contratto.emailOffertaFwa1GigaSardegna = $scope.data.emailOffertaFwa1GigaSardegna;
				}

				_request.nuovoContratto.push(_contratto);
			});    	

			$scope.showLoader = true;
			
			//SM11367
			if(_.indexOf($scope.selectedOfferteList, $rootScope.MAP_OFFERTE.FWAITALIA1GIGASARDEGNA.id) > -1){
				VerificaContrattoFwaEolo.get({codOloAgcom: $scope.data.olo.id}).$promise
				.then(function(response){
					if(response.esito.toUpperCase() == 'OK'){
						$scope._submit(_request);		
					}else{
						$scope.showLoader= false;
						$scope.erroreService("Contratto per servizio non stipulato dal Service Provider");
					}					
				}, function(error){
					$scope.showLoader= false;
					$scope.erroreService("Impossibile verificare contratto FWA Eolo");
				});
			}else{
				$scope._submit(_request);
			}
		}        
	}
	
	$scope._submit = function(_request){
		//RU_1010
		//Tracking da GUI per operazione INSERIMENTO
		var _trackBean = {
				timestampInizio: new Date().toISOString(),
				timestampFine: null,
				numeroDatiEsportati: 0,
				contenutoFile: null,
				nomeFile: null,
				tipoOperazione: TRACKING_GUI.EVENTI.INSERIMENTO.descrizione,
				parametriOperazione: null,
				descrizioneFunzione: 'Anagrafiche|Contratto|Nuovo Contratto'
		};
		
		NuovoContratto.save(_request.nuovoContratto).$promise
			.then(function(response){
				$scope.showLoader= false;				
				if(response.nuovoContrattoOutput){
					if(response.nuovoContrattoOutput.esito === 'OK'){
						_trackBean.timestampFine = new Date().toISOString();
						_trackBean.esito = 'Ok';
						TrackingGUI.tracking(_trackBean);
						
						///PEZZOTTONE
						if($scope.RU_1276 && !_.isEmpty($scope.data.datiComuniCoinvestimento) && !_.isEmpty($scope.data.datiComuniCoinvestimento.fileToUpload)){
							$scope.data.datiComuniCoinvestimento.idContratto = response.nuovoContrattoOutput.idContratto;
							$timeout(function(){
								$scope.$broadcast('startUploadFile', {});	
							}, 10);
							
						}else{		
							$scope.erroreService("Il contratto e' stato creato con successo.");
							$state.go('root.anagrafica.contratto');						
						}	
					}else{
						$scope.erroreService(response.result.details);
						
						_trackBean.timestampFine = new Date().toISOString();
						_trackBean.esito = 'Ko';
						TrackingGUI.tracking(_trackBean);
					}				
				}else{
					//SM_8049
					$scope.erroreService("Impossibile completare l'operazione. Riprovare piu' tardi");
				}
			}, function () {
				$scope.showLoader= false;
				$scope.erroreService("Impossibile completare l'operazione. Riprovare piu' tardi");				
				_trackBean.timestampFine = new Date().toISOString();
				_trackBean.esito = 'Ko';
				TrackingGUI.tracking(_trackBean);
			});
	}

	//RU_1129
	$scope.oscuramento_RU_1129 = function(){
		$scope.RU_1129 = !OSCURAMENTI.RU_1129.oscurato;
	}

	$scope.oscuramento_RU_1129();

	//SM_10029
	$scope.onChangeFwaCheckbox = function(){		
		if($scope.RU_1129 && $scope.showSezioneFwa){
			if((!$scope.data.contrattoFwaInfratel || $scope.data.contrattoFwaInfratel == 'N') && 
					(!$scope.data.contrattoFwaPlus || $scope.data.contrattoFwaPlus == 'N') && 
					(!$scope.data.contrattoFwaDecommissioning || $scope.data.contrattoFwaDecommissioning == 'N')){
				$scope.fwaCheckboxRequired = true;
			}else{
				$scope.fwaCheckboxRequired = false;
			}
		}else{
			$scope.fwaCheckboxRequired = false;
		}
	}

	//RU_1164
	$scope.oscuramento_RU_1164 = function(){
		$scope.RU_1164 = !OSCURAMENTI.RU_1164.oscurato;
	}

	$scope.oscuramento_RU_1164();
	
	//RU_1276
	$scope.oscuramento_RU_1276 = function(){
		$scope.RU_1276 = !OSCURAMENTI.RU_1276.oscurato;
	}

	$scope.oscuramento_RU_1276();

	$scope.$watchCollection('selectedOfferteList', function(newValue, oldValue){
		if(newValue && newValue.length > 0){
			var _arrayCreazioneFwa = $filter('filter')(newValue, $rootScope.MAP_OFFERTE.FWA.id);
			var _arrayCreazioneSemi = _.intersection(newValue, [$rootScope.MAP_OFFERTE.SEMI_VULA_H.id, $rootScope.MAP_OFFERTE.SEMI_BTS_H.id, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id]);

			//SM_11396
			var _arrayCreazioneEoloFwa = $filter('filter')(newValue, $rootScope.MAP_OFFERTE.FWAITALIA1GIGASARDEGNA.id);
			
			$scope.showEmailFwaEolo = (_arrayCreazioneEoloFwa && _arrayCreazioneEoloFwa.length > 0);
			
			//RU_1543
			var _isOffertaFullGpon = $filter('filter')(newValue, [$rootScope.MAP_OFFERTE.FULLGPONPLUS.id, $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.id]);
			if(_isOffertaFullGpon){
				$scope.showFlagMulticast = true;
			}else{
				$scope.showFlagMulticast = false;
			}
			
			
			if(_arrayCreazioneFwa && _arrayCreazioneFwa.length > 0){
				$scope.showSezioneFwa = true;				
			}
			//RU_1164
			if(_arrayCreazioneSemi && _arrayCreazioneSemi.length > 0){
				$scope.showSezioneSemi = true;

				//SM_10433
				$scope.showFlagMulticast = true;
				$scope.recuperaFlagMulticast();

				//Task #36345
				$scope.showSezioneSospensioneServizio = (_arrayCreazioneSemi.indexOf($rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id) > -1);
				if($scope.showSezioneSospensioneServizio){
					$scope.data.datiSospensioneServizio = {};					
					$scope.data.datiSospensioneServizio.dataFineValiditaContratto = angular.copy($scope.data.dataFineValiditaContratto);
				}else{
					delete $scope.data['datiSospensioneServizio'];
				}
				
				//RU_1276
				if($scope.RU_1276 && _arrayCreazioneSemi.length > 0 && $rootScope.isDGUser()){
					$scope.showSezioneComuniCoinvestimento = true;
					$scope.data.datiComuniCoinvestimento = {};
					$scope.data.datiComuniCoinvestimento.offerta = newValue[0];
					$scope.data.datiComuniCoinvestimento.codOloAgcom = $scope.data.olo.id;
				}else{
					$scope.showSezioneComuniCoinvestimento = false;
					delete $scope.data['datiComuniCoinvestimento'];
				}
			}			
		}else{
			$scope.showSezioneFwa = false;			
			//RU_1164
			$scope.showSezioneSemi = false;

			//SM_10433
			$scope.showFlagMulticast = false;	
			if($scope.data.flagMulticast){
				delete $scope.data['flagMulticast'];
			}

			//Task #36345
			$scope.showSezioneSospensioneServizio = false;
			if($scope.data.datiSospensioneServizio){
				delete $scope.data['datiSospensioneServizio'];
			}
			
			//RU_1276
			$scope.showSezioneComuniCoinvestimento = false;
			if($scope.data.datiComuniCoinvestimento){
				delete $scope.data['datiComuniCoinvestimento'];
			}
			
			//SM_11396
			$scope.showEmailFwaEolo = false;		
		}

		$scope.data.contrattoFwaInfratel = 'N';
		$scope.data.contrattoFwaPlus = 'N';
		$scope.data.contrattoFwaDecommissioning = 'N';
	});

	//SM_10433
	$scope.recuperaFlagMulticast = function(){			
		var _idOfferta = $scope.selectedOfferteList[0];
		var _codOloAgcom = $scope.data.olo.id;

		RecuperoFlagMulticast.get({idOfferta: _idOfferta, codOloAgcom: _codOloAgcom}).$promise
		.then(function(response){
			if(response.result && response.result.code == '0'){
				$scope.data.flagMulticast= response.flagMulticast;
			}else{
				$scope.erroreService(response.result.details);
			}				
		}, function(error){
			$scope.erroreService("Impossibile recuperare il valore di FLAG MULTICAST");
		});
	}
	
	//SM_10443
	$scope.convertDate = function(data){
		var _data = angular.copy(data);
		if(_data && _.isDate(_data)){
			//SM_10518
			_data = moment(data).format();
		}
		return _data;
	}

	$scope.annulla = function() {
		$state.go('root.anagrafica.contratto');
	}
	
	//RU_1276
	$scope.$on('endFileUploadError', function(evt, data){
		//CR #37752		
		$scope.erroreService("Errore nell'upload del file: " + data);
		$state.go('root.anagrafica.contratto');
	});
	
	$scope.$on('endFileUploadSuccess', function(evt, data){	
		$scope.erroreService("Contratto creato con successo, file depositato ed elaborazione avviata");
		$state.go('root.anagrafica.contratto');
	})

	$scope.init();
}]);
///////NEW!!!!!

timnow.controller("modificaContrattoNew", ['$scope', '$state', '$rootScope', 'modalService', 'ModificaContratto', 'RecuperoDettaglioContratto', 'TRACKING_GUI', 'TrackingGUI','OSCURAMENTI', '_', '$q', '$filter','$timeout',
	function($scope, $state, $rootScope, modalService, ModificaContratto, RecuperoDettaglioContratto, TRACKING_GUI, TrackingGUI, OSCURAMENTI, _, $q, $filter, $timeout){

	$scope.data = {};
	
	$scope.idContratto = ($state.params.idContratto || null);

	$scope.idContrattoOffertaCatalogo = "";
	$scope.checkAlmostOneFwa = false;
	$scope.altInputFormats = "dd/MM/yyyy";
	
	//RU_1210
	$scope.showSezioneDatiMulticast = false;
	
	//RU_1180
	$scope.multicastData = {};
	$scope.fileNamePattern = /MC_CONTRATTO_[0-9]{3}_[0-9]{2}[0-9]{2}[0-9]{4}_[0-9]{1,}.csv/gm;
	$scope.isDGUser = $rootScope.isDGUser();
	
	//RU_1276
	$scope.fileToUpload = {};

	$scope.init = function(){

		$scope.datiRetrieved = false;		
		
		$scope.data.flagFileNotify = 'N';
		$scope.data.flagAbilitato = 'N';
		$scope.data.flagValido = 'N';

		$scope.data.contrattoFwaPlus = 'N';
		$scope.data.contrattoFwaDecommissioning = 'N';
		$scope.data.contrattoFwaInfratel = 'N';
		
		RecuperoDettaglioContratto.get({"idContratto":$scope.idContratto}).$promise
		.then(function(response){
			
			if(response && response.dettaglioContratto){
				var _dettaglio = response.dettaglioContratto;
				$scope.data.offerteSelected = [];
				
				$scope.data.codiceOloNumerico = _dettaglio.codiceOloNumerico;
				$scope.data.codificaOloAgcom = _dettaglio.codificaOloAgcom;
				$scope.data.flagFileNotify = _dettaglio.flagFileNotify;
				$scope.data.flagAbilitato = _dettaglio.flagAbilitato;
				$scope.data.flagValido = _dettaglio.flagValido;
				$scope.data.dataInizioValiditaContratto = new Date(_dettaglio.dataInizioValiditaContratto);
				$scope.data.dataFineValiditaContratto = new Date(_dettaglio.dataFineValiditaContratto);				
				$scope.data.dataInizioAssociazioneOfferta = new Date(_dettaglio.dataInizioAssociazioneOffertaContratto);
				$scope.data.dataFineAssociazioneOfferta = new Date(_dettaglio.dataFineAssociazioneOffertaContratto);
				$scope.data.idContrattoOffertaCatalogo = _dettaglio.idContrattoOffertaCatalogo;
				$scope.data.nomeContratto = _dettaglio.nomeContratto;
				$scope.data.tipoServizio = _dettaglio.tipoServizio;
				$scope.data.offerteSelected[0] = _dettaglio.offerta;
				$scope.data.tipoContratto = _dettaglio.tipoContratto;
				$scope.data.tipoProdotti = _dettaglio.tipoProdotti;
				$scope.data.codiceContratto = _dettaglio.codiceContratto;
				$scope.data.contrattoFwaInfratel = _dettaglio.contrattoFwaInfratel;
				$scope.data.contrattoFwaPlus = _dettaglio.contrattoFwaPlus;
				$scope.data.contrattoFwaDecommissioning = _dettaglio.contrattoFwaDecommissioning;
				$scope.data.flagMulticast = _dettaglio.flagMulticast;
				
				//RU_1180
				$scope.multicastData.idContratto = $scope.idContratto;
				$scope.multicastData.listaFileCsv = (_dettaglio.listaFileCsv ? _dettaglio.listaFileCsv : []);
				//SM_10575
				if(_dettaglio.bouquet && _dettaglio.bouquet != ''){		
						var _splittedBouquet = 	_dettaglio.bouquet.split('Bouquet');
						$scope.multicastData.bouquet = _splittedBouquet[1];
				}else{
						$scope.multicastData.bouquet = "";
				}					
				
				//SM_9996
				if(_dettaglio.offerta.toLowerCase() == "fixedwirelessaccess"){								
					$scope.data.contrattoFwaInfratel = _dettaglio.contrattoFwaInfratel;
					$scope.data.contrattoFwaPlus = _dettaglio.contrattoFwaPlus;
					$scope.data.contrattoFwaDecommissioning = _dettaglio.contrattoFwaDecommissioning;
					$scope.showSezioneFwa = true;
				}
				
				//RU_1164
				if(["semibitstreamngaftth", "semivulaftth", "semieasyipubbftth"].indexOf(_dettaglio.offerta.toLowerCase()) > -1){					
					$scope.data.dataInizioContrattoCoinvestimento = (_dettaglio.dataInizioCoinvestimento ? new Date(_dettaglio.dataInizioCoinvestimento) : null);
					$scope.data.dataFineContrattoCoinvestimento = (_dettaglio.dataFineCoinvestimento ? new Date(_dettaglio.dataFineCoinvestimento) : null);
					$scope.showSezioneSemi = true;
				}
				
				//SM_10292
				if(_dettaglio.offerta.toLowerCase() == 'semieasyipubbftth'){
					$scope.showSezioneSospensioneServizio = true;
					$scope.data.datiSospensioneServizio = {};
					
					if(_dettaglio.datiSospensioneServizio){														
						$scope.data.datiSospensioneServizio = angular.copy(_dettaglio.datiSospensioneServizio);
						$scope.data.datiSospensioneServizio.dataFineValiditaContratto = new Date(_dettaglio.dataFineValiditaContratto);
						if($scope.data.datiSospensioneServizio.dataInizioDisabil && $scope.data.datiSospensioneServizio.dataInizioDisabil != ''){
							$scope.data.datiSospensioneServizio.dataInizioDisabil = new Date($scope.data.datiSospensioneServizio.dataInizioDisabil);
						}
						if($scope.data.datiSospensioneServizio.dataFineDisabil && $scope.data.datiSospensioneServizio.dataFineDisabil != ''){
							$scope.data.datiSospensioneServizio.dataFineDisabil = new Date($scope.data.datiSospensioneServizio.dataFineDisabil);
						}
					}			
				}
				
				//SM_11396
				if(_dettaglio.offerta.toLowerCase() == 'fwaitalia1gigasardegna'){
					$scope.data.emailOffertaFwa1GigaSardegna = _dettaglio.emailOffertaFwa1GigaSardegna || '';
					$scope.showEmailFwaEolo = true;
				}
							
				$scope.datiRetrieved = true;
				
				//RU_1210
				$scope.showSezioneMulticast = $scope.setShowSezioneMulticast();
			}
			
			$scope.configureDataFineValiditaContrattoOptions();
			$scope.configureDataInizioContrattoCoinvestimentoOptions();
			$scope.configureDataFineContrattoCoinvestimentoOptions();
			$scope.configureDataFineAssociazioneOffertaOptions();
			
		}, function(error){
			$scope.datiRetrieved = true;
			$scope.erroreService("Errore durante il recupero dei dati. Riprovare più tardi");
		});
		
	}


	/**
	 * Configurazione opzioni Data Fine Validità
	 */
	$scope.configureDataFineValiditaContrattoOptions = function(){
		
		var _date = null;
		
		if($scope.data.dataInizioValiditaContratto){
			_date = new Date($scope.data.dataInizioValiditaContratto);
		}else{
			_date = new Date();
		}	
		_date.setDate(_date.getDate() + 1);

		$scope.dataFineValiditaContrattoConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				dateOptions: {
					formatYear: 'yy',
					minDate: _date,
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				},
				onChange: function(){
					//Task #36345
					$timeout(function(){
						if($scope.data.dataFineValiditaContratto){
							var _millisDataFineVal = $scope.data.dataFineValiditaContratto.getTime();
							var _millisDataCurrent = new Date().getTime();
							
							if(_millisDataFineVal < _millisDataCurrent){
								$scope.fwaCheckboxDisabled = true;
							}else{
								$scope.fwaCheckboxDisabled = false;
							}					
						}
						
						if($scope.showSezioneSospensioneServizio && $scope.data.datiSospensioneServizio){	
							$scope.data.datiSospensioneServizio.dataFineValiditaContratto = angular.copy($scope.data.dataFineValiditaContratto);
						}
					}, 5);
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
				dateOptions: {
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
		
		var date = null;
		
		if($scope.data.dataInizioContrattoCoinvestimento){
			date = new Date($scope.data.dataInizioContrattoCoinvestimento);
		}else{
			date = new Date();
		}	
		date.setDate(date.getDate() + 1);
		
		$scope.dataFineContrattoCoinvestimentoConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,
				dateOptions: {
					formatYear: 'yy',
					initDate: new Date(2999, 11, 31),
					minDate: date,
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				}
		};
	}	


	/**
	 * Configurazione opzioni Data Fine Associazione offerta
	 */
	$scope.configureDataFineAssociazioneOffertaOptions = function(){
		
		var date = null;
		if($scope.data.dataFineAssociazioneOfferta){
			date = new Date($scope.data.dataFineAssociazioneOfferta);
		}else{
			date = new Date();
		}	
		date.setDate(date.getDate() + 1);
		
		$scope.dataFineAssociazioneOffertaConfig = {
				formats: ['dd/MM/yyyy', 'shortDate'],
				format: 'dd/MM/yyyy',
				popupOpened : false,				
				dateOptions: {
					formatYear: 'yy',
					minDate: new Date(),
					startingDay: 1
				},
				open: function(){
					this.popupOpened = !this.popupOpened;
				}
		};
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


	$scope.submit = function(){
		var _request = {};     

		if($scope.data.offerteSelected && $scope.data.offerteSelected.length > 0) {
			$scope.data.offerteSelected.forEach(function(item, index){
				_request = {
						"modificaContrattoInput": {		
							"idContratto": $scope.idContratto,
							"idContrattoOffertaCatalogo": $scope.data.idContrattoOffertaCatalogo,							
							"flagAbilitato": $scope.data.flagAbilitato,
							"flagFileNotify": $scope.data.flagFileNotify,
							"flagValido": $scope.data.flagValido,
							"flagMulticast": $scope.data.flagMulticast,
							"dataInizioValiditaContratto": $scope.convertDate($scope.data.dataInizioValiditaContratto),
							"dataFineValiditaContratto": $scope.convertDate($scope.data.dataFineValiditaContratto),
							"dataFineAssociazioneOffertaContratto": $scope.convertDate($scope.data.dataFineAssociazioneOfferta)
					}
				};

				//RU_1129
				if($scope.RU_1129 && $scope.showSezioneFwa){
					_request.modificaContrattoInput.contrattoFwaInfratel = $scope.data.contrattoFwaInfratel;
					_request.modificaContrattoInput.contrattoFwaPlus = $scope.data.contrattoFwaPlus;
					_request.modificaContrattoInput.contrattoFwaDecommissioning = $scope.data.contrattoFwaDecommissioning;
				}

				//RU_1164
				if($scope.showSezioneSemi){
					if($scope.data.dataInizioContrattoCoinvestimento && $scope.data.dataInizioContrattoCoinvestimento != ''){
						_request.modificaContrattoInput.dataInizioCoinvestimento = $scope.convertDate($scope.data.dataInizioContrattoCoinvestimento);
					}						
					if($scope.data.dataFineContrattoCoinvestimento && $scope.data.dataFineContrattoCoinvestimento != ''){
						_request.modificaContrattoInput.dataFineCoinvestimento = $scope.convertDate($scope.data.dataFineContrattoCoinvestimento);
					}						
				}
				
				//RU_1210
				if($scope.showSezioneMulticast && !_.isEmpty($scope.multicastData)){
					//SM_10694
					_request.modificaContrattoInput.bouquet = "Bouquet" + $scope.multicastData.bouquet;
				}
				
				//Task #36345
				if($scope.showSezioneSospensioneServizio && $scope.data.datiSospensioneServizio){
					_request.modificaContrattoInput.datiSospensioneServizio = {};					
					_request.modificaContrattoInput.datiSospensioneServizio = angular.copy($scope.data.datiSospensioneServizio);
					_request.modificaContrattoInput.datiSospensioneServizio.dataInizioDisabil = $scope.convertDate($scope.data.datiSospensioneServizio.dataInizioDisabil);
					_request.modificaContrattoInput.datiSospensioneServizio.dataFineDisabil = $scope.convertDate($scope.data.datiSospensioneServizio.dataFineDisabil);
				}
				
				//SM_11396
				if($scope.showEmailFwaEolo){
					_request.modificaContrattoInput.emailOffertaFwa1GigaSardegna = $scope.data.emailOffertaFwa1GigaSardegna;
				}				
			});    	


			//RU_1010
			//Tracking da GUI per operazione INSERIMENTO
			var _trackBean = {
					timestampInizio: new Date().toISOString(),
					timestampFine: null,
					numeroDatiEsportati: 0,
					contenutoFile: null,
					nomeFile: null,
					tipoOperazione: TRACKING_GUI.EVENTI.MODIFICA.descrizione,
					parametriOperazione: null,
					descrizioneFunzione: 'Anagrafiche|Contratto|Modifica Contratto'
			};
			
			$scope.showLoader = true;

			ModificaContratto.save(_request).$promise
			.then(function(response){
				$scope.showLoader= false;
				if (response && response.esito === 'OK') {			

					_trackBean.timestampFine = new Date().toISOString();
					_trackBean.esito = 'Ok';
					TrackingGUI.tracking(_trackBean);					
					
					///PEZZOTTONE
					if($scope.RU_1276 && !_.isEmpty($scope.data.datiComuniCoinvestimento) && !_.isEmpty($scope.data.datiComuniCoinvestimento.fileToUpload)){
						$scope.$broadcast('startUploadFile', {});
					}else{		
						$scope.erroreService("Il contratto e' stato modificato con successo.");
						$state.go('root.anagrafica.contratto');						
					}
					
				} else {
					if(response && response.esito === 'KO' && response.result && response.result.details) {
						$scope.erroreService(response.result.details);
					}else{
						//SM_8049
						$scope.erroreService("Impossibile completare l'operazione. Riprovare piu' tardi");
					}

					_trackBean.timestampFine = new Date().toISOString();
					_trackBean.esito = 'Ko';
					TrackingGUI.tracking(_trackBean);
				}

			}, function () {
				$scope.showLoader= false;
				$scope.erroreService("Impossibile completare l'operazione. Riprovare piu' tardi");				
				_trackBean.timestampFine = new Date().toISOString();
				_trackBean.esito = 'Ko';
				TrackingGUI.tracking(_trackBean);
			});
		}        
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

	//RU_1210
	//SM_10575
	//SM_10683
	//RU_1543
	$scope.setShowSezioneMulticast = function(){
		return ($scope.datiRetrieved &&  $scope.isDGUser && $scope.data.flagMulticast && $scope.data.flagMulticast == 'Y');
	}
	
	//RU_1276
	$scope.oscuramento_RU_1276 = function(){
		$scope.RU_1276 = !OSCURAMENTI.RU_1276.oscurato;
	}

	$scope.oscuramento_RU_1276();

	$scope.$watchCollection('data.offerteSelected', function(newValue, oldValue){
		if(newValue && newValue.length > 0){
			var _arrayCreazioneFwa = $filter('filter')(newValue, $rootScope.MAP_OFFERTE.FWA.name);
			
			//SM_11396
			var _arrayCreazioneEoloFwa = $filter('filter')(newValue, $rootScope.MAP_OFFERTE.FWAITALIA1GIGASARDEGNA.name);
			$scope.showEmailFwaEolo = (_arrayCreazioneEoloFwa && _arrayCreazioneEoloFwa.length > 0);
			
			//SM_11367
			var _arrayCreazioneSemi = _.intersection(newValue, [$rootScope.MAP_OFFERTE.SEMI_VULA_H.name, $rootScope.MAP_OFFERTE.SEMI_BTS_H.name, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name]);
			if(_arrayCreazioneFwa && _arrayCreazioneFwa.length > 0){
				$scope.showSezioneFwa = true;				
			}
			
			//RU_1543
			$scope._isFullGpon = ([$rootScope.MAP_OFFERTE.FULLGPONPLUS.name, $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.name].indexOf(newValue[0]) > -1);
			
			if($scope._isFullGpon){
				$scope.showFlagMulticast = true;
				$scope.showSezioneMulticast = false
			}else{
				$scope.showFlagMulticast = false;
			}
			
			//RU_1164
			if(_arrayCreazioneSemi && _arrayCreazioneSemi.length > 0) {
				$scope.showSezioneSemi = true;	
				
				//SM_10433
				$scope.showFlagMulticast = true;
				
				//RU_1276
				if($scope.RU_1276 && $rootScope.isDGUser()){
					$scope.showSezioneComuniCoinvestimento = true;
					$scope.data.datiComuniCoinvestimento = {};
					
					var _offerta =  _.chain($rootScope.MAP_OFFERTE).findWhere({name: newValue[0]}).value();
					
					$scope.data.datiComuniCoinvestimento.offerta = _offerta.id;
					$scope.data.datiComuniCoinvestimento.codOloAgcom = $scope.data.codificaOloAgcom;
					$scope.data.datiComuniCoinvestimento.idContratto = $scope.idContratto;
				}else{
					$scope.showSezioneComuniCoinvestimento = false;
					delete $scope.data['datiComuniCoinvestimento'];
				}
			}
		}else{
			$scope.showSezioneFwa = false;
			
			//SM_10938
			$scope.data.contrattoFwaInfratel = 'N';
			$scope.data.contrattoFwaPlus = 'N';
			$scope.data.contrattoFwaDecommissioning = 'N';
						
			//RU_1164
			$scope.showSezioneSemi = false;
			
			//SM_10433
			$scope.showFlagMulticast = false;
			
			//RU_1276
			$scope.showSezioneComuniCoinvestimento = false;
			if($scope.data.datiComuniCoinvestimento){
				delete $scope.data['datiComuniCoinvestimento'];
			}
			
			//SM_11396
			$scope.showEmailFwaEolo = false;	
		}
	});
	
	//SM_10443
	$scope.convertDate = function(data){
		var _data = data;
		if(data && _.isDate(data)){		
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
		$scope.erroreService("Contratto modificato con successo, file depositato ed elaborazione avviata.");
		$state.go('root.anagrafica.contratto');
	});
	
	$scope.init();

}]);
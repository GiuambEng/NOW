timnow.controller('disambiguazione',['alertService', '$rootScope','$scope','$state','$log','$filter','IDsrolo','Addresses','Locator','modalService','OfferteDisambiguazione','Lavorazioni','CRM_PROFILE',
	function(alertService, $rootScope, $scope, $state, $log, $filter,
			IDsrolo, Addresses, Locator, modalService,
			OfferteDisambiguazione, Lavorazioni, CRM_PROFILE) {

		$rootScope.pageClass = $state.params.pageClass;
		$scope.data = {};
		$scope.ob = {};
		$scope.OLOsettato = false;
		$scope.disambiguazioneLoaded = false;
		$scope.disableButton = true;
		$scope.profiloVisibile =($rootScope.timnowConfigData.user.codiceProfilo !== CRM_PROFILE.CRM_OLO && $rootScope.timnowConfigData.user.codiceProfilo !== CRM_PROFILE.CRM_OLORO);
		$scope.comuniLoaded = false;

		$scope.checkProfiloOLO = function() {
			if ($rootScope.timnowConfigData.user.codiceProfilo === CRM_PROFILE.CRM_OLO
					|| $rootScope.timnowConfigData.user.codiceProfilo === CRM_PROFILE.CRM_OLORO) {
				$scope.OLOsettato = true;
				$scope.data.codiceOlo = $rootScope.timnowConfigData.user.codificaOloAgcom;
			}
		};

		$scope.changeLavorazione = function() {
			$scope.data.servizio = $scope.data.provincia = $scope.data.comune = $scope.data.codiceComune = $scope.data.idRisorsa = $scope.data.idRisorsa2 = $scope.data.codiceOrdineOlo = $scope.data.codiceOrdineRiferimentoTi1 = $scope.data.codiceOrdineRiferimentoTi2 = $scope.data.dn = null;
			$scope.data.lavorazione = $scope.data.lavorazioneObject.idTipologiaLavorazione
			$scope.setOLOsettato();
			$scope.loadServiziFiltrati($scope.data.lavorazione);
			$scope.checkCampi();
		};

		$scope.setOLOsettato = function() {
			$scope.OLOsettato = true;
		};

		$scope.displayExit = function(msg) {
			alertService.add(msg,"danger",15000);
		};

		$scope.resetExit = function(msg) {
			$log.debug(msg);
		};

		$scope.queryLocator = function() {
			if ($scope.disambiguazioneForm.$valid) {

				if ($scope.ob.codiceOloAr) {
					$scope.data.codiceOlo = $scope.ob.codiceOloAr.codiceOLO;
				}

				$scope.disableButton = true;
				$scope.disambiguazioneLoaded = false;

				if ($scope.data.comune && $scope.data.comune.idComune) {
					$scope.data.codiceComune = $scope.data.comune.idComune;
				}

				if ($scope.data.codiceOrdineRiferimentoTi1) {
					$scope.data.codiceOrdineRiferimentoTi = $scope.data.codiceOrdineRiferimentoTi1;
				}
				if ($scope.data.codiceOrdineRiferimentoTi2) {
					$scope.data.codiceOrdineRiferimentoTi = $scope.data.codiceOrdineRiferimentoTi2;
				}
				if ($scope.data.servizio) {
					$scope.offerta = $scope.data.servizio.offerta;
				} else {
					$scope.offerta = "";
				}

				$scope.dnaggiuntivi = [];
				for (var i = 0; i < $scope.aggiuntivi.length; i++) {
					if($scope.aggiuntivi[i].name){
						$scope.dnaggiuntivi.push($scope.aggiuntivi[i].name);
					}
				}
				if($scope.dnaggiuntivi.length === 0){
					delete $scope.dnaggiuntivi;
				}						
				
				//CHIAMATA AL SYSTEM LOCATOR DISABILITATA
				$scope.resetData();
				$scope.disableButton = false;
				// C11M08F16 - Verifica ordine in ambito
				if(!$rootScope.OSCURAMENTI.RU_1612.oscurato) {
					var locatorQuery = {
						"codiceOlo" : $scope.data.codiceOlo,
						"servizio" : $scope.offerta,
						"lavorazione" : $scope.data.lavorazioneObject.tipologiaLavorazione,
						"codiceOrdineOlo" : $scope.data.codiceOrdineOlo,
						"codiceOrdineRiferimentoTi" : $scope.data.codiceOrdineRiferimentoTi,
						"idRisorsa" : $scope.data.idRisorsa,
						"sottolavorazione" : $scope.data.sottolavorazione,
						"codiceComune" : $scope.data.comune===null? $scope.data.comune:$scope.data.comune.descrComune,
						"idRisorsa2" : $scope.data.idRisorsa2,
						"dn" : $scope.data.dn,
						"DNAggiuntivi" : $scope.dnaggiuntivi,
						"rientro" : $scope.data.rientro
					};


					$log.info(locatorQuery);

					Locator.save(locatorQuery,
									function(data) {
										$log.debug(data);
										$scope.disambiguazioneLoaded = true;
										$scope.displayExit(data.descrizione);
										if (data.esito === "OK") {
	//										$scope.resetData();
											$scope.disableButton = false;
										} else {
											modalService.showModal(
													{},
													{
														headerText : "Disambiguazione",
														bodyText :data.descrizione,
														actionButtonText : 'Chiudi',
														type : 'warning'
													});
										}
										
									},
									function(error) {
										$log.debug(error);
										$scope.disambiguazioneLoaded = true;
										$scope.disableButton = false;
										modalService.showModal(
														{},
														{
															headerText : "Disambiguazione",
															bodyText : "Non è stato possibile completare l'operazione. Riprova più tardi.",
															actionButtonText : 'Chiudi',
															type : 'warning'
														});
									});
				}
			}
		};

		if (!$scope.idsrolo) {
			var idsrolo = IDsrolo.get({
				noDiffida : false
			});

			idsrolo.$promise.then(function(response) {

				if (response.data) {
					$scope.idsrolo = $filter('orderBy')(
							response.data, 'codiceOLO');
					$scope.disambiguazioneLoaded = true;
				}
			}, function(error) {
				$log.debug(error);
				$scope.disambiguazioneLoaded = true;
			});
		}

		// carico le lavorazioni appena sono pronte
		Lavorazioni.get().$promise.then(function(response) {
			$scope.lavorazioni = response.data;
		}, function(error) {
			$log.debug(error);
		});

		$scope.resetData = function() {
			$scope.ob.codiceOloAr = null;
			$scope.data.codiceOlo = null;
			$scope.data.codiceOrdineOlo = null;
			$scope.data.codiceOrdineRiferimentoTi1 = null;
			$scope.data.codiceOrdineRiferimentoTi2 = null;
			$scope.data.provincia = null;
			$scope.data.comune = null;
			$scope.data.idRisorsa = null;
			$scope.data.idRisorsa2 = null;
			$scope.data.lavorazione = null;
			$scope.data.lavorazioneObject = null;
			$scope.data.servizio = null;
			$scope.data.rientro = null;
			$scope.data.dn = null;
			$scope.OLOsettato = false;
			$scope.checkProfiloOLO();
			$scope.viewServizio = $scope.viewIdRisorsa = $scope.viewDN = $scope.viewDNAggiuntivi = $scope.viewIdRisorsa2 = $scope.viewSottolavorazione = $scope.viewProvincia = $scope.viewComune = $scope.viewCodiceOrdineOlo = $scope.viewCodiceOrdineTI1 = $scope.viewCodiceOrdineTI2 = $scope.viewRientro = false;
			$scope.toggleInviaButton();
		}

		/* Carica i servizi filtrati. */
		$scope.loadServiziFiltrati = function(item) {
			$scope.ServiziLoaded = false;
			function successCallback(response) {
				$scope.ServiziLoaded = true;
				$scope.servizi = response.data;
				$scope.servizi.push({
					nomeOfferta : 'ALTRO',
					offerta : 'ALTRO'
				});
			}

			function errorCallback(error) {
				$log.debug(error);
				$scope.ServiziLoaded = true;
				$rootScope.alertGenericError();
			}

			OfferteDisambiguazione.get({
				tplg_lavrz : item
			}).$promise
					.then(successCallback, errorCallback);
		};

		$scope.toggleInviaButton = function() {

			$scope.campoObbligatorio = $scope.data.lavorazione === '1' && !$scope.viewIdRisorsa && $scope.viewDN && !$scope.data.dn;
			$scope.campoObbligatorio2 = $scope.data.lavorazione === '4' && !$scope.data.idRisorsa;

			if (($scope.OLOsettato && !$scope.data.lavorazione)
					|| ($scope.data.lavorazione === '-1')
					|| ($scope.viewServizio && !$scope.data.servizio)
					|| ($scope.viewProvincia && !$scope.data.provincia)
					|| ($scope.viewComune && !$scope.data.comune)
					|| ($scope.viewSottolavorazione && !$scope.data.sottolavorazione)
					|| ($scope.viewCodiceOrdineTI2 && !$scope.data.codiceOrdineRiferimentoTi2)
					|| ($scope.viewIdRisorsa && !$scope.data.idRisorsa && !$scope.viewDN)
					|| (($scope.viewIdRisorsa && $scope.viewDN && $scope.data.lavorazione !== '4') && (($scope.data.idRisorsa && $scope.data.dn) || (!$scope.data.idRisorsa && !$scope.data.dn)))
					|| ($scope.viewCodiceOrdineOlo && !$scope.data.codiceOrdineOlo && !$scope.data.codiceOrdineRiferimentoTi1)
					|| ($scope.data.lavorazione === '1' && !$scope.viewIdRisorsa && $scope.viewDN && !$scope.data.dn)
					|| (($scope.viewCodiceOrdineOlo && $scope.viewCodiceOrdineTI1) && (($scope.data.codiceOrdineOlo && $scope.data.codiceOrdineRiferimentoTi1) || (!$scope.data.codiceOrdineOlo && !$scope.data.codiceOrdineRiferimentoTi1)))
					|| ($scope.data.servizio && $scope.data.servizio.offerta === 'ALTRO')
					|| ($scope.data.servizio && $scope.data.servizio.idOfferta === '46') //fix FWA
					|| $scope.campoObbligatorio
					|| $scope.campoObbligatorio2) {
				$scope.disableButton = true;
			} else {
				$scope.disableButton = false;
			}
		};

		$scope.checkCampi = function() {
			// LOGICA DI VISUALIZZAZIONE CAMPI
			/**
			    1	ATTIVAZIONE	ATTIVAZIONE
				2	CESSAZIONE	CESSAZIONE
				3	VARIAZIONE	VARIAZIONE
				4	MIGRAZIONE	MIGRAZIONE
				5	ANNULLAMENTO	ANNULLAMENTO
				6	CANCELLAZIONEACCODAMENTO	CANCELLAZIONE ACCODAMENTO
				7	RIMODULAZIONEDAD	RIMODULAZIONE DAD
				8	INTERRUZIONESOSPENSIONE	INTERRUZIONE SOSPENSIONE
				9	STATOAVANZAMENTO	STATO AVANZAMENTO
				10	ALL	ALL
				11	STATOACCODAMENTO	STATO ACCODAMENTO
				12	RIMODULAZIONEDA	RIMODULAZIONE DA
				13	DESOSPENSIONE	DESOSPENSIONE
				14	RIMODULAZIONEDAC	RIMODULAZIONE DAC
				15	RISCONTROCODICESESSIONE	RISCONTRO CODICE SESSIONE
				16	INTERRUZIONEMIGRAZIONE	INTERRUZIONE MIGRAZIONE
				17	ACCETTAZIONEOPERESPECIALI	ACCETTAZIONE OPERE SPECIALI
				18	RIMODULAZIONEDACDARECIPIENT	RIMODULAZIONE DAC DA RECIPIENT
				19	VALIDFORMALEDONATINGDONOR	VALID FORMALE DONATING DONOR
				20	VALIDTECNICADONATINGDONOR	VALID TECNICA DONATING DONOR
				21	VALIDTECNICACESSAZIONE	VALID TECNICA CESSAZIONE
				22	ESPLETAMENTODONORRECIPIENTDONATING	ESPLETAMENTO DONOR RECIPIENT DONATING
				24	RICHIESTAINTERRUZIONERECIPIENT	RICHIESTA INTERRUZIONE RECIPIENT
			 */
			 
			// variabili portatori per ottimizzare le condizioni 
			$scope.lavorazioniCodiceOrdineOLO = ['5','13'];
			$scope.lavorazioniCodiceOrdineTI = ['5','6','7','8','9','12','13','14','15','16','17','18','24'];
			$scope.lavorazioniCodiceOrdineTI2 = [];

			$scope.viewServizio 		=  $scope.data.lavorazione === '1' || $scope.data.lavorazione === '2' || 
											$scope.data.lavorazione === '3' || $scope.data.lavorazione === '4';
			$scope.viewIdRisorsa 		= ($scope.data.lavorazione === '2' || $scope.data.lavorazione === '3' || 
											$scope.data.lavorazione === '4') && ($scope.data.servizio && $scope.data.servizio.offerta !== 'ALTRO') && ($scope.data.servizio && $scope.data.servizio.idOfferta !== '46'); //fix FWA
			$scope.viewDN 				= ($scope.data.lavorazione === '1' && 
										($scope.data.servizio && [$rootScope.MAP_OFFERTE.ULL_LANP.id,$rootScope.MAP_OFFERTE.ULLD_LANP.id,$rootScope.MAP_OFFERTE.SLU_LANP.id,
										                          $rootScope.MAP_OFFERTE.ULL_LA.id,$rootScope.MAP_OFFERTE.ULLD_LA.id, $rootScope.MAP_OFFERTE.SLU_LA.id,
										                          $rootScope.MAP_OFFERTE.WLR_LA.id,$rootScope.MAP_OFFERTE.VULL_LA.id].indexOf($scope.data.servizio.idOfferta) >= 0)) ||
			 						     (($scope.data.lavorazione === '2' || $scope.data.lavorazione === '3' || $scope.data.lavorazione === '4') && ($scope.data.servizio && $scope.data.servizio.offerta !== 'ALTRO') && ($scope.data.servizio && $scope.data.servizio.idOfferta !== '46')); //fix FWA
			$scope.viewDNAggiuntivi 	= ($scope.data.lavorazione === '1' && ($scope.data.servizio && [$rootScope.MAP_OFFERTE.ULL_LANP.id,$rootScope.MAP_OFFERTE.ULLD_LANP.id,$rootScope.MAP_OFFERTE.SLU_LANP.id].indexOf($scope.data.servizio.idOfferta) >= 0)) || 
										   $scope.data.lavorazione === '4';
			$scope.viewIdRisorsa2 		=  $scope.data.lavorazione === '4' && ($scope.data.servizio && $scope.data.servizio.offerta !== 'ALTRO' && $scope.data.servizio.idOfferta !== '46'); //fix FWA
			$scope.viewSottolavorazione =  $scope.data.lavorazione === '3' && ($scope.data.servizio && [$rootScope.MAP_OFFERTE.ULL_LNA.id,$rootScope.MAP_OFFERTE.ULL_LA.id,
			                                                                                    		$rootScope.MAP_OFFERTE.ULLD_LNA.id,$rootScope.MAP_OFFERTE.ULLD_LA.id,
			                                                                                    		$rootScope.MAP_OFFERTE.ULL_LANP.id,$rootScope.MAP_OFFERTE.ULLD_LANP.id].indexOf($scope.data.servizio.idOfferta) >= 0);
			$scope.viewProvincia 		=  $scope.data.lavorazione === '1' && ($scope.data.servizio && $scope.data.servizio.offerta !== 'ALTRO' && $scope.data.servizio.idOfferta !== '46'); //fix FWA
			$scope.viewComune 			=  $scope.data.lavorazione === '1' && $scope.data.servizio && $scope.data.provincia && $scope.data.servizio.offerta !== 'ALTRO' && $scope.data.servizio.idOfferta !== '46'; //fix FWA
			$scope.viewCodiceOrdineOlo 	=  $scope.lavorazioniCodiceOrdineOLO.indexOf($scope.data.lavorazione) >= 0;
			$scope.viewCodiceOrdineTI1 	=  $scope.lavorazioniCodiceOrdineTI.indexOf($scope.data.lavorazione) >= 0;
			$scope.viewCodiceOrdineTI2 	=  $scope.lavorazioniCodiceOrdineTI2.indexOf($scope.data.lavorazione) >= 0;
			$scope.viewRientro          =  ($scope.data.lavorazione === '2' && ($scope.data.servizio && [$rootScope.MAP_OFFERTE.ULL_LANP.id,$rootScope.MAP_OFFERTE.ULLD_LANP.id, $rootScope.MAP_OFFERTE.SLU_LANP.id,
			                        										                          $rootScope.MAP_OFFERTE.WLR_LA.id,$rootScope.MAP_OFFERTE.VULL_LA.id,$rootScope.MAP_OFFERTE.VULL_LNA.id].indexOf($scope.data.servizio.idOfferta) >= 0))

			if ($scope.data.servizio && ($scope.data.servizio.offerta === 'ALTRO' || $scope.data.servizio.idOfferta === '46')) { //fix FWA
				$scope.viewIdRisorsa = $scope.viewDN = $scope.viewDNAggiuntivi = $scope.viewIdRisorsa2 = $scope.viewProvincia = $scope.viewComune = $scope.viewCodiceOrdineOlo = $scope.viewCodiceOrdineTI1 = $scope.viewCodiceOrdineTI2 = $scope.CampoObbligatorio = $scope.CampoObbligatorio2 = false;
			}
			$scope.toggleInviaButton();
		};

		/* Carica la lista delle province. */
		$scope.loadProvince = function() {
			$scope.provinceLoaded = false;
			function successCallback(response) {
				$scope.provinceLoaded = true;
				if (response.result.code < 0) {
					$rootScope.alertGenericError();
				} else {
					$scope.province = response.data;
				}
			}

			function errorCallback(error) {
				$log.debug(error);
				$scope.provinceLoaded = true;
				$rootScope.alertGenericError();
			}

			Addresses.get({type:"cities"}).$promise.then(successCallback,
					errorCallback);
		};

		/* Carica tutti i comuni della provincia passata in input. */
		$scope.loadComuni = function(provincia) {
			$scope.comuni = [];
			$scope.data.comune = null;
			$scope.comuniLoaded = false;

			function successCallback(response) {
				$scope.comuniLoaded = true;
				if (response.result.code < 0) {
					$rootScope.alertGenericError();
				} else {
					$scope.comuni = response.data;
				}
			}

			function errorCallback(error) {
				$log.debug(error);
				$scope.comuniLoaded = true;
				$rootScope.alertGenericError();
			}

			Addresses.get({
				type:"cities",
				provincia : provincia
			}).$promise
					.then(successCallback, errorCallback);
		};

		$scope.aggiuntivi = [ {} ];

		$scope.popolaAggiuntivi = function() {
			$scope.aggiuntivi.push({});
		};

		$scope.rimuoviAggiuntivi = function(selectedIndex) {
			if ($scope.aggiuntivi.length > 1) {
				$scope.aggiuntivi.splice(selectedIndex, 1);
			} else {
				$scope.aggiuntivi = [ {} ];
			}
		};

		$scope.loadProvince();

	} ]);
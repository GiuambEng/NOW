timnow
		.controller(
				'dettaglioOrdine',
				[
						'$scope',
						'$timeout',
						'$state',
						'$rootScope',
						'$log',
						'Orders',
						'OrdersReferents',
						'Request',
						'DTU',
						'DTUDetails',
						'JPUBS',
						'DBCFX',
						'alertService',
						'$uibModal',
						'Notifications',
						'TailPosition',
						'TracciamentoStato',
						'CRM_ORD_PROFILE',
						'CRM_ORD_SUB_PROFILE',
						'CRM_RO_PROFILE',
						'modalService',
						'ordersAction',
						'nuovaRichiestaOrdine',
						'OrderstimeOut',
						'NEW_REQUEST_DONT_SHOW',
						'CodiceRichiesta',
						'RecuperaNotificheRichiesta',
						'Detokenizzazione',
						'DetokenizzazioneXML',
						'TrackingGUI',
						'TRACKING_GUI',
						'_',
						'OpenFiberExternalData',
						'LavorazioneManualeFiberstream',
						'OscuramentoFEA32918',
						'PARENTAL_CONTROL_MAP',
						function($scope, $timeout, $state, $rootScope, $log,
								Orders, OrdersReferents, Request,
								DTU, DTUDetails, JPUBS, DBCFX, alertService,
								$uibModal, Notifications, TailPosition,
								TracciamentoStato,
								CRM_ORD_PROFILE, CRM_ORD_SUB_PROFILE,
								CRM_RO_PROFILE, modalService, ordersAction,
								nuovaRichiestaOrdine, OrderstimeOut,
								NEW_REQUEST_DONT_SHOW, CodiceRichiesta,
								RecuperaNotificheRichiesta,
								Detokenizzazione, DetokenizzazioneXML,
												TrackingGUI, TRACKING_GUI, _, OpenFiberExternalData, 
												LavorazioneManualeFiberstream, OscuramentoFEA32918, PARENTAL_CONTROL_MAP) {

							$rootScope.pageClass = 'dettaglio-ordine';
							$scope.user = $rootScope.timnowConfigData.user;
							$scope.tailPositionEnabled = false;
							$scope.loadEsiti = true;
							$scope.loadDettagli = true;
							$scope.visibilitaProfiliNonOlo = false;
							// SM_8900
							$scope.visibilitaProfiliNonOPCC = false;
							$scope.visibilitaProfiliDG = false;
							$scope.loadJPUBS = false;
							$scope.loadDTU = false;
							//RU_1492
							$scope.loadEventiOpenFiber = false;
							// $scope.loadDBCFX=false; TODO
							$scope.attesaRispostaPreventivo = "";
							$scope.showNewRequestButton = true;
							$scope.disableNewRequestButton = false;
							$scope.codice_richiesta = '';

							var ut_profile = $rootScope.timnowConfigData.user.codiceProfilo;
							$scope.externalDataAbilitazione = false;

							$scope.getDettaglioDTU = function(
									idEventoOrdnineNowWhls,
									progressivoEventoDtu) {
								DTUDetails
										.get({
											idEventoNow : idEventoOrdnineNowWhls,
											progressivoEventoDtu : progressivoEventoDtu,
											idrichiestaolo : $scope.orders.idrichiestaolo
										}).$promise.then(function(data) {
									$scope.dtuDet = data;
								}, function(error) {
									$log.debug(error);
								});
							};

							$scope.orderNumber = $state.params.orderNumber;
							$scope.reqType = $state.params.reqType;
							// solo singola lista
							$scope.files = [];
							$scope.request = [];
							$scope.filesLoaded = true;
							$scope.headerList = [];
							$scope.headerList.push({
								"key" : "tipoNotifica",
								"value" : "Tipo Notifica",
								"type" : "text"
							});
							$scope.headerList.push({
								"key" : "nomeFile",
								"value" : "Nome File",
								"type" : "text"
							});
							$scope.headerList.push({
								"key" : "dimensioneFile",
								"value" : "Dimensione (Byte)",
								"type" : "text"
							});
							$scope.headerList.push({
								"key" : "codOloAgcom",
								"value" : "Codifica OAO",
								"type" : "text"
							});
							$scope.headerList.push({
								"key" : "timestampInvio",
								"value" : "Data Invio",
								"type" : "data",
								"pattern" : "dd/MM/yyyy HH:mm:ss"
							});
							$scope.headerList.push({
								"key" : "esitoInvio",
								"value" : "Esito Invio",
								"type" : "text"
							});
							$scope.headerList.push({
								"key" : "idFileProcessatoOutput",
								"value" : "",
								"type" : "file"
							});
							$scope.tipologia = "File e Notifiche";
							$scope.tipologiaReferenti = "Referenti Contattati";

							$scope.detailList = [];
							$scope.detailList.push({
								"key" : "quantitaRecordTotali",
								"value" : "Record Tot",
								"type" : "text"
							});
							$scope.detailList.push({
								"key" : "timestampCreazioneFile",
								"value" : "Data Creazione",
								"type" : "text"
							});

							$scope.headerListReferenti = [];
							$scope.headerListReferenti.push({
								"key" : "dataContatto",
								"value" : "Data Chiamata",
								"type" : "data",
								"pattern" : "dd/MM/yyyy"
							});
							$scope.headerListReferenti.push({
								"key" : "dataVisita",
								"value" : "Data Visita",
								"type" : "text"
							});
							$scope.headerListReferenti.push({
								"key" : "esito",
								"value" : "Esito",
								"type" : "text"
							});
							$scope.headerListReferenti.push({
								"key" : "nominativo",
								"value" : "Nominativo",
								"type" : "text"
							});
							$scope.headerListReferenti.push({
								"key" : "oraVisitaContatto",
								"value" : "Ora Visita",
								"type" : "text"
							});
							$scope.headerListReferenti.push({
								"key" : "progressivoReferente",
								"value" : "Progressivo",
								"type" : "text"
							});
							//SM_10597
							$scope.headerListReferenti.push({
								"key" : "qualifica",
								"value" : "Qualifica",
								"type" : "text"
							});
							

							$scope.detailListReferenti = [];
							$scope.detailListReferenti.push({
								"key" : "nota",
								"value" : "Ulteriore Contatto",
								"type" : "text"
							});
							$scope.detailListReferenti.push({
								"key" : "oraContatto",
								"value" : "Ora Chiamata",
								"type" : "text"
							});
							$scope.detailListReferenti.push({
								"key" : "progressivoEventoDtu",
								"value" : "Progressivo DTU",
								"type" : "text"
							});
							$scope.detailListReferenti.push({
								"key" : "riferimentoFisso",
								"value" : "Fisso",
								"type" : "text"
							});
							$scope.detailListReferenti.push({
								"key" : "riferimentoMobile",
								"value" : "Mobile",
								"type" : "text"
							});
							$scope.detailListReferenti.push({
								"key" : "dataInserimento",
								"value" : "Data Inserimento",
								"type" : "text"
							});							

							// invoke Random ordineOlo for SM_6466
							// -------------------------------
							$scope.callCodiceRichiesta = function() {
								CodiceRichiesta.get().$promise
										.then(
												function(data) {
													$scope.codice_richiesta = data.codiceUnivoco;
												},
												function(error) {
													$log.info(error);
													$log
															.info("Non e' stato possibile recuperare il codice richiesta");
													modalService
															.showModal(
																	{},
																	{
																		headerText : "Recupero Codice Richiesta",
																		bodyText : "Non e' stato possibile recuperare il codice richiesta. Riprovare piu' tardi.",
																		actionButtonText : 'Chiudi',
																		type : 'success'
																	});
												});
							}

							// -----------------------------------------------------

							// RU_716
							$scope.isNewRequestAllowedByOffer = function() {
								
								//SM_10922
								let _offerteNonValide = [$rootScope.MAP_OFFERTE.FWA.id, $rootScope.MAP_OFFERTE.NPNG.id];
								
								return (!!$scope.orders
										&& !!$scope.orders.idOfferta && (_offerteNonValide.indexOf($scope.orders.idOfferta) == -1)) ? true
										: false;
							}

							$scope.showXML = function(file) {
	
									var _request = {
										codOloAgcom : $scope.orders.codificaOao,
										codOrdineOlo : $scope.orders.ordineOlo,
										tracciatoXml : file.xml,
										idOfferta: $scope.orders.idOfferta,
										lavorazione: file.lavorazioneRichiesta,
										codOrdineTi: $scope.orders.ordineTi,
										flagDetok: 'N',
										//SM_10587
										idRichiestaOlo: ($scope.orders.idrichiestaolo || null)
									};
									
									//SM_10516
									if($scope.R1F_20_0236 && $scope.R1F_20_0236C){
										_request.flagTokFittizia = 'Y';
										_request.pattern = ($scope._patternDetokenizzazioneFittizia || '****');
									}

									DetokenizzazioneXML.save({}, _request).$promise
											.then(
													function(response) {
														if (response.result.code == 'OK') {
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "File XML",
																				templateUrl : 'app/common/templates.html',
																				filexml : true,
																				bodyText : response.tracciatoDetokenizzato
																			});
														} else {
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "File XML",
																				templateUrl : 'app/common/templates.html',
																				filexml : true,
																				bodyText : file.xml
																			});
														}
													},
													function(error) {
														modalService
																.showModal(
																		{},
																		{
																			headerText : "Avviso",
																			templateUrl : 'app/common/templates.html',
																			bodyText : "Errore su detokenizzazione Richiesta XML"
																		});
													});
							};
							
							
							$scope.timeOut = function() {
								$scope.timeOutSpin = true;

								OrderstimeOut.get({
									orderNumber : $scope.orders.idrichiestaolo
								}).$promise
										.then(
												function(response) {
													$scope.timeOutSpin = false;
													modalService
															.showModal(
																	{},
																	{
																		headerText : "Richiesta data di TIMEOUT",
																		bodyText : response.esito,
																		actionButtonText : 'Chiudi',
																		type : 'success'
																	});
												},
												function(error) {
													$scope.timeOutSpin = false;
													modalService
															.showModal(
																	{},
																	{
																		headerText : "Richiesta data di TIMEOUT",
																		bodyText : "Non e' stato possibile richiedere il preventivo. Riprovare piu' tardi.",
																		actionButtonText : 'Chiudi',
																		type : 'success'
																	});
												});
							};
							$scope.nuovoPreventivo = function() {
								$scope.nuovoPreventivoLoading = true;								
								if ($scope.orders.idOfferta === '16'
										|| $scope.orders.idOfferta === '18'
										|| $scope.orders.idOfferta === '44'
										|| $scope.orders.idOfferta === '45') {
									var bodyData = {
										"causale_richiesta" : "RICHIESTAPREVENTIVO",
										"codice_ordine_ti" : $scope.orders.ordineTi,
										"codice_richiesta" : $scope.codice_richiesta ? $scope.codice_richiesta
												: $scope.orders.ordineOlo,
										"oao" : $scope.orders.codificaOao
									};
									nuovaRichiestaOrdine.save({
										orderNumber : $scope.orders.ordineTi
									}, bodyData).$promise
											.then(
													function(response) {
														if (response.result
																&& response.result.code === 'OK') { // RU_844
															ordersAction
																	.get({
																		type : "preventivo",
																		idRichiestaOlo : $scope.orders.idrichiestaolo
																	}).$promise
																	.then(
																			function(
																					response) {
																				$scope.preventivi = response.data;
																				$scope.attesaRispostaPreventivo = $scope.orders.idrichiestaolo;
																			},
																			function(
																					error) {
																				$log
																						.debug(error);
																				$scope.attesaRispostaPreventivo = "";
																			});
															var modalMessageText = "La richiesta è stata accettata.";
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "Nuova Richiesta",
																				closeButtonText : '',
																				bodyText : modalMessageText,
																				actionButtonText : 'Chiudi',
																				scope : $scope,
																				type : 'success'
																			});
															$log
																	.debug('Preventivo accettato '
																			+ accettazione);
														} else if (response.result
																&& response.result.code === 'KO') { // RU_844
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "Nuova Richiesta",
																				closeButtonText : '',
																				bodyText : response.result.details,
																				actionButtonText : 'Chiudi',
																				scope : $scope,
																				type : 'error'
																			});
														}
													},
													function(error) {
														$scope.attesaRispostaPreventivo = "";
														alertService
																.add(
																		"Non e' stato possibile aggiornare il preventivo",
																		"danger",
																		8000);
														$log.debug(error);
													});
								} else {
									ordersAction
											.get({
												type : "richiestapreventivo",
												idRichiestaOlo : $scope.orders.idrichiestaolo
											}).$promise
											.then(
													function(response) {
														if (response.esito
																&& response.esito.codice === 'OK') {
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "Richiesta di Preventivo",
																				bodyText : "Richiesta di Preventivo inviata correttamente.",
																				actionButtonText : 'Chiudi',
																				type : 'success'
																			});
														} else {
															$scope.nuovoPreventivoLoading = false;
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "Errore",
																				bodyText : "Non e' stato possibile richiedere il preventivo. Riprovare piu' tardi.",
																				actionButtonText : 'Chiudi',
																				type : 'warning'
																			});
														}
													},
													function(error) {
														$scope.nuovoPreventivoLoading = false;
														$log.debug(error);
														modalService
																.showModal(
																		{},
																		{
																			headerText : "Errore",
																			bodyText : "Non e' stato possibile richiedere il preventivo. Riprovare piu' tardi.",
																			actionButtonText : 'Chiudi',
																			type : 'warning'
																		});
													});
								}

							};

							$scope.confermaPreventivo = function(item,
									accettazione) {

								var bodyData = {
									"causale_richiesta" : "ACCETTAZIONEOPERESPECIALI",
									"codice_ordine_ti" : $scope.orders.ordineTi,
									"codice_richiesta" : $scope.codice_richiesta ? $scope.codice_richiesta
											: $scope.orders.ordineOlo,
									"oao" : $scope.orders.codificaOao,
									"flagAccettazione" : accettazione
								};

								nuovaRichiestaOrdine.save({
									orderNumber : $scope.orders.ordineTi
								}, bodyData).$promise
										.then(
												function(response) {
													if (response.result
															&& response.result.code === 'OK') { // RU_844
														ordersAction
																.get({
																	type : "preventivo",
																	idRichiestaOlo : $scope.orders.idrichiestaolo
																}).$promise
																.then(
																		function(
																				response) {
																			$scope.preventivi = response.data;
																			$scope.attesaRispostaPreventivo = $scope.orders.idrichiestaolo;
																		},
																		function(
																				error) {
																			$log
																					.debug(error);
																			$scope.attesaRispostaPreventivo = "";
																		});
														var modalMessageText = "La richiesta è stata accettata.";
														modalService
																.showModal(
																		{},
																		{
																			headerText : "Nuova Richiesta",
																			closeButtonText : '',
																			bodyText : modalMessageText,
																			actionButtonText : 'Chiudi',
																			scope : $scope,
																			type : 'success'
																		});
														$log
																.debug('Preventivo accettato '
																		+ accettazione);
													} else if (response.result
															&& response.result.code === 'KO') { // RU_844
														modalService
																.showModal(
																		{},
																		{
																			headerText : "Nuova Richiesta",
																			closeButtonText : '',
																			bodyText : response.result.details,
																			actionButtonText : 'Chiudi',
																			scope : $scope,
																			type : 'error'
																		});
													}
												},
												function(error) {
													$scope.attesaRispostaPreventivo = "";
													alertService
															.add(
																	"Non e' stato possibile aggiornare il preventivo",
																	"danger",
																	8000);
													$log.debug(error);
												});

							};
							// tracciamento e stato
							$scope.getTracciamentoStato = function(item) {
								
								////////
            					var _state = "";
            					if($state.includes('**.listareport.**')){
									_state = "root.ordini.listareport.dettaglio.ordine.tracciamento"
								}else{
									_state = "root.ordini.lista.dettaglio.tracciamento"
								}

								$state.go(_state,
												{
													reqType : $scope.reqType,
													orderNumber : $scope.orderNumber,
													parametriRicerca : $scope.paramToSearch,
													codiceOrdineOlo : $scope.codiceOrdineOlo,
													idRichiestaOlo : $scope.orders.idrichiestaolo,
													fineTracciamento : item.fineTracciamento,
													inizioTracciamento : item.inizioTracciamento
												});
							};

							// SM_7932
							// DBCFX
							$scope.showDBCFX = function() {
								return $scope.orders
										&& ((($scope.orders.richiesta && $scope.orders.richiesta.tipoLavorazione == "MIGRAZIONE") || ($scope.orders.lavorazioneRichiesta == "MIGRAZIONE")) || (($scope.orders.richiesta && $scope.orders.richiesta.tipoLavorazione == "ATTIVAZIONE") || ($scope.orders.lavorazioneRichiesta == "ATTIVAZIONE"))) ? true
										: false;
							};

							$scope.decodificaProfiloParentalControl = function(servizi) {
								if(!servizi){
									return;
								}

								servizi.forEach(function(servizio) {
									if(!servizio.customizations){
										return;
									}

									servizio.customizations.forEach(function(customization) {
										if(customization.attribute == 'PROFILO' &&
											Object.prototype.hasOwnProperty.call(PARENTAL_CONTROL_MAP, customization.value)){
											customization.value = PARENTAL_CONTROL_MAP[customization.value];
										}
									});
								});
							};

							$scope.init = function() {
								Orders.get({
									type : $scope.reqType,
									orderNumber : $scope.orderNumber
								}).$promise
										.then(
												function(data) {
													$scope.orders = data;
													$scope.disableNewRequestButton = false;
														$scope.orders.servizi = OscuramentoFEA32918.filtraServizi(
																$scope.orders.servizi, data.idOfferta, 'customizations'
															);
											$scope.orders.servizi = OscuramentoFEA32918.filtraServiziRU1614(
																		$scope.orders.servizi, 'customizations'
																	);
											$scope.decodificaProfiloParentalControl($scope.orders.servizi);

													// RU_956
													$scope.oscuramento_RU_956();

													// RU_1202
													if ($scope.orders.idOfferta == $rootScope.MAP_OFFERTE.FEEDER.id) {
														$scope
																.deleteNomeBouquetDaServizi();
														// RU_1213
														$scope
																.renameIpSessioneInServizi();
													}
													//RU_1492
													$scope.isOpenFiberOrder = ($scope.orders.idOfferta == $rootScope.MAP_OFFERTE.FIBERSTREAM.id);													
													
													// RU_1084
													// SM_9611
													$scope.oscuramento_RU_1084();
													$scope.oscuramento_R1F_20_0236();
													$scope.oscuramento_R1F_20_0236C();
																										
													// CR01-CR04
													$scope.setShowRichiestaXml();
													
													$scope.recuperaRichiestaXmlDettaglio();
													
													$scope.checkIfOfferEasy = function() {
														// RU_1164
														var _offerteEasy = [
																$rootScope.MAP_OFFERTE.EASY_CAB.id,
																$rootScope.MAP_OFFERTE.EASY_H.id,
																$rootScope.MAP_OFFERTE.SEMI_EASYIP_H.id ];
														return (_offerteEasy
																.indexOf($scope.orders.idOfferta) > -1);
													}

													if (!$scope.orders.orderDetails
															&& ((!$scope.orders.orderCodeTi || $scope.orders.orderCodeTi.length === 0) && !$scope.orders.richiesta)
															&& (($scope.orders.statoNow !== "SCARTATO") && ($scope.orders.statoNow !== "PERVENUTO"))) {
														$scope.loadEsiti = false;
														$scope.filesLoaded = true;
														$scope.loadDTU = true;
														$scope.loadJPUBS = true;
														//RU_1492
														$scope.loadEventiOpenFiber = true;
														$scope.tracciamentoStatoLoaded = true;
														alertService
																.add(
																		"Non e' stato possibile caricare il dettaglio dell'ordine",
																		"danger",
																		8000);
														$state.go('^');
													} else {
														$scope.ordersDetail = $scope.orders.orderDetails;
														$scope.clienteFinale = $scope.orders.cliente;
														// $log.info($scope.orders);
														//$scope.loadDettagli = false;

														// SM_10450
														if ($scope.RU_1084) {
															$scope._regexPattern = "^kk";
														}
														if ($scope.R1F_20_0236) {
															$scope._regexPattern = "^(dk|kk)";															
														}

														// R1F_20_0236.C
														if ($scope.RU_1084 || $scope.R1F_20_0236) {
															//SM_10585
															$scope.verificaTipologiaTokenizzazione();
															$scope.setShowButtonDetokenizzazione();
															
															if (data.referenti && data.referenti.length > 0) {
																
																if ($scope.R1F_20_0236C && !$scope.isOpenFiberOrder){
																	
																	$scope.referents = data.referenti
																	.map(function(refer) {
																		if (refer.qualifica == 'CF') {
																			var _regexC2Plus = new RegExp("^kk");
																			var _regexD420 = new RegExp("^dk");

																			if (_regexC2Plus.test(refer.telefonoFisso) || _regexC2Plus.test(refer.cellulare)) {
																				refer.detokenizzazioneFittizia = true;
																				refer.patternDetokenizzazioneFittizia = $scope._patternDetokenizzazioneFittizia;
																			}
																			//SM_10618
																			//SM_10621
																			else if(!_regexD420.test(refer.nome)){
																				refer.detokenizzazioneFittiziaFull = true;
																				refer.detokenizzazioneFittizia = true;
																				refer.patternDetokenizzazioneFittizia = $scope._patternDetokenizzazioneFittizia
																			}
																		}
																		return refer;
																	});	
																}else{
																	$scope.referents = data.referenti;
																}																
															}
															
															if(!$scope.isOpenFiberOrder){
																$scope.setReferentiTokenizzati();
																$scope.setClienteFinaleTokenizzato();
																
																if ($scope.orders.orderCodeTi && $scope.orders.orderCodeTi.length > 0){
																	$scope.setReferentiTokenizzatiOrdineTi();
																	$scope.setClienteFinaleTokenizzatoOrdineTi();
																}
															}
														}

														// SM_9063
														$scope.orders.orderCodeTi = $scope
																.transcodeOfferDetailsCPS(
																		$scope.orders.orderCodeTi,
																		"nome",
																		"OPZIONETRAFFICO",
																		"richiestadettagliovalore");

														if ($state.params.codiceOrdineOlo !== "") {
															$scope.codiceOrdineOlo = $state.params.codiceOrdineOlo;
														} else {
															$scope.codiceOrdineOlo = $scope.orders.ordineOlo
																	|| $scope.orders.ordineTi
																	|| $scope.orders.idrichiestaolo;
														}

														// per le chiamate che
														// danno errore
														if ($scope.orders.idrichiestaolo) {
															OrdersReferents
																	.get({
																		orderNumber : $scope.orders.idrichiestaolo
																	}).$promise
																	.then(
																			function(
																					data) {
																				$log
																						.debug(
																								'OrdersReferents data: ',
																								data);
																				$scope.contacted_referents = data.data;
																				// SM_9650
																				// R1F-20-0236
																				// R1F-20-0236.C
																				if ($scope.RU_1084
																						|| $scope.R1F_20_0236
																						|| $scope.R1F_20_0236C) {
																					$scope
																							.setReferentiContattatiTokenizzati();
																				}
																			},
																			function() {
																			});

															// SM_9693
															Request
																	.save(
																			{},
																			{
																				idRichiesta : $scope.orders.idrichiestaolo,
																				codOrdineOlo : ($scope.orders.ordineOlo
																						|| $scope.orders.ordineTi
																						|| $scope.orders.idrichiestaolo || null),
																				codOloAgcom : $scope.orders.codificaOao
																			}).$promise
																	.then(
																			function(
																					data) {
																				$log
																						.debug(
																								'Requests data: ',
																								data);
																				$scope.request = data;
																				$scope.loadEsiti = false;
																			},
																			function(
																					error) {
																				$log
																						.info(error);
																				$scope.loadEsiti = false;
																			});

															// RU_888
															RecuperaNotificheRichiesta
																	.get({
																		orderNumber : $scope.orders.idrichiestaolo
																	}).$promise
																	.then(
																			function(
																					data) {
																				$log
																						.debug(
																								'RecuperaNotificheRichiesta data: ',
																								data);
																				$scope.notificheRichiesta = data;
																				$scope.loadNotificheRichiesta = true;
																			},
																			function(
																					error) {
																				$log
																						.info(error);
																				$scope.loadNotificheRichiesta = false;
																			});

															Notifications
																	.get({
																		idRichiestaOlo : $scope.orders.idrichiestaolo
																	}).$promise
																	.then(function(
																			data) {
																		if (data.data)
																			$scope.files = data.data;
																		$scope.filesLoaded = true;
																	});

															TracciamentoStato
																	.get({
																		idRichiestaOlo : $scope.orders.idrichiestaolo
																	}).$promise
																	.then(
																			function(
																					data) {
																				if (data) {
																					$scope.tracciamentoStato = data.data;
																				}
																				$scope.tracciamentoStatoLoaded = true;
																			},
																			function(
																					error) {
																				$log
																						.error(error);
																				$scope.tracciamentoStato = [];
																				$scope.tracciamentoStatoLoaded = true;
																			});

															// EXTERNAL DATA
															// CONTROLLO CON LE
															// CHIAMATE JPUB DTU
															// E
															// DETTAGLIO NELLE
															// CHIAMATE MESSO
															// SOLO PER I
															// PROFILI
															// ABILITATI
															
															//SM_11452
															if ($rootScope.isDGUser() || $rootScope.isPPSUser() || $rootScope.isMKTGUser()) {
																$scope.externalDataAbilitazione = true;
																DTU
																		.get({
																			idRichiesta : $scope.orders.idrichiestaolo
																		}).$promise
																		.then(
																				function(
																						data) {
																					$scope.dtus = data.data;
																					$scope.loadDTU = true;
																				},
																				function(
																						error) {
																					$log
																							.debug(error);
																					$scope.loadDTU = true;
																				});

																JPUBS
																		.get({
																			idRichiesta : $scope.orders.idrichiestaolo
																		}).$promise
																		.then(
																				function(
																						data) {
																					$scope.jpubs = data.data;
																					$scope.loadJPUBS = true;
																				},
																				function(
																						error) {
																					$log
																							.debug(error);
																					$scope.loadJPUBS = true;
																				});

																// DBCFX
																if ($scope
																		.showDBCFX()) {
																	DBCFX
																			.get({
																				idRichiesta : $scope.orders.idrichiestaolo
																			}).$promise
																			.then(
																					function(
																							data) {
																						if (data) {
																							$scope.dbcfxList = data.data;
																						}
																						$scope.loadDBCFX = true;
																					},
																					function(
																							error) {
																						$log
																								.error(error);
																						$scope.loadDBCFX = true;
																					});
																}
																
																//RU_1492
																if($scope.isOpenFiberOrder){
																	OpenFiberExternalData.get({idRichiesta : $scope.orders.idrichiestaolo}).$promise.then(
																		function(data) {
																			$scope.eventiOpenFiber = data.data;
																			$scope.loadEventiOpenFiber = true;
																		},
																		function(error) {
																			$log.debug(error);
																			$scope.loadEventiOpenFiber = true;
																		});
																}

															}
														} else {
															$scope.loadEsiti = false;
															$scope.filesLoaded = true;
															$scope.loadDTU = true;
															$scope.loadJPUBS = true;
															$scope.tracciamentoStatoLoaded = true;
														}

														if ($scope.ordersDetail
																&& $scope.ordersDetail.flagOpereSpeciali) {
															ordersAction
																	.get({
																		type : "preventivo",
																		idRichiestaOlo : $scope.orders.idrichiestaolo
																	}).$promise
																	.then(
																			function(
																					response) {
																				$scope.preventivi = response.data;
																			},
																			function(
																					error) {
																				$log
																						.debug(error);
																			});

															ordersAction
																	.get({
																		type : "consuntivo",
																		idRichiestaOlo : $scope.orders.idrichiestaolo
																	}).$promise
																	.then(
																			function(
																					response) {
																				$scope.consuntivi = response.data;
																			},
																			function(
																					error) {
																				$log
																						.debug(error);
																			});
														}

														// La chiamata al
														// servizio posizione
														// coda viene
														// effettauta solo nel
														// caso
														// lo stato OAO
														// dell'ordine sia
														// uguale ad accodato.
														if ($scope.ordersDetail
																&& $scope.ordersDetail.statoOLO === 'ACCODATO') {
															$scope.tailPositionEnabled = true;

															var parameters = {
																idRisorsa : $scope.ordersDetail.idRisorsa
															};

															TailPosition
																	.get(parameters).$promise
																	.then(
																			function(
																					data) {
																				$scope.tailPosition = data;
																			},
																			function(
																					error) {
																				$log
																						.debug(error);
																				$scope.tailPosition = "Impossibile recuperare la posizione coda.";
																			});
														}
													}

													// per gestire la
													// visualizzazione del
													// pulsante nuova richiesta
													// e disabilitarla per i
													// profili
													// SCARTATO,
													// ESPLETAMENTOTECNICOKO,
													// ESPLETAMENTOTECNICO,
													// ANNULLATO, CHIUSO,
													// INANNULLAMENTOSULDELIVERY,
													// INVIATOAFATTURAZIONE,
													// FATTURAZIONEKO,
													// INATTESAESPLETAMENTOFONIA,
													// INANNULLAMENTOPERRIFIUTOPREVENTIVO,
													// INATTESACONFERMAANNULLAMENTO
													var tmpStatoNow = $scope.orders.statoNow ? $scope.orders.statoNow
															: $scope.orders.richiesta.statoNow;
													if (tmpStatoNow
															&& NEW_REQUEST_DONT_SHOW
																	.hasOwnProperty(tmpStatoNow
																			.replace(
																					/ /g,
																					''))
															|| ($scope.ordersDetail
																	&& $scope.ordersDetail.offerta && $scope.ordersDetail.offerta === 'NP')) {
														$scope.showNewRequestButton = false;
													}

													var sottolavorazione = ($scope.ordersDetail && $scope.ordersDetail.sottolavorazione)
															|| ($scope.orders && $scope.orders.sottolavorazione)
															|| ($scope.orders && $scope.orders.richiesta && $scope.orders.richiesta.sottolavorazione);
													if (sottolavorazione) {
														var sottolavNorm = sottolavorazione.toString().trim().toUpperCase();
														if (sottolavNorm === 'MIGRAZIONEDEL82' || sottolavNorm === 'RIENTRIDEL82') {
															$scope.disableNewRequestButton = true;
														}
													}
													// **********************************************************

													// invoke Random ordineOlo
													// for SM_6466
													// -------------------------------
													$scope.callCodiceRichiesta();
													// -----------------------------------------------------

												},
												function(error) {
													$scope.filesLoaded = true;
													$log.debug(error);
													$scope.loadDettagli = false;
													alertService
															.add(
																	"Non e' stato possibile caricare il dettaglio dell'ordine",
																	"danger",
																	8000);
													$state.go('^');
												});
							};

							// RU_956
							$scope.oscuramento_RU_956 = function() {
								try {
									if ($scope.orders
											&& $scope.orders.idOfferta) {
										if (!$rootScope.OSCURAMENTI.RU_956.oscurato) {
											$scope.RU_956 = ($rootScope.OSCURAMENTI.RU_956.idOfferteNonValide
													.indexOf($scope.orders.idOfferta) > -1);
										} else {
											$scope.RU_956 = false;
										}
									}
								} catch (e) {
									$scope.RU_956 = false;
								}
							}

							// RU_1084
							$scope.oscuramento_RU_1084 = function() {

								try {	
									//SM_10702								
									$scope.RU_1084 = !$rootScope.OSCURAMENTI.RU_1084.oscurato;
								} catch (e) {
									$scope.RU_1084 = false;
								}
							}

							// R1F-20-0236
							$scope.oscuramento_R1F_20_0236 = function() {
								try {									
									if(!$rootScope.OSCURAMENTI.R1F_20_0236.oscurato){
										$scope.R1F_20_0236 = ($rootScope.OSCURAMENTI.R1F_20_0236.idOfferteNonValide.indexOf($scope.orders.idOfferta) == -1);
									}else {
										$scope.R1F_20_0236 = false;
									}									
									
								} catch (e) {
									$scope.R1F_20_0236 = false;
								}
							}

							// R1F-20-0236.C
							$scope.oscuramento_R1F_20_0236C = function() {
								try {
									if ($scope.R1F_20_0236 && !$rootScope.OSCURAMENTI.R1F_20_0236C.oscurato) {
										$scope.R1F_20_0236C = true;
										$scope._patternDetokenizzazioneFittizia = $rootScope.OSCURAMENTI.R1F_20_0236C.pattern;
									} else {
										$scope.R1F_20_0236C = false;
									}
								} catch (e) {
									$scope.R1F_20_0236C = false;
								}
							}
							
							// CR01-CR04
							$scope.setShowRichiestaXml = function() {
								var _offerte = [
										$rootScope.MAP_OFFERTE.VLANNGAMULTICAST.id,
										$rootScope.MAP_OFFERTE.FEEDER.id,
										$rootScope.MAP_OFFERTE.SEDEOLT.id,
										$rootScope.MAP_OFFERTE.CANALE.id ];
								$scope.showRichiestaXml = !(_offerte
										.indexOf($scope.orders.idOfferta) > -1);
							}
							
							$scope.init();
							
							//SM_10516
							$scope.recuperaRichiestaXmlDettaglio = function(){
								
								var _request = {
										codOloAgcom : ($scope.orders.codificaOao || $scope.orders.richiesta.codificaOAO),
										codOrdineOlo : ($scope.orders.ordineOlo || $scope.orders.richiesta.codiceOrdineOLO),
										idOfferta: $scope.orders.idOfferta,
										lavorazione: ($scope.orders.lavorazioneRichiesta || $scope.orders.richiesta.tipoLavorazione),
										codOrdineTi: ($scope.orders.ordineTi || null),
										flagDetok: 'N',
										//SM_10587
										idRichiestaOlo: ($scope.orders.idrichiestaolo || null)
									};
									
									if($scope.R1F_20_0236 && $scope.R1F_20_0236C){
										_request.flagTokFittizia = 'Y';
										_request.pattern = ($scope._patternDetokenizzazioneFittizia || '****');
									}
									
									DetokenizzazioneXML.save({}, _request).$promise
									.then(function(response) {
										
												$scope.loadDettagli = false;
												if (response.result.code == 'OK') {
													$scope.showButtonDetokenizzazioneXml = true;
													if ($scope.orders.richiesta) {
														$scope.orders.richiesta.richiestaXML = response.tracciatoDetokenizzato
													} else if ($scope.ordersDetail) {
														$scope.ordersDetail.richiestaXml = response.tracciatoDetokenizzato;
													}
																										
												} else {
													$scope.showButtonDetokenizzazioneXml = false;
													modalService
															.showModal(
																	{},
																	{
																		headerText : "Detokenizzazione",
																		closeButtonText : '',
																		bodyText : "XML ordine non ancora disponibile",
																		actionButtonText : 'Chiudi',
																		scope : $scope,
																		type : 'error'
																	});
												}
											},
											function(error) {
												$scope.loadDettagli = false;
												$scope.showButtonDetokenizzazioneXml = false;
												modalService
														.showModal(
																{},
																{
																	headerText : "Detokenizzazione",
																	closeButtonText : '',
																	bodyText : "Dati richiesta XML non disponibili, riprovare piu' tardi",
																	actionButtonText : 'Chiudi',
																	scope : $scope,
																	type : 'error'
																});
											});
									
									
							}

							$scope.changeState = function() {
								// Variabile
								// salvataggioFiltriPaginazione.tipologia deve
								// essere aggiunta per
								// Gestire il back con i relativi salvataggi dei
								// filtri light e della paginazione
								// la variabile va settata nel file app.routes
								// Per parametriRicerca invece viene gestita la
								// ricerca avanzata
								// $log.debug($state.current.name);
								if ($state.params.parametriRicerca !== "") {
									$rootScope
											.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
									$state
											.go(
													$rootScope.fromState,
													{
														parametriRicerca : $state.params.parametriRicerca,
														"init" : false
													});
								} else {
									$state.go('^');
								}
							};

							$scope.nuovaRichiesta = function() {
								if ($scope.disableNewRequestButton) {
									return;
								}
								if ($scope.ordersDetail) {
									$scope.orders.tipoLavorazione = $scope.ordersDetail.tipoLavorazione ? $scope.ordersDetail.tipoLavorazione
											: $scope.orders.lavorazioneRichiesta;
								} else {
									$scope.orders.tipoLavorazione = $scope.orders.richiesta.tipoLavorazione;
								}
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
							// ----- MODALE -----

							$scope.animationsEnabled = true;

							$scope.open = function(val, data) {

								// Task #34292
								if ($scope.orders.idOfferta == $rootScope.MAP_OFFERTE.CPS.id) {
									// SM_9063
									$scope.items = $scope
											.transcodeOfferDetailsCPS(data,
													"attribute",
													"OPZIONETRAFFICO", "value");
								} else if ([
										$rootScope.MAP_OFFERTE.GPON_SEMI.id,
										$rootScope.MAP_OFFERTE.GPON_FULL.id ]
										.indexOf($scope.orders.idOfferta) > -1) {
									$scope.items = $scope
											.transcodeOfferDetailsGPON(data);
								} else {
									$scope.items = data;
								}

								$scope.title = val;
								var modalInstance = $uibModal
										.open({
											animation : $scope.animationsEnabled,
											templateUrl : 'app/ordini/dettaglio/dettaglioTplService.html',
											controller : 'ModalInstanceCtrl',
											resolve : {
												items : function() {
													return $scope.items;
												},
												title : function() {
													return $scope.title;
												}
											}
										});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
										}, function() {
											$log.info('Modal dismissed at: '
													+ new Date());
										});
							};

							$scope.openIndirizziClienteFinale = function(val) {
								$scope.items = val;
								var modalInstance = $uibModal
										.open({
											animation : $scope.animationsEnabled,
											templateUrl : 'app/ordini/dettaglio/dettaglioClienteFinaleTplService.html',
											controller : 'ModalInstanceCtrl',
											resolve : {
												items : function() {
													return $scope.items;
												},
												title : function() {
													return 'Indirizzo Cliente Finale';
												}
											}
										});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
										}, function() {
											$log.info('Modal dismissed at: '
													+ new Date());
										});
							};

							// RU_752
							$scope.openNumeroTelefonicoAggiuntivo = function(
									val) {
								$scope.items = val;
								// $scope.items=["1", "2", "3", "5","6", "7"];
								var modalInstance = $uibModal
										.open({
											animation : $scope.animationsEnabled,
											size : 'customsize',
											templateUrl : 'app/ordini/dettaglio/numeroTelefonicoAggiuntivo.html',
											controller : 'ModalInstanceCtrl',
											resolve : {
												items : function() {
													return $scope.items;
												},
												title : function() {
													return 'Numero telefonico aggiuntivo';
												}
											}
										});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
										}, function() {
											$log.info('Modal dismissed at: '
													+ new Date());
										});
							};

							$scope.toggleAnimation = function() {
								$scope.animationsEnabled = !$scope.animationsEnabled;
							};

							$scope.showButtonRichiestaPreventivo = function() {
								return (!CRM_RO_PROFILE
										.hasOwnProperty(ut_profile));
							}

							// TABELLA DBCFX
							$scope.tipologiaDbcfx = "Esiti DBCFX";
							$scope.headerListDbcfx = [];
							$scope.headerListDbcfx.push({
								"key" : "numeroAggiuntivo",
								"value" : "Numero Aggiuntivo",
								"type" : "text"
							});
							$scope.headerListDbcfx.push({
								"key" : "direzionalita",
								"value" : "Direzionalità",
								"type" : "text"
							});

							// REQUEST NOTIFICATION TABELLA START
							$scope.tipologiaEsiti = "Esiti";
							$scope.headerListRequestNotification = [];
							$scope.headerListRequestNotification.push({
								"key" : "tipologiaNotifica",
								"value" : "Tipologia Notifica",
								"type" : "text"
							});
							$scope.headerListRequestNotification.push({
								"key" : "causale",
								"value" : "Causale",
								"type" : "text"
							});
							$scope.headerListRequestNotification.push({
								"key" : "dataCreazione",
								"value" : "Data Creazione",
								"type" : "data",
								"pattern" : "dd/MM/yyyy HH:mm:ss"
							});
							$scope.headerListRequestNotification.push({
								"key" : "ultimoFileNotifica",
								"value" : "Ultimo File Notifica",
								"type" : "text"
							});
							$scope.headerListRequestNotification.push({
								"key" : "dataInvioFile",
								"value" : "Data Invio File ",
								"type" : "text"
							});

							// SM_9651
							$scope.headerListRequestNotification.push({
								"key" : "notificaXML",
								"value" : "Notifica XML",
								"type" : "popupXML"
							});

							// RU_1103
							if (!($rootScope.isOLOUser() || $rootScope.isOPCCUser()) && $rootScope.isSUPERUser()) {
								$scope.headerListRequestNotification.push({
									"key" : "notificaXML",
									"value" : "Detokenizza",
									"type" : "detokenizzaXML"
								});
							}

							// TRACCIAMENTO STATO
							$scope.headerListTracciamentoStato = [];
							$scope.tracciamentoStatoLoaded = false;

							$scope.headerListTracciamentoStato.push({
								"key" : "timestampTracciamento",
								"value" : "Timestamp Inserimento",
								"type" : "data",
								"pattern" : "dd/MM/yyyy HH:mm:ss"
							});
							
							//SM_11452
							if ($rootScope.isDGUser() || $rootScope.isPPSUser()) {
								$scope.headerListTracciamentoStato.push({
									"key" : "statoNOWDA",
									"value" : "stato NOW DA",
									"type" : "text"
								});
								$scope.headerListTracciamentoStato.push({
									"key" : "statoNOWA",
									"value" : "stato NOW A",
									"type" : "text"
								});
								$scope.visibilitaProfiliDG = true;
							}

							// SM_8952
							if ($rootScope.isAllOLOUser()) {
								$scope.visibilitaProfiliNonOlo = true;
								$scope.headerListTracciamentoStato.push({
									"key" : "statoOLODA",
									"value" : "stato OLO DA",
									"type" : "text"
								});
							}

							// SM_8952
							if ($rootScope.isOPCCUser()) {
								$scope.visibilitaProfiliNonOPCC = true;
							}

							$scope.headerListTracciamentoStato.push({
								"key" : "statoOLOA",
								"value" : "stato OLO A",
								"type" : "text"
							});
							$scope.headerListTracciamentoStato.push({
								"key" : "FlagNotifiche",
								"value" : "Notifiche",
								"type" : "checkbox"
							});

							$scope.tipologiaTracciamentoStato = "Tracciamento e Stato";

							$scope.detailListTracciamentoStato = [];

							// SM_9063
							$scope.transcodeOfferDetailsCPS = function(
									arrayOptions, objectKey, optionName,
									objectValue) {

								var _indexKey = -1;

								if (!arrayOptions) {
									return;
								}

								arrayOptions.forEach(function(option, index) {
									if (option[objectKey] == optionName) {
										_indexKey = index;
										return;
									}
								});

								if (_indexKey > -1) {
									if (optionName === "OPZIONETRAFFICO") {
										switch (arrayOptions[_indexKey][objectValue]) {
										case '0':
											arrayOptions[_indexKey][objectValue] = "Long Distance";
											break;
										case '2':
											arrayOptions[_indexKey][objectValue] = "Tutte";
											break;
										}
									}
								}

								return arrayOptions;
							}

							// Task #34292
							$scope.transcodeOfferDetailsGPON = function(
									arrayOptions) {

								var _indexKeyCoinvestimento = -1;
								var _indexKeyTipologiaAccessoUbb = -1;
								var _optionNameCoinvestimento = "COINVESTIMENTO";
								var _optionNameTipologiaAccessoUbb = "TIPOLOGIAACCESSOUBB";

								if (!arrayOptions) {
									return;
								}

								arrayOptions
										.forEach(function(option, index) {
											if (option['attribute'] == _optionNameCoinvestimento) {
												_indexKeyCoinvestimento = index;
											}
											if (option['attribute'] == _optionNameTipologiaAccessoUbb) {
												_indexKeyTipologiaAccessoUbb = index;
											}
										});

								if (_indexKeyCoinvestimento > -1) {
									switch (arrayOptions[_indexKeyCoinvestimento]['value']) {
									case 'I':
										arrayOptions[_indexKeyCoinvestimento]['value'] = "IRU";
										break;
									case 'M':
										arrayOptions[_indexKeyCoinvestimento]['value'] = "Minimo Garantito";
										break;
									}
								}

								if (_indexKeyTipologiaAccessoUbb > -1) {
									switch (arrayOptions[_indexKeyTipologiaAccessoUbb]['value']) {
									case 'S':
										arrayOptions[_indexKeyTipologiaAccessoUbb]['value'] = "Semi-Gpon";
										break;
									case 'F':
										arrayOptions[_indexKeyTipologiaAccessoUbb]['value'] = "Full-Gpon";
										break;
									}
								}

								return arrayOptions;
							}

							// INIZIO SEZIONE DETOKENIZZAZIONE

							// RU_1084

							// SM_9611
							$scope._referentiTokenizzati = [];
							// SM_9650
							$scope._referentiContattatiTokenizzati = [];

							// R1F-20-0236
							$scope._clienteFinaleTokenizzato = {};
							
							//SM_10585
							$scope.verificaTipologiaTokenizzazione = function(){
								
								var _regexD420 = new RegExp("^dk");
								var _regexC2Plus = new RegExp("^kk");
								//SM_10603
								if($scope._referentiTokenizzati && $scope._referentiTokenizzati.length > 0){
									$scope._ordineTokenizzatoD420 = (_regexD420.test($scope._referentiTokenizzati[0].tokenFisso) || _regexD420.test($scope._referentiTokenizzati[0].tokenMobile));
									$scope._ordineTokenizzatoC2Plus = (_regexC2Plus.test($scope._referentiTokenizzati[0].tokenFisso) || _regexC2Plus.test($scope._referentiTokenizzati[0].tokenMobile));
								}else if($scope.clienteFinale){
									$scope._ordineTokenizzatoD420 = (_regexD420.test($scope.clienteFinale.ragioneSociale) || _regexD420.test($scope.clienteFinale.partitaIva));
									$scope._ordineTokenizzatoC2Plus = !$scope._ordineTokenizzatoD420;
								}
							}

							// Estrazione dei numeri referenti tokenizzati di
							// tipo Cliente Finale
							$scope.setReferentiTokenizzati = function() {

								var _referentiTokenizzati = _.where($scope.referents, {qualifica : 'CF'});

								if (_referentiTokenizzati && _referentiTokenizzati.length > 0) {
									
									// R1F-20-0236
									var _regex = new RegExp($scope._regexPattern);
									$scope.referents.map(function(item, index) {
												if (_regex.test(item.telefonoFisso)	|| _regex.test(item.cellulare) || _regex.test(item.cognome)) {
													item.detokenizza = true;
													// SM_9650
													item.referenteContattato = 'N';

													$scope._referentiTokenizzati
															.push({
																tokenFisso : (item.telefonoFisso || null),
																tokenMobile : (item.cellulare || null),
																// SM_10450
																tokenCF : (_regex.test(item.cognome) ? item.cognome : null),
																id : item.progressivo
															});
												}
											});
								}
							}

							// R1F-20-0236
							$scope.setClienteFinaleTokenizzato = function() {
								var _app = angular.copy($scope.clienteFinale);
								if (_app && !_.isEmpty(_app)) {
									var _regex = new RegExp($scope._regexPattern);									

									if ($scope.R1F_20_0236) {
										if (_regex.test(_app.ragioneSociale)) {
											
											$scope.showButtonDetokenizzazioneClienteFinale = true;
											
											$scope._clienteFinaleTokenizzato = {
												id : "-1",
												// SM_10454
												tokenCF : _app.ragioneSociale
											}
										}
									}

									// R1F-20-0236.C
									if ($scope.R1F_20_0236C) {
										
										if (!_regex.test($scope.clienteFinale.ragioneSociale)) {
											
											$scope.showButtonDetokenizzazioneClienteFinale = true;
											$scope.clienteFinale.tokenizzazioneFittizia = true;
										}
									}
								}
							}

							// SM_9685
							$scope.setReferentiTokenizzatiOrdineTi = function() {

								var _arrayQualifica = [];
				
								if ($scope.orders.orderCodeTi && $scope.orders.orderCodeTi.length > 0) {
									// Filtra l'array per 'QUALIFICAREF' e	valore 'CF' ed estrae i progressivi dei referenti
									var _arrayQualifica = _.pluck(_.where($scope.orders.orderCodeTi, {nome : "QUALIFICAREF", richiestadettagliovalore : "CF", tipologiadatorichiesta: "REFERENTE"}), "progressivo");
									// Se trovo qualche referente
									if (_arrayQualifica	&& _arrayQualifica.length > 0) {

										var _regex = new RegExp($scope._regexPattern);

										 _.map($scope.orders.orderCodeTi, function(item) {
											 if (_arrayQualifica.indexOf(item.progressivo) > -1 && item.tipologiadatorichiesta == "REFERENTE"){
												 if((item.nome == "TELEFONOFISSOREFERENTE" || item.nome == "TELEFONOMOBILEREFERENTE" || item.nome == "NOMEREFERENTE" || item.nome == "COGNOMEREFERENTE") && _regex.test(item.richiestadettagliovalore)) { 
													 item.detokenizzaReferente = true;
												 }
												 
												 if((item.nome == "NOMEREFERENTE" || item.nome == "COGNOMEREFERENTE") && !_regex.test(item.richiestadettagliovalore)){
													 item.tokenizzazioneFittizia = true;
													 item.detokenizzaReferente = true;
												 }
												 item.referenteContattato = 'N';
											 }
											 return item;
										 });								

										// Costruzione array referenti tokenizzati
										_arrayQualifica.forEach(function(item) {

													var _fisso = null;
													var _mobile = null;
													var _cognomeRagioneSociale = null;

													// verifico se c'è un
													// telefono fisso e mobile
													// per il referente corrente
													
													var _appArray = _.where($scope.orders.orderCodeTi, {progressivo: item, tipologiadatorichiesta: 'REFERENTE'});
													
													if(_appArray && _appArray.length > 0){
														var _telFisso = _.get(_.pick(_.findWhere(_appArray, {nome: 'TELEFONOFISSOREFERENTE'}), 'richiestadettagliovalore'), 'richiestadettagliovalore');
														var _telMobile = _.get(_.pick(_.findWhere(_appArray, {nome: 'TELEFONOMOBILEREFERENTE'}), 'richiestadettagliovalore'), 'richiestadettagliovalore');
														var _cognome = _.get(_.pick(_.findWhere(_appArray, {nome: 'COGNOMEREFERENTE'}), 'richiestadettagliovalore'), 'richiestadettagliovalore');														
														
														$scope._referentiTokenizzati
														.push({
															tokenFisso : (_telFisso || null),
															tokenMobile : (_telMobile || null),
															tokenCF : (_regex.test(_cognome) ? _cognome : null),
															id : item
														});
													}
											});
										}
									}
								}
							
							$scope.setClienteFinaleTokenizzatoOrdineTi = function(){
								var _arrayDatiClienteFinale = _.where($scope.orders.orderCodeTi, {tipologiadatorichiesta : 'DATI CLIENTE'});
								
								if(_arrayDatiClienteFinale && _arrayDatiClienteFinale.length > 0){
									var _regex = new RegExp($scope._regexPattern);			
									
									var _ragioneSociale = _.get(_.pick(_.findWhere(_arrayDatiClienteFinale, {nome: 'COGNOMERAGSOC'}), 'richiestadettagliovalore'), 'richiestadettagliovalore');

									if ($scope.R1F_20_0236) {
										if (_regex.test(_ragioneSociale)) {
											
											_.map($scope.orders.orderCodeTi, function(item){
												if(item.tipologiadatorichiesta == 'DATI CLIENTE'){
													item.detokenizzaClienteFinale = true;
												}
												return item;
											});
											
											$scope._clienteFinaleTokenizzato = {
												id : "-1",
												// SM_10454
												tokenCF : _ragioneSociale
											}
										}
									}
									
									// R1F-20-0236.C
									if ($scope.R1F_20_0236C) {
										
										if (!_regex.test(_ragioneSociale)) {
											_.map($scope.orders.orderCodeTi, function(item) {
													if (item.tipologiadatorichiesta == 'DATI CLIENTE') {
														item.detokenizzaClienteFinale = true;
														item.tokenizzazioneFittizia = true;
														return item;
													}
											});	
										}
									}
								}
							}

							// Estrazione dei numeri Referenti Contattati dal
							// tab 'Notifiche e Richieste'
							$scope.setReferentiContattatiTokenizzati = function() {

								if ($scope.contacted_referents && $scope.contacted_referents.length > 0) {
																		
									// R1F-20-0236
									var _regex = new RegExp($scope._regexPattern);
									
									// SM_9650
									//Task #36766
									if ($scope._showButtonDetokenizzazione) {
										$scope.detailListReferenti.push({
											"key" : "detokenizza",
											"value" : "",
											"type" : "detokenizza"
										});
									}
									
									// R1F-20-0236.C
									if ($scope.R1F_20_0236C && !$scope.isOpenFiberOrder) {
										
										//SM_10655
										var _regexC2Plus = new RegExp("^kk");
										var _regexD420 = new RegExp("^dk");
										$scope.contacted_referents.forEach(function(item, index) {
											//SM_10597
											if(item.qualifica == 'CF'){
												if($scope._ordineTokenizzatoC2Plus){
													item.detokenizza = true;
													item.nominativoFittizio = '';
													item.nominativoFittizio = angular.copy(item.nominativo);
													item.nominativo = $scope._patternDetokenizzazioneFittizia;
													if(!_regexC2Plus.test(item.riferimentoFisso) || !_regexC2Plus.test(item.riferimentoMobile)){
														item.riferimentoFissoFittizio = angular.copy(item.riferimentoFisso);
														item.riferimentoMobileFittizio = angular.copy(item.riferimentoMobile);
														item.riferimentoFisso = $scope._patternDetokenizzazioneFittizia;
														item.riferimentoMobile = $scope._patternDetokenizzazioneFittizia;
													}												
												}
												if($scope._ordineTokenizzatoD420){
													if (_regexD420.test(item.riferimentoFisso) || _regexD420.test(item.riferimentoMobile) || _regexD420.test(item.nominativo)) {
														item.detokenizza = true;
														item.referenteContattato = 'Y';
													}
												}
											}
										});
									}else{
										$scope.contacted_referents.forEach(function(item, index) {
											//SM_10597
											if(item.qualifica == 'CF'){
												if (_regex.test(item.riferimentoFisso) || _regex.test(item.riferimentoMobile) || _regex.test(item.nominativo)) {
													item.detokenizza = true;
													// SM_9650
													item.referenteContattato = 'Y';
													$scope._referentiContattatiTokenizzati.push({
														tokenFisso : (item.riferimentoFisso || null),
														tokenMobile : (item.riferimentoMobile || null),
														// SM_10453
														tokenCF : (_regex.source == "^dk" ? item.nominativo: null),
														id : index
													});
												}
											}
										});
									}
								}
							}

							$scope.eliminaReferentiDetokenizzati = function(
									referenti) {

								if (referenti && referenti.length > 0) {
									referenti
											.forEach(function(item, index) {
												var _search = $scope._referentiTokenizzati
														.findIndex(function(x) {
															return (x.id === item.id);
														});
												if (_search > -1) {
													$scope._referentiTokenizzati
															.splice(_search, 1);
												}
											})
								}
							}

							$scope.eliminaReferentiContattatiDetokenizzati = function(
									referenti) {

								if (referenti && referenti.length > 0) {
									referenti
											.forEach(function(item, index) {
												var _search = $scope._referentiContattatiTokenizzati
														.findIndex(function(x) {
															return (x.id === item.id);
														});
												if (_search > -1) {
													$scope._referentiContattatiTokenizzati
															.splice(_search, 1);
												}
											})
								}
							}

							$scope.sostituisciReferentiDetokenizzati = function(
									referentiDetokenizzati) {
								if (referentiDetokenizzati) {
									referentiDetokenizzati
											.forEach(function(item, i) {

												var _index = $scope.referents
														.map(
																function(e) {
																	return e.progressivo;
																}).indexOf(
																item.id);
												if (_index > -1) {
													$scope.referents[_index].telefonoFisso = (item.numeroFisso || null);
													$scope.referents[_index].cellulare = (item.numeroMobile || null); // SM_9620

													if (item.cognome) {
														$scope.referents[_index].cognome = item.cognome;
													}
													if (item.nome) {
														$scope.referents[_index].nome = item.nome;
													}

													$scope.referents[_index].detokenizza = false;
												}
											});
								}
							}

							$scope.sostituisciReferentiContattatiDetokenizzati = function(
									referentiDetokenizzati) {
								if (referentiDetokenizzati) {
									referentiDetokenizzati
											.forEach(function(item, i) {
												var _index = parseInt(item.id);
												$scope.contacted_referents[_index].riferimentoFisso = (item.numeroFisso || null);
												$scope.contacted_referents[_index].riferimentoMobile = (item.numeroMobile || null);

												// R1F-20-0236
												if ($scope.R1F_20_0236) {
													$scope.contacted_referents[_index].nominativo = ((item.cognome
															+ ' ' + item.nome) || null);
												}

												delete $scope.contacted_referents[_index].detokenizza;

												$scope
														.eliminaReferentiContattatiDetokenizzati(referentiDetokenizzati);
											});
								}
							}

							$scope.sostituisciClienteFinaleDetokenizzato = function(
									clienteFinaleDetokenizzato) {
								// SM_10454
								if (clienteFinaleDetokenizzato
										&& clienteFinaleDetokenizzato.length > 0) {
									$scope.clienteFinale.nome = clienteFinaleDetokenizzato[0].nome;
									$scope.clienteFinale.ragioneSociale = clienteFinaleDetokenizzato[0].cognome;
									$scope.clienteFinale.codFiscale = clienteFinaleDetokenizzato[0].codFiscale;
									$scope.clienteFinale.partitaIva = clienteFinaleDetokenizzato[0].pIva;

									$scope.showButtonDetokenizzazioneClienteFinale = false;
								}

								// R1F-20-0236.C
								if ($scope.R1F_20_0236C) {
									$scope.clienteFinale.tokenizzazioneFittizia = false;
								}
							}
							
							$scope.sostituisciClienteFinaleOrdineTiDetokenizzato = function(clienteFinaleDetokenizzato) {
								// SM_10454
								if (clienteFinaleDetokenizzato && clienteFinaleDetokenizzato.length > 0) {
									
									_.map($scope.orders.orderCodeTi, function(item){
										if(item.tipologiadatorichiesta == 'DATI CLIENTE'){
											if(item.nome == 'NOME' && clienteFinaleDetokenizzato[0].nome){
												item.richiestadettagliovalore = clienteFinaleDetokenizzato[0].nome; 
											}
											if(item.nome == 'COGNOMERAGSOC' && clienteFinaleDetokenizzato[0].cognome){
												item.richiestadettagliovalore = clienteFinaleDetokenizzato[0].cognome; 
											}
											if(item.nome == 'CF' && clienteFinaleDetokenizzato[0].codFiscale){
												item.richiestadettagliovalore = clienteFinaleDetokenizzato[0].codFiscale; 
											}
											if(item.nome == 'PIVA' && clienteFinaleDetokenizzato[0].pIva){
												item.richiestadettagliovalore = clienteFinaleDetokenizzato[0].pIva; 
											}
											
											delete item['detokenizzaClienteFinale'];
										}
										
										return item;
									});									
								}
							}

							// SM_9685
							$scope.sostituisciReferentiOrdineTiDetokenizzati = function(referentiDetokenizzati) {
								if (referentiDetokenizzati) {
									
									var _arrayProgressivi = _.pluck(referentiDetokenizzati, 'id');
									
									_.map($scope.orders.orderCodeTi,function(item){										
										if(item.tipologiadatorichiesta == 'REFERENTE' && _arrayProgressivi.indexOf(item.progressivo) > -1){											
											var _index = _.findIndex(referentiDetokenizzati, function(val){
												return val.id == item.progressivo;
											});
											
											if(item.nome == 'TELEFONOFISSOREFERENTE'){
												item.richiestadettagliovalore = (referentiDetokenizzati[_index].numeroFisso || null);
											}
											
											if(item.nome == 'TELEFONOMOBILEREFERENTE'){
												item.richiestadettagliovalore = (referentiDetokenizzati[_index].numeroMobile || null);
											}
											
											if(item.nome == 'COGNOMEREFERENTE' && referentiDetokenizzati[_index].cognome){
												item.richiestadettagliovalore = referentiDetokenizzati[_index].cognome;
											}
											
											if(item.nome == 'NOMEREFERENTE' && referentiDetokenizzati[_index].nome){
												item.richiestadettagliovalore = referentiDetokenizzati[_index].nome;
											}
											
											if(item.detokenizzaReferente){
												delete item['detokenizzaReferente'];
											}
										}									
										return item;									
									});
								}
							}

							$scope.detokenizza = function(referenti,
									isReferentiContattati, isReferentiOrdineTi,
									isClienteFinale, isClienteFinaleOrdineTi) {							
								var _request = {
									codOloAgcom : ($scope.orders.codificaOao || $scope.orders.richiesta.codificaOAO),
									codOrdineOlo : ($scope.orders.ordineOlo || $scope.orders.richiesta.codiceOrdineOLO),
									tokenReferenti : []
								}

								if (referenti) {

									if (Array.isArray(referenti)) {
										_request.tokenReferenti = referenti;
									} else {
										_request.tokenReferenti = Array
												.of(referenti);
									}

									if (_request.tokenReferenti
											&& _request.tokenReferenti.length > 0) {

										// SM_10453
										if (isReferentiContattati) {
											_request.referenteContattato = 'Y';
										}

										// R1F-20-0236.C
										var _trackBean = {
											timestampInizio : new Date().toISOString(),
											timestampFine : null,
											numeroDatiEsportati : 0,
											contenutoFile : null,
											nomeFile : null,
											tipoOperazione : TRACKING_GUI.EVENTI.DETOKENIZZAZIONE_REALE.descrizione,
											parametriOperazione : null,
											descrizioneFunzione : 'Ordini|Lista Ordini|Dettaglio Ordine'
										};

										Detokenizzazione.save({}, _request).$promise
												.then(
														function(response) {
															if (response.result.code == 'OK') {
																var _referentiDetokenizzati = response.referentiDetokenizzati.numeriReferenti;
																// SM_9650
																if (isReferentiContattati) {
																	$scope.sostituisciReferentiContattatiDetokenizzati(_referentiDetokenizzati);
																}
																// SM_9685
																else if (isReferentiOrdineTi) {
																	$scope.sostituisciReferentiOrdineTiDetokenizzati(_referentiDetokenizzati);
																} else if (isClienteFinale) {
																	$scope.sostituisciClienteFinaleDetokenizzato(_referentiDetokenizzati);
																} else if(isClienteFinaleOrdineTi){
																	$scope.sostituisciClienteFinaleOrdineTiDetokenizzato(_referentiDetokenizzati);
																}
																else {
																	$scope.sostituisciReferentiDetokenizzati(_referentiDetokenizzati);
																}

															} else {
																modalService
																		.showModal(
																				{},
																				{
																					headerText : "Detokenizzazione",
																					closeButtonText : '',
																					bodyText : "Dati non disponibili, riprovare piu' tardi",
																					actionButtonText : 'Chiudi',
																					scope : $scope,
																					type : 'error'
																				});
															}

															_trackBean.timestampFine = new Date()
																	.toISOString();
															_trackBean.esito = 'Ok';
															TrackingGUI
																	.tracking(_trackBean);
														},
														function(error) {

															_trackBean.timestampFine = new Date()
																	.toISOString();
															_trackBean.esito = 'Ko';
															TrackingGUI
																	.tracking(_trackBean);

															modalService
																	.showModal(
																			{},
																			{
																				headerText : "Detokenizzazione",
																				closeButtonText : '',
																				bodyText : "Dati non disponibili, riprovare piu' tardi",
																				actionButtonText : 'Chiudi',
																				scope : $scope,
																				type : 'error'
																			});
														});
									}
								}
							}

							$scope.detokenizzaReferente = function(referente) {
								
								//SM_10516
								//SM_10618
								if(referente.detokenizzazioneFittizia || referente.detokenizzazioneFittiziaFull){
									$scope.detokenizzazioneFittiziaReferente(referente);
								}
								
								// SM_9611
								if ($scope._referentiTokenizzati
										&& $scope._referentiTokenizzati.length > 0
										&& referente) {
									var _token = $scope._referentiTokenizzati
											.find(function(x) {
												return (x.id === referente.progressivo);
											});

									$scope.detokenizza(_token, false, false, false, false);
								}
							}

							$scope.detokenizzaReferenti = function() {
								
								$scope.detokenizzazioneFittiziaReferenti();
								
								if ($scope._referentiTokenizzati && $scope._referentiTokenizzati.length > 0) {
									
									$scope.detokenizza($scope._referentiTokenizzati, false, false, false, false);
								}
							}

							// SM_9650
							$scope.detokenizzaReferentiContattati = function() {
								
								if ($scope._referentiContattatiTokenizzati && $scope._referentiContattatiTokenizzati.length > 0) {
									$scope.detokenizza($scope._referentiContattatiTokenizzati, true, false, false, false);
								}
							}

							// SM_9685
							$scope.detokenizzaReferenteOrdineTi = function(referente) {
								$scope.detokenizzazioneFittiziaReferenteOrdineTi(referente);
								
								// SM_9611
								if ($scope._referentiTokenizzati && $scope._referentiTokenizzati.length > 0 && referente) {
									var _token = $scope._referentiTokenizzati
											.find(function(x) {
												return (x.id === referente.progressivo);
											});

									$scope.detokenizza(_token, false, true, false, false);
								}
							}
							
							$scope.detokenizzazioneFittiziaReferenteOrdineTi = function(referente){
								//SM_10710
								var _tokenizzazioneFittizia = false;
								
								_.map($scope.orders.orderCodeTi, function(item){
									if(item.tipologiadatorichiesta == 'REFERENTE' && item.progressivo == referente.progressivo){
										if(item.tokenizzazioneFittizia){
											_tokenizzazioneFittizia = true;
											delete item['tokenizzazioneFittizia'];
										}
									}
									return item;
								});	
								
								if(_tokenizzazioneFittizia){
									$scope.detokenizzazioneFittiziaTracking();
								}
							}

							$scope.detokenizzaReferentiOrdineTi = function() {
								
								_.map($scope.orders.orderCodeTi, function(item){
									if(item.tipologiadatorichiesta == 'REFERENTE'){
										if(item.tokenizzazioneFittizia){
											delete item['tokenizzazioneFittizia'];
											$scope.detokenizzazioneFittiziaTracking();
										}
									}
									return item;
								});
								
								if ($scope._referentiTokenizzati && $scope._referentiTokenizzati.length > 0) {
									$scope.detokenizza($scope._referentiTokenizzati, false, true, false, false);
								}
							}

							// R1F-20-0236
							$scope.detokenizzaClienteFinale = function() {

								// R1F-20-0236.C
								if ($scope.clienteFinale.tokenizzazioneFittizia) {
									$scope.clienteFinale.tokenizzazioneFittizia = false;
									$scope.showButtonDetokenizzazioneClienteFinale = false;
									$scope.detokenizzazioneFittiziaTracking();

								} 
								if ($scope._clienteFinaleTokenizzato &&	!_.isEmpty($scope._clienteFinaleTokenizzato)) {
									$scope.detokenizza($scope._clienteFinaleTokenizzato, false, false, true, false);
								}
							}
							
							$scope.detokenizzaClienteFinaleOrdineTi = function() {

								// R1F-20-0236.C
								var _tokenizzazioneFittizia = false;
								var _detokenizzaClienteFinale = false;
								
								_.map($scope.orders.orderCodeTi, function(item){
									if(item.tipologiadatorichiesta == 'DATI CLIENTE'){
										if(item.tokenizzazioneFittizia){
											_tokenizzazioneFittizia = true;
											delete item['tokenizzazioneFittizia'];
										}
										if(item.detokenizzaClienteFinale){
											_detokenizzaClienteFinale = true;
											delete item['detokenizzaClienteFinale'];
										}										
									}
									return item;
								});
								
								if (_tokenizzazioneFittizia) {
									$scope.detokenizzazioneFittiziaTracking();
								} 
								
								if (_detokenizzaClienteFinale) {
									$scope.detokenizza($scope._clienteFinaleTokenizzato, false, false, false, true);
								}
							}

							$scope.detokenizzaReferenteContattato = function(item, index) {
								var _regex = new RegExp($scope._regexPattern);

								// R1F-20-0236.C
								if (item.detokenizza && (item.riferimentoFissoFittizio || item.riferimentoMobileFittizio)) {

									$scope.contacted_referents[index].nominativo = item.nominativoFittizio;
									$scope.contacted_referents[index].riferimentoFisso = item.riferimentoFissoFittizio;
									$scope.contacted_referents[index].riferimentoMobile = item.riferimentoMobileFittizio;

									delete item['detokenizza'];
									delete item['nominativoFittizio'];
									delete item['riferimentoFissoFittizio'];
									delete item['riferimentoMobileFittizio'];

									$scope.detokenizzazioneFittiziaTracking();

								}
								
								var _request = {
									id : index,
									referenteContattato : 'Y'
								};

								if (_regex.test(item.riferimentoFisso)) {
									_request.tokenFisso = item.riferimentoFisso;
								}
								if (_regex.test(item.riferimentoMobile)) {
									_request.tokenMobile = item.riferimentoMobile;
								}

								$scope.detokenizza(_request, true, false, false, false);
								
							}

							// SM_9686
							$scope.detokenizzaXml = function() {

								//SM_10516
								var _request = {
										codOloAgcom : $scope.orders.codificaOao,
										codOrdineOlo : $scope.orders.ordineOlo,
										idOfferta: $scope.orders.idOfferta,
										//SM_10684
										lavorazione: ($scope.orders.lavorazioneRichiesta || $scope.orders.richiesta.tipoLavorazione),
										codOrdineTi: $scope.orders.ordineTi,
										flagDetok: 'Y',
										//SM_10587
										idRichiestaOlo: ($scope.orders.idrichiestaolo || null)
									};
									
									if ($scope.ordersDetail
											&& $scope.ordersDetail.richiestaXml) {
										_request.tracciatoXml = $scope.ordersDetail.richiestaXml;
									}

									if ($scope.orders.richiesta
											&& $scope.orders.richiesta.richiestaXML) {
										_request.tracciatoXml = $scope.orders.richiesta.richiestaXML;
									}

									// SM_10464
									DetokenizzazioneXML.save({}, _request).$promise
											.then(
													function(response) {
														$scope.loadDettagli = false;
														if (response.result.code == 'OK') {
															$scope.showButtonDetokenizzazioneXml = false;
															if ($scope.orders.richiesta) {
																$scope.orders.richiesta.richiestaXML = response.tracciatoDetokenizzato
															} else if ($scope.ordersDetail) {
																$scope.ordersDetail.richiestaXml = response.tracciatoDetokenizzato;
															}
															
															if(response.result.details && response.result.details != ''){
																modalService
																.showModal(
																		{},
																		{
																			headerText : "Detokenizzazione",
																			closeButtonText : '',
																			bodyText : response.result.details,
																			actionButtonText : 'Chiudi',
																			scope : $scope,
																			type : 'error'
																		});
															}
															
														} else {
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "Detokenizzazione",
																				closeButtonText : '',
																				bodyText : "Dati non disponibili, riprovare piu' tardi",
																				actionButtonText : 'Chiudi',
																				scope : $scope,
																				type : 'error'
																			});
														}
													},
													function(error) {
														$scope.loadDettagli = false;
														modalService
																.showModal(
																		{},
																		{
																			headerText : "Detokenizzazione",
																			closeButtonText : '',
																			bodyText : "Dati non disponibili, riprovare piu' tardi",
																			actionButtonText : 'Chiudi',
																			scope : $scope,
																			type : 'error'
																		});
													});
							}

							// SM_9693
							$scope.detokenizzaRichiestaXml = function(richiesta) {

									//SM_10516
									var _request = {
											codOloAgcom : $scope.orders.codificaOao,
											codOrdineOlo : $scope.orders.ordineOlo,
											tracciatoXml : richiesta.xml,
											idOfferta: $scope.orders.idOfferta,
											lavorazione: richiesta.lavorazioneRichiesta,
											codOrdineTi: $scope.orders.ordineTi,
											flagDetok: 'Y',
											//SM_10587
											idRichiestaOlo: ($scope.orders.idrichiestaolo || null)
										};
										

									DetokenizzazioneXML.save({}, _request).$promise
											.then(
													function(response) {
														if (response.result.code == 'OK') {
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "File XML",
																				templateUrl : 'app/common/templates.html',
																				filexml : true,
																				bodyText : response.tracciatoDetokenizzato
																			});
														} else {
															modalService
																	.showModal(
																			{},
																			{
																				headerText : "File XML",
																				templateUrl : 'app/common/templates.html',
																				filexml : true,
																				bodyText : richiesta.xml
																			});
														}
													},
													function(error) {
														modalService
																.showModal(
																		{},
																		{
																			headerText : "Avviso",
																			templateUrl : 'app/common/templates.html',
																			bodyText : "Errore su detokenizzazione Richiesta XML"
																		});
													});

							};

							// SM_9611
							// Detokenizzazione dei numeri referenti per profili
							// interni (non OLO e OPCC)
							/*$scope
									.$watch(
											"_referentiTokenizzati",
											function(newValue, oldValue) {
												if (newValue && newValue.length > 0) {
													if ($scope._ordineTokenizzatoC2Plus) {
														$scope._showButtonDetokenizzazione = false;
														if($scope.referents && $scope.referents.length > 0){
															$scope.detokenizzaClienteFinale();														
															$scope.detokenizzaReferenti();
														}else{
															$scope.detokenizzaClienteFinaleOrdineTi();
															$scope.detokenizzaReferentiOrdineTi();
														}
													}
												} else {
													$scope._showButtonDetokenizzazione = false;
												}
											}, true); // SM_9620

							// SM_9650
							$scope.$watch("_referentiContattatiTokenizzati",
									function(newValue, oldValue) {
										if (newValue && newValue.length > 0) {
											if ($scope._ordineTokenizzatoC2Plus) {
													$scope.detokenizzaReferentiContattati();
												}
											}
										}, true);
						
							
							$scope.$watch("_clienteFinaleTokenizzato",
									function(newValue, oldValue) {
										if (newValue) {
											if ($scope._ordineTokenizzatoC2Plus) {
												$scope.showButtonDetokenizzazioneClienteFinale = false;
												if($scope.referents && $scope.referents.length > 0){
													$scope.detokenizzaClienteFinale();	
												}else{
													$scope.detokenizzaClienteFinaleOrdineTi();
												}																							
											} else {
												$scope.showButtonDetokenizzazioneClienteFinale = true;
											}
										} else {
											$scope.showButtonDetokenizzazioneClienteFinale = false;
										}
									});*/

							// R1F-20-0236.C
							$scope.detokenizzazioneFittiziaTracking = function() {
								var _trackBean = {
									timestampInizio : new Date().toISOString(),
									timestampFine : null,
									numeroDatiEsportati : 0,
									contenutoFile : null,
									nomeFile : null,
									tipoOperazione : TRACKING_GUI.EVENTI.DETOKENIZZAZIONE_FITTIZZIA.descrizione,
									parametriOperazione : null,
									descrizioneFunzione : 'Ordini|Lista Ordini|Dettaglio Ordine'
								};

								// Ritardo fake
								$timeout(function() {
									_trackBean.timestampFine = new Date()
											.toISOString();
									_trackBean.esito = 'Ok';

									TrackingGUI.tracking(_trackBean);
								}, 1000);
							}

							$scope.detokenizzazioneFittiziaReferente = function(referente) {

								$scope.referents = $scope.referents
										.map(function(refer) {
											if (referente.progressivo == refer.progressivo) {
												delete refer['detokenizzazioneFittizia'];
												delete refer['detokenizzazioneFittiziaFull'];
												delete refer['patternDetokenizzazioneFittizia'];
											}
											return refer;
										})

								$scope.detokenizzazioneFittiziaTracking();
							}
							
							$scope.detokenizzazioneFittiziaReferenti = function() {

								$scope.referents = $scope.referents
										.map(function(refer) {
											if (refer.detokenizzazioneFittizia) {
												delete refer['detokenizzazioneFittizia'];
												//SM_10618
												delete refer['detokenizzazioneFittiziaFull'];
												delete refer['patternDetokenizzazioneFittizia'];
											}
											return refer;
										})

								$scope.detokenizzazioneFittiziaTracking();
							}
							
							
							//Task #36766
							//SM_10585
							$scope.setShowButtonDetokenizzazione = function(){				
								//SM_10622
								$scope._showButtonDetokenizzazione = $rootScope.isSUPERUserInterno();
							}														

							// FINE SEZIONE DETOKENIZZAZIONE

							// RU_1202
							// Il campo NomeBouquet presente nella componente
							// CONSISTENZAFEEDER, non deve essere visibile per i
							// profili CRM_OLO*
							$scope.deleteNomeBouquetDaServizi = function() {

								if ($rootScope.isOLOUser()) {
									if ($scope.orders.servizi) {
										$scope.orders.servizi = _
												.map(
														$scope.orders.servizi,
														function(servizio,
																index) {
															var _indice = -1;
															_
																	.each(
																			servizio.customizations,
																			function(
																					customization,
																					indice) {
																				if (customization.attribute == "NOMEBOUQUET") {
																					_indice = indice;
																					return;
																				}
																			});

															if (_indice > -1) {
																servizio.customizations
																		.splice(
																				_indice,
																				1);
															}
															return servizio;
														});
									}
								}
							}

							// RU_1213
							$scope.renameIpSessioneInServizi = function() {
								if ($scope.orders.servizi) {
									$scope.orders.servizi = _
											.map(
													$scope.orders.servizi,
													function(servizio, index) {
														_
																.map(
																		servizio.customizations,
																		function(
																				customization,
																				indice) {
																			if (customization.attribute == "IPSESSIONE") {
																				customization.attribute = "IPSESSIONEEBGP";
																				return;
																			}
																		});
														return servizio;
													});
								}
							}

							// SM_10353
							$scope.setShowOperatoreRete = function() {
								$scope.showOperatoreRete = ($rootScope
										.isDGUser()
										|| $rootScope.isMKTGUser()
										|| $rootScope.isGAUser() || $rootScope
										.isPPSUser());
							}

							$scope.setShowOperatoreRete();
							
							//RU_1492
							/** INIZIO SEZIONE LAVORAZIONE MANUALE **/
							
							$scope.showSimpleXML = function(xml) {
	
								modalService.showModal(
									{},
									{
										headerText : "File XML",
									    templateUrl : 'app/common/templates.html',
										filexml : true,
										bodyText : xml
									});
							}
							
							$scope.$watch('orders', function(newValue, oldValue){
								if(newValue){
									$scope.initLavorazioneManuale();
								}
							});
							
							$scope.initLavorazioneManuale = function(){								
								let _codiceCausaleOao = $scope.orders.codiceCausaleOao;
								
								$scope.showLavorazioneManuale = ($scope.isOpenFiberOrder && ($scope.orders.flagAbilitazioneGuiManualOF && $scope.orders.flagAbilitazioneGuiManualOF.toUpperCase() == "SI"));
								$scope.arrayCausaliConfermaKo = ['B00', 'B01', 'B02', 'B03', 'B04', 'B05', 'B09'];
								$scope.arrayCausaliRisottometti = ['B00', 'B01', 'B02', 'B03', 'B04', 'B05', 'B09'];
								$scope.arrayCausaliModifica = ['B00', 'B01', 'B03'];
								$scope.showButtonConfermaKo = ($scope.arrayCausaliConfermaKo.indexOf(_codiceCausaleOao) > -1); 
								$scope.showButtonRisottometti = ($scope.arrayCausaliRisottometti.indexOf(_codiceCausaleOao) > -1);
								$scope.showButtonModifica = ($scope.arrayCausaliModifica.indexOf(_codiceCausaleOao) > -1);	
								
								$scope.lavorazioneManuale = {};
							}
							
							$scope.lavorazioneManualeRisottometti = function(){
								let _modalOptions = {
									headerText: 'Lavorazione Manuale',
									bodyText: "Risottomettere l'evento Fiberstream ?",
				                    actionButtonText: 'Si',
				                    closeButtonText: 'No',
				                    scope: $scope,
				                    callbackFunction: 'risottomettiEventoFibrestream'
								};
								modalService.showModal({}, _modalOptions);
							}
							
							$scope.lavorazioneManualeConfermaKo = function(){
								let _modalOptions = {
									headerText: 'Lavorazione Manuale',
									bodyText: "Confermare il KO per l'evento Fiberstream ?",
				                    actionButtonText: 'Si',
				                    closeButtonText: 'No',
				                    scope: $scope,
				                    callbackFunction: 'confermaKoEventoFibrestream'
								};
								modalService.showModal({}, _modalOptions);
							}
							
							$scope.lavorazioneManualeModifica = function(){
								let _modalOptions = {
									headerText: 'Lavorazione Manuale',
									bodyText: "Confermare la modifica per l'evento Fiberstream ?",
				                    actionButtonText: 'Si',
				                    closeButtonText: 'No',
				                    scope: $scope,
				                    callbackFunction: 'modificaEventoFibrestream'
								};
								modalService.showModal({}, _modalOptions);
							}
							
							$scope.lavorazioneManualeConfermaModifica = function(){
								let _modalOptions = {
									headerText: 'Lavorazione Manuale',
									bodyText: "Valore aggiornato, si vuole procedere con l'invio verso Fibestream ?",
				                    actionButtonText: 'Si',
				                    closeButtonText: 'No',
				                    scope: $scope,
				                    callbackFunction: 'confermaModificaEventoFibrestream'
								};
								modalService.showModal({}, _modalOptions);
							}
							
							$scope.risottomettiEventoFibrestream = function(){
								$scope.showSpinnerRisottomettiFiberstream = true;
								LavorazioneManualeFiberstream.risottometti.get({'idRichiestaOlo': $scope.orders.idrichiestaolo}).$promise
								.then(function(response){
									$scope.showSpinnerRisottomettiFiberstream = false;
									let _message = "";
									if(response.result.code.toUpperCase() == 'OK'){
										_message = "Operazione di risottomissione evento effettuata con successo." 
										$scope.showButtonRisottometti = false;
										$scope.showButtonModifica = !$scope.modificaEventoOk;
									}else{
										_message = "Errore nell'operazione di risottomissione."
									}
									modalService.showModal({},
										{
											headerText : "Lavorazione Manuale",
											bodyText : _message,
											actionButtonText : 'Chiudi',
											type : 'success'
										});
								}, function(error){
									$scope.showSpinnerRisottomettiFiberstream = false;
									modalService.showModal({},
										{
											headerText : "Lavorazione Manuale",
											bodyText : "Impossibile effettuare la risottomissione evento. Riprovare piu' tardi.",
											actionButtonText : 'Chiudi',
											type : 'success'
										});
								})
							}
							
							$scope.confermaKoEventoFibrestream = function(){
								$scope.showSpinnerConfermaKoFiberstream = true;
								LavorazioneManualeFiberstream.scarta.get({'idRichiestaOlo': $scope.orders.idrichiestaolo}).$promise
								.then(function(response){
									$scope.showSpinnerConfermaKoFiberstream = false;
									let _message = "";
									if(response.result.code.toUpperCase() == 'OK'){
										_message = "Operazione di conferma KO effettuata con successo." 
										$scope.showButtonConfermaKo = false;
									}else{
										_message = "Errore nell'operazione di conferma KO."
									}
									modalService.showModal({},
										{
											headerText : "Lavorazione Manuale",
											bodyText : _message,
											actionButtonText : 'Chiudi',
											type : 'success'
										});
								}, function(error){
									$scope.showSpinnerConfermaKoFiberstream = false;
									modalService.showModal({},
										{
											headerText : "Lavorazione Manuale",
											bodyText : "Impossibile effettuare la conferma KO evento. Riprovare piu' tardi.",
											actionButtonText : 'Chiudi',
											type : 'success'
										});
								})
							}
							
							$scope.modificaEventoFibrestream = function(){
								$scope.showSpinnerModificaFiberstream = true;
								LavorazioneManualeFiberstream.modifica.get({'idRichiestaOlo': $scope.orders.idrichiestaolo, 'idBuilding': $scope.lavorazioneManuale.idBuilding}).$promise
								.then(function(response){
									$scope.showSpinnerModificaFiberstream = false;
									if(response.result.code.toUpperCase() == 'OK'){
										$scope.lavorazioneManualeConfermaModifica();
									}else{
										modalService.showModal({},
											{
												headerText : "Lavorazione Manuale",
												bodyText : response.result.details,
												actionButtonText : 'Chiudi',
												type : 'success'
											});
										}
								}, function(error){
									$scope.showSpinnerModificaFiberstream = false;
									modalService.showModal({},
										{
											headerText : "Lavorazione Manuale",
											bodyText : "Impossibile effettuare la modifica evento. Riprovare piu' tardi.",
											actionButtonText : 'Chiudi',
											type : 'success'
										});
								})
							}
							
							$scope.confermaModificaEventoFibrestream = function(){
								$scope.showSpinnerModificaFiberstream = true;
								LavorazioneManualeFiberstream.modifica.get({'idRichiestaOlo': $scope.orders.idrichiestaolo}).$promise
								.then(function(response){
									$scope.showSpinnerModificaFiberstream = false;
									let _message = "";
									if(response.result.code.toUpperCase() == 'OK'){
										_message = "Valore inviato correttamente verso Fiberstream";
										$scope.modificaEventoOk = true;
									}else{
										_message = response.result.details;
									}
									modalService.showModal({},
										{
											headerText : "Lavorazione Manuale",
											bodyText : _message,
											actionButtonText : 'Chiudi',
											type : 'success'
										});
								}, function(error){
									$scope.showSpinnerModificaFiberstream = false;
									modalService.showModal({},
										{
											headerText : "Lavorazione Manuale",
											bodyText : "Impossibile effettuare la modifica evento. Riprovare piu' tardi.",
											actionButtonText : 'Chiudi',
											type : 'success'
										});
								})
							}
							
							/** FINE SEZIONE LAVORAZIONE MANUALE **/

						}])

		.controller(
				'ModalInstanceCtrl',
				[
						'$scope',
						'$uibModalInstance',
						'items',
						'title',
						function($scope, $uibModalInstance, items, title) {
							$scope.items = items;
							$scope.title = title;
							$scope.cancel = function() {
								$uibModalInstance.dismiss('cancel');
							};
						} ]);
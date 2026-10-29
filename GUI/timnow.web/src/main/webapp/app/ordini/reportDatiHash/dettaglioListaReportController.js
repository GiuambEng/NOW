//R1F-21-0411
timnow.controller('dettaglioListaReportController', ['$scope', '$rootScope', '$state', 'DettaglioListaReport', 'modalService', 'ExportId',
	function($scope, $rootScope, $state, DettaglioListaReport, modalService, ExportId) {

		$scope.headerDettaglioListaReport = [];
		$scope.dettaglioListaReport = [];
		$scope.tipoLista = ($state.params.tipoLista || null);
		$scope.idReport = ($state.params.idReport || null);

		$scope.loadDettaglioListaReport = function() {
			$scope.datiLoaded = true;
			$scope.dettaglioListaReport = [];
			DettaglioListaReport.get({ idReport: $scope.idReport, tipoLista: $scope.tipoLista }).$promise
				.then(function(response) {
					$scope.datiLoaded = false;
					if (response && response.result.description == 'OK') {
						switch ($scope.tipoLista) {
							case "TUTTI":
							case "SOSPESO":
							case "ACCODATO":
							case "OPERA SPECIALE":
								$scope.buildHeadersOrdini();
								if (response.listaOrdiniOutput) {
									$scope.dettaglioListaReport = response.listaOrdiniOutput;
								}
								break;
							case "DONATING":
								$scope.buildHeadersOrdiniDonating();
								if (response.listaOrdiniDonatingOutput) {
									$scope.dettaglioListaReport = response.listaOrdiniDonatingOutput;
								}
								break;
							case "ASSET":
								$scope.buildHeadersAssets();
								if (response.listaAssetOutput) {
									$scope.dettaglioListaReport = response.listaAssetOutput;
								}
								break;
						}
						$scope.$broadcast('nowTable.refreshData', $scope.dettaglioListaReport);
					} else {
						modalService.showModal({}, {
							headerText: "Dettaglio Report",
							templateUrl: 'app/common/templates.html',
							bodyText: response.esito.description
						});
					}
				}, function(error) {
					$scope.datiLoaded = false;
					modalService.showModal({}, {
						headerText: "Dettaglio Report",
						templateUrl: 'app/common/templates.html',
						bodyText: "Errore nel caricamento lista di dettaglio report."
					});
				});
		}

		$scope.buildHeadersOrdini = function() {
			$scope.headerDettaglioListaReport = [];
			$scope.headerDettaglioListaReport.push({ "key": "dataInvio", "value": "Data Invio", "type": "data", "pattern": "dd/MM/yyyy" });
			$scope.headerDettaglioListaReport.push({ "key": "codiceordineolo", "value": "Codice Ordine OAO", "type": "text", "condition": "" });
			$scope.headerDettaglioListaReport.push({ "key": "idRisorsa", "value": "ID Risorsa", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "tipoLavorazione", "value": "Tipo Lavorazione", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "offerta", "value": "Offerta", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "descriz_causal_olo", "value": "Causale", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "statorichiesteolo", "value": "Stato OAO", "type": "text", "condition": "" });
			$scope.headerDettaglioListaReport.push({ "key": "statorichiestanow", "value": "Stato Now", "type": "text", "condition": "" });
			$scope.headerDettaglioListaReport.push({ "key": "codfc_olo_agcom", "value": "Codifica OAO", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "inAttesaDesospensioneDaOao", "value": "In Attesa Desospensione da OAO(SI/NO)", "type": "text", "condition": "" });
		}

		$scope.buildHeadersOrdiniDonating = function() {
			$scope.headerDettaglioListaReport = [];
			$scope.headerDettaglioListaReport.push({ "key": "ordineTI", "value": "Ordine TI", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "statoOAO", "value": "Stato OAO", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "oaoDonating", "value": "OAO Donating", "type": "text" });
		}

		$scope.buildHeadersAssets = function() {
			$scope.headerDettaglioListaReport = [];
			$scope.headerDettaglioListaReport.push({ "key": "codiceOlo", "value": "Ordine OAO", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "codiceOrdineTI", "value": "Ordine TI", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "oao", "value": "Codifica OAO", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "idRisorsa", "value": "ID Risorsa", "type": "text", "classe": "pre" });
			$scope.headerDettaglioListaReport.push({ "key": "idRisorsaOperatoreRete", "value": "Identificativo Risorsa Operatore Rete", "type": "text", "classe": "pre" });
			$scope.headerDettaglioListaReport.push({ "key": "identificativoStatoAsset", "value": "Stato Asset", "type": "text" });
			$scope.headerDettaglioListaReport.push({ "key": "offerta", "value": "Offerta", "type": "text" });
		}

		$scope.getDettaglio = function(item) {
			switch ($scope.tipoLista) {
				case "TUTTI":
				case "SOSPESO":
				case "ACCODATO":
				case "OPERA SPECIALE":
					$scope.getDettaglioOrdine(item);
					break;
				case "DONATING":
					$scope.getDettaglioOrdineDonating(item);
					break;
				case "ASSET":
					$scope.getDettaglioAsset(item);
					break;
			}
		}

		$scope.getDettaglioOrdine = function(item) {
			var _orderNumber = "";
			var _reqType = "";
			var _codiceOrdineOlo = "";
			if (item.codiceordineti && item.statorichiestanow !== 'SCARTATO') {
				_orderNumber = item.codiceordineti;
			} else {
				_orderNumber = item.idRichiestaOlo;
			}
			_reqType = ((item.codiceordineti) && item.statorichiestanow !== 'SCARTATO') ? 'codiceordineti' : 'idrichiestaolo';
			_codiceOrdineOlo = item.codiceordineolo || (item.codiceordineti && item.statorichiestanow !== 'SCARTATO') || item.idRichiestaOlo;

			$state.go('root.ordini.listareport.dettaglio.ordine', {
				reqType: _reqType,
				orderNumber: _orderNumber,
				codiceOrdineOlo: _codiceOrdineOlo
			});
		}

		$scope.getDettaglioOrdineDonating = function(item) {
			$state.go('root.ordini.listareport.dettaglio.donating', {
				order: item,
				filters: ($scope.appliedFilters || null)
			});
		}

		$scope.getDettaglioAsset = function(item) {
			$state.go('root.ordini.listareport.dettaglio.asset', { id: item.identificativoAsset, asset: item })
		}


		$scope.iniziaExport = function() {
			var bodyData = $scope.buildExportRequest();

			$rootScope.numeroDatiEsportati = $scope.dettaglioListaReport.length;

			return ExportId.save({
				entita: (($scope.tipoLista == 'ASSET') ? 'assets' : 'orders')
			}, bodyData).$promise;

		};

		$scope.buildExportRequest = function() {
			if ($scope.tipoLista == 'ASSET') {
				return $scope.buildExportRequestAssets();
			} else {
				return $scope.buildExportRequestOrders();
			}
		}

		$scope.buildExportRequestAssets = function() {
			return {
				indiceriga: "",
				numerorighe: "",
				tipoprofilo: $rootScope.timnowConfigData.user.codiceProfilo,
				cod_olo: $rootScope.timnowConfigData.user.codificaOloAgcom,
				exportRequest: true,
				conditions: [],
				idReport: $scope.idReport
			};
		}

		$scope.buildExportRequestOrders = function() {
			return {
				userId: $rootScope.timnowConfigData.user.userId,
				idRichiesta: [],
				codOloAgcom: $rootScope.timnowConfigData.user.codificaOloAgcom,
				tipoProfilo: $rootScope.timnowConfigData.user.codiceProfilo,
				tipoLista: $scope.tipoLista,
				advancedResearch: {
					indiceriga: "",
					numerorighe: "",
					exportRequest: true,
					conditions: [],
					idReport: $scope.idReport
				}
			};
		}

		$scope.back = function() {
			$state.go('^');
		}

		$scope.loadDettaglioListaReport();
	}]);


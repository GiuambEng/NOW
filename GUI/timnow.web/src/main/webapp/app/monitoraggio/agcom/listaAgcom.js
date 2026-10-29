timnow.controller('listaAgcom', [ '$scope', '$state', '$log', '$rootScope', '$filter', 'agcomMonitorings', 'TRACKING_GUI', 'TrackingGUI', 
	function($scope, $state, $log, $rootScope, $filter, agcomMonitorings, TRACKING_GUI, TrackingGUI) {
		$scope.init = function() {
			$scope.conversionDateMatrix = {
					"0":4,
					"1":5,
					"2":6,
					"3":0,
					"4":1,
					"5":2,
					"6":3
				};
			$scope.showSpinner = true;
			$scope.setDate = function(year, month, day) {
				$scope.dt = new Date(year, month, day);
			};
			$scope.formats = [ 'dd/MM/yyyy', 'shortDate' ];
			$scope.format = $scope.formats[0];
			
			function getDayClass(data) {
				var date = data.date, mode = data.mode;
				if (mode === 'day') {
					var dayToCheck = new Date(date).setHours(0, 0, 0, 0);
					for (var i = 0; i < $scope.events.length; i++) {
						var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);
						if (dayToCheck === currentDay) {
							return $scope.events[i].status;
						}
					}
				}
				return '';
			}

			$scope.clear = function() {
				$scope.dt = null;
			};
			$scope.inlineOptions = {
				customClass : getDayClass,
				minDate : new Date(),
				showWeeks : false
			};
			$scope.dateOptions = {
				dateDisabled : disabled,
				formatYear : 'yy',
				maxDate : new Date(2020, 5, 22),
				minDate : new Date(),
				startingDay : 1
			};
			$scope.toggleMin = function() {
				$scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
				$scope.dateOptions.minDate = $scope.inlineOptions.minDate;
			};
			$scope.toggleMin();
			$scope.openDP1 = function() {
				$scope.popup_dp1.opened = true;
			};
			$scope.popup_dp1 = {
				opened : false
			};
			// disabilito i giorni della settimana
			function disabled(data) {
				var date = data.date, mode = data.mode;
				return mode === 'day' && (date.getDay() !== 3);
			}
			// attivo il tab corretto quando premo indietro dal dettaglio
			$scope.indextab = 1;				 
			 if ($state.params.livello === "1" || $state.params.livello === "2") {
				 	$scope.indextab = parseInt($state.params.livello, 10);
			 }	
			// carico il mercoledì più vicino
			$scope.mercoledi = new Date();
			$scope.mercoledi.setDate($scope.mercoledi.getDate() - $scope.conversionDateMatrix[$scope.mercoledi.getDay().toString()]);
			$scope.sezione($scope.giorno, '1', 'N');			
			$scope.showSpinner = false;
		};
		
		$scope.livello = "";
		$scope.getDettaglio = function(livello) {
				if (livello==="1") {
					$scope.sezione($scope.giorno, '1', 'Y');
					$scope.dettaglio = $scope.dettaglioGiacenza;
				}
				if (livello==="2") {
					$scope.sezione($scope.giorno, '2', 'Y');
					$scope.dettaglio = $scope.dettaglioPercentuale;
				}		
			$state.go('root.monitoraggio.agcom.dettaglioAgcom', {
				dettaglio : $scope.dettaglio,
				livello : livello,
				giorno : $scope.giorno
			});
		};
		
		$scope.sezione = function(giorno, sezione, dettaglio) {
			if ($scope.giornoSelezionato === undefined || $scope.giornoSelezionato === null || $scope.giornoSelezionato === "") {
				$scope.giorno = $filter('date')($scope.mercoledi, "dd/MM/yyyy");
			}
			else {
				$scope.giorno = $filter('date')($scope.giornoSelezionato, "dd/MM/yyyy");
			}
			$scope.showSpinner = true;
			// inizializzo e azzero i campi
			$scope.giacenza = {
				"dataRif" : [],
				"lavorati" : [],
				"ok" : [],
				"ko" : [],
				"giacenza" : [],
				"entroPrimaDAC_SLA" : [],
				"oltrePrimaDAC_SLA" : [],
				"diCuiGiacenzaRIM" : [],
				"diCuiFuoriSLA" : [],
				"diCuiGiacenzaDAC_Scaduta" : [],
				"giacenzaScadutaTotaleDACeSLA" : []
			};

			$scope.giacenzaperc = {
					"dataRif" : [],
					"giacenzaEntroPrimaDAC_OLO_SLAsuGiacenza" : [],
					"giacenzaOltrePrimaDAC_OLO_SLAsuGiacenza" : [],
					"giacenzaRimodulataSuGiacenza" : [],
					"giacenzaA_DACScadutaSuGiacenza" : [],
					"giacenzaScadutaTotSuGiacenza" : [],
					"koSuLavorati" : [],
					"okSULavorati" : [],
					"tipo" : []
		};

			$scope.giacenzascaduta = {
					"dataRif" : [],
					"giacenzaScadutaA_DAC_LA" : [],
					"giacenzaScadutaA_DAC_LNA" : [],
					"giacenzaScadutaA_DAC_TOT" : [],
					"giacenzaScadutaA_DAC_LA_LNA" : [],
					"totaleDAC_SLA" : []
			};
			
			$scope.rimodulazioni = {
					"dataRif" : [],
					"rimodulazioniCausaTI_LA" : [],
					"rimodulazioniCausaTI_LNA" : [],
					"rimodulazioniCausaTI_TOT" : []
			};
			
			$scope.nr = {
					"dataRif" : [],
					"nonRealizzabiliDAC_LA" : [],
					"nonRealizzabiliDAC_LNA" : [],
					"nonRealizzabiliDAC_LAeLNA" : []
			};
					
			$scope.dettaglioGiacenza = {};
			$scope.dettaglioPercentuale = {};

			if (sezione==='3' || sezione==='4' || sezione==='5') {
				dettaglio = null;
			}  
			
        	//RU_1010
            //Tracking da GUI per operazione RICERCA AVANZATA
			
			var _params = {
					livello : 'livello' + sezione,
					flagDettaglio : dettaglio,
					dataEstrazione : $scope.giorno,
					flagExport : false
			};
			
            var _trackBean = {
	    			timestampInizio: new Date().toISOString(),
	    			timestampFine: null,
	    			numeroDatiEsportati: 0,
	    			contenutoFile: null,
	    			descrizioneFunzione: 'Monitoraggio|Monitoraggio AGCOM',
	    			nomeFile: null,
	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
	    			parametriOperazione: JSON.stringify(_params) 			
            };
			
			
			agcomMonitorings.get({
				livello : 'livello' + sezione,
				flagDettaglio : dettaglio,
				dataEstrazione : $scope.giorno,
				flagExport : false
			}).$promise.then(function(response) {
				$scope.showSpinner = false;
				$scope.exportFileVisibility  = false;
				
		 		_trackBean.timestampFine = new Date().toISOString();
                _trackBean.esito = 'Ok';                        
                TrackingGUI.tracking(_trackBean);
				
			 	if (response.data.length > 0) {			 		
			 		$scope.errorDate = false;
					switch(sezione) {
						 case "1":
							 if (dettaglio==='Y') {
									angular.forEach(response.data, function(item) {
										if(!$scope.dettaglioGiacenza[item.olo]){
											$scope.dettaglioGiacenza[item.olo] = 
											{
												"dataRif" : [],
												"lavorati" : [],
												"ok" : [],
												"ko" : [],
												"giacenza" : [],
												"entroPrimaDAC_SLA" : [],
												"oltrePrimaDAC_SLA" : [],
												"diCuiGiacenzaRIM" : [],
												"diCuiFuoriSLA" : [],
												"diCuiGiacenzaDAC_Scaduta" : [],
												"giacenzaScadutaTotaleDACeSLA" : []
											};
										}
										$scope.dettaglioGiacenza[item.olo].dataRif.push(item.dataRif);
										$scope.dettaglioGiacenza[item.olo].lavorati.push(item.lavorati);
										$scope.dettaglioGiacenza[item.olo].ok.push(item.ok);
										$scope.dettaglioGiacenza[item.olo].ko.push(item.ko);
										$scope.dettaglioGiacenza[item.olo].giacenza.push(item.giacenza);
										$scope.dettaglioGiacenza[item.olo].entroPrimaDAC_SLA.push(item.entroPrimaDAC_SLA);
										$scope.dettaglioGiacenza[item.olo].oltrePrimaDAC_SLA.push(item.oltrePrimaDAC_SLA);
										$scope.dettaglioGiacenza[item.olo].diCuiGiacenzaRIM.push(item.diCuiGiacenzaRIM);
										$scope.dettaglioGiacenza[item.olo].diCuiFuoriSLA.push(item.diCuiFuoriSLA);
										$scope.dettaglioGiacenza[item.olo].diCuiGiacenzaDAC_Scaduta.push(item.diCuiGiacenzaDAC_Scaduta);
										$scope.dettaglioGiacenza[item.olo].giacenzaScadutaTotaleDACeSLA.push(item.giacenzaScadutaTotaleDACeSLA);
									});
									
									//SM_8906
									$rootScope.numeroDatiEsportati = response.data.length || 0;
								 }
							 else {
								angular.forEach(response.data, function(item) {
									$scope.giacenza.dataRif.push(item.dataRif);
									$scope.giacenza.lavorati.push(item.lavorati);
									$scope.giacenza.ok.push(item.ok);
									$scope.giacenza.ko.push(item.ko);
									$scope.giacenza.giacenza.push(item.giacenza);
									$scope.giacenza.entroPrimaDAC_SLA.push(item.entroPrimaDAC_SLA);
									$scope.giacenza.oltrePrimaDAC_SLA.push(item.oltrePrimaDAC_SLA);
									$scope.giacenza.diCuiGiacenzaRIM.push(item.diCuiGiacenzaRIM);
									$scope.giacenza.diCuiFuoriSLA.push(item.diCuiFuoriSLA);
									$scope.giacenza.diCuiGiacenzaDAC_Scaduta.push(item.diCuiGiacenzaDAC_Scaduta);
									$scope.giacenza.giacenzaScadutaTotaleDACeSLA.push(item.giacenzaScadutaTotaleDACeSLA);
								});
								
								//SM_8906
								$rootScope.numeroDatiEsportati = $scope.giacenza.dataRif.length || 0;
							 }
						 break;
						 case "2":
							 if (dettaglio==='Y') {
								angular.forEach(response.data, function(item) {
									if(!$scope.dettaglioPercentuale[item.olo]){
										$scope.dettaglioPercentuale[item.olo] = 
										{
											"dataRif" : [],
											"giacenzaEntroPrimaDAC_OLO_SLAsuGiacenza" : [],
											"giacenzaOltrePrimaDAC_OLO_SLAsuGiacenza" : [],
											"giacenzaRimodulataSuGiacenza" : [],
											"giacenzaA_DACScadutaSuGiacenza" : [],
											"giacenzaScadutaTotSuGiacenza" : [],
											"koSuLavorati" : [],
											"okSULavorati" : []
										};
									}
									$scope.dettaglioPercentuale[item.olo].dataRif.push(item.dataRif);
									$scope.dettaglioPercentuale[item.olo].giacenzaEntroPrimaDAC_OLO_SLAsuGiacenza.push(item.giacenzaEntroPrimaDAC_OLO_SLAsuGiacenza);
									$scope.dettaglioPercentuale[item.olo].giacenzaOltrePrimaDAC_OLO_SLAsuGiacenza.push(item.giacenzaOltrePrimaDAC_OLO_SLAsuGiacenza);
									$scope.dettaglioPercentuale[item.olo].giacenzaRimodulataSuGiacenza.push(item.giacenzaRimodulataSuGiacenza);
									$scope.dettaglioPercentuale[item.olo].giacenzaA_DACScadutaSuGiacenza.push(item.giacenzaA_DACScadutaSuGiacenza);
									$scope.dettaglioPercentuale[item.olo].giacenzaScadutaTotSuGiacenza.push(item.giacenzaScadutaTotSuGiacenza);
									$scope.dettaglioPercentuale[item.olo].koSuLavorati.push(item.koSuLavorati);
									$scope.dettaglioPercentuale[item.olo].okSULavorati.push(item.okSULavorati);										 
								});
								
								//SM_8906
								$rootScope.numeroDatiEsportati = response.data.length || 0;
							 }
							 else {
								angular.forEach(response.data, function(item) {
									$scope.giacenzaperc.dataRif.push(item.dataRif);
									$scope.giacenzaperc.giacenzaEntroPrimaDAC_OLO_SLAsuGiacenza.push(item.giacenzaEntroPrimaDAC_OLO_SLAsuGiacenza);
									$scope.giacenzaperc.giacenzaOltrePrimaDAC_OLO_SLAsuGiacenza.push(item.giacenzaOltrePrimaDAC_OLO_SLAsuGiacenza);
									$scope.giacenzaperc.giacenzaRimodulataSuGiacenza.push(item.giacenzaRimodulataSuGiacenza);
									$scope.giacenzaperc.giacenzaA_DACScadutaSuGiacenza.push(item.giacenzaA_DACScadutaSuGiacenza);
									$scope.giacenzaperc.giacenzaScadutaTotSuGiacenza.push(item.giacenzaScadutaTotSuGiacenza);
									$scope.giacenzaperc.koSuLavorati.push(item.koSuLavorati);
									$scope.giacenzaperc.okSULavorati.push(item.okSULavorati);
								});
								
								//SM_8906
								$rootScope.numeroDatiEsportati = $scope.giacenzaperc.dataRif.length || 0;
							 }
						 break;
						 case "3":
							 angular.forEach(response.data, function(item) {
								 $scope.giacenzascaduta.dataRif.push(item.dataRif);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LA.push(item.giacenzaScadutaA_DAC_LA_GIAC);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LA.push(item.giacenzaScadutaA_DAC_LA_SCAD);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LA.push(item.giacenzaScadutaA_DAC_LA_PERC);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LNA.push(item.giacenzaScadutaA_DAC_LNA_GIAC);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LNA.push(item.giacenzaScadutaA_DAC_LNA_SCAD);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LNA.push(item.giacenzaScadutaA_DAC_LNA_PERC);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_TOT.push(item.giacenzaScadutaA_DAC_TOT_GIAC);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_TOT.push(item.giacenzaScadutaA_DAC_TOT_SCAD);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_TOT.push(item.giacenzaScadutaA_DAC_TOT_PERC);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LA_LNA.push(item.giacenzaScadutaA_DAC_LA_LNA_GIAC);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LA_LNA.push(item.giacenzaScadutaA_DAC_LA_LNA_SCAD);
								 $scope.giacenzascaduta.giacenzaScadutaA_DAC_LA_LNA.push(item.giacenzaScadutaA_DAC_LA_LNA_PERC);
								 $scope.giacenzascaduta.totaleDAC_SLA.push(item.totaleDAC_SLA_GIAC);
								 $scope.giacenzascaduta.totaleDAC_SLA.push(item.totaleDAC_SLA_SCAD);
								 $scope.giacenzascaduta.totaleDAC_SLA.push(item.totaleDAC_SLA_PERC);
							 });
							 
							//SM_8906
							 $rootScope.numeroDatiEsportati = $scope.giacenzascaduta.dataRif.length || 0;
							 break;
						 case "4":
							 angular.forEach(response.data, function(item) {
								 $scope.rimodulazioni.dataRif.push(item.dataRif);
								 $scope.rimodulazioni.rimodulazioniCausaTI_LA.push(item.rimodulazioniCausaTI_LA_GIAC);
								 $scope.rimodulazioni.rimodulazioniCausaTI_LA.push(item.rimodulazioniCausaTI_LA_RIM);
								 $scope.rimodulazioni.rimodulazioniCausaTI_LA.push(item.rimodulazioniCausaTI_LA_PERC);
								 $scope.rimodulazioni.rimodulazioniCausaTI_LNA.push(item.rimodulazioniCausaTI_LNA_GIAC);
								 $scope.rimodulazioni.rimodulazioniCausaTI_LNA.push(item.rimodulazioniCausaTI_LNA_RIM);
								 $scope.rimodulazioni.rimodulazioniCausaTI_LNA.push(item.rimodulazioniCausaTI_LNA_PERC);
								 $scope.rimodulazioni.rimodulazioniCausaTI_TOT.push(item.rimodulazioniCausaTI_TOT_GIAC);
								 $scope.rimodulazioni.rimodulazioniCausaTI_TOT.push(item.rimodulazioniCausaTI_TOT_RIM);
								 $scope.rimodulazioni.rimodulazioniCausaTI_TOT.push(item.rimodulazioniCausaTI_TOT_PERC);
							 });
							
							 //SM_8906
							 $rootScope.numeroDatiEsportati = $scope.rimodulazioni.dataRif.length || 0;
							 break;
						 case "5":
							 angular.forEach(response.data, function(item) {
								 $scope.nr.dataRif.push(item.dataRif);
								 $scope.nr.nonRealizzabiliDAC_LA.push(item.nonRealizzabiliDAC_LA_LAV_NR);
								 $scope.nr.nonRealizzabiliDAC_LA.push(item.nonRealizzabiliDAC_LA_NR);
								 $scope.nr.nonRealizzabiliDAC_LA.push(item.nonRealizzabiliDAC_LA_PERC);
								 $scope.nr.nonRealizzabiliDAC_LNA.push(item.nonRealizzabiliDAC_LNA_LAV_NR);
								 $scope.nr.nonRealizzabiliDAC_LNA.push(item.nonRealizzabiliDAC_LNA_NR);
								 $scope.nr.nonRealizzabiliDAC_LNA.push(item.nonRealizzabiliDAC_LNA_PERC);
								 $scope.nr.nonRealizzabiliDAC_LAeLNA.push(item.nonRealizzabiliDAC_LAeLNA_LAV_NR);
								 $scope.nr.nonRealizzabiliDAC_LAeLNA.push(item.nonRealizzabiliDAC_LAeLNA_NR);
								 $scope.nr.nonRealizzabiliDAC_LAeLNA.push(item.nonRealizzabiliDAC_LAeLNA_PERC);
							 });
							 
							 //SM_8906
							 $rootScope.numeroDatiEsportati = $scope.nr.dataRif.length || 0;
							 break;
						 }
					}
					else {
						 $scope.errorDate = true;
						 $scope.msg_err = "Nessun dato da visualizzare per la data selezionata";
					}
				},
				function(error) {
					$scope.showSpinner = false;
					$log.error(error);
					$scope.errorDate = true;
					$scope.msg_errTotale = "Impossibile visualizzare il monitoraggio AGCOM";
					
			 		_trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ko';                        
                    TrackingGUI.tracking(_trackBean);
				});
		};

		$scope.init();
		
		$scope.tabAttivo = function (giorno, livello, dettaglio) {
			$scope.livello=livello;
			$scope.dettaglio=dettaglio;
			$scope.giorno=giorno;
			$scope.sezione($scope.giorno, livello, dettaglio);
		};

		$scope.iniziaExport = function () {
		
		if (($scope.livello === undefined || $scope.livello === null || $scope.livello === "") && ($scope.dettaglio === undefined || $scope.dettaglio === null)) {
			$scope.livello='1';
			$scope.dettaglio='N';
		}
		
		if ($scope.livello==='3' || $scope.livello==='4' || $scope.livello==='5') {
			$scope.dettaglio = null;
		}
				
		return agcomMonitorings.get({
				livello : 'livello' + $scope.livello,
				flagDettaglio : $scope.dettaglio,
				dataEstrazione : $scope.giorno,
				flagExport : true
			}).$promise;
		
		 };
	} ]);
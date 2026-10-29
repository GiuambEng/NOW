timnow.controller('newOrderStep8', ['$scope', '$state', '$rootScope', '$log', '$filter', 'Orders', 'TRACKING_GUI', 'TrackingGUI', 'VLANUtils', '_', 'PARENTAL_CONTROL_MAP',
	function ($scope, $state, $rootScope, $log, $filter, Orders, TRACKING_GUI, TrackingGUI, VLANUtils, _, PARENTAL_CONTROL_MAP) {

    // RU_1614
    $scope.parentalControlMap = PARENTAL_CONTROL_MAP;

	if ($rootScope.formData.stepReached < 8) $rootScope.formData.stepReached = 8;

    if($rootScope.formData.offers && $rootScope.formData.offers[0]){
    	$scope.isLNA=($rootScope.MAP_OFFERTE.VULL_LNA.id === $rootScope.formData.offers[0].idOfferta);
    }
    
    if ([$rootScope.MAP_OFFERTE.VP.name,
        $rootScope.MAP_OFFERTE.VLAN_NGA.name,
      	 $rootScope.MAP_OFFERTE.VLAN_GBE.name,
      	 $rootScope.MAP_OFFERTE.VLAN_VULA.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo)>=0){
    	$scope._indexBanda = VLANUtils.estraiIndiceCampoSezioneInferiore('BANDA');
    	$scope._indexCos = VLANUtils.estraiIndiceCampoSezioneInferiore('IDENTIFICATIVOCOS');
    	
        if(!angular.isArray($rootScope.customizedOffer.offerBotDetails)){
            $rootScope.customizedOffer.offerBotDetails = [];
        }
    }
    
    
    //SM_9425
	$scope.build_timeSlotPresaAppuntamento();
	
    
    //SM_9010
    var _opzioneTraffico = null;
    //SM_9016
    try{
    	//RU_915
    	$scope.isCPS = ([$rootScope.MAP_OFFERTE.CPS.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo)>=0) ? true : false;
    	_opzioneTraffico = angular.copy($rootScope.customizedOffer.offerTopDetails.OPZIONETRAFFICO.dft);
    }catch(e){
    	_opzioneTraffico = null;
    	$scope.isCPS = false;
    }
    $scope.opzioneTraffico = '';
    if(_opzioneTraffico){
    	switch(_opzioneTraffico){
    	case '0':
    		$scope.opzioneTraffico = 'Long Distance';
    		break;
    	case '2':
    		$scope.opzioneTraffico = 'Tutte';
    		break;
    	default:
    		$scope.opzioneTraffico = '';
    	}
    }
    
    var tipoOfferta='';
    if($rootScope.formData.offerDetails){
    	tipoOfferta= $rootScope.formData.offerDetails.offerta;
    }
    $scope.tipoULLSLU = tipoOfferta.substring(0, 3);

    $scope.openAllRiepilogo = function () {
        $scope.openPanelRiepilogo = {
            step1: true,
            step2: true,
            step3: true,
            step4: true,
            step5: true,
            step6: true,
            step7: true,
            closeOthers: false
        };
    };

    $scope.closeAllRiepilogo = function () {
        $scope.openPanelRiepilogo = {
            step1: false,
            step2: false,
            step3: false,
            step4: false,
            step5: false,
            step6: false,
            step7: false,
            closeOthers: true
        };
    };

    $scope.getBandaPicco = function (vv, w) {
        if (vv) {
        	var dd;
            try {
                dd = JSON.parse(vv);
            } catch (exception) {
                dd = vv;
            }
            return (w === 'up') ? dd.up : dd.down;
        }
    };
    $scope.allPanelsOpened = function () {
        var opr = $scope.openPanelRiepilogo;
        return (opr.step1 && opr.step2
            && opr.step3 && opr.step4 && opr.step5
            && opr.step6 && opr.step7);
    };

    $scope.allPanelsClosed = function () {
        var opr = $scope.openPanelRiepilogo;
        return (!opr.step1 && !opr.step2
            && !opr.step3 && !opr.step4
            && !opr.step5 && !opr.step6 && !opr.step7);
    };
    
    //RU_982
    $scope.oscuramento_RU_982 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_982.oscurato){
    				$scope.RU_982 = ($rootScope.OSCURAMENTI.RU_982.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_982 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_982 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_982();
    
    //RU_1036
    $scope.oscuramento_RU_1036 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1036.oscurato){
    				$scope.RU_1036 = ($rootScope.OSCURAMENTI.RU_1036.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_1036 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_1036 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1036();
    
    //RU_980
    //Variabili per visualizzazione delle diverse sezioni
    $scope.showServiziOpzionali = false;
    $scope.showDisaggregazione = false;
    $scope.showPresaAppuntamento = false;
    $scope.showPrestazioniAggiuntive = false;
    $scope.showSlaPlusSu = false;
    $scope.showSezionePerLNA = true;
    //RU_1485
    $scope.showServiziOpzionaliAlternativi = false;
    
    //Inizializza le variabili per mostrare/nascondere le sezioni in base al tipo di offerta
    $scope.checkShowSezioni_RU_980 = function(){
    	var idOfferta = $scope.data.step3.offerta.idOfferta;
    	
    	var attivazione = $rootScope.OSCURAMENTI.RU_980.visualizzaSezioni.attivazione;
    	var migrazione = $rootScope.OSCURAMENTI.RU_980.visualizzaSezioni.migrazione;
    	
    	if($scope.data.step1.causale_ordine.toLowerCase() == 'attivazione'){
    		//RU_1485
    		var _codiceProgetto = $scope.data.step2.codice_progetto;
    		$scope.showServiziOpzionaliAlternativi = (_codiceProgetto && _codiceProgetto.prodottiACatalogo == 'SI' && _codiceProgetto.oneStep && attivazione.offerteServiziOpzionaliAlternativi.indexOf(idOfferta) > -1);
    		$scope.showServiziOpzionali = (_codiceProgetto && (_.isUndefined(_codiceProgetto.prodottiACatalogo) || _codiceProgetto.prodottiACatalogo == 'NO') && attivazione.offerteServiziOpzionali.indexOf(idOfferta) > -1);
    		$scope.showDisaggregazione = (attivazione.offerteDisaggregazione.indexOf(idOfferta) > -1);
    		$scope.showPresaAppuntamento = (attivazione.offertePresaAppuntamento.indexOf(idOfferta) > -1);
    		$scope.showPrestazioniAggiuntive = (attivazione.offertePrestazioniAggiuntive.indexOf(idOfferta) > -1);
    		$scope.showSlaPlusSu = (attivazione.offerteSlaPlusSu.indexOf(idOfferta) > -1);
    		
    		//In caso di Offerte Linea Attiva ULL/ULL Dati/SLU mostrare la sezione  Disaggregazione
    		var idOfferteLA =[$rootScope.MAP_OFFERTE.ULL_LA.id, $rootScope.MAP_OFFERTE.ULLD_LA.id, $rootScope.MAP_OFFERTE.SLU_LA.id];
    		if(idOfferteLA.indexOf(idOfferta) > -1){
    			$scope.showDisaggregazione = true;    			
    			//Mostrare solo System unico nella sezione Disaggregazione
    			$scope.showSezionePerLNA = (idOfferteLA.indexOf(idOfferta) == -1);
    		}
    	    
    	    //In caso di offerta BTS/VULA FTTCab, visualizzare la sezione Servizi Opzionali solo in caso di Linea Non Fonia    	    
    	    if(['15','17'].indexOf(idOfferta) > -1){
    	    	if($scope.customizedOffer &&
    	       		 $scope.customizedOffer.offerTopDetails &&
    	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA && 
    	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'LineaNonFonia'){
    	    		$scope.showServiziOpzionali = true;
    	    	}else{
    	    		$scope.showServiziOpzionali = false;
    	    		//SM_9502
    	    		$scope.showPresaAppuntamento = false;
    	    		$scope.showPrestazioniAggiuntive = false;
    	    		$scope.showSlaPlusSu = false;
    	    	}
    	    	
    	    }
    		
    	}else if($scope.data.step1.causale_ordine.toLowerCase() == 'migrazione'){
       		$scope.showServiziOpzionali = (migrazione.offerteServiziOpzionali.indexOf(idOfferta) > -1);
    		$scope.showDisaggregazione = (migrazione.offerteDisaggregazione.indexOf(idOfferta) > -1);
    		
    		//RU_1033
    		$scope.showSezionePerLNA = false;
    		
    		//Disaggregazione visibile solo per VULA FTTCAB LineaNonFonia
    		if(['17'].indexOf(idOfferta) > -1){
    	    	if($scope.customizedOffer &&
       	       		 $scope.customizedOffer.offerTopDetails &&
       	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA && 
       	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'LineaNonFonia'){
       	    		$scope.showDisaggregazione = true;
       	    	}else{
       	    		$scope.showDisaggregazione = false;
       	    	}
    		}
    	}
    }
    
    $scope.oscuramento_RU_980 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_980.oscurato){
    				$scope.RU_980 = ($rootScope.OSCURAMENTI.RU_980.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.RU_980 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.RU_980 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_980();
    
    //R1I_20_0131
    
    $scope.oscuramento_R1I_20_0131 = function(){		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.R1I_20_0131.oscurato){
    				$scope.R1I_20_0131 = ($rootScope.OSCURAMENTI.R1I_20_0131.idOfferteValide.indexOf($scope.data.step3.offerta.idOfferta) > -1);
    			}else{
    				$scope.R1I_20_0131 = false;
    			}           			
    		}
    	}catch(e){
    		$scope.R1I_20_0131 = false;
    	}          	
    }
    
    $scope.oscuramento_R1I_20_0131();
    
    //Inizializza le variabili per mostrare/nascondere le sezioni in base al tipo di offerta
    $scope.checkShowSezioni_R1I_20_0131 = function(){
    	
    	if($scope.R1I_20_0131){
    		var idOfferta = $scope.data.step3.offerta.idOfferta;
        	
        	var attivazione = $rootScope.OSCURAMENTI.R1I_20_0131.visualizzaSezioni.attivazione;
        	
        	if($scope.data.step1.causale_ordine.toLowerCase() == 'attivazione'){
        		$scope.showDisaggregazione = (attivazione.offerteDisaggregazione.indexOf(idOfferta) > -1);
        		$scope.showPresaAppuntamento = (attivazione.offertePresaAppuntamento.indexOf(idOfferta) > -1);
        		$scope.showPrestazioniAggiuntive = (attivazione.offertePrestazioniAggiuntive.indexOf(idOfferta) > -1);
        		$scope.showSlaPlusSu = (attivazione.offerteSlaPlusSu.indexOf(idOfferta) > -1);
        		
        	    //In caso di offerta VULA FTTCab, visualizzare la sezione Servizi Opzionali solo in caso di Linea Non Fonia    	    
    	    	if($scope.customizedOffer &&
    	       		 $scope.customizedOffer.offerTopDetails &&
    	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA && 
    	    		 $scope.customizedOffer.offerTopDetails.TIPOLINEA.dft === 'LineaNonFonia'){
    	    		$scope.showServiziOpzionali = true;
    	    	}else{
    	    		$scope.showServiziOpzionali = false;
    	    		//SM_9502
    	    		$scope.showPresaAppuntamento = false;
    	    		$scope.showPrestazioniAggiuntive = false;
    	    		$scope.showSlaPlusSu = false;
    	    	}
        	}        		       	    
    	}    	
    }
        
     //RU_1393
     $scope.checkShowSezioni_RU_1393 = function(){
		var idOfferta = $scope.data.step3.offerta.idOfferta;		
		if($scope.data.step1.causale_ordine.toLowerCase() == 'attivazione'){
			$scope.isOffertaSemiGPON = (idOfferta == $rootScope.MAP_OFFERTE.GPON_SEMI.id) | false;
		}
	}

    $scope.checkShowSezioni_RU_980();
    
    $scope.checkShowSezioni_R1I_20_0131();
    
    $scope.checkShowSezioni_RU_1393();    

    //RU_1084
    $scope.oscuramento_RU_1084 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.RU_1084.oscurato){   				
   					$scope.RU_1084 = ($rootScope.OSCURAMENTI.RU_1084.idOfferteNonValide.indexOf($scope.data.step3.offerta.idOfferta) == -1);  				
    			}else{
    				$scope.RU_1084 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.RU_1084 = false;
    	}          	
    }
    
    $scope.oscuramento_RU_1084();
    
    //R1F-20-0236
    $scope.oscuramento_R1F_20_0236 = function(){
		
    	try{
    		if($scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta){            			
    			if(!$rootScope.OSCURAMENTI.R1F_20_0236.oscurato){   				
   					$scope.R1F_20_0236 = ($rootScope.OSCURAMENTI.R1F_20_0236.idOfferteNonValide.indexOf($scope.data.step3.offerta.idOfferta) == -1);  				
    			}else{
    				$scope.R1F_20_0236 = false;     			
    			}
    		}
    	}catch(e){
    		$scope.R1F_20_0236 = false;
    	}          	
    }
    
    $scope.oscuramento_R1F_20_0236();

    $scope.submit_8 = function () {
        // ??
        /*if (($rootScope.data.step1 && 
        	 $rootScope.data.step2 && 
        	 $rootScope.data.step3 && 
        	 $rootScope.data.step5 && 
        	 $rootScope.data.step6 && 
        	 $rootScope.data.step7) || $rootScope.data.step1.causale_ordine === 'variazione') {*/
            if ($scope.data.operatore)
                $scope.data.operatore = $scope.data.operatore.id;
            if ($scope.data.codice_progetto)
                $scope.data.codice_progetto = $scope.data.codice_progetto.cod_prgt;
            
            if($rootScope.data.step4){
            	if ($rootScope.data.step4.dac){
                	var dac4 = new Date($rootScope.data.step4.dac);
                	$rootScope.data.step4.dac = $filter('date')(
                        dac4, 'dd/MM/yyyy');
                }else{
                	delete $rootScope.data.step4.dac;
                }
                if ($rootScope.data.step4.dad){
                	var dad4 = new Date($rootScope.data.step4.dad);
                	$rootScope.data.step4.dad = $filter('date')(
                            dad4, 'dd/MM/yyyy');
                }else{
                	delete $rootScope.data.step4.dad;
                }
            }
            
            if ($scope.data.step7.dac){
            	var dac7 = new Date($scope.data.step7.dac);
                $scope.data.step7.dac = $filter('date')(
                    dac7, 'dd/MM/yyyy');
            }else{
            	delete $scope.data.step7.dac;
            }
            	
            
            if ($scope.data.step7.dad){
            	var dad7 = new Date($scope.data.step7.dad);
            	$scope.data.step7.dad = $filter('date')(
                        dad7, 'dd/MM/yyyy');
            }else{
            	delete $scope.data.step7.dad;
            }
            
            //RU_1462
            if ($scope.data.step7.dataPrevistaAttivazione){
            	var dataPa = new Date($scope.data.step7.dataPrevistaAttivazione);
            	$scope.data.step7.dataPrevistaAttivazione = $filter('date')(
                        dataPa, 'dd/MM/yyyy');
            }else{
            	delete $scope.data.step7.dataPrevistaAttivazione;
            }
            
            //RU_980
            if ($scope.data.step7.datiAppuntamentoDisaggregazione && $scope.data.step7.datiAppuntamentoDisaggregazione.dataAppuntamento){
            	var dataPresaAppuntamento = new Date($scope.data.step7.datiAppuntamentoDisaggregazione.dataAppuntamento);
                $scope.data.step7.datiAppuntamentoDisaggregazione.dataAppuntamento = $filter('date')(dataPresaAppuntamento, 'dd/MM/yyyy');
            }
            
            //RU_1084
            //R1F-20-0236
            if($scope.RU_1084 || $scope.R1F_20_0236){
            	if($rootScope.data.numeriReferentiTokenizzati && $rootScope.data.numeriReferentiTokenizzati.length > 0){      
            		
            		var _referentiTokenizzati = $rootScope.data.numeriReferentiTokenizzati;
            		var _keys = Object.keys($scope.data.step5.datiReferenti);

            		//Bug #32193
            		_referentiTokenizzati.forEach(function(value, i){
            			//SM_9625
            			var _index = parseInt(value.id) + 1;
            			if($scope.data.step5.datiReferenti[_index].cellulare){
            				$scope.data.step5.datiReferenti[_index].cellulare = (value.numeroMobile || null);
            			}
            			if($scope.data.step5.datiReferenti[_index].telefonoFisso){
            				$scope.data.step5.datiReferenti[_index].telefonoFisso = (value.numeroFisso || null);	
            			}
            			
            			//SM_10413
            			$scope.data.step5.datiReferenti[_index].nome = (value.nome || null);
            			$scope.data.step5.datiReferenti[_index].cognome = (value.cognome || null);
            		});
            	}
            	
            	//Task #36242
            	if($rootScope.data.clienteFinaleTokenizzato && !_.isEmpty($rootScope.data.clienteFinaleTokenizzato)){
            		$scope.data.step6.datiClienteFinale.codice_fiscale_cliente = $rootScope.data.clienteFinaleTokenizzato.codFiscale;
            		$scope.data.step6.datiClienteFinale.cognome_cliente = $rootScope.data.clienteFinaleTokenizzato.cognome;
            		$scope.data.step6.datiClienteFinale.nome_cliente = $rootScope.data.clienteFinaleTokenizzato.nome;
            		//SM_10454
            		$scope.data.step6.datiClienteFinale.partita_iva_cliente = $rootScope.data.clienteFinaleTokenizzato.pIva;
            	}
            }
            
            if ($scope.data.step7.dataDisponibilitaSede){
            	var dataDisponibilitaSede7 = new Date($scope.data.step7.dataDisponibilitaSede);
            	$scope.data.step7.dataDisponibilitaSede = $filter('date')(
            			dataDisponibilitaSede7, 'dd/MM/yyyy');
            }else{
            	delete $scope.data.step7.dataDisponibilitaSede;
            }
            
            if ($scope.data.step7.dataSottoscrizioneContratto)
            	var dataSottoscrizioneContratto = new Date($scope.data.step7.dataSottoscrizioneContratto);
                $scope.data.step7.dataSottoscrizioneContratto = $filter('date')(
                		dataSottoscrizioneContratto, 'dd/MM/yyyy');
            
            if ($scope.data.step7.dataRichiestaColocazione){
            	var dataRichiestaColocazione = new Date($scope.data.step7.dataRichiestaColocazione);
            	$scope.data.step7.dataRichiestaColocazione = $filter('date')(
            			dataRichiestaColocazione, 'dd/MM/yyyy');
            }

            if ($scope.data.step1.operatore) {
                $scope.data.step1.operatore = $scope.data.step1.operatore.id;
            }
            if ($scope.data.step2.codice_progetto) {
                $scope.data.step2.codice_progetto = $scope.data.step2.codice_progetto.cod_prgt;
            }
            if($scope.data.step2.contratto.idContratto && $scope.data.step2.contratto.idContrattoPadre)
            	{ $scope.data.step2.contratto.idContratto = $scope.data.step2.contratto.idContrattoPadre; }
            
            if ($rootScope.data.step4 && $rootScope.data.step4.vcItems) {
            	$rootScope.data.step4.offerBotDetails = $rootScope.data.step4.vcItems;
                delete $rootScope.data.step4.vcItems;
            }

            if ($scope.data.step3.offertaLabel) {
                delete $scope.data.step3.offertaLabel;
            }
            if ($scope.data.step3.offerta) {
                $scope.data.step3.offertaCatalogo = $scope.data.step3.offerta.nomeOffertaCatalogo;
            }
            var orderData = {};

            if ($rootScope.data.step4 && $rootScope.data.step4.offerBotDetails) {
                if ($rootScope.data.step4.offerBotDetails.CODICETD) {
                	$rootScope.data.step4.offerBotDetails.CODICETD = $rootScope.data.step4.offerBotDetails.CODICETD.codKit;
                }
            }

            $scope.pass = 0;

            //$log.info($rootScope.formData);

            if ($rootScope.data.step1) {
                angular.extend(orderData, $rootScope.data.step1);
                $scope.pass++;
            }

            if ($rootScope.data.step2) {
                angular.extend(orderData, $rootScope.data.step2);
                $scope.pass++;
            }

            if ($rootScope.data.step3) {
                angular.extend(orderData, $rootScope.data.step3);
                $scope.pass++;
            }
            
            if ($rootScope.data.step4) {
                angular.extend(orderData, $rootScope.data.step4);
                $scope.pass++;
            }
            
            if ($rootScope.data.step5) {
                angular.extend(orderData, $rootScope.data.step5);
                $scope.pass++;
            }

            if ($rootScope.data.step6) {
                angular.extend(orderData, $rootScope.data.step6);
                $scope.pass++;
            }

            if ($rootScope.data.step7) {
                angular.extend(orderData, $rootScope.data.step7);
                $scope.pass++;
            }
            
            if ($rootScope.data.step1.causale_ordine === 'variazione') {
                orderData.offerDetails = $scope.extractOfferDetails();
                $scope.pass++;
            }
            
            if ($rootScope.data.step1.causale_ordine !== 'variazione' && $scope.pass >= 6) {
                $rootScope.data.step4 = $scope.extractOfferDetails();
            }

            if ($rootScope.data.step1.causale_ordine !== 'variazione' && $rootScope.data.step4) {
                orderData.offerDetails = $rootScope.data.step4;
            }

            if (($scope.pass === 7) || (($rootScope.data.step1.causale_ordine === 'variazione') && ($scope.pass >= 5))) {
                $scope.loadStep8 = true;
                var query = {};
                query.codiceOrdineOlo = orderData.codice_ordine;
                query.lavorazione = orderData.causale_ordine;
                query.codiceOlo = orderData.contratto.codificaOAO;
                query.servizio = orderData.offerta.nomeOfferta;
                query.flagAbilitato = orderData.contratto.flagAbilitato;
                $scope.OrderSave(orderData);
            } else {
                $scope.erroreService("Devi completare tutti i passaggi prima di inviare l'ordine.");
                $scope.loadStep8 = false;
            }
        /*} else {
            $scope.erroreService("Devi completare tutti i passaggi prima di inviare l'ordine.");
            $scope.loadStep8 = false;
        }*/
    }; // fine passaggio 8 attivazione

    $scope.OrderSave = function (orderData) {
    	if (orderData.offerta && orderData.offerta.idOfferta) {
            orderData.idOfferta = orderData.offerta.idOfferta;
            delete orderData.offerta;
        }

        if (orderData.tipologia_ordine) {
            delete orderData.tipologia_ordine;
        }
        
        //SM_8060
        if(!!orderData.datiReferentiOnField && !orderData.datiReferentiOnField.cognomeOnField) {
        	delete orderData.datiReferentiOnField;
        }
        
        //SM_9443
        if(!!orderData && orderData.opzioneVariazione == "Riconfigurazione Accesso" && !!orderData.idAssetScelto && orderData.idAssetScelto.offerta && orderData.idAssetScelto.offerta.toUpperCase() == "EASYIPNGAFTTCAB") {
        	orderData.variazione = $scope.data.step4.variazione;
        }

        //RU_1010
        //Tracking da GUI per operazione INSERIMENTO         
        var _trackBean = {
    			timestampInizio: new Date().toISOString(),
    			timestampFine: null,
    			descrizioneFunzione: null,
    			numeroDatiEsportati: 0,
    			contenutoFile: null,
    			nomeFile: null,
    			tipoOperazione: TRACKING_GUI.EVENTI.INSERIMENTO.descrizione,
    			parametriOperazione: null 			
        };
        
        if($scope.data.step1.causale_ordine.toLowerCase() == 'variazione'){
        	_trackBean.descrizioneFunzione = 'Asset|Lista Asset|Variazione Asset';
        }else{
        	_trackBean.descrizioneFunzione = 'Ordini|Nuovo Ordine';
        }
        
        Orders.save(orderData, function (data) {
        	                  
        		_trackBean.timestampFine = new Date().toISOString();	            
        		_trackBean.esito = 'Ok';
        		TrackingGUI.tracking(_trackBean);
        	
        		if(data.result.code.toLowerCase() === "ok"){
                    $state.go($scope.checkNextState());
        		}
        		else{
                    $scope.erroreService("Non e' stato possibile completare l'operazione. Riprova piu' tardi.");
        		}
                $scope.loadStep8 = false;
            },
            function (data) {
            	
        		_trackBean.timestampFine = new Date().toISOString();	            
        		_trackBean.esito = 'Ko';
        		TrackingGUI.tracking(_trackBean);
            	
                $log.debug(data);
                $state.go('root.ordini.new.step1', {"init": true});
                $rootScope.data = {};
                $rootScope.formData = {};
                $scope.loadStep8 = false;
                $scope.erroreService("Non e' stato possibile completare l'operazione. Riprova piu' tardi.");
            }
        );
    };
    
    $scope.extractOfferDetails = function () {
        var offerDetails = {
            offerTopDetails: {},
            offerBotDetails: []
        };
        
        //SM_10322
        /*
         * In caso di Riconfigurazione Accesso con variazione = 'Encapsulation'
         * le UserVLAN con FLAG MULTICAST = SI non devono essere inviate al servizio
         * di creazione ordine
         */
        var _checkVariazione = ($scope.data.step1.causale_ordine == 'variazione' ? true : false);
        var _checkOpzioneVariazione = ($scope.data.step3.opzioneVariazione == 'Riconfigurazione Accesso' ? true : false);
        var _checkVariazioneEncapsulation = ($scope.data.step4 && $scope.data.step4.variazione && $scope.data.step4.variazione == 'Encapsulation' ? true : false);
        
        //SM_10473
        var _checkVlanMulticast = false;
        
        if($scope.data.step4 && $scope.data.step4.vlausers){
        	_checkVlanMulticast = _.some($scope.data.step4.vlanusers, function(item){
            	return (item.FLAGMULTICAST && item.FLAGMULTICAST.dft == 'Y');
            });
        }
                
        if(_checkVariazione && 
           _checkOpzioneVariazione &&
           _checkVariazioneEncapsulation &&
           _checkVlanMulticast){
        	$scope.data.step4.vlanusers = _.filter($scope.data.step4.vlanusers, function(item){
            	return (!item.FLAGMULTICAST);
            });
        }
        

        if ($rootScope.getMap_Offerta($scope.data.step3.offerta.nomeOffertaCatalogo).regolatorio) {
        	offerDetails.offerTopDetails = $rootScope.customizedOffer.offerTopDetails;
        	
            // SE è ATM e GBE al momento del SUBMIT
        } else if ([$rootScope.MAP_OFFERTE.GBE_AF.name,
            	 $rootScope.MAP_OFFERTE.ATM_AF.name,
            	 $rootScope.MAP_OFFERTE.ATM_AH.name,
            	 $rootScope.MAP_OFFERTE.ATM_SF.name,
            	 $rootScope.MAP_OFFERTE.ATM_SH.name,
            	 $rootScope.MAP_OFFERTE.ATM_AL.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo)>=0) {

            angular.forEach($scope.data.step4.offerBotDetails, function (value) {
                if (value.CVLANIDVLAN) {
                    if (value.CVLANIDVLAN.dft) {
                        value.CVLANID = [];
                        value.CVLANID.dft = value.CVLANIDVLAN.dft;
                    }
                    else {
                        value.CVLANID = [];
                        value.CVLANID.dft = value.codice_vlan;
                    }
                }
                if (value.codice_vlan) {
                    value.CVLANID = [];
                    value.CVLANID.dft = value.codice_vlan;
                }
                if (value.TIPOBANDACONSEGNA) {
                    if (value.TIPOBANDACONSEGNA.dft === 'Dedicata') {
                        value.TIPOBANDACONSEGNA.dft = "BandaDedicata";
                    }
                    if (value.TIPOBANDACONSEGNA.dft === 'Condivisa') {
                        value.TIPOBANDACONSEGNA.dft = "BandaCondivisa";
                    }
                }
            });

            offerDetails.offerTopDetails = $rootScope.customizedOffer.offerTopDetails;

            var countVc = 1;

            angular.forEach($scope.data.step4.offerBotDetails, function (arrayItem) {

                angular.forEach(arrayItem, function (value, key) {
                    if ($rootScope.customizedOffer.offerBotDetails[key] && (value.dft !== null)) {
                        var keyObject = angular.copy($rootScope.customizedOffer.offerBotDetails[key]);
                        keyObject.dft = angular.isObject(value) ? value.dft : value + "";
                        keyObject.progressivo = countVc + "";
                        
                        if(keyObject.dft)
                        offerDetails.offerBotDetails.push(keyObject);

                    }
                });
                countVc++;
            });

            // SE è VULA AL MOMENTO DEL SUBMIT
        } else if ([$rootScope.MAP_OFFERTE.GBE_SF.name,
                    $rootScope.MAP_OFFERTE.VULA_CAB.name, 
                    $rootScope.MAP_OFFERTE.VULA_H.name, 
                    $rootScope.MAP_OFFERTE.NGA_CAB.name, 
                    $rootScope.MAP_OFFERTE.EASY_CAB.name,
                    $rootScope.MAP_OFFERTE.EASY_H.name,
                    $rootScope.MAP_OFFERTE.NGA_H.name,
                    $rootScope.MAP_OFFERTE.SEMI_BTS_H.name,
                    $rootScope.MAP_OFFERTE.SEMI_VULA_H.name,
                    $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name,
                    $rootScope.MAP_OFFERTE.FIBERSTREAM.name,
                    $rootScope.MAP_OFFERTE.FULLGPONPLUS.name,
                    $rootScope.MAP_OFFERTE.FULLGPONPLUSNGA.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo)>=0) {

            angular.forEach($scope.data.step4.vlanusers, function (value) {
                if (value.codice_vlan) {
                    value.CVLANID = [];
                    value.CVLANID.dft = value.codice_vlan;
                }
            });
            
            offerDetails.offerTopDetails = $rootScope.customizedOffer.offerTopDetails;

            var countUser = 1;
            angular.forEach($scope.data.step4.vlanusers, function (arrayItem) {


                angular.forEach(arrayItem, function (value, key) {
                    if ($rootScope.customizedOffer.offerBotDetails[key] && (value.dft !== null)) {
                        var keyObject = angular.copy($rootScope.customizedOffer.offerBotDetails[key]);
                        keyObject.dft = angular.isObject(value) ? value.dft + "" : value + "";
                        keyObject.progressivo = countUser + "";
                        
                        if(keyObject.dft)
                        offerDetails.offerBotDetails.push(keyObject);
                    }
                });
                countUser++;
            });
        } 
        //RU_1475
        //Se si tratta di offerta EOLO FWA
        else if($scope.data.step3.offerta.nomeOffertaCatalogo === $rootScope.MAP_OFFERTE.FWAITALIA1GIGASARDEGNA.name) {
			offerDetails.offerTopDetails = $rootScope.customizedOffer.offerTopDetails = {};

            var countUser = 1;
            angular.forEach($scope.data.step4.vlanusers, function (arrayItem) {
                angular.forEach(arrayItem, function (value, key) {
                    if ($rootScope.customizedOffer.offerBotDetails[key] && (value.dft !== null)) {
                        var keyObject = angular.copy($rootScope.customizedOffer.offerBotDetails[key]);
                        keyObject.dft = angular.isObject(value) ? value.dft + "" : value + "";
                        keyObject.progressivo = countUser + "";
                        
                        if(keyObject.dft)
                        offerDetails.offerBotDetails.push(keyObject);
                    }
                });
                countUser++;
            });
		}
        // SE è EASYIP al momento del SUBMIT
        else if ([$rootScope.MAP_OFFERTE.EASY_BF.name,
                    $rootScope.MAP_OFFERTE.EASY_BL.name,
                    $rootScope.MAP_OFFERTE.EASY_SF.name,
                    $rootScope.MAP_OFFERTE.EASY_SL.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo)>=0) {

            offerDetails.offerTopDetails = $rootScope.customizedOffer.offerTopDetails;

            angular.forEach($rootScope.customizedOffer.offerBotDetails, function (value, key) {
                    if ($rootScope.customizedOffer.offerBotDetails[key] && (value.dft !== null)) {
                        var keyObject = angular.copy($rootScope.customizedOffer.offerBotDetails[key]);
                        if(value && value.dft){
                        	keyObject.dft = angular.isObject(value.dft) ? value.dft : (value.dft + "");
                        } else {
                        	keyObject.dft = "";
                        }
                        
                        if(keyObject.dft)
                        offerDetails.offerBotDetails.push(keyObject);
                    }
                });
            
        } else if ([$rootScope.MAP_OFFERTE.FWA.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo)>=0) { //RU_716
        
        	var offerDetails = {
                offerTopDetails: {},
                offerBotDetails: []
            };
        	$rootScope.topDetails.TIPOLOGIACPE;
        	$rootScope.topDetails.FLAGINTERVENTO;
        	var tipologiaCpeObj = {
				"key":$rootScope.topDetails.TIPOLOGIACPE.key,
	            "componente": $rootScope.topDetails.TIPOLOGIACPE.componente,
	            "dft":  $scope.data.step4.tipologia_cpe,
	            "tipologiaDato":$rootScope.topDetails.TIPOLOGIACPE.tipologiaDato,
	            "valore": $scope.data.step4.tipologia_cpe,
	            "progressivo": $rootScope.topDetails.TIPOLOGIACPE.progressivo
        	};
        	       	
        	var flagInterventoObj = {
    			"key":$rootScope.topDetails.FLAGINTERVENTO.key,
                "componente": $rootScope.topDetails.FLAGINTERVENTO.componente,
                "dft": $scope.data.step4.flag_intervento,
                "tipologiaDato":$rootScope.topDetails.FLAGINTERVENTO.tipologiaDato,
                "valore":$scope.data.step4.flag_intervento,
                "progressivo":$rootScope.topDetails.FLAGINTERVENTO.progressivo
        	};
        	//RU_863
        	var profiloFwaObj = {
        			"key":$rootScope.topDetails.PROFILO.key,
                    "componente": $rootScope.topDetails.PROFILO.componente,
                    "dft": $scope.data.step4.profilo_fwa.profilo,
                    "tipologiaDato":$rootScope.topDetails.PROFILO.tipologiaDato,
                    "valore":$scope.data.step4.profilo_fwa.profilo,
                    "progressivo":$rootScope.topDetails.PROFILO.progressivo
            };
            
            //SM_10373
        	offerDetails.offerTopDetails.TIPOLOGIACPE = tipologiaCpeObj;
        	offerDetails.offerTopDetails.FLAGINTERVENTO = flagInterventoObj;
        	offerDetails.offerTopDetails.PROFILO = profiloFwaObj;
        	//SM_10952
        	if($rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.RISORSASWITCHOFF){
				offerDetails.offerTopDetails.RISORSASWITCHOFF = $rootScope.customizedOffer.offerTopDetails.RISORSASWITCHOFF;
			}
        
        }else if ([$rootScope.MAP_OFFERTE.CPS.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo)>=0){ //RU_915
        	offerDetails.offerTopDetails = $rootScope.customizedOffer.offerTopDetails;
        	
        }
        //RU_1058
        else if ([$rootScope.MAP_OFFERTE.VP.name,
         $rootScope.MAP_OFFERTE.VLAN_NGA.name,
       	 $rootScope.MAP_OFFERTE.VLAN_GBE.name,
    	 $rootScope.MAP_OFFERTE.VLAN_VULA.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo)>=0) {        		
                offerDetails.offerTopDetails = $rootScope.customizedOffer.offerTopDetails;
                offerDetails.offerBotDetails = $rootScope.customizedOffer.offerBotDetails;
                if($scope.data.step4 && $scope.data.step4.condivisoriToSend){
                	//angular.extend(offerDetails.offerBotDetails, $scope.data.step4.condivisoriToSend);
                	Array.prototype.push.apply(offerDetails.offerBotDetails, $scope.data.step4.condivisoriToSend)
                }
        }
        
        return offerDetails;
    };
}]);
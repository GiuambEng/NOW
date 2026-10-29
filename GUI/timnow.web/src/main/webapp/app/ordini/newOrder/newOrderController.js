timnow.controller('newOrder', ['$scope', '$state', '$rootScope', '$log', '$filter', '$stateParams', 'modalService', 'LineProfiles', 'Bands', 'TDCodes', 'Draft', 'ConfigurazioneFE', 'Assets','VerificaCoerenzaIdRisorsa', 'checkVariazione','ConvertDateService', 'SlaValidationService','RecuperaIdAsset','Locator','VerificaCongruenzaOffertaCodOrdine','verificaTicketTTM', 'verificaTecnologia', 'Dac', 'VisualizzaTipoBanda', '_',
     function ($scope, $state, $rootScope, $log, $filter, $stateParams, modalService, LineProfiles, Bands, TDCodes, Draft, ConfigurazioneFE, Assets,VerificaCoerenzaIdRisorsa, checkVariazione, ConvertDateService, SlaValidationService,RecuperaIdAsset,Locator,VerificaCongruenzaOffertaCodOrdine,verificaTicketTTM, verificaTecnologia, Dac, VisualizzaTipoBanda, _) {

        // SE ARRIVO DA MENU AZZERO IL NUOVO ORDINE
        if ($state.params.init) {
            $rootScope.formData = {};
            $rootScope.data = {};
            $scope.data = {};
            delete $scope.draftOrder;
            delete $state.params.order;
            delete $rootScope.bozza;
            
            //RU_1180
            $rootScope.primoFeeder = ($state.params.primoFeeder ? $state.params.primoFeeder : false);
            $rootScope.secondoFeeder = ($state.params.secondoFeeder ? $state.params.secondoFeeder : false);            
            $rootScope.isFeederOrder = ($rootScope.primoFeeder || $rootScope.secondoFeeder);
            
            /////////
            var _state = "";
            if($state.includes('**.listareport.**')){
				_state = "root.ordini.listareport.dettaglio.asset.new.step1";
			}else{
				_state = "root.ordini.new.step1";
			}		
			
            
            $state.go(_state, {"init": false});            
            $scope.loadStep2=false;
                      
        }

        // CONFIGURAZIONE FE - C11M08F51 - C11M08F39
        $scope.configurazioneFE = function(valoriConf){
        	return ConfigurazioneFE.get({codFunzione : valoriConf[0].funzione, idOfferta : valoriConf[0].idOfferta, opzioneVariazione: valoriConf[0].opzioneVariazione}).$promise;
        }
        ;
        // MODALE PER MESSAGGIO DI ERRORE
        $scope.erroreService = function (messageBody) {
            modalService.showModal({}, {
                headerText: "Avviso",
                closeButtonText: 'Chiudi',
                bodyText: messageBody,
                scope: $scope,
                type: 'success'
            });
            $scope.caricaPassFive = false;
        };

        // VISUALIZZA BOZZA
        if ($state.params.order && !$scope.draftOrder)
            $scope.draftOrder = $state.params.order;

        if ($scope.draftOrder) {
            if ($scope.draftOrder.corpo.data) {

                $rootScope.formData = {};
                $rootScope.data = {};
                $rootScope.bozza = null;
                $rootScope.bozza = $scope.draftOrder.corpo;
                $rootScope.bozza.noteBozza = $scope.draftOrder.note;
                $rootScope.bozza.nomeBozza = $scope.draftOrder.nome;
                $rootScope.bozza.OAOBozza = $scope.draftOrder.codOloAgcom;
                $rootScope.data = $scope.data = $scope.draftOrder.corpo.data;
                $rootScope.codOrdineOloBozza = $scope.draftOrder.corpo.nomeBozza;
                
                //RU_1180
                $rootScope.primoFeeder = ($rootScope.data.step1.primoFeeder ? $rootScope.data.step1.primoFeeder : false);
                $rootScope.secondoFeeder = ($rootScope.data.step1.secondoFeeder ? $rootScope.data.step1.secondoFeeder : false);            
                $rootScope.isFeederOrder = ($rootScope.data.step1.isFeederOrder ? $rootScope.data.step1.isFeederOrder : false);

                if($scope.draftOrder.corpo.data.step4 && $scope.draftOrder.corpo.data.step4.vcItems){
                	$rootScope.vcItems = $scope.draftOrder.corpo.data.step4.vcItems;
                }


                var stepValidi = 0;
                angular.forEach($rootScope.data, function (step) {
                    if (step) {
                    	stepValidi++;
                    }
                });
                $rootScope.formData.stepReached = stepValidi;

            } else {
                $state.go('root.ordini.bozza');
                $scope.erroreService("Bozza non valida");
            }


        }

        // / FINE VISUALIZZA BOZZA
        // CONTROLLER PADRE NUOVO ORDINE

        // COSTANTI E CONTROLLI INIZIALI
        if ($rootScope.timnowConfigData.config.today) {
            $scope.date = $rootScope.timnowConfigData.config.today;
            $scope.quality_code = angular.fromJson($rootScope.timnowConfigData.config.quality_code);
            $scope.time_slot = angular.fromJson($rootScope.timnowConfigData.config.time_slot);
            $scope.clir_slot = angular.fromJson($rootScope.timnowConfigData.config.clir_slot);

        } else {
            $scope.quality_code = {};
            $scope.time_slot = {};
            $scope.date = new Date();
        }
                
        //SM_9425
        $scope.build_timeSlotPresaAppuntamento = function(){
            $scope.timeSlotPresaAppuntamento = {
                	"01" : "08:30 - 10:30",
                	"02" : "10:30 - 13:00",
                	"03" : "13:00 - 15:00",
                	"04" : "15:00 - 17:00"
                };
                
                var _arrayOfferteDisaggregazione = [$rootScope.MAP_OFFERTE.ULL_LNA.id, 
                									$rootScope.MAP_OFFERTE.ULL_LA.id, 
                									$rootScope.MAP_OFFERTE.ULLD_LNA.id, 
                									$rootScope.MAP_OFFERTE.ULLD_LA.id,
                									$rootScope.MAP_OFFERTE.SLU_LNA.id,
                									$rootScope.MAP_OFFERTE.SLU_LA.id];
                
                
                if(_arrayOfferteDisaggregazione.indexOf($scope.data.step3.offerta.idOfferta) > -1){
                	$scope.timeSlotPresaAppuntamento["05"] = "17:00 - 19:00";
                }
        }

        $scope.loadStep1 = false;
        $scope.loadOLO = false;
        $scope.loadStep2 = false;
        $scope.loadStep3 = false;
        $scope.loadStep4 = false;
        $scope.loadStep5 = false;
        $scope.loadStep6 = false;
        $scope.loadStep7 = false;
        $scope.loadStep8 = false;
        $scope.loadProfiloTecnicoLinea = false;
        $scope.errColl = true;
        $scope.vcCount = 1;
        $scope.vcUser = 1;
        $scope.caricaPassFive = false;
        $scope.integerval = /^\d*$/;
        $scope.alphanumeric = /^[a-zA-Z0-9 ]*$/i;
        $scope.codRegExp = /^[a-zA-Z0-9-_:*,\/]*$/i;
        $scope.NANval = /^([^0-9]*)$/;
        // language=JSRegexp
         $scope.onlyChar = /^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$/;
        $scope.openPanelRiepilogo = {
            step1: true,
            step2: false,
            step3: false,
            step4: false,
            step5: false,
            step6: false,
            step7: false,
            closeOthers: true
        };
        if(!$rootScope.eightStepToVar){
        	$rootScope.eightStepToVar = false;}
        
        $rootScope.pageClass = 'nuovo-ordine';

        if (!$rootScope.data) {

            $log.info("azzera ordine");
            $rootScope.data = {};
            $rootScope.formData = {};
            $state.go('root.ordini.new.step1');
        }

        $scope.returning = $stateParams.returning;
        $scope.operazione = $stateParams.operazione || 'comune';
        $scope.step = $stateParams.step || 1;
        $rootScope.formData.stepReached = $rootScope.formData.stepReached || 0;
        $scope.closeOthersAccordion = true;
        $scope.referentView = [true, false, false, false];
        $scope.datiFinalView = [true, false];
        $scope.datiVcView = [true, false];
        $scope.datiVlanView = [true, false];
        $rootScope.dacValidato = false;
        $rootScope.dacValidato = false;
        $rootScope.dacMessaggioErrore = null;
        $scope.viewBotBozza = true;
		
        $scope.data = $rootScope.formData || {};

        // MODALE - SALVO BOZZA
        $scope.salvaBozza = function (tipoSalvataggio) {
        	var contenutoNoteBozza;
            if ($rootScope.bozza) {
                contenutoNoteBozza = $rootScope.bozza.noteBozza;
            } else {
                contenutoNoteBozza = "";
            }

            $scope.modalSalvaBozza = {
                headerText: 'Salva',
                contentType: 'table_widthInput',
                scope: $scope,
                actionButtonText: 'Salva Ordine',
                closeButtonText: 'Annulla',
                textLabel2: 'Note',
                textError: false,
                textInput: contenutoNoteBozza,
                callbackFunction: 'datiOrdineCallbackBozza'
            };
            $scope.tipoSalvataggio = tipoSalvataggio;

            modalService.showModal({}, $scope.modalSalvaBozza);
        };
        //VALIDA BOZZA PER PASSAGGIO 4
        $scope.validaBozza = function () {
            $scope.salvaBozza();
        };

        $scope.datiOrdineCallbackBozza = function (testoNota) {

            // prendo i dati della form
            var salvoBozza = {};
            var itemParameterValue = testoNota;
            if($rootScope.bozza && !testoNota){
            	itemParameterValue = $rootScope.bozza.noteBozza;
            } 

            $rootScope.data.step4 = (($scope.data.step4 && !_.isEmpty($scope.data.step4)) ? $scope.data.step4 : $rootScope.data.step4);
            $rootScope.data.step5 = (($scope.data.step5 && !_.isEmpty($scope.data.step5)) ? $scope.data.step5 : $rootScope.data.step5);
            $rootScope.data.step6 = (($scope.data.step6 && !_.isEmpty($scope.data.step6)) ? $scope.data.step6 : $rootScope.data.step6);
            $rootScope.data.step7 = (($scope.data.step7 && !_.isEmpty($scope.data.step7)) ? $scope.data.step7 : $rootScope.data.step7);
            $rootScope.data.step8 = (($scope.data.step8 && !_.isEmpty($scope.data.step8)) ? $scope.data.step8 : $rootScope.data.step8);
            salvoBozza.data = $rootScope.data;


            if ($rootScope.customizedOffer) {
                salvoBozza.customizedOffer = $rootScope.customizedOffer;
            }

            // converto i dati in stringa
            var dataBozza = JSON.stringify(salvoBozza);
            $log.info("modifico Bozza");
            // SALVATAGGIO BOZZA
            $scope.CasualeOrdineUppercase = $scope.data.step1.causale_ordine.replace(/\b\w/g, function(l){ return l.toUpperCase() });
            if ($scope.tipoSalvataggio === "aggiorna") {
                $log.info("modifico Bozza");
                 salvoBozza = Draft.mod({
                	codOloAgcom: $scope.data.step1.operatore.codiceOLO,
					codOrdineOloNew: $scope.data.step1.codice_ordine,
                    codOrdineOlo: $rootScope.codOrdineOloBozza,
                    ordineBozza: dataBozza,
                    tipologiaLavorazione: $scope.CasualeOrdineUppercase,
                    note: itemParameterValue,
                    operationType: "UPDATE"
                });
            } else {
                $log.info("inserisco Bozza");
                 salvoBozza = Draft.save({
                	codOloAgcom: $scope.data.step1.operatore.codiceOLO,
                	codOrdineOlo: $scope.data.step1.codice_ordine,
                    ordineBozza: dataBozza,
                    tipologiaLavorazione: $scope.CasualeOrdineUppercase,
                    note: itemParameterValue,
                    operationType: "CREATE"
                });
            }

            salvoBozza.$promise.then(
                function (data) {
                    if (data.result.code === '0') {
                        $log.info("BOZZA SALVATA");
                        $scope.erroreService("Bozza salvata correttamente");
                        $rootScope.formData = {};
                        $rootScope.data = {};
                        $state.go('root.ordini.bozza');
                    } else if (data.result.code === '2') {
                        $scope.erroreService("Il Codice Ordine della Bozza è già esistente");
                    } else {
                        $scope.erroreService("Impossibile salvare la bozza");
                    }

                },
                function (reason) {
                    $log.info("BOZZA NON SALVATA :" + reason);
                    modalService
                        .showModal({}, {
                            headerText: "Errore",
                            bodyText: "Non e' stato possibile salvare la Bozza dell'Ordine. Riprovare piu' tardi.",
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });
                });

        };

        // FINE SALVATAGGIO BOZZA
        //      SE L'OFFERTA è REGOLATORIO O WLR O SHA DEVE AVERE 8 STEP IN VARIAZIONE SE NO 6
        $scope.sceltaOffertaForStep = function(offertaSelezionata){
        	var nomeOfferta = offertaSelezionata.nomeOffertaCatalogo;
            
            $rootScope.eightStepToVar = (nomeOfferta === "WLR") || (nomeOfferta === "SLU") || (nomeOfferta === "SLUDati") || (nomeOfferta === "ULL") || (nomeOfferta === "ULLDati") || (nomeOfferta === "SHA") && ($rootScope.data.step1.causale_ordine === 'variazione');
        };
        //  CREO OGGETTO PER VARIAZIONE PER I DATI CHE ATTIVANO DAL DETTAGLIO 
        $scope.datiVariazioneDaAsset = function(){
            
        	$rootScope.DettaglioAsset = {};
        	
        	var mapSLAASSURANCE={
        			'D':'Copertura Oraria H.24',
        			'E':'Copertura Oraria Saturday',
        			'F':'Copertura Oraria FAST',
        			'G':'Copertura Oraria GOLD',
        			'0':'Base'
        			};
        	var mapMODALITACONSEGNA={
        			'0':'Dinamico L2TP',
        			'1':'Dinamico Virtual Dial UP',
        			'2':'Statico Virtual Dial UP',
        			'3':'Statico LAN 8 Virtual Dial UP',
        			'4':'Statico LAN 16 Virtual Dial UP'
        			};
        	var mapFonia={
        			'1':'POTS',
        			'2':'ISDN BRA',
        			'3':'ISDN PRA'
        			};
        	var mapDati={
        			'4':'ADSL',
        			'5':'HDSL',
        			'9':'SDSL',
        			'10':'VDSL'
        			};
        	
        	var modalitaconsegnaValue=['Dinamico L2TP','Dinamico Virtual Dial UP','Statico Virtual Dial UP','Statico LAN 8 Virtual Dial UP','Statico LAN 16 Virtual Dial UP'];
        	
        	if(!$rootScope.data.step4){
        		$rootScope.data.step4={};
        	}
         
        	$rootScope.data.step4.vcItems=[];
        	
        	if($rootScope.DettaglioAssetUSER){
        		delete $rootScope.DettaglioAssetUSER;
        	}
        	if($rootScope.DettaglioAssetVC){
        		delete $rootScope.DettaglioAssetVC;
        	}
        	//non ci sta nei servizi andrà controllato nel JSON
        	if($rootScope.formData.data.step2.fromVariazione.codSlaAssurance && $rootScope.customizedOffer.offerTopDetails){
        		$rootScope.customizedOffer.offerTopDetails['SLAASSURANCE'].dft=mapSLAASSURANCE[$rootScope.formData.data.step2.fromVariazione.codSlaAssurance];
        	}
        	angular.forEach($rootScope.formData.data.step2.fromVariazione.servizi, function (value) {
        		if((value.prodotto.indexOf('ACCESSO')!== -1) || (value.prodotto.indexOf('PROTOCOLLO')!== -1)){
        			angular.forEach(value.customizzazione, function(item) {
        				if(item.attribute==='INDICATOREDIASSURANCE' || item.attribute==='SLAPROVISIONING' ){
        					item.value=(item.value==='S' || item.value==='Y')?1:0;
        				}
        				if(item.attribute==='SELEZIONEPASSANTE'){
        					item.value=(item.value==='1')?'con selezione passante':'senza selezione passante';
        				}
        				if(item.attribute==='MODULAZIONE' && (item.value!=='Interleaved'&& item.value!=='Fast')){
        					item.value=(item.value==='1')?'Fast':'Interleaved';
        				}
        				if(item.attribute==='ACCESSONUMERICO'){
        					item.value=(item.value==='1')?'accesso numerico 2Mb/s':'accesso analogico';
        				}
        				if((item.attribute==='MODALITACONSEGNA')&&(modalitaconsegnaValue.indexOf(item.value)===-1)){
        					//SM_9625
        					item.value=(mapMODALITACONSEGNA[item.value] ? mapMODALITACONSEGNA[item.value] : '');
        				}
        				if(item.attribute==='CODEVLANSINGLETAG'){
        					item.attribute='CVLANID';
        				}
        				if(item.attribute==='DESTINAZIONEUSO'){
        					var valoreDestinazioneUso= item.value.split('|');
        					for( var i=0; i<=valoreDestinazioneUso.length;i++){
        						if(mapFonia[valoreDestinazioneUso[i]]){
        							$rootScope.data.step4.destinazione_uso_fonia_check=true;
        							if($rootScope.customizedOffer.offerTopDetails.DESTINAZIONEUSOFONIA) $rootScope.customizedOffer.offerTopDetails.DESTINAZIONEUSOFONIA.dft =mapFonia[valoreDestinazioneUso[i]];
        						}else if(mapDati[valoreDestinazioneUso[i]]){
                                    if($rootScope.customizedOffer.offerTopDetails.DESTINAZIONEUSODATI) $rootScope.customizedOffer.offerTopDetails.DESTINAZIONEUSODATI.dft =mapDati[valoreDestinazioneUso[i]];
        							$rootScope.data.step4.destinazione_uso_dati_check=true;
        						}
        					}
        				}
        				
        				//SM_9329
        				if(item.attribute==='INTERMEDIATEAGENTFULL'){
        					if(item.value === 'SI'){
        						item.value = 'Y';
        					}
        					if(item.value === 'NO'){
        						item.value = 'N';
        					}
        				}
        				
            			if($rootScope.customizedOffer.offerBotDetails[item.attribute]){
            				$rootScope.customizedOffer.offerBotDetails[item.attribute].dft = item.value;
            			}
            			if($rootScope.customizedOffer.offerTopDetails[item.attribute]){
            				$rootScope.customizedOffer.offerTopDetails[item.attribute].dft = item.value;
            			}
                    });
        		}
	        	
        		if(value.prodotto.indexOf('USERVLAN')!== -1){
        			var tempUser={};
        			if(!$rootScope.data.step4.vlanusers){
        				$rootScope.data.step4.vlanusers=[];
	        				if($rootScope.data.step4.vcItems){
	        					delete $rootScope.data.step4.vcItems;
	        				}
        			}

        			angular.forEach(value.customizzazione, function(item) {
        				if(item.attribute==='CODEVLANSINGLETAG' || item.attribute==='USERVLANID' || item.attribute==='CVLANID'){
        					item.value=parseInt(item.value);
        				}
        				
        				if(item.attribute==='BANDAPICCODOWN'){
        					if(!tempUser['banda_picco']){
        						tempUser['banda_picco']={};
        					}
            				tempUser['banda_picco'].down=item.value;
        				}
        				
        				if(item.attribute==='BANDAPICCOUP'){
        					if(!tempUser['banda_picco']){
        						tempUser['banda_picco']={};
        					}
            				tempUser['banda_picco'].up=item.value;
        				}
        				
        				if((item.attribute==='CODEVLANSINGLETAG' || item.attribute==='CVLANID')){
        					tempUser['codice_vlan']=item.value;
        					item.attribute='CVLANID';
        				}        				
        				
        				if($rootScope.data.step3 && $rootScope.data.step3.offerta && $rootScope.MAP_OFFERTE.GBE_SF.id === $rootScope.data.step3.offerta.idOfferta &&  item.attribute==='USERVLANID'){
        					item.attribute='USERVLAN';
        					item.value=parseInt(item.value);
        				}

        				tempUser.readOnly=true;
        				tempUser[item.attribute]={};
        				tempUser[item.attribute].dft=(item.value)?item.value:null;
        			});
        			
        			if($rootScope.customizedOffer.offerTopDetails["ENCAPSULATION"] && ($rootScope.customizedOffer.offerTopDetails["ENCAPSULATION"].dft === "SINGLETAG") && tempUser['SVLANCODE']){
        				tempUser['codice_vlan'] = tempUser['SVLANCODE'].dft;
        				tempUser['SVLANCODE'].dft = "";
        			} else {
        				tempUser['codice_vlan'] = "";
        			}
        			if(!$rootScope.bozza || ($rootScope.bozza && $scope.bozza.azzerata)){
        			tempUser.id=($rootScope.data.step4.vlanusers.length+1);
        				$rootScope.data.step4.vlanusers.push(tempUser);
	        			delete $rootScope.DettaglioAssetUSER;
	        			$rootScope.DettaglioAssetUSER = angular.copy($rootScope.data.step4);
        			} else {
        				if(!$rootScope.DettaglioAssetUSER){
        					$rootScope.DettaglioAssetUSER ={};
            				$rootScope.DettaglioAssetUSER.vlanusers = [];
        				}
        				$rootScope.DettaglioAssetUSER.vlanusers.push(tempUser);
        			}
        			
        			
        		}
        		if(value.prodotto.indexOf('VC')!== -1){
        			var tempVc={};
        			if(!$rootScope.data.step4.vcItems){
        				$rootScope.data.step4.vcItems=[];
        			}
        			angular.forEach(value.customizzazione, function(item) {
        				if(item.attribute==='VCI' || item.attribute==='VPI' || item.attribute==='DLCI'){
        					item.value=parseInt(item.value);
        				}
        				
        				if(item.attribute==='CVLANID'){
        					tempVc['CVLANIDVLAN']={};
        					tempVc['CVLANIDVLAN'].dft=parseInt(item.value);
        				}
        				
        				if(item.attribute==='IPDSLAM'){
        					var parts = item.value.split(".");
        					tempVc.dslam_ip_1=parseInt(parts[0]) || 0;
        					tempVc.dslam_ip_2=parseInt(parts[1]) || 0;
        					tempVc.dslam_ip_3=parseInt(parts[2]) || 0;
        					tempVc.dslam_ip_4=parseInt(parts[3]) || 0;
        				}
        				
        				if(item.attribute==='IPKIT'){
        					var partsIPKIT = item.value.split(".");
        					tempVc.kit_ip_1=parseInt(partsIPKIT[0]) || 0;
        					tempVc.kit_ip_2=parseInt(partsIPKIT[1]) || 0;
        					tempVc.kit_ip_3=parseInt(partsIPKIT[2]) || 0;
        					tempVc.kit_ip_4=parseInt(partsIPKIT[3]) || 0;
        				}
        				
        				tempVc[item.attribute]={};
        				tempVc[item.attribute].dft=item.value;
        			});
        			tempVc.readOnly=true;
        			if(!$rootScope.bozza || ($rootScope.bozza && $scope.bozza.azzerata)){
        				tempVc.id=($rootScope.data.step4.vcItems.length+1);
        				$rootScope.data.step4.vcItems.push(tempVc);
        				$rootScope.DettaglioAssetVC = angular.copy($rootScope.data.step4);
        			}else{
        				$rootScope.data.step4.vcItems = $rootScope.vcItems;
        				if(!$rootScope.DettaglioAssetVC){
        				$rootScope.DettaglioAssetVC ={};
        				$rootScope.DettaglioAssetVC.vcItems = [];
        				}
        				$rootScope.DettaglioAssetVC.vcItems.push(tempVc);
        			}

        			if(($scope.data.step3 && $scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta) && $rootScope.MAP_OFFERTE && ($rootScope.MAP_OFFERTE.EASY_BL.id === $scope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.EASY_SL.id === $scope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.EASY_BF.id === $scope.data.step3.offerta.idOfferta || $rootScope.MAP_OFFERTE.EASY_SF.id === $scope.data.step3.offerta.idOfferta)){
        				angular.forEach($rootScope.data.step4.vcItems[0], function(value, key) {
            				if($rootScope.customizedOffer.offerBotDetails[key]){
            					$rootScope.customizedOffer.offerBotDetails[key].dft = value.dft;
            				}
            				});
        	    	}

        		}		
            });
        	
        	//aggiunti i campi non sono 
        	$rootScope.DettaglioAsset = angular.copy($rootScope.customizedOffer);
        };
      // C11M08F49 – Verifica Ticket TTM (S6)
        //RU_995
        $scope.verificaTicketTTM = function(idTicketTTM, idRisorsa){
        	verificaTicketTTM.get({idTicketTTM: idTicketTTM, idRisorsa: idRisorsa}).$promise.then(
        			function(data) {
						if (data.esito === "OK") {
							$state.go($scope.checkNextState());
						} else {
							$scope.erroreService("ID Ticket TTM inesistente oppure non compatibile con la richiesta");
						}
        			},
						function() {
        					$scope.erroreService("ID Ticket TTM inesistente oppure non compatibile con la richiesta");
							}
        			);
        };
     // C11M08F16 – Verifica Ordine in Ambito 
        $scope.VerificaAmbito = function(locatorQuery){
	
			// ------------- riattivare solo se si disattiva chiamata al system locator ------------------------------------ 
			//
			// if($scope.data.step7.dac){
			// 	if($rootScope.dacValidato){
			// 		$rootScope.formData.data.step7 = $scope.data.step7;
			// 		$state.go($scope.checkNextState());	
			// 	}
			// }else{
			// 	$rootScope.formData.data.step7 = $scope.data.step7;
		    //     $state.go($scope.checkNextState());
			// }	

			// C11M08F16 - Verifica ordine in ambito
			if(!$rootScope.OSCURAMENTI.RU_1612.oscurato) {
				Locator.save(locatorQuery,
						function(data) {
							if (data.esito === "OK") {
								if($scope.data.step7.dac){
									if($rootScope.dacValidato){
										$rootScope.formData.data.step7 = $scope.data.step7;
										$state.go($scope.checkNextState());	
									}
								}else{
									$rootScope.formData.data.step7 = $scope.data.step7;
									$state.go($scope.checkNextState());
								}
							} else {
								$scope.erroreService(data.descrizione);
							}
						},
						function(error) {
							$log.debug(error);
							$scope.erroreService("Impossibile Verifica Ordine in Ambito");
						});
			}
        };
        //        CONTROLLO ID RISORSA ASSET PER VARIAZIONE E MIGRAZIONE
        $scope.controlloAsset = function(azzera) {
        	if(azzera && ($rootScope.bozza && $rootScope.bozza.customizedOffer)){
        		$rootScope.bozza.azzerata = true;
        	}
        	//controllo ID Risorsa inoltre la C11M08F37 viene effettuata da FE 
        	//RU_1060
        	if($scope.data.step1.causale_ordine === 'variazione' || $scope.data.step1.causale_ordine === 'migrazione'){
        		$scope.messaggioErroreIdRisorsa = null;
        		$scope.loadStep2=true;
	        	if(!$scope.data.step2.idAssetScelto){
	        	
	        		//SM_9602
	        		var codOLO = null;
	        		if($scope.data.step1.causale_ordine === 'migrazione'){
	        			codOLO = $scope.data.step2.oaoDonating1;
	        		}else{
	        			codOLO = $scope.data.step1.operatore.codiceOLO;
	        		}
	        		RecuperaIdAsset.get({codAgcom: codOLO, idRisorsa:$scope.data.step2.id_risorsa, azione: $rootScope.data.step1.causale_ordine}).$promise.then(
	                        function (response) {
	                        	
	                        	if(response.esito=='OK'){
	                    			$rootScope.modalOptionsTabellaDatiOrdineAsset = {
	            		            headerText: 'Seleziona un Asset',
	            		            actionButtonText: null,
	            		            closeButtonText: 'Ok',
	            		            contentType: 'modale_nowtable',
	            		            scope: $scope,
	            		            recuperoIdAssetCall:false,
	            		            callbackFunction: 'ricercaIDAssetCallback',
	            		            dataHeader: [
	                                             {"key": "idAsset", "value": "Id Asset", "type": "text"},
	                                             {"key": "idRisorsa", "value": "Id Risorsa", "type": "text"},
	                                             {"key": "numeroTelefonico", "value": "Numero Telefonico", "type": "text", "sort":"number"},
	                                             {"key": "numeroFittizio", "value": "Numero Fittizio", "type": "text", "sort": "number"},
	                                             {"key": "offerta", "value": "offerta", "type": "text"}
	                                        ],
	            		            templateUrl: 'app/common/templates.html'
	                    			};
	                        		$rootScope.modalOptionsTabellaDatiOrdineAsset.data=response.data;
		                        	modalService.showModal({}, $rootScope.modalOptionsTabellaDatiOrdineAsset);
	                        	}else{
	                        		//SM_9606                      		
	                        		$scope.messaggioErroreIdRisorsa = "Impossibile caricare i relativi Asset";
	                        	}
	                        	
//	                        	$scope.showSpinnerResetVar SERVE PER STOPPARE LA ROTELLA SU IL RIPRISTINO DEI DATI DELLA VARIAZIONE
	                        	$scope.showSpinnerResetVar = false;
	                        },
	                        function (error) {
	                        	$scope.loadStep2=false;
	                            $log.debug(error);
	                            $scope.messaggioErroreIdRisorsa = "Impossibile caricare i relativi Asset";
	                        });
	        	}else{
	        		$rootScope.modalOptionsTabellaDatiOrdineAsset.recuperoIdAssetCall=false;
	        		$scope.ricercaIDAssetCallback($scope.data.step2.idAssetScelto);
	        	}
        	}
        	
            $rootScope.formData.data.step2 = $rootScope.data.step2;
            $scope.controlloBozza(3);
            
            //RU_1060
            if($scope.data.step1.causale_ordine !== 'variazione' && $scope.data.step1.causale_ordine !== 'migrazione'){
            	$state.go($scope.checkNextState());
            }
        };
        
        $scope.recuperoIdAssetNew = function($event){
        	$event.preventDefault();
    		if(!$rootScope.modalOptionsTabellaDatiOrdineAsset){
			$rootScope.modalOptionsTabellaDatiOrdineAsset = {
		            headerText: 'Seleziona un Asset',
		            actionButtonText: null,
		            closeButtonText: 'Ok',
		            contentType: 'modale_nowtable',
		            scope: $scope,
		            recuperoIdAssetCall:false,
		            callbackFunction: 'ricercaIDAssetCallback',
		            dataHeader: [
                                 {"key": "idAsset", "value": "Id Asset", "type": "text"},
                                 {"key": "idRisorsa", "value": "Id Risorsa", "type": "text"},
                                 {"key": "numeroTelefonico", "value": "Numero Telefonico", "type": "text", "sort":"number"},
                                 {"key": "numeroFittizio", "value": "Numero Fittizio", "type": "text", "sort": "number"},
                                 {"key": "offerta", "value": "offerta", "type": "text"}
                            ],
		            templateUrl: 'app/common/templates.html'
		        };
    		}
        	$rootScope.modalOptionsTabellaDatiOrdineAsset.recuperoIdAssetCall=true;
        	modalService.showModal({}, $rootScope.modalOptionsTabellaDatiOrdineAsset);
        };

        $scope.assegnaContratto = function(idContratto){
            angular.forEach($rootScope.formData.contracts, function(value) {
                // non cambiare == uno è stringa uno è intero
                if(value.idContratto == idContratto){
                    $scope.data.step2.contratto=value;
                }
            });
		};
        $scope.ricercaIDAssetCallback = function (item) {
        	$scope.data.step2.idAssetScelto=item;
        	//SM_10677
        	if($scope.data.step1.causale_ordine !== 'migrazione'){
        		$scope.data.step2.id_risorsa = item.idRisorsa;
        	}        	
        	Assets.get({id: item.idAsset, paramName:'idAsset', consistenza:'N'}).$promise.then(
                    function (response) {
                        if (response.result && response.result.code === '2') {
                            $scope.loadStep2=false;
                            $scope.messaggioErroreIdRisorsa = response.result.message;
                        } else {
                            $scope.assetDetail = response;
                            $scope.data.assetDetail = response;
                            $scope.data.step2.fromVariazione=$rootScope.data.step2.fromVariazione=response;
                            $scope.sceltaOffertaForStep(response);
                            
                        	//RU_1213
                        	if($scope.assetDetail.idOfferta == $rootScope.MAP_OFFERTE.FEEDER.id){
                        		$scope.erroreService("Lavorazione al momento non disponibile");
                        		return;
                        	}
                            
                            //SM_10116
                            if($scope.data.step1.causale_ordine == 'migrazione' && $scope.data.assetDetail.whiteList){
                            	$scope.data.step1.whiteList = $scope.data.assetDetail.whiteList;
                            }

                            if(!$scope.data.step2.contratto && ($scope.data.assetDetail.statoContratto !== "Inactive")){
                                $scope.data.step2.contratto= $scope.data.assetDetail.identificativoContratto;
                                $scope.assegnaContratto($scope.data.assetDetail.identificativoContratto);

						   if(!$scope.data.step2.contratto){
                                     $scope.messaggioErroreIdRisorsa="Impossibile proseguire: il contratto associato alla risorsa selezionata non e' valido";
                                      $scope.loadStep2=false;
                                      return;
								 }
                            }
                            
                         /*if (response.statoAsset !== "ATTIVO") {
                                $scope.messaggioErroreIdRisorsa = "l’ID Risorsa inserita non può essere utilizzata per l’operazione richiesta";
							 }else */
							if (response.tipoServizio === "NP") {
								$scope.messaggioErroreIdRisorsa = "L'ID Risorsa inserito corrisponde ad un ASSET di NUMBER PORTABILITY e non puo' essere utilizzato per l’operazione richiesta";
								return;
							 }
							//SM_9011
							else if(response.tipoServizio === "CPS" && $rootScope.data.step1.causale_ordine == "variazione"){
								$scope.erroreService("Per la consistenza selezionata non e' possibile procedere ad una lavorazione di tipo Variazione.");
								$scope.messaggioErroreIdRisorsa = "Selezionare risorsa valida";
								return;
							}
							
							//SM_10740
							//SM_10742
            				var _state = "";
            				if($state.includes('**.listareport.**')){
								_state = "root.ordini.listareport.dettaglio.asset.new.step3"
							}else{
								_state = "root.ordini.new.step3"
							}
							
						//SM_9616 -> Fix per servizio da richiamare solo in caso di variazione
						 if(!$scope.messaggioErroreIdRisorsa && $scope.data.step1.causale_ordine=='variazione'){
							
                                $scope.loadStep2=true;
                                //        C11M08F45 – Verifica Contratto per Variazione
                                var codOLO = $scope.data.step1.operatore.codiceOLO;
                             	   checkVariazione.get({codAgcom: codOLO, idAsset : $scope.assetDetail.idAsset}).$promise.then(
                             			   function (response) {
                             				   if (response.esito === "OK") {

                                                   /**
													* SM7628 16/07/2018 Cassiopea
                                                    */
                                                   //SM_10903
                             				   	if((["Inactive", "Expired"].indexOf($scope.data.assetDetail.statoContratto) > -1) && response.idContratto){
                                                    $rootScope.formData.data.step2.fromVariazione.identificativoContratto = response.idContratto;
                                                    $scope.assegnaContratto(response.idContratto);
												}
                             					   if(!$rootScope.modalOptionsTabellaDatiOrdineAsset.recuperoIdAssetCall){
                             						   $state.go(_state);
                             					   }
                             				   } else {
                             					  $scope.erroreService(response.descrizione); //FWA - Task #18285
                             				   }
                             			   }, function (){
                             				  $scope.erroreService("Errore Verifica Contratto per Variazione");
                             	});
                            }else{
                            	$state.go(_state);
                            }
                        }
                    },
                    function (error) {
                    	$scope.loadStep2=false;
                        $log.debug(error);
                        $scope.messaggioErroreIdRisorsa = "Impossibile verificare l'ID Risorsa inserita";
                    });
        };
        
        
        
        $scope.valida = function (form) {
            $scope.caricaPassFive = true;
            var forms = [form];
            if (form && (form.$name === 'configurazioneOffertaForm')
                && ($scope.data.step3.tipologia_ordine === 'nga-vula')) {
                forms = [form.catalogo, form.utenti_vlan];
            }

            angular.forEach(forms, function (formItem) {
                angular.forEach(formItem && formItem.$error.required,
                    function (field) {
                        field.$setDirty();
                        $scope.caricaPassFive = false;
                    });
                if($scope.caricaPassFive){
                	angular.forEach(formItem && formItem.$error.maxlength,
                	    function (field) {
               	 	    field.$setDirty();
               	 	    $scope.caricaPassFive = false;
               		});
                }
                if($scope.caricaPassFive){
                	angular.forEach(formItem && formItem.$error.minlength,
                         function (field) {
                         field.$setDirty();
                         $scope.caricaPassFive = false;
                    });
                } 
                if($scope.caricaPassFive){
                	angular.forEach(formItem && formItem.$error.number,
                         function (field) {
                         field.$setDirty();
                         $scope.caricaPassFive = false;
                    });
                }   
                if($scope.caricaPassFive){
                	angular.forEach(formItem && formItem.$error.pattern,
                         function (field) {
                         field.$setDirty();
                         $scope.caricaPassFive = false;
                    });
                }  
            });
        };
        $scope.goTo = function (state) {
			if(!state){
				var _currentState = $state.current.name;
			
				var _baseUrlReport = "root.ordini.listareport.dettaglio.asset.new";
				var _baseUrlOrder = "root.ordini.new";
				
				var _nextState = '';
				
				switch(_currentState){
					case _baseUrlOrder + '.step2':
						_nextState =  _baseUrlOrder + '.step1';
					break;
					case _baseUrlOrder +'.step3':
						_nextState =  _baseUrlOrder + '.step2'
					break;
					case _baseUrlOrder + '.attivazione-configurazione':
						_nextState =  _baseUrlOrder + '.step3'
					break;
					case _baseUrlOrder + '.step5':
						_nextState =  _baseUrlOrder + '.attivazione-configurazione'
					break;
					case _baseUrlOrder + '.step6':
						_nextState =  _baseUrlOrder + '.step5'
					break;
					case _baseUrlOrder + '.step7':
						if($rootScope.data.step1.causale_ordine == 'variazione'){
							_nextState =  _baseUrlOrder + '.attivazione-configurazione'
						}else{
							_nextState =  _baseUrlOrder + '.step6'
						}
					break;
					case _baseUrlOrder + '.step8':
						_nextState =  _baseUrlOrder + '.step7'
					break;	
					
					
					case _baseUrlOrder + '.cessazione.step2':
						_nextState =  _baseUrlOrder + '.cessazione';
					break;
					case _baseUrlOrder + '.cessazione.step3':
						_nextState =  _baseUrlOrder + '.cessazione.step2';
					break;
					case _baseUrlOrder + '.cessazione.riepilogo':
						_nextState =  _baseUrlOrder + '.cessazione.step3';
					break;
					case _baseUrlOrder + '.cessazione.conferma':
						_nextState =  _baseUrlOrder + '.cessazione.riepilogo';
					break;	
									
					
					case _baseUrlReport + '.step2':
						_nextState =  _baseUrlReport + '.step1';
					break;
					case _baseUrlReport +'.step3':
						_nextState =  _baseUrlReport + '.step2'
					break;
					case _baseUrlReport + '.attivazione-configurazione':
						_nextState =  _baseUrlReport + '.step3'
					break;
					case _baseUrlReport + '.step5':
						_nextState =  _baseUrlReport + '.attivazione-configurazione'
					break;
					case _baseUrlReport + '.step6':
						_nextState =  _baseUrlReport + '.step5'
					break;
					case _baseUrlReport + '.step7':
						if($rootScope.data.step1.causale_ordine == 'variazione'){
							_nextState =  _baseUrlReport + '.attivazione-configurazione'
						}else{
							_nextState =  _baseUrlReport + '.step6'
						}
					break;
					case _baseUrlReport + '.step8':
						_nextState =  _baseUrlReport + '.step7'
					break;	
					
					case _baseUrlReport + '.cessazione.step2':
						_nextState =  _baseUrlOrder + '.cessazione';
					break;
					case _baseUrlReport + '.cessazione.step3':
						_nextState =  _baseUrlOrder + '.cessazione.step2';
					break;
					case _baseUrlReport + '.cessazione.riepilogo':
						_nextState =  _baseUrlOrder + '.cessazione.step3';
					break;
					case _baseUrlReport + '.cessazione.conferma':
						_nextState =  _baseUrlOrder + '.cessazione.riepilogo';
					break;				
				}
				
				$state.go(_nextState, {
                	'returning': true
            	});		
				
			}else{
				$state.go(state, {
                	'returning': true
            	});	
			}
        };
        // FUNZIONE ANNULLA

        $scope.confermaAnnulla = function () {
            modalService.showModal(
                {},
                {
                    headerText: "Vuoi annullare l'ordine?",
                    closeButtonText: 'Chiudi',
                    bodyText: "I dati inseriti nell'ordine saranno cancellati.",
                    actionButtonText: 'Continua',
                    scope: $scope,
                    callbackFunction: 'annulla',
                    type: 'success'
                });
            $scope.caricaPassFive = false;
        };

        $scope.annulla = function () {
            $rootScope.formData = {};
            $rootScope.data = {};
            $scope.draftOrder = null;
            $state.params.order = null;
            $rootScope.bozza = null;
            
        	////////
            var _state = "";
            if($state.includes('**.listareport.**')){
				_state = "root.ordini.listareport";
			}else{
				_state = "root.ordini.lista";
			}            
            $state.go(_state);
        };
        // FUNZIONE AZZERA VARIAZIONE
        
        $scope.azzeraVariazione = function () {
        	modalService.showModal(
        			{},
        			{
        				headerText: "Vuoi ripristinare i dati?",
        				closeButtonText: 'Chiudi',
        				bodyText: "I dati inseriti nell'ordine saranno cancellati.",
        				actionButtonText: 'Continua',
        				scope: $scope,
        				callbackFunction: 'azzeraDatiVariazione',
        				type: 'success'
        			});
        	  };
        
        $scope.azzeraDatiVariazione = function () {
        	$scope.showSpinnerResetVar = true;
    		$rootScope.formData.step3 = $rootScope.formData.step4 = $rootScope.formData.step5 = $rootScope.formData.step6 = $rootScope.formData.step7 = $rootScope.formData.step8 ={};
    		$scope.data.step3 = $scope.data.step4 = $scope.data.step5 = $scope.data.step6 = $scope.data.step7 = null;
    		$rootScope.data.step3 = $rootScope.data.step4 = $rootScope.data.step5 = $rootScope.data.step6 = $rootScope.data.step7 = null;
    		$rootScope.formData.stepReached = 2;
//    		richiamo controllo Id Asset
    		$scope.controlloAsset('azzera');
        };

        $scope.vcCount = 1;
        $scope.vcs = [{
            id: '1'
        }];

        $scope.aggiungiVC = function (vcItems) {
            $scope.data.step4.vcItems.push({
                'id': parseInt(vcItems[vcItems.length-1].id) + 1
            });
        };

        $scope.eliminaVc = function (vcusers, vcIndex) {
            vcusers.splice(vcIndex, 1);
            $scope.data.step4.vcItems = vcusers;
        };

        // funzioni per configurazione offerta - GBE
        $scope.limitValue = function (v, limit) {
        	if(!v){
        		return 0;
        	}
        	var val = v;
            if (v.length > limit) {
                val = val.slice(0, limit);
            }
            return parseInt(val);
            
        };
        /* Apertura Accordion VC IN COMUNE TRA ATM e GBE */
        $scope.apriVc = function (form) {

            var forms = [form];

            angular.forEach(forms, function (formItem) {
                var open = true;
                angular.forEach(formItem.$error.required,
                    function (field) {
                        if (field.$invalid) {
                            open = false;
                        }
                    });

                if (open) {
                    $scope.datiVcView = [false, true];
                } else {
                    $scope.datiVcView = [true, false];
                }
            });

        };
        $scope.ControlloValoreSLAConsistenza = function(){
        	$rootScope.DettaglioChangeKO = $rootScope.customizedOffer.offerTopDetails.SLAASSURANCE.dft === $rootScope.DettaglioAsset.offerTopDetails.SLAASSURANCE.dft;
        };

        $scope.checkValidation = function (form) {
            if (form.$invalid) {
                modalService
                    .showModal(
                    {},
                    {
                        headerText: "Attenzione",
                        bodyText: "Completa la sezione \"Catalogo\" per poter aprire questa sezione.",
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });

            }
        };

        // PROFILOTECNICOLINEA
        $scope.configurazioneOffertaCallbackProfilotecnicoLinea = function (item) {

            if (!$scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA) {
                $scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA = {};
                $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA = {};
            }

            $scope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft = item.profiloTecnicaLinea;
            $rootScope.customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft = item.profiloTecnicaLinea;
            if (item.protocollo && $rootScope.data.step1.causale_ordine !== 'variazione' ){ //SM_8252
                if (item.protocollo!=='FR'){
                    $scope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft = 'ATM';
                    $rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft = 'ATM';
                }else{
                    $scope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft = item.protocollo;
                    $rootScope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft = item.protocollo;
                }
            }
            $rootScope.profiloCommercialeDown = item.profiloCommercialeDown;
            $rootScope.profiloCommercialeUp = item.profiloCommercialeUp;
            
            if(($rootScope.data.step1.causale_ordine !== 'variazione') && ($rootScope.MAP_OFFERTE && (($rootScope.MAP_OFFERTE.ATM_SF.id === $scope.data.step3.offerta.idOfferta) || ($rootScope.MAP_OFFERTE.ATM_SH.id === $scope.data.step3.offerta.idOfferta)))){
            	verificaTecnologia.get({
                    idOfferta: $rootScope.data.step3.offerta.idOfferta,
                    profiloTecnicoLinea : item.profiloTecnicaLinea
                }).$promise.then(
                function (response) {
                	$rootScope.customizedOffer.offerTopDetails.TECNOLOGIA.dft = response.tecnologia;
                },
                function () {
                	$log.debug("Impossibile caricare tecnologia. Riprovare più tardi");
                });
            }

            //SM_10066
            if((($scope.data.step4) && ($scope.data.step4.vlanusers)) && ([$rootScope.MAP_OFFERTE.EASY_CAB.name,$rootScope.MAP_OFFERTE.EASY_H.name, $rootScope.MAP_OFFERTE.SEMI_EASYIP_H.name].indexOf($scope.data.step3.offerta.nomeOffertaCatalogo) >= 0)){
                angular.forEach($scope.data.step4.vlanusers,
                    function (value) {
                       if(value.banda_picco && value.banda_picco.down){
                           value.banda_picco.down = "";
					   }
                       if(value.BANDAPICCOUP && value.BANDAPICCOUP.dft){
                           value.BANDAPICCOUP.dft = "";
					   }
                    }
                );
			}
        };

        $scope.headerConfigurazioneProfiloTecnicaLinea = [
            {"key": "profiloTecnicaLinea", "value": "Profilo Tecnica Linea", "type": "text"},
            {"key": "profiloCommercialeDown", "value": "Profilo Commerciale Down", "type": "text", "sort": "number"},
            {"key": "profiloCommercialeUp", "value": "Profilo Commerciale Up", "type": "text", "sort": "number"},
            {"key": "velocitaAggancioDownMax", "value": "Velocita Aggancio Down Max", "type": "text", "sort": "number"},
            {"key": "velocitaAggancioDownMin", "value": "Velocita Aggancio Down Min", "type": "text", "sort": "number"}
        ];

        $scope.configurazioneOffertaGetProfiloTecnicoLinea = function ($event) {
            $event.preventDefault();
            $scope.modalOptionsProfiloTecnicoLinea = {
                headerText: 'Seleziona il Profilo Tecnico Linea',
                actionButtonText: null,
                closeButtonText: 'Ok',
                contentType: 'modale_nowtable',
                scope: $scope,
                callbackFunction: 'configurazioneOffertaCallbackProfilotecnicoLinea',
                dataHeader: $scope.headerConfigurazioneProfiloTecnicaLinea,
                templateUrl: 'app/common/templates.html',
                data: $rootScope.formData.lineProfiles
            };

            modalService.showModal({},
                $scope.modalOptionsProfiloTecnicoLinea);
        };
        // CONTROLLO MODULAZIONE GBE e ATM
        $scope.getLineProfiles = function (caratteristica) {
            $scope.loadProfiloTecnicoLinea = true;
            $scope.modalOptionsProfiloTecnicoLinea = {};
            //SM_8252 
            var protocoll;
            //SM_8299
            if( !!$scope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO && !!$scope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft ){
            	protocoll = $scope.customizedOffer.offerTopDetails.TIPOPROTOCOLLO.dft 
            }
            else{
            	protocoll = ""
            }
            var modulation;
            modulation = ($rootScope.customizedOffer.offerTopDetails && $rootScope.customizedOffer.offerTopDetails.MODULAZIONE && $rootScope.customizedOffer.offerTopDetails.MODULAZIONE.dft) ? $rootScope.customizedOffer.offerTopDetails.MODULAZIONE.dft : null;
            LineProfiles
                .get({
                    idOfferta: $rootScope.data.step3.offerta.idOfferta,
                    modulazione: modulation,
                    caratteristica: caratteristica,
                    protocollo : protocoll //SM_8252
                }).$promise
                .then(
                function (response) {
                    $rootScope.formData.lineProfiles = response.data;
                    $scope.errorPTL = false;
                    $scope.loadProfiloTecnicoLinea = false;
                },
                function (error) {
                    $scope.errorPTL = "Impossibile caricare i profili linea. Riprovare più tardi";
                    $log.debug("Impossibile caricare i profili linea. Riprovare più tardi");
                    $log.debug(error);
                    $scope.loadProfiloTecnicoLinea = false;
                });
        };
        // PROFILO BANDA GBE E NGA
        $scope.getCvlanBandProfile = function () {
            var _idOfferta = ($scope.data && $scope.data.step3 && $scope.data.step3.offerta && $scope.data.step3.offerta.idOfferta)
                ? $scope.data.step3.offerta.idOfferta
                : ($rootScope.data && $rootScope.data.step3 && $rootScope.data.step3.offerta && $rootScope.data.step3.offerta.idOfferta
                    ? $rootScope.data.step3.offerta.idOfferta
                    : ($rootScope.formData && $rootScope.formData.data && $rootScope.formData.data.step2 && $rootScope.formData.data.step2.fromVariazione && $rootScope.formData.data.step2.fromVariazione.idOfferta
                        ? $rootScope.formData.data.step2.fromVariazione.idOfferta
                        : null));
            if(!_idOfferta){
                return;
            }
            var ProfiliBanda = Bands
                .get({type:"viewDedicatedBand",idOfferta: _idOfferta},null);
            ProfiliBanda.$promise
                .then(
                function (response) {
                    $rootScope.formData.profiliBandaCvlan = response.data;
                    $scope.errorBMD = false;
                },
                function (error) {
                    $scope.errorBMD = "Impossibile caricare i Profili Banda. Riprovare più tardi";
                    $log.debug("Impossibile caricare i Profili Banda. Riprovare più tardi");
                    $log.debug(error);
                });
        };
        // EASYIP E ATM
        $scope.getTDCodes = function () {
            var td = TDCodes.get({codOlo: $scope.data.step1.operatore.codiceOLO});
            $log.info("controllo Codici TD");
            td.$promise
                .then(
                function (response) {
                    $rootScope.formData.codiceTD = response.codiciTD;
                    $scope.errorTD = false;
                },
                function (error) {
                    $scope.errorTD = "Impossibile caricare i codici TD. Riprovare più tardi";
                    $log.debug("Impossibile caricare i codici TD. Riprovare più tardi");
                    $log.debug(error);
                });

        };
        // Referenti Contattati ATTIVAZIONE / VARIAZIONE ATM SIMM Inc. Dec.
        
     	$scope.validaDatiRiferimento = function (form) {

             if (form.ref1_tel_fisso.$invalid
                 || form.ref1_qualifica.$invalid
                 || form.ref1_cognome.$invalid
                 || form.ref1_tel_cellulare.$invalid) {
                 $scope.referentView = [true, false, false, false];
             } else {
                 if (form.ref2_tel_fisso.$invalid
                     || form.ref2_qualifica.$invalid
                     || form.ref2_cognome.$invalid
                     || form.ref2_tel_cellulare.$invalid) {
                     $scope.referentView = [false, true, false, false];
                 } else {
                     if (form.ref3_tel_fisso.$invalid
                         || form.ref3_qualifica.$invalid
                         || form.ref3_cognome.$invalid
                         || form.ref3_tel_cellulare.$invalid) {
                         $scope.referentView = [false, false, true, false];
                     } else {
					     //RU_1462
                         if ($rootScope.data.step1.causale_ordine === 'variazione' || ($scope.data.step3.offerta.idOfferta == $rootScope.MAP_OFFERTE.FIBERSTREAM.id)) {
                             if (form.ref4_tel_fisso &&( form.ref4_tel_fisso.$invalid
                                     || form.ref4_cognome.$invalid
                                     || form.ref4_tel_cellulare.$invalid )) {
                                 $scope.referentView = [false, false, false, true];
                             }
                         }
                     }
                 }
             }

             
             angular.forEach(form.$error.required,
                 function (field) {
                     field.$setDirty();
                     $scope.caricaPassFive = false;
                 }
             );
         };
         
         $scope.verificaInserimentoReferentiCorrettamente= function (item){
          	if($rootScope.data && $rootScope.data.step3 && $rootScope.getMap_Offerta($rootScope.data.step3.offerta.idOfferta).regolatorio){
          		return (item &&(item.telefonoFisso || item.cellulare || item.qualifica || item.cognome || item.email)) ;
          	}else{
          		return (item &&(item.nome || item.telefonoFisso || item.cellulare || item.qualifica || item.cognome || item.email)) ;
          	}
          };
        // controllo se il campo viene variato su variazione e attivo il tasto avanti (per ora: GBE)
        $scope.ControlloAvantiAttivo = function(consistenza, valore){
        	if((consistenza !== valore) && !$scope.avantiAttivo){
        		$scope.avantiAttivo = true;
        	}
        };
        /* ///// CONTROLLO PER VISUALIZZAZIONE BOZZA ////// */
        $scope.controlloBozza = function (step) {
            $scope.viewBotBozza = true;
            if ((step === 4) && ($rootScope.bozza && $rootScope.bozza.data && $rootScope.bozza.data.step4) && (!$scope.data.step4)) {
                $scope.data.step4 = $rootScope.bozza.data.step4;
                if ($scope.data.step4) {
                    if ($scope.data.step4.vcItems) {
                        angular.forEach($scope.data.step4.vcItems,
                            function (vc) {
                                if (vc.VPI && vc.VCI) {
                                    vc.VPI.dft = parseInt(vc.VPI.dft);
                                    vc.VCI.dft = parseInt(vc.VCI.dft);
                                }
                          	}
                        );
                    }
                    //FWA
                    if($scope.data.step4.flag_intervento) {
                    	if($scope.data.step4.flag_intervento == "Y") {
							$scope.data.step4.flag_intervento = true;
                    	} else {
							$scope.data.step4.flag_intervento = false;
                    	}
                    }
                }
                $rootScope.customizedOffer = $rootScope.bozza.customizedOffer;
            } else if ((step === 5) && ($rootScope.bozza && $rootScope.bozza.data && $rootScope.bozza.data.step4) && (!$scope.data.step5)) {
                $scope.data.step5 = $rootScope.bozza.data.step5;
            } else if ((step === 6) && ($rootScope.bozza) && (!$scope.data.step6)) {
                $scope.data.step6 = $rootScope.bozza.data.step6;
            } else if ((step === 7) && ($rootScope.bozza) && (!$scope.data.step7)) {
                $scope.data.step7 = $rootScope.bozza.data.step7;
                if ($scope.data.step7) {
                    if ($scope.data.step7.dad)
                        $scope.data.step7.dad = $filter('date')($scope.data.step7.dad, "dd/MM/yyyy");
                    if ($scope.data.step7.dac)
                        $scope.data.step7.dac = $filter('date')($scope.data.step7.dac, "dd/MM/yyyy");
                    if ($scope.data.step7.dataDisponibilitaSede)
                    	$scope.data.step7.dataDisponibilitaSede = $filter('date')($scope.data.step7.dataDisponibilitaSede, "dd/MM/yyyy");
                }
            }
        };
        /*
         * ///// FINE CONTROLLO PER VISUALIZZAZIONE BOZZA
         * //////
         */
        
        $scope.paginaConferma = function () {
        	if($rootScope.data && $rootScope.data.step1){
        		$scope.causale_ordine=$rootScope.data.step1.causale_ordine;
        	}
        	$rootScope.data = {};
        	$rootScope.formData = {};
        };
        
        //SM_8972
        $scope.effettuaValidazioneDACSla = function(){
        	return ([$rootScope.MAP_OFFERTE.ULL_LNA.id, $rootScope.MAP_OFFERTE.ULLD_LNA.id, $rootScope.MAP_OFFERTE.SLU_LNA.id].indexOf($scope.data.step3.offerta.idOfferta) >= 0);
        }
        
        $scope.validationDac = function (data) {

        	//SM_8972
        	if(!$scope.effettuaValidazioneDACSla()){

        		if($rootScope.data.step3 && !$rootScope.data.step3.visibilitaNP){
        			$rootScope.data.step3.visibilitaNP=false;
        		}
        		if(data){
        			$scope.caricaDac = false;
        			var sottolavorazione = "";
        			if(($rootScope.data.step1.causale_ordine==='variazione') && (($rootScope.data.step3.opzioneVariazione === 'Trasloco') || ($rootScope.data.step3.opzioneVariazione === 'Decremento NP'))){
        				sottolavorazione = $rootScope.data.step3.opzioneVariazione;
        			}
        			var item;
        			if(!data.length || data.length>10){
        				item = SlaValidationService.get(
        						ConvertDateService.get(data),
        						$rootScope.data.step1.causale_ordine,
        						$rootScope.data.step3.offerta.idOfferta, 'offer',
        						$rootScope.data.step3.visibilitaNP,
        						sottolavorazione);
        			}else{
        				item = SlaValidationService.get(
        						data,
        						$rootScope.data.step1.causale_ordine,
        						$rootScope.data.step3.offerta.idOfferta, 'offer',
        						$rootScope.data.step3.visibilitaNP,
        						sottolavorazione);
        			}
        			item.then(function (response) {
        				$scope.caricaDac = true;
        				$rootScope.dacMessaggioErrore = null;
        				if (response[0].outcome.codice !== "KO") {
        					if (response[1].outcome.codice !== "KO") {
        						$rootScope.dacValidato = true;
        					} else {
        						$rootScope.dacValidato = false;
        						$rootScope.dacMessaggioErrore = response[1].outcome.descrizione;
        					}
        				} else {
        					$rootScope.dacValidato = false;
        					$rootScope.dacMessaggioErrore = response[0].outcome.descrizione;
        				}

        			},
        			function (error) {
        				$log.debug(error);
        				$scope.caricaDac = true;
        				$rootScope.dacValidato = false;
        				$rootScope.dacMessaggioErrore = "Impossibile validare la Data";
        			});
        		}
        	}else{
        		$rootScope.dacValidato = true;
        	}
        };
         $scope.verificaDacLavorativo = function (data) {
             if(data){
                 $scope.caricaDac = false;
                 
                 //RU_920
                 var _lavorazione = ($rootScope.data.step1.causale_ordine ? $rootScope.data.step1.causale_ordine : null);
                 var _idOfferta = ($rootScope.data.step3.offerta.idOfferta ? $rootScope.data.step3.offerta.idOfferta : null);
                 
                 var dataDaValidare = (!data.length || data.length>10)? ConvertDateService.get(data): data;
                 
                 //RU_920
                 Dac.get({type:"work",dac: dataDaValidare, lavorazione: _lavorazione, idOfferta: _idOfferta}).$promise.then(function (response) {
                         $scope.caricaDac = true;
                         $rootScope.dacMessaggioErrore = null;
                         if (response.outcome.codice !== "KO") {
                             $rootScope.dacValidato = true;
                         } else {
                             $rootScope.dacValidato = false;
                             $rootScope.dacMessaggioErrore = response.outcome.descrizione;
                         }
                     },
                     function (error) {
                         $log.debug(error);
                         $scope.caricaDac = true;
                         $rootScope.dacValidato = false;
                         $rootScope.dacMessaggioErrore = "Impossibile validare la Data";
                     });
             }
         };
         
         $scope.popolaCVLANID = function(codice, fn, index){

     		$log.info("codice_vlan" + codice);
     		var cvlanid = {};

     		VisualizzaTipoBanda.get({codVlanSvlan: codice}).$promise.then(
     			function(response){
     				cvlanid.tipocos = response.data[0].tipoCos;
     				cvlanid.tipobanda = response.data[0].tipoBanda;
     				$log.info(response.data);
     				fn(cvlanid, index);
     				return cvlanid;
     			},
     			function(){
     				$log.info("Il servizio VisualizzaTipoBanda è andato in errore");
     			}
     		);
     	};
     	
     	 $scope.checkNextState = function(){
			var _currentState = $state.current.name;
			
			var _baseUrlReport = "root.ordini.listareport.dettaglio.asset.new";
			var _baseUrlOrder = "root.ordini.new";
			
			var _nextState = '';
			switch(_currentState){
				case _baseUrlOrder + '.step1':
					_nextState =  _baseUrlOrder + '.step2';
				break;
				case _baseUrlOrder +'.step2':
					_nextState =  _baseUrlOrder + '.step3'
				break;
				case _baseUrlOrder + '.step3':
					_nextState =  _baseUrlOrder + '.attivazione-configurazione'
				break;
				case _baseUrlOrder + '.attivazione-configurazione':
					_nextState =  _baseUrlOrder + '.step5'
				break;
				case _baseUrlOrder + '.step5':
					_nextState =  _baseUrlOrder + '.step6'
				break;
				case _baseUrlOrder + '.step6':
					_nextState =  _baseUrlOrder + '.step7'
				break;
				case _baseUrlOrder + '.step7':
					_nextState =  _baseUrlOrder + '.step8'
				break;
				case _baseUrlOrder + '.step8':
					_nextState =  _baseUrlOrder + '.attivazione-conferma'
				break;
				
				
				case _baseUrlOrder + '.cessazione':
					_nextState =  _baseUrlOrder + '.cessazione.step2';
				break;
				case _baseUrlOrder + '.cessazione.step2':
					_nextState =  _baseUrlOrder + '.cessazione.step3';
				break;
				case _baseUrlOrder + '.cessazione.step3':
					_nextState =  _baseUrlOrder + '.cessazione.riepilogo';
				break;
				case _baseUrlOrder + '.cessazione.riepilogo':
					_nextState =  _baseUrlOrder + '.cessazione.conferma';
				break;				
				
				
				case _baseUrlReport + '.step1':
					_nextState =  _baseUrlReport + '.step2';
				break;
				case _baseUrlReport +'.step2':
					_nextState =  _baseUrlReport + '.step3'
				break;
				case _baseUrlReport + '.step3':
					_nextState =  _baseUrlReport + '.attivazione-configurazione'
				break;
				case _baseUrlReport + '.attivazione-configurazione':
					_nextState =  _baseUrlReport + '.step5'
				break;
				case _baseUrlReport + '.step5':
					_nextState =  _baseUrlReport + '.step6'
				break;
				case _baseUrlReport + '.step6':
					_nextState =  _baseUrlReport + '.step7'
				break;
				case _baseUrlReport + '.step7':
					_nextState =  _baseUrlReport + '.step8'
				break;
				case _baseUrlReport + '.step8':
					_nextState =  _baseUrlReport + '.attivazione-conferma'
				break;		
				
				case _baseUrlReport + '.cessazione':
					_nextState =  _baseUrlOrder + '.cessazione.step2';
				break;
				case _baseUrlReport + '.cessazione.step2':
					_nextState =  _baseUrlOrder + '.cessazione.step3';
				break;
				case _baseUrlReport + '.cessazione.step3':
					_nextState =  _baseUrlOrder + '.cessazione.riepilogo';
				break;
				case _baseUrlReport + '.cessazione.riepilogo':
					_nextState =  _baseUrlOrder + '.cessazione.conferma';
				break;		
			}
			
			return _nextState;
	   } 
	   
	   $scope.checkNextStateVariazione = function(){
			var _currentState = $state.current.name;
			
			var _baseUrlReport = "root.ordini.listareport.dettaglio.asset.new";
			var _baseUrlOrder = "root.ordini.new";
			
			var _nextState = '';
			switch(_currentState){
				case _baseUrlOrder + '.attivazione-configurazione':
					_nextState =  _baseUrlOrder + '.step7';
				break;
				
				case _baseUrlReport + '.attivazione-configurazione':
					_nextState =  _baseUrlReport + '.step7'
				break;
			}
			
			return _nextState;
	   } 
    }]);
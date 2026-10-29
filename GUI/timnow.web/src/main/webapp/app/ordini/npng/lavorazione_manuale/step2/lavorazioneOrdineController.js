timnow
    .controller('lavorazioneOrdineNpng', ['$scope', '$state', '$q', '$rootScope','modalService', 'DettaglioOrdineNpng', 'LavorazioneManualeOrdineNpng', 'alertService', 'Dac',
    	function ($scope, $state, $q, $rootScope, modalService, DettaglioOrdineNpng, LavorazioneManualeOrdineNpng, alertService, Dac) {

    	$scope.arrayStatoSuccessivo = [];
    	$scope.azione = "";
    	
        $scope.init = function() {
               	
            $scope.loadStep2 = true;
            $scope.showLoader = false;
            
            $scope.oraCutOverEditable = false;
            $scope.oraDes = false;
            
            
            if(!$rootScope.data){
            	$rootScope.data = {};
            }
            
            if(!$rootScope.data.step2){
            	$rootScope.data.step2 = {};
            }
            
            if ($rootScope.data && $rootScope.data.step2) {
                $scope.data.step2 = $rootScope.data.step2;
            }
            
            if(!$scope.data || !$scope.data.step2){
            	$scope.data = {}
            	$scope.data.step2 = {};
            }
            
            DettaglioOrdineNpng.get({idOrdine: $state.params.idOrdine}).$promise
            .then(function(response){
            	if(response && response.dettaglioOrdineNPNG){
            		$scope.data.step2 = response.dettaglioOrdineNPNG;
            		
            		$scope.arrayStatoSuccessivo = (response.dettaglioOrdineNPNG.statoSuccessivo || []);
            		$scope.arrayCausaleRifiuto = (response.dettaglioOrdineNPNG.causaleRifiuto || []);
            		
            		//SM_11003
            		$scope.data.step2.statoSuccessivo = "";            		
            		$scope.data.step2.causaleRifiuto = "";
            		
                    $scope.configureDAC();
                    $scope.configureOraCutOver();
                    $scope.configureDES();
                    $scope.configureOraDES();
            	}
            }, function(error){	
				$scope.erroreService("Errore recupero dettaglio Ordine NPNG");
            });    
        }         
        
        /*
         * Configurazione DAC
         */
        
        $scope.configureDAC = function(){
			if($scope.data.step2.dac){
				$scope.data.step2.dac = moment($scope.data.step2.dac).toDate();
			}
        	$scope.dacConfig = {
        			formats: ['dd/MM/yyyy', 'shortDate'],
        			format: 'dd/MM/yyyy',
        			popupOpened : false,
        			dateOptions: {
        				formatYear: 'yyyy',
        				startingDay: 1
        			},
        			open: function(){
        				this.popupOpened = !this.popupOpened;
        			},
        			onChange: function(){
        				if($scope.data.step2.dac && $scope.data.step2.dac != ''){
        					$scope.oraCutOverEditable = true;
        				}else{
        					$scope.oraCutOverEditable = false;
        					$scope.data.step2.oraCutover = null;
        				}
        			}
        	};
        }
        
        /*
         * Configurazione Ora Cut Over
         */
        
        $scope.configureOraCutOver = function(){
        	if($scope.data.step2.oraCutOver){
				//SM_10866
				let oraCutOverArray = $scope.data.step2.oraCutOver.split(":");
				if(oraCutOverArray && oraCutOverArray.length > 1){
					$scope.data.step2.oraCutOver = moment().hour(oraCutOverArray[0]).minute(oraCutOverArray[1]).toDate();
				}        		
        	}else{
        		$scope.data.step2.oraCutOver = '';
        	}
        }
        
        /*
         * Configurazione DES
         */

        $scope.configureDES = function(){
			
        	$scope.desConfig = {
        			formats: ['dd/MM/yyyy', 'shortDate'],
        			format: 'dd/MM/yyyy',
        			popupOpened : false,
        			dateOptions: {
        				formatYear: 'yyyy',
        				startingDay: 1
        			},
        			open: function(){
        				this.popupOpened = !this.popupOpened;
        			},
        			onChange: function(){
        				if($scope.data.step2.dataDes && $scope.data.step2.dataDes != ''){
        					$scope.oraDesEditable = true;
        				}else{
        					$scope.oraDesEditable = false;
        					$scope.data.step2.oraDes = null;
        				}
        			}
        	};
        }
        
        /*
         * Configurazione Ora DES
         */
        
        $scope.configureOraDES = function(){
        	if($scope.data.step2.oraDes){
        		//SM_10866
				let oraDesArray = $scope.data.step2.oraDes.split(":");
				if(oraDesArray && oraDesArray.length > 1){
					$scope.data.step2.oraDes = moment().hour(oraDesArray[0]).minute(oraDesArray[1]).toDate();
				}
        	}else{
        		$scope.data.step2.oraDes = '';
        	}
        }
        
        $scope.validazioneFormConferma = function(){
        	
        	var _app = $scope.data.step2;
        	var _statoOrdine = $scope.data.step2.statoOrdine;
        	var _statoSuccessivo = $scope.data.step2.statoSuccessivo;
        	
        	if(_app){
        		
        		if(_statoOrdine == "LAVORAZIONEHD" && _statoSuccessivo == "ACQUISITO"){
            		if((!_app.unitaOrganizzativa || _app.unitaOrganizzativa == '') && 
                			(!_app.tipoMovimentazione || _app.tipoMovimentazione == '') && 
                			(!_app.ultimaFattura || _app.ultimaFattura == '') && 
                			(!_app.penultimaFattura || _app.penultimaFattura == '')){
                			alertService.add("Compilare i campi UNITA' ORGANIZZATIVA, TIPO MOVIMENTAZIONE, ULTIMA FATTURA, PENULTIMA FATTURA","danger",10000);
                			return false;
                		}
        		}  
        		if(_statoOrdine == "ACQUISITO" && _statoSuccessivo == "INVIATOADELIVERY"){
            		if((!_app.unitaOrganizzativa || _app.unitaOrganizzativa == '') && 
                			(!_app.tipoMovimentazione || _app.tipoMovimentazione == '')){
                			alertService.add("Compilare i campi UNITA' ORGANIZZATIVA, TIPO MOVIMENTAZIONE","danger",10000);
                			return false;
                		}
        		}
        		if(_statoOrdine == "INVIATOADELIVERY" && _statoSuccessivo == "ESPLETATO"){
            		if((_app.causaleOrdine || _app.causaleOrdine != '' && _app.causaleOrdine == '2')){
                			alertService.add("Incongruenza tra CAUSALE ORDINE e STATO SUCCESSIVO selezionato","danger",10000);
                			return false;
                		}
            		if((!_app.dataDes || _app.dataDes == '') && 
                			(!_app.oraDes || _app.oraDes == '')){
                			alertService.add("Compilare i campi DES, ORA DES","danger",10000);
                			return false;
                		}
        		}
        		if(_statoOrdine == "INVIATOADELIVERY" && _statoSuccessivo == "ESPLETATOKO"){
            		if((!_app.dataDes || _app.dataDes == '') && 
                			(!_app.oraDes || _app.oraDes == '')){
                			alertService.add("Compilare i campi DES, ORA DES","danger",10000);
                			return false;
                		}
        		}
        	}        	
        	return true;
        }
        
        $scope.setAzione = function(azione){
        	$scope.azione = azione;
        }
        
        /*
         * Verifica DAC lavorativa
         */
        $scope.C11M08F04 = function(){
        	var _app = $scope.data.step2;        	
            return Dac.get({type:"work", dac: _app.dac, lavorazione: _app.lavorazione, idOfferta: $rootScope.MAP_OFFERTE.NPNG.id}).$promise;
        }
        
        /*
         * Verifica DAC SLA
         */
        $scope.C11M08F05 = function(){
        	var _app = $scope.data.step2;        	
        	return Dac.get({type:"sla", dac: _app.dac, orderType: _app.lavorazione, offer: $rootScope.MAP_OFFERTE.NPNG.id}).$promise;
        }
        
        $scope.submit_2 = function(){
        	if($scope.azione && $scope.azione != ''){
        		switch($scope.azione){
        		case 'RIFIUTA':
        			$scope.rifiuta(); 
        			break;
        		case 'CONFERMA':
        			$scope.conferma();
        			break;
        		}
        	}
        }
        
        $scope.conferma = function () {        	
        	modalService.showModal(
        			{},
        			{
        				headerText: "Avviso",
        				closeButtonText: 'No',
        				actionButtonText: 'Si',
        				bodyText: "Confermare le modifiche ?",
        				scope: $scope,
        				callbackFunction: '_conferma',
        				type: 'success'
        			});
        };
        
        $scope._conferma = function(){       
        	var _statoOrdine = $scope.data.step2.statoOrdine;
        	var _statoSuccessivo = $scope.data.step2.statoSuccessivo;
        	
        	if(_statoOrdine == "LAVORAZIONEHD" && _statoSuccessivo == "ACQUISITO" && $scope.validazioneFormConferma()){
            	$q.all([$scope.C11M08F04(), $scope.C11M08F05()])
        		.then(function(responses){
        			var _messageError = null;
        			if(responses[0].outcome.codice == 'KO' || responses[1].outcome.codice == 'KO'){
        				_messageError = (responses[0].outcome.descrizione || responses[1].outcome.descrizione);        				
        				$scope.erroreService(_messageError);
        			}
        			else{
        				$scope._sendLavorazione();
        			}
        		}, function(error){
					$scope.erroreService("Impossibile validare la DAC");
        		});        		
        	}
        	else{
        		$scope._sendLavorazione();
        	}
        }
		
        $scope.rifiuta = function () {        	
        	modalService.showModal(
        			{},
        			{
        				headerText: "Avviso",
        				closeButtonText: 'No',
        				actionButtonText: 'Si',
        				bodyText: "Confermare lo scarto ?",
        				scope: $scope,
        				callbackFunction: '_rifiuta',
        				type: 'success'
        			});
        };
        
        $scope._rifiuta = function(){
        	var _statoOrdine = $scope.data.step2.statoOrdine;
        	var _statoSuccessivo = $scope.data.step2.statoSuccessivo;
        	
        	if(_statoOrdine == "ACQUISITO" && _statoSuccessivo == "SCARTATO"){       		
        		$scope._sendLavorazione();     		
        	}else{
				$scope.erroreService("Per questa operazione devi selezionare lo stato successivo SCARTATO");
			}
        }
        
        $scope.buildRequestLavorazione = function(){
        	var _app = $scope.data.step2;
        	
        	//SM_10459
    		return {
        			lavorazione: _app.lavorazione,
        			statoSuccessivo: ($scope.azione == 'RIFIUTA' ? 'RIFIUTA' : _app.statoSuccessivo),
        			stato: _app.statoOrdine,
        			oao: _app.olo,
        			causaleRifiuto: (_app.causaleRifiuto || null),
        			penultimaFattura: (_app.penultimaFattura || null),
        			ultimaFattura: (_app.ultimaFattura || null),
        			unitaOrganizzativa: (_app.unitaOrganizzativa || null),
        			tipoPortabilita: (_app.tipoPortabilita || null),        			
        			dataCutover: (_app.dac ? $scope.convertDateToString(_app.dac) : null),
        			oraCutover: (_app.oraCutover ? $scope.convertDateToTimeString(_app.oraCutover) : null),
        			dataDes: ((_app.dataDes ? $scope.convertDateToString(_app.dataDes) : null)),
        			oraDes: (_app.oraDes ? $scope.convertDateToTimeString(_app.oraDes) : null),
        			idRichiestaOloTarget: _app.idRichiestaOlo       			
        		};
        }
        
        $scope._sendLavorazione = function(){
        	var _request = $scope.buildRequestLavorazione();
        	
        	$scope.showLoader = true;
        	
    		LavorazioneManualeOrdineNpng.save(_request).$promise
    		.then(function(response){
    			$scope.showLoader = false;
    			if(response.result.code == 'OK'){
    				$state.go('root.ordini.npng.lavorazioneManuale.conferma', {init: false});
    			}else{
					$scope.erroreService(response.result.mesasge);
    			}
    		}, function(error){
    			$scope.showLoader = false;
    			$scope.erroreService("Errore nella creazione lavorazione");
    		}); 
        }
        
        $scope.convertDateToTimeString = function(date){
        	var _hour = "";
        	
        	if(date){
        		var _app = date.toLocaleTimeString();
        		if(_app && _app.length > 0){
        			var _splittedTime = _app.split(':');
        			if(_splittedTime && _splittedTime.length > 0){
        				_hour = _splittedTime[0] + ":" + _splittedTime[1];
        			}
        		}
        	}        	
        	return _hour;
        }
        
        //SM_10459
        $scope.convertDateToString = function(date){       	
        	var _date = "";        	
        	if(date){
        		_date = "".concat(date.getDate(), '/', (date.getMonth() + 1), '/', date.getFullYear());
        	}
        	return _date;
        }
        
        $scope.$watch("data.step2.statoOrdine", function(newValue, oldValue){
        	if(newValue){
        		var _arrayStati_1 = ["ACQUISITO", "INVIATOADELIVERY", "LAVORAZIONEHD"];
        		var _arrayStati_2 = ["ACQUISITO", "LAVORAZIONEHD"];
        		if(_arrayStati_1.indexOf(newValue) > -1){
        			$scope.dacEditable = true;
        			$scope.unitaOrganizzativaEditable = true;
        			$scope.tipoMovimentazioneEditable = true;        			
        			$scope.causaleOrdineEditable = true;
        			$scope.tipoPortabilitaEditable = true;
        			
        			if(newValue == "INVIATOADELIVERY"){
        				$scope.causaleOrdineRequired = true;
        				$scope.tipoPortabilitaRequired = true;
        			}else{
        				$scope.causaleOrdineRequired = false;
        				$scope.tipoPortabilitaRequired = false;
        			}
        		}else{
        			$scope.dacEditable = false;
        			$scope.unitaOrganizzativaEditable = false;
        			$scope.tipoMovimentazioneEditable = false;        			
        			$scope.causaleOrdineEditable = false;
        			$scope.tipoPortabilitaEditable = false;
        		}
        		
        		if(_arrayStati_2.indexOf(newValue) > -1){
        			$scope.ultimaFatturaEditable = true;
        			$scope.penultimaFatturaEditable = true;
        		}else{
        			$scope.ultimaFatturaEditable = false;
        			$scope.penultimaFatturaEditable = false;
        		}
        	}
        });

        $scope.$watch("data.step2.statoSuccessivo", function(newValue, oldValue){
        	if(newValue){
        		var _arrayStati_1 = ["ESPLETATO", "ESPLETATOKO"];
        		var _arrayStati_2 = ["SCARTATO", "ESPLETATOKO"];
        		if(_arrayStati_1.indexOf(newValue) > -1){
        			$scope.desEditable = true;
    				$scope.desRequired = true;
    				$scope.oraDesRequired = true;
        		}
        		else{
        			$scope.desEditable = false;
    				$scope.desRequired = false;
    				$scope.oraDesRequired = false;
        		}
        		
        		if(_arrayStati_2.indexOf(newValue) > -1){
        			$scope.causaleRifiutoRequired = true;
        			$scope.causaleRifiutoEditable = true;
        		}else{
        			$scope.causaleRifiutoRequired = false;
        			$scope.causaleRifiutoEditable = false;
        		}
        		//SM_10919
        		if(newValue === "SCARTATO"){
					$scope.showButtonRifiuta = true;
					$scope.showButtonConferma = false;
					$scope.data.step2.causaleRifiuto = null;
				}else{
					$scope.showButtonRifiuta = false;
					$scope.showButtonConferma = true;
				}
        	}else{
				$scope.desEditable = false;
    			$scope.desRequired = false;
    			$scope.oraDesRequired = false;
    			$scope.showButtonConferma = true;
			}
        });
        
        $scope.indietro = function(){
        	$state.go('root.ordini.npng.lavorazioneManuale.step1', {init: false});
        }
        
        $scope.annulla = function () {
            modalService.showModal(
                {},
                {
                    headerText: "Vuoi annullare la lavorazione ?",
                    closeButtonText: 'Chiudi',
                    bodyText: "I dati inseriti nell'ordine saranno cancellati.",
                    actionButtonText: 'Continua',
                    scope: $scope,
                    callbackFunction: 'confermaAnnulla',
                    type: 'success'
                });
            $scope.caricaPassFive = false;
        };

        $scope.confermaAnnulla = function () {
            $rootScope.formData = {};
            $rootScope.data = {};
            $state.params.order = null;
            $state.go('root.homepage');
        };
        
        $scope.erroreService = function (messageBody) {
			modalService.showModal({}, {
				headerText: "Avviso",
				bodyText: messageBody,
				scope: $scope,
				type: 'success'
			});
		}
        
        $scope.init(); 

    }]);

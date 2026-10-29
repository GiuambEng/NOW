(function () {
    "use strict";
    angular.module("common").constant('CONDITIONS', {
        "STRING": [{
            "value": "ISNULL",
            "label": "Non valorizzato (Nullo)"
        }, {
            "value": "=",
            "label": "= (uguale)"
        }, {
            "value": "!=",
            "label": "Diverso da"
        }, {
            "value": "STARTWITH",
            "label": "Inizia con"
        }, {
            "value": "ENDWITH",
            "label": "Finisce con"
        }, {
            "value": "IN",
            "label": "In"
        }],
        "DATE": [{
            "value": "ISNULL",
            "label": "Non valorizzato (Nullo)"
        }, {
            "value": "=",
            "label": "= (uguale)"
        }, {
            "value": ">",
            "label": ">   (maggiore)"
        }, {
            "value": "<",
            "label": "<   (minore)"
        }, {
            "value": "!=",
            "label": "Diverso da"
        }, {
            "value": "<=",
            "label": "<="
        }, {
            "value": ">=",
            "label": ">="
        }],
        "INT": [{
            "value": "ISNULL",
            "label": "Non valorizzato (Nullo)"
        }, {
            "value": "IN",
            "label": "In"
        }, {
            "value": "=",
            "label": "= (uguale)"
        }, {
            "value": ">",
            "label": ">   (maggiore)"
        }, {
            "value": "<",
            "label": "<   (miniore)"
        }, {
            "value": "!=",
            "label": "Diverso da"
        }, {
            "value": "<=",
            "label": "<="
        }, {
            "value": ">=",
            "label": ">="
        }],
        "TIME": [{
            "value": "ISNULL",
            "label": "Non valorizzato (Nullo)"
        }, {
            "value": "IN",
            "label": "In"
        }, {
            "value": "=",
            "label": "= (uguale)"
        }, {
            "value": ">",
            "label": ">   (maggiore)"
        }, {
            "value": "<",
            "label": "<   (miniore)"
        }, {
            "value": "!=",
            "label": "Diverso da"
        }, {
            "value": "<=",
            "label": "<="
        }, {
            "value": ">=",
            "label": ">="
        }],
        //RU_1301
        "LIST": [{
            "value": "=",
            "label": "= (uguale)"
        }, {
            "value": "!=",
            "label": "Diverso da"
        }]
    });
    
    //RU_896
    angular.module("common").constant('CONDITIONS_CRM_OPCC', {
        "STRING": [{
            "value": "=",
            "label": "= (uguale)"
        }]
    });

    angular.module("common").constant('CONDITIONS_TYPE', {
        "STRING": "STRING",
        "DATE": "DATE",
        "INT": "INT",
        "TIME": "TIME",
        "LIST": "LIST"
    });

    angular.module("common").directive("nowAdvancedSearch",
        nowAdvancedSearchDirectives);

    function nowAdvancedSearchDirectives() {
        var directive = {
            restrict: 'E',
            templateUrl: 'app/common/ricerca_avanzata/template.html',
            scope: {
                datiToSearch: '=',
                titolo: '=',
                callback: '&',
                codFunzione: '=',
                showSpinner: '=',
                alwaysOpen: '=',
                saveDisabled: '=',
                flagHashing: '='
            },
            replace: true,
            controller: controller,
            link: function($scope, $elm, $attr){
                $scope.$on('direttivaSearch.refreshCodFunzione', function (ev, data) {
                	$scope.direttivaSearch.codFunzione = data;
                    $scope.init();
                });                
            },
            controllerAs: 'direttivaSearch',
            bindToController: true
        };
        return directive;
    }

    controller.$inject = ['$log', '$scope', '$rootScope', '$window',
        'filterFilter', '$uibModal', 'CONDITIONS', 'CONDITIONS_TYPE', 'CONDITIONS_CRM_OPCC',  //RU_896
        '$filter', 'AdvancedSearch', '$timeout', 'modalService'];

    function controller($log, $scope, $rootScope, $window, filterFilter,
                        $uibModal, CONDITIONS, CONDITIONS_TYPE, CONDITIONS_CRM_OPCC, //RU_896
                        $filter, AdvancedSearch, $timeout, modalService) {
        $scope.conn = $rootScope.timnowConfigData.config;
        $scope.search = [];
        $scope.spinnerTimeout = true;
        $scope.noErrorAfterSearch = false;

        $scope.open = function (tipoDirettiva) {
            $scope.items = $scope.parametri;
            $scope.titolo = $scope.direttivaSearch.titolo;
            var modalInstance = $uibModal
                .open({
                    animation: true,
                    templateUrl: 'app/common/ricerca_avanzata/modaleTemplate.html',
                    controller: 'ModalInstanceSearchCtrl',
                    resolve: {
                        dati: function () {
                            return $scope.datiToSearch;
                        },
                        tipoDirettiva: function () {
                            return tipoDirettiva;
                        },
                        codFunzione: function () {
                            return $scope.direttivaSearch.codFunzione;
                        },
                        titolo: function () {
                            return $scope.direttivaSearch.titolo;
                        }
                    }
                });

            modalInstance.result.then(function () {
            }, function (paramToSearch) {
                if (paramToSearch !== 'cancel') {
                    $scope.datiToSearch = paramToSearch;                    
                    //RU_896
                    if($scope.isOPCCUser && paramToSearch.length > 0){
                    	$scope.direttivaSearch.nome = paramToSearch[0].nome;
                    	$scope.direttivaSearch.operazione = paramToSearch[0].operazione;
                    	$scope.direttivaSearch.valore = paramToSearch[0].valore;
                    }
                    //RU_1065
                    else{
                    	$scope.direttivaSearch.nome = "";
                    	$scope.direttivaSearch.operazione = "";
                    	$scope.direttivaSearch.valore = "";
                    }
                }
                $scope.direttivaSearch.disabilitaSaveRicerca = false;
                $scope.errorCampi = false;
                $log.info('Modal dismissed at: ' + new Date());
            });
        };
                
        $scope.init = function(){
            $scope.integervalIN = /^[\d,]*$/;
            $scope.integerval = /^\d*$/;
            $scope.alphanumeric = /^[A-Za-z0-9 ,_.&/:+-]*$/i;

            $scope.conditions = [];
            $scope.conditionsType = [];
            $scope.direttivaSearch.disabilitaSaveRicerca = true; // Inizialmente
            // Ricerca
            // disabilitata
            $scope.direttivaSearch.datiToSearch = $scope.direttivaSearch.datiToSearch
            || [];
            
            //RU_896
            $scope.isOPCCUser = $rootScope.isOPCCUser();

            if ($scope.direttivaSearch.datiToSearch.length > 0) {
                $scope.datiToSearch = $scope.direttivaSearch.datiToSearch;
            } else {
                $scope.datiToSearch = [];
            }

            // Lettura dei parametri delle select di ricerca
            
            //R1F-21-0411
            var request_params = {};
            if($scope.direttivaSearch.flagHashing){
            	request_params = {
            		type: $scope.direttivaSearch.codFunzione,
            		flagHashing: $scope.direttivaSearch.flagHashing
            	};
            }else{
            	request_params = {
                	type: $scope.direttivaSearch.codFunzione
                };
            }
            
            var param = AdvancedSearch.get(request_params);
            param.$promise
                .then(
                function (data) {
                    if (data.data)
                        $scope.parametri = $filter('orderBy')(
                            data.data, 'label');
					// RU_1560 e FEA_36452
					$scope.filtraParametriOscurati();
                    
                    //RU_896
                    if($rootScope.isOPCCUser()){
                        angular
                        .forEach(
                        $scope.parametri,
                        function (value) {
                            $scope.conditions[value.nomeDB] = CONDITIONS_CRM_OPCC[value.tipoDato
                                .toUpperCase()];
                            $scope.conditionsType[value.nomeDB] = CONDITIONS_TYPE[value.tipoDato
                                .toUpperCase()];
                        }); 
                        
                        $scope.buildDatiToSearchOPCC();
                        
                    }else{
                        angular
                        .forEach(
                        $scope.parametri,
                        function (value) {
                            $scope.conditions[value.nomeDB] = CONDITIONS[value.tipoDato
                                .toUpperCase()];
                            $scope.conditionsType[value.nomeDB] = CONDITIONS_TYPE[value.tipoDato
                                .toUpperCase()];
                        });                	
                    }
                }, function (error) {
                    $log.debug(error);
                });
        }
        
        //RU_896
        $scope.buildDatiToSearchOPCC = function(){
        	var arrayFiltri = Object.keys($scope.conditions);
        	        	
        	angular.forEach(arrayFiltri, function(item){
        		var _datiToSearch = {};
        		
        		if($scope.conditions[item] && $scope.conditions[item].length > 0){        		
        			$scope.direttivaSearch.nome = item;
        			$scope.direttivaSearch.operazione = $scope.conditions[item][0].value;
        			if($scope.direttivaSearch.datiToSearch && $scope.direttivaSearch.datiToSearch.length > 0){
        				$scope.direttivaSearch.valore = $scope.direttivaSearch.datiToSearch[0].valore;	
        			}else{
        				$scope.direttivaSearch.valore = "";	
        			}        			    
        		}
        	});       	
        }

        $scope.errorCampi = true;

        $scope.ok = function () {
            $scope.controlloValidazioneDati();

            if (!$scope.errorCampi) {
                $scope.noErrorAfterSearch = true;
                $scope.direttivaSearch.datiToSearch = $scope.datiToSearch;
                $scope.direttivaSearch.disabilitaSaveRicerca = false;
                $timeout(function () {
                    $scope.direttivaSearch.callback();
                });
                $scope.collapse = false;
            }

        };

        $scope.resetSearch = function () {
            $scope.direttivaSearch.datiToSearch = [];
            $scope.datiToSearch = [];
            $scope.collapse = false;
        };

        $scope.svuota = function () {
            $scope.direttivaSearch.datiToSearch = [];
            $scope.datiToSearch = [];
            $scope.collapse = false;
            $scope.ok();
        };

        $scope.convertDate = function (d) {
            var formattedDate = new Date(d);
            if (d) {
                formattedDate = $filter('date')(formattedDate, 'dd/MM/yyyy');
            }
            return formattedDate;
        };

        $scope.IsDate = function (txtDate) {
        	 var dateRegex = /^((0[1-9]|[12][0-9]|3[01])|[1-9]|1[0-2]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
             var dateParts = txtDate.valore.split ("/");
             if ( dateRegex.test(txtDate.valore)){
                 if (dateParts.length !== 3) return false;
                 var day, month, year;
                 day = dateParts[0];
                 month = dateParts[1];
                 year = dateParts[2];
                 txtDate.valore_error_message = "Data non valida";
                 var parsedDate = new Date (month+'/'+day+'/'+year);
                 if (parseInt(month) !== (parseInt(parsedDate.getMonth())+1)) return false;
                 if (parseInt(day) !== parsedDate.getDate()) return false;
                 if (parseInt(year) !== parsedDate.getFullYear()) return false;
             }else{
                 if (dateParts.length !== 3 || dateParts[0].length > 2 || dateParts[1].length > 2 || dateParts[2].length > 4) {
                	 txtDate.valore_error_message = "Formato della data non corretto gg/mm/aaaa";
            	     return false;
            	   }
            	   else{
            		   txtDate.valore_error_message = "Data non valida";
            	       return false;
            	   }
             }  
               return true;
            };                

        /* Controllo CONDIZIONE */
        $scope.controlloValidazioneDati = function () {

            $scope.errorCampi = false;

            if ($scope.datiToSearch.length > 0) {
                angular
                    .forEach(
                    $scope.datiToSearch,
                    function (value) {
                        value.operazione_error = false;
                        value.valore_error = false;
                        value.valore_error_message = "";

                        if (!value.operazione) {
                            value.operazione_error = true;
                            $scope.errorCampi = true;
                        } else if (value.operazione !== 'ISNULL') {
                            if (!value.valore) {
                                value.valore_error_message = "Campo Obbligatorio";
                                value.valore_error = true;
                                $scope.errorCampi = true;
                            } else if($scope.conditionsType[value.nome] === 'INT' && ((!$scope.integerval.test(value.valore) && value.operazione !== 'IN') || (!$scope.integervalIN.test(value.valore) && value.operazione === 'IN'))){
                                value.valore_error_message = "Inserire solo numeri";
                                value.valore_error = true;
                                $scope.errorCampi = true;
                            } else if ($scope.conditionsType[value.nome] === 'DATE'
                                && !$scope.IsDate(value)) {
                                value.valore_error = true;
                                $scope.errorCampi = true;
                            }
                        }
                    });
            }

            if ($scope.direttivaSearch.nome) {
                $scope.direttivaSearch.nome_error = false;
                $scope.direttivaSearch.operazione_error = false;
                $scope.direttivaSearch.valore_error = false;
                $scope.direttivaSearch.valore_error_int = false;
                $scope.direttivaSearch.valore_error_date = false;
            }

            if ($scope.direttivaSearch.nome
                || $scope.direttivaSearch.operazione
                || $scope.direttivaSearch.valore) {
                if (!$scope.direttivaSearch.nome) {
                    $scope.direttivaSearch.nome_error = true;
                    $scope.errorCampi = true;
                }

                if (!$scope.direttivaSearch.operazione) {
                    $scope.direttivaSearch.operazione_error = true;
                    $scope.errorCampi = true;
                } else if ($scope.direttivaSearch.operazione !== 'ISNULL') {
                    if (!$scope.direttivaSearch.valore) {
                        $scope.direttivaSearch.valore_error = true;
                        $scope.errorCampi = true;
                    } else if ($scope.conditionsType[$scope.direttivaSearch.nome] === 'INT' && ((!$scope.integerval.test($scope.direttivaSearch.valore) && $scope.direttivaSearch.operazione !== 'IN' ) || (!$scope.integervalIN.test($scope.direttivaSearch.valore)  && $scope.direttivaSearch.operazione === 'IN'))){
                        $scope.direttivaSearch.valore_error_int = true;
                        $scope.errorCampi = true;
                    }
                }

                if (!($scope.errorCampi || $scope.direttivaSearch.nome_error || $scope.direttivaSearch.operazione_error
                    || $scope.direttivaSearch.valore_error || $scope.direttivaSearch.valore_error_int || $scope.direttivaSearch.valore_error_date)) {
                    if ($scope.conditionsType[$scope.direttivaSearch.nome] === 'DATE') {
                        $scope.direttivaSearch.valore = $scope
                            .convertDate($scope.direttivaSearch.valore);
                    }

                    //check if attribute already present in direttivaSearch before to push********RU456 id=93*************
                	var found =false;
                    if ($scope.datiToSearch.length!== 0){
                    	for (var i=0;i<$scope.datiToSearch.length;i++){
                        	if ($scope.datiToSearch[i].nome.indexOf("ADA.NOMEATTRIBUTO")>-1){
                        	  found=true;
                        	  break;
                        	}
                    	}
                    }

            		if (found && $scope.direttivaSearch.nome.indexOf("ADA.NOMEATTRIBUTO")>-1){
                		//show modal possibile eseguire una ricerca su un singolo attributo
                        modalService.showModal({}, {
                            headerText : "Attributo Selezionato",
                            bodyText : "Puo' essere selezionato un solo attributo tra: IDULLCO, IDSLUCO, SVLANCODE, CVLANID, IPDSLAM, IPKIT, CODICEVP, CODICETD",
                            actionButtonText : 'Chiudi',
                            type : 'warning'
                        });
                        //dovrei inibire la ricerca
                        $scope.errorCampi = true;

            		} else {
            			//RU_896
            			if($scope.datiToSearch.length == 0 || !$scope.isOPCCUser){
	                        $scope.datiToSearch.push({
	                            "nome": $scope.direttivaSearch.nome,
	                            "operazione": $scope.direttivaSearch.operazione,
	                            "valore": $scope.direttivaSearch.valore,
	                            "tipo": $scope.conditionsType[$scope.direttivaSearch.nome]
	                        });
	                        $scope.direttivaSearch.nome = "";
	                        $scope.direttivaSearch.operazione = "";
	                        $scope.direttivaSearch.valore = "";
            			}
            		}

                    //**************************************************************************************
                }
            }
        };

        /* AGGIUNGI CONDIZIONE */
        $scope.aggiungi = function (form) {
            $scope.errorCampi = true;

            angular.forEach(form.$error.required, function (field) {
                field.$setDirty();
            });

            if ((form.valore.$valid && form.nome.$valid && form.operazione.$valid)
                || $scope.direttivaSearch.operazione === 'ISNULL') {
                if ($scope.conditionsType[$scope.direttivaSearch.nome] === 'DATE'
                    && $scope.direttivaSearch.operazione !== 'ISNULL') {
                    $scope.direttivaSearch.valore = $scope
                        .convertDate($scope.direttivaSearch.valore);
                }

                $scope.errorCampi = false;
              //check if attribute already present in direttivaSearch before to push********RU456 id=93*************
            	var found =false;
                if ($scope.datiToSearch.length!== 0){
                	for (var i=0;i<$scope.datiToSearch.length;i++){
                    	if ($scope.datiToSearch[i].nome.indexOf("ADA.NOMEATTRIBUTO")>-1){
                    	  found=true;
                    	  break;
                    	}
                	}
                }
        		if (found && $scope.direttivaSearch.nome.indexOf("ADA.NOMEATTRIBUTO")>-1){
                    modalService.showModal({}, {
                        headerText : "Attributo Selezionato",
                        bodyText : "Puo' essere selezionato un solo attributo tra: IDULLCO, IDSLUCO, SVLANCODE, CVLANID, IPDSLAM, IPKIT, CODICEVP, CODICETD",
                        actionButtonText : 'Chiudi',
                        type : 'warning'
                    });

        		} else {
                    $scope.datiToSearch.push({
                        "nome": $scope.direttivaSearch.nome,
                        "operazione": $scope.direttivaSearch.operazione,
                        "valore": $scope.direttivaSearch.valore,
                        "tipo": $scope.conditionsType[$scope.direttivaSearch.nome]
                    });
                    $scope.direttivaSearch.nome = "";
                    $scope.direttivaSearch.operazione = "";
                    $scope.direttivaSearch.valore = "";
        		}
            //**********************************************************************************************

            }
        };

        /* ELIMINA CONDIZIONE */
        $scope.elimina = function (item) {
            $scope.datiToSearch.splice($scope.datiToSearch.indexOf(item), 1);
        };

        $scope.close = function () {
            $scope.datiToSearch = [];
        };

        $scope.resetFromName = function (item) {
            if (item) {
                item.operazione = '';
                item.valore = '';
            } else {
                $scope.direttivaSearch.operazione = '';
                $scope.direttivaSearch.valore = '';
                $scope.direttivaSearch.defaultValue = '';
            }
            // estrapolo defaultValue
            angular.forEach($scope.parametri, function(value, key) {
                if (value.nomeDB===$scope.direttivaSearch.nome){
                	if (value.defaultValue && value.defaultValue.length){
                    	$scope.direttivaSearch.defaultValue= value.defaultValue;
                	}
                }
            });
            $log.info('defaultValue='+$scope.direttivaSearch.defaultValue);
            
            
        };

        $scope.resetFromOperazione = function (item) {
            if (item) {
                item.valore = '';
            } else {
                $scope.direttivaSearch.valore = '';
            }
        };

        $scope.aggiornamentoTipologiaDato = function (item) {
            if (item) {
                item.tipo = $scope.conditionsType[item.nome];
            }
        };
        
        $scope.openDate = function () {
        	$scope.popup_date.opened = true;
        };
        $scope.popup_date = {
        		opened: false
        };
        
        $scope.dateOptions = {
                formatYear: 'yy',
                maxDate: new Date(2500, 5, 22),
                minDate: new Date(1900, 5, 22),
                startingDay: 1
            };
    /*
    TIMEPICKER
*/
        $scope.direttivaSearch.valore = new Date();

        $scope.hstep = 1;
        $scope.mstep = 1;
        $scope.sstep = 30;

        $scope.options = {
            hstep: [1, 2, 3],
            mstep: [1, 5, 10, 15, 25, 30]
        };
        
        //RU_902
        $scope.$watchCollection(function(){
        	return $scope.datiToSearch; 
        }, function(newValue, oldValue){
            if(newValue && newValue.length > 0){            	
            	var filters = JSON.stringify( newValue, function( key, value ) {
            	    if( key === "$$hashKey" ) {
            	        return undefined;
            	    }
            	    return value;
            	});            	
            	$rootScope.datiToSearch = JSON.parse(filters);            	
            	
            }else{
            	//RU_896
            	if($scope.isOPCCUser){
            		$scope.buildDatiToSearchOPCC();
            	}
            	$rootScope.datiToSearch = [];
            }
        });
        
		$scope.filtraParametriOscurati = function() {
            if (!$scope.parametri) {
                return;
            }

			// per ogni RU oscurata, rimuovo i parametri di ricerca definiti nell'array parametriRicercaOscurati
			if ($rootScope.OSCURAMENTI.RU_1560.oscurato && $rootScope.OSCURAMENTI.RU_1560.parametriRicercaOscurati) {
				$scope.parametri = $scope.parametri.filter(p => $rootScope.OSCURAMENTI.RU_1560.parametriRicercaOscurati.indexOf(p.label) == -1);
			}

            var fea36452 = $rootScope.OSCURAMENTI.FEA_36452;
            if (fea36452.oscurato && fea36452.listaCampi) {
                $scope.parametri = $scope.parametri.filter(p => fea36452.listaCampi.indexOf(p.label) == -1);
            }
		}
		
        $scope.init();
    }
})();
(function () {
    "use strict";
    angular.module("common")
        .directive("nowTable", nowTableDirectives);

    function nowTableDirectives() {

        //dati: inserire gli oggetti della lista
        // funzione che va creata nel controllore richiamante
        //costruzione Header
        //key la chiave per visualizzare i dati
        //value quello che si visualizza sull'header
        //type il type per visualizzare che tipo di valore passare sui dati
        // detailList la lista degli oggetti per le singole chiamate

        var directive = {
            restrict: 'E',
            templateUrl: 'app/common/now_table/template.html',
            scope: {
                dati: '=',
                datiOption: '=',
                customHeader: '=',
                detailList: '=',
                containerList: '=',
                tipologia: '=',
                chiaveChiamata: '=',
                showSpinner: '=',
                isLargeWithHScroll: '=',
                customActionCallback: '&',
                customActionLabel: '@',
                rowSelectionCallback: '&',
                modifyContractFunction: '&',
                //SM_8904
                vista: '=',
                detokenizza: '=',
                //RU_1312
                detailFromService: '=',
                showSpinnerDetails: '='
                ,fileActions: '&'
                ,operationInProgressId: '='
                
            },
            replace: true,
            controller: controller,
            link: function($scope, $elm, $attr){
            	$scope.render = function (data) {
            		if(data){
            			$scope.nowTableController.dati = data;
            		}
                };
                $scope.$on('nowTable.refreshData', function (ev, data) {
                    $scope.render(data);
                });                
            },
            controllerAs: 'nowTableController',
            bindToController: true
        };
        return directive;
    }

    controller.$inject = ['$log', '$state','$scope', '$rootScope', '$window', 'filterFilter', 'modalService', 'orderByFilter','DetokenizzazioneNotifica', 'VerificaFileEsitiMulticast']; //SM_9651
    function controller($log, $state, $scope, $rootScope, $window, filterFilter, modalService, orderByFilter, DetokenizzazioneNotifica, VerificaFileEsitiMulticast) {
        $scope.conn = $rootScope.timnowConfigData.config;
        $scope.search = [];
        $scope.isCollapsed = true;
        $scope.spinnerTimeout = true;
        $scope.pageSize = $scope.conn.tablesPagesize;
        $scope.pageInit = $scope.pageSize.split(',');
        $scope.ceil = $window.Math.ceil;
        $scope.visLim = $scope.pageInit[0];
        $scope.numList = $scope.pageInit[0];
        $scope.begin = 1;
        $scope.pagine = $scope.ceil($scope.totalItems / $scope.numList);
        $scope.reverse = false;
        $scope.arrow = [];
        $scope.searchHeader = [];
        
        //RU_935
        $scope.downloadFilePermission = $rootScope.canDownloadFiles();

        if ($scope.nowTableController.dati && $scope.nowTableController.dati.length) {
            $scope.totalItems = $scope.nowTableController.dati.length;
        } else {
            $scope.totalItems = 0;
        }

        // pagination controls
        $scope.currentPage = 1;
        if ($scope.c && $scope.nowTableController.dati) {
            $scope.totalItems = $scope.nowTableController.dati.length;
        } else {
            $scope.totalItems = 0;
        }
        $scope.entryLimit = $scope.pageInit[0]; // items per page

        $scope.searching = function (searchWord, item) {
            var searchFiltrato = [];
            $scope.search[item] = searchWord;
            angular.forEach($scope.nowTableController.customHeader, function (value) {
                if ($scope.search[value.key] && $scope.search[value.key] !== "") {
                    searchFiltrato[value.key] = $scope.search[value.key];
                }
            });
            if ($scope.filtered) {
                $scope.totalItems = $scope.filtered.length;
            } else {
                $scope.totalItems = 0;
            }
            $scope.filtered = filterFilter($scope.nowTableController.dati, searchFiltrato);

            $scope.totalItems = $scope.filtered.length;
            $scope.pagine = $scope.ceil($scope.totalItems / $scope.numList);
            $scope.currentPage = 1;
        };

        $scope.order = function (predicate) {
            if (predicate.value !== '') {
                if ($scope.arrow[predicate.key]) {
                    if ($scope.arrow[predicate.key] === 'down') {
                        $scope.arrow[predicate.key] = 'up';
                    } else {
                        $scope.arrow[predicate.key] = 'down';
                    }
                } else {
                    $scope.arrow = [];
                    $scope.arrow[predicate.key] = 'down';
                }

                $scope.reverse = ($scope.predicate && $scope.predicate.key === predicate.key) ? !$scope.reverse : false;
                $scope.predicate = predicate;

		    if( $scope.predicate.sort &&  $scope.predicate.sort==="number"){
                    $scope.nowTableController.dati = orderByFilter($scope.nowTableController.dati, ('number' + $scope.predicate.key), $scope.reverse);
			 }else if( $scope.predicate.type==="data"){
                    $scope.nowTableController.dati = orderByFilter($scope.nowTableController.dati, ('date' + $scope.predicate.key), $scope.reverse);
                } else {
                    $scope.nowTableController.dati = orderByFilter($scope.nowTableController.dati, $scope.predicate.key, $scope.reverse);
                }
            }
        };

        $scope.comparatorInteger = function (a, b) {
            var aInt = parseInt(a.value);
            var bInt = parseInt(b.value);
            if (aInt === bInt) return 0;
            return (aInt > bInt) ? 1 : -1;
        };

        $scope.aumenta = function () {
            $scope.begin = $scope.begin + parseInt($scope.numList);
            $scope.pageBasic = $scope.pageBasic + 1;
        };

        $scope.diminuisci = function () {
            $scope.begin = $scope.begin - parseInt($scope.numList);
            $scope.pageBasic = $scope.pageBasic - 1;
        };
        $scope.message = function (message) {
            modalService.showModal({}, {
                headerText: "Avviso",
                bodyText: message,
                actionButtonText: 'Chiudi',
                type: 'warning'
            });
        };

        //normalizzazione delle date
        $scope.$watch('nowTableController.dati', function () {
            if ($scope.nowTableController.dati && $scope.nowTableController.dati.length > 0) {
                if (!$scope.normalize) {
                    $scope.normalize = true;
                    angular.forEach($scope.nowTableController.customHeader, function (value) {
                        if (value.sort && value.sort === "number") {
                            angular.forEach($scope.nowTableController.dati, function (item) {
                                if (item[value.key]) {
                                    item['number' + value.key] = parseInt(item[value.key]);
                                }
                            });
                        } else if (value.type === "data" && value.pattern === "dd/MM/yyyy") {
                            angular.forEach($scope.nowTableController.dati, function (item) {
                                if (item[value.key]) {
                                	var parts;
                                	if(item[value.key].indexOf("/")>-1){
                                		parts = item[value.key].split("/");
                                	}
                                	if(item[value.key].indexOf("-")>-1){
                                		parts = item[value.key].split("-");
                                	}
                                    if (parts[2].length > 4)parts[2] = parts[2].substring(0, 4);
                                    item['date' + value.key] = new Date(parts[2], parts[1] - 1, parts[0]); //js considera i mesi a partire dallo 0 mentre dal PS arrivano in notazione standard
                                }
                            });
                        } else if (value.type === "data" && value.pattern === "dd/MM/yyyy HH:mm:ss") {
                            angular.forEach($scope.nowTableController.dati, function (item) {
                                if (item[value.key]) {
                                	var parts;
                                	if(item[value.key].indexOf("/")>-1){
                                		parts = item[value.key].split("/");
                                	}
                                	if(item[value.key].indexOf("-")>-1){
                                		parts = item[value.key].split("-");
                                	}
                                    item['date' + value.key] = new Date(parts[2].substring(0, 4), parts[1] - 1, parts[0], parts[2].substring(5, 7), parts[2].substring(8, 10), parts[2].substring(11, 13)); //js considera i mesi a partire dallo 0 mentre dal PS arrivano in notazione standard
                                }
                            });
                        }
                    });
                    angular.forEach($scope.nowTableController.detailList, function (value) {
                        if (value.sort && value.sort === "number") {
                            angular.forEach($scope.nowTableController.dati, function (item) {
                                if (item[value.key]) {
                                    item['number' + value.key] = parseInt(item[value.key]);
                                }
                            });
                        } else if (value.type === "data" && value.pattern === "dd/MM/yyyy") {
                            angular.forEach($scope.nowTableController.dati, function (item) {
                                if (item[value.key]) {
                                	var parts;
                                	if(item[value.key].indexOf("/")>-1){
                                		parts = item[value.key].split("/");
                                	}
                                	if(item[value.key].indexOf("-")>-1){
                                		parts = item[value.key].split("-");
                                	}
                                    if (parts[2].length > 4)parts[2] = parts[2].substring(0, 4);
                                    item['date' + value.key] = new Date(parts[2], parts[1] - 1, parts[0]); //js considera i mesi a partire dallo 0 mentre dal PS arrivano in notazione standard
                                }
                            });
                        } else if (value.type === "data" && value.pattern === "dd/MM/yyyy HH:mm:ss") {
                            angular.forEach($scope.nowTableController.dati, function (item) {
                                if (item[value.key]) {
                                	var parts;
                                	if(item[value.key].indexOf("/")>-1){
                                		parts = item[value.key].split("/");
                                	}
                                	if(item[value.key].indexOf("-")>-1){
                                		parts = item[value.key].split("-");
                                	}
                                    item['date' + value.key] = new Date(parts[2].substring(0, 4), parts[1] - 1, parts[0], parts[2].substring(5, 7), parts[2].substring(8, 10), parts[2].substring(11, 13)); //js considera i mesi a partire dallo 0 mentre dal PS arrivano in notazione standard
                                }
                            });
                        }
                    });
                    $scope.calcoloFiltriPaginazione();
                }

                if ($scope.checkFiltriPaginazione()) {
                    $scope.begin = $rootScope.salvataggioFiltriPaginazione.Paginazione.begin;
                    $scope.pageBasic = $rootScope.salvataggioFiltriPaginazione.Paginazione.pageBasic;
                } else {
                    $scope.pagine = $scope.ceil($scope.nowTableController.dati.length / $scope.numList);
                    $scope.totalItems = $scope.nowTableController.dati.length;
                    if ($scope.pagine > 0) {
                        $scope.begin = 1;
                        $scope.pageBasic = 1;
                    }
                }
            } else {
                $scope.pagine = 0;
                $scope.totalItems = 0;
            }
        });

        $scope.changeList = function (item) {
            $scope.numList = item;
            $scope.pagine = $scope.ceil($scope.totalItems / $scope.numList);
            if ($scope.pagine > 0) {
                $scope.begin = 1;
                $scope.pageBasic = 1;
            } else {
                $scope.pageBasic = 0;
                $scope.begin = 0;
            }
        };

        $scope.rowSelected = function (item) {
            if (!$scope.withoutRowSelection()) {
                $log.debug("directive callback ...");
                // START SALVATAGGIO FILTRI
                $scope.salvataggioFiltriPaginazione();
                // END SALVATAGGIO FILTRI
                $scope.nowTableController.rowSelectionCallback()(item);
            }
        };
        
        //RU_1312
        $scope.rowSelectedDetails = function (item) {
            if (item.collapse) {
                $scope.nowTableController.rowSelectionCallback()(item);
            }
        };

        $scope.apriXML = function (file) {
            modalService.showModal({}, {
                headerText: "File XML",
                templateUrl: 'app/common/templates.html',
                filexml: true,
                bodyText: file
            });
        };
        
        //SM_9651
        $scope.detokenizzaXML = function (notifica) {
        	        		
        		//SM_9693
        		//SM_10516
        		var _request = {
        			idNotifica: notifica.idNotifica,      
        			tipoProfilo: $rootScope.timnowConfigData.user.codiceProfilo
        		}
        		
        		DetokenizzazioneNotifica.save({}, _request).$promise
        		.then(function(response){
        			if(response.result.code == 'OK'){
                        modalService.showModal({}, {
                            headerText: "File XML",
                            templateUrl: 'app/common/templates.html',
                            filexml: true,
                            bodyText: response.notificaDetokenizzata.xml
                        });      
        			}else{
                        modalService.showModal({}, {
                            headerText: "File XML",
                            templateUrl: 'app/common/templates.html',
                            filexml: true,
                            bodyText: notifica.notificaXML
                        });
        			} 			
        		}, function(error){
                    modalService.showModal({}, {
                        headerText: "File XML",
                        templateUrl: 'app/common/templates.html',
                        filexml: true,
                        bodyText: notifica.notificaXML
                    });
        		})      	
        };

        // START SALVATAGGIO FILTRI
        $scope.salvataggioFiltriPaginazione = function () {
            $rootScope.salvataggioFiltriPaginazione = {};
            $rootScope.salvataggioFiltriPaginazione.customHeader = $scope.nowTableController.customHeader;
            $rootScope.salvataggioFiltriPaginazione.search = $scope.search;
            $rootScope.salvataggioFiltriPaginazione.arrow = $scope.arrow;
            $rootScope.salvataggioFiltriPaginazione.searchHeader = $scope.searchHeader;
            $rootScope.salvataggioFiltriPaginazione.Paginazione = {};
            $rootScope.salvataggioFiltriPaginazione.Paginazione.numList = $scope.numList;
            $rootScope.salvataggioFiltriPaginazione.Paginazione.begin = $scope.begin;
            $rootScope.salvataggioFiltriPaginazione.Paginazione.pageBasic = $scope.pageBasic;
            $rootScope.salvataggioFiltriPaginazione.reverse = !$scope.reverse;
            $rootScope.salvataggioFiltriPaginazione.predicate = $scope.predicate;
        };

        $scope.inizializzazioneFiltriPaginazione = function () {
            if ($scope.checkFiltriPaginazione()) {
                $scope.nowTableController.customHeader = $rootScope.salvataggioFiltriPaginazione.customHeader;
                $scope.search = $rootScope.salvataggioFiltriPaginazione.search;
                $scope.arrow = $rootScope.salvataggioFiltriPaginazione.arrow;
                $scope.searchHeader = $rootScope.salvataggioFiltriPaginazione.searchHeader;
                $scope.numList = $rootScope.salvataggioFiltriPaginazione.Paginazione.numList;
                $scope.begin = $rootScope.salvataggioFiltriPaginazione.Paginazione.begin;
                $scope.reverse = $rootScope.salvataggioFiltriPaginazione.reverse;
                $scope.predicate = $rootScope.salvataggioFiltriPaginazione.predicate;
            }
        };

        $scope.calcoloFiltriPaginazione = function () {
            if ($scope.checkFiltriPaginazione()) {
                $scope.searching();
                $scope.begin = $rootScope.salvataggioFiltriPaginazione.Paginazione.begin;
                $scope.pageBasic = $rootScope.salvataggioFiltriPaginazione.Paginazione.pageBasic;
                if ($scope.predicate) {
                    $scope.order($scope.predicate);
                }
            }
        };
        
        $scope.checkFiltriPaginazione= function(){
        	return ($rootScope.salvataggioFiltriPaginazione && $rootScope.salvataggioFiltriPaginazione.customHeader && $rootScope.salvataggioFiltriPaginazione.tipologia === $scope.nowTableController.tipologia);
        };
        $scope.withoutRowSelection = function () {
            if ($scope.nowTableController.rowSelectionCallback && angular.isFunction($scope.nowTableController.rowSelectionCallback())) {
               return false;
            }else{
            	return true;
            }
        };
        
        $scope.customAction = function (item) {
        	if($scope.nowTableController.customActionCallback && angular.isFunction($scope.nowTableController.customActionCallback())){
        		$scope.nowTableController.customActionCallback()(item);
        	}
        };
        
        $scope.customActionDetokenizza = function (item) {
        	if($scope.nowTableController.customActionCallback && angular.isFunction($scope.nowTableController.customActionCallback())){
        		$scope.nowTableController.customActionCallback()(item, $scope.nowTableController.dati.indexOf(item));
        	}
        };
        
        $scope.changeView = function (item, to, mode) {

            item['type'] = mode;
            $state.go(to, {"getValue": item, "getOption": $scope.nowTableController.datiOption});
        };

        $scope.scaricaFile = function(evt, link){
        	
        	evt.preventDefault();
        	
        	//SM_8904
        	var vista = "";
        	if($scope.nowTableController.vista){
        		vista = $scope.nowTableController.vista;        		
        	}   
        	
        	$scope.link = link;
        	$scope.vista = vista;
        	
        	//RU_1158        	
        	if(vista == $rootScope.VIEW.STATO_FILE && $rootScope.isDGUser()){
                modalService.showModal(
                        {},
                        {
                            headerText: "Download file",
                            closeButtonText: 'Chiudi',
                            bodyText: "Il download implica la detokenizzazione dei dati. Se si vuole procedere, premere OK",
                            actionButtonText: 'OK',
                            scope: $scope,
                            callbackFunction: 'download',
                            type: 'success'
                        });
        	}else{
        		$scope.download();
        	}        	
        	

        };
        
        $scope.download = function(){
            var url = "rest/files?idFile=" + $scope.link + '&vista=' + $scope.vista;
            $window.open(url);
        }
        
        //RU_1180
        $scope.downloadEsitiMulticast = function(evt, item){
        	
        	evt.preventDefault();
        	
        	var _url = '';
        	
        	if(item && item.idInterfaccia && item.idInterfaccia != ''){
        		
        		//CR1-CR4
        		var _params = {
        			idFile: decodeURIComponent(item.idFile),
        			fileName: item.nomeFile,
        			interfaccia: item.idInterfaccia
        		};
        		
        		VerificaFileEsitiMulticast.get(_params).$promise.then(function(response){
        			if(response && response.outputVerificaFileEsitiMulticast && response.outputVerificaFileEsitiMulticast.esito == 'OK'){
        				_url = "rest/multicast/downloadFileEsiti?idFile=" + item.idFile + '&fileName=' + item.nomeFile + '&interfaccia=' + item.idInterfaccia;
        				$window.open(_url);
        			}else{
                        modalService.showModal({}, {
                            headerText: "Avviso",
                            bodyText: response.outputVerificaFileEsitiMulticast.message,
                            actionButtonText: 'Chiudi',
                            type: 'warning'
                        });	
        			}
        		}, function(error){
                    modalService.showModal({}, {
                        headerText: "Avviso",
                        bodyText: error.message,
                        actionButtonText: 'Chiudi',
                        type: 'warning'
                    });
        		});       		
        	}else{        		
        		_url = "rest/contracts/downloadFileEsiti?idFile=" + item.idFile + '&fileName=' + item.nomeFile;
        		$window.open(_url);
        	}            
        }
        
        
        //RU_1276
        $scope.downloadEsitiComuniCoinvestiti = function(evt, item){
        	
        	evt.preventDefault();
        	
        	var _url = '';
        	
        	if(item){       		
        		_url = "rest/comuniCoinvestiti/downloadFileEsiti?idFile=" + item.idFile + "&fileName=" + item.nomeFile + "&offerta=" + item.offerta + "&codOloAgcom=" + (item.codOloAgcom || item.oao);
        		$window.open(_url);       		
        	}else{        		
                modalService.showModal({}, {
                    headerText: "Avviso",
                    bodyText: "Impossibile effettuare il download del file esiti",
                    actionButtonText: 'Chiudi',
                    type: 'warning'
                });
        	}            
        }
        
        //RU_692 
        $scope.checkDisabledButton = function (item, it){
        	if( ( it.disabledValueA.indexOf(item[it.disabledA])<0 ) || (item[it.disabledB] == it.disabledValueB) || (item[it.disabledC] == it.disabledValueC) || (item.stato.toUpperCase()==='ANNULLATA')){ //SM_8285
        		return true
        	}
        	else{
        		return false
        	}
        }
        
        //RU_716 NUOVO CONTRATTO
        $scope.modifyContractFunction = function(item){
        	$state.go('root.anagrafica.contratto.modificaContratto', {
        		idContratto: item.idContratto
        	});
        };
        
        //RU_1203
        $scope.modifyNpngFunction = function(item){
        	$state.go('root.anagrafica.npng.modifica', {
              	number: item
            });
        };
        
        //RU_1335
        $scope.modifyFwaWillDecoFunction = function(item){
        	$state.go('root.anagrafica.fwaWillDeco.edit', {
              	idRisorsa: item.idRisorsaSwitchOff
            });
        };
        
		/* R1F-21-0411 */
		$scope.visualizzaDettaglioReport = function(evt, item){
			evt.preventDefault();			
			$state.go('root.ordini.listareport.dettaglio', {idReport: item.idReport, tipoLista: item.tipoLista});
		}	

        $scope.inizializzazioneFiltriPaginazione();
        // END SALVATAGGIO FILTRI
        
    }
})();
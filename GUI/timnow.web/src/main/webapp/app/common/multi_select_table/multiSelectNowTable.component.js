//RU_1205
angular.module("common")
        .component("multiSelectTable", {
            templateUrl: 'app/common/multi_select_table/multiSelectTable.component.html',
            replace: true,
            bindings: {
                dati: '<',
                customHeader: '=',
                showSpinner: '=',
                selectedDati: '='                
            },
            
            controller: ['$log', '$scope', '$rootScope', '$state', '$window', 'filterFilter', 'orderByFilter',
            	function ($log, $scope, $rootScope, $state, $window, filterFilter, orderByFilter) {
            	
            	var vm = this;
            	vm.conn = $rootScope.timnowConfigData.config;
                vm.pageSize = vm.conn.tablesPagesize;
                vm.pageInit = vm.pageSize.split(',');
                vm.search = [];
                vm.ceil = $window.Math.ceil;
                vm.visLim = vm.pageInit[0];
                vm.numList = vm.pageInit[0];
                vm.numList = vm.pageInit[0];
                vm.begin = 1;        
                vm.pagine = vm.ceil(vm.totalItems / vm.numList);
                vm.searchHeader = [];
                vm.arrow = [];

            	if (vm.dati && vm.dati.length) {
                    vm.totalItems = vm.dati.length;
                } else {
                    vm.totalItems = 0;
                }
                // pagination controls
                vm.currentPage = 1;
                vm.entryLimit = vm.pageInit[0]; // items per page
                
        		vm.$onInit = function(){
        			vm.normalizzaDati();
        		}      


                
                vm.onSelect = function(item){
                	if(vm.selectedDati && vm.selectedDati.selected){
                		vm.selectedDati.selected.push(item);
                	}
                }
                
                vm.onUnselect = function(index){
                	if(vm.selectedDati && vm.selectedDati.selected){
                		vm.selectedDati.selected.splice(index, 1);
                	}
                }


                vm.searching = function (searchWord, item) {
                    var searchFiltrato = [];
                    vm.search[item] = searchWord;
                    angular.forEach(vm.customHeader, function (value) {
                        if (vm.search[value.key] && vm.search[value.key] !== "") {
                            searchFiltrato[value.key] = vm.search[value.key];
                        }
                    });
                    vm.search = searchFiltrato;
                    vm.filtered = filterFilter(vm.dati, searchFiltrato);

                    vm.totalItems = vm.filtered.length;
                    vm.pagine = vm.ceil(vm.totalItems / vm.numList);
                    vm.currentPage = 1;
                };

                vm.order = function (predicate) {
                    if (predicate.value !== '') {
                        if (vm.arrow[predicate.key]) {
                            if (vm.arrow[predicate.key] === 'down') {
                                vm.arrow[predicate.key] = 'up';
                            } else {
                                vm.arrow[predicate.key] = 'down';
                            }
                        } else {
                            vm.arrow = [];
                            vm.arrow[predicate.key] = 'down';
                        }

        		    vm.reverse = (vm.predicate && vm.predicate.key === predicate.key) ? !vm.reverse : false;
        		    vm.predicate = predicate;

        		    if( vm.predicate.sort &&  vm.predicate.sort==="number"){
        				 vm.dati=orderByFilter(vm.dati,('number'+vm.predicate.key),vm.reverse);
        			 }else if( vm.predicate.type==="data"){
        				 vm.dati=orderByFilter(vm.dati,('date'+vm.predicate.key),vm.reverse);
                        } else {
        				 vm.dati=orderByFilter(vm.dati,vm.predicate.key,vm.reverse);
                        }
        		    
                    }
                };

                vm.comparatorInteger = function (a, b) {
                    var aInt = parseInt(a.value);
                    var bInt = parseInt(b.value);

                    if (aInt === bInt) return 0;
                    return (aInt > bInt) ? 1 : -1;
                };

                vm.aumenta = function () {
                    vm.begin = vm.begin + parseInt(vm.numList);
                    vm.pageBasic = vm.pageBasic + 1;
                };

                vm.diminuisci = function () {
                    vm.begin = vm.begin - parseInt(vm.numList);
                    vm.pageBasic = vm.pageBasic - 1;
                };


                vm.normalizzaDati = function () {
                    if (vm.dati && vm.dati.length > 0) {
                        //normalizzare data start
                        if (!vm.normalize) {
                            vm.normalize = true;
                            angular.forEach(vm.customHeader, function (value) {
                                if (value.sort && value.sort === "number") {
                                    angular.forEach(vm.dati, function (item) {
                                        if (item[value.key]) {
                                            item['number' + value.key] = parseInt(item[value.key]);
                                        }
                                    });
                                } else if (value.type === "data" && value.pattern === "dd/MM/yyyy") {
                                    angular.forEach(vm.dati, function (item) {
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
                                    angular.forEach(vm.dati, function (item) {
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
                        }
                        // end

                        vm.pagine = vm.ceil(vm.dati.length / vm.numList);
                        vm.totalItems = vm.dati.length;
                        if (vm.pagine > 0) {
                            vm.begin = 1;
                            vm.pageBasic = 1;
                        }
                    } else {
                        vm.pagine = 0;
                        vm.totalItems = 0;
                    }
                };

        	
                vm.changeList = function (item) {
                    vm.numList = item;
                    vm.pagine = vm.ceil(vm.totalItems / vm.numList);
                    if (vm.pagine > 0) {
                        vm.begin = 1;
                        vm.pageBasic = 1;
                    } else {
                        vm.pageBasic = 0;
                        vm.begin = 0;
                    }
                };
        		
        		// START SALVATAGGIO FILTRI
        		vm.salvataggioFiltriPaginazione = function(){
        			$rootScope.salvataggioFiltriPaginazione={};
        			$rootScope.salvataggioFiltriPaginazione.customHeader=vm.customHeader;
        			$rootScope.salvataggioFiltriPaginazione.search=vm.search;
        			$rootScope.salvataggioFiltriPaginazione.arrow=vm.arrow;
        			$rootScope.salvataggioFiltriPaginazione.searchHeader=vm.searchHeader;
        			$rootScope.salvataggioFiltriPaginazione.Paginazione={};
        			$rootScope.salvataggioFiltriPaginazione.Paginazione.numList=vm.numList;
        			$rootScope.salvataggioFiltriPaginazione.Paginazione.begin=vm.begin;
        			$rootScope.salvataggioFiltriPaginazione.Paginazione.pageBasic=vm.pageBasic;
        			$rootScope.salvataggioFiltriPaginazione.reverse=!vm.reverse;
        			$rootScope.salvataggioFiltriPaginazione.predicate=vm.predicate;
        		};
        		
        		vm.inizializzazioneFiltriPaginazione = function(){
        			if($rootScope.salvataggioFiltriPaginazione && $rootScope.salvataggioFiltriPaginazione.customHeader && $rootScope.salvataggioFiltriPaginazione.tipologia===vm.tipologia){
        				  vm.customHeader=$rootScope.salvataggioFiltriPaginazione.customHeader;
        				  vm.search=$rootScope.salvataggioFiltriPaginazione.search;
        				  vm.arrow=$rootScope.salvataggioFiltriPaginazione.arrow;
        				  vm.searchHeader=$rootScope.salvataggioFiltriPaginazione.searchHeader;
        				  vm.numList = $rootScope.salvataggioFiltriPaginazione.Paginazione.numList;
        				  vm.begin = $rootScope.salvataggioFiltriPaginazione.Paginazione.begin;
        				  vm.reverse = $rootScope.salvataggioFiltriPaginazione.reverse;
        				  vm.predicate = $rootScope.salvataggioFiltriPaginazione.predicate;
        			  }
        		};
        		
        		vm.calcoloFiltriPaginazione = function(){
        			 if($rootScope.salvataggioFiltriPaginazione && $rootScope.salvataggioFiltriPaginazione.customHeader && $rootScope.salvataggioFiltriPaginazione.tipologia===vm.tipologia){
        				  vm.searching();
        				  vm.begin = $rootScope.salvataggioFiltriPaginazione.Paginazione.begin;
        				  vm.pageBasic = $rootScope.salvataggioFiltriPaginazione.Paginazione.pageBasic;
        				  if(vm.predicate){
        					  vm.order(vm.predicate);
        				  }
        			  }
        		};
        		
        		vm.inizializzazioneFiltriPaginazione();
        		// END SALVATAGGIO FILTRI	
        		
            }]        	
        });
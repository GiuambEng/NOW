(function () {
    "use strict";

    angular.module("common")
        .directive("editDeleteNowTable", editDeleteNowTableDirectives);

    function editDeleteNowTableDirectives() {

        //dati: inserire gli oggetti della lista
        //detailCallback: inserire il nome della funzione da richiamare per aprire il dettaglio
        // funzione che va creata nel controllore richiamante
        //keydetailCallback:
        //costruzione Header
        //key la chiave per visualizzare i dati
        //value quello che si visualizza sull'header
        //type il type per visualizzare che tipo di valore passare sui dati
        // detailCallback la chiamata per ricevere il dettaglio per il singolo oggetto
        // detailList la lista degli oggetti per le singole chiamate


        var directive = {
            restrict: 'E',
            templateUrl: 'app/common/edit_delete_now_table/template.html',
            scope: {
                dati: '=',
                detailCallback: '&',
                customHeader: '=',
                detailArg: '=',
                detailList: '=',
                tipologia: '=',
                showSpinner: '=',
                abilitaModify: '=',
                abilitaDelete: '=',
                abilitaAdd: '=',
                hidePagination: '=',
                abilitaCustomAction: '=',
                disabledAddFlag: '=',
                modifyCallback: '&',
                addCallback: '&',
                deleteCallback: '&',
                customActionCallback: '&',
                rowSelectionCallback:'&',
                customActionLabel: '@',
                isLargeWithHScroll: '='
            },
            replace: true,
            controller: controller,
            controllerAs: 'ctrlDirettiva',
            bindToController: true
        };
        return directive;
    }

    controller.$inject = ['$log', '$scope', '$rootScope', '$window', 'filterFilter', '$uibModal','modalService', 'orderByFilter'];
    function controller($log, $scope, $rootScope, $window, filterFilter, $uibModal, modalService, orderByFilter) {
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
        $scope.modifyItem = [];
        $scope.abilitaDeleteItem = false;
        $scope.abilitatoPulsanteDelete = false;
        $scope.hidePagination = false;
        $scope.searchHeader = [];
        $scope.abilitatoPulsanteCustom = false;

        if ($scope.ctrlDirettiva.dati && $scope.ctrlDirettiva.dati.length) {
            $scope.totalItems = $scope.ctrlDirettiva.dati.length;
        } else {
            $scope.totalItems = 0;
        }
        // pagination controls
        $scope.currentPage = 1;
        $scope.entryLimit = $scope.pageInit[0]; // items per page


        $scope.searching = function (searchWord, item) {
            var searchFiltrato = [];
            $scope.search[item] = searchWord;
            angular.forEach($scope.ctrlDirettiva.customHeader, function (value) {
                if ($scope.search[value.key] && $scope.search[value.key] !== "") {
                    searchFiltrato[value.key] = $scope.search[value.key];
                }
            });
            $scope.search = searchFiltrato;
            $scope.filtered = filterFilter($scope.ctrlDirettiva.dati, searchFiltrato);

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
				 $scope.ctrlDirettiva.dati=orderByFilter($scope.ctrlDirettiva.dati,('number'+$scope.predicate.key),$scope.reverse);
			 }else if( $scope.predicate.type==="data"){
				 $scope.ctrlDirettiva.dati=orderByFilter($scope.ctrlDirettiva.dati,('date'+$scope.predicate.key),$scope.reverse);
                } else {
				 $scope.ctrlDirettiva.dati=orderByFilter($scope.ctrlDirettiva.dati,$scope.predicate.key,$scope.reverse);
                }
		    
            }
        };

        $scope.detail = function (item) {
            $scope.checkDetailDeleteSave = 1;
			// START SALVATAGGIO FILTRI
			$scope.salvataggioFiltriPaginazione();
			// END SALVATAGGIO FILTRI
            $scope.ctrlDirettiva.detailArg = item;

        };

        $scope.modifyItem = function (item) {
            $scope.checkDetailDeleteSave = 2;
			// START SALVATAGGIO FILTRI
			$scope.salvataggioFiltriPaginazione();
			// END SALVATAGGIO FILTRI
            $scope.ctrlDirettiva.detailArg = item;
        };

        $scope.abilitaPulsanteDelete = function () {
            if (filterFilter($scope.ctrlDirettiva.dati, {isSelected: true}).length > 0) {
                $scope.abilitatoPulsanteDelete = true;
                $scope.abilitatoPulsanteCustom = true;
            } else {
                $scope.abilitatoPulsanteDelete = false;
                $scope.abilitatoPulsanteCustom = false;
            }
        };


        $scope.deleteItem = function () {
            $scope.checkDetailDeleteSave = 3;

            var modalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'app/common/edit_delete_now_table/modaleTemplate.html',
                controller: 'ModalInstanceDeleteCtrl'
            });

			    modalInstance.result.then( function () {}, function (result) {
                if (result){
                	$scope.ctrlDirettiva.detailArg = filterFilter($scope.ctrlDirettiva.dati, {isSelected: true});
                }
            });

        };

        $scope.apriXML = function (file) {
            modalService.showModal({}, {
                headerText: "File XML",
                templateUrl: 'app/common/templates.html',
                filexml: true,
                bodyText: file
            });
        };
        
        $scope.customAction = function () {
            $scope.checkDetailDeleteSave = 4;
			// START SALVATAGGIO FILTRI
			$scope.salvataggioFiltriPaginazione();
			// END SALVATAGGIO FILTRI
            $scope.ctrlDirettiva.detailArg = filterFilter($scope.ctrlDirettiva.dati, {isSelected: true});
        };

        $scope.addItem = function () {
            $scope.ctrlDirettiva.addCallback();
        };
        $scope.$watch('ctrlDirettiva.detailArg', function () {
            if ($scope.ctrlDirettiva.detailArg !== "" && $scope.checkDetailDeleteSave && $scope.checkDetailDeleteSave === 1) {
                $scope.ctrlDirettiva.detailCallback();
            } else if ($scope.ctrlDirettiva.detailArg !== [] && $scope.checkDetailDeleteSave && $scope.checkDetailDeleteSave === 2) {
                $scope.ctrlDirettiva.modifyCallback();
            } else if ($scope.ctrlDirettiva.detailArg !== [] && $scope.checkDetailDeleteSave && $scope.checkDetailDeleteSave === 3) {
                $scope.ctrlDirettiva.deleteCallback();
                $scope.abilitaPulsanteDelete();
            } else if ($scope.ctrlDirettiva.detailArg !== [] && $scope.checkDetailDeleteSave && $scope.checkDetailDeleteSave === 4) {
                $scope.ctrlDirettiva.customActionCallback();
            }
        });

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


        $scope.$watch('ctrlDirettiva.dati', function () {
            $scope.abilitaPulsanteDelete();
            if ($scope.ctrlDirettiva.dati && $scope.ctrlDirettiva.dati.length > 0) {
                //normalizzare data start
                if (!$scope.normalize) {
                    $scope.normalize = true;
                    angular.forEach($scope.ctrlDirettiva.customHeader, function (value) {
                        if (value.sort && value.sort === "number") {
                            angular.forEach($scope.ctrlDirettiva.dati, function (item) {
                                if (item[value.key]) {
                                    item['number' + value.key] = parseInt(item[value.key]);
                                }
                            });
                        } else if (value.type === "data" && value.pattern === "dd/MM/yyyy") {
                            angular.forEach($scope.ctrlDirettiva.dati, function (item) {
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
                            angular.forEach($scope.ctrlDirettiva.dati, function (item) {
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

                $scope.pagine = $scope.ceil($scope.ctrlDirettiva.dati.length / $scope.numList);
                $scope.totalItems = $scope.ctrlDirettiva.dati.length;
                if ($scope.pagine > 0) {
                    $scope.begin = 1;
                    $scope.pageBasic = 1;
                }
            } else {
                $scope.pagine = 0;
                $scope.totalItems = 0;
            }
        });

   $scope.rowSelected = function(item){
       $log.debug("directive callback ...");
        if($scope.ctrlDirettiva.rowSelectionCallback && angular.isFunction($scope.ctrlDirettiva.rowSelectionCallback())){
            $log.debug("directive callback ...");
            $scope.ctrlDirettiva.rowSelectionCallback()(item);
        }
    };

	
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
		
		// START SALVATAGGIO FILTRI
		$scope.salvataggioFiltriPaginazione = function(){
			$rootScope.salvataggioFiltriPaginazione={};
			$rootScope.salvataggioFiltriPaginazione.customHeader=$scope.ctrlDirettiva.customHeader;
			$rootScope.salvataggioFiltriPaginazione.search=$scope.search;
			$rootScope.salvataggioFiltriPaginazione.arrow=$scope.arrow;
			$rootScope.salvataggioFiltriPaginazione.searchHeader=$scope.searchHeader;
			$rootScope.salvataggioFiltriPaginazione.Paginazione={};
			$rootScope.salvataggioFiltriPaginazione.Paginazione.numList=$scope.numList;
			$rootScope.salvataggioFiltriPaginazione.Paginazione.begin=$scope.begin;
			$rootScope.salvataggioFiltriPaginazione.Paginazione.pageBasic=$scope.pageBasic;
			$rootScope.salvataggioFiltriPaginazione.reverse=!$scope.reverse;
			$rootScope.salvataggioFiltriPaginazione.predicate=$scope.predicate;
		};
		
		$scope.inizializzazioneFiltriPaginazione = function(){
			if($rootScope.salvataggioFiltriPaginazione && $rootScope.salvataggioFiltriPaginazione.customHeader && $rootScope.salvataggioFiltriPaginazione.tipologia===$scope.ctrlDirettiva.tipologia){
				  $scope.ctrlDirettiva.customHeader=$rootScope.salvataggioFiltriPaginazione.customHeader;
				  $scope.search=$rootScope.salvataggioFiltriPaginazione.search;
				  $scope.arrow=$rootScope.salvataggioFiltriPaginazione.arrow;
				  $scope.searchHeader=$rootScope.salvataggioFiltriPaginazione.searchHeader;
				  $scope.numList = $rootScope.salvataggioFiltriPaginazione.Paginazione.numList;
				  $scope.begin = $rootScope.salvataggioFiltriPaginazione.Paginazione.begin;
				  $scope.reverse = $rootScope.salvataggioFiltriPaginazione.reverse;
				  $scope.predicate = $rootScope.salvataggioFiltriPaginazione.predicate;
			  }
		};
		
		$scope.calcoloFiltriPaginazione = function(){
			 if($rootScope.salvataggioFiltriPaginazione && $rootScope.salvataggioFiltriPaginazione.customHeader && $rootScope.salvataggioFiltriPaginazione.tipologia===$scope.ctrlDirettiva.tipologia){
				  $scope.searching();
				  $scope.begin = $rootScope.salvataggioFiltriPaginazione.Paginazione.begin;
				  $scope.pageBasic = $rootScope.salvataggioFiltriPaginazione.Paginazione.pageBasic;
				  if($scope.predicate){
					  $scope.order($scope.predicate);
				  }
			  }
		};
		
		$scope.inizializzazioneFiltriPaginazione();
		// END SALVATAGGIO FILTRI	
    }
})();
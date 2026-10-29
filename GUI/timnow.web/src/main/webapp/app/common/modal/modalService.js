/**modal service**/
angular.module('common').service('modalService', ['$uibModal', '$state',  function ($uibModal, $state) {
    'use strict';
   
    // contentType  table_ro table read only table_sb  table single binding
    var modalDefaults = {
        backdrop: true,
        keyboard: true,
        modalFade: true,
        templateUrl: 'app/common/modal/modal.tpl.html'
    };

    var modalOptions = {
        actionButtonText: 'OK',
        headerText: 'Conferma operazione',
        bodyText: 'Sei sicuro?'
    };

    this.showModal = function (customModalDefaults, customModalOptions) {
        if (!customModalDefaults) {
            customModalDefaults = {};
        }
        customModalDefaults.backdrop = 'static';
        return this.show(customModalDefaults, customModalOptions);
    };

    this.show = function (customModalDefaults, customModalOptions) {
        //Create temp objects to work with since we're in a singleton service
        var tempModalDefaults = {};
        var tempModalOptions = {};

        //Map angular-ui modal custom defaults to modal defaults defined in service
        angular.extend(tempModalDefaults, modalDefaults, customModalDefaults);

        //Map modal.html $scope custom properties to defaults defined in service
        angular.extend(tempModalOptions, modalOptions, customModalOptions);

        if (!tempModalDefaults.controller) {
            tempModalDefaults.controller = ['$scope', '$uibModalInstance', '$log', function ($scope, $uibModalInstance, $log) {
            	
            	$scope.modalOptions = tempModalOptions;
            	$scope.campiDiRicerca = [];
            	$scope.searchAdvance = function(){
            		if (customModalOptions.search) {
                    if (angular.isFunction(customModalOptions.scope[customModalOptions.search])) customModalOptions.scope[customModalOptions.search]($scope.campiDiRicerca.inputSearch);
                }
            	$uibModalInstance.close();
            	};
            	$scope.closeSearch = function(){
            		if (customModalOptions.xback) {
                        if (angular.isFunction(customModalOptions.scope[customModalOptions.xback])) customModalOptions.scope[customModalOptions.xback]();
                    }
            		$uibModalInstance.close();
            	};
            	
                $scope.modalOptions.ok = function (result) {
                    if (customModalOptions.callbackFunction) {
                        if (angular.isFunction(customModalOptions.scope[customModalOptions.callbackFunction])) customModalOptions.scope[customModalOptions.callbackFunction](result);
                    }
                    $uibModalInstance.close(result);
                };
                $scope.modalOptions.close = function (result) {

                    if (customModalOptions.action && customModalOptions.action === 'go_home') {
                        $uibModalInstance.dismiss('cancel');
                        $state.go('root.homepage');
                    }
                    $uibModalInstance.dismiss('cancel');
                };

                $scope.modalOptions.selectionItem = function (item) {
                    if (!$scope.modalOptions.disableAttributeKey || !item[$scope.modalOptions.disableAttributeKey]) {
                        $uibModalInstance.dismiss('cancel');
                        if (angular.isFunction(customModalOptions.scope[customModalOptions.callbackFunction])) customModalOptions.scope[customModalOptions.callbackFunction](item);
                        return (item);
                    } 
                };
                $log.info($scope.modalOptions);
            }];
        }


        return $uibModal.open(tempModalDefaults).result;
    };

    this.alertSearchError = function () {

        return this.showModal({},
            {
                headerText: "Errore",
                bodyText: "Non e' stato possibile effettuare la ricerca. Prova piu' tardi.",
                actionButtonText: 'Chiudi',
                type: 'warning'
            });
    };
    this.alertOkMessage = function (message) {

        return this.showModal({},
            {
                headerText: "Avviso",
                bodyText: message,
                actionButtonText: 'Chiudi',
                type: 'warning'
            });
    };
}]);

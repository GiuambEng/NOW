timnow
    .controller('rimodulazioniDACController', ['$scope', '$state', '$rootScope', '$log', 'MonitoraggioRimodulazioniDAC', 'modalService', function ($scope, $state, $rootScope, $log, MonitoraggioRimodulazioniDAC, modalService) {

        function init() {
            $rootScope.pageClass = $state.params.pageClass;
            $scope.tipologia = $state.params.tipologia;
            $log.info('rimodulzioni DAC');

            //solo singola lista
            $scope.rimodulazioniDacList ="";
            $scope.errorMessage = "Rimodulazioni Dac";
            
            //SM_8906
            $scope.vista = $rootScope.VIEW.MONITORAGGIO_DAC;
            $scope.loadDACInfo();
            
            //RU_935
            $scope.downloadFilePermission = $rootScope.canDownloadFiles();
            
          }
        
          $scope.loadDACInfo = function (refresh) {
              var parameters = {};
              if(refresh){
                  parameters.operation = "refresh";
              }
              MonitoraggioRimodulazioniDAC.get(parameters).$promise.then(
                      function (data) {
                          if (data){
                              $scope.refreshDisabilitato = data.statoRefresh;
                              if(refresh){
                                  modalService.showModal( {}, {
                                      headerText: "Rimodulazioni Dac",
                                      bodyText: data.descStatoRefresh,
                                      actionButtonText: 'Chiudi',
                                      type: 'warning'
                                  } );
                              }else{
                                  $scope.rimodulazioniDac = data.dacInfo;
                                  $scope.operatore = data.operatore;
                                  $scope.dataScadenza = data.dataScadenza;
                              }
                          }                    
                      }, function (error) {
                          //todo
                      });
              
          };
         init();
         
         /* EXPORT DATI */

  
         $scope.refresh = function () {
             $scope.loadDACInfo(true);
             

         };
         

    }]);



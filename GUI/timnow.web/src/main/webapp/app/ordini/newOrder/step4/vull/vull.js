timnow.controller('vull', ['$scope', '$state', '$rootScope', '$log', 'modalService','$filter', function ($scope, $state, $rootScope, $log,  modalService, $filter ) {
	if($rootScope.data.step1.causale_ordine==='variazione'){
    	if($rootScope.data.step4){
    		$scope.data.step4=$rootScope.data.step4;
        }
    }
	
	if (!$rootScope.data.step4) {
        $rootScope.data.step4 = $scope.data.step4 = {};
    }
    //$log.info($rootScope.topDetails);
    $scope.tipoOfferta = $rootScope.formData.offers[0].idOfferta;
    //$log.info($rootScope.topDetails);

    $scope.salvaConfigurazioneOfferta = function () {
    	 $rootScope.formData.data.step4 = $rootScope.data.step4 = $scope.data.step4;
    	 if($rootScope.data.step1.causale_ordine === 'variazione'){
         	$state.go($scope.checkNextStateVariazione());
         }else {
         	 $state.go($scope.checkNextState());
         }
    };

    $scope.submit_4 = function () {
        $rootScope.data.step4 = $scope.data.step4;

        $scope.salvaConfigurazioneOfferta();
        $scope.controlloBozza(5);
    };

    /* Sezione Migrazione Start */

    // datepicker
       $scope.setDate = function (year, month, day) {
           $scope.dt = new Date(year, month, day);
       };

       $scope.formats = ['dd/MM/yyyy', 'shortDate'];
       $scope.format = $scope.formats[0];

       function getDayClass(data) {
           var date = data.date, mode = data.mode;
           if (mode === 'day') {
               var dayToCheck = new Date(date).setHours(0,
                   0, 0, 0);

               for (var i = 0; i < $scope.events.length; i++) {
                   var currentDay = new Date(
                       $scope.events[i].date)
                       .setHours(0, 0, 0, 0);

                   if (dayToCheck === currentDay) {
                       return $scope.events[i].status;
                   }
               }
           }
           return '';
       }

       $scope.today = function () {
           $scope.dt = new Date();
       };

       $scope.clear = function () {
           $scope.dt = null;
       };

       $scope.inlineOptions = {
           customClass: getDayClass,
           minDate: new Date(),
           showWeeks: false
       };

       $scope.dateOptions = {
           dateDisabled: disabled,
           formatYear: 'yy',
           maxDate: new Date(2500, 5, 22),
           minDate: new Date(),
           startingDay: 1
       };

       // Disable weekend selection
       function disabled(data) {
           var date = data.date, mode = data.mode;
           return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
       }

       $scope.toggleMin = function () {
           $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
           $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
       };

       $scope.toggleMin();
       
       $scope.openDP1 = function () {
           $scope.popup_dp1.opened = true;
       };

       $scope.openDP2 = function () {
           $scope.popup_dp2.opened = true;
       };

       $scope.popup_dp1 = {
           opened: false
       };

       $scope.popup_dp2 = {
           opened: false
       };
       
       $scope.caricaDac = true;
    /* Sezione Migrazione End */
}]);
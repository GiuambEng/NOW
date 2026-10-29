//RU_1462
timnow.controller('fiberstreamAttivazioneStep7', ['$scope', '$state', '$rootScope', 'modalService', '$uibModal', 'RecuperaNomiServiziAggiuntiviFiberstream', '$timeout',
	function ($scope, $state, $rootScope, modalService, $uibModal, RecuperaNomiServiziAggiuntiviFiberstream, $timeout) {
		
	$scope.serviziAggiuntivi = [];
	$scope.maxLengthServiziAggiuntivi = 10;
		
	$scope.init = function(){
	 	if(!$scope.data.step7.datiServiziAggiuntivi || $scope.data.step7.datiServiziAggiuntivi.length == 0){
    		$scope.data.step7.datiServiziAggiuntivi = [{
    			id: 1,
    			nomeServizio: null,
    			informazioniServizio: null,
    			vincoloServizio: null,
    			apparati: []
    		}];
    	}		
		$scope.configureNomiServiziAggiuntivi();
	}
	
	/*** INIZIO SEZIONE SERVIZI AGGIUNTIVI ***/
	
	$scope.configureNomiServiziAggiuntivi = function(){
		$scope.listaNomiServiziAggiuntivi = [];
		RecuperaNomiServiziAggiuntiviFiberstream.get().$promise
		.then(function(response){
			if(response.result.code !== 0){
				$scope.erroreService("Errore nel recupero dati Nome Servizio");		
			}else{
				$scope.listaNomiServiziAggiuntivi = response.data;		
			}
		}, function(error){
			$scope.erroreService("Errore nel recupero dati Nome Servizio");	
		});
	}
	
	//La sezione Servizi Aggiuntivi, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isServiziAggiuntiviRequired = function(form){
    	$timeout(function(){
        	if(form){
        		if((form.nomeServizio.$modelValue && form.nomeServizio.$modelValue !== "") 
        				|| (form.informazioniServizio.$modelValue && form.informazioniServizio.$modelValue !== "")
        				|| (form.vincoloServizio.$modelValue && form.vincoloServizio.$modelValue !== "")){
        			$scope.isServiziOpzionaliRequiredFlag = true;
        		}else{
        			$scope.isServiziAggiuntiviRequiredFlag = false;
        		}
        	} else{
    			$scope.isServiziAggiuntiviRequiredFlag = false;
    		}
    	}, 100);
    }
    
    $scope.deleteServizioAggiuntivo = function(index){
    	if($scope.data.step7.datiServiziAggiuntivi && $scope.data.step7.datiServiziAggiuntivi.length > 1){
    		$scope.data.step7.datiServiziAggiuntivi.splice(index, 1);
    	}
    	
    	//Riallineamento id servizi
    	if($scope.data.step7.datiServiziAggiuntivi.length == 1){
    		$scope.data.step7.datiServiziAggiuntivi.id = 1;
    	}else{
    		$scope.data.step7.datiServiziAggiuntivi.forEach(function(item, index){
    			item.id = index + 1;
    		});
    	}
    }
    
    $scope.addServizioAggiuntivo = function(event){
		event.preventDefault();
    	if($scope.data.step7.datiServiziAggiuntivi && $scope.data.step7.datiServiziAggiuntivi.length < $scope.maxLengthServiziAggiuntivi){
    		$scope.data.step7.datiServiziAggiuntivi.push({
        		id: $scope.data.step7.datiServiziAggiuntivi.length + 1,
   				nomeServizio: null,
    			informazioniServizio: null,
    			vincoloServizio: null,
    			apparati: []
        	});
    	}
    }
    
    //La sezione Servizi Aggiuntivi, deve essere obbligatoria
    //solo se almeno uno degli altri campi è valorizzato
    $scope.isServiziAggiuntiviRequired = function(form, indexServizio){
    	$timeout(function(){
        	if(form){
        		if((form.nomeServizio.$modelValue && form.nomeServizio.$modelValue !== "") 
        				|| (form.informazioniServizio.$modelValue && form.informazioniServizio.$modelValue !== "")
        				|| (form.vincoloServizio.$modelValue && form.vincoloServizio.$modelValue !== ""
        				|| ($scope.data.step7.datiServiziAggiuntivi[indexServizio].apparati && $scope.data.step7.datiServiziAggiuntivi[indexServizio].apparati.length > 0))){
        			$scope.isServiziAggiuntiviRequiredFlag = true;
        		}else{
        			$scope.isServiziAggiuntiviRequiredFlag = false;
        		}
        	} else{
    			$scope.isServiziAggiuntiviRequiredFlag = false;
    		}
    	}, 100);
    }
    
    /*** FINE SEZIONE SERVIZI AGGIUNTIVI ***/
    
    
    /*** INIZIO SEZIONE APPARATI ***/
    
    $scope.aggiungiApparato = function(event, indexServizio){
		event.preventDefault();
		
		var _modalConfig = {
      		animation: true,
      		ariaLabelledBy: 'modal-title',
      		ariaDescribedBy: 'modal-body',
      		templateUrl: 'app/ordini/newOrder/step7/fiberstream/modal/newApparatoFiberstream.modal.html',
      		controller: 'newApparatoFiberstreamCtrl',
      		controllerAs: '$ctrl',
      		backdrop: 'static',
      		size: 'lg',
      		resolve: {
				//Parametri in input alla modale
        		inputDatiServizio: function () {
          			return {
						indexServizio: indexServizio				
					};
        		}
      		}
    	};
    	
    	var _modalInstance = $uibModal.open(_modalConfig);
    	
    	_modalInstance.result.then(function (newApparato) {
      			$scope.selected = newApparato;
      			$scope.data.step7.datiServiziAggiuntivi[indexServizio].apparati.push(newApparato);
      			
    		}, function () {
      			console.log('Modal dismissed at: ' + $scope.selected);
    	});
	}
	
	$scope.eliminaApparato = function(indexServizio, indexApparato){
		$scope.data.step7.datiServiziAggiuntivi[indexServizio].apparati.splice(indexApparato, 1); 
	}
	    
    /*** FINE SEZIONE APPARATI ***/   
	
	
	/*** Inizio sezione Datepicker ***/

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
    $scope.dateOptions = {
        formatYear: 'yy',
        minDate: new Date(),
        startingDay: 1
    };

    $scope.openDP = function () {
        $scope.popup_dp.opened = true;
    };

    $scope.popup_dp = {
        opened: false
    };
    
    /*** Fine sezione Datepicker ***/
    
    $scope.submitFormFiberstream = function(event) {
    	event.stopPropagation();
    	
    	//Elimino i dati delle sezioni superflue
        if($scope.data.step7.datiServiziOpzionali && $scope.data.step7.datiServiziOpzionali.length > 0){
	    	$scope.data.step7.datiServiziOpzionali = [];
    	}
    	
    	if($scope.data.step7.datiServiziAggiuntivi && $scope.data.step7.datiServiziAggiuntivi == 1){
			var _sa = $scope.data.step7.datiServiziAggiuntivi[0];
			if((_sa.nomeServizio == null || _sa.nomeServizio == "" ) && 
			   (_sa.vincoloServizio == null || _sa.vincoloServizio == "" ) && 
			   (_sa.informazioniServizio == null || _sa.informazioniServizio == "" )){
				$scope.data.step7.datiServiziAggiuntivi = [];	
			}			
		}
    	
    	$rootScope.formData.data.step7 = $rootScope.data.step7 = $scope.data.step7;
    	
    	$state.go('root.ordini.new.step8');	          
    };
    
    $scope.init();

}]);  
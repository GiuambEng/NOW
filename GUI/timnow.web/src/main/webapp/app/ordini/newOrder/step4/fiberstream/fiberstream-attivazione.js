timnow.controller('fiberstreamAttivazioneStep4', ['$state', '$scope', '$rootScope', 'modalService', 'LineProfiles', '_', 'RecuperaVlanFiberstream', 
    function ($state, $scope, $rootScope, modalService, LineProfiles, _, RecuperaVlanFiberstream) {
	    $scope.vcUser = 1;
	    $scope.visualizzaSpinner = false;
	    
	    $scope.causaleOrdine = ($rootScope.data.step1.causale_ordine || $scope.data.step1.causale_ordine);
	    
	    if (!$rootScope.data.step4){
	    	$rootScope.data.step4 = $scope.data.step4 = {};
	    	$scope.data.step4.vlanusers = [];
			$scope.data.step4.vlanusers.push({
	            'id': 1
        	});
	    }
	    
	    $scope.showUserVlans = false;
	    
	    /*** PROFILO TECNICO LINEA ***/
	    
	    $scope.getLineProfiles = function () {
	        LineProfiles.get({
	            idOfferta: $rootScope.data.step3.offerta.idOfferta,
	        }).$promise.then(
	            function (response) {
	                $rootScope.formData.lineProfiles = response.data;
	                $scope.errorPTL = false;
	            }, function (error) {
	                $scope.errorPTL = "Impossibile caricare i profili linea. Riprovare più tardi";
	            });
	    };
	    
	    /*** INIZIO GESTIONE MODALE RICERCA SERVICE VLAN ***/
	    
	    $scope.configurazioneOffertaCallbackVLAN = function (item) {
			angular.forEach($scope.data.step4.vlanusers, function(vlan){
				if(vlan.id == $rootScope.numItemForModalCallback){
					vlan.SERVICEVLAN = {};
					vlan.SERVICEVLAN.dft = item.codVlan;
				}				
			});
;		}
	    
	    $scope.searchAdvance = function(formModale) {
			if(!formModale){
				formModale = {};
			}
            $scope.visualizzaSpinner = true;
            //Aggiunta dell'OLO selezionato allo step 1 ai filtri di ricerca'
            formModale.codOloAgcom = $scope.data.step1.operatore.codiceOLO;
            RecuperaVlanFiberstream.save({}, formModale).$promise.then(function(response) {
            	if (response.result && response.result.code !== "0") {
                    $scope.erroreService("Nessuna VLAN trovata in base ai criteri utilizzati.");
                } else {
                    if (response) {
                        $rootScope.formData.vlans = response.data;
                        $scope.modalVlan("configurazioneOffertaCallbackVLAN");
                    } else {
                        $rootScope.formData.vlans = [];
                        $scope.erroreService("Nessuna VLAN trovata in base ai criteri utilizzati.");
                    }
                }
                $scope.visualizzaSpinner = false;
            }, function(error) {
            	$rootScope.formData.vlans = [];
                $scope.erroreService("Impossibile caricare le VLAN. Riprovare più tardi");
                $scope.visualizzaSpinner = false;
            });
	    };    
	    
	    $scope.searchVlan = function (event, itemNum) {
			event.preventDefault();
    		$rootScope.formData.vlans = "";
        	$rootScope.numItemForModalCallback = itemNum;        	
        	$scope.modalVlan("configurazioneOffertaCallbackVLAN");
    	};
	    
	    $scope.modalVlan = function(callback){
	    	$scope.returnSearch = callback;
	        $scope.headerSearchVlan = [
	            {"key": "codOloAgcom", "value": "Codifica OAO Agcom", "type": "text"},
	            {"key": "codVlan", "value": "Codice Vlan", "type": "text"},
	            {"key": "provincia", "value": "Provincia", "type": "text"},
	            {"key": "siglaProvincia", "value": "Sigla Provincia", "type": "text"}
	        ];
	        $scope.inputSearch = [
	            {"key": "codiceVlan", "label": "Codice Vlan"},
	            {"key": "provincia", "label": "Provincia"}
	            ];
	
	            $scope.modalOptionsSearchVlan = {
	                headerText: 'Seleziona un elemento',
	                actionButtonText: null,
	                closeButtonText: 'Ok',
	                contentType: 'modale_nowtable_search',
	                scope: $scope,
	                callbackFunction: callback,
	                search: 'searchAdvance',
	                dataSearch: $scope.inputSearch,
	                dataHeader: $scope.headerSearchVlan,
	                data: $rootScope.formData.vlans
	            };
	            modalService.showModal({}, $scope.modalOptionsSearchVlan);
	    };
	    
	    /*** FINE GESTIONE MODALE RICERCA SERVICE VLAN ***/
	    
	    /***  INIZIO GESTIONE VLAN ***/
	    
	    $scope.aggiungiVlan = function () {
	        var _vlanusers = $scope.data.step4.vlanusers;
	        $scope.vcUser = _vlanusers.length;
	        $scope.vcUserID = _vlanusers[_vlanusers.length - 1].id;
	     
	        $scope.vcUserID++;
	        $scope.vcUser++;
	        
	        $scope.data.step4.vlanusers.push({
	            'id': $scope.vcUserID
        	});
    	};
	    
	    $scope.eliminaVlan = function (vlanusers, vlanIndex) {
        	vlanusers.splice(vlanIndex, 1);
        	$scope.data.step4.vlanusers = vlanusers;
    	};
    		    
	    /*** FINE GESTIONE VLAN ***/
	    
	    //Verifica se per il Profilo tecnico '205M' sono state create 3 Uservlan con tutti i Profili VLAN 0, 1 e 5
	    $scope.verificaUserVlanPerProfiloTecnico = function(){
			if($scope.data.step4.vlanusers.length >= 3){
				var _profiles = _.pluck($scope.data.step4.vlanusers, "PROFILOVLAN");
				var _dft = _.pluck(_profiles, "dft");
				var _intersection = _.intersection(_dft, ['0', '1', '5']);
				return (_intersection.length == 3);
			}
			return false;
		}
		
		$scope.$watch("data.step4.vlanusers", function(newValue, oldValue){
			if(newValue){
				//Disabilita il pulsante Avanti
				var _flagVerificaUserVlan = $scope.verificaUserVlanPerProfiloTecnico();
				$scope.disableNextStep = !_flagVerificaUserVlan;
			}else{
				$scope.disableNextStep = false;
			}
		}, true);
	    
	    $scope.$watch("customizedOffer.offerTopDetails.PROFILOTECNICOLINEA.dft", function(newValue, oldValue){
			if(newValue && newValue === "205M"){
				//visualizza l'alert per le UserVlan
				$scope.showAlertUserVlan = (newValue == "205M");
			}else{	
				$scope.showAlertUserVlan = false;
			}
		
		});
		
		$scope.submit_4 = function(){
			 $state.go($scope.checkNextState());
		}
    
}]);
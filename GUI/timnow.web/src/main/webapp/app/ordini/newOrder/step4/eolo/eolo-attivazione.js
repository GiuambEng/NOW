timnow.controller('eoloAttivazioneStep4', ['$state', '$scope', '$rootScope', 'modalService', '_', 'RecuperaVlanEolo', 'VerificaCoppiaIdVlanCvlan',
    function ($state, $scope, $rootScope, modalService, _, RecuperaVlanEolo, VerificaCoppiaIdVlanCvlan) {
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
	    $scope.errorMsg = '';
	    
	    
	    /*** INIZIO GESTIONE MODALE RICERCA SVLANCODE ***/
	    	    
	    $scope.configurazioneOffertaCallbackVLAN = function (item) {
			angular.forEach($scope.data.step4.vlanusers, function(vlan){
				if(vlan.id == $rootScope.numItemForModalCallback){
					vlan.SVLANCODE = {};
					vlan.SVLANCODE.dft = item.svlanCode;
					vlan.IDVLANOLO = {};
					vlan.IDVLANOLO.dft = item.idVlanOlo;
					vlan.IDVLANEOLO = {};
					vlan.IDVLANEOLO.dft = item.idVlanEolo;
				}				
			});
		}
	    
	    $scope.searchAdvance = function(formModale) {
	        if (!formModale) {
	            $scope.erroreService("Inserire almeno un valore di ricerca");
	        } else {
	            $scope.visualizzaSpinner = true;
	            formModale.codOloAgcom = $scope.data.step1.operatore.codiceOLO;
	            RecuperaVlanEolo.save({}, formModale).$promise.then(function(response) {
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
	        }
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
	            {"key": "idVlanOlo", "value": "IDVLANOLO", "type": "text"},
	            {"key": "svlanCode", "value": "SVLAN CODE", "type": "text"},
	            {"key": "idVlanEolo", "value": "IDVLANEOLO", "type": "text"}
	        ];
	        $scope.inputSearch = [				
	            {"key": "idVlanOlolight", "label": "IDVLANOLO"},
	            {"key": "svlanCodelight", "label": "SVLAN CODE"},
	            {"key": "idVlanEololight", "label": "IDVLANEOLO"}	            
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
	    
	    /*** FINE GESTIONE MODALE RICERCA SVLANCODE ***/  
	    
	    //TODO: richiamare la funzione C04M01F513 – Verifica coppia IDVLANOLO-CVLAN  
	    $scope.verificaCoppiaIdVlanCvlan = function(){
			var _request = {
				offerta: $scope.data.step3.offerta.nomeOffertaCatalogo,
				codOloAgcom: $scope.data.step1.operatore.codiceOLO,
				idVlanOlo: $scope.data.step4.vlanusers[0].IDVLANOLO.dft,
				cvlanId: $scope.data.step4.vlanusers[0].CVLANID.dft
			};
			
			return VerificaCoppiaIdVlanCvlan.save(_request).$promise;			
		}
	   
	    
	    //C11M08F100 - Verifica dominio USERVLANID
	    $scope.$watch('data.step4.vlanusers', function(newValue, oldValue){
			if(newValue && newValue.length > 0){
				if(newValue[0].USERVLANID && newValue[0].USERVLANID.dft){
					//RU_1479
					//RU_1487
					if((newValue[0].USERVLANID.dft >=0 && newValue[0].USERVLANID.dft <=4000 && newValue[0].USERVLANID.dft !== 8) ){
						$scope.disableNextStep = false;
					}
					else{
						$scope.disableNextStep = true;						
					}	
				}
			}
		}, true);
		
		//SM_11421
		$scope.showErrorMessageUserVlan = function(){
			$scope.errorMsg = "Valori ammissibili: da 0 a 7 e da 9 a 4000 (il valore 8 non e' ammesso). Inserire 0 o 1 per configurazione Untagged.";
		}
		
		$scope.onDeleteSvlanCode = function(){
			$scope.data.step4.vlanusers[0].SVLANCODE.dft = null;
			$scope.data.step4.vlanusers[0].IDVLANOLO.dft = null;
			$scope.data.step4.vlanusers[0].IDVLANEOLO.dft = null;
		}
				
		$scope.submit_4 = function(){
			if($scope.RU_1475){
				$scope.verificaCoppiaIdVlanCvlan()
				.then(function(response){
					if(response.esito.toUpperCase() === 'KO'){
						$scope.erroreService("Coppia di valori IDVLANOLO - CVLANID gia' presente");
					}else{
						$state.go($scope.checkNextState());
					}				
				}, function(error){
					$scope.erroreService("Impossibile verificare la coppia IDVLANOLO - CVLANID !");
				});						
			}else{
				$state.go($scope.checkNextState());
			}	 
		}
		
		$scope.oscuramento_RU_1475 = function(){
   			$scope.RU_1475 = !$rootScope.OSCURAMENTI.RU_1475.oscurato;
		}
		
		$scope.oscuramento_RU_1475();
    
}]);
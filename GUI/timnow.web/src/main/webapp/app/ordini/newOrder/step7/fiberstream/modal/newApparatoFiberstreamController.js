//RU_1462
timnow.controller("newApparatoFiberstreamCtrl", ['$uibModalInstance', 'modalService', 'inputDatiServizio', 'RecuperaApparatiFiberstream', 'RecuperaTipologiaApparatoFiberstream',
	function($uibModalInstance, modalService, inputDatiServizio, RecuperaApparatiFiberstream, RecuperaTipologiaApparatoFiberstream){
		
	var $ctrl = this;
	
	$ctrl.servizio = inputDatiServizio;
	
	$ctrl.apparato = {
		qtaApparato: 1
	};

	
	$ctrl.aggiungi = function() {
		 $uibModalInstance.close($ctrl.apparato); 
	};
	
	$ctrl.chiudi = function(){
		$uibModalInstance.dismiss("close");
	};
	
	/*** INIZIO GESTIONE MODALE RICERCA CODICE APPARATO ***/
	    
	$ctrl.configurazioneCodiceApparatoCallback = function (item) {
		$ctrl.apparato.codiceApparato = item.codNMU;
		$ctrl.apparato.idServizioAggiuntivo = $ctrl.servizio.indexServizio + 1;
				
		RecuperaTipologiaApparatoFiberstream.get({'codiceNMU': item.codNMU}).$promise
		.then(function(result){
			if (response.result && response.result.code === "2") {
                    $ctrl.erroreService("Nessuna Tipologia Apparato trovata per codice apparato " + item.codNMU);
                } else {
					$ctrl.apparato.tipologiaApparato = result.tipologiaApparato;
				}			
			}, function(error){
				$ctrl.erroreService("Impossibile caricare i valori per Tipologia Apparato. Riprovare più tardi");
				$ctrl.apparato.tipologiaApparato = null;			
		});	
	}
	    
    $ctrl.searchAdvance = function(formModale) {
        if (!formModale) {
            $ctrl.erroreService("Inserire un valore di ricerca");
        } else {
            RecuperaApparatiFiberstream.get({'codiceNMULight': formModale.codNMU}).$promise
            .then(function(response) {
            	if (response.result && response.result.code !== "0") {
                    $ctrl.erroreService("Nessun Codice Apparato trovato in base ai criteri utilizzati.");
                } else {
                    if (response) {
						$ctrl.codici = response.data;
					    //Re-mapping da array di stringhe ad array di oggetti 
					    //per visualizzazione in tabella
					    $ctrl.codiciApparati = _.map($ctrl.codici, function(item){
							return ({'codNMU' : item});
						});		
						$ctrl.modalCodiceApparato("configurazioneCodiceApparatoCallback");
                    } else {
                        $ctrl.codiciApparati = [];
                        $ctrl.erroreService("Nessun Codice Apparato trovato in base ai criteri utilizzati.");
                    }
                }
            }, function(error) {
				$ctrl.codici = [];
            	$ctrl.codiciApparati = [];
                $ctrl.erroreService("Impossibile caricare i valori per Codice Apparato. Riprovare più tardi");
            });
        }
    };    
    
    $ctrl.searchCodiceApparato = function (event) {
		event.preventDefault();
		$ctrl.codiciApparati = [];      	
    	$ctrl.modalCodiceApparato("configurazioneCodiceApparatoCallback");
	};
    
    $ctrl.modalCodiceApparato = function(callback){
    	$ctrl.returnSearch = callback;
        $ctrl.headerSearchCodiceApparato = [
            {"key": "codNMU", "value": "Codice Apparato", "type": "text"}
        ];
        $ctrl.inputSearch = [ 
            {"key": "codNMU", "label": "Cod. Apparato"}
            ];

            $ctrl.modalOptionsSearchCodiciApparati = {
                headerText: 'Seleziona un elemento',
                actionButtonText: null,
                closeButtonText: 'Ok',
                contentType: 'modale_nowtable_search',
                scope: $ctrl,
                callbackFunction: callback,
                search: 'searchAdvance',
                dataSearch: $ctrl.inputSearch,
                dataHeader: $ctrl.headerSearchCodiceApparato,
                data: $ctrl.codiciApparati
            };
            modalService.showModal({}, $ctrl.modalOptionsSearchCodiciApparati);
    };
	    
	/*** FINE GESTIONE MODALE RICERCA SERVICE VLAN ***/

	$ctrl.erroreService = function(messageBody){
 	   modalService.showModal({}, {
    	    headerText: "Avviso",
        	closeButtonText: 'Chiudi',
        	bodyText: messageBody,
        	scope: $scope,
        	type: 'success'
    	});
    }

	
}]);
timnow
    .controller('vlanSvlan', ['$scope', '$state', '$rootScope', 'lans', '$log', 'modalService', 'AdvancedSearchGetDati', 'alertService', 'TRACKING_GUI', 'TrackingGUI', 
    	function ($scope, $state, $rootScope, lans, $log, modalService, AdvancedSearchGetDati, alertService, TRACKING_GUI, TrackingGUI) {
        $rootScope.pageClass = $state.params.pageClass;
        $scope.tipologia = $state.params.tipologia;
        $scope.enableRicercaVlanSvlan=true;

        //solo singola lista
        $scope.lans = [];
        $scope.lansLoaded = false;
        $scope.headerList = [];
        $scope.headerList.push({"key": "codicevlan", "value": "Codice VLAN", "type": "text"});
        $scope.headerList.push({"key": "flagencapsulation", "value": "flag encapsulation", "type": "checkbox"});
        $scope.headerList.push({"key": "tipologia", "value": "Tipologia", "type": "text"});
        $scope.headerList.push({"key": "stato", "value": "Stato", "type": "text"});
        $scope.headerList.push({"key": "nome", "value": "Nome", "type": "text"});
        $scope.headerList.push({"key": "idvlanolo", "value": "ID VLAN OLO", "type": "text", "sort": "number"});

        $scope.detailList = [];
        $scope.detailList.push({"key": "tipobanda", "value": "Tipo Banda", "type": "text"});
        $scope.detailList.push({"key": "tipocos", "value": "Tipo COS", "type": "text"});
        $scope.detailList.push({"key": "clli", "value": "CLLI", "type": "text"});
        $scope.detailList.push({"key": "nomecentrale", "value": "Nome Centrale", "type": "text"});
        $scope.detailList.push({"key": "codicekit", "value": "Codice KIT", "type": "text"});
        $scope.detailList.push({"key": "dslamtype", "value": "DSLAM type", "type": "text"});
        $scope.detailList.push({"key": "dec", "value": "DEC", "type": "text"});
        $scope.detailList.push({"key": "decattivazione", "value": "Dec Attivazione", "type": "text"});
        $scope.detailList.push({"key": "codiceareadiraccolta", "value": "Codice area di raccolta", "type": "text"});
        $scope.detailList.push({"key": "descareadiraccolta", "value": "Desc Area di raccolta", "type": "text"});
        $scope.detailList.push({"key": "codicemacroarea", "value": "Codice Macro area", "type": "text"});
        $scope.detailList.push({"key": "descmacroarea", "value": "Desc Macro area", "type": "text"});
        $scope.detailList.push({"key": "codicesupermacroarea", "value": "Codice Super Macro area", "type": "text"});
        $scope.detailList.push({"key": "descsupermacroarea", "value": "Desc super macro area", "type": "text"});
        $scope.detailList.push({"key": "tipotrasporto", "value": "Tipo trasporto", "type": "text"});
        $scope.detailList.push({"key": "flagvlantaslation", "value": "Flag VLAN translation", "type": "checkbox"});
        //RU_963
        $scope.detailList.push({"key": "tipologiaClusterComune", "value": "Marcaggio Comune", "type": "text"});
        $scope.detailList.push({"key": "flagFtthOnly", "value": "Flag FTTH Only", "type": "checkbox"});

        
        var isInitTrue = $state.params.init;
        //check if $state.params.init == true
        if ((isInitTrue) && $rootScope.RicercaAdvVlanSvlan) {
            delete $rootScope.RicercaAdvVlanSvlan;
        }
        
        init();

        function init() {
	       	 alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare il profilo VLAN/SVLAN di interesse.","danger",10000);
	         $scope.lansLoaded = true;
        }
        
        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }
        
        $scope.tipologiaRicerca = 'VLAN SVLAN';
        $scope.getSearchAdvanced = function () {
        	$scope.enableRicercaVlanSvlan=false;
            $scope.lansLoaded = false;

            if ($scope.paramToSearch.length > 0) {
            	
            	//RU_1010
                //Tracking da GUI per operazione RICERCA AVANZATA
                var _trackBean = {
    	    			timestampInizio: new Date().toISOString(),
    	    			timestampFine: null,
    	    			numeroDatiEsportati: 0,
    	    			contenutoFile: null,
    	    			descrizioneFunzione: 'Amministrazione|VLAN/SVLAN',
    	    			nomeFile: null,
    	    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    	    			parametriOperazione: JSON.stringify($scope.paramToSearch) 			
                };
            	
                $rootScope.RicercaAdvVlanSvlan = $scope.paramToSearch;

                var vlansvlan = AdvancedSearchGetDati.save({
                    type: 'lans'
                }, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                vlansvlan.$promise.then(function (data) {
                	
                	_trackBean.timestampFine = new Date().toISOString();
                	
                    if (data.result.code < 0) {
                        modalService.alertSearchError();
                        
                        _trackBean.esito = 'Ko';                        
                        TrackingGUI.tracking(_trackBean);
                        
                        return false;
                    }
                    if (data.data){
                        $scope.lans = data.data;
                        
                        _trackBean.esito = 'Ok';                        
                        TrackingGUI.tracking(_trackBean);
                    }
                    $scope.lansLoaded = true;
                }, function (error) {
                    $log.debug(error);
                    modalService.alertSearchError();
                    $scope.lansLoaded = true;
                    
                    _trackBean.timestampFine = new Date().toISOString();
                    _trackBean.esito = 'Ko';                        
                    TrackingGUI.tracking(_trackBean);
                });
            } else {
            	delete $rootScope.RicercaAdvVlanSvlan;
                init();
            }
        };

    }]);
timnow.controller('tracciamenoeStato', ['$scope', '$state', '$rootScope', '$log', '$resource', 'TracciamentoStato' ,'CRM_ORD_SUB_PROFILE', 'CRM_PROFILE', 'modalService',
    function ($scope, $state, $rootScope, $log, $resource, TracciamentoStato, CRM_ORD_SUB_PROFILE, CRM_PROFILE, modalService) {
	
	 $scope.idRichiestaOlo = $state.params.idRichiestaOlo;
     $scope.reqType = $state.params.reqType;
     var ut_profile = $rootScope.timnowConfigData.user.codiceProfilo;
     
     $scope.headerTraccStato = [];
     $scope.traccStatoLoaded = false;
     
     $scope.headerTraccStato.push({"key": "timestampTracciamento", "value": "Timestamp Inserimento", "type": "text"});
    
     if (CRM_ORD_SUB_PROFILE.hasOwnProperty(ut_profile)) {
         $scope.headerTraccStato.push({"key": "statoNOWDA", "value": "Stato NOW DA", "type": "text"});
         $scope.headerTraccStato.push({"key": "statoNOWA", "value": "Stato NOW A", "type": "text"});
         $scope.visibilitaProfiliDG = true;
     }

     if (ut_profile === CRM_PROFILE.CRM_OLO || ut_profile === CRM_PROFILE.CRM_OLORO) {
         $scope.visibilitaProfiliNonOlo = true;
     }
     $scope.headerTraccStato.push({"key": "statoOLODA", "value": "Stato OLO DA", "type": "text"});
     $scope.headerTraccStato.push({"key": "statoOLOA", "value": "Stato OLO A", "type": "text"});
     $scope.headerTraccStato.push({"key": "dacDA", "value": "DAC DA", "type": "text"});
     $scope.headerTraccStato.push({"key": "dacA", "value": "DAC A", "type": "text"});

     $scope.tipologia = "Tracciamento e Stato";

     
	 TracciamentoStato.get({
         idRichiestaOlo: $scope.idRichiestaOlo,
         inizioTracciamento: $state.params.inizioTracciamento,
         fineTracciamento: $state.params.fineTracciamento
     }).$promise.then(function (data) {
             if (data) {
                 $scope.traccStatoDettaglio = data.data;
             }
             $scope.traccStatoLoaded = true;
         }, function (error) {
             $log.error(error);
             $scope.traccStatoDettaglio = [];
             $scope.traccStatoLoaded = true;
         });
	 
	 $scope.getDettaglioTraccStato = function(item){
		 $scope.headerTracciamentoeStatoDett = [];

	     
	     if (CRM_ORD_SUB_PROFILE.hasOwnProperty(ut_profile)) {
	     $scope.headerTracciamentoeStatoDett.push({"key": "descCausaleNow", "value": "descCausaleNow", "type": "text"});
	     }
	     if (ut_profile === CRM_PROFILE.CRM_OLO || ut_profile === CRM_PROFILE.CRM_OLORO) {
	     $scope.headerTracciamentoeStatoDett.push({"key": "descCausaleOlo", "value": "descCausaleOlo", "type": "text"});
	     }
	     $scope.headerTracciamentoeStatoDett.push({"key": "codOloAgcomDestinatario", "value": "Codifica Olo Agcom", "type": "text"});
	     $scope.headerTracciamentoeStatoDett.push({"key": "descTipoDestinatario", "value": "descTipoDestinatario", "type": "text"});
	     $scope.headerTracciamentoeStatoDett.push({"key": "descTipoNotif", "value": "descTipoNotif", "type": "text"});
	     $scope.headerTracciamentoeStatoDett.push({"key": "tracciatoFile", "value": "tracciatoFile", "type": "text"});
	    

		 var dettaglio = [];
		 dettaglio.push(item);
		 if (item.tracciatoFile){
			 $scope.modalTracciamentoeStatoDett = {
			            headerText: "Dettaglio Tracciamento Stato",
			            actionButtonText: null,
			            closeButtonText: 'Ok',
			            contentType: 'modale_nowtable_scroll',
			            scope: $scope,
			            callbackFunction: 'datiOrdineCallbackContract',
			            dataHeader: $scope.headerTracciamentoeStatoDett,
			            templateUrl: 'app/common/templates.html',
			            data: dettaglio,
			            disableAttributeKey: $scope.disableAttributeKeyContracts
			        };
			 modalService.showModal({}, $scope.modalTracciamentoeStatoDett);
		 }
	  
	 };
	 
	 $scope.changeState = function () {
         //Variabile salvataggioFiltriPaginazione.tipologia deve essere aggiunta per
         //Gestire il back con i relativi salvataggi dei filtri light e della paginazione
         //la variabile va settata nel file app.routes
         //Per parametriRicerca invece viene gestita la ricerca avanzata
     	//$log.debug($state.current.name);
 		if($state.params.parametriRicerca!==""){
     		$rootScope.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
             $state.go($rootScope.fromState, {
                 parametriRicerca: $state.params.parametriRicerca, "init": false
             });
     	}else{
     		$state.go('^');
     	}
     };
    }]);
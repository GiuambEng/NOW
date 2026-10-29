timnow.controller('contrattoDettaglio', ['$scope', '$state', '$rootScope', '$log', 'OSCURAMENTI', 'RecuperaComuniCoinvestiti', 'modalService', '_',
	function ($scope, $state, $rootScope, $log, OSCURAMENTI, RecuperaComuniCoinvestiti, modalService, _) {

	$log.debug("contrattoDettaglio");
	$rootScope.pageClass = $state.current.params.pageClass;
	$scope.contratto = $state.params.contratto;
	$scope.tipologiaMulicast = 'IP Multicast';

	//RU_1202    
	$scope.commonHeaderDatiIpMulticast = [];
	$scope.commonHeaderDatiIpMulticast.push({"key": "dataInserimento", "value": "Data Inserimento", "type": "text"});
	$scope.commonHeaderDatiIpMulticast.push({"key": "dataInizioValidita", "value": "Data Inizio Validità", "type": "text"});
	$scope.commonHeaderDatiIpMulticast.push({"key": "dataFineValidita", "value": "Data Fine Validità", "type": "text"});

	$scope.headerDatiIpSessioneList = [];
	$scope.headerDatiIpSessioneList.push({"key": "ipSessione", "value": "IP Sessione ePGB", "type": "text"});

	$scope.headerDatiIpMulticastList = [];
	$scope.headerDatiIpMulticastList.push({"key": "ipMulticast", "value": "IP Multicast", "type": "text"});

	$scope.headerDatiIpSorgenteList = [];
	$scope.headerDatiIpSorgenteList.push({"key": "ipSorgente", "value": "IP Sorgente", "type": "text"});

	$scope.headerDatiAsNumberList = [];
	$scope.headerDatiAsNumberList.push({"key": "asNumber", "value": "AS Number", "type": "text"});    

	$scope.headerDatiIpSessioneList = _.union($scope.headerDatiIpSessioneList, $scope.commonHeaderDatiIpMulticast);
	$scope.headerDatiIpMulticastList = _.union($scope.headerDatiIpMulticastList, $scope.commonHeaderDatiIpMulticast);
	$scope.headerDatiIpSorgenteList = _.union($scope.headerDatiIpSorgenteList, $scope.commonHeaderDatiIpMulticast);
	$scope.headerDatiAsNumberList = _.union($scope.headerDatiAsNumberList, $scope.commonHeaderDatiIpMulticast);   

	$scope.arrayComuniCoinvestiti = [];

	$scope.changeState = function () {
		$rootScope.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
		$state.go($rootScope.fromState, {parametriRicerca: $state.params.parametriRicerca, "init": false});
	};

	//SM_9996
	$scope.showSezioneFwa = ($scope.contratto.tipoProdotti == 'FWA');

	//RU_1129
	$scope.oscuramento_RU_1129 = function(){
		$scope.RU_1129 = (!OSCURAMENTI.RU_1129.oscurato);
	}

	$scope.oscuramento_RU_1129();

	//RU_1164
	$scope.showSezioneSemi = ($scope.contratto.tipoProdotti == 'FTTH');

	$scope.oscuramento_RU_1164 = function(){
		$scope.RU_1164 = (!OSCURAMENTI.RU_1164.oscurato);
	}

	$scope.oscuramento_RU_1164();
	
	//RU_1276
	$scope.headerComuniCoinvestitiList = [];
	$scope.headerComuniCoinvestitiList.push({"key": "descrComune", "value": "Descrizione", "type": "text"});
	$scope.headerComuniCoinvestitiList.push({"key": "dataInizioCoinvestimento", "value": "Data inizio coinvestimento", "type": "data", "pattern": "dd/MM/yyyy"});
	$scope.headerComuniCoinvestitiList.push({"key": "codiceContratto", "value": "Codice Contratto", "type": "text"});
	$scope.headerComuniCoinvestitiList.push({"key": "codOloAgcom", "value": "Codice Olo", "type": "text"});
	$scope.headerComuniCoinvestitiList.push({"key": "offerta", "value": "Offerta", "type": "text"});
	$scope.headerComuniCoinvestitiList.push({"key": "dataFineCoinvestimento", "value": "Data fine coinvestimento", "type": "data", "pattern": "dd/MM/yyyy"});
	$scope.headerComuniCoinvestitiList.push({"key": "istatComune", "value": "Codice Istat Comune", "type": "text"});

	$scope.recuperaComuniCoinvestimento = function(){
		$scope.arrayComuniCoinvestiti = [];

		//RU_1276
		var _request = {
				idContratto: $scope.contratto.idContratto,
				exportRequest: 'N',
				fileType: null
		};

		RecuperaComuniCoinvestiti.save(_request).$promise    	
		.then(function(response){
			//SM_10070
			if(response.listaComuniCoinvestiti && response.listaComuniCoinvestiti.length > 0){						
				angular.copy(response.listaComuniCoinvestiti, $scope.arrayComuniCoinvestiti);
			}
			$scope.showComuniCoinvestimento();
		}, function(error){
			modalService.showModal({}, {
				headerText: "Avviso",
				bodyText: "Errore nel recupero dati Comuni coinvestiti",
				scope: $scope,
				type: 'success'
			});
		});    	
	}

	//SM_10070
	$scope.showComuniCoinvestimento = function(){
		var _modalConfig = {
				headerText: 'Comuni Coinvestiti',
				actionButtonText: null,
				closeButtonText: 'Ok',
				contentType: 'modale_nowtable_no_selection',
				scope: $scope,
				dataHeader: $scope.headerComuniCoinvestitiList, //SM_10295
				data: $scope.arrayComuniCoinvestiti
		};

		//RU_1276
		if($scope.RU_1276){
			_modalConfig.showExportCsv = true;
			_modalConfig.showExportXls = true;
			_modalConfig.vista = $rootScope.VIEW.CONTRATTO;
			_modalConfig.callbackExportCsv = $scope.iniziaExportCsv;
			_modalConfig.callbackExportXls = $scope.iniziaExportXls;
		}

		modalService.showModal({}, _modalConfig);
	}

	//RU_1202
	$scope.showDatiIpSessione = function(){
		var _modalConfig = {
				headerText: "Sezione Dati Multicast - IP Sessione ePGB",
				actionButtonText: null,
				closeButtonText: 'Ok',
				contentType: 'modale_nowtable_no_selection',
				scope: $scope,
				dataHeader: $scope.headerDatiIpSessioneList,
				data: ($scope.contratto.datiMulticast.datiIpSessione || [])
		};
		modalService.showModal({}, _modalConfig);
	}

	$scope.showDatiIpMulticast = function(){
		var _modalConfig = {
				headerText: "Sezione Dati Multicast - IP Multicast",
				actionButtonText: null,
				closeButtonText: 'Ok',
				contentType: 'modale_nowtable_no_selection',
				scope: $scope,
				dataHeader: $scope.headerDatiIpMulticastList,
				data: ($scope.contratto.datiMulticast.datiIpMulticast || [])
		};
		modalService.showModal({}, _modalConfig);
	}

	$scope.showDatiIpSorgente = function(){
		var _modalConfig = {
				headerText: "Sezione Dati Multicast - IP Sorgente",
				actionButtonText: null,
				closeButtonText: 'Ok',
				contentType: 'modale_nowtable_no_selection',
				scope: $scope,
				dataHeader: $scope.headerDatiIpSorgenteList,
				data: ($scope.contratto.datiMulticast.datiIpSorgente || [])
		};
		modalService.showModal({}, _modalConfig);
	}

	$scope.showDatiAsNumber = function(){
		var _modalConfig = {
				headerText: "Sezione Dati Multicast - AS Number",
				actionButtonText: null,
				closeButtonText: 'Ok',
				contentType: 'modale_nowtable_no_selection',
				scope: $scope,
				dataHeader: $scope.headerDatiAsNumberList,
				data: ($scope.contratto.datiMulticast.datiAsNumber || [])
		};
		modalService.showModal({}, _modalConfig);
	}

	//RU_1213
	$scope.setShowNomeBouquet = function(){
		$scope.showNomeBouquet = !($rootScope.isOLOUser());
	}

	$scope.setShowNomeBouquet();

	//Task #36401
	$scope.setShowSezioneDisabilitazioneServizio = function(){
		if($scope.contratto && !_.isEmpty($scope.contratto.datiSospensioneServizio)){
			$scope.showSezioneDisabilitazioneServizio = true;
		}
	}

	$scope.setShowSezioneDisabilitazioneServizio();
	
	$scope.setShowEmailFwaEolo = function(){
		$scope.showEmailFwaEolo = ($scope.contratto.tipoProdotti === "FWAEOLO");
	}
	
	$scope.setShowEmailFwaEolo();

	//RU_1276
	$scope.oscuramento_RU_1276 = function(){
		$scope.RU_1276 = !OSCURAMENTI.RU_1276.oscurato;
	}

	$scope.oscuramento_RU_1276();
	
	//RU_1276
	if($scope.RU_1276 && $scope.showSezioneSemi){
		$scope.showSezioneComuniCoinvestimento = true;
		$scope.data = {};
		$scope.data.datiComuniCoinvestimento = {};
				
		//$scope.data.datiComuniCoinvestimento.offerta = _offerta.id;
		$scope.data.datiComuniCoinvestimento.codOloAgcom = $scope.contratto.codificaOAO;
		$scope.data.datiComuniCoinvestimento.idContratto = $scope.contratto.idContratto;
	}

	$scope.iniziaExportCsv = function(){
		return $scope.iniziaExport('CSV');
	};

	$scope.iniziaExportXls = function(){
		return $scope.iniziaExport('XLS');
	};

	$scope.iniziaExport = function (fileType) {
		var _request = {
				idContratto: $scope.contratto.idContratto,
				exportRequest: 'Y',
				fileType: fileType
		};

		return RecuperaComuniCoinvestiti.save(_request).$promise;
	};

}]);
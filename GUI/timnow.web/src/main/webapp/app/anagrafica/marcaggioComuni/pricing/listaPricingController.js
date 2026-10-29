//RU_963
timnow.controller('listaMarcaggioComuniPricing', ['alertService', '$scope', '$state', '$rootScope', 'AdvancedSearchGetDati', 'ExportId', 'modalService',
    function (alertService, $scope, $state, $rootScope, AdvancedSearchGetDati, ExportId, modalService) {

        $rootScope.pageClass = 'Marcaggio Comuni';
        $scope.marcaggi = [];
        $scope.datiLoaded = false;
        $scope.headerList = [];
        $scope.detailList = [];
        $scope.tipologia = $state.params.tipologia;
        $scope.tipologiaRicerca = $state.params.tipologia;
        $scope.enableRicercaMarcaggi = true;
        
        if (!$scope.paramToSearch) {
            $scope.paramToSearch = [];
        }

        if ($state.params.init && $rootScope.RicercaAdvListaOrdini) {
            delete $rootScope.RicercaAdvListaOrdini;
        }

        $scope.init = function() {
        	alertService.add("Si invita l'utente ad utilizzare la Ricerca Avanzata per recuperare gli ordini di interesse.","danger",10000);
            $scope.datiLoaded = true;
        }

        $scope.headerList.push({"key": "codiceIstatComune","value": "Codice ISTAT","type": "text"});
        $scope.headerList.push({"key": "tipologiaClusterComune","value": "Marcaggio ","type": "text"});
        $scope.headerList.push({"key": "offerta","value": "Offerta","type": "text"});
        $scope.headerList.push({"key": "dataInizioLiberalizzazione", "value": "Data Inizio Liberalizzazione", "type": "text", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.headerList.push({"key": "dataFineMarcaggioNuoviAccessi", "value": "Data Fine Marcaggio Nuovi Accessi", "type": "text", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.headerList.push({"key": "codicePricing","value": "Codice pricing","type": "text"});
        $scope.headerList.push({"key": "dataInizioValiditaPricing","value": "Validita pricing","type": "text"});
        $scope.headerList.push({"key": "dataFineValiditaPricing", "value": "Data Fine Validità Pricing", "type": "text", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.headerList.push({"key": "versioning","value": "Versioning","type": "text"});        
        
        //Dettagli collapsible
        $scope.detailList.push({"key": "dataInizioMarcaggio", "value": "Data Inizio Marcaggio", "type": "text", "pattern": "dd/MM/yyyy HH:mm:ss"});
        $scope.detailList.push({"key": "descrizioneComune", "value": "Comune", "type": "text"});
                
        $scope.getDettaglioPricing = function(item) {
            $state.go('root.amministrazione.marcaggioComuni.dettaglio', { comune: item });
        };
        
        $scope.getSearchAdvanced = function () {
        	$scope.enableRicercaMarcaggi=false;
        	$scope.marcaggiLoaded = false;

            if ($scope.paramToSearch.length > 0) {
                $rootScope.RicercaAdvListaOrdini = $scope.paramToSearch;

                var ordini = AdvancedSearchGetDati.save({
                    type: 'marcaggioComuni'
                }, {
                    conditions: $scope.paramToSearch,
                    indiceriga: '',
                    numerorighe: ''
                });
                ordini.$promise.then(function (data) {
                    if (data.result.code < 0) {
                        modalService.alertSearchError();
                        return false;
                    }
                    if (data.data)
                    	$scope.marcaggi = data.data;
                    $scope.marcaggiLoaded = true;
                }, function (error) {
                    modalService.alertSearchError();
                    $scope.marcaggiLoaded = true;
                });
            } else {
            	delete $rootScope.RicercaAdvListaOrdini;
            	$scope.init();
            }
        };
        
        $scope.iniziaExportCsv = function(){
        	return $scope.iniziaExport('CSV');
        };
        
        $scope.iniziaExportXls = function(){
        	return $scope.iniziaExport('XLS');
        };
        
        
        $scope.iniziaExport = function (fileType) {
            var bodyData = {};

            if ($scope.paramToSearch.length > 0) {

                bodyData = {
                    "numerorighe": "",
                    "indiceriga": "",
                    "exportRequest": true,
                    "conditions": $scope.paramToSearch,
                    "fileType": fileType
                };
            }
           
            $rootScope.numeroDatiEsportati = $scope.marcaggi.length;

            return ExportId.save({
                entita: 'marcaggioComuni'
            }, bodyData).$promise;

        };


        if ($rootScope.RicercaAdvListaOrdini) {
            $scope.paramToSearch = $rootScope.RicercaAdvListaOrdini;
            $scope.getSearchAdvanced();
        } else {
            $scope.init();
        }

    }]);
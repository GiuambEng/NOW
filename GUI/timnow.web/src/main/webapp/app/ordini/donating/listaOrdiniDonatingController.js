timnow.controller('listaOrdiniDonating', ['$scope', '$state', '$rootScope', 'modalService', 'OrdineDonating', 'TRACKING_GUI', 'TrackingGUI', 
	function ($scope, $state, $rootScope, modalService, OrdineDonating, TRACKING_GUI, TrackingGUI) {

    $rootScope.pageClass = 'lista-ordini-donating';
    
     //RU_1010
     //Tracking da GUI per operazione INSERIMENTO
     $scope._trackBean = {
    			timestampInizio: new Date().toISOString(),
    			timestampFine: null,
    			numeroDatiEsportati: 0,
    			contenutoFile: null,
    			descrizioneFunzione: 'Ordini|Ordini Donating',
    			nomeFile: null,
    			tipoOperazione: TRACKING_GUI.EVENTI.RICERCA_AVANZATA.descrizione,
    			parametriOperazione: JSON.stringify($scope.filters)		
        };
    
    /**
     * Callback per l'inizializzazione delle variabili dello scope.
     */
    $scope.init = function () {
        $scope.tipologia = 'Ordini Donating';
        $scope.loading = false;
        $scope.listLoaded = false;

        $scope.filters = {};
        $scope.appliedFilters = {};
        $scope.list = [];
       
        $scope.listHeaders = [
            {"key": "ordineTI", "value": "Ordine TI", "type": "text"},
            {"key": "statoOAO", "value": "Stato OAO", "type": "text"},
            {"key": "oaoDonating", "value": "OAO Donating", "type": "text"}
        ];

        $scope.restoreSearchIfNeeded()
    };

    $scope.search = function () {

        $scope.list = [];
        $scope.loading = true;
        $scope.listLoaded = true;
        OrdineDonating.get({
                codiceOrdineTI: $scope.filters.codiceOrdine,
                nomeFileNotifica: $scope.filters.nomeFile,
                idRisorsa: $scope.filters.idRisorsa,
                codiceSessione: $scope.filters.codiceSessione})
            .$promise
            .then($scope.successCallback, $scope.errorCallback);
    };
    
    $scope.successCallback = function (response) {
        	
        $scope.loading = false;
        $scope._trackBean.timestampFine = new Date().toISOString();
        	
            if (!response.hasOwnProperty('result') || response.result.code < 0) {
                modalService.alertSearchError();
                
                $scope._trackBean.esito = 'Ko';                
                TrackingGUI.tracking(_trackBean);
                
                return false;
            }
            if (response.data) {
            	$scope._trackBean.esito = 'Ok';            	
            	TrackingGUI.tracking($scope._trackBean);
            	
                $scope.list = response.data;
            }

            $scope.appliedFilters = {
                codiceOrdine: $scope.filters.codiceOrdine,
                nomeFile: $scope.filters.nomeFile,
                idRisorsa:$scope.filters.idRisorsa,
                codiceSessione:$scope.filters.codiceSessione
            };

            $scope.listLoaded = true;
            $scope.loading = false;
    };
        
    $scope.errorCallback = function () {        	
            modalService.alertSearchError();
        	$scope.loading = false;
            
        	$scope._trackBean.timestampFine = new Date().toISOString();
            $scope._trackBean.esito = 'Ko';                
            TrackingGUI.tracking($scope._trackBean);
        };

    /**
     * Callback per reinizializzare la maschera di ricerca e la tabella.
     */
    $scope.clearSearch = function () {
        $scope.init();
    };

    /**
     * Callback per ripristinare i valori della la maschera di ricerca e della
     * tabella nel caso di ritorno dalla pagina di dettaglio.
     */
    $scope.restoreSearchIfNeeded = function () {
        if ($state.params.filters) {
            $scope.filters = $state.params.filters;
            $state.params.filters = null;
            $scope.search();
        }
    };

    /**
     * Callback per il recupero del dettaglio dell'ordine donating selezionato.
     */
    $scope.getDetail = function (item) {
        $state.go('root.ordini.donating.dettaglio', {
            order: item,
            filters: $scope.appliedFilters
        });
    };

    $scope.init();

}]);     
timnow.controller('clienteDettaglio', ['$scope', '$state', '$rootScope', '$log', function ($scope, $state, $rootScope, $log) {
    $log.debug("clienteDettaglio");
    $rootScope.pageClass = $state.current.params.pageClass;
    $scope.cliente = $state.params.cliente;
    $scope.accorpati = $state.params.clientiFiltered;

    //solo singola lista
    $scope.headerList = [{"key": "nome", "value": "OAO", "type": "text"},
        {"key": "ragioneSociale", "value": "Ragione Sociale", "type": "text"},
        {"key": "dataAccorpamento", "value": "Data Accorpamento", "type": "data", "pattern": "dd/MM/yyyy"},
        {"key": "statoAccorpamento", "value": "Stato Accorpamento", "type": "text"}];
    $scope.tipologia = 'Clienti Accorpati';

    $scope.detailList = [{"key": "nome", "value": "Nome", "type": "text"}];

    $scope.changeState = function () {
        //Variabile alvataggioFiltriPaginazione.tipologia deve essere aggiunta per
        //Gestire il back con i relativi salvataggi dei filtri light e della paginazione
        //la variabile va settata nel file app.routes
        //Per parametriRicerca invece viene gestita la ricerca avanzata
//		$rootScope.salvataggioFiltriPaginazione.tipologia=$state.current.params.tipologia;
        $rootScope.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
        $state.go($rootScope.fromState, {parametriRicerca: $state.params.parametriRicerca, "init": false});
    };
}]);
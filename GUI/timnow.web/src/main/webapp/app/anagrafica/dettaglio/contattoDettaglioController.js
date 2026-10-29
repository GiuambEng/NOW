timnow
    .controller('contattoDettaglio', ['$scope', '$state', '$rootScope', '$log', 'Contacts', function ($scope, $state, $rootScope, $log, Contacts) {
        $log.debug("dettaglio contatto page");
        $rootScope.pageClass = $state.current.params.pageClass;
        $scope.contatto = $state.params.contatto;
        $scope.tipologia = 'Riferimenti';
        $scope.riferimenti = [];

        //solo singola lista
        $scope.riferimentiLoaded = false;
        $scope.headerList = [
            {"key": "comune", "value": "Comune", "type": "text"},
            {"key": "particellaTopon", "value": "Particella Toponomastica", "type": "text"},
            {"key": "prov", "value": "Provincia", "type": "text"},
            {"key": "email", "value": "Email", "type": "text"}];

        $scope.errorMessage = "Riferimenti";

        $scope.detailList = [
            {"key": "cap", "value": "CAP", "type": "text"},
            {"key": "indirizzo", "value": "Indirizzo", "type": "text"},
            {"key": "numeroCivico", "value": "Numero Civico", "type": "text"},
            {"key": "numeroMobl", "value": "Cellulare", "type": "text"},
            {"key": "cellulareAlternativo", "value": "Cellulare Alternativo", "type": "text"},
            {"key": "telfFisso", "value": "Telefono Fisso", "type": "text"},
            {"key": "telfFissoAlternativo", "value": "Telefono Alternativo", "type": "text"},
            {"key": "fax", "value": "Fax", "type": "text"},
            {"key": "codIstatIndirizzo", "value": "Codice ISTAT Indirizzo", "type": "text"},
            {"key": "codIstatComune", "value": "Codice ISTAT Comune", "type": "text"},
            {"key": "codIstatProvincia", "value": "Codice ISTAT Provincia", "type": "text"}];

        $scope.getRiferimenti = function () {
            Contacts.get({idcontatto: $scope.contatto.idContatto,references:'references'}).$promise.then(function (data) {
                $scope.riferimenti = data.data;
                angular.forEach($scope.riferimenti, function (field) {
                    if (field.prefissoMobl) {
                        field.numeroMobl = field.prefissoMobl + field.numeroMobl;
                    }
                    if (field.prefissoFisso) {
                        field.telfFisso = field.prefissoFisso + field.telfFisso;
                    }
                });
                $scope.riferimentiLoaded = true;
            }, function (error) {
                $scope.riferimentiLoaded = true;
            });
        };

        $scope.changeState = function () {
            //Variabile alvataggioFiltriPaginazione.tipologia deve essere aggiunta per
            //Gestire il back con i relativi salvataggi dei filtri light e della paginazione
            //la variabile va settata nel file app.routes
            //Per parametriRicerca invece viene gestita la ricerca avanzata
//		$rootScope.salvataggioFiltriPaginazione.tipologia=$state.current.params.tipologia;
            $rootScope.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
            $state.go($rootScope.fromState, {parametriRicerca: $state.params.parametriRicerca, "init": false});
        };

        $scope.getRiferimenti();
    }]);
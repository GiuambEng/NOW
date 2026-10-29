//RU_1188
timnow.controller('dettaglioAssetRaccolta', ['$scope', '$state', '$rootScope', '$log', 'AssetsRaccolta', '$uibModal', function ($scope, $state, $rootScope, $log, AssetsRaccolta, $uibModal) {
	
	//SM_10344
    $scope.changeState = function () {
        $rootScope.impostaTipologiaFiltriRicerca($state.current.params.tipologia);
        $state.go($rootScope.fromState, {parametriRicerca: $state.params.parametriRicerca, init: false});
    };

    $scope.init = function() {
        $rootScope.pageClass = $state.current.params.pageClass;

        $scope.loadDettagli = true;
        
        AssetsRaccolta.detail.get({'idAsset': $state.params.idAsset}).$promise
        .then(function (response) {
        	
        	if(response && response.DettaglioAssetRaccoltaOutput){
        		$scope.dettaglio = response.DettaglioAssetRaccoltaOutput;
        	}
        	
            $scope.loadDettagli = false;
            
        }, function (error) {
            $scope.loadDettagli = false;
            $log.info(error);
        });
    };
    
    $scope.cessazioneAsset = function () {
        $state.go('root.consistenze.asset.cessazione', {id: $state.params.idAsset});
    };
    
    $scope.variazioneAsset = function () {
        	$rootScope.formData = {};
        	$state.go('root.ordini.new.step1', {asset: $scope.dettaglio, "init": true});
    };
    
    $scope.open = function (val, data) {
    	        
        $scope.title = val;
        $scope.item = data;
        
        var _template = "";
        
        switch(val){
        	case 'RACCOLTAVP':
        		_template = 'app/consistenze/dettaglio_asset_raccolta/servizi/raccoltaVp.tpl.html';
        	break;
        	case 'RACCOLTAVLANNGA':
        		_template = 'app/consistenze/dettaglio_asset_raccolta/servizi/raccoltaVlanNga.tpl.html';
        	break;
        	case 'RACCOLTAVLANGBE':
        		_template = 'app/consistenze/dettaglio_asset_raccolta/servizi/raccoltaVlanGbe.tpl.html';
        	break;
        	case 'RACCOLTAVLANVULA':
        		_template = 'app/consistenze/dettaglio_asset_raccolta/servizi/raccoltaVlanVula.tpl.html';
        	break;
        	case 'TIPOCOS':
        		_template = 'app/consistenze/dettaglio_asset_raccolta/servizi/raccoltaTipoCos.tpl.html';
        	break;        	
        }
        
        $uibModal.open({
            templateUrl: _template,
            controller: 'DettaglioServiziModalCtrl',
            resolve: {
                item: function () {
                    return $scope.item;
                },
                title: function () {
                    return $scope.title;
                }
            }
        });
    }
  
    $scope.init();
}]);
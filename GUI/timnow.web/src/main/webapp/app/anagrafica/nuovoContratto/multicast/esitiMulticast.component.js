//RU_1180
timnow.component('esitiMulticast', {
	templateUrl: 'app/anagrafica/nuovoContratto/multicast/esitiMulticast.component.html',
	bindings:{
		data: '<'
			
	},
	controller: ['$rootScope', 
		function($rootScope){	
		
		var vm = this;
		
		vm.headerList = [];
		vm.headerList.push({"key": "nomeFile", "value": "Nome File", "type": "text"});
		vm.headerList.push({"key": "idFile", "value": "", "type": "esitoMulticastContratto"});
		vm.headerList.push({"key": "statoFile", "value": "", "type": "statoFile"});
				
	}]
})
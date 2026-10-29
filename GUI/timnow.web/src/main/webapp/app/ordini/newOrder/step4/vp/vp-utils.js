//RU_1058
timnow
	.constant('VP_VARIAZIONI',{
		'VARIAZIONE_TDKIT': 'VariazioneTDKit',
		'VARIAZIONE_CARATTERISTICA': 'VariazioneCaratteristica'
	})
	.constant('VP_RACCOLTA_SERVIZI',{
		'VP': 'RACCOLTAVP'
	})
	.service('VPUtils', function($rootScope, $filter){
		
		var dettagliAsset = {};
		
		return {
			
		
		
		trascodeFamigliaVlan: function(famigliaVlan){
			var _famigliaVlan = "";
			if(famigliaVlan){
				switch(famigliaVlan){
				case '1':
					_famigliaVlan = "VLAN MonoCoS Banda Condivisa";
					break;
				case '2':
					_famigliaVlan = "VLAN MultiCoS Banda Condivisa";
					break;
				case '3':
					_famigliaVlan = "VLAN MultiCoS Banda Dedicata";
					break;
				default:
					break;
				}
			}
			return _famigliaVlan;
		},
		
		trascodeArrayCoS: function(){
			var _arrayCoS = [];
			_arrayCoS.push({key: "VLAN MonoCoS Banda Condivisa CoS 0", value: '0'});
			_arrayCoS.push({key: "VLAN MonoCoS Banda Condivisa CoS 1", value: '1'});
			_arrayCoS.push({key: "VLAN MonoCoS Banda Condivisa CoS 3", value: '3'});
			_arrayCoS.push({key: "VLAN MonoCoS Banda Condivisa CoS 5", value: '5'});
			
			return _arrayCoS;
		},
		
		trascodeCoS: function(cos){
			var _cos = "";
			if(cos){
				switch(superMacroArea){
				case '0':
					_cos = "VLAN MonoCoS Banda Condivisa CoS 0";
					break;
				case '1':
					_cos = "VLAN MonoCoS Banda Condivisa CoS 1";
					break;
				case '3':
					_cos = "VLAN MonoCoS Banda Condivisa CoS 3";
					break;
				case '5':
					_cos = "VLAN MonoCoS Banda Condivisa CoS 5";
					break;
				default:
					break;
				}
			}
			return _cos;
		},
		
		trascodeArraySuperMacroArea: function(idOfferta){
			var _arraySuperMacroArea = [];
			var _idOffertaVLAN_NGA = $rootScope.MAP_OFFERTE.VLAN_NGA.id;
			var _idOffertaVLAN_GBE = $rootScope.MAP_OFFERTE.VLAN_GBE.id;
			if(idOfferta == _idOffertaVLAN_NGA){
				_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR reale", value: '0'});
				_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR SUPERMACROAREA", value: '1'});
				_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR SUPERMACROAREA CC", value: '2'});
				_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR SUPERMACROAREA LIB", value: '3'});
			}else if(idOfferta == _idOffertaVLAN_GBE){
				_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR reale", value: '0'});
				_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR SUPERMACROAREA", value: '1'});
			}
			return _arraySuperMacroArea;
		},
				
		trascodeSuperMacroArea: function(superMacroArea){
			var _superMacroArea = "";
			if(superMacroArea){
				switch(superMacroArea){
				case '0':
					_superMacroArea = "Consegna su CAR di MAdR reale";
					break;
				case '1':
					_superMacroArea = "Consegna su CAR di MAdR SUPERMACROAREA";
					break;
				case '2':
					_superMacroArea = "Consegna su CAR di MAdR SUPERMACROAREA CC";
					break;
				case '3':
					_superMacroArea = "Consegna su CAR di MAdR SUPERMACROAREA LIB";
					break;
				default:
					break;
				}
			}
			
			return _superMacroArea;
		},
		
		trascodeArrayCAR: function(){
			var _arrayCAR = [];
			_arrayCAR.push({key: "CAR 1", value: '1'});
			_arrayCAR.push({key: "CAR 2", value: '2'});
			_arrayCAR.push({key: "CAR 3", value: '3'});
			_arrayCAR.push({key: "CAR 4", value: '4'});
			_arrayCAR.push({key: "CAR 5", value: '5'});
			
			return _arrayCAR;
		},
		
		trascodeCAR: function(car){
			var _car = "";
			if(car){
				switch(car){
				case '1':
					_car = "CAR 1";
					break;
				case '2':
					_car = "CAR 2";
					break;
				case '3':
					_car = "CAR 3";
					break;
				case '4':
					_car = "CAR 4";
					break;
				case '5':
					_car = "CAR 5";
					break;
				default:
					break;
				}
			}			
			return _car;
		},
		
		setAttributesToCondivisoriFromAsset: function(condivisori){			
			if(condivisori){
				condivisori.forEach(function(item, index){
					if(!item.ELIMINA){
						item.ELIMINA = {};
						item.ELIMINA.dft = false;
					}
				});
			}			
			return condivisori;
		},
		
		extractValuesFromArray: function(data, key){			
			var _arrayResult = [];			
			if(data && data.length > 0){
				if(key){
					_arrayResult = data.map(function(a) {return a[key];});
				}
			}
			return _arrayResult;			
		},
		
		
		estraiDettagliAsset: function(dettagli){			
			
			if(dettagli && dettagli.servizi && dettagli.servizi.length > 0){
				dettagli.servizi.forEach(function(item){
					dettagliAsset[item.prodotto] = item.customizzazione;
				});
			}
		},
		
		estraiCampoDettagliAsset: function(prodotto, campo){
			
			var _valoreCampo = null;
			
			if(dettagliAsset && prodotto && campo){
				 if(dettagliAsset[prodotto] && dettagliAsset[prodotto].length > 0){
					 dettagliAsset[prodotto].forEach(function(_campo, index){
						 if(_campo.attribute === campo){
							 _valoreCampo = _campo.value;
							 return;
						 } 
					 });
				 }								
			}
			
			return _valoreCampo;
		}		
	};		
});
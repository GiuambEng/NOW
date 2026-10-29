//RU_1058
timnow
	.constant('VLAN_VARIAZIONI',{
		'VARIAZIONE_TDKIT': 'VariazioneTDKit',
		'VARIAZIONE_CAR': 'VariazioneCAR',
		'VARIAZIONE_BANDA': 'VariazioneBanda',
		'NUMERO_CONDIVISORI': 'VariazioneNumeroCondivisori'
	})
	.constant('VLAN_RACCOLTA_SERVIZI',{
		'VLAN_NGA': 'RACCOLTAVLANNGA',
		'VLAN_GBE': 'RACCOLTAVLANGBE',
		'VLAN_VULA': 'RACCOLTAVLANVULA'
	})
	.service('VLANUtils', function($rootScope, $filter, $q){
		
		var dettagliAsset = {};
		
		return{
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
			
			reverseTrascodeFamigliaVlan: function(famigliaVlan){
				var _famigliaVlan = "";
				if(famigliaVlan){
					switch(famigliaVlan){
					case "VLAN MonoCoS Banda Condivisa":
						_famigliaVlan = "1";
						break;
					case "VLAN MultiCoS Banda Condivisa":
						_famigliaVlan = "2";
						break;
					case "VLAN MultiCoS Banda Dedicata":
						_famigliaVlan = "3";
						break;
					default:
						break;
					}
				}
				return _famigliaVlan;
			},
			
			reverseTrascodeTipoVlan: function(tipoVlan){
				var _tipoVlan = "";
				if(tipoVlan){
					switch(tipoVlan){
					case "SINGLETAG":
						_tipoVlan = "1";
						break;
					case "DOUBLETAG":
						_tipoVlan = "2";
						break;
					default:
						break;
					}
				}
				return _tipoVlan;
			},
			
			reverseTrascodeSuperMacroarea: function(superMacroarea){
				var _superMacroarea = "";
				if(superMacroarea){
					switch(superMacroarea){
					case "Consegna su CAR di MAdR reale":
						_superMacroarea = "0";
						break;
					case "Consegna su CAR di MAdR 'SUPERMACROAREA'":
						_superMacroarea = "1";
						break;
					case "Consegna su CAR di MAdR 'SUPERMACROAREA CC'":
						_superMacroarea = "2";
						break;
					case "Consegna su CAR di MAdR 'SUPERMACROAREA LIB'":
						_superMacroarea = "3";
						break;
					default:
						break;
					}
				}
				return _superMacroarea;
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
					switch(cos){
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
					_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR 'SUPERMACROAREA'", value: '1'});
					_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR 'SUPERMACROAREA CC'", value: '2'});
					_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR 'SUPERMACROAREA LIB'", value: '3'});
				}else if(idOfferta == _idOffertaVLAN_GBE){
					_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR reale", value: '0'});
					_arraySuperMacroArea.push({key: "Consegna su CAR di MAdR 'SUPERMACROAREA'", value: '1'});
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
						_superMacroArea = "Consegna su CAR di MAdR 'SUPERMACROAREA'";
						break;
					case '2':
						_superMacroArea = "Consegna su CAR di MAdR 'SUPERMACROAREA CC'";
						break;
					case '3':
						_superMacroArea = "Consegna su CAR di MAdR 'SUPERMACROAREA LIB'";
						break;
					default:
						break;
					}
				}
				
				return _superMacroArea;
			},
			
			buildArraySuperMacroArea: function(idOfferta, macroArea){
				var _arraySuperMacroArea = [];
				var _idOffertaVLAN_NGA = $rootScope.MAP_OFFERTE.VLAN_NGA.id;
				var _idOffertaVLAN_GBE = $rootScope.MAP_OFFERTE.VLAN_GBE.id;
				
				if(idOfferta == _idOffertaVLAN_NGA){
					if(macroArea && macroArea != "" && (macroArea.search("_LIB") > -1 || macroArea.search("_CC") > -1)){
						_arraySuperMacroArea.push("Consegna su CAR di MAdR reale");
					}else{
						_arraySuperMacroArea.push("Consegna su CAR di MAdR reale");
						_arraySuperMacroArea.push("Consegna su CAR di MAdR 'SUPERMACROAREA'");
						_arraySuperMacroArea.push("Consegna su CAR di MAdR 'SUPERMACROAREA CC'");
						_arraySuperMacroArea.push("Consegna su CAR di MAdR 'SUPERMACROAREA LIB'");
					}

				}else if(idOfferta == _idOffertaVLAN_GBE){
					_arraySuperMacroArea.push("Consegna su CAR di MAdR reale");
					_arraySuperMacroArea.push("Consegna su CAR di MAdR 'SUPERMACROAREA'");
				}
				return _arraySuperMacroArea;
			},
			
			buildArrayCCLib: function(idOfferta, macroArea){
				var _arrayCCLib = [];
				var _idOffertaVLAN_NGA = $rootScope.MAP_OFFERTE.VLAN_NGA.id;
								
				if(idOfferta == _idOffertaVLAN_NGA){
					if(macroArea && macroArea != ""){
						if(macroArea.search("_LIB") > -1){
							_arrayCCLib.push("LIB");
						}else if(macroArea.search("_CC") > -1){
							_arrayCCLib.push("CC");
						}
					}else{
						_arrayCCLib.push("LIB");
						_arrayCCLib.push("CC");
					}
				}
				
				return _arrayCCLib;
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
			
			varificaAbilitazionePulsanteSelezionaCAR: function(famigliaVlan, cos){
				
				var _arrayCOS = ['0', '1'];
				var _arrayFamigliaVlan = ['2', '3'];
							
				if(famigliaVlan && cos){
					if((famigliaVlan == '1' && _arrayCOS.indexOf(cos) > -1) ||
					   (_arrayFamigliaVlan.indexOf(famigliaVlan) > -1)) {
						return true;
					}
				}
				
				return false;
			},
			
			//C11M08F78 - Verifica Selezione CAR
			VerificaSelezioneCAR: function(idOfferta, famigliaVlan, cos){			
				var deferred = $q.defer();
				
				var _car = ($rootScope.customizedOffer.offerTopDetails.CAR.dft || null);
				
				var _response = {
					esito: "KO"
				};
				
				var _idOffertaVLAN_VULA = $rootScope.MAP_OFFERTE.VLAN_VULA.id;
				
				if(_idOffertaVLAN_VULA == idOfferta){
					deferred.reject(_response);
				}
				
				if(this.varificaAbilitazionePulsanteSelezionaCAR(famigliaVlan, cos) && _car){
					response.esito = "OK";
					deferred.resolve(_response);
				}else{
					_response.messaggio = "Errore su Verifica CAR";
					deferred.reject(_response);
				}
						
				return deferred.promise;
			},
			
			addAzioneToCondivisori: function(condivisori){
				if(condivisori && condivisori.length > 0){
					condivisori.forEach(function(item, index){
						if(!item.azione){
							item.azione = "";
						}
					});
				}			
				return condivisori;
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
			},	
			
			estraiTipoCosDaAsset: function(dettagli){

				var _progressivo = 0;
				
				var  _array = [];
				
				var _obj = {};
				var _arrayReturn = [];
							
				if(dettagli && dettagli.servizi && dettagli.servizi.length > 0){
					_array = $filter('filter')(dettagli.servizi, {prodotto: 'TIPOCOS'});
					if(_array && _array.length > 0){
						_array.forEach(function(item){
							var _prodotto = item.prodotto;
							_progressivo++; 
							item.customizzazione.forEach(function(campo){
								_obj = {};
								_obj.componente = _prodotto;
								_obj.domain = "list";
								_obj.key = campo.attribute;
								_obj.progressivo = _progressivo;
								_obj.dft = campo.value;
								if(campo.attribute == 'IDENTIFICATIVOCOS'){
									_obj.tipologiaDato = 'NUMBER'; 
								}
								if(campo.attribute == 'BANDA'){
									_obj.tipologiaDato = 'VARCHAR2'; 
								}
								if(campo.attribute == 'TIPOBANDA'){
									_obj.tipologiaDato = 'VARCHAR2'; 
								}
								_arrayReturn.push(_obj);								
							});
						});
					}
				}					

				if($rootScope.customizedOffer && $rootScope.customizedOffer.offerBotDetails){
					$rootScope.customizedOffer.offerBotDetails = [];
					angular.copy(_arrayReturn, $rootScope.customizedOffer.offerBotDetails);
				}
			},
			
			estraiIndiceCampoSezioneInferiore: function(campo){				
				
				var _index = -1;
				
				if($rootScope.customizedOffer && 
				   $rootScope.customizedOffer.offerBotDetails && 
				   $rootScope.customizedOffer.offerBotDetails.length > 0){
					$rootScope.customizedOffer.offerBotDetails.forEach(function(item, index){
						if(item.key == campo){
							_index = index;
						}
					});					
					return _index;
				}
			},
			
			estraiCampoSezioneInferiore: function(campo){	
				
				var _filtered = null;
							
				if($rootScope.customizedOffer && 
				   $rootScope.customizedOffer.offerBotDetails && 
				   $rootScope.customizedOffer.offerBotDetails.length > 0){
						_filtered = $filter('filter')($rootScope.customizedOffer.offerBotDetails, {key: campo});
				}
				
				return _filtered;
			},
			
			/**
			 * Trasforma la sezione inferiore dei dati della compilazione in array,
			 * per attivazione offerte VLAN
			 */
			convertiSezioneInferioreInArray: function(){
				var _array = [];
				if($rootScope.customizedOffer.offerBotDetails && !angular.isArray($rootScope.customizedOffer.offerBotDetails)){
					
					angular.forEach($rootScope.customizedOffer.offerBotDetails, function(item){
						var _object = {};
						angular.forEach(item, function(value, key){
							_object[key] = value;
						});
						_array.push(_object);
					});
					
					$rootScope.customizedOffer.offerBotDetails = [];
					
					angular.copy(_array, $rootScope.customizedOffer.offerBotDetails);
					
				}
			}
		};
});
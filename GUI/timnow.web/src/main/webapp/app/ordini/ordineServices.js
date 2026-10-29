timnow
    //questa chiamata senza ID da tutti gli Orders con l'ID da il dettaglio
    .factory('Orders', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/:type/:orderNumber', {type: '@type', orderNumber: '@orderNumber',state: '@state'}, {
            'save': {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    .factory('OrdersReferents', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/:orderNumber/contactedreferents');
    }])
    .factory('OrderstimeOut', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/recuperodatatimeout/:orderNumber');
    }])
    //RU_713
    .factory('VerificaCompatibilitaProfiloVc', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	    'use strict';
	    	return $resource(BASEPATH + 'orders/verificacompatibproftecnlineaprofilovc', {
        'save': {
        		method: 'POST', headers: {'Content-Type': 'application/json'}
        	  }
	    });
    }])
    .factory('DTU', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'externaldata/dtus/:idRichiesta');
    }])
    .factory('DBCFX', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'externaldata/dbcfx/:idRichiesta');
    }])
    .factory('VisualizzaCodiciRifiuto', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'listaRichiesteAssets/visualizzacodicirifiuto');
    }])
    .factory('nuovaRichiestaOrdine', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/:orderNumber/requests', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
	.factory('VerificaIDRisorsa', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaidrisorsa/:type', null,
            {verifica: {method: 'POST', headers: {'Content-Type': 'application/json'}}});
    }])
    .factory('VerificaPresenzaIDRisorsa', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/verificapresenzaidrisorsa', null,
    			{verifica: {method: 'GET', headers: {'Content-Type': 'application/json'}}});
    }])
    .factory('checkVariazione', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/variazioni/checks/:idAsset/contratto');
    }])
	.factory('ConfigurazioneFE', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/configurazione/:codFunzione', {
            idOfferta: '@idOfferta',
            opzioneVariazione: '@opzioneVariazione'
        }, {});
    }])
    // checkRequest checkOloWholesaler invioPreventivo listaPreventivi listaConsuntivi
    .factory('ordersAction', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/:type/:idRichiestaOlo');
    }])
    .factory('VerificaCoerenzaIdRisorsa', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificacoerenzaidrisorsa/:idRisorsa/:codOloAgcom');
    }])
    .factory('VerificaVpFlat', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificavpflatattestazione', null,
            {verifica: {method: 'POST', headers: {'Content-Type': 'application/json'}}});
    }]) 
    .factory('VerificaCongruenzaOffertaCodOrdine', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificacongruenzaoffertacodordine/:idOfferta');
    }])
    .factory('DTUDetails', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'externaldata/dtus/detail/:idEventoNow/:progressivoEventoDtu/:idrichiestaolo');
    }])
    .factory('JPUBS', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'externaldata/jpubs/:idRichiesta');
    }])
    //query parameters consistenza, codDonating
    .factory('Assets', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'assets/:paramName/:id');
    }])
    .factory('NuovaRicarica', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'listaRicaricheAssets/nuovaricarica');
    }])
    .factory('TaglioRicarica', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'listaRicaricheAssets/taglioricarica');
    }])
    .factory('RecuperaIdAsset', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'assets/recupero/:codAgcom');
    }])
    .factory('SLAtime', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'slas');
    }])
    .factory('Addresses', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'address/:type', {type: '@type'});
    }])
    .factory('Districts', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'address/controllorecuperadistretto');
    }])
    //query parameters codOLO valoreRicerca
    .factory('IDULLCo', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'idullcos');
    }])
     //query parameters codOLO valoreRicerca
    .factory('IDSLUCo', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'idslucos');
    }])
    //query parameters anagrafica disaggregazione
    .factory('DISAGGREGAZIONE', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'anagraficadisaggregazione');
    }])
     //query parameters noDiffida
    .factory('IDsrolo', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'srolos/:list');
    }])
    .factory('Contracts', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'contracts/olo/:codOlo');
    }])
    .factory('Projects', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'projects/:codOlo');
    }])
    //query parameters contratto
    .factory('Offers', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'offers/:offerId');
    }])
    //query parameters dac orderType offer flagNp
    .factory('Dac', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'dacs/:type');
    }])
    .factory('Request', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        //return $resource(BASEPATH + 'requests/:orderNumber');
        //SM_9693
        return $resource(BASEPATH + 'requests', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('TailPosition', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'positions');
    }])
    .factory('VCProfiles', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'vcs/viewProfilesVC/:tipoprofilovc/:idOfferta');
    }])
    .factory('TracciamentoStato', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'ordertracking/:idRichiestaOlo/:inizioTracciamento/:fineTracciamento');
    }])
     //query parameters codOloAgcom  encapsulation service
    .factory('VlanSvlanCvlan', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'lans/:type', null,
                {verifica: {method: 'POST', headers: {'Content-Type': 'application/json'}}});
    }])
    .factory('TDCodes', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'tdCodes/:codOlo');
    }])
    .factory('VPCode', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'vps/code/:idOfferta/:codOlo');
    }])
    .factory('checkNumeric', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'olos/checkNumeric/:codOlo');
    }])
    .factory('checkOao', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'oaos/:type/:codOlo/:idOfferta');
    }])
    .factory('Draft', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'drafts/:operationType/:listaOrdiniBozzaOp', null, {
            save: {method: 'POST', headers: {'Content-Type': 'application/json'}},
            get: {method: 'GET', headers: {'Content-Type': 'application/json'}},
            delete_draft: {method: 'GET', headers: {'Content-Type': 'application/json'}},
            mod: {method: 'POST', headers: {'Content-Type': 'application/json'}}
        });
    }])
    //query parameters codiceOrdineTI nomeFileNotifica
    .factory('OrdineDonating', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'ordini-donating/:idRichiestaOLO');
    }])
    //RU_995
    .factory('verificaTicketTTM', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaTicketTTM');
    }])    
    .factory('verificaTecnologia', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/verificaTecnologia');
    }])
    .factory('CodiceRichiesta', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/codiceUnivoco');
    }])
     .factory('verificaTecnologia', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/verificaTecnologia');
    }])
    .factory('RecuperaRichieste', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/recuperarichieste');
    }])
    .factory('VisualizzaTipoBanda', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	   'use strict';
	   return $resource(BASEPATH + 'bands/viewTypeBand/:codVlanSvlan');
	}])
	//SM_8535
	.factory('VerificaPerVariazioneWlr', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificapervariazionewlr', {
            'save': {method: 'POST', headers: {'Content-Type': 'application/json'}}
        })
    }])
    //RU_833 FIX FWA CESSAZIONE
    .factory('Verificacodiceordineolo', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	   'use strict';
	   return $resource(BASEPATH + 'orders/verificacodiceordineolo/:codiceOrdineOlo/:codOloAgcom');
	}])
	//RU_871
    .factory('VerificaInConsistenzaPresenzaModem', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	   'use strict';
	   return $resource(BASEPATH + 'orders/verificainconsistenzapresenzamodem/:idOfferta/:flagReferente?idRisorsa');
	}])
	//RU_863
    .factory('RecuperaProfiliFwa', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
	   'use strict';
	   return $resource(BASEPATH + 'orders/recuperaprofilifwa/:profiloFwa');
	}])
	//RU_888
    .factory('RecuperaNotificheRichiesta', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'requests/recuperanotificherichiesta/:orderNumber');
    }])
    //RU_875
    //SM_10241
    .factory('VerificaCodiceProgettoOneStep', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificacodiceprogettoonestep', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //RU_915
    .factory('VerificaCarrierOloCps', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'olos/checkCarrierOloCps', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //RU_915
    .factory('VerificaContratto', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'olos/checkContract', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
        //RU_921
    .factory('RecuperaTipologieCpe', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'cpes');
    }])
    //RU_966
    .factory('VerificaCompatibilitaIntermediateAgent', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaIntermediateAgentFull', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //RU_980
    .factory('RecuperaCodServizioSysUnico', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaCodiceServizioSystemUnico', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_995    
    .factory('VerificaOrdineVariazioneDowngradeFast', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaOrdineVariazioneDowngradeFast', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1058
    .factory('VerificaKitAbilitatoNGA', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaKitAbilitatoNGA', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1058
    .factory('VisualizzaCampiOfferteVLAN', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/visualizzaCampiOfferteVLAN', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
     //RU_1058
    .factory('RecuperaCampiOffertaVP', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaCampiOffertaVP', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1058
    .factory('VerificaLimiteMassimoVP', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaLimiteMassimoVP', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1058
    .factory('VerificaAreaRaccoltaVPLite', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaAreaRaccoltaVPLite', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1058
    .factory('RecuperaCAR', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaCar', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
     //RU_1058
    .factory('RecuperaSubContractor', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaSubContractor/:idRisorsa')
    }])
    
    //RU_1058
    .factory('RecuperaCodOloSubContractor', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaCodOloSubContractor/:idRisorsa')
    }])
    
    //RU_1058
    .factory('VerificaCodiceTDKit', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaCodiceTdKit', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    .factory('VerificaModelloKit', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaModelloKit', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1060    
    .factory('VerificaComuneOffertaInfratel', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaComuneOffertaInfratel', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1084
    .factory('Tokenizzazione', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'tokenizzazione/referenti', {}, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('Detokenizzazione', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'detokenizzazione/referenti', {}, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //SM_9651
    .factory('DetokenizzazioneNotifica', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        //return $resource(BASEPATH + 'detokenizzazione/notifica/:idNotifica')
        return $resource(BASEPATH + 'detokenizzazione/notifica', {}, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //SM_9686
    .factory('DetokenizzazioneXML', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'detokenizzazione/xml', {}, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1089    
    .factory('VerificaCongruenzaClusterComuneVlan', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaCongruenzaClusterComuneVlan', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1129
    .factory('RecuperaProfiliFwaPost', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaProfiliFwa', {}, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    .factory('VerificaTipologiaContrattoFwa', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaTipologiaContrattoFwa', {}, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
        
    //SM_9825    
    .factory('RecuperaCodiciTdKit', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaCodiciTdKit', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
     //SM_9825
    .factory('VerificaModelloKitMadr', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaModelloKitMadr');
    }])
    
    //RU_1150    
    .factory('RecuperaIdGpon', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaIdGpon', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1166   
    .factory('RecuperaMacroArea', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaMacroArea', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1164    
    .factory('VerificaContrattoCoinvestimentoComune', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaContrattoCoinvestimentoComune', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1180
    .factory('VisualizzaCampiOfferteMulticast', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/visualizzaCampiOfferteMulticast', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('VerificaAbilitazioneMcContratto', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/verificaAbilitazioneMcContratto');
    }])

    //RU_1181
    .factory('VerificaRecuperoModem', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
    	'use strict';
    	return $resource(BASEPATH + 'orders/verificaRecuperoModem');
    }])
    
    //R1I-21-0138    
    .factory('VerificaCompatibilitaProfiloTecnicoLinea', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaCompatibilitaProfiloTecnicoLinea', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //R1F-20-0236.D
    .factory('VerificaNumeriNoteOperatore', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaNumeriNoteOperatore',null,  {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    
    //RU_1270   
    .factory('VerificaProfiloTecnicoLineaX1X2', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaProfiloTecnicoLineaX1X2');
    }])
    
    //RU_1335
    .factory('VerificaIdRisorsaSwitchoffFwa', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaIdRisorsaSwitchoffContrattoFwa');
    }])
    
    //RU_1393
    .factory('RecuperaCodiceSystemUnico', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaCodiceSystemUnico', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('RecuperaCodiceSubAppalto', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaCodiceSubAppalto', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //RU_1428
    .factory('RecuperaTipologiaImpresa', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaTipologiaImpresa', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //RU_1462
    .factory('RecuperaVlanFiberstream', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'fiberstream/searchVlan', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('RecuperaNomiServiziAggiuntiviFiberstream', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'fiberstream/nomiServiziAggiuntivi');
    }])
    .factory('RecuperaApparatiFiberstream', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'fiberstream/apparati');
    }])
    .factory('RecuperaTipologiaApparatoFiberstream', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'fiberstream/tipologiaApparato');
    }])
    //RU_1475
    .factory('RecuperaVlanEolo', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'eoloFwa/searchVlan', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    .factory('AddressesEoloFwa', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'eoloFwa/address/:type', {type: '@type'});
    }])
    .factory('VerificaCoppiaIdVlanCvlan', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'eoloFwa/verificaCoppiaIdVlanCvlan', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //RU_1485
    .factory('RecuperaServiziOpzionaliAlternativi', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaServiziOpzionaliAlternativi');
    }])
    //RU_1492
    .factory('OpenFiberExternalData', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'externaldata/openFiber/:idRichiesta');
    }])
    //RU_1502
    .factory('VerificaSpostamentoVlan', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaSpostamentoVlan', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
     //SM_11483
    .factory('VerificaCongruenzaDRGOfferta', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaCongruenzaDRGOfferta', null, {
            'save': {
                method: 'POST', headers: {'Content-Type': 'application/json'}
            }
        });
    }])
    //RU_1543
    .factory('VerificaAttivazioneFullGponPlus', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaAttivazioneFullGponPlus');
    }])
    //RU_1560 -> getCodiceOperatoreSecondario
    .factory('GetCodiceOperatoreSecondario', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/getCodiceOperatoreSecondario');
    }])
    //RU_1560 -> C11M08F111
    .factory('VerificaCodiceProgettoOneStepTLC8', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaCodiceProgettoOneStepTLC8');
    }])
	//RU_1560 -> C11M08F112
    .factory('VerificaSLABasePerONTOperatore', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaSLABasePerONTOperatore');
    }])
    //RU_1560 -> C11M08F113
    .factory('VerificaAttivazioneFTTH', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaAttivazioneFTTH');
    }])
    //RU_1560 -> C11M08F114
    .factory('VerificaMigrazioneFTTH', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/verificaMigrazioneFTTH');
    }])
    //RU_1598
    .factory('RecuperaClusterAccesso', ['$resource', 'BASEPATH', function ($resource, BASEPATH) {
        'use strict';
        return $resource(BASEPATH + 'orders/recuperaClusterAccesso');
    }])
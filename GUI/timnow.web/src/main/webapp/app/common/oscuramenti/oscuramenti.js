commonModule

    .constant('OSCURAMENTI', {
    	//RU_956
    	'RU_956': {
        	oscurato: false,
        	idOfferteNonValide: ['7','41','11','12','13','14','15','16','17','18','44','45']
        },
    	//RU_966
    	'RU_966': {
    		oscurato: false,
    		//R1I-20-0189
    		idOfferteValide: ['15','16','17','18','67','68'] //SM_9282
        },
        //R1C-19-1212
        'R1C_19_1212': {
        	oscurato: false,
        	idOfferteValide: ['16','18']
        },
        //RU_980
        //Task #38240
        'RU_980': {
        	oscurato: false,
        	idOfferteValide: ['1','3','5','15','17', '2','4','6','16','18','44','45','67','68','69'],
        	visualizzaSezioni: {
        		attivazione: {
					//RU_1485
            		offerteServiziOpzionali: ['15','17','16','18','44','45','69','77','78'], //RU_1543
            		offerteServiziOpzionaliAlternativi: ['16','67','18','68','45','69','65','77','78', '79', '80'], //RU_1543 + RU_1581
            		offerteDisaggregazione: ['1','3','5','17'],
            		offertePresaAppuntamento: ['1','3','5'],
            		offertePrestazioniAggiuntive: ['1','3','5'],
            		offerteSlaPlusSu: ['1','3','5']        
            	},
            	migrazione: {
            		offerteServiziOpzionali: ['1','3','5'],
            		//SM_9505
            		offerteDisaggregazione: ['1','3','5','17','2', '6','4']
            	}
        	}        	
        },
        //RU_985
        'RU_985': {
        	oscurato: false,
        	idOfferteValide: ['46']
        },
    	//RU_982
    	'RU_982': {
    		oscurato: false,
    		idOfferteValide: ['7']
        },
        //RU_994
        'RU_994': {
        	oscurato: false,
        	idOfferteValide: ['15','17']
        },
        //RU_995
        'RU_995': {
        	oscurato: false,
        	idOfferteValide: ['44']
        },
        //R1I-20-0131
        'R1I_20_0131': {
        	oscurato: false,
        	idOfferteValide: ['17'],
        	visualizzaSezioni: {
        		attivazione: {
            		offerteServiziOpzionali: ['17'],
            		offerteDisaggregazione: ['17'],
            		offertePresaAppuntamento: ['17'],
            		offertePrestazioniAggiuntive: ['17'],
            		offerteSlaPlusSu: ['17']        
            	}
        	}
        },        
        //RU_1036
        'RU_1036': {
        	oscurato: false,
        	idOfferteValide: ['7','8', '9','10', '15', '17'] //SM_9464
        },
        //RU_1060
        'RU_1060': {
        	oscurato: false,
        	idOfferteValide: ['16', '18', '45']
        },
        //RU_1084
        'RU_1084': {
        	//TASK #32892 -> Disoscuramento C2PLUS e RU_1058
        	//SM_10702
        	oscurato: false
        },
        //RU_1058
        'RU_1058': {
        	//TASK #32892 -> Disoscuramento C2PLUS e RU_1058
        	oscurato: false,
        	idOfferteValide: ['61', '62', '63', '64']
        },
        //RU_1089
        'RU_1089': {
        	oscurato: false,
        	idOfferteValide: ['15', '16']
        },
        //RU_1129
        'RU_1129': {
        	//Oscuramento per rilascio in collaudo
        	//Disoscuramento per rilascio in system test
        	oscurato: false
        },
        //RU_1164
        'RU_1164': {
        	oscurato: false,
        	idOfferteValide: ['67', '68', '69']
        },
        //R1F-20-0236
        'R1F_20_0236': {
        	oscurato: false, 
        	//SM_10702
        	idOfferteNonValide: ['46', '65', '66', '74']
        },
        //R1F-20-0236.C
        'R1F_20_0236C':{
        	oscurato: false,
        	pattern: "****",
        	data: '2022-02-15'        		
        },
        //R1F-20-0236.D
        'R1F_20_0236D':{
        	oscurato: false
        },        
        //RU_1276
        //RU_1291 -> Oscuramento RU_1276
        'RU_1276': {
        	oscurato: false
        },
        //RU_1299
        'RU_1299': {
        	oscurato: false,
        	idOfferteValide: ['67', '68', '69']
        },
        //RU_1335
        'RU_1335': {
        	oscurato: false
        },
        //RU_1338
        'RU_1338': {
        	oscurato: false
        },
        //RU_1357
        'RU_1357': {
        	oscurato: false,
        	idOfferteValide: ['15', '16', '17', '18', '44', '45','67', '68', '69']
        },
        //RU_1400
        //SM_11102
        'RU_1400': {
			oscurato: false,
			idOfferteNonValide: ['3', '4', '28', '23', '24']
		},
		//RU_1452
		'RU_1452': {
			oscurato: false
		},
		//RU_1475
		'RU_1475': {
			oscurato: false
		},
		//RU_1502
		'RU_1502': {
			oscurato: false
		},
		//RU_1543
		'RU_1543': {
			oscurato: false
		},
		'RU_1560': {
			oscurato: false,
			idOfferteValide: ['16', '18', '68', '45'],
			parametriRicercaOscurati: ['ONT OPERATORE', 'MODELLO SERVIZIO PER VALIDAZIONI', 'CODICE OPERATORE SECONDARIO', 'DESCRIZIONE OPERATORE SECONDARIO']
		},
		'RU_1581': {
			oscurato: false,
			idOfferteValide: ['79', '80'],
			nomiStandardfferteValide: ['SEMIGPON1BPNRR', 'FULLGPON1BPNRR']
		},
		'RU_1583': {
			oscurato: false
		},
		'RU_1598': {
			oscurato: true,
			idOfferteValideAttivazione: ['16', '15', '18', '17', '68', '44', '45'], // in ordine: BitstreamNGAFTTH, BitstreamNGAFTTCAB, VULAFTTH, VULAFTTCAB, SEMIVULAFTTH, EasyIPUBBFTTCAB, EasyIPUBBFTTH
			idOfferteValideMigrazione: ['15', '17', '44'], // in ordine: BitstreamNGAFTTCAB, VULAFTTCAB, EasyIPUBBFTTCAB
		},
		'RU_1612': {
			oscurato: false
		},
		'RU_1614': {
			oscurato: false,
			listaCampi: ['PROFILO'],
			idOfferteValide: ['44', '45'] // in ordine: EasyIPUBBFTTCAB, EasyIPUBBFTTH
		},
		'FEA_32918': {
			oscurato: false,
			listaCampi: ['MERCATO', 'COPERTOFTTH'],
			idOfferteValideMERCATO: ['17', '18', '68'], // VULAFTTCAB, VULAFTTH, SEMIVULAFTTH
			idOfferteValideCOPERTOFTTH: ['17'], // VULAFTTCAB
		},
		'FEA_42907': {
			oscurato: false
		},
		'FEA_36452': { // C10
			oscurato: false,
			listaCampi: ['SISTEMADICREATION'],
			idOfferteValide: ['68', '18', '16', '45', '65', '77', '78', '79', '80'] // SEMIVULAFTTH, VULAFTTH, BitstreamNGAFTTH, EasyIPUBBFTTH, UBBSEMIGPON, FULLGPONPLUS, FULLGPONPLUSNGA, SEMIGPON1BPNRR, FULLGPON1BPNRR
		},
    });

commonModule

    /* env config - START */

    .constant('BASEPATH', 'rest/')

    /* env config - END */


    /* common config - START */

// LANDING: pagina di default, da alterare solo per esigenze di sviluppo

    .constant('LANDING', 'root.homepage')
    //.constant('LANDING', 'root.ordini.nuovo.attivazione-cliente')

    /* common config - END */

    .constant('CRM_RICARICHE_PROFILE', {
        'CRM_OLORO': 'CRM_OLORO',
        'CRM_DGRO': 'CRM_DGRO',
        'CRM_DGRO_CON': 'CRM_DGRO_CON',
        'CRM_MKTG' : 'CRM_MKTG',
        'CRM_PPS': 'CRM_PPS',
        'CRM_NEWS': 'CRM_NEWS',
        'CRM_GA': 'CRM_GA'
    })
    
    .constant('CRM_RISOTTOMISSIONE_PROFILE', {
    	'CRM_PPS': 'CRM_PPS',
    	'CRM_GA': 'CRM_GA'
    })

    
    .constant('CRM_PROFILE', {
    	'CRM_DG': 'CRM_DG',
    	'CRM_GA': 'CRM_GA',
    	'CRM_DGRO': 'CRM_DGRO',
    	'CRM_DGRO_CON': 'CRM_DGRO_CON',
    	'CRM_DG_CON': 'CRM_DG_CON',
    	'CRM_DG_REG_UO': 'CRM_DG_REG_UO',
    	'CRM_NEWS': 'CRM_NEWS',
    	'CRM_OLO': 'CRM_OLO',
    	'CRM_OLORO': 'CRM_OLORO',
    	'CRM_PPS': 'CRM_PPS',
    	'CRM_MKTG' : 'CRM_MKTG',/* RU_872 */
    	'CRM_DG_SUPER': 'CRM_DG_SUPER', /* RU_872 */
    	'CRM_GA_SUPER': 'CRM_GA_SUPER', /* RU_872 */
    	'CRM_DGRO_SUPER': 'CRM_DGRO_SUPER', /* RU_872 */
    	'CRM_DGRO_CON_SUPER': 'CRM_DGRO_CON_SUPER', /* RU_872 */
    	'CRM_DG_CON_SUPER': 'CRM_DG_CON_SUPER', /* RU_872 */
    	'CRM_DG_REG_UO_SUPER': 'CRM_DG_REG_UO_SUPER', /* RU_872 */
    	'CRM_NEWS_SUPER': 'CRM_NEWS_SUPER', /* RU_872 */
    	'CRM_OLO_SUPER': 'CRM_OLO_SUPER', /* RU_872 */
    	'CRM_OLORO_SUPER': 'CRM_OLORO_SUPER', /* RU_872 */
    	'CRM_PPS_SUPER': 'CRM_PPS_SUPER', /* RU_872 */
    	'CRM_MKTG_SUPER' : 'CRM_MKTG_SUPER', /* RU_872 */
    	'CRM_OPCC' : 'CRM_OPCC' /* RU_869 */
    })

     /* RU_872 */
    .constant('CRM_PROFILE_SUPER', {
    	'CRM_DG_SUPER': 'CRM_DG_SUPER',
    	'CRM_GA_SUPER': 'CRM_GA_SUPER',
    	'CRM_DGRO_SUPER': 'CRM_DGRO_SUPER',
    	'CRM_DGRO_CON_SUPER': 'CRM_DGRO_CON_SUPER',
    	'CRM_DG_CON_SUPER': 'CRM_DG_CON_SUPER',
    	'CRM_DG_REG_UO_SUPER': 'CRM_DG_REG_UO_SUPER',
    	'CRM_NEWS_SUPER': 'CRM_NEWS_SUPER',
    	'CRM_OLO_SUPER': 'CRM_OLO_SUPER',
    	'CRM_OLORO_SUPER': 'CRM_OLORO_SUPER',
    	'CRM_PPS_SUPER': 'CRM_PPS_SUPER',
    	'CRM_MKTG_SUPER' : 'CRM_MKTG_SUPER'
    })
    
     .constant('CRM_DG_PROFILES', {
        'CRM_DG': 'CRM_DG',
        'CRM_DGRO': 'CRM_DGRO',
        'CRM_DGRO_CON': 'CRM_DGRO_CON',
        'CRM_DG_CON': 'CRM_DG_CON',
        'CRM_DG_REG_UO': 'CRM_DG_REG_UO'
    })

// da rivedere come ottimizzare per dettaglioController
    .constant('CRM_ORD_PROFILE',{
        'CRM_DG': 'CRM_DG',
        'CRM_GA': 'CRM_GA',
        'CRM_DGRO': 'CRM_DGRO',
        'CRM_DGRO_CON': 'CRM_DGRO_CON',
        'CRM_DG_CON': 'CRM_DG_CON',
        'CRM_DG_REG_UO': 'CRM_DG_REG_UO',
        'CRM_PPS': 'CRM_PPS',
        'CRM_MKTG': 'CRM_MKTG'        
    })
    
    .constant('CRM_ORD_SUB_PROFILE',{
          'CRM_DG': 'CRM_DG',
          'CRM_GA': 'CRM_GA',
          'CRM_DGRO': 'CRM_DGRO',
          'CRM_DGRO_CON': 'CRM_DGRO_CON',
          'CRM_DG_CON': 'CRM_DG_CON',
          'CRM_DG_REG_UO': 'CRM_DG_REG_UO',
          'CRM_PPS': 'CRM_PPS'
    })
    
    //Profili ai quali nascondere il pulsante 'Richiesta preventivo' nel dettaglio Ordine
    .constant('CRM_RO_PROFILE',{
    	'CRM_DGRO': 'CRM_DGRO',
    	'CRM_DGRO_CON': 'CRM_DGRO_CON',
    	'CRM_OLORO': 'CRM_OLORO',
    	'CRM_DGRO_SUPER': 'CRM_DGRO_SUPER',
    	'CRM_DGRO_CON_SUPER': 'CRM_DGRO_CON_SUPER',
    	'CRM_OLORO_SUPER': 'CRM_OLORO_SUPER',
    	'CRM_DGRO_SUPER': 'CRM_DGRO_SUPER',
    	'CRM_DGRO_CON_SUPER': 'CRM_DGRO_CON_SUPER',
    	'CRM_OLORO_SUPER': 'CRM_OLORO_SUPER'
    })

    
    .constant('USER_TASK_ACTION', {
        'SKIP': {key: 'SKIP', value: 'Scarto Senza Modifica Causale'},
        'SKIP_MOD': {key: 'SKIP_MOD', value: 'Scarto con Modifica Causale'},
        'RETRY': {key: 'RETRY', value: 'Risottomissione'}
    })
    
    .constant('MAP_OFFERTE', {
    	'ULL_LNA':	{name:'ULL', 		id:'1', 	regolatorio:true, dati:false},
    	'ULL_LA':	{name:'ULL',		id:'2', 	regolatorio:true, dati:false},
    	'ULLD_LNA':	{name:'ULLDati', 	id:'3', 	regolatorio:true, dati:false},
    	'ULLD_LA':	{name:'ULLDati', 	id:'4', 	regolatorio:true, dati:false},
    	'ULL_LANP':	{name:'ULL', 		id:'27', 	regolatorio:true, dati:false},
    	'ULLD_LANP':{name:'ULLDati', 	id:'28', 	regolatorio:true, dati:false},
    	'SLU_LNA':	{name:'SLU', 		id:'5', 	regolatorio:true, dati:false},
    	'SLU_LA':	{name:'SLU', 		id:'6', 	regolatorio:true, dati:false},
    	'SLU_LANP':	{name:'SLU', 		id:'29', 	regolatorio:true, dati:false},
    	'VULL_LNA':	{name:'VULL', 		id:'21', 	regolatorio:true, dati:false},
    	'VULL_LA':	{name:'VULL', 		id:'26', 	regolatorio:true, dati:false},
    	'WLR_LA':	{name:'WLR', 		id:'25', 	regolatorio:true, dati:false},
    	'WLR_LNA':	{name:'WLR', 		id:'22', 	regolatorio:true, dati:false},
    	'SHA_CM':	{name:'SHA', 		id:'23', 	regolatorio:true, dati:true},
    	'SHA_SM':	{name:'SHA', 		id:'24', 	regolatorio:true, dati:true},
    	'NP':		{name:'NP', 		id:'20', 	regolatorio:true, dati:false},
    	'VULA_CAB':	{name:'VULAFTTCAB', id:'17', 	regolatorio:false, dati:true},
    	'VULA_H':	{name:'VULAFTTH', 	id:'18', 	regolatorio:false, dati:true},
    	'GBE_AF':	{name:'BitstreamGBEAsimmetricoFlat', 	id:'7', 	regolatorio:false, dati:true},
    	'GBE_SF':	{name:'BitstreamGBESimmetricoFlat', 	id:'41', 	regolatorio:false, dati:true},
    	'ATM_AF':	{name:'BitstreamATMAsimmetricoFlat', 	id:'8', 	regolatorio:false, dati:true},
    	'ATM_AH':	{name:'BitstreamATMAsimmetricoHL', 		id:'9', 	regolatorio:false, dati:true},
    	'ATM_AL':	{name:'BitstreamATMAsimmetricoLite', 	id:'10', 	regolatorio:false, dati:true},
    	'ATM_SF':	{name:'BitstreamATMSimmetricoFlat', 	id:'39', 	regolatorio:false, dati:true},
    	'ATM_SH':	{name:'BitstreamATMSimmetricoHL', 		id:'40', 	regolatorio:false, dati:true},
    	'EASY_BF':	{name:'EasyIPBasePlusFlat', 			id:'11', 	regolatorio:false, dati:true},
    	'EASY_BL':	{name:'EasyIPBasePlusLite', 			id:'12', 	regolatorio:false, dati:true},
    	'EASY_SF':	{name:'EasyIPSpecialProfileFlat', 		id:'13', 	regolatorio:false, dati:true},
    	'EASY_SL':	{name:'EasyIPSpecialProfileLite', 		id:'14', 	regolatorio:false, dati:true},    	
    	'NGA_CAB':	{name:'BitstreamNGAFTTCAB', 			id:'15', 	regolatorio:false, dati:true},
    	'NGA_H':	{name:'BitstreamNGAFTTH', 				id:'16', 	regolatorio:false, dati:true},
    	'EASY_CAB': {name:'EasyIPUBBFTTCAB', 		        id:'44', 	regolatorio:false, dati:true},
    	'EASY_H':   {name:'EasyIPUBBFTTH', 				    id:'45', 	regolatorio:false, dati:true},
    	'FWA': 		{name:'FixedWirelessAccess',			id:'46',	regolatorio:false, dati:false}, //RU_716
    	'CPS': 		{name:'CPS',							id:'47',	regolatorio:false, dati:false}, //RU_915,
    	'VLAN_NGA': {name:'VLANNGA',						id:'61',	regolatorio:false, dati:false}, //RU_1058
    	'VLAN_VULA':{name:'VLANVULA',						id:'62',	regolatorio:false, dati:false}, //RU_1058
    	'VLAN_GBE': {name:'VLAN',							id:'63',	regolatorio:false, dati:false}, //RU_1058
    	'VP': 		{name:'VP',								id:'64',	regolatorio:false, dati:false}, //RU_1058
    	'GPON_SEMI':{name:'UBBSEMIGPON',					id:'65',	regolatorio:false, dati:false}, //RU_1150
    	'GPON_FULL':{name:'UBBFULLGPON',					id:'66',	regolatorio:false, dati:false}, //RU_1150
    	'SEMI_VULA_H'  :{name:'SEMIVULAFTTH',				id:'68',	regolatorio:false, dati:true}, //RU_1164
    	'SEMI_BTS_H'   :{name:'SEMIBitstreamNGAFTTH',		id:'67',	regolatorio:false, dati:true}, //RU_1164
    	'SEMI_EASYIP_H':{name:'SEMIEasyIPUBBFTTH',			id:'69',	regolatorio:false, dati:true}, //RU_1164
    	'FEEDER':{name:'FEEDER',							id:'71',	regolatorio:false, dati:true}, //RU_1180
    	'VLANNGAMULTICAST':{name:'VLANNGAMULTICAST',		id:'70',	regolatorio:false, dati:true}, //CR1-CR4
    	'SEDEOLT':{name:'SEDEOLT',							id:'72',	regolatorio:false, dati:true}, //CR1-CR4
    	'CANALE':{name:'CANALE',							id:'73',	regolatorio:false, dati:true},  //CR1-CR4    
    	'NPNG':{name:'NPNG',								id:'74',	regolatorio:false, dati:true},  //CR1-CR4
    	'FIBERSTREAM':{name:'FIBERSTREAM',					id:'75',	regolatorio:false, dati:true},  //RU_1462
    	'FWAITALIA1GIGASARDEGNA':{name:'FWAITALIA1GIGASARDEGNA', id:'76',	regolatorio:false, dati:true},
    	'FULLGPONPLUS':{name:'FULLGPONPLUS', 				id:'77',	regolatorio:false, dati:true},
    	'FULLGPONPLUSNGA':{name:'FULLGPONPLUSNGA', 			id:'78',	regolatorio:false, dati:true},
    	'GPON_SEMI_PNRR':{name:'SEMIGPON1BPNRR', 			id:'79',	regolatorio:false, dati:true},
    	'GPON_FULL_PNRR':{name:'FULLGPON1BPNRR', 			id:'80',	regolatorio:false, dati:true}
    })
    
	.constant('NEW_REQUEST_DONT_SHOW',{
          'SCARTATO': 'SCARTATO',
          'ESPLETAMENTOTECNICOKO': 'ESPLETAMENTOTECNICOKO',
          'ESPLETAMENTOTECNICO': 'ESPLETAMENTOTECNICO',
          'ANNULLATO': 'ANNULLATO',
          'CHIUSO': 'CHIUSO',
          'INANNULLAMENTOSULDELIVERY': 'INANNULLAMENTOSULDELIVERY',
          'INVIATOAFATTURAZIONE': 'INVIATOAFATTURAZIONE',
       	  'FATTURAZIONEKO': 'FATTURAZIONEKO',
       	  'INATTESAESPLETAMENTOFONIA': 'INATTESAESPLETAMENTOFONIA',
       	  'INANNULLAMENTOPERRIFIUTOPREVENTIVO': 'INANNULLAMENTOPERRIFIUTOPREVENTIVO'
	})

	.constant('MIGRAZIONE_ULL_SLU_STATI', {
		'0': 'FILE CARICATO',
		'1': 'CHECK FILE IN CORSO',
		'2': 'CHECK FILE OK',
		'3': 'CHECK FILE KO',
		'4': 'FILE IN LAVORAZIONE',
		'5': 'FILE ELABORATO OK',
		'6': 'FILE ELABORATO KO'
	})
    
    //SM_8904
    .constant('VIEW',{
    	'CLIENTE' : 'Cliente',
    	'CONTATTO' : 'Contatto',
    	'CONTRATTO' : 'Contratto',
    	'CESSAZIONE' : 'Cessazione',
    	'ASSET' : 'Lista Asset Accesso',
    	'CATALOGO' : 'Catalogo',
    	'NOTIFICHE' : 'File di Notifiche',
    	'STATO_FILE' : 'Stato File Ordini e Richieste',
    	'RICARICHE' : 'Lista Ricariche',
    	'RICHIESTE_RICARICHE' : 'Lista Richieste Ricariche',
    	'MONITORAGGIO_AGCOM' : 'Monitoraggio Agcom',
    	'MONITORAGGIO_AGCOM_DETTAGLIO' : 'Monitoraggio Agcom Dettaglio',
    	'MONITORAGGIO_KO_CAUTELARE' : 'Monitoraggio KO in cautelare',
    	'MONITORAGGIO_KO_GIORNALIERI' : 'Allarme KO giornalieri',
    	'MONITORAGGIO_KO_OLO' : 'Monitoraggio KO su OLO',
    	'MONITORAGGIO_KO_WARNING' : 'Monitoraggio KO di tipo warning',
    	'MONITORAGGIO_KO_WARNING_DETTAGLIO' : 'Monitoraggio KO di tipo warning Dettaglio',
    	'OPERE_SPECIALI' : 'Lista Ordini con opere speciali',
    	'ACCODATI' : 'Lista Ordini Accodati',
    	'BOZZA' : 'Lista Ordini in Bozza',
    	'SOSPESI' : 'Lista Ordini Sospesi',
    	'FATTURAZIONE' : 'Monitoraggio Fatturazione',
    	'MONITORAGGIO_FILE' : 'Monitoraggio File',
    	'MONITORAGGIO_FILE_DETTAGLIO' : 'Monitoraggio File Dettaglio',
    	'MONITORAGGIO_GIACENZA' : 'Monitoraggio Giacenza',
    	'MONITORAGGIO_KO' : 'Monitoraggio KO',
    	'MONITORAGGIO_NOTIFICHE_OLO' : 'Monitoraggio Notifiche OLO',
    	'MONITORAGGIO_ODV' : 'Monitoraggio ODV',
    	'MONITORAGGIO_DAC' : 'Monitoraggio Rimodulazioni DAC',
    	'MONITORAGGIO_INTERFACCE' : 'Monitoraggio Staging Interfacce NOW',
    	'MONITORAGGIO_TEMPI' : 'Monitoraggio Tempi di Attraversamento',
    	'MONITORAGGIO_TEMPI_DETTAGLIO' : 'Monitoraggio Tempi di Attraversamento Dettaglio',
    	'ORDER_TRACKING' : 'Order Tracking',
    	'ORDINI' : 'Lista Ordini',
    	'DETTAGLIO_ORDINE': 'Dettaglio ordine',
    	//RU_963
    	'MARCAGGIO_COMUNI_PRICING': 'Marcaggio Comuni/Pricing',
   		//RU_1058
    	'AREAMACROAREA' : 'Area MacroArea',
    	'CENTRALI_NGA': 'Centrali NGA',
    	'CENTRALI_GBE': 'Centrali GBE',
    	'NODI': 'Nodi',
    	'PDC': 'Punti di consegna',
    	'KIT_NGA_GBE' : 'Kit NGA GBE',
    	'VLAN': 'VLAN',
    	//RU_1127
    	'UPLOAD_DECOMMISSIONING': 'Upload File Decommissioning',
    	'DOWNLOAD_DECOMMISSIONING': 'Download File Decommissioning',
    	//RU_1180
    	'FILE_MULTICAST': 'Gestione File Multicast',
		'MIGRAZIONE_ULL_SLU': 'Gestione file migrazione ULL/SLU',
    	//RU_1188
    	'ASSET_RACCOLTA' : 'Lista Asset Raccolta',
    	//RU_1203
    	'NPNG': 'Associazione Opzione traffico prefisso NPNG',
    	//RU_1301
    	'COMUNI_COINVESTIMENTO': 'Gestione File Comuni coinvestimento',
    	//RU_1335
    	'FWA_WILL_DECO': 'Risorse FWA WILL Deco',
    	'FILE_FWA': 'Gestione File Risorse FWA Decommissioning',
    	//Change Request #42013
    	'MONITORAGGIO_KO_DEL_103' : 'Monitoraggio KO Delibera 103',
    	//RU_1492
    	'ORDINI_OPENFIBER' : 'Lista Ordini OF',
    	// RU_1583
    	'RADIUS': 'Radius'
    })
	
	// RU_1614
	.constant('PARENTAL_CONTROL_MAP', Object.freeze({
	    '1': 'Nessun blocco',
	    '2': 'Blocco di soli URL siti per adulti',
	    '3': 'Blocco adulti + malware',
	    '4': 'Blocco adulti + malware + violenza'
	  }))

;

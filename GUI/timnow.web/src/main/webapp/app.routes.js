timnow.config([ '$stateProvider', '$urlRouterProvider', '$httpProvider', '$logProvider', function($stateProvider, $urlRouterProvider, $httpProvider, $logProvider) {
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/json; charset=utf-8';
	$httpProvider.defaults.headers.put['Content-Type'] = 'application/json; charset=utf-8';
	$urlRouterProvider.otherwise('/homepage');

	/* Definizione degli Stati */
	$stateProvider
	
	/* Stato Padre */
	.state('root', {
		abstract : true,
		views : {
			'loading' : {
				templateUrl : 'app/init/content.html'
			},
			'header' : {
				templateUrl : 'app/common/header.html',
				controller : 'header'
			},
			'banner' : {
				templateUrl : 'app/common/banner.html'
			},
			'templates' : {
				templateUrl : 'app/common/templates.html'
			}
		},
		/* Lettura del file di Config */
		resolve : {
			loading : function($rootScope, ConfigFE, $window, $log) {
				return ConfigFE.get().$promise.then(function(response) {
					commonModule.constant('CONFIG', response);
					$rootScope.appLoaded = true;
					$rootScope.timnowConfigData = response;
                    
					var logDebugEnabled = $rootScope.timnowConfigData.config.logDebugEnabled === 'true';
                    $logProvider.debugEnabled(logDebugEnabled);
                    $rootScope.loadListaAmbiti();        
					return $rootScope.timnowConfigData;
				}, function(error) {
					if(error.status === 503){
						$log.error('Error loading configuration: BE not working');
						$window.location.href = 'serviceUnavailable.html';
					}else if(error.status === 504){
						$log.error('Error loading configuration: redirect to index.html');
						$window.location.href = 'index.html';
					}else if(error.status === 501){ // RU_856
						$log.error('Error manutenzione programmata');
						$window.location.href = 'manutenzioneProgrammata.jsp';
					}
					else {
						$log.error('Error loading configuration: user not authorized');
						$window.location.href = 'notAuthorized.html';
					}
					$log.error(error);
				});

			}
		}
	})
	
	/* Stati Figli */
	.state('root.homepage', {
		url : '/homepage',
		data : {
			pageTitle : 'Home | NOW'
		},
		params : {
			settore : 'allUser', // possono vederlo tutti gli utenti
			pageClass: 'home'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/common/banner.html',
			},
			'innercontent@' : {
				templateUrl : 'app/homepage/content.html',
				controller : 'homepage'
			}
		}
	})
	/*
	.state('root.disambiguazione', {
		url : '/disambiguazione',
		params : {
			settore : "Pagina di Disambiguazione",
			page : "Pagina di Disambiguazione",
			pageClass: 'disambiguazione',
			
			componente: 'Disambiguazione',
			macro: 'GUI Pagina di Disambiguazione'
				
		},
		data : {
			pageTitle : 'Disambiguazione | NOW'
		},
		views : {
			'header@' : {
				templateUrl : 'app/disambiguazione/header.html',
			},
			'banner@' : {
				template : '',
			},
			'innercontent@' : {
				templateUrl : 'app/disambiguazione/content.html',
				controller : 'disambiguazione'
			}
		}
	})*/
	.state('root.exit', {
		url : '/exit',
		data : {
			pageTitle : 'Uscita | NOW'
		},
		params : {
			settore : 'allUser',
			pageClass: 'exit'
		},
		views : {
			'header@' : {},
			'templates' : {},
			'banner@' : {},
			'innercontent@' : {
				templateUrl : 'app/exit/content.html',
				controller : 'exit'
			}
		}
	})
	.state('root.amministrazione', {
		abstract : true,
		params : {
			settore : "Amministrazione",
			ambito: 'Amministrazione'
		},
		url : '/amministrazione',
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/banner.html'
			}
		}
	})
	.state('root.ordini', {
		abstract : true,
		params : {
			settore : "Ordini",
			parametriRicerca : "",
			ambito: 'Ordini'
		},
		url : '/ordini',
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/newOrder/banner.html'
			}
		}
	})
	.state('root.anagrafica', {
		abstract : true,
		params : {
			settore : "Anagrafiche",
			ambito: "Anagrafiche"
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/banner.html'
			}
		}
	})
	.state('root.consistenze', {
		abstract : true,
		params : {
			settore : "Asset",
			ambito: 'Asset'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/consistenze/banner.html'
			}
		}
	})
	.state('root.notifiche', {
		abstract : true,
		params : {
			settore : "File e Notifiche",
			ambito: 'File e Notifiche'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/banner.html'
			}
		}
	})
	.state('root.monitoraggio', {
		abstract : true,
		params : {
			settore : "Reportistica",
//			settore : "Amministrazione"
			ambito: 'Monitoraggio'	
		},
		url : '/monitoraggio',
		views : {
			'banner@' : {
				templateUrl : 'app/monitoraggio/banner.html'
			}
		}
	})
	.state('root.monitoraggio.fatturazione', {
		url : '/fatturazione',
		data : {
			pageTitle : 'Monitoraggio Fatturazione | NOW'
		},
		params : {
			page : 'Monitoraggio Fatturazione',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio Fatturazione'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/fatturazione/listaFatturazione.html',
				controller : 'listaFatturazioneController'
			}
		}
	})
	.state('root.monitoraggio.fatturazione.contatore', {
		url : '/contatore',
		data : {
			pageTitle : 'Contatore | Monitoraggio Fatturazione | NOW'
		},
		params : {
			page : 'Monitoraggio Fatturazione',
			contatore: null,
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio Fatturazione',
			dettaglioFunzione: 'Contatore'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/fatturazione/dettaglioContatoreFatturazione.html',
				controller : 'dettaglioContatoreFatturazioneController'
			}
		}
	})
	.state('root.monitoraggio.fatturazione.contatore.dettaglio', {
		url : '/dettaglio',
		data : {
			pageTitle : 'Dettaglio contatore | Monitoraggio Fatturazione | NOW'
		},
		params : {
			page : 'Monitoraggio Fatturazione',
			selectedOrder: null,
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio Fatturazione',
			dettaglioFunzione: 'Contatore|Dettaglio'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/fatturazione/dettaglioFatturazione.html',
				controller : 'dettaglioFatturazioneController'
			}
		}
	})		
	.state('root.monitoraggio.notificheolo', {
		url : '/notificheolo',
		data : {
			pageTitle : 'Monitoraggio Notifiche OLO | NOW'
		},
		params : {
			page : 'Monitoraggio Notifiche OLO',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio Notifiche OLO'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/olonotifiche/listaOloNotifiche.html',
				controller : 'notificheOloController'
			}
		}
	})
	.state('root.monitoraggio.koOlo', {
		url : '/koOlo',
		data : {
			pageTitle : 'Monitoraggio KO su OLO | NOW'
		},
		params : {
			page : 'Monitoraggio KO su OLO',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio KO su OLO'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/koolo/listaKoOlo.html',
				controller : 'listakoOlo'
			}
		}
	})
	.state('root.monitoraggio.koCaut', {
		url : '/koCautelare',
		data : {
			pageTitle : 'Monitoraggio KO in CAUTELARE | NOW'
		},
		params : {
			//page : 'KO CAUTELARE'
			page : 'Monitoraggio KO in Cautelare',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio KO in Cautelare'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/kocautelare/listaKoCautelare.html',
				controller : 'listakoCaut'
			}
		}
	})
	.state('root.monitoraggio.koWarn', {
		url : '/koWarning',
		data : {
			pageTitle : 'Monitoraggio KO di Tipo Warning | NOW'
		},
		params : {
			page : 'Monitoraggio KO di Tipo Warning',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio KO di Tipo Warning'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/kowarning/listaKoWarning.html',
				controller : 'listakoWarn'
			}
		}
	})
	.state('root.monitoraggio.koWarn.dettaglio', {
		url : '/koWarningDettaglio',
		data : {
			pageTitle : 'Monitoraggio KO di Tipo Warning | NOW'
		},
		params : {
			page : 'Monitoraggio KO di Tipo Warning',
			dettaglio: '',
			parentData: [],
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio KO di Tipo Warning',
			dettaglioFunzione: 'Dettaglio'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/kowarning/listaKoWarningDettaglio.html',
				controller : 'listakoWarnDettaglio'
			}
		}
	})
	.state('root.monitoraggio.tempiAttraversamento', {
		url : '/tempi-attraversamento',
		data : {
			pageTitle : 'Monitoraggio Tempi di Attraversamento| NOW'
		},
		params : {
			//page : 'KO CAUTELARE'
			page : 'Monitoraggio Tempi di Attraversamento',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio Tempi di Attraversamento'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/attraversamento/listaTempiAttraversamento.html',
				controller : 'listaTempiAttrav'
			}
		}
	})
	.state('root.monitoraggio.tempiAttraversamento.dettaglio', {
		url : '/dettaglio',
		data : {
			pageTitle : 'Monitoraggio Tempi di Attraversamento | NOW'
		},
		params : {
			//page : 'KO CAUTELARE'
			page : 'Monitoraggio Tempi di Attraversamento',
			dettaglio: '',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio Tempi di Attraversamento',
			dettaglioFunzione: 'Dettaglio'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/attraversamento/listaTempiAttraversamentoDettaglio.html',
				controller : 'listaTempiAttravDettaglio'
			}
		}
	})
	.state('root.monitoraggio.file', {
		url : '/file',
		data : {
			pageTitle : 'Monitoraggio file| NOW'
		},
		params : {
			//page : 'KO CAUTELARE'
			page : 'Monitoraggio File',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio File',
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/file/listaFile.html',
				controller : 'listaFile'
			}
		}
	})
	.state('root.monitoraggio.file.dettaglio', {
		url : '/file/dettaglio',
		data : {
			pageTitle : 'Monitoraggio file| NOW'
		},
		params : {
			//page : 'KO CAUTELARE'
			page : 'Monitoraggio File',
			dettaglio : '',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio File',
			dettaglioFunzione: 'Dettaglio'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/file/listaFileDettaglio.html',
				controller : 'FileDettaglio'
			}
		}
	})
	.state('root.monitoraggio.koGiornal', {
		url : '/koGiornalieri',
		data : {
			pageTitle : 'Allarmi su KO Giornalieri | NOW'
		},
		params : {
			//page : 'KO CAUTELARE'
			page : 'Allarmi su KO Giornalieri',
			
			componente: 'Monitoraggio',
			macro: 'Allarmi su KO Giornalieri'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/kogiornalieri/listaKoGiornalieri.html',
				controller : 'listakoGiornal'
			}
		}
	})
	.state('root.monitoraggio.rinvioemail', {
		url : '/email',
		data : {
			pageTitle : 'Rinvio Mail | NOW'
		},
		params : {
			//page : 'Rinvio Email'
			page : 'Rinvio Mail',
			
			componente: 'Monitoraggio',
			macro: 'Rinvio Mail'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/rinvioemail/listaRinvioEmail.html',
				controller : 'rinvioEmailController'
			}
		}
	})
	.state('root.monitoraggio.rinviofile', {
		url : '/rinviofile',
		data : {
			pageTitle : 'Rinvio File | NOW'
		},
		params : {
			page : 'Rinvio File',
			
			componente: 'Monitoraggio',
			macro: 'Rinvio File'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/rinviofile/listaRinvioFile.html',
				controller : 'rinvioFileController'
			}
		}
	})
	.state('root.monitoraggio.rinvionotifiche', {
		url : '/notifiche',
		data : {
			pageTitle : 'Rinvio Notifiche | NOW'
		},
		params : {
			page : 'Rinvio Notifica',
			
			componente: 'Monitoraggio',
			macro: 'Rinvio Notifica'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/rinvionotifiche/rinvioNotifiche.html',
				controller : 'rinvioNotificheController'
			}
		}
	})
	.state('root.monitoraggio.usertask', {
		url : '/usertask',
		data : {
			pageTitle : 'User Task | NOW'
		},
		params : {
			page : 'User Task',
			
			componente: 'Monitoraggio',
			macro: 'Gestione User Task'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/usertask/content.html',
				controller : 'userTaskController'
			}
		}
	})
	.state('root.monitoraggio.generazionenotifichetemplate', {
		url : '/generanotifiche',
		data : {
			pageTitle : 'Generazione notifiche da template | NOW'
		},
		params : {
			page : 'Generazione Notifiche da Template',
			
			componente: 'Monitoraggio',
			macro: 'Generazione Notifiche da Template'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/generazionenotifichetemplate/generazioneNotifiche.html',
				controller : 'generazioneNotificheController'
			}
		}
	})

	 .state('root.monitoraggio.agcom', {
		  url : '/agcom',
		  data : {
			  pageTitle : 'Monitoraggio AGCOM | NOW'
		  },
		  params : {
			  page : 'Monitoraggio AGCOM',
			  livello : 'livello',
			  
				componente: 'Monitoraggio',
				macro: 'Monitoraggio AGCOM'
		  },
		  views : {
		   'innercontent@' : {
			   templateUrl : 'app/monitoraggio/agcom/listaAgcom.html',
			   controller : 'listaAgcom'
		   }
		}
	})

	.state('root.monitoraggio.agcom.dettaglioAgcom', {
		  data : {
			  pageTitle : 'Monitoraggio AGCOM | NOW'
		  },
		  params : {
			  page : 'Monitoraggio AGCOM',
			  livello : 'livello',
			  dettaglio : 'dettaglio',			
			  giorno : 'giorno',
			  
				componente: 'Monitoraggio',
				macro: 'Monitoraggio AGCOM',
				dettaglioFunzione : 'Dettaglio'
		  },
		  views : {
		   'innercontent@' : {
			   templateUrl : 'app/monitoraggio/agcom/dettaglioAgcom.html',
			   controller : 'dettaglioAgcom'
		   }
		}
	})
	
   .state('root.monitoraggio.rimodulazioniDAC', {
        url : '/rimodulazionidac',
        data : {
            pageTitle : 'Monitoraggio Rimodulazioni DAC | NOW'
        },
        params : {
            page : 'Monitoraggio Rimodulazioni DAC',
            
			componente: 'Monitoraggio',
			macro: 'Monitoraggio Rimodulazioni DAC'
        },
        views : {
            'innercontent@' : {
                templateUrl : 'app/monitoraggio/rimodulazioniDAC/rimodulazioniDAC.html',
                controller : 'rimodulazioniDACController'
            }
        }
    })

    .state('root.monitoraggio.rigenerazioneMail', {
        url : '/rigenerazionemail',
        data : {
            pageTitle : 'Rigenerazione Mail | NOW'
        },
        params : {
            page : 'Monitoraggio Rigenerazione Email',
            tipologia: 'Lista Notifiche',
            parametriRicerca : "",
            
            componente: 'Monitoraggio',
			macro: 'Rigenerazione Mail'
        },
        views : {
            'innercontent@' : {
                templateUrl : 'app/monitoraggio/rigenerazionemail/listaRigenerazioneMail.html',
                controller : 'rigenerazioneMailController'
            }
        }
    })

    .state('root.monitoraggio.rigenerazioneMail.listaNotifiche', {
		url : '/rigenerazionemail/:idRichiestaOlo',
		data : {
            pageTitle : 'Rigenerazione Mail | NOW'
		},
		params : {
			page : 'Monitoraggio Rigenerazione Email',
			tipologia: 'Lista Notifiche',
			parametriRicerca : "",
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio Rigenerazione Email',
			dettaglioFunzione: 'Lista Notifiche'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/rigenerazionemail/notifiche/listaNotificheRigenerazioneMail.html',
				controller : 'notificheRigenerazioneMailController'
			}
		}
	})	
	//Change Request #42013	
	.state('root.monitoraggio.koDelibera103', {
		url : '/koDelibera103',
		data : {
			pageTitle : 'Monitoraggio KO Delibera 103 | NOW'
		},
		params : {
			page : 'Monitoraggio KO Delibera 103',
			
			componente: 'Monitoraggio',
			macro: 'Monitoraggio KO Delibera 103'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/monitoraggio/kodel103/listaKoDel103.html',
				controller : 'listaKoDel103'
			}
		}
	})

	.state('root.amministrazione.SLAtime', {
		url : '/SLAtime',
		data : {
			pageTitle : 'SLA time | NOW'
		},
		params : {
			page : 'SLA Time',
			pageClass: 'SLA Time',
			tipologia:'SLA Time',
			
			componente: 'Amministrazione',
			macro: 'SLA Time',
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/SLAtime/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/SLAtime/listaSLAtime.html',
				controller : 'listaSLAtime'
			}
		}
	})
	.state('root.amministrazione.News', {
		url : '/News',
		data : {
			pageTitle : 'News | NOW'
		},
		params : {
			page : 'News e Informative Migrazione',
			pageClass: 'News',
			tipologia:'News',
			
			componente: 'Amministrazione',
			macro: 'News e Informative Migrazione'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/News/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/News/listaNews.html',
				controller : 'amministrazioneNewsList'
			}
		}
	})
	.state('root.amministrazione.News.addModify', {
		data : {
			pageTitle : 'News | NOW'
		},
		params : {
			news : '',
			page : 'News e Informative Migrazione',
			pageClass: 'AddNews',
			tipologia:'News'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/News/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/News/addModify/addNews.html',
				controller : 'AddNews'
			}
		}
	})
	.state('root.amministrazione.Atms', {
		url : '/atms',
		data : {
			pageTitle : 'ATM | NOW'
		},
		params : {
			page : 'Kit ATM',
			pageClass: 'Atm',
			tipologia:'Kit ATM',
			
			componente: 'Amministrazione',
			macro: 'Kit ATM'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/atms/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/atms/listaAtms.html',
				controller : 'Atms'
			}
		}
	})
	.state('root.amministrazione.faq', {
		url : '/faq',
		data : {
			pageTitle : 'FAQ | NOW'
		},
		params : {
			page : 'FAQ Management',
			pageClass: 'Faq',
			tipologia:'Faq',
			
			componente: 'Amministrazione',
			macro: 'FAQ'
		},
		views : { 
			'banner@' : {
				templateUrl : 'app/amministrazione/faq/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/faq/Faq.html',
				controller : 'amministrazioneFaq'
			}
		}
	})
	.state('root.amministrazione.faq.addModify', {
		params : {
			faq : "",
			page : 'FAQ Management',
			pageClass: 'AddFaq',
			tipologia:'Faq',
			
			componente: 'Amministrazione',
			macro: 'FAQ'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/amministrazione/faq/addModify/addFaq.html',
				controller : 'amministrazioneAddFaq'
			}
		}
	})
	.state('root.amministrazione.archiTD', {
		url : '/archiTD',
		data : {
			pageTitle : 'Archi TD | NOW'
		},
		params : {
			page : 'Gestione archi TD',
			pageClass: 'Archi TD',
			tipologia:'Archi TD',
			
			componente: 'Amministrazione',
			macro: 'Gestione archi TD'
		},
		views : { 
			'banner@' : {
				templateUrl : 'app/amministrazione/archiTD/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/archiTD/archiTD.html',
				controller : 'amministrazioneArchiTD'
			}
		}
	})
	.state('root.amministrazione.archiTD.addModify', {
		params : {
			faq : "",
			page : 'Gestione archi TD',
			pageClass: 'AddArchiTD',
			tipologia:'ArchiTD',
			archiTD:''
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/amministrazione/archiTD/addModify/addArchiTD.html',
				controller : 'amministrazioneAddArchiTD'
			}
		}
	})
	.state('root.amministrazione.ihelp', {
		url : '/ihelp',
		data : {
			pageTitle : 'iHelp | NOW'
		},
		params : {
			page : 'iHelp Management',
			pageClass: 'iHelps',
			tipologia:'iHelp',
			
			componente: 'Amministrazione',
			macro: 'iHelp'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/iHelps/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/iHelps/iHelp.html',
				controller : 'amministrazioneIhelp'
			}
		}
	})
	.state('root.amministrazione.ihelp.addModify', {
		params : {
			ihelp : "",
			page : 'iHelp Management',
			pageClass: 'AddIhelp', 
			tipologia:'iHelp',
			
			componente: 'Amministrazione',
			macro: 'iHelp'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/amministrazione/iHelps/addModify/addIhelp.html',
				controller : 'AddIhelp'
			}
		}
	})
	.state('root.amministrazione.lines', {
		url : '/lines',
		data : {
			pageTitle : 'Profili Linea | NOW'
		},
		params : {
			page : 'Profili Linea',
			pageClass: 'lines',
			tipologia:'Profili Linea',
			
			componente: 'Amministrazione',
			macro: 'Profili Linea'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/lines/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/lines/lines.html',
				controller : 'linea'
			}
		}
	})
	.state('root.amministrazione.VLAN', {
		url : '/vlansvlan',
		data : {
			pageTitle : 'VLAN/SVLAN | NOW'
		},
		params : {
			page : 'VLAN/SVLAN',
			pageClass: 'lans',
			tipologia:'VLAN/SVLAN',
			
			componente: 'Amministrazione',
			macro: 'VLAN/SVLAN'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/vlan_svlan/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/vlan_svlan/lans.html',
				controller : 'vlanSvlan'
			}
		}
	})
	.state('root.amministrazione.vcs', {
		url : '/vcs',
		data : {
			pageTitle : 'Profili VC | NOW'
		},
		params : {
			page : 'Profili VC',
			pageClass: 'vcs',
			tipologia:'Profili VC',
			
			componente: 'Amministrazione',
			macro: 'Profili VC'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/vcs/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/vcs/vcs.html',
				controller : 'vcs'
			}
		}
	})
	.state('root.amministrazione.vp', {
		url : '/vp',
		data : {
			pageTitle : 'Profili VP | NOW'
		},
		params : {
			page : 'VP',
			pageClass: 'vps',
			tipologia:'Profili VP',
			
			componente: 'Amministrazione',
			macro: 'VP'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/vp/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/vp/listaVp.html',
				controller : 'vps'
			}
		}
	})
	.state('root.amministrazione.bandepicco', {
		url : '/BandePicco',
		data : {
			pageTitle : 'Lista Bande Picco | NOW'
		},
		params : {
			page : 'Bande Picco',
			pageClass: 'Bande Picco',
			tipologia:'Bande Picco',
			
			componente: 'Amministrazione',
			macro: 'Bande Picco'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/BandePicco/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/BandePicco/listaBandePicco.html',
				controller : 'listaBande'
			}
		}
	})
	.state('root.amministrazione.causalirimodulazioni', {
		url : '/CausaliRimodulazioni',
		data : {
			pageTitle : 'Causali Rimodulazioni | NOW'
		},
		params : {
			page : 'Configura Causali RDAC',
			tipologia:'Causali RDAC',
			
			componente: 'Amministrazione',
			macro: 'Configura Causali RDAC'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/CausaliRimodulazioni/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/CausaliRimodulazioni/listaCausaliRimodulazioni.html',
				controller : 'listaCausaliRimod'
			}
		}
	})
	.state('root.amministrazione.pps', {
		url : '/parametripps',
		data : {
			pageTitle : 'Parametri Monitoraggio PPS | NOW'
		},
		params : {
			page : 'Parametri Monitoraggio PPS',
			tipologia:'Parametri Monitoraggio PPS',
			
			componente: 'Amministrazione',
			macro: 'Parametri Monitoraggio PPS'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/pps/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/pps/content.html',
				controller : 'pps'
			}
		}
	})	
	
	//RU_1058
	.state('root.amministrazione.areaMacroArea', {
		url : '/areaMacroArea',
		data : {
			pageTitle : 'Area MacroArea | NOW'
		},
		params : {
			page : 'Area MacroArea',
			tipologia:'Area MacroArea',
			
			componente: 'Amministrazione',
			macro: 'Area MacroArea'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/areaMacroArea/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/areaMacroArea/content.html',
				controller : 'areaMacroArea'
			}
		}
	})
	.state('root.amministrazione.centrali', {
		url : '/centrali',
		abstract: true,
	})
	.state('root.amministrazione.centrali.gbe', {
		url : '/gbe',
		data : {
			pageTitle : 'Centrali GBE| NOW'
		},
		params : {
			page : 'Centrali GBE',
			tipologia:'Centrali GBE',
			
			componente: 'Amministrazione',
			macro: 'Centrali GBE'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/centrali/gbe/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/centrali/gbe/content.html',
				controller : 'centraliGbe'
			}
		}
	})
	.state('root.amministrazione.centrali.nga', {
		url : '/nga',
		data : {
			pageTitle : 'Centrali NGA| NOW'
		},
		params : {
			page : 'Centrali NGA',
			tipologia:'Centrali GBE',
			
			componente: 'Amministrazione',
			macro: 'Centrali NGA'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/centrali/nga/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/centrali/nga/content.html',
				controller : 'centraliNga'
			}
		}
	})
	.state('root.amministrazione.pdc', {
		url : '/pdc',
		data : {
			pageTitle : 'Punti di consegna| NOW'
		},
		params : {
			page : 'Punti di consegna',
			tipologia:'Punti di consegna',
			
			componente: 'Amministrazione',
			macro: 'Punti di consegna'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/pdc/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/pdc/content.html',
				controller : 'pdc'
			}
		}
	})
	.state('root.amministrazione.nodi', {
		url : '/nodi',
		data : {
			pageTitle : 'Nodi| NOW'
		},
		params : {
			page : 'Nodi',
			tipologia:'Nodi',
			
			componente: 'Amministrazione',
			macro: 'Nodi'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/nodi/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/nodi/content.html',
				controller : 'nodi'
			}
		}
	})
	.state('root.amministrazione.kitngagbe', {
		url : '/kitNgaGbe',
		data : {
			pageTitle : 'Kit NGA GBE| NOW'
		},
		params : {
			page : 'Kit NGA GBE',
			tipologia:'Kit NGA GBE',
			
			componente: 'Amministrazione',
			macro: 'Kit NGA GBE'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/kitVlan/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/kitVlan/content.html',
				controller : 'kitVlan'
			}
		}
	})
	.state('root.amministrazione.vlan', {
		url : '/vlan',
		data : {
			pageTitle : 'VLAN| NOW'
		},
		params : {
			page : 'VLAN',
			tipologia:'VLAN',
			
			componente: 'Amministrazione',
			macro: 'VLAN'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/vlan/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/vlan/content.html',
				controller : 'vlan'
			}
		}
	})	
	.state('root.ordini.lista', {
		url : '/lista-ordini',
		data : {
			pageTitle : 'Lista ordini | NOW'
		},
		params : {
			page : 'Lista Ordini',
			tipologia: 'Lista Ordini',
			parametriRicerca : "",
			init : false,
			
			componente: 'Ordini',
			macro: 'Lista Ordini'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/lista/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/lista/content.html',
				controller : 'listaOrdini'
			}
		}
	})
	.state('root.ordini.bozza', {
		url : '/lista-bozza',
		data : {
			pageTitle : 'Lista Bozza | NOW'
		},
		params : {
			page : 'Ordini in Bozza',
			
			componente: 'Ordini',
			macro: 'Ordini in Bozza'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/bozza/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/bozza/content.html',
				controller : 'listaBozze'
			}
		}
	})
	//RU_1492
	.state('root.ordini.openfiber', {
		url : '/lista-ordini-openfiber',
		data : {
			pageTitle : 'Lista ordini OpenFiber| NOW'
		},
		params : {
			page : 'Lista Ordini OpenFiber',
			tipologia: 'Lista Ordini OpenFiber',
			parametriRicerca : "",
			init : false,
			
			componente: 'Ordini',
			macro: 'Lista Ordini OpenFiber'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/openFiber/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/openFiber/ordiniOpenFiber.html',
				controller : 'listaOrdiniOpenFiber'
			}
		}
	})
	.state('root.ordini.lista.dettaglio', {
		url : '/:reqType/:orderNumber',
		data : {
			pageTitle : 'Dettaglio ordine | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Lista Ordini',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			tipologia : 'Lista Ordini',
			
			componente: 'Ordini',
			macro: 'Lista Ordini',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/dettaglioOrdine.html',
				controller : 'dettaglioOrdine'
			}
		}
	})
	.state('root.ordini.lista.dettaglio.tracciamento', {
		url : '/tracciamento-stato',
		data : {
			pageTitle : 'Tracciamento e Stato | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Lista Ordini',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			idRichiestaOlo:"",
			inizioTracciamento:"",
			fineTracciamento:"",
			tipologia : 'Lista Ordini'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/tracciamentoestato/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/tracciamentoestato/content.html',
				controller : 'tracciamenoeStato'
			}
		}
	})
	.state('root.ordini.lista.dettaglio.richiesta', {
		url : '/richiesta',
		data : {
			pageTitle : 'Nuova richiesta per ordine | NOW'
		},
		params : {
			order : "",
			page : 'Nuova Richiesta',
			
			componente: 'Ordini',
			macro: 'Lista Ordini',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/richiesta/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/richiesta/richiesta.html',
				controller : 'richiestaOrdine'
			}
		}
	})
	//RU_1492
	.state('root.ordini.openfiber.dettaglio', {
		url : '/:reqType/:orderNumber',
		data : {
			pageTitle : 'Dettaglio ordine | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Lista Ordini',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			tipologia : 'Lista Ordini',
			
			componente: 'Ordini',
			macro: 'Lista Ordini',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/dettaglioOrdine.html',
				controller : 'dettaglioOrdine'
			}
		}
	})
	.state('root.ordini.openfiber.dettaglio.tracciamento', {
		url : '/tracciamento-stato',
		data : {
			pageTitle : 'Tracciamento e Stato | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Lista Ordini',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			idRichiestaOlo:"",
			inizioTracciamento:"",
			fineTracciamento:"",
			tipologia : 'Lista Ordini'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/tracciamentoestato/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/tracciamentoestato/content.html',
				controller : 'tracciamenoeStato'
			}
		}
	})
	.state('root.ordini.openfiber.dettaglio.richiesta', {
		url : '/richiesta',
		data : {
			pageTitle : 'Nuova richiesta per ordine | NOW'
		},
		params : {
			order : "",
			page : 'Nuova Richiesta',
			
			componente: 'Ordini',
			macro: 'Lista Ordini',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/richiesta/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/richiesta/richiesta.html',
				controller : 'richiestaOrdine'
			}
		}
	})
//	INIZIO NUOVO ORDINE
	.state('root.ordini.new', {
		url : '/new',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				controller : 'newOrder'
			}
		},
		params : {
			page : 'Nuovo Ordine',
			init : false,
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
		},
		//SM_9063
		onEnter: ['ResetDataService', function(ResetDataService){
			ResetDataService.reset(/^root.ordini.new*[.A-Za-z0-1]{0,}/);
		}]
	})
	//RU_1180
	.state('root.ordini.newprimofeeder', {
		url : '/newPrimoFeeder',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				controller : 'newOrder'
			}
		},
		params : {
			page : 'Nuovo Ordine',
			init : false,
			primoFeeder: true,
			secondoFeeder: false,
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
		},
		onEnter: ['$rootScope', 'VerificaAbilitazioneMcContratto', 'ResetDataService', '$state', 'modalService', function($rootScope, VerificaAbilitazioneMcContratto, ResetDataService, $state, modalService){
			ResetDataService.reset(/^root.ordini.new*[.A-Za-z0-1]{0,}/);
			
			var _codOloAgcom = $rootScope.timnowConfigData.user.codificaOloAgcom;
			
			if($rootScope.isOLOUser()){
				VerificaAbilitazioneMcContratto.get({codOloAgcom: _codOloAgcom, flagPrimoFeeder: 'Y'}).$promise
				.then(function(response){
					if(response && response.VerificaAbilitazioneMcContrattoOutput && response.VerificaAbilitazioneMcContrattoOutput.esito == 'KO'){
		                  modalService.alertOkMessage("Attenzione, non esiste un contratto attivo abilitato al Multicast; non è possibile procedere con l’inserimento dell’ordine richiesto");
		                  $state.go('root.homepage');
					}
				}, function(error){
					modalService.alertOkMessage("Impossibile verificare l'abilitazione Multicast per l'OLO");
					$state.go('root.homepage');
				});		
			}else{
				return null;
			}
		}]
	})
	.state('root.ordini.newfeedersuccessivo', {
		url : '/newFeederSuccessivo',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				controller : 'newOrder'
			}
		},
		params : {
			page : 'Nuovo Ordine',
			init : false,
			primoFeeder: false,
			secondoFeeder: true,
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
		},
		onEnter: ['$rootScope', 'VerificaAbilitazioneMcContratto', 'ResetDataService', '$state', 'modalService', function($rootScope, VerificaAbilitazioneMcContratto, ResetDataService, $state, modalService){
			ResetDataService.reset(/^root.ordini.new*[.A-Za-z0-1]{0,}/);
			
			var _codOloAgcom = $rootScope.timnowConfigData.user.codificaOloAgcom;
			
			if($rootScope.isOLOUser()){
				VerificaAbilitazioneMcContratto.get({codOloAgcom: _codOloAgcom, flagPrimoFeeder: 'N'}).$promise
				.then(function(response){
					if(response && response.VerificaAbilitazioneMcContrattoOutput && response.VerificaAbilitazioneMcContrattoOutput.esito == 'KO'){
		                  modalService.alertOkMessage("Attenzione, non esiste un contratto attivo abilitato al Multicast; non è possibile procedere con l’inserimento dell’ordine richiesto");
		                  $state.go('root.homepage');
					}
				}, function(error){
					modalService.alertOkMessage("Impossibile verificare l'abilitazione Multicast per l'OLO");
					$state.go('root.homepage');
				});		
			}else{
				return null;
			}
		}]
	})
	.state('root.ordini.new.step1', {
		url : '/step1',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step1/content.html',
				controller : 'newOrder'
			}
		},
		params : {
			returning : null,
			order : "",
			asset:"",
			init : false,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 1'
		}
	})
	.state('root.ordini.new.step2', {
		url : '/step2',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step2/dati-ordine.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 2,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 2'
		}
	})
	.state('root.ordini.new.step3', {
		url : '/step3',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step3/content.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 3,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 3'
		}
	})
	.state('root.ordini.new.attivazione-configurazione', {
		url : '/step4',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step4/configurazione-offerta.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 4,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 4'
		}
	})
	.state('root.ordini.new.step5', {
		url : '/step5',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step5/dati-riferimenti.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 5,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 5'
		}
	})
	.state('root.ordini.new.step6', {
		url : '/step6',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step6/dati-cliente.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 6,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 6'
		}
	})
	.state('root.ordini.new.step7', {
		url : '/step7',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step7/dettaglio-ordine.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 7,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 7'
		}
	})
	.state('root.ordini.new.step8', {
		url : '/step8',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step8/riepilogo-ordine.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 8,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 8'
		},
		
		//SM_9063
		onExit: ['ResetDataService', function(ResetDataService){
			ResetDataService.reset(/^root.ordini.new*[.A-Za-z0-1]{0,}/);
		}]
	})
//	FINE NUOVO ORDINE
	
	// INIZIO SEZIONE MIGRATA NUOVO ORDINE NUOVO   
    .state('root.ordini.new.attivazione-conferma', {
        url : '/conferma',
        data : {
            pageTitle : 'Nuovo ordine di Attivazione - Conferma ricezione | NOW'
        },
        views : {
            'innercontent@' : {
                templateUrl : 'app/ordini/newOrder/conferma.html',
                controller : 'newOrder'
            }
        },
        params : {
            operazione : 'attivazione',
            step : 'conferma',
            page : 'Nuovo Ordine',
            
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Conferma'
        }
    })

// FINE SEZIONE MIGRATA NUOVO ORDINE NUOVO  

	//RU_1203
	//RU_1394
	//INIZIO ORDINE NPNG
	/*
	.state('root.ordini.npng', {
		abstract: true,		
		params : {
			settore : "Ordini NPNG",
			ambito: 'Ordini NPNG',
			init : false
		},
		url : '/npng',
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/newOrder/banner.html'
			},
			'innercontent@' : {
				controller : 'lavorazioneManualeNpng'
			}
		}
	})	
	
	.state('root.ordini.npng.lavorazioneManuale', {
		parent: 'root.ordini.npng',
		url : '/lavorazioneManuale',		
		data : {
			pageTitle : 'Lavorazione Manuale NPNG | NOW'
		},
		views: {
			'innercontent@' : {
				controller : 'lavorazioneManualeNpng'
			}
		},
		params : {
			page : 'Lavorazione Manuale NPNG',
			init : false,
			
			componente: 'Ordini NPNG',
			macro: 'Lavorazione Manuale NPNG',
		}
	})
	
	.state('root.ordini.npng.lavorazioneManuale.step1', {
		parent: 'root.ordini.npng.lavorazioneManuale',
		url : '/ricercaOrdine',
		data : {
			pageTitle : 'Ricerca Ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/npng/lavorazione_manuale/step1/content.html',
				controller : 'ricercaOrdineNpng'
			}
		},
		params : {
			page : 'Lavorazione Manuale NPNG',
			init : false,
			
			componente: 'Ordini NPNG',
			macro: 'Lavorazione Manuale NPNG',
		}
	})
	
	.state('root.ordini.npng.lavorazioneManuale.step2', {
		parent: 'root.ordini.npng.lavorazioneManuale',
		url : '/lavorazioneOrdine',
		data : {
			pageTitle : 'Lavorazione Ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/npng/lavorazione_manuale/step2/content.html',
				controller : 'lavorazioneOrdineNpng'				
			}
		},
		params : {
			page : 'Lavorazione Manuale NPNG',
			init : false,
			idOrdine: null,
			
			componente: 'Ordini NPNG',
			macro: 'Lavorazione Manuale NPNG',
		}
	})
	
	.state('root.ordini.npng.lavorazioneManuale.conferma', {
        url : '/conferma',
        parent: 'root.ordini.npng.lavorazioneManuale',
        data : {
            pageTitle : 'Conferma | NOW'
        },
        views : {
			'innercontent@' : {
				templateUrl: 'app/ordini/npng/lavorazione_manuale/conferma.html',
				controller : 'lavorazioneManualeNpng'
			}
        },
        params : {
            operazione : 'attivazione',
            step : 'conferma',
            page : 'Conferma',
            
			componente: 'Ordini NPNG',
			macro: 'Lavorazione Manuale NPNG',
			dettaglioFunzione: 'Conferma'
        }
    })
	
	.state('root.ordini.npng.cambioOlo', {
		parent: 'root.ordini.npng',
		url : '/cambioOlo',		
		data : {
			pageTitle : 'Cambio OLO NPNG | NOW'
		},
		views: {
			'innercontent@' : {
				controller : 'cambioOloNpng'
			}
		},
		params : {
			page : 'Cambio OLO NPNG',
			init : false,
			
			componente: 'Ordini NPNG',
			macro: 'Cambio OLO NPNG',
		}
	})
	
	.state('root.ordini.npng.cambioOlo.step1', {
		parent: 'root.ordini.npng.cambioOlo',
		url : '/ricercaOrdine',
		data : {
			pageTitle : 'Ricerca Risorsa | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/npng/cambio_olo/step1/content.html',
				controller : 'ricercaRisorsaNpng'
			}
		},
		params : {
			page : 'Ricerca Risorsa',
			init : false,
			
			componente: 'Ordini NPNG',
			macro: 'Cambio OLO NPNG',
		}
	})
	
	.state('root.ordini.npng.cambioOlo.step2', {
		parent: 'root.ordini.npng.cambioOlo',
		url : '/visualizzazioneConsistenza',
		data : {
			pageTitle : 'Visualizzazione Consistenza | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/npng/cambio_olo/step2/content.html',
				controller : 'visualizzazioneConsistenzaNpng'				
			}
		},
		params : {
			page : 'Visualizzazione Consistenza',
			init : false,
			idOrdine: null,
			
			componente: 'Ordini NPNG',
			macro: 'Visualizzazione Consistenza',
		}
	})
	
	.state('root.ordini.npng.cambioOlo.conferma', {
        url : '/conferma',
        parent: 'root.ordini.npng.cambioOlo',
        data : {
            pageTitle : 'Conferma | NOW'
        },
        views : {
			'innercontent@' : {
				templateUrl: 'app/ordini/npng/cambio_olo/conferma.html',
				controller : 'cambioOloNpng'
			}
        },
        params : {
            operazione : 'attivazione',
            step : 'conferma',
            page : 'Conferma',
            
			componente: 'Ordini NPNG',
			macro: 'Lavorazione Manuale NPNG',
			dettaglioFunzione: 'Conferma'
        }
    })
	//FINE ORDINE NPNG
	
	*/
	  

// INIZIO NUOVA SEZIONE CESSAZIONE
    .state('root.ordini.new.cessazione', {
		url : '/cessazione',
		data : {
			pageTitle : 'Nuovo ordine di Cessazione | NOW'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/newOrder/cessazione/banner.html'
			},
			'innercontent@' : {
				controller : 'cessazioneNewOrder'
			}
		},
		params : {
			page : 'Nuovo Ordine',
			init : false,
			
			componente: 'Ordini',
			macro: 'Cessazione Ordine',
			dettaglioFunzione: 'Step 1'
		},
		
		//SM_9063
		onEnter: ['ResetDataService', function(ResetDataService){
			ResetDataService.reset(/^root.ordini.new*[.A-Za-z0-1]{0,}/);
		}]
	})
    .state('root.ordini.new.cessazione.step2', {
    	url : '/step2',
		data : {
			pageTitle : 'Nuovo ordine di Cessazione - Step 2 | NOW'
		},
		params : {
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Cessazione Ordine',
			dettaglioFunzione: 'Step 2'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/cessazione/step2.html',
				controller : 'cessazioneNewOrder'
			}
		}
	})
	.state('root.ordini.new.cessazione.step3', {
		url : '/step3',
		data : {
			pageTitle : 'Nuovo ordine di Cessazione - Step 3 | NOW'
		},
		params : {
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Cessazione Ordine',
			dettaglioFunzione: 'Step 3'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/cessazione/dati-riferimenti.html',
				controller : 'cessazioneNewOrder'
			}
		}
	})
	.state('root.ordini.new.cessazione.riepilogo', {
		url : '/riepilogo',
		data : {
			pageTitle : 'Nuovo ordine di Cessazione - Riepilogo | NOW'
		},
		params : {
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Cessazione Ordine',
			dettaglioFunzione: 'Riepilogo'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/cessazione/riepilogo.html',
				controller : 'cessazioneNewOrder'
			}
		}
	})
	.state('root.ordini.new.cessazione.conferma', {
		url : '/conferma',
		data : {
			pageTitle : 'Nuovo ordine di Cessazione - conferma | NOW'
		},
		params : {
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Cessazione Ordine',
			dettaglioFunzione: 'Conferma'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/cessazione/conferma.html'
			}
		},
		
		//SM_9063
		onExit: ['ResetDataService', function(ResetDataService){
			ResetDataService.reset(/^root.ordini.new.cessazione*[.A-Za-z0-1]{0,}/);
		}]
	})
// FINE NUOVA SEZIONE CESSAZIONE
	.state('root.ordini.sospesi', {
		url : '/ordini-sospesi',
		data : {
			pageTitle : 'Lista ordini sospesi | NOW'
		},
		params : {
			page : 'Ordini Sospesi',
			parametriRicerca : "",
			tipologia: 'Lista Ordini Sospesi',
			init : false,
			
			componente: 'Ordini',
			macro: 'Ordini Sospesi'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/sospesi/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/sospesi/sospesi.html',
				controller : 'listaOrdiniSospesi'
			}
		}
	})
	.state('root.ordini.sospesi.dettaglio', {
		url : '/:reqType/:orderNumber',
		data : {
			pageTitle : 'Dettaglio ordine | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Ordini Sospesi',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			tipologia : 'Lista Ordini Sospesi',
			
			componente: 'Ordini',
			macro: 'Ordini Sospesi',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/dettaglioOrdine.html',
				controller : 'dettaglioOrdine'
			}
		}
	})
	.state('root.ordini.accodati', {
		url : '/ordini-accodati',
		data : {
			pageTitle : 'Lista ordini accodati | NOW'
		},
		params : {
			page : 'Ordini Accodati',
			parametriRicerca : "",
			tipologia: 'Lista Ordini Accodati',
			init : false,
			
			componente: 'Ordini',
			macro: 'Ordini Accodati'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/accodati/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/accodati/accodati.html',
				controller : 'listaOrdiniAccodati'
			}
		}
	})
	.state('root.ordini.accodati.dettaglio', {
		url : '/:reqType/:orderNumber',
		data : {
			pageTitle : 'Dettaglio ordine | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Ordini Accodati',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			tipologia : 'Lista Ordini Accodati',
			
			componente: 'Ordini',
			macro: 'Ordini Accodati',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/dettaglioOrdine.html',
				controller : 'dettaglioOrdine'
			}
		}
	})
	.state('root.ordini.rielaborabili', {
		url : '/ordini-rielaborabili',
		data : {
			pageTitle : 'Lista ordini rielaborabili| NOW'
		},
		params : {
			idArea : 2,
			label : 1,
			page : 'Ordini Rielaborabili'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/rielaborabili/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/rielaborabili/listaRiela.html',
				controller : 'News' // DA CAMBIARE
			}
		}
	})
	.state('root.ordini.donating', {
		url : '/ordini-donating',
		data : {
			pageTitle : 'Lista ordini donating | NOW'
		},
		params : {
			page : 'Ordini Donating',
			filters: null,		
			
			componente: 'Ordini',
			macro: 'Ordini Donating'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/donating/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/donating/listaOrdiniDonating.html',
				controller : 'listaOrdiniDonating'
			}
		}
	})
	.state('root.ordini.donating.dettaglio', {
		data : {
			pageTitle : 'Dettaglio ordine | NOW'
		},
		params : {
			order: null,
			filters: null,
			page : 'Ordini Donating',
			
			componente: 'Ordini',
			macro: 'Ordini Donating',
			dettaglioFunzione: 'Visualizzazione Notifiche e Riscontro Codice Sessione Donating'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/donating/dettaglioOrdineDonating.html',
				controller : 'dettaglioOrdineDonating'
			}
		}
	})
	.state('root.ordini.operespeciali', {
		url : '/ordini-opere-speciali',
		data : {
			pageTitle : 'Lista ordini con Opere Speciali | NOW'
		},
		params : {
			page : 'Ordini con Opere Speciali',
			parametriRicerca : "",
			tipologia: 'Lista Ordini Opere Speciali',
			init : false,
			
			componente: 'Ordini',
			macro: 'Ordini con Opere Speciali'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/operespeciali/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/operespeciali/operespeciali.html',
				controller : 'listaOrdiniOpereSpeciali'
			}
		}
	})
	.state('root.ordini.operespeciali.dettaglio', {
		url : '/:reqType/:orderNumber',
		data : {
			pageTitle : 'Dettaglio ordine | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Ordini con Opere Speciali',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			tipologia : 'Lista Ordini Opere Speciali',
			
			componente: 'Ordini',
			macro: 'Ordini con Opere Speciali',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine' 
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/dettaglioOrdine.html',
				controller : 'dettaglioOrdine'
			}
		}
	})
	.state('root.anagrafica.cliente', {
		url : '/cliente',
		data : {
			pageTitle : 'Anagrafica cliente | NOW'
		},
		params : {
			page : 'Cliente',
			parametriRicerca : "",
			pageClass: 'clienti',
			tipologia:'Clienti',
			
			componente: 'Anagrafiche',
			macro: 'Cliente'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/anagrafica/cliente.html',
				controller : 'cliente'
			}
		}
	})
	.state('root.anagrafica.cliente.dettaglio', {
		data : {
			pageTitle : 'Dettaglio cliente | NOW'
		},
		params : {
			notify : false,
			cliente : "",
			clientiFiltered : "",
			parametriRicerca : "",
			page : 'Cliente',
			pageClass: 'clienteDettaglio',
			tipologia:'Clienti',
			
			componente: 'Anagrafiche',
			macro: 'Cliente'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/anagrafica/dettaglio/clienteDettaglio.html',
				controller : 'clienteDettaglio'
			}
		}
	})
	.state('root.anagrafica.contatto', {
		url : '/contatto',
		data : {
			pageTitle : 'Anagrafica contatto | NOW'
		},
		params : {
			page : 'Contatto',
			parametriRicerca : "",
			pageClass: 'contatti',
			tipologia : 'Contatti',
			
			componente: 'Anagrafiche',
			macro: 'Contatto'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/bannerContatto.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/contatto.html',
				controller : 'contatto'
			}
		}
	})
	.state('root.anagrafica.contatto.dettaglio', {
		data : {
			pageTitle : 'Dettaglio contatto | NOW'
		},
		params : {
			notify : false,
			contatto : "",
			page : 'Contatto',
			parametriRicerca : "",
			pageClass: 'contattoDettaglio',
			tipologia : 'Contatti',
			
			componente: 'Anagrafiche',
			macro: 'Contatto'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/anagrafica/dettaglio/contattoDettaglio.html',
				controller : 'contattoDettaglio'
			}
		}
	})
	.state('root.anagrafica.contratto', {
		url : '/contratto',
		data : {
			pageTitle : 'Anagrafica contratto | NOW'
		},
		params : {
			page : 'Contratto',
			parametriRicerca : "",
			pageClass: 'contratti',
			tipologia : 'Contratti',
			
			componente: 'Anagrafiche',
			macro: 'Contratto'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/bannerContratto.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/contratto.html',
				controller : 'contratto'
			}
		}
	})
	
	.state('root.anagrafica.contratto.nuovoContratto', {
		url : '/nuovoContratto',
		data : {
			pageTitle : 'Nuovo contratto | NOW'
		},
		params : {
			page: "Contratto",
			pageClass: 'nuovo-contratto',
			
			componente: 'Anagrafiche',
			macro: 'Contratto'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/contratto/new/nuovoContratto.html',
				controller : 'nuovoContrattoNew'
			}
		}
	})
	
	
	
	.state('root.anagrafica.contratto.modificaContratto', {
		url : '/modificaContratto/:idContratto',
		data : {
			pageTitle : 'Nuovo contratto | NOW'
		},
		params : {
			page: "Contratto",
			pageClass: 'nuovo-contratto',
			
			componente: 'Anagrafiche',
			macro: 'Contratto'				
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/contratto/edit/modificaContratto.html',
				controller : 'modificaContrattoNew'
			}
		}
	})
	
	.state('root.anagrafica.contratto.dettaglio', {
		data : {
			pageTitle : 'Dettaglio contratto | NOW'
		},
		params : {
			notify : false,
			contratto : "",
			page : 'Contratto',
			parametriRicerca : "",
			pageClass: 'contrattoDettaglio',
			tipologia : 'Contratti',
			
			componente: 'Anagrafiche',
			macro: 'Contratto'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/anagrafica/dettaglio/contrattoDettaglio.html',
				controller : 'contrattoDettaglio'
			}
		}
	})
	.state('root.anagrafica.idullco', {
		url : '/idullco',
		data : {
			pageTitle : 'Anagrafica IDULLCO | NOW'
		},
		params : {
			page : 'Anagrafica IDULLCO',
			parametriRicerca : "",
			pageClass: 'idullco',
			tipologia : 'Idullco',
			
			componente: 'Anagrafiche',
			macro: 'IDULLCO'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/bannerIdullco.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/idullco.html',
				controller : 'listaIdullco'
			}
		}
	})
	.state('root.anagrafica.idsluco', {
		url : '/idsluco',
		data : {
			pageTitle : 'Anagrafica IDSLUCO | NOW'
		},
		params : {
			page : 'Anagrafica IDSLUCO',
			parametriRicerca : "",
			pageClass: 'idsluco',
			tipologia : 'Idsluco',
			
			componente: 'Anagrafiche',
			macro: 'IDSLUCO'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/bannerIdsluco.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/idsluco.html',
				controller : 'listaIdsluco'
			}
		}
	})
	// RU_1583
	.state('root.anagrafica.radius', {
		url : '/radius',
		data : {
			pageTitle : 'Anagrafica radius | NOW'
		},
		params : {
			page : 'Radius',
			parametriRicerca : "",
			pageClass: 'radius',
			tipologia : 'Radius',
			
			componente: 'Anagrafiche',
			macro: 'Radius'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/radius/bannerRadius.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/radius/radius.html',
				controller : 'radius'
			}
		}
	})
	
	//R1I_20_0131
	.state('root.anagrafica.disaggregazione', {
		url : '/disaggregazione',
		abstract: true,
	})	
	.state('root.anagrafica.disaggregazione.ull', {
		url : '/ull',
		data : {
			pageTitle : 'Anagrafica Disaggregazione | NOW'
		},
		params : {
			page : 'Disaggregazione',
			parametriRicerca : "",
			pageClass: 'disaggregazione',
			tipologia : 'Disaggregazione',
			sezione:'ULL',
			sezioneName:'ULL/SLU',
			
			componente: 'Anagrafiche',
			macro: 'Disaggregazione'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/bannerDisaggregazione.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/disaggregazione.html',
				controller : 'listaDisaggregazione'
			}
		}
	})
	.state('root.anagrafica.disaggregazione.vula', {
		url : '/vula',
		data : {
			pageTitle : 'Anagrafica Disaggregazione | NOW'
		},
		params : {
			page : 'Disaggregazione',
			parametriRicerca : "",
			pageClass: 'disaggregazione',
			tipologia : 'Disaggregazione',
			sezione:'VULA',
			sezioneName:'VULA',
			
			componente: 'Anagrafiche',
			macro: 'Disaggregazione'
				
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/bannerDisaggregazione.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/disaggregazione.html',
				controller : 'listaDisaggregazione'
			}
		}
	})
	
	//RU_963
	.state('root.anagrafica.marcaggioComuni', {
		url : '/marcaggioComuni',
		data : {
			pageTitle : 'Marcaggio Comuni | NOW'
		},
		params : {
			page : 'Marcaggio Comuni',
			pageClass: 'Marcaggio Comuni',
			tipologia:'Anagrafica Marcaggio Comuni',
			
			componente: 'Anagrafiche',
			macro: 'Marcaggio Comuni'
		},
		views : { 
			'banner@' : {
				templateUrl : 'app/anagrafica/marcaggioComuni/pricing/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/marcaggioComuni/pricing/listaPricing.html',
				controller : 'listaMarcaggioComuniPricing'
			}
		}
	})
	
	//RU_1078
	.state('root.anagrafica.comuniInfratel', {
		url : '/comuniInfratel',
		data : {
			pageTitle : 'OLO Comune Infratel | NOW'
		},
		params : {
			page : 'OLO Comune Infratel',
			tipologia:'OLO Comune Infratel',
			
			componente: 'Anagrafiche',
			macro: 'OLO Comune Infratel'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/amministrazione/comuniInfratel/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/amministrazione/comuniInfratel/listaComuniInfratel.html',
				controller : 'listaComuniInfratel'
			}
		}
	})	
	
	//RU_1308
	.state('root.anagrafica.idGpon', {
		url : '/gpon',
		data : {
			pageTitle : 'Anagrafica IDGPON | NOW'
		},
		params : {
			page : 'Anagrafica IDGPON',
			tipologia:'Anagrafica IDGPON',
			
			componente: 'Anagrafiche',
			macro: 'Anagrafica IDGPON'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/gpon/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/gpon/listaGpon.html',
				controller : 'listaGpon'
			}
		}
	})
	//RU_1335
	.state('root.anagrafica.fwaWillDeco', {
		url : '/fwaWillDeco',
		data : {
			pageTitle : 'Risorse FWA WILL Deco| NOW'
		},
		params : {
			page : 'Risorse FWA WILL Deco',
			tipologia:'Risorse FWA WILL Deco',
			
			componente: 'Anagrafiche',
			macro: 'Risorse FWA WILL Deco'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/fwaWillDeco/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/fwaWillDeco/listaFwaWillDeco.html',
				controller : 'listaFwaWillDeco'
			}
		}
	})
	.state('root.anagrafica.fwaWillDeco.dettaglio', {
		url : '/details/:idRisorsa',
		data : {
			pageTitle : 'Risorse FWA WILL Deco| NOW'
		},
		params : {
			page : 'Risorse FWA WILL Deco',
			tipologia:'Risorse FWA WILL Deco',
			
			componente: 'Anagrafiche',
			macro: 'Risorse FWA WILL Deco'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/fwaWillDeco/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/fwaWillDeco/dettaglio/dettaglioFwaWillDeco.html',
				controller : 'dettaglioFwaWillDeco'
			}
		}
	})
	.state('root.anagrafica.fwaWillDeco.edit', {
		url : '/edit/:idRisorsa',
		data : {
			pageTitle : 'Risorse FWA WILL Deco| NOW'
		},
		params : {
			page : 'Risorse FWA WILL Deco',
			tipologia:'Risorse FWA WILL Deco',
			
			componente: 'Anagrafiche',
			macro: 'Risorse FWA WILL Deco'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/fwaWillDeco/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/fwaWillDeco/edit/modificaFwaWillDeco.html',
				controller : 'modificaFwaWillDeco'
			}
		}
	})
	.state('root.anagrafica.fwaWillDeco.new', {
		url : '/new',
		data : {
			pageTitle : 'Risorse FWA WILL Deco| NOW'
		},
		params : {
			page : 'Risorse FWA WILL Deco',
			tipologia:'Risorse FWA WILL Deco',
			
			componente: 'Anagrafiche',
			macro: 'Risorse FWA WILL Deco'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/fwaWillDeco/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/fwaWillDeco/new/nuovoFwaWillDeco.html',
				controller : 'nuovoFwaWillDeco'
			}
		}
	})
	
	//RU_1393
	//RU_1432
	.state('root.anagrafica.gestioneAutonoma', {
		url : '/gestioneAutonoma',
		abstract: true,
	})	
	.state('root.anagrafica.gestioneAutonoma.associazioneOaoImpresaArea', {
		url : '/associazioneOaoImpresaArea',
		data : {
			pageTitle : 'Gestione Autonoma | NOW'
		},
		params : {
			page : 'Gestione Autonoma',
			parametriRicerca : "",
			pageClass: 'gestioneAutonoma',
			tipologia : 'Gestione Autonoma',
			sezione:'Associazione Oao-Impresa-Area',
			sezioneName:'Associazione Oao-Impresa-Area',
			
			componente: 'Anagrafiche',
			macro: 'Gestione Autonoma'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/gestioneAutonoma/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/gestioneAutonoma/associazioneOao/associazioneOao.html',
				controller : 'associazioneOao'
			}
		}
	})
	//RU_1479
	.state('root.anagrafica.fwaEolo', {
		url : '/fwaEolo',
		data : {
			pageTitle : 'Anagrafica VLAN FWA ITALIA 1GIGA SARDEGNA | NOW'
		},
		params : {
			page : 'Anagrafica VLAN FWA ITALIA 1GIGA SARDEGNA',
			tipologia:'Anagrafica VLAN FWA ITALIA 1GIGA SARDEGNA',
			
			componente: 'Anagrafiche',
			macro: 'Anagrafica VLAN FWA ITALIA 1GIGA SARDEGNA'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/eolo/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/eolo/listaFwaEolo.html',
				controller : 'listaFwaEolo'
			}
		}
	})
	//RU_1485
	.state('root.anagrafica.codiciProgettoCatalogo', {
		url : '/codiciProgettoCatalogo',
		data : {
			pageTitle : 'Anagrafica Codici Progetto a Catalogo | NOW'
		},
		params : {
			page : 'Anagrafica Codici Progetto a Catalogo',
			parametriRicerca : "",
			pageClass: 'Anagrafica Codici Progetto a Catalogo',
			tipologia : 'Codici Progetto',
			
			componente: 'Anagrafiche',
			macro: 'Anagrafica Codici Progetto a Catalogo'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/anagrafica/codiciProgettoCatalogo/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/anagrafica/codiciProgettoCatalogo/listaCodiciProgettoCatalogo.html',
				controller : 'listaCodiciProgettoCatalogo'
			}
		}
	})
	
	.state('root.consistenze.asset', {
		abstract : true,
		params : {
			page : 'Lista Asset'
		},
		views : {}
	})
		//to do (ricariche)
	.state('root.consistenze.listaricariche', {
		url : '/asset/listaricariche',
		data : {
			pageTitle : 'Lista Ricariche | NOW'
		},
        params : {
            page : 'Lista Ricariche',
            pageClass: 'Asset',
            tipologia : 'Ricariche',
            ricaricaType: '',
			getValue: '',
            getOption: '',
            
			componente: 'Asset',
			macro: 'Lista Ricariche'
        },
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/lista_ricariche/listaRicariche.html',
				controller : 'listaRicariche'
			}
		}
	})
	.state('root.consistenze.listaricariche.richiestaRicarica', {
		data : {
			pageTitle : 'Richiesta Ricarica | NOW'
		},
		params : {
			page : 'Lista Ricariche',
			pageClass: 'Asset',
            ricaricaType: '',
            getValue: '',
            getOption: ''
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/richiesta_ricariche/richiestaRicariche.html',
				controller : 'richiestaRicariche'
			}
		}
	})
	.state('root.consistenze.listarichiestericarica', {
		url : '/asset/listarichiestericarica',
		data : {
			pageTitle : 'Lista Ricariche | NOW'
		},
        params : {
            page : 'Lista Ricariche',
            pageClass: 'Asset',
            tipologia : 'Lista Richieste Ricarica',
            ricaricaType: '',
            getValue: '',
            getOption: '',
            
			componente: 'Asset',
			macro: 'Lista Richieste Ricariche'
        },
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/lista_ricariche/listaRichiesteRicariche.html',
				controller : 'listaRichiesteRicariche'
			}
		}
	})

	//SM_10344
	.state('root.consistenze.asset.listaAccesso', {
		url : '/asset/listaAccesso',
		data : {
			pageTitle : 'Lista asset accesso | NOW'
		},
		params : {
			page : 'Lista Asset Accesso',
			pageClass: 'Asset Accesso',
			tipologia : 'Asset Accesso',
			
			componente: 'Asset Accesso',
			macro: 'Lista Asset Accesso',
			init: false
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/listaAsset.html',
				controller : 'listaAsset'
			}
		}
	})	
	
	//RU_1188
	.state('root.consistenze.asset.listaRaccolta', {
		url : '/asset/listaRaccolta',
		data : {
			pageTitle : 'Lista asset raccolta | NOW'
		},
		params : {
			page : 'Lista Asset Raccolta',
			pageClass: 'Asset Raccolta',
			tipologia : 'Asset Raccolta',
			
			componente: 'Asset Raccolta',
			macro: 'Lista Asset Raccolta',
			init: false
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/lista_asset_raccolta/listaAssetRaccolta.html',
				controller : 'listaAssetRaccolta'
			}
		}
	})
	
	.state('root.consistenze.asset.listaRaccolta.dettaglio', {
		data : {
			pageTitle : 'Dettaglio Lista Asset Raccolta | NOW'
		},
		params : {
			notify : false,
			idAsset : "",
			page : 'Lista Asset Raccolta',
			pageClass: 'Asset Raccolta',
			tipologia : 'Asset Raccolta',
			
			componente: 'Asset Raccolta',
			macro: 'Lista Asset Raccolta',
			dettaglioFunzione: 'Visualizzazione Dettaglio Asset Raccolta'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/consistenze/dettaglio_asset_raccolta/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/consistenze/dettaglio_asset_raccolta/dettaglioAssetRaccolta.html',
				controller : 'dettaglioAssetRaccolta'
			}
		}
	})
	
	.state('root.consistenze.asset.listaAccesso.dettaglio', {
		url: '/:id',
		data : {
			pageTitle : 'Dettaglio Lista Asset | NOW'
		},
		params : {
			notify : false,
			asset : "",
			page : 'Lista Asset',
			pageClass: 'Asset',
			tipologia : 'Asset',
			
			componente: 'Asset',
			macro: 'Lista Asset',
			dettaglioFunzione: 'Visualizzazione Dettaglio Asset'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/consistenze/dettaglio/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/consistenze/dettaglio/dettaglioAsset.html',
				controller : 'dettaglioAsset'
			}
		}
	})
	.state('root.consistenze.asset.cessazione', {
		url : '/asset/:id/cessazione',
		data : {
			pageTitle : 'Cessazione asset - step 1 | NOW'
		},
		params : {
			page : 'Lista Asset',
			pageClass: 'asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Step 1'
				
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/step1.html',
				controller : 'cessazioneAsset'
			}
		},
		
		//SM_9063
		onEnter: ['ResetDataService', function(ResetDataService){
			ResetDataService.reset(/^root.consistenze.asset.cessazione*[.A-Za-z0-1]{0,}/);
		}]
	})
	.state('root.consistenze.asset.cessazione.step2', {
		data : {
			pageTitle : 'Cessazione asset - Step 2 | NOW'
		},
		params : {
			page : 'Lista Asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Step 2'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/step2.html',
				controller : 'cessazioneAsset'
			}
		}
	})
	.state('root.consistenze.asset.cessazione.step3', {
		data : {
			pageTitle : 'Cessazione asset - Step 3 | NOW'
		},
		params : {
			page : 'Lista Asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Step 3'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/dati-riferimenti.html',
				controller : 'cessazioneAsset'
			}
		}
	})
	.state('root.consistenze.asset.cessazione.riepilogo', {
		data : {
			pageTitle : 'Cessazione asset - Riepilogo | NOW'
		},
		params : {
			page : 'Lista Asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Riepilogo'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/riepilogo.html',
				controller : 'cessazioneAsset'
			}
		}
	})
	.state('root.consistenze.asset.cessazione.conferma', {
		url : '/riepilogo',
		data : {
			pageTitle : 'Cessazione asset - conferma | NOW'
		},
		params : {
			page : 'Lista Asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Conferma'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/conferma.html',
				controller : 'cessazioneAsset'
			}
		},
		
		//SM_9063
		onExit: ['ResetDataService', function(ResetDataService){			
			ResetDataService.reset(/^root.consistenze.asset.cessazione*[.A-Za-z0-1]{0,}/);
		}]
	})
	.state('root.notifiche.file', {
		url : '/file-notifiche',
		data : {
			pageTitle : 'File di notifiche | NOW'
		},
		params : {
			page : 'File di Notifiche',
			pageClass: 'file_notifiche',
			tipologia:'File di Notifiche',
			
            
			componente: 'File e Notifiche',
			macro: 'File di Notifiche'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/fileNotifiche.html',
				controller : 'fileNotifiche'
			}
		}
	})
	.state('root.notifiche.stato', {
		url : '/file-stato',
		data : {
			pageTitle : 'Stato file | NOW'
		},
		params : {
			page : 'Stato File Ordini e Richieste',
			pageClass: 'stato_file',
			tipologia:'File',
			
			componente: 'File e Notifiche',
			macro: 'Stato File Ordini e Richieste'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/bannerStatoFile.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/statoFile.html',
				controller : 'statoFile'
			}
		}
	})
	.state('root.notifiche.upload', {
		url : '/file-upload',
		data : {
			pageTitle : 'Upload file | NOW'
		},
		params : {
			page : 'Upload File Ordini e Richieste',
			pageClass: 'upload_file',
			
			componente: 'File e Notifiche',
			macro: 'Upload File Ordini e Richieste'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/bannerUploadFile.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/uploadFile.html',
				controller : 'uploadFile'
			}
		}
	})
	//RU_1127
	.state('root.notifiche.decommissioningupload', {
		url : '/file-decommissioning-upload',
		data : {
			pageTitle : 'Upload File Decommissioning | NOW'
		},
		params : {
			page : 'Upload File Decommissioning',
			pageClass: 'file_decommissioning',
			tipologia:'Upload File Decommissioning',
			
            
			componente: 'Upload File Decommissioning',
			macro: 'Upload File Decommissioning'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/bannerUploadFile.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/uploadFileDecommissioning.html',
				controller : 'uploadFileDecommissioning'
			}
		}
	})
	//RU_1127
	.state('root.notifiche.decommissioningdownload', {
		url : '/file-decommissioning-download',
		data : {
			pageTitle : 'Download File Decommissioning | NOW'
		},
		params : {
			page : 'Download File Decommissioning',
			pageClass: 'file_decommissioning',
			tipologia:'Download File Decommissioning',
			
            
			componente: 'Download File Decommissioning',
			macro: 'Download File Decommissioning'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/bannerFileDecommissioning.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/fileDecommissioning.html',
				controller : 'fileDecommissioning'
			}
		}
	})
	//SM_10805
	.state('root.notifiche.switchoffupload', {
		url : '/allegati-decommissioning-upload',
		data : {
			pageTitle : 'Upload File Switchoff | NOW'
		},
		params : {
			page : 'Upload File Switchoff',
			pageClass: 'file_switchoff',
			tipologia:'Upload File Switchoff',
			
            
			componente: 'Upload File Switchoff',
			macro: 'Upload File Switchoff'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/bannerUploadFile.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/uploadFileSwitchoff.html',
				controller : 'uploadFileSwitchoff'
			}
		}
	})
	//RU_1180
	.state('root.notifiche.multicast', {
		url : '/multicast',
		abstract: true
	})
	.state('root.notifiche.multicast.visualizzaFile', {
		url : '/visualizza-file',
		data : {
			pageTitle : 'Visualizza File Multicast | NOW'
		},
		params : {
			page : 'Gestione File Multicast',
			pageClass: 'file_multicast',
			tipologia:'File Multicast',
			
            
			componente: 'Gestione File Multicast',
			macro: 'Gestione File Multicast'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/multicast/bannerFileMulticast.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/multicast/fileMulticast.html',
				controller : 'fileMulticast'
			}
		}
	})
	.state('root.notifiche.multicast.uploadFile', {
		url : '/upload-file',
		data : {
			pageTitle : 'Upload File Multicast | NOW'
		},
		resolve:{
			_verificaContrattoMulticast: function($rootScope, modalService, Multicast, $state){
				
				//SM_10124
				var _codOloAgcom = $rootScope.timnowConfigData.user.codificaOloAgcom;
				
				//SM_10214
				//SM_11045
				if($rootScope.isAllOLOUser()){
					return Multicast.verificaContrattoMulticast.get({codOloAgcom: _codOloAgcom}).$promise;	
				}else{
					return null;
				}
			},			
			_codOloAgcom: function($rootScope, $timeout, $q){
				
				var deferred = $q.defer();				
				$timeout(function(){
					deferred.resolve($rootScope.timnowConfigData.user.codificaOloAgcom);
				}, 10);
				
				return deferred.promise;
			}
		}, 
		params : {
			page : 'Gestione File Multicast',
			pageClass: 'file_multicast',
			tipologia:'Gestione File Multicast',
			
            
			componente: 'Gestione File Multicast',
			macro: 'Gestione File Multicast'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/multicast/bannerFileMulticast.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/multicast/uploadFileMulticast.html',
				controller : 'uploadFileMulticast'
			}
		}
	})
	.state('root.notifiche.migrazioneUllSlu', {
		url : '/migrazione-ull-slu',
		abstract : true
	})
	.state('root.notifiche.migrazioneUllSlu.uploadFile', {
		url : '/upload-file',
		data : {
			pageTitle : 'Upload file migrazione ULL/SLU | NOW'
		},
		params : {
			page : 'Gestione file migrazione ULL/SLU',
			pageClass : 'migrazione_ull_slu',
			tipologia : 'Gestione file migrazione ULL/SLU',
			componente : 'Gestione file migrazione ULL/SLU',
			macro : 'Gestione file migrazione ULL/SLU'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/migrazione_ull_slu/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/migrazione_ull_slu/uploadFile.html',
				controller : 'uploadFileMigrazioneUllSlu'
			}
		}
	})
	.state('root.notifiche.migrazioneUllSlu.monitoraggio', {
		url : '/monitoraggio/:idFile?nomeFile',
		data : {
			pageTitle : 'Monitoraggio upload migrazione ULL/SLU | NOW'
		},
		params : {
			page : 'Gestione file migrazione ULL/SLU',
			pageClass : 'migrazione_ull_slu',
			tipologia : 'Gestione file migrazione ULL/SLU',
			componente : 'Gestione file migrazione ULL/SLU',
			macro : 'Gestione file migrazione ULL/SLU',
			nomeFile : null
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/migrazione_ull_slu/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/migrazione_ull_slu/monitoraggio.html',
				controller : 'monitoraggioMigrazioneUllSlu'
			}
		}
	})
	.state('root.notifiche.migrazioneUllSlu.listaFile', {
		url : '/lista-file',
		data : {
			pageTitle : 'Monitoraggio upload migrazione ULL/SLU | NOW'
		},
		params : {
			page : 'Gestione file migrazione ULL/SLU',
			pageClass : 'migrazione_ull_slu',
			tipologia : 'Gestione file migrazione ULL/SLU',
			componente : 'Gestione file migrazione ULL/SLU',
			macro : 'Gestione file migrazione ULL/SLU'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/migrazione_ull_slu/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/migrazione_ull_slu/listaFile.html',
				controller : 'listaFileMigrazioneUllSlu'
			}
		}
	})
	//RU_1301
	.state('root.notifiche.comunicoinvestimento', {
		url : '/file-comuni-coinvestimento',
		data : {
			pageTitle : 'Gestione File Comuni Coinvestimento | NOW'
		},
		params : {
			page : 'Gestione File Comuni Coinvestimento',
			pageClass: 'file_comuni_coinvestimento',
			tipologia:'File Comuni',
			
            
			componente: 'Gestione File Comuni Coinvestimento',
			macro: 'Gestione File Comuni Coinvestimento'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/comuni_coinvestimento/bannerFileComuniCoinvestimento.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/comuni_coinvestimento/listaFileComuniCoinvestimento.html',
				controller : 'listaFileComuniCoinvestimento'
			}
		}
	})
	
	//RU_1335
	.state('root.notifiche.fwaDecommissioning', {
		url : '/fwaDecommissioning',
		abstract: true
	})
	.state('root.notifiche.fwaDecommissioning.visualizzaFile', {
		url : '/visualizza-file',
		data : {
			pageTitle : 'Visualizza File Risorse FWA Decommissioning | NOW'
		},
		params : {
			page : 'Gestione File Risorse FWA Decommissioning',
			pageClass: 'fwa_decommissioning',
			tipologia:'File Risorse FWA Decommissioning',			
            
			componente: 'Gestione File Risorse FWA Decommissioning',
			macro: 'Gestione File Risorse FWA Decommissioning'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/fwa_decommissioning/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/fwa_decommissioning/fileFwaDecommissioning.html',
				controller : 'fileFwaDecommissioning'
			}
		}
	})
	.state('root.notifiche.fwaDecommissioning.uploadFile', {
		url : '/upload-file',
		data : {
			pageTitle : 'Upload File Risorse FWA Decommissioning | NOW'
		},		
		params : {
			page : 'Gestione File Risorse FWA Decommissioning',
			pageClass: 'fwa_decommissioning',
			tipologia:'Gestione File Risorse FWA Decommissioning',
			
            
			componente: 'Gestione File Risorse FWA Decommissioning',
			macro: 'Gestione File Risorse FWA Decommissioning'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/file_notifiche/fwa_decommissioning/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/file_notifiche/fwa_decommissioning/uploadFileFwaDecommissioning.html',
				controller : 'uploadFileFwaDecommissioning'
			}
		}
	})
	
	
	
	
	.state('root.catalog', {
		url : '/catalog',
		data : {
			pageTitle : 'Catalogo | NOW'
		},
		params : {
			settore : 'Catalogo',
			page : 'Catalogo'
		},
		views : {
			'banner@' : {},
			'innercontent@' : {
				templateUrl : 'app/catalog/content.html',
				controller : 'catalog'
			}
		}
	})
	.state('root.trackingapp', {
		url : '/trackingapp',
		data : {
			pageTitle : 'Tracking Applicativo | NOW'
		},
		params : {
			//non configurato
			settore : 'Tracking Applicativo',
			page : 'Tracking Applicativo'
		},
		views : {
			'banner@' : {},
			'innercontent@' : {
				templateUrl : 'app/trackingApp/content.html',
				controller : 'trackingApp'
			}
		}
	})
	.state('root.ihelp', {
		url : '/ihelp/:idAmbito',
		data : {
			pageTitle : 'iHelp | NOW'
		},
		params : {
			settore : 'allUser',
			ihelps : "",
			pageClass: 'ihelp',
			
			componente: 'Home Page',
			macro: 'iHelp'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ihelp/content.html',
				controller : 'ihelp'
			},
			'banner@' : {
				templateUrl : 'app/ihelp/banner.html'
			}
		}
	})
	.state('root.ihelp.dettaglio', {
		url : '/?idhelp=:idIHelp',
		data : {
			pageTitle : 'iHelp | NOW'
		},
		params : {
			componente: 'Home Page',
			macro: 'iHelp'			
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ihelp/dettaglio.html',
				controller : 'ihelp'
			}
		}
	})
	.state('root.faq', {
		url : '/faq',
		data : {
			pageTitle : 'FAQ | NOW'
		},
		params : {
			settore : 'allUser',
			faqs : "",
			pageClass: 'faq',
				
			componente: 'Home Page',
			macro: 'FAQ'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/faq/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/faq/content.html',
				controller : 'faq'
			}
		}
	})
	.state('root.faq.dettaglio', {
		url : '/?idfaq=:idFaq',
		data : {
			pageTitle : 'FAQ | NOW'
		},
		params : {
			settore : 'allUser',
			
			componente: 'Home Page',
			macro: 'FAQ'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/faq/dettaglio.html',
				controller : 'faq'
			},
			'banner@' : {
				templateUrl : 'app/faq/banner.html'
			}
		}
	})
	.state('root.news', {
		url : '/news',
		data : {
			pageTitle : 'News | NOW'
		},
		params : {
			settore : 'allUser',
			news : "",
			pageClass: 'news',
			
			componente: 'Home Page',
			macro: 'News'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/news/content.html',
				controller : 'allNews'
			},
			'banner@' : {
				templateUrl : 'app/news/banner.html'
			}
		}
	})
	.state('root.news.dettaglio', {
		url : '/?idNews=:idnews',
		data : {
			pageTitle : 'News | NOW'
		},
		params : {
			settore : 'allUser',
			
			componente: 'Home Page',
			macro: 'News'	
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/news/dettaglio.html',
				controller : 'allNews'
			},
			'banner@' : {
				templateUrl : 'app/news/banner.html'
			}
		}
	})
	
	/* R1F-21-0411 */
	.state('root.ordini.creazionereport', {
		url : '/creazioneReport',
		data : {
			pageTitle : 'Gestione Ricerca Dati Hash | NOW'
		},
		params : {
			settore : 'allUser',
			
			componente: 'Home Page',
			macro: 'Ordini'	
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/reportDatiHash/creazioneReport.html',
				controller : 'creazioneReportController'
			},
			'banner@' : {
				templateUrl : 'app/ordini/reportDatiHash/banner.html'
			}
		}
	})	
	.state('root.ordini.listareport', {
		url : '/listaReport',
		data : {
			pageTitle : 'Gestione Ricerca Dati Hash | NOW'
		},
		params : {
			settore : 'allUser',
			
			componente: 'Home Page',
			macro: 'Ordini'	
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/reportDatiHash/listaReport.html',
				controller : 'listaReportController'
			},
			'banner@' : {
				templateUrl : 'app/ordini/reportDatiHash/banner.html'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio', {
		url : '/dettaglio/:idReport/:tipoLista',
		data : {
			pageTitle : 'Gestione Ricerca Dati Hash | NOW'
		},
		params : {
			settore : 'allUser',
			
			componente: 'Home Page',
			macro: 'Ordini'	
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/reportDatiHash/dettaglioListaReport.html',
				controller : 'dettaglioListaReportController'
			},
			'banner@' : {
				templateUrl : 'app/ordini/reportDatiHash/banner.html'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.ordine', {
		url : '/ordine/:reqType/:orderNumber',
		data : {
			pageTitle : 'Dettaglio ordine | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Lista Ordini',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			tipologia : 'Lista Ordini',
			
			componente: 'Ordini',
			macro: 'Lista Ordini',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/dettaglioOrdine.html',
				controller : 'dettaglioOrdine'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.ordine.tracciamento', {
		url : '/tracciamento-stato',
		data : {
			pageTitle : 'Tracciamento e Stato | NOW'
		},
		params : {
			notify : false,
			order : "",
			page : 'Lista Ordini',
			parametriRicerca : "",
			codiceOrdineOlo:"",
			idRichiestaOlo:"",
			inizioTracciamento:"",
			fineTracciamento:"",
			tipologia : 'Lista Ordini'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/dettaglio/tracciamentoestato/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/dettaglio/tracciamentoestato/content.html',
				controller : 'tracciamenoeStato'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.ordine.richiesta', {
		url : '/richiesta',
		data : {
			pageTitle : 'Nuova richiesta per ordine | NOW'
		},
		params : {
			order : "",
			page : 'Nuova Richiesta',
			
			componente: 'Ordini',
			macro: 'Lista Ordini',
			dettaglioFunzione: 'Visualizzazione Dettaglio Ordine'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/ordini/richiesta/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/ordini/richiesta/richiesta.html',
				controller : 'richiestaOrdine'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.donating', {
		url : '/donating',
		data : {
			pageTitle : 'Dettaglio ordine | NOW'
		},
		params : {
			order: null,
			filters: null,
			page : 'Ordini Donating',
			
			componente: 'Ordini',
			macro: 'Ordini Donating',
			dettaglioFunzione: 'Visualizzazione Notifiche e Riscontro Codice Sessione Donating'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/donating/dettaglioOrdineDonating.html',
				controller : 'dettaglioOrdineDonating'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.asset', {
		url:'/asset/:id',
		data : {
			pageTitle : 'Dettaglio Lista Asset | NOW'
		},
		params : {
			notify : false,
			asset : "",
			page : 'Lista Asset',
			pageClass: 'Asset',
			tipologia : 'Asset',
			
			componente: 'Asset',
			macro: 'Lista Asset',
			dettaglioFunzione: 'Visualizzazione Dettaglio Asset'
		},
		views : {
			'banner@' : {
				templateUrl : 'app/consistenze/dettaglio/banner.html'
			},
			'innercontent@' : {
				templateUrl : 'app/consistenze/dettaglio/dettaglioAsset.html',
				controller : 'dettaglioAsset'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.cessazione', {
		url : '/cessazione',
		data : {
			pageTitle : 'Cessazione asset - step 1 | NOW'
		},
		params : {
			page : 'Lista Asset',
			pageClass: 'asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Step 1'
				
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/step1.html',
				controller : 'cessazioneAsset'
			}
		},
		
		//SM_9063
		onEnter: ['ResetDataService', function(ResetDataService){
			ResetDataService.reset(/^root.ordini.listareport.dettaglio.asset*[.A-Za-z0-1]{0,}/);
		}]
	})
	.state('root.ordini.listareport.dettaglio.asset.cessazione.step2', {
		data : {
			pageTitle : 'Cessazione asset - Step 2 | NOW'
		},
		params : {
			page : 'Lista Asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Step 2'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/step2.html',
				controller : 'cessazioneAsset'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.cessazione.step3', {
		data : {
			pageTitle : 'Cessazione asset - Step 3 | NOW'
		},
		params : {
			page : 'Lista Asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Step 3'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/dati-riferimenti.html',
				controller : 'cessazioneAsset'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.cessazione.riepilogo', {
		data : {
			pageTitle : 'Cessazione asset - Riepilogo | NOW'
		},
		params : {
			page : 'Lista Asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Riepilogo'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/riepilogo.html',
				controller : 'cessazioneAsset'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.cessazione.conferma', {
		url : '/riepilogo',
		data : {
			pageTitle : 'Cessazione asset - conferma | NOW'
		},
		params : {
			page : 'Lista Asset',
			
			componente: 'Asset',
			macro: 'Cessazione',
			dettaglioFunzione: 'Conferma'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/consistenze/cessazione/conferma.html',
				controller : 'cessazioneAsset'
			}
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.new', {
		url : '/variazione',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				controller : 'newOrder'
			}
		},
		params : {
			page : 'Nuovo Ordine',
			init : false,
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
		},
		//SM_9063
		onEnter: ['ResetDataService', function(ResetDataService){
			ResetDataService.reset(/^root.ordini.listareport.dettaglio.asset.new*[.A-Za-z0-1]{0,}/);
		}]
	})
	.state('root.ordini.listareport.dettaglio.asset.new.step1', {
		url : '/step1',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step1/content.html',
				controller : 'newOrder'
			}
		},
		params : {
			returning : null,
			asset:"",
			init : false,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 1'
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.new.step2', {
		url : '/step2',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step2/dati-ordine.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 2,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 2'
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.new.step3', {
		url : '/step3',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step3/content.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 3,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 3'
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.new.attivazione-configurazione', {
		url : '/step4',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step4/configurazione-offerta.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 4,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 4'
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.new.step5', {
		url : '/step5',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step5/dati-riferimenti.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 5,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 5'
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.new.step6', {
		url : '/step6',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step6/dati-cliente.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 6,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 6'
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.new.step7', {
		url : '/step7',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step7/dettaglio-ordine.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 7,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 7'
		}
	})
	.state('root.ordini.listareport.dettaglio.asset.new.step8', {
		url : '/step8',
		data : {
			pageTitle : 'Nuovo ordine | NOW'
		},
		views : {
			'innercontent@' : {
				templateUrl : 'app/ordini/newOrder/step8/riepilogo-ordine.html',
				controller : 'newOrder'
			}
		},
		params : {
			operazione : 'attivazione',
			step : 8,
			page : 'Nuovo Ordine',
			
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Step 8'
		},
		
		//SM_9063
		onExit: ['ResetDataService', function(ResetDataService){
			ResetDataService.reset(/^root.ordini.listareport.dettaglio.asset.new*[.A-Za-z0-1]{0,}/);
		}]
	})

    .state('root.ordini.listareport.dettaglio.asset.new.attivazione-conferma', {
        url : '/conferma',
        data : {
            pageTitle : 'Nuovo ordine di Attivazione - Conferma ricezione | NOW'
        },
        views : {
            'innercontent@' : {
                templateUrl : 'app/ordini/newOrder/conferma.html',
                controller : 'newOrder'
            }
        },
        params : {
            operazione : 'attivazione',
            step : 'conferma',
            page : 'Nuovo Ordine',
            
			componente: 'Ordini',
			macro: 'Nuovo Ordine',
			dettaglioFunzione: 'Conferma'
        }
    })

// FINE SEZIONE MIGRATA NUOVO ORDINE NUOVO  
	
	
	/**httpProvider**/
	$httpProvider.interceptors.push([ '$injector', '$q', '$window', '$log', '$rootScope', function($injector, $q, $window, $log, $rootScope) {
		return {
			'request' : function(config) {
				// Imposta il timeout delle chiamate http in base alla configurazione.
				if(!(config.data && config.data.file)){
					var timnowConfig = $rootScope.timnowConfigData;
					if (timnowConfig && timnowConfig.config && timnowConfig.config.rest_timeout) {
						config.timeout = timnowConfig.config.rest_timeout;
					} else {
						config.timeout = 40000;
					}
				}
				
				return config;
			},
			'response' : function(response) {
				if (response.data != null && response.data.result != null) {
					var resultCode = response.data.result.code;
					var resultLimited = response.data.isLimitedList;
					if (resultCode != null && resultCode !== '0') {
						//injected manually to get around circular dependency problem.
						if (resultCode < 0) {
							$log.debug('resultCode < 0 :' + resultCode);
							return $q.reject(response);
						} else {
							$log.debug('resultCode > 0 :' + resultCode);
							return response || $q.when(response);
						}
					}
					if(resultLimited){
						var alertService = $injector.get('alertService');
						alertService.add("Gli elementi in lista superano il limite di visualizzazione consentito: raffina la ricerca.");
					}
				}
				return response || $q.when(response);
			},
			'responseError' : function(response) {
				switch (response.status) {
				case 401:
					$log.debug('requires authentication');
					return $q.reject(response);
				case 403:
					$log.debug('no rights to do this');
					return $q.reject(response);
				case 404:
					$log.debug('resource not present');
					return $q.reject(response);
				case 408:
					$log.debug('request timeout (HTTP 408): rejecting');
					return $q.reject(response);
				case 500:
					$log.debug('server internal error: ' + response.data);
					return $q.reject(response);
				case 501:
					$log.debug('Manutenzione programmata: ' + response.data);
					return $q.reject(response);
				case 503:
					$log.debug('service unavailable: ' + response.data);
					return $q.reject(response);
				case 504 :
					$log.debug('temporary redirect after session expired');
					$rootScope.$emit("sessionExpired");
					return $q.reject(response);
				case -1:
					$log.debug('file upload error: ' + response.data);
					return $q.reject(response);
				case 0:
					$log.debug('request timeout  (HTTP 0): rejecting');
					return $q.reject(response);
				default:
				}
				//non blocco il flusso
				return response || $q.when(response);
			}
		};
		
	} ]);
} ]);
commonModule
    /**
     * Factory condivisa per la gestione dei filtri previsti dalla FEA_32918.
     * Utilizza la configurazione OSCURAMENTI per rimuovere dalle customizzazioni
     * dei servizi gli attributi non applicabili all'offerta corrente.
     */
    .factory('OscuramentoFEA32918', ['OSCURAMENTI', function(OSCURAMENTI) {
        return {
            /**
             * Filtra le customizzazioni dei servizi in base all'offerta.
             * Le customizzazioni con attributi non presenti in listaCampi
             * vengono mantenute; per MERCATO e COPERTOFTTH viene invece
             * verificata la relativa lista di offerte valide. Se la funzione
             * di oscuramento e attiva, gli attributi configurati vengono rimossi.
             *
             * @param {Array} servizi elenco dei servizi da filtrare
             * @param {String|Number} idOfferta identificativo dell'offerta corrente
             * @param {String} nomeCustomizzazioni nome della proprieta che contiene
             *        le customizzazioni ('customizzazione' per gli asset,
             *        'customizations' per gli ordini)
             * @return {Array} elenco dei servizi filtrato, oppure il valore
             *         originale se servizi non e valorizzato
             */
            filtraServizi: function(servizi, idOfferta, nomeCustomizzazioni) {
                var fea32918 = OSCURAMENTI.FEA_32918;

                if (!servizi) {
                    return servizi;
                }

                return servizi.map(function(servizio) {
                    if (!servizio[nomeCustomizzazioni]) {
                        return servizio;
                    }

                    servizio[nomeCustomizzazioni] = servizio[nomeCustomizzazioni].filter(function(customization) {
                        if (fea32918.listaCampi.indexOf(customization.attribute) == -1) {
                            return true;
                        }

                        if (fea32918.oscurato) {
                            return false;
                        }

                        var idOfferteValide = customization.attribute == 'MERCATO'
                            ? fea32918.idOfferteValideMERCATO
                            : fea32918.idOfferteValideCOPERTOFTTH;
                        return idOfferteValide.indexOf(idOfferta) > -1;
                    });
                    return servizio;
                });
            },

            filtraServiziFEA36452: function(servizi, idOfferta, nomeCustomizzazioni) {
                var fea36452 = OSCURAMENTI.FEA_36452;

                if (!servizi) {
                    return servizi;
                }

                return servizi.map(function(servizio) {
                    if (!servizio[nomeCustomizzazioni]) {
                        return servizio;
                    }

                    servizio[nomeCustomizzazioni] = servizio[nomeCustomizzazioni].filter(function(customization) {
                        if (fea36452.listaCampi.indexOf(customization.attribute) == -1) {
                            return true;
                        }

                        return !fea36452.oscurato &&
                            fea36452.idOfferteValide.indexOf(String(idOfferta)) > -1;
                    });
                    return servizio;
                });
            },

            filtraServiziRU1614: function(servizi, nomeCustomizzazioni) {
                var ru1614 = OSCURAMENTI.RU_1614;

                if (!servizi || !ru1614.oscurato) {
                    return servizi;
                }

                return servizi.filter(function(servizio) {
                    if (!servizio[nomeCustomizzazioni]) {
                        return true;
                    }

                    return !servizio[nomeCustomizzazioni].some(function(customization) {
                        return ru1614.listaCampi.indexOf(customization.attribute) > -1;
                    });
                });
            }
        };
    }]);

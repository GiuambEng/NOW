timnow.factory('SlaValidationService', ['$log', 'Dac', '$q',
    function ($log, Dac, $q) {
        'use strict';

        return {
            get: function (date, order, id, idType, flagNp, sottolavorazione) {
                var slaParams = {
                	type:"sla",
                    dac: date,
                    orderType: order,
                    flagNp: flagNp,
                    sottolavorazione: sottolavorazione
                };

                if (idType === 'offer') {
                    slaParams.offer = id;
                } else {
                    slaParams.resourceId = id;
                }

                var sla = Dac.get(slaParams);
                //RU_920
                var work = Dac.get({type:"work",dac: date, lavorazione: order, idOfferta: id});
                return $q.all([sla.$promise, work.$promise]);
            }
        };
    }
]);

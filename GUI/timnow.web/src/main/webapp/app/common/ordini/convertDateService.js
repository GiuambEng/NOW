timnow.factory('ConvertDateService', ['$filter',
    function ($filter) {

        return {
            get: function (dateInput) {
                var dateTmp = new Date(dateInput);

                return $filter('date')(dateTmp, 'dd/MM/yyyy');
            }
        };
    }
]);

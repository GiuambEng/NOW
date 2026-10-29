timnow.factory('HeaderService', function () {
    'use strict';
    return {};
})

    .factory('Logout', ['$resource', function ($resource) {
        'use strict';
        return $resource('rest/currentuser/quit', {}, {
                cleanSession: {method: 'GET', params: {}, isArray: false}
            }
        );
    }]);
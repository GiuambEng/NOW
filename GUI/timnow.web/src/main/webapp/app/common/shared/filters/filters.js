angular.module('common')
.filter('nl2br', ['$sce', function ($sce) {
    'use strict';
    var tag = (/xhtml/i).test(document.doctype) ? '<br />' : '<br>';
    return function (msg) {
        // ngSanitize's linky filter changes \r and \n to &#10; and &#13; respectively
        if (!msg) {
            return msg;
        }
        msg = (msg + '').replace(/(\r\n|\n\r|&#10;&#13;|&#13;&#10;|&#10;|&#13;|\r|\n)/g, tag);
        return $sce.trustAsHtml(msg);
    };
}])
.filter('getById', function () {
    'use strict';
    return function (input, id) {
        var i = 0, len = input.length;
        for (; i < len; i++) {
            if (+input[i].id === +id) {
                return input[i];
            }
        }
        return null;
    };
})
.filter('joinAttrs', function() {
    return function(list, attrName) {
        var joinedStr = "";
        if(list && list.length > 0){
            for(var i=0; i<list.length; i++){
                joinedStr += list[i][attrName] + "\n";
              }
        }

        return joinedStr;
    };
});
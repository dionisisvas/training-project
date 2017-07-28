'use strict';

angular.
    module('core.focusOn').
    factory('focusBroadcast', function ($rootScope, $timeout) {
        return function(name) {
            $timeout(function (){
                $rootScope.$broadcast('focusOn', name);
            });
        }
    });

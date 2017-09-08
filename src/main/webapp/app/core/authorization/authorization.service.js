'use strict';

angular.
    module('core.authorization').
    factory('Authorization', ['$resource',
        function($resource) {
            return {
                Register: $resource('api/auth/register'),
                Login: $resource('api/auth/login')
            };
        }
    ]);

'use strict';

angular.
    module('core.user').
    factory('User', ['$resource',
        function($resource) {
            return {
                UserById: $resource('api/user/:userId'),
                UserByUsername: $resource('api/user/username/:username'),
                UserList: $resource('api/user/list'),
                EditUser: $resource('api/user/edit', {}, {
                     update: {
                     	method: 'PUT'
                     }
                })
            };
        }
    ]);

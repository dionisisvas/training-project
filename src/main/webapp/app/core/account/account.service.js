'use strict';

angular.
    module('core.account').
    factory('Account', ['$resource',
        function($resource) {
            return {
                AccountById: $resource('api/account/:accountId'),
                AccountByUsername: $resource('api/account/username/:username'),
                AccountByEmail: $resource('api/account/email/:email'),
                AccountList: $resource('api/account/list'),
                IsUsernameUnique: $resource('api/account/is-unique/username/:username'),
                IsEmailUnique: $resource('api/account/is-unique/email/:email')
            };
        }
    ]);

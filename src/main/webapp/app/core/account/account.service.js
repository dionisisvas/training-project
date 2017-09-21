'use strict';

angular.
    module('core.account').
    factory('Account', ['$resource',
        function($resource) {
            return {
                AccountByUsername: $resource('api/account/:username'),
                AccountById: $resource('api/account/id/:accountId'),
                AccountByEmail: $resource('api/account/email/:email'),
                AccountList: $resource('api/account/list'),
                IsUsernameUnique: $resource('api/account/is-unique/username/:username'),
                IsEmailUnique: $resource('api/account/is-unique/email/:email'),
                EditAccount:$resource('api/account/edit')
            };
        }
    ]);

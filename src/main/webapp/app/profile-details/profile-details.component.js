'use strict';

angular.
    module('myProfileDetails').
    component('myProfileDetails', {
        templateUrl: 'app/profile-details/profile-details.template.html',
        controller: ['$routeParams', 'Account', 'User',
            function ProfileDetailsController($routeParams, Account, User) {
                var self = this;

                self.user = User.UserById.get({userId: $routeParams.userId});
                self.account = Account.AccountById.get({accountId: $routeParams.userId});
        }]
    });

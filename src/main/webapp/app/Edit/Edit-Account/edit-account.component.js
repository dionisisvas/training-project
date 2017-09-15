'use strict';

angular.
    module('editAccount').
        component('editAccount', {
        templateUrl: 'app/Edit/Edit-Account/edit-account.template.html',
        controller: ['Account', 'Authorization', 'JWToken','$scope',
            function EditAccountController(Account, User, JWToken,$scope) {
                var self = this;
var account = JSON.stringify({
                                    username :    $scope.account.username,
                                    password :    $scope.account.password,
                                    email:        $scope.account.email
                        });

                if (JWToken.getToken()) {
                    JWToken.getTokenBody(JWToken.getToken()).then(function(tknResult) {
                        self.tokenBody = JSON.parse(tknResult);
                        self.userAccount = Account.AccountByUsername.get({username: self.tokenBody.username});
                        self.userAccount.$promise.then(function(accountResult) {
                        self.userAccount = accountResult;
                        }, function() {
                        	console.log("Failed to retrieve the account for user with username: " + self.tokenBody.username);
                        });
                        self.user = User.UserById.get({userId: self.tokenBody.sub});
                        self.user.$promise.then(function(userResult) {
                        self.user = userResult;
                        }, function() {
                        	console.log("Failed to retrieve the account for user with userId: " + self.tokenBody.sub);
                        });
                    }, function() {
                        console.error("Couldn't retrieve JWT body");
                    });
                }



     }]
    });
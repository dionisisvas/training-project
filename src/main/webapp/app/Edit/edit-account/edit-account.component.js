'use strict';

angular.
    module('editMyAccount').
        component('editMyAccount', {
        templateUrl: 'app/Edit/edit-account/edit-account.template.html',
        controller: ['Account','User', 'Authorization', 'JWToken','$scope',
            function EditMyAccountController(Account,User, Authorization, JWToken,$scope) {
               var self = this;

   				self.myDate = new Date();
                self.minDate = new Date(
                    self.myDate.getFullYear() - 125,
                    self.myDate.getMonth(),
                    self.myDate.getDate()
                );
                self.maxDate = new Date(
                    self.myDate.getFullYear() - 18,
                    self.myDate.getMonth(),
                    self.myDate.getDate()
                );

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
                    self.submitForm = function(isValid) {

                    if (isValid) {
                        var account = JSON.stringify({
                                    username :    self.userAccount.username,
                                    password :    self.userAccount.password,
                                    email:        self.userAccount.email
                        });

                        var user = JSON.stringify({
                                    name :        self.user.name,
                                    surname :     self.user.surname,
                                    dateOfBirth : self.user.dateOfBirth
                        });

                        var dataWrapper = "{\"account\":" + account + ",\"user\":" + user + "}";
console.log(account);
console.log(user);
}
}


     }]
    });
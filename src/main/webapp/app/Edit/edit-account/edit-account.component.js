'use strict';

angular.
    module('editMyAccount').
        component('editMyAccount', {
        templateUrl: 'app/Edit/edit-account/edit-account.template.html',
        controller: ['Account','User', 'Authorization', 'JWToken','$scope',
            function EditMyAccountController(Account,User, Authorization, JWToken,$scope) {
               var self = this;


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

 $scope.user = {
    name: 'email@example.com',
    surname: '123-45-67',
    number: 29,
    range: 10,
    url: 'http://example.com',
    search: 'blabla',
    color: '#6a4415',
    date: null,
    time: '12:30',
    datetime: null,
    month: null,
    week: null
  };
  console.log("hjkhkjkj");

     }]
    });
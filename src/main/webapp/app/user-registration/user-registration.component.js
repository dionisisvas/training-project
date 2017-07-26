'use strict';

angular.
    module('myUserRegistration').
        component('myUserRegistration', {
        templateUrl: 'app/user-registration/user-registration.template.html',
        controller: ['$location', '$scope', '$window', 'Account', 'Authorization', 'JWToken',
            function UserRegistrationController($location, $scope, $window, Account, Authorization, JWToken) {
                var self = this;

                self.loginUrl = 'login';

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

                self.submitForm = function(isValid) {

                    if (isValid) {
                        var account = JSON.stringify({
                                    username :    $scope.account.username,
                                    password :    $scope.account.password,
                                    email:        $scope.account.email
                        });

                        var user = JSON.stringify({
                                    username :    $scope.account.username,
                                    name :        $scope.user.name,
                                    surname :     $scope.user.surname,
                                    dateOfBirth : $scope.user.dateOfBirth
                        });

                        var dataWrapper = "{\"account\":" + account + ",\"user\":" + user + "}";

                        Authorization.Register.save(dataWrapper, function() {
                            console.log("Registration succeeded");

                            Authorization.Login.save(account, function(response) {
                                console.log("Login succeeded");
                                JWToken.setToken(response.token).then(function() {
                                    $location.path('/');
                                    $window.location.reload();
                                });
                            }, function(response) {
                                console.error("Login failed: " + response.data.message);
                            });
                        }, function(response) {
                            console.error("Registration failed: " + response.data.message);
                        });
                    }
                };
        }]
    });

'use strict';

angular.
    module('myUserRegistration').
        component('myUserRegistration', {
        templateUrl: 'app/user-registration/user-registration.template.html',
        controller: ['$location', '$mdToast', '$scope', '$timeout', '$window', 'Account', 'Authorization', 'JWToken',
            function UserRegistrationController($location, $mdToast, $scope, $timeout, $window, Account, Authorization, JWToken) {
                var self = this;

                self.loginUrl = 'auth/1';

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

                        Authorization.Register.save(dataWrapper, function(response) {
                                $mdToast.show(
                                    $mdToast.simple()
                                      .textContent(response.message + ' Logging you in...')
                                      .position('bottom center')
                                      .hideDelay(600)
                                );

                            $timeout(function() {
                                Authorization.Login.save(account, function(response) {
                                    console.log("Login succeeded: " + response.token);
                                    JWToken.setToken(response.token).then(function() {
                                        $location.path('/');
                                        $window.location.reload();
                                    });
                                }, function(response) {
                                    console.log("Login failed: " + response.data.message);
                                });
                            }, 500);
                        }, function(response) {
                            $mdToast.show(
                                $mdToast.simple()
                                  .textContent(response.data.message)
                                  .action('Dismiss')
                                  .highlightAction(true)
                                  .highlightClass('md-primary md-warn')
                                  .position('bottom center')
                                  .hideDelay(3000)
                            );
                        });
                    }
                };
        }]
    });

'use strict';

angular.
    module('myLoginCard').
    component('myLoginCard', {
        templateUrl: 'app/login-card/login-card.template.html',
        controller: ['$location', '$mdToast', '$scope', '$window', 'Authorization', 'JWToken',
            function LoginCardController($location, $mdToast, $scope, $window, Authorization, JWToken) {
                var self = this;
                self.registrationUrl = 'auth/0';

                self.submitForm = function(isValid) {

                    if (isValid) {
                        Authorization.Login.save($scope.account, function(response) {
                            console.log("Login succeeded.");
                            JWToken.setToken(response.token).then(function() {
                                $location.path('/');
                                $window.location.reload();
                            });
                        }, function(response) {
                            $mdToast.show(
                                $mdToast.simple()
                                  .textContent( "Login failed. ")
                                  .action('Dismiss')
                                  .highlightAction(true)
                                  .highlightClass('md-primary md-warn')
                                  .position('bottom center')
                                  .hideDelay(3000)
                            );
                        });
                    }
                };

                self.switchTab = function() {
                    $location.path(self.registrationUrl);
                }
        }]
    });

'use strict';

angular.
    module('myUserLogin').
    component('myUserLogin', {
        templateUrl: 'app/user-login/user-login.template.html',
        controller: ['$location', '$mdToast', '$scope', '$window', 'Authorization', 'JWToken',
            function UserLoginController($location, $mdToast, $scope, $window, Authorization, JWToken) {
                var self = this;
                self.registrationUrl = 'register';

                self.submitForm = function(isValid) {

                    if (isValid) {
                        Authorization.Login.save($scope.account, function(response) {
                            console.log("Login succeeded " + response.token);
                            JWToken.setToken(response.token).then(function() {
                                $location.path('/');
                                $window.location.reload();
                            });
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

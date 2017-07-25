'use strict';

angular.
    module('myUserLogin').
    component('myUserLogin', {
        templateUrl: 'app/user-login/user-login.template.html',
        controller: ['$location', '$mdToast', '$scope', '$window', 'Authorization', 'JWToken',
            function UserLoginController($location, $mdToast, $scope, $window, Authorization, JWToken) {
                var self = this;
                self.registrationUrl = 'register';

                this.submitForm = function(isValid) {

                    Authorization.Login.save($scope.account, function(response) {
                        console.log("Login succeeded " + response.token);
                        JWToken.setToken(response.token).then(function() {
                            $location.path('/');
                            $window.location.reload();
                        });
                    }, function(response) {
                        console.error("Login failed: " + response.data.message);
                    });
                };
        }]
    });

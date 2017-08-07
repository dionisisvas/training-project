'use strict';

angular.
    module('myUserLogin').
    component('myUserLogin', {
        templateUrl: 'app/user-login/user-login.template.html',
        controller: ['$location', 'Account', 'JWToken',
            function UserLoginController($location, Account, JWToken) {
                $(document).ready(function(){

                    $("#submit").click(function() {

                        var account = JSON.stringify({
                                    username :    $('#username').val(),
                                    password :    $('#password').val()
                        });

                        Account.Login.save(account, function(response) {
                            console.log("Login succeeded " + response.token);
                            JWToken.setToken(response.token).then(function() {
                                $location.path('/');
                            });
                        }, function(response) {
                            console.error("Login failed: " + response.data.message);
                        });
                    });
            });
        }]
    });
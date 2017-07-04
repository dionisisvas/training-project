'use strict';

angular.
	module('myUserLogin').
	component('myUserLogin', {
		templateUrl: 'app/user-login/user-login.template.html',
		controller: ['Account', 'JWToken',
            function UserLoginController(Account, JWToken) {
                $(document).ready(function(){
                    
                    $("#submit").click(function() {                        
                        
                        var account = JSON.stringify({
                                    username :    $('#username').val(),
                                    password :    $('#password').val()                      
                        });
                        
                        Account.Login.save(account, function(response) {
                            JWToken.setToken(response.token);
                            console.log("Login succeeded");
                        }, function() {
                            console.error("Login failed");
                        });              
                    });             
            });
        }]
    });
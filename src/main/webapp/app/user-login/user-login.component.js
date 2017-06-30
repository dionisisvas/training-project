'use strict';

angular.
	module('myUserLogin').
	component('myUserLogin', {
		templateUrl: 'app/user-login/user-login.template.html',
		controller: ['Account',
            function UserLoginController(Account) {
                var self = this;
                $(document).ready(function(){
                    
                    $("#submit").click(function() {                        
                        
                        var account = JSON.stringify({
                                    username :    $('#username').val(),
                                    password :    $('#password').val()                      
                        });
                        
                        Account.Login.save(account, function(response) {
                            self.jwt = response.token;
                            console.log("Login succeeded");
                        }, function() {
                            console.error("Login failed");
                        });              
                    });             
            });
        }]
    });
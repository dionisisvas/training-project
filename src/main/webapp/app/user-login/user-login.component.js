'use strict';

angular.
	module('myUserLogin').
	component('myUserLogin', {
		templateUrl: 'app/user-login/user-login.template.html',
		controller: [
            function UserLoginController() {
                $(document).ready(function(){
                    
                    $("#username").focusout(function() {

                    });
 
                    $("#password").focusout(function() {
 
                    });

                    $("#submit").click(function() {                        

                    });             
            });
        }]
    });
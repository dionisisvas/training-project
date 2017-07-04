'use strict';

angular.
	module('myNavBar').
	component('myNavBar', {
		templateUrl: 'app/nav-bar/nav-bar.template.html',
		controller: ['JWToken',
            function NavBarController(JWToken) {
                var self = this;
                
                self.tkn = JWToken.getToken();
                
                if (self.tkn) {
                    self.isLoggedIn = true;
                } else {
                    self.isLoggedIn = false;
                }
		}]
	});

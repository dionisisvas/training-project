'use strict';

angular.
	module('myNavBar').
	component('myNavBar', {
		templateUrl: 'app/nav-bar/nav-bar.template.html',
		controller: ['JWToken',
            function NavBarController(JWToken) {
                var self = this;
                                
                if (JWToken.getToken()) {
                    self.isLoggedIn = true;
                } else {
                    self.isLoggedIn = false;
                }
		}]
	});

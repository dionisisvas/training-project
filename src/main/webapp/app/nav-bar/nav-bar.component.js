'use strict';

angular.
	module('myNavBar').
	component('myNavBar', {
		templateUrl: 'app/nav-bar/nav-bar.template.html',
		controller: ['$location', 'JWToken',
            function NavBarController($location, JWToken) {
                var self = this;
                
                if (JWToken.getToken()) {
                    self.isLoggedIn = true;
                    self.tokenBody = JSON.parse(JWToken.getTokenBody(JWToken.getToken()));
                } else {
                    self.isLoggedIn = false;
                    self.tokenBody = null;
                }
                
                self.logout = function() {
                
                    JWToken.removeToken().then(function() {
                                self.isLoggedIn = false; 
                                $location.path('/');
                        });
                }
		}]
	});

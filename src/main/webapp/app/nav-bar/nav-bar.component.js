'use strict';

angular.
	module('myNavBar').
	component('myNavBar', {
		templateUrl: 'app/nav-bar/nav-bar.template.html',
		controller: [function NavBarController() {
            var self = this;
            self.isLoggedIn = false;
		}]
	});

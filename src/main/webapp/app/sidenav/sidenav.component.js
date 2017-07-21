'use strict';

angular.
    module('mySidenav').
    component('mySidenav', {
        templateUrl: 'app/sidenav/sidenav.template.html',
        controller: ['$location', 'JWToken',
            function SidenavController($location, JWToken) {
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

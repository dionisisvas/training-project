'use strict';

angular.
    module('myToolbar').
    component('myToolbar', {
        templateUrl: 'app/toolbar/toolbar.template.html',
        controller: ['$location', 'JWToken',
            function ToolbarController($location, JWToken) {
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

'use strict';

angular.
    module('myToolbar').
    component('myToolbar', {
        templateUrl: 'app/toolbar/toolbar.template.html',
        controller: ['$location', 'focusBroadcast', 'JWToken',
            function ToolbarController($location, focusBroadcast, JWToken) {
                var self = this;
                self.showSearch = false;
                self.githubUrl = 'https://github.com/dionisisvas/training-project/';

                if (JWToken.getToken()) {
                    self.isLoggedIn = true;
                    self.tokenBody = JSON.parse(JWToken.getTokenBody(JWToken.getToken()));
                } else {
                    self.isLoggedIn = false;
                    self.tokenBody = null;
                }

                self.toggleSearch = function() {
                    self.showSearch = !self.showSearch;
                    if (self.showSearch) {
                        focusBroadcast('showSearch');
                    }
                }

                self.logout = function() {
                    JWToken.removeToken().then(function() {
                        self.isLoggedIn = false;
                        $location.path('/');
                    });
                }
            }]
    });

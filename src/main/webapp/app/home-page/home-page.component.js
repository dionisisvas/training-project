'use strict';

angular.
    module('myHomePage').
    component('myHomePage', {
        templateUrl: 'app/home-page/home-page.template.html',
        controller: ['JWToken',
            function HomePageController(JWToken) {
                var self = this;

                self.tokenBody;
                self.isLoggedIn;

                self.setDefaults = function() {
                    self.tokenBody = {
                                name : 'guest'
                    };
                    self.isLoggedIn = false;
                }

                self.setDefaults();

                if (JWToken.getToken()) {
                    JWToken.getTokenBody(JWToken.getToken()).then(function(tknResult) {
                        self.tokenBody = JSON.parse(tknResult);
                        self.isLoggedIn = true;
                    }, function() {
                        self.setDefaults();
                        console.error("Couldn't retrieve JWT body");
                    });
                }
        }]
    });

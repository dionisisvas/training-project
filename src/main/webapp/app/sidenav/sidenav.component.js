'use strict';

angular.
    module('mySidenav').
    component('mySidenav', {
        templateUrl: 'app/sidenav/sidenav.template.html',
        controller: ['$location', 'Image', 'JWToken',
            function SidenavController($location, Image, JWToken) {
                var self = this;

                self.setDefaults = function() {
                    self.tokenBody = {
                                sub :       '-1',
                                name :      'Name',
                                surname:    'Surname',
                                username :  'username',
                                email:      'email@domainname.com'
                    };
                    self.isLoggedIn = false;
                    self.tokeBody = null;
                    self.profileImage = null;
                }

                self.setDefaults();

                if (JWToken.getToken()) {
                    JWToken.getTokenBody(JWToken.getToken()).then(function(tknResult) {
                        self.tokenBody = JSON.parse(tknResult);
                        self.isLoggedIn = true;
                        self.profileImage = Image.ProfileImage.get({userId: self.tokenBody.sub});
                        self.profileImage.$promise.then(function(imgResult) {
                            self.profileImage = imgResult;
                        }, function() {
                            console.log("User " + self.tokenBody.sub + " has no profile image.");
                        });
                    }, function() {
                        self.setDefaults();
                        console.error("Couldn't retrieve JWT body");
                    });
                } else {
                    self.setDefaults();
                }

                self.logout = function() {
                    JWToken.removeToken().then(function() {
                        self.setDefaults();
                        $location.path('/login');
                    });
                }
        }]
    });

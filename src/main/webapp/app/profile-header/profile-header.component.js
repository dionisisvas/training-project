'use strict';

angular.
    module('myProfileHeader').
    component('myProfileHeader', {
        templateUrl: 'app/profile-header/profile-header.template.html',
        controller: ['$location', '$routeParams', 'Account', 'Image', 'User',
            function ProfileHeaderController($location, $routeParams, Account, Image, User) {
                var self = this;
                self.userAccount;
                self.userImages;
                self.profileImageUrl;

                self.setProfileImageUri = function setProfileImageUri(imageUri) {
                    self.profileImageUrl = imageUri;
                };

                self.getUserImages = function() {
                    self.userImages = Image.UserImages.query({userId: $routeParams.userId}, function(imgResult) {
                        self.userImages = imgResult;
                        if (self.userImages.length > 0) {
                            self.setProfileImageUri(self.userImages[0].imgUri);
                        }
                    }, function() {
                        console.log("User " + $routeParams.userId + " has no images.");
                    });
                }

                self.getUserAccount = function() {
                    self.userAccount = Account.AccountById.get({accountId: $routeParams.userId}, function(accountResult) {
                        self.userAccount = accountResult;
                    }, function() {
                        console.log("Failed to retrieve the account for user with uid: " + $routeParams.userId);
                    });
                }

                self.user = User.UserById.get({userId: $routeParams.userId}, function(user) {
                    self.getUserImages();
                    self.getUserAccount();
                }, function() {
                    $location.path('error');
                    console.log("User " + $routeParams.userId + " does not exist.");
                });
        }]
    });

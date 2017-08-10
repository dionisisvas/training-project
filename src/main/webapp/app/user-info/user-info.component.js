'use strict';

angular.
    module('myUserInfo').
    component('myUserInfo', {
        templateUrl: 'app/user-info/user-info.template.html',
        controller: ['$routeParams', 'Account', 'Hobby', 'Image', 'User',
            function UserInfoController($routeParams, Account, Hobby, Image, User) {
                var self = this;
                var userHobbies;
                var userImages;
                var userEmail;
                var profileImageUrl;

                self.setProfileImageUri = function setProfileImageUri(imageUri) {
                    self.profileImageUrl = imageUri;
                };

                self.getUserImages = function() {
                    self.userImages = Image.UserImages.query({userId: $routeParams.userId});
                    self.userImages.$promise.then(function(imgResult) {
                        self.userImages = imgResult;
                        if (self.userImages.length > 0) {
                            self.setProfileImageUri(self.userImages[0].imgUri);
                        }
                    }, function() {
                        console.log("User " + $routeParams.userId + " has no images.");
                    });
                }

                self.getUserHobbies = function() {
                    self.userHobbies = Hobby.UserHobbies.query({userId: $routeParams.userId});
                    self.userHobbies.$promise.then(function(hobbiesResult) {
                        self.userHobbies = hobbiesResult;
                    }, function() {
                        console.log("User " + $routeParams.userId + " has no hobbies.");
                    });
                }

                self.getUserEmail = function() {
                    self.userAccount = Account.AccountById.get({accountId: $routeParams.userId});
                    self.userAccount.$promise.then(function(accountResult) {
                        self.userEmail = accountResult.email;
                    }, function() {
                        console.log("Failed to retrieve the account for user with uid: " + $routeParams.userId);
                    });
                }

                self.user = User.UserById.get({userId: $routeParams.userId}, function(user) {
                    self.getUserImages();
                    self.getUserHobbies();
                    self.getUserEmail();
                });

        }]
    });

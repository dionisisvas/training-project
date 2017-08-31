'use strict';

angular.
    module('myUserProfile').
    component('myUserProfile', {
        templateUrl: 'app/user-profile/user-profile.template.html',
        controller: ['$routeParams', 'Account', 'Hobby', 'Image', 'User', '$scope', 'Timeline',
            function UserProfileController($routeParams, Account, Hobby, Image, User, $scope, Timeline) {
                var self = this;
                var userHobbies;
                var userImages;
                var profileImageUrl;
                var userDates;
var testItemList = [];
 $scope.itemList = [];

    $scope.onItemClick = function( item ) {
        item.active = !item.active;
        if (item.active) {
            item.activeContent = item.content;
        } else {
            item.activeContent = item.shortContent;
        }
    }

        self.setTestData=function () {
        self.userDates = Timeline.EventByUserId.query({userId: $routeParams.userId});
        self.userDates.$promise.then(function(datesResult) {
        self.userDates = datesResult;

        angular.forEach(datesResult, function(dates, key) {
        var DateFormat=dates.dateOfEvent.reverse();
        var transDate=DateFormat.join("-");
        testItemList.push({ date: transDate, time: dates.title, content: dates.description });

        for( var i = 0; i < testItemList.length; i++ ) {
            var item = testItemList[i];
            item.shortContent = item.content.substring(0, 235);
            if (item.content.length > 235) {
                item.shortContent = [item.shortContent, '...'].join('');
            }
            testItemList[i].activeContent = testItemList[i].shortContent;
            testItemList[i].active = false;
        }


        }, function() {
         console.log("User " + $routeParams.userId + " has no selected dates.");
         });
         });

    }

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

                self.getUserAccount = function() {
                    self.userAccount = Account.AccountById.get({accountId: $routeParams.userId});
                    self.userAccount.$promise.then(function(accountResult) {
                        self.userAccount = accountResult;
                    }, function() {
                        console.log("Failed to retrieve the account for user with uid: " + $routeParams.userId);
                    });
                }

                self.user = User.UserById.get({userId: $routeParams.userId}, function(user) {
                var DateFormat=user.dateOfBirth.reverse();
                 var transDateOb=user.dateOfBirth.join("-");
                 testItemList.push({ date: transDateOb, time: 'Birthday', content: 'Birthday' });

        for( var i = 0; i < testItemList.length; i++ ) {
            var item = testItemList[i];
            item.shortContent = item.content.substring(0, 235);
            if (item.content.length > 235) {
                item.shortContent = [item.shortContent, '...'].join('');
            }
            testItemList[i].activeContent = testItemList[i].shortContent;
            testItemList[i].active = false;
        }
                    self.getUserImages();
                    self.getUserHobbies();
                    self.getUserAccount();
                    self.setTestData();
                });
       $scope.itemList = testItemList;
        }]
    });

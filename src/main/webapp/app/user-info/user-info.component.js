'use strict';

angular.
    module('myUserInfo').
    component('myUserInfo', {
        templateUrl: 'app/user-info/user-info.template.html',
        controller: ['$routeParams', 'Account', 'Hobby', 'Image', 'User','$scope','Timeline',
            function UserInfoController($routeParams, Account, Hobby, Image, User,$scope,Timeline) {
                var self = this;
                var userHobbies;
                var userImages;
                var profileImageUrl;
                var userDates;



 $scope.itemList = [];

    $scope.onItemClick = function( item ) {
        item.active = !item.active;
        if (item.active) {
            item.activeContent = item.content;
        } else {
            item.activeContent = item.shortContent;
        }
    }

    function setTestData() {


    self.getUserDates = function() {
                        self.userDates = Timeline.EventByUserId.query({userId: $routeParams.userId});
                        self.userDates.$promise.then(function(datesResult) {
                            self.userDates = datesResult;
                            console.log(datesResult);


        var testItemList = [
            { date: '8/1/2014', time: '10:27 am', content: 'Graduated from university ' },
            { date: '8/1/2014', time: '11:45 am', content: 'Graduated from university ' },
            { date: '8/3/2014', time: '8:31 am', content: 'Graduated from university ' },
            { date: '8/16/2014', time: '1:15 pm', content: 'Graduated from university ' },
            { date: '9/2/2014', time: '1:27 pm', content: 'Graduated from university ' }
        ];

        for( var i = 0; i < testItemList.length; i++ ) {
            var item = testItemList[i];
            item.shortContent = item.content.substring(0, 235);
            if (item.content.length > 235) {
                item.shortContent = [item.shortContent, '...'].join('');
            }
            testItemList[i].activeContent = testItemList[i].shortContent;
            testItemList[i].active = false;
        }

        $scope.itemList = testItemList;
        }, function() {
         console.log("User " + $routeParams.userId + " has no selected dates.");
         });
        }
    }

    setTestData();

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
                    self.getUserImages();
                    self.getUserHobbies();
                    self.getUserAccount();
                    self.getUserDates();
                });

        }]
    });

'use strict';

angular.
    module('myProfileTimeline').
    component('myProfileTimeline', {
        templateUrl: 'app/profile-timeline/profile-timeline.template.html',
        controller: ['$routeParams', 'Account', 'User', 'Timeline',
            function ProfileTimelineController($routeParams, Account, User, Timeline) {
                var self = this;
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

                self.getLifeEvents = function () {
                    self.lifeEvents = Timeline.EventByUserId.query({userId: $routeParams.userId}, function(datesResult) {
                        self.userDates = datesResult;
                        angular.forEach(datesResult, function(dates, key) {
                            var DateFormat=new Date(dates.dateOfEvent);
                            var transDate=DateFormat.toDateString();
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

                self.user = User.UserById.get({userId: $routeParams.userId}, function(user) {
                    var DateFormat=new Date(user.dateOfBirth);
                    var transDateOb=DateFormat.toDateString();
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
                    self.setTestData();
                });
                
                $scope.itemList = testItemList;
        }]
    });

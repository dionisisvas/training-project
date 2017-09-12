'use strict';

angular.
    module('myProfileTimeline').
    component('myProfileTimeline', {
        templateUrl: 'app/profile-timeline/profile-timeline.template.html',
        controller: ['$routeParams', 'User', 'Timeline',
            function ProfileTimelineController($routeParams, User, Timeline) {
                var self = this;
                self.rawEventList;
                self.formattedEventList = [];

                self.onEventClick = function(lifeEvent) {
                    lifeEvent.active = !lifeEvent.active;
                    if (lifeEvent.active) {
                        lifeEvent.activeContent = lifeEvent.content;
                    } else {
                        lifeEvent.activeContent = lifeEvent.shortContent;
                    }
                }

                self.getLifeEvents = function () {
                    self.rawEventList = Timeline.EventByUserId.query({userId: $routeParams.userId}, function(eventsResult) {
                        self.rawEventList = eventsResult;
                        self.formatEventList();
                    }, function() {
                            console.log("User " + $routeParams.userId + " has no life events.");
                    });
                }

                self.formatEventList = function() {
                    angular.forEach(self.rawEventList, function(rawEvent, key) {
                        var formattedDate = new Date(rawEvent.dateOfEvent);
                        self.formattedEventList.push({ date: formattedDate.toDateString(), time: rawEvent.title, content: rawEvent.description });
                    });

                    angular.forEach(self.formattedEventList, function(formattedEvent, key) {
                        formattedEvent.shortContent = formattedEvent.content;
                        if (formattedEvent.content.length > 235) {
                            formattedEvent.shortContent = formattedEvent.content.substring(0, 235);
                            formattedEvent.shortContent += '...';
                        }

                        formattedEvent.activeContent = formattedEvent.shortContent;
                        formattedEvent.active = false;
                    });
                }

                self.user = User.UserById.get({userId: $routeParams.userId}, function(user) {
                    var formattedDate = new Date(user.dateOfBirth);
                    self.formattedEventList.push({ date: formattedDate.toDateString(), time: 'Birthday', content: 'Birthday' });

                    self.getLifeEvents();
                });
        }]
    });

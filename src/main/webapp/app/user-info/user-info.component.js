'use strict';

angular.
	module('myUserInfo').
	component('myUserInfo', {
		templateUrl: 'app/user-info/user-info.template.html',
		controller: ['$routeParams', 'Hobby', 'Image', 'User',
			function UserInfoController($routeParams, Hobby, Image, User) {
				var self = this;
				var userHobbies;			
				var userImages;	
				var profileImageUrl;
				
				self.setProfileImageUri = function setProfileImageUri(imageUri) {
					self.profileImageUrl = imageUri;
				};
				
				self.getUserImages = function() {
					self.userImages = Image.UserImages.query({userId: $routeParams.userId});
					self.userImages.$promise.then(function(imgResult) {
                        self.setProfileImageUri(self.userImages[0].imgUri);
						self.userImages = imgResult;
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
				
				self.user = User.UserById.get({userId: $routeParams.userId}, function(user) {
					self.getUserImages();
					self.getUserHobbies();
				});	

				
		}]
	});

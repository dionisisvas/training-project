'use strict';

angular.
	module('myUserInfo').
	component('myUserInfo', {
		templateUrl: 'resources/app/user-info/user-info.template.html',
		controller: ['$routeParams', 'User', 'Image',
			function UserInfoController($routeParams, User, Image) {
				var self = this;				
				var userImages;	
				var profileImageUrl;
				
				self.setProfileImageUri = function setProfileImageUri(imageUri) {
					self.profileImageUrl = imageUri;
				};
				
				self.user = User.get({userId: $routeParams.userId}, function(user) {
					self.userImages = Image.UserImages.query({userId: $routeParams.userId}, function() {
						self.setProfileImageUri(self.userImages[0].imgUri);
					});
					self.userImages.$promise.then(function(imgResult) {
						self.userImages = imgResult;
					}, function() {
						console.log("User " + $routeParams.userId + " has no images.");
					});
				});			
		}]
	});

'use strict';

angular.
	module('myUserInfo').
	component('myUserInfo', {
		templateUrl: 'resources/app/user-info/user-info.template.html',
		controller: ['$routeParams', '$User', function UserInfoController($routeParams, $User) {
			var self = this;				
			
			self.user = User.get({userId: $routeParams.userId}, function(user) {
				self.setImage(user.images[0]);
			});

			self.setImage = function setImage(imageUrl) {
				self.mainImageUrl = imageUrl;
			};
		}]
	});

'use strict';

angular.
	module('myUserInfo').
	component('myUserInfo', {
		templateUrl: 'resources/app/user-info/user-info.template.html',
		controller: ['$http', '$routeParams', function UserInfoController($http, $routeParams) {
			var self = this;			
			
			self.setImage = function setImage(imageUrl) {
				self.mainImageUrl = imageUrl;
			};
			
			$http.get('resources/json/users/user_' + $routeParams.userId + '.json').then(function(response) {
				self.user = response.data;
				self.setImage(self.user.images[0]);
			});
		}]
	});

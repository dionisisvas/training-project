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
			
			$http.get(method:'GET', url:'/users/:userId', {id:'@userId'}).then(function(response) {
				self.user = response.data;
				self.setImage(self.user.images[0]);
			});
		}]
	});

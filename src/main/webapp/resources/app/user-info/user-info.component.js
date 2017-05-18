'use strict';

angular.
	module('myUserInfo').
	component('myUserInfo', {
		templateUrl: 'resources/app/user-info/user-info.template.html',
		controller: ['$http', '$routeParams', function UserInfoController($http, $routeParams) {
			var self = this;			
			self.userId = $routeParams.userId;
			
			$http.get('resources/json/users/user_' + self.userId + '.json').then(function(response) {
				self.user = response.data;
			});
		}]
	});

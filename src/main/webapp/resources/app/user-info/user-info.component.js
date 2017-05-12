'use strict';

angular.
	module('userInfo').
	component('userInfo', {
		templateUrl: '../resources/app/user-info/user-info.template.html',
		controller: function UserInfoController($http) {
			var self = this;
			
			$http.get('../resources/app/users/users.json').then(function(response) {
				self.users = response.data;
			});
		}
	});
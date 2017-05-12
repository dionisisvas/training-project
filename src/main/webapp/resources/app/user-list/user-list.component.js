'use strict';

angular.
	module('userList').
	component('userList', {
		templateUrl: 'resources/app/user-list/user-list.template.html',
		controller: function UserListController($http) {
			var self = this;
			
			$http.get('resources/app/users/users.json').then(function(response) {
				self.users = response.data;
			});
		}
	});
'use strict';

angular.
	module('userList').
	component('userList', {
		templateUrl: 'resources/app/user-list/user-list.template.html',
		controller: ['$http', function UserListController($http) {
			var self = this;
			
			self.starting_limit = 3;
			self.limit = self.starting_limit;
			self.orderProp = 'id';

			$http.get('resources/json/users/users.json').then(function(response) {
				self.users = response.data;
			});
		}]
	});
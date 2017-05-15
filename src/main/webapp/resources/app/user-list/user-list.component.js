'use strict';

angular.
	module('userList').
	component('userList', {
		templateUrl: 'resources/app/user-list/user-list.template.html',
		controller: ['$http', function UserListController($http) {
			var self = this;
			
			self.orderProp = 'id';

			$http.get('resources/json/users/users.json').then(function(response) {
				self.users = response.data;
			});
		}]
	});
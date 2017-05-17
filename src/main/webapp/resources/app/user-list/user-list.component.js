'use strict';

angular.
	module('myUserList').
	component('myUserList', {
		templateUrl: 'resources/app/user-list/user-list.template.html',
		controller: ['$http', function UserListController($http) {
			var self = this;
			
			self.startingLimit = 3;
			self.limit = self.startingLimit;
			self.limitStep = 5;
			
			self.orderProp = 'id';
			
			$http.get('resources/json/users/users.json').then(function(response) {
				self.users = response.data;
			});
		
		    self.getHigherLimit = function() {
				// Increase the limit by the limitStep amount.
				self.limit += self.limitStep;
			
				// Make sure it's an integer multiple of the limitStep. 
				// i.e. 3 will increase to 10 instead of 8.
				if ((self.limit % self.limitStep) != 0) {
					self.limit += self.limitStep - (self.limit % self.limitStep);
				}
				
				// Check if the new limit is higher than the length of users.
		        if (self.limit > self.users.length) {
					self.limit = self.users.length;
				}
		    };

		    self.getLowerLimit = function() {
				// Decrease the limit by the limitStep amount.
				self.limit -= self.limitStep;
				
				// Check if the new limit can be lowered by an other limitStep amount.
				// If not, set to startingLimit.
				if ((self.limit - self.limitStep) < self.startingLimit) {
					self.limit = self.startingLimit;
				}
		    };
		}]
	});
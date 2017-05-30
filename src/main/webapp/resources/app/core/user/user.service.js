'use strict';

angular.
	module('core.user').
	factory('User', ['$resource',
		function($resource) {
			return $url('users/:userId', {}, {
				query: {
					method: 'GET',
					params: {userId: 'users'},
					isArray: true
				}
			});
		}
	]);


'use strict';

angular.
	module('core.user').
	factory('User', ['$resource',
		function($resource) {
			return {
				UserById: $resource('api/user/uid/:userId'),
				UserList: $resource('api/user/list'),                
                Register: $resource('api/user/register')
			};
		}
	]);

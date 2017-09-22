'use strict';

angular.
	module('core.user').
	factory('User', ['$resource',
		function($resource) {
			return {
				UserByUsername: $resource('api/user/:username'),                
				UserById: $resource('api/user/uid/:userId'),
				UserList: $resource('api/user/list'),
				EditUser: $resource('api/user/edit', {}, {
                          'update': {
                         	 method: 'PUT'
                          }
                })
			};
		}
	]);

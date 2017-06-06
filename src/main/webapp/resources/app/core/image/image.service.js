'use strict';

angular.
	module('core.image').
	factory('Image', ['$resource',
		function($resource) {
			return $resource('api/image/user/:userId/profile', {}, {
				query: {
					method: 'GET',
					isArray: true
				}
			});
		}
	]);


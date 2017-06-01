'use strict';

angular.
	module('core.image').
	factory('Image', ['$resource',
		function($resource) {
			return $resource('image/profile/:userId', {}, {
				query: {
					method: 'GET',
					isArray: true
				}
			});
		}
	]);


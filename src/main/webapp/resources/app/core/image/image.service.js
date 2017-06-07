'use strict';

angular.
	module('core.image').
	factory('Image', ['$resource',
		function($resource) {
			return {
				Image: $resource('api/image/:imgId', {}),
				ProfileImage: $resource('api/image/user/:userId/profile'),
				UserImages: $resource('api/image/user/:userId', {}, {
					query: {
						method: 'GET',
						isArray: true
					}
				})
			};
		}
	]);


'use strict';

angular.
	module('core.hobby').
	factory('Hobby', ['$resource',
		function($resource) {
			return {
				Hobby: $resource('api/hobby/:hobbyId', {}),
				UserHobbies: $resource('api/hobby/user/:userId', {}, {
					query: {
						method: 'GET',
						isArray: true
					}
				})
			};
		}
	]);


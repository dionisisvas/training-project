'use strict';

angular.
	module('core.hobby').
	factory('Hobby', ['$resource',
		function($resource) {
			return {
				Hobby: $resource('api/hobby/:hobbyId'),
                HobbyList: $resource('api/hobby/list'),
                EditHobby:$resource('api/hobby/edit'),
				UserHobbies: $resource('api/hobby/user/:userId', {}, {
					query: {
						method: 'GET',
						isArray: true
					}
				})
			};
		}
	]);


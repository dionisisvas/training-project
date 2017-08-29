'use strict';

angular.
	module('core.timeline').
	factory('Timeline', ['$resource',
		function($resource) {
			return {
				EventByUserId: $resource('api/dates/:userId')

			};
		}
	]);

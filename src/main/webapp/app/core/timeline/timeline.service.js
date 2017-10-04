'use strict';

angular.
	module('core.timeline').
	factory('Timeline', ['$resource',
		function($resource) {
			return {
				EventByUserId: $resource('api/dates/:userId'),
				AllEvents: $resource('api/dates/list'),
				EditEvents:$resource('api/dates/add', {}, {
                   update: {
                    method: 'POST'
                   }
                })
			};
		}
	]);

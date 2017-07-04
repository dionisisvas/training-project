'use strict';

angular.
	module('core.metrics').
	factory('Metrics', ['$resource',
		function($resource) {
			return {
				MetricsByUserId: $resource('metrics/id/{userId}'),
				MetricsList: $resource('metrics/list')
			};
		}
	]);

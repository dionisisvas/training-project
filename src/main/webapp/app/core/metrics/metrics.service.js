'use strict';

angular.
	module('core.metrics').
	factory('Metrics', ['$resource',
		function($resource) {
			return {
				MetricsByUserId: $resource('api/metrics/:userId'),
				MetricsList: $resource('api/metrics/list'),
				EditMetrics:$resource('apo/metrics/edit'),
				CountriesList:$resource('resources/json/countries.json')
			};
		}
	]);

'use strict';

angular.
	module('core.metrics').
	factory('Metrics', ['$resource',
		function($resource) {
			return {
				MetricsByUserId: $resource('api/metrics/:userId'),
				MetricsList: $resource('api/metrics/list'),
				EditMetrics:$resource('api/metrics/edit', {}, {
                            update: {
                               method: 'PUT'
                            }
                }),
				CountriesList:$resource('resources/json/countries.json'),
				EducationList:$resource('resources/json/education.json')
			};
		}
	]);

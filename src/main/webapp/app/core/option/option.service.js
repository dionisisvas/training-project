'use strict';

angular.
	module('core.option').
	factory('Option', ['$resource',
		function($resource) {
			return	$resource('resources/json/options.json', {})
		}
	]);


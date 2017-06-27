'use strict';

angular.
	module('core.account').
	factory('Account', ['$resource',
		function($resource) {
			return {
				AccountByUsername: $resource('api/account/:username'),                
				AccountById: $resource('api/account/id/:accountId'),
				AccountList: $resource('api/account/list'),                
                Create: $resource('api/account/create')
			};
		}
	]);

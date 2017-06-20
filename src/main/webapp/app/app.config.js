'use strict';

angular.
	module('trainingApp').
	config(['$locationProvider' ,'$routeProvider',
		function config($locationProvider, $routeProvider) {
			$locationProvider.html5Mode(true);

		    $routeProvider.
				when('/', {
					template: '<my-option-list></my-option-list>'
				}).
				when('/error', {
					template: '<my-error-message></my-error-message>'
				}).				
				when('/user', {
					template: '<my-user-list></my-user-list>'
				}).
				when('/user/:userId', {
					template: '<my-user-info></my-user-info>'
				}).
				when('/create/user', {
                	template: '<my-app></my-app>'
               	}).
				otherwise('/error');
		}
	]);
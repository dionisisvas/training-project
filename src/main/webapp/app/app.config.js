'use strict';

angular.
	module('trainingApp').
	config(['$locationProvider' ,'$routeProvider',
		function config($locationProvider, $routeProvider) {
			$locationProvider.html5Mode(true);

		    $routeProvider.
				when('/', {
					template: '<my-home-page></my-home-page>'
				}).
				when('/error', {
					template: '<my-error-page></my-error-page>'
				}).				
				when('/user', {
					template: '<my-user-list></my-user-list>'
				}).
				when('/user/:userId', {
					template: '<my-user-info></my-user-info>'
				}).
				when('/register', {
                	template: '<my-user-registration></my-user-registration>'
               	}).
				otherwise('/error');
		}
	]);
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
				when('/user/list', {
					template: '<my-user-list></my-user-list>'
				}).
				when('/user/uid/:userId', {
					template: '<my-user-info></my-user-info>'
				}).
				when('/register', {
                	template: '<my-user-registration></my-user-registration>'
               	}).
				when('/login', {
                	template: '<my-user-login></my-user-login>'
               	}).
               	when('/statistic', {
                    template: '<my-nav-bar></my-nav-bar><my-user-statistics></my-user-statistics>'
                }).
                when('/maps', {
                template: '<my-nav-bar></my-nav-bar><my-user-maps></my-user-maps>'
                }).
				otherwise('/error');
		}

	]);
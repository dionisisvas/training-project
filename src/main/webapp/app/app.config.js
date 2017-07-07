'use strict';

angular.
	module('trainingApp').
	config(['$locationProvider' ,'$routeProvider',
		function config($locationProvider, $routeProvider) {
			$locationProvider.html5Mode(true);

		    $routeProvider.
				when('/', {
					template: '<my-nav-bar></my-nav-bar><my-home-page></my-home-page>'
				}).
				when('/error', {
					template: '<my-nav-bar></my-nav-bar><my-error-page></my-error-page>'
				}).				
				when('/user/list', {
					template: '<my-nav-bar></my-nav-bar><my-user-list></my-user-list>'
				}).
				when('/user/uid/:userId', {
					template: '<my-nav-bar></my-nav-bar><my-user-info></my-user-info>'
				}).
				when('/register', {
                	template: '<my-nav-bar></my-nav-bar><my-user-registration></my-user-registration>'
               	}).
				when('/login', {
                	template: '<my-nav-bar></my-nav-bar><my-user-login></my-user-login>'
               	}).                
        when('/statistic', {
                    template: '<my-user-statistics></my-user-statistics>'
                }).
				otherwise('/error');
		}
	]);
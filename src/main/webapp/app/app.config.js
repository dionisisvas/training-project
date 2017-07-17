'use strict';

angular.
    module('trainingApp').
    config(['$httpProvider', '$locationProvider' ,'$routeProvider',
        function config($httpProvider, $locationProvider, $routeProvider) {
            $httpProvider.defaults.withCredentials = true;

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
                    template: '<my-user-statistics></my-user-statistics>'
                }).
                otherwise('/error');
        }
    ]);

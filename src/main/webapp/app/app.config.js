'use strict';

angular.
    module('trainingApp').
    config(['$httpProvider', '$locationProvider', '$mdThemingProvider', '$routeProvider',
        function config($httpProvider, $locationProvider, $mdThemingProvider, $routeProvider) {
            $httpProvider.defaults.withCredentials = true;

            $locationProvider.html5Mode(true);

            $mdThemingProvider.theme('myTheme')
                .primaryPalette('deep-orange', {
                  'hue-2': '500',
                  'hue-3': '700'
                })
                .accentPalette('amber')
                .warnPalette('red');

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
                when('/maps', {
                    template: '<my-user-maps></my-user-maps>'
                }).
                when('/statistic', {
                    template: '<my-user-statistics></my-user-statistics>'
                }).
                otherwise('/error');
        }
    ]);

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
                    templateUrl: 'app/views/home.template.html'
                }).
                when('/about', {
                    templateUrl: 'app/views/about.template.html'
                }).
                when('/error', {
                    templateUrl: 'app/views/error.template.html'
                }).
                when('/login', {
                    template: '<my-user-login></my-user-login>'
                }).
                when('/maps', {
                    template: '<my-user-maps></my-user-maps><my-login-prompt></my-login-prompt>'
                }).
                when('/register', {
                    template: '<my-user-registration></my-user-registration>'
                }).
                when('/statistics', {
                    template: '<my-user-statistics></my-user-statistics><my-login-prompt></my-login-prompt>'
                }).
                when('/users', {
                    templateUrl: 'app/views/users.template.html'
                }).
                when('/user/uid/:userId', {
                    template: '<my-user-info></my-user-info><my-login-prompt></my-login-prompt>'
                }).
                otherwise('/error');
        }
    ]);

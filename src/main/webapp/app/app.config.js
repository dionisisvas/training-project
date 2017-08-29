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
                when('/auth/:tabId?', {
                    templateUrl: 'app/views/auth.template.html'
                }).
                when('/charts', {
                    templateUrl: 'app/views/charts.template.html'
                }).
                when('/error', {
                    templateUrl: 'app/views/error.template.html'
                }).
                when('/users', {
                    templateUrl: 'app/views/users.template.html'
                }).
                when('/user/uid/:userId', {
                    templateUrl: 'app/views/profile.template.html'
                }).
                otherwise('/error');
        }
    ]);

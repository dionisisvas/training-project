'use strict';

angular.
    module('myAuthTabs').
    component('myAuthTabs', {
        templateUrl: 'app/auth-tabs/auth-tabs.template.html',
        controller: ['$routeParams',
            function AuthTabsController($routeParams) {
                var self = this;

                self.tabId = $routeParams.tabId;
        }]
    });

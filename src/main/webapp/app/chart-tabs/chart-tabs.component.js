'use strict';

angular.
    module('myChartTabs').
    component('myChartTabs', {
        templateUrl: 'app/chart-tabs/chart-tabs.template.html',
        controller: ['$routeParams', '$window',
            function ChartTabsController($routeParams, $window) {
                var self = this;

                self.tabId = $routeParams.tabId;
        }]
    });

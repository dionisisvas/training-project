'use strict';

angular.
    module('core.chartInfo').
    factory('ChartInfo', ['$resource',
        function($resource) {
            return {
              ChartData: $resource('resources/json/chart-data.json'),
              ChartOptions: $resource('resources/json/chart-options.json')
            }
        }
    ]);

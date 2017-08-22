'use strict';

angular.
    module('core.chartInfo').
    factory('ChartInfo', ['$resource',
        function($resource) {
            return {
              ChartInfo: $resource('resources/json/chart-info.json'),
              ChartOptions: $resource('resources/json/chart-options.json')
            }
        }
    ]);

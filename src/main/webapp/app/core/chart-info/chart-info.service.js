'use strict';

angular.
    module('core.chartInfo').
    factory('ChartInfo', ['$resource',
        function($resource) {
          return $resource('resources/json/chart-info.json')
        }
    ]);

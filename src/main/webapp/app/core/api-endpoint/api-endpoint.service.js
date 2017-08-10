'use strict';

angular.
    module('core.apiEndpoint').
    factory('ApiEndpoint', ['$resource',
        function($resource) {
          return $resource('resources/json/api-endpoints.json')
        }
    ]);


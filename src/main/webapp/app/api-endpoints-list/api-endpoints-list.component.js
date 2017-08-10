'use strict';

angular.
    module('myApiEndpoints').
    component('myApiEndpoints', {
        templateUrl: 'app/api-endpoints-list/api-endpoints-list.template.html',
        controller: ['ApiEndpoint',
            function ApiEndpointsListController(ApiEndpoint) {
                var self = this;

                self.apiEndpointsList = ApiEndpoint.query();
        }]
    });

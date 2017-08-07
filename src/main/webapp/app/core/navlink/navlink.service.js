'use strict';

angular.
  module('core.navlink').
  factory('Navlink', ['$resource',
    function($resource) {
      return  $resource('resources/json/navlinks.json')
    }
  ]);

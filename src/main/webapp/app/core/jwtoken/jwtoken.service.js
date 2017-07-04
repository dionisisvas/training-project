'use strict';

angular.
	module('core.jwtoken').
	service('JWToken', ['$resource',
		function() {
            var self = this;
            var token = null;
            
            self.setToken = function(tkn) {
                self.token = tkn;
            }
            
            self.getToken = function() {
                return self.token;
            }
		}
	]);


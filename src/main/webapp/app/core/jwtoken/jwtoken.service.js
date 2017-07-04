'use strict';

angular.
	module('core.jwtoken').
	service('JWToken', ['$q',
		function($q) {
            var self = this;
            var token = null;
            
            self.setToken = function(tkn) {
                var deferred = $q.defer();
                
                self.token = tkn;
                
                deferred.resolve();
                
                return deferred.promise;
            }
            
            self.getToken = function() {
                return self.token;
            }
		}
	]);


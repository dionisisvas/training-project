'use strict';

angular.
	module('core.jwtoken').
	service('JWToken', ['$cookieStore', '$http', '$q',
		function($cookieStore, $http, $q) {
            var self = this;
            self.token = $cookieStore.get('myToken');
            
            self.setToken = function(tkn) {
                var deferred = $q.defer();
                
                self.token = tkn;
                $cookieStore.put('myToken', self.token);
                
                deferred.resolve();
                
                return deferred.promise;
            }
            
            self.getToken = function() {
                return self.token;
            }
		}
	]);


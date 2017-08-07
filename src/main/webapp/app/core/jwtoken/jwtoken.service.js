'use strict';

angular.
    module('core.jwtoken').
    service('JWToken', ['$cookieStore', '$http', '$q',
        function($cookieStore, $http, $q) {
            var self = this;

            self.setToken = function(tkn) {
                var deferred = $q.defer();

                self.token = tkn;
                $cookieStore.put('myToken', self.token);
                $http.defaults.headers.common['Authorization'] = 'Bearer ' + self.token;

                deferred.resolve();

                return deferred.promise;
            }

            self.getToken = function() {
                return self.token;
            }

            self.removeToken = function() {
                var deferred = $q.defer();

                if ($cookieStore.get('myToken')) {
                    $cookieStore.remove('myToken');
                }

                $http.defaults.headers.common['Authorization'] = '';
                self.token = null;

                deferred.resolve();

                return deferred.promise;
            }

            self.decodeToken = function(tkn) {
                return atob(tkn);
            }

            self.getTokenBody = function(tkn) {
                var deferred = $q.defer();
                var tokenParts;

                if (tkn) {
                    tokenParts = tkn.split('.');
                }

                if (tokenParts.length !== 3) {
                    return deferred.reject("Invalid token");
                } else {
                    deferred.resolve(self.decodeToken(tokenParts[1]));
                }

                return deferred.promise;
            }

            self.setToken($cookieStore.get('myToken'));
        }
    ]);

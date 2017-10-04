'use strict';

angular.
    module('core.jwtoken').
    service('JWToken', ['$cookieStore', '$http', '$q',
        function($cookieStore, $http, $q) {
            var self = this;

            self.setToken = function(tkn) {
                var deferred = $q.defer();

                $cookieStore.put('myToken', tkn);
                $http.defaults.headers.common['Authorization'] = 'Bearer ' + tkn;

                deferred.resolve();

                return deferred.promise;
            }

            self.getToken = function() {
                return $cookieStore.get('myToken');
            }

            self.removeToken = function() {
                var deferred = $q.defer();

                if ($cookieStore.get('myToken')) {
                    $cookieStore.remove('myToken');
                }

                $http.defaults.headers.common['Authorization'] = '';

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
                } else {
                    return deferred.reject("Invalid token");
                }

                if (tokenParts.length !== 3) {
                    return deferred.reject("Invalid token");
                } else {
                    deferred.resolve(self.decodeToken(tokenParts[1]));
                }

                return deferred.promise;
            }

            self.isLoggedIn = function() {
                var deferred = $q.defer();

                var tkn = self.getToken();
                if (tkn) {
                    self.getTokenBody(tkn).then(function(tknBodyResult) {
                        var tknBody = JSON.parse(tknBodyResult);
                        // Check if the token is expired
                        if ((tknBody.exp - (new Date().getTime() / 1000)) > 0 ) {
                            deferred.resolve(true);
                        } else {
                            deferred.resolve(false);
                        }
                    });
                } else {
                    deferred.resolve(false);
                }

                return deferred.promise;
            }            
            
            self.isOwner = function(id) {
                var deferred = $q.defer();

                var tkn = self.getToken();
                if (tkn) {
                    self.getTokenBody(tkn).then(function(tknResult) {
                        var tknBody = JSON.parse(tknResult);

                        if (tknBody.sub == id) {
                            deferred.resolve(true);
                        } else {
                            deferred.resolve(false);
                        }
                    });
                } else {
                    deferred.resolve(false);
                }

                return deferred.promise;
            }
        }
    ]);

'use strict';

angular.
    module('core.emailUnique').
    directive('emailUnique', ['$q', 'Account',
        function($q, Account) {
            return {
                require : 'ngModel',
                link    : function(scope, elem, attr, ngModel) {
                              ngModel.$asyncValidators.emailUnique = function(email) {
                                  var deferred = $q.defer();
                                  Account.IsEmailUnique.get({email: email}, function(res) {
                                      if (res.isUnique) {
                                        deferred.resolve();
                                      }
                                      else {
                                        deferred.reject();
                                      }
                                  });

                                  return deferred.promise;
                              };
                }
            }
        }
    ]);

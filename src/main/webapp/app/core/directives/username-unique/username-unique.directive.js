'use strict';

angular.
    module('core.usernameUnique').
    directive('usernameUnique', ['$q', 'Account',
        function($q, Account) {
            return {
                require : 'ngModel',
                link    : function(scope, elem, attr, ngModel) {
                              ngModel.$asyncValidators.usernameUnique = function(username) {
                                  var deferred = $q.defer();
                                  Account.IsUsernameUnique.get({username: username}, function(res) {
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

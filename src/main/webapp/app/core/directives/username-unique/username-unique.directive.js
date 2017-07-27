'use strict';

angular.
    module('core.usernameUnique').
    directive('usernameUnique', ['Account',
        function(Account) {
            return {
                require : 'ngModel',
                link    : function($scope, elem, attr, ngModel) {
                              ngModel.$asyncValidators.usernameUnique = function(username) {
                                  return Account.IsUsernameUnique.get({username: username}).$promise.then(function(res) {
                                      ngModel.$setValidity('usernameUnique', res.data);
                                  });
                              };
                }
            }
        }
    ]);

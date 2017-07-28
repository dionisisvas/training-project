'use strict';

angular.
    module('core.emailUnique').
    directive('emailUnique', ['Account',
        function(Account) {
            return {
                require : 'ngModel',
                link    : function(scope, elem, attr, ngModel) {
                              ngModel.$asyncValidators.emailUnique = function(email) {
                                  return Account.IsEmailUnique.get({email: email}).$promise.then(function(res) {
                                      ngModel.$setValidity('emailUnique', res.data);
                                  });
                              };
                }
            }
        }
    ]);

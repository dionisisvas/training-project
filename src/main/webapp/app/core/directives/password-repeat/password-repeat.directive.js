'use strict';

angular.
    module('core.passwordRepeat').
    directive('passwordRepeat', [
        function() {
            return {
                require : 'ngModel',
                scope: {
                    pwd: "=passwordRepeat"
                },
                link    : function(scope, elem, attr, ngModel) {
                              ngModel.$validators.passwordRepeat = function(repeatedPwd) {
                                  return repeatedPwd == scope.pwd;
                              };

                              scope.$watch("pwd", function() {
                                  ngModel.$validate();
                              });
                }
            }
        }
    ]);

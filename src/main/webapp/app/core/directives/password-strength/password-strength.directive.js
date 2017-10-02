'use strict';

angular.
    module('core.passwordStrength').
    directive('passwordStrength', [
        function() {
            var PWD_PATTERNS = [
                /[a-z]/, // Contains lowercase characters
                /[A-Z]/, // Contains uppercase characters
                /\d/,    // Contains numerals
                /[\W_]/   // Contains special characters
            ];

            return {
                require : 'ngModel',
                link    : function(scope, elem, attr, ngModel) {
                              ngModel.$validators.passwordStrength = function(pwd) {
                                  var isStrong = true;

                                  angular.forEach(PWD_PATTERNS, function(rgx) {
                                      isStrong = isStrong && rgx.test(pwd);
                                  });

                                  return isStrong;
                              };
                }
            }
        }
    ]);

'use strict';

angular.
    module('myLoginPrompt').
    component('myLoginPrompt', {
        templateUrl: 'app/login-prompt/login-prompt.template.html',
        controller: ['$window', 'JWToken',
            function LoginPromptController($window, JWToken) {
                var self = this;

                self.isLoggedIn = false;
                self.loginPromptCardDismissedEpoch = 0;
                self.cardDismissed = false;
                self.dayInMillis = 86400000;

                if (JWToken.getToken()) {
                    self.isLoggedIn = true;
                }

                self.checkIfDismissed = function() {
                    self.loginPromptCardDismissedEpoch = $window.localStorage.getItem('loginPromptCardDismissedEpoch');
                    if (self.loginPromptCardDismissedEpoch !== null) {
                        if((new Date().getTime() - self.loginPromptCardDismissedEpoch) > self.dayInMillis) {
                            $window.localStorage.removeItem('loginPromptCardDismissedEpoch');
                            return false;
                        } else {
                          return true;
                        }
                    }

                    return false;
                }

                self.cardDismissed = self.checkIfDismissed();

                self.dismissPrompt = function() {
                    $window.localStorage.setItem('loginPromptCardDismissedEpoch', new Date().getTime());
                    self.cardDismissed = true;
                }
        }]
    });

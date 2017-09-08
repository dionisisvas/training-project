'use strict';

angular.
    module('myLoginPrompt').
    component('myLoginPrompt', {
        templateUrl: 'app/login-prompt/login-prompt.template.html',
        controller: ['JWToken',
            function LoginPromptController(JWToken) {
                var self = this;

                self.isLoggedIn = false;
                self.cardDismissed = false;

                if (JWToken.getToken()) {
                    self.isLoggedIn = true;
                }
        }]
    });

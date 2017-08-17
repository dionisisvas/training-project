'use strict';

angular.
    module('myToolbar').
    component('myToolbar', {
        templateUrl: 'app/toolbar/toolbar.template.html',
        controller: ['focusBroadcast',
            function ToolbarController(focusBroadcast) {
                var self = this;
                self.showSearch = false;
                self.githubUrl = 'https://github.com/dionisisvas/training-project/';

                self.toggleSidenav = function() {
                }

                self.toggleSearch = function() {
                    self.showSearch = !self.showSearch;
                    if (self.showSearch) {
                        focusBroadcast('showSearch');
                    }
                }
            }]
    });

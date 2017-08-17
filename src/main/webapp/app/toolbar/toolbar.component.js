'use strict';

angular.
    module('myToolbar').
    component('myToolbar', {
        templateUrl: 'app/toolbar/toolbar.template.html',
        controller: ['$mdSidenav', 'focusBroadcast',
            function ToolbarController($mdSidenav, focusBroadcast) {
                var self = this;
                self.showSearch = false;
                self.githubUrl = 'https://github.com/dionisisvas/training-project/';

                self.toggleSidenav = function() {
                    $mdSidenav('left').toggle();
                }

                self.toggleSearch = function() {
                    self.showSearch = !self.showSearch;
                    if (self.showSearch) {
                        focusBroadcast('showSearch');
                    }
                }
            }]
    });

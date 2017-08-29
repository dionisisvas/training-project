'use strict';

angular.
    module('myGrids').
    component('myGrids', {
        templateUrl: 'app/grids/grids.template.html',
        controller: ['Metrics', 'User',
            function UserStatisticsController(Metrics, User) {

                var self = this;

                self.users = User.UserList.query(function() {

                    self.metrics = Metrics.MetricsList.query(function() {

                        self.fillDataTables();
                    });
                });

                self.fillDataTables = function() {

                    angular.forEach(self.metrics, function(metric, key) {

                        metric.name = self.users[key].name;
                        metric.surname = self.users[key].surname;
                        metric.age = self.users[key].age;
                    });
                }
        }]
    });

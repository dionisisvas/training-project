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

                        google.charts.load('visualization', {
                                'packages':['table'],
                                'callback': function() {

                                    self.tableChart = new google.visualization.Table(document.getElementById('table_div'));

                                    self.fillDataTables();
                                    self.updateTable();
                                }
                            });
                    });
                });

                self.fillDataTables = function() {

                    self.data = new google.visualization.DataTable();

                    self.data.addColumn('string', 'Name');
                    self.data.addColumn('string', 'Surname');
                    self.data.addColumn('number', 'Age');
                    self.data.addColumn('number', 'Height');
                    self.data.addColumn('number', 'Weight');
                    self.data.addColumn('string', 'Nationality');
                    self.data.addColumn('string', 'Birthplace');
                    self.data.addColumn('string', 'Education');

                    angular.forEach(self.metrics, function(metric, key) {
                        self.data.addRow([
                                self.users[key].name,
                                self.users[key].surname,
                                self.users[key].age,
                                metric.height,
                                metric.weight,
                                metric.nationality,
                                metric.placeOfBirth,
                                metric.education
                            ]);
                    });
                }

                self.updateTable = function() {

                    self.tableChart.draw(self.data);
                }
        }]
    });

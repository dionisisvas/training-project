'use strict';

angular.
    module('myUserStatistics').
    component('myUserStatistics', {
        templateUrl: 'app/user-statistics/user-statistics.template.html',
        controller: ['$scope', 'Metrics', 'User',
            function UserStatisticList($scope, Metrics, User) {

                var self = this;

                self.chartOptions = [{
                        id: 1,
                        title: "Age",
                        is3D: true
                    }, {
                        id: 2,
                        title: "Height",
                        is3D: true
                    },{
                        id: 3,
                        title: "Weight",
                        is3D: true
                    },{
                        id: 4,
                        title: "Education",
                        is3D: true
                    }];
                self.selectedChart = null;

                self.agedUnder25 = 0;
                self.aged25To34 = 0;
                self.aged35To44 = 0;
                self.aged45To54 = 0;
                self.aged55To64 = 0;
                self.aged65To74 = 0;
                self.agedOver74 = 0;

                self.heightShort = 0;
                self.heightMedium = 0;
                self.heightTall = 0

                self.thin = 0;
                self.medium = 0;
                self.fat = 0;

                self.university = 0;
                self.school = 0;
                self.doctorate = 0;
                self.master = 0;
                self.noDiploma = 0;
                self.professional = 0;

                self.users = User.UserList.query(function() {
                    angular.forEach(self.users, function(user) {

                        if (user.age < 25) {
                            self.agedUnder25++;
                        } else if(user.age < 35) {
                            self.aged25To34++;
                        } else if(user.age < 45) {
                            self.aged35To44++;
                        } else if(user.age < 55) {
                            self.aged45To54++;
                        } else if(user.age < 65) {
                            self.aged55To64++;
                        } else if(user.age < 75) {
                            self.aged65To74++;
                        } else {
                            self.agedOver74++;
                        }

                        self.metrics = Metrics.MetricsList.query(function() {

                            angular.forEach(self.metrics, function(metric, key) {
                                if (metric.height <= 1.70) {
                                    self.heightShort++;
                                } else if(metric.height <= 1.80) {
                                    self.heightMedium++;
                                } else {
                                    self.heightTall++;
                                }

                                metric.bmi = metric.weight / (metric.height * metric.height);

                                if (metric.bmi <= 18.5) {
                                    self.thin++;
                                } else if (metric.bmi <= 25) {
                                    self.medium++;
                                } else {
                                    self.fat++;
                                }

                                if (metric.education === "University Education") {
                                    self.university++;
                                } else if(metric.education === "High School Diploma") {
                                    self.school++;
                                } else if(metric.education === "Doctorate Degree") {
                                    self.doctorate++;
                                } else if(metric.education === "Master's Degree") {
                                    self.master++;
                                } else if(metric.education === "No High School Diploma") {
                                    self.noDiploma++;
                                } else if(metric.education === "Professional Degree") {
                                    self.professional++;
                                }
                            });

                            google.charts.load('visualization', '1', {packages:["corechart"]});
                            google.charts.setOnLoadCallback(drawChart);

                            function drawChart(x,y) {
                                self.dataAge = google.visualization.arrayToDataTable([
                                        ['Task',                'User Age'],
                                        ['Under 25 years old',  self.agedUnder25],
                                        ['25-34 years old',     self.aged25To34],
                                        ['35-44 years old',     self.aged35To44],
                                        ['45-54 years old',     self.aged45To54],
                                        ['55-64 years old',     self.aged55To64],
                                        ['65-74 years old',     self.aged65To74],
                                        ['Over 74 years old',   self.agedOver74]
                                    ]);

                                self.dataHeight = google.visualization.arrayToDataTable([
                                        ['Task',                    'User Height'],
                                        ['Short  (Height <= 1.70)',  self.heightShort],
                                        ['Medium (Height <= 1.80)',  self.heightMedium],
                                        ['Tall   (Height > 1.80)' ,  self.heightTall]
                                    ]);

                                self.dataWeight = google.visualization.arrayToDataTable([
                                        ['Task',                  'User Weight'],
                                        ['Thin   (BMI <= 18.5)',  self.thin],
                                        ['Medium (BMI <= 25)',    self.medium],
                                        ['Fat    (BMI > 25)',     self.fat]
                                    ]);

                                self.dataEdu = google.visualization.arrayToDataTable([
                                        ['Task',                    'User Education'],
                                        ['University Education',    self.university],
                                        ['High School Diploma',     self.school],
                                        ['Doctorate Degree',        self.doctorate],
                                        ['Master Degree',           self.master],
                                        ['No High School Diploma',  self.noDiploma],
                                        ['Professional Degree',     self.professional]
                                    ]);

                                self.chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                                self.chart.draw(self.dataAge, self.chartOptions[0]);

                                self.updateChart = function() {
                                    if ($scope.selectedChart === null || $scope.selectedChart.chart.id === 1) {
                                        x = self.dataAge;
                                        y = self.chartOptions[0];
                                    }

                                    if ($scope.selectedChart.id === 2) {
                                        x = dataHeight;
                                        y = self.chartOptions[1];
                                    }
                                    if ($scope.selectedChart.id === 3) {
                                        x = dataWeight;
                                        y = self.chartOptions[2];
                                     }
                                    if ($scope.selectedChart.id === 4) {
                                        x = dataEdu;
                                        y = self.chartOptions[3];
                                    }

                                    self.chart.draw(x, y);
                                    self.chartBar.draw(x, y);
                                }

                                google.charts.load('current',{'packages':['bar']});
                                google.charts.setOnLoadCallback(drawStuff);
                            }

                            function drawStuff() {
                                self.chartBar = new google.charts.Bar(document.getElementById('top_x_div'));
                                self.chartBar.draw(self.dataAge, self.chartOptions[0]);
                            }
                        });
                    });
                });
        }]
    });


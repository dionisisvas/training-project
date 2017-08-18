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

                self.ageGroups = [
                        0, // Aged under 25 years old
                        0, // Aged between 25 to 34 years old
                        0, // Aged between 35 to 44 years old
                        0, // Aged between 45 to 54 years old
                        0, // Aged between 55 to 64 years old
                        0, // Aged between 65 to 74 years old
                        0  // Aged over 74 years old
                    ];

                self.heightGroups = [
                        0, // Short - Height at most 1.70m
                        0, // Average - Height at most 1.80m
                        0  // Tall - Height over 1.80m
                    ];

                self.weightGroups = [
                        0, // Underweight - 18.5 BMI at most
                        0, // Normal weight - 25 BMI at most
                        0  // Overweight - Over 25 BMI
                    ];

                self.educationGroups = [
                        0, // Illiterate
                        0, // Finished high school
                        0, // Has a professional degree
                        0, // Has a bachelor's degree
                        0, // Has a master's degree
                        0  // Has a doctorate's degree
                    ];

                self.users = User.UserList.query(function() {
                    angular.forEach(self.users, function(user) {

                        if (user.age < 25) {
                            self.ageGroups[0]++;
                        } else if (user.age < 35) {
                            self.ageGroups[1]++;
                        } else if (user.age < 45) {
                            self.ageGroups[2]++;
                        } else if (user.age < 55) {
                            self.ageGroups[3]++;
                        } else if (user.age < 65) {
                            self.ageGroups[4]++;
                        } else if (user.age < 75) {
                            self.ageGroups[5]++;
                        } else {
                            self.ageGroups[6]++;
                        }

                        self.metrics = Metrics.MetricsList.query(function() {

                            angular.forEach(self.metrics, function(metric) {
                                if (metric.height <= 1.70) {
                                    self.heightGroups[0]++;
                                } else if (metric.height <= 1.80) {
                                    self.heightGroups[1]++;
                                } else {
                                    self.heightGroups[2]++;
                                }

                                metric.bmi = metric.weight / (metric.height * metric.height);

                                if (metric.bmi <= 18.5) {
                                    self.weightGroups[0]++;
                                } else if (metric.bmi <= 25) {
                                    self.weightGroups[1]++;
                                } else {
                                    self.weightGroups[2]++;
                                }

                                if (metric.education === "No High School Diploma") {
                                    self.educationGroups[0]++;
                                } else if (metric.education === "High School Diploma") {
                                    self.educationGroups[1]++;
                                } else if (metric.education === "Professional Degree") {
                                    self.educationGroups[2]++;
                                } else if (metric.education === "University Education") {
                                    self.educationGroups[3]++;
                                } else if (metric.education === "Master's Degree") {
                                    self.educationGroups[4]++;
                                } else if (metric.education === "Doctorate Degree") {
                                    self.educationGroups[5]++;
                                }
                            });

                            google.charts.load('visualization', '1', {packages:["corechart"]});
                            google.charts.setOnLoadCallback(drawChart);

                            function drawChart(x, y) {
                                self.dataAge = google.visualization.arrayToDataTable([
                                        ['Task',                'User Age'],
                                        ['Under 25 years old',  self.ageGroups[0]],
                                        ['25-34 years old',     self.ageGroups[1]],
                                        ['35-44 years old',     self.ageGroups[2]],
                                        ['45-54 years old',     self.ageGroups[3]],
                                        ['55-64 years old',     self.ageGroups[4]],
                                        ['65-74 years old',     self.ageGroups[5]],
                                        ['Over 74 years old',   self.ageGroups[6]]
                                    ]);

                                self.dataHeight = google.visualization.arrayToDataTable([
                                        ['Task',                    'User Height'],
                                        ['Short  (Height <= 1.70)',  self.heightGroups[0]],
                                        ['Medium (Height <= 1.80)',  self.heightGroups[1]],
                                        ['Tall   (Height > 1.80)' ,  self.heightGroups[2]]
                                    ]);

                                self.dataWeight = google.visualization.arrayToDataTable([
                                        ['Task',                  'User Weight'],
                                        ['Thin   (BMI <= 18.5)',  self.weightGroups[0]],
                                        ['Medium (BMI <= 25)',    self.weightGroups[1]],
                                        ['Fat    (BMI > 25)',     self.weightGroups[2]]
                                    ]);

                                self.dataEdu = google.visualization.arrayToDataTable([
                                        ['Task',                    'User Education'],
                                        ['University Education',    self.educationGroups[3]],
                                        ['High School Diploma',     self.educationGroups[1]],
                                        ['Doctorate Degree',        self.educationGroups[5]],
                                        ['Master Degree',           self.educationGroups[4]],
                                        ['No High School Diploma',  self.educationGroups[0]],
                                        ['Professional Degree',     self.educationGroups[2]]
                                    ]);

                                self.chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                                self.chart.draw(self.dataAge, self.chartOptions[0]);

                                self.updateChart = function() {
                                    if ($scope.selectedChart === null || $scope.selectedChart.chart.id === 1) {
                                        x = self.dataAge;
                                        y = self.chartOptions[0];
                                    }

                                    if ($scope.selectedChart.id === 2) {
                                        x = self.dataHeight;
                                        y = self.chartOptions[1];
                                    }
                                    if ($scope.selectedChart.id === 3) {
                                        x = self.dataWeight;
                                        y = self.chartOptions[2];
                                     }
                                    if ($scope.selectedChart.id === 4) {
                                        x = self.dataEdu;
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


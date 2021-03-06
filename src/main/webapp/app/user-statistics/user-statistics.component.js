'use strict';

angular.
    module('myUserStatistics').
    component('myUserStatistics', {
        templateUrl: 'app/user-statistics/user-statistics.template.html',
        controller: ['ChartInfo', 'Metrics', 'User',
            function UserStatisticsController(ChartInfo, Metrics, User) {

                var self = this;

                self.chartOptions = ChartInfo.ChartOptions.get();
                self.chartData = ChartInfo.ChartData.get(function() {
                    self.pieChartCardTitle = self.chartData['ageGrouped'].title;
                    self.barChartCardTitle = self.chartData['ageGrouped'].title;
                });

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
                        0, // Illiterate/Insufficient data
                        0, // Finished high school
                        0, // Has a trade's school degree
                        0, // Has a bachelor's degree
                        0, // Has a master's degree
                        0  // Has a doctorate's degree
                    ];

                self.users = User.UserList.query(function() {

                    self.metrics = Metrics.MetricsList.query(function() {

                        google.charts.load('visualization', {
                                'packages':['corechart'],
                                'callback': function() {

                                    self.pieChart = new google.visualization.PieChart(document.getElementById('piechart_div'));
                                    self.barChart =  new google.visualization.BarChart(document.getElementById('barchart_div'));

                                    self.fillDataTables();
                                    self.updatePieChart('ageGrouped');
                                    self.updateBarChart('ageGrouped');
                                }
                            });
                    });
                });

                self.fillDataTables = function() {

                    angular.forEach(self.metrics, function(metric, key) {

                        metric.age = self.users[key].age;
                        metric.bmi = metric.weight / (metric.height * metric.height);

                        if (metric.age < 25) {
                            self.ageGroups[0]++;
                        } else if (metric.age < 35) {
                            self.ageGroups[1]++;
                        } else if (metric.age < 45) {
                            self.ageGroups[2]++;
                        } else if (metric.age < 55) {
                            self.ageGroups[3]++;
                        } else if (metric.age < 65) {
                            self.ageGroups[4]++;
                        } else if (metric.age < 75) {
                            self.ageGroups[5]++;
                        } else {
                            self.ageGroups[6]++;
                        }

                        if (metric.height <= 1.70) {
                            self.heightGroups[0]++;
                        } else if (metric.height <= 1.80) {
                            self.heightGroups[1]++;
                        } else {
                            self.heightGroups[2]++;
                        }

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

                    self.ageDataTable = google.visualization.arrayToDataTable([
                            ['Age bracket',              'Population'],
                            ['Under 25 years old',  self.ageGroups[0]],
                            ['25-34 years old',     self.ageGroups[1]],
                            ['35-44 years old',     self.ageGroups[2]],
                            ['45-54 years old',     self.ageGroups[3]],
                            ['55-64 years old',     self.ageGroups[4]],
                            ['65-74 years old',     self.ageGroups[5]],
                            ['Over 74 years old',   self.ageGroups[6]]
                        ], false);
                    self.heightDataTable = google.visualization.arrayToDataTable([
                            ['Height bracket',            'Population'],
                            ['Short   (Height <= 1.70)',  self.heightGroups[0]],
                            ['Average (Height <= 1.80)',  self.heightGroups[1]],
                            ['Tall    (Height > 1.80)',   self.heightGroups[2]]
                        ], false);
                    self.bmiDataTable = google.visualization.arrayToDataTable([
                            ['BMI bracket',                  'Population'],
                            ['Underweight   (BMI <= 18.5)',  self.weightGroups[0]],
                            ['Normal weight (BMI <= 25)',    self.weightGroups[1]],
                            ['Overweight    (BMI > 25)',     self.weightGroups[2]]
                        ], false);
                    self.educationDataTable = google.visualization.arrayToDataTable([
                            ['Education',            'Population'],
                            ['No school or data',    self.educationGroups[0]],
                            ['High school',          self.educationGroups[1]],
                            ['Trade school degree',  self.educationGroups[2]],
                            ['Bachelor\'s degree',   self.educationGroups[3]],
                            ['Master\'s degree',     self.educationGroups[4]],
                            ['Doctorate\'s degree',  self.educationGroups[5]]
                        ], false);
                }

                self.getDataTable = function(data = 'ageGrouped') {

                    switch(data) {
                        case 'heightGrouped':
                            return self.heightDataTable;
                        case 'bmiGrouped':
                            return self.bmiDataTable;
                        case 'educationGrouped':
                            return self.educationDataTable;
                        case 'ageGrouped':
                        default:
                            return self.ageDataTable;
                    }
                }

                self.updatePieChart = function(data = 'ageGrouped') {
                    self.pieChartCardTitle = self.chartData[data].title;
                    self.pieChart.draw(self.getDataTable(data), self.chartOptions.pieChart);
                }

                self.updateBarChart = function(data = 'ageGrouped') {
                    self.barChartCardTitle = self.chartData[data].title;
                    self.barChart.draw(self.getDataTable(data), self.chartOptions.barChart);
                }
        }]
    });

'use strict';

angular.
   module('myUserStatistics').
   component('myUserStatistics', {
      templateUrl: 'app/user-statistics/user-statistics.template.html',
      controller: ['User','Metrics','$scope',
         function UserStatisticList( User,Metrics,$scope) {
         $scope.chartOptions = [{
                 id: 1,
                 name: "Age"
             }, {
                 id: 2,
                 name: "Height"
             },{
                id: 3,
                name: "Weight"
                },{
                id: 4,
                 name: "Education"
             }];

         var self =$(this);

         self.first=0;
         self.second=0;
         self.third=0;
         self.forth=0;
         self.fifth=0;
         self.sixth=0;
         self.seventh=0;
         self.heightShort=0;
         self.heightMedium=0;
         self.heightTall=0;
         self.thin=0;
         self.medium=0;
         self.fat=0;
         self.university=0;
         self.school=0;
         self.doctorate=0;
         self.master=0;
         self.noDiploma=0;
         self.professional=0;

self.users = User.UserList.query(function() {
angular.forEach(self.users, function(user) {
if (user.age<=24 && user.age>=18){self.first++}
else if(user.age<=34 && user.age>=25){self.second++;}
else if(user.age<=44 && user.age>=35){self.third++;}
else if(user.age<=54 && user.age>=45){self.forth++;}
else if(user.age<=64 && user.age>=55){self.fifth++;}
else if(user.age<=74 && user.age>=65){self.sixth++;}
else if(user.age>=75) {self.seventh++;}
self.metrics = Metrics.MetricsList.query(function() {
angular.forEach(self.metrics, function(metrics) {
if (metrics.height<=1.70){self.heightShort++}
else if(metrics.height>1.70 && metrics.height<=1.80){self.heightMedium++;}
else if(metrics.height>1.80){self.heightTall++;}

if ((metrics.weight/(metrics.height*metrics.height))<18.5){self.thin++;}
else if((metrics.weight/(metrics.height*metrics.height))>=18.5 &&(metrics.weight/(metrics.height*metrics.height))<=25){self.medium++;}
else if((metrics.weight/(metrics.height*metrics.height))>25){self.fat++;}

if((metrics.education).valueOf()==("University Education").valueOf()){self.university++;}
else if((metrics.education).valueOf()==("High School Diploma").valueOf()){self.school++;}
else if((metrics.education).valueOf()==("Doctorate Degree").valueOf()){self.doctorate++;}
else if((metrics.education).valueOf()==("Master's Degree").valueOf()){self.master++;}
else if((metrics.education).valueOf()==("No High School Diploma").valueOf()){self.noDiploma++;}
else if((metrics.education).valueOf()==("Professional Degree").valueOf()){self.professional++;}


        google.charts.load('visualization', '1', {packages:["corechart"]});


                   google.charts.setOnLoadCallback(drawChart);

                      	function drawChart(x,y) {
                          var dataAge = google.visualization.arrayToDataTable([
                          ['Task', 'User Age'],
                          ['18-24 Years Old', self.first],
                          ['25-34 years old', self.second],
                          ['35-44 years old', self.third],
                          ['45-54 years old', self.forth],
                          ['55-64 years old', self.fifth],
                          ['65-74 years old', self.sixth],
                          ['75 years or older',self.seventh]
                          ]);

                          var dataHeight = google.visualization.arrayToDataTable([
                          ['Task', 'User Height'],
                          ['Short (Height<1.70)', self.heightShort],
                          ['Medium (1.70<Height<1.80)', self.heightMedium],
                          ['Tall (Height>1.80)' , self.heightTall]
                        ]);

                    var dataWeight = google.visualization.arrayToDataTable([
                          ['Task', 'User Weight'],
                          ['Thin (BMI<18.5)', self.thin],
                          ['Medium (18.5<BMI<25)', self.medium],
                          ['Fat(BMI>25)', self.fat]
                        ]);

                    var dataEdu = google.visualization.arrayToDataTable([
                          ['Task', 'User Education'],
                          ['University Education', self.university],
                          ['High School Diploma', self.school],
                          ['Doctorate Degree', self.doctorate],
                          ['Master Degree', self.master],
                          ['No High School Diploma', self.noDiploma],
                          ['Professional Degree', self.professional]
                          ]);

                        var options1 = {
                          title: 'User Age',
                          is3D: true,
                        };
                        var options2 = {
                          title: 'User Height',
                          is3D: true,
                        };
                        var options3 = {
                           title: 'User Weight',
                           is3D: true,
                        };
                        var options4 = {
                           title: 'User Education',
                           is3D: true,
                        };
                        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                                chart.draw(dataAge, options1);

                               $scope.updateChart = (self.users,self.metrics,function () {
                                if ($scope.selectedChart.chart === null || $scope.selectedChart.chart.id === 1) {
                                    x = dataAge;
                                    y=options1;
                                }

                                if ($scope.selectedChart.chart !== undefined && $scope.selectedChart.chart.id === 2) {
                                    x = dataHeight;
                                    y=options2;
                                }
                                if ($scope.selectedChart.chart !== undefined && $scope.selectedChart.chart.id === 3) {
                                    x = dataWeight;
                                    y=options3;
                                 }
                                if ($scope.selectedChart.chart !== undefined && $scope.selectedChart.chart.id === 4) {
                                    x = dataEdu;
                                    y=options4;
                                }
                                chart.draw(x, y);
                                self.chart1.draw(x, y);
                               });



                 google.charts.load('current',{'packages':['bar']});
                 google.charts.setOnLoadCallback(drawStuff);
}

            function drawStuff() {
            self.chart1 = new google.charts.Bar(document.getElementById('top_x_div'));
           };
});
});
});
});

  }]
  })
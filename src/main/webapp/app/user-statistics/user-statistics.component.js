'use strict';

angular.
	module('myUserStatistics').
	component('myUserStatistics', {
		templateUrl: 'app/user-statistics/user-statistics.template.html',
		controller: ['User','Metrics',
			function UserStatisticList( User,Metrics) {
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
               	angular.forEach(self.users, function(user, key) {
               	if (user.age<=24 && user.age>=18){self.first++}
               	else if(user.age<=34 && user.age>=25){self.second++;}
               	else if(user.age<=44 && user.age>=35){self.third++;}
               	else if(user.age<=54 && user.age>=45){self.forth++;}
               	else if(user.age<=64 && user.age>=55){self.fifth++;}
               	else if(user.age<=74 && user.age>=65){self.sixth++;}
               	else if(user.age>=75) {self.seventh++;}

               	  google.charts.load('visualization', '1', {packages:["corechart"]});
                   google.charts.setOnLoadCallback(drawChart);
                      function drawChart() {

                        var data = google.visualization.arrayToDataTable([
                          ['Task', 'User Age'],
                          ['18-24 Years Old', self.first],
                          ['25-34 years old', self.second],
                          ['35-44 years old', self.third],
                          ['45-54 years old', self.forth],
                          ['55-64 years old', self.fifth],
                		  ['65-74 years old', self.sixth],
                		  ['75 years or older',self.seventh]
                        ]);

                        var options = {
                          title: 'User Age',
                          is3D: true,
                        };

                        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                        chart.draw(data, options);

                 google.charts.load('current',{'packages':['bar']});
                 google.charts.setOnLoadCallback(drawStuff);
}
            function drawStuff() {
             var data = new google.visualization.arrayToDataTable([
               ['User Age', 'Users'],
               ["18-24 Years Old", self.first],
               ["25-34 years old", self.second],
               ["35-44 years old", self.third],
               ["45-54 years old", self.forth],
               ["55-64 years old", self.fifth],
               ["65-74 years old", self.sixth],
               ["75 years or older",self.seventh]
             ]);

             var options = {
               title: 'User Age',
               width: 900,
               legend: { position: 'none' },
               chart: { title: 'User Age'},
               bars: 'vertical',
               axes: {
                 x: {
                   0: { side: 'bottom', label: 'Percentage'} // Top x-axis.
                 }
               },
               bar: { groupWidth: "90%" }
             };

             var chart = new google.charts.Bar(document.getElementById('top_x_div'));
             chart.draw(data, options);
           };
  })
  });

  self.metrics = Metrics.MetricsList.query(function() {
  angular.forEach(self.metrics, function(metrics, key) {
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
                   google.charts.setOnLoadCallback(drawChart1);
                      function drawChart1() {

                        var data = google.visualization.arrayToDataTable([
                          ['Task', 'Height'],
                          ['High School Diploma', self.school],
                          ['Medium',self.doctorate],
                          ['Fat', self.professional]
                        ]);

                        var options = {
                          title: 'User Weight',
                          is3D: true,
                        };

                        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d1'));
                        chart.draw(data, options);

  }
  });
  });


  function myFunction() {
      var x = document.getElementById('piechart_3d');
      if (x.style.display === 'none') {
          x.style.display = 'block';
      } else {
          x.style.display = 'none';
      }
  }
  }]
  });
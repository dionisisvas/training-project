'use strict';

angular.
	module('myUserStatistics').
	component('myUserStatistics', {
		templateUrl: 'app/user-statistics/user-statistics.template.html',
		controller: ['User',
			function UserStatisticList( User) {
				var self =$(this);

				 self.first=0;
				 self.second=0;
				 self.third=0;
				 self.forth=0;
				 self.fifth=0;
				 self.sixth=0;
				 self.seventh=0;
				self.users = User.UserList.query(function() {
               	angular.forEach(self.users, function(user, key) {
               	if (user.age<=24 && user.age>=18){self.first++}
               	else if(user.age<=34 && user.age>=25){self.second++;}
               	else if(user.age<=44 && user.age>=35){self.third++;}
               	else if(user.age<=54 && user.age>=45){self.forth++;}
               	else if(user.age<=64 && user.age>=55){self.fifth++;}
               	else if(user.age<=74 && user.age>=65){self.sixth++;}
               	else (user.age>=75)
               	{self.seventh++;}

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
   }]
  });
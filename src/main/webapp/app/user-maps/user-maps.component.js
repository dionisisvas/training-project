'use strict';

angular.
   module('myUserMaps').
   component('myUserMaps', {
      templateUrl: 'app/user-maps/user-maps.template.html',
      controller: ['Metrics',
  function UserMaps(Metrics) {
var a = {};

self.metrics = Metrics.MetricsList.query(function() {
angular.forEach(self.metrics, function(metrics,key) {
if (_.has(a,metrics.nationality)){ a[metrics.nationality]++;}
else{a[metrics.nationality] = 1}



     function drawRegionsMap() {
     var d1=_.keys(a);
     var d2=_.values(a);
        var data =new google.visualization.DataTable();
          data.addColumn('string', 'd1');
            data.addColumn('number', 'Number Of Users');
            for(var i = 0; i < d1.length; i++)
              data.addRow([d1[i], d2[i]]);

        var options = {};
        var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));
        chart.draw(data, options);
      }
google.charts.load('current', {
        'packages':['geochart'],
        'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
      });
      google.charts.setOnLoadCallback(drawRegionsMap);
      })
      })
}]
})

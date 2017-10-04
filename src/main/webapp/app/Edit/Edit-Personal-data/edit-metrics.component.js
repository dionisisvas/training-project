'use strict';

angular.
    module('editMetrics').
        component('editMetrics', {
        templateUrl: 'app/Edit/Edit-Personal-data/edit-metrics.template.html',
        controller: ['$scope','Metrics','JWToken','$http','$window','$location',
            function EditMyHobbiesController($scope,Metrics,JWToken,$http,$window,$location) {


	  var self=this;
      var map;
      var geocoder;
      var mapOptions = { center: new google.maps.LatLng(0.0, 0.0), zoom: 2,
        mapTypeId: google.maps.MapTypeId.ROADMAP };

      function initialize() {
       var myOptions = {
                center: new google.maps.LatLng(37.940731834543755, 23.75244140625 ),
                zoom:8,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            geocoder = new google.maps.Geocoder();
            var map = new google.maps.Map(document.getElementById("map_canvas"),
            myOptions);
            google.maps.event.addListener(map, 'click', function(event) {
                placeMarker(event.latLng);
            });

            var marker;
            function placeMarker(location) {
                if(marker){
                    marker.setPosition(location);
                }else{
                    marker = new google.maps.Marker({ //on créé le marqueur
                        position: location,
                        map: map
                    });
                }
                document.getElementById('lat').value=location.lat();
                document.getElementById('lng').value=location.lng();
                getAddress(location);
            }

      function getAddress(latLng) {
        geocoder.geocode( {'latLng': latLng},
          function(results, status) {
            if(status == google.maps.GeocoderStatus.OK) {
              if(results[0]) {
                document.getElementById("address").value = results[0].formatted_address;
                self.address=results[0].formatted_address;
              }
              else {
                document.getElementById("address").value = "No results";
              }
            }
            else {
              document.getElementById("address").value = status;
            }
          });
        }
      }

google.maps.event.addDomListener(window, 'load', initialize);
$(document).ready(function(){
  initialize();
});

$scope.Metrics = Metrics.CountriesList.query();
$scope.Education=Metrics.EducationList.query();
 if (JWToken.getToken()) {
  JWToken.getTokenBody(JWToken.getToken()).then(function(tknResult) {
  self.tokenBody = JSON.parse(tknResult);
  self.metrics = Metrics.MetricsByUserId.get({userId: self.tokenBody.sub});
  self.metrics.$promise.then(function(metricsResult) {
  self.metrics = metricsResult;

  }, function() {
  console.log("Failed to retrieve metrics for user with userId: " + self.tokenBody.sub);
  });
}, function() {
  console.error("Couldn't retrieve JWT body");
});

}
self.SaveForm=function(){
  var metrics = JSON.stringify({
  	height	: self.metrics.height,
  	weight	: self.metrics.weight,
  	nationality	: self.metrics.nationality.code,
  	placeOfBirth	: self.address,
  	education	: self.metrics.education.level,
  	userId	: self.tokenBody.sub
  	});
  	$http.put('api/metrics/edit',metrics);
  	//Metrics.EditMetrics.update(metrics);
  	console.log(metrics);
  	$location.path('/');
    $window.location.reload();
}
            }]
            });
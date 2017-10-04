'use strict';

angular.
    module('addEvent')
    .config(function($mdThemingProvider) {
        $mdThemingProvider.theme('docs-dark', 'default')
          .primaryPalette('orange')
          .dark();
      }).
        component('addEvent', {
        templateUrl: 'app/Edit/add-event/add-event.template.html',
        controller: ['Timeline', 'JWToken','$scope','$http','$window',
            function AddEventController(Timeline,JWToken,$scope,$http,$window) {
               var self = this;


			if (JWToken.getToken()) {
                    JWToken.getTokenBody(JWToken.getToken()).then(function(tknResult) {
                    self.tokenBody = JSON.parse(tknResult);
});
}
self.setEvent=function(){

				var event=JSON.stringify({
                     userId :        self.tokenBody.sub,
                     dateOfEvent :     self.event.dateOfEvent,
                     title :		 self.event.title,
                     description : 	  self.event.description
                     });

Timeline.EditEvents.update(event);
console.log(event);
}
}]
});

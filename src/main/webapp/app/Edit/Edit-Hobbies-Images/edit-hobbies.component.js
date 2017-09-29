'use strict';

angular.
    module('editMyHobbies').
        component('editMyHobbies', {
        templateUrl: 'app/Edit/Edit-Hobbies-Images/edit-hobbies.template.html',
        controller: ['Account','Hobby', 'Authorization', 'JWToken','$scope','$http','$resource',
            function EditMyHobbiesController(Account,Hobby, Authorization,JWToken,$scope,$http,$resource) {
               var self = this;

  $scope.models = {
        selected: null,
        lists: {"All": [],"User": [] }
    };

				if (JWToken.getToken()) {
                    JWToken.getTokenBody(JWToken.getToken()).then(function(tknResult) {
                    self.tokenBody = JSON.parse(tknResult);
                        self.userHobbies = Hobby.UserHobbies.query({userId: self.tokenBody.sub});
                        self.userHobbies.$promise.then(function(hobbiesResult) {
                        self.userHobbies = hobbiesResult;
                        angular.forEach(hobbiesResult,function(hobby){
                        $scope.models.lists.User.push({label:  hobby.name});
                        });
                        }, function() {
                        	console.log("Failed to retrieve hobbies for user with userId: " + self.tokenBody.sub);
                        });

                    }, function() {
                        console.error("Couldn't retrieve JWT body");
                    });
                }

  	self.allHobbies = Hobby.HobbyList.query(function(allHobbies) {
  	$scope.allHobbies = allHobbies;
  	angular.forEach(allHobbies,function(hobby){
  	$scope.models.lists.All.push({label:  hobby.name});

  	});
  	}, function() {
    console.log("Failed to retrieve hobbies for user with userId: " + self.tokenBody.sub);
 	 });

    $scope.$watch('models', function(model) {

           $scope.modelAsJson = angular.toJson(model.lists.User, true);
   		   $scope.list = [];
           var keys = _.keys(model.lists.User);
   		   _.forEach(keys, function(key){
           var hobbyFound = _.find($scope.allHobbies, function(hobby) {
           		return hobby.name == model.lists.User[key].label;
           	});
           	$scope.list.push(hobbyFound);
           });
           self.setUserHobbies=function(){
           $http.post("api/hobby/edit/"+self.tokenBody.sub,$scope.list);
           }
           console.log($scope.list);
           }, true);

  }]
});

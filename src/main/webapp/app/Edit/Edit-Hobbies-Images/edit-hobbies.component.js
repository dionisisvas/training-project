'use strict';

angular.
    module('editMyHobbies').
        component('editMyHobbies', {
        templateUrl: 'app/Edit/Edit-Hobbies-Images/edit-hobbies.template.html',
        controller: ['Account','Hobby', 'Authorization', 'JWToken','$scope',
            function EditMyHobbiesController(Account,Hobby, Authorization,JWToken,$scope) {
               var self = this;

  $scope.models = {
        selected: null,
        lists: {"All": [],"User": [] }
    };
     $scope.hobbyArray=[];
				if (JWToken.getToken()) {
                    JWToken.getTokenBody(JWToken.getToken()).then(function(tknResult) {
                    self.tokenBody = JSON.parse(tknResult);
                        self.userHobbies = Hobby.UserHobbies.query({userId: self.tokenBody.sub});
                        self.userHobbies.$promise.then(function(hobbiesResult) {
                        self.userHobbies = hobbiesResult;
                        angular.forEach(hobbiesResult,function(hobby){
                        $scope.models.lists.User.push({label:  hobby.name});
                        $scope.hobbyArray.push({id:self.tokenBody.sub,hobbyId:hobby.hobbyId});

                        });
console.log($scope.hobbyArray);
                        }, function() {
                        	console.log("Failed to retrieve hobbies for user with userId: " + self.tokenBody.sub);
                        });

                        /*  angular.forEach($scope.models.lists.User,function(items){
                          $scope.hobbyArray.push({id:self.tokenBody.sub,hobbyName:items})

                          });*/
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
           console.log($scope.modelAsJson);
           var keys = _.keys(model.lists.User);
   		_.forEach(keys, function(key){
           	var hobbyFound = _.find($scope.allHobbies, function(hobby) {
           		return hobby.name == model.lists.User[key].label;
           	});
           	//list.push({id:self.tokenBody.sub,hobbyId:hobbyFound.id})
           	list.push(hobbyFound);
           });

       }, true);
   //   hobbyArray =$scope.list;
   //     Hobby.EditHobby.save(hobbyArray);
   //     console.log(hobbyArray);

               }]
});

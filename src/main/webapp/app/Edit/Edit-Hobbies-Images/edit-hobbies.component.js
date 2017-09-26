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
        lists: {"A": [], "B": []}
    };
				if (JWToken.getToken()) {
                    JWToken.getTokenBody(JWToken.getToken()).then(function(tknResult) {
                    self.tokenBody = JSON.parse(tknResult);
                        self.userHobbies = Hobby.UserHobbies.query({userId: self.tokenBody.sub});
                        self.userHobbies.$promise.then(function(hobbiesResult) {
                        self.userHobbies = hobbiesResult;
                        angular.forEach(hobbiesResult,function(hobby){
                        $scope.models.lists.A.push({label: "Item " + hobby.hobbyName});
                        });

                        }, function() {
                        	console.log("Failed to retrieve hobbies for user with userId: " + self.tokenBody.sub);
                        });
                    }, function() {
                        console.error("Couldn't retrieve JWT body");
                    });
                }



    // Generate initial model
    for (var i = 1; i <= 3; ++i) {

        $scope.models.lists.B.push({label: "Item B" + i});
    }
    // Model to JSON for demo purpose
    $scope.$watch('models', function(model) {
        $scope.modelAsJson = angular.toJson(model, true);
    }, true);


            }]
        });

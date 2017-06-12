(function(angular) {
 'use strict';
 var app=angular.module('myApp',[ngResource])

  	component('myApp', {
    templateUrl: 'app/user-create/index.html',
controller:function CreateController(){
    $scope.create = function(){
    	User = $resource(
    		    "http://localhost:8080/spring/api/user/create",
    		    {},
    		    {save: {method:'PUT',isArray:false}}
    	);

    	var user = {};

		user.username = $scope.personForm.username;
		user.userId = $scope.personForm.userId;
		user.name = $scope.personForm.name;
		user.surname = $scope.personForm.surname;
		user.age = $scope.personForm.age;
		user.dob = $scope.personForm.dob;
		user.phoneNo = $scope.personForm.phoneNo;
		user.address = $scope.personForm.address;
		user.password = $scope.personForm.password;
		user.confirmPassword = "";


		$scope.personForm.username = "";
		$scope.personForm.userId="";
		$scope.personForm.name="";
		$scope.personForm.surname="";
		$scope.personForm.age="";
		$scope.personForm.dob="";
		$scope.personForm.phoneNo="";
		$scope.personForm.address="";
		$scope.personForm.password="";


}
}
});
});

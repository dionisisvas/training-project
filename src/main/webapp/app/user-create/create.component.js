'use strict';
angular.
	module('myApp',['ngRoute']).
	component('myApp', {
		templateUrl: 'app/user-create/index.html',
		controller: ['$scope', '$http',
		function CreateController($scope, $http) {

        $scope.send_form = function () {



    	var user =JSON.stringify({
		username : $scope.username,
		userId : $scope.userId,
		name : $scope.name,
		surname : $scope.surname,
		age : $scope.age,
		dob : $scope.dob,
		phoneNo : $scope.phoneNo,
		address : $scope.address,
		password : $scope.password


});
$http.put('http://localhost:8080/spring/api/user/create',user);
}
 $scope.validatePassword=function () {
 jQuery.validator.setDefaults({
  debug: true,
  success: "valid"
});
            var validator = $("#myform").validate({
                    rules: {
            password : {
                            minlength : 5
                        },
            password_again: { minlength : 5,
                            equalTo : "#password"
            }
          }
                });
                if (validator.form()) {
                    alert('Sucess');
                }
            }
}]
});


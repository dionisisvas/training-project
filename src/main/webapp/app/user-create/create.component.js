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

});
$http.put('http://localhost:8080/spring/api/user/create',user);
}
}]
});


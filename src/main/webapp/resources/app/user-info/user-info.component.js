'use strict';

angular.
	module('myUserInfo').
	component('myUserInfo', {
		templateUrl: 'resources/app/user-info/user-info.template.html',
		controller: ['$routeParams', function UserInfoController($routeParams) {
			this.userId = $routeParams.userId;
		}]
	});
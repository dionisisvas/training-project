'use strict';

angular.
	module('myOptionList').
	component('myOptionList', {
		templateUrl: 'resources/app/option-list/option-list.template.html',
		controller: function OptionListController() {
			this.pageOptions = [
				{
					param: null,
					dir: '',
					info: 'home dir'
				}, {
					param: null,
					dir: 'user',
					info: 'user list'
				}, {
					param: 'userId',
					dir: 'user',
					info: 'specific user info'
				}, {
					param: null,
					dir: 'error',
					info: 'default not found landing page'
				}
			];
			this.restOptions = [
				{
					param: null,
					dir: 'user',
					dir2: null,
					info: 'get the user list'
				}, {
					param: 'userId',
					dir: 'user',
					dir2: null,					
					info: 'get user by id'
				}, {
					param: 'imgId',
					dir: 'image',
					dir2: null,					
					info: 'get image by its id'
				}, {
					param: 'userId',
					dir: 'image/user',
					dir2: null,					
					info: 'get images by a user id'
				}, {
					param: 'userId',
					dir: 'image/user',
					dir2: '/profile',					
					info: 'get a user\'s profile image'
				}, {
					param: null,
					dir: 'hobby',
					dir2: null,					
					info: 'get a list of all hobbies'
				}, {
					param: 'hobbyId',
					dir: 'hobby',
					dir2: null,					
					info: 'get hobby by its id'
				}, {
					param: 'userId',
					dir: 'hobby/user',
					dir2: null,					
					info: 'get hobbies by a user id'
				}
			];			
		}
	});

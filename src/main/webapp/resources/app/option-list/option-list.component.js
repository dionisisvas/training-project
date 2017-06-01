'use strict';

angular.
	module('myOptionList').
	component('myOptionList', {
		templateUrl: 'resources/app/option-list/option-list.template.html',
		controller: function OptionListController() {
			this.options = [
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
					param: 'imgId',
					dir: 'image',
					info: 'show specific image'
				}, {
					param: 'userId',
					dir: 'image/list',
					info: 'show user\'s images'
				}, {
					param: 'userId',
					dir: 'image/profile',
					info: 'show user\'s profile image'
				}, {
					param: null,
					dir: 'error',
					info: 'default not found landing page'
				}
			];
		}
	});

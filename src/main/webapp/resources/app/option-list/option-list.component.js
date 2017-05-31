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
					param: 'id',
					dir: 'user',
					info: 'specific user info'
				}, {
					param: null,
					dir: 'error',
					info: 'default not found landing page'
				}
			];
		}
	});

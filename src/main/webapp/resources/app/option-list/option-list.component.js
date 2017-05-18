'use strict';

angular.
	module('myOptionList').
	component('myOptionList', {
		templateUrl: 'resources/app/option-list/option-list.template.html',
		controller: function OptionListController() {
			this.options = [
				{
					name: null,
					dir: '',
					info: 'home dir'
				}, {
					name: null,
					dir: 'user',
					info: 'user list'
				}, {
					name: 'id',
					dir: 'user',
					info: 'user list'
				}, {
					name: null,
					dir: 'error',
					info: 'default not found landing page'
				}
			];
		}
	});

'use strict';

angular.
	module('optionList').
	component('optionList', {
		templateUrl: 'resources/app/option-list/option-list.template.html',
		controller: function OptionListController() {
			this.options = [
				{
					id: '0',
					name: 'name',
					dir: 'hello',
					info: 'any string will do'
				}, {
					id: '1',
					name: 'id',
					dir: 'user',
					info: 'long, id = 5 for mock user'
				},
			];
		}
	});

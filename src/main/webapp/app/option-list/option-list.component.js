'use strict';

angular.
	module('myOptionList').
	component('myOptionList', {
		templateUrl: 'app/option-list/option-list.template.html',
		controller: ['Option',
			function OptionListController(Option) {
				var self = this;
				
				self.options = Option.query();				
		}]
	});

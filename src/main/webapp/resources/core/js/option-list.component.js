'use strict';

angular.
	module('trainingApp').
	component('optionList', {
		template:
			'<h4>Options:</h4>' +
			'<ul>' +
				'<li ng-repeat="option in $ctrl.options">' +
					'<b>*/{{option.dir}}/</span>' +
					'<em>{{option.name}}</em>' +
					'  -  {{option.info}}'
				'</li>' +
			'</ul>',
		controller: function OptionListController() {
		  this.options = [
			{
				name: 'name',
				dir: 'hello',
				info: 'any string will do'
			}, {
				name: 'id',
				dir: 'user',
				info: 'long, id = 5 for mock user'
			}
		  ];
		}
	});

'use strict';

angular.
    module('core.hobby').
    factory('Hobby', ['$resource',
        function($resource) {
            return {
                Hobby: $resource('api/hobby/:hobbyId'),
                HobbyList: $resource('api/hobby/list'),
                UserHobbies: $resource('api/hobby/user/:userId', {}, {
                    query: {
                        method: 'GET',
                        isArray: true
                    }
                }),
                EditHobby: $resource('api/hobby/edit')
            };
        }
    ]);


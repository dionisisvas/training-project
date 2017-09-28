'use strict';

angular.
    module('core.post').
    factory('Post', ['$resource',
        function($resource) {
            return {
                Post: $resource('api/post/:postId', {
                    params: {
                        getComments:'@getComments'
                    }
                }),
                PostsBySubject: $resource('api/post/subject/:subjectType/:subjectId', {
                    params: {
                        getComments:'@getComments'
                    }
                }),
                PostsByPoster: $resource('api/post/poster/:posterId', {
                    params: {
                        getComments:'@getComments'
                    }
                })
            };
        }
    ]);

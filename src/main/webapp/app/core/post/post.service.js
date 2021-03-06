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
                }),
                AddPost: $resource('api/post/add'),
                DeletePost: $resource('api/post/:postId/delete'),
                EditPost: $resource('api/post/edit', {}, {
                     update: {
                        method: 'PUT'
                     }
                })
            };
        }
    ]);

'use strict';

angular.
    module('core.comment').
    factory('Comment', ['$resource',
        function($resource) {
            return {
                Comment: $resource('api/comment/:commentId', {
                    params: {
                        getComments:'@getComments'
                    }
                }),
                CommentsBySubject: $resource('api/comment/subject/:subjectType/:subjectId', {
                    params: {
                        getComments:'@getComments'
                    }
                }),
                AddComment: $resource('api/comment/add'),
                DeleteComment: $resource('api/comment/:commentId/delete'),
                EditComment: $resource('api/comment/edit')
            };
        }
    ]);

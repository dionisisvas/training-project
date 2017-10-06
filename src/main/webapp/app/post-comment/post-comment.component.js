'use strict';

angular.
    module('myPostComment').
    component('myPostComment', {
        templateUrl: 'app/post-comment/post-comment.template.html',
        controller: [
            function PostCommentController() {
                var self = this;

        }],
        bindings: {
          comment: '<'
        }
    });

'use strict';

angular.
    module('myPostComment').
    component('myPostComment', {
        templateUrl: 'app/post-comment/post-comment.template.html',
        controller: ['Comment', 'Image', 'JWToken', 'User',
            function PostCommentController(Comment, Image, JWToken, User) {
                var self = this;

                self.isCommentReply = self.isCommentReply || false;

                self.formatCommentData = function(comment) {
                    self.showReplies = false;
                    JWToken.isOwner(comment.posterId).then(function(res) {
                        comment.owner = res;
                    });

                    if (!self.isCommentReply) { // Replying depth is 1 comment
                        Comment.CommentsBySubject.query({
                            subjectType: 'COMMENT',
                            subjectId: comment.id,
                            getComments: true
                        }, function(commentsResult)  {
                            comment.comments = commentsResult;
                            self.repliesCounter = comment.comments.length;
                        }, function() {
                            console.log("Comment " + comment.id + " has no replies.");
                        });
                    }

                    comment.formattedCreationDate = (new Date(comment.creationDate[0],
                                                           comment.creationDate[1],
                                                           comment.creationDate[2],
                                                           comment.creationDate[3],
                                                           comment.creationDate[4],
                                                           comment.creationDate[5])).toLocaleString();

                    comment.formattedLastEditDate = (new Date(comment.lastEditDate[0],
                                                           comment.lastEditDate[1],
                                                           comment.lastEditDate[2],
                                                           comment.lastEditDate[3],
                                                           comment.lastEditDate[4],
                                                           comment.lastEditDate[5])).toLocaleString();

                    comment.poster = User.UserById.get({userId: comment.posterId});
                    comment.posterProfileImage = Image.ProfileImage.get({userId: comment.posterId}, function(imgResult){
                        comment.posterProfileImage = imgResult;
                    }, function() {
                        console.log("User " + comment.posterId + " has no profile image.");
                    });
                }

                self.toggleReplies = function() {
                    self.showReplies = !self.showComments;
                }

                self.formatCommentData(self.comment);
        }],
        bindings: {
          comment: '<',
          isCommentReply: '<'
        }
    }).
    config(
        function($compileProvider) {
            $compileProvider.preAssignBindingsEnabled(true);
    });

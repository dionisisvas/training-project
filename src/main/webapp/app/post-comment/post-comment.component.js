'use strict';

angular.
    module('myPostComment').
    component('myPostComment', {
        templateUrl: 'app/post-comment/post-comment.template.html',
        controller: ['$mdToast', '$routeParams', '$timeout', 'Comment', 'Image', 'JWToken', 'User',
            function PostCommentController($mdToast, $routeParams, $timeout, Comment, Image, JWToken, User) {
                var self = this;

                self.isProfileOwner = false;
                self.isCommentReply = self.isCommentReply || false;

                self.formatCommentData = function(comment) {
                    self.flipping = false;
                    self.editMode = false;
                    self.showReplies = false;
                    comment.deleted = false;

                    JWToken.isOwner(comment.posterId).then(function(res) {
                        comment.owner = res;
                    });

                    if (!self.isCommentReply) { // Replying depth is 2 comments
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

                self.deleteComment = function(id) {
                    Comment.DeleteComment.delete({commentId: id}, function() {
                        self.comment.deleted = true;

                        console.log("Comment with ID: " + id + " was deleted successfully.");
                    }, function() {
                        console.log("Comment with ID: " + id + " deletion failed.");
                    });
                }

                self.toggleEditComment = function() {
                    self.flipping = true;
                    self.editMode = !self.editMode;
                    $timeout(function() {
                        self.flipping = false;
                    }, 1000)
                }

                self.toggleReplies = function() {
                    self.showReplies = !self.showReplies;
                }

                JWToken.isOwner($routeParams.userId).then(function(res) {
                    self.isProfileOwner = res;
                });

                self.editComment = function(isValid) {
                    if (isValid) {
                        Comment.EditComment.update(self.comment, function(response) {
                            self.comment = response;

                            self.formatCommentData(self.comment);
                            self.editMode = true;
                            self.toggleEditComment();

                            console.log("Comment edited succesfully.");
                        }, function() {
                            $mdToast.show(
                                $mdToast.simple()
                                  .textContent('Editing comment failed...')
                                  .action('Dismiss')
                                  .highlightAction(true)
                                  .highlightClass('md-primary md-warn')
                                  .position('bottom center')
                                  .hideDelay(3000)
                            );
                        });
                    }
                };

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

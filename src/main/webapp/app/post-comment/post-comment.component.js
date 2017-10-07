'use strict';

angular.
    module('myPostComment').
    component('myPostComment', {
        templateUrl: 'app/post-comment/post-comment.template.html',
        controller: ['Image', 'JWToken', 'User',
            function PostCommentController(Image, JWToken, User) {
                var self = this;

                self.formatCommentData = function() {
                    JWToken.isOwner(self.comment.posterId).then(function(res) {
                        self.comment.owner = res;
                    });
                    self.comment.formattedCreationDate = (new Date(self.comment.creationDate[0],
                                                           self.comment.creationDate[1],
                                                           self.comment.creationDate[2],
                                                           self.comment.creationDate[3],
                                                           self.comment.creationDate[4],
                                                           self.comment.creationDate[5])).toLocaleString();

                    self.comment.formattedLastEditDate = (new Date(self.comment.lastEditDate[0],
                                                           self.comment.lastEditDate[1],
                                                           self.comment.lastEditDate[2],
                                                           self.comment.lastEditDate[3],
                                                           self.comment.lastEditDate[4],
                                                           self.comment.lastEditDate[5])).toLocaleString();

                    self.comment.poster = User.UserById.get({userId: self.comment.posterId});
                    self.comment.posterProfileImage = Image.ProfileImage.get({userId: self.comment.posterId}, function(imgResult){
                        self.comment.posterProfileImage = imgResult;
                    }, function() {
                        console.log("User " + self.comment.posterId + " has no profile image.");
                    });
                }

                self.formatCommentData();
        }],
        bindings: {
          comment: '<'
        }
    }).
    config(
        function($compileProvider) {
            $compileProvider.preAssignBindingsEnabled(true);
    });

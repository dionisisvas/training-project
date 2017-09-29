'use strict';

angular.
    module('myProfilePosts').
    component('myProfilePosts', {
        templateUrl: 'app/profile-posts/profile-posts.template.html',
        controller: ['$routeParams', 'Image', 'Post', 'User',
            function ProfilePostsController($routeParams, Image, Post, User) {
                var self = this;

                self.posts = Post.PostsBySubject.query({
                    subjectType: 'USER',
                    subjectId: $routeParams.userId,
                    getComments: true
                }, function()  {
                    angular.forEach(self.posts, function(post, key) {
                        post.formattedCreationDate = (new Date(post.creationDate[0],
                                                               post.creationDate[1],
                                                               post.creationDate[2],
                                                               post.creationDate[3],
                                                               post.creationDate[4],
                                                               post.creationDate[5])).toLocaleString();

                        post.formattedLastEditDate = (new Date(post.lastEditDate[0],
                                                               post.lastEditDate[1],
                                                               post.lastEditDate[2],
                                                               post.lastEditDate[3],
                                                               post.lastEditDate[4],
                                                               post.lastEditDate[5])).toLocaleString();

                        post.poster = User.UserById.get({userId: post.posterId});
                        post.posterProfileImage = Image.ProfileImage.get({userId: post.posterId}, function(imgResult){
                            post.posterProfileImage = imgResult;
                        }, function() {
                            console.log("User " + post.posterId + " has no profile image.");
                        });
                    });
                });
                self.user = User.UserById.get({userId: $routeParams.userId});
                self.profileImage = Image.ProfileImage.get({userId: $routeParams.userId});
        }]
    });

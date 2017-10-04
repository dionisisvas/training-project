'use strict';

angular.
    module('myProfilePosts').
    component('myProfilePosts', {
        templateUrl: 'app/profile-posts/profile-posts.template.html',
        controller: ['$routeParams', 'JWToken', 'Image', 'Post', 'User',
            function ProfilePostsController($routeParams, JWToken, Image, Post, User) {
                var self = this;

                self.isLoggedIn = false;
                self.isProfileOwner = false;
                self.isPostDeleted = [];
                self.postCounter = 0;

                self.user = User.UserById.get({userId: $routeParams.userId});
                self.posts = Post.PostsBySubject.query({
                    subjectType: 'USER',
                    subjectId: $routeParams.userId,
                    getComments: true
                }, function()  {
                    self.postCounter = self.posts.length;
                    angular.forEach(self.posts, function(post, key) {
                        self.isPostDeleted[key] = false;
                        JWToken.isOwner(post.posterId).then(function(res) {
                            post.owner = res;
                        });
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
                }, function() {
                    console.log("User " + $routeParams.userId + " has no posts.");
                });
                Image.ProfileImage.get({userId: $routeParams.userId}, function(imgRes) {
                    self.profileImage = imgRes;
                }, function() {
                    console.log("User " + $routeParams.userId + " has no profile image.");
                });

                JWToken.isLoggedIn().then(function(authResult) {
                    self.isLoggedIn = authResult;
                });

                JWToken.isOwner($routeParams.userId).then(function(res) {
                    self.isProfileOwner = res;
                });

                self.isPostOwner = function(id) {
                    return JWToken.isOwner(id);
                }
                self.deletePost = function(id, key) {
                    Post.DeletePost.delete({postId: id}, function() {
                        self.isPostDeleted[key] = true;
                        self.postCounter--;
                        self.posts.remove(key);
                        console.log("Post with post ID: " + id + " was deleted successfully." + self.posts.length);
                    }, function() {
                        console.log("Post with post ID: " + id + " deletion failed.");
                    });
                }
        }]
    });

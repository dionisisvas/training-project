'use strict';

angular.
    module('myProfilePosts').
    component('myProfilePosts', {
        templateUrl: 'app/profile-posts/profile-posts.template.html',
        controller: ['$mdToast', '$routeParams', '$timeout', '$scope', 'JWToken', 'Image', 'Post', 'User',
            function ProfilePostsController($mdToast, $routeParams, $timeout, $scope, JWToken, Image, Post, User) {
                var self = this;

                self.isLoggedIn = false;
                self.isProfileOwner = false;

                self.user = User.UserById.get({userId: $routeParams.userId});
                self.posts = Post.PostsBySubject.query({
                    subjectType: 'USER',
                    subjectId: $routeParams.userId,
                    getComments: true
                }, function()  {
                    angular.forEach(self.posts, function(post, key) {
                        self.formatPostData(post);
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

                self.formatPostData = function(post) {
                    post.flipping = false;
                    post.editMode = false;
                    post.deleted = false;
                    post.showComments = false;
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
                }

                self.isPostOwner = function(id) {
                    return JWToken.isOwner(id);
                }

                self.deletePost = function(id, key) {
                    Post.DeletePost.delete({postId: id}, function() {
                        self.posts[key].deleted = true;

                        console.log("Post with post ID: " + id + " was deleted successfully.");
                    }, function() {
                        console.log("Post with post ID: " + id + " deletion failed.");
                    });
                }

                self.submitPost = function(isValid) {
                    if (isValid) {
                        var tkn = JWToken.getToken();
                        JWToken.getTokenBody(tkn).then(function(tknBodyRes) {
                            var tknBody = JSON.parse(tknBodyRes);

                            self.newPost.posterId = tknBody.sub,
                            self.newPost.subjectType = 'USER',
                            self.newPost.subjectId = $routeParams.userId,


                            Post.AddPost.save(self.newPost, function(response) {
                                self.newPost.title = null;
                                self.newPost.content = null;
                                $scope.newPostForm.$setPristine();
                                $scope.newPostForm.$setUntouched();

                                self.posts.push(response);
                                self.formatPostData(self.posts[self.posts.length - 1], (self.posts.length - 1));

                                console.log("Post submitted succesfully.");
                            }, function() {
                                $mdToast.show(
                                    $mdToast.simple()
                                      .textContent('Submitting new post failed...')
                                      .action('Dismiss')
                                      .highlightAction(true)
                                      .highlightClass('md-primary md-warn')
                                      .position('bottom center')
                                      .hideDelay(3000)
                                );
                                console.log("Posting failed.");
                            });
                        });
                    }
                };

                self.toggleComments = function(key) {
                    self.posts[key].showComments = !self.posts[key].showComments;
                }

                self.toggleEditPost = function(id) {
                    self.posts[id].flipping = true;
                    self.posts[id].editMode = !self.posts[id].editMode;
                    $timeout(function() {
                        self.posts[id].flipping = false;
                    }, 1000)
                }

                self.editPost = function(isValid, key) {
                    if (isValid) {
                        Post.EditPost.update(self.posts[key], function(response) {
                            self.posts[key].title = response.title;
                            self.posts[key].content = response.content;
                            self.posts.lastEditDate = response.lastEditDate;
                            self.posts[key].formattedLastEditDate = (new Date(self.posts[key].lastEditDate[0],
                                                                              self.posts[key].lastEditDate[1],
                                                                              self.posts[key].lastEditDate[2],
                                                                              self.posts[key].lastEditDate[3],
                                                                              self.posts[key].lastEditDate[4],
                                                                              self.posts[key].lastEditDate[5])).toLocaleString();

                            self.toggleEditPost(key);

                            console.log("Post edited succesfully.");
                        }, function() {
                            $mdToast.show(
                                $mdToast.simple()
                                  .textContent('Editing post failed...')
                                  .action('Dismiss')
                                  .highlightAction(true)
                                  .highlightClass('md-primary md-warn')
                                  .position('bottom center')
                                  .hideDelay(3000)
                            );
                        });
                    }
                };
        }]
    });

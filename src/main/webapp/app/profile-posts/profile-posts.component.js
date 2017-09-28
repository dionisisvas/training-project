'use strict';

angular.
    module('myProfilePosts').
    component('myProfilePosts', {
        templateUrl: 'app/profile-posts/profile-posts.template.html',
        controller: ['$routeParams', 'Post', 'User',
            function ProfilePostsController($routeParams, Post, User) {
                var self = this;

                self.posts = Post.PostsBySubject.query({
                    subjectType: 'USER',
                    subjectId: $routeParams.userId,
                    getComments: true
                })                    
                self.user = User.UserById.get({userId: $routeParams.userId});
        }]
    });

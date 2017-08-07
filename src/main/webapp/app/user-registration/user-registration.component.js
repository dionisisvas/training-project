'use strict';

angular.
    module('myUserRegistration').
        component('myUserRegistration', {
        templateUrl: 'app/user-registration/user-registration.template.html',
        controller: ['$location', 'Account', 'JWToken', 'User',
            function UserRegistrationController($location, Account, JWToken, User) {
                function validateEmail(email) {
                    var rgx = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                    return rgx.test(email);
                }

                $(document).ready(function(){

                    $("#email").focusout(function() {
                        var email = $(this).val();
                        if (email == '') {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_email").text("* Please enter your email.");
                        }
                        else if (!validateEmail(email)) {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_email").text("* Not a valid email.");
                        }
                        else {
                            var self = $(this);
                            var tmpUser = Account.AccountByEmail.get({email: email});
                            tmpUser.$promise.then(function(accountResult) {
                                self.css("border-color", "#FF0000");
                                $('#submit').attr('disabled', true);
                                $("#error_email").text("* This email is already in use.");
                            }, function() {
                                self.css("border-color", "#2eb82e");
                                $('#submit').attr('disabled', false);
                                $("#error_email").text("");
                            });
                        }
                    });

                    $("#username").focusout(function() {
                        var username = $(this).val();
                        if (username == '') {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_username").text("* Please choose a username.");
                        }
                        else if (username.length < 3) {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_username").text("* The username must be at least 3 characters long.");
                        }
                        else if ( username.length > 24) {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_username").text("* The username must be at most 24 characters long.");
                        }
                        else if (username.match(/[\W]/)) {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_username").text("* The username can only contain alphanumerical characters.");
                        }
                        else {
                            var self = $(this);
                            var tmpUser = Account.AccountByUsername.get({username: username});
                            tmpUser.$promise.then(function(accountResult) {
                                self.css("border-color", "#FF0000");
                                $('#submit').attr('disabled', true);
                                $("#error_username").text("* This username is already in use.");
                            }, function() {
                                self.css("border-color", "#2eb82e");
                                $('#submit').attr('disabled', false);
                                $("#error_username").text("");
                            });
                        }
                    });

                    $("#name").focusout(function() {
                        if ($(this).val() == '') {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_name").text("* Please enter your first name.");
                        }
                        else {
                            $(this).css("border-color", "#2eb82e");
                            $('#submit').attr('disabled', false);
                            $("#error_name").text("");
                        }
                    });

                    $("#lastName").focusout(function() {
                        if ($(this).val() == '') {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_lastName").text("* Please enter your last name.");
                        }
                        else {
                            $(this).css("border-color", "#2eb82e");
                            $('#submit').attr('disabled', false);
                            $("#error_lastName").text("");
                        }
                    });

                    $("#dateOfBirth").focusout(function() {
                        if ($(this).val() == '') {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_dateOfBirth").text("* Please enter your date of birth.");
                        }
                        else {
                            $(this).css("border-color", "#2eb82e");
                            $('#submit').attr('disabled', false);
                            $("#error_dateOfBirth").text("");
                        }
                    });

                    $("#password").focusout(function() {
                        var pwd = $(this).val();
                        if (pwd == '') {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_password").text("* Please choose a password!");
                        }
                        else if (pwd.length < 8) {
                                $(this).css("border-color", "#FF0000");
                                $('#submit').attr('disabled', true);
                                $("#error_password").text("* The password should be at least 8 characters long.");
                                checkFailed = true;
                        }
                        else if (pwd.length > 64) {
                                $(this).css("border-color", "#FF0000");
                                $('#submit').attr('disabled', true);
                                $("#error_password").text("* The password should be at most 64 characters long.");
                                checkFailed = true;
                        }
                        else {
                            if (!pwd.match(/[A-Z]/) || !pwd.match(/[a-z]/) || !pwd.match(/\d/) || !pwd.match(/[\W]/)) {
                                $(this).css("border-color", "#FFFF00");
                                $('#submit').attr('disabled', false);
                                $("#warning_password").text("* Suggestion: your password should be mixed case with alphanumerical and symbol characters.");
                            }
                            else {
                                $(this).css("border-color", "#2eb82e");
                                $('#submit').attr('disabled', false);
                                $("#warning_password").text(""); 
                                $("#error_password").text("");
                            }
                        }
                    });

                    $("#passwordRepeat").focusout(function() {
                        var passwordRepeat = $(this).val();
                        if (passwordRepeat == '') {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_passwordRepeat").text("* Please repeat your password!");
                        }
                        else if (passwordRepeat != $('#password').val()) {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled', true);
                            $("#error_passwordRepeat").text("* Passwords don't match.");
                        }
                        else {
                            $(this).css("border-color", "#2eb82e");
                            $('#submit').attr('disabled', false);
                            $("#error_passwordRepeat").text("");
                        }
                    });

                    $("#submit").click(function() {  

                        var account = JSON.stringify({
                                    username :    $('#username').val(),
                                    password :    $('#password').val(),
                                    email:        $('#email').val()
                        });

                        var user = JSON.stringify({
                                    username :    $('#username').val(),
                                    name :        $('#name').val(),
                                    surname :     $('#lastName').val(),
                                    dateOfBirth : $('#dateOfBirth').val()
                        });

                        var dataWrapper = "{\"account\":" + account + ",\"user\":" + user + "}";

                        Account.Register.save(dataWrapper, function() {
                            console.log("Registration succeeded");

                            Account.Login.save(account, function(response) {
                                console.log("Login succeeded");
                                JWToken.setToken(response.token).then(function() {
                                    $location.path('/');
                                });
                            }, function(response) {
                                console.error("Login failed: " + response.data.message);
                            });
                        }, function(response) {
                            console.error("Registration failed: " + response.data.message);
                        });
                    });
            });
        }]
    });
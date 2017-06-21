'use strict';

angular.
	module('myUserRegistration',['ngRoute']).
	component('myUserRegistration', {
		templateUrl: 'app/user-registration/user-registration.template.html',
		controller: ['$scope', '$http',
            function UserRegistrationController($scope, $http) {
                $(document).ready(function(){

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
                        var checkFailed = false;
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
                        else {
                            if (!pwd.match(/[A-Z]/) || !pwd.match(/[a-z]/) || !pwd.match(/\d/)) {
                                $(this).css("border-color", "#FFFF00");
                                $('#submit').attr('disabled', false);
                                $("#warning_password").text("* Suggestion: your password should be mixed case alphanumerical.");
                            }   
                            else {
                                $(this).css("border-color", "#2eb82e");
                                $('#submit').attr('disabled', false);
                                $("#error_password").text("");                               
                            }
                            
                            pwdRepeat = $('#passwordRepeat').val();    
                            if (pwdRepeat != '') {
                                if (pwdRepeat != pwd) {
                                    $(this).css("border-color", "#FF0000");
                                    $('#submit').attr('disabled', true);
                                    $("#error_passwordRepeat").text("* Passwords don't match.");    
                                }
                                else {
                                    $(this).css("border-color", "#2eb82e");
                                    $('#submit').attr('disabled', false);
                                    $("#error_passwordRepeat").text("");                                      
                                }    
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
                        var user = JSON.stringify({
                                    username :    $('#username').val(),
                                    userId :      $('#userID').val(),
                                    name :        $('#myName').val(),
                                    surname :     $('#lastname').val(),
                                    dateOfBirth : $('#dateOfBirth').val(),
                                    phoneNo :     $('#phone').val(),
                                    address :     $('#address').val(),
                                    password :    $('#password').val()
                        });

                        $http.put('http://localhost:8080/spring/api/user/create',user);
                    });             
            });
        }]
    });
'use strict';
angular.
	module('myApp',['ngRoute']).
	component('myApp', {
		templateUrl: 'app/user-create/index.html',
		controller: ['$scope', '$http',
		function CreateController($scope, $http) {
$(document).ready(function(){

    	$("#myName").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_name").text("* You have to enter your first name!");
        	}
        	else
        	{
        		$(this).css("border-color", "#2eb82e");
        		$('#submit').attr('disabled',false);
        		$("#error_name").text("");

        	}
       });
        $("#lastname").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_lastname").text("* You have to enter your Last name!");
        	}
        	else
        	{
        		$(this).css("border-color", "#2eb82e");
        		$('#submit').attr('disabled',false);
        		$("#error_lastname").text("");
        	}
       });
        $("#dateOfBirth").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_dateOfBirth").text("* You have to enter your Date of Birth!");
        	}
        	else
        	{
        		$(this).css("border-color", "#2eb82e");
        		$('#submit').attr('disabled',false);
        		$("#error_dob").text("");
        	}
       });
        $("#gender").focusout(function(){
        	$(this).css("border-color", "#2eb82e");

       });
        $("#age").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_age").text("* You have to enter your Age!");
        	}
        	else
        	{
        		$(this).css({"border-color":"#2eb82e"});
        		$('#submit').attr('disabled',false);
        		$("#error_age").text("");
        	}
        	});
        $("#phone").focusout(function(){
            var pho =$("#phone").val();
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_phone").text("* You have to enter your Phone Number!");
        	}
        	else if (pho.length!=10)
        	{
                    $(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_phone").text("* Length of Phone Number Should Be Ten");
        	}
        	else if(!$.isNumeric(pho))
        	{
        	        $(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_phone").text("* Phone Number Should Be Numeric");
        	}
        	else{
        		$(this).css({"border-color":"#2eb82e"});
        		$('#submit').attr('disabled',false);
        		$("#error_phone").text("");
        	}

    	});
    	 $("#password").focusout(function(){
                    var password =$("#password").val();
            		if($(this).val()==''){
                		$(this).css("border-color", "#FF0000");
                			$('#submit').attr('disabled',true);
                			$("#error_password").text("* You have to enter your Password!");
                	}
                	else if (password.length<8)
                	{
                            $(this).css("border-color", "#FF0000");
                			$('#submit').attr('disabled',true);
                			$("#error_password").text("* Length of Password Should Be At Least 8");
                	}
                	else if(!password.match(/[A-Z]/))
                	{
                	        $(this).css("border-color", "#FF0000");
                			$('#submit').attr('disabled',true);
                			$("#error_password").text("* At Least One Capital Letter");
                	}else if(!password.match(/[a-z]/))
                    {
                            $(this).css("border-color", "#FF0000");
                            $('#submit').attr('disabled',true);
                            $("#error_password").text("* At Least One Lowercase Letter");
                    }else if(!password.match(/\d/))
                     {
                    		 $(this).css("border-color", "#FF0000");
                    		 $('#submit').attr('disabled',true);
                             $("#error_password").text("* At Least One Number");
                     }else{
                		$(this).css({"border-color":"#2eb82e"});
                		$('#submit').attr('disabled',false);
                		$("#error_phone").text("");
                	}

            	});
            	$("#cpassword").focusout(function(){
            	var cpassword =$("#cpassword").val();
                    		if($(this).val()==''){
                        		$(this).css("border-color", "#FF0000");
                        			$('#submit').attr('disabled',true);
                        			$("#error_cpassword").text("* You have to enter Password Again!");
                        	}else if($('#password').val()!=$('#cpassword').val())
                             {
                               $(this).css("border-color", "#FF0000");
                               $('#submit').attr('disabled',true);
                               $("#error_cpassword").text("* Wrong Password");
                             }
                        	else
                        	{
                        		$(this).css("border-color", "#2eb82e");
                        		$('#submit').attr('disabled',false);
                        		$("#error_cpassword").text("");
                        	}
                       });

   		$( "#submit" ).click(function() {
   			if($("#myName" ).val()=='')
   			{
        		$("#myName").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_name").text("* You have to enter your first name!");
        	}
        	if($("#lastname" ).val()=='')
   			{
        		$("#lastname").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_lastname").text("* You have to enter your Last name!");
        	}
   			if($("#dateOfBirth" ).val()=='')
   			{
        		$("#dateOfBirth").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#dateOfBirth").text("* You have to enter your Date of Birth!");
        	}
   			if($("#age" ).val()=='')
   			{
        		$("#age").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_age").text("* You have to enter your Age!");
        	}
        	if($("#phone" ).val()=='')
   			{
        		$("#phone").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_phone").text("* You have to enter your Phone Number!");
        	}
        	var user =JSON.stringify({
                		username : $('#username').val(),
                		userId :  $('#userID').val(),
                		name :  $('#myName').val(),
                		surname :  $('#lastname').val(),
                		dateOfBirth :  $('#dateOfBirth').val(),
                		phoneNo :  $('#phone').val(),
                		address :  $('#address').val(),
                		password : $('#password').val()

                });

                $http.put('http://localhost:8080/spring/api/user/create',user);

			});
	});

}]
});
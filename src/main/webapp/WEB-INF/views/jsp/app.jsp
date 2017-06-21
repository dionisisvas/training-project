<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="trainingApp">
	<head>
		<meta charset="utf-8">
		<base href="/home/">
		<title>IRI Training Project</title>

		<spring:url value="/resources/css/app.css" var="appCss" />
		<spring:url value="/resources/css/app.animation.css" var="appAnimationCss" />
		<spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />

		<link href="${bootstrapCss}" rel="stylesheet" />
		<link href="${appCss}" rel="stylesheet" />
		<link href="${appAnimationCss}" rel="stylesheet" />

        <spring:url value="/resources/lib/angular/angular.js" var="angularJs" />
        <spring:url value="/resources/lib/angular/angular-animate.js" var="angularAnimateJs" />
        <spring:url value="/resources/lib/angular/angular-resource.js" var="angularResourceJs" />		
        <spring:url value="/resources/lib/angular/angular-route.js" var="angularRouteJs" />
        <spring:url value="/app/app.module.js" var="appModuleJs" />
        <spring:url value="/app/app.config.js" var="appConfigJs" />
        <spring:url value="/app/core/core.module.js" var="coreModuleJs" />
        <spring:url value="/app/core/hobby/hobby.module.js" var="hobbyModuleJs" />
        <spring:url value="/app/core/hobby/hobby.service.js" var="hobbyServiceJs" />	
        <spring:url value="/app/core/image/image.module.js" var="imageModuleJs" />
        <spring:url value="/app/core/image/image.service.js" var="imageServiceJs" />
        <spring:url value="/app/core/option/option.module.js" var="optionModuleJs" />
        <spring:url value="/app/core/option/option.service.js" var="optionServiceJs" />
        <spring:url value="/app/core/user/user.module.js" var="userModuleJs" />
        <spring:url value="/app/core/user/user.service.js" var="userServiceJs" />
        <spring:url value="/app/error-message/error-message.module.js" var="errorMessageModuleJs" />
        <spring:url value="/app/error-message/error-message.component.js" var="errorMessageComponentJs" />
        <spring:url value="/app/home-page/home-page.module.js" var="homePageModuleJs" />
        <spring:url value="/app/home-page/home-page.component.js" var="homePageComponentJs" />
        <spring:url value="/app/nav-bar/nav-bar.module.js" var="navBarModuleJs" />
        <spring:url value="/app/nav-bar/nav-bar.component.js" var="navBarComponentJs" />       
        <spring:url value="/app/option-list/option-list.module.js" var="optionListModuleJs" />
        <spring:url value="/app/option-list/option-list.component.js" var="optionListComponentJs" />
        <spring:url value="/app/user-list/user-list.module.js" var="userListModuleJs" />
        <spring:url value="/app/user-list/user-list.component.js" var="userListComponentJs" />
        <spring:url value="/app/user-info/user-info.module.js" var="userInfoModuleJs" />
        <spring:url value="/app/user-info/user-info.component.js" var="userInfoComponentJs" />
        <spring:url value="/app/user-create/create.module.js" var="createModuleJs" />
        <spring:url value="/app/user-create/create.component.js" var="userCreateComponentJs" />

        <script
            src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
            crossorigin="anonymous"></script>
        <script 
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
            crossorigin="anonymous"></script>        
        <script src="${angularJs}"></script>
        <script src="${angularAnimateJs}"></script>
        <script src="${angularResourceJs}"></script>
        <script src="${angularRouteJs}"></script>
        <script src="${coreModuleJs}"></script>		
        <script src="${appModuleJs}"></script>
        <script src="${appConfigJs}"></script>
        <script src="${hobbyModuleJs}"></script>
        <script src="${hobbyServiceJs}"></script>		
        <script src="${imageModuleJs}"></script>
        <script src="${imageServiceJs}"></script>	
        <script src="${optionModuleJs}"></script>
        <script src="${optionServiceJs}"></script>		
        <script src="${userModuleJs}"></script>
        <script src="${userServiceJs}"></script>
        <script src="${errorMessageModuleJs}"></script>
        <script src="${errorMessageComponentJs}"></script>		
        <script src="${homePageModuleJs}"></script>
        <script src="${homePageComponentJs}"></script>		
        <script src="${navBarModuleJs}"></script>
        <script src="${navBarComponentJs}"></script>	        
        <script src="${optionListModuleJs}"></script>
        <script src="${optionListComponentJs}"></script>
        <script src="${userListModuleJs}"></script>
        <script src="${userListComponentJs}"></script>
        <script src="${userInfoModuleJs}"></script>
        <script src="${userInfoComponentJs}"></script>
        <script src="${createModuleJs}"></script>
        <script src="${userCreateComponentJs}"></script>
	</head>

	<body>
		<div class="view-container">
			<div ng-view class="view-frame"></div>
		</div>
	</body>
</html>

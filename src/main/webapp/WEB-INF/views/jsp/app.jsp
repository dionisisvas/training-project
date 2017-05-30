<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="trainingApp">
	<head>
		<meta charset="utf-8">
		<base href="/spring/">
		<title>Training Project</title>

		<spring:url value="/resources/app/css/app.css" var="appCss" />
		<spring:url value="/resources/app/css/app.animation.css" var="appAnimationCss" />
		<spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />

		<link href="${bootstrapCss}" rel="stylesheet" />
		<link href="${appCss}" rel="stylesheet" />
		<link href="${appAnimationCss}" rel="stylesheet" />
		
		<spring:url value="/resources/lib/angular/angular.js" var="angularJs" />
		<spring:url value="/resources/lib/angular/angular-animate.js" var="angularAnimateJs" />
		<spring:url value="/resources/lib/angular/angular-resource.js" var="angularResourceJs" />		
		<spring:url value="/resources/lib/angular/angular-route.js" var="angularRouteJs" />
		<spring:url value="/resources/app/app.module.js" var="appModuleJs" />
		<spring:url value="/resources/app/app.config.js" var="appConfigJs" />
		<spring:url value="/resources/app/core/core.module.js" var="coreModuleJs" />		
		<spring:url value="/resources/app/core/user/user.module.js" var="userModuleJs" />
		<spring:url value="/resources/app/core/user/user.service.js" var="userServiceJs" />
		<spring:url value="/resources/app/error-message/error-message.module.js" var="errorMessageModuleJs" />
		<spring:url value="/resources/app/error-message/error-message.component.js" var="errorMessageComponentJs" />
		<spring:url value="/resources/app/option-list/option-list.module.js" var="optionListModuleJs" />
		<spring:url value="/resources/app/option-list/option-list.component.js" var="optionListComponentJs" />
		<spring:url value="/resources/app/user-list/user-list.module.js" var="userListModuleJs" />
		<spring:url value="/resources/app/user-list/user-list.component.js" var="userListComponentJs" />
		<spring:url value="/resources/app/user-info/user-info.module.js" var="userInfoModuleJs" />
		<spring:url value="/resources/app/user-info/user-info.component.js" var="userInfoComponentJs" />

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${angularJs}"></script>
		<script src="${angularAnimateJs}"></script>
		<script src="${angularResourceJs}"></script>
		<script src="${angularRouteJs}"></script>
		<script src="${coreModuleJs}"></script>		
		<script src="${appModuleJs}"></script>
		<script src="${appConfigJs}"></script>	
		<script src="${userModuleJs}"></script>
		<script src="${userServiceJs}"></script>
		<script src="${errorMessageModuleJs}"></script>
		<script src="${errorMessageComponentJs}"></script>		
		<script src="${optionListModuleJs}"></script>
		<script src="${optionListComponentJs}"></script>
		<script src="${userListModuleJs}"></script>
		<script src="${userListComponentJs}"></script>
		<script src="${userInfoModuleJs}"></script>
		<script src="${userInfoComponentJs}"></script>
	</head>

	<body>
		<div class="view-container">
			<div ng-view class="view-frame"></div>
		</div>
	</body>
</html>

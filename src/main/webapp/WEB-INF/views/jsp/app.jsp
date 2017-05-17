<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="trainingApp">
	<head>
		<meta charset="utf-8">
		<base href="/spring/">
		<title>Training Project</title>

		<spring:url value="/resources/css/app.css" var="appCss" />
		<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />

		<link href="${bootstrapCss}" rel="stylesheet" />
		<link href="${appCss}" rel="stylesheet" />

		<spring:url value="/resources/angular/angular.js" var="angularJs" />
		<spring:url value="/resources/angular/angular-route.js" var="angularRouteJs" />
		<spring:url value="/resources/app/app.module.js" var="appModuleJs" />
		<spring:url value="/resources/app/app.config.js" var="appConfigJs" />
		<spring:url value="/resources/app/option-list/option-list.module.js" var="optionListModuleJs" />
		<spring:url value="/resources/app/option-list/option-list.component.js" var="optionListComponentJs" />
		<spring:url value="/resources/app/user-list/user-list.module.js" var="userListModuleJs" />
		<spring:url value="/resources/app/user-list/user-list.component.js" var="userListComponentJs" />
		<spring:url value="/resources/app/user-info/user-info.module.js" var="userInfoModuleJs" />
		<spring:url value="/resources/app/user-info/user-info.component.js" var="userInfoComponentJs" />

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${angularJs}"></script>
		<script src="${angularRouteJs}"></script>
		<script src="${appModuleJs}"></script>
		<script src="${appConfigJs}"></script>
		<script src="${optionListModuleJs}"></script>
		<script src="${optionListComponentJs}"></script>
		<script src="${userListModuleJs}"></script>
		<script src="${userListComponentJs}"></script>
		<script src="${userInfoModuleJs}"></script>
		<script src="${userInfoComponentJs}"></script>
	</head>

	<body>
		<div ng-view></div>
	</body>
</html>

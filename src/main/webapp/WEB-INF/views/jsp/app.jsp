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
        <link rel="stylesheet"  href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">

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
        <spring:url value="/app/core/metrics/metrics.module.js" var="metricsModuleJs" />
        <spring:url value="/app/core/metrics/metrics.service.js" var="metricsServiceJs" />
        <spring:url value="/app/core/option/option.module.js" var="optionModuleJs" />
        <spring:url value="/app/core/option/option.service.js" var="optionServiceJs" />
        <spring:url value="/app/core/user/user.module.js" var="userModuleJs" />
        <spring:url value="/app/core/user/user.service.js" var="userServiceJs" />
        <spring:url value="/app/error-page/error-page.module.js" var="errorPageModuleJs" />
        <spring:url value="/app/error-page/error-page.component.js" var="errorPageComponentJs" />
        <spring:url value="/app/home-page/home-page.module.js" var="homePageModuleJs" />
        <spring:url value="/app/home-page/home-page.component.js" var="homePageComponentJs" />
        <spring:url value="/app/nav-bar/nav-bar.module.js" var="navBarModuleJs" />
        <spring:url value="/app/nav-bar/nav-bar.component.js" var="navBarComponentJs" />       
        <spring:url value="/app/option-list/option-list.module.js" var="optionListModuleJs" />
        <spring:url value="/app/option-list/option-list.component.js" var="optionListComponentJs" />
        <spring:url value="/app/user-list/user-list.module.js" var="userListModuleJs" />
        <spring:url value="/app/user-list/user-list.component.js" var="userListComponentJs" />            
        <spring:url value="/app/user-login/user-login.module.js" var="userLoginModuleJs" />
        <spring:url value="/app/user-login/user-login.component.js" var="userLoginComponentJs" />        
        <spring:url value="/app/user-info/user-info.module.js" var="userInfoModuleJs" />
        <spring:url value="/app/user-info/user-info.component.js" var="userInfoComponentJs" />        
        <spring:url value="/app/user-registration/user-registration.module.js" var="userRegistrationModuleJs" />
        <spring:url value="/app/user-registration/user-registration.component.js" var="userRegistrationComponentJs" />
        <spring:url value="/app/user-statistics/user-statistics.module.js" var="userStatisticsModuleJs" />
        <spring:url value="/app/user-statistics/user-statistics.component.js" var="userStatisticComponentJs" />

        <script
            src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
            crossorigin="anonymous"></script>
        <script 
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
            crossorigin="anonymous"></script>
            <script  src="https://www.gstatic.com/charts/loader.js"></script>
            <script src="//code.jquery.com/jquery-1.12.4.js" ></script>
            <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js" ></script>
            <script src="https://cdn.datatables.net/rowreorder/1.0.0/js/dataTables.rowReorder.js"></script>
        <script src="${angularJs}"></script>
        <script src="${angularAnimateJs}"></script>
        <script src="${angularResourceJs}"></script>
        <script src="${angularRouteJs}"></script>
        <script src="${coreModuleJs}"></script>		
        <script src="${appModuleJs}"></script>
        <script src="${appConfigJs}"></script>
        <script src="${hobbyModuleJs}"></script>
        <script src="${hobbyServiceJs}"></script>
        <script src="${metricsModuleJs}"></script>
        <script src="${metricsServiceJs}"></script>
        <script src="${imageModuleJs}"></script>
        <script src="${imageServiceJs}"></script>	
        <script src="${optionModuleJs}"></script>
        <script src="${optionServiceJs}"></script>		
        <script src="${userModuleJs}"></script>
        <script src="${userServiceJs}"></script>
        <script src="${errorPageModuleJs}"></script>
        <script src="${errorPageComponentJs}"></script>		
        <script src="${homePageModuleJs}"></script>
        <script src="${homePageComponentJs}"></script>		
        <script src="${navBarModuleJs}"></script>
        <script src="${navBarComponentJs}"></script>	        
        <script src="${optionListModuleJs}"></script>
        <script src="${optionListComponentJs}"></script>
        <script src="${userListModuleJs}"></script>
        <script src="${userListComponentJs}"></script>
        <script src="${userLoginModuleJs}"></script>
        <script src="${userLoginComponentJs}"></script>        
        <script src="${userInfoModuleJs}"></script>
        <script src="${userInfoComponentJs}"></script>
        <script src="${userRegistrationModuleJs}"></script>
        <script src="${userRegistrationComponentJs}"></script>
        <script src="${userStatisticsModuleJs}"></script>
        <script src="${userStatisticComponentJs}"></script>
	</head>

	<body>
		<div class="view-container">
            <my-nav-bar></my-nav-bar>
			<div ng-view class="view-frame"></div>
		</div>
	</body>
</html>

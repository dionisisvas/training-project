<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="trainingApp">
  <head>
    <meta charset="utf-8">
    <base href="/">
    <meta name="description" content="An intern training application.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="resources/img/favicon.ico" type="image/x-icon" rel="shortcut icon"/>
    <link href="resources/img/favicon.ico" type="image/x-icon" rel="icon"/>
    <title>IRI Training Project</title>

    <spring:url value="/resources/css/app.css" var="appCss" />
    <spring:url value="/resources/css/simple.css" var="simpleCss" />
    <spring:url value="/resources/css/app.animation.css" var="appAnimationCss" />
    <spring:url value="/resources/css/timeline.css" var="timelineCss" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
    <link href="${appCss}" rel="stylesheet" />
    <link href="${simpleCss}" rel="stylesheet" />
    <link href="${appAnimationCss}" rel="stylesheet" />
    <link href="${timelineCss}" rel="stylesheet" />
  </head>

  <body ng-cloak>
    <div class="view-container" layout-fill>
      <div ng-view class="view-frame" layout="column" md-theme="myTheme" layout-fill></div>
    </div>

    <spring:url value="/app/app.module.js" var="appModuleJs" />
    <spring:url value="/app/app.config.js" var="appConfigJs" />
    <spring:url value="/app/core/core.module.js" var="coreModuleJs" />
    <spring:url value="/app/core/account/account.module.js" var="accountModuleJs" />
    <spring:url value="/app/core/account/account.service.js" var="accountServiceJs" />
    <spring:url value="/app/core/authorization/authorization.module.js" var="authorizationModuleJs" />
    <spring:url value="/app/core/authorization/authorization.service.js" var="authorizationServiceJs" />
    <spring:url value="/app/core/chart-info/chart-info.module.js" var="chartInfoModuleJs" />
    <spring:url value="/app/core/chart-info/chart-info.service.js" var="chartInfoServiceJs" />
    <spring:url value="/app/core/hobby/hobby.module.js" var="hobbyModuleJs" />
    <spring:url value="/app/core/hobby/hobby.service.js" var="hobbyServiceJs" />
    <spring:url value="/app/core/image/image.module.js" var="imageModuleJs" />
    <spring:url value="/app/core/image/image.service.js" var="imageServiceJs" />
    <spring:url value="/app/core/jwtoken/jwtoken.module.js" var="jwtokenModuleJs" />
    <spring:url value="/app/core/jwtoken/jwtoken.service.js" var="jwtokenServiceJs" />
    <spring:url value="/app/core/metrics/metrics.module.js" var="metricsModuleJs" />
    <spring:url value="/app/core/metrics/metrics.service.js" var="metricsServiceJs" />
    <spring:url value="/app/core/timeline/timeline.module.js" var="timelineModuleJs" />
    <spring:url value="/app/core/timeline/timeline.service.js" var="timelineServiceJs" />
    <spring:url value="/app/core/navlink/navlink.module.js" var="navlinkModuleJs" />
    <spring:url value="/app/core/navlink/navlink.service.js" var="navlinkServiceJs" />
    <spring:url value="/app/core/api-endpoint/api-endpoint.module.js" var="apiEndpointModuleJs" />
    <spring:url value="/app/core/api-endpoint/api-endpoint.service.js" var="apiEndpointServiceJs" />
    <spring:url value="/app/core/user/user.module.js" var="userModuleJs" />
    <spring:url value="/app/core/user/user.service.js" var="userServiceJs" />
    <spring:url value="/app/core/directives/email-unique/email-unique.module.js" var="emailUniqueModuleJs" />
    <spring:url value="/app/core/directives/email-unique/email-unique.directive.js" var="emailUniqueDirectiveJs" />
    <spring:url value="/app/core/directives/focus-on/focus-on.module.js" var="focusOnModuleJs" />
    <spring:url value="/app/core/directives/focus-on/focus-on.directive.js" var="focusOnDirectiveJs" />
    <spring:url value="/app/core/directives/focus-on/focus-on.service.js" var="focusOnServiceJs" />
    <spring:url value="/app/core/directives/password-repeat/password-repeat.module.js" var="passwordRepeatModuleJs" />
    <spring:url value="/app/core/directives/password-repeat/password-repeat.directive.js" var="passwordRepeatDirectiveJs" />
    <spring:url value="/app/core/directives/password-strength/password-strength.module.js" var="passwordStrengthModuleJs" />
    <spring:url value="/app/core/directives/password-strength/password-strength.directive.js" var="passwordStrengthDirectiveJs" />
    <spring:url value="/app/core/directives/username-unique/username-unique.module.js" var="usernameUniqueModuleJs" />
    <spring:url value="/app/core/directives/username-unique/username-unique.directive.js" var="usernameUniqueDirectiveJs" />
    <spring:url value="/app/about-card/about-card.module.js" var="aboutCardModuleJs" />
    <spring:url value="/app/about-card/about-card.component.js" var="aboutCardComponentJs" />
    <spring:url value="/app/auth-tabs/auth-tabs.module.js" var="authTabsModuleJs" />
    <spring:url value="/app/auth-tabs/auth-tabs.component.js" var="authTabsComponentJs" />
    <spring:url value="/app/api-endpoints-list/api-endpoints-list.module.js" var="apiEndpointsListModuleJs" />
    <spring:url value="/app/api-endpoints-list/api-endpoints-list.component.js" var="apiEndpointsListComponentJs" />
    <spring:url value="/app/error-card/error-card.module.js" var="errorCardModuleJs" />
    <spring:url value="/app/error-card/error-card.component.js" var="errorCardComponentJs" />
    <spring:url value="/app/greet-card/greet-card.module.js" var="greetCardModuleJs" />
    <spring:url value="/app/greet-card/greet-card.component.js" var="greetCardComponentJs" />
    <spring:url value="/app/tables/tables.module.js" var="tablesModuleJs" />
    <spring:url value="/app/tables/tables.component.js" var="tablesComponentJs" />
    <spring:url value="/app/legal-card/legal-card.module.js" var="legalCardModuleJs" />
    <spring:url value="/app/legal-card/legal-card.component.js" var="legalCardComponentJs" />
    <spring:url value="/app/login-prompt/login-prompt.module.js" var="loginPromptModuleJs" />
    <spring:url value="/app/login-prompt/login-prompt.component.js" var="loginPromptComponentJs" />
    <spring:url value="/app/sidenav/sidenav.module.js" var="sidenavModuleJs" />
    <spring:url value="/app/sidenav/sidenav.component.js" var="sidenavComponentJs" />
    <spring:url value="/app/toolbar/toolbar.module.js" var="toolbarModuleJs" />
    <spring:url value="/app/toolbar/toolbar.component.js" var="toolbarComponentJs" />
    <spring:url value="/app/user-list/user-list.module.js" var="userListModuleJs" />
    <spring:url value="/app/user-list/user-list.component.js" var="userListComponentJs" />
    <spring:url value="/app/login-card/login-card.module.js" var="loginCardModuleJs" />
    <spring:url value="/app/login-card/login-card.component.js" var="loginCardComponentJs" />
    <spring:url value="/app/profile-details/profile-details.module.js" var="profileDetailsModuleJs" />
    <spring:url value="/app/profile-details/profile-details.component.js" var="profileDetailsComponentJs" />
    <spring:url value="/app/profile-header/profile-header.module.js" var="profileHeaderModuleJs" />
    <spring:url value="/app/profile-header/profile-header.component.js" var="profileHeaderComponentJs" />
    <spring:url value="/app/profile-hobbies/profile-hobbies.module.js" var="profileHobbiesModuleJs" />
    <spring:url value="/app/profile-hobbies/profile-hobbies.component.js" var="profileHobbiesComponentJs" />
    <spring:url value="/app/profile-timeline/profile-timeline.module.js" var="profileTimelineModuleJs" />
    <spring:url value="/app/profile-timeline/profile-timeline.component.js" var="profileTimelineComponentJs" />
    <spring:url value="/app/registration-card/registration-card.module.js" var="registrationCardModuleJs" />
    <spring:url value="/app/registration-card/registration-card.component.js" var="registrationCardComponentJs" />
    <spring:url value="/app/user-maps/user-maps.module.js" var="userMapsModuleJs" />
    <spring:url value="/app/user-maps/user-maps.component.js" var="userMapsComponentJs" />
    <spring:url value="/app/user-statistics/user-statistics.module.js" var="userStatisticsModuleJs" />
    <spring:url value="/app/user-statistics/user-statistics.component.js" var="userStatisticComponentJs" />
    <spring:url value="/app/Edit/edit-account/edit-account.module.js" var="editAccountModuleJs" />
    <spring:url value="/app/Edit/edit-account/edit-account.component.js" var="editAccountComponentJs" />
    <spring:url value="/app/Edit/Edit-Hobbies-Images/edit-hobbies.module.js" var="editHobbiesModuleJs" />
    <spring:url value="/app/Edit/Edit-Hobbies-Images/edit-hobbies.component.js" var="editHobbiesComponentJs" />

    <script src="//cdnjs.cloudflare.com/ajax/libs/lodash.js/0.10.0/lodash.min.js"></script>
    <script
      src="https://code.jquery.com/jquery-1.12.4.min.js"
      integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
      crossorigin="anonymous"></script>
    <script src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular-cookies.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular-messages.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular-resource.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular-route.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-drag-and-drop-lists/2.1.0/angular-drag-and-drop-lists.js"></script>
    <script src="${coreModuleJs}"></script>
    <script src="${appModuleJs}"></script>
    <script src="${appConfigJs}"></script>
    <script src="${accountModuleJs}"></script>
    <script src="${accountServiceJs}"></script>
    <script src="${authorizationModuleJs}"></script>
    <script src="${authorizationServiceJs}"></script>
    <script src="${chartInfoModuleJs}"></script>
    <script src="${chartInfoServiceJs}"></script>
    <script src="${hobbyModuleJs}"></script>
    <script src="${hobbyServiceJs}"></script>
    <script src="${imageModuleJs}"></script>
    <script src="${imageServiceJs}"></script>
    <script src="${jwtokenModuleJs}"></script>
    <script src="${jwtokenServiceJs}"></script>
    <script src="${metricsModuleJs}"></script>
    <script src="${metricsServiceJs}"></script>
    <script src="${timelineModuleJs}"></script>
    <script src="${timelineServiceJs}"></script>
    <script src="${navlinkModuleJs}"></script>
    <script src="${navlinkServiceJs}"></script>
    <script src="${apiEndpointModuleJs}"></script>
    <script src="${apiEndpointServiceJs}"></script>
    <script src="${userModuleJs}"></script>
    <script src="${userServiceJs}"></script>
    <script src="${emailUniqueModuleJs}"></script>
    <script src="${emailUniqueDirectiveJs}"></script>
    <script src="${focusOnModuleJs}"></script>
    <script src="${focusOnDirectiveJs}"></script>
    <script src="${focusOnServiceJs}"></script>
    <script src="${passwordRepeatModuleJs}"></script>
    <script src="${passwordRepeatDirectiveJs}"></script>
    <script src="${passwordStrengthModuleJs}"></script>
    <script src="${passwordStrengthDirectiveJs}"></script>
    <script src="${usernameUniqueModuleJs}"></script>
    <script src="${usernameUniqueDirectiveJs}"></script>
    <script src="${aboutCardModuleJs}"></script>
    <script src="${aboutCardComponentJs}"></script>
    <script src="${authTabsModuleJs}"></script>
    <script src="${authTabsComponentJs}"></script>
    <script src="${errorCardModuleJs}"></script>
    <script src="${errorCardComponentJs}"></script>
    <script src="${greetCardModuleJs}"></script>
    <script src="${greetCardComponentJs}"></script>
    <script src="${tablesModuleJs}"></script>
    <script src="${tablesComponentJs}"></script>
    <script src="${legalCardModuleJs}"></script>
    <script src="${legalCardComponentJs}"></script>
    <script src="${loginPromptModuleJs}"></script>
    <script src="${loginPromptComponentJs}"></script>
    <script src="${apiEndpointsListModuleJs}"></script>
    <script src="${apiEndpointsListComponentJs}"></script>
    <script src="${sidenavModuleJs}"></script>
    <script src="${sidenavComponentJs}"></script>
    <script src="${toolbarModuleJs}"></script>
    <script src="${toolbarComponentJs}"></script>
    <script src="${userListModuleJs}"></script>
    <script src="${userListComponentJs}"></script>
    <script src="${loginCardModuleJs}"></script>
    <script src="${loginCardComponentJs}"></script>
    <script src="${profileDetailsModuleJs}"></script>
    <script src="${profileDetailsComponentJs}"></script>
    <script src="${profileHeaderModuleJs}"></script>
    <script src="${profileHeaderComponentJs}"></script>
    <script src="${profileHobbiesModuleJs}"></script>
    <script src="${profileHobbiesComponentJs}"></script>
    <script src="${profileTimelineModuleJs}"></script>
    <script src="${profileTimelineComponentJs}"></script>
    <script src="${registrationCardModuleJs}"></script>
    <script src="${registrationCardComponentJs}"></script>
    <script src="${userMapsModuleJs}"></script>
    <script src="${userMapsComponentJs}"></script>
    <script src="${userStatisticsModuleJs}"></script>
    <script src="${userStatisticComponentJs}"></script>
    <script src="${editAccountModuleJs}"></script>
    <script src="${editAccountComponentJs}"></script>
    <script src="${editHobbiesModuleJs}"></script>
    <script src="${editHobbiesComponentJs}"></script>
  </body>
</html>

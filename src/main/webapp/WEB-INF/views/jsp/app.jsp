<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="trainingApp">
	<head>
		<meta charset="utf-8">
		<title>Training Project</title>

		<spring:url value="/resources/core/css/app.css" var="coreCss" />
		<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />

		<link href="${bootstrapCss}" rel="stylesheet" />
		<link href="${coreCss}" rel="stylesheet" />

		<spring:url value="/resources/angular/angular.js" var="angularJs" />
		<spring:url value="/resources/bootstrap/css/bootstrap.min.js" var="bootstrapJs" />
		<spring:url value="/resources/core/js/app.js" var="coreJs" />
		<spring:url value="/resources/core/js/option-list.component.js" var="optionListJs" />

		<script src="${angularJs}"></script>
		<script src="${bootstrapJs}"></script>
		<script src="${coreJs}"></script>
		<script src="${optionListJs}"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	</head>

	<body>
		<p>
			<c:choose>
				<c:when test="${not empty guest_name}">
					<h2>Hello ${guest_name}!</h3>
				</c:when>
				<c:when test="${not empty full_name}">
					<h2>Welcome back ${full_name}!</h2>
				</c:when>
				<c:otherwise>
					<h2>Hello guest!</h2>
					<option-list></option-list>
				</c:otherwise>
			</c:choose>
		</p>
	</body>
</html>

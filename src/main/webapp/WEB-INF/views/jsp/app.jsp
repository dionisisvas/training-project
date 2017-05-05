<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Maven + Spring MVC + @JavaConfig</title>

	<spring:url value="/resources/core/css/app.css" var="coreCss" />
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>

<body>
	<p>
		<c:choose>
			<c:when test="${not empty name}">
				Hello ${name}
			</c:when>
			<c:when test="${not empty full_name}">
				Hello ${full_name}
			</c:when>
			<c:otherwise>
				Hello guest!
			</c:otherwise>
		</c:choose>
	</p>

	<spring:url value="/resources/core/js/app.js" var="coreJs" />
	<spring:url value="/resources/bootstrap/css/bootstrap.min.js" var="bootstrapJs" />

	<script src="${coreJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>
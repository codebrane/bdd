<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
	<title>${pageContext.servletContext.contextPath}/modeltest</title>
</head>
<body>
	<p id="intro">
		<spring:message code="modeltest.intro" />
	</p>
	
	<p id="firstAttribute">
		firstAttributeValue = <c:out value="${firstAttributeName}" />
  </p>
  <p id="secondAttribute">
		secondAttributeValue = <c:out value="${secondAttributeName}" />
  </p>
  <p id="thirdAttribute">
    thirdAttributeValue = <c:out value="${thirdAttributeName}" />
  </p>
	</p>
</body>
</html>
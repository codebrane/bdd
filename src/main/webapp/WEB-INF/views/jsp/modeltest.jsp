<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>${pageContext.servletContext.contextPath}/modeltest</title>
</head>
<body>
	<p id="intro">
		Testing expression language support
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
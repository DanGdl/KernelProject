<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<jsp:include page="header.jsp"/>
	<body>
		<h3>Welcome to Devices Server!</h3>
		<c:choose>
		    <c:when test="${mode == 'edit'}">
		        <jsp:include page="measurements_edit.jsp"/>
		    </c:when>
		    <c:when test="${mode == 'delete'}">
		        <jsp:include page="measurements_delete.jsp"/>
		    </c:when>
		    <c:otherwise>
		        <jsp:include page="measurements_list.jsp"/>
		    </c:otherwise>
		</c:choose>
		<button type="button" name="back" onclick="history.back()">Back</button>
	</body>
</html>

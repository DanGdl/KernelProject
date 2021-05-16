<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<jsp:include page="header.jsp"/>
	<body>
		<h3>Welcome to Devices Server!</h3>
		<h4>${mode}</h4>
		<h4>${status}</h4>
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
		<br><br><a href="./">&lt&ltBack</a>
	</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="../../student" method="post">
    <fieldset>
        <input type="hidden" name="id" value="${entity.id}">
        <input type="hidden" name="action" value="editAction">
        <legend>Personal information:</legend>
        Name:<br>
        <input type="text" name="name" value="${entity.name}">
        <br>
        <!-- Last name:<br>
        <input type="text" name="surname" value="${person.surname}">
        <br>
        Gender:<br>
        <c:choose>
            <c:when test="${gender == '1'}">
                <input type="radio" name="gender" value="1" checked> Male<br>
                <input type="radio" name="gender" value="2"> Female<br>
            </c:when>
            <c:when test="${gender == '2'}">
                <input type="radio" name="gender" value="1"> Male<br>
                <input type="radio" name="gender" value="2"> Female checked<br>
            </c:when>
        </c:choose >
        <br>
        Birthday:<br>
        <input type="date" name="birthday" value=${birthday}><br>
        <br><br-->
        <input type="submit" value="Done">
    </fieldset>
</form>
<br>${status}

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/devices" method="post">
    <fieldset>
        <input type="hidden" name="id" value="${entity.id}">
        <input type="hidden" name="action" value="editAction">
        <legend>Device info:</legend>
        Name:<br>
        <input type="text" name="name" value="${entity.name}">
        <br>
        Address:<br>
        <input type="text" name="address" value="${entity.address}">
        <br>
        <input type="submit" value="Done">
    </fieldset>
</form>
<br>${status}

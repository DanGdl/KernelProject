<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/devices" method="post">
    <fieldset>
        <input type="hidden" name="id" value="${entity.id}">
        <input type="hidden" name="sure" value="yes">
        <input type="hidden" name="action" value="deleteAction">
        <legend>Device info:</legend>        
        Name:<br>
        <input type="text" name="name" value="${entity.name}" readonly>
        <br>
        Address:<br>
        <input type="text" name="address" value="${entity.address}" readonly>
        Are you sure to delete? <br>
        <input type="submit" value="Yes">
    </fieldset>
</form>
<br>${status}

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/measurements" method="post">
    <fieldset>
        <input type="hidden" name="id" value="${entity.id}">
        <input type="hidden" name="action" value="editAction">
        <legend>Information:</legend>
        Source address:<br>
        <input type="text" name="name" value="${entity.sourceAddress}">
        <br>
        Destination address:<br>
        <input type="text" name="name" value="${entity.destinationAddress}">
        <br>
        Gas pressure:<br>
        <input type="text" name="name" value="${entity.gasPressure}">
        <br>
        Valve state:<br>
        <input type="text" name="name" value="${entity.valvesState}">
        <br>
        Pipe temperature:<br>
        <input type="text" name="name" value="${entity.pipeTemperature}">
        <br>
        Payload:<br>
        <input type="text" name="name" value="${entity.payload}">
        <br>
        <input type="submit" value="Done">
    </fieldset>
</form>
<br>${status}

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/student" method="post">
    <fieldset>
        <input type="hidden" name="id" value="${entity.id}">
        <input type="hidden" name="sure" value="yes">
        <input type="hidden" name="action" value="deleteAction">
        <legend>Information:</legend>
        Source address:<br>
        <input type="text" name="name" value="${entity.sourceAddress}" readonly>
        <br>
        Destination address:<br>
        <input type="text" name="name" value="${entity.destinationAddress}" readonly>
        <br>
        Gas pressure:<br>
        <input type="text" name="name" value="${entity.gasPressure}" readonly>
        <br>
        Valve state:<br>
        <input type="text" name="name" value="${entity.valvesState}" readonly>
        <br>
        Pipe temperature:<br>
        <input type="text" name="name" value="${entity.pipeTemperature}" readonly>
        <br>
        Payload:<br>
        <input type="text" name="name" value="${entity.payload}" readonly>
        <br>
        
        Are you sure to delete? <br>
        <input type="submit" value="Yes">
    </fieldset>
</form>
<br>${status}

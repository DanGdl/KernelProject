<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<p>List of measurements: </p>

 <form method="post" action="./measurements">
 	<input type="hidden" name="action" value="editAction">
	Source Address: <input name="sourceAddress" />
	Destination Address: <input name="destinationAddress" />
	Gas pressure: <input name="gasPressure" />
	Valve status: <input name="valvesState" />
	Pipe temperature: <input name="pipeTemperature" />
	Payload: <input name="payload" />
	<input type="submit" value="Save" />
</form>
	
<table border="1">
    <thead>
	    <td>ID</td>
	    <td>Source Address</td>
	    <td>Destination Address</td>
	    <td>Gas pressure</td>
	    <td>Valve status</td>
	    <td>Pipe temperature</td>
	    <td>Payload</td>
    </thead>
		
    <tbody>
	    <c:forEach items="${entities}" var="entity">
	        <tr>
	            <td>${entity.id}</td>
	            <td>${entity.sourceAddress}</td>
	            <td>${entity.destinationAddress}</td>
	            <td>${entity.gasPressure}</td>
	            <td>${entity.valvesState}</td>
	            <td>${entity.pipeTemperature}</td>
	            <td>${entity.payload}</td>
	            <td>
	                <button class="btn warning" type="submit"
	                        onclick="window.location.href='measurements/${entity.id}/edit';">Edit
	                </button>
	            </td>
	            <td>
	                <button class="btn danger" type="submit"
	                        onclick="window.location.href='measurements/${entity.id}/delete';">Delete
	                </button>
	            </td>
	        </tr>
	    </c:forEach>
    </tbody>
</table>

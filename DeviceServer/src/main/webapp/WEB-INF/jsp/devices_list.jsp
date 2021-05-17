<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<p>Create new Device:</p>
 <form method="post" action="./devices">
 	<input type="hidden" name="action" value="editAction">
	Name: <input name="name" />
	Address: <input name="address" />
	<input type="submit" value="Save" />
</form>
	
<p>List of devices: </p>
<table border="1">
    <thead>
	    <td>ID</td>
	    <td>Name</td>
	    <td>Address</td>
    </thead>
		
    <tbody>
	    <c:forEach var="entity" items="${entities}">
	        <tr>
	            <td>${entity.id}</td>
	            <td>${entity.name}</td>
	            <td>${entity.address}</td>
	            <td>
	                <button class="btn warning" type="submit"
	                        onclick="window.location.href='devices/${entity.id}/edit';">Edit
	                </button>
	            </td>
	            <td>
	                <button class="btn danger" type="submit"
	                        onclick="window.location.href='devices/${entity.id}/delete';">Delete
	                </button>
	            </td>
	        </tr>
	    </c:forEach>
    </tbody>
</table>

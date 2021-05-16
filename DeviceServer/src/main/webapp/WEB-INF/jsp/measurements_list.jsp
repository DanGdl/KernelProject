<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<p>List of students: </p>
<br>${status}

 <form method="post" action="./student">
 	<input type="hidden" name="action" value="editAction">
	Name: <input name="name" />
	<input type="submit" value="Save" />
</form>
	
<table border="1">
    <thead>
	    <td>ID</td>
	    <td>Name</td>
    </thead>
		
    <tbody>
	    <c:forEach items="${entities}" var="entity">
	        <tr>
	            <td>${entity.id}</td>
	            <td>${entity.name}</td>
	            <td>
	                <button class="btn warning" type="submit"
	                        onclick="window.location.href='student/${entity.id}/edit';">Edit
	                </button>
	            </td>
	            <td>
	                <button class="btn danger" type="submit"
	                        onclick="window.location.href='student/${entity.id}/delete';">Delete
	                </button>
	            </td>
	        </tr>
	    </c:forEach>
    </tbody>
</table>

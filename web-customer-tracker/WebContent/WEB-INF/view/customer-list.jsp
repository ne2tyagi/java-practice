<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer List</title>
<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div>
	<h1>CRM- Customer Relationship Manager</h1>
</div>
<div>
	<input type="button" value="Add Customer" onClick="window.location.href='showCustomerForm; return false;'"/>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>EMail</th>
			<th>Action</th>
		</tr>
		<c:forEach var="tempCustomer" items="${customers }">
			<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id }"></c:param>
			</c:url>
			<c:url var="deleteLink" value="/customer/deleteCustomer">
				<c:param name="customerId" value="${tempCustomer.id}"></c:param>
			</c:url>
			<tr>
				<td>${tempCustomer.firstName }</td>
				<td>${tempCustomer.lastName }</td>
				<td>${tempCustomer.email }</td>
				<td><a href="${updateLink }">Update</a> | <a href="${deleteLink }" onClick="if(!confirm('Are you sure?'))return false;">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</div>
</body>
</html>
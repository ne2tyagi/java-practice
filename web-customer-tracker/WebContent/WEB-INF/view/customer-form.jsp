<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Customer</title>
</head>
<body>
	<div>
		<h3>Customer form</h3>
		<form:form method="POST" action="saveCustomer" modelAttribute="customer">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save Customer"/></td>
				</tr>
			</table>
		</form:form>
		<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
	</div>
</body>
</html>
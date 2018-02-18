<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title> Customer form</title>
	<style>.error{color:red;}</style>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">
	First Name(*): <form:input path="firstName" />
	<form:errors path="firstName" cssClass="error"/><br/>
	Last Name: <form:input path="lastName"/><br/>
	Free Passes: <form:input path="freePasses"/>
	<form:errors path="freePasses" cssClass="error"/>
	<br/>
	Postal Code: <form:input path="postalCode" />
	<form:errors path="postalCode" cssClass="error"/><br/>
	Course Code: <form:input path="courseCode"/>
	<form:errors path="courseCode" cssClass="error" />
	<input type="submit"/>
</form:form>
</body>
</html>
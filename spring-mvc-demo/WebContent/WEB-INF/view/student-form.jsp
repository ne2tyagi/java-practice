<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Registration- Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
First Name: <form:input path="firstName"/><br/>
Last Name: <form:input path="lastName"/><br/>
Country: <form:select path="country">
	<form:options items="${countryOptions}"/>
	<br/><br/>
	<form:radiobuttons path="language" items="${languages }"/><br/>
	<form:checkboxes path="os" items="${operatingSystems }"/>
</form:select>
<input type="submit"/>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Confirmation</title>
</head>
<body>
 Student is confirmed: ${student.firstName } ${student.lastName }
 Country: ${student.country }
 Language: 
 <ul>
 <c:forEach items="${student.os }" var="temp"><li>${temp }</li></c:forEach>
 </ul>
</body>
</html>
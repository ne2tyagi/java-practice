<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation- Customer</title>
</head>
<body>
First Name: ${customer.firstName }
Last name: ${customer.lastName }
Postal Code: ${customer.postalCode }
Free Passes: ${customer.freePasses }
Course Code: ${customer.courseCode }
</body>
</html>
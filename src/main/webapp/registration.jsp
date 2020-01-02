<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 02/01/2020
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<form:form action="/register" method="post" modelAttribute="user">
    <form:input path="name"/>
    <form:input path="email"/>
    <form:input path="password"/>
    <input type="submit" value="Register">
</form:form>

<body>

</body>
</html>

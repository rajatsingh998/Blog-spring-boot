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


<body>
<jsp:include page="header.jsp" />
<form:form action="/register" method="post" modelAttribute="user">
    User Name: <form:input path="name"/>
    Email: <form:input path="email"/>
    Password: <form:input path="password"/>
    <input type="submit" value="Register">
</form:form>
</body>
</html>

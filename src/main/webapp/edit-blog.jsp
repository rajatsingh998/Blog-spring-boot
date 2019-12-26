<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 23/12/2019
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fdg</title>
</head>
<body>
<form:form action="save" method="POST" modelAttribute="theBlog">
    Enter Title Name: <form:input path="title"/>
    <form:hidden path="id"></form:hidden>
    <br><br>
    Enter Your Content: <form:input path="content"/>
    <br><br>

    <input type="submit" value="Update"/>
</form:form>
</body>
</html>

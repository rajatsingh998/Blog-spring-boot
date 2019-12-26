<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 21/12/2019
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="save" method="POST" modelAttribute="theBlog">
    Enter Title Name: <form:input path="title"/>
    <br><br>
    Enter Your Content: <form:input path="content"/>
    <br><br>

    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
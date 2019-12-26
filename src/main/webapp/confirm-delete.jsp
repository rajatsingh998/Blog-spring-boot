<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 23/12/2019
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<form:form action="delete" method="POST" modelAttribute="theBlog">
    <form:hidden path="id"></form:hidden>

    Title Name: ${theBlog.title}
    <br><br>
    Content: ${theBlog.content}
    <br><br>

    <input type="submit" value="Delete"/>
</form:form>

</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
<form:form action="/new" method="POST" modelAttribute="blog">
    Enter Title Name: <form:input path="title"/>
    <br><br>
    Enter Your Content: <form:input path="content"/>
    <br><br>
    Select tags:
    <br><br>

<form:form modelAttribute="category">

            Sci-fic<form:checkbox path="name" value="Sci-fic"/>
            Motivational<form:checkbox path="name" value="Motivational"/>


    <input type="submit" value="Submit"/>
</form:form>

</form:form>

</body>
</html>
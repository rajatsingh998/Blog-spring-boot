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
<form:form action="/edit-save" method="POST" modelAttribute="theBlog">
    Enter Title Name: <form:input path="title"/>
    <form:hidden path="id"></form:hidden>
    <br><br>
    Enter Your Content: <form:input path="content"/>
    <br><br>
    <form:form modelAttribute="category">

        Sci-fic<form:checkbox path="name" value="Sci-fic"/>
        Motivational<form:checkbox path="name" value="Motivational"/>


        <input type="submit" value="Submit"/>
    </form:form>

</form:form>
</body>
</html>

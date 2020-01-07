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
<script type="text/javascript">
    function validateForm() {
        var a = document.getElementById("a").value;
        var b = document.getElementById("b").value;
        var c = document.getElementById("c").value;

        if (a == null || a == "", b == null || b == "", c == null || c == "") {
            alert("Please Fill All Required Field");
            return false;
        }
    }
</script>

<body>
<jsp:include page="header.jsp" />
<form:form onsubmit="return validateForm()" action="/register" name="Form" method="post" modelAttribute="user" >
    User Name: <form:input id="a" path="name"/>
    Email: <form:input id="b" path="email"/>
    Password: <form:input id="c" path="password"/>
    <input type="submit" value="Register">
</form:form>
</body>
</html>

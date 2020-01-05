<%@ page import="com.firstdemo.first_demo.Model.Post" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>fdg</title>
</head>
<body>
<jsp:include page="header.jsp" />
<security:authorize access="!isAuthenticated()">
    <%
        response.sendRedirect("/");
    %>
</security:authorize>
<%--<form:form action="/edit-save" method="POST" modelAttribute="theBlog">--%>
<%--<div class="container">--%>

<%--    <div class="well">--%>
<%--        <div class="media">--%>
<%--            <a class="pull-left" href="#">--%>
<%--                <img class="media-object" src="http://placekitten.com/150/150" >--%>
<%--            </a>--%>
<%--            <div class="media-body">--%>

<%--                    <% Post post= (Post) request.getAttribute("theBlog");%>--%>
<%--                    <form:hidden path="id"></form:hidden>--%>
<%--                    <input type="hidden" name="userName" value="<%=post.getUser().getName() %>">--%>
<%--                    <h4 class="media-heading" contenteditable="true"><%=post.getTitle()%>--%>
<%--                        </a></h4>--%>
<%--                    <p class="text-right">By <%=post.getUser().getName()%></p>--%>
<%--                    <p contenteditable="true"><%=post.getContent()%></p>--%>
<%--                    <form:form modelAttribute="category">--%>

<%--                        Sci-fic<form:checkbox path="name" value="Sci-fic"/>--%>
<%--                        Motivational<form:checkbox path="name" value="Motivational"/>--%>
<%--                        Travel<form:checkbox path="name" value="Travel"/>--%>

<%--                        <input type="submit" value="Submit"/>--%>





<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</form:form>--%>
<%--</form:form>--%>
<form:form action="/edit-save" method="POST" modelAttribute="theBlog">
    <% Post post= (Post) request.getAttribute("theBlog");%>
    Enter Title Name: <form:input path="title"/>
    <form:hidden path="id"></form:hidden>
    <input type="hidden" name="userName" value="<%=post.getUser().getName() %>">
    <br><br>
    Enter Your Content: <form:input path="content"/>
    <br><br>
    <form:form modelAttribute="category">

        Sci-fic<form:checkbox path="name" value="Sci-fic"/>
        Motivational<form:checkbox path="name" value="Motivational"/>
        Travel<form:checkbox path="name" value="Travel"/>

        <input type="submit" value="Submit"/>
    </form:form>

</form:form>
</body>
</html>

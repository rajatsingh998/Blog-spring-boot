<%@ page import="com.firstdemo.first_demo.Model.Post" %>
<%@ page import="com.firstdemo.first_demo.Model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 03/01/2020
  Time: 06:11
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
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container">
        <%
    Post post =  (Post)request.getAttribute("blog");

%>
    <div class="well">
        <div class="media">
            <a class="pull-left" href="#">
                <img class="media-object" src="http://placekitten.com/150/150">
            </a>
            <div class="media-body">

                <h4 class="media-heading"><a href="/post/view/<%=post.getId()%>"><%=post.getTitle()%>
                </a></h4>
                <p class="text-right">By <%=post.getUser().getName()%></p>
                <p><%=post.getContent()%></p>
                <ul class="list-inline list-unstyled">
                    <li><span><i class="glyphicon glyphicon-calendar"></i><%=post.getCreatedAt()%> </span></li>
                    <li>|</li>
                    <span><i class="glyphicon glyphicon-comment"></i> <%=post.getUpdatedAt()%></span>
                    <li>|</li>
                    <li>
                        <%
                            List<Category> categoryList = post.getCategories();
                            for (Category category : categoryList) {
                        %>
                        <%=category.getName()%>
                        <%
                            }
                        %>
                    </li>
                    <li>|</li>
                    <li>
                        <!-- Use Font Awesome http://fortawesome.github.io/Font-Awesome/ -->
                        <security:authorize access="isAuthenticated()">
                            <%
                                String user=post.getUser().getName();
                                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                                String username="";
                                String authorities="";
                                if (principal instanceof UserDetails) {
                                    username = ((UserDetails)principal).getUsername();
                                    authorities= String.valueOf(((UserDetails) principal).getAuthorities());
                                } else {
                                    username= principal.toString();
                                }
                                if(user.equals(username)||authorities.equals("[ROLE_ADMIN]"))                   {
                            %>
                            <a href="/edit?id=<%=post.getId()%>">Edit</a>
                            <%
                                }
                            %>
                        </security:authorize>
                        <security:authorize access="isAuthenticated()">
                            <%
                                String user=post.getUser().getName();
                                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                                String username="";
                                String authorities="";
                                if (principal instanceof UserDetails) {
                                    username = ((UserDetails)principal).getUsername();
                                    authorities= String.valueOf(((UserDetails) principal).getAuthorities());
                                } else {
                                    username= principal.toString();
                                }
                                if(user.equals(username)||authorities.equals("[ROLE_ADMIN]"))
                                {
                            %>
                            <a href="/delete-confirm?id=<%=post.getId()%>">Delete</a>
                            <%
                                }
                            %>
                        </security:authorize>

                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>

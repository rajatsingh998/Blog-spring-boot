<%@ page import="com.firstdemo.first_demo.Model.Post" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.firstdemo.first_demo.Model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Search Result</title>
</head>
<body>
<jsp:include page="header.jsp" />
<%--<div align="center">--%>
<%--    <h2>Search Result</h2>--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <tr>--%>
<%--            <th>Title</th>--%>
<%--            <th>Content</th>--%>
<%--            <th>Created At</th>--%>
<%--            <th>Updated At</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${allPost}" var="Blog">--%>
<%--            <tr>--%>
<%--                <td>${Blog.title}</td>--%>
<%--                <td>${Blog.content}</td>--%>
<%--                <td>${Blog.createdAt}</td>--%>
<%--                <td>${Blog.updatedAt}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<%
    ArrayList<Post> allPost = (ArrayList<Post>) request.getAttribute("allPost");
    int i = 0;
    for (Post post : allPost) {
        i++;
%>
<div class="container">

    <div class="well">
        <div class="media">
            <a class="pull-left" href="#">
                <img class="media-object" src="http://placekitten.com/150/150" >
            </a>
            <div class="media-body">

                <h4 class="media-heading"><a href="/view?id=<%=(post.getId())%>"><%=post.getTitle()%>
                </a></h4>
                <p class="text-right">By <%=post.getUser().getName()%></p>
                <p><%=post.getContent()%></p>
                <ul class="list-inline list-unstyled">
                    <li><span><i class="glyphicon glyphicon-calendar"></i><%=post.getCreatedAt()%> </span></li>
                    <li>|</li>
                    <span><i class="glyphicon glyphicon-calendar"></i> <%=post.getUpdatedAt()%></span>
                    <li>|</li>
                    <li>
                        <%
                            List<Category> categoryList = post.getCategories();
                            for (Category category : categoryList) {
                        %>
                        #<%=category.getName()%>
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
<%}%>
<%
    for (int j=0;j*3<(int)request.getAttribute("totalPost");j++){%>
<a href="?page=<%=j%>"><%=j%></a>
<%
    }
%>
</body>
</html>
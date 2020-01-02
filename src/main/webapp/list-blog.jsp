<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.firstdemo.first_demo.Model.Post" %>
<%@ page import="com.firstdemo.first_demo.Model.Category" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Blogs</title>
</head>
<body>
<%--<security:authorize access="!isAuthenticated()">--%>
<%--    <%--%>
<%--        response.sendRedirect("/");--%>
<%--    %>--%>
<%--</security:authorize>--%>
<div align="center">
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
<%  %>
<%--    <form action="/filter" method="get">--%>
<%--        Sci-fic<input type="checkbox" value="Sci-fic"/>--%>
<%--        Motivational<input type="checkbox" value="Motivational"/>--%>
<%--        Travel <input type="checkbox" value="Travel"/>--%>

<%--        <input type="submit" value="Submit"/>--%>
<%--    </form>--%>
    <h3><a href="/new">Add New Blog</a></h3>
    <br><br>
    <h2> Sort By:</h2>
    <a href="/sortbyUpdate">Update Time</a>
    <a href="/sortbyCreate">Create Time</a>
    <br><br><br>
    <security:authorize access="isAuthenticated()">
        <h2 class="text-success"> Welcome Back,<security:authentication property="name"/></h2>
        <h3 class="text-success">You are given <security:authorize access="hasRole('USER')"> AUTHOR LEVEL PRIVILEGE</security:authorize></h3>
        <security:authorize access="hasRole('ADMIN')"> ADMIN LEVEL PRIVILEGE  </h3>
            <p>With Great Power Comes great Responsibility</p> </security:authorize>
    </security:authorize>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">AuthorName</th>
            <th scope="col">PostTitle</th>
            <th scope="col">Post Content</th>
            <th scope="col">Created At</th>
            <th scope="col">Last Updated At</th>
            <th scope="col">Category</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                ArrayList<Post> allPost = (ArrayList<Post>) request.getAttribute("listPost");
                int i = 0;
                for (Post post : allPost) {
                    i++;
            %>
            <td scope="row"><%=i%>
            </td>
            <td>
                <p><%=post.getUser().getName()%></p>
            </td>
            <td>
                <a href="/post/view/<%=post.getId()%>"><%=post.getTitle()%>
                </a>
            </td>
            <td>
                <%=post.getContent()%>
            </td>
            <td>
                <%=post.getCreatedAt()%>
            </td>
            <td>
                <%=post.getUpdatedAt()%>
            </td>
            <td>
                <%
                    List<Category> categoryList = post.getCategories();
                    for (Category category : categoryList) {
                %>
                <%=category.getName()%>
                <%
                    }
                %>
            </td>
            <td>
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
            </td>
            <td>
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
            </td>
        </tr>
        </tbody>
        <%}%>
    </table>
<%--    <table border="1" cellpadding="5">--%>
<%--    <%ArrayList<Post> allPost = (ArrayList<Post>) request.getAttribute("listPost");%>--%>
<%--        <tr>--%>
<%--            <th>Title</th>--%>
<%--            <th>Content</th>--%>
<%--            <th>Created at</th>--%>
<%--            <th>Updated at </th>--%>

<%--            <th>Action </th>--%>
<%--        </tr>--%>

<%--        <c:forEach items="${listPost}" var="theBlog">--%>

<%--            <c:url var="updateLink" value="/edit?id=${theBlog.id}">--%>

<%--            </c:url>--%>
<%--            <c:url var="deleteLink" value="/delete-confirm?id=${theBlog.id}">--%>

<%--&lt;%&ndash;            </c:url>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <c:url var="showBYId" value="/blog/showById/${tempBlogs.id}">&ndash;%&gt;--%>

<%--            </c:url>--%>
<%--            <tr>--%>

<%--                <td>${theBlog.title}</td>--%>
<%--                <td>${theBlog.content}</td>--%>
<%--                <td>${theBlog.createdAt}</td>--%>
<%--                <td>${theBlog.updatedAt}</td>--%>

<%--                <td><a href="${updateLink}">Update</a>--%>
<%--                    | <td>--%>
<%--                <security:authorize access="isAuthenticated()">--%>
<%--                    <%--%>

<%--                        for (Post post : allPost) {--%>
<%--                        String name=  post.getUser().getName();--%>
<%--                        }--%>
<%--                        String user=allPost.--%>
<%--                        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();--%>
<%--                        String username="";--%>
<%--                        String authorities="";--%>
<%--                        if (principal instanceof UserDetails) {--%>
<%--                            username = ((UserDetails)principal).getUsername();--%>
<%--                            authorities= String.valueOf(((UserDetails) principal).getAuthorities());--%>
<%--                        } else {--%>
<%--                            username= principal.toString();--%>
<%--                        }--%>
<%--                        if(user.equals(username)||authorities.equals("[ROLE_ADMIN]"))                   {--%>
<%--                    %>--%>
<%--                    <a href="/post/edit/<%=post.getPostId()%>">Edit</a>--%>
<%--                    <%--%>
<%--                        }--%>
<%--                    %>--%>
<%--                </security:authorize>--%>
<%--                    <a href="${deleteLink}">Delete</a>--%>
<%--                </td>--%>

<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

</div>
<%
    for (int j=0;j*3<(int)request.getAttribute("totalPost");j++){%>
<a href="?page=<%=j%>"><%=j%></a>
<%
    }
%>
</body>
</html>
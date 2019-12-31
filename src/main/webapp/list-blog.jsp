
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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

<div align="center">
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>

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
    <table border="1" cellpadding="5">

        <tr>
            <th>Title</th>
            <th>Content</th>
            <th>Created at</th>
            <th>Updated at </th>

            <th>Action </th>
        </tr>

        <c:forEach items="${listPost}" var="theBlog">

            <c:url var="updateLink" value="/edit?id=${theBlog.id}">

            </c:url>
            <c:url var="deleteLink" value="/delete-confirm?id=${theBlog.id}">

<%--            </c:url>--%>
<%--            <c:url var="showBYId" value="/blog/showById/${tempBlogs.id}">--%>

            </c:url>
            <tr>

                <td>${theBlog.title}</td>
                <td>${theBlog.content}</td>
                <td>${theBlog.createdAt}</td>
                <td>${theBlog.updatedAt}</td>

                <td><a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>

</div>
<%
    for (int i=0;i*3<(int)request.getAttribute("totalPost");i++){%>
<a href="?page=<%=i%>"><%=i%></a>
<%
    }
%>
</body>
</html>
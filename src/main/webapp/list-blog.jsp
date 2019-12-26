<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer Manager</title>
</head>
<body>
<div align="center">
    <h3><a href="/BlogMVCJPA_war_exploded/new">Add New Blog</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>Title</th>
            <th>Content</th>
        </tr>
        <c:forEach items="${allBlogs}" var="theBlog">
            <c:url var="updateLink" value="/edit?id=${theBlog.id}">

            </c:url>
            <c:url var="deleteLink" value="/delete-confirm?id=${theBlog.id}">

<%--            </c:url>--%>
<%--            <c:url var="showBYId" value="/blog/showById/${tempBlogs.id}">--%>

            </c:url>
            <tr>

                <td>${theBlog.title}</td>
                <td>${theBlog.content}</td>
                <td><a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
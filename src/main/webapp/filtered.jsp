<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table border="1" cellpadding="5">

    <tr>
        <th>Title</th>
        <th>Content</th>
        <th>Created at</th>
        <th>Updated at </th>
        <th>tags</th>
        <th>Action </th>
    </tr>

    <c:forEach items="${result}" var="theBlog">

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

</body>
</html>
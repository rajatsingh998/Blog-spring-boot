<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 03/01/2020
  Time: 06:46
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
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css"/>
<nav class="navbar navbar-expand-lg navbar-light bg-info">

    <a class="navbar-brand text-light" href="https://www.jquery-az.com/" >Slogan/Logo</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#demo-navbar" aria-controls="demo-navbar" aria-expanded="false" aria-label="Toggle navigation">

        <span class="navbar-toggler-icon"></span>

    </button>



    <div class="collapse navbar-collapse" id="demo-navbar">

        <ul class="navbar-nav mr-auto">

            <li class="nav-item active">

                <a class="nav-link text-light" href="/">Home<span class="sr-only">(current)</span></a>

            </li>

            <li class="nav-item">

                <a class="nav-link text-light" href="/new">New Blog</a>

            </li>

            <li class="nav-item dropdown">

                <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                    Sort By

                </a>

                <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                    <a class="dropdown-item" href="/sortbyCreate">Creation Time</a>

                    <a class="dropdown-item" href="/sortbyUpdate">Update Time</a>



                </div>

            </li>

            <li class="nav-item">
                <sec:authorize access="hasAnyRole('ROLE_ADMIN') || hasAnyRole('ROLE_USER')">
                    <a class="nav-link text-light" href="/logout">Logout</a>
                </sec:authorize>
                <sec:authorize access="!hasAnyRole('ROLE_ADMIN')&& !hasAnyRole('ROLE_USER')  ">
                    <a class="nav-link text-light" href="/login">Login</a>
                </sec:authorize>




            </li>

        </ul>

        <form method="get" action="search" class="form-inline my-2 my-lg-0">

            <input name="keyword" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">

            <button class="btn btn-outline-warning my-2 my-sm-0" type="submit">Search</button>

        </form>

    </div>

</nav>
</body>
</html>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Lin's Blog</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">


    <link rel="stylesheet" href="${cdnLibPath}/bootstrap-4.0.0-alpha/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${cdnPath}/css/style.css">
    <link rel="stylesheet" href="${siteUrl}/style/css.css">
</head>
<body>

<nav class="navbar navbar-fixed-top navbar-light bg-faded">
    <a class="navbar-brand" href="#"></a>
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="${siteUrl}">首页 <span class="sr-only">(current)</span></a>
        </li>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">分类一</a>--%>
        <%--</li>--%>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">关于我</a>--%>
        <%--</li>--%>
    </ul>
    <form class="form-inline navbar-form pull-right">
        <%--<input class="form-control" type="text" placeholder="Search">--%>
        <%--<button class="btn btn-success-outline" type="submit">Search</button>--%>
    </form>
</nav>

<div class="blog_head">
    <div class="container">
        <h1>Lin's Blog</h1>
        <p>心若止水     波澜不惊</p>
    </div>
</div>

<div class="container-fluid">

    <div class="row">

        <c:forEach items="${blog.blogList}" var="blogContent" varStatus="status">
            <div class="col-sm-12 col-md-4 col-lg-3 blog_box <c:if test="${status.index%2 == 0 }">odd</c:if>"    >
                <h5 class="blog_title"><a target="_blank" title="${blogContent.title}" href="${siteUrl}${blogContent.documentViewLink}">${blogContent.title}</a></h5>
                <div class="date">${blogContent.date}<a target="_blank" title="${blogContent.title}" href="${siteUrl}${blogContent.documentViewLink}">全文</a></div>
                <div class="info">${blogContent.description}</div>

            </div>
        </c:forEach>
    </div>

    <!-- jQuery first, then Bootstrap JS. -->
    <script src="${cdnLibPath}jquery-1.11.3.js"></script>
    <script src="${cdnLibPath}bootstrap-4.0.0-alpha/dist/js/bootstrap.js"></script>
</body>
</html>

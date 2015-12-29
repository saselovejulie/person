<%--<p><span>标题:</span> <input type="text" name="title"> </p>--%>
<%--<p><span>分类:</span><input type="text" name="types"></p>--%>
<%--<p><span>标签:</span><input type="text" name="tags"></p>--%>
<%--<p><span>文章:</span><textarea name="content" cols="20" rows="5"></textarea></p>--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en" ng-app="personApp">
<head>
    <title></title>

    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>


    <%@ include file="/views/manage/common/css.jsp" %>



</head>

<body ng-controller="blogEditController">

<input type="text" name="title" ng-model="title"> <br />
<input type="text" name="types" ng-model="types"> <br />
<input type="text" name="tags" ng-model="tags"> <br />
<input type="text" name="description" ng-model="description"> <br />


<textarea rows="10" cols="200" ng-model="content">
    


</textarea>

<a href="#" ng-click="save()">保存</a>

<%@ include file="/views/manage/common/js.jsp" %>

<script src="${siteUrl}app/app.js" type="text/javascript"></script>
<script src="${siteUrl}app/manage/blog/controller/blogEditcontroller.js" type="text/javascript"></script>
</body>
</html>
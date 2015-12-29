<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <title data-ng-bind="'Metronic AngularJS | ' + $state.current.data.pageTitle">${manageStatic}</title>

    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>


    <%@ include file="/views/manage/common/css.jsp" %>



</head>

<body ng-controller="AppController" class="page-header-fixed page-sidebar-closed-hide-logo page-quick-sidebar-over-content page-on-load" ng-class="{'page-container-bg-solid': settings.layout.pageBodySolid, 'page-sidebar-closed': settings.layout.pageSidebarClosed}">


<div ng-spinner-bar class="page-spinner-bar">
    <div class="bounce1"></div>
    <div class="bounce2"></div>
    <div class="bounce3"></div>
</div>

<div data-ng-include="'tpl/header.html'" data-ng-controller="HeaderController" class="page-header navbar navbar-fixed-top">
</div>


<div class="clearfix">
</div>

<div class="page-container">
    <div data-ng-include="'tpl/sidebar.html'" data-ng-controller="SidebarController" class="page-sidebar-wrapper">
    </div>
    <div class="page-content-wrapper">
        <div class="page-content">
            <div data-ng-include="'tpl/theme-panel.html'" data-ng-controller="ThemePanelController" class="theme-panel hidden-xs hidden-sm">
            </div>

            <div ui-view class="fade-in-up">
            </div>
        </div>
    </div>

    <!-- BEGIN QUICK SIDEBAR -->
    <a href="javascript:;" class="page-quick-sidebar-toggler"><i class="icon-close"></i></a>
    <div data-ng-include="'tpl/quick-sidebar.html'" data-ng-controller="QuickSidebarController" class="page-quick-sidebar-wrapper"></div>
    <!-- END QUICK SIDEBAR -->
</div>
<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->
<div data-ng-include="'tpl/footer.html'" data-ng-controller="FooterController" class="page-footer">
</div>
<!-- END FOOTER -->


<%@ include file="/views/manage/common/js.jsp" %>




<script type="text/javascript">
    /* Init Metronic's core jquery plugins and layout scripts */
    $(document).ready(function() {
        Metronic.init(); // Run metronic theme
        Metronic.setAssetsPath('${manageStatic}assets/'); // Set the assets folder path
    });
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>Lin&#039;s Site | 心若止水 波澜不惊</title>
    <link rel='stylesheet' id='twentytwelve-fonts-css' href='https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,400,700&#038;subset=latin,latin-ext' type='text/css' media='all'/>


    <link rel="stylesheet" href="${siteUrl}/style/css.css">
</head>

<body class="home blog custom-font-enabled single-author">
<div id="page" class="hfeed site">
    <header id="masthead" class="site-header" role="banner">
        <hgroup>
            <h1 class="site-title"><a href="${siteUrl}" title="Lin&#039;s Site" rel="home">Lin&#039;s Site</a></h1>

            <h2 class="site-description">心若止水 波澜不惊</h2>
        </hgroup>

        <nav id="site-navigation" class="main-navigation" role="navigation">
            <button class="menu-toggle">菜单</button>
            <a class="assistive-text" href="#content" title="跳至内容">跳至内容</a>

            <div class="nav-menu">
                <ul>
                    <li class="current_page_item"><a href="${siteUrl}">首页</a></li>

                    <%--<li class="page_item page-item-2"><a href="http://conglin-site.com/?page_id=2">示例页面</a></li>--%>

                </ul>
            </div>
        </nav>

    </header>

    <div id="main" class="wrapper">
        <div id="primary" class="site-content">
            <div id="content" role="main">

                <c:forEach items="${blog.blogList}" var="blogContent" varStatus="status">
                    <article id="post-211" class="post-211 post type-post status-publish format-standard hentry category-mysql category-other category-27">
                        <header class="entry-header">

                            <h1 class="entry-title">
                                <a target="_blank" href="${siteUrl}${blogContent.documentViewLink}" title="${blogContent.title}">${blogContent.title}</a>
                            </h1>
                        </header>

                        <div class="entry-content">
                                ${blogContent.description}
                        </div>

                        <footer class="entry-meta">
                            本条目发布于<a target="_blank" href="${blogContent.documentViewLink}" title="14:47" rel="bookmark">
                            <time class="entry-date" datetime="2015-04-18T14:47:20+00:00">${blogContent.date}</time>
                        </a>。Tags:

                            <c:forEach items="${blogContent.tags}" var="tag" varStatus="status">
                                <a style="font-style: italic;" href="#" rel="category">${tag}</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:forEach>
                        </footer>
                    </article>
                </c:forEach>

                <nav id="nav-below" class="navigation" role="navigation">
                    <h3 class="assistive-text">文章导航</h3>


                    <div class="nav-previous">
                        <c:if test="${blog.pageNumber != '1'}">
                            <a href="${siteUrl}list/${blog.pageNumber-1}"><span class="meta-nav">&larr;</span> 较新文章</a>
                        </c:if>
                    </div>


                    <div class="nav-next">
                        <c:if test="${blog.total-(blog.pageNumber * blog.pageSize) > 0 }">
                            <a href="${siteUrl}list/${blog.pageNumber+1}"> 早期文章 <span class="meta-nav">→</span></a>
                        </c:if>
                    </div>

                </nav>
            </div>
        </div>

        <div id="secondary" class="widget-area" role="complementary">
            <%--<aside id="search-2" class="widget widget_search"><form role="search" method="get" id="searchform" class="searchform" action="http://conglin-site.com/">--%>
            <%--<div>--%>
            <%--<label class="screen-reader-text" for="s">搜索：</label>--%>
            <%--<input type="text" value="" name="s" id="s" />--%>
            <%--<input type="submit" id="searchsubmit" value="搜索" />--%>
            <%--</div>--%>
            <%--</form></aside>		--%>


            <aside id="recent-posts-2" class="widget widget_recent_entries"><h3 class="widget-title">近期文章</h3>
                <ul>

                    <c:forEach items="${lastBlog.blogList}" var="blogContent" varStatus="status">
                        <li>
                            <a target="_blank" href="${siteUrl}${blogContent.documentViewLink}">${blogContent.title}</a>
                        </li>
                    </c:forEach>
                </ul>
            </aside>


            <%--<aside id="recent-comments-2" class="widget widget_recent_comments"><h3 class="widget-title">近期评论</h3><ul id="recentcomments"></ul></aside><aside id="archives-2" class="widget widget_archive"><h3 class="widget-title">文章归档</h3>		<ul>--%>
            <%--<li><a href='http://conglin-site.com/?m=201504'>2015年四月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201502'>2015年二月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201404'>2014年四月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201305'>2013年五月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201303'>2013年三月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201302'>2013年二月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201212'>2012年十二月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201210'>2012年十月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201209'>2012年九月</a></li>--%>
            <%--<li><a href='http://conglin-site.com/?m=201208'>2012年八月</a></li>--%>
            <%--</ul>--%>
            <%--</aside>--%>


            <%--<aside id="categories-2" class="widget widget_categories"><h3 class="widget-title">分类目录</h3>		<ul>--%>
            <%--<li class="cat-item cat-item-12"><a href="http://conglin-site.com/?cat=12" >HTML5</a>--%>
            <%--</li>--%>
            <%--cat-item cat-item-27"><a href="http://conglin-site.com/?cat=27" >数据结构</a>--%>
            <%--</li>--%>
            <%--</ul>--%>
            <%--</aside>--%>


            <%--<aside id="meta-2" class="widget widget_meta"><h3 class="widget-title">功能</h3>			<ul>--%>
            <%--<li><a href="http://conglin-site.com/wp-login.php?action=register">注册</a></li>			<li><a href="http://conglin-site.com/wp-login.php">登录</a></li>--%>
            <%--<li><a href="http://conglin-site.com/?feed=rss2">文章<abbr title="Really Simple Syndication">RSS</abbr></a></li>--%>
            <%--<li><a href="http://conglin-site.com/?feed=comments-rss2">评论<abbr title="Really Simple Syndication">RSS</abbr></a></li>--%>
            <%--<li><a href="https://cn.wordpress.org/" title="基于WordPress，一个优美、先进的个人信息发布平台。">WordPress.org</a></li>			</ul>--%>
            <%--</aside>		--%>


        </div>
    </div><!-- #main .wrapper -->
    <footer id="colophon" role="contentinfo">
        <div class="site-info">
            <a href="#" title="优雅的个人发布平台">Lin's Site</a>
        </div><!-- .site-info -->
    </footer><!-- #colophon -->
</div><!-- #page -->

</body>
</html>
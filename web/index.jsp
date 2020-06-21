<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<jsp:useBean id="user" type="dao.UserDao" scope="request"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<html>
<head>
    <title>DARK SOULS III</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/main.css"/>
</head>

<head><title>用户界面</title>
</head>

<body class="mediawiki ltr ns-0 ns-subject page-Slave_Knight_Gael  MiniEditor oasis-breakpoints skin-oasis oasis-dark-theme  user-anon background-fixed wiki-darksouls">

<div class="background-image-gradient"></div>

<div class="WikiaSiteWrapper">
    <header class="wds-community-header">
        <div class="wds-community-header__wordmark" data-tracking="wordmark-image">
            <img src="images/logo.png" width="243" height="50">
        </div>
        <div class="wds-community-header__wordmark" data-tracking="wordmark-image">
            <h1 class="page-header__title">Welcome, ${user.id}.</h1>
            <%  if(user != null) {%>
            <%      if(user.getEmail() != null) {%>
            <h1>${user.email}</h1>
            <%      }%>
            <%  }%>
        </div>

    </header>


    <section id="WikiaPage" class="WikiaPage V2" onclick="">
        <div class="WikiaPageContentWrapper">
            <header id="PageHeader" class="page-header">
                <div class="page-header__main">
                    <h1 class="page-header__title">>>>我的卡片</h1>
                </div>
                <div class="page-header__info">
                    <a href="${pageContext.request.contextPath}/browsecard"><h1 class="page-header__title">|卡片集市</h1></a>
                    <a href="${pageContext.request.contextPath}/addCard"><h1 class="page-header__title">|添加卡片</h1></a>
                    <a href="${pageContext.request.contextPath}/random"><h1 class="page-header__title">|随机卡片</h1></a>
                    <a href="${pageContext.request.contextPath}/exam"><h1 class="page-header__title">|答题</h1></a>
                    <a href="${pageContext.request.contextPath}/mail"><h1 class="page-header__title">|密保邮箱</h1></a>
                </div>
            </header>
            <hr class="page-header__separator">
        </div>

        <div class="portable-infobox pi-background pi-theme-DS3 pi-layout-default">
            <h2 class="pi-item pi-item-spacing pi-title" >${user.card.get("name")}</h2>

            <figure class="pi-item pi-image" data-source="image">
                <img src="${user.card.get("url")}">
            </figure>

            <div class="pi-item pi-data pi-item-spacing pi-border-color" data-source="location">
                <h3 class="pi-data-label pi-secondary-font">ID</h3>
                <div class="pi-data-value pi-font"><a href="#">${user.card.get("id")}</a></div>
            </div>
            <div class="pi-item pi-data pi-item-spacing pi-border-color" data-source="drops">
                <h3 class="pi-data-label pi-secondary-font">品质</h3>
                <div class="pi-data-value pi-font"><a href="#">${user.card.get("品质")}</a></div>
            </div>
            <div class="pi-item pi-data pi-item-spacing pi-border-color" data-source="drops">
                <h3 class="pi-data-label pi-secondary-font">世代</h3>
                <div class="pi-data-value pi-font"><a href="#">${user.card.get("世代")}</a></div>
            </div>
        </div>

        <div id="WikiaPageBackground" class="WikiaPageBackground"></div>

    </section>


</div>

</body>

</html>

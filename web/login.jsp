<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>登陆界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/main.css"/>
</head>
<body class="mediawiki ltr ns-0 ns-subject page-Slave_Knight_Gael  MiniEditor oasis-breakpoints skin-oasis oasis-dark-theme  user-anon background-fixed wiki-darksouls">

<div class="background-image-gradient"></div>

<div class="WikiaSiteWrapper">
	<header class="wds-community-header">
		<div class="wds-community-header__wordmark" data-tracking="wordmark-image">
			<img src="images/logo.png" width="243" height="50">
		</div>
	</header>


	<section id="WikiaPage" class="WikiaPage V2" onclick="">
		<div class="WikiaPageContentWrapper">
			<header id="PageHeader" class="page-header">
				<div class="page-header__main">
					<h1 class="page-header__title">>>>登陆</h1>
				</div>
			</header>
			<hr class="page-header__separator">
		</div>

		<form action="login" method="post">
			<table align="center">
				<tr><td align="center">用户名:<input type="text" name="id">
				</td></tr>
				<tr><td align="center">密     码:<input type="password" name="password">
				</td></tr>
				<tr><td><input type="submit" value="登陆" id="textfield" align="center">
				</td></tr>
			</table>
		</form>

		<div id="WikiaPageBackground" class="WikiaPageBackground"></div>

	</section>


</div>
</body>
</html>

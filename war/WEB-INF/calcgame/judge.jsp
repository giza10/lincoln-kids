<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
  content="width=320px, initial-scale=1, minimum-scale=1, maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" href="/stylesheets/iphone.css" />
<title>けいさんゲーム</title>
</head>
<body>
<div id="header">
<h1>だい１もん　けっか</h1>
</div>
<p align="center">
<c:if test="${is_correct}">
<img alt="せいかい！" src="/calcgame/images/correct.jpg">
</c:if>
<c:if test="${!is_correct}">
<img alt="ざんねん！" src="/calcgame/images/incorrect.gif">
</c:if>
</p>
<ul>
<li><a href="/calcgame/main">つぎ　の　もんだい　へ</a></li>
</ul>
</body>
</html>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
  content="width=320px, initial-scale=1, minimum-scale=1, maximum-scale=1,user-scalable=no" />
<title>Just Stop</title>
<link rel="stylesheet" href="/juststop/css/main.css" type="text/css"></link>
<script type="text/javascript"
  src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="/juststop/js/main.js"></script>
</head>
<body>

<!-- 発進画面 -->
<div id="screen1">
  <img id="cartop" src="/juststop/img/cartop.gif" /> <!-- ミニカー（上から） -->
  <input id="go" type="button" value="GO!" /> <!-- GOボタン -->
</div>

<!-- 走行画面 -->
<div id="screen2">
  <div id="updating"></div>
  <div id="sideview">
    <img id="carside" src="/juststop/img/carside.gif" /> <!-- ミニカー（横から） -->
    <img id="object" src="/juststop/img/object.gif" /> <!-- ペン立て -->
    <div id="road"></div> <!-- 机の画像 -->
  </div>
  <div id="infoview">
    <span id="score">あと 000.0cm</span><br />
    <input id="retry" type="button" value="再挑戦" /><br />
    <!-- 記録登録ボタンはログインしていないと押せない -->
    <input id="register" type="button" value="記録登録" <c:if test="${empty user}">disabled="disabled"</c:if> />
    <input id="ranking" type="button" value="ランキング" />
  </div>
</div>
</body>
</html>

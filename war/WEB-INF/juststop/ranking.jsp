<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.
org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta id="viewport" name="viewport"
  content="width=320; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
<title>Just Stop - Ranking</title>
<link rel="stylesheet" href="/stylesheets/iphone.css" />
</head>
<body>
<div id="header" class="pre">
<h1>ランキング</h1>
<p><c:out value="${date}" /></p>
<a href="#" id="backButton" onClick="window.close(); return false;">閉じる</a>
</div>
<ul>
  <!-- 検索結果を表示する -->
  <c:forEach var="score" varStatus="status" items="${scores}">
    <li><small><c:out value="${score.leftLength}" /> cm</small>
      <c:out value="${status.index + 1}" />位: <c:out value="${score.nickname}" />
    </li>
  </c:forEach>
</ul>
</body>
</html>

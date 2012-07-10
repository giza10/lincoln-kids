
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
  content="width=320px, initial-scale=1, minimum-scale=1, maximum-scale=1,user-scalable=no" />
<title>けいさんゲーム</title>
<link rel="stylesheet" href="/stylesheets/iphone.css" />
<script type="text/javascript"
  src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="/calcgame/js/main.js"></script>
</head>
<body>
<div id="header" class="pre">
<h1>第１問</h1>
</div>

<c:forEach var="question" varStatus="status" items="${questionSet}">
<div id="question-<c:out value='${status.index + 1}'/>">
<h1><c:out value="${question.question}"/></h1>
<ul>
  <li><a href="/calcgame/judge"><c:out value="${question.ans1}"/></a></li>
  <li><a href="/calcgame/judge"><c:out value="${question.ans2}"/></a></li>
  <li><a href="/calcgame/judge"><c:out value="${question.ans3}"/></a></li>
  <li><a href="/calcgame/judge"><c:out value="${question.ans4}"/></a></li>
</ul>
</div>
</c:forEach>
</body>

</html>
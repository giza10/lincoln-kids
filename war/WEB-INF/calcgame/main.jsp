
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
<h1 id="question-title">だい １ もん</h1>
</div>


<c:forEach var="question" varStatus="status" items="${questionSet}">
<div id="question-<c:out value='${status.index + 1}'/>">
<h1 id="question-expression-<c:out value='${status.index + 1}'/>" style='padding-left: 20px'><c:out value="${question.question}"/></h1>
<ul>
  <li><a href="#" onclick="judge(0, <c:out value="${question.correctAnsIdx}"/>)" style='font-size: 24px'><c:out value="${question.answerList[0]}"/></a></li>
  <li><a href="#" onclick="judge(1, <c:out value="${question.correctAnsIdx}"/>)" style='font-size: 24px'><c:out value="${question.answerList[1]}"/></a></li>
  <li><a href="#" onclick="judge(2, <c:out value="${question.correctAnsIdx}"/>)" style='font-size: 24px'><c:out value="${question.answerList[2]}"/></a></li>
  <li><a href="#" onclick="judge(3, <c:out value="${question.correctAnsIdx}"/>)" style='font-size: 24px'><c:out value="${question.answerList[3]}"/></a></li>
</ul>
</div>
</c:forEach>

<div id="judge">
<ul>
<li><a href="#" onclick="goNext()" id="gonext">つぎ　の　もんだい　へ</a></li>
</ul>
<p align="center">
<img id="correctImage" alt="せいかい！" src="/calcgame/images/correct.jpg">
<img id="incorrectImage" alt="ざんねん！" src="/calcgame/images/incorrect.gif">
</p>
</div>

<div id="result">
<p align="center">
<span id="score" style="font-size:40pt">>100 てん</span>
</p>
<ul>
<li><a href="/calcgame/main">もう　１かい</a></li>
<li><a href="/index">スタートがめん　へ</a></li>
</ul>
</div>

</body>

</html>
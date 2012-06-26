<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String question = (String) request.getAttribute( "Question" );
    Integer ans1 = (Integer) request.getAttribute( "ans1" );
    Integer ans2 = (Integer) request.getAttribute( "ans2" );
    Integer ans3 = (Integer) request.getAttribute( "ans3" );
    Integer ans4 = (Integer) request.getAttribute( "ans4" );
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
  content="width=320px, initial-scale=1, minimum-scale=1, maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" href="/stylesheets/iphone.css" />
<title>けいさんゲーム</title>
</head>
<body>
<div id="header" class="pre">
<!-- 
<p>
<c:if test="${not empty user}">
<c:out value="${nickname}" />
</c:if>
<c:if test="${empty user}">
ログインしていません
</c:if>
</p>
 -->
<h1>第１問</h1>
</div>
<h1><% out.println(question); %></h1>
<ul>
<li><a href="/calcgame/judge"><% out.println(ans1); %></a></li>
<li><a href="/calcgame/judge"><% out.println(ans2); %></a></li>
<li><a href="/calcgame/judge"><% out.println(ans3); %></a></li>
<li><a href="/calcgame/judge"><% out.println(ans4); %></a></li>
</ul>
</body>
</html>
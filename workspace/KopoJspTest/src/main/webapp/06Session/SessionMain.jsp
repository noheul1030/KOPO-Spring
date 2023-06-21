<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*, java.util.*" %>
<%
// 날짜 표시 형식
SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

// 최초 세션 요청 시각 생성
long createTime = session.getCreationTime();
String creationTimeStr = dateFormat.format(new Date(createTime));

long lastTime = session.getLastAccessedTime(); // 마지막 요청 시각
String lastTimeStr = dateFormat.format(new Date(lastTime));

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 시간 확인</title>
</head>
<body>
	<h2>설정 값 확인</h2>
	<ul>
		<li>세션 유지 시간 : <%= session.getMaxInactiveInterval() +"초"%></li>
		<li>세션 아이디 : <%= session.getId() %></li>
		<li>세션 요청시각 : <%= creationTimeStr %></li>
		<li>세션 마지막 요청시각 : <%= lastTimeStr %></li>
	</ul>

</body>
</html>
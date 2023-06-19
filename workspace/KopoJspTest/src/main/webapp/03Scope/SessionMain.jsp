<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
ArrayList<String> lists = new ArrayList<String>();
lists.add("노을");
lists.add("리스트");
lists.add("컬렉션");
session.setAttribute("lists",lists);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session scope</title>
</head>
<body>

	<h2>page 이동 후 session 영역 확인</h2>
	<a href="SessionLocation.jsp"> SessionLocation page로 이동</a>

</body>
</html>
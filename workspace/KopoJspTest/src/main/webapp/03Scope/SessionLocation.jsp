<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionLocation</title>
</head>
<body>
	<h2> 페이지 이동 후 session 처리 확인</h2>
<%
	ArrayList<String> lists = (ArrayList<String>)session.getAttribute("lists");

	for(String str : lists){
		out.print(str);
		out.print("<br>");
	}
%>

</body>
</html>
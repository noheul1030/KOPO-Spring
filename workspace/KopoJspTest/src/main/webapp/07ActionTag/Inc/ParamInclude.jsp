<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인클루드 된 페이지에서 변수 확인</title>
</head>
<body>
	<h2> 매개변수 확인</h2>
	<%= request.getParameter("loc1") %>
	<%= request.getParameter("loc2") %>

</body>
</html>
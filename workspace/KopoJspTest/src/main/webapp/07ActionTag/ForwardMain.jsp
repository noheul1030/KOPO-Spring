<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("pAttr","김유신");
request.setAttribute("rAttr","계백");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 - forward</title>
</head>
<body>
	<h2>액션태그로 포워딩하기</h2>
	<jsp:forward page="ForwardSub.jsp"/>
</body>
</html>
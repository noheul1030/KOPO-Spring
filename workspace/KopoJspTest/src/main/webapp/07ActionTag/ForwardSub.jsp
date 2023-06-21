<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - 서브포워드</title>
</head>
<body>
	<h2>포워딩 결과</h2>
	<ul>
		<li>page : <%=pageContext.getAttribute("pAttr") %></li>
		<li>request : <%=request.getAttribute("rAttr") %></li>
	</ul>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 영역</title>
</head>
<body>
	<h2>페이지 이동 후 page 영역 값 읽기</h2>
<%
	Object pInt = pageContext.getAttribute("pageInt");
	Object pString = pageContext.getAttribute("pageStr");
	Object pPerson = pageContext.getAttribute("pagePerson");
	
%>	
	<ul>
		<li>Integer Obj = <%=(pInt == null)? "값 없음": pInt %></li>
		<li>String Obj = <%=(pString == null)? "값 없음": pString%></li>
		<li>Person Obj = <%=(pPerson == null)? "값 없음": ((Person)pPerson).getName()%></li>
	</ul>	
	
	
	
</body>
</html>
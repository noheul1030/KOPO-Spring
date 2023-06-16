<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include page</title>
</head>
<body>
<%

	int pInt2 = (Integer)(pageContext.getAttribute("pageInt"));
	String pString2 = pageContext.getAttribute("pageStr").toString();
	Person pPerson2 = (Person)(pageContext.getAttribute("pagePerson"));
	
%>	
	<ul>
		<li>Integer Obj = <%=pInt2 %></li>
		<li>Integer Obj = <%=pString2 %></li>
		<li>Integer Obj = <%=pPerson2.getName() %>,<%=pPerson2.getAge() %></li>
	</ul>
</body>
</html>
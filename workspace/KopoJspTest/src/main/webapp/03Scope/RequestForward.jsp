<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Person rePerson = (Person)(request.getAttribute("requestPerson"));
%>
	<ul>
		<li>String : <%=request.getAttribute("requestStr")%></li>
		<li>Person : <%=rePerson.getName()%>,<%=rePerson.getAge()%></li>
	</ul>
<%	
	request.setCharacterEncoding("UTF-8");
	out.println(request.getParameter("param1"));
	out.println(request.getParameter("param2"));
%>
</body>
</html>
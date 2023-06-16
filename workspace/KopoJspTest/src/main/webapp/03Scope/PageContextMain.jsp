<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person"%>

<%
	pageContext.setAttribute("pageInt",10);
	pageContext.setAttribute("pageStr","페이지저장");
	pageContext.setAttribute("pagePerson",new Person("kopo",50));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>page 값 가져와 출력하기</h2>
<%
	int pInt = (Integer)(pageContext.getAttribute("pageInt"));
	String pString = pageContext.getAttribute("pageStr").toString();
	Person pPerson = (Person)(pageContext.getAttribute("pagePerson"));
	
%>	
	<ul>
		<li>Integer Obj = <%=pInt %></li>
		<li>Integer Obj = <%=pString %></li>
		<li>Integer Obj = <%=pPerson.getName() %>,<%=pPerson.getAge() %></li>
	</ul>
<%
	out.println(pageContext.getAttribute("pageInt"));
	out.println("<br>");
	out.println(pageContext.getAttribute("pageStr"));
	out.println("<br>");
	out.println(pageContext.getAttribute("pagePerson"));
%>
	
	<h2>include 된 페이지에서 출력 값 확인</h2>
<%@ include file = "PageInclude.jsp" %>
	
	<h2>단순 페이지 이동 후 pageContext 데이터 확인</h2>
	<a href="PageLocation.jsp">PageLocation.jsp 바로가기</a>
	
	
	
	

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
pageContext.setAttribute("scopeVal","페이지 영역");
request.setAttribute("scopeVal","리퀘스트 영역");
session.setAttribute("scopeVal","세션 영역");
application.setAttribute("scopeVal","애플리케이션 영역");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ImplicitObjMain.jsp</title>
</head>
<body>
	<h2>내장객체 EL 표현</h2>
	<h3>영역별 저장값 읽기</h3>
	<ul>
		<li>페이지영역 : ${ pageScope.scopeVal } </li>
		<li>페이지영역 : ${ requestScope.scopeVal } </li>
		<li>페이지영역 : ${ sessionScope.scopeVal } </li>
		<li>페이지영역 : ${ applicationScope.scopeVal } </li>	
	</ul>

	<h3>영역의 우선권은 누구?</h3>
	<li>${ scopeVal }</li>
	
	<jsp:forward page = "ImplicitForwardResult.jsp"/>
</body>
</html>
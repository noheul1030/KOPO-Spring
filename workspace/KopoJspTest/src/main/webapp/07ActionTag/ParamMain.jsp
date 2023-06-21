<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 포워드하기 전 한글문자는 인코딩 필수
//request.setCharacterEncoding("UTF-8"); // web.xml에 인코딩 정의 해놓음
String pValue = "방랑시인";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 - param</title>
</head>
<body>
	<jsp:useBean id="person" class="common.Person" scope="request" />
	<jsp:setProperty name="person" property='name' value="김삿갓"/>
	<jsp:setProperty name="person" property='age' value="97"/>
	<jsp:forward page="ParamForward.jsp?param1=김정호" >
		<jsp:param name="param2" value="경기도 양주" />
		<jsp:param name="param3" value="<%=pValue%>" />
	</jsp:forward>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
pageContext.setAttribute("scopeVal","������ ����");
request.setAttribute("scopeVal","������Ʈ ����");
session.setAttribute("scopeVal","���� ����");
application.setAttribute("scopeVal","���ø����̼� ����");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ImplicitObjMain.jsp</title>
</head>
<body>
	<h2>���尴ü EL ǥ��</h2>
	<h3>������ ���尪 �б�</h3>
	<ul>
		<li>���������� : ${ pageScope.scopeVal } </li>
		<li>���������� : ${ requestScope.scopeVal } </li>
		<li>���������� : ${ sessionScope.scopeVal } </li>
		<li>���������� : ${ applicationScope.scopeVal } </li>	
	</ul>

	<h3>������ �켱���� ����?</h3>
	<li>${ scopeVal }</li>
	
	<jsp:forward page = "ImplicitForwardResult.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ImplicitForwardResult.jsp</title>
</head>
<body>
	<h2>ImplicitForwardResult ������</h2>
	<h3>�������� ����� �Ӽ� �б�</h3>
	<ul>
		<li>������ ���� : ${ pageScope.scopeVal }</li>
		<li>������Ʈ ���� : ${ requestScope.scopeVal }</li>
		<li>���� ���� : ${ sessionScope.scopeVal }</li>
		<li>���ø����̼� ���� : ${ applicationScope.scopeVal }</li>
	</ul>
	
	<h3> ������� �������� ���� �켱���� ����?</h3>
	<li>${ scopeVal }</li>

</body>
</html>
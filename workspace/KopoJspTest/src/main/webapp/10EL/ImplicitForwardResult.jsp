<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ImplicitForwardResult.jsp</title>
</head>
<body>
	<h2>ImplicitForwardResult 페이지</h2>
	<h3>영역별로 저장된 속성 읽기</h3>
	<ul>
		<li>페이지 영역 : ${ pageScope.scopeVal }</li>
		<li>리퀘스트 영역 : ${ requestScope.scopeVal }</li>
		<li>세션 영역 : ${ sessionScope.scopeVal }</li>
		<li>애플리케이션 영역 : ${ applicationScope.scopeVal }</li>
	</ul>
	
	<h3> 포워드된 페이지의 영역 우선권은 누구?</h3>
	<li>${ scopeVal }</li>

</body>
</html>
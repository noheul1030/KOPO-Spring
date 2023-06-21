<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 - 자바빈즈</title>
</head>
<body>
	<h2>UseBean 액션태그</h2>
	<jsp:useBean id="person" class="common.Person" scope="request"></jsp:useBean>

	<h3>setProperty 사용</h3>
	<jsp:setProperty name="person" property="name" value="임꺽정" />
	<jsp:setProperty name="person" property="age" value="40" />
	
	<h3>getProperty 값 가져오기</h3>
	<ul>
		<li> 이름 : <jsp:getProperty name="person" property="name" /></li>
		<li> 나이 : <jsp:getProperty name="person" property="age" /></li>
	</ul>
</body>
</html>
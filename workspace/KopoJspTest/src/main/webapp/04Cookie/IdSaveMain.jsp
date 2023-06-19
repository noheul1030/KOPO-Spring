<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "utils.CookieManager" %>

<%
String loginId = CookieManager.readCookie(request, "loginId");

String cookieCheck = "";
	if(!loginId.equals("")){
		cookieCheck = "checked";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키로 아이디 저장하기</title>
</head>
<body>
	<h2> 로그인 페이지</h2>
	<form action = "IdSaveProcess.jsp" method = 'post'>
		<span>아이디 : </span><input type='text' name='user_id' value="<%= loginId%>" required />
		<span>자동로그인 </span><input type='checkbox' name='save_check' value='Y'<%=cookieCheck%>> <!-- 아이디저장 -->
		<br>
		<span width='100'>패스워드 : </span><input type='text' name='user_pw' value='' required />
		<br>		
		<input type='submit' value='로그인하기' />
		
	</form>


</body>
</html>
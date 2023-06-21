<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session login</title>
	<style>
	  	.fourth{
		  background: gold;
		  border-color: white;
		  color: black;
		  background-image: linear-gradient(45deg, yellow 50%, transparent 50%);
		  background-position: 100%;
		  background-size: 400%;
		  transition: background 300ms ease-in-out;
		  border-radius: 5px;
		}
		.fourth:hover {
		  background-position: 0;
		}
	
	</style>
</head>
<body>
	<jsp:include page='../Common/Link.jsp'/> <!-- 공통 링크 적용 -->
	<h2>로그인 페이지</h2>
	<span style="color : red; font-size: 1.2em;">
	<%= request.getAttribute("LoginErrMsg") == null?
			"" : request.getAttribute("LoginErrMsg")%>
	</span>
	
<% // 로그인 상태 확인
  if (session.getAttribute("UserId") == null){ %>
	<script>
	function validateForm(form){
		if(!form.user_id.value){
			alert("아이디를 입력하세요.");
			return false;
		}
		if(form.user_pw.value == ""){
			alert("패스워드를 입력해주세요.");
			return false;
		}
	}
	</script>
	
	<form action='LoginProcess.jsp' method= 'post' name='loginFrm' onsubmit= 'return validateForm(this);'>
		아 이 디 : <input type='text' name='user_id'/><br>
		패스워드 : <input type='text' name='user_pw'/><br>
		<input class='fourth' type='submit' value='로그인' style="width:80px; height: 30px; font-weight: bold;"/>
	</form>
<% }else { %>
	<%= session.getAttribute("UserName") %> 회원님. 로그인 하셨습니다. <br>
	<a href='Logout.jsp'> [로그아웃]</a>
<% } %>
</body>
</html>
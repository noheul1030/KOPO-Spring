<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception 처리</title>
</head>
<body>
<%
	int status = response.getStatus(); // response 내장 객체로부터 에러 코드 확인
	if(status == 404){
		out.print("404 에러가 발생하였습니다.");
		out.print("<br/>파일 경로를 확인해 주세요.");
	}else if(status == 405){
		out.print("404 에러가 발생하였습니다.");
		out.print("<br/>요청 방식(method)를 확인해 주세요.");
	}else if(status == 500){
		out.print("404 에러가 발생하였습니다.");
		out.print("<br/>소스 코드에 오류가 없는지 확인해 주세요.");
	}
%>

</body>
</html>
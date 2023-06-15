<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="isErrorPage.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어 - errorPage, isErrorPage 속성</title>
</head>
<body>
<%
/* try{
	int myAge = Integer.parseInt(request.getParameter("age")) + 10;  // 에러 발생
	out.println("10년 후 당신의 나이는 " + myAge + "입니다.");  // 실행되지 않음
}catch(Exception e){
	out.println("예외가 발생했습니다.");
} */
int myAge = Integer.parseInt(request.getParameter("age")) + 10;  // 에러 발생
out.println("10년 후 당신의 나이는 " + myAge + "입니다.");  // 실행되지 않음
%>
</body>
</html>
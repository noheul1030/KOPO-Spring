<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 세션에 저장된 클라이언트 속성 삭제
//session.removeAttribute("UserId");
//session.removeAttribute("UserName");

// 세션의 속성 모두 삭제
session.invalidate();
response.sendRedirect("LoginForm.jsp");

%>
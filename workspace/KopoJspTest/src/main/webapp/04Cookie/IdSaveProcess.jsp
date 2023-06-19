<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "utils.CookieManager" %>
<%@ page import = "utils.JSFunction" %>
    
<%
// form의 값을 read
String user_id = request.getParameter("user_id");
String user_pw = request.getParameter("user_pw");
String save_check = request.getParameter("save_check");

if("kopo".equals(user_id) && "1234".equals(user_pw)){
	if(save_check != null && save_check.equals("Y")){
		CookieManager.makeCookie(response, "loginId", user_id, 60*60*24); // 쿠키 만들기
			
	}else{
		CookieManager.deleteCookie(response, "loginId"); // 쿠키제거
	}
	JSFunction.alertLocation("로그인 성공","IdSaveMain.jsp",out);
}else{
	JSFunction.alertBack("로그인 실패",out);
}
%>
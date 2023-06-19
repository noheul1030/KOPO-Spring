<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

String chkVal = request.getParameter("inactiveToday");
if(chkVal != null && chkVal.equals("1")){
	Cookie cookie = new Cookie("PopupMode","off");
	cookie.setPath(request.getContextPath());
	cookie.setMaxAge(60*60*24); // 24시간
	response.addCookie(cookie);
	
	out.print("24시간 동안 팝업 열리지 않음");
}
%>


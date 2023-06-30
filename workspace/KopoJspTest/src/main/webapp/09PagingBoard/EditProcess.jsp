<%@ page import="model1.BoardDAO"%>
<%@ page import="model1.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./IsLoggedIn.jsp"%>

<%
// 폼값 받기
request.setCharacterEncoding("utf-8");
String num = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");
String ID = session.getAttribute("UserId").toString();

//폼값을 DTO 객체에 저장
BoardDTO dto = new BoardDTO();
dto.setId(session.getAttribute("UserId").toString());

// DAO 객체를 통해 DB에 DTO 저장
BoardDAO dao = new BoardDAO(application);
int iResult = dao.updateWrite(ID, num, title, content);
dao.close();

// 성공 or 실패? 
if (iResult == 1) {
	response.sendRedirect("List.jsp");
} else {
	JSFunction.alertBack("수정에 실패하였습니다.", out);
}
%>
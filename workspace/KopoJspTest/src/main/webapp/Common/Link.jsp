<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<table border='1' width='90%'>
	<tr>
		<td align='center'>
		<% if (session.getAttribute("UserId") == null) {%>
			<a href='../06Session/LoginForm.jsp'>로그인</a>
<%		} else { %>
			<a href='../06Session/Logout.jsp'>로그아웃</a>
<%		} %>
		</td>
	</tr>	
</table>
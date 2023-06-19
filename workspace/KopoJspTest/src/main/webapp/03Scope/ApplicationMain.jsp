<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application scope</title>
</head>
<body>

	<h2>application 영역 확인</h2>

<%
	Map<String,Person> maps = new HashMap<>();
	maps.put("Aclass",new Person("이수일",20));
	maps.put("Bclass",new Person("김희애",30));
	
	// application 영역에 저장하기 - name : maps
	application.setAttribute("maps", maps);	
%>
	<!-- applicationResult.jsp 생성 후 출력 --> 
	<h2>page 이동 후 application 영역 확인</h2>
	<a href="applicationResult.jsp"> applicationResult.jsp page로 이동</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application</title>
</head>
<body>
	<h2> application 저장 결과 출력</h2>
<%
	Map<String,Person> maps = (Map<String,Person>)application.getAttribute("maps");
	Set<String> keys = maps.keySet();
	
	for(String key : keys){
		Person person = maps.get(key);
		out.print(String.format("이름 : %s, 나이 : %d",person.getName(),person.getAge()));
		out.print("<br>");
	}
%>

</body>
</html>
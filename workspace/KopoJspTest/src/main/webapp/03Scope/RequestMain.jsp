<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person"%>
    
<%	
// 1. "request" 라는 문자열을 name은 requestStr 로 저장
request.setAttribute("requestStr", "request");
request.getAttribute("requestStr");

// 2. Person 객체 저장 (본인이름, 나이는 20)
request.setAttribute("requestPerson", new Person("노을",33));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request scope</title>
</head>

<body>
	<h2> request 영역 확인</h2>
<%
	// 저장된 데이터 불러와서 출력
	request.removeAttribute("requestStr"); // 저장된 변수를 삭제 시도
	request.removeAttribute("requestInt"); // 없는 변수를 삭제 시도
	Person rePerson = (Person)(request.getAttribute("requestPerson"));
%>
	<ul>
		<li>String requestStr : <%=request.getAttribute("requestStr")%></li>
		<li>Person requestPerson : <%=rePerson.getName()%>,<%=rePerson.getAge()%></li>
	</ul>
	
	<h2>request 영역 속성 전달 - 포워드 활용</h2>
<%
	request.getRequestDispatcher("RequestForward.jsp?param1=한글&param2=eng")
		.forward(request,response);
%>

</body>
</html>
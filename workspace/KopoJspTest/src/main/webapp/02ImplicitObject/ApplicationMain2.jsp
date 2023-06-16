<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>web.xml 설정 값 읽어오기</h2>
	초기화 매개변수 : <%= application.getInitParameter("INIT_PARAM1") %>
	초기화 매개변수 : <%= application.getInitParameter("INIT_PARAM2") %>
	초기화 매개변수 : <%= application.getInitParameter("INIT_PARAM3") %>
	초기화 매개변수 : <%= application.getInitParameter("INIT_PARAM4") %>

	<h2>서버 물리적 경로 읽어오기</h2>
	<!-- 컨텍스트 루트 경로 외한 경로 -->
	경로 주소 : <%= application.getRealPath("/02ImplicitObject") %>

	<h2>선언부 application 객체 사용</h2>
	<%!
		public String useImplicitObject(){
			return this.getServletContext().getRealPath("/02ImplicitObject");
		}
		public String useImplicitObject(ServletContext app){
			return app.getRealPath("/02ImplicitObject");
		}
	%>
	<ul>
		<li> this 사용 : <%= useImplicitObject()%> </li>
		<li> 내장객체 전달 : <%= useImplicitObject(application)%> </li>
	
	</ul>
</body>
</html>
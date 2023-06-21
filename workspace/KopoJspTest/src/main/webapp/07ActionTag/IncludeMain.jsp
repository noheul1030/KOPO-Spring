<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String outPath1 = "./Inc/OuterPage1.jsp";
String outPath2 = "./Inc/OuterPage2.jsp";

pageContext.setAttribute("pAttr","동명왕");
request.setAttribute("rAttr","온조왕");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>지시어 VS 액션태그 방식 비교</h2>

	<h3>지시어로 페이지 포함</h2>
	<%@ include file="./Inc/OuterPage1.jsp" %>
	<p> 외부파일 변수 : <%=newVar1%></p>
	<br>
	
	
	<h3>액션태그로 페이지 포함</h2>
	<jsp:include page="./Inc/OuterPage2.jsp"/>
	<jsp:include page="<%= outPath2 %>"/>
	
	
	<%-- <p> 외부파일 변수 : <%=newVar2%></p> 서로 호환이 불가능하다 이 방법은 사용할 수 없음--%>
		
<!-- 1. 지시어로  include 
	 2. newVal1 출력
	 3. 지시어로  include : 표현식으로 경로 지정
	 4. 액션태그로 include
	 5. 액션태그로 include : 표현식으로 경로 지정
	 6. newVal2 출력
	 -->
</body>
</html>
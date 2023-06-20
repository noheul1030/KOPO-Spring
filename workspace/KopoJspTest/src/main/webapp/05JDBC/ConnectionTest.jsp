<%@ page import = "common.JDBConnect, common.DBConnPool" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연결 테스트</title>
</head>
<body>
	<h2> JDBC TEST 1</h2>
<%
	JDBConnect jdbc = new JDBConnect(); // 접속 시도
	jdbc.close(); // 해제 시도 
%>


	<h2> JDBC TEST 2</h2>
<%
	String driver = application.getInitParameter("OracleDriver"); // 오라클 드라이버
	String url = application.getInitParameter("OracleURL"); // 호스트 URL 주소 
	String id = application.getInitParameter("OracleID"); // kopo
	String pwd = application.getInitParameter("OraclePwd"); // 1234
	
	JDBConnect jdbc2 = new JDBConnect(driver,url,id,pwd); // 접속 시도
	jdbc2.close(); // 해제 시도 
%>

	<h2> JDBC TEST 3</h2>
<%
	JDBConnect jdbc3 = new JDBConnect(application); // 접속 시도
	jdbc3.close(); // 해제 시도 
%>


	<h2> JDBC TEST 4</h2>
<%
	DBConnPool jdbc4 = new DBConnPool(); // 접속 시도
	jdbc4.close(); // 해제 시도 
%>

</body>
</html>
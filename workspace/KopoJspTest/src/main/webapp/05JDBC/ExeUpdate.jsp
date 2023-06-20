<%@ page import = "common.JDBConnect, common.DBConnPool" %>
<%@ page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jdbc update</title>
</head>
<body>
	<h2>회원 추가 - executeUpdate() 함수 사용</h2>
<%
	// DB 연결
	JDBConnect jdbc = new JDBConnect();
	
	// 입력 데이터 준비
	String id = "test2";
	String pass = "2222";
	String name = "테스트2";	
	
 	// 쿼리 생성
	String sql = "insert into member values (?,?,?, sysdate)";
	PreparedStatement psmt = jdbc.con.prepareStatement(sql);
	psmt.setString(1,id);
	psmt.setString(2,pass);
	psmt.setString(3,name);
	
	// 쿼리 작업 실시
	int inResult = psmt.executeUpdate();
	out.println(inResult + " row 행 입력 완료");
		 
	// 연결 닫기
	jdbc.close();
%>	


</body>
</html>
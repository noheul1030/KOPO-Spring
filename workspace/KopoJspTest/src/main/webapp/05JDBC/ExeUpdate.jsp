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
	<h2>ȸ�� �߰� - executeUpdate() �Լ� ���</h2>
<%
	// DB ����
	JDBConnect jdbc = new JDBConnect();
	
	// �Է� ������ �غ�
	String id = "test2";
	String pass = "2222";
	String name = "�׽�Ʈ2";	
	
 	// ���� ����
	String sql = "insert into member values (?,?,?, sysdate)";
	PreparedStatement psmt = jdbc.con.prepareStatement(sql);
	psmt.setString(1,id);
	psmt.setString(2,pass);
	psmt.setString(3,name);
	
	// ���� �۾� �ǽ�
	int inResult = psmt.executeUpdate();
	out.println(inResult + " row �� �Է� �Ϸ�");
		 
	// ���� �ݱ�
	jdbc.close();
%>	


</body>
</html>
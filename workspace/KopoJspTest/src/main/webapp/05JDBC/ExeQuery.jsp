<%@ page import = "common.JDBConnect, common.DBConnPool" %>
<%@ page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DB ��ȸ</title>
</head>
<body>
	<h2>��� ��ȸ (executeQuery() ���)</h2>
<%
	// DB ����
	JDBConnect jdbc = new JDBConnect();

	Statement stmt = jdbc.con.createStatement();
	//stmt.execute("delete from member where ID = 'test2'");

	String sql = "select * from member";	
	
	ResultSet rset = stmt.executeQuery(sql);
	
	while(rset.next()){
		String id = rset.getString(1);
		String pw = rset.getString(2);
		String name = rset.getString(3);
		java.sql.Date regidate = rset.getDate("regidate");
		
		out.println(String.format("%s / %s / %s / %s",id,pw,name,regidate)+"<br>");
	} 
	 
	// ���� �ݱ�
	jdbc.close();
%>	


</body>
</html>
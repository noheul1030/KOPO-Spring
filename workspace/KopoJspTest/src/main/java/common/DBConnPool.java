package common;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnPool {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rset;
	
	public DBConnPool() {
		try {
			// 커넥션 풀을 얻어오기
			Context initCtx = new InitialContext();
			Context ctx = (Context)initCtx.lookup("java:comp/env"); // 웹 루트 경로
			DataSource source = (DataSource)ctx.lookup("dbcp_myoracle");
			// 커넥션  풀로 연결
			con = source.getConnection();
			System.out.println("커넥션 풀로 연결");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void close() { // 연결 해제 -> 자원을 반납
		try {
			if (rset != null)
				rset.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();
			System.out.println("커넥션풀 자원 반납");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

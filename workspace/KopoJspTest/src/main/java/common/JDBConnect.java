package common;

import java.sql.*;

import javax.servlet.ServletContext;

public class JDBConnect {
	public Connection con; // DB 연결
	public Statement stmt; // 파라미너가 없는 쿼리문
	public PreparedStatement psmt; // 파라미터가 없는 쿼리문(동적)
	public ResultSet rset; // 쿼리문 결과 저장

	public JDBConnect() { // 생성자
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");

			// 드라이버 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "kopo11";
			String pwd = "1234";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공 - 기본 생성자");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			// 드라이버 로드
			Class.forName(driver);
//
//			// 드라이버 연결
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String id = "kopo11";
//			String pwd = "1234";
			
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공 - 4개의 파라미터");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JDBConnect(ServletContext application) {
		try {
			String driver = application.getInitParameter("OracleDriver"); // 오라클 드라이버
			Class.forName(driver);
			
			String url = application.getInitParameter("OracleURL"); // 호스트 URL 주소 
			String id = application.getInitParameter("OracleID"); // kopo
			String pwd = application.getInitParameter("OraclePwd"); // 1234
			
			con  = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공 - application 직접 접근");
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
			System.out.println("자원 해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

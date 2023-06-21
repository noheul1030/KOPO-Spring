package model1;

import java.util.*;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoardDAO extends JDBConnect {
	
	public BoardDAO(ServletContext application) {
		super(application);
	}
	
	
	
	// 검색 후 조건에 맞는 게시물 개수를 반환
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0; // 게시물 개수 담을 변수
		String query = "select count(*) from board";
		
		if(map.get("serchWord") != null) {
			query += " where " + map.get("serchField") + " "
					+ " like '%" + map.get("serchWord") + "%'";			
		}		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			rset.next(); // 커서의 위치가 맨 첫 행으로 이동
			totalCount = rset.getInt(1); // 첫번째 칼럼에서 값 가져오기
		}catch(Exception e) {
			System.out.println("게시물 개수 구하는 중 에러 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	
	
	public List<BoardDTO> selectList(Map<String, Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>(); // 결과 담을 변수
		
		String query = "select count(*) from board";
		
		if(map.get("serchWord") != null) {
			query += " where " + map.get("serchField") + " "
					+ " like '%" + map.get("serchWord") + "%'";			
		}
		query += " order by num desc ";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rset.getString("num"));
				dto.setTitle(rset.getString("title"));
				dto.setContent(rset.getString("content"));
				dto.setPostdate(rset.getDate("postdate"));
				dto.setId(rset.getString("id"));
				dto.setVisitcount(rset.getString("visitcount"));
				
				bbs.add(dto);
			}
		}catch(Exception e) {
			System.out.println("게시물 조회 중 에러 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
}

package kr.ac.kopo.ctc.kopo11.board.service;

import java.sql.ResultSet;

public interface BoardService {
	// 날짜
	String date();
	
	// 마지막 게시글 count
	int LastNumber();
	
	
	// 3. 공지번호,제목,날짜,내용 값 저장
	void newinsert(String title, String date, String content);
	void reinsert(String title, String date, String content, int rootid, int relevel, int recnt);
	
	// 4. 컬럼 삭제
	void delete(int id);		
		
	// 5. 컬럼 값 수정 update
	void update(int number,String title, String content);
	
	// 6. table 한건 조회
	ResultSet selectOne(String key);		
	
	// 7. 조회수 카운트
	void visit(String key);
}

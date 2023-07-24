package kr.ac.kopo.ctc.kopo11.board.service;

import java.sql.ResultSet;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Override // 날짜
	public String date() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // 마지막 게시글 count
	public int LastNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override // 3. 공지번호,제목,날짜,내용 값 저장
	public void newinsert(String title, String date, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override // 4. 컬럼 삭제
	public void reinsert(String title, String date, String content, int rootid, int relevel, int recnt) {
		// TODO Auto-generated method stub
		
	}

	@Override // 4. 컬럼 삭제
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override // 5. 컬럼 값 수정 update
	public void update(int number, String title, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override // 6. table 한건 조회
	public ResultSet selectOne(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // 7. 조회수 카운트
	public void visit(String key) {
		// TODO Auto-generated method stub
		
	}

	
}

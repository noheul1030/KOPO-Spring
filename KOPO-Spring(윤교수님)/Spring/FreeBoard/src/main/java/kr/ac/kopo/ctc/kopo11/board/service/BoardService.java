package kr.ac.kopo.ctc.kopo11.board.service;

import java.time.LocalDate;
import java.util.List;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;

public interface BoardService {
	// 날짜
	LocalDate date();
	
	// 게시글 임의등록 Test
	void insertTest();
	
	// New 게시글 등록 
	void newInsert(String title,String content);
	
	// 전체 게시물 조회
	List<BoardItem> findAll();

	// id값으로 삭제
	void deleteId(Integer id);		

	// id값으로 한건 조회
	BoardItem oneSelectView(Integer id);		
	
	// 조회수 카운트
	void visit(Integer id);
	
	
	
	
	
	
	
	
	// 마지막 게시글 count
	int LastNumber();
	
	
		
	// 5. 컬럼 값 수정 update
	void update(int number,String title, String content);

	
	

}

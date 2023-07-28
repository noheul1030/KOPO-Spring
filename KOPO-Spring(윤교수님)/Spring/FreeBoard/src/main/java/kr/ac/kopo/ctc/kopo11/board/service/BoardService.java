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
	public void newInsert(BoardItem board);
	
	// 전체 게시물 조회
	List<BoardItem> findAll();

	// id값으로 삭제
	void deleteId(Long id);		

	// id값으로 한건 조회
	BoardItem oneSelectView(Long id);		
	
	// 조회수 카운트
	void visit(Long id);	
	
//	//오토인크리먼트 값 가져오기
//	public int idCount();	
		
	// 컬럼 값 수정 update
	void update(BoardItem board);

}

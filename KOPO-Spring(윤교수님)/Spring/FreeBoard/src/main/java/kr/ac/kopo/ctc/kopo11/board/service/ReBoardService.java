package kr.ac.kopo.ctc.kopo11.board.service;

import java.time.LocalDate;
import java.util.List;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardComment;

public interface ReBoardService {
	// 날짜
	LocalDate reDate();
	
	// 전체 댓글 조회
	List<BoardComment> reFindAll();
	
	// id값으로 댓글 삭제
	void reDeleteId(BoardComment reBoard);		
	
	// 컬럼 댓글 값 수정 update
	void reUpdate(BoardComment reBoard);
	
	void saveComment(int id, BoardComment reBoard);
	
	List<BoardComment> reFindCommentById(long id);

}

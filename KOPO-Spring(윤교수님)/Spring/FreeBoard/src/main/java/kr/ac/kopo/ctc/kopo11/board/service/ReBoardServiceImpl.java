package kr.ac.kopo.ctc.kopo11.board.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardComment;
import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.repo.BoardRepository;
import kr.ac.kopo.ctc.kopo11.board.repo.ReBoardRepository;

@Service
public class ReBoardServiceImpl implements ReBoardService {

	@Autowired
	private ReBoardRepository reboardRepository;

	@Autowired
	private BoardRepository boardRepository;

	// 날짜
	@Override
	public LocalDate reDate() {
		LocalDate now = LocalDate.now();
		return now;
	}

	// 전체 댓글 조회
	@Override
	public List<BoardComment> reFindAll() {
		return (List<BoardComment>) reboardRepository.findAll();
	}

	// id값으로 댓글 삭제
	@Override
	public void reDeleteId(BoardComment reboard) {
		reboardRepository.deleteById(reboard.getReid());
	}

	// 컬럼 댓글 값 수정 update
	@Override
	public void reUpdate(BoardComment reBoard) {
		BoardComment reB = reboardRepository.findById(reBoard.getReid()).get();
		// 가져온 글에 수정한 내용을 세팅한다.
		reB.setRecontent(reBoard.getRecontent());
		// DB에 저장
		reboardRepository.save(reB);

	}

	// 댓글 저장
	@Override
	public void saveComment(int id, BoardComment reBoard) {
		BoardItem board = boardRepository.findById((long) id).get();

		BoardComment comment = new BoardComment();
		String date = LocalDate.now().toString();

		comment.setBoardItem(board);
		comment.setRecontent(reBoard.getRecontent());
		comment.setRedate(date);
		comment.setRootid((long) id);

		reboardRepository.save(comment);

	}

	@Override
	public List<BoardComment> reFindCommentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

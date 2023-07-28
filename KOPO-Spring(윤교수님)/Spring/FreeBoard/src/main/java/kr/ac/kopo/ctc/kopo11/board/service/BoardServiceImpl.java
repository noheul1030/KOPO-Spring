package kr.ac.kopo.ctc.kopo11.board.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.repo.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public BoardServiceImpl(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	public BoardServiceImpl() {
	}

	// 날짜
	@Override
	public LocalDate date() {
		LocalDate now = LocalDate.now();
		return now;
	}

	// 게시글 임의등록 Test
	@Override
	public void insertTest() {
		for (int i = 1; i <= 20; i++) {
			BoardItem board1 = new BoardItem();

			board1.setDate(String.valueOf(date()));
			board1.setContent("Test 게시글 입니다.");
			board1.setTitle("Test Title 입니다.");
			board1.setViewcnt(0);

			boardRepository.save(board1);
		}
	}

	// New 게시글 등록
	@Override
	public void newInsert(BoardItem board) {
		board.setViewcnt(0);

		boardRepository.save(board);
	}

	// 전체 게시물 조회
	@Override
	public List<BoardItem> findAll() {
//		PageRequest pageable = PageRequest.of(0, 20); // 페이지 번호 0부터 시작
//		Page<BoardItem> page = boardRepository.findAll(pageable);
//		return page.getContent();
		return (List<BoardItem>) boardRepository.findAll();
	}

	// id값으로 삭제
	@Override
	public void deleteId(Long id) {
		boardRepository.deleteById(id);
	}

	@Override // id값으로 한건 조회
	public BoardItem oneSelectView(Long id) {
		return boardRepository.findById(id).orElse(null);
	}

	@Override // id값으로 한건 조회 시 조회수 카운트
	public void visit(Long id) {
		BoardItem board = boardRepository.findById(id).orElse(null);
		if (board != null) {
			board.setViewcnt(board.getViewcnt() + 1);
			boardRepository.save(board);
		}
	}

//	@Override // id값으로 한건 조회 시 조회수 카운트
//	public int idCount() {
//		int number = 1;
//		try {
//			number = boardRepository.findNextAutoId();
//			return number;
//		} catch (Exception e) {
//		}
//		return number;
//	}

	@Override // 컬럼 값 수정 update
	public void update(BoardItem board) {
		BoardItem board2 = boardRepository.findById(board.getId()).get();
		// 가져온 글에 수정한 내용을 세팅한다.
		board2.setTitle(board.getTitle());
		board2.setContent(board.getContent());

        // DB에 저장
        boardRepository.save(board2);
	}
}

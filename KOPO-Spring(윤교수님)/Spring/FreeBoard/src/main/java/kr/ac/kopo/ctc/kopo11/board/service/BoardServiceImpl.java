package kr.ac.kopo.ctc.kopo11.board.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.repo.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository boardRepository;
	
	public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
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
		for(int i = 1; i <= 20; i++) {
			BoardItem board1 = new BoardItem();
				
			board1.setDate(date());
			board1.setContent("Test 게시글" + i + " 입니다.");
			board1.setTitle("Test Title 입니다.");
			board1.setViewcnt(0);
			
			boardRepository.save(board1);
		}
	}
	
	// New 게시글 등록 
	@Override
	public void newInsert(String title,String content) {
		BoardItem board1 = new BoardItem();
		
		board1.setDate(date());
		board1.setTitle(title);
		board1.setContent(content);
		board1.setViewcnt(0);
		
		boardRepository.save(board1);
	}

	// 전체 게시물 조회
	@Override
    public List<BoardItem> findAll() {
        PageRequest pageable = PageRequest.of(0, 10); // 페이지 번호 0부터 시작
        Page<BoardItem> page = boardRepository.findAll(pageable);
        return page.getContent();
    }
	
	// id값으로 삭제
	@Override
	public void deleteId(Integer id) {
		boardRepository.deleteById(id);
	}
	
	@Override // id값으로 한건 조회
	public BoardItem oneSelectView(Integer id) {
		return boardRepository.findById(id).orElse(null);
	}

	@Override // id값으로 한건 조회 시 조회수 카운트
	public void visit(Integer id) {
		BoardItem board = boardRepository.findById(id).orElse(null);
        if (board != null) {
            board.setViewcnt(board.getViewcnt() + 1);
            boardRepository.save(board);
        }		
	}

	
	
	
	
	
	@Override // 마지막 게시글 count
	public int LastNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override // 5. 컬럼 값 수정 update
	public void update(int number, String title, String content) {
		// TODO Auto-generated method stub
		
	}

}

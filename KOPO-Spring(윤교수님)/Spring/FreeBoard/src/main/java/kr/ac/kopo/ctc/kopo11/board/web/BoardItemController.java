package kr.ac.kopo.ctc.kopo11.board.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardComment;
import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.repo.BoardRepository;
import kr.ac.kopo.ctc.kopo11.board.service.BoardService;

@Controller
public class BoardItemController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardRepository boardRepository;


	public BoardItemController(BoardService boardService) {
		this.boardService = boardService;
	}

	// Test insert 입력
	@RequestMapping(value = "/insertTest")
	public ResponseEntity<String> insertTest(BoardItem board) {

		boardService.insertTest();
		return ResponseEntity.ok("<h2>Test 게시물이 성공적으로 등록되었습니다.</h2>");
	}

	// 작성된 게시물 저장(새로운 글은 newInsert/ 수정 글은 update)
	@PostMapping("/write")
	public String write(BoardItem board, String updating) {

		if (updating.equals("updating")) {
			boardService.update(board);
		} else {
			boardService.newInsert(board);
		}

		return "write";
	}

	// 새로운 글 쓰기
	@RequestMapping(value = "/newInsert")
	public String newInsert(Model model) {
		// int number = boardService.idCount();
		String date = String.valueOf(boardService.date());
		// model.addAttribute("number", number);
		model.addAttribute("date", date);

		return "newInsert";
	}

	// 전체 list 저장
	@RequestMapping(value = "/list")
	public String findAll(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, 
			@RequestParam(value = "search", required = false, defaultValue = "") String title) {
		
		// 검색 키워드(title)를 이용하여 게시물 검색
	    Page<BoardItem> boardItems;
	    if (!title.isEmpty()) {
	        boardItems = boardRepository.findByTitleContainingIgnoreCase(title, pageable);
	    } else {
	        boardItems = boardRepository.findAll(pageable);
	    }
	    
	    // 나머지 페이징 및 정렬 로직은 그대로 유지
	    int pageNumber = boardItems.getPageable().getPageNumber();
	    int totalPages = boardItems.getTotalPages();
	    int pageBlock = 10;
	    int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
	    int endBlockPage = startBlockPage + pageBlock - 1;
	    endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;
		
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("list", boardItems);
		
		return "list";
	}

	// 기존 게시 글 수정
	@PostMapping(value = "/update")
	public String update(BoardItem board, Model model) {
		BoardItem item = boardService.oneSelectView(board.getId());
		model.addAttribute("update", item);

		return "update";
	}

	// 하나의 게시글 조회
	@GetMapping(value = "/oneSelectView") // GET 요청에 대해서만 처리하도록 @GetMapping 어노테이션 사용
	public String oneSelectView(BoardItem board, Model model) {
		BoardItem item = boardService.oneSelectView(board.getId());
		Collection<BoardComment> comment = item.getBoardComment();

		model.addAttribute("oneSelectView", item);
		model.addAttribute("relist", comment);

		// 조회 수 증가
		boardService.visit(board.getId());

		return "oneSelectView";
	}

	// 하나의 게시글 삭제
	@PostMapping(value = "/oneDelete")
	public String deleteBoard(BoardItem board, Model model) {
		BoardItem item = boardService.oneSelectView(board.getId());
		model.addAttribute("oneDelete", item);
		// 아이디에 해당하는 게시물을 삭제합니다.
		boardService.deleteId(board.getId());
		return "oneDelete";
	}

}

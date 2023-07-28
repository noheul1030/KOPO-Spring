package kr.ac.kopo.ctc.kopo11.board.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardComment;
import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.service.BoardService;

@Controller
public class BoardItemController {

	@Autowired
	private BoardService boardService;


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
	public String findAll(Model model) {
		List<BoardItem> findAll = boardService.findAll();
		model.addAttribute("list", findAll);
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

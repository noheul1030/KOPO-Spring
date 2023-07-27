package kr.ac.kopo.ctc.kopo11.board.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.service.BoardService;

//@RequestMapping(value= "/Board")
@Controller
public class BoardItemController {

	@Autowired
	private BoardService boardService;

	public BoardItemController(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = "/insertTest")
	public ResponseEntity<String> insertTest(BoardItem board) {

		boardService.insertTest();
		return ResponseEntity.ok("<h2>Test 게시물이 성공적으로 등록되었습니다.</h2>");
	}

	@PostMapping("/write")
	public String write(BoardItem board, String updating) {
		
		if(updating.equals("updating")) {
			boardService.update(board);
		}else {
			boardService.newInsert(board);
		}
		
		return "write";
	}

	@RequestMapping(value = "/newInsert")
	public String newInsert(Model model) {
		//int number = boardService.idCount();
		String date = String.valueOf(boardService.date());
		//model.addAttribute("number", number);
		model.addAttribute("date", date);

		return "newInsert";
	}

	@RequestMapping(value = "/list")
	public String findAll(Model model) {
		List<BoardItem> findAll = boardService.findAll();
		model.addAttribute("list", findAll);
		return "list";
	}

	@PostMapping(value = "/update")
	public String update(BoardItem board, Model model) {
		BoardItem item = boardService.oneSelectView(board.getId());
		model.addAttribute("update", item);

		return "update";
	}

	@GetMapping(value = "/oneSelectView") // GET 요청에 대해서만 처리하도록 @GetMapping 어노테이션 사용
	public String oneSelectView(BoardItem board, Model model) {
		BoardItem item = boardService.oneSelectView(board.getId());
		model.addAttribute("oneSelectView", item);
		// 조회된 값이 null일 경우 로그에 출력합니다.
		if (item == null) {
			System.out.println("<h2>해당 ID는 존재하지 않습니다 : " + board.getId() + "</h2>");
		} else {
			// 조회 수 증가
			boardService.visit(board.getId());
		}

		return "oneSelectView";
	}

	@PostMapping(value = "/oneDelete")
	public String deleteBoard(BoardItem board, Model model) {
		BoardItem item = boardService.oneSelectView(board.getId());
		model.addAttribute("oneDelete", item);
		// 아이디에 해당하는 게시물을 삭제합니다.
		boardService.deleteId(board.getId());
		return "oneDelete";
	}
	
	// Servlet 코드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // "updating" 파라미터 값을 "updatingValue"라는 이름으로 설정하여 write.jsp로 전달
	    request.setAttribute("updatingValue", "updating");
	    request.getRequestDispatcher("write.jsp").forward(request, response);
	}

}

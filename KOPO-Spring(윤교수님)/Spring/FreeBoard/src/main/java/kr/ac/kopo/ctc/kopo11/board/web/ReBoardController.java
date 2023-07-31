package kr.ac.kopo.ctc.kopo11.board.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.ctc.kopo11.board.domain.BoardComment;
import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.service.ReBoardService;

@Controller
@RequestMapping("/reply")
public class ReBoardController {

	@Autowired
	private ReBoardService reboardService;

	public ReBoardController(ReBoardService reboardService) {
		this.reboardService = reboardService;
	}

	// 작성된 게시물 저장(새로운 글은 newInsert/ 수정 글은 update)
	@PostMapping("/writereply")
	public void rewrite(int id, BoardComment reboard, HttpServletResponse resp) throws IOException {
		reboardService.saveComment(id, reboard);

		resp.sendRedirect("/oneSelectView?id=" + id);
	}

	// 새로운 글 쓰기
	@RequestMapping(value = "/oneSelectView")
	public String newInsert(BoardItem board, Model model) {
		String date = String.valueOf(reboardService.reDate());
		model.addAttribute("date", date);

		return "oneSelectView";
	}

	// 전체 list 저장
	@RequestMapping(value = "/relist")
	public String findAll(BoardItem board, Model model) {
		List<BoardComment> findAll = reboardService.reFindAll();
		model.addAttribute("relist", findAll);
		return "relist";
	}

	// 하나의 댓글 삭제
	@PostMapping("/reDelete")
	public void deleteBoard(int id, BoardComment reboard, HttpServletResponse resp) throws IOException {
		// 아이디에 해당하는 게시물을 삭제합니다.
		System.out.println("아이디 : " + reboard.getReid());

		reboardService.reDeleteId(reboard);
		resp.sendRedirect("/oneSelectView?id=" + id);
	}

}

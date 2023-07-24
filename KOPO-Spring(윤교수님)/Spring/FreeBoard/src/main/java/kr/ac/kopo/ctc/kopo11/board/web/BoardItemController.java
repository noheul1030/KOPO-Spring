package kr.ac.kopo.ctc.kopo11.board.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.repo.BoardRepository;


//@RequestMapping(value= "/Board")
@Controller
public class BoardItemController {
	
	LocalDate now = LocalDate.now();
	@Autowired
	private BoardRepository boardRepository;
	
	// 첫 접속 시 보여지는 Board 전체 게시물 조회 
	@RequestMapping(value= "/findAll")
	@ResponseBody
	public List<BoardItem> findAll(Model model) {
		PageRequest pageable = PageRequest.of(1, 10);
		Page<BoardItem> page = boardRepository.findByIdAndTitleAndViewcntAndDate(pageable);
		return page.getContent();
			
	}

	
	@RequestMapping(value = "/BoardIteminsert")
	public void insert(){
		
		for(int i = 1; i <= 20; i++) {
		BoardItem board1 = new BoardItem();
			
		board1.setDate(now);
		board1.setContent("Spring 게시글" + i + " 입니다.");
		board1.setRelevel(0);
		board1.setRecnt(0);
		board1.setRootid(0);
		board1.setTitle("Title 입니다.");
		board1.setViewcnt(0);
		
		boardRepository.save(board1);
		}
	}
	
	
	@RequestMapping(value = "/oneSelectView")
	public List<BoardItem> oneSelectView(Model model, @RequestParam(value="id") Integer id) {
		List<BoardItem> list = boardRepository.oneSelectView(id);
		return list;
	}

}

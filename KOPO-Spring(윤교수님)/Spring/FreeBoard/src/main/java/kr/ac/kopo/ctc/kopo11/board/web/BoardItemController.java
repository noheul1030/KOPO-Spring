package kr.ac.kopo.ctc.kopo11.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo11.board.service.BoardService;


//@RequestMapping(value= "/Board")
@RestController
public class BoardItemController {
		
	@Autowired
	private BoardService boardService;
	
	public BoardItemController(BoardService boardService) {
        this.boardService = boardService;
    }
	
	@RequestMapping(value = "/insertTest")
	public ResponseEntity<String> insertTest(BoardItem board){
		boardService.insertTest();
		return ResponseEntity.ok("<h2>Test 게시물이 성공적으로 등록되었습니다.</h2>");
	} 

	
	@PostMapping("/newInsert")
	public ResponseEntity<String> newInsert(@RequestParam("title") String title, @RequestParam("content") String content) {
	    boardService.newInsert(title, content);
	    return ResponseEntity.ok("<h2>게시물이 성공적으로 등록되었습니다.</h2>");
	}
	

	@RequestMapping(value= "/List_findAll")
    @ResponseBody
    public List<BoardItem> findAll(Model model) {
        return boardService.findAll();
    }
	    
	@GetMapping(value ="/oneSelectView") // GET 요청에 대해서만 처리하도록 @GetMapping 어노테이션 사용
    public BoardItem oneSelectView(BoardItem board) {
		BoardItem item = boardService.oneSelectView(board.getId());
        
        // 조회된 값이 null일 경우 로그에 출력합니다.
        if (item == null) {
            System.out.println("<h2>해당 ID는 존재하지 않습니다 : " + board.getId() + "</h2>");
        } else {
            // 조회 수 증가
        	boardService.visit(board.getId());
        }
        
        return item;
    }
	
	@GetMapping(value ="/oneDelete")
    public ResponseEntity<String> deleteBoard(BoardItem board) {
        // 아이디에 해당하는 게시물을 삭제합니다.
		boardService.deleteId(board.getId());
        // 삭제 성공 시 200 OK 응답을 반환합니다.
        return ResponseEntity.ok("<h2>게시물이 성공적으로 삭제되었습니다.</h2>");
    }
}

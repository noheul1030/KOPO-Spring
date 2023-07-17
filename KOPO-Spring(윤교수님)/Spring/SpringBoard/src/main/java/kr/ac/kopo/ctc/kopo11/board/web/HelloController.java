package kr.ac.kopo.ctc.kopo11.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.kopo11.board.service.BoardItemService;

import kr.ac.kopo.ctc.kopo11.board.domain.Sample;
@Controller
@RequestMapping(value = "/hello")
public class HelloController {
	
	@Autowired
	private BoardItemService boardItemService;
	
//	@RequestMapping(value = "/hello")
//	public String hellSpringBoot(Model model) {
//		
//		int sum = boardItemService.add(3,5);		
//		
//		model.addAttribute("sum",sum);
//		
//		model.addAttribute("name","노을");
//		return "hello";
//	}
}

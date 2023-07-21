package kr.ac.kopo.ctc.kopo11.board.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.kopo11.board.service.BoardItemService;
@Controller
@RequestMapping(value = "/hello")
public class HelloController {
	
	@Autowired
	private BoardItemService boardItemService;
	
	@RequestMapping(value = "/hello")
	public String helloSpringBoot(Model model) {
		
		int sum = boardItemService.add(3,5);		
		
		List<String> myItems = new ArrayList<>();
		myItems.add("aaa");
		myItems.add("bbb");
		myItems.add("ccc");
		
		model.addAttribute("name","노을");
		model.addAttribute("sum",sum);
		model.addAttribute("myItems",myItems);
		
		return "hello";
	}
}

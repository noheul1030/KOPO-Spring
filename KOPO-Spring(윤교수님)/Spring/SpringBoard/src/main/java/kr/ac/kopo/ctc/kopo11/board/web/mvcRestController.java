package kr.ac.kopo.ctc.kopo11.board.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.ctc.kopo11.board.domain.MVC;

@RestController
@RequestMapping(value = "/rest")
public class mvcRestController {
	
	@RequestMapping(value = "/rest1")
	public ResponseEntity<MVC> mvc1(){
		MVC mvc = new MVC();
		mvc.setId(1);
		mvc.setName("abcd");
		return ResponseEntity.ok(mvc);
	}
	
	@RequestMapping(value = "/rests1")
	public ResponseEntity<List<MVC>> rests1(){
		MVC mvc1 = new MVC();
		mvc1.setId(1);
		mvc1.setName("abcd1");
		
		MVC mvc2 = new MVC();
		mvc2.setId(2);
		mvc2.setName("abcd2");
		
		List<MVC> mvcs = new ArrayList<MVC>();
		mvcs.add(mvc1);
		mvcs.add(mvc2);
		
		return ResponseEntity.ok(mvcs);
	}
	
	@RequestMapping(value = "/rest2")
	public MVC mvc2(){
		MVC mvc = new MVC();
		mvc.setId(1);
		mvc.setName("abcd");
		return mvc;
	}
	
	@RequestMapping(value = "/rests2")
	public List<MVC> rests2(){
		MVC mvc1 = new MVC();
		mvc1.setId(1);
		mvc1.setName("abcd1");
		
		MVC mvc2 = new MVC();
		mvc2.setId(2);
		mvc2.setName("abcd2");
		
		List<MVC> mvcs = new ArrayList<MVC>();
		mvcs.add(mvc1);
		mvcs.add(mvc2);
		
		return mvcs;
	}

}

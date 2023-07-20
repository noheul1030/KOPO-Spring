package kr.ac.kopo.ctc.kopo11.board.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.kopo11.board.service.SampleCacheService;

@Controller
public class SampleCacheController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleCacheController.class);

	@Autowired
	private SampleCacheService sampleCacheService;
	
	@RequestMapping(value = "/noCache")
	@ResponseBody
	public String noCache(@RequestParam HashMap<String, String> map) {
		Long id = Long.parseLong(map.get("id"));
		return sampleCacheService.testNoCache(id);
	}
	
	@RequestMapping(value = "/cache")
	@ResponseBody
	public String cache(@RequestParam HashMap<String, String> map) {
		Long id = Long.parseLong(map.get("id"));
		return sampleCacheService.testNoCache(id);
	}
}

package kr.ac.kopo.ctc.kopo11.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.kopo11.board.domain.Sample;
import kr.ac.kopo.ctc.kopo11.board.repo.SampleRepository;
import kr.ac.kopo.ctc.kopo11.board.repo.mapper.SampleMapper;

@Controller
public class SampleController {
   
   @Autowired
   private SampleRepository sampleRepository;
   @Autowired
   private SampleMapper sampleMapper;
   
   // 리스트에 담긴 내용을 출력하는 메서드
   @RequestMapping(value = "/sample1")
   @ResponseBody
   public List<Sample> list(Model model) {
      
      Map<String, Object> filter = new HashMap<String, Object>();
      filter.put("title", "a");
      
      PageRequest pageable = PageRequest.of(0, 10);
      List<Sample> list12 = sampleRepository.findAll();
      return list12;
   }
   
   // page 대한 content 등 정보를 모두 출력되도록 하는 메서드
   @RequestMapping(value = "/sample2")
   @ResponseBody
   public Page<Sample> list2(Model model) {
      
      Map<String, Object> filter = new HashMap<String, Object>();
      filter.put("title", "a");
      
      PageRequest pageable = PageRequest.of(0, 10);
      Page<Sample> page =
            sampleRepository.findAll(pageable);
      return page;
   }
   
   
   // page content만 출력되도록 하는 메서드
   @RequestMapping(value = "/sample3")
   @ResponseBody
   public List<Sample> list3(Model model) {
      
      Map<String, Object> filter = new HashMap<String, Object>();
      filter.put("title", "a");
      
      PageRequest pageable = PageRequest.of(0, 10);
      Page<Sample> page =
            sampleRepository.findAll(pageable);
      return page.getContent();
   }
   
   
   @RequestMapping(value = "/mapper")
   @ResponseBody
   public List<Sample> mapper(Model model) {	   
	   
	   return sampleMapper.findAll();
   }

}
package com.resort.springboot.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;
import com.resort.springboot.repo.NoticeRepository;
import com.resort.springboot.service.NoticeService;


@Controller
public class NoticeController {
	
//	@Autowired
//	private NoticeService noticeService;
//	@Autowired
//	private NoticeRepository noticeRepository;
//
//
//	public NoticeController(NoticeService noticeService) {
//		this.noticeService = noticeService;
//	}
//
//	// Test insert 입력
//	@RequestMapping(value = "/insertTest")
//	public ResponseEntity<String> insertTest(Notice notice) {
//
//		noticeService.insertTest();
//		return ResponseEntity.ok("<h2>Test 게시물이 성공적으로 등록되었습니다.</h2>");
//	}
//
//	// 작성된 게시물 저장(새로운 글은 newInsert/ 수정 글은 update)
//	@PostMapping("/write")
//	public String write(Notice notice, String updating) {
//
//		if (updating.equals("updating")) {
//			noticeService.update(notice);
//		} else {
//			noticeService.newInsert(notice);
//		}
//
//		return "write";
//	}
//
//	// 새로운 글 쓰기
//	@RequestMapping(value = "/newInsert")
//	public String newInsert(Model model) {
//		// int number = boardService.idCount();
//		String date = String.valueOf(noticeService.date());
//		// model.addAttribute("number", number);
//		model.addAttribute("date", date);
//
//		return "newInsert";
//	}
//
//	// 전체 list 저장
//	@PostMapping(value = "/noticeBoard")
//	public String findAll(Model model, @PageableDefault(size = 10, sort = "notice_id", direction = Sort.Direction.DESC) Pageable pageable, 
//			@RequestParam(value = "search", required = false, defaultValue = "") String title) {
//		
//		// 검색 키워드(title)를 이용하여 게시물 검색
//	    Page<Notice> notices;
//	    if (!title.isEmpty()) {
//	    	notices = noticeRepository.findByTitleContainingIgnoreCase(title, pageable);
//	    } else {
//	    	notices = noticeRepository.findAll(pageable);
//	    }
//	    
//	    // 나머지 페이징 및 정렬 로직은 그대로 유지
//	    int pageNumber = notices.getPageable().getPageNumber();
//	    int totalPages = notices.getTotalPages();
//	    int pageBlock = 10;
//	    int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
//	    int endBlockPage = startBlockPage + pageBlock - 1;
//	    endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;
//		
//		model.addAttribute("startBlockPage", startBlockPage);
//		model.addAttribute("endBlockPage", endBlockPage);
//		model.addAttribute("list", notices);
//		
//		return "noticeBoard";
//	}
//
//	// 기존 게시 글 수정
//	@PostMapping(value = "/update")
//	public String update(Notice notice, Model model) {
//		Notice item = noticeService.oneSelectView(notice.getNoticeId());
//		model.addAttribute("update", item);
//
//		return "update";
//	}
//
//	// 하나의 게시글 조회
//	@GetMapping(value = "/oneSelectView") // GET 요청에 대해서만 처리하도록 @GetMapping 어노테이션 사용
//	public String oneSelectView(Notice notice, Model model) {
//		Notice item = noticeService.oneSelectView(notice.getNoticeId());
//		Collection<NoticeComment> comment = item.getNoticeComment();
//
//		model.addAttribute("oneSelectView", item);
//		model.addAttribute("relist", comment);
//
//		// 조회 수 증가
//		noticeService.visit(notice.getNoticeId());
//
//		return "oneSelectView";
//	}
//
//	// 하나의 게시글 삭제
//	@PostMapping(value = "/oneDelete")
//	public String deleteBoard(Notice notice, Model model) {
//		Notice item = noticeService.oneSelectView(notice.getNoticeId());
//		model.addAttribute("oneDelete", item);
//		// 아이디에 해당하는 게시물을 삭제합니다.
//		noticeService.deleteId(notice.getNoticeId());
//		return "oneDelete";
//	}

}

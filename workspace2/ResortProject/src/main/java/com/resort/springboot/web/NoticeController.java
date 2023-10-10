package com.resort.springboot.web;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;
import com.resort.springboot.dto.NoticeDto;
import com.resort.springboot.service.NoticeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

	private final NoticeService noticeService;

	// 1. 게시글 목록 조회
	
	@GetMapping("/noticeBoard_list")
	public String list(Model model) {

		List<Notice> noticeList = this.noticeService.getList();
		model.addAttribute("noticeList", noticeList);
		return "/noticeBoard_list";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// 2. 게시글 작성
	 
	@GetMapping("/noticeBoard_create")
	public String notice(Model model) {
		model.addAttribute("create", new NoticeDto());

		return "noticeBoard_create";
	}

	@PostMapping("/noticeBoard_create")
	public String noticeCreate(@Valid @ModelAttribute("create")NoticeDto noticeDto, BindingResult bindingResult,
			Notice notice, String updating) {

		if (bindingResult.hasErrors()) {
			return "noticeBoard_create";
		}
		
		this.noticeService.newInsert(notice);

		return "redirect:/noticeBoard_list"; // 질문 저장후 질문목록으로 이동
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
	// 3. 하나의 게시글 조회
	
	@GetMapping(value = "/noticeBoard_detail")
	public String oneSelectView(Model model, Notice notice) {
		Notice noticeitem = noticeService.oneSelectView(notice.getNoticeId());
		Collection<NoticeComment> comment = noticeitem.getNoticeComment();

		model.addAttribute("oneSelectView", noticeitem);
		model.addAttribute("relist", comment);

		noticeService.visit(noticeitem.getNoticeId());
		return "/noticeBoard_detail";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
	// 4. 게시글 삭제
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/noticeBoard_delete")
	public String noticeBoard_delete(Model model, Notice notice) {
		
		noticeService.deleteId(notice.getNoticeId());
		
		return "noticeBoard_delete";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// 5. 기존 게시글 수정
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/noticeBoard_update")
	public String noticeBoard_update(Model model, Notice notice) {
		Notice noticeitem = noticeService.oneSelectView(notice.getNoticeId());
		model.addAttribute("update", noticeitem);
		return "noticeBoard_update";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/noticeBoard_update")
	public String noticeUpdate(@Valid @ModelAttribute("update")NoticeDto noticeDto, BindingResult bindingResult, Model model, Notice notice) {
		
		if (bindingResult.hasErrors()) {
			return "noticeBoard_update";
		}

		Notice noticeitem = noticeService.oneSelectView(notice.getNoticeId());
		model.addAttribute("update", noticeitem);

		this.noticeService.update(notice);
		
		return "redirect:/noticeBoard_list";
	}

}

package com.resort.springboot.web;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.dto.NoticeDto;
import com.resort.springboot.service.NoticeService;
import com.resort.springboot.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

	private final NoticeService noticeService;
	private final UserService userService;

	// 1. 게시글 목록 조회

	@GetMapping("/noticeBoard_list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {

		Page<Notice> paging = this.noticeService.getList(page);
		model.addAttribute("paging", paging);

		return "/noticeBoard_list";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	// 2. 게시글 작성
	@GetMapping("/noticeBoard_create")
	public String noticeCreate(NoticeDto.Request noticeDto, Model model) {
		model.addAttribute("create", noticeDto);

		return "noticeBoard_create";
	}

	@PostMapping("/noticeBoard_create")
	public String noticeCreate(@Valid @ModelAttribute("create") NoticeDto.Request noticeDto,
			BindingResult bindingResult, Principal principal) {

		if (bindingResult.hasErrors()) {
			return "noticeBoard_create";
		}

		SiteUser user = this.userService.getUser(principal.getName());
		this.noticeService.newInsert(noticeDto.getTitle(), noticeDto.getContent(), user);

		return "redirect:/noticeBoard_list"; // 질문 저장후 질문목록으로 이동
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

	// 3. 하나의 게시글 조회

	@GetMapping(value = "/noticeBoard_detail")
	public String oneSelectView(Model model, Notice notice, 
			@RequestParam(value = "incrementVisit", required = false, defaultValue = "true") boolean incrementVisit) {
		
		Notice noticeitem = noticeService.oneSelectView(notice.getNoticeId());
		List<NoticeComment> comment = noticeitem.getComments();

		model.addAttribute("oneSelectView", noticeitem);
		model.addAttribute("relist", comment);

		if (incrementVisit) {
	        noticeService.visit(noticeitem.getNoticeId());
	    }
		return "/noticeBoard_detail";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

	// 4. 게시글 삭제

	@GetMapping(value = "/noticeBoard_delete")
	public String noticeBoard_delete(Model model, Notice notice) {

		noticeService.deleteId(notice.getNoticeId());

		return "noticeBoard_delete";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	// 5. 기존 게시글 수정

	@GetMapping(value = "/noticeBoard_update")
	public String noticeUpdate(Model model, Notice notice) {
		Notice noticeitem = noticeService.oneSelectView(notice.getNoticeId());
		model.addAttribute("update", noticeitem);
		return "noticeBoard_update";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/noticeBoard_update")
	public String noticeUpdate(@Valid @ModelAttribute("update") NoticeDto.Request noticeDto,
			BindingResult bindingResult, Model model, Notice notice) {

		if (bindingResult.hasErrors()) {
			return "noticeBoard_update";
		}

		Notice noticeitem = noticeService.oneSelectView(notice.getNoticeId());
		model.addAttribute("update", noticeitem);

		this.noticeService.update(notice);

		return "redirect:/noticeBoard_list";
	}

}

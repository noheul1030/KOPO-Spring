package com.resort.springboot.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.dto.NoticeDto;
import com.resort.springboot.service.NoticeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

	private final NoticeService noticeService;

	@GetMapping("/noticeBoard_list")
	public String list(Model model) {

		List<Notice> noticeList = this.noticeService.getList();
		model.addAttribute("noticeList", noticeList);
		return "/noticeBoard_list";
	}

	@GetMapping("/noticeBoard_create")
	public String notice(Model model) {
		model.addAttribute("noticeForm", new NoticeDto());
		
		return "noticeBoard_create";
	}

	@PostMapping("/noticeBoard_create")
	public String noticeCreate(@Valid @ModelAttribute("noticeForm") NoticeDto noticeDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "noticeBoard_create";
		}
		
		this.noticeService.newInsert(noticeDto.getTitle(), noticeDto.getContent(), noticeDto.getId());
		return "redirect:/noticeBoard_list"; // 질문 저장후 질문목록으로 이동
	}

	@GetMapping(value = "/detail/{noticeId}")
	public String detail(Model model, @PathVariable("noticeId") Long id) {
		Notice notice = this.noticeService.oneSelectView(id);
		model.addAttribute("notice", notice);
		return "/notice/detail";
	}

}

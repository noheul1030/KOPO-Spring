package com.resort.springboot.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.service.NoticeServiceImpl;

import lombok.RequiredArgsConstructor;

@RequestMapping("/notice")
@RequiredArgsConstructor
@Controller
public class NoticeController {

	private final NoticeServiceImpl noticeServiceImpl;

	@GetMapping("/list")
	public String list(Model model) {

		List<Notice> noticeList = this.noticeServiceImpl.getList();
		model.addAttribute("noticeList", noticeList);
		return "/notice/list";
	}

	@GetMapping(value = "/detail/{noticeId}")
	public String detail(Model model, @PathVariable("noticeId") Long id) {
		Notice notice = this.noticeServiceImpl.oneSelectView(id);
		model.addAttribute("notice", notice);
		return "/notice/detail";
	}

}

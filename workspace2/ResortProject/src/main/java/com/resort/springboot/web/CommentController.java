package com.resort.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.dto.CommentDto;
import com.resort.springboot.service.CommentService;
import com.resort.springboot.service.NoticeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CommentController {
	
	private final NoticeService noticeService;
	private final CommentService commentService;
	
	@PostMapping("/create/{id}")
    public String commentCreate(Model model, @PathVariable("id") Long id, 
            @Valid CommentDto commentDto, BindingResult bindingResult) {
		
        Notice notice = this.noticeService.oneSelectView(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("notice", notice);
            return "noticeBoard_detail";
        }
        this.commentService.create(notice, commentDto.getRecontent());
        return String.format("redirect:/noticeBoard_detail/%s", id);
    }
}

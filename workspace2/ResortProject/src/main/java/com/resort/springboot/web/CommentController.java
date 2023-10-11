package com.resort.springboot.web;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.springboot.domain.CommentForm;
import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.service.CommentService;
import com.resort.springboot.service.NoticeService;
import com.resort.springboot.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CommentController {

	private final UserService userService;
	private final NoticeService noticeService;
	private final CommentService commnetService;

	/* CREATE */
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{postId}")
	public String createComment(Model model, @PathVariable("id") Long id, @Valid CommentForm commentForm,
			BindingResult bindingResult, Principal principal) {
		Notice notice = this.noticeService.getNotice(id);
		SiteUser user = this.userService.getUser(principal.getName());
		if (bindingResult.hasErrors()) {
			model.addAttribute("postDetail", notice); // 댓글 작성 오류 시 해당 공지 내용 저장해서 유지
			return "noticeBoard_detail";
		}
		commnetService.create(notice, commentForm.getComment(), user);

		return String.format("redirect:/noticeBoard_detail/%s", id);
	}
}

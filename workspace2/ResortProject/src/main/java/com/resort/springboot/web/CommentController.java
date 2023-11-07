package com.resort.springboot.web;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.dto.CommentDto;
import com.resort.springboot.dto.NoticeDto;
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
	private final CommentService commentService;

	/* CREATE */
	
	@GetMapping("/noticeBoard_detail/{noticeId}")
	public String createComment(Model model, CommentDto.Request commentDto, NoticeDto.Response noticeDto) {
		model.addAttribute("commentForm", commentDto);
		model.addAttribute("oneSelectView",noticeDto);
		
		return "/noticeBoard_detail/{noticeId}";

	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/noticeBoard_detail/{noticeId}")
	public String createComment(Model model, @PathVariable Long noticeId,
			@Valid @ModelAttribute("commentForm") CommentDto.Request commentDto, BindingResult bindingResult,
			Principal principal) {
		
		Notice notice = this.noticeService.getNotice(noticeId);
		SiteUser user = this.userService.getUser(principal.getName());
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("oneSelectView", notice); // 댓글 작성 오류 시 해당 공지 내용 저장해서 유지
			return "noticeBoard_detail?noticeId=" + noticeId;
		}
		
		commentService.create(notice, commentDto.getComment(), user);

		return "redirect:/noticeBoard_detail?noticeId=" + noticeId + "&incrementVisit=false"; 
	}

	/* UPDATE */
	@PreAuthorize("isAuthenticated() or hasRole('ROLE_ADMIN')")
	@GetMapping("/update/{commentId}")
	public String update(CommentDto.Request commentDto, @PathVariable("commentId") Long commentId,
			Principal principal) {
		
		NoticeComment comment = this.commentService.getcomment(commentId);
		
		if (!"admin".equals(principal.getName()) && !comment.getCommentUser().getId().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, principal.getName());
		}
		
		commentDto.setComment(comment.getComment());

		return "#";
	}

	@PreAuthorize("isAuthenticated() or hasRole('ROLE_ADMIN')")
	@PostMapping("/update/{commentId}")
	public String update(@Valid CommentDto.Request commentDto, BindingResult bindingResult,
			@PathVariable("commentId") Long commentId, Principal principal) {
		if (bindingResult.hasErrors()) {
			return "#";
		}
		NoticeComment comment = this.commentService.getcomment(commentId);
		if (!"admin".equals(principal.getName()) && !comment.getCommentUser().getId().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "post");
		}
		this.commentService.modify(comment, commentDto.getComment());
		return String.format("redirect:/noticeBoard_detail/%s", comment.getRootId().getNoticeId());
	}

	/* DELETE */
	@PreAuthorize("isAuthenticated() or hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{commentId}")
	public String commentDelete(Principal principal, @PathVariable("commentId") long commentId) {
		NoticeComment comment = this.commentService.getcomment(commentId);
		if (!"admin".equals(principal.getName()) && !comment.getCommentUser().getId().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
		}
		this.commentService.delete(comment);
		return String.format("redirect:/noticeBoard_detail/%s", comment.getRootId().getNoticeId());
	}

	////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/relist")
	public String findAll(Notice notice, Model model) {
		List<NoticeComment> findAll = commentService.reFindAll();
		model.addAttribute("relist", findAll);
		return "relist";
	}

}
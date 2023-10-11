package com.resort.springboot.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.dto.CommentDto;
import com.resort.springboot.exception.DataNotFoundException;
import com.resort.springboot.repo.NoticeCommentRepository;
import com.resort.springboot.repo.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final NoticeCommentRepository commentRepository;
	private final NoticeRepository postRepository;

	public void create(Long postId, CommentDto.Request dto) {

		Notice notice = postRepository.findById(postId)
				.orElseThrow(() -> new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다. " + postId));

		dto.setRootId(notice);
		dto.setDate(LocalDateTime.now());

		NoticeComment comment = dto.toEntity();
		commentRepository.save(comment);
	}

	public void create(Notice notice, String content, SiteUser user) {
		NoticeComment comment = new NoticeComment();
		comment.setComment(content);
		comment.setDate(LocalDateTime.now());
		comment.setRootId(notice);
		comment.setCommentUser(user);
		commentRepository.save(comment);
	}

	public NoticeComment getcomment(long commentId) {
		Optional<NoticeComment> comment = this.commentRepository.findById(commentId);
		if (comment.isPresent()) {
			return comment.get();
		} else {
			throw new DataNotFoundException("comment not found");
		}
	}

	public void modify(NoticeComment comments, String comment) {
		comments.setComment(comment);
		comments.setCommentModifiedDate(LocalDateTime.now());
		this.commentRepository.save(comments);
	}

	public void delete(NoticeComment comments) {
		this.commentRepository.delete(comments);
	}

	// 전체 게시물 조회
	public List<NoticeComment> getList(Notice rootId) {
		return this.commentRepository.getCommentByRootIdOrderByCommentId(rootId);
	}

}
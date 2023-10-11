package com.resort.springboot.dto;

import java.time.LocalDateTime;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;
import com.resort.springboot.domain.SiteUser;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommentDto {

	// 댓글 서비스 요청
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class Request {

		private Long commentId;
		private LocalDateTime date;
		private LocalDateTime commentModifiedDate;
		private Notice rootId;
		private SiteUser commentUser;

		@NotEmpty(message = "내용은 필수항목입니다.")
		private String comment;

		// Dto -> Entity
		public NoticeComment toEntity() {
			NoticeComment comments = NoticeComment.builder().commentId(commentId).comment(comment).date(date)
					.commentModifiedDate(commentModifiedDate).rootId(rootId).commentUser(commentUser).build();

			return comments;
		}
	}

	// 댓글 정보 반환
	@Getter
	public static class Response {

		private Long commentId;
		private String comment;
		private LocalDateTime date;
		private LocalDateTime commentModifiedDate;
		private Notice rootId;
		private SiteUser commentUser;

		// Entity -> Dto
		public Response(NoticeComment comment) {
			this.commentId = comment.getCommentId();
			this.comment = comment.getComment();
			this.date = comment.getDate();
			this.commentModifiedDate = comment.getCommentModifiedDate();
			this.rootId = comment.getRootId();
			this.commentUser = comment.getCommentUser();
		}
	}
}

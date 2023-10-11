package com.resort.springboot.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;
import com.resort.springboot.domain.SiteUser;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class NoticeDto {

	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@Builder
	@Getter
	@Setter
	public static class Request {
		private Long noticeId;

		private SiteUser id;

		@Pattern(regexp = "^[가-힣a-zA-Z0-9?!,&]+( [가-힣a-zA-Z0-9?!,&]+)*$", message = "제목의 입력값이 유효하지 않습니다. 다시 확인해 주세요.")
		@NotEmpty(message = "제목은 필수항목입니다.")
		private String title;

		@NotEmpty(message = "내용은 필수항목입니다.")
		private String content;

		private LocalDateTime date;

		private LocalDateTime postModifiedDate;

		private Integer viewcnt;
		
		private List<NoticeComment> comments;

		public Notice createNotice() {
			Notice notice = Notice.builder()
					.noticeId(noticeId)
					.id(id)
					.title(title)
					.date(date)
					.postModifiedDate(postModifiedDate)
					.content(content)
					.viewcnt(0)
					.comments(comments)
					.build();
			return notice;
		}
	}
	
	// 게시글 정보 반환
		@Getter
	    public static class Response {
			
			private final Long noticeId;
			private final SiteUser id;
			private final String title;
			private final String content;
			private final LocalDateTime date;
			private final LocalDateTime postModifiedDate;
			private final int viewcnt;
			private List<NoticeComment> comments;
			
			// Entity -> Dto
	        public Response(Notice notice) {	   
	            this.noticeId = notice.getNoticeId();
	            this.title = notice.getTitle();
	            this.date = notice.getDate();
	            this.postModifiedDate = notice.getPostModifiedDate();
	            this.content = notice.getContent();
	            this.viewcnt = notice.getViewcnt();
	            this.id = notice.getId();
	            this.comments = notice.getComments();
	        }
		}
}

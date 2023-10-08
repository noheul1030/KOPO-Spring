package com.resort.springboot.dto;

import com.resort.springboot.domain.NoticeComment;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

//	private String noticeId;

	private Long reid;

	@NotEmpty(message = "내용은 필수항목입니다.")
	private String recontent;

	private String redate;

	
	public NoticeComment createComment() {
		NoticeComment noticeComment = NoticeComment.builder()
//				.noticeId(noticeId)
				.reid(reid)
	    		.recontent(recontent)
	    		.redate(redate)
	            .build();
	    return noticeComment;
	}
}

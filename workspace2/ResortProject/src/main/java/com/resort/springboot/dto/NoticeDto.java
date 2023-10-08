package com.resort.springboot.dto;

import com.resort.springboot.domain.Notice;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class NoticeDto {

	private Long noticeId;
	
	private String id;

	@Pattern(regexp = "^[가-힣a-zA-Z0-9?!,&]+( [가-힣a-zA-Z0-9?!,&]+)*$", message = "제목의 입력값이 유효하지 않습니다. 다시 확인해 주세요.")
	@NotEmpty(message = "제목은 필수항목입니다.")
	private String title;
	
	@NotEmpty(message="내용은 필수항목입니다.")
	private String content;
	
	private String date;	
	
	private Integer viewcnt;

	public Notice createNotice() {
		Notice notice = Notice.builder()
				.noticeId(noticeId)
				.id(id)
	    		.title(title)
	    		.date(date)
	            .content(content)
	            .viewcnt(0)
	            .build();
	    return notice;
	}
}

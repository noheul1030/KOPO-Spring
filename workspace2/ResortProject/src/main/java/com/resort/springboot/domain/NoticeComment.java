package com.resort.springboot.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class NoticeComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long commentId;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String comment;
	
	@Column
	private LocalDateTime date;
	
	@Column
	private LocalDateTime commentModifiedDate;
	
	 // 원글
	@ManyToOne(optional = false)
	@JoinColumn(name = "notice_id")
	private Notice rootId;
	
	// 작성자
	@ManyToOne
	@JoinColumn(name = "user_id")
	private SiteUser commentUser;

}

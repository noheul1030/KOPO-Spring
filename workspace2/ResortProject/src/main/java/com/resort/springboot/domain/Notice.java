package com.resort.springboot.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
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
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long noticeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private SiteUser id;
	
	@Column
	private String title;
	
	@Column
	private LocalDateTime date;
	
	@Column
	private LocalDateTime postModifiedDate;
	
	@Column
	private String content;
	
	@Column 
	private Integer viewcnt;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "rootId", fetch = FetchType.LAZY)
	@OrderBy("comment_date asc")
	private List<NoticeComment> comments;
}

package com.resort.springboot.domain;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long noticeId;
	
	@Column
	private String id;
	
	@Column
	private String title;
	
	@Column
	private String date;
	
	@Column
	private String content;
	
	@Column 
	private Integer viewcnt;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "notice", fetch = FetchType.LAZY)
	private Collection<NoticeComment> noticeComment;
}

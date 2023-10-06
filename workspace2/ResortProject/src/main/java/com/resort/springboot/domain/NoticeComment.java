package com.resort.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class NoticeComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long reid;

	@ManyToOne(optional = false)
	@JoinColumn(name = "notice_id")
	private Notice notice;

	@Column
	private String recontent;

	@Column
	private String redate;

	@Column
	private Long rootid;
}

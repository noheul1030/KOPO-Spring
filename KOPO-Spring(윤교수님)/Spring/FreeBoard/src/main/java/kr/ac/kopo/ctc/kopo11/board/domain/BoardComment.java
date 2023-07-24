package kr.ac.kopo.ctc.kopo11.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 댓글
public class BoardComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String title;
	@Column
	private String date;
	@Column
	private String content;
	@Column
	private Integer rootid;
	@Column
	private Integer relevel;
	@Column
	private Integer recnt;
	
}

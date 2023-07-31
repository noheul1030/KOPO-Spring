package kr.ac.kopo.ctc.kopo11.board.domain;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// 원글 
@Entity
public class BoardItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String title;

	@Column
	private String date;

	@Column
	private String content;

	@Column
	private Integer viewcnt;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "boardItem", fetch = FetchType.LAZY)
	private Collection<BoardComment> boardComment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}

////////////////////////////////////////////////////////////////////////////////////////	
	
	public Collection<BoardComment> getBoardComment() {
		return boardComment;
	}

	public void setBoardComment(Collection<BoardComment> boardComment) {
		this.boardComment = boardComment;
	}

}

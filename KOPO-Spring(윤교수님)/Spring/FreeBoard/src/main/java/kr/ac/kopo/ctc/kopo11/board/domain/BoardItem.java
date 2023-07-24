package kr.ac.kopo.ctc.kopo11.board.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 원글 
@Entity
public class BoardItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String title;
	@Column
	private LocalDate date;
	@Column
	private String content;
	@Column
	private Integer rootid;
	@Column
	private Integer relevel;
	@Column
	private Integer recnt;
	@Column
	private Integer viewcnt;
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getRootid() {
		return rootid;
	}
	public void setRootid(Integer rootid) {
		this.rootid = rootid;
	}
	public Integer getRelevel() {
		return relevel;
	}
	public void setRelevel(Integer relevel) {
		this.relevel = relevel;
	}
	public Integer getRecnt() {
		return recnt;
	}
	public void setRecnt(Integer recnt) {
		this.recnt = recnt;
	}
	public Integer getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}
}

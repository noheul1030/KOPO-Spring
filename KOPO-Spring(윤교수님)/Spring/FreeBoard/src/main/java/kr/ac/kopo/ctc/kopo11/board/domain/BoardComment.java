package kr.ac.kopo.ctc.kopo11.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// 댓글
@Entity
public class BoardComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long reid;

	@ManyToOne(optional = false)
	@JoinColumn(name = "board_item_id")
	private BoardItem boardItem;

	@Column
	private String recontent;

	@Column
	private String redate;

	@Column
	private Long rootid;

	public Long getReid() {
		return reid;
	}

	public void setReid(Long reid) {
		this.reid = reid;
	}

	public BoardItem getBoardItem() {
		return boardItem;
	}

	public void setBoardItem(BoardItem boardItem) {
		this.boardItem = boardItem;
	}

	public String getRecontent() {
		return recontent;
	}

	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}

	public String getRedate() {
		return redate;
	}

	public void setRedate(String redate) {
		this.redate = redate;
	}

	public Long getRootid() {
		return rootid;
	}

	public void setRootid(Long rootid) {
		this.rootid = rootid;
	}

}

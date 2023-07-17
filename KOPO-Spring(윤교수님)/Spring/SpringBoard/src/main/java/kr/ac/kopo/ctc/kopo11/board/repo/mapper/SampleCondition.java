package kr.ac.kopo.ctc.kopo11.board.repo.mapper;

import java.io.Serializable;

public class SampleCondition implements Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String title;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

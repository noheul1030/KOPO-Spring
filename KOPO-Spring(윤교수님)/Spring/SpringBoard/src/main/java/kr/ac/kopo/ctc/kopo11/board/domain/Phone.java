package kr.ac.kopo.ctc.kopo11.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone {
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String no;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="member_id")
	private Member member;
	
	public Phone(String string) {
		this.no = string;
	}
	
	public Phone() {
		
	}	

	@Override
	public String toString() {
		String result = "[phone_" + id + "]" + no;
		return result;
	}
	public Member getMember() {
		return member;
	}

	public void setMember(Member member2) {
		this.member = member2;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
	
}

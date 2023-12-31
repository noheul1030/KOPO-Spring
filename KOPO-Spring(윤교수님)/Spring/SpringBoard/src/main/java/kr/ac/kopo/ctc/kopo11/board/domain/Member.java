package kr.ac.kopo.ctc.kopo11.board.domain;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Member {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;

	@Column
	private String name;

	@Column
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="member", fetch = FetchType.LAZY)
	private Collection<Phone> phones;
	
	public Member(String string, Integer age) {
		this.name = string;
		this.age = age;
	}
	
	public Member() {
		
	}	

	public Collection<Phone> getPhones(){
		if( phones == null ) {
			phones = new ArrayList<Phone>();
		}
		return phones;
	}
	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}
	public void addPhone(Phone p) {
		Collection<Phone> phones = getPhones();
		p.setMember(this);
		phones.add(p);
	}
	
	@Override
	public String toString() {
		String result = "["+id+"]" + name + "," + age;
		for( Phone p : getPhones()) {
			result += "\n" + p.toString();
		}
		return result;
	}

		
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	
}

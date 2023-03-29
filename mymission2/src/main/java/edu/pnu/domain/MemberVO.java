// Model
package edu.pnu.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {
	
	private int id;
	private String pass;
	private String name;
	private Date regidate;	
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(int id, String pass, String name) {		
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = new Date();		
	}
	
	public MemberVO(MemberVO memberVO) {
		this.id = memberVO.id;
		this.pass = memberVO.pass;
		this.name = memberVO.name;
		this.regidate = new Date();		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}

	
}

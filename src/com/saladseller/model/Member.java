package com.saladseller.model;

public class Member {
	
	private int m_num;
	private String m_id;
	private String m_pw;
	private String m_email;
	private String m_addr;
	private String m_phone;
	
	
	public int getM_num() {
		return m_num;
	}
	
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	
	public String getM_id() {
		return m_id;
	}
	
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	public String getM_pw() {
		return m_pw;
	}
	
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	
	public String getM_email() {
		return m_email;
	}
	
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	public String getM_addr() {
		return m_addr;
	}
	
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	
	public String getM_phone() {
		return m_phone;
	}
	
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	
	
	@Override
	public String toString() {
		return "Member [m_num = " + m_num + ", m_id = " + m_id + ", m_pw = " + m_pw + ", m_email = " + m_email + ", m_addr = "
				+ m_addr + ", m_phone = " + m_phone + "]";
	}
	
	
}

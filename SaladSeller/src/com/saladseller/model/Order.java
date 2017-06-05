package com.saladseller.model;

import java.sql.Date;

public class Order {

	private int o_id;
	private int p_id;
	private int m_id;
	private int o_num;
	private Date o_date;
	
	
	public int getO_id() {
		return o_id;
	}
	
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	
	public int getP_id() {
		return p_id;
	}
	
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	public int getM_id() {
		return m_id;
	}
	
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
	public int getO_num() {
		return o_num;
	}
	
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	
	public Date getO_date() {
		return o_date;
	}
	
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	
	
	@Override
	public String toString() {
		return "Order [o_id = " + o_id + ", p_id = " + p_id + ", m_id = " + m_id + ", o_num = " + o_num + ", o_date = " + o_date
				+ "]";
	}
	
	
}

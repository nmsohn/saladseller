package com.saladseller.model;

public class Product {

	private int p_id;
	private String p_name;
	private String cat_id;
	private String descript;
	private int price;
	private int p_num;
	
	
	public int getP_id() {
		return p_id;
	}
	
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	public String getP_name() {
		return p_name;
	}
	
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	
	public String getCat_id() {
		return cat_id;
	}
	
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	
	public String getDescript() {
		return descript;
	}
	
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getP_num() {
		return p_num;
	}
	
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	
	@Override
	public String toString() {
		return "Product [p_id = " + p_id + ", p_name = " + p_name + ", cat_id = " + cat_id + ", descript = " + descript
				+ ", price = " + price + ", p_num = " + p_num + "]";
	}
	
	
}

package com.saladseller.model;

public class Product {

	private int p_id;
	private String p_name;
	private String category;
	private String descripttion;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescripttion() {
		return descripttion;
	}

	public void setDescripttion(String descripttion) {
		this.descripttion = descripttion;
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
		return "Product{" +
				"p_id=" + p_id +
				", p_name='" + p_name + '\'' +
				", category='" + category + '\'' +
				", descripttion='" + descripttion + '\'' +
				", price=" + price +
				", p_num=" + p_num +
				'}';
	}
}

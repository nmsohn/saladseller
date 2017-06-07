package com.saladseller.model;

public class Product {

	private int p_id;
	private String p_name;
	private String category;
	private String description;
	private double price;
	private int quantity;
	private String imgPath;

	public Product(String p_name, String category, String description, double price, int quantity, String imgPath) {
		this.p_name = p_name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.imgPath = imgPath;
	}

	public Product(int p_id, String p_name, String category, String description, int price, int quantity, String imgPath) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.imgPath = imgPath;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}

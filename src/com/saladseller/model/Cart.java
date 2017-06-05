package com.saladseller.model;

public class Cart {
	private Product product;
	private int quantity;
	

	public Cart(Product p) {
		product = p;
		quantity = 1;
	}

	// Method to increase the quantity
	// of the product in the cart
	public void incrementQuantity() {
		quantity++;
	}

	// Method to decrease the quantity
	// of the product in the cart
	public void decrementQuantity() {
		--quantity;
	}

	/**
	 * 
	 * Beginning of Getters and Setters
	 */

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * End of Getters and Setters
	 */

	public double getTotal() {
		double amount = 0;
		amount = (this.getQuantity() * product.getPrice());
		return amount;
	}
}

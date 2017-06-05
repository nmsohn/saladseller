package com.saladseller.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.jsp.PageContext;

import com.saladseller.model.Cart;
import com.saladseller.model.Product;

public class CartService {
	private static HashMap<Integer, Cart> itemsMap = null;
	private int numberOfItems = 0;
	private final static Logger LOGGER = Logger.getLogger(CartService.class
			.getName());

	public CartService() {
		itemsMap = new HashMap<Integer, Cart>();
	}

	// Adds items to the shopping cart
	public synchronized void add(int p_id, Product p) {
		Cart newItem = new Cart(p);
		itemsMap.put(p_id, newItem);
		LOGGER.info("Quantity is :" + newItem.getQuantity());
	}

	// Update items in the shopping cart
	public synchronized void updateQuantity(int p_id, int quantity,
			Product p) {
		if (itemsMap.containsKey(p_id)) {
			Cart scItem = (Cart) itemsMap
					.get(p_id);
			scItem.setQuantity(quantity);
		}
	}

	// Remove items from the shopping cart
	public synchronized void remove(int p_id) {
		if (itemsMap.containsKey(p_id)) {
			Cart scItem = itemsMap.get(p_id);
			if (scItem.getQuantity() <= 1) {
				itemsMap.remove(p_id);
			}
			numberOfItems--;
		}
	}

	// Clear all items in the shopping cart
	public synchronized void clear() {
		LOGGER.info("Clearing the Shopping Cart");
		itemsMap.clear();
		numberOfItems = 0;
	}

	// Get All the Items in the Shopping Cart
	public synchronized List<Cart> getItems() {
		List<Cart> listOfItems = new ArrayList<Cart>();
		listOfItems.addAll(this.itemsMap.values());
		return listOfItems;
	}

	// Get Number of Items in the Shopping Cart
	public synchronized int getNumberOfItems() {
		numberOfItems = 0;
		Iterator<Cart> scItemIterator = getItems().iterator();

		while (scItemIterator.hasNext()) {
			Cart items = scItemIterator.next();
			numberOfItems += items.getQuantity();
		}

		return numberOfItems;
	}

	// Get the Total Value of the Shopping Cart
	public synchronized double getTotal() {

		double amount = 0.0;
		Iterator<Cart> anotherSCItemIterator = getItems()
				.iterator();
		while (anotherSCItemIterator.hasNext()) {
			Cart anotherSCItem = anotherSCItemIterator.next();
			Product product = anotherSCItem.getProduct();
			amount += (anotherSCItem.getQuantity() * product.getPrice());
		}

		return amount;
	}

	// Checks whether a particular product
	// is already present in the cart
	public static boolean checkProductInCart(PageContext pageContext) {
		int productID = (int) pageContext.findAttribute("p_id");
		if (itemsMap == null)
			itemsMap = new HashMap<Integer, Cart>();
		if (itemsMap.containsKey(productID)) {
			LOGGER.info("Product already exists in the cart");
			return true;
		}
		return false;
	}
}

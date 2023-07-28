package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	@Column(name = "itemName")
	private String itemName;

	@Column(name = "itemUnitPrice")
	private double itemUnitPrice;

	 @ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Order order;

	@Column(name = "itemQuantity")
	private int itemQuantity;
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemUnitPrice() {
		return itemUnitPrice;
	}

	public void setItemUnitPrice(double itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Item(Long itemId, String itemName, double itemUnitPrice, Order order, int itemQuantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemUnitPrice = itemUnitPrice;
		this.order = order;
		this.itemQuantity = itemQuantity;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

}
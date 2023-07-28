package com.example.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private Long orderId;

	@Column(name = "orderDate")
	private Date orderDate;

	@Column(name = "orderStatus")
	private String orderStatus;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Item> collectionOfItems;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<Item> getCollectionOfItems() {
		return collectionOfItems;
	}

	public void setCollectionOfItems(List<Item> collectionOfItems) {
		this.collectionOfItems = collectionOfItems;
	}

	public Order(Long orderId, Date orderDate, String orderStatus, List<Item> collectionOfItems) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.collectionOfItems = collectionOfItems;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructors, getters, and setters

}

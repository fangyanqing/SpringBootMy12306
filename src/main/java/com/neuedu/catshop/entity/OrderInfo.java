package com.neuedu.catshop.entity;

public class OrderInfo {
	private Integer orderId;
	private Integer num;
	private String orderState;
	
	private String orderTime;
	private String deliveryTime;
	
	private Product product;
	
	private User user;

	
	
	public OrderInfo() {
		super();
	}

	public OrderInfo(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	

	public OrderInfo(Integer orderId, Integer num, String orderState, String orderTime, String deliveryTime,
			Product product, User user) {
		super();
		this.orderId = orderId;
		this.num = num;
		this.orderState = orderState;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.product = product;
		this.user = user;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}


	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}

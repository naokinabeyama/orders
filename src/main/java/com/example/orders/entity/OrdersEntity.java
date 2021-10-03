package com.example.orders.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrdersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int placeId;
	private int statusCode;
	private String clientName;
	private String address;
	private String tell;
	private String itemName;
	private int price;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	
	@OneToOne
	@JoinColumn(name="placeId", insertable = false, updatable = false)
	private PlacesEntity placesEntity;
	
	@ManyToOne
	@JoinColumn(name="statusCode", insertable = false, updatable = false)
	private OrderStatusEntity orderStatusEntity;
	
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return placeId
	 */
	public int getPlaceId() {
		return placeId;
	}
	/**
	 * @param placeId セットする placeId
	 */
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	/**
	 * @return statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode セットする statusCode
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName セットする clientName
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return tell
	 */
	public String getTell() {
		return tell;
	}
	/**
	 * @param tell セットする tell
	 */
	public void setTell(String tell) {
		this.tell = tell;
	}
	/**
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return createdAt
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt セットする createdAt
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return updateAt
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updateAt セットする updateAt
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	public PlacesEntity getPlacesEntity() {
		return placesEntity;
	}
	
	public void setPlacesEntity(PlacesEntity placesEntity) {
		this.placesEntity = placesEntity;
	}
	
	public OrderStatusEntity getOrdersStatusEntity() {
		return orderStatusEntity;
	}
	
	public void setOrderStatusEntity(OrderStatusEntity orderStatusEntity) {
		this.orderStatusEntity = orderStatusEntity;
	}
}

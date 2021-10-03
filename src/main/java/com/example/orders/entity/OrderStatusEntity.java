package com.example.orders.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_status")
public class OrderStatusEntity {
	
	@Id
	private int code;
	private String val;
	/**
	 * @return code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code セットする code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return val
	 */
	public String getVal() {
		return val;
	}
	/**
	 * @param val セットする val
	 */
	public void setVal(String val) {
		this.val = val;
	}
}

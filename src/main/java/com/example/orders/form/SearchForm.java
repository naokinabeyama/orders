package com.example.orders.form;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SearchForm {
	
	private int orderId;
	private int status;
	
	@Size(max=10, message="商品単価(from)は10桁以内で入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "商品単価(from)は半角数字で入力してください")
	private String priceFrom;
	
	@Size(max=10, message="商品単価(to)は10桁以内で入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "商品単価(to)は半角数字で入力してください")
	private String priceTo;
	
	@Size(max=32, message="顧客名は32文字以内で入力してください")
	private String clientName;
	
	private int companyId;
	private boolean orderDateSort;
	/**
	 * @return orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId セットする orderId
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * @return priceFrom
	 */
	public String getPriceFrom() {
		return priceFrom;
	}
	/**
	 * @param priceFrom セットする priceFrom
	 */
	public void setPriceFrom(String priceFrom) {
		this.priceFrom = priceFrom;
	}
	/**
	 * @return priceTo
	 */
	public String getPriceTo() {
		return priceTo;
	}
	/**
	 * @param priceTo セットする priceTo
	 */
	public void setPriceTo(String priceTo) {
		this.priceTo = priceTo;
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
	 * @return companyId
	 */
	public int getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId セットする companyId
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return orderDateSort
	 */
	public boolean isOrderDateSort() {
		return orderDateSort;
	}
	/**
	 * @param orderDateSort セットする orderDateSort
	 */
	public void setOrderDateSort(boolean orderDateSort) {
		this.orderDateSort = orderDateSort;
	}
	/**
	 * @return status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status セットする status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
}

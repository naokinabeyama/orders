package com.example.orders.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "places")
public class PlacesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int companyId;
	private String placeItemName;
	private int placeQuantity;
	private long placeItemPrice;
	
	@ManyToOne
	@JoinColumn(name="companyId", insertable = false, updatable = false)
	private CompaniesEntity companiesEntity;
	
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
	 * @return placeItemName
	 */
	public String getPlaceItemName() {
		return placeItemName;
	}
	/**
	 * @param placeItemName セットする placeItemName
	 */
	public void setPlaceItemName(String placeItemName) {
		this.placeItemName = placeItemName;
	}
	/**
	 * @return placeQuantity
	 */
	public int getPlaceQuantity() {
		return placeQuantity;
	}
	/**
	 * @param placeQuantity セットする placeQuantity
	 */
	public void setPlaceQuantity(int placeQuantity) {
		this.placeQuantity = placeQuantity;
	}
	/**
	 * @return placeItemPrice
	 */
	public long getPlaceItemPrice() {
		return placeItemPrice;
	}
	/**
	 * @param placeItemPrice セットする placeItemPrice
	 */
	public void setPlaceItemPrice(long placeItemPrice) {
		this.placeItemPrice = placeItemPrice;
	}
	
	public CompaniesEntity getCompaniesEntity() {
		return companiesEntity;
	}
	
	public void setCompaniesEntity(CompaniesEntity companiesEntity) {
		this.companiesEntity = companiesEntity;
	}
	
}

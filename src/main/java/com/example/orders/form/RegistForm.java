package com.example.orders.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistForm {
	
	@NotBlank(message = "顧客名を入力してください")
	@Size(max = 32, message = "顧客名は32文字以内で入力してください")
	private String clientName;
	
	@NotBlank(message = "顧客電話番号を入力してください")
	@Pattern(regexp = "^(0{1}\\d{9,10})$", message="顧客電話番号は10文字以上11文字以内で入力してください")
	private String tell;
	
	@NotBlank(message = "住所を入力してください")
	@Size(max = 50, message = "住所は50文字以内で入力してください")
	private String address;
	
	@NotBlank(message = "商品名を入力してください")
	@Size(max = 255, message = "商品名は255文字以内で入力してください")
	private String itemName;
	
	@NotBlank(message = "商品単価を入力してください")
	@Size(max = 10, message = "商品単価は10桁以内で入力してください")
	@Pattern(regexp = "^[0-9]*$", message="商品単価は半角数字で入力してください")
	private String itemPrice;
	
	@Min(value = 0, message = "会社名を選択してください")
	private int companyId;
	
	@NotBlank(message = "発注商品名を入力してください")
	@Size(max = 255, message = "発注商品名は255文字以内で入力してください")
	private String placeItemName;
	
	@NotBlank(message = "発注数を入力してください")
	@Size(max = 9, message ="発注数は9桁以内で入力してください")
	@Pattern(regexp = "^[0-9]*$", message="発注数は半角数字で入力してください")
	private String placeQuantity;
	
	@NotBlank(message = "発注単価を入力してください")
	@Size(max = 10, message = "発注単価は10桁以内で入力してください")
	@Pattern(regexp = "^[0-9]*$", message="発注単価は半角数字で入力してください")
	private String placeItemPrice;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getPlaceItemName() {
		return placeItemName;
	}

	public void setPlaceItemName(String placeItemName) {
		this.placeItemName = placeItemName;
	}

	public String getPlaceQuantity() {
		return placeQuantity;
	}

	public void setPlaceQuantity(String placeQuantity) {
		this.placeQuantity = placeQuantity;
	}

	public String getPlaceItemPrice() {
		return placeItemPrice;
	}

	public void setPlaceItemPrice(String placeItemPrice) {
		this.placeItemPrice = placeItemPrice;
	}

}

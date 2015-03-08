package com.cik.elasticsearch.dto;

import io.searchbox.annotations.JestId;

public class BaseSearchRequest {
	@Override
	public String toString() {
		return "BaseSearchRequest [documentId=" + documentId + ", chefName="
				+ chefName + ", menuName=" + menuName + ", cuisineType="
				+ cuisineType + ", cuisineName=" + cuisineName + ", location="
				+ location + ", zipCode=" + zipCode + "]";
	}
	@JestId
	private String documentId;
	
	private String chefName;
	private String menuName;
	private String cuisineType;
	private String cuisineName;
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getChefName() {
		return chefName;
	}
	public void setChefName(String chefName) {
		this.chefName = chefName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getCuisineName() {
		return cuisineName;
	}
	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	private String location;
	private String zipCode;

}

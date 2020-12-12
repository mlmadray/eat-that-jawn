package com.techelevator.model;

public class Category {
	
	private int zomatoCategoryId;
	private String categoryName;
	
	public Category() {}
	
	public Category(int id, String name) {
		this.categoryName = name;
		this.zomatoCategoryId = id;
	}
	
	public int getZomatoCategoryId() {
		return zomatoCategoryId;
	}
	public void setZomatoCategoryId(int zomatoCategoryId) {
		this.zomatoCategoryId = zomatoCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}

package com.techelevator.model;

public class Neighborhood {
	
	private int localitySubzoneId;
	private String localitySubzoneName;
	
	public Neighborhood() {}
	public Neighborhood(int id, String name) {
		this.localitySubzoneId = id;
		this.localitySubzoneName = name;
	}
	public int getLocalitySubzoneId() {
		return localitySubzoneId;
	}
	public void setLocalitySubzoneId(int localitySubzoneId) {
		this.localitySubzoneId = localitySubzoneId;
	}
	public String getLocalitySubzoneName() {
		return localitySubzoneName;
	}
	public void setLocalitySubzoneName(String localitySubzoneName) {
		this.localitySubzoneName = localitySubzoneName;
	}

}

package com.psgtech.fileio;

public class AddressModel {
	private String street;
	private String city;
	private int zipcode;
	@SuppressWarnings("unused")
	private String country;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString(){
		return getStreet() + ", "+getCity()+", "+getZipcode()+ ", "+getCountry();
	}
}

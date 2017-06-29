package com.psgsft.test;

import java.io.Serializable;

public class Address implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 9156870242363105700L;
String City;
String State;
String Country;
String Street;
int zipcode;
int AddressID;
public String getCity() {
	return City;
}
public String getCountry() {
	return Country;
}
public String getState() {
	return State;
}
public String getStreet() {
	return Street;
}
public int getZipcode() {
	return zipcode;
}
public int getAddress() {
	return AddressID;
}

public Address() {
	// TODO Auto-generated constructor stub
}
}

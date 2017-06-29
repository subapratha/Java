package com.psgsft.test;

import java.io.Serializable;
import java.sql.Date;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1377827542702177644L;
	
	int Numberofguests;
	String IDCardNo;
	int phoneNumber;
	Address adresss;
	Services ServicesAvailed;
	String GuestName;
	Date Occupiedon;
	Date Vacatedon;
	String ReservedBy;
	Rooms roomalloted; 
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Address getAdresss() {
		return adresss;
	}
	public String getGuestName() {
		return GuestName;
	}
	public String getIDCardNo() {
		return IDCardNo;
	}
	public int getNumberofguests() {
		return Numberofguests;
	}
	public Date getOccupiedon() {
		return Occupiedon;
	}public int getPhoneNumber() {
		return phoneNumber;
	}
	public String getReservedBy() {
		return ReservedBy;
	}public Services getServicesAvailed() {
		return ServicesAvailed;
	}public Date getVacatedon() {
		return Vacatedon;
	}
	public Rooms getRoomalloted() {
		return roomalloted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

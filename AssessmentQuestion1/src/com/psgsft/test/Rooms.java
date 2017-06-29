package com.psgsft.test;

import java.sql.Date;

public class Rooms {
int RoomId;
RoomType roomType;
String description;
String floornumber;
int RoomNo;
Date Occupiedon;
Date Vacatedon;
Date cancelledon;
Date checkintime;
Date Checkouttime;
Employees Approvedby;
int vacant;
// roomno
public int getRoomNo() {
	return RoomNo;
}
//floornumber
public String getFloornumber() {
	return floornumber;
}
//any facilities 
public String getDescription() {
	return description;
}
//room cancelled on
public Date getCancelledon() {
	return cancelledon;
}
//room occupied on
public Date getOccupiedon() {
	return Occupiedon;
}
//ac or nonac or cot type 

public RoomType getRoomType() {
	return roomType;
}
// room vacated on
public Date getVacatedon() {
	return Vacatedon;
}

public Rooms() {
	// TODO Auto-generated constructor stub
}
public Employees getApprovedby() {
	return Approvedby;
}public Date getCheckintime() {
	return checkintime;
}
public Date getCheckouttime() {
	return Checkouttime;
}public int getRoomId() {
	return RoomId;
}
}

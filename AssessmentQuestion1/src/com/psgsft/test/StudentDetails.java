package com.psgsft.test;
import java.io.Serializable;
public class StudentDetails implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -5891825376673339202L;
String rollNo;
String fullName;
Double percentage;
int phoneNumber;

public StudentDetails(String rollNo, String fullName, Double percentage, int phoneNumber) {
	// TODO Auto-generated constructor stub
	this.rollNo=rollNo;
	this.fullName=fullName;
	this.percentage=percentage;
	this.phoneNumber=phoneNumber;
	
}
public String getRollNo() {
	return rollNo;
}
public String getFullName() {
	return fullName;
}
public Double getPercentage() {
	return percentage;
}
public int getPhoneNumber() {
	return phoneNumber;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}
public void setPercentage(Double percentage) {
	this.percentage = percentage;
}
public void setPhoneNumber(int phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public static void add(StudentDetails studentDetails) {
	// TODO Auto-generated method stub
	
}

}

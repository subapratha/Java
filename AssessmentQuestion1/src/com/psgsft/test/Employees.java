package com.psgsft.test;

import java.sql.Date;

public class Employees {

String FullName;
String Designation;
Double Salary;
int PhoneNumber;
Date DateofJoining;
Address address;
int EmployeeID;
public Employees() {
	// TODO Auto-generated constructor stub
}
public String getFullName() {
	return FullName;
}
public int getPhoneNumber() {
	return PhoneNumber;
}
public Double getSalary() {
	return Salary;
}
public Date getDateofJoining() {
	return DateofJoining;
}
public String getDesignation() {
	return Designation;
}
public Address getAddress() {
	return address;
}
public int getEmployeeID() {
	return EmployeeID;
}
}

package com.psgtech.fileIO;

import java.io.Serializable;

public class Student implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int rollNo;
String Name;
Double Marks;
transient String address;




public int getRollNo() {
	return rollNo;
}
public String getName() {
	return Name;
}

public Double getMarks() {
	return Marks;
}
public String getAddress() {
	return address;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public Student(int rollNumber, String name, Double Marks, String address)
{
  this.rollNo = rollNumber;
  this.Name = name;
  this.Marks = Marks;
  this.address = address;
}
    }

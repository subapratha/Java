package com.psgtech.fileio;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class StudentModel {

	@SerializedName("studID")
	private String id;
	private String name;
	//private boolean permanent;
	transient AddressModel address;
	private long[] phoneNumbers;
	//private String role;
	private List<String> cities;
	private Map<String, String> properties;
	//private int phoneNumbers;
	private String rollNo; 
	  
	   
	public String getId() { 
	      return id; 
	   }  
	   public void setId(String id) { 
	      this.id = id; 
	   }  
	   public long[] getPhoneNumbers() { 
	      return phoneNumbers; 
	   }  
	   public void setPhoneNumbers(long[] phoneNumbers) { 
	      this.phoneNumbers = phoneNumbers; 
	   }
	   public String getRollNo() { 
		      return rollNo; 
		   }  
		   public void setRollNo(String rollNo) { 
		      this.rollNo = rollNo; 
		   }
	   public String getName() { 
	      return name; 
	   } 
	   public void setName(String name) { 
	      this.name = name; 
	   } 
	  /* class Name { 
	      public String fullname; 
	      //public String lastName; 
	   }*/ 
	public AddressModel getAddress() {
		return address;
	}
	public void setAddress(AddressModel address) {
		this.address = address;
	}
	
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***** Student Details *****\n");
		sb.append("ID="+getId()+"\n");
		sb.append("Name="+getName()+"\n");
		sb.append("rollNo="+getRollNo()+"\n");
		sb.append("Phone Numbers="+Arrays.toString(getPhoneNumbers())+"\n");
		sb.append("Address="+getAddress()+"\n");
		sb.append("Cities="+Arrays.toString(getCities().toArray())+"\n");
		sb.append("Properties="+getProperties()+"\n");
		sb.append("*****************************");
		
		return sb.toString();
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public Map<String, String> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	
}

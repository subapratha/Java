package com.psgtech.fileio;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class MyClass {

	@JsonProperty
	private String Name;
	@JsonProperty
	private String CreationDate;
	
	public String getName() { 
	      return Name; 
	   } 
	   public void setName(String name) { 
	      this.Name = name; 
	   }
	   @Override
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("***** Student Details *****\n");
			sb.append("Name="+getName()+"\n");
					
			return sb.toString();
		}
	
}

package com.psgtech.fileio.jsontofile;
import com.psgtech.fileio.AddressModel;

import com.psgtech.fileio.StudentModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
public class jsonreader {
public static void main(String[] args) throws IOException
{
	try{
		InputStream is = new FileInputStream("f:\\21.json");
		InputStreamReader isr = new InputStreamReader(is);

		//create JsonReader object
		JsonReader reader = new JsonReader(isr);

		//create objects
		StudentModel Student = new StudentModel();
		AddressModel add = new AddressModel();
		Student.setAddress(add);
		List<Long> phoneNums = new ArrayList<Long>();
		Student.setCities(new ArrayList<String>());
		Student.setProperties(new HashMap<String, String>());
		String key = null;
		boolean insidePropertiesObj=false;

		key = parseJSON(reader, Student, phoneNums, key, insidePropertiesObj);

		System.out.println("Key" + key);

		long[] nums = new long[phoneNums.size()];
		int index = 0;
		for (Long l : phoneNums) {
			nums[index++] = l;
		}
		Student.setPhoneNumbers(nums);

		reader.close();
		//print employee object
		System.out.println("Student Object\n\n"+Student);
	}
	catch(IOException e){
		e.printStackTrace();
	}
}

private static String parseJSON(JsonReader reader, StudentModel Student,List<Long> phoneNums, String key, boolean insidePropertiesObj) throws IOException {
	
	//loop to read all tokens
			while(reader.hasNext()){
				//get next token
				JsonToken token = reader.peek();
				
				switch(token){
				case BEGIN_OBJECT:
					reader.beginObject();
					if("address".equals(key) || "properties".equals(key)){
						while(reader.hasNext()){
						parseJSON(reader, Student,phoneNums, key, insidePropertiesObj);
						}
						reader.endObject();
					}
					break;
				case END_OBJECT:
					reader.endObject();
					if(insidePropertiesObj) insidePropertiesObj=false;
					break;
				case BEGIN_ARRAY:
					reader.beginArray();
					if("phoneNumbers".equals(key) || "cities".equals(key)){
						while(reader.hasNext()){
							parseJSON(reader, Student,phoneNums, key, insidePropertiesObj);
							}
						reader.endArray();
					}
					break;
				case END_ARRAY:
					reader.endArray();
					break;
				case NAME:
					key = reader.nextName();
					if("properties".equals(key)) insidePropertiesObj=true;
					break;
				/*case BOOLEAN:
					if("permanent".equals(key)) Student.setPermanent(reader.nextBoolean());
					else{
						System.out.println("Unknown item found with key="+key);
						//skip value to ignore it
						reader.skipValue();
					}
					break;*/
				case NUMBER:
					
				 if("phoneNumbers".equals(key)) phoneNums.add(reader.nextLong());
					//else if("zipcode".equals(key)) emp.getAddress().setZipcode(reader.nextInt());
					else {
						System.out.println("Unknown item found with key="+key);
						//skip value to ignore it
						reader.skipValue();
					}
					break;
				case STRING:
					
					setStringValues(Student, key, reader.nextString(), insidePropertiesObj);
					
					break;
				case NULL:
					System.out.println("Null value for key"+key);
					reader.nextNull();
					break;
				case END_DOCUMENT:
					System.out.println("End of Document Reached");
					break;
				default:
					System.out.println("This part will never execute");
					break;
					
				}
			}
			return key;
}



private static void setStringValues(StudentModel Student, String key,
		String value, boolean insidePropertiesObj) {
	if("$oid".equals(key)) Student.setId(value);
	else if("fullname".equals(key)) Student.setName(value);
	else if("role".equals(key)) Student.setRollNo(value);
	else if("cities".equals(key)) Student.getCities().add(value);
	else if ("street".equals(key)) Student.getAddress().setStreet(value);
	else if("city".equals(key)) Student.getAddress().setCity(value);
	else{
		//add to Student properties map
		if(insidePropertiesObj){
			Student.getProperties().put(key, value);
		}else{
			System.out.println("Unknown data found with key="+key+" value="+value);
		}
		
	}
}


}


package com.psgtech.fileio.jsontofile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.psgtech.fileio.AddressModel;

import com.psgtech.fileio.StudentModel;
public class JacksonAPI {
public static void main(String[] args) throws JsonParseException, IOException {
		
		//create JsonParser object
		JsonParser jsonParser = new JsonFactory().createParser(new File("F:\\21.json"));
		
		//loop through the tokens
		StudentModel stu = new StudentModel();
		AddressModel address = new AddressModel();
		stu.setAddress(address);
		stu.setCities(new ArrayList<String>());
		stu.setProperties(new HashMap<String, String>());
		List<Long> phoneNums = new ArrayList<Long>();
		boolean insidePropertiesObj=false;
		
		parseJSON(jsonParser, stu, phoneNums, insidePropertiesObj);
		
		long[] nums = new long[phoneNums.size()];
		int index = 0;
		for(Long l :phoneNums){
			nums[index++] = l;
		}
		stu.setPhoneNumbers(nums);
		
		jsonParser.close();
		//print Student object
		System.out.println("Student Object\n\n"+stu);
	}

	/**
	 * @param jsonParser
	 * @param stu
	 * @param phoneNums
	 * @param insidePropertiesObj
	 * @throws JsonParseException
	 * @throws IOException
	 */
	private static void parseJSON(JsonParser jsonParser, StudentModel stu,
			List<Long> phoneNums, boolean insidePropertiesObj) throws JsonParseException, IOException {
		
		//loop through the JsonTokens
		while(jsonParser.nextToken() != JsonToken.END_OBJECT){
			String name = jsonParser.getCurrentName();
			if("id".equals(name)){
				jsonParser.nextToken();
				stu.setId(jsonParser.getText());
			}else if("name".equals(name)){
				jsonParser.nextToken();
				stu.setName(jsonParser.getText());
			//}else if("permanent".equals(name)){
				//jsonParser.nextToken();
				//stu.setPermanent(jsonParser.getBooleanValue());
			}else if("address".equals(name)){
				jsonParser.nextToken();
				//nested object, recursive call
				parseJSON(jsonParser, stu, phoneNums, insidePropertiesObj);
			}else if("street".equals(name)){
				jsonParser.nextToken();
				stu.getAddress().setStreet(jsonParser.getText());
			}else if("city".equals(name)){
				jsonParser.nextToken();
				stu.getAddress().setCity(jsonParser.getText());
			}else if("zipcode".equals(name)){
				jsonParser.nextToken();
				stu.getAddress().setZipcode(jsonParser.getIntValue());
			}else if("phoneNumbers".equals(name)){
				jsonParser.nextToken();
				while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
					phoneNums.add(jsonParser.getLongValue());
				}
			}else if("role".equals(name)){
				jsonParser.nextToken();
				stu.setRollNo(jsonParser.getText());
			}else if("cities".equals(name)){
				jsonParser.nextToken();
				while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
					stu.getCities().add(jsonParser.getText());
				}
			}else if("properties".equals(name)){
				jsonParser.nextToken();
				while(jsonParser.nextToken() != JsonToken.END_OBJECT){
					String key = jsonParser.getCurrentName();
					jsonParser.nextToken();
					String value = jsonParser.getText();
					stu.getProperties().put(key, value);
				}
			}
		}
	}


}

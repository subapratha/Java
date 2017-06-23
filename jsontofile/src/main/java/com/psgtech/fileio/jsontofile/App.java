package com.psgtech.fileio.jsontofile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
//import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import com.google.gson.stream.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.psgtech.fileio.AddressModel;
import com.psgtech.fileio.MyClass;
import com.psgtech.fileio.StudentModel;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("unused")
public class App {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		// JSONParser Parser = new JSONParser();
		try {

			
	
			System.out.println("-----------JSON to class-----------------");

			InputStream is = new FileInputStream("f:\\21.json");
			InputStreamReader isr = new InputStreamReader(is);
			System.out.println("input stream " + is);
			System.out.println("input stream reader" + isr);
			// create JsonReader object
			JsonReader reader = new JsonReader(isr);
			// create objects
			StudentModel Student = new StudentModel();
			AddressModel add = new AddressModel();
			Student.setAddress(add);
			List<Long> phoneNums = new ArrayList<Long>();
			Student.setCities(new ArrayList<String>());
			Student.setProperties(new HashMap<String, String>());
			String key = null;
			boolean insidePropertiesObj = false;

			key = parseJSON(reader, Student, phoneNums, key, insidePropertiesObj);

			System.out.println("Key" + key);

			long[] nums = new long[phoneNums.size()];
			int index = 0;
			for (Long l : phoneNums) {
				nums[index++] = l;
			}
			Student.setPhoneNumbers(nums);

			reader.close();
			// print Student object
			// System.out.println("Student Object\n\n" + Student);

			
			
		}catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	private static String parseJSON(JsonReader reader, StudentModel Student, List<Long> phoneNums, String key,
			boolean insidePropertiesObj) throws IOException {

		// loop to read all tokens
		while (reader.hasNext()) {
			// get next token
			JsonToken token = reader.peek();

			switch (token) {
			case BEGIN_OBJECT:
				reader.beginObject();
				if ("address".equals(key) || "properties".equals(key)) {
					while (reader.hasNext()) {
						parseJSON(reader, Student, phoneNums, key, insidePropertiesObj);
						// setStringValues( Student, key, reader.nextString(),
						// insidePropertiesObj);
					}
					reader.endObject();
				}
				break;
			case END_OBJECT:
				reader.endObject();
				if (insidePropertiesObj)
					insidePropertiesObj = false;
				break;
			case BEGIN_ARRAY:
				reader.beginArray();
				if ("contactNo".equals(key) || "city".equals(key)) {
					while (reader.hasNext()) {
						parseJSON(reader, Student, phoneNums, key, insidePropertiesObj);
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
			case NUMBER:
				if ("contactNo".equals(key))
					phoneNums.add(reader.nextLong());
				else {
					System.out.println("Unknown item found with key=" + key);
					// skip value to ignore it
					reader.skipValue();
				}
				break;
			case STRING:
				setStringValues(Student, key, reader.nextString(), insidePropertiesObj);
				break;
			case NULL:
				System.out.println("Null value for key" + key);
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

	private static void setStringValues(StudentModel Student, String key, String value, boolean insidePropertiesObj) {
		if ("fullName".equals(key))
			Student.setName(value);
		else if ("$oid".equals(key))
			Student.setId(value);
		
		else if ("country".equals(key))
			Student.getAddress().setCountry(value);
		else if ("regNo".equals(key))
			Student.setRollNo(value);
		else {
			// add to Student properties map
			
			 if(insidePropertiesObj){ Student.getProperties().put(key, value);
			  }
			 
		 else {
			System.out.println("Unknown data found with key=" + key + " value=" + value);
		}
	}
}
}

package com.psgtech.fileio.jsontofile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.stream.JsonReader;
//import com.google.gson.stream.JsonToken;

public class RegRecordJsonTransformer {

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		if (args.length < 1) {
			System.err.println("Pass input JSON file");
			System.exit(-1);
		}

		// read JSON file to get JSON array
		Map<String, Object>[] inputJsonArray = readInputJson(args[0]);

		// iterate each element in JSON array and transform to target array
		// Map<String, Object>[][] targetJsonArray =
		// transformJson(inputJsonArray);

		// export target array into required output format
		// exportJsonArray(targetJsonArray);
		System.out.println(inputJsonArray);
	}

	private static Map<String, Object>[] readInputJson(String inputFileName)
			throws UnsupportedEncodingException, FileNotFoundException {
		JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(inputFileName), "UTF-8"));
		try {
			return readMessagesArray(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object>[] readMessagesArray(JsonReader reader) throws IOException {
		List<Map<String, Object>> messages = new ArrayList<Map<String, Object>>();

		reader.beginArray();
		while (reader.hasNext()) {
			messages.add(readMessage(reader));
		}
		reader.endArray();

		return (Map<String, Object>[]) messages.toArray();
	}

	public static Map<String, Object> readMessage(JsonReader reader) throws IOException {
		Map<String, Object> record = new HashMap<>();
		String name = "";
	       String value="";
	       
		reader.beginObject();
		 while (reader.hasNext()) {
			  name = reader.nextName();
		      
		       
		       if (name.equals("_id")) {
		         value = reader.nextString();
		       } else {
		         reader.skipValue();
		       }
			     
		     }
		 
		     reader.endObject();
		     return record(name, value);
	}

	private static Map<String, Object> record(String name, String value) {
		// TODO Auto-generated method stub
		//return null;
		System.out.printf(name,value);
		return null;
	}

}

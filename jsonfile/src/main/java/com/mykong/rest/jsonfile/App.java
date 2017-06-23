package com.mykong.rest.jsonfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
//import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.Json;
import javax.json.stream.JsonParser;
//import javax.swing.text.html.HTMLDocument.Iterator;

@SuppressWarnings("unused")
public class App {

	public static void main(String args[]) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			// read JSON from a file
			Map<String, Object> map = mapper.readValue(new File("f:\\21.json"),
					new TypeReference<Map<String, Object>>() {
					});

			// Getting Set of keys

			Set<String> keySet = map.keySet();

			// Creating an ArrayList of keys

			ArrayList<String> listOfKeys = new ArrayList<String>(keySet);

			System.out.println("ArrayList Of Keys :");

			for (String key : listOfKeys) {
				System.out.println(key);
			}

			System.out.println("--------------------------");
			System.out.println(map.size());
			System.out.println(map);
			
			Iterator<String> keySetIterator = keySet.iterator();
			while (keySetIterator.hasNext()) {
			   System.out.println("------------------------------------------------");
			   System.out.println("Iterating Map in Java using KeySet Iterator");
			   String key = keySetIterator.next();
			   System.out.println("key: " + key + " value: " + map.get(key));
			}


			
			
			// Getting Collection of values

			Collection<Object> values = map.values();

			// Creating an ArrayList of values

			ArrayList<Object> listOfValues = new ArrayList<Object>(values);

			System.out.println("ArrayList Of Values :");

			for (Object value : listOfValues) {
				System.out.println(value);
			}

			System.out.println("--------------------------");

			
			
			
			// Getting the Set of entries

			Set<Entry<String, Object>> entrySet = map.entrySet();

			// Creating an ArrayList Of Entry objects

			ArrayList<Entry<String, Object>> listOfEntry = new ArrayList<Entry<String, Object>>(entrySet);

			System.out.println("ArrayList of Key-Values :");

			for (Entry<String, Object> entry : listOfEntry) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}

			// write JSON to a file
			//mapper.writeValue(new File("F:\\user.json"), map);

		} catch (

		JsonGenerationException e)

		{
			e.printStackTrace();
		} catch (

		JsonMappingException e)

		{
			e.printStackTrace();
		} catch (

		IOException e)

		{
			e.printStackTrace();
		}
	}
}

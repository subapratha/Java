package com.psgtech.fileio.jsontofile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psgtech.fileio.MyClass;


@SuppressWarnings("unused")
public class Mapclass  {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		
	try
	{
	byte[] mapData = Files.readAllBytes(Paths.get("f:\\21.json"));
	Map<String, Object> myMap = new HashMap<String, Object>();

	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	//myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String, Object>>() {
	//});
	List<MyClass> myObjects = objectMapper.readValue(mapData , new TypeReference<List<MyClass>>(){});
	System.out.println("Map using myClassObbjects: " + myObjects);
	System.out.println("Map using TypeReference: " + myMap);
	System.out.println("----------------------------------");
	System.out.println("map iternator ends");
	System.out.println("\nExample 1...");
	Iterator<Entry<String, Object>> iterator = myMap.entrySet().iterator();
	while (iterator.hasNext()) {
		Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
		System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue());
	}

	// more elegant way, this should be the standard way, recommend!
	System.out.println("\nExample 2...");
	for (Map.Entry<String, Object> entry : myMap.entrySet()) {
		System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
	}

	// weired, but works anyway, not recommend!
	System.out.println("\nExample 3...");
	for (Object key : myMap.keySet()) {
		System.out.println("Key : " + key.toString() + " Value : " + myMap.get(key));
	}

	// Java 8 only, forEach and Lambda. recommend!
	System.out.println("\nExample 4...");
	myMap.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));

	System.out.println("map iternator ends");
	}
	catch(IOException e)
	{
		e.printStackTrace();
		
	}
	}
}

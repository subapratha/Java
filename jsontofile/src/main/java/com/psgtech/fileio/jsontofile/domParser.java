package com.psgtech.fileio.jsontofile;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unused")
public class domParser 
{
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		
	try
	{
	byte[] mapData = Files.readAllBytes(Paths.get("f:\\21.json"));
	//Map<String, Object> myMap = new HashMap<String, Object>();
	ObjectMapper objectMapper = new ObjectMapper();
	// read JSON like DOM Parser
	JsonNode rootNode = objectMapper.readTree(mapData);
	JsonNode idNode = rootNode.path("id");
	System.out.println("id = " + idNode.asInt());

	JsonNode phoneNosNode = rootNode.path("contactNo");
	Iterator<JsonNode> elements = phoneNosNode.elements();
	while (elements.hasNext()) {
		JsonNode phone = elements.next();
		System.out.println("Phone No = " + phone.asLong());
	}

	System.out.println("-----------------------------");
}
catch (Exception e)
{
	e.printStackTrace();
	}
	}
}

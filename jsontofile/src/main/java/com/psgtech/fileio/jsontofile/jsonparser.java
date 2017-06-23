package com.psgtech.fileio.jsontofile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
//import com.fasterxml.jackson.core.JsonFactory;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonToken;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.psgtech.fileio.MyClass;

@SuppressWarnings("unused")
public class jsonparser {
	// @SuppressWarnings("unchecked")
	// @SuppressWarnings({ })
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {

		try {
			System.out.println("------------------jsonfactory parser----------------------------------------");

			JsonReader reader = Json.createReader(new FileReader("f:\\21.json"));
			JsonArray jArray = (JsonArray) reader.readArray();

			// Map<String, JsonValue> StudentMap = new HashMap<>();
			LinkedHashMap<String, JsonValue> StudentMap = new LinkedHashMap<String, JsonValue>();
			for (int i = 0; i < jArray.size(); i++) {
				JsonObject object = jArray.getJsonObject(i);
				Iterator<Entry<String, JsonValue>> iterator = object.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry<String, JsonValue> entry = (Map.Entry<String, JsonValue>) iterator.next();
					StudentMap.put(entry.getKey(), entry.getValue());
					
					 System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue());
					

				}
				
			/*	Method method = MyClass.class.getMethod("getStringList", null);

				Type returnType = method.getGenericReturnType();

				if(returnType instanceof ParameterizedType){
				    ParameterizedType type = (ParameterizedType) returnType;
				    Type[] typeArguments = type.getActualTypeArguments();
				    for(Type typeArgument : typeArguments){
				        Class typeArgClass = (Class) typeArgument;
				        System.out.println("typeArgClass = " + typeArgClass);
				    }
				}
*/				System.out.println(StudentMap.getClass());
				
			}

			 StringWriter returnString = new StringWriter();
			    Map<String,HashMap<String, String>> hashMap = new HashMap<String, HashMap<String, String>>();
			    for (Entry e : hashMap.entrySet()) {
			        HashMap<String, Number> hm = (HashMap<String, Number>) e.getValue();
			        String key = (String) e.getKey();
			        returnString.append("|\t").append(key).append("\t|");
			        for (Entry en : hm.entrySet()){
			            returnString.append("|\t").append((String) en.getValue()).append("\t|");
			        }
			        returnString.append("\r\n");
			    }        
			    System.out.println(returnString.toString());

				} catch (

		IOException e)

		{

			e.printStackTrace();

		}

	}
}

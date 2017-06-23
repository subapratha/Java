package com.psgtech.fileio.jsontofile;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;

//import javax.json.JsonArray;
import javax.json.JsonException;

import com.google.gson.JsonElement;
//import javax.json.JsonObject;
//import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
public class JsonParkeyval {
	public static void main(String [] args){
		
			//JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(""), "UTF-8"));
			convertFileToJSON ("f:\\21.json");
	 	
	}
	public static Map<String, Object> convertFileToJSON (String fileName){

        // Read from File to String
  //      JsonObject jsonObject = new JsonObject();
        JsonArray Array = new JsonArray();
        try {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader(fileName));
            //jsonObject = jsonElement.getAsJsonObject();
            Array= jsonElement.getAsJsonArray();
            
            return jsonToMap(Array);
        } catch (FileNotFoundException e) {
           
        }   
        
        
        return null;
    }
	public static Map<String, Object> jsonToMap(JsonArray array) throws JsonException {
	    Map<String, Object> retMap = new HashMap<String, Object>();

	    if(array.isJsonNull()) {
	        retMap = toList(array);
	    }
	    return retMap;
	}

	/*public static Map<String, Object> toMap(JsonArray Array) throws JsonException {
		 Map<String, Object> map = new HashMap<String, Object>();

	        Iterator<String> keysItr = array.keySet().iterator();
	        while(keysItr.hasNext()) {
	            String key = keysItr.next();
	            Object value = array.get(key);

	            if(value instanceof JsonArray) {
	                value = toList((JsonArray) value);
	            }

	            else if(value instanceof JsonObject) {
	                value = toMap((JsonObject) value);
	            }
//	            map.put(key, value);
	//        }
	        return map;
	    }
*/	@SuppressWarnings("unchecked")
public static Map<String, Object> toList(JsonArray array) throws JsonException {
	    List<Object> list = new ArrayList<Object>();
	    //Map<String, Object> map = new HashMap<String, Object>();
	    for(int i = 0; i < array.size(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JsonArray) {
	            value = toList((JsonArray) value);
	        }

	        /*else if(value instanceof JsonObject) {
	            value = toMap((JsonObject) value);
	        }*/
	        list.add(value);
	       // map.put(key, value);
	        System.out.println(Arrays.deepToString(list.toArray()));
	    }
	    return (Map<String, Object>) list;
	}

}

package com.psgtech.fileio.jsontofile;
	import java.io.FileNotFoundException;
	import java.io.InputStreamReader;
	import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Map.Entry;

	import com.google.gson.GsonBuilder;
	import com.google.gson.JsonArray;
	import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
	import com.google.gson.JsonParser;
	import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

	public class GsonParser {
	    public static void main(String[] args) {
	        try {
	            print(loadJsonArray("data_array.json", true));
	            print(loadJsonObject("data_object.json", true));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void print(Object object) {
	        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(object).toString());
	    }

	    public static Map<String, Object> loadJsonObject(String filename, boolean isResource)
	            throws UnsupportedEncodingException, FileNotFoundException, JsonIOException, JsonSyntaxException, MalformedURLException {
	        return jsonToMap(loadJson(filename, isResource).getAsJsonObject());
	    }

	    public static List<Object> loadJsonArray(String filename, boolean isResource)
	            throws UnsupportedEncodingException, FileNotFoundException, JsonIOException, JsonSyntaxException, MalformedURLException {
	        return jsonToList(loadJson(filename, isResource).getAsJsonArray());
	    }

	    private static JsonElement loadJson(String filename, boolean isResource) throws UnsupportedEncodingException, FileNotFoundException, JsonIOException, JsonSyntaxException, MalformedURLException {
	        return new JsonParser().parse(new InputStreamReader(FileLoader.openInputStream(filename, isResource), "UTF-8"));
	    }

	    public static Object parse(JsonElement json) {
	        if (json.isJsonObject()) {
	            return jsonToMap((JsonObject) json);
	        } else if (json.isJsonArray()) {
	            return jsonToList((JsonArray) json);
	        }

	        return null;
	    }

	    public static Map<String, Object> jsonToMap(JsonObject jsonObject) {
	        if (jsonObject.isJsonNull()) {
	            return new HashMap<String, Object>();
	        }

	        return toMap(jsonObject);
	    }

	    public static List<Object> jsonToList(JsonArray jsonArray) {
	        if (jsonArray.isJsonNull()) {
	            return new ArrayList<Object>();
	        }

	        return toList(jsonArray);
	    }

	    private static final Map<String, Object> toMap(JsonObject object) {
	        Map<String, Object> map = new HashMap<String, Object>();

	        for (Entry<String, JsonElement> pair : object.entrySet()) {
	            map.put(pair.getKey(), toValue(pair.getValue()));
	        }

	        return map;
	    }

	    private static final List<Object> toList(JsonArray array) {
	        List<Object> list = new ArrayList<Object>();

	        for (JsonElement element : array) {
	            list.add(toValue(element));
	        }

	        return list;
	    }

	    private static final Object toPrimitive(JsonPrimitive value) {
	        if (value.isBoolean()) {
	            return value.getAsBoolean();
	        } else if (value.isString()) {
	            return value.getAsString();
	        } else if (value.isNumber()){
	            return value.getAsNumber();
	        }
	        else if (value.isJsonNull()){
	            return value.toString().equals("");
	        }

	        return null;
	    }

	    private static final Object toValue(JsonElement value) {
	        if (value.isJsonNull()) {
	            return null;
	        } else if (value.isJsonArray()) {
	            return toList((JsonArray) value);
	        } else if (value.isJsonObject()) {
	            return toMap((JsonObject) value);
	        } else if (value.isJsonPrimitive()) {
	            return toPrimitive((JsonPrimitive) value);
	        }

	        return null;
	    }
	}


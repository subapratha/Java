package com.psgtech.fileio.jsontofile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;

public class jsonparserold {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
try{
	  
	  JsonFactory jfactory = new JsonFactory();
	  
	 //*** read from file //
		//@SuppressWarnings("deprecation")
		JsonParser jParser =jfactory.createJsonParser(new File("f:\\21.json"));
	
	while (jParser.nextToken() !=	 JsonToken.END_OBJECT) {
	  
String fieldname =  jParser.getCurrentName();

if("fullname".equals(fieldname))
{

// current token is "name", // move
//to next, which is "name"'s value
jParser.nextToken();
System.out.println("name"+jParser.
getText()); // display mkyong

}

if ("age".equals(fieldname)) {

// current token is "age", // move to next, which is "name"'s value
jParser.nextToken();
System.out.println("age"+jParser.getIntValue()); // display 29

}

if ("_id".equals(fieldname)) {

jParser.nextToken(); // current token is "[", move next

// messages is array, loop until token equal to "]"
while(jParser.nextToken() != JsonToken.END_ARRAY) {

// display msg1, msg2, msg3
//System.out.println("values "+jParser.getText());

}

}

} jParser.close();


}catch(

JsonGenerationException e)

{

e.printStackTrace();

} catch(

JsonMappingException e)

{

e.printStackTrace();

} catch(

IOException e)

{

e.printStackTrace();

}

}

}

package com.psgtech.fileio.jsontofile;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Set;

import com.google.gson.stream.JsonWriter;
import com.psgtech.fileio.StudentModel;
public class GsonWriter {
	public static void main(String[] args) throws IOException {
		StudentModel Student = new StudentModel();//.createStudent();
		
		//writing on console, we can initialize with FileOutputStream to write to file
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		JsonWriter writer = new JsonWriter(out);
		//set indentation for pretty print
		writer.setIndent("\t");
		//start writing
		writer.beginObject(); //{
	//	writer.name("id").value(StudentModel.getId().toString()); // "id": 123
		//writer.name("name").value(StudentModel.getName()); // "name": "David"
		///writer.name("permanent").value(Student.isPermanent()); // "permanent": false
		writer.name("address").beginObject(); // "address": {
			writer.name("street").value(Student.getAddress().getStreet()); // "street": "BTM 1st Stage"
			writer.name("city").value(Student.getAddress().getCity()); // "city": "Bangalore"
			writer.name("zipcode").value(Student.getAddress().getZipcode()); // "zipcode": 560100
			writer.endObject(); // }
		writer.name("phoneNumbers").beginArray(); // "phoneNumbers": [
			for(long num : Student.getPhoneNumbers()) writer.value(num); //123456,987654
			writer.endArray(); // ]
		//writer.name("role").value(Student.getRole()); // "role": "Manager"
		writer.name("cities").beginArray(); // "cities": [
			for(String c : Student.getCities()) writer.value(c); //"Los Angeles","New York"
			writer.endArray(); // ]
		writer.name("properties").beginObject(); //"properties": {
			Set<String> keySet = Student.getProperties().keySet();
			for(String key : keySet) writer.name("key").value(Student.getProperties().get(key));//"age": "28 years","salary": "1000 Rs"
			writer.endObject(); // }
		writer.endObject(); // }
		
		writer.flush();
		
		//close writer
		writer.close();
		
	}


}

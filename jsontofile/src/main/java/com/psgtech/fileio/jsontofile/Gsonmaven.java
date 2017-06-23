package com.psgtech.fileio.jsontofile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.psgtech.fileio.AddressModel;
import com.psgtech.fileio.StudentModel;
@SuppressWarnings("unused")
public class Gsonmaven {
	public static void main(String[] args) throws IOException {
		try{
		//StudentModel stu = createStudentModel();

		// Get Gson object
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// read JSON file data as String
		String fileData = new String(Files.readAllBytes(Paths
				.get("f:\\21.json")));

		// parse json string to object
		StudentModel stu1 = gson.fromJson(fileData, StudentModel.class);

		// print object data
		System.out.println("\n\nStudentModel Object\n\n" + stu1);

		// create JSON String from Object
		String jsonstu = gson.toJson(stu1);
		System.out.print(jsonstu);
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
/*
	public static StudentModel createStudentModel() {

		StudentModel stu = new StudentModel();
		stu.setId("99GE100");
		stu.setName("David");
		//stu.setPermanent(false);
		stu.setPhoneNumbers(new long[] { 123456, 987654 });
		stu.setRollNo("Manager");

		AddressModel add = new AddressModel();
		add.setCity("Bangalore");
		add.setStreet("BTM 1st Stage");
		add.setZipcode(560100);
		stu.setAddress(add);

		List<String> cities = new ArrayList<String>();
		cities.add("Los Angeles");
		cities.add("New York");
		stu.setCities(cities);

		Map<String, String> props = new HashMap<String, String>();
		props.put("Department", "Computer Science");
		props.put("age", "18 years");
		stu.setProperties(props);

		return stu;
	}
*/
	}


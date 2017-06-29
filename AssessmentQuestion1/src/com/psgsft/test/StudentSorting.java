package com.psgsft.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.psgsft.test.StudentDetails;


import com.psgsft.test.RollNumberCompare;

		
@SuppressWarnings("unused")
public class StudentSorting {
@SuppressWarnings("rawtypes")
public static void main(String[] args) {
	try {
		 
		//Creating BufferedReader object to read the input text file
        
        BufferedReader reader = new BufferedReader(new FileReader("C://users/admin/desktop/Studentdetails.txt"));
         
        //Creating ArrayList to hold Student objects
         
        ArrayList<StudentDetails> studentRecords = new ArrayList<StudentDetails>();
         
        //Reading Student records one by one
         
        String currentLine = reader.readLine();
         
        while (currentLine != null)
        {
            String[] studentDetail = currentLine.split(" ");
            String rollNo =studentDetail[0];
             
            String FullName = studentDetail[1];
             
            Double Percentage = Double.valueOf(studentDetail[2]);
         
            int PhoneNumber= Integer.parseInt(studentDetail[3]);
            
            //Creating Student object for every student record and adding it to ArrayList
             
            studentRecords.add(new StudentDetails(rollNo, FullName, Percentage, PhoneNumber));
            StudentDetails stu=new StudentDetails(rollNo, FullName, Percentage, PhoneNumber);
 // add missing Students       
            StudentDetails stu1= new StudentDetails("2017BCO105", "***", 0.0,0);
            
            currentLine = reader.readLine();
        }
        /*List<Student> studentList = new ArrayList<Student>();
        studentList.add(new StudentDetails(2017BCO101, "SNRao", 60.5,9876543210));
        studentList.add(new StudentDetails("2017BCO104", "Jyostna", 70.5, 9807654312));
        studentList.add(new StudentDetails("2017BCO102", "Jyostna", 70.5, 9807654312));
        studentList.add(new StudentDetails("2017BCO106", "Jyostna", 70.5, 9807654312));
        studentList.add(new StudentDetails("2017BCO103", "Jyostna", 70.5, 9807654312));
        
         */
        //Sorting ArrayList studentRecords based on rollnumber in ascending order
         
        Collections.sort(studentRecords, new RollNumberCompare());
        
        
         
        //Creating BufferedWriter object to write into output text file
         
        BufferedWriter writer = new BufferedWriter(new FileWriter("C://users/admin/desktop/Studentoutput.txt"));
       /* FileOutputStream fos=new FileOutputStream("c://users/admin/desktop/fos.txt");
        ObjectOutputStream oos = new ObjectOutputStream(writer);
		 //oos.writeObject(St);
		 Student std1 = new Student(35, "SNRao", 60.5, "Ameerpet, Hyderabad");
		    Student std2 = new Student(45, "Jyostna", 70.5, "Paradise circle, Secunderabad");
		    Student std3 = new Student(55, "Srinivas", 80.5, "Punjagutta, Hyderabad");

		    oos.writeObject(std1);
		    oos.writeObject(std2);
		    oos.writeObject(std3);
				                         // writing anonymous Student object 
		    oos.writeObject(new Student(65, "Jyothi", 90.5, "Kookatpally, Hyderabad"));

		    fos.close();
*/
        //Writing every studentRecords into output text file
         
        for (StudentDetails student : studentRecords) 
        {
            writer.write(student.rollNo);
             System.out.println(student.rollNo);
            writer.write(" "+student.fullName);
            System.out.println(student.fullName);
            writer.write(" "+student.percentage);
            System.out.println(student.percentage);
            writer.write(" "+student.phoneNumber);
            System.out.println(student.phoneNumber);
            
            writer.newLine();
        }
        
        Comparator comparator = Collections.reverseOrder();
        
        
      //Sorting ArrayList studentRecords based on rollnumber in descending order
        
        Collections.sort(studentRecords, new RollNumberCompare());
        
        
         
        //Creating BufferedWriter object to write into output text file
         
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("C://users/admin/desktop/Studentoutput.txt"));
         
        //Writing every studentRecords into output text file
         
        for (StudentDetails student : studentRecords) 
        {
            writer1.write(student.rollNo);
             System.out.println(student.rollNo);
            writer1.write(" "+student.fullName);
            System.out.println(student.fullName);
            writer1.write(" "+student.percentage);
            System.out.println(student.percentage);
            writer1.write(" "+student.phoneNumber);
            System.out.println(student.phoneNumber);
            
            writer1.newLine();
        }
        
        
        //Closing the resources
         
        reader.close();
        writer.close(); 
        writer1.close();
    

	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
